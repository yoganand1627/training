package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES07SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES09DO;
/**************************************************************************
** 
** Module File:   CRES07S.src
**
** Service Name:  CRES07S
**
** Description:   This is the retrieval service that gets all
**                characteristics data from the RESOURCE_CHRCTR table
**                given a resource service ID.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  07/27/95 
** 
** Programmer:    Jason W. Gloor
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:23:26  $
**                      $Modtime:   05 Aug 1996 16:49:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I 
**                        added the lines.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres07s {
    CRES07SO CRES07S(CRES07SI cres07si) {
        CRES07SO cres07so = new CRES07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cres07si.getArchInputStruct());
        rc = CallCRES09D(cres07si, cres07so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                
                
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
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
        ARC_PRFServiceStopTime_TUX(cres07si.getArchInputStruct() , cres07so.getArchOutputStruct());
        
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
                
                //  Call Retrieve DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cres07so;
    }

    static int CallCRES09D(CRES07SI pInputMsg816, CRES07SO pOutputMsg763, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i409 = 0;
        
        /*
        ** Declare local variables
        */
        CRES09DI pCRES09DInputRec = null;
        CRES09DO pCRES09DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES09DInputRec = new CRES09DI();
        pCRES09DOutputRec = new CRES09DO();
        pCRES09DInputRec.setUlIdResourceService(pInputMsg816.getUlIdResourceService());
        pCRES09DInputRec.setArchInputStruct(pInputMsg816.getArchInputStruct());
        rc = cres09dQUERYdam(sqlca, pCRES09DInputRec, pCRES09DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i409 = 0;i409 < pCRES09DOutputRec.getArchOutputStruct().getUlRowQty();++i409) {
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setUlIdResourceChrctr(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getUlIdResourceChrctr());
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setTsLastUpdate(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getTsLastUpdate());
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setSzCdRsrcCharChrctr(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getSzCdRsrcCharChrctr());
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setCCdRsrcCharSex(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getCCdRsrcCharSex());
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setUNbrRsrcCharMinMAge(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getUNbrRsrcCharMinMAge());
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setUNbrRsrcCharMaxMAge(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getUNbrRsrcCharMaxMAge());
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setUNbrRsrcCharMinFAge(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getUNbrRsrcCharMinFAge());
                    pOutputMsg763.getROWCRES07SOG_ARRAY().getROWCRES07SOG(i409).setUNbrRsrcCharMaxFAge(pCRES09DOutputRec.getROWCRES09DO_ARRAY().getROWCRES09DO(i409).getUNbrRsrcCharMaxFAge());
                }
                pOutputMsg763.getArchOutputStruct().setUlRowQty(pCRES09DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg763.getArchOutputStruct().setBMoreDataInd(pCRES09DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
