package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECC1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECC1DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
/**************************************************************************
**
** Module File:   CCON19S.src
**
** Service Name:  SVC AUTH SAVE
**
** Description:   This service performs Service Authorization header save
**                functionality as well as the creation and modification of
**                events, Approval Invalidation and ToDo creation.
**
**                If the Window Mode is New then a new record will be saved
**                to the SERVICE AUTHORIZATION table and a new record
**                inserted into the SVC_AUTH_EVENT_LINK table.
**
**                If the Window Mode is Modify and the Event Status is 'PEND'
**                then the approval will have to be invalidated and the
**                Event Status demoted to 'COMP'.
**
**                If this is the first time that the Service Authorization
**                has been marked complete then the appropriate alerts will
**                be generated.
**
**                ToDo's also have to be generated if the worker is
**                authorizing services that are contracted in a region
**                different to their unit region.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  24 October 1995
**
** Programmer:    Brian McRae
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   22 Aug 1996 16:05:40  $
**                      $Modtime:   22 Aug 1996 13:40:20  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/30/95  FOGARTIS  Modified for loop, returning pages of SVC AUTH DTL
**                      rows for processing. Incorrectly had a ; following
**                      the for statement.
**
**  12/14/95  MCRAEBS   FOISTHJ - Changed the todo text string.  SIR 2272
**
**  12/19/95  MCRAEBS   SIR 2349 - Reset Term and Show Date for ToDos
**
**  01/17/96  MCRAEBS   SIR 2671 - Added CINV43AUD to Delete Todo's
**                      associated with the newly saved SvcAuth Event
**
**  01/18/96  MCRAEBS   SIR 2775 - Set rc to SQL_SUCCESS so SA Event Link
**                      DAM will run BSM
**
**
**  01/20/96  MCRAEBS   SIR 2771 - Set Person Assigned to Contract Manager
**                      instead of Current User's Supervisor.  ToDo show
**                      date should also be set to the current date
**
**  01/24/96  GUARRICR  SIR 2915 - Changed CCON002 ToDo Description to name
**                      service for indexed detail line item rather than
**                      service from header.
**
**  02/08/96  GOLDBEDA  SIR 3106 - CAUD33D will now save ID PERSON PRICIPAL
**                      to the SERVICE_AUTHORIZATION Table.
**
**  08/14/96  ADKINSMC  SIR 21130 - Invalidate approval for events if we have
**                      tried to add or modify a Service Authorization after
**                      the Investigation has been submitted for approval.
**
**  02/19/2003  KRD     IMPACT - We now allow users to delete SvcAuths that
**                      have not yet been marked complete.  Code has been
**                      added to support this enhancement.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  05/12/03   Srini    SIR 17445 - Added code to start a transaction if one is not
**						started to accomodate the starting of transaction in the
**						EJB/java code.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**						to PROCESS_TUX_RC_ERROR_NOFREE after the
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**						input and output objects before they are allocated
**
**	06/30/03  Srini		SIR 18602 - Modified to fix error handling for
**						transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**						PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to
**						PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  12/30/03  ochumd - Sir 19989 - Two new service codes associated with PAC 291 are needed
**            to support the automatic disbursement of Kinship Care dollars in the South
**            Texas pilot scheduled to start February 2004.Added Dams csec58d.pc and csecc1d.pc
**            to handle the new service codes.
**
**  04/02/04  Srini   SIR  22824 - Allocating one pointer but checking for another pointer
**				   leading to memory allocation failure error.
**
**  04/02/04  A.Corley  SIR 22735 - Updated To-Do description so
**                      that length will not exceed 80 characters.
**  04/17/05  CORLEYAN   SIR 23538 - Added save for Donated Community Service
**                       information
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon19s {
    static final String APS2 = "APS";
    static final String CPS1 = "CPS";
    static final String CON1 = "CON001";
    static final String CON2 = "CON002";
    static final String CON7 = "CON007";
    static final String AUTHORIZATION = "AUT";
    static final String PENDING1 = "PEND";
    static final int INITIAL_PAGE3 = 1;
    static final int CURRENT1 = 0;
    static final int NEXT1 = 1;
    static final String STATUS_NEW3 = "NEW";
    static final String STATUS_PROCESS2 = "PROC";
    static final String STATUS_COMPLET = "COMP";
    static final String STATUS_PENDING1 = "PEND";
    static final String STATUS_APPROVED1 = "APRV";
    static final int FND_FAILURE2 = 1;
    static final String SERVICES1 = "CSVCCODE";
    static final int SERVICES_LEN1 = 25;
    
    /* Ochumd sir# 19989*/
    static final String SERVICE_CODE_INT = "67A";
    static final String SERVICE_CODE_FLX = "67B";
    static final String SERVICE_CATEGORY = "24";
    static int transactionflag = - 1;
    CCON19SO CCON19S(CCON19SI ccon19si) {
        CCON19SO ccon19so = new CCON19SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CCON19S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCON19S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        
        /*
        ** IMPACT - Also, modified this if-statement and moved code from prior
        **  to the call to CheckStageEventStatus() to here to properly handle the
        **  new DELETE functionality
        **
        **  Original code:
        **      if (FND_SUCCESS == RetVal)
        */
        
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCON19S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCON19S\n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        int RetVal = SUCCESS;
        int i200 = 0;
        FndInt3date dtAPSAdd = null;/* used to set due dates  */
        FndInt3date dtCPSAdd1 = null;
        public public public public public public public public public public public public public public public public public public String szSvcDecode1 = new String();
        
        int ulIdPersonChild = 0;
        int lRC8 = 0;
        
        /*
        ** declare CINV81D - Retrieve Person Information
        */
        public public public CINV81DI pCINV81DInputRec = null;
        CINV81DO pCINV81DOutputRec = null;
        
        /*
        ** declare CAUD33D - Service Authorization AUD
        */
        CAUD33DI pCAUD33DInputRec = null;
        CAUD33DO pCAUD33DOutputRec = null;
        
        /*
        ** declare CAUD34D - Service Authorization Event Link AUD
        */
        CAUD34DI pCAUD34DInputRec = null;
        CAUD34DO pCAUD34DOutputRec = null;
        
        /*
        ** declare CLSS24D - Service Authorization Detail Retrieve
        */
        CLSS24DI pCLSS24DInputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;
        
        /*
        ** declare CSES23D - Service Authorization Retrieve
        */
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        
        /*
        ** declare CINV43D - Delete Todo
        */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        
        /*
        ** declare PostEvent Common Function
        */
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        
        /*
        ** declare ToDo Common Function
        */
        CSUB40UI pToDoCommonInput = null;
        CSUB40UO pToDoCommonOutput = null;
        
        /*
        ** declare InvalidateApproval Common Function
        */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        
        /*
        ** declare CheckStageEvent Common Function
        */
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        
        /* SIR 21130 - Added to Invalidate Stage Closure/Conclusion Approval */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** IMPACT -- added new DAM to delete Service Auths
        */
        CAUDE7DI pCAUDE7DInputRec = null;
        CAUDE7DO pCAUDE7DOutputRec = null;
        
        /*  Ochumd  - Impact Added two new dams to check for placement
        ** Sir#19989
        */
        CSEC58DI pCSEC58DInputRec = null;
        CSEC58DO pCSEC58DOutputRec = null;
        
        CSECC1DI pCSECC1DInputRec = null;
        CSECC1DO pCSECC1DOutputRec = null;
        
        /*
        ** Call CCMN02U
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon19si.getArchInputStruct());
        if (0 == ccon19si.getSzCdSvcAuthCategory().compareTo(SERVICE_CATEGORY) && (0 == ccon19si.getSzCdSvcAuthService().compareTo(SERVICE_CODE_INT) || 0 == ccon19si.getSzCdSvcAuthService().compareTo(SERVICE_CODE_FLX)) && 0 == ccon19si.getROWCCMN01UIG00().getUlIdEvent()) {
            // 
            // BEGIN Retrieval for CSEC58D - Prim Child Info Rtrv
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCSEC58DInputRec = new CSEC58DI();
            
            pCSEC58DOutputRec = new CSEC58DO();
            pCSEC58DInputRec.setUlIdStage(ccon19si.getROWCCMN01UIG00().getUlIdStage());
            rc = csec58dQUERYdam(sqlca, pCSEC58DInputRec, pCSEC58DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Populate Output Message: Set the following fields in CFAD39SO
                    // to the corresponding ones in CSEC58DO: IdPerson, dtPesonBirth
                    // and IdCase
                    ulIdPersonChild = pCSEC58DOutputRec.getUlIdPerson();
                    break;
                    
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            if (SUCCESS == RetVal) {
                // 
                // BEGIN Retrieval for CSECC1D - Act Plcmt for a given Dt
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCSECC1DInputRec = new CSECC1DI();
                
                pCSECC1DOutputRec = new CSECC1DO();
                
                pCSECC1DInputRec.setUlIdPlcmtChild(ulIdPersonChild);
                pCSECC1DInputRec.setDtServAuthEffectiveDt(ccon19si.getDtDtSvcAuthEff());
                rc = csecc1dQUERYdam(sqlca, pCSECC1DInputRec, pCSECC1DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (pCSECC1DOutputRec.getDtDtPlcmtEnd().year != DateHelper.NULL_DATE) {
                            lRC8 = ARC_UTLCompareDateAndTime((FndInt3date) & ccon19si.getDtDtSvcAuthEff() , (char) 0, (FndInt3date) & pCSECC1DOutputRec.getDtDtPlcmtEnd() , (char) 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        }
                        
                        if ((lRC8 > 0) || (0 != pCSECC1DOutputRec.getSzCdPlcmtLivArr().compareTo("DD"))) {
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_NO_PLCMT;
                            
                            
                            //  Call CMSC17D
                            rc = Messages.MSG_SVC_AUTH_NO_PLCMT;
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_NO_PLCMT;
                        rc = Messages.MSG_SVC_AUTH_NO_PLCMT;
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        /***********************************************************
        **  END Retrieval for CSECC1D - Act Plcmt for a given Dt
        ***********************************************************/
        
        
        /**************************************************************************
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(ccon19si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(ccon19si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(ccon19si.getROWCCMN01UIG00().getSzCdTask());
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
                
                break;
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                //  Set RetVal to FND_FAILURE
                RetVal = FND_FAILURE2;
                
                break;
                //  SIR #20651 - 4/28/96 - PURCELA - Added a Case for SQL
                // NOT FOUND.  If working with Converted
                // Data, then there may not be a Historical Primary (HP)
                // Worker.  In this scenario, a full row insert to the
                // Stage Person Link Table is needed.  Otherwise, CCMND3D
                // will update the Stage Person Link Table.
                
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAILURE
                RetVal = FND_FAILURE2;
                
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAILURE
                RetVal = FND_FAILURE2;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                //  Set RetVal to FND_FAILURE
                RetVal = FND_FAILURE2;
                
                break;
        }
        if ((SUCCESS == RetVal) && (WtcHelperConstants.REQ_FUNC_CD_DELETE == ccon19si.getArchInputStruct().getCReqFuncCd())) {
            //  Allocate memory for DAM Input and Output Structures
            pCAUDE7DInputRec = new CAUDE7DI();
            
            pCAUDE7DOutputRec = new CAUDE7DO();
            pCAUDE7DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
            pCAUDE7DInputRec.setUlIdSvcAuth(ccon19si.getUlIdSvcAuth());
            
            //  Call CMSC18D
            rc = caude7dSPdam(sqlca, pCAUDE7DInputRec, pCAUDE7DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    RetVal = SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
            }
        }
        else if ((SUCCESS == RetVal) && (WtcHelperConstants.REQ_FUNC_CD_DELETE != ccon19si.getArchInputStruct().getCReqFuncCd())) {
            
            if (0 == ccon19si.getROWCCMN01UIG00().getUlIdEvent()) {
                ccon19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else {
                ccon19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            //  IMPACT END
            
            
            //  Allocate memory for PostEvent Common Function Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
            rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(ccon19si.getROWCCMN01UIG00().getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(ccon19si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(ccon19si.getROWCCMN01UIG00().getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(ccon19si.getROWCCMN01UIG00().getSzTxtEventDescr());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(ccon19si.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccon19si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccon19si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(ccon19si.getROWCCMN01UIG00().getTsLastUpdate());
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    if (WtcHelperConstants.REQ_FUNC_CD_UPDATE != ccon19si.getArchInputStruct().getCReqFuncCd()) {
                        ccon19so.getROWCCMN01UIG00().setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                    }
                    else {
                        ccon19so.getROWCCMN01UIG00().setUlIdEvent(ccon19si.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    ccon19so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN01UOutputRec.getTsLastUpdate());
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    if (0 == ccon19si.getUlIdSvcAuth()) {
                        ccon19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    }
                    // END SIR 22559
                    else {
                        ccon19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    }
                    
                    if (0 < ccon19si.getUlIdEvent()) {
                        // 
                        // Begin Invalidate Approval
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pInvdInput = new CCMN05UI();
                        
                        pInvdOutput = new CCMN05UO();
                        pInvdInput.setArchInputStruct(ccon19si.getArchInputStruct());
                        
                        //  Invalidate the Conclusion event directly
                        // 
                        // Begin CCMN62D Invalidate the Conclusion event
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN62DInputRec = new CCMN62DI();
                        
                        pCCMN62DOutputRec = new CCMN62DO();
                        pCCMN62DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
                        pCCMN62DInputRec.setUlIdEvent(ccon19si.getUlIdEvent());
                        
                        if (true == ccon19si.getArchInputStruct().getUlSysNbrReserved1()) {
                            pCCMN62DInputRec.setSzCdEventStatus(STATUS_PENDING1);
                        }
                        else {
                            pCCMN62DInputRec.setSzCdEventStatus(Cinv61s.EVENT_STATUS_COMP);
                        }
                        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        
                        
                        //  Call CAUD47D
                        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                RetVal = Csub50s.FND_FAIL;
                                
                                break;
                        }
                        pInvdInput.setUlIdEvent(ccon19si.getUlIdEvent());
                        rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                        
                        //  Analyze error code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                RetVal = Csub50s.FND_FAIL;
                                
                                break;
                        }
                    }
                    
                    // 
                    // End Invalidate Approval
                    // 
                    
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD33DInputRec = new CAUD33DI();
                    
                    pCAUD33DOutputRec = new CAUD33DO();
                    pCAUD33DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
                    pCAUD33DInputRec.getArchInputStruct().setCReqFuncCd(ccon19si.getArchInputStruct().getCReqFuncCd());
                    pCAUD33DInputRec.setUlIdSvcAuth(ccon19si.getUlIdSvcAuth());
                    pCAUD33DInputRec.setUlIdResource(ccon19si.getUlIdResource());
                    pCAUD33DInputRec.setUlIdContract(ccon19si.getUlIdContract());
                    pCAUD33DInputRec.setCIndSvcAuthComplete(ccon19si.getCIndSvcAuthComplete());
                    pCAUD33DInputRec.setSzCdSvcAuthCategory(ccon19si.getSzCdSvcAuthCategory());
                    pCAUD33DInputRec.setSzCdSvcAuthRegion(ccon19si.getSzCdSvcAuthRegion());
                    pCAUD33DInputRec.setSzCdSvcAuthCounty(ccon19si.getSzCdSvcAuthCounty());
                    pCAUD33DInputRec.setSzCdSvcAuthService(ccon19si.getSzCdSvcAuthService());
                    pCAUD33DInputRec.setSzTxtSvcAuthComments(ccon19si.getSzTxtSvcAuthComments());
                    pCAUD33DInputRec.setSzTxtSvcAuthSecProvdr(ccon19si.getSzTxtSvcAuthSecProvdr());
                    pCAUD33DInputRec.setTsLastUpdate(ccon19si.getTsLastUpdate());
                    pCAUD33DInputRec.setUlIdPrimaryClient(ccon19si.getUlIdPrimaryClient());
                    pCAUD33DInputRec.setDtDtSvcAuthEff(ccon19si.getDtDtSvcAuthEff());
                    pCAUD33DInputRec.setCIndDntdCmmtySvc(ccon19si.getCIndDntdCmmtySvc());// person logged in
                    rc = caud33dAUDdam(sqlca, pCAUD33DInputRec, pCAUD33DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccon19so.setUlIdSvcAuth(pCAUD33DOutputRec.getUlIdSvcAuth());
                            
                            //  Retreive Svc Auth Detail TimeStamp
                            pCSES23DInputRec = new CSES23DI();
                            
                            pCSES23DOutputRec = new CSES23DO();
                            pCSES23DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
                            pCSES23DInputRec.setUlIdSvcAuth(ccon19so.getUlIdSvcAuth());
                            
                            //  Call CAUDA0D
                            rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
                            
                            //  Analyze error code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    ccon19so.setTsLastUpdate(pCSES23DOutputRec.getTsLastUpdate());
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    
                                    break;
                            }
                            
                            //  SIR 2671 01/17/96 BSM
                            // Delete any ToDo's related to this event
                            pCINV43DInputRec = new CINV43DI();
                            
                            pCINV43DOutputRec = new CINV43DO();
                            pCINV43DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
                            pCINV43DInputRec.setUlIdEvent(ccon19so.getROWCCMN01UIG00().getUlIdEvent());
                            rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
                            
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = WtcHelperConstants.SQL_SUCCESS;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                            //## END TUX/XML: Turn the XML buffer into an input message struct 
                            
                            
                            
                            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == ccon19si.getArchInputStruct().getCReqFuncCd()) && (ServiceConstants.SQL_SUCCESS == rc)) {
                                pCAUD34DInputRec = new CAUD34DI();
                                
                                pCAUD34DOutputRec = new CAUD34DO();
                                pCAUD34DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
                                pCAUD34DInputRec.setUlIdSvcAuth(ccon19so.getUlIdSvcAuth());
                                pCAUD34DInputRec.setUlIdSvcAuthEvent(ccon19so.getROWCCMN01UIG00().getUlIdEvent());
                                
                                rc = caud34dAUDdam(sqlca, pCAUD34DInputRec, pCAUD34DOutputRec);
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        break;
                                    default :// Of Svc Auth Linker should not fail
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        
                                        // 
                                        // END CAUD15D
                                        // 
                                        break;
                                }
                            }
                            break;
                            
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            break;
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    break;
                default :// Of Post Event Add or Update
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
            if (true == ccon19si.getBScrIndAuthDiffRegion() && true == ccon19si.getBScrIndFrstTmComp()) {
                
                //  Allocate memory for ToDo Common Function
                // Input and Output Structures
                pToDoCommonInput = new CSUB40UI();
                
                pToDoCommonOutput = new CSUB40UO();
                pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccon19si.getROWCCMN01UIG00().getUlIdStage());
                
                //  Call CCMND3D
                rc = ARC_UTLGetDateAndTime(pToDoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ccon19si.getUlIdCntrctManager());
                pToDoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(CON7);
                rc = Csub40u.TodoCommonFunction(pToDoCommonInput, pToDoCommonOutput, pServiceStatus);
                
                //  Analyze return code for CSEC58D
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            if (!(ccon19si.getSzCdEventStatus().compareTo(STATUS_PENDING1) != 0) && WtcHelperConstants.SQL_SUCCESS == rc) {
                //  Allocate memory for InvalidateApproval Common Function
                // Input and Output Structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                
                pInvdInput.setArchInputStruct(ccon19si.getArchInputStruct());
                pInvdInput.setUlIdEvent(ccon19si.getROWCCMN01UIG00().getUlIdEvent());
                rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                
                //  Analyze return code for CSECC1D
                switch (rc) {
                        
                        //  SIR 21003 - Changed error processing of cses80d
                        // to allow sql-not-found because that is an
                        // acceptible condition.  It should not "blow-up"
                        // at this point.
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            if (!(ccon19si.getSzCdUnitProgram().compareTo(APS2) != 0) && true == ccon19si.getBScrIndFrstTmComp() && WtcHelperConstants.SQL_SUCCESS == rc) {
                //  Allocate memory for DAM Input and Output Structures
                pCLSS24DInputRec = new CLSS24DI();
                
                pCLSS24DOutputRec = new CLSS24DO();
                pCLSS24DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
                pCLSS24DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE);
                
                //  Process until there are no more records in CLSS24DO
                for (pCLSS24DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE3);((1 == pCLSS24DOutputRec.getArchOutputStruct().getBMoreDataInd()) || (INITIAL_PAGE3 == pCLSS24DInputRec.getArchInputStruct().getUsPageNbr())) && (WtcHelperConstants.SQL_SUCCESS == rc);pCLSS24DInputRec.getArchInputStruct().getUsPageNbr()++) {
                    pCLSS24DInputRec.setUlIdSvcAuth(ccon19si.getUlIdSvcAuth());
                    
                    //  Call CAUDC3D
                    rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Process until there are no more records in CLSS24
                            for (i200 = 0;i200 < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();i200++) {
                                //  Allocate memory for DAM Input and Output Structures
                                pCINV81DInputRec = new CINV81DI();
                                
                                pCINV81DOutputRec = new CINV81DO();
                                pCINV81DInputRec.setArchInputStruct(ccon19si.getArchInputStruct());
                                pCINV81DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE3);
                                pCINV81DInputRec.getArchInputStruct().setUlPageSizeNbr(INITIAL_PAGE3);
                                pCINV81DInputRec.setUlIdPerson(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i200).getUlIdPerson());
                                rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
                                
                                //  Analyze error code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Allocate memory for ToDo Common Function
                                        // Input and Output Structures
                                        pToDoCommonInput = new CSUB40UI();
                                        
                                        pToDoCommonOutput = new CSUB40UO();
                                        pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccon19si.getROWCCMN01UIG00().getUlIdStage());
                                        
                                        pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ccon19si.getROWCCMN01UIG00().getUlIdPerson());
                                        pToDoCommonInput.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccon19so.getROWCCMN01UIG00().getUlIdEvent());
                                        
                                        pToDoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(CON2);
                                        pToDoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i200).getDtSvcAuthDtlShow());
                                        rc = ARC_FRMGetDecode((char) szSvcDecode1, (char) pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i200).getSzCdSvcAuthDtlSvc() , SERVICES_LEN1, (char) SERVICES1);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                        pToDoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfDesc("SA " + pCINV81DOutputRec.getSzNmPersonFull() + " - " + szSvcDecode1 + " expires on " + (pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i200).getDtDtSvcAuthDtlTerm().month) + "/" + (pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i200).getDtDtSvcAuthDtlTerm().day) + "/" + (pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i200).getDtDtSvcAuthDtlTerm().year));
                                        
                                        //  Set PostEvent DtSystemDate to current date
                                        rc = Csub40u.TodoCommonFunction(pToDoCommonInput, pToDoCommonOutput, pServiceStatus);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                
                                                
                                                break;
                                        }
                                        
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                        
                                        
                                        //  SIR 21747
                                        // Remove the extra memory free
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        
                                        
                                        break;
                                }
                            }
                            
                            break;
                            
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                }
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon19si.getArchInputStruct() , ccon19so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            //  Call CCMN01U
            rc = SUCCESS;
        }
        
        /*
        ** Set Invoice back to pending
        */
        
        /* 
        ** If CFIN14SI szCdInvoPhase != FIN_CD_INVO_PHASE_PEND and
        ** explan_code == FND_SUCCESS, set Invoice back to pending
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in CCON19S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCON19S\n");
        }
        return ccon19so;
    }

}
