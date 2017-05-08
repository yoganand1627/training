package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD64DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   ccfc04s.src
**
** Service Name:  CCFC04S
**
** Description:   This service will update the Closure Reason and Stage 
**                Closure Date on the STAGE table.  It will also update the 
**                Closure Living Arrangement on the PAL table.  It will also 
**                create a PAL closure event by doing a full row add to the 
**                EVENT table and creating a link to the prmiary child.  
**                It will also write out an Alert for the primary PAL worker 
**                indicating that the PAL stage has been closed.  
**                Additionally,it will set the status for all of the PAL 
**                events to "COMP".
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/07/95
** 
** Programmer:    Timothy R. Overend 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:34:52  $
**                      $Modtime:   29 Mar 1996 23:53:42  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc04s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PRIMARY_CHILD_ROLE = "PC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_TYPE_PCL = "PCL";
    public static final String PAL_STAGE_TYPE = "PAL";
    public static final String PAL_STAGE_TODO = "CFC001";
    public static final String TODO_DESCRIP = "The PAL Stage has been closed for ";
    public static final String EVENT_TYPE_ILS = "ILS";
    public static final String EVENT_TYPE_RUT = "RUT";
    CCFC04SO CCFC04S(CCFC04SI ccfc04si) {
        CCFC04SO ccfc04so = new CCFC04SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        int ulIdPersonChild = 0;
        int ulIdPersonWorker = 0;
        String NmPersonFull = new String();
        
        CMSC15DI pCMSC15DInputRec = null;
        CMSC15DO pCMSC15DOutputRec = null;
        
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;
        CSUB40UO pCSUB40UOutputRec = null;
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        CSEC66DI pCSEC66DInputRec = null;
        CSEC66DO pCSEC66DOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        CAUD64DI pCAUD64DInputRec = null;
        CAUD64DO pCAUD64DOutputRec = null;
        
        
        /*
        ** Call CINT21D
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc04si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields 
        */
        
        /*
        **  Perform Main Processing
        */
        
        
        /**************************************************************************
        ** Call the Retrieve Primary Employee Dam - CINV51D
        **
        ** Description - This dam will retrieve the ID PERSON for a given role for
        **               a given stage.  It's used to find the primary worker for
        **               a stage.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINV51DInputRec = new CINV51DI();
        
        pCINV51DOutputRec = new CINV51DO();
        pCINV51DInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
        pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD_ROLE);
        pCINV51DInputRec.setUlIdStage(ccfc04si.getUlIdStage());
        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.SQL_SUCCESS;
                
                ulIdPersonChild = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            // 
            // Call the Post Event Common Function - CCMN01U
            // Description - This dam will create a new event.
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
            if (0 != ccfc04si.getUlIdEvent()) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(ccfc04si.getROWCCMN01UIG00().getTsLastUpdate());
            }
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(ulIdPersonChild);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(ccfc04si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_PCL);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(ccfc04si.getROWCCMN01UIG00().getSzTxtEventDescr());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccfc04si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccfc04si.getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(ccfc04si.getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(ccfc04si.getDtDtStageClose());
            
            //  Call DAM
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    rc = WtcHelperConstants.SQL_SUCCESS;
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case Messages.MSG_CMN_UPDATE_FAILED:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            // 
            // Call the PAL Closure Liv Arr Dam - CMSC15D
            // Description - This dam updates the PAL table's living arrangment based 
            // upon id stage.
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCMSC15DInputRec = new CMSC15DI();
            
            pCMSC15DOutputRec = new CMSC15DO();
            pCMSC15DInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
            pCMSC15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCMSC15DInputRec.setSzCdPalCloseLivArr(ccfc04si.getSzCdPalCloseLivArr());
            pCMSC15DInputRec.setUlIdStage(ccfc04si.getUlIdStage());
            rc = cmsc15dAUDdam(sqlca, pCMSC15DInputRec, pCMSC15DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.SQL_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            
            // 
            // Call the EVENT STATUS AUD Dam - CAUD64D
            // Description - This DAM will update the CD EVENT STATUS for a row in the
            // EVENT table given CD EVENT TYPE and the ID STAGE.  This
            // DAM will change all events for the stage with the CD EVENT
            // TYPE specified.  It will change the CD EVENT STATUS to the
            // status specified in the input. 
            // (re-open PAL Training/Serivces event)
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUD64DInputRec = new CAUD64DI();
            
            pCAUD64DOutputRec = new CAUD64DO();
            pCAUD64DInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
            pCAUD64DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCAUD64DInputRec.setSzCdEventType(EVENT_TYPE_RUT);
            pCAUD64DInputRec.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
            pCAUD64DInputRec.setUlIdStage(ccfc04si.getUlIdStage());
            rc = caud64dAUDdam(sqlca, pCAUD64DInputRec, pCAUD64DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.SQL_SUCCESS;
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    pCAUD64DInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
                    pCAUD64DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCAUD64DInputRec.setSzCdEventType(EVENT_TYPE_ILS);
                    pCAUD64DInputRec.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
                    pCAUD64DInputRec.setUlIdStage(ccfc04si.getUlIdStage());
                    
                    //  Call DAM
                    
                    rc = caud64dAUDdam(sqlca, pCAUD64DInputRec, pCAUD64DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            rc = WtcHelperConstants.SQL_SUCCESS;
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            // 
            // Call the Lead Coordinator Simple Dam - CSEC66D
            // Description - This DAM will return the ID_PERSON of the lead PAL_COORDINATOR
            // for the region of conservatorship for the PAL child.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC66DInputRec = new CSEC66DI();
            
            pCSEC66DOutputRec = new CSEC66DO();
            pCSEC66DInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
            
            //  PROCESS macro will free resources
            
            pCSEC66DInputRec.setUlIdStage(ccfc04si.getUlIdStage());
            
            rc = csec66dQUERYdam(sqlca, pCSEC66DInputRec, pCSEC66DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    ulIdPersonWorker = pCSEC66DOutputRec.getUlIdPerson();
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            
            // 
            // Call the Stage Person Link Dam - CCMN44D
            // Description - This DAM will return a single row from the 
            // person table based upon the ID_PERSON passed
            // in.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN44DInputRec = new CCMN44DI();
            
            pCCMN44DOutputRec = new CCMN44DO();
            pCCMN44DInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
            pCCMN44DInputRec.setUlIdPerson(ulIdPersonChild);
            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    NmPersonFull = pCCMN44DOutputRec.getSzNmPersonFull();
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            // 
            // Call the ToDo Common Function - CSUB40U
            // Description - This service performs the business logic neccessary
            // to execute the TODO COMMON FUNCTION. This service
            // will help standardize/formalize how Todo's are created.
            // It will prevent hard-coding, of Todo descriptions, due
            // dates, and other data within the functional program.
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCSUB40UInputRec = new CSUB40UI();
            
            pCSUB40UOutputRec = new CSUB40UO();
            pCSUB40UInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
            pCSUB40UInputRec.getArchInputStruct().setCReqFuncCd(ccfc04si.getArchInputStruct().getCReqFuncCd());
            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(PAL_STAGE_TODO);
            pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_DESCRIP);
            strncat(pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() , NmPersonFull, Ccmn85s.NM_PERSON_FULL_LEN);
            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(ccfc04si.getDtDtStageClose());
            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdPersonWorker);
            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccfc04si.getROWCCMN01UIG00().getUlIdPerson());
            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccfc04si.getROWCCMN01UIG00().getUlIdEvent());
            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ccfc04si.getUlIdStage());
            rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Call DAM
                    rc = WtcHelperConstants.SQL_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            
        }
        
        if (WtcHelperConstants.SQL_SUCCESS == rc) {
            // 
            // Call the Close Stage Case Common Function - CCMN02U
            // Description - This shared library function provides the necessary
            // updates required to close a stage. If a case and a
            // situation are associated with the stage, and there are
            // no other open stages associated with the case, the
            // situation and the case are also closed.
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCCMN02UInputRec = new CCMN02UI();
            
            pCCMN02UOutputRec = new CCMN02UO();
            pCCMN02UInputRec.setArchInputStruct(ccfc04si.getArchInputStruct());
            pCCMN02UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            
            pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(ccfc04si.getSzCdStageReasonClosed());
            pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(PAL_STAGE_TYPE);
            pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(ccfc04si.getSzCdStageProgram());
            pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(ccfc04si.getUlIdStage());
            //  Populate output message
            
            rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    rc = WtcHelperConstants.SQL_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
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
        ARC_PRFServiceStopTime_TUX(ccfc04si.getArchInputStruct() , ccfc04so.getArchOutputStruct());
        
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
        return ccfc04so;
    }

}
