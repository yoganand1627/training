package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC71DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC18DO;
/**************************************************************************
**
** Module File:   CINV21S.src
**
** Service Name:  CINV21S - APS INV CONCL AUD
**
** Description:   This service updates information modified on the APS
**                Investigation Conclusion window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/27/95
**
** Programmer:    CRG
**
** Change History:
** Date      User      Description
** --------  --------  --------------------------------------------------
** 11/13/95  HELMKEST  SIR 1710: Included CheckStageEventStatus common
**                      function. (CCMN06U)
** 01/18/96  MUSEBL    R1R2 Impact #29: Admin Review
**                     Bypass CheckStageEventStatus and all event logic.
**
** 04/26/96  ODONNERJ  SIR#2860 : Change Impact #29. Add Dam cSEC71d. Use
**                     an if/else to pass in the id_stage of the ARI/ARF stage
**                     if needed.
**
** 7/8/96    DYARGR    SIR 21752 - Change timer to correct dam name.
**
** 08/13/96  vanderm   SIR #21968 - Databse should be restored for all
**                     AUD services which return an error.  Error handling
**                     was changed from FND_SEVERITY_WARNING to
**                     FND_SEVERITY_ERROR.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver mode" allowing supervisors to ability to
**                      modify data without invalidating the pending
**                      approval.
**
** 06/23/03   Srini    SIR 18449 - Added goto and END statements for intermediate
**					   exits from the service.
**
**	07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**						before the InvalidateAprvl call.
**
**  08/01/03   Srini    SIR 17827 - IMPACT: Make the service transactionaware.
**
** 06/20/05   Nallavs  SIR 23663 -Added 11 new fields of stage closure checklist and LEP/Sensory
**                     Impairment Expandable section fiels from the
**                     Face to Face Narrative onto the Investigation Conclusion.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv21s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_PROGRESS = "PROC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /* Event Statuses */
    public static final String EVENT_STATUS_PENDING = "PEND";
    
    
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int NULL_DATE = - 1;
    public static final String NULL_STRING = "";
    
    /* R1R2 Impact #29: Admin Review */
    public static final String ADMIN_REVIEW_INV = "ARI";
    public static final String ADMIN_REVIEW_FAD = "ARF";
    static int transactionflag = - 1;
    CINV21SO CINV21S(CINV21SI cinv21si) {
        boolean goto_END = false;
        CINV21SO cinv21so = new CINV21SO();
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
            userlog("ERROR: tpgetlev failed in CINV21S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV21S\n");
        }
        /*
        ** Set Event Status to "In Progress" if all required window fields
        ** not filled
        */
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV21S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        ROWCCMN01UIG00 PostEventRec = null;
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        Pint ulOutputEvent = new Pint();
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        
        /* SIR 2860 : Add the call to the Retrieve Open Admin Review Stage Dam */
        CSEC71DI pCSEC71DInputRec = null;
        CSEC71DO pCSEC71DOutputRec = null;
        
        /* Call DAM to save modifications to the Stage table */
        rc = ARC_PRFServiceStartTime_TUX(cinv21si.getArchInputStruct());
        
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
        ** SIR 2860:
        ** (BEGIN): cSEC71d Add the call to the Retrieve Open Admin Review Stage Dam
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCSEC71DInputRec = new CSEC71DI();
        
        pCSEC71DOutputRec = new CSEC71DO();
        
        if ((0 == cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_INV)) || (0 == cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD))) {
            pCSEC71DInputRec.setArchInputStruct(cinv21si.getArchInputStruct());
            pCSEC71DInputRec.setUlIdStage(cinv21si.getROWCINV21SIG01().getUlIdStage());
            rc = csec71dQUERYdam(sqlca, pCSEC71DInputRec, pCSEC71DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        /**************************************************************************
        ** End SIR 2860
        ** (END): Common Function: cSEC71d
        **************************************************************************/
        
        
        
        /* R1R2 Impact #29: Admin Review
        ** Bypass CheckStageEventStatus() if the stage is ARI or ARF.  The
        ** ID_STAGE passed in will correspond to a closed Investigation or an
        ** open or closed FA Home stage.  In either case, we KNOW the stage is
        ** closed and don't want the error messages that CheckStageEventStatus()
        ** produces.
        */
        /*
        ** SIR 2860 : We always want to call CheckEventStatus. Now we change the id_stage.
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
        pCCMN06UInputRec.setArchInputStruct(cinv21si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv21si.getArchInputStruct().getCReqFuncCd());
        if ((0 == cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_INV)) || (0 == cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD))) {
            pCCMN06UInputRec.setUlIdStage(pCSEC71DOutputRec.getUlIdStage());
        }
        else {
            pCCMN06UInputRec.setUlIdStage(cinv21si.getROWCINV21SIG01().getUlIdStage());
        }
        pCCMN06UInputRec.setSzCdTask(cinv21si.getROWCCMN01UIG00().getSzCdTask());
        
        
        /*
        ** Set all TODOs associated with event to COMPLETED
        */
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
                
                //  On an UPDATE or DELETE statement, SQL_NOT_FOUND will be returned
                // if there are no records meeting the WHERE clause criteria.  In
                // most cases this will be caused by a timestamp mismatch.
                // pServiceStatus->explan_code should be set to the appropriate
                // message by the programmer.
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
        
        if (false == cinv21si.getArchInputStruct().getUlSysNbrReserved1() && SUCCESS == RetVal && cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_INV) != 0 && cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD) != 0) {
            
            if (!(strncmp(cinv21si.getROWCCMN01UIG00().getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
                //  Reserve memory for Invalidate Function structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                pInvdInput.setArchInputStruct(cinv21si.getArchInputStruct());
                pInvdInput.setUlIdEvent(cinv21si.getROWCCMN01UIG00().getUlIdEvent());
                rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            if (NULL_DATE != cinv21si.getROWCINV21SIG01().getDtDtApsInvstCmplt().month && NULL_DATE != cinv21si.getROWCINV21SIG01().getDtDtApsInvstCmplt().year && NULL_DATE != cinv21si.getROWCINV21SIG01().getDtDtApsInvstCmplt().day && cinv21si.getROWCINV21SIG02().getSzCdStageReasonClosed().compareTo(NULL_STRING) != 0) {
                cinv21si.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
            }
            else {
                cinv21si.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_PROGRESS);
            }
            cinv21si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            PostEventRec.setUlIdEvent(cinv21si.getROWCCMN01UIG00().getUlIdEvent());
            PostEventRec.setUlIdStage(cinv21si.getROWCCMN01UIG00().getUlIdStage());
            PostEventRec.setUlIdPerson(cinv21si.getROWCCMN01UIG00().getUlIdPerson());
            PostEventRec.setSzCdTask(cinv21si.getROWCCMN01UIG00().getSzCdTask());
            PostEventRec.setSzCdEventType(cinv21si.getROWCCMN01UIG00().getSzCdEventType());
            PostEventRec.setDtDtEventOccurred(cinv21si.getROWCCMN01UIG00().getDtDtEventOccurred());
            PostEventRec.setSzTxtEventDescr(cinv21si.getROWCCMN01UIG00().getSzTxtEventDescr());
            PostEventRec.setSzCdEventStatus(cinv21si.getROWCCMN01UIG00().getSzCdEventStatus());
            PostEventRec.setTsLastUpdate(cinv21si.getROWCCMN01UIG00().getTsLastUpdate());
            rc = Ccmn25s.CallPostEvent(cinv21si.getArchInputStruct() , PostEventRec, ulOutputEvent, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                    
                    //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                    // if there is an attempt to store a duplicate primary key value.
                    // pServiceStatus->explan_code should be set to the appropriate
                    // message by the programmer.
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    
                    //  Exit service
                    //SIR#18449		Added goto for intermediate exit.
                    RetVal = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    // Srini 02/10/03  Added goto for intermediate exit.
                    goto END;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    break;
            }
        }
        
        if (SUCCESS == RetVal && cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_INV) != 0 && cinv21si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD) != 0) {
            
            //  Start Performance Timer
            rc = Cinv28s.CallCINV24D(cinv21si, cinv21so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    
                    //  Exit service
                    //SIR#18449		Added goto for intermediate exit.
                    RetVal = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    // Srini 02/10/03  Added goto for intermediate exit.
                    goto END;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            rc = Cinv16s.CallCSVC18D(cinv21si, cinv21so, pServiceStatus);
            switch (rc) {
                    
                    //  On an UPDATE or DELETE statement, SQL_NOT_FOUND will be returned
                    // if there are no records meeting the WHERE clause criteria.  In
                    // most cases this will be caused by a timestamp mismatch.
                    // pServiceStatus->explan_code should be set to the appropriate
                    // message by the programmer.
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    
                    //  Exit service
                    //SIR#18449		Added goto for intermediate exit.
                    RetVal = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    goto_END = true;
                    if (goto_END) {
                        break;
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
            }
            
        }
        
        if (!(goto_END)) {
            
            // Setup for service function exit
            
            
            ARC_PRFServiceStopTime_TUX(cinv21si.getArchInputStruct() , cinv21so.getArchOutputStruct());
            if (RetVal == SUCCESS) {
                rc = SUCCESS;
            }
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            //## END TUX/XML: Turn the XML buffer into an input message struct 
            
            
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV21S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call CheckStageEventStatus
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV21S\n");
        }
        return cinv21so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = "CINV21SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct6, ROWCCMN01UIG00 ROWCCMN01UIG005, Pint ulIdEvent25, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        CCMN01UI pInputMsg668 = null;
        CCMN01UO pOutputMsg618 = null;
        pInputMsg668 = new CCMN01UI();
        pOutputMsg618 = new CCMN01UO();
        pInputMsg668.setArchInputStruct(ArchInputStruct6);
        pInputMsg668.setROWCCMN01UIG00(ROWCCMN01UIG005);
        pOutputMsg618.setUlIdEvent(ulIdEvent25.value);
        
        rc = Ccmn01u.PostEvent(pInputMsg668, pOutputMsg618, pServiceStatus);
        
        if (ulIdEvent25.value == null) {
            ulIdEvent25.value = pOutputMsg618.getUlIdEvent();
        }
        
        return rc;
    }

    static int CallCINV24D(CINV21SI pInputMsg669, CINV21SO * pOutputMsg619, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    /**************************************************************************
    ** (END): Retrieve DAM: cres04d     ** Caps_resource simple retrieve
    **************************************************************************/
    {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV24DI pCINV24DInputRec = null;
        CINV24DO pCINV24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV24DInputRec = new CINV24DI();
        
        pCINV24DOutputRec = new CINV24DO();
        pCINV24DInputRec.setSzCdApsInvstFinalPrty(pInputMsg669.getROWCINV21SIG01().getSzCdApsInvstFinalPrty());
        pCINV24DInputRec.setSzcdApsInvstOvrallDisp(pInputMsg669.getROWCINV21SIG01().getSzcdApsInvstOvrallDisp());
        pCINV24DInputRec.setDtDtApsInvstBegun(pInputMsg669.getROWCINV21SIG01().getDtDtApsInvstBegun());
        pCINV24DInputRec.setDtDtApsInvstCltAssmt(pInputMsg669.getROWCINV21SIG01().getDtDtApsInvstCltAssmt());
        pCINV24DInputRec.setDtDtApsInvstCmplt(pInputMsg669.getROWCINV21SIG01().getDtDtApsInvstCmplt());
        pCINV24DInputRec.setUlIdEvent(pInputMsg669.getROWCINV21SIG01().getUlIdEvent());
        
        /* Return the return code to the calling routine */
        pCINV24DInputRec.setUlIdStage(pInputMsg669.getROWCINV21SIG01().getUlIdStage());
        pCINV24DInputRec.setTsLastUpdate(pInputMsg669.getROWCINV21SIG01().getTsLastUpdate());
        pCINV24DInputRec.setSzCdClosureType(pInputMsg669.getROWCINV21SIG01().getSzCdClosureType());
        pCINV24DInputRec.setBIndExtDoc(pInputMsg669.getROWCINV21SIG01().getBIndExtDoc());
        pCINV24DInputRec.setBIndLegalAction(pInputMsg669.getROWCINV21SIG01().getBIndLegalAction());
        pCINV24DInputRec.setBIndFamViolence(pInputMsg669.getROWCINV21SIG01().getBIndFamViolence());
        
        pCINV24DInputRec.setBIndECS(pInputMsg669.getROWCINV21SIG01().getBIndECS());
        pCINV24DInputRec.setBIndClient(pInputMsg669.getROWCINV21SIG01().getBIndClient());
        pCINV24DInputRec.setSzTxtClientOther(pInputMsg669.getROWCINV21SIG01().getSzTxtClientOther());
        pCINV24DInputRec.setSzCdInterpreter(pInputMsg669.getROWCINV21SIG01().getSzCdInterpreter());
        pCINV24DInputRec.setSzTxtMethodComm(pInputMsg669.getROWCINV21SIG01().getSzTxtMethodComm());
        pCINV24DInputRec.setSzTxtTrnsNameRlt(pInputMsg669.getROWCINV21SIG01().getSzTxtTrnsNameRlt());
        pCINV24DInputRec.setSzTxtAltComm(pInputMsg669.getROWCINV21SIG01().getSzTxtAltComm());
        /*
        ** Anything but success us unacceptable
        */
        pCINV24DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        pCINV24DInputRec.setBIndAPSInvCnclsn('Y');
        
        
        /* Call the DAM to obtain the TS LAST UPDATE
        ** so that the current Time Stamp is available
        ** for future updates
        */
        rc = cinv24dAUDdam(sqlca, pCINV24DInputRec, pCINV24DOutputRec);
        
        /*
        ** Analyze error code
        */
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
    }

    static int CallCSVC18D(CINV21SI pInputMsg670, CINV21SO * pOutputMsg620, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
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
        pCSVC18DInputRec.setUlIdStage(pInputMsg670.getROWCINV21SIG02().getUlIdStage());
        pCSVC18DInputRec.setTmSysTmStageClose(pInputMsg670.getROWCINV21SIG02().getTmSysTmStageClose());
        pCSVC18DInputRec.setTmSysTmStageStart(pInputMsg670.getROWCINV21SIG02().getTmSysTmStageStart());
        pCSVC18DInputRec.setUlIdUnit(pInputMsg670.getROWCINV21SIG02().getUlIdUnit());
        pCSVC18DInputRec.setBIndStageClose(pInputMsg670.getROWCINV21SIG02().getBIndStageClose());
        pCSVC18DInputRec.setSzNmStage(pInputMsg670.getROWCINV21SIG02().getSzNmStage());
        pCSVC18DInputRec.setSzCdStage(pInputMsg670.getROWCINV21SIG02().getSzCdStage());
        pCSVC18DInputRec.setSzCdStageClassification(pInputMsg670.getROWCINV21SIG02().getSzCdStageClassification());
        pCSVC18DInputRec.setSzCdStageCnty(pInputMsg670.getROWCINV21SIG02().getSzCdStageCnty());
        pCSVC18DInputRec.setSzCdStageCurrPriority(pInputMsg670.getROWCINV21SIG02().getSzCdStageCurrPriority());
        pCSVC18DInputRec.setSzCdStageInitialPriority(pInputMsg670.getROWCINV21SIG02().getSzCdStageInitialPriority());
        /* 
        **  PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
        **  SQL error returned from the DAM.
        */
        pCSVC18DInputRec.setSzCdStageProgram(pInputMsg670.getROWCINV21SIG02().getSzCdStageProgram());
        
        pCSVC18DInputRec.setSzCdStageReasonClosed(pInputMsg670.getROWCINV21SIG02().getSzCdStageReasonClosed());
        pCSVC18DInputRec.setDtDtStageClose(pInputMsg670.getROWCINV21SIG02().getDtDtStageClose());
        pCSVC18DInputRec.setDtDtStageStart(pInputMsg670.getROWCINV21SIG02().getDtDtStageStart());
        pCSVC18DInputRec.setUlIdCase(pInputMsg670.getROWCINV21SIG02().getUlIdCase());
        pCSVC18DInputRec.setUlIdSituation(pInputMsg670.getROWCINV21SIG02().getUlIdSituation());
        pCSVC18DInputRec.setSzTxtStageClosureCmnts(pInputMsg670.getROWCINV21SIG02().getSzTxtStageClosureCmnts());
        pCSVC18DInputRec.setSzTxtStagePriorityCmnts(pInputMsg670.getROWCINV21SIG02().getSzTxtStagePriorityCmnts());
        pCSVC18DInputRec.setSzCdStageRegion(pInputMsg670.getROWCINV21SIG02().getSzCdStageRegion());
        pCSVC18DInputRec.setSzCdStageRsnPriorityChgd(pInputMsg670.getROWCINV21SIG02().getSzCdStageRsnPriorityChgd());
        pCSVC18DInputRec.setSzCdStageType(pInputMsg670.getROWCINV21SIG02().getSzCdStageType());
        pCSVC18DInputRec.setTsLastUpdate(pInputMsg670.getROWCINV21SIG02().getTsLastUpdate());
        pCSVC18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = csvc18dAUDdam(sqlca, pCSVC18DInputRec, pCSVC18DOutputRec);
        
        /* SIR 10617 - calling the ccmn39d dam */
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    // Call DAM
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
    }

}
