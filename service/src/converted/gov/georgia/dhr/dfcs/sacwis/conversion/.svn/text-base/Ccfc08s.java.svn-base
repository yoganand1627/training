package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB7DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC08S.src
**
** Service Name:  CCFC08S - PAL FOLLOWUP SAVE
**
** Description:   This service will update all columns for an Id Stage from 
**                the PAL FOLLOWUP table.  Additionally, it will add/delete 
**                rows from the PAL PUBLIC ASSIST table given an Id Stage 
**                and a Cd PAL Public Assist code. It will also update all 
**                the columns for an Id Event from the EVENT row. It can add 
**                or modify the EVENT row.  It will also retrieve the primary
**                child for the PAl stage in order to link the event with 
**                the primary child when adding/updating the followup event.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/12/95
** 
** Programmer:    James J. O'Mara 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:35:38  $
**                      $Modtime:   29 Mar 1996 23:54:32  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   02/29/96  JRH      SIR 3447 - Added CCMN06U to handle the error for
**                      an attempt to save an event for a closed stage.
**   03/11/96  JJO      SIR 3699 - Added CAUDB7D to Update TODO for PAL
**                      Followup.
**   3/11/96   JJO      SIR 3813 -- Added a break statement after the DAM call
**                      to CAUD57D.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/


/**************************************************************************
** Service Include Files
***************************************************************************/

/* Symbolic Constants */
public class Ccfc08s {
    public static final String PRIMARY_CHILD = "PC";
    public static final String STATUS_COMPLETE = "COMP";
    public static final String FOLLOW_UP = "FUP";
    public static final String PAL_FOLLOWUP_COMPLETED = "PAL Follow-up Completed";
    CCFC08SO CCFC08S(CCFC08SI ccfc08si) {
        CCFC08SO ccfc08so = new CCFC08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int usRow = 0;/* loop variable */
        int ulIdPerson3 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        int RetVal = SUCCESS;
        CAUD56DI pCAUD56DInputRec = null;/* pointer to DAM input record  */
        CAUD56DO pCAUD56DOutputRec = null;/* pointer to DAM output record */
        CAUD57DI pCAUD57DInputRec = null;/* pointer to DAM input record  */
        CAUD57DO pCAUD57DOutputRec = null;/* pointer to DAM output record */
        
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* Post Event Function */
        
        CCMN01UO pCCMN01UOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;/*SIR#1710*/
        CCMN06UO pCCMN06UOutputRec = null;/*SIR#1710*/
        CAUDB7DI pCAUDB7DInputRec = null;/* Sir 3699 TODO Update */
        CAUDB7DO pCAUDB7DOutputRec = null;/* Sir 3699 TODO Update */
        rc = ARC_PRFServiceStartTime_TUX(ccfc08si.getArchInputStruct());
        rc = ARC_PRFServiceStartTime_TUX(ccfc08si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** BEGIN SIR 3447 --Common Function: ccmn06u  
        ** Check Stage/Event common function
        **************************************************************************/
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(ccfc08si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(ccfc08si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(ccfc08si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(ccfc08si.getROWCCMN01UIG00().getSzCdTask());
        
        
        /*
        ** Call CCMN02U
        */
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
        
        if (SUCCESS == RetVal) {
            
            if (WINDOW_MODE_NEW == ccfc08si.getSzSysCdWinMode()) {
                //  Allocate memory for DAM Input and Output Structures
                pCINV51DInputRec = new CINV51DI();
                
                pCINV51DOutputRec = new CINV51DO();
                pCINV51DInputRec.getArchInputStruct().setCReqFuncCd(ccfc08si.getArchInputStruct().getCReqFuncCd());
                pCINV51DInputRec.setUlIdStage(ccfc08si.getROWCCMN01UIG00().getUlIdStage());
                pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                
                //  Set rc to SQL_SUCCESS
                rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ulIdPerson3 = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            if (WtcHelperConstants.SQL_SUCCESS == rc) {
                // CCMN01U -- POST EVENT
                
                // 
                // (BEGIN): Common Function: CCMN01U   Post Event common function
                // 
                
                //  Allocate memory for Common Function Input and Output Structures
                pCCMN01UInputRec = new CCMN01UI();
                
                pCCMN01UOutputRec = new CCMN01UO();
                pCCMN01UInputRec.setArchInputStruct(ccfc08si.getArchInputStruct());
                
                if (0 == ccfc08si.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                
                else {
                    
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                }
                
                // 
                // Service Macro Definitions
                // 
                
                
                // 
                // Function Prototypes
                // 
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccfc08si.getROWCCMN01UIG00().getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(STATUS_COMPLETE);
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(FOLLOW_UP);
                rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(ccfc08si.getROWCCMN01UIG00().getUlIdEvent());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccfc08si.getROWCCMN01UIG00().getUlIdStage());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(ccfc08si.getROWCCMN01UIG00().getSzCdTask());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(PAL_FOLLOWUP_COMPLETED);
                if (0 != ccfc08si.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(ccfc08si.getTsSysTsLastUpdate2());
                }
                if (WINDOW_MODE_NEW == ccfc08si.getSzSysCdWinMode()) {
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(ulIdPerson3);
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                
                
                
                
                //  Start Performance Timer
                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                
                // 
                // Function Prototypes
                // 
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                // SIR 19613
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // 
                        // (BEGIN): CAUD56D -- PAL FOLLOWUP AUD              
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD56DInputRec = new CAUD56DI();
                        
                        pCAUD56DOutputRec = new CAUD56DO();
                        pCAUD56DInputRec.setArchInputStruct(ccfc08si.getArchInputStruct());
                        pCAUD56DInputRec.getArchInputStruct().setCReqFuncCd(ccfc08si.getArchInputStruct().getCReqFuncCd());
                        pCAUD56DInputRec.setUlIdStage(ccfc08si.getROWCCMN01UIG00().getUlIdStage());
                        
                        pCAUD56DInputRec.setSzCdPalFollupEducStat(ccfc08si.getSzCdPalFollupEducStat());
                        pCAUD56DInputRec.setSzCdPalFollupEmployed(ccfc08si.getSzCdPalFollupEmployed());
                        pCAUD56DInputRec.setSzCdPalFollupLivArr(ccfc08si.getSzCdPalFollupLivArr());
                        
                        pCAUD56DInputRec.setSzCdPalFollupMarital(ccfc08si.getSzCdPalFollupMarital());
                        pCAUD56DInputRec.setSzCdPalFollupHighestEdu(ccfc08si.getSzCdPalFollupHighestEdu());
                        pCAUD56DInputRec.setUCdPalFollupReunified(ccfc08si.getUCdPalFollupReunified());
                        
                        pCAUD56DInputRec.setDtDtPalFollupDate(ccfc08si.getDtDtPalFollupDate());
                        pCAUD56DInputRec.setCIndPalFollupNoPubAst(ccfc08si.getCIndPalFollupNoPubAst());
                        pCAUD56DInputRec.setCIndPalFollupNotLocate(ccfc08si.getCIndPalFollupNotLocate());
                        
                        pCAUD56DInputRec.setLNbrPalFollupNumChldrn(ccfc08si.getLNbrPalFollupNumChldrn());
                        rc = caud56dAUDdam(sqlca, pCAUD56DInputRec, pCAUD56DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                //  need to give user an error message stating that
                                // someone else had modified their record since they
                                // had retrieved it; they need to try again.
                                // To do this: set the explan_code equal to the MSG that
                                // should be sent.
                                // SIR 997:
                                // If the requested function (cReqFuncCd) was REQ_FUNC_CD_ADD,
                                // and we get back SQL_NOT_FOUND from the dam, it means that
                                // the insert resulted in a SQL_DUPLICATE_KEY and then the
                                // retrieve of the DT_LAST_UPDATE for that newly added record
                                // was SQL_NOT_FOUND (because the insert was not successful).
                                // In this case, we want to give the user the MSG_CMN_DUP_SP_LINK
                                // message (not the MSG_CMN_TMSTAMP_MISMATCH message).
                                
                                // SIR 997: added an if statement
                                if (Cint14s.INDICATOR_NO == ccfc08si.getCIndPalFollupNoPubAst()) {
                                    
                                    // 
                                    // (BEGIN): CAUD57D -- PAL PUBLIC ASSIST AUD
                                    // 
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCAUD57DInputRec = new CAUD57DI();
                                    
                                    pCAUD57DOutputRec = new CAUD57DO();
                                    rc = WtcHelperConstants.SQL_SUCCESS;
                                    pCAUD57DInputRec.getArchInputStruct().setCReqFuncCd(ccfc08si.getArchInputStruct().getCReqFuncCd());
                                    pCAUD57DInputRec.setUlIdStage(ccfc08si.getROWCCMN01UIG00().getUlIdStage());
                                    
                                    //  While more rows are left to process and rc is zero,
                                    // continue loop.
                                    while (usRow < ccfc08si.getArchInputStruct().getUlPageSizeNbr()) {
                                        
                                        pCAUD57DInputRec.setArchInputStruct(ccfc08si.getArchInputStruct());
                                        pCAUD57DInputRec.setSzCdPalPublicAssist(ccfc08si.getROWCCFC08SIG00_ARRAY().getROWCCFC08SIG00(usRow).getSzCdPalPublicAssist());
                                        
                                        
                                        //  Call CLSS18D
                                        rc = caud57dAUDdam(sqlca, pCAUD57DInputRec, pCAUD57DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                break;
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                                                break;
                                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                break;
                                        }
                                        usRow++;
                                    }
                                    break;
                                }
                                break;
                                
                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        break;
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        break;
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            // 
            // (END): Common Function: ccmn01u  
            // Post Event common function
            // 
            
            //  SIR#3513 - Added the TODO AUD Dam, CAUDB7D, to the
            // save service so that whenever the data for PAL
            // Followup is saved, the associated TODOs, if any, will
            // be taken off the Staff TODO List.  This is necessary
            // because in the PAL Dialog when a TODO is completed for 
            // the ILS or RUT windows the event status remains PROC
            // until the stage is completed through the PAL Summary
            // window.  Thus, simply completing a TODO would not have
            // removed it from the TODO List.  The CAUDB7D dam updates
            // the date TODO completed and removes the TODO from the
            // TODO list whenever the window data is saved.
            //  Allocate memory for DAM Input and Output Structures
            pCAUDB7DInputRec = new CAUDB7DI();
            
            pCAUDB7DOutputRec = new CAUDB7DO();
            pCAUDB7DInputRec.setArchInputStruct(ccfc08si.getArchInputStruct());
            pCAUDB7DInputRec.getArchInputStruct().setCReqFuncCd(ccfc08si.getArchInputStruct().getCReqFuncCd());
            pCAUDB7DInputRec.setUlIdStage(ccfc08si.getROWCCMN01UIG00().getUlIdStage());
            pCAUDB7DInputRec.setSzCdTodoTask(ccfc08si.getROWCCMN01UIG00().getSzCdTask());
            rc = caudb7dAUDdam(sqlca, pCAUDB7DInputRec, pCAUDB7DOutputRec);
            
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
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc08si.getArchInputStruct() , ccfc08so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        /* select one record and compare it with all the existing names in
        ** person forward. insert if no match found
        ** AND
        **  we only want to transfer DPS_CODE to person_froward
        ** CdRecCheckType of "10" (DPS Criminal History)
        ** SIR#23436: added 3 more check types "15","20","25"
        ** and also took out the comparison for-loop because it's been asked to transfer the
        ** records regerdless of being duplicate
        */
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
                
                
                //  Call CLSS14D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccfc08so;
    }

}
