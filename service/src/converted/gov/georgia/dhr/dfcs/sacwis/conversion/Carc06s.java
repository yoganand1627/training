package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN24DO;
/**************************************************************************
** 
** Module File:   carc06s.src
**
** Service Name:  CARC06S - REPORT LIST RETRIEVE
**
** Description:   This service will retrieve a list of all reports to be
**		  diplayed on the Report List window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/10/96
** 
** Programmer:    John Vencill
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:24:48  $
**                      $Modtime:   29 Mar 1996 23:49:34  $
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







public class Carc06s {
    CARC06SO CARC06S(CARC06SI carc06si) {
        CARC06SO carc06so = new CARC06SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;// Return code
        rc = ARC_PRFServiceStartTime_TUX(carc06si.getArchInputStruct());
        rc = CallCDYN24D(carc06si, carc06so, pServiceStatus);
        //  SIR 17534 - exit gracefully if the approval event is not found
        // Original code:
        // PROCESS_TUX_RC_ERROR_NOFREE;
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                if (ARC_UTLGetConfigEntry(carc06so.getSzSysTxtRptFullPath() , CONFIG_REPORTING_URL) != Arcutls.ARC_UTL_SUCCESS) {
                    pServiceStatus.explan_code = Messages.MSG_CANNOT_READ_PATH;
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                }
                break;
                
                // person may be in system but not in an active case
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
                //  PWO 1111: Removed case statement.
                // case SQL_NOT_FOUND:
                // pServiceStatus->severity    = FND_SEVERITY_ERROR;
                // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                // rc = MSG_CMN_TMSTAMP_MISMATCH;
                // break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        
        //  Stop performance timer for service
        ARC_PRFServiceStopTime_TUX(carc06si.getArchInputStruct() , carc06so.getArchOutputStruct());
        
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
        return carc06so;
    }

    static int CallCDYN24D(CARC06SI pInputMsg3, CARC06SO pOutputMsg3, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        int i3 = 0;
        //  Declare local variables
        CDYN24DI pCDYN24DInputRec = null;
        CDYN24DO pCDYN24DOutputRec = null;
        
        //  Allocate memory for Input and Output Structures
        pCDYN24DInputRec = new CDYN24DI();
        pCDYN24DOutputRec = new CDYN24DO();
        pCDYN24DInputRec.setUlIdPerson(pInputMsg3.getUlIdPerson());
        pCDYN24DInputRec.setCSysIndRptRtrvType(pInputMsg3.getCSysIndRptRtrvType());
        pCDYN24DOutputRec.getArchOutputStruct().setUlRowQty(0);
        pCDYN24DInputRec.setArchInputStruct(pInputMsg3.getArchInputStruct());
        rc = cdyn24dQUERYdam(sqlca, pCDYN24DInputRec, pCDYN24DOutputRec);
        
        
        //  Analyze return code
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i3 = 0;i3 < pCDYN24DOutputRec.getArchOutputStruct().getUlRowQty();++i3) {
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzTxtRptFullName(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzTxtRptFullName());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzTxtRptLstStatus(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzTxtRptLstStatus());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setDtDtRptLstGeneration(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getDtDtRptLstGeneration());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setDtDtRptLstRetainage(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getDtDtRptLstRetainage());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzTxtRptLstRuntimeName(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzTxtRptLstRuntimeName());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setUlIdRptList(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getUlIdRptList());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzNmRptSqrName(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzNmRptSqrName());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzNmRptSqrVer(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzNmRptSqrVer());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzTxtRptGenName(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzTxtRptGenName());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzNmRptOrientation(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzNmRptOrientation());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzNmRptTemplateName(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzNmRptTemplateName());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzNmRptType(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzNmRptType());
                    pOutputMsg3.getROWCARC06SOG_ARRAY().getROWCARC06SOG(i3).setSzTxtRptEmailOption(pCDYN24DOutputRec.getROWCDYN24DO_ARRAY().getROWCDYN24DO(i3).getSzTxtRptEmailOption());
                }
                pOutputMsg3.getArchOutputStruct().setUlRowQty(pCDYN24DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg3.getArchOutputStruct().setBMoreDataInd(pCDYN24DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                //  Call DAM
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        
        return rc;
    }

}
