package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD92DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD92DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC37DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC32S.src
**
** Service Name:  CCFC32S
**
** Description:   This service will Update rows in the Criminal History Table
**                (no Add or Delete) for a given IdCrimHist (maximum page
**                size is 13 rows).  Also, this service will delete rows from 
**                Crim Hist Narr Table for a given IdCrimHist when the 
**                XIndDeleteNarr flag is set for that IdCrimHist. It will call
**                DAMS CAUD92D and CMSC37D.
**                
**                Note:  Although this service is set up to Add/Update/Delete
**                to the Criminal History Table, the Criminal History window
**                only updates this table, never adding or deleting rows
**                (only the Function Code = UPDATE is passed by the window).
**                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/8/95
** 
** Programmer:    CIN 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:39:50  $
**                      $Modtime:   29 Mar 1996 23:58:28  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc32s {
    CCFC32SO CCFC32S(CCFC32SI ccfc32si) {
        CCFC32SO ccfc32so = new CCFC32SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        
        /*
        ** Call CCMN43D
        */
        rc = ARC_UTLCheckServiceBatchBlock("CCFC32S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD92DI pCAUD92DInputRec = null;
        CAUD92DO pCAUD92DOutputRec = null;
        
        CMSC37DI pCMSC37DInputRec = null;
        CMSC37DO pCMSC37DOutputRec = null;
        
        
        
        /*
        ** Generic List AUD
        */
        int usRow = 0;
        int usInputRow = 0;
        
        
        /*
        ** Call CCMN43D
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc32si.getArchInputStruct());
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for CAUD92D DAM Input and Output Structures
        */
        pCAUD92DInputRec = new CAUD92DI();
        
        pCAUD92DOutputRec = new CAUD92DO();
        
        
        /*
        ** Allocate memory for CMSC37D DAM Input and Output Structures
        */
        pCMSC37DInputRec = new CMSC37DI();
        
        pCMSC37DOutputRec = new CMSC37DO();
        rc = WtcHelperConstants.SQL_SUCCESS;
        
        /*
        ** While more rows are left to process and rc is zero,
        ** continue loop.
        */
        while ((usRow < ccfc32si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
            pCAUD92DInputRec.setArchInputStruct(ccfc32si.getArchInputStruct());
            pCAUD92DInputRec.getArchInputStruct().setCReqFuncCd(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getSzCdScrDataAction());
            pCAUD92DInputRec.setSzCdCrimHistAction(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getSzCdCrimHistAction());
            pCAUD92DInputRec.setSzTxtCrimHistCmnts(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getSzTxtCrimHistCmnts());
            pCAUD92DInputRec.setSzNmCrimHistReturned(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getSzNmCrimHistReturned());
            pCAUD92DInputRec.setUlIdCrimHist(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getUlIdCrimHist());
            pCAUD92DInputRec.setUlIdRecCheck(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getUlIdRecCheck());
            pCAUD92DInputRec.setTsLastUpdate(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getTsLastUpdate());
            rc = caud92dAUDdam(sqlca, pCAUD92DInputRec, pCAUD92DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Blindly return rc code to allow user to determine
                    // proper course of action
                    
                    // 
                    // Prepare output message to be returned and return
                    // 
                    if (INDICATOR_YES == ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getCIndDeleteNarr()) {
                        pCMSC37DInputRec.setArchInputStruct(ccfc32si.getArchInputStruct());
                        pCMSC37DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                        pCMSC37DInputRec.setUlIdCrimHist(ccfc32si.getROWCCFC32SIG00_ARRAY().getROWCCFC32SIG00(usRow).getUlIdCrimHist());
                        
                        
                        
                        rc = cmsc37dAUDdam(sqlca, pCMSC37DInputRec, pCMSC37DOutputRec);
                        
                        //  Analyze error code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                break;
                                
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  Set explan_data to usRow
                                // Note: Use sprintf
                                //##                                  sprintf(pReturnPB->appl_status.explan_data,
                                //##                                          "%u",
                                //##                                          usVersionRow);
                                
                                break;
                        }
                    }
                    
                    //  Set explan_data to usRow
                    // Note: Use sprintf
                    //##                                  sprintf(pReturnPB->appl_status.explan_data,
                    //##                                          "%u",
                    //##                                          usVersionRow);
                    
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
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
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
        ARC_PRFServiceStopTime_TUX(ccfc32si.getArchInputStruct() , ccfc32so.getArchOutputStruct());
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
        return ccfc32so;
    }

}
