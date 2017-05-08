package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS18DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CCON15S.src
**
** Service Name:  SBCNTR LIST RTRV
**
** Description:   This service will retrieve all resources that have 
**                been designated as subcontractors for the prime resource.
**                It will also retrieve all services for which the prime
**                resource may provide. 
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 16, 1995
** 
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:07:00  $
**                      $Modtime:   28 Mar 1996 22:29:52  $
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






public class Ccon15s {
    public static final int INITIAL_PAGE = 1;
    CCON15SO CCON15S(CCON15SI ccon15si) {
        CCON15SO ccon15so = new CCON15SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i197 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSS14DI pCLSS14DInputRec = null;
        CLSS14DO pCLSS14DOutputRec = null;
        
        CLSS18DI pCLSS18DInputRec = null;
        CLSS18DO pCLSS18DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccon15si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS18DInputRec = new CLSS18DI();
        
        pCLSS18DOutputRec = new CLSS18DO();
        pCLSS18DInputRec.setArchInputStruct(ccon15si.getArchInputStruct());
        pCLSS18DInputRec.setUIdRsrcLinkParent(ccon15si.getUIdRsrcLinkParent());
        pCLSS18DInputRec.getArchInputStruct().setUsPageNbr(ccon15si.getArchInputStruct().getUsPageNbr());
        pCLSS18DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon15si.getArchInputStruct().getUlPageSizeNbr());
        
        /*
        ** Call DAM
        */
        rc = clss18dQUERYdam(sqlca, pCLSS18DInputRec, pCLSS18DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCON15SO to fields in CLSS18DO
                
                for (i197 = 0;i197 < pCLSS18DOutputRec.getArchOutputStruct().getUlRowQty();i197++) {
                    ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(i197).setSzCdRsrcLinkService(pCLSS18DOutputRec.getROWCLSS18DO_ARRAY().getROWCLSS18DO(i197).getSzCdRsrcLinkService());
                    ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(i197).setSzNmResource(pCLSS18DOutputRec.getROWCLSS18DO_ARRAY().getROWCLSS18DO(i197).getSzNmResource());
                    ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(i197).setTsLastUpdate(pCLSS18DOutputRec.getROWCLSS18DO_ARRAY().getROWCLSS18DO(i197).getTsSysTsLastUpdate2());
                    ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(i197).setUIdRsrcLink(pCLSS18DOutputRec.getROWCLSS18DO_ARRAY().getROWCLSS18DO(i197).getUIdRsrcLink());
                    ccon15so.getROWCCON15SOG00_ARRAY().getROWCCON15SOG00(i197).setUIdRsrcLinkChild(pCLSS18DOutputRec.getROWCLSS18DO_ARRAY().getROWCLSS18DO(i197).getUIdRsrcLinkChild());
                }
                ccon15so.getArchOutputStruct().setBMoreDataInd(pCLSS18DOutputRec.getArchOutputStruct().getBMoreDataInd());
                ccon15so.getArchOutputStruct().setUlRowQty(pCLSS18DOutputRec.getArchOutputStruct().getUlRowQty());
                
                if (FND_YES == ccon15si.getBSysIndSbcntrPredisplay()) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCLSS14DInputRec = new CLSS14DI();
                    
                    pCLSS14DOutputRec = new CLSS14DO();
                    pCLSS14DInputRec.setArchInputStruct(ccon15si.getArchInputStruct());
                    pCLSS14DInputRec.setUlIdResource(ccon15si.getUIdRsrcLinkParent());
                    pCLSS14DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon15si.getUlPageSizeNbr());
                    //  Populate output message
                    
                    rc = clss14dQUERYdam(sqlca, pCLSS14DInputRec, pCLSS14DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            
                            //  Populate Output Message
                            
                            //  Set fields in CCON15SO to fields in CLSS14DO
                            
                            
                            for (i197 = 0;i197 < pCLSS14DOutputRec.getArchOutputStruct().getUlRowQty();i197++) {
                                ccon15so.getROWCCON15SOG01_ARRAY().getROWCCON15SOG01(i197).setSzCdRsrcSvcService(pCLSS14DOutputRec.getROWCLSS14DO_ARRAY().getROWCLSS14DO(i197).getSzCdRsrcSvcService());
                            }
                            ccon15so.setUlRowQty(pCLSS14DOutputRec.getArchOutputStruct().getUlRowQty());
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
                }
                //  Do nothing, the output message just returns success or failure
                break;
            default :// For CLSS18D
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon15si.getArchInputStruct() , ccon15so.getArchOutputStruct());
        
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
        return ccon15so;
    }

}
