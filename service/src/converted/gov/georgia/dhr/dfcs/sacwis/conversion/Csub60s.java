package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB60SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB60SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
/**************************************************************************
**
** Module File:   CSUB60S.src
**
** Service Name:  CSUB60S - OUTPUT LAUNCH SAVE
**
** Description:   This service will add or update the EVENT table using
**                the Post Event function.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:        9 October 1995
**
** Programmer:          Erik T. Wilson
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   24 Apr 1997 15:09:44  $
**                      $Modtime:   24 Apr 1997 11:03:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/28/95  WILSONET  String Test Modifications.
**
**  12/08/95  RAOSP     SIR #2170 : Allow the Document to be saved when
**                      Visitation Plan English and Spanish.
**
**  12/14/95  PURCELA   SIR #2170 : Additional modifications to compensate
**                      for Save Failure when Stages other than Subcare used
**
**  12/28/95  WILSONET  SIR#2170 : When the Stage is FRE, FSU, or FPR there
**                      is no reason to call CINV51D.  The if statement
**                      before this DAM was expanded to include a check
**                      for SUB Stage.  RAOSP,PURCELA changes were deleleted.
**
**  04/22/97  CYSKD     SIR #11812 : Took away unnecessary PROCESS_TUX_RC_ERROR
**                      and provided for graceful error handling in event
**                      of a timestamp mismatch on a document save.
** 12/03/2002 DWW   changed line 422 so that it processes the correct error codes
**          old code: PROCESS_TUX_SQL_ERROR;
**          new code: PROCESS_TUX_RC_ERROR;
** 12/18/2002 Srini D   changed line 410 to return
**          pServiceStatus->explan_code = MSG_SYS_EVENT_STS_MSMTCH;
**          instead of FND_FAIL for CheckStageEventStatus
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver mode" allowing supervisors to ability to
**                      modify data without invalidating the pending
**                      approval.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub60s {
    public static final String PRIMARY_CHILD = "PC";
    public static final String STATUS_PENDING = "PEND";
    public static final String STATUS_NEW = "NEW";
    
    /*
    ** SIR #2170 : CD_STAGE's that will require a diffent Stage Person role to
    ** be passed in to CINV51 and that role itself.
    */
    public static final String SUBCARE_STG_CODE = "SUB";
    CSUB60SO CSUB60S(CSUB60SI csub60si) {
        CSUB60SO csub60so = new CSUB60SO();
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
        //##  short rc      = FND_SUCCESS;
        int RetVal = SUCCESS;
        /*
        ** Declare local variables
        */
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        CINV43DI pCINV43DInputRec = null;/* Sir 3513 TODO Update Dam */
        CINV43DO pCINV43DOutputRec = null;/* Sir 3513 TODO Update Dam */
        CCMN06UI pCCMN06UInputRec = null;/*SIR#1710*/
        CCMN06UO pCCMN06UOutputRec = null;/*SIR#1710*/
        CCMN05UI pInvdInput = null;/* Invalidate approval common function */
        
        CCMN05UO pInvdOutput = null;
        CCMN01UI pCCMN01UInputRec = null;/* Rebuild common function */
        
        CCMN01UO pCCMN01UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub60si.getArchInputStruct());
        
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
        pCCMN06UInputRec.setArchInputStruct(csub60si.getArchInputStruct());
        
        
        
        /* END NEW LICENSING INV CODE - SPB ***************************************** */
        
        /*
        ** Perform edits for CAA - Investigation
        ** Closed after assignment
        */
        if (0 != csub60si.getROWCCMN01UIG00().getUlIdEvent()) {
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        else {
            
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        pCCMN06UInputRec.setUlIdStage(csub60si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csub60si.getROWCCMN01UIG00().getSzCdTask());
        
        
        /*
        ** Call CAUD20D.  The Contract Period ELB DAM receives IdContract and
        ** performs an AUD on the indicated row.
        ** Delete:  a stored procedure is called to perform a cascade delete
        **          for Contract Version, Contract Service and Contract County.
        ** Add:     Performs a full row insert into Contract Period Table
        ** Modify:  Performs a full row update into Contract Period Table.
        ** CONTRACT PERIOD update */
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
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        
        /*
        ** Set Calculated Retention date to maximum date
        */
        if ((SUCCESS == RetVal) && ((0 == STATUS_NEW.compareTo(csub60si.getSzCdEventStatus())) || (0 == csub60si.getROWCCMN01UIG00().getUlIdEvent())) && (0 == SUBCARE_STG_CODE.compareTo(csub60si.getSzCdStage()))) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCINV51DInputRec = new CINV51DI();
            
            pCINV51DOutputRec = new CINV51DO();
            pCINV51DInputRec.setArchInputStruct(csub60si.getArchInputStruct());
            pCINV51DInputRec.getArchInputStruct().setCReqFuncCd(csub60si.getArchInputStruct().getCReqFuncCd());
            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
            pCINV51DInputRec.setUlIdStage(csub60si.getROWCCMN01UIG00().getUlIdStage());
            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    csub60si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    csub60si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        if (false == csub60si.getArchInputStruct().getUlSysNbrReserved1()) {
            
            if ((SUCCESS == RetVal) && (0 == csub60si.getSzCdEventStatus().compareTo(STATUS_PENDING))) {
                //  Allocate memory for Common Function Input and Output Structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                pInvdInput.setArchInputStruct(csub60si.getArchInputStruct());
                pInvdInput.getArchInputStruct().setCReqFuncCd(csub60si.getArchInputStruct().getCReqFuncCd());
                
                pInvdInput.setUlIdEvent(csub60si.getROWCCMN01UIG00().getUlIdEvent());
                rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            if (RetVal == SUCCESS) {
                //  Allocate memory for Common Function Input and Output Structures
                pCCMN01UInputRec = new CCMN01UI();
                
                pCCMN01UOutputRec = new CCMN01UO();
                pCCMN01UInputRec.setArchInputStruct(csub60si.getArchInputStruct());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub60si.getROWCCMN01UIG00().getUlIdStage());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub60si.getROWCCMN01UIG00().getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub60si.getROWCCMN01UIG00().getUlIdEvent());
                pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(csub60si.getROWCCMN01UIG00().getDtDtEventOccurred());
                pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub60si.getROWCCMN01UIG00().getTsLastUpdate());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub60si.getROWCCMN01UIG00().getSzCdTask());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub60si.getROWCCMN01UIG00().getSzCdEventStatus());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub60si.getROWCCMN01UIG00().getSzCdEventType());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub60si.getROWCCMN01UIG00().getSzTxtEventDescr());
                
                //  If CSES77D OutputRec Cd Guard Guardian Type
                // == APS or Contracted, and Cd Guard Close Reason
                // != Recorded in Error then call CSES68D for a retention
                // type of Guardianship (APG)
                if (0 == pCCMN01UInputRec.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                
                else {
                    
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                }
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub60si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                //  Get the current date and store it in dtCurrentDate
                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        csub60so.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                        
                        //  Set Calculated Retention date to maximum date
                        if ((RetVal == SUCCESS) && (0 != csub60si.getROWCCMN01UIG00().getUlIdEvent())) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCINV43DInputRec = new CINV43DI();
                            
                            pCINV43DOutputRec = new CINV43DO();
                            pCINV43DInputRec.setArchInputStruct(csub60si.getArchInputStruct());
                            pCINV43DInputRec.setUlIdEvent(csub60si.getROWCCMN01UIG00().getUlIdEvent());
                            // CONTRACT VERSION update
                            rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    break;
                                    
                                default :
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                        }
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        pServiceStatus.severity = FND_WARNING;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        break;
                        
                    default :
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
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
        ARC_PRFServiceStopTime_TUX(csub60si.getArchInputStruct() , csub60so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        /*
        ** Set Calculated Retention date to maximum date
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csub60so;
    }

}
