package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN07DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CFIN01S.src
**
** Service Name:   CFIN01S - Invoice List Retrieval
**
** Description:   This service will retrieve the information for the listbox
**                on CFIN01W - Invoice List.  This service calls a dynamic 
**                dam to retrieve from the INVOICE, CONTRACT, and CAPS 
**                RESOURCE tables. It call CDYN07D - INVO LIST RTRV.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  November 21,1995 
** 
** Programmer:    Lee Phillips
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:18:12  $
**                      $Modtime:   30 Mar 1996 00:10:06  $
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






public class Cfin01s {
    CFIN01SO CFIN01S(CFIN01SI cfin01si) {
        CFIN01SO cfin01so = new CFIN01SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i222 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CDYN07DI pCDYN07DInputRec = null;
        CDYN07DO pCDYN07DOutputRec = null;
        
        
        /*
        ** Call CSEC02D
        */
        rc = ARC_PRFServiceStartTime_TUX(cfin01si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing - Retrieve Data for Invoice List Box
        ** uaing dynamic DAM CDYN07D
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCDYN07DInputRec = new CDYN07DI();
        
        pCDYN07DOutputRec = new CDYN07DO();
        pCDYN07DInputRec.setArchInputStruct(cfin01si.getArchInputStruct());
        pCDYN07DInputRec.setSzCdCntrctRegion(cfin01si.getSzCdCntrctRegion());
        pCDYN07DInputRec.setSzCdInvoPhase(cfin01si.getSzCdInvoPhase());
        pCDYN07DInputRec.setSzCdInvoType(cfin01si.getSzCdInvoType());
        pCDYN07DInputRec.setUlIdInvoInvoice(cfin01si.getUlIdInvoInvoice());
        pCDYN07DInputRec.setUlIdContract(cfin01si.getUlIdContract());
        pCDYN07DInputRec.setUlIdResource(cfin01si.getUlIdResource());
        pCDYN07DInputRec.setUMoInvoMonth(cfin01si.getUMoInvoMonth());
        pCDYN07DInputRec.setUYrInvoYear(cfin01si.getUYrInvoYear());
        pCDYN07DInputRec.getArchInputStruct().setUsPageNbr(cfin01si.getArchInputStruct().getUsPageNbr());
        pCDYN07DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin01si.getArchInputStruct().getUlPageSizeNbr());
        rc = cdyn07dQUERYdam(sqlca, pCDYN07DInputRec, pCDYN07DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CFIN01SO.G00 to fields in CDYN07DO
                for (i222 = 0;i222 < pCDYN07DOutputRec.getArchOutputStruct().getUlRowQty();i222++) {
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setSzCdCntrctRegion(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getSzCdCntrctRegion());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setSzCdInvoPhase(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getSzCdInvoPhase());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setSzCdInvoType(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getSzCdInvoType());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setSzNmResource(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getSzNmResource());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setDAmtInvoValidAmount(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getDAmtInvoValidAmount());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setDtDtInvoSubmitDate(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getDtDtInvoSubmitDate());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setCIndInvoRejItems(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getCIndInvoRejItems());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setUlIdContract(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getUlIdContract());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setUlIdInvoInvoice(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getUlIdInvoInvoice());
                    cfin01so.getROWCFIN01SOG00_ARRAY().getROWCFIN01SOG00(i222).setUlIdResource(pCDYN07DOutputRec.getROWCDYN07DO_ARRAY().getROWCDYN07DO(i222).getUlIdResource());
                }
                cfin01so.getArchOutputStruct().setBMoreDataInd(pCDYN07DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfin01so.getArchOutputStruct().setUlRowQty(pCDYN07DOutputRec.getArchOutputStruct().getUlRowQty());
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
        ARC_PRFServiceStopTime_TUX(cfin01si.getArchInputStruct() , cfin01so.getArchOutputStruct());
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
                
                
                //  Call CAUDC0D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            
        }
        return cfin01so;
    }

}
