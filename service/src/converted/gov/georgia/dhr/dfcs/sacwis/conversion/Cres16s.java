package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES16SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES40DO;
/**************************************************************************
** 
** Module File:   CRES16S.src
**
** Service Name:  CRES16S
**
** Description:   This is a list service that retrieves all of the 
**                  school districts for a particular county passed
**                  from the Resource Address window (CRES09W) window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  06/28/95 
** 
** Programmer:    Jason W. Gloor
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:23:34  $
**                      $Modtime:   05 Aug 1996 16:49:24  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                       added the lines.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres16s {
    CRES16SO CRES16S(CRES16SI cres16si) {
        CRES16SO cres16so = new CRES16SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = ARC_PRFServiceStartTime_TUX(cres16si.getArchInputStruct());
        rc = CallCRES40D(cres16si, cres16so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
                //##      case ARC_ERR_SQL_ERROR:
                //##      break;
                
                //   PROCESS_TUX_RC_ERROR is called only when there is an unexpected error
                // returned from the callDAM function.
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cres16si.getArchInputStruct() , cres16so.getArchOutputStruct());
        
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
        return cres16so;
    }

    static int CallCRES40D(CRES16SI pInputMsg824, CRES16SO pOutputMsg771, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i414 = 0;
        
        /*
        ** Declare local variables
        */
        CRES40DI pCRES40DInputRec = null;
        CRES40DO pCRES40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES40DInputRec = new CRES40DI();
        pCRES40DOutputRec = new CRES40DO();
        pCRES40DInputRec.setSzScrAddrGenericAddrCnty2(pInputMsg824.getSzScrAddrGenericAddrCnty2());
        pCRES40DInputRec.setArchInputStruct(pInputMsg824.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Set CCFC26SO WCD DtSystemDate to current date
        */
        rc = cres40dQUERYdam(sqlca, pCRES40DInputRec, pCRES40DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i414 = 0;i414 < pCRES40DOutputRec.getArchOutputStruct().getUlRowQty();++i414) {
                    pOutputMsg771.getROWCRES16SOG_ARRAY().getROWCRES16SOG(i414).setSzTxtSchDistName(pCRES40DOutputRec.getROWCRES40DO_ARRAY().getROWCRES40DO(i414).getSzTxtSchDistName());
                    pOutputMsg771.getROWCRES16SOG_ARRAY().getROWCRES16SOG(i414).setSzCdRsrcAddrSchDist(pCRES40DOutputRec.getROWCRES40DO_ARRAY().getROWCRES40DO(i414).getSzCdSchDist());
                }
                pOutputMsg771.getArchOutputStruct().setUlRowQty(pCRES40DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg771.getArchOutputStruct().setBMoreDataInd(pCRES40DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
