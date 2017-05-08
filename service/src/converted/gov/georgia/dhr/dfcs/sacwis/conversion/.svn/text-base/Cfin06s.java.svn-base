package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS75DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:    CFIN06S.SRC
**
** Service Name:   CFIN06S - DELV SVC DTL RTRV
**
** Description:   This service will retrieve records from the Delivered
**                Service Detail table for a given Invoice ID.  It will also
**                retrieve all service codes for a given Contract ID.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 18, 1995
**
** Programmer:    Danny Gillespie
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   06 Aug 1997 18:19:04  $
**                      $Modtime:   06 Aug 1997 17:50:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/25/97  CHESSMTL  We will now call clss75d.pc rather than clss13d.pc
**                      See the comments in clss75d.pc for explanation.
**
** 04/26/05   MALPANS   SIR 23475 -statically setting the pageno to 1 and
**						pagesizenbr to 100 to fix paginating problem with the
**						service codes.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin06s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final char REQ_FUNC_CD_FIRST_TIME = 'F';
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String NULL_STRING = "";
    CFIN06SO CFIN06S(CFIN06SI cfin06si) {
        CFIN06SO cfin06so = new CFIN06SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i224 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        int rowQty = 0;
        
        CDYN11DI pCDYN11DInputRec = null;
        CDYN11DO pCDYN11DOutputRec = null;
        
        CLSS75DI pCLSS75DInputRec = null;
        CLSS75DO pCLSS75DOutputRec = null;
        
        /* SIR 23223 - this populates the szCdRsrcFacilType variable */
        rc = ARC_PRFServiceStartTime_TUX(cfin06si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /**************************************************************************
        ** BEGIN: CDYN11D
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCDYN11DInputRec = new CDYN11DI();
        
        pCDYN11DOutputRec = new CDYN11DO();
        
        /*
        ** SIR 1096 - Include references to DAMs CCMNG5D and CCMNG6D
        */
        pCDYN11DInputRec.setArchInputStruct(cfin06si.getArchInputStruct());
        pCDYN11DInputRec.setSzSysCdSvcDtlSortType(cfin06si.getSzSysCdSvcDtlSortType());
        pCDYN11DInputRec.setUlIdContract(cfin06si.getUlIdContract());
        
        pCDYN11DInputRec.setUlIdInvoInvoice(cfin06si.getUlIdInvoInvoice());
        pCDYN11DInputRec.getArchInputStruct().setUsPageNbr(cfin06si.getArchInputStruct().getUsPageNbr());
        pCDYN11DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin06si.getArchInputStruct().getUlPageSizeNbr());
        
        /* Update NBR_RSRC_OPEN_SLOTS */
        rc = cdyn11dQUERYdam(sqlca, pCDYN11DInputRec, pCDYN11DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CFIN06SO to fields in CDYN11DO
                
                for (i224 = 0;i224 < pCDYN11DOutputRec.getArchOutputStruct().getUlRowQty();i224++) {
                    
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setSzCdSvcDtlLiType(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getSzCdSvcDtlLiType());
                    
                    //  SIR 1265 - Added prototypes for IsDateNull() and CallCCMNH2D()
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setSzCdSvcDtlService(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getSzCdSvcDtlService());
                    
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setSzCdSvcDtlUnitType(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getSzCdSvcDtlUnitType());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setSzCdSvcDtlCounty(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getSzCdSvcDtlCounty());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setSzScrNmGenericFullName(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getSzNmPersonFull());
                    
                    // 
                    // APT 06/12/2001 BEGIN SECURITY UPGRADE
                    // Add prototypes for CallCAUDE2D()
                    // 
                    
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setSzCdCnsvcPaymentType(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getSzCdCnsvcPaymentType());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setTsLastUpdate(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getTsLastUpdate());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setDAmtSvcDtlFeePaid(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getDAmtSvcDtlFeePaid());
                    
                    // 
                    // APT 06/12/2001 END SECURITY UPGRADE
                    // 
                    
                    
                    
                    //  SIR 2593 - Added prototypes for CallCCMNH4D() and CCMNH5D()
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setDAmtSvcDtlUnitRate(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getDAmtSvcDtlUnitRate());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setUlIdPerson(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getUlIdPerson());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setUlIdSvcDtl(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getUlIdSvcDtl());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setUlIdSvcAuthDtl(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getUlIdSvcAuthDtl());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setUMoSvcDtlSvcMonth(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getUMoSvcDtlSvcMonth());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setUYrSvcDtlServiceYear(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getUYrSvcDtlServiceYear());
                    
                    // SIR 23196
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setUsNbrSvcDtlCsli(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getUsNbrSvcDtlCsli());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setSNbrSvcDtlUnitQty(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getSNbrSvcDtlUnitQty());
                    cfin06so.getROWCFIN06SOG_ARRAY().getROWCFIN06SOG(i224).setCIndSvcDtlRejItem(pCDYN11DOutputRec.getROWCDYN11DO_ARRAY().getROWCDYN11DO(i224).getCIndSvcDtlRejItem());
                }
                
                //## BEGIN TUX/XML: Declare XML variables
                cfin06so.getArchOutputStruct().setBMoreDataInd(pCDYN11DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfin06so.getArchOutputStruct().setUlRowQty(pCDYN11DOutputRec.getArchOutputStruct().getUlRowQty());
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
        if (REQ_FUNC_CD_FIRST_TIME == cfin06si.getArchInputStruct().getCReqFuncCd()) /*
        ** Populate Output Message
        */
        {
            
            // 
            // BEGIN: CLSS75D
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCLSS75DInputRec = new CLSS75DI();
            
            pCLSS75DOutputRec = new CLSS75DO();
            pCLSS75DInputRec.setArchInputStruct(cfin06si.getArchInputStruct());
            pCLSS75DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCLSS75DInputRec.getArchInputStruct().setUlPageSizeNbr(100);
            pCLSS75DInputRec.setUlIdContract(cfin06si.getUlIdContract());
            rc = clss75dQUERYdam(sqlca, pCLSS75DInputRec, pCLSS75DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFIN06SO to fields in CLSS75DO
                    
                    
                    for (i224 = 0;i224 < CFIN06SO._CFIN06SO__SZCDSVCDTLSERVICE_SIZE && 0 != NULL_STRING.compareTo(pCLSS75DOutputRec.getROWCLSS75DO_ARRAY().getROWCLSS75DO(i224).getSzCdCnsvcService());i224++) {
                        cfin06so.getSzCdSvcDtlService_ARRAY().setSzCdSvcDtlService(i224, pCLSS75DOutputRec.getROWCLSS75DO_ARRAY().getROWCLSS75DO(i224).getSzCdCnsvcService());
                    }
                    
                    
                    //Set the rowQty to i to pass it to marshal function - Srini
                    rowQty = i224;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CON_NO_SVC_CODE;
                    
                    //  Call CSES38D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
                    
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin06si.getArchInputStruct() , cfin06so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  Analyze error code
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
        return cfin06so;
    }

}
