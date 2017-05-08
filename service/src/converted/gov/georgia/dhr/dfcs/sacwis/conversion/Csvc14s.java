package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
/**************************************************************************
**
** Module File:   CSVC14S.src
**
** Service Name:  CSVC14S
**
** Description:   Saves Service Delivery Closure fields
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2/14/95
**
** Programmer:    Wendy Purtle,
**                Mark Dunnagan, final code review changes.
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   12 Aug 1996 17:11:20  $
**                      $Modtime:   12 Aug 1996 16:23:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  08/29/95  GLOORJW   PWO #1264 Removed CINV20SOG00 from Output record
**
**  09/26/95  SOOLEAYG  SIR #1512 - Switch after cinv43d DAM was always
**   hitting PROCESS_TUX_RC_ERROR on save.
**
**  11/13/95  YANTISTK SIR #1710: Added CheckStageEventStatus common function.
**
**  02/20/96  LASKEYRM SIR #5050: CheckStageEventStatus() was screwing
**                     up the code that checked for NEW Events. A simple
**                     change to the input cReqFuncCd fixed the problem. See
**                     CheckStateEventStatus() documentation for details
**                     about the MSG_SYS_MULT_INST funtionality.
**
**  8/12/96   vanderm   SIR #21968 - database should be restored for
**                      database updates (AUD's) which encounter a problem.
**                      Error handling was corrected by changing
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver mode" allowing supervisors to ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  07/07/2003  Srini   SIR 18504-  Fixed the unmarshalling code which was
**                      overwriting the timestamp fields from one to another.
**
**  07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**                      before the InvalidateAprvl call.
**
**  07/12/05   dunawakl SIR 23664 Added Variables for new Service Delivery Closure fields
**  09/08/05  yeehp     SIR 23771 : Added variable for service delivery closure fields
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csvc14s {
    CSVC14SO CSVC14S(CSVC14SI csvc14si) {
        CSVC14SO csvc14so = new CSVC14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/*SIR#1710*/
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        Pint tempulIdEvent = new Pint();
        int tempulIdStage = 0;
        rc = ARC_PRFServiceStartTime_TUX(csvc14si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check buffer size
        */
        
        /*
        ** Process error message and return to client
        */
        
        /*
        ** Initialize output message and length
        */
        
        /*
        ** Initialize service status fields
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
        
        /*
        ** Increment the "number of events passed" counter.
        */
        pCCMN06UInputRec.setArchInputStruct(csvc14si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN06UInputRec.setUlIdStage(csvc14si.getROWCCMN01UIG00().getUlIdStage());
        
        /*
        ** Increment warning counter.
        */
        pCCMN06UInputRec.setSzCdTask(csvc14si.getROWCCMN01UIG00().getSzCdTask());
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
                
                //  Increment warning counter.
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        if (SUCCESS == RetVal) {
            if ((false == csvc14si.getArchInputStruct().getUlSysNbrReserved1()) && (0 == csvc14si.getSzCdEventStatus().compareTo(SVC_CD_EVENT_STATUS_PENDING))) {
                //  Allocate memory for Input and Output Structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                
                //  Increment counter by 1
                pInvdInput.setArchInputStruct(csvc14si.getArchInputStruct());
                
                //  Increment counter by 1
                pInvdInput.setUlIdEvent(csvc14si.getROWCCMN01UIG00().getUlIdEvent());
                rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                csvc14si.getROWCCMN01UIG00().setSzCdEventStatus(SVC_CD_EVENT_STATUS_COMPLETE);
            }
            
            //  Populate Output Message
            
            if (0 == csvc14si.getROWCCMN01UIG00().getUlIdEvent()) {
                rc = CallCSVC36D(csvc14si, csvc14so, pServiceStatus);
                switch (rc) {
                    case Messages.MSG_NO_ROWS_RETURNED:
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            tempulIdEvent.value = csvc14si.getUlIdEvent();
            
            //  Call DAM
            rc = Ccmn25s.CallPostEvent(csvc14si.getArchInputStruct() , csvc14si.getROWCCMN01UIG00() , tempulIdEvent, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            csvc14so.setUlIdEvent(csvc14si.getUlIdEvent());
            rc = Cinv16s.CallCSVC18D(csvc14si, csvc14so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    
                case Messages.MSG_CMN_UPDATE_FAILED:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (0 == csvc14si.getSzCdStage().compareTo(SVC_CD_STAGE_APS_SVC)) {
                rc = CallCSVC22D(csvc14si, csvc14so, pServiceStatus);
                switch (rc) {
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            rc = Cinv12s.CallCINV43D(csvc14si, csvc14so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case Messages.MSG_NO_ROWS_RETURNED:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                case Messages.MSG_CMN_UPDATE_FAILED:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(csvc14si.getArchInputStruct() , csvc14so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            //  Call DAM
            rc = SUCCESS;
        }
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
        return csvc14so;
    }

    static int CallCSVC18D(CSVC14SI pInputMsg844, CSVC14SO * pOutputMsg789, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i438 = 0;
        
        /*
        ** Declare local variables
        */
        CSVC18DI pCSVC18DInputRec = null;
        CSVC18DO pCSVC18DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC18DInputRec = new CSVC18DI();
        pCSVC18DOutputRec = new CSVC18DO();
        pCSVC18DInputRec.setUlIdStage(pInputMsg844.getROWCINV21SIG02().getUlIdStage());
        pCSVC18DInputRec.setTmSysTmStageClose(pInputMsg844.getROWCINV21SIG02().getTmSysTmStageClose());
        pCSVC18DInputRec.setTmSysTmStageStart(pInputMsg844.getROWCINV21SIG02().getTmSysTmStageStart());
        pCSVC18DInputRec.setUlIdUnit(pInputMsg844.getROWCINV21SIG02().getUlIdUnit());
        pCSVC18DInputRec.setBIndStageClose(pInputMsg844.getROWCINV21SIG02().getBIndStageClose());
        pCSVC18DInputRec.setSzNmStage(pInputMsg844.getROWCINV21SIG02().getSzNmStage());
        pCSVC18DInputRec.setSzCdStage(pInputMsg844.getROWCINV21SIG02().getSzCdStage());
        pCSVC18DInputRec.setSzCdStageClassification(pInputMsg844.getROWCINV21SIG02().getSzCdStageClassification());
        pCSVC18DInputRec.setSzCdStageCnty(pInputMsg844.getROWCINV21SIG02().getSzCdStageCnty());
        pCSVC18DInputRec.setSzCdStageCurrPriority(pInputMsg844.getROWCINV21SIG02().getSzCdStageCurrPriority());
        
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pCSVC18DInputRec.setSzCdStageInitialPriority(pInputMsg844.getROWCINV21SIG02().getSzCdStageInitialPriority());
        pCSVC18DInputRec.setSzCdStageProgram(pInputMsg844.getROWCINV21SIG02().getSzCdStageProgram());
        pCSVC18DInputRec.setSzCdStageReasonClosed(pInputMsg844.getROWCINV21SIG02().getSzCdStageReasonClosed());
        
        pCSVC18DInputRec.setDtDtStageClose(pInputMsg844.getROWCINV21SIG02().getDtDtStageClose());
        pCSVC18DInputRec.setDtDtStageStart(pInputMsg844.getROWCINV21SIG02().getDtDtStageStart());
        pCSVC18DInputRec.setUlIdCase(pInputMsg844.getROWCINV21SIG02().getUlIdCase());
        pCSVC18DInputRec.setUlIdSituation(pInputMsg844.getROWCINV21SIG02().getUlIdSituation());
        pCSVC18DInputRec.setSzCdClientAdvised(pInputMsg844.getROWCINV21SIG02().getSzCdClientAdvised());
        
        pCSVC18DInputRec.setBIndEcs(pInputMsg844.getROWCINV21SIG02().getBIndEcs());
        pCSVC18DInputRec.setBIndEcsVer(pInputMsg844.getROWCINV21SIG02().getBIndEcsVer());
        pCSVC18DInputRec.setSzTxtStageClosureCmnts(pInputMsg844.getROWCINV21SIG02().getSzTxtStageClosureCmnts());
        
        pCSVC18DInputRec.setSzTxtStagePriorityCmnts(pInputMsg844.getROWCINV21SIG02().getSzTxtStagePriorityCmnts());
        pCSVC18DInputRec.setSzCdStageRegion(pInputMsg844.getROWCINV21SIG02().getSzCdStageRegion());
        pCSVC18DInputRec.setSzCdStageRsnPriorityChgd(pInputMsg844.getROWCINV21SIG02().getSzCdStageRsnPriorityChgd());
        
        pCSVC18DInputRec.setSzCdStageType(pInputMsg844.getROWCINV21SIG02().getSzCdStageType());
        pCSVC18DInputRec.setTsLastUpdate(pInputMsg844.getROWCINV21SIG02().getTsLastUpdate());
        pCSVC18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** This DAM will perform full row retrievals from INVOICE and CAPS
        ** RESOURCE using a dynamic where clause.  Psuedo Code is attached.
        */
        
        /*
        ** Start Performance Timer
        */
        rc = csvc18dAUDdam(sqlca, pCSVC18DInputRec, pCSVC18DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
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
                
                
                //  Call CDYN07D
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                //  SIR 14996 - Added dam CLSC18D to return principals.
                // CSES97D checks to see if the person id passed from clsc18d was
                // a victim in an allegation with a disposition of RTB
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC22D(CSVC14SI pInputMsg845, CSVC14SO * pOutputMsg790, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        int i439 = 0;
        
        /*
        ** Declare local variables
        */
        CSVC22DI pCSVC22DInputRec = null;
        CSVC22DO pCSVC22DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC22DInputRec = new CSVC22DI();
        
        pCSVC22DOutputRec = new CSVC22DO();
        pCSVC22DInputRec.setUlIdStage(pInputMsg845.getROWCINV21SIG02().getUlIdStage());
        pCSVC22DInputRec.setDtDtSvcDelvDecision(pInputMsg845.getDtDtSvcDelvDecision());
        pCSVC22DInputRec.setTsLastUpdate(pInputMsg845.getTsLastUpdate());
        pCSVC22DInputRec.setArchInputStruct(pInputMsg845.getArchInputStruct());
        /* 5/21/2003 MCCLAIM moved inside if statement to avoid rc getting
        unnecesarily overwritten */
        /*
        ** get current date and time and place it in dtCurrentDate
        ** this is a locally declared variable for this purpose only
        */
        rc = csvc22dAUDdam(sqlca, pCSVC22DInputRec, pCSVC22DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
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
                
                
                //  Call CAUD99D
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC36D(CSVC14SI pInputMsg846, CSVC14SO * pOutputMsg791, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSVC36DI pCSVC36DInputRec = null;
        CSVC36DO pCSVC36DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC36DInputRec = new CSVC36DI();
        pCSVC36DOutputRec = new CSVC36DO();
        pCSVC36DInputRec.setUlIdStage(pInputMsg846.getROWCINV21SIG02().getUlIdStage());
        pCSVC36DInputRec.setSzCdEventType(SVC_CD_EVENT_TYPE_CLOSE);
        rc = csvc36dQUERYdam(sqlca, pCSVC36DInputRec, pCSVC36DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg846.getROWCCMN01UIG00().setUlIdEvent(pCSVC36DOutputRec.getUlIdEvent());
                pInputMsg846.setUlIdEvent(pCSVC36DOutputRec.getUlIdEvent());
                pInputMsg846.getROWCCMN01UIG00().setUlIdEvent(pCSVC36DOutputRec.getUlIdEvent());
                pInputMsg846.getROWCCMN01UIG00().setTsLastUpdate(pCSVC36DOutputRec.getTsLastUpdate());
                
                //  Start Performance Timer
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                // 
                // (END): Retrieve DAM: csys06d      DISCHARGE Narrative check 
                // 
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV43D(CSVC14SI pInputMsg847, CSVC14SO * pOutputMsg792, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINV43DInputRec.setUlIdEvent(pInputMsg847.getUlIdEvent());
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                //  Call CAUD17D.  The Contract Service AUD performs a full row
                // insert to the Contract Service table.
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct9, ROWCCMN01UIG00 ROWCCMN01UIG008, Pint ulIdEvent31, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN01UI pInputRec = null;
        CCMN01UO pOutputRec = null;
        FndInt3date CurDate = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pInputRec = new CCMN01UI();
        pOutputRec = new CCMN01UO();
        pInputRec.setArchInputStruct(ArchInputStruct9);
        pInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pInputRec.setROWCCMN01UIG00(ROWCCMN01UIG008);
        
        if (0 != pInputRec.getROWCCMN01UIG00().getUlIdEvent()) {
            pInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = ARC_UTLGetDateAndTime(CurDate, 0);
            
            if (0 != rc) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            pInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(CurDate);
        }
        rc = Ccmn01u.PostEvent(pInputRec, pOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        ulIdEvent31.value = pOutputRec.getUlIdEvent();
        return rc;
    }

}
