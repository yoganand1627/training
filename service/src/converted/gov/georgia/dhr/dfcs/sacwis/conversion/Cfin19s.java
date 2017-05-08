package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN05DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN05DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:    CFIN19S.src
**
** Service Name:   CFIN19S - Payment Approval List Retrieve
**
** Description:   This service will retrieve selected columns for dynamic
**                search criteria from the Invoice, Contract and Resource
**                tables.  The DAM, CDYN05D - INVO APPVL RTRV, retrieves
**                all columns from the Invoice table where CD CNTRCT REGION
**                is equal to one of the regions that the user has modify
**                access to, that are valid with and without line item
**                rejections.  It will join to the CONTRACT and CAPS RESOURCE
**                tables.  The service will then pull the following
**                attributes from the DAM output message:
**                  ID INVOICE, ID CONTRACT, CD INVO APPROVED, CD INVO PHASE,
**                  NM RESOURCE, AMT INVO VALID AMOUNT, DT INVO RECEIVED,
**                  ID PERSON, SYS TS LAST UPDATE
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11/21/95
**
** Programmer:    Diana L. Feller
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:53:42  $
**                      $Modtime:   08 May 1996 21:40:36  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/03/96  PHILLILH  SIR #20882 - Retrieve dtDtInvoApprovalDate from the
**                      Invoice table and pass to Payment Approval (CFIN09W)
**                      window.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
**  05/02/04  gerryc    SIR 15533 - added Sort By parameter
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin19s {
    CFIN19SO CFIN19S(CFIN19SI cfin19si) {
        CFIN19SO cfin19so = new CFIN19SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        /*
        ** END SIR 15047
        */
        /*
        ** This DAM retrieves all the cases
        */
        rc = ARC_UTLCheckServiceBatchBlock("CFIN19S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i230 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CDYN05DI pCDYN05DInputRec = null;
        CDYN05DO pCDYN05DOutputRec = null;
        // SIR 23096 Start
        rc = ARC_PRFServiceStartTime_TUX(cfin19si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCDYN05DInputRec = new CDYN05DI();
        
        pCDYN05DOutputRec = new CDYN05DO();
        pCDYN05DInputRec.setArchInputStruct(cfin19si.getArchInputStruct());
        pCDYN05DInputRec.szCdCntrctRegion = cfin19si.getSzCdCntrctRegion_ARRAY();
        pCDYN05DInputRec.setSzSysCdWinMode(cfin19si.getSzSysCdWinMode());
        pCDYN05DInputRec.setBWcdCdSortBy(cfin19si.getBWcdCdSortBy());
        pCDYN05DInputRec.getArchInputStruct().setUsPageNbr(cfin19si.getArchInputStruct().getUsPageNbr());
        pCDYN05DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin19si.getArchInputStruct().getUlPageSizeNbr());
        rc = cdyn05dQUERYdam(sqlca, pCDYN05DInputRec, pCDYN05DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CFIN19SO to fields in CDYN05DO
                
                for (i230 = 0;i230 < pCDYN05DOutputRec.getArchOutputStruct().getUlRowQty();i230++) {
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setSzCdInvoApproved(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getSzCdInvoApproved());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setUlIdInvoInvoice(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getUlIdInvoInvoice());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setSzCdInvoPhase(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getSzCdInvoPhase());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setDtDtInvoReceivedDate(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getDtDtInvoReceivedDate());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setDtDtInvoApprovalDate(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getDtDtInvoApprovalDate());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setDAmtInvoValidAmount(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getDAmtInvoValidAmount());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setUlIdPerson(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getUlIdPerson());
                    
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setTsLastUpdate(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getTsLastUpdate());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setSzNmResource(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getSzNmResource());
                    cfin19so.getROWCFIN19SOG_ARRAY().getROWCFIN19SOG(i230).setUlIdContract(pCDYN05DOutputRec.getROWCDYN05DO_ARRAY().getROWCDYN05DO(i230).getUlIdContract());
                }
                cfin19so.getArchOutputStruct().setBMoreDataInd(pCDYN05DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfin19so.getArchOutputStruct().setUlRowQty(pCDYN05DOutputRec.getArchOutputStruct().getUlRowQty());
                
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
        ARC_PRFServiceStopTime_TUX(cfin19si.getArchInputStruct() , cfin19so.getArchOutputStruct());
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
        
        
        return cfin19so;
    }

}
