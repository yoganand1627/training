package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC20DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CCON21S.src
**
** Service Name:  Service List Retrieve
**
** Description:   This service will retrieve a list of Service Authorization
**                Detail records based upon IdSvcAuth from the Service 
**                Authorization Detail window. It will also retrieve 
**                NmPersonFull based upon IdPerson from the Person table.
**
**                It will call DAM CLSC20D - SVC AUTH LIST RTRV
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2 October 1995 
** 
** Programmer:    Brian McRae
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Sep 1996 17:56:04  $
**                      $Modtime:   12 Sep 1996 13:50:10  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/26/95  FOGARTIS  Fixed references to changed C name for Amt Req FLD.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon21s {
    CCON21SO CCON21S(CCON21SI ccon21si) {
        CCON21SO ccon21so = new CCON21SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i202 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CLSC20DI pCLSC20DIInputRec = null;
        CLSC20DO pCLSC20DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccon21si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC20DIInputRec = new CLSC20DI();
        
        pCLSC20DOutputRec = new CLSC20DO();
        pCLSC20DIInputRec.setArchInputStruct(ccon21si.getArchInputStruct());
        pCLSC20DIInputRec.setUlIdSvcAuth(ccon21si.getUlIdSvcAuth());
        pCLSC20DIInputRec.getArchInputStruct().setUsPageNbr(ccon21si.getArchInputStruct().getUsPageNbr());
        pCLSC20DIInputRec.getArchInputStruct().setUlPageSizeNbr(ccon21si.getArchInputStruct().getUlPageSizeNbr());
        
        /*
        ** Start Performance Timer
        */
        rc = clsc20dQUERYdam(sqlca, pCLSC20DIInputRec, pCLSC20DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCON21SO to fields in CLSC20DO
                
                for (i202 = 0;i202 < pCLSC20DOutputRec.getArchOutputStruct().getUlRowQty();i202++) {
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setSzCdSvcAuthDtlAuthType(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getSzCdSvcAuthDtlAuthType());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setSzCdSvcAuthDtlSvc(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getSzCdSvcAuthDtlSvc());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setSzNmPersonFull(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getSzNmPersonFull());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setDtDtSvcAuthDtlBegin(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getDtDtSvcAuthDtlBegin());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setDtDtSvcAuthDtlEnd(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getDtDtSvcAuthDtlEnd());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setDtDtSvcAuthDtlTerm(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getDtDtSvcAuthDtlTerm());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setLAmtSvcAuthDtlAmtReq(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getLAmtSvcAuthDtlAmtReq());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setLNbrSvcAuthDtlUnitReq(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getLNbrSvcAuthDtlUnitReq());
                    ccon21so.getROWCCON21SOG00_ARRAY().getROWCCON21SOG00(i202).setUlIdSvcAuthDtl(pCLSC20DOutputRec.getROWCLSC20DO_ARRAY().getROWCLSC20DO(i202).getUlIdSvcAuthDtl());
                }
                ccon21so.getArchOutputStruct().setBMoreDataInd(pCLSC20DOutputRec.getArchOutputStruct().getBMoreDataInd());
                ccon21so.getArchOutputStruct().setUlRowQty(pCLSC20DOutputRec.getArchOutputStruct().getUlRowQty());
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
        ARC_PRFServiceStopTime_TUX(ccon21si.getArchInputStruct() , ccon21so.getArchOutputStruct());
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
        return ccon21so;
    }

}
