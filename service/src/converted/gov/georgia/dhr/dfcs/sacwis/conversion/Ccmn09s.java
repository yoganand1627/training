package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN09SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN21DO;
/**************************************************************************
** 
** Module File:   ccmn09s.src
**
** Service Name:  ccmn09s
**
** Description:   This service calls one dam:
**
** CCMN21D Dam: 
**                input:   1 variable:  IdOnCall                  
**               output:  12 variables: IdPerson, Nm Person Full, 
**                        Home Phone, Contact Order, OnCallDesig(nation), 
**                        Phone1, Ext1, Phone2, Ext2
**                        IdEmpOnCallLink, IdOnCall, tsLastUpdate
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/30/95 
** 
** Programmer:    Mary F. Sladewski
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:21:16  $
**                      $Modtime:   05 Aug 1996 16:49:02  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10Apr95   sladewmf  Initial check-in.
**  01May95   sladewmf  Made changes recommended by bennetta
**                      (code/technical review).
**  05May95   sladewmf  Made changes to match new error handling outlined
**                      in the May05 08:23 1995 version of svcshell.src 
**  06Jan96   bruckmk   SIR 1993: Get System Date and Time for return to 
**                      Client, since the Date should not be retrieved on 
**                      the client side.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                      added the line.
**
***************************************************************************/

/********** service include files *****************************************/



/*
** Extern for version control table.
*/






public class Ccmn09s {
    CCMN09SO CCMN09S(CCMN09SI ccmn09si) {
        CCMN09SO ccmn09so = new CCMN09SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(ccmn09si.getArchInputStruct());
        
        
        /*
        ** Call CSEC27D
        */
        rc = ARC_UTLGetDateAndTime(ccmn09so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Ccmn07s.CallCCMN21D(ccmn09si, ccmn09so, pServiceStatus);
        switch (rc) /* cmsc52d */
        {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* load translation map with service name and version */
        
        /* stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(ccmn09si.getArchInputStruct() , ccmn09so.getArchOutputStruct());
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
        return ccmn09so;
    }

    static int CallCCMN21D(CCMN09SI pInputMsg223, CCMN09SO pOutputMsg204, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i127 = 0;
        /* local variables */
        CCMN21DI pCCMN21DInputRec = null;
        CCMN21DO pCCMN21DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN21DInputRec = new CCMN21DI();
        
        pCCMN21DOutputRec = new CCMN21DO();
        pCCMN21DInputRec.setArchInputStruct(pInputMsg223.getArchInputStruct());
        pCCMN21DInputRec.getROWCCMN21DI().setUlIdOnCall(pInputMsg223.getROWCCMN21DI().getUlIdOnCall());
        
        /*
        ** Call DAM
        */
        rc = ccmn21dQUERYdam(sqlca, pCCMN21DInputRec, pCCMN21DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze error code
            
            switch (rc) {
                    
                    //  SQL Not Found Case for Dam CSES68D (AOC)
                case NO_DATA_FOUND:
                    //  Do nothing on success
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            rc = WtcHelperConstants.ARC_SUCCESS;
            
            for (i127 = 0;i127 < pCCMN21DOutputRec.getArchOutputStruct().getUlRowQty();++i127) {
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setUlIdPerson(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getUlIdPerson());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setSzNmPersonFull(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getSzNmPersonFull());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setLNbrPhone(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getLNbrPhone());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setUsNbrEmpOnCallCntctOrd(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getUsNbrEmpOnCallCntctOrd());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setSzCdEmpOnCallDesig(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getSzCdEmpOnCallDesig());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setSzNbrEmpOnCallPhone1(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getSzNbrEmpOnCallPhone1());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setLNbrEmpOnCallExt1(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getLNbrEmpOnCallExt1());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setSzNbrEmpOnCallPhone2(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getSzNbrEmpOnCallPhone2());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setLNbrEmpOnCallExt2(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getLNbrEmpOnCallExt2());
                
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setUlIdEmpOnCallLink(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getUlIdEmpOnCallLink());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setUlIdOnCall(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getUlIdOnCall());
                pOutputMsg204.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).setTsLastUpdate(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i127).getTsLastUpdate());
            }
            pOutputMsg204.getArchOutputStruct().setUlRowQty(pCCMN21DOutputRec.getArchOutputStruct().getUlRowQty());
        }
        
        return rc;
    }

}
