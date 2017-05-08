package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CCFC11S.src
**
** Service Name:   CCFC11S - PAL TRNG SVC SAVE
**
** Description:   This service will update all columns for an Id Stage/
**                Id PAL Services from the PAL SERVICE table.  It will also
**                update all columns for an Id Event from the EVENT table.
**                It can add or modify the EVENT row.  It will also retrieve
**                the primary child for the PAL stage in order to lik the
**                event with the primary child whem adding the
**                Services/Training event.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12-14-95 
** 
** Programmer:    Jeff Hughes
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   03 Apr 1997 22:38:38  $
**                      $Modtime:   03 Apr 1997 09:05:28  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/28/96  JRH       SIR 3421---Added Common function 06 to check
**                      to see if the stage is closed.  If the stage is 
**                      closed, an error will be displayed to the user 
**                      telling them that they cannot save this event.
**
**  03/01/96  OMARAJJ   SIR#3513 - Added the TODO AUD Dam, CINV43D, to the
**                      save service so that whenever the data for PAL RUT
**                      is saved, the associated TODO, if any, will
**                      be taken off the Staff TODO List.  This is necessary
**                      because in the PAL Dialog when a TODO is completed
**                      for the ILS or RUT windows the event status remains
**                      PROC until the stage is completed through the PAL
**                      Summary window.  Thus, simply completing a TODO would
**                      not have removed it from the TODO List.  The CINV43D
**                      dam updates the date TODO completed and removes the
**                      TODO from the TODO list whenever the window data is
**                      saved.
**
** 03/06/96  OMARAJJ    SIR# 3669 - Added an IF condition to the call to 
**                      CINV43D, TODO update DAM, because this dam would
**                      cause the save service to fail if no event had been
**                      previously created (ie if no TODO was created before
**                      the first attempt at saving). This dam requires an ID
**                      EVENT.
**  04/02/97    KRD     SIR 13196 - If an error occurs during a call to a
**                      DAM, the service should stop processing.  The error
**                      handling in this service was continuing after an
**                      error was returned from CAUD62D.  Consequently, this
**                      service has been cleaned up to handle error properly.
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






public class Ccfc11s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final String PRIMARY_CHILD = "PC";
    public static final String IN_PROCESS = "PROC";
    public static final String RECORD_UNPAID_TRAINING = "RUT";
    public static final String PAL_FOLLOWUP_COMPLETED = "COMP";
    public static final String RECORD_UNPAID_TRAINING_DESC = "Record Services/Training";
    CCFC11SO CCFC11S(CCFC11SI ccfc11si) {
        CCFC11SO ccfc11so = new CCFC11SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        CINV51DI pCINV51DInputRec = null;/* pointer to DAM input record  */
        CINV51DO pCINV51DOutputRec = null;/* pointer to DAM output record */
        
        CAUD62DI pCAUD62DInputRec = null;
        CAUD62DO pCAUD62DOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* Post Event common function          */
        CCMN01UO pCCMN01UOutputRec = null;/* Post Event common function OutPut */
        CCMN06UI pCCMN06UInputRec = null;/* Sir 3447Check Stage Common Function */
        CCMN06UO pCCMN06UOutputRec = null;/* Sir 3447Check Stage Common Function */
        CINV43DI pCINV43DInputRec = null;/* ToDo Complete AUD dam: update only  */
        
        CINV43DO pCINV43DOutputRec = null;
        
        
        
        int RetVal = SUCCESS;
        
        int usRow = 0;
        int usInputRow = 0;
        int ulIdPerson4 = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccfc11si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** SIR 3421--- Common Function: ccmn06u  ** Check Stage/Event
        ** common function. If Stage is closed do not allow save service 
        ** to continue.
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(ccfc11si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(ccfc11si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(ccfc11si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(ccfc11si.getROWCCMN01UIG00().getSzCdTask());
        
        /*
        ** Call DAM
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
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        /* 01/22/2003 DWW: Added for error handling */
        if (RetVal == SUCCESS) {
            //## END TUX/XML: Turn the XML buffer into an input message struct 
            
            
            
            if (ccfc11si.getSzSysCdWinMode() == WINDOW_MODE_NEW) {
                
                // * Allocate memory for DAM Input and Output Structures
                pCINV51DInputRec = new CINV51DI();
                
                pCINV51DOutputRec = new CINV51DO();
                pCINV51DInputRec.setUlIdStage(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(0).getUlIdStage());
                pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:// possible not to have any rows
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ulIdPerson4 = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                        
                        RetVal = SUCCESS;
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            
            if (SUCCESS == RetVal) {
                
                // 
                // (BEGIN): Common Function: CCMN01U   Post Event common function
                // 
                
                //  Allocate memory for Common Function Input and Output Structures
                pCCMN01UInputRec = new CCMN01UI();
                
                pCCMN01UOutputRec = new CCMN01UO();
                pCCMN01UInputRec.setArchInputStruct(ccfc11si.getArchInputStruct());
                
                if (0 == ccfc11si.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                
                else {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                }
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccfc11si.getROWCCMN01UIG00().getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(ulIdPerson4);
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(IN_PROCESS);
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(RECORD_UNPAID_TRAINING);
                rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(ccfc11si.getROWCCMN01UIG00().getUlIdEvent());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccfc11si.getROWCCMN01UIG00().getUlIdStage());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(ccfc11si.getROWCCMN01UIG00().getSzCdTask());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(RECORD_UNPAID_TRAINING_DESC);
                if (0 != ccfc11si.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(ccfc11si.getROWCCMN01UIG00().getTsLastUpdate());
                }
                
                if (ccfc11si.getSzSysCdWinMode() == WINDOW_MODE_NEW) {
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(ulIdPerson4);
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                
                
                
                // Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccfc11so.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD62DInputRec = new CAUD62DI();
                        
                        pCAUD62DOutputRec = new CAUD62DO();
                        
                        
                        //  Initialize rc for loop
                        RetVal = SUCCESS;
                        
                        //  While more rows are left to process and rc is zero,
                        // continue loop.
                        while ((usRow < ccfc11si.getArchInputStruct().getUlPageSizeNbr()) && (SUCCESS == RetVal)) {
                            pCAUD62DInputRec.setArchInputStruct(ccfc11si.getArchInputStruct());
                            pCAUD62DInputRec.getArchInputStruct().setCReqFuncCd(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getSzCdScrDataAction());
                            pCAUD62DInputRec.setUlIdPalService(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getUlIdPalService());
                            pCAUD62DInputRec.setUlIdStage(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getUlIdStage());
                            pCAUD62DInputRec.setSzCdPalServiceCategory(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getSzCdPalServiceCategory());
                            pCAUD62DInputRec.setTsLastUpdate(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getTsLastUpdate());
                            pCAUD62DInputRec.setSzCdPalServiceType(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getSzCdPalServiceType());
                            pCAUD62DInputRec.setLNbrPalServiceUnits(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getLNbrPalServiceUnits());
                            pCAUD62DInputRec.setSzSdsPalServiceOther(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getSzSdsPalServiceOther());
                            pCAUD62DInputRec.setDtDtPalServiceDate(ccfc11si.getROWCCFC11SIG00_ARRAY().getROWCCFC11SIG00(usRow).getDtDtPalServiceDate());
                            rc = caud62dAUDdam(sqlca, pCAUD62DInputRec, pCAUD62DOutputRec);
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    RetVal = SUCCESS;
                                    break;
                                    // 05/15/03  Srini     SIR# 17294. Not returning proper error when the year is less than 1850.
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                    
                                    
                                    //  Set explan_data to usRow
                                    // Note: Use sprintf
                                    //##                    sprintf(pReturnPB->appl_status.explan_data,
                                    //##                            "%u",
                                    //##                            usRow);
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                                    
                                    
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                            usRow++;
                        }
                        break;
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                }
            }
            
            if ((SUCCESS == RetVal) && (0 != ccfc11si.getROWCCMN01UIG00().getUlIdEvent())) {
                //  SIR#3513 - Added the TODO AUD Dam, CINV43D, to the
                // save service so that whenever the data for PAL ILS
                // Assessment is saved, the associated TODO, if any, will
                // be taken off the Staff TODO List.  This is necessary
                // because in the PAL Dialog when a TODO is completed for 
                // the ILS or RUT windows the event status remains PROC
                // until the stage is completed through the PAL Summary
                // window.  Thus, simply completing a TODO would not have
                // removed it from the TODO List.  The CINV43D dam updates
                // the date TODO completed and removes the TODO from the
                // TODO list whenever the window data is saved.
                
                //  Allocate memory for DAM Input and Output Structures
                pCINV43DInputRec = new CINV43DI();
                
                pCINV43DOutputRec = new CINV43DO();
                pCINV43DInputRec.setArchInputStruct(ccfc11si.getArchInputStruct());
                pCINV43DInputRec.getArchInputStruct().setCReqFuncCd(ccfc11si.getArchInputStruct().getCReqFuncCd());
                pCINV43DInputRec.setUlIdEvent(ccfc11si.getROWCCMN01UIG00().getUlIdEvent());
                rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        
                        // 
                        // (END): Retrieve Event Record
                        // 
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
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
        ARC_PRFServiceStopTime_TUX(ccfc11si.getArchInputStruct() , ccfc11so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            //  Start performance timer for service. All performance functions always
            // return success so there is no need to check status.
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //  If there was some action (i.e. add or delete), then
            // call the DAM.
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                // SIR 21891 - missing versioning
                //  Run-time Versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                // 
                // Call DAMs to retrieve data
                // 
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccfc11so;
    }

}
