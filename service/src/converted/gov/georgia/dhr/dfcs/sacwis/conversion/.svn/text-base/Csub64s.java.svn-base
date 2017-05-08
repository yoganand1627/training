package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB64SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB64SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD42DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CSUB64s.src
**
** Service Name:  CHG STG TYPE AUD
**
** Description:   This service will add or update the Event Table using the 
**                  post event function, add or update the Stage table, 
**                  and (if necessary), call the invalidate event function.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:   10/6/95  
** 
** Programmer:      Brian Walker
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:20:08  $
**                      $Modtime:   28 Mar 1996 23:25:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
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






public class Csub64s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String STAGE_EVENT_TYPE = "STG";
    public static final String STATUS_COMPLETE = "COMP";
    CSUB64SO CSUB64S(CSUB64SI csub64si) {
        CSUB64SO csub64so = new CSUB64SO();
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
        int RetVal = 0;
        
        CAUD42DI pCAUD42DInputRec = null;
        CAUD42DO pCAUD42DOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* SIR#2006 PostEvent */
        
        
        CCMN01UO pCCMN01UOutputRec = null;
        CINV43DI pCINV43DInputRec = null;/* ToDo Complete AUD dam: update only  */
        
        CINV43DO pCINV43DOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub64si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub64si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(csub64si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setSzCdTask(csub64si.getCSUB64SIG01().getSzCdTask());
        pCCMN06UInputRec.setUlIdStage(csub64si.getCSUB64SIG01().getUlIdStage());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, sqlca);
        
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
        
        if (RetVal == SUCCESS) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub64si.getCSUB64SIG01().getUlIdEvent());
            
            if (0 != pCCMN01UInputRec.getROWCCMN01UIG00().getUlIdEvent()) {
                pCCMN01UInputRec.setArchInputStruct(csub64si.getArchInputStruct());
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            
            
            else {
                pCCMN01UInputRec.setArchInputStruct(csub64si.getArchInputStruct());
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub64si.getCSUB64SIG01().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub64si.getCSUB64SIG01().getTsLastUpdate());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub64si.getCSUB64SIG01().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub64si.getCSUB64SIG01().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub64si.getCSUB64SIG01().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub64si.getCSUB64SIG01().getSzTxtEventDescr());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(STATUS_COMPLETE);
            rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub64si.getCSUB64SIG01().getSzCdEventType());
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD42DInputRec = new CAUD42DI();
                    
                    pCAUD42DOutputRec = new CAUD42DO();
                    pCAUD42DInputRec.setArchInputStruct(csub64si.getArchInputStruct());
                    pCAUD42DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCAUD42DInputRec.setUlIdStage(csub64si.getCSUB64SIG00().getUlIdStage());
                    pCAUD42DInputRec.setSzCdStageType(csub64si.getCSUB64SIG00().getSzCdStageType());
                    pCAUD42DInputRec.setTsLastUpdate(csub64si.getCSUB64SIG00().getTsLastUpdate());
                    rc = caud42dAUDdam(sqlca, pCAUD42DInputRec, pCAUD42DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                    
            }
        }
        
        if (RetVal == SUCCESS) {
            //  Allocate memory for DAM Input and Output Structures
            pCINV43DInputRec = new CINV43DI();
            
            pCINV43DOutputRec = new CINV43DO();
            pCINV43DInputRec.setUlIdEvent(csub64si.getCSUB64SIG01().getUlIdEvent());
            rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                    
                case NO_DATA_FOUND:
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
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub64si.getArchInputStruct() , csub64so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        if (RetVal == SUCCESS) /*
        ** IMPACT END
        */
        {
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) /*
        ** IMPACT END
        */
        {
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
        return csub64so;
    }

}
