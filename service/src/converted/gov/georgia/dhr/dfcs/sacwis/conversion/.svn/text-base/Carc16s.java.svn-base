package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS16DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CARC16S.src
**
** Service Name:   CARC16S
**
** Description:   This service retrieves all designees for a given employee.
**                It performs a full row retrieval of the EMP_TEMP_ASSIGN 
**                table for a given ID PERSON.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  9/23/95 
** 
** Programmer:    Belinda Muse
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:25:40  $
**                      $Modtime:   28 Mar 1996 22:10:46  $
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






public class Carc16s {
    CARC16SO CARC16S(CARC16SI carc16si) {
        CARC16SO carc16so = new CARC16SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CARC16S", pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i9 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //## long            rc = 0;
        
        CLSS16DI pCLSS16DInputRec = null;
        CLSS16DO pCLSS16DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(carc16si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(carc16so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS16DInputRec = new CLSS16DI();
        
        pCLSS16DOutputRec = new CLSS16DO();
        pCLSS16DInputRec.setArchInputStruct(carc16si.getArchInputStruct());
        pCLSS16DInputRec.setUlIdPerson(carc16si.getUlIdPerson());
        pCLSS16DInputRec.getArchInputStruct().setUsPageNbr(carc16si.getArchInputStruct().getUsPageNbr());
        pCLSS16DInputRec.getArchInputStruct().setUlPageSizeNbr(carc16si.getArchInputStruct().getUlPageSizeNbr());
        rc = clss16dQUERYdam(sqlca, pCLSS16DInputRec, pCLSS16DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CARC16SO to fields in CLSS16DO
                for (i9 = 0;i9 < pCLSS16DOutputRec.getArchOutputStruct().getUlRowQty();i9++) {
                    carc16so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i9).setUlIdEmpTempAssign(pCLSS16DOutputRec.getROWCLSS16DO_ARRAY().getROWCLSS16DO(i9).getUlIdEmpTempAssign());
                    carc16so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i9).setUlIdPersonDesignee(pCLSS16DOutputRec.getROWCLSS16DO_ARRAY().getROWCLSS16DO(i9).getUlIdPersonDesignee());
                    carc16so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i9).setSzNmPersonFull(pCLSS16DOutputRec.getROWCLSS16DO_ARRAY().getROWCLSS16DO(i9).getSzNmPersonFull());
                    carc16so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i9).setDtDtAssignExpiration(pCLSS16DOutputRec.getROWCLSS16DO_ARRAY().getROWCLSS16DO(i9).getDtDtAssignExpiration());
                    carc16so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i9).setTsLastUpdate(pCLSS16DOutputRec.getROWCLSS16DO_ARRAY().getROWCLSS16DO(i9).getTsLastUpdate());
                }
                
                carc16so.getArchOutputStruct().setBMoreDataInd(pCLSS16DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                carc16so.getArchOutputStruct().setUlRowQty(pCLSS16DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(carc16si.getArchInputStruct() , carc16so.getArchOutputStruct());
        
        /*
        ** RIOSJA, SIR 16298 - Added "Moderate Family Pres" and
        ** "Contracted Moderate Family Pres" to the list of
        ** Recommended Actions for which APRV'd service auths
        ** will be progressed if Term Date is in the future.
        **
        ** SIR #20884 - Added to if statement, Code Stage
        ** Reason Close is one of the FPR closure reasons.
        ** If so, allow approved, open Service Auths to
        ** pass edit check.
        */
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //  When this is not the last stage in the case, we are only
            // concerned that there are open COMPlete or PENDing Service
            // Authorizations.
            // Otherwise, the SvcAuths are APRV, NEW or PROC and we don't
            // give edit checks on these
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
        return carc16so;
    }

}
