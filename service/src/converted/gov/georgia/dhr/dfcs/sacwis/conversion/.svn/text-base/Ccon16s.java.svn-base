package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD26DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON16S.src
**
** Service Name:  SBCNTR LIST SAVE
**
** Description:   This service will perform an add, update and/or delete
**                to the Resource Link table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 16, 1995
** 
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:07:16  $
**                      $Modtime:   28 Mar 1996 22:30:04  $
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






public class Ccon16s {
    CCON16SO CCON16S(CCON16SI ccon16si) {
        CCON16SO ccon16so = new CCON16SO();
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
        //##  short rc = FND_SUCCESS;
        
        CAUD26DI pCAUD26DInputRec = null;
        CAUD26DO pCAUD26DOutputRec = null;
        
        
        int usRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccon16si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD26DInputRec = new CAUD26DI();
        
        pCAUD26DOutputRec = new CAUD26DO();
        
        
        while (usRow < ccon16si.getArchInputStruct().getUlPageSizeNbr() && SUCCESS == pServiceStatus.explan_code) {
            pCAUD26DInputRec.setArchInputStruct(ccon16si.getArchInputStruct());
            pCAUD26DInputRec.getArchInputStruct().setCReqFuncCd(ccon16si.getROWCCON16SIG00_ARRAY().getROWCCON16SIG00(usRow).getSzCdScrDataAction());
            pCAUD26DInputRec.setSzCdRsrcLinkService(ccon16si.getROWCCON16SIG00_ARRAY().getROWCCON16SIG00(usRow).getSzCdRsrcLinkService());
            pCAUD26DInputRec.setSzCdRsrcLinkType(ccon16si.getROWCCON16SIG00_ARRAY().getROWCCON16SIG00(usRow).getSzCdRsrcLinkType());
            pCAUD26DInputRec.setTsLastUpdate(ccon16si.getROWCCON16SIG00_ARRAY().getROWCCON16SIG00(usRow).getTsLastUpdate());
            pCAUD26DInputRec.setUIdRsrcLink(ccon16si.getROWCCON16SIG00_ARRAY().getROWCCON16SIG00(usRow).getUIdRsrcLink());
            pCAUD26DInputRec.setUIdRsrcLinkChild(ccon16si.getROWCCON16SIG00_ARRAY().getROWCCON16SIG00(usRow).getUIdRsrcLinkChild());
            pCAUD26DInputRec.setUIdRsrcLinkParent(ccon16si.getROWCCON16SIG00_ARRAY().getROWCCON16SIG00(usRow).getUIdRsrcLinkParent());
            
            // Call DAM
            rc = caud26dAUDdam(sqlca, pCAUD26DInputRec, pCAUD26DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:// CAUD20D
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
            usRow++;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon16si.getArchInputStruct() , ccon16so.getArchOutputStruct());
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
        
        return ccon16so;
    }

}
