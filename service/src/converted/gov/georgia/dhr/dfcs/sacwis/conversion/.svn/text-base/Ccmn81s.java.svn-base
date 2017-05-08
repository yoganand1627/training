package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB1DO;
public class Ccmn81s {
    public static final int MSG_ARC_MSG_BUFFER_SMALL = 100;
    CCMN81SO CCMN81S(CCMN81SI ccmn81si) {
        CCMN81SO ccmn81so = new CCMN81SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(ccmn81si.getArchInputStruct());
        rc = CallCCMNB1D(ccmn81si, ccmn81so, pServiceStatus);
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn81si.getArchInputStruct() , ccmn81so.getArchOutputStruct());
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
        return ccmn81so;
    }

    static int CallCCMNB1D(CCMN81SI pInputMsg355, CCMN81SO pOutputMsg325, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMNB1DI pCCMNB1DInputRec = null;
        CCMNB1DO pCCMNB1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB1DInputRec = new CCMNB1DI();
        pCCMNB1DOutputRec = new CCMNB1DO();
        pCCMNB1DInputRec.setUlIdCase(pInputMsg355.getCCMN81SG01().getUlIdCase());
        rc = ccmnb1dQUERYdam(sqlca, pCCMNB1DInputRec, pCCMNB1DOutputRec);
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR() }
        
        else {
            pOutputMsg325.setArchOutputStruct(pCCMNB1DOutputRec.getArchOutputStruct());
            pOutputMsg325.getSpecHD().setUlIdCase(pCCMNB1DOutputRec.getUlIdCase());
            
            pOutputMsg325.getSpecHD().setTsSysTsLastUpdate2(pCCMNB1DOutputRec.getTsSysTsLastUpdate2());
            pOutputMsg325.getSpecHD().setSzCdCaseSpeclHndlg(pCCMNB1DOutputRec.getSzCdCaseSpeclHndlg());
            pOutputMsg325.getSpecHD().setBIndCaseSensitive(pCCMNB1DOutputRec.getBIndCaseSensitive());
            pOutputMsg325.getSpecHD().setBIndCaseWorkerSafety(pCCMNB1DOutputRec.getBIndCaseWorkerSafety());
            pOutputMsg325.getSpecHD().setSzTxtCaseWorkerSafety(pCCMNB1DOutputRec.getSzTxtCaseWorkerSafety());
            pOutputMsg325.getSpecHD().setSzTxtCaseSensitiveCmnts(pCCMNB1DOutputRec.getSzTxtCaseSensitiveCmnts());
        }
        return rc;
    }

}
