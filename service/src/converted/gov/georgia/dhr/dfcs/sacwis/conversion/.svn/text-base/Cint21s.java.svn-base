package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT58DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT77DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT77DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH3DO;
/**************************************************************************
** 
** Module File:   cint21s.src
**
** Service Name:  cint21s
**
** Description:   Save service for CINT15W Priority/Closure window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Function List
** -------------
** CINT21S         Save service.
** CallCINT41D     Calls update dam. CINT41D updates a row in the STAGE table.
** Populate41DI    Populates update dam input message.
** CallPostEvent   Calls PostEvent() function. PostEvent() updates the STAGE
**                 and EVENT tables.
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Mar 1997 16:46:16  $
**                      $Modtime:   14 Mar 1997 10:54:16  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/09/94  laskeyrm  File created.
**  04/15/95  laskeyrm  Code review modifications -- code beautification
**                      and malloc() return value checking added.
**  04/18/95  laskeyrm  Changed ARC_ERR_FATAL_RETURN to 
**                      ARC_ERR_INTERNAL_ERROR.
**  04/27/95  laskeyrm  Removed ID_PERSON and ID_CASE from 
**                      CloseCaseStage() input record.
**  06/19/95  laskeyrm  Commented Stage Progression/CloseCaseStage() out.
**                      It didn't work. See below for comments.
**  08/22/95  KRD       SIR 1209 - Added call to DAM CINT58D to check for the
**                      presence of an outstanding Law Enforcement
**                      Notification ToDo.
**  10/05/95  KRD       SIR 1642 - The event description for a closed stage
**                      should contain the decode of the Reason Closed:
**                      field rather than the code plus comments.
**  10/30/95  ELLIOTSL  ERR #1991: If there is a ToDo then the user navigated 
**                      from staff todo list (CCMN30W) or case todo list 
**                      (CCMN31W).  The todo needs to be marked as completed.  
**                      If there is no todo then no action will be taken.
**  01/19/96  GUARRICR  SIR#2426  Added CheckStageEventStatus common 
**                      function. Fixed up error handling, too.
**  02/26/96  KRD       SIR 5026 - Due to a request by PRS, when an Intake
**                      stage is closed via the Intake Priority/Closure
**                      window, the stage closure event should display the
**                      employee's name rather than 'System' as the person
**                      that closed the stage.
**  03/12/97  RIOSJA    SIR 12533 - CCMNH3D DAM will now be called before
**                      the call to CloseStageCase. Previously, CCMNH3D was
**                      being called after the call to CloseStageCase. This
**                      was causing a "no data found" error because CCMNH3D
**                      was trying to update the todo completion date after
**                      CloseStageCase had already deleted the todo.
**    
**  03/14/97  PAULS     SIR 12119 - Inialized variable ulNewEventId to zero
**                      because it was causing an Uninitialized Memory Read
**                      when Purifying CCMN00V.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/07/03  Srini     SIR#17337- IMPACT: Fixed the unmarshalling problem of 
**                      parent structure field getting overwritten by child 
**                      structure field by using the ulStackCounter variable.
**  02/18/04 dejuanr    SIR 18305 - Created a new dam cint77d to update the 
**                      INCOMING_DETAIL table and set the status of the intake
**                      to CLD.
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint21s {
    
    public static final int REQ_FUNC_CD_SAVE = 'S';
    public static final int REQ_FUNC_CD_PRIORITY_CHANGE = 'P';
    public static final int REQ_FUNC_CD_CLOSE = 'E';
    
    /*
    ** SIR 1209 - macro for the task value of the Law Enforcement Notification
    ** ToDo
    */
    public static final String TODO_LE_NOTIF_TASK = "1047";
    
    /*
    ** SIR 18305 
    */
    public static final String CLOSED_STATUS = "CLD";
    public static final String INTAKE_STAGE = "INT";
    public static final String IR_STAGE = "I&R";
    public static final String NULL_STRING = "";
    //## END TUX/XML: Declare XML variables 
    
    
    //## BEGIN TUX/XML: Turn the XML buffer into an input message struct 
    /* Allocate the Input message that will be used within the service */
    static CINT21SI pInputMsg = null;
    static CINT21SO pOutputMsg = null;
    CINT21SO CINT21S(CINT21SI cint21si) {
        CINT21SO cint21so = new CINT21SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        Pint ulNewEventId = new Pint();/*Sir12119 - Initialized the variable
        because it was causing Unitialized
        Memory Read */
        ulNewEventId.value = 0;
        
        
        
        int ServiceFunction = 0;
        
        CCMN02UI pCloseInput = null;
        CCMN02UO pCloseOutput = null;
        int RetVal = SUCCESS;/* SIR#2426 */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function   */
        
        CCMN06UO pCCMN06UOutputRec = null;
        if (cint21si.getStageRow().getUlIdStage() != 0) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cint21si.getArchInputStruct());
            
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(cint21si.getStageRow().getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(NULL_STRING);
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            
            //  Analyze return code
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
            //  Save this function code.
            ServiceFunction = cint21si.getArchInputStruct().getCReqFuncCd();
            
            if ((REQ_FUNC_CD_CLOSE == ServiceFunction) || (REQ_FUNC_CD_SAVE == ServiceFunction)) {
                rc = Ccmn88s.CallCINT58D(cint21si, cint21so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_INT_LE_NOTIF_REQUIRED:
                        //  Stop performance timer for service
                        ARC_PRFServiceStopTime_TUX(cint21si.getArchInputStruct() , cint21so.getArchOutputStruct());
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                }
            }
            
            cint21si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            
            //  Call CMSC09D
            rc = Ccmn03u.CallCINT41D(cint21si, cint21so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_WARNING;
                    pServiceStatus.explan_code = rc;
                    
                    //  SIR 2426
                    // Exit service if stage timestamp mismatch occurs
                    ARC_PRFServiceStopTime_TUX(cint21si.getArchInputStruct() , cint21so.getArchOutputStruct());
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
            
            if ((ServiceFunction == REQ_FUNC_CD_SAVE) || (ServiceFunction == REQ_FUNC_CD_PRIORITY_CHANGE)) {
                
                //SIR 14339 add new input to use same DAM for both the primary
                //and secondary workers
                cint21si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                rc = Ccmn25s.CallPostEvent(cint21si.getArchInputStruct() , cint21si.getROWCCMN01UIG00() , ulNewEventId, pServiceStatus);
                switch (rc) {
                    case SUCCESS:
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_WARNING;
                        pServiceStatus.explan_code = rc;
                        
                        //  SIR 2426
                        // Exit service if stage timestamp mismatch occurs
                        ARC_PRFServiceStopTime_TUX(cint21si.getArchInputStruct() , cint21so.getArchOutputStruct());
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        break;
                }
            }
            if (cint21si.getLdIdTodo() != 0) {
                rc = Ccmn86s.CallCMNH3D(cint21si, cint21so, pServiceStatus);
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if ((ServiceFunction == REQ_FUNC_CD_SAVE) || (ServiceFunction == REQ_FUNC_CD_CLOSE)) {
                cint21si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                pCloseInput = new CCMN02UI();
                pCloseOutput = new CCMN02UO();
                
                //  Analyze error code
                if (pCloseInput == (CCMN02UI) 0 || pCloseOutput == (CCMN02UO) 0) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                
                pCloseInput.getCCMN02UIG00().setUlIdStage(cint21si.getROWCCMN01UIG00().getUlIdStage());
                pCloseInput.getCCMN02UIG00().setSzCdStageProgram(cint21si.getStageRow().getSzCdStageProgram());
                pCloseInput.getCCMN02UIG00().setSzCdStage(cint21si.getStageRow().getSzCdStage());
                //  SIR 15512
                
                pCloseInput.getCCMN02UIG00().setSzCdStageReasonClosed(cint21si.getStageRow().getSzCdStageReasonClosed());
                pCloseInput.getCCMN02UIG00().setSzTxtEventDescr(cint21si.getSzTxtEventDescr());
                pCloseInput.setArchInputStruct(cint21si.getArchInputStruct());
                
                pCloseInput.getCCMN02UIG00().setUlIdPerson(cint21si.getUlIdPerson());
                
                //  Call CCMNB8D
                rc = Ccmn02u.CloseStageCase(pCloseInput, pCloseOutput, pServiceStatus);
                switch (rc) {
                    case SUCCESS:
                        cint21so.setArchOutputStruct(pCloseOutput.getArchOutputStruct());
                        cint21so.setUlIdEvent(pCloseOutput.getUlIdEvent());
                        
                        if ((MATCH == INTAKE_STAGE.compareTo(cint21si.getStageRow().getSzCdStage())) || (MATCH == IR_STAGE.compareTo(cint21si.getStageRow().getSzCdStage()))) {
                            rc = CallCINT77D(cint21si, cint21so, pServiceStatus);
                            
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_WARNING;
                        pServiceStatus.explan_code = rc;
                        
                        
                        
                        
                        //  SIR 1096 - Removed reference to CallCCMNF4D.
                        
                        cint21so.setUlIdEvent(0);
                        break;
                    case Messages.MSG_CMN_STAGE_CLOSED:
                        pServiceStatus.severity = FND_WARNING;
                        pServiceStatus.explan_code = rc;
                        cint21so.setUlIdEvent(0);
                        
                        break;
                        
                    default :
                        cint21so.setUlIdEvent(0);
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
            }
            
        }
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
                
                
                //  Call CloseOpenStage
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint21so;
        
    }

    static int CallCINT41D(CINT21SI pInputMsg462, CINT21SO pOutputMsg422, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINT41DI pAudDamInput = null;
        CINT41DO pAudDamOutput = null;
        
        /* Allocate memory for Input and Output Structures. */
        pAudDamInput = new CINT41DI();
        pAudDamOutput = new CINT41DO();
        
        if (pAudDamInput == (CINT41DI) 0 || pAudDamOutput == (CINT41DO) 0) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        
        /* Populate Input Structure for DAM. */
        Populate41DI(pAudDamInput, pInputMsg462);
        rc = cint41dAUDdam(sqlca, pAudDamInput, pAudDamOutput);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case SUCCESS:
                pOutputMsg422.setArchOutputStruct(pAudDamOutput.getArchOutputStruct());
                break;
                
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int Populate41DI(CINT41DI pDst, CINT21SI pSrc) {
        pDst.setUlIdStage(pSrc.getStageRow().getUlIdStage());
        pDst.setUlIdSituation(pSrc.getStageRow().getUlIdSituation());
        pDst.setUlIdCase(pSrc.getStageRow().getUlIdCase());
        pDst.setBIndStageClose(pSrc.getStageRow().getBIndStageClose());
        pDst.setUlIdUnit(pSrc.getStageRow().getUlIdUnit());
        pDst.setDtDtStageClose(pSrc.getStageRow().getDtDtStageClose());
        pDst.setDtDtStageStart(pSrc.getStageRow().getDtDtStageStart());
        pDst.setSzCdStage(pSrc.getStageRow().getSzCdStage());
        pDst.setSzCdStageClassification(pSrc.getStageRow().getSzCdStageClassification());
        pDst.setSzCdStageCnty(pSrc.getStageRow().getSzCdStageCnty());
        pDst.setSzCdStageProgram(pSrc.getStageRow().getSzCdStageProgram());
        pDst.setSzCdStageReasonClosed(pSrc.getStageRow().getSzCdStageReasonClosed());
        pDst.setSzCdStageRegion(pSrc.getStageRow().getSzCdStageRegion());
        pDst.setSzCdStageRsnPriorityChgd(pSrc.getStageRow().getSzCdStageRsnPriorityChgd());
        pDst.setSzCdStageType(pSrc.getStageRow().getSzCdStageType());
        pDst.setSzCdStageCurrPriority(pSrc.getStageRow().getSzCdStageCurrPriority());
        pDst.setSzCdStageInitialPriority(pSrc.getStageRow().getSzCdStageInitialPriority());
        pDst.setSzTxtStagePriorityCmnts(pSrc.getStageRow().getSzTxtStagePriorityCmnts());
        pDst.setSzTxtStageClosureCmnts(pSrc.getStageRow().getSzTxtStageClosureCmnts());
        pDst.setSzNmStage(pSrc.getStageRow().getSzNmStage());
        pDst.setTsLastUpdate(pSrc.getStageRow().getTsLastUpdate());
        pDst.setTmSysTmStageClose(pSrc.getStageRow().getTmSysTmStageClose());
        pDst.setTmSysTmStageStart(pSrc.getStageRow().getTmSysTmStageStart());
        pDst.setArchInputStruct(pSrc.getArchInputStruct());
        return 0;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct1, ROWCCMN01UIG00 ROWCCMN01UIG001, Pint ulIdEvent11, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        CCMN01UI pInputMsg463 = null;
        CCMN01UO pOutputMsg423 = null;
        pInputMsg463 = new CCMN01UI();
        pOutputMsg423 = new CCMN01UO();
        
        if (pInputMsg463 == (CCMN01UI) 0 || pOutputMsg423 == (CCMN01UO) 0) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        if ((ArchInputStruct1 == null) || (ROWCCMN01UIG001 == null) || (ulIdEvent11 == null)) {
            
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        pInputMsg463.setArchInputStruct(ArchInputStruct1);
        pInputMsg463.setROWCCMN01UIG00(ROWCCMN01UIG001);
        pOutputMsg423.setUlIdEvent(ulIdEvent11.value);
        rc = Ccmn01u.PostEvent(pInputMsg463, pOutputMsg423, pServiceStatus);
        
        if (ulIdEvent11.value == null) {
            ulIdEvent11.value = pOutputMsg423.getUlIdEvent();
        }
        
        
        return rc;
    }

    static int CallCINT58D(CINT21SI pInputMsg464, CINT21SO * pOutputMsg424, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CINT58DI pCINT58DInputRec = null;
        CINT58DO pCINT58DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT58DInputRec = new CINT58DI();
        
        pCINT58DOutputRec = new CINT58DO();
        pCINT58DInputRec.setArchInputStruct(pInputMsg464.getArchInputStruct());
        pCINT58DInputRec.setUlIdStage(pInputMsg464.getStageRow().getUlIdStage());
        pCINT58DInputRec.setSzCdTodoTask(TODO_LE_NOTIF_TASK);
        
        
        /*
        ** Call CAUD75D
        */
        rc = cint58dQUERYdam(sqlca, pCINT58DInputRec, pCINT58DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (DateHelper.NULL_DATE == pCINT58DOutputRec.getDtDtTodoCompleted().year) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_INT_LE_NOTIF_REQUIRED;
                    
                    //  Set rc to ARC_SUCCESS
                    rc = Messages.MSG_INT_LE_NOTIF_REQUIRED;
                }
                
                else {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT77D(CINT21SI pInputMsg465, CINT21SO * pOutputMsg425, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT77DI pCINT77DInputRec = null;
        CINT77DO pCINT77DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT77DInputRec = new CINT77DI();
        
        pCINT77DOutputRec = new CINT77DO();
        pCINT77DInputRec.setArchInputStruct(pInputMsg465.getArchInputStruct());
        pCINT77DInputRec.setUlIdStage(pInputMsg465.getStageRow().getUlIdStage());
        pCINT77DInputRec.setTsLastUpdate(pInputMsg465.getStageRow().getTsIncmgDtlLastUpdate());
        pCINT77DInputRec.setCdIncmgStatus(CLOSED_STATUS);
        
        /*
        ** for each IdSvcAuth returned from the DAM search
        ** the SVC_AUTH_DETAIL table to retrieve the
        ** SvcAuthDtlTermDate
        */
        
        rc = cint77dAUDdam(sqlca, pCINT77DInputRec, pCINT77DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
            case NO_DATA_FOUND:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCMNH3D(CINT21SI pInputMsg466, CINT21SO * pOutputMsg426, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMNH3DI pCCMNH3DI = null;
        CCMNH3DO pCCMNH3DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCCMNH3DI = new CCMNH3DI();
        pCCMNH3DO = new CCMNH3DO();
        if (pCCMNH3DI == (CCMNH3DI) 0 || pCCMNH3DO == (CCMNH3DO) 0) {
            
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        pCCMNH3DI.setLdIdTodo(pInputMsg466.getLdIdTodo());
        
        /* get the Educations from educational_history table for person_closed */
        rc = ccmnh3dAUDdam(sqlca, pCCMNH3DI, pCCMNH3DO);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        /*
        ** SIR 22052, 12/11/96 - This function code will be used in the DAM to
        **      indentify APS Facility cases that have allegations of NEGLECT.
        **
        **      ALLEGATION TYPE         FUNCTION CODE
        **      ---------------         -------------
        **      NEGLECT                 REQ_FUNC_CD_ADD
        **      not NEGLECT             REQ_FUNC_CD_UPDATE
        */
        /*
        ** Return the total number of rows found matching the input row's
        ** "who did what to whom" triad (including the input row)
        ** ERR#1797 If the only duplicate we found is the same row we
        ** passed in, return zero duplicates, else return the number found.
        */
        
        return rc;
        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        
        
    }

}
