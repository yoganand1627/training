package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC52DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON12S.src
**
** Service Name:  CCON12S
**
** Description:   This service will add, update, or delete rows on the 
**                Contract Service table.  Update and deletes will use ID
**                Cnsvc and Timestamp to identify the affected row.  
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 3, 1995
** 
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   22 Aug 1997 11:01:28  $
**                      $Modtime:   22 Aug 1997 11:00:24  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  07/14/97  saravigm  QuickWin-Contract check against the euivalency and
**                      non_equivalency check.Code was inserted on this service
**                      so that when a new period is added to the contract
**                      the program will check and only pass to the new period
**                      the services that pass the edit of cmsc52d.pc.look for 
**                      QuickWin on code to see what was changed on code.  
**  08/22/97  CHESSMTL  Added Facility type contracts to the exclusion of
**                      of the Equivalency edits.
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/* Financial Enhancement 07/27/1997. */
public class Ccon12s {
    public static final String FAD_FUNC_TYPE = "FAD";
    /* TLC 08/22/1997 Added Facility */
    public static final String FAC_FUNC_TYPE = "FAC";
    static int transactionflag = - 1;
    CCON12SO CCON12S(CCON12SI ccon12si) 
    {
        CCON12SO ccon12so = new CCON12SO();
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
            userlog("ERROR: tpgetlev failed in CCON12S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            
            //  Call CINV95D
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCON12S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCON12S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD17DI pCAUD17DInputRec = null;
        CAUD17DO pCAUD17DOutputRec = null;
        
        CMSC52DI pCMSC52DInputRec = null;
        CMSC52DO pCMSC52DOutputRec = null;
        
        int usRow = 0;
        int usInputRow = 0;
        
        
        /*
        ** Call CSES66D
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon12si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): Generic List AUD
        **************************************************************************/
        
        
        /* CAUD17D.PC BEGINS THE CALL- END OF QUICK_ENHANCMENT CODE*/
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD17DInputRec = new CAUD17DI();
        
        pCAUD17DOutputRec = new CAUD17DO();
        pCAUD17DInputRec.setUlIdCntrctWkr(ccon12si.getUlIdCntrctWkr());
        pCAUD17DInputRec.setUlIdContract(ccon12si.getUlIdContract());
        pCAUD17DInputRec.setUlNbrCnsvcPeriod(ccon12si.getUlNbrCnsvcPeriod());
        pCAUD17DInputRec.setUlNbrCnsvcVersion(ccon12si.getUlNbrCnsvcVersion());
        pCAUD17DInputRec.setArchInputStruct(ccon12si.getArchInputStruct());
        
        
        /*
        ** Call CSES68D
        */
        rc = WtcHelperConstants.ARC_SUCCESS;
        
        
        
        while ((usRow < ccon12si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.ARC_SUCCESS)) {
            
            //  Check for memory allocation errors.
            if ((0 != ccon12si.getSzCdCntrctFuncType().compareTo(FAD_FUNC_TYPE) && 0 != ccon12si.getSzCdCntrctFuncType().compareTo(FAC_FUNC_TYPE)) && (ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_ADD) || ((ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getSzCdScrDataAction() == ServiceConstants.REQ_FUNC_CD_UPDATE) && (ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getCIndCnsvcNewRow() == 'Y'))) {
                pCMSC52DInputRec = new CMSC52DI();
                pCMSC52DOutputRec = new CMSC52DO();
                pCMSC52DInputRec.setArchInputStruct(ccon12si.getArchInputStruct());
                pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (4));
                pCMSC52DInputRec.setSzCdEquivSvcDtlService(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getSzCdCnsvcService());
                pCMSC52DInputRec.setDtDtEquivStartDate(ccon12si.getDtDtCncntyEffective());
                pCMSC52DInputRec.setDtDtEquivEndDate(ccon12si.getDtDtCncntyEnd());
                
                rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                
                switch (rc) {
                        
                        //  SIR 11437 - add case for rc = 16502, display a message
                        // instead of an error.
                        // SIR 13770 - message should only appear if the PR could
                        // not be inserted into the stage_person_link table.
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                            
                            //  Set rc to MSG_DETAIL_DELETED
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                        }
                        else {
                            pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (3));
                            
                            
                            //  Call CSES66D
                            rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                            
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    
                                    
                                    
                                    if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                                        
                                        
                                        //  Call CSES68D
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                    }
                                    else {
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_NO_EQUIV_CONTRACT;
                                        
                                        rc = Messages.MSG_NO_EQUIV_CONTRACT;
                                    }
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    
                                    break;
                            }
                        }
                }
            }
            
            
            
            if (rc == WtcHelperConstants.ARC_SUCCESS) {
                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getSzCdScrDataAction());
                pCAUD17DInputRec.setSzCdCnsvcPaymentType(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getSzCdCnsvcPaymentType());
                pCAUD17DInputRec.setSzCdCnsvcService(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getSzCdCnsvcService());
                pCAUD17DInputRec.setSzNbrCnsvcUnitType(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getSzNbrCnsvcUnitType());
                pCAUD17DInputRec.setCIndCnsvcNewRow(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getCIndCnsvcNewRow());
                pCAUD17DInputRec.setTsLastUpdate(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getTsLastUpdate());
                pCAUD17DInputRec.setUlAmtCnsvcEquip(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlAmtCnsvcEquip());
                pCAUD17DInputRec.setUlAmtCnsvcFrgBenft(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlAmtCnsvcFrgBenft());
                pCAUD17DInputRec.setUlAmtCnsvcOther(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlAmtCnsvcOther());
                pCAUD17DInputRec.setUlAmtCnsvcSalary(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlAmtCnsvcSalary());
                pCAUD17DInputRec.setUlAmtCnsvcSupply(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlAmtCnsvcSupply());
                pCAUD17DInputRec.setUlAmtCnsvcTravel(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlAmtCnsvcTravel());
                
                pCAUD17DInputRec.setUlAmtCnsvcUnitRate(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlAmtCnsvcUnitRate());
                pCAUD17DInputRec.setUlIdCnsvc(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlIdCnsvc());
                pCAUD17DInputRec.setUlNbrCnsvcFedMatch(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlNbrCnsvcFedMatch());
                pCAUD17DInputRec.setUlNbrCnsvcLineItem(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlNbrCnsvcLineItem());
                pCAUD17DInputRec.setUlNbrCnsvcLocalMatch(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlNbrCnsvcLocalMatch());
                pCAUD17DInputRec.setUlNbrCnsvcUnitRate(ccon12si.getROWCCON12SIG00_ARRAY().getROWCCON12SIG00(usRow).getUlNbrCnsvcUnitRate());
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                
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
            }
            usRow++;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon12si.getArchInputStruct() , ccon12so.getArchOutputStruct());
        /*
        ** Retrieve from the SITUATION table.
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            
            
            //  Retrieve from the CASE table if a case was referenced
            // in the STAGE table.
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCON12S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Call CSES66D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCON12S \n");
        }
        return ccon12so;
        
    }

}
