package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CSYS03S.SRC
**
** Service Name:  CSYS03S - PERSON LIST
**
** Description:   Retrieves information for the Person List Box.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/15/94
** 
** Programmer:    MS   
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Csys03s {
    CSYS03SO CSYS03S(CSYS03SI csys03si) {
        CSYS03SO csys03so = new CSYS03SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(csys03si.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = Cinv01s.CallCINV34D(csys03si, csys03so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = ARC_UTLGetDateAndTime(csys03so.getDtDtContact() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(csys03si.getArchInputStruct() , csys03so.getArchOutputStruct());
        
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
        return csys03so;
    }

    
    static int CallCINV34D(CSYS03SI pInputMsg874, CSYS03SO pOutputMsg815, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i452 = 0;
        CINV34DI pCINV34DInputRec = null;
        CINV34DO pCINV34DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV34DInputRec = new CINV34DI();
        
        
        pCINV34DOutputRec = new CINV34DO();
        pCINV34DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg874.getArchInputStruct().getUsPageNbr());
        pCINV34DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg874.getArchInputStruct().getUlPageSizeNbr());
        pCINV34DInputRec.setUlIdStage(pInputMsg874.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(SVC_CD_TYPE_STAFF);
        rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg815.setArchOutputStruct(pCINV34DOutputRec.getArchOutputStruct());
                for (i452 = 0;i452 < pOutputMsg815.getArchOutputStruct().getUlRowQty();i452++) {
                    
                    if (0 != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i452).getUlIdPerson()) {
                        pOutputMsg815.getROWCSYS03SOG01_ARRAY().getROWCSYS03SOG01(i452).setSzNmPersonFull(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i452).getSzNmPersonFull());
                        pOutputMsg815.getROWCSYS03SOG01_ARRAY().getROWCSYS03SOG01(i452).setSzCdStagePersRole(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i452).getSzCdStagePersRole());
                        pOutputMsg815.getROWCSYS03SOG01_ARRAY().getROWCSYS03SOG01(i452).setSzCdStagePersRelInt(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i452).getSzCdStagePersRelInt());
                        pOutputMsg815.getROWCSYS03SOG01_ARRAY().getROWCSYS03SOG01(i452).setSzCdStagePersType(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i452).getSzCdStagePersType());
                        pOutputMsg815.getROWCSYS03SOG01_ARRAY().getROWCSYS03SOG01(i452).setUlIdPerson(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i452).getUlIdPerson());
                    }
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##         sprintf(pReturnPB->appl_status.explan_data,
                //##                 "%u",
                //##                 usInputRow);
                
                break;
                
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##         sprintf(pReturnPB->appl_status.explan_data,
                //##                 "%u",
                //##                 usInputRow);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

}
