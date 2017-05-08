package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC19SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA2DO;
/**************************************************************************
** 
** Module File:   carc19s.src
**
** Service Name:  CARC19S - REPORT DELETE
**
** Description:   This service will delete the specified report from the
**    Report List table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/20/96
** 
** Programmer:    John Vencill
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   12 Aug 1996 17:11:02  $
**                      $Modtime:   12 Aug 1996 16:07:56  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  8/12/96   vanderm   SIR #21968 - database should be restored for 
**                      database updates (AUD's) which encounter a problem.
**                      Error handling was corrected by changing 
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/










public class Carc19s {
    CARC19SO CARC19S(CARC19SI carc19si) {
        CARC19SO carc19so = new CARC19SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(carc19si.getArchInputStruct());
        carc19si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        rc = CallCAUDA2D(carc19si, carc19so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(carc19si.getArchInputStruct() , carc19so.getArchOutputStruct());
        
        
        
        
        
        /*SIR 23416 ADDED logic to set edit check if FORMER_DAY_CARE in open APRV staus*/
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return carc19so;
    }

    static int CallCAUDA2D(CARC19SI pInputMsg5, CARC19SO pOutputMsg8, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    {
        int rc = 0;/* Return code */
        int i10 = 0;
        CAUDA2DI pCAUDA2DInputRec = null;
        CAUDA2DO pCAUDA2DOutputRec = null;
        
        pCAUDA2DInputRec = new CAUDA2DI();
        pCAUDA2DOutputRec = new CAUDA2DO();
        pCAUDA2DInputRec.setUlIdRptList(pInputMsg5.getUlIdRptList());
        pCAUDA2DOutputRec.getArchOutputStruct().setUlRowQty(0);
        pCAUDA2DInputRec.setArchInputStruct(pInputMsg5.getArchInputStruct());
        rc = cauda2dAUDdam(sqlca, pCAUDA2DInputRec, pCAUDA2DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg8.getArchOutputStruct().setUlRowQty(0);
                pOutputMsg8.getArchOutputStruct().setBMoreDataInd(0);
                
                
                //  Call CLSS06D This service will receive IdContract and retrieve
                // NbrCnperPeriod, DtCnperStart, DtCnperTerm, DtCnperClosure,
                // CdCnperStatus, IndCnperRenewal, and IndCnperSigned from
                // the Contract Period table.
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                // Srini D 02/13/03 set the rc value to explan_code so that PROCESS_TUX_RC_ERROR can handle it
                rc = Messages.MSG_NO_ROWS_RETURNED;
                // 
                // (END): Retrieve DAM: cses37d      Placement simple retrieve
                // 
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
