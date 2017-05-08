package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC52DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CCON23S.src
**
** Service Name:  CCON23S
**
** Description:   This is the Save Service for Service Authorization Detail.
**                First it will check whether or not the Person has already
**                been authorized services for the resource during the specified
**                time period.  It will then retrieve Budget information and
**                validate against the Amount Requested.  If the Amount Requested
**                decreases the current budget to less than 15%, then a To Do
**                is initiated.  If the above passes validation, then the
**                Save Dam is called for Svc Auth Dtl and Event Person Link
**                tables.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  November 1, 1995
**
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.7  $
**                      $Date:   26 Jun 1997 16:58:18  $
**                      $Modtime:   26 Jun 1997 16:54:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/04/95  FOGARTIS  Changed service structure to do validation for a
**                      row then write it to the database immediately after
**                      passing validation. Previously service was checking
**                      all rows through validation 1, then 2 then updating
**                      the database all at once - caused potential errors.
**
**  12/13/95  FOISTHJ   SIR 2254 - Changed the sprintf statement for input
**                      to the ToDo List. The following changes were made:
**                      capitalized the C in contract, added the word Svc
**                      after the IdContract, and changed service line item
**                      to the actual Service code for that service, and
**                      made the return value for this action an Alert not
**                      a ToDo. The long description was also changed on the
**                      ToDo_Info table to read Review instead of Approve.
**
** 12/22/95   MCRAEBS   SIR 2401 - change dtTodoCfDueFrom to current date
**                      rather than DtlShowDate
**
** 01/04/96   MCRAEBS   SIR 2447 - Only return MSG_CON_NEG_SVC_BALANCE if
**                      Contract has a budget limit.   BSM
**  05/16/96  PHILLILH  SIR #21185 -  Only call CCMN68D if the Service Auth
**                      Detail window Mode is NEW.(i.e. ulIdSvcAuthDtl = 0).
**                      This is done so that when a Service Auth is modified,
**                      the Person on the Event List is not set to MULTIPLE.
**                      It was getting set to MULTIPLE because a new row was
**                      being added every time the detail window was
**                      modified.
**
**  08/08/96  MCRAEBS   Send the value of CdStage to CSEC17 for SA Detail
**                      validation.
**
**  05/01/97  GMS      DAM CMSC52D.PC was added to this service
**                     This DAM will be called from the Service Authorization Detail
**                     Window when the save pushbutton is clicked.This DAM is a new edit
**                     during the SAVE service that will check and see is the service
**                     code exists in the Equivalency table for the given time period
**                     and open stages for the client.  SIR#13575
**   06/26/97 CHESSMTL Removed the Contract Budget Edit
**
**  06/03/04  CORLEYAN SIR 15664 -- We want to make sure that the resource is
**                     not contracted for an overlapping period regardless of
**                     if we are adding a new service auth detail, or if we are
**                     updating an old one.  In order to do this, remove the "add"
**                     check around csec17, and pass a new parameter into csec17
**                     to make sure we are not looking at the service auth detail
**                     we are currently saving.  Also changed the parameter for Term
**                     date passed into csec17 from end date to term date.  Term
**                     date will always be the same as end date except when we are
**                     saving a terminated service auth.  In this case we want to
**                     check against the term date not the end date.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon23s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final double BUDGET_PCT = 0.85;
    public static final char REQ_FUNC_CD_ADD = 'A';
    
    public static final int INITIAL_PAGE = 1;
    public static final String INITIAL = "INI";
    public static final String ONE_TIME = "ONT";
    CCON23SO CCON23S(CCON23SI ccon23si) {
        CCON23SO ccon23so = new CCON23SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int ulDesc = 0;/* Temporary variable for To Do Desc */
        CMSC52DI pCMSC52DInputRec = null;/* SIR #13575 Quick-Win Enhancement */
        CMSC52DO pCMSC52DOutputRec = null;/* SIR #13575 Quick-Win Enhancement */
        CAUD13DI pCAUD13DInputRec = null;/* This DAM will do a full row update */
        CAUD13DO pCAUD13DOutputRec = null;/* to the Svc Auth Dtl Table */
        CCMN68DI pCCMN68DInputRec = null;/* This DAM will update the Event Person */
        CCMN68DO pCCMN68DOutputRec = null;/* Link table for Id Person in each Svc */
        CSEC17DI pCSEC17DInputRec = null;/* This DAM will validate that the same */
        CSEC17DO pCSEC17DOutputRec = null;/* person has not been authorized services */
        CSES36DI pCSES36DInputRec = null;/* This DAM will validate against the current */
        CSES36DO pCSES36DOutputRec = null;/* budget to insure that the Amount Requested */
        CSUB40UI pTodoCommonInput = null;/* This function will create a ToDo */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        
        
        
        
        /* Auth Dtl record */
        
        /* from the same resource during the specified */
        /* time period already. */
        
        /* does not decrease the current budget to */
        /* less than 15% */
        
        CSUB40UO pTodoCommonOutput = null;
        
        
        int usRow = 0;
        int rc_time1 = 0;/* Return code for CompareDateAndTime */
        FndInt3date dtCurrDate1 = null;
        rc = ARC_PRFServiceStartTime_TUX(ccon23si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        for (usRow = 0;usRow < ccon23si.getArchInputStruct().getUlPageSizeNbr() && WtcHelperConstants.SQL_SUCCESS == rc;usRow++) {
            if ((0 == ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlAuthType().compareTo(INITIAL)) || (0 == ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlAuthType().compareTo(ONE_TIME))) {
                // Call to DAM CMSC52D begins SIR#13575
                //  Allocate memory for Input and Output Structures
                pCMSC52DInputRec = new CMSC52DI();
                pCMSC52DOutputRec = new CMSC52DO();
                pCMSC52DInputRec.setArchInputStruct(ccon23si.getArchInputStruct());
                pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (3));
                pCMSC52DInputRec.setSzCdEquivSvcDtlService(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlSvc());
                pCMSC52DInputRec.setUlIdEvent(ccon23si.getUlIdEvent());
                pCMSC52DInputRec.setUlIdPerson(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdPerson());
                pCMSC52DInputRec.setDtDtEquivStartDate(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlBegin());
                
                pCMSC52DInputRec.setDtDtEquivEndDate(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlEnd());
                rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                        
                        //  Success Case for Dam CSES68D (APF)
                    case WtcHelperConstants.SQL_SUCCESS:
                        if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                            
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                        }
                        else {
                            rc_time1 = ARC_UTLCompareDateAndTime(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlBegin() , 0, ccon23si.getDtDtStageStart() , 0);
                            
                            if (rc_time1 >= 0) {
                                
                                
                                
                                pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (1));
                                rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                        
                                        //  SQL Not Found Case for Dam CSES68D (APF)
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        
                                        if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                        }
                                        else {
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_NO_EQUIV_MATCH;
                                            rc = Messages.MSG_NO_EQUIV_MATCH;
                                        }
                                        break;
                                        // 
                                        // (END): Retrieve DAM: cses06d     
                                        // Legal Action simple retrieve
                                        // 
                                        
                                        // SIR#2163 - case SQL_NOT_FOUND was removed
                                        
                                    default :
                                        
                                        //## BEGIN TUX/XML: Declare XML variables 
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                break;
                            }
                            else // The svc auth starts before the stage start date
                            {
                                //  Check to make sure the Svc Auth Ends after the
                                // Stage Start Date
                                rc_time1 = ARC_UTLCompareDateAndTime(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlEnd() , 0, ccon23si.getDtDtStageStart() , 0);
                                
                                if (rc_time1 > 0) {
                                    pCMSC52DInputRec.setArchInputStruct(ccon23si.getArchInputStruct());
                                    pCMSC52DInputRec.setDtDtEquivStartDate(ccon23si.getDtDtStageStart());
                                    pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (1));
                                    rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                                }
                                else {
                                    rc = WtcHelperConstants.SQL_SUCCESS;
                                    pCMSC52DOutputRec.setUlSysNbrGenericCntr(1);
                                }
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                        //  Success Case for Dam CINV74D
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        
                                        if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                                            pCMSC52DInputRec.setDtDtEquivStartDate(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlBegin());
                                            
                                            if (rc_time1 > 0) {
                                                pCMSC52DInputRec.setDtDtEquivEndDate(ccon23si.getDtDtStageStart());
                                            }
                                            pCMSC52DInputRec.getArchInputStruct().setCReqFuncCd((char) (2));
                                            
                                            rc = cmsc52dQUERYdam(sqlca, pCMSC52DInputRec, pCMSC52DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                    
                                                    //  Success Case for Dam CSES68D (LRO)
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    
                                                    if (pCMSC52DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                                                        
                                                        //  Call DAM
                                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                                    }
                                                    else {
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_NO_EQUIV_MATCH;
                                                        
                                                        rc = Messages.MSG_NO_EQUIV_MATCH;
                                                    }
                                                    break;
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                        }
                                        else // First call to Equivalency yielded count of 0
                                        {
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_NO_EQUIV_MATCH;
                                            rc = Messages.MSG_NO_EQUIV_MATCH;
                                            break;
                                        }
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            break;
                        }
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                }
            }
            
            if (rc == WtcHelperConstants.SQL_SUCCESS) {
                //  SIR 15664 -- Remove the check for Add mode around this
                // DAM call.  We want to call this DAM at all times to ensure
                // that an overlap does not occur.  However, Inside the DAM we
                // want to make sure that we are not returning the current row
                // we are saving, as that would not be an overlap, so pass the
                // ID_SVC_AUTH we are currently saving into the DAM
                //  Allocate memory for DAM Input and Output Structures
                // for CSEC17D
                pCSEC17DInputRec = new CSEC17DI();
                
                pCSEC17DOutputRec = new CSEC17DO();
                pCSEC17DInputRec.setArchInputStruct(ccon23si.getArchInputStruct());
                pCSEC17DInputRec.getArchInputStruct().setUlPageSizeNbr(INITIAL_PAGE);
                pCSEC17DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pCSEC17DInputRec.setUlIdResource(ccon23si.getUlIdResource());
                pCSEC17DInputRec.setSzCdSvcAuthDtlSvc(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlSvc());
                pCSEC17DInputRec.setDtDtSvcAuthDtlBegin(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlBegin());
                pCSEC17DInputRec.setDtDtSvcAuthDtlTerm(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlTerm());
                pCSEC17DInputRec.setUlIdPerson(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdPerson());
                pCSEC17DInputRec.setUlIdSvcAuthDtl(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdSvcAuthDtl());
                pCSEC17DInputRec.setSzCdStage(ccon23si.getSzCdStage());
                rc = csec17dQUERYdam(sqlca, pCSEC17DInputRec, pCSEC17DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                        
                        //  SQL Not Found Case for Dam CSES68D (LRO)
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CON_SVC_AUTH_DUP;
                        
                        //  Call DAM
                        rc = Messages.MSG_CON_SVC_AUTH_DUP;
                        break;
                        
                        //  Success Case for Dam CSES68D (LUT)
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        rc = WtcHelperConstants.SQL_SUCCESS;
                        break;
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                
                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                    //  Allocate memory for DAM Input and Output Structures
                    // for CSES36D
                    pCSES36DInputRec = new CSES36DI();
                    
                    pCSES36DOutputRec = new CSES36DO();
                    pCSES36DInputRec.setArchInputStruct(ccon23si.getArchInputStruct());
                    pCSES36DInputRec.getArchInputStruct().setUlPageSizeNbr(INITIAL_PAGE);
                    pCSES36DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                    pCSES36DInputRec.setUlIdContract(ccon23si.getUlIdContract());
                    pCSES36DInputRec.setUlNbrCnsvcPeriod(ccon23si.getUlNbrCnperPeriod());
                    pCSES36DInputRec.setUlNbrCnsvcVersion(ccon23si.getUlNbrCnverVersion());
                    pCSES36DInputRec.setSzCdCnsvcService(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlSvc());
                    
                    pCSES36DInputRec.setUlNbrCnsvcLineItem(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlNbrSvcAuthDtlLineItm());
                    rc = cses36dQUERYdam(sqlca, pCSES36DInputRec, pCSES36DOutputRec);
                    switch (rc) {
                            
                            //  SQL Not Found Case for Dam CSES68D (LUT)
                        case WtcHelperConstants.SQL_SUCCESS:
                            
                            if ((pCSES36DOutputRec.getUlAmtCnsvcUnitRate() - pCSES36DOutputRec.getUlAmtCnsvcUnitRateUsed()) < ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getLAmtSvcAuthDtlAmtReq() && FND_YES == ccon23si.getCIndCntrctBudgLimit()) {
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  CCMNC5D receives ID CASE from the service and returns an entire
                                // row from the CAPS CASE table.  CSES56D does a full row retrieve
                                // from RECORDS RETENTION table given a Case ID.
                                
                                //  Start Performance Timer
                                rc = WtcHelperConstants.SQL_SUCCESS;
                            }
                            
                            
                            else if (BUDGET_PCT < ((ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getLAmtSvcAuthDtlAmtReq() + pCSES36DOutputRec.getUlAmtCnsvcUnitRateUsed()) / pCSES36DOutputRec.getUlAmtCnsvcUnitRate()) && FND_YES == ccon23si.getCIndCntrctBudgLimit()) {
                                //  To Do Processing
                                
                                //  Allocate memory for DAM Input and Output Structures
                                // CSUB40UO
                                pTodoCommonInput = new CSUB40UI();
                                
                                pTodoCommonOutput = new CSUB40UO();
                                
                                pTodoCommonInput.setArchInputStruct(ccon23si.getArchInputStruct());
                                
                                
                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(ccon23si.getSzSysCdTodoCf());
                                pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ccon23si.getUlIdCntrctManager());
                                pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccon23si.getUlIdPerson());
                                pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccon23si.getUlIdStage());
                                rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrDate1, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtCurrDate1);
                                pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfDesc("The budget for Contract " + ccon23si.getUlIdContract() + " Svc " + (ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlSvc()) + " is expended.");
                                rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                                
                                //  Analyze error code
                                switch (rc) {
                                        
                                        //  Success Case for Dam CSES68D (LRB)
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        
                                        //  Call CCMNC5D
                                        rc = WtcHelperConstants.SQL_SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                        
                                }
                            }
                            
                            
                            
                            else {
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                rc = WtcHelperConstants.SQL_SUCCESS;
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                
                if (WtcHelperConstants.SQL_SUCCESS == rc) {
                    
                    //  Allocate memory for DAM Input and Output Structures
                    // CAUD13D
                    
                    pCAUD13DInputRec = new CAUD13DI();
                    
                    pCAUD13DOutputRec = new CAUD13DO();
                    
                    pCAUD13DInputRec.setArchInputStruct(ccon23si.getArchInputStruct());
                    pCAUD13DInputRec.getArchInputStruct().setCReqFuncCd(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdScrDataAction());
                    pCAUD13DInputRec.setSzCdSvcAuthDtlAuthType(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlAuthType());
                    pCAUD13DInputRec.setSzCdSvcAuthDtlPeriod(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlPeriod());
                    pCAUD13DInputRec.setSzCdSvcAuthDtlSvc(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlSvc());
                    pCAUD13DInputRec.setSzCdSvcAuthDtlUnitType(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getSzCdSvcAuthDtlUnitType());
                    pCAUD13DInputRec.setDtDtSvcAuthDtl(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtl());
                    pCAUD13DInputRec.setDtDtSvcAuthDtlBegin(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlBegin());
                    
                    pCAUD13DInputRec.setDtDtSvcAuthDtlEnd(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlEnd());
                    pCAUD13DInputRec.setDtDtSvcAuthDtlTerm(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtDtSvcAuthDtlTerm());
                    pCAUD13DInputRec.setDtSvcAuthDtlShow(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getDtSvcAuthDtlShow());
                    pCAUD13DInputRec.setTsLastUpdate(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getTsLastUpdate());
                    pCAUD13DInputRec.setUlIdPerson(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdPerson());
                    pCAUD13DInputRec.setUlIdSvcAuth(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdSvcAuth());
                    pCAUD13DInputRec.setUlIdSvcAuthDtl(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdSvcAuthDtl());
                    pCAUD13DInputRec.setLAmtSvcAuthDtlAmtReq(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getLAmtSvcAuthDtlAmtReq());
                    
                    pCAUD13DInputRec.setUNbrSvcAuthDtlFreq(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUNbrSvcAuthDtlFreq());
                    pCAUD13DInputRec.setUlNbrSvcAuthDtlLineItm(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlNbrSvcAuthDtlLineItm());
                    pCAUD13DInputRec.setLNbrSvcAuthDtlSugUnit(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getLNbrSvcAuthDtlSugUnit());
                    pCAUD13DInputRec.setLNbrSvcAuthDtlUnitRate(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getLNbrSvcAuthDtlUnitRate());
                    pCAUD13DInputRec.setLNbrSvcAuthDtlUnitReq(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getLNbrSvcAuthDtlUnitReq());
                    rc = caud13dAUDdam(sqlca, pCAUD13DInputRec, pCAUD13DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                            //  SQL Not Found Case for Dam CSES68D (LRB)
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            if (0 == ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdSvcAuthDtl()) {
                                
                                pCCMN68DInputRec = new CCMN68DI();
                                
                                if (pCAUD13DInputRec == null) {
                                    
                                    
                                    //  Call CCMNC5D
                                    rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                
                                pCCMN68DOutputRec = new CCMN68DO();
                                
                                if (pCAUD13DOutputRec == null) {
                                    rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                pCCMN68DInputRec.setArchInputStruct(ccon23si.getArchInputStruct());
                                pCCMN68DInputRec.getArchInputStruct().setCReqFuncCd(REQ_FUNC_CD_ADD);
                                pCCMN68DInputRec.setUlIdPerson(ccon23si.getROWCCON23SIG00_ARRAY().getROWCCON23SIG00(usRow).getUlIdPerson());
                                pCCMN68DInputRec.setUlIdEvent(ccon23si.getUlIdEvent());
                                rc = ccmn68dAUDdam(sqlca, pCCMN68DInputRec, pCCMN68DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                        //  Success Case for Dam CSES68D (LAD)
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        break;
                                        
                                        //  SQL Not Found Case for Dam CSES68D (LAD)
                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Call DAM
                                        rc = WtcHelperConstants.SQL_SUCCESS;
                                        break;
                                    default :// For CSES36D
                                        
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            break;
                            
                            //  SQL Not Found Case for Dam CINV74D
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            break;
                            
                            //  Success Case for Dam CSES68D (CAA)
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
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon23si.getArchInputStruct() , ccon23so.getArchOutputStruct());
        
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
        return ccon23so;
    }

}
