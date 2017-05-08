package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB81DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CSUB17S.src
**
** Service Name:  CSUB17S
**
** Description:   This service will confirm that event processsing is OK
**                using Check Stage Event Status function and add/update an
**                event row and a Level of Care row.  If primary child is
**                unknown, it will be determined.  Oracle trigger will be set
**                on the Person LOC table to write to its shadow table.
**                The shadow table will trigger an update to the adjustment
**                table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  9/27/95
**
** Programmer:    Stephen Helmke
**
** Archive Information: $Revision:   1.5  $
**                      $Date:   08 Feb 2000 14:52:54  $
**                      $Modtime:   08 Feb 2000 11:55:14  $
**                      $Author:   pvcs  $
**
e* Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/28/96  WILSONET  SIR#10122: Remove stop Timer after common function
**                      and include timers for CINV43D - ToDoAUD DAM
**
**  08/27/96  vanderm   SIR 22100: memory problem fix.  Memory allotted and
**                      freed within if statements.
**
**  01/10/96  saravigm  We want the indicator to be set regardless if the
**                      event is closed or in process.  The indicator should
**                      have no effects on payment.
**
** 02/04/2000 Peril     Added code and a new dam(CSUB81D.PC)
**                      to check for duplicate start dates for
**                      Authorized level of care.See comments under #15148.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
** 03/06/2003  DWW      Added an error handling block, because this actually sinks a timestamp
** 		        mismatch returned from PostEvent
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
**
**  07/28/03  JEH       SIR 19185 - Adding PROCESS_TUX_RC_ERROR after ccmn06 call
**                      to prevent further processing of the service
**
**  10/29/03  dejuanr   SIR 19986 - Created dam caude9 to create new ALOCs.
**                      This dam will ingnore ALOC's created in previous
**                      stages.
**  01/18/05  reedlg    SIR 18563 - populate dtEventOccurred with today's date,
**                      not LOC start date.
**  02/08/05  CORLEYAN  SIR 23401 - Save id person who is updating the row
**  02/14/05  CORLEYAN  SIR 23400 - Save Review Type
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub17s {
    public static final int CURRENT = 0;
    public static final int NEXT = 1;
    public static final int EVENT = 0;
    public static final int LOC = 1;
    public static final String BILLING = "BLOC";
    public static final String AUTHORIZED = "ALOC";
    public static final int FND_FAIL = 1;
    
    public static final String STATUS_NEW = "NEW";
    public static final int ZERO = 0;
    public static final String STATUS_COMPLETE = "COMP";
    public static final String PRIMARY_CHILD = "PC";
    CSUB17SO CSUB17S(CSUB17SI csub17si) {
        CSUB17SO csub17so = new CSUB17SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CSUB17S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        int RetVal = SUCCESS;
        /*
        ** SIR 18563 - get today's date for dtEventOccurred
        */
        FndInt3date DtToday = null;
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        
        /*
        ** Declare local variables
        */
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;/* Post Event Common Function */
        
        CAUD11DI pCAUD11DInputRec = null;
        CAUD11DO pCAUD11DOutputRec = null;/* AUD for Person LOC table for BLOC and RLOC*/
        
        CAUDE9DI pCAUDE9DInputRec = null;
        CAUDE9DO pCAUDE9DOutputRec = null;/* AUD for Person LOC table for ALOC - SIR 19986 */
        
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;/* Check Stage Event Status */
        
        CSES15DI pCSES15DInputRec = null;
        CSES15DO pCSES15DOutputRec = null;/* Retrieve from Person LOC */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        
        CSUB81DI pCSUB81DInputRec = null;
        CSUB81DO pCSUB81DOutputRec = null;/*Retrieve from Person LOC */
        rc = ARC_PRFServiceStartTime_TUX(csub17si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for common function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub17si.getArchInputStruct());
        pCCMN06UInputRec.setSzCdTask(csub17si.getSzCdTask());
        pCCMN06UInputRec.setUlIdStage(csub17si.getUlIdStage());
        
        /*
        ** Call CINT21D
        */
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                RetVal = SUCCESS;
                break;
                
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                RetVal = FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
                
                // SIR 11077 - We are assuming that all the exceptions raised
                // will be bcause of deleting the VID for a resource that has
                // contracts asociated with it.
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                RetVal = FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                RetVal = FND_FAIL;
                break;
        }
        
        /*
        ** Analyze error code
        */
        if ((SUCCESS == RetVal) && (0 == csub17si.getUlIdPerson())) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCINV51DInputRec = new CINV51DI();
            
            pCINV51DOutputRec = new CINV51DO();
            pCINV51DInputRec.setArchInputStruct(csub17si.getArchInputStruct());
            pCINV51DInputRec.setUlIdStage(csub17si.getUlIdStage());
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
            
            //  Set rc to MSG_NO_PAL_COORD_EXISTS_REASSIGN
            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set retention value to FND_SUCCESS
                    RetVal = SUCCESS;
                    csub17si.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    csub17so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = FND_FAIL;
                    
                    break;
            }
        }
        
        
        
        /*
        ** SIR# 15148 - CSUB81D checks for duplicate dates for ALOC.
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSUB81DInputRec = new CSUB81DI();
        
        pCSUB81DOutputRec = new CSUB81DO();
        pCSUB81DInputRec.setArchInputStruct(csub17si.getArchInputStruct());
        pCSUB81DInputRec.setUlIdPerson(csub17si.getUlIdPerson());
        pCSUB81DInputRec.setSzCdPlocType(csub17si.getSzCdPlocType());
        pCSUB81DInputRec.setDtDtPlocStart(csub17si.getDtDtPlocStart());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCSUB81DInputRec.setDtDtPlocEnd(csub17si.getDtDtPlocEnd());
        
        /*
        ** Set rc to FND_SUCCESS
        */
        rc = csub81dQUERYdam(sqlca, pCSUB81DInputRec, pCSUB81DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                if (((0 == csub17si.getSzCdPlocType().compareTo(AUTHORIZED)) && (0 != pCSUB81DOutputRec.getUsSysNbrNumberOfRows()) && (WtcHelperConstants.REQ_FUNC_CD_ADD == csub17si.getArchInputStruct().getCReqFuncCd())) || ((0 < pCSUB81DOutputRec.getUsSysNbrNumberOfRows()) && (INDICATOR_YES == csub17si.getIndDateModified()) && (ServiceConstants.REQ_FUNC_CD_UPDATE == csub17si.getArchInputStruct().getCReqFuncCd()))) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_ALOC_START_DT_EXISTS;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAIL;
                }
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                }
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAILURE
                RetVal = FND_FAIL;
                break;
        }
        
        if (RetVal != SUCCESS) {
            rc = RetVal;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Address
        */
        if (SUCCESS == RetVal) {
            
            
            //  Allocate memory for common function Post Event Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(csub17si.getArchInputStruct());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub17si.getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub17si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(NEXT));
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType("LOC");
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub17si.getUlIdStage());
            rc = ARC_UTLGetDateAndTime(DtToday, 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(DtToday);
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub17si.getUlIdEventPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub17si.getUlIdPlocEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub17si.getTsLastUpdate_ARRAY().getTsLastUpdate(EVENT));
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub17si.getSzTxtEventDescr());
            
            //  Phone
            if (0 == csub17si.getUlIdPlocEvent()) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            
            //  Name: if person is being added, create default entry in Name table
            if (0 == STATUS_NEW.compareTo(csub17si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(CURRENT)) || (0 == csub17si.getUlIdPlocEvent())) {
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(EVENT).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(EVENT).setUlIdPerson(csub17si.getUlIdPerson());
            }
            
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            switch (rc) {
                    
                    
                    // SIR 11077 - We are assuming that all the exceptions raised
                    // will be bcause of deleting the VID for a resource that has
                    // contracts asociated with it.
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // ochumd Begin SIR 23427
                    //  Name: if person's name has changed update entry in intake allegation table
                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == pCCMN01UInputRec.getArchInputStruct().getCReqFuncCd()) {
                        csub17so.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                    }
                    
                    // ochumd End SIR 23427
                    
                    //  IDs
                    if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == pCCMN01UInputRec.getArchInputStruct().getCReqFuncCd()) {
                        csub17so.setUlIdEvent(csub17si.getUlIdPlocEvent());
                    }
                    csub17so.getTsLastUpdate_ARRAY().setTsLastUpdate(EVENT, pCCMN01UOutputRec.getTsLastUpdate());
                    
                    // 
                    // OPTIONAL CODE NOTE (BEGIN): Generic AUD
                    // 
                    //  Allocate memory for DAM CAUD11D Input and Output Structures
                    pCAUD11DInputRec = new CAUD11DI();
                    
                    pCAUD11DOutputRec = new CAUD11DO();
                    pCAUD11DInputRec.getArchInputStruct().setCReqFuncCd(csub17si.getArchInputStruct().getCReqFuncCd());
                    
                    
                    //  SIR 15512 Below
                    if (ZERO == csub17si.getUlIdPlocEvent()) {
                        
                        pCAUD11DInputRec.setUlIdPlocEvent(csub17so.getUlIdEvent());
                    }
                    
                    else {
                        
                        pCAUD11DInputRec.setUlIdPlocEvent(csub17si.getUlIdPlocEvent());
                    }
                    pCAUD11DInputRec.setTsLastUpdate(csub17si.getTsLastUpdate_ARRAY().getTsLastUpdate(LOC));
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                    //  Following deviates from the general procedure as this service is called by another service and
                    //  it can also be called directly.
                    //  TUX_CHECK_APPL_STATUS
                    if ((0 == csub17si.getSzCdPlocType().compareTo(BILLING)) && (WtcHelperConstants.REQ_FUNC_CD_UPDATE == csub17si.getArchInputStruct().getCReqFuncCd())) {
                        pCAUD11DInputRec.setCIndPlocWriteHistory(INDICATOR_YES);
                    }
                    
                    else {
                        pCAUD11DInputRec.setCIndPlocWriteHistory(Cint14s.INDICATOR_NO);
                    }
                    pCAUD11DInputRec.setUlIdPerson(csub17si.getUlIdPerson());
                    pCAUD11DInputRec.setSzCdPlocChild(csub17si.getSzCdPlocChild());
                    pCAUD11DInputRec.setSzCdPlocType(csub17si.getSzCdPlocType());
                    pCAUD11DInputRec.setBSysIndPrfrmValidation(csub17si.getBSysIndPrfrmValidation());
                    pCAUD11DInputRec.setCIndPlocCsupSend(csub17si.getCIndPlocCsupSend());
                    pCAUD11DInputRec.setDtDtPlocEnd(csub17si.getDtDtPlocEnd());
                    pCAUD11DInputRec.setDtDtPlocStart(csub17si.getDtDtPlocStart());
                    
                    pCAUD11DInputRec.setUlIdPersUpdt(csub17si.getUlIdPersUpdt());
                    pCAUD11DInputRec.setSzCdRevType(csub17si.getSzCdRevType());
                    pCAUD11DInputRec.setArchInputStruct(csub17si.getArchInputStruct());
                    //Commit only if we began the transaction in this service
                    if (MATCH == csub17si.getSzCdPlocType().compareTo(AUTHORIZED)) {
                        //  Call CAUDE9D
                        // Allocate memory for DAM CAUDE9D Input and Output Structures
                        pCAUDE9DInputRec = new CAUDE9DI();
                        
                        pCAUDE9DOutputRec = new CAUDE9DO();
                        pCAUDE9DInputRec.getArchInputStruct().setCReqFuncCd(csub17si.getArchInputStruct().getCReqFuncCd());
                        pCAUDE9DInputRec.setArchInputStruct(csub17si.getArchInputStruct());
                        pCAUDE9DInputRec.setUlIdPlocEvent(pCAUD11DInputRec.getUlIdPlocEvent());
                        pCAUDE9DInputRec.setTsLastUpdate(csub17si.getTsLastUpdate_ARRAY().getTsLastUpdate(LOC));
                        
                        pCAUDE9DInputRec.setCIndPlocWriteHistory(pCAUD11DInputRec.getCIndPlocWriteHistory());
                        
                        pCAUDE9DInputRec.setUlIdPerson(csub17si.getUlIdPerson());
                        pCAUDE9DInputRec.setUlIdStage(csub17si.getUlIdStage());
                        pCAUDE9DInputRec.setSzCdPlocChild(csub17si.getSzCdPlocChild());
                        pCAUDE9DInputRec.setSzCdPlocType(csub17si.getSzCdPlocType());
                        pCAUDE9DInputRec.setBSysIndPrfrmValidation(csub17si.getBSysIndPrfrmValidation());
                        pCAUDE9DInputRec.setCIndPlocCsupSend(csub17si.getCIndPlocCsupSend());
                        pCAUDE9DInputRec.setUlIdPersUpdt(csub17si.getUlIdPersUpdt());
                        pCAUDE9DInputRec.setSzCdRevType(csub17si.getSzCdRevType());
                        pCAUDE9DInputRec.setDtDtPlocEnd(csub17si.getDtDtPlocEnd());
                        pCAUDE9DInputRec.setDtDtPlocStart(csub17si.getDtDtPlocStart());
                        
                        rc = caude9dAUDdam(sqlca, pCAUDE9DInputRec, pCAUDE9DOutputRec);
                        pCAUD11DOutputRec.setUlSysNbrValidationMsg(pCAUDE9DOutputRec.getUlSysNbrValidationMsg());
                    }
                    else {
                        //  Not found will have to be accepted given the fact
                        // that the call could be coming from the temporary
                        // workload, and would not have a stage record.
                        rc = caud11dAUDdam(sqlca, pCAUD11DInputRec, pCAUD11DOutputRec);
                    }
                    if (ZERO < pCAUD11DOutputRec.getUlSysNbrValidationMsg()) {
                        pServiceStatus.explan_code = pCAUD11DOutputRec.getUlSysNbrValidationMsg();
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        rc = pCAUD11DOutputRec.getUlSysNbrValidationMsg();
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    
                    else {
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Allocate memory for DAM CSES15D Input and
                                // Output Structures
                                pCSES15DInputRec = new CSES15DI();
                                
                                pCSES15DOutputRec = new CSES15DO();
                                pCSES15DInputRec.setArchInputStruct(csub17si.getArchInputStruct());
                                
                                if (WtcHelperConstants.REQ_FUNC_CD_ADD == csub17si.getArchInputStruct().getCReqFuncCd()) {
                                    pCSES15DInputRec.setUlIdPlocEvent(csub17so.getUlIdEvent());
                                }
                                
                                else {
                                    pCSES15DInputRec.setUlIdPlocEvent(csub17si.getUlIdPlocEvent());
                                }
                                rc = cses15dQUERYdam(sqlca, pCSES15DInputRec, pCSES15DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub17so.getTsLastUpdate_ARRAY().setTsLastUpdate(LOC, pCSES15DOutputRec.getTsLastUpdate());
                                        
                                        if (0 != csub17si.getUlIdPlocEvent()) {
                                            //  Allocate memory for DAM Input and
                                            // Output Structures
                                            pCINV43DInputRec = new CINV43DI();
                                            
                                            pCINV43DOutputRec = new CINV43DO();
                                            pCINV43DInputRec.setArchInputStruct(csub17si.getArchInputStruct());
                                            pCINV43DInputRec.setUlIdEvent(csub17si.getUlIdPlocEvent());
                                            
                                            //  Call DAM
                                            rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
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
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub17si.getArchInputStruct() , csub17so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            //  Call DAM
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        
        return csub17so;
    }

}
