package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB49SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CSUB49S.src
**
** Service Name:  CSUB49S
**
** Description:   This is the Add, Update, Delete service for the Persons in
**                Home Removal Window.  It modifies the PERSON_HOME_RMVL table
**                according to whether the user has added a person to the list
**                to be included or deleted from the window list
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2 October 1995
** 
** Programmer:    Greg Dyar
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:23:40  $
**                      $Modtime:   06 Aug 1996 09:25:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  08/05/96  ZABIHIN   SIR 21891 - Was missing versioning. Added the lines.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub49s {
    public static final int FND_FAILURE = 1;
    static int transactionflag = - 1;
    CSUB49SO CSUB49S(CSUB49SI csub49si) {
        CSUB49SO csub49so = new CSUB49SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        //SIR 17188 - IMPACT: Added code to make Service Transaction aware
        // Need to check if the transaction is already in progress as this service is called
        // from another service.
        //SIR 18602
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CSUB49S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            
            //  Call UnitAccess
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CSUB49S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CSUB49S \n");
            bTransactionStarted = true;
        }
        int RetVal = 0;/* return value for sql messages */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        
        CAUD12DI pCAUD12DInputRec = null;
        CAUD12DO pCAUD12DOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        
        
        int usInputRow = 0;
        int usRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(csub49si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /* 
        ** Perform Check Stage Event Status Processing
        */
        
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(csub49si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(csub49si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csub49si.getSzCdTask());
        
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                RetVal = SUCCESS;
                break;
                
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                RetVal = FND_FAILURE;
                break;
                
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                RetVal = FND_FAILURE;
                break;
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                RetVal = FND_FAILURE;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                RetVal = FND_FAILURE;
                break;
        }
        
        
        /*
        **  Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD12DInputRec = new CAUD12DI();
        
        pCAUD12DOutputRec = new CAUD12DO();
        if (SUCCESS == RetVal) {
            
            while ((usRow < CSUB49SI._CSUB49SI__ROWCSUB49SIG00_SIZE) && (usRow < csub49si.getArchInputStruct().getUlPageSizeNbr()) && (SUCCESS == rc)) {
                pCAUD12DInputRec.setArchInputStruct(csub49si.getArchInputStruct());
                
                //## BEGIN TUX/XML: Declare XML variables
                pCAUD12DInputRec.getArchInputStruct().setCReqFuncCd(csub49si.getROWCSUB49SIG00_ARRAY().getROWCSUB49SIG00(usRow).getSzCdScrDataAction());
                pCAUD12DInputRec.setTsLastUpdate(csub49si.getROWCSUB49SIG00_ARRAY().getROWCSUB49SIG00(usRow).getTsLastUpdate());
                pCAUD12DInputRec.setUlIdPersHmRemoval(csub49si.getROWCSUB49SIG00_ARRAY().getROWCSUB49SIG00(usRow).getUlIdPerson());
                pCAUD12DInputRec.setUlIdEvent(csub49si.getROWCSUB49SIG00_ARRAY().getROWCSUB49SIG00(usRow).getUlIdEvent());
                
                rc = caud12dAUDdam(sqlca, pCAUD12DInputRec, pCAUD12DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
                usRow++;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub49si.getArchInputStruct() , csub49so.getArchOutputStruct());
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
                userlog("ERROR: tpcommit failed in service CSUB49S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CSUB49S \n");
        }
        return csub49so;
    }

}
