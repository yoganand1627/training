package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN99DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN99DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
/**************************************************************************
**
** Module File:   ccmn25s.src
**
** Service Name:  ccmn25s
**
** Description:   This service will perform the save processing for the
**                Assign Window
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  20 Jan 95
**
** Original Programmer:   Bart McCleskey/Andersen Consulting
**
** Current  Programmer:   Mary Sladewski
**
** Archive Information: $Revision:   1.8  $
**                      $Date:   19 Apr 1999 09:31:58  $
**                      $Modtime:   24 Mar 1999 13:47:46  $
**                      $Author:   pvcs  $
**
**  Change History:
**  Date        User      Description
**  ----------  --------  --------------------------------------------------
**  05/01/1995  sladewmf  Implemented new error handling changes as outlined
**                        in the Apr20 17:12 1995 version of svcshell.src
**
**  05/05/1995  sladewmf  Implemented new error handling changes as outlined
**                        in the May05 08:23 1995 version of svcshell.src
**
**  05/15/1995  sladewmf  Added comments and aligned code.
**
**  05/17/1995  sladewmf  Added functions for two new dams:
**                        CallCCMNG0D and CallCCMNG1D.
**
**  05/31/1995  sladewmf  Made tech review changes.
**
**  06/15/1995  sladewmf  Changed the order of the for loop.
**
**  07/18/1995  DMV       Fixed code for creating TODO's when a block is
**                        assigned.
**
**  07/29/1995  sladewmf  SIR 997: Changed the order of the for loop back
**                        to it's original form; added a case statement in the
**                        switch following the 'rc=CallCCMN80D' line; and added
**                        a case and an if statement in the CallCCMN80D function.
**
**  08/18/1995  sladewmf  SIR 235: Added if statement to CallCCMNG0D function.
**
**  08/18/1995  sladewmf  SIR 826: Changed Stage Progression processing.
**
**  12/15/1995  mcraebs   SIR 2327: Changes Stage Progression call - set
**                        ulPageNbr to 1.
**
**  01/15/1996  KRD       SIR 2408 - During a Save & Assign from Intake, an
**                        event should be posted to indicate the primary
**                        assignment regardless of whether or not the Save &
**                        Assign is to the user or to another employee.  This
**                        was only happening for two cases - 1) AssignSaveGroup
**                        rows with a szCdScrDataAction of UPDATE for non-Stage
**                        Progressed stages and 2) Stage Progressed stages that
**                        pass an IdPerson in the AssignSaveGroup.
**
**                        In addition, some unneccessary macros were removed.
**  01/20/1996  GUARRICR  SIR 2810: Added CheckStageEventStatus common function
**                        to the service to ensure that none of the stages
**                        being assigned are closed.
**
**  06/19/1996  KRD       SIR 10085 - For some unknown reason, when the input
**                        message is passed from the client to the service, the
**                        message will contain pieces of data from prior calls
**                        to the service.  For example, suppose the service is
**                        first called with 5 rows of data.  Then the service
**                        is called with 2 rows of data.  The input message
**                        will look correct on the client side, but the service
**                        thinks it is getting 5 rows of data - 2 from the
**                        current run and the last 3 from the prior run.  This
**                        would cause random data access and SQL_NOT_FOUND
**                        errors.  To correct this problem, the window has
**                        been modified to pass an exact count of the rows to
**                        be processed and this service has been modified to
**                        use that count in the for loops.
**
**  07/11/1996  KRD       SIR 10261 - rewrote service (major overhaul of the
**                        service main function) to use a character code
**                        passed from the window in
**                        pInputMsg->ArchInputStruct.cReqFuncCd instead of
**                        TRUE/FALSE.  Modified all code which compared the
**                        data actions of the rows due to REQ_FUNC_CD_UPDATE
**                        not being taken into account for secondary
**                        assignments.  Also added CdStagePersRole to the
**                        input message for use in CallCCMN80D().
**
**  07/31/1996  KRD       printf() statements added to help determine state of
**                        stage since APS Intakes are still not progressing
**                        to Investigation.
**
**  08/31/1996  KRD       Changed the subdirectory to which the tracer file is
**                        written.
**
**  11/04/1996  saravigm  SIR 22133:Fixing the problem of Assign window not
**                        handling Save&Assign of Intake by secondary worker
**                        who is unassigned as secondary.
**
**  12/18/1996  KRD       The printf() statements are necessary for debugging,
**                        but the error has not occurred recently.  The code
**                        has been modified so that they can be turned on and
**                        off more readily by the use of a DEBUG flag.  At this
**                        time the DEBUG flag will be set to FALSE.
**
**  01/23/2003  DWW       Added following line for error handling:
**                        if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  06/20/2005  wadesa    SIR 23695 - Added functionality to progress APS stages to
**                        either a INV or directly to SVC.  This is determined by
**                        the new szCdStageReasonClosed passed in from the
**                        AssignConversation.
**
**  08/04/2005  wadesa    SIR 23802 - Defect fix for auto prgressing with push button
**                        Assign from workload page.
**
**  08/11/2005  Nallavs   SIR 22556 - Removed unnecessary comments.
***************************************************************************/
/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn25s {
    
    /**************************************************************************
    ** Constants
    ***************************************************************************/
    /* used in CallCCMN43D */
    public static final char SUPERVISOR = 'V';
    
    /* used in CCMN25S */
    public static final String COMPLETE = "COMP";
    public static final String ASSIGNMENT = "ASG";
    
    /* used in CallCCMN80D */
    public static final String STAFF = "STF";
    public static final String SECONDARY_WORKER = "SE";
    
    /* used in CallProgress */
    public static final String INTAKE = "INT";
    public static final String INVESTIGATION = "INV";
    public static final String SERVICE_DELIVERY = "SVC";
    public static final String REASON_CODE_01 = "01";
    public static final String REASON_CODE_02 = "02";
    public static final String NULL_STRING = "";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int INITIAL_PAGE = 1;
    
    /*
    ** SIR 10261 - macros needed for service processing
    */
    public static final char UNDETERMINED = 'A';
    
    /* SIR 14844 */
    /* #define INTAKE_APS_LIC  'B'*/
    
    public static final char INTAKE_APS = 'B';
    public static final char INTAKE_NON_APS = 'C';
    public static final char INTAKE_NON_INT = 'D';
    public static final char INTAKE_FULL_SVC = 'E';
    public static final char NON_INT_FUL_SVC = 'F';
    public static final char NON_INT_FAD = 'G';
    
    /*
    ** START SIR 23695 - Parmater for "CRSR"
    */
    public static final String NON_CRSR = "REG";
    public static final String CRSR = "C-REG";
    CCMN25SO CCMN25S(CCMN25SI ccmn25si) {
        CCMN25SO ccmn25so = new CCMN25SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int I = 0;
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* SIR#1710 CheckStageEventStatus common function */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#1710 */
        
        /*
        ** Call the function to append "et al" to the victim's
        ** name.
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn25si.getArchInputStruct());
        
        /**************************************************************************
        ** SIR 2810:
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        ** Run for each ulIdStage in AssignSaveGroup. Break if error occurs.
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        
        /*
        ** SIR 10085 - the following for loop has been modified to use the
        ** count of rows passed from the window.  The original for-statement was:
        **      for (I=0; pInputMsg->AssignSaveGroup[I].ulIdStage > 0; I++)
        */
        for (I = 0;I < ccmn25si.getArchInputStruct().getUlPageSizeNbr();I++) {
            pCCMN06UInputRec.setArchInputStruct(ccmn25si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            
            pCCMN06UInputRec.setUlIdStage(ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(NULL_STRING);
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            //  Analyze return code
            switch (rc) {
                    
                    //  SIR 21003 - Changed error processing of cses80d
                    // to allow sql-not-found because that is an
                    // acceptible condition.  It should not "blow-up"
                    // at this point.
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
            if (SUCCESS != RetVal) {
                break;
            }
        }
        if (SUCCESS == RetVal) {
            //  Analyze return code
            switch (ccmn25si.getArchInputStruct().getCReqFuncCd()) {
                case INTAKE_NON_APS:
                    
                case INTAKE_NON_INT:
                    
                case NON_INT_FAD:
                    rc = Cint21s.CallPostEvent(ccmn25si, ccmn25so, 0, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                case NON_INT_FUL_SVC:
                case INTAKE_FULL_SVC:
                    //  Perform "full service functionality" (i.e, update
                    // the stage_person_link table, send ToDos, etc.)
                    for (I = 0;I < ccmn25si.getArchInputStruct().getUlPageSizeNbr();I++) {
                        ccmn25si.getArchInputStruct().setCReqFuncCd(null);
                        rc = CallCCMN80D(ccmn25si, ccmn25so, I, pServiceStatus);
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.ARC_SUCCESS:
                                break;
                            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                
                            case Messages.MSG_CMN_DUP_SP_LINK:
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                        }
                        //  Analyze return code
                        switch (ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzCdScrDataAction()) {
                            case WtcHelperConstants.REQ_FUNC_CD_ADD:
                                rc = Ccmn19s.CallCCMN43D(ccmn25si, ccmn25so, I, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                            case WtcHelperConstants.REQ_FUNC_CD_DELETE:
                                rc = CallCCMN99D(ccmn25si, ccmn25so, I, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                            case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                                if (0 == ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzCdStagePersRole().compareTo(PRIMARY_ROLE_STAGE_OPEN)) {
                                    
                                    //  Call CINT21D
                                    rc = Cint21s.CallPostEvent(ccmn25si, ccmn25so, I, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    //  Set rc to ARC_SUCCESS
                                    rc = Ccmn19s.CallCCMN43D(ccmn25si, ccmn25so, I, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    rc = CallCCMN99D(ccmn25si, ccmn25so, I, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    rc = CallCCMNA1D(ccmn25si, ccmn25so, I, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    if (ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlSysIdPriorPerson() != ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson()) {
                                        ccmn25si.getArchInputStruct().setCReqFuncCd(SUPERVISOR);
                                        
                                        //  Call CCMN82D
                                        rc = Ccmn19s.CallCCMN43D(ccmn25si, ccmn25so, I, pServiceStatus);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    }
                                    //  Set rc to ARC_SUCCESS
                                    rc = CallCCMN81D(ccmn25si, ccmn25so, I, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    rc = CallCCMNG0D(ccmn25si, ccmn25so, I, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    rc = CallCCMNB7D(ccmn25si, ccmn25so, I, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    //  SIR 22577 -- If the explain code is not sucess, return the
                                    // explain code as the rc to the conversation
                                    if (0 != ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdCase()) {
                                        
                                        //  Call CLSC71D
                                        rc = CallCCMNG1D(ccmn25si, ccmn25so, I, pServiceStatus);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    }
                                }
                                
                                break;
                                
                            default :
                                
                                break;
                        }
                    }
                    break;
                case INTAKE_APS:
                    //  Set rc to ARC_SUCCESS
                    rc = CallProgress(ccmn25si, ccmn25so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    //  Set rc to ARC_SUCCESS
                    rc = Cint21s.CallPostEvent(ccmn25si, ccmn25so, 0, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    //  SIR 22133:Fixing the problem of Assign window not
                    // handling Save&Assign of Intake by secondary worker
                    // who is unassigned as secondary. adding a FOR statement.
                    // 
                    for (I = 0;I < ccmn25si.getArchInputStruct().getUlPageSizeNbr();I++) {
                        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzCdScrDataAction()) {
                            ccmn25si.getArchInputStruct().setCReqFuncCd(null);
                            rc = Ccmn19s.CallCCMN43D(ccmn25si, ccmn25so, I, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            //  Declare FOUNDATION variables
                            
                            //  Declare local variables
                            
                            //  Start performance timer for service
                            rc = CallCCMNA1D(ccmn25si, ccmn25so, I, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            if (ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlSysIdPriorPerson() != ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson()) {
                                ccmn25si.getArchInputStruct().setCReqFuncCd(SUPERVISOR);
                                
                                // SIR 21891 - missing versioning
                                //  Run-time Versioning
                                
                                //  Check buffer size
                                
                                //  Process error message and return to client
                                
                                //  Initialize output message and length
                                
                                //  Initialize service status fields
                                
                                // 
                                // Call DAMs to retrieve data
                                // 
                                
                                //  Retrieve the Conclusion Event ID for the stage
                                rc = Ccmn19s.CallCCMN43D(ccmn25si, ccmn25so, I, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            rc = CallCCMN81D(ccmn25si, ccmn25so, I, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            rc = CallCCMNG0D(ccmn25si, ccmn25so, I, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            rc = CallCCMNB7D(ccmn25si, ccmn25so, I, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            if (0 != ccmn25si.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).getUlIdCase()) {
                                rc = CallCCMNG1D(ccmn25si, ccmn25so, I, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                        }
                    }
                    break;
                    
                    
                case UNDETERMINED:
                    
                default :
                    
                    //  Call DAM
                    rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
        }
        
        
        ARC_PRFServiceStopTime_TUX(ccmn25si.getArchInputStruct() , ccmn25so.getArchOutputStruct());
        /*
        ** Populate Output Message if event list requested
        */
        if (RetVal == SUCCESS) {
            
            
            rc = SUCCESS;
        }
        /*
        ** If event status is anything but "COMP".
        **
        ** ERR#1588 No warning to be set if event is Contact
        **      and NEW or if event is Outcome Matrix and NEW
        **      or PROC.
        ** ERR#1674 No warning to be set if Update Priority
        **      event or Med/Mental Assessment event is NEW.
        ** SIR#1887 No warning to be set if the event type is
        **      Legal Action or Guardianship, because these are
        **      optional events and do not have to be closed.
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn25so;
    }

    static int CallCCMNA1D(CCMN25SI pInputMsg264, CCMN25SO * pOutputMsg247, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* declare local variables */
        CCMNA1DI pCCMNA1DInputRec = null;
        CCMNA1DO pCCMNA1DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMNA1DInputRec = new CCMNA1DI();
        
        pCCMNA1DOutputRec = new CCMNA1DO();
        pCCMNA1DInputRec.setArchInputStruct(pInputMsg264.getArchInputStruct());
        pCCMNA1DInputRec.setUlIdUnit(pInputMsg264.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdUnit());
        rc = ccmna1dQUERYdam(sqlca, pCCMNA1DInputRec, pCCMNA1DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg264.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).setUlSysIdPriorPerson(pCCMNA1DOutputRec.getUlIdPerson());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN80D(CCMN25SI pInputMsg265, CCMN25SO * pOutputMsg248, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* declare local variables */
        CCMN80DI pCCMN80DInputRec = null;
        CCMN80DO pCCMN80DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN80DInputRec = new CCMN80DI();
        
        pCCMN80DOutputRec = new CCMN80DO();
        pCCMN80DInputRec.setArchInputStruct(pInputMsg265.getArchInputStruct());
        
        pCCMN80DInputRec.setSzCdStagePersType(STAFF);
        pCCMN80DInputRec.setSzCdStagePersSearchInd('0');
        pCCMN80DInputRec.setSzTxtStagePersNotes(NULL_STRING);
        ARC_UTLGetDateAndTime(pCCMN80DInputRec.getDtDtStagePersLink() , 0);
        
        pCCMN80DInputRec.setSzCdStagePersRelInt(NULL_STRING);
        pCCMN80DInputRec.setBIndStagePersReporter('0');
        pCCMN80DInputRec.setBIndStagePersInLaw('0');
        
        pCCMN80DInputRec.setBIndStagePersEmpNew('1');
        pCCMN80DInputRec.setTsLastUpdate(pInputMsg265.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getTsLastUpdate());
        pCCMN80DInputRec.setUlIdStage(pInputMsg265.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdStage());
        
        pCCMN80DInputRec.setUlIdPerson(pInputMsg265.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
        pCCMN80DInputRec.setUlIdStagePerson(pInputMsg265.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdStagePerson());
        pCCMN80DInputRec.setSzCdStagePersRole(pInputMsg265.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzCdStagePersRole());
        
        pCCMN80DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg265.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzCdScrDataAction());
        
        
        rc = ccmn80dAUDdam(sqlca, pCCMN80DInputRec, pCCMN80DOutputRec);
        
        /* Analyze return code */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                //  If the Corrective Action = "Other", and the Non-Compliances
                // multi-line entry field is not NULL
                // SIR 23458 - If statement below had been accidentally commented out - reinstated the end of comment (line 960).
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == pCCMN80DInputRec.getArchInputStruct().getCReqFuncCd()) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_DUP_SP_LINK;
                    rc = Messages.MSG_CMN_DUP_SP_LINK;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                }
                break;// break for CLSS67D
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_DUP_SP_LINK;
                
                rc = Messages.MSG_CMN_DUP_SP_LINK;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMN81D(CCMN25SI pInputMsg266, CCMN25SO * pOutputMsg249, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* declare local variables */
        CCMN81DI pCCMN81DInputRec = null;
        CCMN81DO pCCMN81DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN81DInputRec = new CCMN81DI();
        
        pCCMN81DOutputRec = new CCMN81DO();
        pCCMN81DInputRec.setArchInputStruct(pInputMsg266.getArchInputStruct());
        pCCMN81DInputRec.setUlIdPerson(pInputMsg266.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
        pCCMN81DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn81dAUDdam(sqlca, pCCMN81DInputRec, pCCMN81DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CLSS67D: "SELECT * FROM    CONTRACT WHERE  C.ID_RESOURCE = "
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN99D(CCMN25SI pInputMsg267, CCMN25SO * pOutputMsg250, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* declare local variables */
        CCMN99DI pCCMN99DInputRec = null;
        CCMN99DO pCCMN99DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN99DInputRec = new CCMN99DI();
        
        pCCMN99DOutputRec = new CCMN99DO();
        pCCMN99DInputRec.setArchInputStruct(pInputMsg267.getArchInputStruct());
        
        /* SIR #1058: This has been changed to a switch.
        */
        switch (pInputMsg267.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzCdScrDataAction()) {
            case WtcHelperConstants.REQ_FUNC_CD_DELETE:
                pCCMN99DInputRec.setUlIdPerson(pInputMsg267.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlSysIdPriorPerson());
                pCCMN99DInputRec.setUlSysIdPriorPerson(pInputMsg267.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
                break;
                // Multiple Instances are necessary for the Demographics Window
                
            case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                pCCMN99DInputRec.setUlIdPerson(pInputMsg267.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
                pCCMN99DInputRec.setUlSysIdPriorPerson(pInputMsg267.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlSysIdPriorPerson());
                break;
        }
        pCCMN99DInputRec.setUlIdStage(pInputMsg267.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdStage());
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCCMN99DInputRec.getDtDtTodoCompleted().month = DateHelper.NULL_DATE;
        pCCMN99DInputRec.getDtDtTodoCompleted().day = DateHelper.NULL_DATE;
        pCCMN99DInputRec.getDtDtTodoCompleted().year = DateHelper.NULL_DATE;
        pCCMN99DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn99dAUDdam(sqlca, pCCMN99DInputRec, pCCMN99DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN43D(CCMN25SI pInputMsg268, CCMN25SO * pOutputMsg251, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* declare local variables */
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN43DInputRec = new CCMN43DI();
        
        pCCMN43DOutputRec = new CCMN43DO();
        pCCMN43DInputRec.setArchInputStruct(pInputMsg268.getArchInputStruct());
        pCCMN43DInputRec.setSzCdTodoTask(NULL_STRING);
        pCCMN43DInputRec.setSzCdTodoType("A");
        pCCMN43DInputRec.getDtDtTaskDue().day = DateHelper.NULL_DATE;
        pCCMN43DInputRec.getDtDtTaskDue().month = DateHelper.NULL_DATE;
        pCCMN43DInputRec.getDtDtTaskDue().year = DateHelper.NULL_DATE;
        
        /*
        ** Set CSUB40UI DtTodoCfDueFrom
        ** to SystemDate
        */
        ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCompleted() , 0);
        ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCreated() , 0);
        ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoDue() , 0);
        pCCMN43DInputRec.setUlIdCase(pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdCase());
        pCCMN43DInputRec.setUlIdEvent(0);
        pCCMN43DInputRec.setUlIdStage(pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdStage());
        pCCMN43DInputRec.setTxtTodoLongDesc(NULL_STRING);
        pCCMN43DInputRec.setUlIdTodoPersCreator(pInputMsg268.getUlIdPerson());
        pCCMN43DInputRec.setLdIdTodo(0);
        
        /*
        ** Analyze return code
        */
        switch (pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzCdScrDataAction()) {
            case WtcHelperConstants.REQ_FUNC_CD_ADD:
                pCCMN43DInputRec.setSzTxtTodoDesc("New Secondary Assignment");
                pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
                pCCMN43DInputRec.setUlIdTodoPersWorker(pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlSysIdPriorPerson());
                
                break;
            case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                pCCMN43DInputRec.setUlIdTodoPersWorker(pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
                
                if (SUPERVISOR == pInputMsg268.getArchInputStruct().getCReqFuncCd()) {
                    pCCMN43DInputRec.setSzTxtTodoDesc("New Primary Assignment for: ");
                    pCCMN43DInputRec.getSzTxtTodoDesc() += pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzNmPersonFull();
                    pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlSysIdPriorPerson());
                }
                else {
                    pCCMN43DInputRec.setSzTxtTodoDesc("New Primary Assignment");
                    pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg268.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
                }
                
                break;
        }
        pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CSES41D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMNG0D(CCMN25SI pInputMsg269, CCMN25SO * pOutputMsg252, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /* declare local variables */
        CCMNG0DI pCCMNG0DInputRec = null;
        CCMNG0DO pCCMNG0DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMNG0DInputRec = new CCMNG0DI();
        
        pCCMNG0DOutputRec = new CCMNG0DO();
        pCCMNG0DInputRec.setArchInputStruct(pInputMsg269.getArchInputStruct());
        
        pCCMNG0DInputRec.setUlIdUnit(pInputMsg269.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdUnit());
        rc = ccmng0dQUERYdam(sqlca, pCCMNG0DInputRec, pCCMNG0DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (!(pCCMNG0DOutputRec.getSzCdUnitRegion().compareTo(CAPS_REGION_SWI) != 0)) {
                    pInputMsg269.setSzCdStageRegion(CAPS_UNIT_SWI);
                }
                
                else if (atoi(pCCMNG0DOutputRec.getSzCdUnitRegion()) > CAPS_REGION_MAX) {
                    pInputMsg269.setSzCdStageRegion(CAPS_UNIT_STATE_OFFICE);
                }
                
                else {
                    pInputMsg269.getSzCdStageRegion()[0] = pCCMNG0DOutputRec.getSzCdUnitRegion()[1];
                    pInputMsg269.getSzCdStageRegion()[1] = pCCMNG0DOutputRec.getSzCdUnitRegion()[2];
                }
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMNB7D(CCMN25SI pInputMsg270, CCMN25SO * pOutputMsg253, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* declare local variables */
        CCMNB7DI pCCMNB7DInputRec = null;
        CCMNB7DO pCCMNB7DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMNB7DInputRec = new CCMNB7DI();
        
        pCCMNB7DOutputRec = new CCMNB7DO();
        pCCMNB7DInputRec.setArchInputStruct(pInputMsg270.getArchInputStruct());
        pCCMNB7DInputRec.setUlIdStage(pInputMsg270.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdStage());
        pCCMNB7DInputRec.setUlIdUnit(pInputMsg270.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdUnit());
        pCCMNB7DInputRec.setSzCdStageRegion(pInputMsg270.getSzCdStageRegion());
        pCCMNB7DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** IMPACT BEGIN
        */
        /*
        ** IMPACT END
        */
        
        /* Add/Updates Professional Assmt table */
        rc = ccmnb7dAUDdam(sqlca, pCCMNB7DInputRec, pCCMNB7DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMNG1D(CCMN25SI pInputMsg271, CCMN25SO * pOutputMsg254, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* declare local variables */
        CCMNG1DI pCCMNG1DInputRec = null;
        CCMNG1DO pCCMNG1DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMNG1DInputRec = new CCMNG1DI();
        
        pCCMNG1DOutputRec = new CCMNG1DO();
        pCCMNG1DInputRec.setArchInputStruct(pInputMsg271.getArchInputStruct());
        pCCMNG1DInputRec.setUlIdCase(pInputMsg271.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdCase());
        pCCMNG1DInputRec.setSzCdCaseRegion(pInputMsg271.getSzCdStageRegion());
        pCCMNG1DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = ccmng1dAUDdam(sqlca, pCCMNG1DInputRec, pCCMNG1DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallProgress(CCMN25SI pInputMsg272, CCMN25SO * pOutputMsg255, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMN03UI pCCMN03UInputRec = null;
        CCMN03UO pCCMN03UOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN03UInputRec = new CCMN03UI();
        
        pCCMN03UOutputRec = new CCMN03UO();
        pCCMN03UInputRec.setArchInputStruct(pInputMsg272.getArchInputStruct());
        pCCMN03UInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN03UInputRec.setUlIdStage(pInputMsg272.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).getUlIdStage());
        pCCMN03UInputRec.setSzCdStage(INTAKE);
        pCCMN03UInputRec.setSzCdStageProgram(pInputMsg272.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).getSzCdStageProgram());
        if (0 == pInputMsg272.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).getSzCdStageType().compareTo(CRSR)) {
            
            pCCMN03UInputRec.setSzCdStageOpen(SERVICE_DELIVERY);
            pCCMN03UInputRec.setSzCdStageReasonClosed(REASON_CODE_02);
        }
        else {
            pCCMN03UInputRec.setSzCdStageOpen(INVESTIGATION);
            pCCMN03UInputRec.setSzCdStageReasonClosed(REASON_CODE_01);
        }
        if (pInputMsg272.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).getUlIdPerson() > 0) {
            pCCMN03UInputRec.setUlIdPerson(pInputMsg272.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).getUlIdPerson());
        }
        
        rc = Ccmn03u.CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
        switch (rc) {
            case SUCCESS:// caud28d
                
                //  Call DAM
                pInputMsg272.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).setUlIdStage(pCCMN03UOutputRec.getUlIdStage());
                pInputMsg272.getAssignSaveGroup_ARRAY().getAssignSaveGroup(0).setTsLastUpdate(pCCMN03UOutputRec.getTsLastUpdate());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        return rc;
    }

    static int CallPostEvent(CCMN25SI pInputMsg273, CCMN25SO * pOutputMsg256, int I, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN01UInputRec = new CCMN01UI();
        
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(pInputMsg273.getArchInputStruct());
        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(COMPLETE);
        
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(ASSIGNMENT);
        ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
        
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pInputMsg273.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdStage());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg273.getUlIdPerson());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr("Primary Assignment Issued For: ");
        pCCMN01UInputRec.getROWCCMN01UIG00().getSzTxtEventDescr() += pInputMsg273.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getSzNmPersonFull();
        pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(pInputMsg273.getAssignSaveGroup_ARRAY().getAssignSaveGroup(I).getUlIdPerson());
        pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        return rc;
    }

}
