package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB28SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB28SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD10DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD10DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   csub28s.src
**
** Service Name:  CSUB28S
**
** Description:   This service will perform a validation to ensure that the
**                stage is not closed.  It will add, update, or delete n
**                rows of PPT participants in the PPT Participant table.
**                If the Send Alert indicator is on, it will send online 
**                notification alert to Staff participant.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/30/95/
** 
** Programmer:    Nancy Zimmerman 
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:16:20  $
**                      $Modtime:   28 Mar 1996 23:22:36  $
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






public class Csub28s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String TODO_INFO_27_CODE = "SUB027";
    public static final String START_LINE = "A PPT/ACR is scheduled on ";
    public static final String MIDDLE_LINE = " at ";
    public static final String LAST_LINE = ".";
    CSUB28SO CSUB28S(CSUB28SI csub28si) {
        CSUB28SO csub28so = new CSUB28SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        String date_string = new String();/* Variable used to populate TxtEventDescr */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CAUD10DI pCAUD10DInputRec = null;
        CAUD10DO pCAUD10DOutputRec = null;
        
        int RetVal = SUCCESS;
        
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;/* ToDo common function */
        
        CSUB40UO pCSUB40UOutputRec = null;
        
        int usPptPartRow = 0;
        int usInputRow = 0;
        int i426 = 0;
        
        FndInt3date CurrentDate = null;
        rc = ARC_PRFServiceStartTime_TUX(csub28si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub28si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(csub28si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(csub28si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csub28si.getSzCdTask());
        
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
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
                
                //SIR:17091 Srini: Added the error handling to take care of full table scans.
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
            //  Allocate memory for DAM Input and Output Structures
            pCAUD10DInputRec = new CAUD10DI();
            
            pCAUD10DOutputRec = new CAUD10DO();
            
            //  Set usPptPartRow to CSUB28SI WcdNbrListRowsQty
            usPptPartRow = csub28si.getSWCDNbrListRowsQty();
            
            
            for (i426 = 0;i426 < csub28si.getSWCDNbrListRowsQty() && (rc == WtcHelperConstants.SQL_SUCCESS);i426++) {
                pCAUD10DInputRec.setArchInputStruct(csub28si.getArchInputStruct());
                pCAUD10DInputRec.getArchInputStruct().setCReqFuncCd(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getSzCdScrDataAction());
                pCAUD10DInputRec.setUlIdEvent(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getUlIdPptEvent());
                pCAUD10DInputRec.setUlIdPerson(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getUlIdPerson());
                pCAUD10DInputRec.setSzCdPptPartType(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getSzCdPptPartType());
                pCAUD10DInputRec.setSzNmPptPartFull(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getSzNmPptPartFull());
                pCAUD10DInputRec.setSzSdsPptPartRelationship(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getSzSdsPptPartRelationship());
                pCAUD10DInputRec.setSzCdPptNotifType(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getSzCdPptNotifType());
                pCAUD10DInputRec.setDtDtPptPartDateNotif(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getDtDtPptPartDateNotif());
                pCAUD10DInputRec.setDtDtPptPart(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getDtDtPptPart());
                pCAUD10DInputRec.setTsLastUpdate(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getTsLastUpdate());
                pCAUD10DInputRec.setUlIdPptPart(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getUlIdPptPart());
                //  Call architecture function to retreive the current date.
                rc = caud10dAUDdam(sqlca, pCAUD10DInputRec, pCAUD10DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getCScrIndSendAlert() == FND_YES) {
                            //  Allocate memory for Todo Common Function input & output 
                            // structures
                            
                            //  Allocate memory for Common Function Input and Output
                            // Structures
                            pCSUB40UInputRec = new CSUB40UI();
                            
                            pCSUB40UOutputRec = new CSUB40UO();
                            pCSUB40UInputRec.setArchInputStruct(csub28si.getArchInputStruct());
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_27_CODE);
                            
                            rc = ARC_UTLGetDateAndTime(CurrentDate, 0);
                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(CurrentDate);
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(csub28si.getROWCSUB28SIG00_ARRAY().getROWCSUB28SIG00(i426).getUlIdPerson());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub28si.getUlSysIdTodoCfPersCrea());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(csub28si.getUlIdStage());
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(START_LINE);
                            date_string = csub28si.getDtDtPptDate().month + "/" + csub28si.getDtDtPptDate().day + "/" + csub28si.getDtDtPptDate().year;
                            pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += date_string + MIDDLE_LINE + csub28si.getTmScrTmPptTime() + LAST_LINE;
                            
                            //  Call CAUD08D The Contract County AUD performs a full row insert,
                            // update or delete to the Contract County table.
                            rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                            
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
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
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub28si.getArchInputStruct() , csub28so.getArchOutputStruct());
        
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
        return csub28so;
    }

}
