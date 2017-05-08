package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC12DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC03DO;
/**************************************************************************
**
** Module File:    CFIN21S.src
**
** Service Name:   Payment History List Retrieve
**
** Description:   This service will function in two modes.  If the
**                ScrFinPayhistSearch passed into the service is equal
**                to CLIENT, the service will call CLSS34D- (HstLstPrsnRtrv)
**                to retrieve rows for the CFIN11W Listbox, CMSC12D-
**                (DelvrdSvcDtlTotal) to retrieve the total amount of
**                payments, and CCMN44D- (Person Rtrv) to retrieve the
**                client's name for CFIN11W's window title.  If the
**                ScrFinPayhistSearch passed into the service is equal to
**                a RESOURCE, the service will call CLSS33D- (HstLstRsrcRtrv)
**                to retrieve rows of invoices, CMSC11D-
**                (Invo Warrant Total) to retrieve the total amount of
**                payments, and CRES04D- (Resource Rtrv) to validate the
**                resource id.If the ScrFinPayhistSearch passed into the
**                service is equal to CONTRACT, the service will call
**                CLSS33D- (HstLstRsrcRtrv) to retrieve rows of invoices,
**                (Invo Warrant Total) to retrieve the total amount of
**                CMSC11D-payments, and CSEC03D- (Contract Info) to
**                validate the contract id.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  November 22, 1995
**
** Programmer:    Elizabeth Crystal
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Sep 1996 17:56:50  $
**                      $Modtime:   12 Sep 1996 13:50:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/13/96  MCRAEBS   SIR 3908 - We need to send the InvoValid Amount back
**                      to the Client, not the Warrant Amount.  BSM
**
**  02/24/03  Srini     Set the rc value to explain code as we check on rc
**                      value in the TUX_CHECK_APPL_STATUS macro.
**  05/13/04  gerryc    Added logic for contract id search.  Payment
**                      history id is passed to the DAMs instead of resource id,
**                      and a search by code is passed (resource or contract).
**                      Modularized DAM calls.  Also added in CSEC03 to
**                      validate the contract id.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin21s {
    static final String CLIENT2 = "0";
    static final String RESOURCE = "1";
    static final String CONTRACT1 = "2";
    CFIN21SO CFIN21S(CFIN21SI cfin21si) {
        CFIN21SO cfin21so = new CFIN21SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        public public public int i232 = 0;
        
        /*
        ** Declare local variables
        */
        
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        /*
        **  The CCMN44D (Person Rtrv) will retrieve the CLIENT's name for CFIN11W's
        **  window title.
        */
        
        CLSS34DI pCLSS34DInputRec = null;
        CLSS34DO pCLSS34DOutputRec = null;
        
        /*
        **  The CLSS34D (Hst Lst Prsn Rtrv) will retrieve all the delivered service
        **  detail records, within a date range, linked to a person.  The delivered
        **  service detail records are linked to an invoice, contract and resource
        **  to get the remainder of the information.
        */
        
        CMSC12DI pCMSC12DInputRec = null;
        CMSC12DO pCMSC12DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin21si.getArchInputStruct());
        
        if (!(cfin21si.getSzScrFinPayhistSearch().compareTo(CLIENT2) != 0)) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN44DInputRec = new CCMN44DI();
            
            pCCMN44DOutputRec = new CCMN44DO();
            pCCMN44DInputRec.setUlIdPerson(cfin21si.getUlScrFinPayhistId());
            
            
            //  Call CSEC11D
            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfin21so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                    
                    
                    // Retrieve CLIENT's Payment History
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCLSS34DInputRec = new CLSS34DI();
                    
                    pCLSS34DOutputRec = new CLSS34DO();
                    pCLSS34DInputRec.setUlIdPerson(cfin21si.getUlScrFinPayhistId());
                    pCLSS34DInputRec.setDtScrNbrFinPayhistFrom(cfin21si.getDtScrNbrFinPayhistFrom());
                    pCLSS34DInputRec.setDtScrDtFinPayhistTo(cfin21si.getDtScrDtFinPayhistTo());
                    pCLSS34DInputRec.getArchInputStruct().setUsPageNbr(cfin21si.getArchInputStruct().getUsPageNbr());
                    pCLSS34DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin21si.getArchInputStruct().getUlPageSizeNbr());
                    
                    rc = clss34dQUERYdam(sqlca, pCLSS34DInputRec, pCLSS34DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Populate Output Message
                            
                            
                            //  Set fields in CFIN21SO to fields in CLSS34DO
                            
                            for (i232 = 0;i232 < pCLSS34DOutputRec.getArchOutputStruct().getUlRowQty();i232++) {
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setUlIdInvoInvoice(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getUlIdInvoInvoice());
                                
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setDtDtInvoWarrantDate(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getDtDtInvoWarrantDate());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setSzNmResource(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getSzNmResource());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setDAmtSvcDtlFeePaid(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getDAmtSvcDtlFeePaid());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setDAmtSvcDtlIncome(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getDAmtSvcDtlIncome());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setDAmtSvcDtlUnitRate(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getDAmtSvcDtlUnitRate());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setSzCdSvcDtlService(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getSzCdSvcDtlService());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setSzCdSvcDtlUnitType(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getSzCdSvcDtlUnitType());
                                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                                // SQL error returned from the DAM.
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setSNbrSvcDtlFromDay(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getSNbrSvcDtlFromDay());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setSNbrSvcDtlToDay(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getSNbrSvcDtlToDay());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setSNbrSvcDtlUnitQty(pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getSNbrSvcDtlUnitQty());
                                cfin21so.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(i232).setDAmtInvoValidAmount(((pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getDAmtSvcDtlUnitRate() * pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getSNbrSvcDtlUnitQty()) - pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getDAmtSvcDtlFeePaid() - pCLSS34DOutputRec.getROWCLSS34DO_ARRAY().getROWCLSS34DO(i232).getDAmtSvcDtlIncome()));
                            }
                            cfin21so.getArchOutputStruct().setBMoreDataInd(pCLSS34DOutputRec.getArchOutputStruct().getBMoreDataInd());
                            cfin21so.getArchOutputStruct().setUlRowQty(pCLSS34DOutputRec.getArchOutputStruct().getUlRowQty());
                            
                            
                            //  Retrieve Total Information
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCMSC12DInputRec = new CMSC12DI();
                            
                            pCMSC12DOutputRec = new CMSC12DO();
                            pCMSC12DInputRec.setUlIdPerson(cfin21si.getUlScrFinPayhistId());
                            pCMSC12DInputRec.setDtScrNbrFinPayhistFrom(cfin21si.getDtScrNbrFinPayhistFrom());
                            pCMSC12DInputRec.setDtScrDtFinPayhistTo(cfin21si.getDtScrDtFinPayhistTo());
                            rc = cmsc12dQUERYdam(sqlca, pCMSC12DInputRec, pCMSC12DOutputRec);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    cfin21so.setDScrAmtFinPayhistTotpy(pCMSC12DOutputRec.getDScrAmtFinPayhistTotpy());
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                                    
                            }
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                            
                            
                            //  Call CSEC12D
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_FIN_INVALID_PRSN_ID;
                    
                    
                    //  Set rc to ARC_SUCCESS
                    rc = pServiceStatus.explan_code;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        
        /* if RESOURCE */
        else if (!(cfin21si.getSzScrFinPayhistSearch().compareTo(RESOURCE) != 0)) {
            
            
            //  Set rc to ARC_SUCCESS
            //03/17/03  Srini: Modified to return the error message instead of success by 
            //		 setting the rc to MSG_CON_NO_ACTIVE_CONTRACT.
            //                rc = ARC_SUCCESS;
            rc = Cfad08s.CallCRES04D(cfin21si, cfin21so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    
                    //  Set rc to ARC_SUCCESS
                    //03/17/03  Srini: Modified to return the error message instead of success by 
                    //		 setting the rc to MSG_CON_NO_ACTIVE_CONTRACT.
                    //                rc = ARC_SUCCESS;
                    rc = CallCLSS33D(cfin21si, cfin21so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            rc = CallCMSC11D(cfin21si, cfin21so, pServiceStatus);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.ARC_SUCCESS:
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    break;
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            
                            break;
                            
                            
                            
                    }
                case Messages.MSG_FIN_INVALID_RSRC_ID:
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    break;
            }
        }
        /*end if RESOURCE*/
        
        /* if CONTRACT */
        else {
            rc = CallCSEC03D(cfin21si, cfin21so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    
                    //  Start Performance Timer
                    rc = CallCLSS33D(cfin21si, cfin21so, pServiceStatus);
                    
                    //  Analyze error code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            rc = CallCMSC11D(cfin21si, cfin21so, pServiceStatus);
                            
                            //  Analyze error code
                            switch (rc) {
                                case WtcHelperConstants.ARC_SUCCESS:
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    break;
                            }
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            break;// SQL_SUCCESS for CCMN60D
                    }
                case Messages.MSG_FIN_INVLD_CNTRCT_ID:
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    break;// break default for CCMN43D
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfin21si.getArchInputStruct() , cfin21so.getArchOutputStruct());
        
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
        return cfin21so;
    }

    static int CallCLSS33D(CFIN21SI pInputMsg387, CFIN21SO pOutputMsg353, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int j = 0;/* loop counter */
        
        /*
        ** Declare local variables
        */
        CLSS33DI pCLSS33DInputRec = null;
        CLSS33DO pCLSS33DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS33DInputRec = new CLSS33DI();
        
        pCLSS33DOutputRec = new CLSS33DO();
        pCLSS33DInputRec.setBWcdCdSearchBy(pInputMsg387.getSzScrFinPayhistSearch());
        pCLSS33DInputRec.setUlScrFinPayhistId(pInputMsg387.getUlScrFinPayhistId());
        pCLSS33DInputRec.setDtScrNbrFinPayhistFrom(pInputMsg387.getDtScrNbrFinPayhistFrom());
        pCLSS33DInputRec.setDtScrDtFinPayhistTo(pInputMsg387.getDtScrDtFinPayhistTo());
        pCLSS33DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg387.getArchInputStruct().getUsPageNbr());
        pCLSS33DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg387.getArchInputStruct().getUlPageSizeNbr());
        rc = clss33dQUERYdam(sqlca, pCLSS33DInputRec, pCLSS33DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Populate Output Message
                
                for (j = 0;j < pCLSS33DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                    pOutputMsg353.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(j).setUlIdInvoInvoice(pCLSS33DOutputRec.getROWCLSS33DO_ARRAY().getROWCLSS33DO(j).getUlIdInvoInvoice());
                    pOutputMsg353.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(j).setDtDtInvoWarrantDate(pCLSS33DOutputRec.getROWCLSS33DO_ARRAY().getROWCLSS33DO(j).getDtDtInvoWarrantDate());
                    
                    pOutputMsg353.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(j).setSzNmResource(pCLSS33DOutputRec.getROWCLSS33DO_ARRAY().getROWCLSS33DO(j).getSzNmResource());
                    pOutputMsg353.getROWCFIN21SOG00_ARRAY().getROWCFIN21SOG00(j).setDAmtInvoValidAmount(pCLSS33DOutputRec.getROWCLSS33DO_ARRAY().getROWCLSS33DO(j).getDAmtInvoValidAmount());
                }
                pOutputMsg353.getArchOutputStruct().setBMoreDataInd(pCLSS33DOutputRec.getArchOutputStruct().getBMoreDataInd());
                pOutputMsg353.getArchOutputStruct().setUlRowQty(pCLSS33DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                //  Call architecture function to retreive the current date.
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                break;
        }
        return rc;
    }

    static int CallCMSC11D(CFIN21SI pInputMsg388, CFIN21SO pOutputMsg354, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CMSC11DI pCMSC11DInputRec = null;
        CMSC11DO pCMSC11DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCMSC11DInputRec = new CMSC11DI();
        
        pCMSC11DOutputRec = new CMSC11DO();
        pCMSC11DInputRec.setBWcdCdSearchBy(pInputMsg388.getSzScrFinPayhistSearch());
        pCMSC11DInputRec.setUlScrFinPayhistId(pInputMsg388.getUlScrFinPayhistId());
        pCMSC11DInputRec.setDtScrNbrFinPayhistFrom(pInputMsg388.getDtScrNbrFinPayhistFrom());
        pCMSC11DInputRec.setDtScrDtFinPayhistTo(pInputMsg388.getDtScrDtFinPayhistTo());
        rc = cmsc11dQUERYdam(sqlca, pCMSC11DInputRec, pCMSC11DOutputRec);
        
        /* 
        ** 11870 - An entry exists if the query was successful and 
        ** the DAM has deleted the entry from the stage
        ** person link table.
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg354.setDScrAmtFinPayhistTotpy(pCMSC11DOutputRec.getDScrAmtFinPayhistTotpy());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCRES04D(CFIN21SI pInputMsg389, CFIN21SO * pOutputMsg355, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCRES04DInputRec = new CRES04DI();
        
        pCRES04DOutputRec = new CRES04DO();
        pCRES04DInputRec.setUlIdResource(pInputMsg389.getUlScrFinPayhistId());
        
        
        /*
        ** Call CSEC66D
        */
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_FIN_INVALID_RSRC_ID;
                rc = pServiceStatus.explan_code;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCSEC03D(CFIN21SI pInputMsg390, CFIN21SO * pOutputMsg356, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSEC03DI pCSEC03DInputRec = null;
        CSEC03DO pCSEC03DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSEC03DInputRec = new CSEC03DI();
        
        pCSEC03DOutputRec = new CSEC03DO();
        pCSEC03DInputRec.setUlIdContract(pInputMsg390.getUlScrFinPayhistId());
        rc = csec03dQUERYdam(sqlca, pCSEC03DInputRec, pCSEC03DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_FIN_INVLD_CNTRCT_ID;
                
                //  Call CINV29D
                rc = pServiceStatus.explan_code;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                break;
        }
        return rc;
    }

}
