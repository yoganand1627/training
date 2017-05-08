package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES56DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC19S.src
**
** Service Name:  CCFC19S
**
** Description:   This service will retrieve all columns for an ID Case from
**                the RECORDS RETENTION table.  There will be one row for a 
**                specified ID Case.  Additionally, it will retrieve a full
**                row from the CAPS CASE table to get the closure date for 
**                case.  It calls DAMS: CCMNC5D - CASE SMP and CSES56D -
**                REC RETN RTRV.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/27/95 
** 
** Programmer:    Lee Phillips
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:38:00  $
**                      $Modtime:   15 May 1996 18:00:24  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  3/7/96    CRYSTAEP  SIR #3687 - Inserted code in Populate Output Message
**                      to set Eligible and Actual Case Destruction Dates
**                      to ARC_UTL_MAX_(DAY,MONTH,YEAR) if dates retrieved
**                      are NULL_DATE.  This will ensure that the Case
**                      Destruction Date displayed on the Records Retention
**                      window will be permanent for cases in which the
**                      retention period retrieved is permanent.
**
**  05/03/96  CRYSTAEP  SIR 20878- If no record exists, display 
**                      MSG_REC_RETN_NOT_FOUND to inform user that no 
**                      Records Retention data exists for the case.
**                      (This is due to conversion).
** 
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc19s {
    CCFC19SO CCFC19S(CCFC19SI ccfc19si) {
        CCFC19SO ccfc19so = new CCFC19SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i44 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CCMNC5DI pCCMNC5DInputRec = null;
        CCMNC5DO pCCMNC5DOutputRec = null;
        CSES56DI pCSES56DInputRec = null;
        CSES56DO pCSES56DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc19si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing - CCMNC5D
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMNC5DInputRec = new CCMNC5DI();
        
        pCCMNC5DOutputRec = new CCMNC5DO();
        
        pCCMNC5DInputRec.setArchInputStruct(ccfc19si.getArchInputStruct());
        pCCMNC5DInputRec.setUlIdCase(ccfc19si.getUlIdCase());
        
        
        /*
        ** Call CAUD64D
        */
        rc = ccmnc5dQUERYdam(sqlca, pCCMNC5DInputRec, pCCMNC5DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccfc19so.setDtDtCaseClosed(pCCMNC5DOutputRec.getDtDtCaseClosed());
                
                //  CSES56D - A full row retrieve from the RECORDS RETENTION table 
                // given the input ID CASE.
                
                //  Allocate memory for DAM Input and Output Structures
                pCSES56DInputRec = new CSES56DI();
                
                pCSES56DOutputRec = new CSES56DO();
                pCSES56DInputRec.setArchInputStruct(ccfc19si.getArchInputStruct());
                pCSES56DInputRec.setUlIdCase(ccfc19si.getUlIdCase());
                
                rc = cses56dQUERYdam(sqlca, pCSES56DInputRec, pCSES56DOutputRec);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccfc19so.setSzCdRecRtnRetenType(pCSES56DOutputRec.getSzCdRecRtnRetenType());
                        ccfc19so.setSzTxtRecRtnDstryDtRsn(pCSES56DOutputRec.getSzTxtRecRtnDstryDtRsn());
                        ccfc19so.setTsLastUpdate(pCSES56DOutputRec.getTsLastUpdate());
                        ccfc19so.setDtDtRecRtnDstryActual(pCSES56DOutputRec.getDtDtRecRtnDstryActual());
                        ccfc19so.setDtDtRecRtnDstryElig(pCSES56DOutputRec.getDtDtRecRtnDstryElig());
                        if (DateHelper.NULL_DATE == ccfc19so.getDtDtRecRtnDstryActual().year) {
                            // Process utility function failure
                            ccfc19so.getDtDtRecRtnDstryActual().day = Arcutls.ARC_UTL_MAX_DAY;
                            ccfc19so.getDtDtRecRtnDstryActual().month = Arcutls.ARC_UTL_MAX_MONTH;
                            ccfc19so.getDtDtRecRtnDstryActual().year = Arcutls.ARC_UTL_MAX_YEAR;
                        }
                        
                        if (DateHelper.NULL_DATE == ccfc19so.getDtDtRecRtnDstryElig().year) {
                            ccfc19so.getDtDtRecRtnDstryElig().day = Arcutls.ARC_UTL_MAX_DAY;
                            ccfc19so.getDtDtRecRtnDstryElig().month = Arcutls.ARC_UTL_MAX_MONTH;
                            ccfc19so.getDtDtRecRtnDstryElig().year = Arcutls.ARC_UTL_MAX_YEAR;
                        }
                        
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_REC_RETN_NOT_FOUND;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
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
        ARC_PRFServiceStopTime_TUX(ccfc19si.getArchInputStruct() , ccfc19so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else 
        {
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Call CSES56D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccfc19so;
    }

}
