package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV96SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV96SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSESA4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSESA4DO;
/**************************************************************************
**
** Module File:   CINV96S.SRC
**
** Service Name:  CINV96S
**
** Description: This service is used in the Licensing Invst Conclusion
**              page to validate Facility ID's against the Class DB
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/4/04
**
** Programmer:    Carolyn Douglass
**
** Change History:
** Date      User      Description
** --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv96s {
    public static final int NULL_DATE = - 1;
    CINV96SO CINV96S(CINV96SI cinv96si) {
        CINV96SO cinv96so = new CINV96SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLGetDateAndTime(cinv96so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Set CCMN01UI DtEventOccurred to current system date
        */
        rc = CallCSESA4D(cinv96si, cinv96so, pServiceStatus);
        
        switch (rc) {
                
                //  Success Case for Dam CSES68D
            case WtcHelperConstants.ARC_SUCCESS:
                
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                sprintf(pReturnPB->appl_status.explan_data,
                //##                        "%u",
                //##                        usRow);
                
                break;
                
                //  SQL Not Found Case for Dam CSES68D
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                
                //  Call Post Event function
                
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                sprintf(pReturnPB->appl_status.explan_data,
                //##                        "%u",
                //##                        usRow);
                
                break;
                //  SQL Not Found for DAM CSES75D
            case Messages.MSG_TOO_MANY_ROWS_RETURNED:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_TOO_MANY_ROWS_RETURNED;
                rc = Messages.MSG_TOO_MANY_ROWS_RETURNED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
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
        
        return cinv96so;
    }

    static int CallCSESA4D(CINV96SI pInputMsg800, CINV96SO pOutputMsg745, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSESA4DI pCSESA4DInputRec = null;
        CSESA4DO pCSESA4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSESA4DInputRec = new CSESA4DI();
        pCSESA4DOutputRec = new CSESA4DO();
        pCSESA4DInputRec.setArchInputStruct(pInputMsg800.getArchInputStruct());
        pCSESA4DInputRec.setLNbrRsrcFacilAcclaim(pInputMsg800.getLNbrRsrcFacilAcclaim());
        pCSESA4DInputRec.setLNbrAgency(pInputMsg800.getLNbrAgency());
        pCSESA4DInputRec.setLNbrBranch(pInputMsg800.getLNbrBranch());
        pCSESA4DInputRec.setCIndAgencyHome(pInputMsg800.getCIndAgencyHome());
        rc = csesa4dQUERYdam(sqlca, pCSESA4DInputRec, pCSESA4DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                {
                    pOutputMsg745.getROWCINV96SOG01().setSzNmResource(pCSESA4DOutputRec.getSzNmClassFacility());
                    pOutputMsg745.getROWCINV96SOG01().setLNbrRsrcFacilAcclaim(pCSESA4DOutputRec.getLNbrRsrcFacilAcclaim());
                    pOutputMsg745.getROWCINV96SOG01().setLNbrAgency(pCSESA4DOutputRec.getLNbrAgency());
                    pOutputMsg745.getROWCINV96SOG01().setLNbrBranch(pCSESA4DOutputRec.getLNbrBranch());
                    pOutputMsg745.getROWCINV96SOG01().setUlIdClassFclty(pCSESA4DOutputRec.getUlIdClassFclty());
                }
                break;
            case Messages.MSG_TOO_MANY_ROWS_RETURNED:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_TOO_MANY_ROWS_RETURNED;
                
                //  Call DAM
                rc = Messages.MSG_TOO_MANY_ROWS_RETURNED;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
