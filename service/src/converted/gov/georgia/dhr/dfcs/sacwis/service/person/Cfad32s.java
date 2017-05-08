package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS57DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CFAD32S.src
**                
** Service Name:  CFAD32S
**
** Description:   This service will call a DAM to retrieve all FA Home
**							  Member Training rows where IdPerson equals the IdPerson
**							  passed into the service.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 29, 1995 
** 
** Programmer:    Stephen Parks
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:16:22  $
**                      $Modtime:   30 Mar 1996 00:09:26  $
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






public class Cfad32s {
    CFAD32SO CFAD32S(CFAD32SI cfad32si) {
        CFAD32SO cfad32so = new CFAD32SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i214 = 0;
        
        /*                             
        ** Declare FOUNDATION variables 
        */
        
        /*         
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSS57DI pCLSS57DInputRec = null;
        CLSS57DO pCLSS57DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfad32si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cfad32so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS57DInputRec = new CLSS57DI();
        
        pCLSS57DOutputRec = new CLSS57DO();
        pCLSS57DInputRec.setArchInputStruct(cfad32si.getArchInputStruct());
        pCLSS57DInputRec.setUlIdPerson(cfad32si.getUlIdPerson());
        pCLSS57DInputRec.getArchInputStruct().setUsPageNbr(cfad32si.getArchInputStruct().getUsPageNbr());
        pCLSS57DInputRec.getArchInputStruct().setUlPageSizeNbr(cfad32si.getArchInputStruct().getUlPageSizeNbr());
        
        /*
        ** Call CSES82D
        */
        rc = clss57dQUERYdam(sqlca, pCLSS57DInputRec, pCLSS57DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Populate Output Message
                
                //  Set fields in CFAD32SO to fields in CLSS57DO
                
                
                for (i214 = 0;i214 < pCLSS57DOutputRec.getArchOutputStruct().getUlRowQty();i214++) {
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setUlIdIndivTraining(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getUlIdIndivTraining());
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setTsLastUpdate(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getTsLastUpdate());
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setSzCdIndivTrnType(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getSzCdIndivTrnType());
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setDtDtIndivTrn(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getDtDtIndivTrn());
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setCIndIndivTrnEc(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getCIndIndivTrnEc());
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setLdNbrIndivTrnHrs(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getLdNbrIndivTrnHrs());
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setSNbrIndivTrnSession(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getSNbrIndivTrnSession());
                    cfad32so.getCFAD32SOG00_ARRAY().getCFAD32SOG00(i214).setSzTxtIndivTrnTitle(pCLSS57DOutputRec.getROWCLSS57DO_ARRAY().getROWCLSS57DO(i214).getSzTxtIndivTrnTitle());
                }
                cfad32so.getArchOutputStruct().setBMoreDataInd(pCLSS57DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfad32so.getArchOutputStruct().setUlRowQty(pCLSS57DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(cfad32si.getArchInputStruct() , cfad32so.getArchOutputStruct());
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
        return cfad32so;
    }

}
