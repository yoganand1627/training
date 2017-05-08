package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC21DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFIN07S.src
**
** Service Name:  CFIN07S - DELVRD SVC DTL AUD
**
** Description:   This service will add/update to the Delivered Service Table
**                and to the Invoice table.  It will also verify that there
**                are more adjustment line items than reversal line items.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 18, 1995
**
** Programmer:    Danny Gillespie
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   19 Mar 2001 07:33:04  $
**                      $Modtime:   12 Mar 2001 09:47:58  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/15/96  GILLESLS  Removed commented code from DAM calls
**  01/24/03  SRINI D   Replacing FIN_IND_DTL_REJ_ITEM with FND_YES as per
**                      Anna.
**
**  02/06/2003  KRD     IMPACT - Add call to CMSC21D to handled the automatic
**                      updating the unit rate.
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






public class Cfin07s {
    
    /*
    ** Declare FOUNDATION variables 
    */
    public static final String FIN_CD_INVO_PHASE_PEND = "VLP";
    public static final String FIN_CD_INVO_PHASE_PREBILL = "PRB";
    public static final int FIRST_DELVRD_SVC_RECORD = 0;
    public static final String FIN_CD_LI_TYPE_ADJ = "A";
    public static final String FIN_CD_LI_TYPE_REV = "R";
    public static final char FIN_IND_DTL_REJ_ITEM = '!';
    /*
    ** IMPACT BEGIN - add macro to know when to call CMSC21D
    */
    public static final String FIN_COST_REIM = "CRM";
    CFIN07SO CFIN07S(CFIN07SI cfin07si) {
        CFIN07SO cfin07so = new CFIN07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CMSC08DI pCMSC08DInputRec = null;
        CMSC08DO pCMSC08DOutputRec = null;
        
        CAUD44DI pCAUD44DInputRec = null;
        CAUD44DO pCAUD44DOutputRec = null;
        
        CAUD43DI pCAUD43DInputRec = null;
        CAUD43DO pCAUD43DOutputRec = null;
        
        /*
        ** 11/03/2000 - ochumd Added two new dams per sir# 15605.
        */
        
        CLSCB2DI pCLSCB2DInputRec = null;
        CLSCB2DO pCLSCB2DOutputRec = null;
        
        CAUDE0DI pCAUDE0DInputRec = null;
        CAUDE0DO pCAUDE0DOutputRec = null;
        
        /*
        ** IMPACT BEGIN - define dam input/output
        */
        CMSC21DI pCMSC21DInputRec = null;
        CMSC21DO pCMSC21DOutputRec = null;
        /*
        ** IMPACT END
        */
        
        int usRow = 0;
        int usInputRow = 0;
        int usRevCounter = 0;
        int usAdjCounter = 0;
        
        /*
        ** Call The CloseStageCase Function
        */
        rc = ARC_PRFServiceStartTime_TUX(cfin07si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** BEGIN: CAUD44D - Update Invoice Phase processing
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD44DInputRec = new CAUD44DI();
        
        pCAUD44DOutputRec = new CAUD44DO();
        pCAUD44DInputRec.setArchInputStruct(cfin07si.getArchInputStruct());
        pCAUD44DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD44DInputRec.setUlIdInvoInvoice(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(0).getUlIdInvoInvoice());
        
        pCAUD44DInputRec.setTsLastUpdate(cfin07si.getTsSysTsLastUpdate2());
        pCAUD44DInputRec.setSzCdInvoPhase(FIN_CD_INVO_PHASE_PEND);
        rc = caud44dAUDdam(sqlca, pCAUD44DInputRec, pCAUD44DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                cfin07so.setTsLastUpdate(pCAUD44DOutputRec.getTsLastUpdate());
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
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            
            // 
            // BEGIN: CAUD43D - AUD Delivered Service Records
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUD43DInputRec = new CAUD43DI();
            
            pCAUD43DOutputRec = new CAUD43DO();
            
            
            //  While more rows are left to process and rc is zero,
            // continue loop.
            while ((usRow < cfin07si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
                pCAUD43DInputRec.setArchInputStruct(cfin07si.getArchInputStruct());
                pCAUD43DInputRec.getArchInputStruct().setCReqFuncCd(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getSzCdSysDataActionOutcome());
                pCAUD43DInputRec.setSzCdSvcDtlCounty(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getSzCdSvcDtlCounty());
                pCAUD43DInputRec.setSzCdSvcDtlService(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getSzCdSvcDtlService());
                pCAUD43DInputRec.setSzCdSvcDtlUnitType(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getSzCdSvcDtlUnitType());
                pCAUD43DInputRec.setSzCdSvcDtlLiType(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getSzCdSvcDtlLiType());
                pCAUD43DInputRec.setTsLastUpdate(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getTsLastUpdate());
                pCAUD43DInputRec.setCIndSvcDtlRejItem(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getCIndSvcDtlRejItem());
                
                pCAUD43DInputRec.setDAmtSvcDtlFeePaid(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getDAmtSvcDtlFeePaid());
                
                pCAUD43DInputRec.setDAmtSvcDtlUnitRate(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getDAmtSvcDtlUnitRate());
                pCAUD43DInputRec.setUlIdPerson(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUlIdPerson());
                pCAUD43DInputRec.setUlIdInvoInvoice(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUlIdInvoInvoice());
                pCAUD43DInputRec.setUlIdSvcDtl(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUlIdSvcDtl());
                pCAUD43DInputRec.setUlIdSvcAuthDtl(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUlIdSvcAuthDtl());
                pCAUD43DInputRec.setUMoSvcDtlSvcMonth(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUMoSvcDtlSvcMonth());
                pCAUD43DInputRec.setUYrSvcDtlServiceYear(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUYrSvcDtlServiceYear());
                pCAUD43DInputRec.setUsNbrSvcDtlCsli(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUsNbrSvcDtlCsli());
                pCAUD43DInputRec.setSNbrSvcDtlUnitQty(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getSNbrSvcDtlUnitQty());
                
                rc = caud43dAUDdam(sqlca, pCAUD43DInputRec, pCAUD43DOutputRec);
                
                //  Analyze return code
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
                usRow++;
            }
        }
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            
            
            // 
            // BEGIN: CMSC08D - This DAM will verify that the number of Adjustment
            // entries are equal to or greater than the number of
            // Reversal entries
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC08DInputRec = new CMSC08DI();
            
            pCMSC08DOutputRec = new CMSC08DO();
            pCMSC08DInputRec.setArchInputStruct(cfin07si.getArchInputStruct());
            pCMSC08DInputRec.setSzCdSvcDtlLiType(FIN_CD_LI_TYPE_ADJ);
            pCMSC08DInputRec.setUlIdInvoInvoice(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(FIRST_DELVRD_SVC_RECORD).getUlIdInvoInvoice());
            rc = cmsc08dQUERYdam(sqlca, pCMSC08DInputRec, pCMSC08DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    usAdjCounter = pCMSC08DOutputRec.getUsSysNbrSvcDtlCount();
                    pCMSC08DInputRec.setArchInputStruct(cfin07si.getArchInputStruct());
                    pCMSC08DInputRec.setSzCdSvcDtlLiType(FIN_CD_LI_TYPE_REV);
                    pCMSC08DInputRec.setUlIdInvoInvoice(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(FIRST_DELVRD_SVC_RECORD).getUlIdInvoInvoice());
                    rc = cmsc08dQUERYdam(sqlca, pCMSC08DInputRec, pCMSC08DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            usRevCounter = pCMSC08DOutputRec.getUsSysNbrSvcDtlCount();
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
        
        /* Populate DAM Input Structure */
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            
            //  Declare FOUNDATION variables
            
            //  Declare local variables
            usRow = 0;
            
            while ((usRow < cfin07si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
                
                // SIR#3582: bIndChkd is intened to signal that Alert
                // is Not To Be Sent.  Direct Match with LOC and FLOC
                if ((0 == (cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getSNbrSvcDtlUnitQty())) && (cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getCIndSvcDtlRejItem() != FND_YES)) {
                    
                    
                    // 
                    // BEGIN: CLSCB2D - To retrieve the records from the Delivered
                    // Service Detail for a given Invoice ID.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    
                    pCLSCB2DInputRec = new CLSCB2DI();
                    
                    pCLSCB2DOutputRec = new CLSCB2DO();
                    pCLSCB2DInputRec.setArchInputStruct(cfin07si.getArchInputStruct());
                    pCLSCB2DInputRec.setUlIdInvoInvoice(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(usRow).getUlIdInvoInvoice());
                    
                    rc = clscb2dQUERYdam(sqlca, pCLSCB2DInputRec, pCLSCB2DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            // 
                            // BEGIN: CAUDE0D - AUD Delivered Service Records
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCAUDE0DInputRec = new CAUDE0DI();
                            
                            pCAUDE0DOutputRec = new CAUDE0DO();
                            pCAUDE0DInputRec.setArchInputStruct(cfin07si.getArchInputStruct());
                            pCAUDE0DInputRec.setUlIdSvcDtl(pCLSCB2DOutputRec.getUlIdSvcDtl());
                            pCAUDE0DInputRec.setUlIdSvcDtlRevrsalOrig(pCLSCB2DOutputRec.getUlIdSvcDtlRevrsalOrig());
                            
                            // Update functional record
                            rc = caude0dAUDdam(sqlca, pCAUDE0DInputRec, pCAUDE0DOutputRec);
                            
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    //  Retrieve Service Authorization from Service Auth. Event
                                    // Link table.
                                    rc = SUCCESS;
                                    break;
                                    
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            rc = SUCCESS;
                            break;
                            
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                usRow++;
            }
        }
        
        /*
        ** Populate the output message
        */
        
        /* SIR#3582: Do Not write Id Contract       */
        /* if Selected PlcmtType is TYC or JPC      */
        /* SIR 14938:  Added PACE to this scenario  */
        if ((WtcHelperConstants.SQL_SUCCESS == rc) && (0 == cfin07si.getSzCdCnsvcPaymentType().compareTo(FIN_COST_REIM))) {
            //  Allocate memory for DAM Input and Output Structures
            pCMSC21DInputRec = new CMSC21DI();
            
            pCMSC21DOutputRec = new CMSC21DO();
            pCMSC21DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCMSC21DInputRec.setUlIdInvoInvoice(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(0).getUlIdInvoInvoice());
            pCMSC21DInputRec.setDAmtSvcDtlUnitRate(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(0).getDAmtSvcDtlUnitRate() + .0005);
            pCMSC21DInputRec.setUsNbrSvcDtlCsli(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(0).getUsNbrSvcDtlCsli());
            pCMSC21DInputRec.setSzCdSvcDtlLiType(cfin07si.getROWCFIN07SIG_ARRAY().getROWCFIN07SIG(0).getSzCdSvcDtlLiType());
            pCMSC21DInputRec.setTsLastUpdate(cfin07so.getTsLastUpdate());
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
                    
                    //  SIR 21003 - Changed error processing of cses80d
                    // to allow sql-not-found because that is an
                    // acceptible condition.  It should not "blow-up"
                    // at this point.
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
        ARC_PRFServiceStopTime_TUX(cfin07si.getArchInputStruct() , cfin07so.getArchOutputStruct());
        /* SIR 23136 If the placement type is Foster Adoptive, */
        /* Set the valid contract indicator to No, and skip    */
        /* finding an active contract for any service */
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  SIR#3582: There was not an exact match with the the
            // original service input.  It is necessary to find an
            // active facility status and then search for a contract
            // for ANY service in the county of service.
            // FLOCStatus of 'A' means that status is ACTIVE.
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                //  Retrieve Full Name
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfin07so;
    }

}
