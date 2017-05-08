package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS75DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:    CFIN10S.src
**
** Service Name:   CFIN10S- Foster Care Detail Retrieval
**
** Description:   This service will retieve all records from the
**                DELVRD_SVC_DTL table that have an ID INVOICE = to the one
**                passed into the service.  The records will be sorted
**                alphabetically into the listbox according to Person Name.
**                Additionally, this service will retrieve all the
**                services of a contract.  CLSS13D will be called only on
**                the initial call to this service - SYS CARC RQST FUNC CD,
**                stored in the input architecture record group, will indicate
**                whether to call CLSS13D.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11--1995
**
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:26:20  $
**                      $Modtime:   30 Mar 1996 00:12:20  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/2/2001 Hadjimh   SIR# extension of 15787 The Service Code Combobox should
**                      be populated with all the service codes of a contract.
**                      CLSS13D is replaced by CLSS75D just to do that.
**
**	09/03/03  Srini     SIR#19677 - statically setting the pageno to 1 and 
**						pagesizenbr to 100 to fix paginating problem with the 
**						service codes.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin10s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char REQ_FUNC_CD_DTLS_CDS = 'C';
    CFIN10SO CFIN10S(CFIN10SI cfin10si) {
        CFIN10SO cfin10so = new CFIN10SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i227 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CDYN02DI pCDYN02DInputRec = null;
        CDYN02DO pCDYN02DOutputRec = null;
        CLSS75DI pCLSS75DInputRec = null;
        CLSS75DO pCLSS75DOutputRec = null;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(cfin10si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cfin10so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCDYN02DInputRec = new CDYN02DI();
        
        pCDYN02DOutputRec = new CDYN02DO();
        pCDYN02DInputRec.setArchInputStruct(cfin10si.getArchInputStruct());
        pCDYN02DInputRec.setUlIdInvoInvoice(cfin10si.getUlIdInvoInvoice());
        pCDYN02DInputRec.setBWcdCdSortBy(cfin10si.getBWcdCdSortBy());
        pCDYN02DInputRec.getArchInputStruct().setUsPageNbr(cfin10si.getArchInputStruct().getUsPageNbr());
        pCDYN02DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin10si.getArchInputStruct().getUlPageSizeNbr());
        rc = cdyn02dQUERYdam(sqlca, pCDYN02DInputRec, pCDYN02DOutputRec);
        
        /*
        ** Analyze return code
        */
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CFIN10SO to fields in CDYN02DO
                
                for (i227 = 0;i227 < pCDYN02DOutputRec.getArchOutputStruct().getUlRowQty();i227++) {
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setSzCdSvcDtlLiType(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getSzCdSvcDtlLiType());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setSzNmPersonFull(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getSzNmPersonFull());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setSzCdSvcDtlService(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getSzCdSvcDtlService());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setTsLastUpdate(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getTsSysTsLastUpdate2());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setUYrSvcDtlServiceYear(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getUYrSvcDtlServiceYear());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setSNbrSvcDtlUnitQty(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getSNbrSvcDtlUnitQty());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setSNbrSvcDtlToDay(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getSNbrSvcDtlToDay());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setSNbrSvcDtlFromDay(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getSNbrSvcDtlFromDay());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setLNbrRsrcFacilAcclaim(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getLNbrRsrcFacilAcclaim());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setUMoSvcDtlSvcMonth(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getUMoSvcDtlSvcMonth());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setCIndSvcDtlRejItem(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getCIndSvcDtlRejItem());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setUlIdResource(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getUlIdResource());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setUlIdSvcDtl(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getUlIdSvcDtl());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setUlIdPerson(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getUlIdPerson());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setDAmtSvcDtlUnitRate(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getDAmtSvcDtlUnitRate());
                    cfin10so.getROWCFIN10SOG00_ARRAY().getROWCFIN10SOG00(i227).setDAmtSvcDtlIncome(pCDYN02DOutputRec.getROWCDYN02DO_ARRAY().getROWCDYN02DO(i227).getDAmtSvcDtlIncome());
                }
                cfin10so.getArchOutputStruct().setBMoreDataInd(pCDYN02DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfin10so.getArchOutputStruct().setUlRowQty(pCDYN02DOutputRec.getArchOutputStruct().getUlRowQty());
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
        
        if ((REQ_FUNC_CD_DTLS_CDS == cfin10si.getArchInputStruct().getCReqFuncCd()) && (WtcHelperConstants.ARC_SUCCESS == rc)) {
            
            pCLSS75DInputRec = new CLSS75DI();
            
            pCLSS75DOutputRec = new CLSS75DO();
            
            pCLSS75DInputRec.setArchInputStruct(cfin10si.getArchInputStruct());
            
            pCLSS75DInputRec.setUlIdContract(cfin10si.getUlIdContract());
            pCLSS75DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCLSS75DInputRec.getArchInputStruct().setUlPageSizeNbr(100);
            rc = clss75dQUERYdam(sqlca, pCLSS75DInputRec, pCLSS75DOutputRec);
            switch (rc) {
                    //  Temp Fix 20316
                    // Add sql_not_found
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    for (i227 = 0;i227 < pCLSS75DOutputRec.getArchOutputStruct().getUlRowQty();i227++) {
                        cfin10so.getROWCFIN10SOG01_ARRAY().getROWCFIN10SOG01(i227).setSzCdCnsvcService(pCLSS75DOutputRec.getROWCLSS75DO_ARRAY().getROWCLSS75DO(i227).getSzCdCnsvcService());
                    }
                    cfin10so.setUlRowQty(pCLSS75DOutputRec.getArchOutputStruct().getUlRowQty());
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
        ARC_PRFServiceStopTime_TUX(cfin10si.getArchInputStruct() , cfin10so.getArchOutputStruct());
        
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
        return cfin10so;
    }

}
