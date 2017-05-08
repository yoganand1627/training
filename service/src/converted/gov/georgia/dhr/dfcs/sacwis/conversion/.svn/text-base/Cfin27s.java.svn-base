package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD59DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFIN27S.src
**
** Service Name:  ACCT TRAN SAVE
**
** Description:   This service will Add and Update records to the
**                FIN ACCT TRANSACTION table and partially update a
**                record on the FINANCIAL ACCOUNT table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 4, 1995
**
** Programmer:    Kristi D. Bradford
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:54:36  $
**                      $Modtime:   30 Mar 1996 00:14:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/17/2003  KRD     IMPACT - The Financial Account dialog now supports
**                      accounts for APS.  One of the changes was to add
**                      two new columns to the FIN_ACCT_TRANSACTION table.
**                      We need to save any data sent from the web page
**                      for those columns.
**
**  03/03/2003  KRD     IMPACT - Another new column added to the table.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin27s {
    CFIN27SO CFIN27S(CFIN27SI cfin27si) {
        CFIN27SO cfin27so = new CFIN27SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /* This DAM will Update the AMT FIN ACCT BALANCE, DT FIN ACCT BALANCE
        ** DATE and NBR FIN ACCT TRANS COUNT columns on the FINANCIAL ACCOUNT
        ** TABLE.  ID FIN ACCT and SYS TS LAST UPDATE will be used to identify
        ** the row to be updated
        */
        CAUD60DI pCAUD60DInputRec = null;
        CAUD60DO pCAUD60DOutputRec = null;
        
        /* This DAM will Add or Update full rows on the FIN ACCT TRANSACTION table.
        ** SYS TS LAST UPDATE will be used to identify rows to be updated
        */
        CAUD59DI pCAUD59DInputRec = null;
        CAUD59DO pCAUD59DOutputRec = null;
        
        int usRow = 0;
        int usInputRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(cfin27si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD60DInputRec = new CAUD60DI();
        
        pCAUD60DOutputRec = new CAUD60DO();
        pCAUD60DInputRec.setArchInputStruct(cfin27si.getArchInputStruct());
        pCAUD60DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD60DInputRec.setDtDtFinAcctBalanceDate(cfin27si.getDtDtFinAcctBalanceDate());
        pCAUD60DInputRec.setTsLastUpdate(cfin27si.getTsLastUpdate());
        pCAUD60DInputRec.setLdAmtFinAcctBalance(cfin27si.getLdAmtFinAcctBalance());
        pCAUD60DInputRec.setUlIdFinAcct(cfin27si.getUlIdFinAcct());
        pCAUD60DInputRec.setUNbrFinAcctTransCount(cfin27si.getUNbrFinAcctTransCount());
        rc = caud60dAUDdam(sqlca, pCAUD60DInputRec, pCAUD60DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Call DAM CAUD59D
                
                //  Allocate memory for DAM Input and Output Structures
                pCAUD59DInputRec = new CAUD59DI();
                
                pCAUD59DOutputRec = new CAUD59DO();
                
                while ((usRow < cfin27si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
                    pCAUD59DInputRec.setArchInputStruct(cfin27si.getArchInputStruct());
                    pCAUD59DInputRec.getArchInputStruct().setCReqFuncCd(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getSzCdScrDataAction());
                    pCAUD59DInputRec.setSzCdAcctTranCategory(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getSzCdAcctTranCategory());
                    pCAUD59DInputRec.setSzCdAcctTranType(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getSzCdAcctTranType());
                    pCAUD59DInputRec.setSzTxtAcctTranDescr(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getSzTxtAcctTranDescr());
                    pCAUD59DInputRec.setDtDtAcctTranDate(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getDtDtAcctTranDate());
                    
                    pCAUD59DInputRec.setTsLastUpdate(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getTsLastUpdate());
                    pCAUD59DInputRec.setLdAmtAcctTranAmount(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getLdAmtAcctTranAmount());
                    pCAUD59DInputRec.setDAmtAcctTranBalance(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getDAmtAcctTranBalance());
                    pCAUD59DInputRec.setUlIdFinAcct(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getUlIdFinAcct());
                    pCAUD59DInputRec.setUlIdFinAcctTran(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getUlIdFinAcctTran());
                    pCAUD59DInputRec.setUNbrAcctTranCount(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getUNbrAcctTranCount());
                    pCAUD59DInputRec.setUlNbrAcctTranWarrantNbr(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getUlNbrAcctTranWarrantNbr());
                    pCAUD59DInputRec.setSzCdSubcategory(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getSzCdSubcategory());
                    pCAUD59DInputRec.setSzNmPayee(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getSzNmPayee());
                    pCAUD59DInputRec.setCIndFinAcctReconciled(cfin27si.getROWCFIN27SIG00_ARRAY().getROWCFIN27SIG00(usRow).getCIndFinAcctReconciled());
                    rc = caud59dAUDdam(sqlca, pCAUD59DInputRec, pCAUD59DOutputRec);
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
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    usRow++;
                }
                break;
                
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                //  Set explan_data to usRow
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin27si.getArchInputStruct() , cfin27so.getArchOutputStruct());
        
        /*
        ** Set Calculated Retention date to maximum date
        */
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
        return cfin27so;
    }

}
