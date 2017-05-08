package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD86DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD86DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CFAD33S.SRC
**
** Service Name:  CFAD333S
**
** Description: This service will first loop through all rows sent to
**              the service looking for a "Pre-Service" type row.  If one
**              is found, a DAM is called to determine if any preservice
**              training sessions have been previously saved to the 
**              database.  If not, then PostEvent is called and a ToDo
**              is created which will be associated with the newly
**              created event.  Following this processing, any rows
**              which were Added/Updated/Deleted on the window will be 
**              Added/Updated/Deleted from the database. FA_INDIV_TRAINING
**              rows.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 2, 1996
** 
** Programmer:    Stephen Parks 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:16:26  $
**                      $Modtime:   30 Mar 1996 00:09:28  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/29/96  VISHNUR   SIR 3371 - Duplicate ToDo are not to be creted for
**                      PreService training. 
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/


/*
** Extern for version control table.
*/






public class Cfad33s {
    CFAD33SO CFAD33S(CFAD33SI cfad33si) {
        CFAD33SO cfad33so = new CFAD33SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i215 = 0;
        
        /*                            
        ** Declare FOUNDATION variables 
        */
        
        /*                             
        ** Declare local variables 
        */
        //##  short                   rc = FND_SUCCESS;
        int RetVal = SUCCESS;
        int usRow = 0;
        int usInputRow = 0;
        
        char bFound = (char) (0);
        
        CAUD86DI pCAUD86DInputRec = null;
        CAUD86DO pCAUD86DOutputRec = null;
        CMSC34DI pCMSC34DInputRec = null;
        CMSC34DO pCMSC34DOutputRec = null;
        CSES41DI pCSES41DInputRec = null;
        CSES41DO pCSES41DOutputRec = null;
        CSUB40UI pTodoCommonInput = null;
        CSUB40UO pTodoCommonOutput = null;
        rc = ARC_PRFServiceStartTime_TUX(cfad33si.getArchInputStruct());
        
        
        /*      
        ** Initialize Service Status Fields 
        */
        
        /*        
        **  Perform Main Processing
        */
        
        /*
        ** Check for addition of Pre-Service Training Type
        */
        while (usRow < cfad33si.getArchInputStruct().getUlPageSizeNbr() &&!(bFound != 0) && RetVal == SUCCESS) {
            if ((0 == cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getSzCdIndivTrnType().compareTo(TRAINING_TYPE_PRESERVICE)) && (cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getSzCdSysDataActionOutcome() == WtcHelperConstants.REQ_FUNC_CD_ADD)) {
                bFound = 1;
            }
            usRow++;
        }
        
        if (bFound != 0 && RetVal == SUCCESS) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC34DInputRec = new CMSC34DI();
            
            pCMSC34DOutputRec = new CMSC34DO();
            
            pCMSC34DInputRec.setArchInputStruct(cfad33si.getArchInputStruct());
            pCMSC34DInputRec.setUlIdPerson(cfad33si.getUlIdPerson());
            pCMSC34DInputRec.setSzCdIndivTrnType(TRAINING_TYPE_PRESERVICE);
            rc = cmsc34dQUERYdam(sqlca, pCMSC34DInputRec, pCMSC34DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set RetVal = FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    if (pCMSC34DOutputRec.getUlSysNbrGenericCntr() == 0) {
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES41DInputRec = new CSES41DI();
                        
                        pCSES41DOutputRec = new CSES41DO();
                        pCSES41DInputRec.setArchInputStruct(cfad33si.getArchInputStruct());
                        pCSES41DInputRec.setUlIdRsrcFaHomeStage(cfad33si.getUlIdStage());
                        pCSES41DInputRec.getArchInputStruct().setUsPageNbr(1);
                        pCSES41DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                        rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                if (0 == pCSES41DOutputRec.getSzCdRsrcFaHomeStatus().compareTo(HOME_STATUS_INQUIRY)) {
                                    
                                    //  Begin Common Function
                                    
                                    //  Allocate memory for Common Function Input
                                    // and Output Structures
                                    
                                    pTodoCommonInput = new CSUB40UI();
                                    
                                    pTodoCommonOutput = new CSUB40UO();
                                    pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD045");
                                    
                                    //  Set CSUB40UI DtTodoCfDueFrom
                                    // to NULL_DATE
                                    ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                                    
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(0);
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(pCSES41DOutputRec.getUlIdRsrcFaHomeEvent());
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad33si.getUlIdStage());
                                    
                                    //  Call DAM
                                    rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                                    
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            
                                            //  Set RetVal to FND_SUCCESS
                                            RetVal = SUCCESS;
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                }
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                
                                break;
                        }
                    }
                    break;
                    
                    //  NOTE: The DAM does a SELECT COUNT (*), so it should never return
                    // SQL_NOT_FOUND
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
            }
        }
        
        /*
        ** If the Closure Code is "Valid, Continue as APS", close the
        ** Investigation Stage and open the Service Delivery Stage
        **
        ** Also Open Stage if Closure Code is "Administrative Closure" or
        ** "Client died" and Actions were found on the Outcome Matrix
        **
        ** SIR 1804 - Replaced OUT_MATRIX_ACTIONS_EDIT with OUT_MATRIX_ACT_WARNING
        ** in the following if-statement.
        */
        /*
        ** SIR 5034
        ** Don't progress for closure codes Admin Closure or Client Died
        */
        if (RetVal == SUCCESS) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUD86DInputRec = new CAUD86DI();
            
            pCAUD86DOutputRec = new CAUD86DO();
            rc = WtcHelperConstants.SQL_SUCCESS;
            
            usRow = 0;
            
            //  While more rows are left to process and rc is zero,
            // continue loop.
            while ((usRow < cfad33si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
                pCAUD86DInputRec.setArchInputStruct(cfad33si.getArchInputStruct());
                
                pCAUD86DInputRec.getArchInputStruct().setCReqFuncCd(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getSzCdSysDataActionOutcome());
                pCAUD86DInputRec.setSzCdIndivTrnType(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getSzCdIndivTrnType());
                pCAUD86DInputRec.setDtDtIndivTrn(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getDtDtIndivTrn());
                pCAUD86DInputRec.setUlIdIndivTraining(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getUlIdIndivTraining());
                pCAUD86DInputRec.setCIndIndivTrnEc(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getCIndIndivTrnEc());
                pCAUD86DInputRec.setLdNbrIndivTrnHrs(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getLdNbrIndivTrnHrs());
                pCAUD86DInputRec.setSNbrIndivTrnSession(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getSNbrIndivTrnSession());
                pCAUD86DInputRec.setSzTxtIndivTrnTitle(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getSzTxtIndivTrnTitle());
                pCAUD86DInputRec.setTsLastUpdate(cfad33si.getCFAD33SIG00_ARRAY().getCFAD33SIG00(usRow).getTsLastUpdate());
                
                pCAUD86DInputRec.setUlIdPerson(cfad33si.getUlIdPerson());
                rc = caud86dAUDdam(sqlca, pCAUD86DInputRec, pCAUD86DOutputRec);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        
                        //  Set explan_data to usRow
                        // Note: Use sprintf
                        //##              sprintf(pReturnPB->appl_status.explan_data,
                        //##                      "%u",
                        //##                      usRow);
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        
                        
                        //  Set explan_data to usRow
                        // Note: Use sprintf
                        //##              sprintf(pReturnPB->appl_status.explan_data,
                        //##                      "%u",
                        //##                      usRow);
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
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
        ARC_PRFServiceStopTime_TUX(cfad33si.getArchInputStruct() , cfad33so.getArchOutputStruct());
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
                //Srini: 08/21/03  Commented the usRc statement as we will be ok even if it doesn't write
                //       to the pipe as long as the tempfile is written and database has record with 
                //       pending status. This fixes the problem when the service writes the RPT* file and 
                //		 doesn't write to the pipe as the .LINK is missing but doesn't write to the DB.
                //          usRc = ARC_UTL_NO_SERVER;
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        
        return cfad33so;
    }

}
