package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV18SO;
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
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17DO;
/**************************************************************************
**
** Module File:   cinv18s.src
**
** Service Name:  CINV18S - SAVE FAC INV CONCL
**
** Description:   Saves information on for the Facility Investigation window
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/19/95
**
** Programmer:    Sameer Rao
**
** Change History:
** Date      User      Description
** --------  --------  --------------------------------------------------
**  11/13/95  HELMKEST  SIR 1710: Included CheckStageEventStatus common
**                      function. (CCMN06U)
**
** 08/13/96  vanderm    SIR #21968 - Databse should be restored for all
**                      AUD services which return an error.  Error handling
**                      was changed from FND_SEVERITY_WARNING to
**                      FND_SEVERITY_ERROR.
**
**  04/03/97  GONZALCE  SIR 13618/MHMR Enhancement:  Added szCdMhmrCompCode
**                      to the input of CINV18SI and CINV22DI.  CINV22D
**                      update the Facility_Invst_Dtl table with the MHMR
**                      code.
**
**  04/09/97  RIOSJA    SIR 13618 - MHMR Enhancement for "Investigation
**                      Rapid Closure". Added indicator for Superintendent
**                      Notification.
**  04/15/97  DURANG    SIR 13618 - MHMR Enhancement. Added the call to
**                      the Retrieve Open Admin Review Stage Dam. This
**                      will allow for Admin Reviews to be processed.
**  04/30/98  KOMARA    MHMR3 - Item8.5 MHMR Enhancement.  Add new referral
**                      form.
**  08/31/98  RIOSJA    MHMR Phase III - "pCSEC71DOutputRec->ulIdStage" was
**                      being used in an assigment statement after the
**                      DAM Output Structure "pCSEC71DOutputRec" had already
**                      been freed. This was causing a "no data found" error
**                      because the data in the structure was no longer
**                      accessible. Both the DAM Input and Output Structures
**                      will now be freed after the assignment statement.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**	07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**						before the InvalidateAprvl call.
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
** 
**  11/11/03  ECD       SIR 22371 and 22384 - IMPACT Commented out the code
**                      that creates the Events.  The events will now be created in
**                      the ReferralForm.java file.
**
**  
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv18s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_PROGRESS = "PROC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_PENDING = "PEND";
    /* ERR#1869 Indices for timestamp array in output message */
    public static final int EVENT_INDEX = 0;
    public static final int STAGE_INDEX = 1;
    public static final int FACIL_INDEX = 2;
    public static final String ADMIN_REVIEW_INV = "ARI";
    public static final String ADMIN_REVIEW_FAD = "ARF";
    /* MHMR3 Item 8.5 begin */
    public static final String EVENT_TYPE_CASE = "CAS";
    public static final String EVENT_REFERRAL_DESC = "Referral Form generated";
    static int transactionflag = - 1;
    CINV18SO CINV18S(CINV18SI cinv18si) {
        CINV18SO cinv18so = new CINV18SO();
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
            userlog("ERROR: tpgetlev failed in CINV18S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) 
        {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINV18S\n");
        }
        
        /*********************************************************************
        ** End SIR 1710
        ** (END): Common Function: ccmn06u Check Stage/Event common function
        **********************************************************************/
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINV18S \n");
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
        rc = ARC_PRFServiceStartTime_TUX(cinv18si.getArchInputStruct());
        
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
        ** SIR 13618:
        ** (BEGIN): cSEC71d Add the call to the Retrieve Open Admin Review Stage Dam
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCSEC71DInputRec = new CSEC71DI();
        
        pCSEC71DOutputRec = new CSEC71DO();
        /*SIR 23663 Added 11 new elements staring from  szCdClosureType_IND */
        
        if ((0 == cinv18si.getROWCINV18SIG01().getSzCdEventType().compareTo(ADMIN_REVIEW_INV)) || (0 == cinv18si.getROWCINV18SIG01().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD))) {
            pCSEC71DInputRec.setArchInputStruct(cinv18si.getArchInputStruct());
            pCSEC71DInputRec.setUlIdStage(cinv18si.getROWCINV18SIG03().getUlIdStage());
            rc = csec71dQUERYdam(sqlca, pCSEC71DInputRec, pCSEC71DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                    RetVal = Messages.MSG_SYS_STAGE_CLOSED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        if (RetVal == SUCCESS) {
            // 
            // SIR 1710:
            // (BEGIN): Common Function: ccmn06u Check Stage/Event common function
            // 
            
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cinv18si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv18si.getArchInputStruct().getCReqFuncCd());
            
            if ((0 == cinv18si.getROWCINV18SIG01().getSzCdEventType().compareTo(ADMIN_REVIEW_INV)) || (0 == cinv18si.getROWCINV18SIG01().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD))) {
                pCCMN06UInputRec.setUlIdStage(pCSEC71DOutputRec.getUlIdStage());
            }
            //  Set Event Status to "In Progress" if all required window fields
            // not filled
            else {
                pCCMN06UInputRec.setUlIdStage(cinv18si.getROWCINV18SIG01().getUlIdStage());
            }
            pCCMN06UInputRec.setSzCdTask(cinv18si.getROWCINV18SIG01().getSzCdTask());
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
            
        }
        else if (SUCCESS == RetVal && cinv18si.getROWCINV18SIG01().getSzCdEventType().compareTo(ADMIN_REVIEW_INV) != 0 && cinv18si.getROWCINV18SIG01().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD) != 0) {
            
            if (false == cinv18si.getArchInputStruct().getUlSysNbrReserved1()) {
                if (!(strncmp(cinv18si.getROWCINV18SIG01().getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
                    //  Reserve memory for Invalidate Function structures
                    pInvdInput = new CCMN05UI();
                    
                    pInvdOutput = new CCMN05UO();
                    pInvdInput.setArchInputStruct(cinv18si.getArchInputStruct());
                    pInvdInput.setUlIdEvent(cinv18si.getROWCINV18SIG01().getUlIdEvent());
                    rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                if (cinv18si.getROWCINV18SIG02().getSzNmFacilInvstFacility().compareTo("") != 0 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstIntake().month != - 1 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstIntake().day != - 1 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstIntake().year != - 1 && cinv18si.getROWCINV18SIG02().getTmSysTmFacilInvstInt().compareTo("") != 0 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstBegun().month != - 1 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstBegun().day != - 1 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstBegun().year != - 1 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstComplt().month != - 1 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstComplt().day != - 1 && cinv18si.getROWCINV18SIG02().getDtDtFacilInvstComplt().year != - 1 && cinv18si.getROWCINV18SIG03().getSzCdStageReasonClosed().compareTo("") != 0) {
                    
                    cinv18si.getROWCINV18SIG01().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
                }
                else {
                    cinv18si.getROWCINV18SIG01().setSzCdEventStatus(EVENT_STATUS_PROGRESS);
                }
                cinv18si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                
                //## BEGIN TUX/XML: Declare XML variables 
                PostEventRec.setUlIdEvent(cinv18si.getROWCINV18SIG01().getUlIdEvent());
                PostEventRec.setUlIdStage(cinv18si.getROWCINV18SIG01().getUlIdStage());
                PostEventRec.setUlIdPerson(cinv18si.getROWCINV18SIG01().getUlIdPerson());
                PostEventRec.setSzCdTask(cinv18si.getROWCINV18SIG01().getSzCdTask());
                PostEventRec.setSzCdEventType(cinv18si.getROWCINV18SIG01().getSzCdEventType());
                //##              return (FND_SUCCESS);
                PostEventRec.setDtDtEventOccurred(cinv18si.getROWCINV18SIG01().getDtDtEventOccurred());
                //##              return (FND_SUCCESS);
                PostEventRec.setSzTxtEventDescr(cinv18si.getROWCINV18SIG01().getSzTxtEventDescr());
                PostEventRec.setSzCdEventStatus(cinv18si.getROWCINV18SIG01().getSzCdEventStatus());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                PostEventRec.setTsLastUpdate(cinv18si.getROWCINV18SIG01().getTsLastUpdate());
                rc = Ccmn25s.CallPostEvent(cinv18si.getArchInputStruct() , PostEventRec, ulOutputEvent, pServiceStatus);
                switch (rc) {
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        
                        //  End Sir #13369 durang
                        
                        break;
                }
            }
            rc = CallCINV22D(cinv18si, cinv18so, pServiceStatus);
            switch (rc) {
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            rc = Cinv16s.CallCSVC18D(cinv18si, cinv18so, pServiceStatus);
            switch (rc) {
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    
                    break;
            }
            
            //  Call DAM
            rc = Ccmn01u.CallCCMN45D(cinv18si, cinv18so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            rc = Ccmn80s.CallCINT40D(cinv18si, cinv18so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            //  No todos against that employee
            rc = Cinv17s.CallCINV17D(cinv18si, cinv18so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            
        }
        
        
        /*
        ** Set up output message
        */
        
        
        //##               PrepServiceExit(SVCPARMS);
        
        
        ARC_PRFServiceStopTime_TUX(cinv18si.getArchInputStruct() , cinv18so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        /*
        ** Create an event for the new using of the stage id that
        ** is passed into the service.
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            //  we're processing the Record Call event
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINV18S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                
                
                //  Start performance timer for service. All performance functions always
                // return success so there is no need to check status.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
            
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINV18S \n");
            
            //  END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            
        }
        return cinv18so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV18SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct3, ROWCCMN01UIG00 ROWCCMN01UIG003, Pint ulIdEvent16, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        CCMN01UI pInputMsg634 = null;
        CCMN01UO pOutputMsg587 = null;
        pInputMsg634 = new CCMN01UI();
        pOutputMsg587 = new CCMN01UO();
        pInputMsg634.setArchInputStruct(ArchInputStruct3);
        pInputMsg634.setROWCCMN01UIG00(ROWCCMN01UIG003);
        pOutputMsg587.setUlIdEvent(ulIdEvent16.value);
        rc = Ccmn01u.PostEvent(pInputMsg634, pOutputMsg587, pServiceStatus);
        
        if (ulIdEvent16.value == null) {
            ulIdEvent16.value = pOutputMsg587.getUlIdEvent();
        }
        return rc;
    }

    static int CallCINV22D(CINV18SI pInputMsg635, CINV18SO * pOutputMsg588, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV22DI pCINV22DInputRec = null;
        CINV22DO pCINV22DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV22DInputRec = new CINV22DI();
        pCINV22DOutputRec = new CINV22DO();
        pCINV22DInputRec.setSzAddrFacilInvstAffAttn(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAffAttn());
        pCINV22DInputRec.setSzAddrFacilInvstAffCity(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAffCity());
        pCINV22DInputRec.setSzAddrFacilInvstAffCnty(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAffCnty());
        pCINV22DInputRec.setSzAddrFacilInvstAffilSt(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAffilSt());
        pCINV22DInputRec.setSzAddrFacilInvstAffStr1(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAffStr1());
        pCINV22DInputRec.setSzAddrFacilInvstAffStr2(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAffStr2());
        pCINV22DInputRec.setSzAddrFacilInvstAffZip(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAffZip());
        pCINV22DInputRec.setSzAddrFacilInvstAttn(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstAttn());
        pCINV22DInputRec.setSzAddrFacilInvstCity(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstCity());
        pCINV22DInputRec.setSzAddrFacilInvstCnty(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstCnty());
        pCINV22DInputRec.setSzAddrFacilInvstState(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstState());
        pCINV22DInputRec.setSzAddrFacilInvstStr1(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstStr1());
        
        pCINV22DInputRec.setSzAddrFacilInvstStr2(pInputMsg635.getROWCINV18SIG02().getSzAddrFacilInvstStr2());
        pCINV22DInputRec.setSsAddrFacilInvstZip(pInputMsg635.getROWCINV18SIG02().getSsAddrFacilInvstZip());
        pCINV22DInputRec.setSzCdFacilInvstOvrallDis(pInputMsg635.getROWCINV18SIG02().getSzCdFacilInvstOvrallDis());
        
        pCINV22DInputRec.setDtDtFacilInvstBegun(pInputMsg635.getROWCINV18SIG02().getDtDtFacilInvstBegun());
        pCINV22DInputRec.setTmSysTmFacilInvstBeg(pInputMsg635.getROWCINV18SIG02().getTmSysTmFacilInvstBeg());
        pCINV22DInputRec.setDtDtFacilInvstComplt(pInputMsg635.getROWCINV18SIG02().getDtDtFacilInvstComplt());
        pCINV22DInputRec.setDtDtFacilInvstIncident(pInputMsg635.getROWCINV18SIG02().getDtDtFacilInvstIncident());
        pCINV22DInputRec.setTmSysTmFacilInvstInc(pInputMsg635.getROWCINV18SIG02().getTmSysTmFacilInvstInc());
        pCINV22DInputRec.setDtDtFacilInvstIntake(pInputMsg635.getROWCINV18SIG02().getDtDtFacilInvstIntake());
        pCINV22DInputRec.setTmSysTmFacilInvstInt(pInputMsg635.getROWCINV18SIG02().getTmSysTmFacilInvstInt());
        pCINV22DInputRec.setUlIdAffilResource(pInputMsg635.getROWCINV18SIG02().getUlIdAffilResource());
        pCINV22DInputRec.setUlIdEvent(pInputMsg635.getROWCINV18SIG02().getUlIdEvent());
        pCINV22DInputRec.setUlIdFacilResource(pInputMsg635.getROWCINV18SIG02().getUlIdFacilResource());
        pCINV22DInputRec.setUlIdStage(pInputMsg635.getROWCINV18SIG02().getUlIdStage());
        pCINV22DInputRec.setSzNbrFacilInvstAffilExt(pInputMsg635.getROWCINV18SIG02().getSzNbrFacilInvstAffilExt());
        pCINV22DInputRec.setLNbrFacilInvstAffilPhn(pInputMsg635.getROWCINV18SIG02().getLNbrFacilInvstAffilPhn());
        pCINV22DInputRec.setSzNbrFacilInvstExtension(pInputMsg635.getROWCINV18SIG02().getSzNbrFacilInvstExtension());
        pCINV22DInputRec.setLNbrFacilInvstPhone(pInputMsg635.getROWCINV18SIG02().getLNbrFacilInvstPhone());
        pCINV22DInputRec.setSzNmFacilInvstAff(pInputMsg635.getROWCINV18SIG02().getSzNmFacilInvstAff());
        pCINV22DInputRec.setSzNmFacilInvstFacility(pInputMsg635.getROWCINV18SIG02().getSzNmFacilInvstFacility());
        pCINV22DInputRec.setSzTxtFacilInvstAffilCmnt(pInputMsg635.getROWCINV18SIG02().getSzTxtFacilInvstAffilCmnt());
        pCINV22DInputRec.setSzTxtFacilInvstComments(pInputMsg635.getROWCINV18SIG02().getSzTxtFacilInvstComments());
        pCINV22DInputRec.setTsLastUpdate(pInputMsg635.getROWCINV18SIG02().getTsLastUpdate());
        pCINV22DInputRec.setSzCdMhmrCompCode(pInputMsg635.getROWCINV18SIG02().getSzCdMhmrCompCode());
        pCINV22DInputRec.setCIndFacilSuperintNotif(pInputMsg635.getROWCINV18SIG02().getCIndFacilSuperintNotif());
        pCINV22DInputRec.setArchInputStruct(pInputMsg635.getArchInputStruct());
        rc = cinv22dAUDdam(sqlca, pCINV22DInputRec, pCINV22DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Call CLSS67D - List of Contract rows for an id resource
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    //  Do nothing, the output message just returns success or 
                    // failure.
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
    }

    static int CallCSVC18D(CINV18SI pInputMsg636, CINV18SO * pOutputMsg589, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCSVC18DInputRec.setSzCdStage(pInputMsg636.getROWCINV18SIG03().getSzCdStage());
        pCSVC18DInputRec.setSzCdStageClassification(pInputMsg636.getROWCINV18SIG03().getSzCdStageClassification());
        pCSVC18DInputRec.setSzCdStageCnty(pInputMsg636.getROWCINV18SIG03().getSzCdStageCnty());
        pCSVC18DInputRec.setSzCdStageCurrPriority(pInputMsg636.getROWCINV18SIG03().getSzCdStageCurrPriority());
        pCSVC18DInputRec.setSzCdStageInitialPriority(pInputMsg636.getROWCINV18SIG03().getSzCdStageInitialPriority());
        pCSVC18DInputRec.setSzCdStageProgram(pInputMsg636.getROWCINV18SIG03().getSzCdStageProgram());
        pCSVC18DInputRec.setSzCdStageReasonClosed(pInputMsg636.getROWCINV18SIG03().getSzCdStageReasonClosed());
        pCSVC18DInputRec.setSzCdStageRegion(pInputMsg636.getROWCINV18SIG03().getSzCdStageRegion());
        pCSVC18DInputRec.setSzCdStageRsnPriorityChgd(pInputMsg636.getROWCINV18SIG03().getSzCdStageRsnPriorityChgd());
        pCSVC18DInputRec.setSzCdStageType(pInputMsg636.getROWCINV18SIG03().getSzCdStageType());
        pCSVC18DInputRec.setDtDtStageClose(pInputMsg636.getROWCINV18SIG03().getDtDtStageClose());
        pCSVC18DInputRec.setDtDtStageStart(pInputMsg636.getROWCINV18SIG03().getDtDtStageStart());
        pCSVC18DInputRec.setUlIdCase(pInputMsg636.getROWCINV18SIG03().getUlIdCase());
        pCSVC18DInputRec.setUlIdSituation(pInputMsg636.getROWCINV18SIG03().getUlIdSituation());
        pCSVC18DInputRec.setUlIdStage(pInputMsg636.getROWCINV18SIG03().getUlIdStage());
        pCSVC18DInputRec.setSzNmStage(pInputMsg636.getROWCINV18SIG03().getSzNmStage());
        pCSVC18DInputRec.setUlIdUnit(pInputMsg636.getROWCINV18SIG03().getUlIdUnit());
        pCSVC18DInputRec.setSzTxtStagePriorityCmnts(pInputMsg636.getROWCINV18SIG03().getSzTxtStagePriorityCmnts());
        pCSVC18DInputRec.setSzTxtStageClosureCmnts(pInputMsg636.getROWCINV18SIG03().getSzTxtStageClosureCmnts());
        pCSVC18DInputRec.setBIndStageClose(pInputMsg636.getROWCINV18SIG03().getBIndStageClose());
        pCSVC18DInputRec.setTsLastUpdate(pInputMsg636.getROWCINV18SIG03().getTsLastUpdate());
        pCSVC18DInputRec.setTmSysTmStageStart(pInputMsg636.getROWCINV18SIG03().getTmSysTmStageStart());
        pCSVC18DInputRec.setTmSysTmStageClose(pInputMsg636.getROWCINV18SIG03().getTmSysTmStageClose());
        pCSVC18DInputRec.setArchInputStruct(pInputMsg636.getArchInputStruct());
        rc = csvc18dAUDdam(sqlca, pCSVC18DInputRec, pCSVC18DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
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

    static int CallCCMN45D(CINV18SI pInputMsg637, CINV18SO pOutputMsg590, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter */
        int rc = 0;/* Return code  */
        
        /*
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg637.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg637.getROWCINV18SIG01().getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        else {
            pOutputMsg590.getTsLastUpdate_ARRAY().setTsLastUpdate(EVENT_INDEX, pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
        }
        return rc;
    }

    static int CallCINT40D(CINV18SI pInputMsg638, CINV18SO pOutputMsg591, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setArchInputStruct(pInputMsg638.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(pInputMsg638.getROWCINV18SIG03().getUlIdStage());
        //##   PROCESS_TUX_RC_ERROR;    
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
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
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        else {
            pOutputMsg591.getTsLastUpdate_ARRAY().setTsLastUpdate(STAGE_INDEX, pCINT40DOutputRec.getTsLastUpdate());
        }
        return rc;
    }

    static int CallCINV17D(CINV18SI pInputMsg639, CINV18SO pOutputMsg592, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV17DI pCINV17DInputRec = null;
        CINV17DO pCINV17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV17DInputRec = new CINV17DI();
        
        pCINV17DOutputRec = new CINV17DO();
        pCINV17DInputRec.setArchInputStruct(pInputMsg639.getArchInputStruct());
        pCINV17DInputRec.setUlIdStage(pInputMsg639.getROWCINV18SIG02().getUlIdStage());
        rc = cinv17dQUERYdam(sqlca, pCINV17DInputRec, pCINV17DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            
        }
        else {
            pOutputMsg592.getTsLastUpdate_ARRAY().setTsLastUpdate(FACIL_INDEX, pCINV17DOutputRec.getTsLastUpdate());
        }
        return rc;
    }

}
