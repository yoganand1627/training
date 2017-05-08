package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CCON08S.src
**
** Service Name:  CCON08S
**
** Description:   This service will update all columns for a
**                Contract/Contract Period/Contract Version combination
**                in the Contract Version table.  The service can add,
**                modify, or delete a row in the Contract Version table.
**
**                If the row passed has an action indicator of update
**                and a Lock Modification indicator of yes
**                numerous actions will take place.
**                First, The service information will be retrieved for
**                the modified row.  Second, if the version is not
**                version number one, the services information will be
**                retrieved for the previous version.  If all of the
**                current version service line item amounts are greater
**                than the previous version's line item amounts used,
**                the current version's line item amounts used will be
**                updated with the previous version's amount used values,
**                (This comparison is only done for versions other than
**                the first version) the current contract worker's name,
**                and the new row action indicator will be set to No.
**                In the case of the first version, only the workers
**                name and new row action indicator (set to No) will
**                be updated.
**                In addition, any service rows that did not exist in
**                the previous version will be updated with the
**                current contract worker's name, and the new row action
**                indicator will be set to No.
**                This allows the finance work to be updated to the most
**                recent locked version.  Setting all of the locked
**                version service rows to No assures that new versions
**                will contain at least as many service line items
**                as the previous version in the same order with the
**                same service line item number.
**
**                If the version end dates are modified for the
**                row passed, the corresponding county dates are modified
**                in order to reflect the new version end dates as well.
**
**                For any Contract Version that has a data action of add,
**                the service will duplicate the previous Version's service
**                line items and corresponding contracted counties in a
**                mimicking a new using feature.  Thus, this only works
**                if the version is not the first version.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/24/95
**
** Programmer:    GLOORJW
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   23 Sep 1996 14:52:40  $
**                      $Modtime:   23 Sep 1996 14:05:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/07/95  GLOORJW   Moved memset of the previous version retrieval
**                      variables before the - if not first version
**                      statement in order to always set the variable
**                      to NULL since they are used later and may be
**                      filled with garbage.
**
**  01/30/96  FELLERDL  SIR 3013 - Compare Effective date to the closure date
**
**  09/19/96  CHESSMTL  We do not want to check if the AMT_CNSVC_UNIT_RATE
**                      field is < AMT_CNSVC_UNIT_RATE_USED before copying
**                      over the budget info (on contract service) for Cost
**                      Reimbursement line items, and we don't want to check
**                      the amount used columns at all for contracts without
**                      budgets
**  02/13/03  Srini D   set the rc value to explan_code(SSM_VERS_BEFORE_CLOSURE)
**			            so that PROCESS_TUX_RC_ERROR can handle it
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon08s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int FIRST_VERSION = 1;
    public static final int INITIAL_PAGE = 1;
    
    /* TLC 09/20/96 Added variable for fix */
    public static final String CRM_PAYMENT_TYPE = "CRM";
    CCON08SO CCON08S(CCON08SI ccon08si) {
        CCON08SO ccon08so = new CCON08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  short rc = FND_SUCCESS;
        
        CAUD15DI pCAUD15DInputRec = null;
        CAUD15DO pCAUD15DOutputRec = null;
        CLSS11DI pCLSS11DInputRec = null;
        CLSS11DO pCLSS11DOCurrentVersion = null;
        CLSS11DO pCLSS11DOPreviousVersion = null;
        CAUD17DI pCAUD17DInputRec = null;
        CAUD17DO pCAUD17DOutputRec = null;
        CLSS37DI pCLSS37DInputRec = null;
        CLSS37DO pCLSS37DOutputRec = null;
        CAUD08DI pCAUD08DInputRec = null;
        CAUD08DO pCAUD08DOutputRec = null;
        CLSS06DI pCLSS06DInputRec = null;
        CLSS06DO pCLSS06DOutputRec = null;
        
        int usVersRow = 0;
        int usVersionRow = 0;
        int usServiceRow = 0;
        int usCountyRow = 0;
        int sPeriodCtr = 0;
        int lRC7 = 0;
        
        /*
        ** Start performance timer for service. All performance functions always
        ** return success so there is no need to check status.
        */
        rc = ARC_PRFServiceStartTime_TUX(ccon08si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /********************************************************
        **  SIR 3013 - Compare Effective date to the closure date
        *********************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS06DInputRec = new CLSS06DI();
        
        pCLSS06DOutputRec = new CLSS06DO();
        pCLSS06DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
        pCLSS06DInputRec.setUlIdContract(ccon08si.getUlIdContract());
        
        
        /**************************************************************************
        ** Service Macro Definitions
        ***************************************************************************/
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pCLSS06DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS06DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS06DO._CLSS06DO__ROWCLSS06DO_SIZE);
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check buffer size 
        */
        /*
        ** Process error message and return to client 
        */
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields 
        */
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        rc = clss06dQUERYdam(sqlca, pCLSS06DInputRec, pCLSS06DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Find row returned from CLSS06Dam where Period is equal to
                // Period in the Version List Window
                for (sPeriodCtr = 0;(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(sPeriodCtr).getUlNbrCnperPeriod() != ccon08si.getUlNbrCnverPeriod());sPeriodCtr++) {
                    ;
                }
                //  The Closure Date of a Period cannot be before the Effective
                // Date of the latest version in that period (i.e. - the
                // version to be added
                while ((usVersRow < ccon08si.getArchInputStruct().getUlPageSizeNbr()) && (SUCCESS == pServiceStatus.explan_code)) {
                    lRC7 = ARC_UTLCompareDateAndTime((FndInt3date) & pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(sPeriodCtr).getDtDtCnperClosure() , (char) 0, (FndInt3date) & ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersRow).getDtDtCnverEffective() , (char) 0);
                    
                    if (lRC7 <= 0) {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.SSM_VERS_BEFORE_CLOSURE;
                        rc = Messages.SSM_VERS_BEFORE_CLOSURE;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    }
                    else {
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                    }
                    usVersRow++;
                }
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        /******************************************************
        **  End SIR 3013
        ******************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD15DInputRec = new CAUD15DI();
        
        pCAUD15DOutputRec = new CAUD15DO();
        pCAUD15DInputRec.setUlIdCntrctWkr(ccon08si.getUlIdCntrctWkr());
        pCAUD15DInputRec.setUlIdContract(ccon08si.getUlIdContract());
        pCAUD15DInputRec.setUlNbrCnverPeriod(ccon08si.getUlNbrCnverPeriod());
        
        while ((usVersionRow < ccon08si.getArchInputStruct().getUlPageSizeNbr()) && (SUCCESS == pServiceStatus.explan_code)) {
            pCAUD15DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
            pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getSzCdScrDataAction());
            pCAUD15DInputRec.setUlNbrCnverVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion());
            pCAUD15DInputRec.setUlIdCnver(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlIdCnver());
            pCAUD15DInputRec.setDtDtCnverEffective(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getDtDtCnverEffective());
            pCAUD15DInputRec.setDtDtCnverEnd(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getDtDtCnverEnd());
            pCAUD15DInputRec.setDtDtCnverCreate(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getDtDtCnverCreate());
            pCAUD15DInputRec.setCIndCnverVerLock(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getCIndCnverVerLock());
            pCAUD15DInputRec.setUlNbrCnverNoShowPct(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverNoShowPct());
            pCAUD15DInputRec.setSzTxtCnverComment(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getSzTxtCnverComment());
            pCAUD15DInputRec.setTsLastUpdate(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getTsLastUpdate());
            rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    if ((FND_YES == ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getBSysIndVersionLockMod()) && (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getSzCdScrDataAction())) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCLSS11DInputRec = new CLSS11DI();
                        
                        pCLSS11DOCurrentVersion = new CLSS11DO();
                        
                        pCLSS11DOPreviousVersion = new CLSS11DO();
                        if (FIRST_VERSION != ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion()) {
                            pCLSS11DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                            pCLSS11DInputRec.setUlIdContract(ccon08si.getUlIdContract());
                            pCLSS11DInputRec.setUlNbrCnsvcPeriod(ccon08si.getUlNbrCnverPeriod());
                            pCLSS11DInputRec.setUlNbrCnsvcVersion((ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion() - 1));
                            pCLSS11DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS11DO._CLSS11DO__ROWCLSS11DO_SIZE);
                            
                            pCLSS11DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                            rc = clss11dQUERYdam(sqlca, pCLSS11DInputRec, pCLSS11DOPreviousVersion);
                        }
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                pCLSS11DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                                pCLSS11DInputRec.setUlIdContract(pCAUD15DInputRec.getUlIdContract());
                                
                                //## BEGIN TUX/XML: Declare XML variables 
                                pCLSS11DInputRec.setUlNbrCnsvcPeriod(pCAUD15DInputRec.getUlNbrCnverPeriod());
                                pCLSS11DInputRec.setUlNbrCnsvcVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion());
                                pCLSS11DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS11DO._CLSS11DO__ROWCLSS11DO_SIZE);
                                pCLSS11DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                rc = clss11dQUERYdam(sqlca, pCLSS11DInputRec, pCLSS11DOCurrentVersion);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Initialize the service row counter to zero
                                        usServiceRow = 0;
                                        
                                        //  Service used AUD amount processing
                                        while ((usServiceRow < pCLSS11DOPreviousVersion.getArchOutputStruct().getUlRowQty()) && (SUCCESS == pServiceStatus.explan_code)) {
                                            //  As long as the record group element is not blank...
                                            if ((FIRST_VERSION != ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion()) && (SUCCESS == pServiceStatus.explan_code) && (INDICATOR_YES == ccon08si.getCIndCntrctBudgLimit())) {
                                                
                                                if (pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalaryUsed() > pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalary()) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CON_INVALID_BUDG;
                                                }
                                                if ((pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquipUsed() > pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquip()) && (SUCCESS == pServiceStatus.explan_code)) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CON_INVALID_BUDG;
                                                }
                                                if ((pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenftUsed() > pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenft()) && (SUCCESS == pServiceStatus.explan_code)) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CON_INVALID_BUDG;
                                                }
                                                
                                                if ((pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupplyUsed() > pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupply()) && (SUCCESS == pServiceStatus.explan_code)) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CON_INVALID_BUDG;
                                                }
                                                if ((pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravelUsed() > pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravel()) && (SUCCESS == pServiceStatus.explan_code)) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CON_INVALID_BUDG;
                                                }
                                                if (0 != CRM_PAYMENT_TYPE.compareTo(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcPaymentType())) {
                                                    if ((pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRateUsed() > pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRate()) && (SUCCESS == pServiceStatus.explan_code)) {
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_CON_INVALID_BUDG;
                                                    }
                                                }
                                                if ((pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOtherUsed() > pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOther()) && (SUCCESS == pServiceStatus.explan_code)) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CON_INVALID_BUDG;
                                                }
                                            }
                                            if (SUCCESS == pServiceStatus.explan_code) {
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCAUD17DInputRec = new CAUD17DI();
                                                
                                                pCAUD17DOutputRec = new CAUD17DO();
                                                pCAUD17DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                pCAUD17DInputRec.setUlIdCntrctWkr(ccon08si.getUlIdCntrctWkr());
                                                pCAUD17DInputRec.setUlIdContract(ccon08si.getUlIdContract());
                                                pCAUD17DInputRec.setUlNbrCnsvcPeriod(ccon08si.getUlNbrCnverPeriod());
                                                pCAUD17DInputRec.setUlNbrCnsvcVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion());
                                                pCAUD17DInputRec.setUlNbrCnsvcLineItem(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLineItem());
                                                pCAUD17DInputRec.setUlIdCnsvc(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlIdCnsvc());
                                                pCAUD17DInputRec.setSzCdCnsvcService(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcService());
                                                pCAUD17DInputRec.setSzCdCnsvcPaymentType(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcPaymentType());
                                                pCAUD17DInputRec.setSzNbrCnsvcUnitType(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzNbrCnsvcUnitType());
                                                pCAUD17DInputRec.setUlNbrCnsvcFedMatch(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcFedMatch());
                                                pCAUD17DInputRec.setUlNbrCnsvcLocalMatch(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLocalMatch());
                                                pCAUD17DInputRec.setUlNbrCnsvcUnitRate(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcUnitRate());
                                                pCAUD17DInputRec.setUlAmtCnsvcEquip(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquip());
                                                pCAUD17DInputRec.setUlAmtCnsvcFrgBenft(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenft());
                                                pCAUD17DInputRec.setUlAmtCnsvcOther(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOther());
                                                pCAUD17DInputRec.setUlAmtCnsvcSalary(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalary());
                                                pCAUD17DInputRec.setUlAmtCnsvcSupply(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupply());
                                                pCAUD17DInputRec.setUlAmtCnsvcTravel(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravel());
                                                pCAUD17DInputRec.setUlAmtCnsvcUnitRate(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRate());
                                                pCAUD17DInputRec.setTsLastUpdate(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getTsLastUpdate());
                                                if (FIRST_VERSION != ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion()) {
                                                    pCAUD17DInputRec.setUlAmtCnsvcAdminAllUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcAdminAllUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcEquipUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquipUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcFrgBenftUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenftUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcOffItemUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOffItemUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcOtherUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOtherUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcSalaryUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalaryUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcSupplyUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupplyUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcTravelUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravelUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcUnitRateUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRateUsed());
                                                }
                                                else {
                                                    pCAUD17DInputRec.setUlAmtCnsvcAdminAllUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcAdminAllUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcEquipUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquipUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcFrgBenftUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenftUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcOffItemUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOffItemUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcOtherUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOtherUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcSalaryUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalaryUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcSupplyUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupplyUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcTravelUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravelUsed());
                                                    pCAUD17DInputRec.setUlAmtCnsvcUnitRateUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRateUsed());
                                                }
                                                pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                                
                                                //  Call DAM
                                                rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                                
                                                //  Analyze Return Code
                                                
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
                                                usServiceRow++;
                                            }
                                        }
                                        
                                        
                                        
                                        //  Service New Row processing
                                        // At this point all of the services that
                                        // existed for the previous version have been
                                        // updated with the necessary worker, new row
                                        // and amount used fields.  Now we need to update
                                        // any rows that exist for our current version
                                        // that did not exist for the previous version
                                        // with the no row of No and the worker informaiton.
                                        // This section is necessary in order set
                                        // the contract worker to the current worker
                                        // and set the new row indicator to No.
                                        // Note: start counter at CLSS11DPreviousVersion
                                        // ulRowQty since we are continuing to process
                                        // service rows that did not exist for the
                                        // previous version, but exist for our new version
                                        while ((usServiceRow < pCLSS11DOCurrentVersion.getArchOutputStruct().getUlRowQty()) && (SUCCESS == pServiceStatus.explan_code)) {
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCAUD17DInputRec = new CAUD17DI();
                                            
                                            pCAUD17DOutputRec = new CAUD17DO();
                                            
                                            pCAUD17DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                                            
                                            pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                            
                                            pCAUD17DInputRec.setUlIdCntrctWkr(ccon08si.getUlIdCntrctWkr());
                                            pCAUD17DInputRec.setUlIdContract(ccon08si.getUlIdContract());
                                            pCAUD17DInputRec.setUlNbrCnsvcPeriod(ccon08si.getUlNbrCnverPeriod());
                                            pCAUD17DInputRec.setUlNbrCnsvcVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion());
                                            
                                            
                                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                            pCAUD17DInputRec.setUlNbrCnsvcLineItem(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLineItem());
                                            pCAUD17DInputRec.setUlIdCnsvc(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlIdCnsvc());
                                            pCAUD17DInputRec.setSzCdCnsvcService(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcService());
                                            pCAUD17DInputRec.setSzCdCnsvcPaymentType(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcPaymentType());
                                            pCAUD17DInputRec.setSzNbrCnsvcUnitType(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzNbrCnsvcUnitType());
                                            pCAUD17DInputRec.setUlNbrCnsvcFedMatch(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcFedMatch());
                                            
                                            //## BEGIN TUX/XML: Declare XML variables 
                                            pCAUD17DInputRec.setUlNbrCnsvcLocalMatch(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLocalMatch());
                                            pCAUD17DInputRec.setUlNbrCnsvcUnitRate(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcUnitRate());
                                            pCAUD17DInputRec.setUlAmtCnsvcEquip(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquip());
                                            pCAUD17DInputRec.setUlAmtCnsvcFrgBenft(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenft());
                                            pCAUD17DInputRec.setUlAmtCnsvcOther(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOther());
                                            pCAUD17DInputRec.setUlAmtCnsvcSalary(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalary());
                                            pCAUD17DInputRec.setUlAmtCnsvcSupply(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupply());
                                            pCAUD17DInputRec.setUlAmtCnsvcTravel(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravel());
                                            pCAUD17DInputRec.setUlAmtCnsvcUnitRate(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRate());
                                            pCAUD17DInputRec.setTsLastUpdate(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getTsLastUpdate());
                                            pCAUD17DInputRec.setUlAmtCnsvcAdminAllUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcAdminAllUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcEquipUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquipUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcFrgBenftUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenftUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcOffItemUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOffItemUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcOtherUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOtherUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcSalaryUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalaryUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcSupplyUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupplyUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcTravelUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravelUsed());
                                            pCAUD17DInputRec.setUlAmtCnsvcUnitRateUsed(pCLSS11DOCurrentVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRateUsed());
                                            pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                            rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                            
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
                                            usServiceRow++;
                                        }
                                        break;
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_CON_NO_SERVICES;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CON_NO_SERVICES;
                                
                                //  Set explan_data to usRow
                                // Note: Use sprintf
                                //##                  sprintf(pReturnPB->appl_status.explan_data,
                                //##                          "%u",
                                //##                          usVersionRow);
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    if ((FND_YES == ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getBIndEndDateMod()) && (SUCCESS == pServiceStatus.explan_code)) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCLSS37DInputRec = new CLSS37DI();
                        
                        pCLSS37DOutputRec = new CLSS37DO();
                        pCLSS37DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                        pCLSS37DInputRec.setUlIdContract(ccon08si.getUlIdContract());
                        pCLSS37DInputRec.setUlNbrCnsvcPeriod(ccon08si.getUlNbrCnverPeriod());
                        pCLSS37DInputRec.setUlNbrCnsvcVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion());
                        pCLSS37DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS37DO._CLSS37DO__ROWCLSS37DO_SIZE);
                        pCLSS37DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                        rc = clss37dQUERYdam(sqlca, pCLSS37DInputRec, pCLSS37DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD08DInputRec = new CAUD08DI();
                                
                                pCAUD08DOutputRec = new CAUD08DO();
                                
                                usCountyRow = 0;
                                
                                //  While county rows exist and the AUD is successful,
                                // continue adding rows for the new version
                                while ((usCountyRow < pCLSS37DOutputRec.getArchOutputStruct().getUlRowQty()) && (SUCCESS == pServiceStatus.explan_code)) {
                                    pCAUD08DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                                    pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                    pCAUD08DInputRec.setUlIdCntrctWkr(ccon08si.getUlIdCntrctWkr());
                                    pCAUD08DInputRec.setDtDtCncntyEnd(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getDtDtCnverEnd());
                                    pCAUD08DInputRec.setUlIdCncnty(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdCncnty());
                                    pCAUD08DInputRec.setUlIdContract(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdContract());
                                    pCAUD08DInputRec.setUlIdResource(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdResource());
                                    pCAUD08DInputRec.setSzCdCncntyCounty(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyCounty());
                                    pCAUD08DInputRec.setSzCdCncntyService(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyService());
                                    pCAUD08DInputRec.setDtDtCncntyEffective(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getDtDtCncntyEffective());
                                    pCAUD08DInputRec.setTmScrTmGeneric1(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric1());
                                    pCAUD08DInputRec.setTmScrTmGeneric2(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric2());
                                    pCAUD08DInputRec.setUlNbrCncntyPeriod(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyPeriod());
                                    pCAUD08DInputRec.setUlNbrCncntyLineItem(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyLineItem());
                                    pCAUD08DInputRec.setUlNbrCncntyVersion(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyVersion());
                                    pCAUD08DInputRec.setTsLastUpdate(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTsLastUpdate());
                                    rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                                    
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
                                    usCountyRow++;
                                }
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
                    if ((ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion() > FIRST_VERSION) && (WtcHelperConstants.REQ_FUNC_CD_ADD == ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getSzCdScrDataAction()) && (SUCCESS == pServiceStatus.explan_code)) {
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCLSS11DInputRec = new CLSS11DI();
                        
                        pCLSS11DOPreviousVersion = new CLSS11DO();
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                        pCLSS11DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                        pCLSS11DInputRec.setUlIdContract(ccon08si.getUlIdContract());
                        pCLSS11DInputRec.setUlNbrCnsvcPeriod(ccon08si.getUlNbrCnverPeriod());
                        pCLSS11DInputRec.setUlNbrCnsvcVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion() - 1);
                        pCLSS11DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS11DO._CLSS11DO__ROWCLSS11DO_SIZE);
                        pCLSS11DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                        rc = clss11dQUERYdam(sqlca, pCLSS11DInputRec, pCLSS11DOPreviousVersion);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Update the version services from the previous
                                // version services
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD17DInputRec = new CAUD17DI();
                                
                                pCAUD17DOutputRec = new CAUD17DO();
                                
                                //  Initialize service row
                                usServiceRow = 0;
                                
                                //  While service rows exist, ann the AUD is successful
                                // continue adding the previous version's
                                // service rows to the new version
                                while ((usServiceRow < pCLSS11DOPreviousVersion.getArchOutputStruct().getUlRowQty()) && (SUCCESS == pServiceStatus.explan_code)) {
                                    pCAUD17DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                                    pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                    pCAUD17DInputRec.setUlIdCnsvc(0);
                                    pCAUD17DInputRec.setUlIdCntrctWkr(ccon08si.getUlIdCntrctWkr());
                                    
                                    pCAUD17DInputRec.setUlIdContract(ccon08si.getUlIdContract());
                                    pCAUD17DInputRec.setUlNbrCnsvcPeriod(ccon08si.getUlNbrCnverPeriod());
                                    pCAUD17DInputRec.setUlNbrCnsvcVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion());
                                    pCAUD17DInputRec.setUlNbrCnsvcLineItem(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLineItem());
                                    pCAUD17DInputRec.setSzCdCnsvcService(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcService());
                                    pCAUD17DInputRec.setSzCdCnsvcPaymentType(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcPaymentType());
                                    pCAUD17DInputRec.setSzNbrCnsvcUnitType(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzNbrCnsvcUnitType());
                                    pCAUD17DInputRec.setUlNbrCnsvcFedMatch(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcFedMatch());
                                    pCAUD17DInputRec.setUlNbrCnsvcLocalMatch(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLocalMatch());
                                    pCAUD17DInputRec.setUlNbrCnsvcUnitRate(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcUnitRate());
                                    
                                    pCAUD17DInputRec.setUlAmtCnsvcEquip(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquip());
                                    pCAUD17DInputRec.setUlAmtCnsvcFrgBenft(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenft());
                                    pCAUD17DInputRec.setUlAmtCnsvcOther(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOther());
                                    pCAUD17DInputRec.setUlAmtCnsvcSalary(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalary());
                                    pCAUD17DInputRec.setUlAmtCnsvcSupply(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupply());
                                    pCAUD17DInputRec.setUlAmtCnsvcTravel(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravel());
                                    pCAUD17DInputRec.setUlAmtCnsvcUnitRate(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRate());
                                    pCAUD17DInputRec.setTsLastUpdate(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getTsLastUpdate());
                                    
                                    pCAUD17DInputRec.setUlAmtCnsvcAdminAllUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcAdminAllUsed());
                                    pCAUD17DInputRec.setUlAmtCnsvcEquipUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcEquipUsed());
                                    pCAUD17DInputRec.setUlAmtCnsvcFrgBenftUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcFrgBenftUsed());
                                    
                                    pCAUD17DInputRec.setUlAmtCnsvcOffItemUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOffItemUsed());
                                    pCAUD17DInputRec.setUlAmtCnsvcOtherUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcOtherUsed());
                                    pCAUD17DInputRec.setUlAmtCnsvcSalaryUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSalaryUsed());
                                    pCAUD17DInputRec.setUlAmtCnsvcSupplyUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcSupplyUsed());
                                    
                                    pCAUD17DInputRec.setUlAmtCnsvcTravelUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcTravelUsed());
                                    pCAUD17DInputRec.setUlAmtCnsvcUnitRateUsed(pCLSS11DOPreviousVersion.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlAmtCnsvcUnitRateUsed());
                                    pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                    
                                    //  Call DAM
                                    rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                    
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
                                    usServiceRow++;
                                }
                                if (SUCCESS == pServiceStatus.explan_code) {
                                    //  Duplicate County information from informaiton
                                    // from the previous version
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCLSS37DInputRec = new CLSS37DI();
                                    
                                    pCLSS37DOutputRec = new CLSS37DO();
                                    pCLSS37DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                                    pCLSS37DInputRec.setUlIdContract(pCAUD15DInputRec.getUlIdContract());
                                    pCLSS37DInputRec.setUlNbrCnsvcPeriod(pCAUD15DInputRec.getUlNbrCnverPeriod());
                                    pCLSS37DInputRec.setUlNbrCnsvcVersion(pCAUD15DInputRec.getUlNbrCnverVersion() - 1);
                                    pCLSS37DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS37DO._CLSS37DO__ROWCLSS37DO_SIZE);
                                    pCLSS37DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                    rc = clss37dQUERYdam(sqlca, pCLSS37DInputRec, pCLSS37DOutputRec);
                                    
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCAUD08DInputRec = new CAUD08DI();
                                            
                                            pCAUD08DOutputRec = new CAUD08DO();
                                            
                                            //  Initialize the County row counter
                                            usCountyRow = 0;
                                            
                                            //  While county rows exist and no
                                            // AUD errors occur, continue adding
                                            // the previous version counties to
                                            // the new version
                                            while ((usCountyRow < pCLSS37DOutputRec.getArchOutputStruct().getUlRowQty()) && (SUCCESS == pServiceStatus.explan_code)) {
                                                pCAUD08DInputRec.setArchInputStruct(ccon08si.getArchInputStruct());
                                                pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                pCAUD08DInputRec.setUlIdCncnty(0);
                                                pCAUD08DInputRec.setUlIdCntrctWkr(ccon08si.getUlIdCntrctWkr());
                                                pCAUD08DInputRec.setDtDtCncntyEnd(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getDtDtCnverEnd());
                                                pCAUD08DInputRec.setDtDtCncntyEffective(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getDtDtCnverEffective());
                                                pCAUD08DInputRec.setUlNbrCncntyVersion(ccon08si.getROWCCON08SIG00_ARRAY().getROWCCON08SIG00(usVersionRow).getUlNbrCnverVersion());
                                                pCAUD08DInputRec.setUlIdContract(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdContract());
                                                pCAUD08DInputRec.setUlIdResource(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdResource());
                                                pCAUD08DInputRec.setSzCdCncntyCounty(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyCounty());
                                                pCAUD08DInputRec.setSzCdCncntyService(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyService());
                                                pCAUD08DInputRec.setTmScrTmGeneric1(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric1());
                                                pCAUD08DInputRec.setTmScrTmGeneric2(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric2());
                                                pCAUD08DInputRec.setUlNbrCncntyPeriod(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyPeriod());
                                                pCAUD08DInputRec.setUlNbrCncntyLineItem(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyLineItem());
                                                pCAUD08DInputRec.setTsLastUpdate(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTsLastUpdate());
                                                rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                                                
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
                                                usCountyRow++;
                                            }
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
                                
                                // 
                                // End Call CSYS06D
                                // 
                                
                                break;
                        }
                    }
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    
                    // 
                    // End Call cses65D
                    // 
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
            usVersionRow++;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon08si.getArchInputStruct() , ccon08so.getArchOutputStruct());
        if (pServiceStatus.explan_code != SUCCESS) {
            
            //  Call DAM
            rc = pServiceStatus.explan_code;
        }
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
        return ccon08so;
    }

}
