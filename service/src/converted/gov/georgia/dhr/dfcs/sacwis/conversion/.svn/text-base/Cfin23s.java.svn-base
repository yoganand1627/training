package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC57DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:    CFIN23S.src
**
** Service Name:   Financial Account List Retrieve
**
** Description:   Financial Account List Retrieve retrieves all records from
**                the FINANCIAL ACCOUNT table based upon the search criteria
**                passed into the service.
**
** Environment:   HP-UX V9.0
**                HP-UX Ansi C Compiler
**
** Date Created:  11-16-95
**
** Programmer:    adkinsmc
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:54:22  $
**                      $Modtime:   30 Mar 1996 00:14:08  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  01/29/2003  KRD     IMPACT - The Financial Account dialog is being
**                      enhanced to support accounts for APS.  Needed to
**                      add a new field to the service and DAM to enable
**                      searching by program.  Required changes to the
**                      main service function as well as
**                      startElementCFIN23SI() and endElementCFIN23SI().
**
**  05/20/2003  KRD     SIR 17005 - Need to determine, before the search,
**                      whether or not the person is a member of a stage
**                      in the given program.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin23s {
    CFIN23SO CFIN23S(CFIN23SI cfin23si) {
        CFIN23SO cfin23so = new CFIN23SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i233 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CDYN13DI pCDYN13DInputRec = null;
        CDYN13DO pCDYN13DOutputRec = null;
        
        /*
        ** SIR 17005 - Add new DAM input/output records
        */
        CMSC57DI pCMSC57DInputRec = null;
        CMSC57DO pCMSC57DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfin23si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** SIR 17005 - Add call to DAM CMSC57D
        */
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCMSC57DInputRec = new CMSC57DI();
        
        pCMSC57DOutputRec = new CMSC57DO();
        pCMSC57DInputRec.setArchInputStruct(cfin23si.getArchInputStruct());
        pCMSC57DInputRec.setUlIdPerson(cfin23si.getUlIdPerson());
        pCMSC57DInputRec.setSzCdStageProgram(cfin23si.getSzCdFinAcctProgram());
        rc = cmsc57dQUERYdam(sqlca, pCMSC57DInputRec, pCMSC57DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Only get the previous version information if the
                // version number modified is one (there is no
                // previous version information)
                if (0 < pCMSC57DOutputRec.getUlSysNbrGenericCntr()) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCDYN13DInputRec = new CDYN13DI();
                    
                    pCDYN13DOutputRec = new CDYN13DO();
                    pCDYN13DInputRec.setArchInputStruct(cfin23si.getArchInputStruct());
                    pCDYN13DInputRec.setSzCdFinAcctRegion(cfin23si.getSzScrCdFinAcctReg());
                    pCDYN13DInputRec.setSzCdFinAcctType(cfin23si.getSzScrCdAcctTypeSearch());
                    pCDYN13DInputRec.setSzCdLegalStatCnty(cfin23si.getSzScrCdFinAcctPersCnty());
                    pCDYN13DInputRec.setUlIdPerson(cfin23si.getUlIdPerson());
                    pCDYN13DInputRec.setSzCdFinAcctProgram(cfin23si.getSzCdFinAcctProgram());
                    pCDYN13DInputRec.getArchInputStruct().setUsPageNbr(cfin23si.getArchInputStruct().getUsPageNbr());
                    pCDYN13DInputRec.getArchInputStruct().setUlPageSizeNbr(cfin23si.getArchInputStruct().getUlPageSizeNbr());
                    
                    
                    //  Call CCMN60D
                    rc = cdyn13dQUERYdam(sqlca, pCDYN13DInputRec, pCDYN13DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            
                            //  Populate Output Message
                            
                            //  Set fields in CFIN23SO.G00 to fields in CDYN13DO
                            
                            for (i233 = 0;i233 < pCDYN13DOutputRec.getArchOutputStruct().getUlRowQty();i233++) {
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setLdAmtFinAcctBalance(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getLdAmtFinAcctBalance());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setSzCdFinAcctStatus(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getSzCdFinAcctStatus());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setSzCdFinAcctType(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getSzCdFinAcctType());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setDtDtFinAcctBalanceDate(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getDtDtFinAcctBalanceDate());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setUlIdFinAcct(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getUlIdFinAcct());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setUlIdPerson(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getUlIdPerson());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setSzNbrFinAcctAccount(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getSzNbrFinAcctAccount());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setUNbrFinAcctTransCount(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getUNbrFinAcctTransCount());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setSzCdLegalStatCnty(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getSzCdLegalStatCnty());
                                cfin23so.getROWCFIN23SOG00_ARRAY().getROWCFIN23SOG00(i233).setSzScrNmGenericFullName(pCDYN13DOutputRec.getROWCDYN13DO_ARRAY().getROWCDYN13DO(i233).getSzNmPersonFull());
                            }
                            cfin23so.getArchOutputStruct().setBMoreDataInd(pCDYN13DOutputRec.getArchOutputStruct().getBMoreDataInd());
                            cfin23so.getArchOutputStruct().setUlRowQty(pCDYN13DOutputRec.getArchOutputStruct().getUlRowQty());
                            
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
                }
                
                
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
        ARC_PRFServiceStopTime_TUX(cfin23si.getArchInputStruct() , cfin23so.getArchOutputStruct());
        
        /*
        ** Only validate the amount and amount used for
        ** the two versions if the modified version
        ** is not version one
        */
        /*
        ** TLC 09/23/96 And only perform this validation for Contracts
        ** with budget limits
        */
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            // 
            // Begin validation processing
            // 
            
            // Salary
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
        return cfin23so;
    }

}
