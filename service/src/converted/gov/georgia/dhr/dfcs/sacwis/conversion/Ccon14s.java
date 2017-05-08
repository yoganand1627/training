package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD08DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON14S.src
**
** Service Name:  County List Save
**
** Description:   This service will add or delete reference rows from 
**                the Contract County table based upon the Data Action
**                Indicator in the listbox.  Before the AUD Dam (CAUD08D) is 
**                called, the Retrieval Dam (CLSC11D) is initiated to determine
**                whether or not a county has been contracted for the Resource
**                and Service code in another Contract or Service Line since 
**                the initial call to the Retrieval service that populated the
**                listbox was called.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 4, 1995
** 
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:06:46  $
**                      $Modtime:   28 Mar 1996 22:29:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
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






public class Ccon14s {
    static int transactionflag = - 1;
    CCON14SO CCON14S(CCON14SI ccon14si) {
        CCON14SO ccon14so = new CCON14SO();
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
            userlog("ERROR: tpgetlev failed in CCON14S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCON14S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCON14S \n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CLSC11DI pCLSC11DInputRec = null;
        CLSC11DO pCLSC11DOutputRec = null;
        
        CAUD08DI pCAUD08DInputRec = null;
        CAUD08DO pCAUD08DOutputRec = null;
        int usRow = 0;/* Counter used to loop through the
        ** input message
        */
        int usInputRow = 0;/* Counter used to loop through the 
        ** Retrieval DAM output against the 
        ** AUD DAM input
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon14si.getArchInputStruct());/* No other approvers to invalidate */
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        ** for CLSC11D - County List Rtrv
        */
        pCLSC11DInputRec = new CLSC11DI();
        
        pCLSC11DOutputRec = new CLSC11DO();
        pCLSC11DInputRec.setArchInputStruct(ccon14si.getArchInputStruct());
        pCLSC11DInputRec.setSzCdRsrcSvcService(ccon14si.getSzCdRsrcSvcService());
        pCLSC11DInputRec.setDtDtCncntyEffective(ccon14si.getDtDtCncntyEffective());
        pCLSC11DInputRec.setDtDtCncntyEnd(ccon14si.getDtDtCncntyEnd());
        pCLSC11DInputRec.setUlIdContract(ccon14si.getUlIdContract());
        pCLSC11DInputRec.setUlIdResource(ccon14si.getUlIdResource());
        pCLSC11DInputRec.setUlNbrCncntyLineItem(ccon14si.getUlNbrCncntyLineItem());
        pCLSC11DInputRec.setUlNbrCncntyPeriod(ccon14si.getUlNbrCncntyPeriod());
        pCLSC11DInputRec.setUlNbrCncntyVersion(ccon14si.getUlNbrCncntyVersion());
        pCLSC11DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSC11DInputRec.getArchInputStruct().setUlPageSizeNbr(CCON14SI._CCON14SI__ROWCCON14SIG_SIZE);
        rc = clsc11dQUERYdam(sqlca, pCLSC11DInputRec, pCLSC11DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Allocate memory for DAM Input and Output Structures
                pCAUD08DInputRec = new CAUD08DI();
                
                pCAUD08DOutputRec = new CAUD08DO();
                
                
                for (usRow = 0;usRow < ccon14si.getArchInputStruct().getUlPageSizeNbr();usRow++) {
                    
                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == ccon14si.getROWCCON14SIG_ARRAY().getROWCCON14SIG(usRow).getSzCdScrDataAction()) {
                        //  Loop through CLSC11DO.G00 for all rows that match
                        // Cd County from CAUD08DI with Cd County from CLSC11DO.G00
                        for (usInputRow = 0;usInputRow < pCLSC11DOutputRec.getArchOutputStruct().getUlRowQty();usInputRow++) {
                            if (!(ccon14si.getROWCCON14SIG_ARRAY().getROWCCON14SIG(usInputRow).getSzCdCncntyCounty().compareTo(pCLSC11DOutputRec.getROWCLSC11DO_ARRAY().getROWCLSC11DO(usInputRow).getSzCdRsrcSvcCnty()) != 0) && 0 != pCLSC11DOutputRec.getROWCLSC11DO_ARRAY().getROWCLSC11DO(usInputRow).getUlIdCncnty()) {
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            }
                        }
                    }
                    pCAUD08DInputRec.setArchInputStruct(ccon14si.getArchInputStruct());
                    pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(ccon14si.getROWCCON14SIG_ARRAY().getROWCCON14SIG(usRow).getSzCdScrDataAction());
                    pCAUD08DInputRec.setSzCdCncntyCounty(ccon14si.getROWCCON14SIG_ARRAY().getROWCCON14SIG(usRow).getSzCdCncntyCounty());
                    pCAUD08DInputRec.setSzCdCncntyService(ccon14si.getSzCdRsrcSvcService());
                    pCAUD08DInputRec.setTsLastUpdate(ccon14si.getROWCCON14SIG_ARRAY().getROWCCON14SIG(usRow).getTsLastUpdate());
                    pCAUD08DInputRec.setDtDtCncntyEffective(ccon14si.getDtDtCncntyEffective());
                    pCAUD08DInputRec.setDtDtCncntyEnd(ccon14si.getDtDtCncntyEnd());
                    pCAUD08DInputRec.setUlIdCncnty(ccon14si.getROWCCON14SIG_ARRAY().getROWCCON14SIG(usRow).getUlIdCncnty());
                    pCAUD08DInputRec.setUlIdResource(ccon14si.getUlIdResource());
                    pCAUD08DInputRec.setUlIdContract(ccon14si.getUlIdContract());
                    pCAUD08DInputRec.setUlNbrCncntyLineItem(ccon14si.getUlNbrCncntyLineItem());
                    pCAUD08DInputRec.setUlNbrCncntyPeriod(ccon14si.getUlNbrCncntyPeriod());
                    pCAUD08DInputRec.setUlNbrCncntyVersion(ccon14si.getUlNbrCncntyVersion());
                    pCAUD08DInputRec.setUlIdCntrctWkr(ccon14si.getUlIdCntrctWkr());
                    rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
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
                
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CON_NO_COUNTY;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon14si.getArchInputStruct() , ccon14so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            //  IMPACT BEGIN - Don't demote events when in "Approver mode"
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCON14S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCON14S \n");
        }
        return ccon14so;
    }

}
