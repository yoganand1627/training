package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV10SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV76DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB6DI;
/**************************************************************************
**
** Module File:   CINV10S.src
**
** Service Name:  CINV10S
**
** Description:   Updates multiple Facility Allegation Detail dispositions
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  28 MAR 95
**
** Programmer:    WHW
**
** 11/08/95  YANTISTK   SIR#1710 Added logic for CheckStageEventStatus common
**                      function.
** 02/20/96  GLOORJW    SIR #2141: In order for the Facility Allegation
**                      Detail window to save with the Case Merge/Split
**                      disposition code of ZZZ (Merged in Error), the
**                      ID_CASE_MERGE_TO column must exist and the
**                      IND_CASE_MERGE_INVALID must be 'Y' for
**                      the specific case located on the CASE_MERGE
**                      table.  The DAM CCMNB6D must be used in order to
**                      retreive the ID_CASE from the STAGE table given the
**                      ID_STAGE passed to the service.  If the two criteria
**                      specified are not met, is not valid, the code
**                      MSG_INV_DISP_INVALID will be returned to the window
**                      and the information will not be committed to the
**                      data base.  If the two criteria are met, the service
**                      will continue normally.
** 03/20/96  BRUCKMK   SIR 5124: The Comments also need to be saved for
**             Multi Mode and saved to all the selected Facility
**             Allegation Windows.  Added the Text Element to Service
**             and DAM Input Messages and the DAM itself.
**             To avoid comments being saved and overwriting both
**             the Investigator and Supervisor findings with blanks
**             when these are left blank, I split the call to
**             DAM cinv76d up for Supervisor, Investigator and
**             Comments data.  Depending on whether these fields
**             are populated, the DAM will be called with a specific
**             function code to update only the columns that should
**             be updated without overwriting the other columns
**             in the row with blanks.
**
**  04/28/97  GONZALCE  SIR 13618: Populated cIndFacilSuperintNotif with
**                      CINV17D Output Rec. Changed two variable names to match
**                      C names in DAM files generated from Foundation.  The
**                      variables are:szAddrFacilInvstStr1 and
**                      szAddrFacilInvstStr2
**
** 04/21/97  DURANG     SIR 13618 - MHMR Enhancement.  Added a condition
**                      prior to calling CheckStageEventStatus -
**                      Check Stage/Event common function.
** 07/24/97  GONZALCE   SIR 14170 - Populated the MHMR Component Code in
**                      CINV22DI because previously it was being updated
**                      to NULL.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**	07/30/03  Srini    SIR#19044 Initialize the input structure pointers
**			  		   before the InvalidateAprvl call.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv10s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String TASK_STATUS_COMPLETE = "COMP";
    
    public static final String CASE_MERGED_IN_ERROR = "ZZZ";
    
    public static final int DETAIL_RECORD = 0;
    public static final int OVERALL = 1;
    public static final String NULL_STRING = "";
    CINV10SO CINV10S(CINV10SI cinv10si) {
        CINV10SO cinv10so = new CINV10SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/* SIR#1710 */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        CCMNB6DO CCMNB6DOutputMsg = null;/* SIR #2141 Get ID_CASE for ID_STAGE */
        CLSC68DI CLSC68DInputMsg = null;/* SIR #2141 Send info to CASE_MERGE  */
        CLSC68DO CLSC68DOutputMsg = null;/* SIR #2141 Get info from CASE_MERGE */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function   */
        
        /* SIR 21130b */
        
        
        /*SIR 21130b*/
        
        
        
        /* SIR#3949: Add variable for ADS Skill Found for Worker */
        /*
        ** IMPACT BEGIN - removed variable due to it being unnecessary
        **
        **  BOOL          bSkillFound = FALSE;
        **
        ** IMPACT END
        */
        
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv10si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check buffer size
        */
        
        /*
        ** Process error message and return to client
        */
        
        /*
        ** Initialize output message and length
        */
        
        /*
        ** Initialize service status fields
        */
        
        /**************************************************************************
        ** SIR#1710
        ** (BEGIN): Common Function: ccmn06u Check Stage/Event common function.
        ****************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv10si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv10si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv10si.getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv10si.getSzCdTask());
        
        if (cinv10si.getLdIdTodo() != 0) {
            pCCMN06UInputRec.setUlIdStage(cinv10si.getLdIdTodo());
        }
        
        
        /*
        ** Call CAUD35D
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
        
        if (SUCCESS == RetVal &&!(CASE_MERGED_IN_ERROR.compareTo(cinv10si.getCdAllegDisposition_ARRAY().getCdAllegDisposition(DETAIL_RECORD)) != 0)) {
            rc = Cinv08s.CallCCMNB6D(cinv10si, CCMNB6DOutputMsg, pServiceStatus);
            
            
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
            
            if (Csub50s.FND_FAIL != RetVal) {
                CLSC68DInputMsg.setUlIdCaseMergeTo(CCMNB6DOutputMsg.getUlIdCase());
                rc = Cinv08s.CallCLSC68D(cinv10si, CLSC68DInputMsg.getUlIdCaseMergeTo() , CLSC68DOutputMsg, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                    case Messages.MSG_INV_DISP_INVALID:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = Messages.MSG_INV_DISP_INVALID;
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        
        if (SUCCESS == RetVal) {
            if (cinv10si.CdAllegDisposition != null) {
                rc = Cinv08s.CallBlankOverallDispositionFAC(cinv10si, cinv10so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = CallCINV76D(cinv10si, cinv10so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            if ((0 != cinv10si.getUlIdEvent()) && (false == cinv10si.getArchInputStruct().getUlSysNbrReserved1())) {
                
                rc = Ccmn05u.CallCCMN62D(cinv10si, cinv10so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                // We also need to Invalidate the approval for the other windows
                // associated with this case
                
                //  Reserve memory for Invalidate Function structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                pInvdInput.setArchInputStruct(cinv10si.getArchInputStruct());
                pInvdInput.setUlIdEvent(cinv10si.getUlIdEvent());
                rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv10si.getArchInputStruct() , cinv10so.getArchOutputStruct());
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        /*
        ** exit the loop once the primary address rec is found
        */
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  If a school district code exists for the primary row, 
            // get its decode
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
        return cinv10so;
    }

    static int CallCINV76D(CINV10SI pInputMsg571, CINV10SO * pOutputMsg525, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i306 = 0;
        
        /*
        ** Declare local variables
        */
        CINV76DI pCINV76DInputRec = null;
        CINV76DO pCINV76DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV76DInputRec = new CINV76DI();
        
        pCINV76DOutputRec = new CINV76DO();
        pCINV76DInputRec.setArchInputStruct(pInputMsg571.getArchInputStruct());
        pCINV76DInputRec.setCdAllegDisposition(pInputMsg571.getCdAllegDisposition_ARRAY().getCdAllegDisposition(DETAIL_RECORD));
        pCINV76DInputRec.setSzFacilAllegInvClass(pInputMsg571.getSzFacilAllegInvClass());
        pCINV76DInputRec.setSzCdFacilAllegClssSupr(pInputMsg571.getSzCdFacilAllegClssSupr());
        pCINV76DInputRec.setSzCdFacilAllegDispSupr(pInputMsg571.getSzCdFacilAllegDispSupr());
        pCINV76DInputRec.setSzCdFacilAllegSrc(pInputMsg571.getSzCdFacilAllegSrc());
        pCINV76DInputRec.setSzCdFacilAllegSrcSupr(pInputMsg571.getSzCdFacilAllegSrcSupr());
        pCINV76DInputRec.setSzTxtFacilAllegCmnts(pInputMsg571.getSzTxtFacilAllegCmnts());
        pCINV76DInputRec.setDtDtFacilAllegInvstgtr(pInputMsg571.getDtDtFacilAllegInvstgtr());
        pCINV76DInputRec.setDtDtFacilAllegSuprReply(pInputMsg571.getDtDtFacilAllegSuprReply());
        pCINV76DInputRec.setBIndFacilAllegCancelHist(pInputMsg571.getBIndFacilAllegCancelHist());
        
        if (0 != pInputMsg571.getSzCdFacilAllegSrc().compareTo(NULL_STRING)) {
            pCINV76DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            // 
            // SIR 5124: Update the Investigator fields if they were filled.
            // 
            for (i306 = 0;i306 < pInputMsg571.getArchInputStruct().getUlPageSizeNbr();i306++) {
                pCINV76DInputRec.setTsLastUpdate(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getTsLastUpdate());
                pCINV76DInputRec.setTsSysTsLastUpdate4(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getTsSysTsLastUpdate4());
                pCINV76DInputRec.setUlIdAllegation(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getUlIdAllegation());
                //  Call Retrieve DAM
                rc = cinv76dAUDdam(sqlca, pCINV76DInputRec, pCINV76DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        
                        
                        
                        
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
        }
        
        if (0 != pInputMsg571.getSzCdFacilAllegSrcSupr().compareTo(NULL_STRING)) {
            pCINV76DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            // 
            // SIR 5124: Update the Supervisor fields if they were filled.
            // 
            for (i306 = 0;i306 < pInputMsg571.getArchInputStruct().getUlPageSizeNbr();i306++) {
                pCINV76DInputRec.setTsLastUpdate(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getTsLastUpdate());
                pCINV76DInputRec.setTsSysTsLastUpdate4(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getTsSysTsLastUpdate4());
                pCINV76DInputRec.setUlIdAllegation(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getUlIdAllegation());
                rc = cinv76dAUDdam(sqlca, pCINV76DInputRec, pCINV76DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        
                        
                        
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
        }
        if (0 != pInputMsg571.getSzTxtFacilAllegCmnts().compareTo(NULL_STRING)) {
            pCINV76DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            
            // 
            // SIR 5124: Update the Comments if they were filled.
            // 
            for (i306 = 0;i306 < pInputMsg571.getArchInputStruct().getUlPageSizeNbr();i306++) {
                pCINV76DInputRec.setTsLastUpdate(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getTsLastUpdate());
                pCINV76DInputRec.setTsSysTsLastUpdate4(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getTsSysTsLastUpdate4());
                pCINV76DInputRec.setUlIdAllegation(pInputMsg571.getCINV10SIG_ARRAY().getCINV10SIG(i306).getUlIdAllegation());
                rc = cinv76dAUDdam(sqlca, pCINV76DInputRec, pCINV76DOutputRec);
                
                //  Analyze error code
                
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        
                        
                        
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCCMN62D(CINV10SI pInputMsg572, CINV10SO * pOutputMsg526, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setUlIdEvent(pInputMsg572.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(TASK_STATUS_COMPLETE);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallBlankOverallDispositionFAC(CINV10SI pInputMsg573, CINV10SO * pOutputMsg527, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        
        /* To retrieve row from the disposition table.
        */
        CINV17DI pCINV17DInputRec = null;
        CINV17DO pCINV17DOutputRec = null;
        
        CINV22DI pCINV22DInputRec = null;
        CINV22DO pCINV22DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINV17DInputRec = new CINV17DI();
        
        pCINV17DOutputRec = new CINV17DO();
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINV22DInputRec = new CINV22DI();
        
        pCINV22DOutputRec = new CINV22DO();
        pCINV17DInputRec.setUlIdStage(pInputMsg573.getUlIdStage());
        
        /*
        ** Call CCMN44D
        */
        rc = cinv17dQUERYdam(sqlca, pCINV17DInputRec, pCINV17DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            return rc;
        }
        pCINV22DInputRec.setCIndFacilSuperintNotif(pCINV17DOutputRec.getCIndFacilSuperintNotif());
        pCINV22DInputRec.setSzCdMhmrCompCode(pCINV17DOutputRec.getSzCdMhmrCompCode());
        pCINV22DInputRec.setSzAddrFacilInvstAffAttn(pCINV17DOutputRec.getSzAddrFacilInvstAffAttn());
        pCINV22DInputRec.setSzAddrFacilInvstAffCity(pCINV17DOutputRec.getSzAddrFacilInvstAffCity());
        pCINV22DInputRec.setSzAddrFacilInvstAffCnty(pCINV17DOutputRec.getSzAddrFacilInvstAffCnty());
        pCINV22DInputRec.setSzAddrFacilInvstAffilSt(pCINV17DOutputRec.getSzAddrFacilInvstAffilSt());
        pCINV22DInputRec.setSzAddrFacilInvstAffStr1(pCINV17DOutputRec.getSzAddrFacilInvstAffStr1());
        pCINV22DInputRec.setSzAddrFacilInvstAffStr2(pCINV17DOutputRec.getSzAddrFacilInvstAffStr2());
        pCINV22DInputRec.setSzAddrFacilInvstStr1(pCINV17DOutputRec.getSzAddrFacilInvstStr1());
        pCINV22DInputRec.setSzAddrFacilInvstStr2(pCINV17DOutputRec.getSzAddrFacilInvstStr2());
        pCINV22DInputRec.setSzAddrFacilInvstAffZip(pCINV17DOutputRec.getSzAddrFacilInvstAffZip());
        pCINV22DInputRec.setSzAddrFacilInvstAttn(pCINV17DOutputRec.getSzAddrFacilInvstAttn());
        pCINV22DInputRec.setSzAddrFacilInvstCity(pCINV17DOutputRec.getSzAddrFacilInvstCity());
        pCINV22DInputRec.setSzAddrFacilInvstCnty(pCINV17DOutputRec.getSzAddrFacilInvstCnty());
        pCINV22DInputRec.setSzAddrFacilInvstState(pCINV17DOutputRec.getSzAddrFacilInvstState());
        pCINV22DInputRec.setSsAddrFacilInvstZip(pCINV17DOutputRec.getSsAddrFacilInvstZip());
        pCINV22DInputRec.setDtDtFacilInvstBegun(pCINV17DOutputRec.getDtDtFacilInvstBegun());
        pCINV22DInputRec.setDtDtFacilInvstComplt(pCINV17DOutputRec.getDtDtFacilInvstComplt());
        pCINV22DInputRec.setDtDtFacilInvstIncident(pCINV17DOutputRec.getDtDtFacilInvstIncident());
        pCINV22DInputRec.setDtDtFacilInvstIntake(pCINV17DOutputRec.getDtDtFacilInvstIntake());
        pCINV22DInputRec.setUlIdAffilResource(pCINV17DOutputRec.getUlIdAffilResource());
        pCINV22DInputRec.setUlIdEvent(pCINV17DOutputRec.getUlIdEvent());
        pCINV22DInputRec.setUlIdFacilResource(pCINV17DOutputRec.getUlIdFacilResource());
        pCINV22DInputRec.setUlIdStage(pCINV17DOutputRec.getUlIdStage());
        pCINV22DInputRec.setSzNbrFacilInvstAffilExt(pCINV17DOutputRec.getSzNbrFacilInvstAffilExt());
        pCINV22DInputRec.setLNbrFacilInvstAffilPhn(pCINV17DOutputRec.getLNbrFacilInvstAffilPhn());
        pCINV22DInputRec.setSzNbrFacilInvstExtension(pCINV17DOutputRec.getSzNbrFacilInvstExtension());
        pCINV22DInputRec.setLNbrFacilInvstPhone(pCINV17DOutputRec.getLNbrFacilInvstPhone());
        pCINV22DInputRec.setSzNmFacilInvstAff(pCINV17DOutputRec.getSzNmFacilInvstAff());
        pCINV22DInputRec.setSzNmFacilInvstFacility(pCINV17DOutputRec.getSzNmFacilInvstFacility());
        pCINV22DInputRec.setSzTxtFacilInvstAffilCmnt(pCINV17DOutputRec.getSzTxtFacilInvstAffilCmnt());
        pCINV22DInputRec.setSzTxtFacilInvstComments(pCINV17DOutputRec.getSzTxtFacilInvstComments());
        pCINV22DInputRec.setTsLastUpdate(pCINV17DOutputRec.getTsLastUpdate());
        pCINV22DInputRec.setTmSysTmFacilInvstBeg(pCINV17DOutputRec.getTmSysTmFacilInvstBeg());
        pCINV22DInputRec.setTmSysTmFacilInvstInc(pCINV17DOutputRec.getTmSysTmFacilInvstInc());
        pCINV22DInputRec.setTmSysTmFacilInvstInt(pCINV17DOutputRec.getTmSysTmFacilInvstInt());
        pCINV22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call CINV51D
        */
        rc = cinv22dAUDdam(sqlca, pCINV22DInputRec, pCINV22DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCCMNB6D(CINV10SI pInputMsg574, CCMNB6DO pCCMNB6DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        CCMNB6DI pCCMNB6DInputRec = null;/* input record */
        CCMNB6DO pCCMNB6DOutputRec = null;/* output record */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB6DInputRec = new CCMNB6DI();
        
        
        pCCMNB6DOutputRec = new CCMNB6DO();
        pCCMNB6DInputRec.setArchInputStruct(pInputMsg574.getArchInputStruct());
        pCCMNB6DInputRec.setUlIdStage(pInputMsg574.getUlIdStage());
        
        /*
        ** Call CCMN01U
        */
        rc = ccmnb6dQUERYdam(sqlca, pCCMNB6DInputRec, pCCMNB6DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pCCMNB6DOutputMsg.setUlIdCase(pCCMNB6DOutputRec.getUlIdCase());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    
    static int CallCLSC68D(CINV10SI pInputMsg575, int ulIdCaseMergeTo4, CLSC68DO * pCLSC68DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter   */
        int rc = WtcHelperConstants.ARC_SUCCESS;
        CLSC68DI pCLSC68DInputRec = null;/* input record  */
        CLSC68DO pCLSC68DOutputRec = null;/* output record */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC68DInputRec = new CLSC68DI();
        
        
        pCLSC68DOutputRec = new CLSC68DO();
        pCLSC68DInputRec.setArchInputStruct(pInputMsg575.getArchInputStruct());
        pCLSC68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC68DO._CLSC68DO__ROWCLSC68DO_SIZE);
        pCLSC68DInputRec.setUlIdCaseMergeTo(ulIdCaseMergeTo4);
        rc = clsc68dQUERYdam(sqlca, pCLSC68DInputRec, pCLSC68DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Loop through rows returned in order to determine if
                // any IND_CASE_MERGE_INVALID fields are not YES
                for (usRowCtr = 0;usRowCtr < pCLSC68DOutputRec.getArchOutputStruct().getUlRowQty();usRowCtr++) {
                    
                    if (FND_YES != pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(usRowCtr).getCIndCaseMergeInv()) {
                        rc = Messages.MSG_INV_DISP_INVALID;
                        break;
                    }
                }
                break;
            case NO_DATA_FOUND:
                rc = Messages.MSG_INV_DISP_INVALID;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
