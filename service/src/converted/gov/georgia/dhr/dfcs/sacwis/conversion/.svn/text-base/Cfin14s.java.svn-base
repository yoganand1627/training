package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD53DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CFIN14S.src
**
** Service Name:  Cost Reimbursement Detail Save
**
** Description:   This service will call dams to do a full row update on the
**                CostReimDtl table. It will also update DelvrdSvcDtl records
**                by IdInvoice and CLSI with computed unit rate and total. If
**                the process is successful, the service will call CAUD44D to
**                update the status of the Invoice record.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12-04-95
** 
** Programmer:    adkinsmc
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Sep 1996 17:56:46  $
**                      $Modtime:   12 Sep 1996 13:50:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/15/96  GILLESLS  Removed comments from the DAM calls
**
**  02/29/96  MCRAEBS   SIR 3453 - To avoid rounding errors in when the 
**                      unit rate is passes to the InputRec from the 
**                      InputMsg (double to float) add .005 to the value in 
**                      the InputMsg.  BSM
**
**  03/12/96  MCRAEBS   SIR 3771 - Changed .005 to .0005 to avoid rounding 
**                      errors in small dollar fee calculations.  BSM
**
**  01/28/03  DWW       moved these free statements inside the 
**                      if statement where they are malloc'd so that we do not 
**                      get a segfault on an error condition
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin14s {
    static final String FIN_CD_INVO_PHASE_PEND1 = "VLP";
    static final String FIN_CD_INVO_PHASE_PREBILL1 = "PRB";
    CFIN14SO CFIN14S(CFIN14SI cfin14si) {
        CFIN14SO cfin14so = new CFIN14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare local variables 
        */
        
        public public CMSC21DI pCMSC21DInputRec = null;
        CMSC21DO pCMSC21DOutputRec = null;
        CAUD44DI pCAUD44DInputRec = null;
        CAUD44DO pCAUD44DOutputRec = null;
        CAUD53DI pCAUD53DInputRec = null;
        CAUD53DO pCAUD53DOutputRec = null;
        
        
        int usRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(cfin14si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Cost Reimubursement AUD
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD53DInputRec = new CAUD53DI();
        
        pCAUD53DOutputRec = new CAUD53DO();
        
        while ((usRow < cfin14si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.ARC_SUCCESS == rc)) {
            pCAUD53DInputRec.getArchInputStruct().setCReqFuncCd(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getSzCdScrDataAction());
            pCAUD53DInputRec.setUlIdInvoInvoice(cfin14si.getUlIdInvoInvoice());
            pCAUD53DInputRec.setSzCdCostReimLiType(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getSzCdCostReimLiType());
            pCAUD53DInputRec.setSzCdCostReimService(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getSzCdCostReimService());
            
            //## BEGIN TUX/XML: Declare XML variables
            pCAUD53DInputRec.setSzCdCostReimInvoDisptn(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getSzCdCostReimInvoDisptn());
            pCAUD53DInputRec.setTsLastUpdate(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getTsLastUpdate());
            pCAUD53DInputRec.setUsNbrCostReimCsli(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getUsNbrCostReimCsli());
            pCAUD53DInputRec.setUNbrCostReimUnitQty(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getUNbrCostReimUnitQty());
            pCAUD53DInputRec.setDAmtCostReimAdminAll(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimAdminAll());
            pCAUD53DInputRec.setDAmtCostReimEquip(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimEquip());
            pCAUD53DInputRec.setDAmtCostReimFrgBenft(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimFrgBenft());
            pCAUD53DInputRec.setDAmtCostReimOffItem(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimOffItem());
            pCAUD53DInputRec.setDAmtCostReimDtlOther(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimDtlOther());
            pCAUD53DInputRec.setDAmtCostReimSalary(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimSalary());
            pCAUD53DInputRec.setDAmtCostReimSupply(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimSupply());
            pCAUD53DInputRec.setDAmtCostReimTravel(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDAmtCostReimTravel());
            pCAUD53DInputRec.setUlIdCostReim(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getUlIdCostReim());
            pCAUD53DInputRec.setCIndCostReimRejItm(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getCIndCostReimRejItm());
            
            //  Call DAM
            rc = caud53dAUDdam(sqlca, pCAUD53DInputRec, pCAUD53DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Call CMSC21D - DELV SVC UPDATE to update the DELVRD SVC DTL
                    // records the CLSI that was just saved
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC21DInputRec = new CMSC21DI();
                    
                    pCMSC21DOutputRec = new CMSC21DO();
                    pCMSC21DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCMSC21DInputRec.setUlIdInvoInvoice(cfin14si.getUlIdInvoInvoice());
                    pCMSC21DInputRec.setDAmtSvcDtlUnitRate((float) ((cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getDScrAmtCostReimCmpUrt() + .0005)));
                    pCMSC21DInputRec.setUsNbrSvcDtlCsli(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getUsNbrCostReimCsli());
                    pCMSC21DInputRec.setSzCdSvcDtlLiType(cfin14si.getROWCFIN14SIG_ARRAY().getROWCFIN14SIG(usRow).getSzCdCostReimLiType());
                    pCMSC21DInputRec.setTsLastUpdate(cfin14si.getTsSysTsLastUpdate2());
                    
                    
                    rc = cmsc21dAUDdam(sqlca, pCMSC21DInputRec, pCMSC21DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            break;
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            usRow++;
        }
        
        if ((FIN_CD_INVO_PHASE_PEND1 != cfin14si.getSzCdInvoPhase()) && (SUCCESS == pServiceStatus.explan_code)) {
            //  Allocate memory for DAM Input and Output Structures
            pCAUD44DInputRec = new CAUD44DI();
            
            pCAUD44DOutputRec = new CAUD44DO();
            pCAUD44DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCAUD44DInputRec.setUlIdInvoInvoice(cfin14si.getUlIdInvoInvoice());
            pCAUD44DInputRec.setTsLastUpdate(cfin14si.getTsSysTsLastUpdate2());
            pCAUD44DInputRec.setSzCdInvoPhase(FIN_CD_INVO_PHASE_PEND1);
            rc = caud44dAUDdam(sqlca, pCAUD44DInputRec, pCAUD44DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfin14so.setTsLastUpdate(pCAUD44DOutputRec.getTsLastUpdate());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
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
        ARC_PRFServiceStopTime_TUX(cfin14si.getArchInputStruct() , cfin14so.getArchOutputStruct());
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
        return cfin14so;
    }

}
