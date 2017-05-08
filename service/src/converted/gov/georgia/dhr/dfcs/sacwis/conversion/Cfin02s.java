package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CFIN02S.src
**
** Service Name:  CFIN02S
**
** Description:   This service will retrieve the information
**                for the entry fields for CFIN03W - INVOICE
**                HEADER.  If the window is in NEW mode, the
**                service will call CSEC06D to retrieve information 
**                specific to the contract from CONTRACT, 
**                CAPS RESOURCE, AND RESOURCE ADDRESS.  In modify
**                or BROWSE mode, the DAM will retrieve invoice
**                information from INVOICE, in addition to the
**                former information.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11/14/95 
** 
** Programmer:    GLOORJW
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:21:46  $
**                      $Modtime:   05 Aug 1996 16:49:08  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/08/96  CHESSMTL  Added code to retrieve the Contract Program Type.  
**                      Also modified the output header file.  From 6/1/96 to
**                      8/31/96, users will not be able to create Invoices 
**                      against CPS Contracts
**  7/26/96    zabihin  sir 21891 : version control code was missing, I 
**                      added the lines.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin02s {
    CFIN02SO CFIN02S(CFIN02SI cfin02si) {
        CFIN02SO cfin02so = new CFIN02SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i223 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CSEC06DI pCSEC06DInputRec = null;
        CSEC06DO pCSEC06DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin02si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cfin02so.getDtScrDtCurrentDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSEC06DInputRec = new CSEC06DI();
        
        pCSEC06DOutputRec = new CSEC06DO();
        
        pCSEC06DInputRec.setArchInputStruct(cfin02si.getArchInputStruct());
        pCSEC06DInputRec.setUlIdContract(cfin02si.getUlIdContract());
        pCSEC06DInputRec.setUlIdInvoInvoice(cfin02si.getUlIdInvoInvoice());
        
        /*
        ** Call DAM if a Race is added or deleted
        */
        rc = csec06dQUERYdam(sqlca, pCSEC06DInputRec, pCSEC06DOutputRec);
        
        
        /*
        ** Analyze return code for CSUB40U
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                cfin02so.getDtDtInvoSubmitDate().day = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoSubmitDate().month = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoSubmitDate().year = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoWarrantDate().day = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoWarrantDate().month = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoWarrantDate().year = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoEntryCompleted().day = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoEntryCompleted().month = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoEntryCompleted().year = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoEntryStarted().day = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoEntryStarted().month = DateHelper.NULL_DATE;
                cfin02so.getDtDtInvoEntryStarted().year = DateHelper.NULL_DATE;
                if (cfin02si.getUlIdContract() > 0) {
                    cfin02so.setUlIdContract(cfin02si.getUlIdContract());
                    cfin02so.setSzNmResource(pCSEC06DOutputRec.getSzNmResource());
                    cfin02so.setUlIdResource(pCSEC06DOutputRec.getUlIdResource());
                    cfin02so.setSzNbrInvoVid(pCSEC06DOutputRec.getSzNbrRsrcAddrVid());
                    cfin02so.setSzCdCntrctProgramType(pCSEC06DOutputRec.getSzCdCntrctProgramType());
                    cfin02so.setSzCdCntrctRegion(pCSEC06DOutputRec.getSzCdCntrctRegion());
                    cfin02so.setSzCdInvoType(pCSEC06DOutputRec.getSzCdInvoType());
                }
                
                //  Otherwise, Populate all of the output fields
                // from the DAM output record.  When an Invoice ID
                // exists, the VID is a historical VID thus, the VID retrieved
                // in this case should be the VID stored on the 
                // Invoice table.
                else {
                    cfin02so.setUlIdInvoInvoice(pCSEC06DOutputRec.getUlIdInvoInvoice());
                    cfin02so.setUlIdContract(pCSEC06DOutputRec.getUlIdContract());
                    cfin02so.setSzNmResource(pCSEC06DOutputRec.getSzNmResource());
                    cfin02so.setUlIdResource(pCSEC06DOutputRec.getUlIdResource());
                    cfin02so.setSzNbrInvoVid(pCSEC06DOutputRec.getSzNbrInvoVid());
                    cfin02so.setSzCdCntrctProgramType(pCSEC06DOutputRec.getSzCdCntrctProgramType());
                    cfin02so.setSzCdCntrctRegion(pCSEC06DOutputRec.getSzCdCntrctRegion());
                    cfin02so.setSzCdInvoType(pCSEC06DOutputRec.getSzCdInvoType());
                    cfin02so.setUMoInvoMonth(pCSEC06DOutputRec.getUMoInvoMonth());
                    cfin02so.setUYrInvoYear(pCSEC06DOutputRec.getUYrInvoYear());
                    cfin02so.setDAmtInvoClaimedAmount(pCSEC06DOutputRec.getDAmtInvoClaimedAmount());
                    cfin02so.setDAmtInvoValidAmount(pCSEC06DOutputRec.getDAmtInvoValidAmount());
                    cfin02so.setDAmtInvoWarrant(pCSEC06DOutputRec.getDAmtInvoWarrant());
                    cfin02so.setSzNbrInvoWarrant(pCSEC06DOutputRec.getSzNbrInvoWarrant());
                    cfin02so.setDtDtInvoReceivedDate(pCSEC06DOutputRec.getDtDtInvoReceivedDate());
                    cfin02so.setDtDtInvoSubmitDate(pCSEC06DOutputRec.getDtDtInvoSubmitDate());
                    cfin02so.setDtDtInvoWarrantDate(pCSEC06DOutputRec.getDtDtInvoWarrantDate());
                    cfin02so.setDtDtInvoEntryCompleted(pCSEC06DOutputRec.getDtDtInvoEntryCompleted());
                    cfin02so.setDtDtInvoEntryStarted(pCSEC06DOutputRec.getDtDtInvoEntryStarted());
                    cfin02so.setSzCdInvoAdjustmentRb(pCSEC06DOutputRec.getSzCdInvoAdjustmentRb());
                    cfin02so.setCIndInvoReadyForValid(pCSEC06DOutputRec.getCIndInvoReadyForValid());
                    cfin02so.setSzCdInvoPhase(pCSEC06DOutputRec.getSzCdInvoPhase());
                    
                    cfin02so.setSzCdInvoApproved(pCSEC06DOutputRec.getSzCdInvoApproved());
                    cfin02so.setTsLastUpdate(pCSEC06DOutputRec.getTsSysTsLastUpdate4());
                }
                break;
            case NO_DATA_FOUND:
                
                if (cfin02si.getUlIdContract() > 0) {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                }
                //  Otherwise, an error has occured.  In this case,
                // set the severity to FND_SEVERITY_ERROR and the return code
                // to MSG_DATABASE_RETRIEVE_FAIL
                else {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                }
                //  Do nothing, the output message just returns success or
                // failure
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
        ARC_PRFServiceStopTime_TUX(cfin02si.getArchInputStruct() , cfin02so.getArchOutputStruct());
        
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
        return cfin02so;
    }

}
