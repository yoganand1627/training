package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC07SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES72DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES72DO;
/**************************************************************************
** 
** Module File:   carc21s.src
**
** Service Name:  CARC21S - REPORT RETRY
**
** Description:   This service will fetch a report's parmlist and re-launch
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/17/96
** 
** Programmer:    John Vencill
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:25:56  $
**                      $Modtime:   29 Mar 1996 23:49:50  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Carc21s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final String CARC07S_VER = "20";
    public static final int REPORT_DEFAULT_TIMEOUT = 60;
    CARC21SO CARC21S(CARC21SI carc21si) {
        CARC21SO carc21so = new CARC21SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        String pInputMsgXml = null;
        String szServiceName = new String();
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##   unsigned short rc = FND_SUCCESS;
        String szParmList = null;
        int usPadLength = 0;
        _FND_STANDARD_PB RetryHdr;
        _MSG_PARM_BLOCK RetryMsgPB;
        CARC07SI pRetryInputMsg = null;
        CARC07SO RetryOutputMsg = null;
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_PRFServiceStartTime_TUX(carc21si.getArchInputStruct());
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = CallCSES72D(carc21si, carc21so, pServiceStatus, szParmList);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pRetryInputMsg = new CARC07SI();
        pRetryInputMsg.setArchInputStruct(carc21si.getArchInputStruct());
        pRetryInputMsg.setSzNmRptSqrName(carc21si.getSzNmRptSqrName());
        pRetryInputMsg.setSzNmRptSqrVer(carc21si.getSzNmRptSqrVer());
        pRetryInputMsg.setUlIdPerson(carc21si.getUlIdPerson());
        pRetryInputMsg.setSzTxtEmailMessage(carc21si.getSzTxtEmailMessage());
        pRetryInputMsg.setTxtRptParmList(szParmList);
        pRetryInputMsg.setUlRptLstCfpStamp(0);
        szServiceName = "CARC07S";
        int lBufferLength = 0;
        pInputMsgXml = null;
        
        /*
        ** Analyze error code
        */
        if (rc != 0) {
            
            //  If Answer for retrieved row is "YES", call DAM to scan Outcome
            // Matrix table for possible Actions and Outcomes.
            if (tperrno == TPESVCFAIL) {
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_REPORT_LAUNCH_FAILED;
            }
            else {
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCALL_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCALL_FAILED;
            }
        }
        pInputMsgXml = null;
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(carc21si.getArchInputStruct() , carc21so.getArchOutputStruct());
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
        return carc21so;
    }

    static int CallCSES72D(CARC21SI pInputMsg6, CARC21SO pOutputMsg9, Arcxmlerrors.TUX_DECL_STATUSPARMS, String[] pszParmList) {
        int rc = 0;/* Return code */
        int i11 = 0;
        /*
        ** Declare local variables
        */
        CSES72DI pCSES72DInputRec = null;
        CSES72DO pCSES72DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES72DInputRec = new CSES72DI();
        pCSES72DOutputRec = new CSES72DO();
        pCSES72DInputRec.setUlIdRptList(pInputMsg6.getUlIdRptList());
        pCSES72DOutputRec.getArchOutputStruct().setUlRowQty(0);
        pCSES72DInputRec.setArchInputStruct(pInputMsg6.getArchInputStruct());
        
        //set rc value to FND_FAIL
        rc = cses72dQUERYdam(sqlca, pCSES72DInputRec, pCSES72DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg9.getArchOutputStruct().setUlRowQty(0);
                pOutputMsg9.getArchOutputStruct().setBMoreDataInd(0);
                pszParmList = CStringUtils.setCharAt(pszParmList, 0, pCSES72DOutputRec.getSzRptLstParmlist());
                if (pszParmList.length == 0) {
                    
                    //set rc value to FND_FAIL
                    rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                }
                else {
                    
                    //set rc value to FND_FAIL
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
