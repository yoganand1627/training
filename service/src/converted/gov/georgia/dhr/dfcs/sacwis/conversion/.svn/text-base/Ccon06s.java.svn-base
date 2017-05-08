package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES01DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD28DO;
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
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC52DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CCON06S.src
**
** Service Name:   CCON06S
**
** Description:   This service will update all columns for Id Contract, 
**                Nbr Cnper Period, Id Cntrct Wkr, Cd Cnper Status, 
**                Dt Cnper Start, Dt Cnper Term, Dt Cnper Closure, Ind 
**                Cnper Renewal, and Ind Cnper Signed on the Contract 
**                Period table.  It can add, modify or delete a Contract
**                Period row.  For any Contract Period that it adds, it 
**                will duplicate the previous Period's last version's 
**                Service Line Items.  If it modifies DtCnperStart or 
**                DtCnperTerm, then it will update DtCnverEffective, 
**                DtCnverEnd, DtCncntyEffective and DtCncntyEnd on the 
**                Contract Version and Contract County tables respectively.
**                If a Contract Period is deleted, then it will delete the
**                version, service line items and counties associated with
**                Nbr Cnper Period.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/10/95 
** 
** Programmer:    Diana Feller
**
** Archive Information: $Revision:   1.10  $
**                      $Date:   15 Nov 1999 08:07:44  $
**                      $Modtime:   11 Nov 1999 11:42:36  $
**                      $Author:   pvcs  $
**
**  Change    History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/06/95  FELLERDL  In CAUD17D insert to the Contract Service table, the
**                      version # copied to new period was set to last version 
**                      # of previous period.  New period's initial version # 
**                      should be set to 1.   
**  12/06/95  FELLERDL  SIR 2111 When creating a new period, should NOT copy 
**                      service budgets to 1st version of new period.
**                      Delete code in pCAUD17DInputRec copying 
**                      budget information 
**
**  12/11/95  MCRAEBS   SIR 2169 - If the user attempts to save a contract period
**                      and the closure date is before the latest version's 
**                      effective date, the save will be invalidated and 
**                      SSM_INVD_CLOSURE_DT will be returned to the client.
**
**  12/15/95  FELLERDL  SIR 2169 - Assign correct version, start and end dates
**                      for an updated contract period.  Also, free memory
**                      for CSES01D.  
**                                    
**  01/04/97  FELLERDL  SIR 2477 - Change the pCAUD08DInputRec->dtDtCncntyEnd
**                      to pInputMsg->ROWCCON06SIG00[usCountyRow].dtDtCnperClosure.
**                      This sets the end date to correct value for every county
**                      for the Contract County AUD.
**   
**  01/18/96  FELLERDL  SIR 2763 - Add CLSS11D to retrieve services for existing 
**                      period. If user tries to save a signed period with 
**                      no services, a message will be displayed.   
** 
**  01/30/97  FELLERDL  SIR 3013 - Only check first period for signed with 
**                      no services in UPDATE mode. Also, Set term date back 
**                      to period's term date - NOT closure date.  Moved 
**                      first 2 DAM calls inside while statement.
**
**  03/01/96  ADKINSMC  SIR 3437 - Expanded both if statements which call 
**                      CLSS11D so if a new contract period is being created
**                      and the status is active and contract signed the
**                      service will return a MSG_CON_PER_SIGN_WO_SERV.
**
**  05/30/96  CRYSTAEP  SIR 21438 - Modified 'if' statement from SIR 2725.
**                      DAM caud28d was locking every version of a contract
**                      if it was signed.  Only the first version must be
**                      locked. 
**  08/15/96  CHESSMTL  SIR 21962 - The user is now allowed to alter the
**                      start date of the first period (FAD Contracts only).
**                      However, this save can only be done so long as the 
**                      Contract County records will not override any existing
**                      county records for the same resource/service combination
**                      This validation will done with a new DAM, clss73d.  If
**                      this DAM returns no data, the Save will proceed.
**  08/23/96  DALLEYKR  SIR 22080: move freeing of memory to inside the
**                      conditional where it's allocated   
**
**  07/14/97  saravigm  QuickWin-Contract - We will check against the 
**                      equivalency and non_equivalency table before 
**                      carrying a Contract Service record forward to a new
**                      Period (Non Fad Contracts only).
**  08/22/97  CHESSMTL  Added Facility type contracts to the exclusion of
**                      of the Equivalency edits.
**  11/03/99  komarae   SIR 15166 - Plug memory leaks that caused server to die.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
** 
**	05/28/03  Srini    SIR 17595 - Replaced TRUE to INDICATOR_YES
**
**  06/25/03  Srini    SIR 18513 Setting the ulPageSizeNbr to 100.This is set 
**					   to 100 (_CLSS09DO__ROWCLSS09DO_SIZE) because the dam returns 
**					   all the rows in contract_version table and we are only 
**					   interested in 1 of them.  Unfortunately, passing in the value 
**					   from the conversation messes this up because PageSize can often 
**					   be 1 which tells the service how many updates to do, and it would 
**					   break trying to do updates for more than 1 if only 1 record was 
**					   passed in.
** 06/09/05  Ochumd    Sir#23430 - Added a legal identifier field for contracts.
**                     This service will now process NbrLegalIdentifier
**                     as part of its save process.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

public class Ccon06s {
    public static final String FAD_CONTRACT = "FAD";
    
    /* TLC 08/22/1997 Added FAC */
    public static final String FAC_CONTRACT = "FAC";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /**************************************************************************
    ** Function Prototypes
    ***************************************************************************/
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    /**************************************************************************
    **
    ** Function Name:  CCON06S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    public static final int MAX_CONTRACT_SERVICES = 50;
    public static final int MAX_COUNTIES_QTY = 13000;
    public static final String PERIOD_ADDED = "A new period has been added.";
    public static final int INITIAL_PAGE = 1;
    CCON06SO CCON06S(CCON06SI ccon06si) {
        CCON06SO ccon06so = new CCON06SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i192 = 0;
        int lRC6 = 0;
        int usInputRow = 0;
        int usCountyRow = 0;
        int usServiceRow = 0;
        int RetVal = SUCCESS;
        
        
        CAUD20DI pCAUD20DInputRec = null;
        CAUD20DO pCAUD20DOutputRec = null;
        
        CSES01DI pCSES01DInputRec = null;
        CSES01DO pCSES01DOutputRec = null;
        
        CAUD28DI pCAUD28DInputRec = null;
        CAUD28DO pCAUD28DOutputRec = null;
        
        CAUD15DI pCAUD15DInputRec = null;
        CAUD15DO pCAUD15DOutputRec = null;
        
        CLSS11DI pCLSS11DInputRec = null;
        CLSS11DO pCLSS11DOutputRec = null;
        
        CAUD17DI pCAUD17DInputRec = null;
        CAUD17DO pCAUD17DOutputRec = null;
        
        CLSS37DI pCLSS37DInputRec = null;
        CLSS37DO pCLSS37DOutputRec = null;
        
        CAUD08DI pCAUD08DInputRec = null;
        CAUD08DO pCAUD08DOutputRec = null;
        
        CLSS73DI pCLSS73DInputRec = null;
        CLSS73DO pCLSS73DOutputRec = null;
        
        CLSS09DI pCLSS09DInputRec = null;
        CLSS09DO pCLSS09DOutputRec = null;
        
        CMSC52DI pCMSC52DInputRec = null;
        CMSC52DO pCMSC52DOutputRec = null;
        /* In order to subtract one day, two days are subtracted, and one day is added.
        ** Otherwise the function does not work */
        rc = ARC_PRFServiceStartTime_TUX(ccon06si.getArchInputStruct());
        
        /*  ** Initialize Service Status Fields   */
        /*  ** Perform Main Processing  */
        
        /*
        ** While the row count is less than number of times the record group occurs,
        ** SysCdDataOutcome is not null and explan_code is successful
        */
        while (usInputRow < ccon06si.getArchInputStruct().getUlPageSizeNbr() && SUCCESS == pServiceStatus.explan_code) {
            
            //  Blindly return rc code to allow user to determine
            // proper course of action
            
            // 
            // Prepare output message to be returned and return
            // 
            if ((WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction()) || (ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() == 1 && FND_YES == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperSigned())) {
                //  Allocate memory for DAM Input and Output Structures
                pCSES01DInputRec = new CSES01DI();
                
                pCSES01DOutputRec = new CSES01DO();
                pCSES01DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                pCSES01DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                pCSES01DInputRec.setUlNbrCnverPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod());
                pCSES01DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pCSES01DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                
                rc = cses01dQUERYdam(sqlca, pCSES01DInputRec, pCSES01DOutputRec);
                
                //  Handle return code.
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        lRC6 = ARC_UTLCompareDateAndTime((FndInt3date) & ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperClosure() , (char) 0, (FndInt3date) & pCSES01DOutputRec.getDtDtCnverEffective() , (char) 0);
                        if (lRC6 <= 0) {
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.SSM_INVD_CLOSURE_DT;
                            rc = Messages.SSM_INVD_CLOSURE_DT;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            break;
                        }
                        else {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                        }
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        
                        break;
                }
            }
            
            
            // -----------------------------------------------------------
            //  Allocate & initialize memory for DAM Input and Output Structures
            pCAUD20DInputRec = new CAUD20DI();
            
            pCAUD20DOutputRec = new CAUD20DO();
            pCAUD20DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
            pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction());
            pCAUD20DInputRec.setUlIdContract(ccon06si.getUlIdContract());
            pCAUD20DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
            pCAUD20DInputRec.setUlNbrCnperPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod());
            pCAUD20DInputRec.setDtDtCnperClosure(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperClosure());
            pCAUD20DInputRec.setDtDtCnperStart(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
            pCAUD20DInputRec.setDtDtCnperTerm(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperTerm());
            pCAUD20DInputRec.setSzCdCnperStatus(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdCnperStatus());
            pCAUD20DInputRec.setUlNbrLegalIdentifier(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrLegalIdentifier());
            pCAUD20DInputRec.setCIndCnperRenewal(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperRenewal());
            pCAUD20DInputRec.setCIndCnperSigned(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperSigned());
            pCAUD20DInputRec.setTsLastUpdate(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getTsLastUpdate());
            rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    if (false == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                    }
                    //##            sprintf(pReturnPB->appl_status.explan_data,
                    //##                   "%u",
                    //##                pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                    
                    
                    else {
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() > 1 && WtcHelperConstants.REQ_FUNC_CD_ADD == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction()) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES01DInputRec = new CSES01DI();
                            
                            pCSES01DOutputRec = new CSES01DO();
                            pCSES01DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                            pCSES01DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                            pCSES01DInputRec.setUlNbrCnverPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() - 1);
                            pCSES01DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                            pCSES01DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                            rc = cses01dQUERYdam(sqlca, pCSES01DInputRec, pCSES01DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    if (FND_YES == pCSES01DOutputRec.getCIndCnverVerLock()) {
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCAUD15DInputRec = new CAUD15DI();
                                        
                                        pCAUD15DOutputRec = new CAUD15DO();
                                        pCAUD15DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                        pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        pCAUD15DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                                        pCAUD15DInputRec.setUlNbrCnverPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod());
                                        pCAUD15DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
                                        
                                        pCAUD15DInputRec.setUlNbrCnverVersion(1);
                                        rc = ARC_UTLGetDateAndTime(pCAUD15DInputRec.getDtDtCnverCreate() , 0);
                                        
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        pCAUD15DInputRec.setDtDtCnverEffective(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
                                        pCAUD15DInputRec.setDtDtCnverEnd(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperTerm());
                                        if (FND_NO == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperSigned()) {
                                            pCAUD15DInputRec.setCIndCnverVerLock(FND_NO);
                                        }
                                        
                                        else {
                                            pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                                        }
                                        pCAUD15DInputRec.setUlNbrCnverNoShowPct(pCSES01DOutputRec.getUlNbrCnverNoShowPct());
                                        pCAUD15DInputRec.setSzTxtCnverComment(PERIOD_ADDED);
                                        rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCLSS11DInputRec = new CLSS11DI();
                                                
                                                pCLSS11DOutputRec = new CLSS11DO();
                                                pCLSS11DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                                pCLSS11DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                                                pCLSS11DInputRec.setUlNbrCnsvcPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() - 1);
                                                pCLSS11DInputRec.setUlNbrCnsvcVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
                                                pCLSS11DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                                pCLSS11DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_CONTRACT_SERVICES);
                                                rc = clss11dQUERYdam(sqlca, pCLSS11DInputRec, pCLSS11DOutputRec);
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                        
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        
                                                        //  Allocate memory for DAM Input and Output Structures
                                                        pCAUD17DInputRec = new CAUD17DI();
                                                        
                                                        pCAUD17DOutputRec = new CAUD17DO();
                                                        
                                                        usServiceRow = 0;
                                                        
                                                        //   Service AUD Processing for CAUD17D
                                                        while (usServiceRow < pCLSS11DOutputRec.getArchOutputStruct().getUlRowQty() && SUCCESS == pServiceStatus.explan_code) {
                                                            // SIR 15166 - moved allocating and initializing cmsc52d memory here
                                                            pCMSC52DInputRec = new CMSC52DI();
                                                            pCMSC52DOutputRec = new CMSC52DO();
                                                            if (0 == FAD_CONTRACT.compareTo(ccon06si.getSzCdCntrctFuncType()) || 0 == FAC_CONTRACT.compareTo(ccon06si.getSzCdCntrctFuncType())) {
                                                                pCMSC52DOutputRec.setUlSysNbrGenericCntr(1);
                                                            }
                                                            else {
                                                                pCMSC52DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                                                pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (4));
                                                                pCMSC52DInputRec.setSzCdEquivSvcDtlService(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcService());
                                                                pCMSC52DInputRec.setDtDtEquivStartDate(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
                                                                pCMSC52DInputRec.setDtDtEquivEndDate(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperTerm());
                                                                rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                                                                
                                                                //  Analyze return code
                                                                switch (rc) {
                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                        
                                                                        //  Check for NULL pointers, return fatal error if found.
                                                                        if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                                                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                                                            
                                                                            break;
                                                                        }
                                                                        else {
                                                                            pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (3));
                                                                            rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                                                                            
                                                                            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                            }
                                                                        }
                                                                    default :
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                        
                                                                        
                                                                        break;
                                                                }
                                                            }
                                                            
                                                            if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                                                                pCAUD17DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                                pCAUD17DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
                                                                pCAUD17DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                                                                pCAUD17DInputRec.setUlNbrCnsvcPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod());
                                                                pCAUD17DInputRec.setUlNbrCnsvcVersion(1);
                                                                pCAUD17DInputRec.setUlNbrCnsvcLineItem(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLineItem());
                                                                pCAUD17DInputRec.setSzCdCnsvcService(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcService());
                                                                pCAUD17DInputRec.setSzCdCnsvcPaymentType(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzCdCnsvcPaymentType());
                                                                pCAUD17DInputRec.setCIndCnsvcNewRow(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getCIndCnsvcNewRow());
                                                                pCAUD17DInputRec.setSzNbrCnsvcUnitType(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getSzNbrCnsvcUnitType());
                                                                pCAUD17DInputRec.setUlNbrCnsvcFedMatch(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcFedMatch());
                                                                pCAUD17DInputRec.setUlNbrCnsvcLocalMatch(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcLocalMatch());
                                                                pCAUD17DInputRec.setUlNbrCnsvcUnitRate(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getUlNbrCnsvcUnitRate());
                                                                ;
                                                                pCAUD17DInputRec.setTsLastUpdate(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(usServiceRow).getTsLastUpdate());
                                                                rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                                                
                                                                //  Analyze return code
                                                                switch (rc) {
                                                                        
                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        
                                                                        //  Set explan_data to usRow
                                                                        // Note: Use sprintf
                                                                        //##          sprintf(pReturnPB->appl_status.explan_data,
                                                                        //##                  "%u",
                                                                        //##                  usVersionRow);
                                                                        
                                                                        break;
                                                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                                        
                                                                        //  Set explan_data to usRow
                                                                        // Note: Use sprintf
                                                                        //##          sprintf(pReturnPB->appl_status.explan_data,
                                                                        //##                  "%u",
                                                                        //##                  usVersionRow);
                                                                        
                                                                        break;
                                                                    default :// caud17d
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                        
                                                                        break;
                                                                }
                                                            }
                                                            usServiceRow++;
                                                        }
                                                        
                                                        break;
                                                        
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_CON_INVLD_PER;
                                                        break;
                                                    default :// for clss11d
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        break;
                                                }
                                                break;
                                                
                                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                break;
                                            default :// caud15d
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                break;
                                        }
                                    }
                                    
                                    //   Error processing - Not Locked Version
                                    else {
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_CON_VERSION_UNLOCK;
                                    }
                                    break;
                                default :// cres01d
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        
                        
                        else if (ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() == 1 && WtcHelperConstants.REQ_FUNC_CD_ADD == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction()) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCAUD15DInputRec = new CAUD15DI();
                            
                            pCAUD15DOutputRec = new CAUD15DO();
                            pCAUD15DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                            pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            pCAUD15DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                            pCAUD15DInputRec.setUlNbrCnverPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod());
                            pCAUD15DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
                            pCAUD15DInputRec.setUlNbrCnverVersion(1);
                            rc = ARC_UTLGetDateAndTime(pCAUD15DInputRec.getDtDtCnverCreate() , 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pCAUD15DInputRec.setDtDtCnverEffective(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
                            pCAUD15DInputRec.setDtDtCnverEnd(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperTerm());
                            
                            if (FND_NO == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperSigned()) {
                                pCAUD15DInputRec.setCIndCnverVerLock(FND_NO);
                            }
                            
                            else {
                                pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                            }
                            pCAUD15DInputRec.setUlNbrCnverNoShowPct(0);
                            pCAUD15DInputRec.setSzTxtCnverComment(PERIOD_ADDED);
                            rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
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
                        
                        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction() && ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() == 1 && INDICATOR_YES == ccon06si.getCIndRsrcTransport()) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCLSS73DInputRec = new CLSS73DI();
                            
                            pCLSS73DOutputRec = new CLSS73DO();
                            pCLSS73DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                            pCLSS73DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                            pCLSS73DInputRec.setUlNbrCncntyPeriod(1);
                            pCLSS73DInputRec.setUlNbrCncntyVersion(1);
                            pCLSS73DInputRec.setDtDtCncntyEffective(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
                            pCLSS73DInputRec.setDtDtCncntyEnd(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperTerm());
                            rc = clss73dQUERYdam(sqlca, pCLSS73DInputRec, pCLSS73DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Now we have to call clss09d.pc because we don't have
                                    // the neccesary data to update version one
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCLSS09DInputRec = new CLSS09DI();
                                    
                                    pCLSS09DOutputRec = new CLSS09DO();
                                    pCLSS09DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                    pCLSS09DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                                    pCLSS09DInputRec.setUlNbrCnverPeriod(1);
                                    pCLSS09DInputRec.getArchInputStruct().setUsPageNbr(ccon06si.getArchInputStruct().getUsPageNbr());
                                    pCLSS09DInputRec.getArchInputStruct().setUlPageSizeNbr(100);
                                    rc = clss09dQUERYdam(sqlca, pCLSS09DInputRec, pCLSS09DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Set up loop to retrieve information for 1st
                                            // version only and populate in first retrieval set
                                            for (i192 = 0;i192 < pCLSS09DOutputRec.getArchOutputStruct().getUlRowQty();i192++) {
                                                
                                                if (1 == pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i192).getUlNbrCnverVersion()) {
                                                    pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(1).setDtDtCnverEnd(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i192).getDtDtCnverEnd());
                                                    pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(1).setCIndCnverVerLock(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(i192).getCIndCnverVerLock());
                                                }
                                            }
                                            
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCAUD28DInputRec = new CAUD28DI();
                                            
                                            pCAUD28DOutputRec = new CAUD28DO();
                                            pCAUD28DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                            pCAUD28DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
                                            pCAUD28DInputRec.getArchInputStruct().setCReqFuncCd(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction());
                                            pCAUD28DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                                            pCAUD28DInputRec.setUlNbrCnverPeriod(1);
                                            pCAUD28DInputRec.setUlNbrCnverVersion(1);
                                            pCAUD28DInputRec.setDtDtCnperStart(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
                                            pCAUD28DInputRec.setCIndCnverVerLock(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(1).getCIndCnverVerLock());
                                            pCAUD28DInputRec.setDtDtCnperTerm(pCLSS09DOutputRec.getROWCLSS09DO_ARRAY().getROWCLSS09DO(1).getDtDtCnverEnd());
                                            
                                            //  Call CSES01D, Contract Version retrieve for an idContract
                                            rc = caud28dAUDdam(sqlca, pCAUD28DInputRec, pCAUD28DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                    
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    pCLSS37DInputRec = new CLSS37DI();
                                                    
                                                    pCLSS37DOutputRec = new CLSS37DO();
                                                    pCLSS37DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                                    pCLSS37DInputRec.setUlIdContract(pCAUD28DInputRec.getUlIdContract());
                                                    pCLSS37DInputRec.setUlNbrCnsvcPeriod(1);
                                                    pCLSS37DInputRec.setUlNbrCnsvcVersion(1);
                                                    pCLSS37DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                                    pCLSS37DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_COUNTIES_QTY);
                                                    
                                                    //  Call CAUD15D. Performs a full row
                                                    // update/insert to the Contract Version table.
                                                    rc = clss37dQUERYdam(sqlca, pCLSS37DInputRec, pCLSS37DOutputRec);
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                            
                                                            //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //  Allocate memory for DAM Input and Output Structures
                                                            pCAUD08DInputRec = new CAUD08DI();
                                                            
                                                            pCAUD08DOutputRec = new CAUD08DO();
                                                            
                                                            //  Initialize the county row counter
                                                            usCountyRow = 0;
                                                            
                                                            //   County AUD processing CAUD08D
                                                            while (usCountyRow < pCLSS37DOutputRec.getArchOutputStruct().getUlRowQty() && SUCCESS == pServiceStatus.explan_code) {
                                                                pCAUD08DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                                                pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                                pCAUD08DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
                                                                pCAUD08DInputRec.setDtDtCncntyEnd(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getDtDtCncntyEnd());
                                                                pCAUD08DInputRec.setUlIdCncnty(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdCncnty());
                                                                pCAUD08DInputRec.setUlIdContract(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdContract());
                                                                pCAUD08DInputRec.setUlIdResource(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdResource());
                                                                pCAUD08DInputRec.setSzCdCncntyCounty(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyCounty());
                                                                
                                                                pCAUD08DInputRec.setSzCdCncntyService(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyService());
                                                                pCAUD08DInputRec.setDtDtCncntyEffective(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
                                                                pCAUD08DInputRec.setTmScrTmGeneric1(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric1());
                                                                pCAUD08DInputRec.setTmScrTmGeneric2(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric2());
                                                                pCAUD08DInputRec.setTsLastUpdate(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTsLastUpdate());
                                                                pCAUD08DInputRec.setUlNbrCncntyPeriod(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyPeriod());
                                                                pCAUD08DInputRec.setUlNbrCncntyVersion(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyVersion());
                                                                pCAUD08DInputRec.setUlNbrCncntyLineItem(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyLineItem());
                                                                
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
                                                                        
                                                                    default :
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                        break;
                                                                }
                                                                usCountyRow++;
                                                            }
                                                            
                                                            //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            break;
                                                        default :// clss37d
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            break;
                                                    }
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                                    break;
                                                    
                                                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                    break;
                                                default :// caud28d
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                            break;
                                        default :// clss09d
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                    break;
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CON_COUNTY_VIOLATION;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                                default :// clss73d
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        
                        if ((WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction()) || (ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() == 1 && FND_YES == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperSigned())) {
                            
                            RetVal = SUCCESS;
                            if (ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() == 1) {
                                //  SIR 2763  Add CLSS11D to retrieve services for 1st period.
                                // Allocate memory for DAM Input and Output Structures
                                pCLSS11DInputRec = new CLSS11DI();
                                
                                pCLSS11DOutputRec = new CLSS11DO();
                                pCLSS11DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                pCLSS11DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                                pCLSS11DInputRec.setUlNbrCnsvcPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod());
                                pCLSS11DInputRec.setUlNbrCnsvcVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
                                
                                pCLSS11DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                pCLSS11DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_CONTRACT_SERVICES);
                                
                                //  Call CAUD17D.  The Contract Service AUD performs a full row
                                // insert to the Contract Service table.
                                rc = clss11dQUERYdam(sqlca, pCLSS11DInputRec, pCLSS11DOutputRec);
                                switch (rc) {
                                        
                                        //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        RetVal = SUCCESS;
                                        break;
                                    case NO_DATA_FOUND:
                                        
                                        if ((ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() == 1) && (FND_YES == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperSigned())) {
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_CON_PER_SIGN_WO_SERV;
                                            //##                          sprintf(pReturnPB->appl_status.explan_data,
                                            //##                                  "%u",
                                            //##                                  pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                        }
                                        break;
                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                        break;
                                        
                                    default :
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            
                            if (SUCCESS == RetVal) {
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD28DInputRec = new CAUD28DI();
                                
                                pCAUD28DOutputRec = new CAUD28DO();
                                pCAUD28DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                pCAUD28DInputRec.getArchInputStruct().setCReqFuncCd(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction());
                                pCAUD28DInputRec.setUlIdContract(ccon06si.getUlIdContract());
                                pCAUD28DInputRec.setUlNbrCnverPeriod(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod());
                                pCAUD28DInputRec.setUlNbrCnverVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
                                
                                if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getSzCdScrDataAction() && ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getUlNbrCnperPeriod() == 1 && INDICATOR_YES == ccon06si.getCIndRsrcTransport() && 1 == pCSES01DOutputRec.getUlNbrCnverVersion()) {
                                    pCAUD28DInputRec.setDtDtCnperStart(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperStart());
                                    
                                }
                                else {
                                    pCAUD28DInputRec.setDtDtCnperStart(pCSES01DOutputRec.getDtDtCnverEffective());
                                }
                                pCAUD28DInputRec.setDtDtCnperTerm(ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getDtDtCnperTerm());
                                pCAUD28DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
                                pCAUD28DInputRec.setCIndCnverVerLock(pCSES01DOutputRec.getCIndCnverVerLock());
                                
                                if ('1' == pCSES01DOutputRec.getUlNbrCnverVersion()) {
                                    
                                    if (FND_NO == ccon06si.getROWCCON06SIG00_ARRAY().getROWCCON06SIG00(usInputRow).getCIndCnperSigned()) {
                                        pCAUD28DInputRec.setCIndCnverVerLock(FND_NO);
                                        
                                    }
                                    
                                    else {
                                        pCAUD28DInputRec.setCIndCnverVerLock(FND_YES);
                                    }
                                }
                                
                                rc = caud28dAUDdam(sqlca, pCAUD28DInputRec, pCAUD28DOutputRec);
                                
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                        //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCLSS37DInputRec = new CLSS37DI();
                                        
                                        pCLSS37DOutputRec = new CLSS37DO();
                                        
                                        pCLSS37DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                        
                                        pCLSS37DInputRec.setUlIdContract(pCAUD28DInputRec.getUlIdContract());
                                        pCLSS37DInputRec.setUlNbrCnsvcPeriod(pCAUD28DInputRec.getUlNbrCnverPeriod());
                                        pCLSS37DInputRec.setUlNbrCnsvcVersion(pCAUD28DInputRec.getUlNbrCnverVersion());
                                        pCLSS37DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                        pCLSS37DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_COUNTIES_QTY);
                                        // Retrieve DAM from Contract_County
                                        rc = clss37dQUERYdam(sqlca, pCLSS37DInputRec, pCLSS37DOutputRec);
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                pCAUD08DInputRec = new CAUD08DI();
                                                
                                                pCAUD08DOutputRec = new CAUD08DO();
                                                
                                                usCountyRow = 0;
                                                
                                                //   County AUD processing CAUD08D
                                                while (usCountyRow < pCLSS37DOutputRec.getArchOutputStruct().getUlRowQty() && SUCCESS == pServiceStatus.explan_code) {
                                                    
                                                    pCAUD08DInputRec.setArchInputStruct(ccon06si.getArchInputStruct());
                                                    
                                                    pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                    pCAUD08DInputRec.setUlIdCntrctWkr(ccon06si.getUlIdCntrctWkr());
                                                    pCAUD08DInputRec.setDtDtCncntyEnd(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getDtDtCncntyEnd());
                                                    pCAUD08DInputRec.setUlIdCncnty(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdCncnty());
                                                    pCAUD08DInputRec.setUlIdContract(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdContract());
                                                    pCAUD08DInputRec.setUlIdResource(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlIdResource());
                                                    pCAUD08DInputRec.setSzCdCncntyCounty(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyCounty());
                                                    pCAUD08DInputRec.setSzCdCncntyService(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getSzCdCncntyService());
                                                    pCAUD08DInputRec.setDtDtCncntyEffective(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getDtDtCncntyEffective());
                                                    pCAUD08DInputRec.setTmScrTmGeneric1(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric1());
                                                    pCAUD08DInputRec.setTmScrTmGeneric2(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTmScrTmGeneric2());
                                                    pCAUD08DInputRec.setTsLastUpdate(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getTsLastUpdate());
                                                    pCAUD08DInputRec.setUlNbrCncntyPeriod(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyPeriod());
                                                    pCAUD08DInputRec.setUlNbrCncntyVersion(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyVersion());
                                                    pCAUD08DInputRec.setUlNbrCncntyLineItem(pCLSS37DOutputRec.getROWCLSS37DO_ARRAY().getROWCLSS37DO(usCountyRow).getUlNbrCncntyLineItem());
                                                    rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            break;
                                                            
                                                            //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
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
                                    default :// caud28d
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        break;
                                }
                            }
                        }
                    }
                    
                    break;
                    
                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
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
            usInputRow++;
        }
        
        /*
        ** Load Translation Map
        */
        
        
        ARC_PRFServiceStopTime_TUX(ccon06si.getArchInputStruct() , ccon06so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            rc = SUCCESS;
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
        return ccon06so;
    }

}
