package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB50SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD50DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CSUB50S.src
**
** Service Name:  CSUB50S
**
** Description:   PPT DETAIL AUD
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 13, 1995
** 
** Programmer:  Jennifer Matteson    
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   30 Aug 1996 10:13:10  $
**                      $Modtime:   30 Aug 1996 10:03:16  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  08/29/96  vanderm   SIR 22100 - memory problems: Input and Output Rec
**                      freed twice.  Commented out free statement in error
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub50s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final int FND_FAIL = 1;
    
    public static final String PRIMARY_CHILD = "PC";
    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_PROCESS = "PROC";
    public static final String STATUS_COMPLETE = "COMP";
    public static final String PPR = "Permanency Planning Review ";
    public static final int CURRENT = 0;
    
    public static final int NEXT = 1;
    public static final String TODO_CODE1 = "SUB006";
    public static final String TODO_CODE2 = "SUB007";
    CSUB50SO CSUB50S(CSUB50SI csub50si) {
        CSUB50SO csub50so = new CSUB50SO();
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
        
        CAUD09DI pCAUD09DInputRec = null;
        CAUD09DO pCAUD09DOutputRec = null;
        
        CAUD50DI pCAUD50DInputRec = null;
        CAUD50DO pCAUD50DOutputRec = null;
        
        CSES14DI pCSES14DInputRec = null;
        CSES14DO pCSES14DOutputRec = null;
        CINV51DI pCINV51DInputRec = null;/* Get IdPerson given IdStage & Role */
        
        CINV51DO pCINV51DOutputRec = null;
        
        
        
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* Post Event common function */
        CCMN01UO pCCMN01UOutputRec = null;/* SIR#2006 PostEvent */
        CSUB40UI pCSUB40UInputRec = null;/* TODO common function */
        
        CSUB40UO pCSUB40UOutputRec = null;
        
        
        
        int usRow = 0;
        int usInputRow = 0;
        
        
        /*
        ** Call CSES25D
        */
        rc = ARC_PRFServiceStartTime_TUX(csub50si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub50si.getArchInputStruct());
        
        if (0 == csub50si.getROWCCMN01UIG00().getUlIdEvent()) {
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        else {
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        pCCMN06UInputRec.setUlIdStage(csub50si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csub50si.getROWCCMN01UIG00().getSzCdTask());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  SQL Not Found for DAM CSES75D
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set RetVal to FND_SUCCESS
                RetVal = SUCCESS;
                
                break;
                
                //  SQL Not Found Case for Dam CSES41D
            case Messages.MSG_SYS_STAGE_CLOSED:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                break;
                
                //  Success Case for Dam CSEC63D (PAR)
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                break;
                
                //  SQL Not Found Case for Dam CSEC63D (PAR)
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                break;
                
                //   PROCESS_TUX_RC_ERROR_TRANSACT is called only when there is an unexpected
                // error returned from the callDAM function.
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = FND_FAIL;
                break;
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if ((SUCCESS == RetVal) && (0 == csub50si.getUlIdPerson())) {
            //  Allocate memory for DAM Input and Output Structures
            pCINV51DInputRec = new CINV51DI();
            
            pCINV51DOutputRec = new CINV51DO();
            pCINV51DInputRec.setArchInputStruct(csub50si.getArchInputStruct());
            pCINV51DInputRec.setUlIdStage(csub50si.getUlIdStage());
            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            
            //  Stop Performance Timer
            ARC_PRFServiceStopTime_TUX(csub50si.getArchInputStruct() , csub50so.getArchOutputStruct());
            
            //  Analyze return code
            switch (rc) {
                    
                    //  Success Case for Dam CSES68D (CCR)
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub50si.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = FND_FAIL;
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(csub50si.getArchInputStruct());
            
            if (0 == csub50si.getROWCCMN01UIG00().getUlIdEvent()) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            if ((0 == csub50si.getROWCCMN01UIG00().getUlIdEvent()) || (0 == STATUS_NEW.compareTo(csub50si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(CURRENT)))) {
                
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub50si.getUlIdPerson());
            }
            
            
            //  Call CINV81D
            rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub50si.getROWCCMN01UIG00().getTsLastUpdate());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub50si.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub50si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub50si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub50si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub50si.getROWCCMN01UIG00().getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub50si.getROWCCMN01UIG00().getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub50si.getROWCCMN01UIG00().getSzTxtEventDescr());
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            
            
            //  Analyze return code
            switch (rc) {
                    
                    //  SQL Not Found Case for Dam CSES68D (CCR)
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    csub50so.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                    csub50so.setTsSysTsLastUpdate2(pCCMN01UOutputRec.getTsLastUpdate());
                    //## END TUX/XML: Turn the XML buffer into an input message struct
                    
                    
                    
                    if ((0 == STATUS_COMPLETE.compareTo(csub50si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(NEXT))) || (0 != csub50si.getROWCCMN01UIG00().getUlIdEvent())) {
                        //  Allocate memory for CAUD50DI and CAUD50DO
                        pCAUD50DInputRec = new CAUD50DI();
                        
                        pCAUD50DOutputRec = new CAUD50DO();
                        pCAUD50DInputRec.setArchInputStruct(csub50si.getArchInputStruct());
                        
                        pCAUD50DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        pCAUD50DInputRec.setUlIdEvent(pCCMN01UInputRec.getROWCCMN01UIG00().getUlIdEvent());
                        pCAUD50DInputRec.setDtDtTodoCompleted(csub50si.getCSUB50SIG00().getDtDtPptDocComp());
                        rc = caud50dAUDdam(sqlca, pCAUD50DInputRec, pCAUD50DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                                
                                //  Success Case for Dam CSEC08D (CWA)
                            case WtcHelperConstants.SQL_SUCCESS:
                                
                                //  SQL Not Found Case for Dam CSEC08D (CWA)
                                // This will act as the Success Case to
                                // retrieve the retention period for this
                                // retention period because a "no rows returned"
                                // would mean that the Intake was closed after
                                // assignment.
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = FND_FAIL;
                                break;
                        }
                    }
                    if (FND_FAIL != RetVal) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD09DInputRec = new CAUD09DI();
                        
                        pCAUD09DOutputRec = new CAUD09DO();
                        
                        // 
                        // Function Prototypes
                        // 
                        // SIR#15787: Given IdPerson, returns Birthday
                        pCAUD09DInputRec.setArchInputStruct(csub50si.getArchInputStruct());
                        if (0 == csub50si.getCSUB50SIG00().getUlIdPptEvent()) {
                            pCAUD09DInputRec.setUlIdPptEvent(pCCMN01UOutputRec.getUlIdEvent());
                        }
                        else {
                            pCAUD09DInputRec.setUlIdPptEvent(csub50si.getCSUB50SIG00().getUlIdPptEvent());
                        }
                        pCAUD09DInputRec.setSzAddrPptCity(csub50si.getCSUB50SIG00().getSzAddrPptCity());
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        pCAUD09DInputRec.setSzAddrPptCnty(csub50si.getCSUB50SIG00().getSzAddrPptCnty());
                        pCAUD09DInputRec.setSzAddrPptStLn1(csub50si.getCSUB50SIG00().getSzAddrPptStLn1());
                        pCAUD09DInputRec.setSzAddrPptStLn2(csub50si.getCSUB50SIG00().getSzAddrPptStLn2());
                        pCAUD09DInputRec.setSzAddrPptState(csub50si.getCSUB50SIG00().getSzAddrPptState());
                        pCAUD09DInputRec.setSzAddrPptZip(csub50si.getCSUB50SIG00().getSzAddrPptZip());
                        pCAUD09DInputRec.setSzNbrPptPhone(csub50si.getCSUB50SIG00().getSzNbrPptPhone());
                        pCAUD09DInputRec.setSzTxtPptAddrCmnt(csub50si.getCSUB50SIG00().getSzTxtPptAddrCmnt());
                        pCAUD09DInputRec.setDtDtPptDate(csub50si.getCSUB50SIG00().getDtDtPptDate());
                        pCAUD09DInputRec.setDtDtPptDocComp(csub50si.getCSUB50SIG00().getDtDtPptDocComp());
                        pCAUD09DInputRec.setLNbrPptPhoneExt(csub50si.getCSUB50SIG00().getLNbrPptPhoneExt());
                        pCAUD09DInputRec.setTsLastUpdate(csub50si.getCSUB50SIG00().getTsLastUpdate());
                        pCAUD09DInputRec.setTmScrTmGeneric1(csub50si.getCSUB50SIG00().getTmScrTmPptTime());
                        
                        
                        //  Call CLSC19D
                        rc = caud09dAUDdam(sqlca, pCAUD09DInputRec, pCAUD09DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                                
                                //  Success Case for Dam CSES68D (CWA)
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                //  Retrieve record from the PPT Table to get
                                // most recent timestamp
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCSES14DInputRec = new CSES14DI();
                                
                                pCSES14DOutputRec = new CSES14DO();
                                pCSES14DInputRec.setArchInputStruct(csub50si.getArchInputStruct());
                                pCSES14DInputRec.setUlIdPptEvent(pCAUD09DInputRec.getUlIdPptEvent());
                                rc = cses14dQUERYdam(sqlca, pCSES14DInputRec, pCSES14DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                        //  SQL Not Found Case for Dam CSES68D (CWA)
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        csub50so.setUlIdPptEvent(pCSES14DOutputRec.getUlIdPptEvent());
                                        csub50so.setTsLastUpdate(pCSES14DOutputRec.getTsLastUpdate());
                                        break;
                                        
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        //  Set RetVal to FND_FAIL
                                        RetVal = FND_FAIL;
                                        break;
                                }
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  Set RetVal to FND_FAIL
                                
                                RetVal = FND_FAIL;
                                break;
                        }
                    }
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = FND_FAIL;
                    break;
            }
        }
        
        /*
        ** SIR# 20541 - If the ldIdTodo is Not Null, then we are processing an
        ** Admin review and need to pass the Admin Review stage, not the INV stage
        */
        if ((SUCCESS == RetVal) && (FND_YES == csub50si.getCSysIndDtPptCompFlld())) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(csub50si.getArchInputStruct());
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(STATUS_NEW);
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub50si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(PPR);
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub50si.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub50si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub50si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub50si.getROWCCMN01UIG00().getSzCdEventType());
            
            
            //  Call CSES26D
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            switch (rc) {
                    
                    //  SQL Not Found Case for Dam CLSC59D
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Create task for Supervisor
                    //  Allocate memory for CSUB40U Input and Output Structures
                    pCSUB40UInputRec = new CSUB40UI();
                    
                    pCSUB40UOutputRec = new CSUB40UO();
                    pCSUB40UInputRec.setArchInputStruct(csub50si.getArchInputStruct());
                    pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE1);
                    pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub50si.getCSUB50SIG00().getDtDtPptDate());
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub50si.getUlSysIdTodoCfPersCrea());
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(csub50si.getUlIdStage());
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(pCCMN01UOutputRec.getUlIdEvent());
                    rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                    
                    switch (rc) {
                            
                            //  SQL Not Found Case for Dam CCMND9D
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            pCSUB40UInputRec.setArchInputStruct(csub50si.getArchInputStruct());
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE2);
                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub50si.getCSUB50SIG00().getDtDtPptDate());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub50si.getUlSysIdTodoCfPersCrea());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(csub50si.getUlIdStage());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(pCCMN01UOutputRec.getUlIdEvent());
                            rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                    //  Success Case for Dam CAUD75D
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = FND_FAIL;
                                    break;
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            //  Set RetVal to FND_FAIL
                            RetVal = FND_FAIL;
                            break;
                    }
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = FND_FAIL;
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub50si.getArchInputStruct() , csub50so.getArchOutputStruct());
        /**************************************************************************
        ** (END): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        /**************************************************************************
        ** (BEGIN): SIR # 2141
        **          If the disposition is ZZZ make sure that
        **          ID_CASE_MERGE_TO column exists and the
        **          IND_CASE_MERGE_INVALID must be 'Y' for
        **          the specific case located on the CASE_MERGE
        **************************************************************************/
        if (RetVal == SUCCESS) {
            
            
            //  Call CLSC18D
            rc = SUCCESS;
        }
        
        /*
        ** If the ID_CASE was retreived properly, retreve all rows
        ** from the the CASE_MERGE table where the ID_CASE exists in
        ** the ID_CASE_MERGE_TO column.
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            // 
            // (END):   SIR # 2141
            // If the disposition is ZZZ make sure that
            // ID_CASE_MERGE_TO column exists and the
            // IND_CASE_MERGE_INVALID must be 'Y' for
            // the specific case located on the CASE_MERGE
            // 
            
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
        
        /* vanderm SIR 11966
        ** ONLY FREE MEMORY ALLOCATED BEFORE SWITCH STATEMENT
        **
        ** free(pCCMN43DInputRec);
        ** free(pCCMN43DOutputRec);
        ** free(pCINT40DInputRec);
        ** free(pCINT40DOutputRec);
        ** free(pCINV51DInputRec);
        ** free(pCINV51DOutputRec);
        ** free(pCCMN60DInputRec);
        ** free(pCCMN60DOutputRec);
        ** free(pCSEC04DInputRec);
        ** free(pCSEC04DOutputRec);
        */
        
        return csub50so;
    }

}
