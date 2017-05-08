package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN38DO;
/**************************************************************************
** 
** Module File:   CCMN27S.src
**
** Service Name:  CCMN27S
**
** Description:   Updates CD_STAGE_CNTY in the STAGE table 
**		  and CD_CASE_COUNTY in the CASE table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/07/95 
** 
** Programmer:    Alex Ramirez/Mary Sladewski
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:46:02  $
**                      $Modtime:   29 Mar 1996 00:18:18  $
**                      $Author:   pvcs  $
**
** Change History:
** Date	     Programmer  Description
** --------  ----------  --------------------------------------------------
** 05/10/95  PITMANGS	 Change code to reflect new error processing 
**			 techniques, as well as changes per technical review
**   9Aug95  sladewmf    PWO 1111: Removed references to timestamp processing 
**                       (...tsSysTsLastUpdate2 and ...tsSysTsLastUpdate3).
** 01/19/96  GUARRICR    SIR#2426  Added CheckStageEventStatus common 
**                       function.  
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**  06/13/03   Srini    SIR#17827 - Made the service transaction aware.
**
**	06/30/03  Srini		SIR 18602 - Modified to fix error handling for 
**						transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**						PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to 
**						PROCESS_TUX_SQL_ERROR_TRANSACT calls.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn27s {
    public static final String NULL_STRING = "";
    static int transactionflag = - 1;
    CCMN27SO CCMN27S(CCMN27SI ccmn27si) {
        CCMN27SO ccmn27so = new CCMN27SO();
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
            userlog("ERROR: tpgetlev failed in CCMN27S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCMN27S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCMN27S\n");
            bTransactionStarted = true;
        }
        int RetVal = SUCCESS;/* SIR#2426 */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccmn27si.getArchInputStruct());
        
        if (ccmn27si.getUlIdStage() != 0) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            
            pCCMN06UInputRec.setArchInputStruct(ccmn27si.getArchInputStruct());
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(ccmn27si.getUlIdStage());
            
            // end define SIR 21130
            
            // 
            // Function Prototypes
            // 
            
            // SIR 21130 - dam to retrive the id_event for the closure
            // 
            pCCMN06UInputRec.setSzCdTask(NULL_STRING);
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
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            
            //  Declare FOUNDATION variables
            
            //  Declare local variables
            
            
            //  Start performance timer for service. All performance functions always
            // return success so there is no need to check status.
            rc = CallCCMN66D(ccmn27si, ccmn27so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            if (0 != ccmn27si.getUlIdCase()) {
                
                // SIR 21891 - missing versioning
                //  Run-time Versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                // 
                // Call DAMs to retrieve data
                // 
                rc = CallCCMN38D(ccmn27si, ccmn27so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                        //  PWO 1111: Removed case statement.
                        // case MSG_CMN_TMSTAMP_MISMATCH:
                        // return (FND_SUCCESS);
                        // break;
                        
                    default :
                        
                        // 
                        // Function Prototypes
                        // 
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn27si.getArchInputStruct() , ccmn27so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            //## END TUX/XML: Turn the XML buffer into an input message struct 
            
            
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCMN27S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCMN27S\n");
        }
        return ccmn27so;
    }

    static int CallCCMN66D(CCMN27SI pInputMsg275, CCMN27SO * pOutputMsg258, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN66DI pCCMN66DInputRec = null;
        CCMN66DO pCCMN66DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN66DInputRec = new CCMN66DI();
        
        pCCMN66DOutputRec = new CCMN66DO();
        pCCMN66DInputRec.setSzCdStageCnty(pInputMsg275.getSzCdStageCnty());
        pCCMN66DInputRec.setUlIdStage(pInputMsg275.getUlIdStage());
        pCCMN66DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        
        /*
        ** Call CLSS11D.  The Contract Service Retrieve DAM retrieves
        ** a row from Contract Service table where IdContract, Period and 
        ** Version match.
        */
        rc = ccmn66dAUDdam(sqlca, pCCMN66DInputRec, pCCMN66DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCCMN38D(CCMN27SI pInputMsg276, CCMN27SO * pOutputMsg259, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN38DI pCCMN38DInputRec = null;
        CCMN38DO pCCMN38DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN38DInputRec = new CCMN38DI();
        
        pCCMN38DOutputRec = new CCMN38DO();
        pCCMN38DInputRec.setSzCdStageCnty(pInputMsg276.getSzCdStageCnty());
        pCCMN38DInputRec.setUlIdCase(pInputMsg276.getUlIdCase());
        pCCMN38DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn38dAUDdam(sqlca, pCCMN38DInputRec, pCCMN38DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
                // person may be in system but not in an active case
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                
                // Return the return code to the calling routine
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

}
