package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD39DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CCON25S.src
**
** Service Name:  CCON25S
**
** Description:   This is the Service Authorizatin APS Detail Save service.
**                It will call CAUD38D - APS SVC AUTH AUD and CAUD39D - APS
**                INHOME TASK AUD.  CAUD38D is for the simple information
**                entered on the window and CAUD39D is for the in home task
**                list box.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/06/95
**
** Programmer:    Timothy "Forms Guy" Overend
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:08:10  $
**                      $Modtime:   28 Mar 1996 22:30:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/01/95  MCRAEBS   Added a timestamp to the output of the service.
**                      This timestamp will be from a retrieve of the SVC
**                      AUTH table after a sucessful update of the table.
**                      The timestamp will eventually make it back to the
**                      header window. Add of CSES23D completed.
**
**  05/12/03   Srini    SIR 17445 - Added code to start a transaction if one is not
**						started to accomodate the starting of transaction in the
**						EJB/java code.
**
**	06/30/03  Srini		SIR 18602 - Modified to fix error handling for
**						transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**						PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to
**						PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**  04/17/05  CORLEYAN  SIR 23538 - Added save for Estimated Value
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon25s {
    static int transactionflag = - 1;
    CCON25SO CCON25S(CCON25SI ccon25si) {
        CCON25SO ccon25so = new CCON25SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCON25S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCON25S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCON25S\n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        CAUD38DI pCAUD38DInputRec = null;
        CAUD38DO pCAUD38DOutputRec = null;
        CAUD39DI pCAUD39DInputRec = null;
        CAUD39DO pCAUD39DOutputRec = null;
        
        int usRow = 0;
        int usInputRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccon25si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check Output Buffer Size
        */
        /*
        ** Process error message and return to client
        */
        //##    */
        ARC_PRFServiceStopTime_TUX(ccon25si.getArchInputStruct() , ccon25so.getArchOutputStruct());
        
        /*
        ** Initialize Service Status Fields
        */
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** Call the CAUD38D - APS SVC AUTH AUD dam
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD38DInputRec = new CAUD38DI();
        
        pCAUD38DOutputRec = new CAUD38DO();
        pCAUD38DInputRec.setArchInputStruct(ccon25si.getArchInputStruct());
        pCAUD38DInputRec.getArchInputStruct().setCReqFuncCd(ccon25si.getArchInputStruct().getCReqFuncCd());
        pCAUD38DInputRec.setSzCdSvcAuthAbilToRespond(ccon25si.getSzCdSvcAuthAbilToRespond());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        pCAUD38DInputRec.setSzTxtMedicalConditions(ccon25si.getSzTxtMedicalConditions());
        pCAUD38DInputRec.setSzTxtDirectToHome(ccon25si.getSzTxtDirectToHome());
        pCAUD38DInputRec.setSzTxtHomeEnviron(ccon25si.getSzTxtHomeEnviron());
        pCAUD38DInputRec.setTsLastUpdate(ccon25si.getTsLastUpdate());
        pCAUD38DInputRec.setDtDtSvcAuthVerbalReferl(ccon25si.getDtDtSvcAuthVerbalReferl());
        pCAUD38DInputRec.setUlIdSvcAuth(ccon25si.getUlIdSvcAuth());
        pCAUD38DInputRec.setUlIdPerson(ccon25si.getUlIdPerson());
        pCAUD38DInputRec.setLAmtEstValue(ccon25si.getLAmtEstValue());
        rc = caud38dAUDdam(sqlca, pCAUD38DInputRec, pCAUD38DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                // 
                // Call Dam CSES23D - SVC AUTH RTRV
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCSES23DInputRec = new CSES23DI();
                
                pCSES23DOutputRec = new CSES23DO();
                pCSES23DInputRec.setArchInputStruct(ccon25si.getArchInputStruct());
                pCSES23DInputRec.setUlIdSvcAuth(ccon25si.getUlIdSvcAuth());
                rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccon25so.setTsLastUpdate(pCSES23DOutputRec.getTsLastUpdate());
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        
                        break;
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
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        
        /**************************************************************************
        ** Call the CAUD39D - APS INHOME TASK AUD dam
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD39DInputRec = new CAUD39DI();
        
        pCAUD39DOutputRec = new CAUD39DO();
        
        
        while ((usRow < ccon25si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
            
            pCAUD39DInputRec.setArchInputStruct(ccon25si.getArchInputStruct());
            pCAUD39DInputRec.getArchInputStruct().setCReqFuncCd(ccon25si.getROWCCON25SIG00_ARRAY().getROWCCON25SIG00(usRow).getSzCdScrDataAction());
            pCAUD39DInputRec.setSzCdAPSInHomeTask(ccon25si.getROWCCON25SIG00_ARRAY().getROWCCON25SIG00(usRow).getSzCdAPSInHomeTask());
            pCAUD39DInputRec.setTsLastUpdate(ccon25si.getROWCCON25SIG00_ARRAY().getROWCCON25SIG00(usRow).getTsLastUpdate());
            pCAUD39DInputRec.setUlIdApsInhomeSvcAuth(ccon25si.getROWCCON25SIG00_ARRAY().getROWCCON25SIG00(usRow).getUlIdSvcAuth());
            
            //  Declare FOUNDATION variables
            
            //  Declare local variables
            
            //  Start performance timer for service
            rc = caud39dAUDdam(sqlca, pCAUD39DInputRec, pCAUD39DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
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
            usRow++;
        }
        
        /*
        ** Load Translation Map
        */
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon25si.getArchInputStruct() , ccon25so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in CCON25S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                //    Call DAM to determine if id-case from
                // the input msg to the service was closed
                // in a case merge
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCON25S\n");
        }
        
        return ccon25so;
    }

}
