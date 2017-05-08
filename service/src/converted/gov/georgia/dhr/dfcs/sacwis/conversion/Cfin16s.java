package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD44DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFIN16S.src
**
** Service Name:  CFIN16S
**
** Description:   This service will Add or Update records to the ADMIN DTL
**                table.  CD ACTION CD will determine Add versus Update.  All
**                fields on the ADMIN DTL which are not used in CFIN07W will
**                be set to Null or 0 depending upon type.
**                Prior to the above AUD, this service will call CMSC13D two
**                times to check the number of reversals and adjustments.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11-14-1995
**
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:43:26  $
**                      $Modtime:   30 Mar 1996 00:13:38  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12-14-95  TLC       Added an if statement (when counting reversals to be
**                      saved to the database) to prevent a modified reversal
**                      row from being counted
**
**  1/10/96   LEELJ     Added DAM CAUD44D in order to update the Invoice
**                      table with the proper phase and validation flag.
**                      The new invoice time stamp will be returned to
**                      the window.
**
**  1/10/96   GLOORJW   Added if statements around DAMs CAUD44D and
**                      CMSC13D that will only allow the DAMS to be
**                      called if the previous DAM was successful.
**
**  01/10/96  GLOORJW   Removed references to Pac and Obj variables
**
**  01/27/04  CORLEYAN  SIR 22425 Removed MSG_FIN_MORE_REV_THAN_ADJ since it
**                      has been deemed unneccesary
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin16s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String REVERSAL_LI = "R";
    public static final String ADJUSTMENT_LI = "A";
    public static final String FIN_CD_INVO_PHASE_PEND = "VLP";
    CFIN16SO CFIN16S(CFIN16SI cfin16si) {
        CFIN16SO cfin16so = new CFIN16SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int /* Counter for Reversals */
        iRevCounter = 0;
        int iAdjCounter = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  short           rc = FND_SUCCESS;
        int usRow = 0;
        int usInputRow = 0;
        
        CAUD48DI pCAUD48DInputRec = null;
        CAUD48DO pCAUD48DOutputRec = null;
        
        CMSC13DI pCMSC13DInputRec = null;
        CMSC13DO pCMSC13DOutputRec = null;
        
        /*
        ** Added DAM CAUD44D   LJL 1/10/96
        */
        CAUD44DI pCAUD44DInputRec = null;
        CAUD44DO pCAUD44DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin16si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Added DAM CAUD44D  LJL 1/10/96
        */
        /**************************************************************************
        ** BEGIN: CAUD44D - Update Invoice Phase processing
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD44DInputRec = new CAUD44DI();
        
        pCAUD44DOutputRec = new CAUD44DO();
        pCAUD44DInputRec.setArchInputStruct(cfin16si.getArchInputStruct());
        pCAUD44DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD44DInputRec.setUlIdInvoInvoice(cfin16si.getUlIdInvoInvoice());
        pCAUD44DInputRec.setTsLastUpdate(cfin16si.getTsSysTsLastUpdate2());
        if (0 != cfin16si.getSzCdInvoPhase().compareTo(FIN_CD_INVO_PHASE_PEND)) {
            cfin16si.setSzCdInvoPhase(FIN_CD_INVO_PHASE_PEND);
        }
        pCAUD44DInputRec.setSzCdInvoPhase(cfin16si.getSzCdInvoPhase());
        rc = caud44dAUDdam(sqlca, pCAUD44DInputRec, pCAUD44DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                cfin16so.setTsLastUpdate(pCAUD44DOutputRec.getTsLastUpdate());
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
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC13DInputRec = new CMSC13DI();
            
            pCMSC13DOutputRec = new CMSC13DO();
            pCMSC13DInputRec.setArchInputStruct(cfin16si.getArchInputStruct());
            pCMSC13DInputRec.setSzCdAdminDtlLiType(REVERSAL_LI);
            pCMSC13DInputRec.setUlIdInvoInvoice(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usRow).getUlIdInvoInvoice());
            rc = cmsc13dQUERYdam(sqlca, pCMSC13DInputRec, pCMSC13DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                    //  If Dam is successful, set rc to Success and break out of switch
                    // statement
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    iRevCounter = pCMSC13DOutputRec.getUsSysNbrSvcDtlCount();
                    pCMSC13DInputRec.setArchInputStruct(cfin16si.getArchInputStruct());
                    pCMSC13DInputRec.setSzCdAdminDtlLiType(ADJUSTMENT_LI);
                    pCMSC13DInputRec.setUlIdInvoInvoice(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usRow).getUlIdInvoInvoice());
                    
                    // call DAM
                    rc = cmsc13dQUERYdam(sqlca, pCMSC13DInputRec, pCMSC13DOutputRec);
                    
                    //  Analyze error code
                    switch (rc) {
                            
                            //  If no row is found, the approval was deleted already because it
                            // was also related to a revious event passed.  Set the id_approval
                            // to zero to stop the deleting of approvals, set rc to success and
                            // break out of switch statement
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            iAdjCounter = pCMSC13DOutputRec.getUsSysNbrSvcDtlCount();// Counter for Adjustments
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUD48DInputRec = new CAUD48DI();
            
            pCAUD48DOutputRec = new CAUD48DO();
            
            
            for (usInputRow = 0;(usInputRow < cfin16si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc);usInputRow++) {
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdScrDataAction()) {
                    if (!(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdAdminDtlLiType().compareTo(REVERSAL_LI) != 0)) {
                        iRevCounter++;
                    }
                    
                    // SVC AUTH ENH -- modified if condition below to consider
                    // MODIFY mode due to enhancement.
                    if (!(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdAdminDtlLiType().compareTo(ADJUSTMENT_LI) != 0)) {
                        iAdjCounter++;
                    }
                }
            }
            
            
            
            
            for (usInputRow = 0;(usInputRow < cfin16si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc);usInputRow++) {
                
                pCAUD48DInputRec.setArchInputStruct(cfin16si.getArchInputStruct());
                pCAUD48DInputRec.getArchInputStruct().setCReqFuncCd(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdScrDataAction());
                pCAUD48DInputRec.setSzCdAdminDtlInvoDisptn(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdAdminDtlInvoDisptn());
                pCAUD48DInputRec.setSzCdAdminDtlLiType(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdAdminDtlLiType());
                pCAUD48DInputRec.setSzCdAdminDtlService(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getSzCdAdminDtlService());
                pCAUD48DInputRec.setTsLastUpdate(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getTsLastUpdate());
                
                pCAUD48DInputRec.setCIndAdminDtlRejItm(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getCIndAdminDtlRejItm());
                pCAUD48DInputRec.setDAmtAdminDtlAdminAlloc(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlAdminAlloc());
                pCAUD48DInputRec.setDAmtAdminDtlEquipment(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlEquipment());
                pCAUD48DInputRec.setDAmtAdminDtlFrgBenft(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlFrgBenft());
                pCAUD48DInputRec.setDAmtAdminDtlOffsetItem(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlOffsetItem());
                pCAUD48DInputRec.setDAmtAdminDtlOther(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlOther());
                pCAUD48DInputRec.setDAmtAdminDtlSalaries(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlSalaries());
                pCAUD48DInputRec.setDAmtAdminDtlSupplies(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlSupplies());
                pCAUD48DInputRec.setDAmtAdminDtlTravel(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getDAmtAdminDtlTravel());
                pCAUD48DInputRec.setUlIdAdminDtl(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getUlIdAdminDtl());
                pCAUD48DInputRec.setUlIdInvoInvoice(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getUlIdInvoInvoice());
                pCAUD48DInputRec.setUMoAdminDtlSvcMonth(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getUMoAdminDtlSvcMonth());
                pCAUD48DInputRec.setUsNbrAdminDtlCsli(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getUsNbrAdminDtlCsli());
                pCAUD48DInputRec.setUYrAdminDtlSvcYear(cfin16si.getROWCFIN16SIG00_ARRAY().getROWCFIN16SIG00(usInputRow).getUYrAdminDtlSvcYear());
                //  Do nothing, the output message just returns success or
                // failure.
                rc = caud48dAUDdam(sqlca, pCAUD48DInputRec, pCAUD48DOutputRec);
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
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin16si.getArchInputStruct() , cfin16so.getArchOutputStruct());
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
        return cfin16so;
    }

}
