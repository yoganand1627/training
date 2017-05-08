package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN25SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD61DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD61DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFIN25S.src
**
** Service Name:  Financial Account Detail Save
**
** Description:   This service will update all columns in the FINANCIAL
**                ACCOUNT table by ID FIN ACCT.  It is called by window
**                CFIN14W - FIN ACCT DETAIL
**
** Environment:   HP-UX V11.x
**                HP-UX Ansi C Compiler
**
** Date Created:  December 13, 1995
**
** Programmer:    Louise Lee
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:54:30  $
**                      $Modtime:   30 Mar 1996 00:14:16  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/31/2003  KRD     SIR 19301 - Added column CD_PROGRAM to the table.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin25s {
    
    
    
    public static final String FIN_CD_ACCT_STAT_CLOSED = "C";
    CFIN25SO CFIN25S(CFIN25SI cfin25si) {
        CFIN25SO cfin25so = new CFIN25SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        
        
        
        /*
        ** Declare local variables
        */
        
        CAUD61DI pCAUD61DInputRec = null;
        CAUD61DO pCAUD61DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin25si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Add/Modify Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD61DInputRec = new CAUD61DI();
        
        pCAUD61DOutputRec = new CAUD61DO();
        pCAUD61DInputRec.setArchInputStruct(cfin25si.getArchInputStruct());
        pCAUD61DInputRec.getArchInputStruct().setCReqFuncCd(cfin25si.getArchInputStruct().getCReqFuncCd());
        pCAUD61DInputRec.setUlIdFinAcct(cfin25si.getUlIdFinAcct());
        pCAUD61DInputRec.setSzAddrFinAcctAddr1(cfin25si.getSzAddrFinAcctAddr1());
        pCAUD61DInputRec.setSzAddrFinAcctAddr2(cfin25si.getSzAddrFinAcctAddr2());
        pCAUD61DInputRec.setSzCdFinAcctState(cfin25si.getSzCdFinAcctState());
        pCAUD61DInputRec.setSzCdFinAcctCnty(cfin25si.getSzCdFinAcctCnty());
        pCAUD61DInputRec.setSzAddrFinAcctCity(cfin25si.getSzAddrFinAcctCity());
        pCAUD61DInputRec.setSzAddrFinAcctZip(cfin25si.getSzAddrFinAcctZip());
        pCAUD61DInputRec.setLdAmtFinAcctBalance(cfin25si.getLdAmtFinAcctBalance());
        pCAUD61DInputRec.setSzCdFinAcctStatus(cfin25si.getSzCdFinAcctStatus());
        pCAUD61DInputRec.setSzCdFinAcctType(cfin25si.getSzCdFinAcctType());
        pCAUD61DInputRec.setDtDtFinAcctBalanceDate(cfin25si.getDtDtFinAcctBalanceDate());
        pCAUD61DInputRec.setDtDtFinAcctStartDate(cfin25si.getDtDtFinAcctStartDate());
        pCAUD61DInputRec.setDtDtFinAcctEndDate(cfin25si.getDtDtFinAcctEndDate());
        pCAUD61DInputRec.setUlIdPerson(cfin25si.getUlIdPerson());
        pCAUD61DInputRec.setSzNbrFinAcctAccount(cfin25si.getSzNbrFinAcctAccount());
        pCAUD61DInputRec.setSzNbrFinAcctExt(cfin25si.getSzNbrFinAcctExt());
        pCAUD61DInputRec.setSzNbrFinAcctPhone(cfin25si.getSzNbrFinAcctPhone());
        pCAUD61DInputRec.setUNbrFinAcctTransCount(cfin25si.getUNbrFinAcctTransCount());
        pCAUD61DInputRec.setSzNmFinAcctInstName(cfin25si.getSzNmFinAcctInstName());
        pCAUD61DInputRec.setSzTxtFinAcctComments(cfin25si.getSzTxtFinAcctComments());
        pCAUD61DInputRec.setSzCdProgram(cfin25si.getSzCdProgram());
        pCAUD61DInputRec.setTsLastUpdate(cfin25si.getTsLastUpdate());
        if (WtcHelperConstants.REQ_FUNC_CD_ADD == cfin25si.getArchInputStruct().getCReqFuncCd()) {
            rc = ARC_UTLGetDateAndTime(pCAUD61DInputRec.getDtDtFinAcctStartDate() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (!(FIN_CD_ACCT_STAT_CLOSED.compareTo(cfin25si.getSzCdFinAcctStatus()) != 0)) {
            if (DateHelper.NULL_DATE == cfin25si.getDtDtFinAcctEndDate().year || DateHelper.NULL_DATE == cfin25si.getDtDtFinAcctEndDate().month || DateHelper.NULL_DATE == cfin25si.getDtDtFinAcctEndDate().day) {
                rc = ARC_UTLGetDateAndTime(pCAUD61DInputRec.getDtDtFinAcctEndDate() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        
        
        
        else {
            
            cfin25si.getDtDtFinAcctStartDate().year = DateHelper.NULL_DATE;
            cfin25si.getDtDtFinAcctStartDate().month = DateHelper.NULL_DATE;
            cfin25si.getDtDtFinAcctStartDate().day = DateHelper.NULL_DATE;
        }
        rc = caud61dAUDdam(sqlca, pCAUD61DInputRec, pCAUD61DOutputRec);
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
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin25si.getArchInputStruct() , cfin25so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                //Do not commit as it will be committed in the called service.
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfin25so;
    }

}
