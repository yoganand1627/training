package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON10S.src
**
** Service Name:  CCON10S
**
** Description:   This service saves changes made 
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 11, 1995
** 
** Programmer:    Louise J. Lee
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:04:26  $
**                      $Modtime:   28 Mar 1996 22:29:06  $
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






public class Ccon10s {
    CCON10SO CCON10S(CCON10SI ccon10si) {
        CCON10SO ccon10so = new CCON10SO();
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
        //##  short rc = FND_SUCCESS;
        
        CAUD06DI pCAUD06DInputRec = null;
        CAUD06DO pCAUD06DOutputRec = null;
        
        
        int usRow = 0;
        int usInputRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccon10si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCAUD06DInputRec = new CAUD06DI();
        
        pCAUD06DOutputRec = new CAUD06DO();
        
        while ((usRow < ccon10si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
            pCAUD06DInputRec.setArchInputStruct(ccon10si.getArchInputStruct());
            pCAUD06DInputRec.getArchInputStruct().setCReqFuncCd(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getSzCdScrDataAction());
            pCAUD06DInputRec.setUlIdCntrctWkr(ccon10si.getUlIdCntrctWkr());
            pCAUD06DInputRec.setUlIdCnsvc(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlIdCnsvc());
            pCAUD06DInputRec.setUlAmtCnsvcEquip(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlAmtCnsvcEquip());
            pCAUD06DInputRec.setUlAmtCnsvcFrgBenft(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlAmtCnsvcFrgBenft());
            pCAUD06DInputRec.setUlAmtCnsvcSalary(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlAmtCnsvcSalary());
            pCAUD06DInputRec.setUlAmtCnsvcSupply(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlAmtCnsvcSupply());
            pCAUD06DInputRec.setUlAmtCnsvcTravel(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlAmtCnsvcTravel());
            pCAUD06DInputRec.setUlAmtCnsvcOther(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlAmtCnsvcOther());
            pCAUD06DInputRec.setUlAmtCnsvcUnitRate(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getUlAmtCnsvcUnitRate());
            pCAUD06DInputRec.setTsLastUpdate(ccon10si.getROWCCON10SIG00_ARRAY().getROWCCON10SIG00(usRow).getTsLastUpdate());
            rc = caud06dAUDdam(sqlca, pCAUD06DInputRec, pCAUD06DOutputRec);
            
            //  Analyze error code
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
                    
                    // 
                    // GET SUPERVISOR END WITH CCMN60D ENDING RETURN TO 
                    // CCMN19D RC ANALYSIS WITH CASE DEFAULT
                    // 
                    
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
        ARC_PRFServiceStopTime_TUX(ccon10si.getArchInputStruct() , ccon10so.getArchOutputStruct());
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
        return ccon10so;
    }

}
