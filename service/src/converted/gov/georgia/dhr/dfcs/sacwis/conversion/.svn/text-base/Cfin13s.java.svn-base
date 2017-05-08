package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS39DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CFIN13S.src
**
** Service Name:  Cost Reimbursement Detail Retrieve
**
** Description:   Cost Reimbursement Detail Retrieve retrieves columns from
**                the DelvrdSvcDtl and CostReimDtl tables.  It groups
**                DelvrdSvcDtl records by CLSI and compares the quantities
**                to the CostReimDtl table and updates line items that have
**                changed.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12-01-95
**
** Programmer:    adkinsmc
**
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   28 Nov 2000 14:41:40  $
**                      $Modtime:   28 Nov 2000 10:42:58  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/27/01    KRD     SIR 15960 - The flag to determine if the data was
**                      okay was not being set properly if more rows were
**                      returned from CMSC20D than were returned from
**                      CLSS39D.
**
**  01/17/2003  KRD     IMPACT - In CAPS, it was impossible for this service
**                      to be called and return a SQL_NOT_FOUND because the
**                      window could never be accessed.  However, in IMPACT,
**                      we will always call the service.  So, the service
**                      needed to be rewritten to gracefully handle the
**                      SQL_NOT_FOUND error.
**  01/27/03  Srini D   Commenting the if statement part so that szCdrDataAction 
**						is always set to REQ_FUNC_CD_UPDATE as per Anna's request.
**  01/28/03  Srini D   Moved lines 725-732 to between 416 to 424. Basically moved
**						the copying of ulRowQty and bMoreData as per Anna's request.
**
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin13s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String FIN_CD_PAYMENT_TYPE = "CRM";
    CFIN13SO CFIN13S(CFIN13SI cfin13si) {
        CFIN13SO cfin13so = new CFIN13SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i228 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  short           rc = FND_SUCCESS,
        int CLSIcounter = 0;
        int CRDcounter = 0;
        
        CMSC20DI pCMSC20DInputRec = null;
        CMSC20DO pCMSC20DOutputRec = null;
        CLSS39DI pCLSS39DInputRec = null;
        CLSS39DO pCLSS39DOutputRec = null;
        
        
        
        /*
        ** Boolean Variables
        **
        ** IMPACT BEGIN - bCMSC20Dfail is no longer necessary
        */
        boolean bDataError = true;
        rc = ARC_PRFServiceStartTime_TUX(cfin13si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCMSC20DInputRec = new CMSC20DI();
        
        pCMSC20DOutputRec = new CMSC20DO();
        pCMSC20DInputRec.setUlIdInvoInvoice(cfin13si.getUlIdInvoInvoice());
        pCMSC20DInputRec.setSzCdCnsvcPaymentType(FIN_CD_PAYMENT_TYPE);
        pCMSC20DInputRec.getArchInputStruct().setUsPageNbr(cfin13si.getArchInputStruct().getUsPageNbr());
        
        pCMSC20DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin13si.getArchInputStruct().getUlPageSizeNbr());
        rc = cmsc20dQUERYdam(sqlca, pCMSC20DInputRec, pCMSC20DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Flag for the success of CMSC20D
                // IMPACT BEGIN - bCMSC20Dfail is no longer necessary
                // bCMSC20Dfail = FALSE;
                // IMPACT END
                
                //  Populate Output Message
                
                //  Set fields in CFIN13SO to fields in CMSC20DO
                
                
                for (i228 = 0;i228 < CFIN13SO._CFIN13SO__ROWCFIN13SOG_SIZE && 0 != pCMSC20DOutputRec.getROWCMSC20DO_ARRAY().getROWCMSC20DO(i228).getUsNbrCostReimCsli();i228++) {
                    cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(i228).setSzCdCostReimService(pCMSC20DOutputRec.getROWCMSC20DO_ARRAY().getROWCMSC20DO(i228).getSzCdCostReimService());
                    cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(i228).setSzCdCostReimLiType(pCMSC20DOutputRec.getROWCMSC20DO_ARRAY().getROWCMSC20DO(i228).getSzCdCostReimLiType());
                    
                    cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(i228).setUsNbrCostReimCsli(pCMSC20DOutputRec.getROWCMSC20DO_ARRAY().getROWCMSC20DO(i228).getUsNbrCostReimCsli());
                    cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(i228).setUNbrCostReimUnitQty(pCMSC20DOutputRec.getROWCMSC20DO_ARRAY().getROWCMSC20DO(i228).getUNbrCostReimUnitQty());
                    cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(i228).setDAmtCostReimOffItem(pCMSC20DOutputRec.getROWCMSC20DO_ARRAY().getROWCMSC20DO(i228).getDAmtCostReimOffItem());
                    cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(i228).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                cfin13so.getArchOutputStruct().setBMoreDataInd(pCMSC20DOutputRec.getArchOutputStruct().getBMoreDataInd());
                cfin13so.getArchOutputStruct().setUlRowQty(pCMSC20DOutputRec.getArchOutputStruct().getUlRowQty());
                
                //  CLSS39D- Retrieve from Cost Reimbursement table
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSS39DInputRec = new CLSS39DI();
                
                pCLSS39DOutputRec = new CLSS39DO();
                pCLSS39DInputRec.setUlIdInvoInvoice(cfin13si.getUlIdInvoInvoice());
                pCLSS39DInputRec.getArchInputStruct().setUsPageNbr(cfin13si.getArchInputStruct().getUsPageNbr());
                pCLSS39DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin13si.getArchInputStruct().getUlPageSizeNbr());
                rc = clss39dQUERYdam(sqlca, pCLSS39DInputRec, pCLSS39DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        if ((pCLSS39DOutputRec.getArchOutputStruct().getUlRowQty() > 0) && (cfin13so.getArchOutputStruct().getUlRowQty() > 0)) {
                            //  Loop through CLSS39D unitl no more rows
                            for (CRDcounter = 0;CRDcounter < pCLSS39DOutputRec.getArchOutputStruct().getUlRowQty() && 0 != pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getUsNbrCostReimCsli();CRDcounter++) {
                                //  Loop through the output message from Delved Svc Dtl until no more rows
                                
                                
                                for (CLSIcounter = 0;CLSIcounter < pCMSC20DOutputRec.getArchOutputStruct().getUlRowQty() && 0 != pCMSC20DOutputRec.getROWCMSC20DO_ARRAY().getROWCMSC20DO(CLSIcounter).getUsNbrCostReimCsli();CLSIcounter++) {
                                    if ((pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getUsNbrCostReimCsli() == cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).getUsNbrCostReimCsli()) && (0 == pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getSzCdCostReimLiType().compareTo(cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).getSzCdCostReimLiType()))) {
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setSzCdCostReimService(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getSzCdCostReimService());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setSzCdCostReimLiType(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getSzCdCostReimLiType());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setSzCdCostReimInvoDisptn(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getSzCdCostReimInvoDisptn());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setTsLastUpdate(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getTsLastUpdate());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setCIndCostReimRejItm(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getCIndCostReimRejItm());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setUsNbrCostReimCsli(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getUsNbrCostReimCsli());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setDAmtCostReimAdminAll(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getDAmtCostReimAdminAll());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setDAmtCostReimEquip(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getDAmtCostReimEquip());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setDAmtCostReimFrgBenft(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getDAmtCostReimFrgBenft());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setDAmtCostReimDtlOther(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getDAmtCostReimDtlOther());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setDAmtCostReimSalary(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getDAmtCostReimSalary());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setDAmtCostReimSupply(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getDAmtCostReimSupply());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setDAmtCostReimTravel(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getDAmtCostReimTravel());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setUlIdCostReim(pCLSS39DOutputRec.getROWCLSS39DO_ARRAY().getROWCLSS39DO(CRDcounter).getUlIdCostReim());
                                        cfin13so.getROWCFIN13SOG_ARRAY().getROWCFIN13SOG(CLSIcounter).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        //                  } /* end if */
                                        //End of Change Srini D
                                        bDataError = false;
                                        break;
                                    }
                                }
                            }
                            if (bDataError) {
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_FIN_COST_REIM_NO_DS;
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        
                        
                        //  End Variable Declaration 
                        
                        //  Start Performance Timer
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = NO_DATA_FOUND;
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
        ARC_PRFServiceStopTime_TUX(cfin13si.getArchInputStruct() , cfin13so.getArchOutputStruct());
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
        return cfin13so;
    }

}
