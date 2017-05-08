package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN97SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN97SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CCMN97S.src
**
** Service Name:  CCMN97S
**
** Description:   This service will DELETE all rows from the TODO table
**                for the ID TODOs given as input.  This service was
**                created to allow BLOCK DELETE of TODOs on the Staff Todo 
**                List window to be saved.  It has a call to only one DAM -
**                CCMN43D. (SIR #20179)
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/09/96
** 
** Programmer:    Elizabeth P. Crystal
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:53:54  $
**                      $Modtime:   02 May 1996 21:03:58  $
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
** Extern for version control table. - Commented out for DEVL testing.
*/






public class Ccmn97s {
    CCMN97SO CCMN97S(CCMN97SI ccmn97si) {
        CCMN97SO ccmn97so = new CCMN97SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables 
        
        int rc = FND_SUCCESS;
        int usRow = 0;/* Loop counter */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccmn97si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        /*
        ** Perform Main Processing - CCMN43D
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN43DInputRec = new CCMN43DI();
        
        pCCMN43DOutputRec = new CCMN43DO();
        rc = WtcHelperConstants.SQL_SUCCESS;
        
        /*
        ** While more rows are left to process and rc is zero,
        ** continue loop.
        */
        while ((usRow < ccmn97si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
            pCCMN43DInputRec.setArchInputStruct(ccmn97si.getArchInputStruct());
            pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            pCCMN43DInputRec.setLdIdTodo(ccmn97si.getLdIdTodo_ARRAY().getLdIdTodo(usRow));
            pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(0, 147);
            pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(1, 112);
            pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(2, 12);
            pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(3, 31);
            pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(4, 1);
            pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(5, 0);
            pCCMN43DInputRec.getTsLastUpdate_ARRAY().setTsLastUpdate(6, 0);
            rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(ccmn97si.getArchInputStruct() , ccmn97so.getArchOutputStruct());
        
        /*
        ** Set fields in CCFC03SO to fields in CCMNG2DO
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
            
        }
        return ccmn97so;
    }

}
