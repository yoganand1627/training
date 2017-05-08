package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS75DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CFIN15S.src
**
** Service Name:   CFIN15S
**
** Description:   This service will retieve all records from the ADMIN DTL 
**                table that have an ID INVOICE = to the one passed into the
**                service.  Additionally, this service will retrieve all the 
**                services of a contract.  CLSS13D will be called only on 
**                the initial call to this service - SYS CARC RQST FUNC CD,
**                stored in the input architecture record group, will indicate
**                whether to call CLSS13D. 
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11-14-1995 
** 
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1997 18:19:22  $
**                      $Modtime:   06 Aug 1997 17:51:16  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/10/96  GLOORJW   Removed references to Obj and Pac variables
**  07/25/97  CHESSMTL  We will now call clss75d.pc rather than clss13d.pc
**                      See the comments in clss75d.pc for explanation.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin15s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char REQ_FUNC_CD_DTLS_CDS = 'C';
    public static final int FIN_SVC_CD_PAGE_SIZE = 50;
    CFIN15SO CFIN15S(CFIN15SI cfin15si) {
        CFIN15SO cfin15so = new CFIN15SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i229 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CLSS36DI pCLSS36DInputRec = null;
        CLSS36DO pCLSS36DOutputRec = null;
        CLSS75DI pCLSS75DInputRec = null;
        CLSS75DO pCLSS75DOutputRec = null;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(cfin15si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS36DInputRec = new CLSS36DI();
        
        pCLSS36DOutputRec = new CLSS36DO();
        pCLSS36DInputRec.setArchInputStruct(cfin15si.getArchInputStruct());
        pCLSS36DInputRec.setUlIdInvoInvoice(cfin15si.getUlIdInvoInvoice());
        pCLSS36DInputRec.getArchInputStruct().setUsPageNbr(cfin15si.getArchInputStruct().getUsPageNbr());
        pCLSS36DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin15si.getArchInputStruct().getUlPageSizeNbr());
        rc = clss36dQUERYdam(sqlca, pCLSS36DInputRec, pCLSS36DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CFIN15SO to fields in CLSS36DO
                
                for (i229 = 0;i229 < pCLSS36DOutputRec.getArchOutputStruct().getUlRowQty();i229++) {
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setSzCdAdminDtlInvoDisptn(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getSzCdAdminDtlInvoDisptn());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setSzCdAdminDtlLiType(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getSzCdAdminDtlLiType());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setSzCdAdminDtlService(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getSzCdAdminDtlService());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setTsLastUpdate(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getTsLastUpdate());
                    
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setCIndAdminDtlRejItm(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getCIndAdminDtlRejItm());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setUsNbrAdminDtlCsli(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getUsNbrAdminDtlCsli());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setUMoAdminDtlSvcMonth(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getUMoAdminDtlSvcMonth());
                    
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setUYrAdminDtlSvcYear(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getUYrAdminDtlSvcYear());
                    
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setUlIdInvoInvoice(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getUlIdInvoInvoice());
                    
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setUlIdAdminDtl(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getUlIdAdminDtl());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlTravel(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlTravel());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlSupplies(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlSupplies());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlSalaries(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlSalaries());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlOther(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlOther());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlOffsetItem(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlOffsetItem());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlFrgBenft(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlFrgBenft());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlEquipment(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlEquipment());
                    cfin15so.getROWCFIN15SOG00_ARRAY().getROWCFIN15SOG00(i229).setDAmtAdminDtlAdminAlloc(pCLSS36DOutputRec.getROWCLSS36DO_ARRAY().getROWCLSS36DO(i229).getDAmtAdminDtlAdminAlloc());
                }
                cfin15so.getArchOutputStruct().setBMoreDataInd(pCLSS36DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfin15so.getArchOutputStruct().setUlRowQty(pCLSS36DOutputRec.getArchOutputStruct().getUlRowQty());
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
        
        if ((REQ_FUNC_CD_DTLS_CDS == cfin15si.getArchInputStruct().getCReqFuncCd()) && (WtcHelperConstants.ARC_SUCCESS == rc)) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCLSS75DInputRec = new CLSS75DI();
            
            pCLSS75DOutputRec = new CLSS75DO();
            pCLSS75DInputRec.setArchInputStruct(cfin15si.getArchInputStruct());
            pCLSS75DInputRec.setUlIdContract(cfin15si.getUlIdContract());
            pCLSS75DInputRec.getArchInputStruct().setUsPageNbr(cfin15si.getArchInputStruct().getUsPageNbr());
            pCLSS75DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin15si.getArchInputStruct().getUlPageSizeNbr());
            rc = clss75dQUERYdam(sqlca, pCLSS75DInputRec, pCLSS75DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CFIN15SO to fields in CLSS75DO
                    
                    
                    for (i229 = 0;i229 < pCLSS75DOutputRec.getArchOutputStruct().getUlRowQty();i229++) {
                        cfin15so.getROWCFIN15SOG01_ARRAY().getROWCFIN15SOG01(i229).setSzCdCnsvcService(pCLSS75DOutputRec.getROWCLSS75DO_ARRAY().getROWCLSS75DO(i229).getSzCdCnsvcService());
                    }
                    cfin15so.setUlRowQty(pCLSS75DOutputRec.getArchOutputStruct().getUlRowQty());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_CON_NO_SVC_CODE;
                    
                    //  Call DAM
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
        ARC_PRFServiceStopTime_TUX(cfin15si.getArchInputStruct() , cfin15so.getArchOutputStruct());
        
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
        return cfin15so;
    }

}
