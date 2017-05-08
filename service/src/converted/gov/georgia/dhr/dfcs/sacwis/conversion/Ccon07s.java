package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS09DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CCON07S.src
**
** Service Name:   CCON07S
**
** Description:   This service will retrieve all rows for an Id
**                Contract and Period Number from the Contract
**                Version table.  
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/11/1995 
** 
** Programmer:    GLOORJW
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:03:48  $
**                      $Modtime:   28 Mar 1996 22:28:32  $
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






public class Ccon07s {
    CCON07SO CCON07S(CCON07SI ccon07si) {
        CCON07SO ccon07so = new CCON07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code  */
        int i193 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSS09DI pCLSS09DInputRec = null;
        CLSS09DO pCLSS09DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccon07si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccon07so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS09DInputRec = new CLSS09DI();
        
        pCLSS09DOutputRec = new CLSS09DO();
        pCLSS09DInputRec.setArchInputStruct(ccon07si.getArchInputStruct());
        pCLSS09DInputRec.setUlIdContract(ccon07si.getUlIdContract());
        pCLSS09DInputRec.setUlNbrCnverPeriod(ccon07si.getUlNbrCnverPeriod());
        pCLSS09DInputRec.getArchInputStruct().setUsPageNbr(ccon07si.getArchInputStruct().getUsPageNbr());
        pCLSS09DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon07si.getArchInputStruct().getUlPageSizeNbr());
        
        /**************************************************************************
        ** Declare FOUNDATION variables 
        ***************************************************************************/
        
        
        /********** local variables **********************************************/
        
        
        /********** Start performance timer for service **************************/
        rc = clss09dQUERYdam(sqlca, pCLSS09DInputRec, pCLSS09DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCON07SO to fields in CLSS09DO
                for (i193 = 0;i193 < pCLSS09DOutputRec.getArchOutputStruct().getUlRowQty();i193++) {
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setUlNbrCnverVersion(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getUlNbrCnverVersion());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setUlIdCnver(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getUlIdCnver());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setDtDtCnverEffective(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getDtDtCnverEffective());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setDtDtCnverEnd(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getDtDtCnverEnd());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setDtDtCnverCreate(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getDtDtCnverCreate());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setUlNbrCnverNoShowPct(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getUlNbrCnverNoShowPct());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setCIndCnverVerLock(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getCIndCnverVerLock());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setSzTxtCnverComment(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getSzTxtCnverComment());
                    ccon07so.getROWCCON07SOG00_ARRAY().getROWCCON07SOG00(i193).setTsLastUpdate(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i193).getTsLastUpdate());
                }
                ccon07so.getArchOutputStruct().setUlRowQty(pCLSS09DOutputRec.getArchOutputStruct().getUlRowQty());
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
        ARC_PRFServiceStopTime_TUX(ccon07si.getArchInputStruct() , ccon07so.getArchOutputStruct());
        
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
        
        return ccon07so;
    }

    
}
