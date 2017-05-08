package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN68DO;
/**************************************************************************
**
** Module File:   CINV31S.src
**
** Service Name:  CINV31S
**
** Description:   XXX Add Update Prof Assmt table XXX
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/14/95
**
** Programmer:    ALIAM
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/14/95  HELMKEST  Add CheckStageEventStatus common function to the
**                      service.
**
**  08/13/96  VANDERM   SIR 21968 - Database needs to be restored for all
**                      AUD services which return errors.  Thus the error
**                      handling for all AUD dams was changed from
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  07/17/2003	JEH	Calling InvalidateAprvl common function was not
**			initializing the ArchInputStruct.ulSysNbrReserved1
**			input variable, causing approver logic to fail.
**
**  08/13/2003	JEH	InvalidateAprvl should always take pInputMsg->ulIdEvent
**
**  08/14/2003	JEH	Rolling back some of the changes made on 5/5/03. 
**			MMA events aren't submitted, so shouldn't be set to PEND.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv31s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String TASK_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_NEW = "NEW";
    CINV31SO CINV31S(CINV31SI cinv31si) {
        CINV31SO cinv31so = new CINV31SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        
        /*
        ** Declare local variables
        */
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        ROWCCMN01UIG00 PostEventRec = null;
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/*SIR#1710*/
        CCMN06UO pCCMN06UOutputRec = null;/*SIR#1710*/
        rc = ARC_PRFServiceStartTime_TUX(cinv31si.getArchInputStruct());
        
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
        ** SIR 1710:
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv31si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv31si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv31si.getROWCCMN46DI().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv31si.getROWCCMN46DI().getSzCdTask());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        /*
        ** Analyze error code
        */
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
        if (SUCCESS == RetVal) {
            if (!(cinv31si.getROWCCMN46DI().getUlIdEvent() != 0)) {
                cinv31si.getROWCCMN46DI().setDtDtEventOccurred(cinv31si.getDtProfAssmtAppt());
                cinv31si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                PostEventRec.getROWCCMN01UIG01_ARRAY().setROWCCMN01UIG01(0, cinv31si.getROWCCMN01UIG01());
            }
            else {
                cinv31si.getROWCCMN46DI().setDtDtEventOccurred(cinv31si.getDtProfAssmtAppt());
                cinv31si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                cinv31so.getUlIdEvent().value = cinv31si.getROWCCMN46DI().getUlIdEvent();
            }
            PostEventRec.setUlIdEvent(cinv31si.getROWCCMN46DI().getUlIdEvent());
            PostEventRec.setUlIdStage(cinv31si.getROWCCMN46DI().getUlIdStage());
            PostEventRec.setUlIdPerson(cinv31si.getROWCCMN46DI().getUlIdPerson());
            PostEventRec.setSzCdTask(cinv31si.getROWCCMN46DI().getSzCdTask());
            
            PostEventRec.setSzCdEventType(cinv31si.getROWCCMN46DI().getSzCdEventType());
            PostEventRec.setDtDtEventOccurred(cinv31si.getROWCCMN46DI().getDtDtEventOccurred());
            PostEventRec.setSzTxtEventDescr(cinv31si.getROWCCMN46DI().getSzTxtEventDescr());
            PostEventRec.setSzCdEventStatus(TASK_STATUS_COMPLETE);
            PostEventRec.setTsLastUpdate(cinv31si.getROWCCMN46DI().getTsLastUpdate());
            
            // set CSUB40UIG00.dtSysDtTodoCfDueFrom to today's
            // date and time
            rc = Ccmn25s.CallPostEvent(cinv31si.getArchInputStruct() , PostEventRec, cinv31so.getUlIdEvent() , pServiceStatus);
            switch (rc) {
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            cinv31si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            if (cinv31si.getArchInputStruct().getCReqFuncCd() != 0 && 0 != cinv31si.getROWCCMN01UIG01().getUlIdPerson() &&!(strncmp(cinv31si.getROWCCMN46DI().getSzCdEventStatus() , EVENT_STATUS_NEW, EVENT_STATUS_NEW.length()) != 0)) {
                //  SIR #3633 - Added ARC_UTLAddToDate to subtract 90 days so that
                // the ToDo shows up 90 days before the end date of the Adoption
                // Subsidy.
                rc = Ccmn01u.CallCCMN68D(cinv31si, cinv31so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (false == cinv31si.getArchInputStruct().getUlSysNbrReserved1()) {
                
                if (cinv31si.getUlIdEvent() != 0) {
                    //  Reserve memory for Invalidate Function structures
                    pInvdInput = new CCMN05UI();
                    
                    pInvdOutput = new CCMN05UO();
                    //  SIR 3986 - Todo Spreadsheet was not adding days to sent date
                    // properly so we're now using ARC_UTLAddToDate to add 45 days
                    // to dtSent.  This will be the date that shows on the CaseTodo
                    // window.  Above comment regarding adding 90 days is NOT
                    // CORRECT!!!!
                    
                    rc = Ccmn05u.CallCCMN62D(cinv31si, cinv31so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    pInvdInput.setUlIdEvent(cinv31si.getUlIdEvent());
                    pInvdInput.getArchInputStruct().setUlSysNbrReserved1(cinv31si.getArchInputStruct().getUlSysNbrReserved1());
                    
                    
                    //  Set CSUB40UI DtToDoCfDueFrom to today's date.
                    rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                //  Populate Output Message
                if (cinv31si.getROWCCMN46DI().getUlIdEvent() != 0) {
                    
                    //  SIR #3633 - Added ARC_UTLAddToDate to subtract 90 days so that
                    // the ToDo shows up 90 days before the end date of the Adoption
                    // Subsidy.
                    rc = Cinv12s.CallCINV43D(cinv31si, cinv31so, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            
            //  Call CSUB40U
            rc = CallCINV40D(cinv31si, cinv31so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        /* Exit the service */
        
        
        ARC_PRFServiceStopTime_TUX(cinv31si.getArchInputStruct() , cinv31so.getArchOutputStruct());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        /* 01/22/2003 DWW: Added for error handling */
        if (RetVal == SUCCESS) {
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
        return cinv31so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        
        /*
        ** SIR 13618 - add CallCRES04D to service
        */
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV31SO";
        pOutputMsgTransMap.map_version = "01";
        
        
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct8, ROWCCMN01UIG00 ROWCCMN01UIG007, Pint ulIdEvent27, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;
        CCMN01UI pInputMsg703 = null;
        CCMN01UO pOutputMsg653 = null;
        pInputMsg703 = new CCMN01UI();
        pOutputMsg653 = new CCMN01UO();
        pInputMsg703.setArchInputStruct(ArchInputStruct8);
        pInputMsg703.setROWCCMN01UIG00(ROWCCMN01UIG007);
        pOutputMsg653.setUlIdEvent(ulIdEvent27.value);
        rc = Ccmn01u.PostEvent(pInputMsg703, pOutputMsg653, pServiceStatus);
        
        if (ulIdEvent27.value == null) {
            ulIdEvent27.value = pOutputMsg653.getUlIdEvent();
        }
        return rc;
    }

    static int CallCCMN62D(CINV31SI pInputMsg704, CINV31SO * pOutputMsg654, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
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
        pCCMN62DInputRec.setUlIdEvent(pInputMsg704.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(TASK_STATUS_COMPLETE);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call CSYS06D
        */
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV40D(CINV31SI pInputMsg705, CINV31SO pOutputMsg655, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV40DI pCINV40DInputRec = null;
        CINV40DO pCINV40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV40DInputRec = new CINV40DI();
        
        pCINV40DOutputRec = new CINV40DO();
        if (pInputMsg705.getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
            pCINV40DInputRec.setUlIdEvent(pOutputMsg655.getUlIdEvent().value);
        }
        else {
            pCINV40DInputRec.setUlIdEvent(pInputMsg705.getROWCCMN46DI().getUlIdEvent());
        }
        pCINV40DInputRec.setUlIdPersonPrincipal(pInputMsg705.getUlIdPersonPrincipal());
        pCINV40DInputRec.setUlIdPersonProfessional(pInputMsg705.getUlIdPersonProfessional());
        pCINV40DInputRec.setDtProfAssmtAppt(pInputMsg705.getDtProfAssmtAppt());
        pCINV40DInputRec.setSzNmProfAssmtName(pInputMsg705.getSzNmProfAssmtName());
        pCINV40DInputRec.setSzNmProfAssmtPrincipal(pInputMsg705.getSzNmProfAssmtPrincipal());
        pCINV40DInputRec.setSzTxtProfAssmtOther(pInputMsg705.getSzTxtProfAssmtOther());
        pCINV40DInputRec.setCdProfAssmtApptRsn(pInputMsg705.getCdProfAssmtApptRsn());
        pCINV40DInputRec.setTsLastUpdate(pInputMsg705.getTsLastUpdate());
        pCINV40DInputRec.setSzTxtProfAssmtFindings(pInputMsg705.getSzTxtProfAssmtFindings());
        pCINV40DInputRec.setSzAddrProfAssmtCity(pInputMsg705.getSzAddrProfAssmtCity());
        pCINV40DInputRec.setSzAddrProfAssmtStLn1(pInputMsg705.getSzAddrProfAssmtStLn1());
        pCINV40DInputRec.setSzAddrProfAssmtStLn2(pInputMsg705.getSzAddrProfAssmtStLn2());
        pCINV40DInputRec.setSzAddrProfAssmtZip(pInputMsg705.getSzAddrProfAssmtZip());
        pCINV40DInputRec.setSzCdProfAssmtCounty(pInputMsg705.getSzCdProfAssmtCounty());
        pCINV40DInputRec.setSzAddrProfAssmtState(pInputMsg705.getSzAddrProfAssmtState());
        pCINV40DInputRec.setLNbrProfAssmtPhone(pInputMsg705.getLNbrPhone());
        pCINV40DInputRec.setLNbrPhoneExtension(pInputMsg705.getLNbrPhoneExtension());
        pCINV40DInputRec.setSzTxtProfAssmtCmnts(pInputMsg705.getSzTxtProfAssmtCmnts());
        pCINV40DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg705.getSzCdScrDataAction());
        pInputMsg705.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        if (pInputMsg705.getArchInputStruct().getCReqFuncCd() != 0 && 0 != pInputMsg705.getROWCCMN01UIG01().getUlIdPerson() &&!(strncmp(pInputMsg705.getROWCCMN46DI().getSzCdEventStatus() , EVENT_STATUS_NEW, EVENT_STATUS_NEW.length()) != 0)) {
            pCINV40DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        rc = cinv40dAUDdam(sqlca, pCINV40DInputRec, pCINV40DOutputRec);
        
        switch (rc) {
                
            case SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV43D(CINV31SI pInputMsg706, CINV31SO * pOutputMsg656, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
        pCINV43DInputRec.setUlIdEvent(pInputMsg706.getROWCCMN46DI().getUlIdEvent());
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  Get the current date and store it in dtCurrDate
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN68D(CINV31SI pInputMsg707, CINV31SO * pOutputMsg657, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN68DI pCCMN68DInputRec = null;
        CCMN68DO pCCMN68DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN68DInputRec = new CCMN68DI();
        
        pCCMN68DOutputRec = new CCMN68DO();
        pCCMN68DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        
        pCCMN68DInputRec.setUlIdEvent(pInputMsg707.getROWCCMN46DI().getUlIdEvent());
        pCCMN68DInputRec.setUlIdPerson(pInputMsg707.getROWCCMN01UIG01().getUlIdPerson());
        rc = ccmn68dAUDdam(sqlca, pCCMN68DInputRec, pCCMN68DOutputRec);
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        return rc;
    }

}
