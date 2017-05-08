package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD97DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD97DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD99DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD99DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB2DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
**
** Module File:   CFAD40S.src
**
** Service Name:  Adpt Sub Save
**
** Description:   This service will write to the Adoption Subsidy table
**                and handle record overlap and audits, write to the
**                Medicaid Update Table, and handle events and ToDos.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created: 1/31/1996
**
** Programmer:   Brian Walker
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   17 Sep 1996 14:20:08  $
**                      $Modtime:   17 Sep 1996 13:19:30  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/06/96  OMARAJJ   SIR#3661 - Added and SQL_NOT_FOUND case with the
**                      SUCCESS case when calling CINV43D, the TODO Update
**                      Dam so that when no TODO exist the Save service won't
**                      fail.
**  3/8/96    PURCELA   SIR #3770 - Since the most recent generation of the
**                      WCD and Service Input Header, the ToDo indicator
**                      variables had been changed in Foundation from bSys...
**                      to cSys...  Modified Code to handle the different
**                      values.
**  3/13/96   PURCELA   SIR #3710 - Added a Dummy Event Indicator to the
**                      Input Header and passed Func Codes / Performed logic
**                      based on whether a Dummy Event is being modified.
**                      Previous logic would fail when an event existed with
**                      a New Status and no linked Adoption Subsidy record.
**
**  3/13/96   OMARAJJ   SIR#3628 - Removed the a code condtion for Agreement Returned
**                      TODOs so that these TODOs will be created based only on
**                      whether or not the Agreement Returned Date is present.
**
**  3/13/96   OMARAJJ   SIR#3633 - Corrected the Text for TODO FAD042 to match
**                      the description in the TODO spreadsheet.
**
**  3/14/96   ADKINSMC  SIR #3633 - Added ARC_UTLAddToDate for FAD038 and
**                      FAD042 TODOs. Subtracted 90 days from the Adoption
**                      Subsidy end date that is passed from the Adoption
**                      Subsidy Detail so that the ToDo will be created 90
**                      days before the end date.
**
**  3/18/96   ZIMMERNE  SIR #3933 -   The if statement that calls CINV43D
**                      (the dam that completes to-do's) was modified.  "Or
**                      event status is PROC," was added to the if statement.
**                      To-do's with the event status of PROC should be
**                      completed along with the to-do's with status of COMP.
**                      This ensures that manually created to-do's are deleted.
**  3/25/96   PURCELA   SIR #4213 - Set the IndAdptSubProcess to N if the
**                      Adoption Subsidy is new.  Otherwise, simply pass it
**                      through.
**  3/28/96   PURCELA   SIR #4322 - Inserted conditionality into the setting
**                      of the ToDo flags that the Event Status is not COMP.
**                      If it is, then the only ToDo that should be created
**                      is the one to create a new Subsidy.
**  4/2/96    OMARAJJ   SIR# 4220 - Before the call to CAUD99D MEDICAID UPDATE
**                      TABLE, when the Adoption Subsidy Trans Type is  DEN,
**                      denial, and the Adoption Subsidy End Month is the
**                      current month and the current day is the 15th or
**                      after the Medicaid Update table should not be updated.
**  04/11/96  OMARAJJ   SIR#20301 - Corrected the variable ulIdPerson, an input
**                      for CAUD99D, so that the correct Person ID is saved
**                      to the Medicaid Update Table.
**  5/6/96    PURCELA   SIR #20830 - In order to compensate for Non
**                      Navigational Events, only perform
**                      CheckStageEventStatus if a CdTask has been passed
**                      into the Service.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  5/21/2003 MCCLAIM   Set rc based on explan_code if RetVal == FND_FAIL
**                      Tried to protect rc/RetVal in a couple places
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad40s {
    
    /*
    ** Declare FOUNDATION variables
    */
    
    /* SIR#4220 */
    static final String TYPE_DENIAL = "DEN";
    static final String TYPE_ADD = "ADD";
    static final String TYPE_TRANSFER = "TRA";
    static final String NULL_STRING1 = "";
    CFAD40SO CFAD40S(CFAD40SI cfad40si) {
        CFAD40SO cfad40so = new CFAD40SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        rc = ARC_UTLCheckServiceBatchBlock("CFAD40S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare local variables
        */
        //##  short rc = FND_SUCCESS;
        public public public public int RetVal = SUCCESS;
        int usRow = 0;
        int usInputRow = 0;
        FndInt3date dtAdd1 = new FndInt3date( - 90, 0, 0);
        FndInt3date dtAdd2 = new FndInt3date(45, 0, 0);
        
        
        
        String bToDoFlag = new String();
        
        int iToDoFlagCounter = 0;
        FndInt3date dtDtCurrentDate = null;
        int ulPostEventIdEvent = 0;
        
        
        
        CAUD97DI pCAUD97DInputRec = null;
        CAUD97DO pCAUD97DOutputRec = null;
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        CAUD99DI pCAUD99DInputRec = null;
        CAUD99DO pCAUD99DOutputRec = null;
        
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        
        CSUB40UI pToDoCommonInput = null;
        CSUB40UO pToDoCommonOutput = null;
        
        CAUDB2DI pCAUDB2DInputRec = null;
        CAUDB2DO pCAUDB2DOutputRec = null;
        bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD037, false);
        bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD038, false);
        bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD040, false);
        bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD041, false);
        bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD042, false);
        rc = ARC_PRFServiceStartTime_TUX(cfad40si.getArchInputStruct());
        if (0 != NULL_STRING1.compareTo(cfad40si.getROWCCMN01UIG00().getSzCdTask())) {
            //  Execute "The Gate" Perform Check Stage Event Status
            // Processing, CCMN06U
            
            // 
            // BEGIN CCMN06U Check Stage Event Status
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cfad40si.getArchInputStruct());
            pCCMN06UInputRec.setUlIdStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cfad40si.getROWCCMN01UIG00().getSzCdTask());
            if (0 == cfad40si.getROWCCMN01UIG00().getUlIdEvent() && Cint14s.INDICATOR_NO == cfad40si.getBSysIndUserTodo()) {
                pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
            }
            
            else {
                pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                    
                case Messages.MSG_SYS_STAGE_CLOSED:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                    
                case Messages.MSG_SYS_MULT_INST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            // 
            // BEGIN CCMN01U Post Event
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(cfad40si.getArchInputStruct());
            if (0 == cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(cfad40si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(cfad40si.getROWCCMN01UIG00().getTsLastUpdate());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(cfad40si.getROWCCMN01UIG00().getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(cfad40si.getROWCCMN01UIG00().getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(cfad40si.getROWCCMN01UIG00().getDtDtEventOccurred());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(cfad40si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(cfad40si.getROWCCMN01UIG00().getSzTxtEventDescr());
            
            //  Get the current date and store it in dtCurrDate
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    //  Populate ulPostEventIdEvent with IdEvent.  This is done because it
                    // is needed in CAUD97DI.  ulPostEventIdEvent is a local varaible created
                    // created to hold this value.  It is referenced here, in the CAUD97D
                    // CSUB40, and CAUD99 input structure.
                    ulPostEventIdEvent = pCCMN01UOutputRec.getUlIdEvent();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            if ((Cint14s.INDICATOR_NO == cfad40si.getCSysIndAppSent()) && (0 != cfad40si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(Cinv61s.EVENT_STATUS_COMP))) {
                
                if (DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAppSent().day && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAppSent().month && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAppSent().year && DateHelper.NULL_DATE == cfad40si.getCFAD40SIG00().getDtDtAdptSubAppReturned().day && DateHelper.NULL_DATE == cfad40si.getCFAD40SIG00().getDtDtAdptSubAppReturned().month && DateHelper.NULL_DATE == cfad40si.getCFAD40SIG00().getDtDtAdptSubAppReturned().year) {
                    bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD037, true);
                }
            }
            if ((Cint14s.INDICATOR_NO == cfad40si.getCSysIndAgreeSent()) && (0 != cfad40si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(Cinv61s.EVENT_STATUS_COMP))) {
                if (DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent().day && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent().month && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent().year && DateHelper.NULL_DATE == cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn().day && DateHelper.NULL_DATE == cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn().month && DateHelper.NULL_DATE == cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn().year) 
                {
                    bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD040, true);
                }
            }
            if ((Cint14s.INDICATOR_NO == cfad40si.getCSysIndAgreeRtn()) && (0 != cfad40si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(Cinv61s.EVENT_STATUS_COMP))) {
                if (DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn().day && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn().month && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn().year) {
                    bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD041, true);
                }
            }
            //  Call DAM if good code
            if (Cint14s.INDICATOR_NO == cfad40si.getCSysIndSubEnd()) {
                
                //  Analyze error code
                if (DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd().day && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd().month && DateHelper.NULL_DATE != cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd().year) {
                    if (0 != cfad40si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(Cinv61s.EVENT_STATUS_COMP)) {
                        bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD042, true);
                    }
                    bToDoFlag = CStringUtils.setCharAt(bToDoFlag, FAD038, true);
                }
            }
        }
        if ((0 != cfad40si.getROWCCMN01UIG00().getUlIdEvent()) && ((0 == cfad40si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(Csub64s.STATUS_COMPLETE)) || (0 == cfad40si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(Cinv28s.EVENT_STATUS_PROC))) && (SUCCESS == RetVal)) {
            
            // 
            // BEGIN CINV43D ToDo Complete AUD
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCINV43DInputRec = new CINV43DI();
            
            pCINV43DOutputRec = new CINV43DO();
            pCINV43DInputRec.setArchInputStruct(cfad40si.getArchInputStruct());
            pCINV43DInputRec.setUlIdEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
            pCINV43DInputRec.getArchInputStruct().setCReqFuncCd(cfad40si.getArchInputStruct().getCReqFuncCd());
            
            rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
            
            
            //  SIR#10122: Remove Stop DAM Performance Timer.
            // Timers are started and stopped within DAMs.
            
            //  Analyze return code
            switch (rc) {// begin SIR #15787: Portion A is replaced by lines 5899 to #6091
                case WtcHelperConstants.SQL_SUCCESS:
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    //  Get the current date and store it in dtCurrDate
                    rc = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            // 
            // BEGIN CAUD97D  ADT SUB AUD
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCAUD97DInputRec = new CAUD97DI();
            
            pCAUD97DOutputRec = new CAUD97DO();
            pCAUD97DInputRec.setArchInputStruct(cfad40si.getArchInputStruct());
            pCAUD97DInputRec.setUlIdAdptSub(cfad40si.getCFAD40SIG00().getUlIdAdptSub());
            pCAUD97DInputRec.getArchInputStruct().setCReqFuncCd(cfad40si.getArchInputStruct().getCReqFuncCd());
            pCAUD97DInputRec.setDtDtAdptSubAgreeRetn(cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeRetn());
            pCAUD97DInputRec.setDtDtAdptSubAgreeSent(cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent());
            pCAUD97DInputRec.setDtDtAdptSubAppReturned(cfad40si.getCFAD40SIG00().getDtDtAdptSubAppReturned());
            pCAUD97DInputRec.setDtDtAdptSubAppSent(cfad40si.getCFAD40SIG00().getDtDtAdptSubAppSent());
            pCAUD97DInputRec.setDtDtAdptSubApprvd(cfad40si.getCFAD40SIG00().getDtDtAdptSubApprvd());
            pCAUD97DInputRec.setDtDtAdptSubEffective(cfad40si.getCFAD40SIG00().getDtDtAdptSubEffective());
            pCAUD97DInputRec.setDtDtAdptSubEnd(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd());
            pCAUD97DInputRec.setSAmtAdptSub(cfad40si.getCFAD40SIG00().getSAmtAdptSub());
            pCAUD97DInputRec.setSzTxtAdptSubRsn(cfad40si.getCFAD40SIG00().getSzTxtAdptSubRsn());
            pCAUD97DInputRec.setSzCdAdptSubCloseRsn(cfad40si.getCFAD40SIG00().getSzCdAdptSubCloseRsn());
            
            pCAUD97DInputRec.setCIndAdptSubThirdParty(cfad40si.getCFAD40SIG00().getCIndAdptSubThirdParty());
            
            if (0 == cfad40si.getROWCCMN01UIG00().getUlIdEvent() || INDICATOR_YES == cfad40si.getBSysIndUserTodo()) {
                pCAUD97DInputRec.setCIndAdptSubProcess(Cint14s.INDICATOR_NO);
            }
            
            else {
                pCAUD97DInputRec.setCIndAdptSubProcess(cfad40si.getCFAD40SIG00().getCIndAdptSubProcess());
            }
            pCAUD97DInputRec.setSzCdAdptAudDeterm(cfad40si.getCFAD40SIG00().getSzCdAdptSubDeterm());
            pCAUD97DInputRec.setUlIdAdptSubPayee(cfad40si.getCFAD40SIG00().getUlIdAdptSubPayee());
            pCAUD97DInputRec.setTsLastUpdate(cfad40si.getCFAD40SIG00().getTsLastUpdate());
            pCAUD97DInputRec.setUlIdPlcmtEvent(cfad40si.getUlIdPlcmtEvent());
            pCAUD97DInputRec.setDtDtAdptSubLastInvc(cfad40si.getCFAD40SIG00().getDtDtAdptSubLastInvc());
            pCAUD97DInputRec.setUlAdptSubPerson(cfad40si.getUlIdPerson());
            
            rc = caud97dAUDdam(sqlca, pCAUD97DInputRec, pCAUD97DOutputRec);
            
            
            //  Stop DAM Performance Timer
            //##    ARC_PRFDataAccessStopTime();
            
            
            
            //  Analyze return code
            switch (rc) {
                    
                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    if (0 == pCAUD97DOutputRec.getUlSysNbrValidationMsg()) {
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        cfad40so.setUlIdAdptSub(pCAUD97DOutputRec.getUlIdAdptSub());
                        
                        //  Set Ret Val to FND_SUCCESS
                        RetVal = SUCCESS;
                        
                        if (0 == cfad40si.getROWCCMN01UIG00().getUlIdEvent() || INDICATOR_YES == cfad40si.getBSysIndUserTodo()) {
                            
                            // 
                            // BEGIN CAUDB2D  ADT SUB EVENT LINK AUD
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCAUDB2DInputRec = new CAUDB2DI();
                            
                            pCAUDB2DOutputRec = new CAUDB2DO();
                            pCAUDB2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            pCAUDB2DInputRec.setUlIdEvent(ulPostEventIdEvent);
                            pCAUDB2DInputRec.setUlIdAdptSub(pCAUD97DOutputRec.getUlIdAdptSub());
                            
                            rc = caudb2dAUDdam(sqlca, pCAUDB2DInputRec, pCAUDB2DOutputRec);
                            
                            //  Stop DAM Performance Timer
                            //##  ARC_PRFDataAccessStopTime();
                            
                            //  Analyze return code
                            
                            // Sir # 15148 - Added  conditions to check
                            // if the IndDateModified is true .
                            
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set Ret Val to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                        }
                    }
                    else {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = pCAUD97DOutputRec.getUlSysNbrValidationMsg();
                        
                        //  Set Ret Val to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                    //  SIR# 21795 - This code did not have a default switch so when the dam
                    // fails processing continues without failure.
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    
                    RetVal = Csub50s.FND_FAIL;
                    //  Do nothing, the output message just returns success or
                    // failure.
                    break;
            }
        }
        if (SUCCESS == RetVal && null != cfad40si.getSzCdMedUpdType()[0] && null != cfad40si.getSzCdMedUpdTransTypE()[0]) {
            
            //  Call CAUD15D.  The Contract Version AUD DAM receives IdContract,
            // NbrCnperPeriod, NbrCnverVersion, IdCntrctWkr, DtCnverCreate,
            // DtCnverEffective, DtCnverEnd, IndCnverVerLock, NbrCnverNoShowPct
            // and TxtCnverComment. It performs a full row AUD on the Contract
            // Version table.
            rc = ARC_UTLGetDateAndTime(dtDtCurrentDate, 0);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            if (!(TYPE_ADD.compareTo(cfad40si.getSzCdMedUpdTransTypE()) != 0) ||!(TYPE_TRANSFER.compareTo(cfad40si.getSzCdMedUpdTransTypE()) != 0) ||!(TYPE_DENIAL.compareTo(cfad40si.getSzCdMedUpdTransTypE()) != 0) &&!(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd().month == dtDtCurrentDate.month && dtDtCurrentDate.day >= 15)) {
                // 
                // BEGIN CAUD99D MEDICAID UPDATE TABLE
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCAUD99DInputRec = new CAUD99DI();
                
                pCAUD99DOutputRec = new CAUD99DO();
                pCAUD99DInputRec.setArchInputStruct(cfad40si.getArchInputStruct());
                pCAUD99DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCAUD99DInputRec.setUlIdMedUpdStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
                pCAUD99DInputRec.setUlIdMedUpdPerson(cfad40si.getUlIdPerson());
                if (0 != cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCAUD99DInputRec.setUlIdMedUpdRecord(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
                }
                
                else {
                    pCAUD99DInputRec.setUlIdMedUpdRecord(ulPostEventIdEvent);
                }
                pCAUD99DInputRec.setSzCdMedUpdType(cfad40si.getSzCdMedUpdType());
                pCAUD99DInputRec.setSzCdMedUpdTransTypE(cfad40si.getSzCdMedUpdTransTypE());
                rc = caud99dAUDdam(sqlca, pCAUD99DInputRec, pCAUD99DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        
        if ((SUCCESS == RetVal) && ((bToDoFlag.charAt(FAD037) == true) || (bToDoFlag.charAt(FAD038) == true) || (bToDoFlag.charAt(FAD040) == true) || (bToDoFlag.charAt(FAD041) == true) || (bToDoFlag.charAt(FAD042) == true))) {
            for (iToDoFlagCounter = 0;iToDoFlagCounter <= FAD042 && SUCCESS == RetVal;iToDoFlagCounter++) {
                
                if (true == bToDoFlag.charAt(iToDoFlagCounter)) {
                    // 
                    // BEGIN CSUB40U ToDo COMMON FUNTION
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pToDoCommonInput = new CSUB40UI();
                    
                    pToDoCommonOutput = new CSUB40UO();
                    pToDoCommonInput.setArchInputStruct(cfad40si.getArchInputStruct());
                    
                    //  Analyze return code
                    switch (iToDoFlagCounter) {
                            
                        case FAD037:
                            pToDoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD037");
                            rc = ARC_UTLGetDateAndTime(pToDoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pToDoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += "Has the subsidy application for " + cfad40si.getSzNmStage() + " been received?";
                            break;
                        case FAD038:
                            
                            pToDoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD038");
                            pToDoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd());
                            //  Get the current date and store it in dtCurrDate
                            rc = ARC_UTLAddToDate((FndInt3date) & pToDoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , (FndInt3date) & dtAdd1);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pToDoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += "A new adoption subsidy period for " + cfad40si.getSzNmStage() + " needs to be created.";
                            break;
                        case FAD040:// No Svc Auth Detail Rows Found
                            pToDoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD040");
                            pToDoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(cfad40si.getCFAD40SIG00().getDtDtAdptSubAgreeSent());
                            
                            rc = ARC_UTLAddToDate((FndInt3date) & pToDoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , (FndInt3date) & dtAdd2);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pToDoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += "Has the subsidy agreement for " + cfad40si.getSzNmStage() + " been received?";
                            break;
                        case FAD041:
                            pToDoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD041");
                            //  Get the current date and store it in dtCurrDate
                            rc = ARC_UTLGetDateAndTime(pToDoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pToDoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += "You must complete the subsidy details or close the subsidy.";
                            break;
                        case FAD042:
                            pToDoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD042");
                            
                            pToDoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(cfad40si.getCFAD40SIG00().getDtDtAdptSubEnd());
                            
                            rc = ARC_UTLAddToDate((FndInt3date) & pToDoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , (FndInt3date) & dtAdd1);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pToDoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += "The adoption subsidy for " + cfad40si.getSzNmStage() + " must be closed.";
                            pToDoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() += "The adoption subsidy for " + cfad40si.getSzNmStage() + " must be closed.  The Close Adoption Subsidy batch processwill automatically close it 2 weeks before its end date";
                            break;
                    }
                    if (0 == cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
                        pToDoCommonInput.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    }
                    
                    else {
                        pToDoCommonInput.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    }
                    pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(cfad40si.getROWCCMN01UIG00().getUlIdPerson());
                    pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(cfad40si.getROWCCMN01UIG00().getUlIdPerson());
                    
                    if (0 != cfad40si.getROWCCMN01UIG00().getUlIdEvent()) {
                        pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(cfad40si.getROWCCMN01UIG00().getUlIdEvent());
                        pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
                    }
                    
                    else {
                        
                        pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(ulPostEventIdEvent);
                        pToDoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad40si.getROWCCMN01UIG00().getUlIdStage());
                    }
                    
                    rc = Csub40u.TodoCommonFunction(pToDoCommonInput, pToDoCommonOutput, pServiceStatus);
                    
                    //  Stop DAM Performance Timer
                    //##                        ARC_PRFDataAccessStopTime();
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:// Contract Period Retrieve
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
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
        ARC_PRFServiceStopTime_TUX(cfad40si.getArchInputStruct() , cfad40so.getArchOutputStruct());
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        
        if (RetVal == SUCCESS) {
            //  Get the current date and store it in dtCurrDate
            rc = SUCCESS;
        }
        if ((RetVal == Csub50s.FND_FAIL) && (rc == SUCCESS)) {
            
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
        return cfad40so;
    }

}
