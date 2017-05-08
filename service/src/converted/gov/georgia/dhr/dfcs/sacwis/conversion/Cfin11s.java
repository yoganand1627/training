package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE0DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFIN11S.src
**
** Service Name:  CFIN11S- Foster Care AUD service
**
** Description:   This service will Add or Update records to the DELVRD_SVC_DTL
**                table.  CD ACTION CD will determine Add versus Update.  All
**                fields on the DELVRD_SVC_DTL which are not used in CFIN07W
**                will be set to Null or 0 depending upon type.
**                Prior to the above AUD, this service will call CMSC08D two
**                times to check the number of reversals and adjustments.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12-01-1995
**
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   05 Mar 2001 14:04:40  $
**                      $Modtime:   05 Mar 2001 09:37:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/09/96  LEELJ     Added DAM CAUD44D in order to update the Invoice
**                      table with the proper phase and validation flag.
**                      The new invoice time stamp will be returned to
**                      the window.
**
**  01/09/96  GLOORJW   Added if statements around DAMs CAUD04D and
**                      CMSC08D that will only allow the DAMS to be
**                      called if the previous DAM was successful.
**
**  11/16/00  OCHUMD    Added two dams (CLSCB2D.PC and CAUDE0D.PC) per
**                      sir# 15630.  These dams will select from and update
**                      the Delvrd_svc_dtl table by setting the invoice dis-
**                      position and the reversal origin fields to NULL in
**                      the origial and reversal rows respectively when a
**                      reversal is not submitted.
**
**  01/27/04  CORLEYAN  SIR 22425 Removed MSG_FIN_MORE_REV_THAN_ADJ since it
**                      has been deemed unneccesary
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/* 11/16/00 - ochumd added header files for dams CLSCB2D and CAUDE0D */


/*
** Extern for version control table.
*/






public class Cfin11s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String REVERSAL_LI = "R";
    public static final String ADJUSTMENT_LI = "A";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    
    public static final String FIN_CD_INVO_PHASE_PEND = "VLP";
    public static final char FIN_IND_DTL_REJ_ITEM = 'N';
    CFIN11SO CFIN11S(CFIN11SI cfin11si) {
        CFIN11SO cfin11so = new CFIN11SO();
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
        //##  short           rc = FND_SUCCESS;
        int usRow = 0;
        int usInputRow = 0;
        int usRevCounter = 0;
        int usAdjCounter = 0;
        
        CAUD04DI pCAUD04DInputRec = null;
        CAUD04DO pCAUD04DOutputRec = null;
        
        CMSC08DI pCMSC08DInputRec = null;
        CMSC08DO pCMSC08DOutputRec = null;
        
        /*
        ** Added DAM CAUD44D   LJL 1/10/96
        */
        CAUD44DI pCAUD44DInputRec = null;
        CAUD44DO pCAUD44DOutputRec = null;
        
        
        /*
        ** Added DAMS CLSCB2D and CAUDE0D ochumd 11/16/00
        */
        
        CLSCB2DI pCLSCB2DInputRec = null;
        CLSCB2DO pCLSCB2DOutputRec = null;
        
        CAUDE0DI pCAUDE0DInputRec = null;
        CAUDE0DO pCAUDE0DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin11si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        /*
        **  Perform Main Processing
        */
        /*
        ** Added DAM CAUD44D  LJL 1/9/96
        */
        /**************************************************************************
        ** BEGIN: CAUD44D - Update Invoice Phase processing
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD44DInputRec = new CAUD44DI();
        
        pCAUD44DOutputRec = new CAUD44DO();
        pCAUD44DInputRec.setArchInputStruct(cfin11si.getArchInputStruct());
        pCAUD44DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD44DInputRec.setUlIdInvoInvoice(cfin11si.getUlIdInvoInvoice());
        pCAUD44DInputRec.setTsLastUpdate(cfin11si.getTsSysTsLastUpdate2());
        
        if (0 != cfin11si.getSzCdInvoPhase().compareTo(FIN_CD_INVO_PHASE_PEND)) {
            cfin11si.setSzCdInvoPhase(FIN_CD_INVO_PHASE_PEND);
        }
        pCAUD44DInputRec.setSzCdInvoPhase(cfin11si.getSzCdInvoPhase());
        rc = caud44dAUDdam(sqlca, pCAUD44DInputRec, pCAUD44DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                cfin11so.setTsLastUpdate(pCAUD44DOutputRec.getTsLastUpdate());
                
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                
                // End of LUT switch
                
                break;
                
            default :
                Arcxmlerrors// CAPS resource
                .PROCESS_TUX_SQL_ERROR();
                
                
                break;
        }
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            //  Allocate memory for DAM Input and Output Structures
            pCMSC08DInputRec = new CMSC08DI();
            
            pCMSC08DOutputRec = new CMSC08DO();
            
            
            // 
            // Function Prototypes
            // 
            
            pCMSC08DInputRec.setArchInputStruct(cfin11si.getArchInputStruct());
            pCMSC08DInputRec.setSzCdSvcDtlLiType(REVERSAL_LI);
            pCMSC08DInputRec// Rsrc Addr
            .setUlIdInvoInvoice(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usRow).getUlIdInvoInvoice());
            rc = cmsc08dQUERYdam(sqlca, pCMSC08DInputRec, pCMSC08DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    usRevCounter// Counter for Reversals
                     = pCMSC08DOutputRec.getUsSysNbrSvcDtlCount();
                    pCMSC08DInputRec.setArchInputStruct(cfin11si.getArchInputStruct());
                    pCMSC08DInputRec.setSzCdSvcDtlLiType(ADJUSTMENT_LI);
                    pCMSC08DInputRec// Rsrc Phone
                    .setUlIdInvoInvoice(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usRow).getUlIdInvoInvoice());
                    rc = cmsc08dQUERYdam(sqlca, pCMSC08DInputRec, pCMSC08DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            usAdjCounter = pCMSC08DOutputRec.getUsSysNbrSvcDtlCount();// Counter for Adjustments
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            // End of LRB switch
                            
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
            pCAUD04DInputRec = new CAUD04DI();
            
            pCAUD04DOutputRec = new CAUD04DO();
            
            
            //  Count # of reversals and adjustments to be saved.  These numbers will
            // be added to prior counts above to arrive at a grand total (reversals
            // and adjustments currently attached + reversals and adjustments to
            // be saved).
            
            for (usInputRow = 0;(usInputRow < cfin11si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc);usInputRow++) {
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSzCdScrDataAction()) {
                    if (!(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSzCdSvcDtlLiType().compareTo(REVERSAL_LI) != 0)) {
                        usRevCounter// Rsrc Link Child
                        ++;
                    }
                    if (!(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSzCdSvcDtlLiType().compareTo(ADJUSTMENT_LI) != 0)) {
                        usAdjCounter++;
                    }
                }
            }
            
            
            
            
            for (usInputRow = 0;(usInputRow < cfin11si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc);usInputRow++) {
                pCAUD04DInputRec.setArchInputStruct(cfin11si.getArchInputStruct());
                pCAUD04DInputRec// School District
                .getArchInputStruct().setCReqFuncCd(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSzCdScrDataAction());
                pCAUD04DInputRec.setSzCdSvcDtlLiType(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSzCdSvcDtlLiType());
                pCAUD04DInputRec// sch dist code
                .setSzCdSvcDtlService(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSzCdSvcDtlService());
                pCAUD04DInputRec.setSzCdSvcDtlUnitType(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSzCdSvcDtlUnitType());
                pCAUD04DInputRec// Rsrc Link Parent
                .setTsLastUpdate(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getTsLastUpdate());
                pCAUD04DInputRec.setUYrSvcDtlServiceYear(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getUYrSvcDtlServiceYear());
                pCAUD04DInputRec.setSNbrSvcDtlUnitQty(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSNbrSvcDtlUnitQty());
                pCAUD04DInputRec// checks for contracted services
                .setSNbrSvcDtlToDay(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSNbrSvcDtlToDay());
                pCAUD04DInputRec.setSNbrSvcDtlFromDay(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSNbrSvcDtlFromDay());
                pCAUD04DInputRec.setUMoSvcDtlSvcMonth(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getUMoSvcDtlSvcMonth());
                pCAUD04DInputRec.setCIndSvcDtlRejItem(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getCIndSvcDtlRejItem());
                pCAUD04DInputRec.setUlIdSvcDtl(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getUlIdSvcDtl());
                pCAUD04DInputRec.setUlIdResource(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getUlIdResource());
                pCAUD04DInputRec// checked for address record
                .setUlIdPerson(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getUlIdPerson());
                // links to contracts  6/3/96
                
                pCAUD04DInputRec.setUlIdInvoInvoice(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getUlIdInvoInvoice());
                pCAUD04DInputRec.setDAmtSvcDtlUnitRate(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getDAmtSvcDtlUnitRate());
                pCAUD04DInputRec.setDAmtSvcDtlIncome(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getDAmtSvcDtlIncome());
                rc = caud04dAUDdam(sqlca, pCAUD04DInputRec, pCAUD04DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // End of LAD switch
                        
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
                        
                        
                        // Start end of switch # 1 logic
                        
                        break;
                }
            }
        }
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            for (usInputRow = 0;(usInputRow < cfin11si.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.SQL_SUCCESS == rc);usInputRow++) {
                
                //  Analyze error code
                if ((0 == (cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getSNbrSvcDtlUnitQty())) && (cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getCIndSvcDtlRejItem() == FIN_IND_DTL_REJ_ITEM)) {
                    
                    // 
                    // BEGIN: CLSCB2D - To retrieve the records from the Delivered Service
                    // Detail for a given Invoice ID.
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCLSCB2DInputRec = new CLSCB2DI();
                    
                    pCLSCB2DOutputRec = new CLSCB2DO();
                    pCLSCB2DInputRec.setArchInputStruct(cfin11si.getArchInputStruct());
                    pCLSCB2DInputRec.setUlIdInvoInvoice(cfin11si.getROWCFIN11SIG00_ARRAY().getROWCFIN11SIG00(usInputRow).getUlIdInvoInvoice());
                    rc = clscb2dQUERYdam(sqlca, pCLSCB2DInputRec, pCLSCB2DOutputRec);
                    
                    //  Analyze return code
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
                            pCAUDE0DInputRec.setArchInputStruct(cfin11si.getArchInputStruct());
                            pCAUDE0DInputRec.setUlIdSvcDtl(pCLSCB2DOutputRec.getUlIdSvcDtl());
                            pCAUDE0DInputRec.setUlIdSvcDtlRevrsalOrig(pCLSCB2DOutputRec.getUlIdSvcDtlRevrsalOrig());
                            rc = caude0dAUDdam(sqlca, pCAUDE0DInputRec, pCAUDE0DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
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
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin11si.getArchInputStruct() , cfin11so.getArchOutputStruct());
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
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
                
                //  Start performance timer for service
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfin11so;
    }

}
