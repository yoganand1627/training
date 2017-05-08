package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC68DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV77DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV77DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB6DI;
/**************************************************************************
**
** Module File:   CINV09S.src
**
** Service Name:  CINV09S
**
** Description:   Updates multiple Allegation Details.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  28 MAR 95
**
** Programmer:    WHW
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 18:18:20  $
**                      $Modtime:   23 May 1996 18:44:20  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
** 11/08/95  YANTISTK   SIR#1710 Add code for CheckStageEventStatus common
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
**  05/20/96  OMARAJJ   SIR#21251 - Replace COPYSZ with MEMCPY for timestamp
**                      variables.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**	07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**						before the InvalidateAprvl call.
**  07/13/04   douglacs SIR 22756 - add new fields to licensing_invst_dtl
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv09s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String TASK_STATUS_COMPLETE = "COMP";
    
    public static final int DETAIL_RECORD = 0;
    public static final int OVERALL = 1;
    
    
    /* for APS To Do's        */
    /* for CPS To Do's        */
    
    public static final String APS = "APS";
    public static final String CPS = "CPS";
    public static final String RESIDENTIAL_LIC = "RCL";
    public static final String COMMUNITY_LIC = "CCL";
    public static final String CD_STAGE_ADMIN = "ADM";
    public static final String CASE_MERGED_IN_ERROR = "ZZZ";
    CINV09SO CINV09S(CINV09SI cinv09si) {
        CINV09SO cinv09so = new CINV09SO();
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
        CCMN06UI pCCMN06UInputRec = null;/* SIR#2426 */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#2426 */
        CCMNB6DO CCMNB6DOutputMsg = null;/* SIR #2141 Get ID_CASE for ID_STAGE */
        CLSC68DI CLSC68DInputMsg = null;/* SIR #2141 Send info to CASE_MERGE  */
        CLSC68DO CLSC68DOutputMsg = null;/* SIR #2141 Get info from CASE_MERGE */
        
        
        /*
        ** Call CSES68D
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv09si.getArchInputStruct());
        
        
        
        /*
        ** SIR 468 - If the call is a I&R or a non-case related special
        ** request, then a case and situation should not be created.
        ** The disposition will contain either a special request or
        ** an I&R type.  An easier method is to check the stage cd.
        ** A case related special request will have INT as its code here.
        */
        if (cinv09si.getSzCdStage().compareTo(CD_STAGE_ADMIN) != 0) {
            // 
            // SIR#1710
            // (BEGIN): Common Function: ccmn06u Check Stage/Event common function.
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cinv09si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv09si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(cinv09si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cinv09si.getSzCdTask());
            
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    break;
                case Messages.MSG_SYS_STAGE_CLOSED:// No Rows for Listbox
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    //  Place code here to be executed on a successful DAM call.  For
                    // instance, a call to another DAM.
                    break;
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:// Person Id not found
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
        
        
        /* 
        ** Continue with normal creation/update of case and situation 
        ** if the call is an intake.
        */
        if (SUCCESS == RetVal &&!(CASE_MERGED_IN_ERROR.compareTo(cinv09si.getCdAllegDisposition_ARRAY().getCdAllegDisposition(DETAIL_RECORD)) != 0)) {
            
            //  Set rc to MSG_DETAIL_DELETED
            rc = Cinv08s.CallCCMNB6D(cinv09si, CCMNB6DOutputMsg, pServiceStatus);
            
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
                    //  Place code here to be executed on a successful DAM call.  For
                    // instance, a call to another DAM.
                    break;
            }
            if (Csub50s.FND_FAIL != RetVal) {
                CLSC68DInputMsg.setUlIdCaseMergeTo(CCMNB6DOutputMsg.getUlIdCase());
                
                // Set rc to ARC_SUCCESS
                rc = Cinv08s.CallCLSC68D(cinv09si, CLSC68DInputMsg.getUlIdCaseMergeTo() , CLSC68DOutputMsg, pServiceStatus);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        break;
                        
                        //  End Retrieve Resource's Payment History
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
            //  Create or modify the situation information 
            // If the situation is known, then send it to the service.
            if (cinv09si.CdAllegDisposition != null) {
                
                
                
                
                if (!(APS.compareTo(cinv09si.getSzCdStageProgram()) != 0)) {
                    
                    // Set rc to ARC_SUCCESS
                    rc = Cinv47s.CallBlankOverallDispositionAPS(cinv09si, cinv09so, pServiceStatus);
                }
                else if (!(RESIDENTIAL_LIC.compareTo(cinv09si.getSzCdStageProgram()) != 0) ||!(COMMUNITY_LIC.compareTo(cinv09si.getSzCdStageProgram()) != 0)) {
                    
                    
                    //  Call CINV95D
                    rc = Cinv47s.CallBlankOverallDispositionLIC(cinv09si, cinv09so, pServiceStatus);
                }
                else if (!(CPS.compareTo(cinv09si.getSzCdStageProgram()) != 0)) {
                    
                    
                    //  Call CSES66D
                    rc = Cinv47s.CallBlankOverallDispositionCPS(cinv09si, cinv09so, pServiceStatus);
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            
            //  Call CSES68D
            rc = CallCINV77D(cinv09si, cinv09so, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    break;
                case Messages.MSG_CMN_UPDATE_FAILED:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            
            //  SIR #1000  08/01/95 MED
            // Changes were made to this logic to allow an event to be created
            // for I&R and Non-case related special requests if they were being
            // submitted for approval.  This is necessary because submission
            // creates a Todo which must be tied to an event.
            
            //  Create a record call event.
            if ((0 != cinv09si.getUlIdEvent()) && (false == cinv09si.getArchInputStruct().getUlSysNbrReserved1())) {
                
                rc = Ccmn05u.CallCCMN62D(cinv09si, cinv09so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                // We also need to Invalidate the approval for the other windows
                // associated with this case
                
                //  Reserve memory for Invalidate Function structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                
                pInvdInput.setArchInputStruct(cinv09si.getArchInputStruct());
                pInvdInput.setUlIdEvent(cinv09si.getUlIdEvent());
                
                //  Set rc to MSG_DETAIL_DELETED
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
        ARC_PRFServiceStopTime_TUX(cinv09si.getArchInputStruct() , cinv09so.getArchOutputStruct());
        
        
        if (RetVal == SUCCESS) {
            
            //  Set rc to ARC_SUCCESS
            rc = SUCCESS;
        }
        
        
        /*
        ** If save and assign, we need to set the incmg status
        ** to CLD (closed).
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
                
                // Set rc to ARC_SUCCESS
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv09so;
    }

    static int CallCINV77D(CINV09SI pInputMsg564, CINV09SO * pOutputMsg520, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i305 = 0;
        
        /*
        ** Declare local variables
        */
        CINV77DI pCINV77DInputRec = null;
        CINV77DO pCINV77DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV77DInputRec = new CINV77DI();
        pCINV77DOutputRec = new CINV77DO();
        pCINV77DInputRec.setArchInputStruct(pInputMsg564.getArchInputStruct());
        
        /*
        ** Populate Input Structure for DAM
        */
        for (i305 = 0;i305 < pInputMsg564.getArchInputStruct().getUlPageSizeNbr();i305++) {
            pCINV77DInputRec.setUlIdAllegation(pInputMsg564.getCINV09SIG_ARRAY().getCINV09SIG(i305).getUlIdAllegation());
            pCINV77DInputRec.setCdAllegDisposition(pInputMsg564.getCdAllegDisposition_ARRAY().getCdAllegDisposition(DETAIL_RECORD));
            pCINV77DInputRec.setSzCdAllegSeverity(pInputMsg564.getSzCdAllegSeverity());
            pCINV77DInputRec.setSzTxtAllegDuration(pInputMsg564.getSzTxtAllegDuration());
            pCINV77DInputRec.setTsLastUpdate(pInputMsg564.getCINV09SIG_ARRAY().getCINV09SIG(i305).getTsLastUpdate());
            
            //  Call CSUB40U
            rc = cinv77dAUDdam(sqlca, pCINV77DInputRec, pCINV77DOutputRec);
            
            
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //set rc value to FND_FAIL
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    
                    break;
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN62D(CINV09SI pInputMsg565, CINV09SO * pOutputMsg521, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMN62DInputRec.setUlIdEvent(pInputMsg565.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(TASK_STATUS_COMPLETE);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        
        /************************************************************************
        ** (BEGIN): Contracts existance determination.  Is there an open foster
        **          and adoptive contract for the home?
        ************************************************************************/
        
        /*
        ** if home is non-prs or home is prs and home status is approved-active
        ** or approved-inactive, determine if contracts exist and create them if
        ** they don't exist
        */
        
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallBlankOverallDispositionAPS(CINV09SI pInputMsg566, CINV09SO * pOutputMsg522, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        
        /* To retrieve row from the disposition table.
        */
        CINV44DI pCINV44DInputRec = null;
        CINV44DO pCINV44DOutputRec = null;
        
        CINV24DI pCINV24DInputRec = null;
        CINV24DO pCINV24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINV44DInputRec = new CINV44DI();
        
        pCINV44DOutputRec = new CINV44DO();
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINV24DInputRec = new CINV24DI();
        
        pCINV24DOutputRec = new CINV24DO();
        pCINV44DInputRec.setUlIdStage(pInputMsg566.getUlIdStage());
        rc = cinv44dQUERYdam(sqlca, pCINV44DInputRec, pCINV44DOutputRec);
        if (rc != 0) {
            
            
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            return rc;
        }
        
        /*************************************************************
        ** END CAUD08D
        **************************************************************/
        /* End SIR #15787 */
        /* }  end SIR #10053 - if FND_SUCCESS == RetVal */
        
        /*********************END UPDATE CODE ************************/
        
        
        /* Increment contract row counter */
        pCINV24DInputRec.setTsLastUpdate(pCINV44DOutputRec.getROWCINV44DO().getTsLastUpdate());
        pCINV24DInputRec.setUlIdEvent(pCINV44DOutputRec.getROWCINV44DO().getUlIdEvent());
        pCINV24DInputRec.setUlIdStage(pCINV44DOutputRec.getROWCINV44DO().getUlIdStage());
        pCINV24DInputRec.setSzCdApsInvstFinalPrty(pCINV44DOutputRec.getROWCINV44DO().getSzCdApsInvstFinalPrty());
        pCINV24DInputRec.setDtDtApsInvstBegun(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstBegun());
        pCINV24DInputRec.setDtDtApsInvstCltAssmt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCltAssmt());
        pCINV24DInputRec.setDtDtApsInvstCmplt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCmplt());
        pCINV24DInputRec.setTsLastUpdate(pCINV44DOutputRec.getROWCINV44DO().getTsLastUpdate());
        pCINV24DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinv24dAUDdam(sqlca, pCINV24DInputRec, pCINV24DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallBlankOverallDispositionLIC(CINV09SI pInputMsg567, CINV09SO * pOutputMsg523, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables 
        */
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        /* To retrieve row from the disposition table.
        */
        CINV74DI pCINV74DInputRec = null;
        CINV74DO pCINV74DOutputRec = null;
        /*
        ** Declare local variables
        */
        CINV53DI pCINV53DInputRec = null;
        CINV53DO pCINV53DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINV74DInputRec = new CINV74DI();
        
        pCINV74DOutputRec = new CINV74DO();
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINV53DInputRec = new CINV53DI();
        
        pCINV53DOutputRec = new CINV53DO();
        pCINV74DInputRec.setUlIdStage(pInputMsg567.getUlIdStage());
        
        
        /*
        ** Call CAUD97
        */
        rc = cinv74dQUERYdam(sqlca, pCINV74DInputRec, pCINV74DOutputRec);
        
        
        
        
        /*
        ** SIR #20525 - Add CINT21D to retrieve whether the stage is closed
        ** or not regardless of window mode.
        */
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            return rc;
        }
        pCINV53DInputRec.setSzCdLicngInvstCoractn(pCINV74DOutputRec.getSzCdLicngInvstCoractn());
        pCINV53DInputRec.setDtDtLicngInvstAssigned(pCINV74DOutputRec.getDtDtLicngInvstAssigned());
        pCINV53DInputRec.setDtDtLicngInvstDtlBegun(pCINV74DOutputRec.getDtDtLicngInvstDtlBegun());
        pCINV53DInputRec.setDtDtLicngInvstComplt(pCINV74DOutputRec.getDtDtLicngInvstComplt());
        pCINV53DInputRec.setDtDtLicngInvstIntake(pCINV74DOutputRec.getDtDtLicngInvstIntake());
        pCINV53DInputRec.setUlIdEvent(pCINV74DOutputRec.getUlIdEvent());
        
        pCINV53DInputRec.setUlIdStage(pCINV74DOutputRec.getUlIdStage());
        pCINV53DInputRec.setTxtLicngInvstNoncomp(pCINV74DOutputRec.getTxtLicngInvstNoncomp());
        pCINV53DInputRec.setTsLastUpdate(pCINV74DOutputRec.getTsLastUpdate());
        pCINV53DInputRec.setUlIdResource(pCINV74DOutputRec.getUlIdResource());
        pCINV53DInputRec.setSzNmResource(pCINV74DOutputRec.getSzNmResource());
        pCINV53DInputRec.setLNbrRsrcFacilAcclaim(pCINV74DOutputRec.getLNbrRsrcFacilAcclaim());
        pCINV53DInputRec.setSzCdRsrcFacilType(pCINV74DOutputRec.getSzCdRsrcFacilType());
        pCINV53DInputRec.setSzTxtRsrcComments(pCINV74DOutputRec.getSzTxtRsrcComments());
        pCINV53DInputRec.setLNbrFacilPhoneNumber(pCINV74DOutputRec.getLNbrFacilPhoneNumber());
        pCINV53DInputRec.setLNbrFacilPhoneExtension(pCINV74DOutputRec.getLNbrFacilPhoneExtension());
        pCINV53DInputRec.setSzAddrRsrcAddrAttn(pCINV74DOutputRec.getSzAddrRsrcAddrAttn());
        pCINV53DInputRec.setSzAddrRsrcAddrStLn1(pCINV74DOutputRec.getSzAddrRsrcAddrStLn1());
        pCINV53DInputRec.setSzAddrRsrcAddrStLn2(pCINV74DOutputRec.getSzAddrRsrcAddrStLn2());
        pCINV53DInputRec.setSzAddrRsrcAddrCity(pCINV74DOutputRec.getSzAddrRsrcAddrCity());
        pCINV53DInputRec.setSzAddrRsrcAddrCounty(pCINV74DOutputRec.getSzAddrRsrcAddrCounty());
        pCINV53DInputRec.setSzAddrRsrcAddrState(pCINV74DOutputRec.getSzAddrRsrcAddrState());
        pCINV53DInputRec.setSzAddrRsrcAddrZip(pCINV74DOutputRec.getSzAddrRsrcAddrZip());
        pCINV53DInputRec.setUlIdAffilResource(pCINV74DOutputRec.getUlIdAffilResource());
        pCINV53DInputRec.setSzNmAffilResource(pCINV74DOutputRec.getSzNmAffilResource());
        pCINV53DInputRec.setSzTxtAffilComments(pCINV74DOutputRec.getSzTxtAffilComments());
        pCINV53DInputRec.setLNbrAffilPhoneNumber(pCINV74DOutputRec.getLNbrAffilPhoneNumber());
        pCINV53DInputRec.setLNbrAffilPhoneExtension(pCINV74DOutputRec.getLNbrAffilPhoneExtension());
        pCINV53DInputRec.setSzAffilAddrAttn(pCINV74DOutputRec.getSzAffilAddrAttn());
        pCINV53DInputRec.setSzAffilAddrStLn1(pCINV74DOutputRec.getSzAffilAddrStLn1());
        
        pCINV53DInputRec.setSzAffilAddrStLn2(pCINV74DOutputRec.getSzAffilAddrStLn2());
        pCINV53DInputRec.setSzAffilAddrCity(pCINV74DOutputRec.getSzAffilAddrCity());
        pCINV53DInputRec.setSzAffilAddrCounty(pCINV74DOutputRec.getSzAffilAddrCounty());
        pCINV53DInputRec.setSzAffilAddrState(pCINV74DOutputRec.getSzAffilAddrState());
        pCINV53DInputRec.setSzAffilAddrZip(pCINV74DOutputRec.getSzAffilAddrZip());
        pCINV53DInputRec.setUlIdClassFclty(pCINV74DOutputRec.getUlIdClassFclty());
        pCINV53DInputRec.setUlIdClassAffilFclty(pCINV74DOutputRec.getUlIdClassAffilFclty());
        pCINV53DInputRec.setLNbrAffilAcclaim(pCINV74DOutputRec.getLNbrAffilAcclaim());
        pCINV53DInputRec.setLNbrAgency(pCINV74DOutputRec.getLNbrAgency());
        pCINV53DInputRec.setLNbrBranch(pCINV74DOutputRec.getLNbrBranch());
        pCINV53DInputRec.setLNbrAffilAgency(pCINV74DOutputRec.getLNbrAffilAgency());
        pCINV53DInputRec.setLNbrAffilBranch(pCINV74DOutputRec.getLNbrAffilBranch());
        pCINV53DInputRec.setSzCdAffilFacilType(pCINV74DOutputRec.getSzCdAffilFacilType());
        pCINV53DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinv53dAUDdam(sqlca, pCINV53DInputRec, pCINV53DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallBlankOverallDispositionCPS(CINV09SI pInputMsg568, CINV09SO * pOutputMsg524, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        
        /* To retrieve row from the disposition table.
        */
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        CINVA8DI pCINVA8DInputRec = null;
        CINVA8DO pCINVA8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINV95DInputRec = new CINV95DI();
        
        pCINV95DOutputRec = new CINV95DO();
        
        /*
        ** Allocate memory for Input and Output Retrieve Structures
        */
        pCINVA8DInputRec = new CINVA8DI();
        
        pCINVA8DOutputRec = new CINVA8DO();
        pCINV95DInputRec.setUlIdStage(pInputMsg568.getUlIdStage());
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            return rc;
        }
        
        pCINVA8DInputRec.setSzCdCpsInvstDtlFamIncm(pCINV95DOutputRec.getSzCdCpsInvstDtlFamIncm());
        pCINVA8DInputRec.setCIndCpsInvstDtlRaNa(pCINV95DOutputRec.getCIndCpsInvstDtlRaNa());
        
        pCINVA8DInputRec.setDtDtCPSInvstDtlAssigned(pCINV95DOutputRec.getDtDtCPSInvstDtlAssigned());
        pCINVA8DInputRec.setDtDtCPSInvstDtlBegun(pCINV95DOutputRec.getDtDtCPSInvstDtlBegun());
        pCINVA8DInputRec.setDtDtCpsInvstDtlComplt(pCINV95DOutputRec.getDtDtCpsInvstDtlComplt());
        pCINVA8DInputRec.setDtDtCPSInvstDtlIntake(pCINV95DOutputRec.getDtDtCPSInvstDtlIntake());
        pCINVA8DInputRec.setUlIdEvent(pCINV95DOutputRec.getUlIdEvent());
        pCINVA8DInputRec.setUlIdStage(pCINV95DOutputRec.getUlIdStage());
        pCINVA8DInputRec.setBIndCpsInvstEaConcl(pCINV95DOutputRec.getBIndCpsInvstEaConcl());
        
        //## BEGIN TUX/XML: Declare XML variables
        pCINVA8DInputRec.setBIndCpsInvstSafetyPln(pCINV95DOutputRec.getBIndCpsInvstSafetyPln());
        pCINVA8DInputRec.setTsLastUpdate(pCINV95DOutputRec.getTsLastUpdate());
        pCINVA8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        
        /********** Start performance timer for Data Access Module ****************/
        rc = cinva8dAUDdam(sqlca, pCINVA8DInputRec, pCINVA8DOutputRec);
        
        /*
        ** Analyze error code
        */
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            
            
            
            
        }
        
        /*
        ** return ARC_SUCCESS because no Service Auth event types
        ** were found so the code can continue processing
        */
        return rc;
    }

    
    static int CallCCMNB6D(CINV09SI pInputMsg569, CCMNB6DO pCCMNB6DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMNB6DInputRec.setArchInputStruct(pInputMsg569.getArchInputStruct());
        pCCMNB6DInputRec.setUlIdStage(pInputMsg569.getUlIdStage());
        rc = ccmnb6dQUERYdam(sqlca, pCCMNB6DInputRec, pCCMNB6DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
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

    
    static int CallCLSC68D(CINV09SI pInputMsg570, int ulIdCaseMergeTo3, CLSC68DO * pCLSC68DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCLSC68DInputRec.setArchInputStruct(pInputMsg570.getArchInputStruct());
        pCLSC68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC68DO._CLSC68DO__ROWCLSC68DO_SIZE);
        pCLSC68DInputRec.setUlIdCaseMergeTo(ulIdCaseMergeTo3);
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
                //  SIR 2766 - MSG_INV_NOT_BEGUN case added
                //04/09/2003  Srini:  Added a break.
                break;
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = Messages.MSG_INV_DISP_INVALID;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
