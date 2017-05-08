package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:    CFIN24S.src
**
** Service Name:   Financial Account Detail Retrieval Service
**
** Description:   This service will retrieve all columns from the
**                FINANCIAL ACCOUNT table and then it will call a R1
**                dam to get the decode of a person's name.
**
** Environment:   HP-UX V11.x
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 12, 1995
**
** Programmer:    Louise Lee
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:54:26  $
**                      $Modtime:   30 Mar 1996 00:14:12  $
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






public class Cfin24s {
    CFIN24SO CFIN24S(CFIN24SI cfin24si) {
        CFIN24SO cfin24so = new CFIN24SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i234 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CSES49DI pCSES49DInputRec = null;
        CSES49DO pCSES49DOutputRec = null;
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin24si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES49DInputRec = new CSES49DI();
        
        pCSES49DOutputRec = new CSES49DO();
        pCSES49DInputRec.setArchInputStruct(cfin24si.getArchInputStruct());
        
        pCSES49DInputRec.setUlIdFinAcct(cfin24si.getUlIdFinAcct());
        rc = cses49dQUERYdam(sqlca, pCSES49DInputRec, pCSES49DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                cfin24so.setSzAddrFinAcctAddr1(pCSES49DOutputRec.getSzAddrFinAcctAddr1());
                cfin24so.setSzAddrFinAcctAddr2(pCSES49DOutputRec.getSzAddrFinAcctAddr2());
                
                // SIR 3104
                cfin24so.setSzCdFinAcctCnty(pCSES49DOutputRec.getSzCdFinAcctCnty());
                cfin24so.setSzCdFinAcctState(pCSES49DOutputRec.getSzCdFinAcctState());
                cfin24so.setSzAddrFinAcctCity(pCSES49DOutputRec.getSzAddrFinAcctCity());
                
                cfin24so.setSzAddrFinAcctZip(pCSES49DOutputRec.getSzAddrFinAcctZip());
                cfin24so.setLdAmtFinAcctBalance(pCSES49DOutputRec.getLdAmtFinAcctBalance());
                cfin24so.setSzCdFinAcctStatus(pCSES49DOutputRec.getSzCdFinAcctStatus());
                
                cfin24so.setSzCdFinAcctType(pCSES49DOutputRec.getSzCdFinAcctType());
                cfin24so.setDtDtFinAcctBalanceDate(pCSES49DOutputRec.getDtDtFinAcctBalanceDate());
                cfin24so.setDtDtFinAcctStartDate(pCSES49DOutputRec.getDtDtFinAcctStartDate());
                
                cfin24so.setDtDtFinAcctEndDate(pCSES49DOutputRec.getDtDtFinAcctEndDate());
                cfin24so.setUlIdPerson(pCSES49DOutputRec.getUlIdPerson());
                cfin24so.setSzNbrFinAcctAccount(pCSES49DOutputRec.getSzNbrFinAcctAccount());
                
                
                cfin24so.setSzNbrFinAcctExt(pCSES49DOutputRec.getSzNbrFinAcctExt());
                cfin24so.setSzNbrFinAcctPhone(pCSES49DOutputRec.getSzNbrFinAcctPhone());
                cfin24so.setUNbrFinAcctTransCount(pCSES49DOutputRec.getUNbrFinAcctTransCount());
                
                cfin24so.setSzNmFinAcctInstName(pCSES49DOutputRec.getSzNmFinAcctInstName());
                cfin24so.setSzTxtFinAcctComments(pCSES49DOutputRec.getSzTxtFinAcctComments());
                cfin24so.setSzCdProgram(pCSES49DOutputRec.getSzCdProgram());
                
                cfin24so.setTsLastUpdate(pCSES49DOutputRec.getTsLastUpdate());
                
                
                //  Note:  It is a full row retrieval; all rows except IdFinAcct
                // will go back to the client
                
                //  CCMN44D - PERSON SMP Retrieval Processing. Second dam called
                
                //  Allocate memory for DAM Input and Output Structures
                pCCMN44DInputRec = new CCMN44DI();
                
                pCCMN44DOutputRec = new CCMN44DO();
                pCCMN44DInputRec.setArchInputStruct(cfin24si.getArchInputStruct());
                pCCMN44DInputRec.setUlIdPerson(pCSES49DOutputRec.getUlIdPerson());
                rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        cfin24so.setSzScrNmFinAcctClient(pCCMN44DOutputRec.getSzNmPersonFull());
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                        
                        //  Call DAM
                        rc = Messages.MSG_DETAIL_DELETED;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                rc = Messages.MSG_DETAIL_DELETED;
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
        ARC_PRFServiceStopTime_TUX(cfin24si.getArchInputStruct() , cfin24so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            if (tpcommit(0) == - 1) {
                
                // SIR 3318
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
        return cfin24so;
    }

}
