package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC68DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB1DO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV71DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV90DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV90DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV70DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV70DO;
/**************************************************************************
**
** Module File:   CINV08S.src
**
** Service Name:  CINV08S
**
** Description:   Updates the Facility Allegation Details and the Injury
**                List Details.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  28 MAR 95
**
** Programmer:    WHW
**
** 11/07/95  YANTISTK   SIR#1710 Add code for CheckStageEventStatus common
**                      function.
** 01/02/96  GUARRICR   ERR #2422: Set function code in input record to
**                      CheckStageEventStatus to UPDATE in order to
**                      prevent searching for an event that would not exist
**                      for allegations.
** 02/10/96  GLOORJW    SIR #2141: In order for the Facility Allegation
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
**  3/19/96  ODONNERJ   SIR# 3899: Add UPDATE to IF loop to retrieve tmStamp
**                      for Save and stay. Add CINV70D and CINV90D to retreive
**                      tsLastUpdate for Facil_alleg detail table and allegation
**                      table.
**  5/13/96  ODONNERJ   SIR# 20824: Add new lines to prevent error code when the
**                      Req_func code is ADD. Fixes glitch in SIR# 3899.
**
**  7/16/96  DYARGR     SIR 21814 - Free the pointers for cinvb1d
** 12/11/96  RIOSJA     SIR 22052 - A check on the NEGLECT TYPE field needs
**                      to be included as a condition for the duplicate row
**                      check for facility allegations.
**
**  04/28/97  GONZALCE  SIR 13618: Populated cIndFacilSuperintNotif with
**                      CINV17D Output Rec. Changed two variable names to match
**                      C names in DAM files generated from Foundation.  The
**                      variables are:szAddrFacilInvstStr1 and
**                      szAddrFacilInvstStr2
** 04/21/97  DURANG     SIR 13618 - MHMR Enhancement.  Added a condition
**                      prior to calling CheckStageEventStatus -
**                      Check Stage/Event common function.
** 07/24/97  GONZALCE   SIR 14170 - Populated the MHMR Component Code in
**                      CINV22DI because previously it was being updated
**                      to NULL.
** 12/03/2002 DWW   Added the next two lines to make the service return
**          an error on this condition.
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
**
**  03/10/2004     Srini  SIR #22595 - Modified the unmarshal function to 
**			  take care of same field name problem in both parent 
**			  and child structures.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv08s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String INTAKE = "INT";
    public static final String PRINCIPAL = "PRN";
    public static final String TASK_STATUS_COMPLETE = "COMP";
    public static final String ALLEGED_VICTIM = "VC";
    public static final String ALLEGED_PERP = "AP";
    public static final String VICTIM_PERP = "VP";
    public static final String NO_ROLE = "NO";
    public static final String CASE_MERGED_IN_ERROR = "ZZZ";
    
    public static final String NEGL_ALLEG_TYPE = "NEGL";
    CINV08SO CINV08S(CINV08SI cinv08si) {
        CINV08SO cinv08so = new CINV08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/* SIR#1710 */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        char bSuccess = '\u0000';
        CCMN06UI pCCMN06UInputRec = null;/* SIR#1710 Check Stage/Event common function */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#1710 */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        CCMNB6DO CCMNB6DOutputMsg = null;/* SIR #2141 Get ID_CASE for ID_STAGE */
        CLSC68DI CLSC68DInputMsg = null;/* SIR #2141 Send info to CASE_MERGE  */
        CLSC68DO CLSC68DOutputMsg = null;/* SIR #2141 Get info from CASE_MERGE */
        int AVVictimCnt = 0;/* # times victim is named as a victim in other allegations */
        int AVPerpCnt = 0;/* # times victim is named as a perp in other allegations   */
        int APVictimCnt = 0;/* # times perp is named as a victim in other allegations   */
        int APPerpCnt = 0;/* # times perp is named as a perp in other allegations     */
        int usInjuryRecords = 0;
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv08si.getArchInputStruct());
        
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
        pCCMN06UInputRec.setArchInputStruct(cinv08si.getArchInputStruct());
        pCCMN06UInputRec.setUlIdStage(cinv08si.getCINV08SIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv08si.getCINV08SIG00().getSzCdTask());
        
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        if (cinv08si.getCINV08SIG00().getLdIdTodo() != 0) {
            pCCMN06UInputRec.setUlIdStage(cinv08si.getCINV08SIG00().getLdIdTodo());
        }
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
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
        if (SUCCESS == RetVal &&!(CASE_MERGED_IN_ERROR.compareTo(cinv08si.getCINV08SIG00().getCdAllegDisposition()) != 0)) {
            
            
            //  Call CSES68D
            rc = Cinv09s.CallCCMNB6D(cinv08si, CCMNB6DOutputMsg, pServiceStatus);
            
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
                
                rc = Cinv09s.CallCLSC68D(cinv08si, CLSC68DInputMsg.getUlIdCaseMergeTo() , CLSC68DOutputMsg, pServiceStatus);
                
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
            
            // 
            // Call DAMs to retrieve data
            // 
            
            // Save # of injury list rows.
            usInjuryRecords = cinv08si.getArchInputStruct().getUlPageSizeNbr();
            cinv08so.setUlIdVictim(cinv08si.getCINV08SIG00().getUlIdVictim());
            cinv08so.setUlIdAllegedPerpetrator(cinv08si.getCINV08SIG00().getUlIdAllegedPerpetrator());
            if (WtcHelperConstants.REQ_FUNC_CD_DELETE == cinv08si.getArchInputStruct().getCReqFuncCd()) {
                if (cinv08si.getCINV08SIG00().getSzCdAllegIncidentStage().compareTo(INTAKE) != 0) {
                    
                    //  SIR #2304: Call CAUD36D to update the
                    // CD_STAGE_TYPE
                    
                    //  Update the Cd Stage Type on the Stage table
                    if (cinv08si.getCdAllegDisposition() != null) {
                        
                        //  Set rc to MSG_DETAIL_DELETED
                        rc = Cinv10s.CallBlankOverallDispositionFAC(cinv08si, cinv08so, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  Set rc to MSG_DETAIL_DELETED
                    rc = CallCINV71D(cinv08si, cinv08so, pServiceStatus);
                    
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            //  Set rc to MSG_DETAIL_DELETED
                            rc = Cinv47s.CallCINVB2D(cinv08si, cinv08so, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            AVVictimCnt = cinv08so.getUlIdVictim();
                            APVictimCnt = cinv08so.getUlIdAllegedPerpetrator();
                            
                            
                            //  Call CSEC63D
                            rc = Cinv47s.CallCINVB3D(cinv08si, cinv08so, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            AVPerpCnt = cinv08so.getUlIdVictim();
                            APPerpCnt = cinv08so.getUlIdAllegedPerpetrator();
                            if ((AVVictimCnt > 0) && (AVPerpCnt > 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole2(VICTIM_PERP);
                            }
                            if ((AVVictimCnt == 0) && (AVPerpCnt > 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole2(ALLEGED_PERP);
                            }
                            
                            //  SIR 2968
                            // Added if test for close date.  If this is an APS or Contracted
                            // Guardianship and the closed date is filled and we are currently
                            // stage type guardianship, we need to check that this is the only
                            // Guardianship record before changing the stage type to reg
                            if ((AVVictimCnt > 0) && (AVPerpCnt == 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole2(ALLEGED_VICTIM);
                            }
                            if ((AVVictimCnt == 0) && (AVPerpCnt == 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole2(NO_ROLE);
                            }
                            if ((APVictimCnt > 0) && (APPerpCnt > 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole(VICTIM_PERP);
                            }
                            if ((APVictimCnt == 0) && (APPerpCnt > 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole(ALLEGED_PERP);
                            }
                            if ((APVictimCnt > 0) && (APPerpCnt == 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole(ALLEGED_VICTIM);
                            }
                            
                            if ((APVictimCnt == 0) && (APPerpCnt == 0)) {
                                cinv08si.getCINV08SIG00().setSzCdStagePersRole(NO_ROLE);
                            }
                            
                            rc = Cinv47s.CallCINVA4D(cinv08si, cinv08so, pServiceStatus);
                            
                            cinv08so.setUlIdVictim(cinv08si.getCINV08SIG00().getUlIdVictim());
                            
                            cinv08so.setUlIdAllegedPerpetrator(cinv08si.getCINV08SIG00().getUlIdAllegedPerpetrator());
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            break;
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            break;
                            
                        default :
                            
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                else // stage is INTAKE
                {
                    
                    //  Set rc to MSG_DETAIL_DELETED
                    rc = Cinv47s.CallCINVA1D(cinv08si, cinv08so, pServiceStatus);
                    
                    
                    //  Increase Page Counter
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    if (cinv08so.getArchOutputStruct().getUlRowQty() > 1) {
                        
                        
                        //  Call CSES68D
                        rc = CallCINV71D(cinv08si, cinv08so, pServiceStatus);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                if (cinv08si.getCdAllegDisposition() != null) {
                                    
                                    rc = Cinv10s.CallBlankOverallDispositionFAC(cinv08si, cinv08so, pServiceStatus);
                                    
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                
                                //  Set rc to MSG_DETAIL_DELETED
                                rc = Cinv47s.CallCINVB2D(cinv08si, cinv08so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                
                                AVVictimCnt = cinv08so.getUlIdVictim();
                                APVictimCnt = cinv08so.getUlIdAllegedPerpetrator();
                                
                                
                                //  Call CSEC08D
                                rc = Cinv47s.CallCINVB3D(cinv08si, cinv08so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                
                                AVPerpCnt = cinv08so.getUlIdVictim();
                                APPerpCnt = cinv08so.getUlIdAllegedPerpetrator();
                                if ((AVVictimCnt > 0) && (AVPerpCnt > 0)) {
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole2(VICTIM_PERP);
                                }
                                
                                if ((AVVictimCnt == 0) && (AVPerpCnt > 0)) {
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole2(ALLEGED_PERP);
                                }
                                // SIR 23694 - Check the stage type. If stage type is GUA or C-GUA
                                // set the stage type accrodingly.
                                if ((AVVictimCnt > 0) && (AVPerpCnt == 0)) {
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole2(ALLEGED_VICTIM);
                                }
                                // SIR 23694 - Check for stage type for GUA and C-GUA.
                                // Set the stage type as GUA if stage type is REG. Else if stage type is
                                // C-GUA set the stage type as C-GUA.
                                if ((AVVictimCnt == 0) && (AVPerpCnt == 0)) {
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole2(NO_ROLE);
                                }
                                if ((APVictimCnt > 0) && (APPerpCnt > 0)) {
                                    
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole(VICTIM_PERP);
                                }
                                
                                // SIR 23694 - Check the stage type for GUA and C-GUA.
                                // Set the stage type accrodingly.
                                if ((APVictimCnt == 0) && (APPerpCnt > 0)) {
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole(ALLEGED_PERP);
                                }
                                
                                
                                
                                
                                
                                
                                
                                
                                //  SIR 15280 - delete three month review to dos (or
                                // ensure they are already deleted) if the stage type
                                // is guardianship
                                if ((APVictimCnt > 0) && (APPerpCnt == 0)) {
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole(ALLEGED_VICTIM);
                                }
                                
                                //  SIR 15280 - if the stage type has just been changed from GUA
                                // to REG, then re-create the three month to dos for the worker
                                // and the supervisor.  This happens when closing a guardianship
                                if ((APVictimCnt == 0) && (APPerpCnt == 0)) {
                                    cinv08si.getCINV08SIG00().setSzCdStagePersRole(NO_ROLE);
                                }
                                
                                
                                //  Call CSES68D
                                rc = Cinv47s.CallCINVA4D(cinv08si, cinv08so, pServiceStatus);
                                cinv08so.setUlIdVictim(cinv08si.getCINV08SIG00().getUlIdVictim());
                                cinv08so.setUlIdAllegedPerpetrator(cinv08si.getCINV08SIG00().getUlIdAllegedPerpetrator());
                                break;
                            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                break;
                            case Messages.MSG_CMN_UPDATE_FAILED:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                    }
                    else // can't delete; return error message
                    {
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = Messages.MSG_INV_NOT_DUP_ALLEG;
                        
                        rc = Messages.MSG_INV_NOT_DUP_ALLEG;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
            else // ADD or UPDATE
            {
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = Cinv47s.CallCINVA1D(cinv08si, cinv08so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                // 
                // (END): CINV43D
                // 
                
                if (cinv08so.getArchOutputStruct().getUlRowQty() > 0) {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_NO_DUP_LB_ROW;
                    
                    //  Set rc to MSG_DETAIL_DELETED
                    rc = Messages.MSG_NO_DUP_LB_ROW;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                else // else if duplicates weren't found
                {
                    if (cinv08si.getCdAllegDisposition() != null) {
                        
                        //  Set rc to MSG_DETAIL_DELETED
                        rc = Cinv10s.CallBlankOverallDispositionFAC(cinv08si, cinv08so, pServiceStatus);
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    
                    //  Call CAUD75D
                    rc = Cinv47s.CallCINVA4D(cinv08si, cinv08so, pServiceStatus);
                    
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            break;
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            break;
                            
                        default :
                            
                            //## BEGIN TUX/XML: Declare XML variables 
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    // Set rc to ARC_SUCCESS
                    rc = CallCINV71D(cinv08si, cinv08so, pServiceStatus);
                    
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            if (WtcHelperConstants.REQ_FUNC_CD_ADD == cinv08si.getArchInputStruct().getCReqFuncCd() || ServiceConstants.REQ_FUNC_CD_UPDATE == cinv08si.getArchInputStruct().getCReqFuncCd()) {
                                cinv08si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                cinv08si.getArchInputStruct().setUlPageSizeNbr(CINVB1DO._CINVB1DO__ROWCINVB1DO_SIZE);
                                rc = Cinv47s.CallCINVB1D(cinv08si, cinv08so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                rc = Cinv07s.CallCINV70D(cinv08si, cinv08so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                
                                //  Call DAM
                                rc = Cinv44s.CallCINV90D(cinv08si, cinv08so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            break;
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
            cinv08si.getArchInputStruct().setUlPageSizeNbr(usInjuryRecords);
            
            if (cinv08si.getArchInputStruct().getUlPageSizeNbr() > 0) {
                rc = CallCINV09D(cinv08si, cinv08so, pServiceStatus);
                
                //  Analyze return code
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
            }
            if ((0 != cinv08si.getUlIdEvent()) && (false == cinv08si.getArchInputStruct().getUlSysNbrReserved1())) {
                rc = Ccmn05u.CallCCMN62D(cinv08si, cinv08so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                // We also need to Invalidate the approval for the other windows
                // associated with this case
                
                //  Reserve memory for Invalidate Function structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                pInvdInput.setArchInputStruct(cinv08si.getArchInputStruct());
                pInvdInput.setUlIdEvent(cinv08si.getUlIdEvent());
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
        ARC_PRFServiceStopTime_TUX(cinv08si.getArchInputStruct() , cinv08so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            //  Start Performance Timer
            rc = SUCCESS;
        }
        
        /**************************************************************************
        ** (END): Post Event
        **************************************************************************/
        
        
        /*
        ** Create Alert Todo
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
        return cinv08so;
    }

    static int CallCINVA1D(CINV08SI pInputMsg551, CINV08SO pOutputMsg509, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVA1DI pCINVA1DInputRec = null;
        CINVA1DO pCINVA1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVA1DInputRec = new CINVA1DI();
        
        pCINVA1DOutputRec = new CINVA1DO();
        pCINVA1DInputRec.setArchInputStruct(pInputMsg551.getArchInputStruct());
        pCINVA1DInputRec.setUlIdAllegedPerpetrator(pInputMsg551.getCINV08SIG00().getUlIdAllegedPerpetrator());
        pCINVA1DInputRec.setUlIdVictim(pInputMsg551.getCINV08SIG00().getUlIdVictim());
        pCINVA1DInputRec.setSzCdAllegType(pInputMsg551.getCINV08SIG00().getSzCdAllegType());
        pCINVA1DInputRec.setUlIdStage(pInputMsg551.getCINV08SIG00().getUlIdStage());
        pCINVA1DInputRec.setSzCdFacilAllegNeglType(pInputMsg551.getCINV08SIG00().getSzCdFacilAllegNeglType());
        if (0 == pInputMsg551.getCINV08SIG00().getSzCdAllegType().compareTo(NEGL_ALLEG_TYPE)) {
            pCINVA1DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        else {
            pCINVA1DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        rc = cinva1dQUERYdam(sqlca, pCINVA1DInputRec, pCINVA1DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                
                //  SIR 3106 - Loop through the CCON18SOG00 structure to find
                // the IdPerson with a role of 'CL' or 'VC'.  We only want to
                // send this NmPersonFull and IdPerson back to the client
                //  SIR 20789
                // Changed this if statement to only do this for APS cases and
                // always regardless of whether we have an event
                // if (0 != pInputMsg->ulIdEvent ||
                // 0 == strcmp(APS, pInputMsg->szCdUnitProgram) )
                if (!((1 == pCINVA1DOutputRec.getArchOutputStruct().getUlRowQty()) && (pInputMsg551.getCINV08SIG00().getUlIdAllegation() == pCINVA1DOutputRec.getUlIdAllegation()))) {
                    pOutputMsg509.getArchOutputStruct().setUlRowQty(pCINVA1DOutputRec.getArchOutputStruct().getUlRowQty());
                }
                else {
                    pOutputMsg509.getArchOutputStruct().setUlRowQty(0);
                }
                
                // 
                // End Call to Stage Retrieval Dam - CINT21D
                // 
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV71D(CINV08SI pInputMsg552, CINV08SO * pOutputMsg510, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV71DI pCINV71DInputRec = null;
        CINV71DO pCINV71DOutputRec = null;
        int i301 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV71DInputRec = new CINV71DI();
        
        pCINV71DOutputRec = new CINV71DO();
        pCINV71DInputRec.setArchInputStruct(pInputMsg552.getArchInputStruct());
        pCINV71DInputRec.setCdAllegDisposition(pInputMsg552.getCINV08SIG00().getCdAllegDisposition());
        pCINV71DInputRec.setSzCdAllegIncidentStage(pInputMsg552.getCINV08SIG00().getSzCdAllegIncidentStage());
        pCINV71DInputRec.setSzCdAllegType(pInputMsg552.getCINV08SIG00().getSzCdAllegType());
        pCINV71DInputRec.setSzFacilAllegInvClass(pInputMsg552.getCINV08SIG00().getSzFacilAllegInvClass());
        pCINV71DInputRec.setSzCdFacilAllegClssSupr(pInputMsg552.getCINV08SIG00().getSzCdFacilAllegClssSupr());
        pCINV71DInputRec.setSzCdFacilAllegDispSupr(pInputMsg552.getCINV08SIG00().getSzCdFacilAllegDispSupr());
        
        pCINV71DInputRec.setSzCdFacilAllegEventLoc(pInputMsg552.getCINV08SIG00().getSzCdFacilAllegEventLoc());
        pCINV71DInputRec.setSzCdFacilAllegInjSer(pInputMsg552.getCINV08SIG00().getSzCdFacilAllegInjSer());
        pCINV71DInputRec.setSzCdFacilAllegNeglType(pInputMsg552.getCINV08SIG00().getSzCdFacilAllegNeglType());
        pCINV71DInputRec.setSzCdFacilAllegSrc(pInputMsg552.getCINV08SIG00().getSzCdFacilAllegSrc());
        pCINV71DInputRec.setSzCdFacilAllegSrcSupr(pInputMsg552.getCINV08SIG00().getSzCdFacilAllegSrcSupr());
        pCINV71DInputRec.setBIndFacilAllegAbOffGr(pInputMsg552.getCINV08SIG00().getBIndFacilAllegAbOffGr());
        pCINV71DInputRec.setBIndFacilAllegCancelHist(pInputMsg552.getCINV08SIG00().getBIndFacilAllegCancelHist());
        pCINV71DInputRec.setBIndFacilAllegSupvd(pInputMsg552.getCINV08SIG00().getBIndFacilAllegSupvd());
        pCINV71DInputRec.setSzNbrFacilAllegMHMR(pInputMsg552.getCINV08SIG00().getSzNbrFacilAllegMHMR());
        pCINV71DInputRec.setSzTxtFacilAllegCmnts(pInputMsg552.getCINV08SIG00().getSzTxtFacilAllegCmnts());
        pCINV71DInputRec.setTsLastUpdate(pInputMsg552.getCINV08SIG00().getTsLastUpdate());
        
        pCINV71DInputRec.setTsSysTsLastUpdate2(pInputMsg552.getCINV08SIG00().getTsSysTsLastUpdate2());
        pCINV71DInputRec.setDtDtFacilAllegIncident(pInputMsg552.getCINV08SIG00().getDtDtFacilAllegIncident());
        pCINV71DInputRec.setTmTmIncmgCall(pInputMsg552.getCINV08SIG00().getTmTmIncmgCall());
        pCINV71DInputRec.setDtDtFacilAllegInvstgtr(pInputMsg552.getCINV08SIG00().getDtDtFacilAllegInvstgtr());
        
        pCINV71DInputRec.setDtDtFacilAllegSuprReply(pInputMsg552.getCINV08SIG00().getDtDtFacilAllegSuprReply());
        
        pCINV71DInputRec.setUlIdAllegation(pInputMsg552.getCINV08SIG00().getUlIdAllegation());
        pCINV71DInputRec.setUlIdAllegedPerpetrator(pInputMsg552.getCINV08SIG00().getUlIdAllegedPerpetrator());
        pCINV71DInputRec.setUlIdStage(pInputMsg552.getCINV08SIG00().getUlIdStage());
        pCINV71DInputRec.setUlIdVictim(pInputMsg552.getCINV08SIG00().getUlIdVictim());
        rc = cinv71dAUDdam(sqlca, pCINV71DInputRec, pCINV71DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg552.getArchInputStruct().getCReqFuncCd()) {
                    for (i301 = 0;i301 < CINV08SI._CINV08SI__CINV08SIG01_SIZE;i301++) {
                        pInputMsg552.getCINV08SIG01_ARRAY().getCINV08SIG01(i301).setUlIdAllegation(pCINV71DOutputRec.getUlIdAllegation());
                    }
                }
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call CAUD20D.  The Contract Period ELB DAM receives IdContract and
                // performs an AUD on the indicated row.
                // Delete:  a stored procedure is called to perform a cascade delete
                // for Contract Version, Contract Service and Contract County.
                // Add:     Performs a full row insert into Contract Period Table
                // Modify:  Performs a full row update into Contract Period Table.
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV09D(CINV08SI pInputMsg553, CINV08SO * pOutputMsg511, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i302 = 0;
        
        /*
        ** Declare local variables
        */
        CINV09DI pCINV09DInputRec = null;
        CINV09DO pCINV09DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV09DInputRec = new CINV09DI();
        
        pCINV09DOutputRec = new CINV09DO();
        pCINV09DInputRec.setArchInputStruct(pInputMsg553.getArchInputStruct());
        
        /*
        ** Populate Input Structure for DAM
        */
        for (i302 = 0;i302 < pInputMsg553.getArchInputStruct().getUlPageSizeNbr();i302++) {
            pCINV09DInputRec.setSzCdFacilInjuryBody(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getSzCdFacilInjuryBody());
            pCINV09DInputRec.setSzCdFacilInjuryCause(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getSzCdFacilInjuryCause());
            pCINV09DInputRec.setDtFacilInjuryDtrmntn(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getDtFacilInjuryDtrmntn());
            pCINV09DInputRec.setSzCdFacilInjurySide(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getSzCdFacilInjurySide());
            pCINV09DInputRec.setSzCdFacilInjuryType(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getSzCdFacilInjuryType());
            pCINV09DInputRec.setSzTxtFacilInjuryCmnts(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getSzTxtFacilInjuryCmnts());
            pCINV09DInputRec.setTsLastUpdate(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getTsLastUpdate());
            pCINV09DInputRec.setUlIdFacilityInjury(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getUlIdFacilityInjury());
            pCINV09DInputRec.setUlIdAllegation(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getUlIdAllegation());
            pCINV09DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg553.getCINV08SIG01_ARRAY().getCINV08SIG01(i302).getCReqFuncCd());
            //  This employee is not a Unit Approver:
            // continue processing the rest of the service.
            rc = cinv09dAUDdam(sqlca, pCINV09DInputRec, pCINV09DOutputRec);
            
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
        return rc;
    }

    static int CallCINVB2D(CINV08SI pInputMsg554, CINV08SO pOutputMsg512, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVB2DI pCINVB2DInputRec = null;
        CINVB2DO pCINVB2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB2DInputRec = new CINVB2DI();
        
        pCINVB2DOutputRec = new CINVB2DO();
        pCINVB2DInputRec.setArchInputStruct(pInputMsg554.getArchInputStruct());
        pCINVB2DInputRec.setUlIdPerson(pInputMsg554.getCINV08SIG00().getUlIdVictim());
        pCINVB2DInputRec.setUlIdStage(pInputMsg554.getCINV08SIG00().getUlIdStage());
        pCINVB2DInputRec.setUlIdAllegation(pInputMsg554.getCINV08SIG00().getUlIdAllegation());
        
        /*
        ** Call CCMN01U
        */
        rc = cinvb2dQUERYdam(sqlca, pCINVB2DInputRec, pCINVB2DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg512.setUlIdVictim(pCINVB2DOutputRec.getArchOutputStruct().getUlRowQty());
                pCINVB2DInputRec.setUlIdPerson(pInputMsg554.getCINV08SIG00().getUlIdAllegedPerpetrator());
                rc = cinvb2dQUERYdam(sqlca, pCINVB2DInputRec, pCINVB2DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pOutputMsg512.setUlIdAllegedPerpetrator(pCINVB2DOutputRec.getArchOutputStruct().getUlRowQty());
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVB3D(CINV08SI pInputMsg555, CINV08SO pOutputMsg513, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/*Return Code*/
        
        /*
        ** Declare local variables
        */
        CINVB3DI pCINVB3DInputRec = null;
        CINVB3DO pCINVB3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB3DInputRec = new CINVB3DI();
        
        pCINVB3DOutputRec = new CINVB3DO();
        pCINVB3DInputRec.setArchInputStruct(pInputMsg555.getArchInputStruct());
        pCINVB3DInputRec.setUlIdPerson(pInputMsg555.getCINV08SIG00().getUlIdVictim());
        pCINVB3DInputRec.setUlIdStage(pInputMsg555.getCINV08SIG00().getUlIdStage());
        pCINVB3DInputRec.setUlIdAllegation(pInputMsg555.getCINV08SIG00().getUlIdAllegation());
        
        rc = cinvb3dQUERYdam(sqlca, pCINVB3DInputRec, pCINVB3DOutputRec);
        switch (rc) {
                
                // SIR 11077 - We are assuming that all the exceptions raised
                // will be bcause of deleting the VID for a resource that has
                // contracts asociated with it.
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg513.setUlIdVictim(pCINVB3DOutputRec.getArchOutputStruct().getUlRowQty());
                pCINVB3DInputRec.setUlIdPerson(pInputMsg555.getCINV08SIG00().getUlIdAllegedPerpetrator());
                
                //  Call DAM
                rc = cinvb3dQUERYdam(sqlca, pCINVB3DInputRec, pCINVB3DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pOutputMsg513.setUlIdAllegedPerpetrator(pCINVB3DOutputRec.getArchOutputStruct().getUlRowQty());
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
        
        
    }

    static int CallCINVB1D(CINV08SI pInputMsg556, CINV08SO pOutputMsg514, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        /*
        ** Declare local variables
        */
        CINVB1DI pCINVB1DInputRec = null;
        CINVB1DO pCINVB1DOutputRec = null;
        int i303 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB1DInputRec = new CINVB1DI();
        
        pCINVB1DOutputRec = new CINVB1DO();
        pCINVB1DInputRec.setArchInputStruct(pInputMsg556.getArchInputStruct());
        
        pCINVB1DInputRec.setUlIdStage(pInputMsg556.getCINV08SIG00().getUlIdStage());
        pCINVB1DInputRec.setSzCdStagePersType(PRINCIPAL);
        rc = cinvb1dQUERYdam(sqlca, pCINVB1DInputRec, pCINVB1DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                // Victim Timestamp
                for (i303 = 0;i303 < pCINVB1DOutputRec.getArchOutputStruct().getUlRowQty();i303++) {
                    
                    //  Set Event Status to "Complete" if required window fields
                    // filled
                    if (pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i303).getUlIdPerson() == pOutputMsg514.getUlIdVictim()) {
                        pOutputMsg514.setTsSysTsLastUpdate4(pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i303).getTsLastUpdate());
                    }
                }
                
                // Perp Timestamp
                for (i303 = 0;i303 < pCINVB1DOutputRec.getArchOutputStruct().getUlRowQty();i303++) {
                    //  If stage is a Case Related Special Request, the Recommended
                    // Action field doesn't need to be filled
                    if (pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i303).getUlIdPerson() == pOutputMsg514.getUlIdAllegedPerpetrator()) {
                        
                        pOutputMsg514.setTsSysTsLastUpdate3(pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i303).getTsLastUpdate());
                    }
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVA4D(CINV08SI pInputMsg557, CINV08SO * pOutputMsg515, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVA4DI pCINVA4DInputRec = null;
        CINVA4DO pCINVA4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVA4DInputRec = new CINVA4DI();
        
        pCINVA4DOutputRec = new CINVA4DO();
        pCINVA4DInputRec.setArchInputStruct(pInputMsg557.getArchInputStruct());
        pCINVA4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINVA4DInputRec.setUlIdStage(pInputMsg557.getCINV08SIG00().getUlIdStage());
        pCINVA4DInputRec.setUlIdPerson(pInputMsg557.getCINV08SIG00().getUlIdVictim());
        pCINVA4DInputRec.setSzCdStagePersRole(pInputMsg557.getCINV08SIG00().getSzCdStagePersRole2());
        pCINVA4DInputRec.setTsLastUpdate(pInputMsg557.getCINV08SIG00().getTsSysTsLastUpdate4());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /*
        ** Set CCON05SO WCD DtSystemDate to current date
        */
        rc = cinva4dAUDdam(sqlca, pCINVA4DInputRec, pCINVA4DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
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
        /**************************************************************************
        ** (END): Common Function: ccmn01u  ** Post Event common function
        **************************************************************************/
        
        
        /* SIR 21130b -moved this from the SQL_SUCCESS of the switch statement
        ** because the has to call all the following event if we do not call
        ** post event
        ** If post event is called -- else statement entered -- the rc refers
        ** back to the POSTEVENT call ; if not rc refers back to CCMN62 call.
        */
        if (pInputMsg557.getCINV08SIG00().getUlIdAllegedPerpetrator() != 0) {
            
            if (pInputMsg557.getCINV08SIG00().getUlIdAllegedPerpetrator() != pInputMsg557.getCINV08SIG00().getUlIdVictim()) {
                pCINVA4DInputRec.setUlIdPerson(pInputMsg557.getCINV08SIG00().getUlIdAllegedPerpetrator());
                pCINVA4DInputRec.setSzCdStagePersRole(pInputMsg557.getCINV08SIG00().getSzCdStagePersRole());
                
                pCINVA4DInputRec.setTsLastUpdate(pInputMsg557.getCINV08SIG00().getTsSysTsLastUpdate3());
                
                
                //  Call CLSS06D
                rc = cinva4dAUDdam(sqlca, pCINVA4DInputRec, pCINVA4DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                        //  Populate event id for PostEvent
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        
                        //  Set rc to ARC_SUCCESS
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
        }
        return rc;
    }

    static int CallCCMN62D(CINV08SI pInputMsg558, CINV08SO * pOutputMsg516, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setUlIdEvent(pInputMsg558.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(TASK_STATUS_COMPLETE);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call CCMN45D
        */
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
        
    }

    static int CallBlankOverallDispositionFAC(CINV08SI pInputMsg559, CINV08SO * pOutputMsg517, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
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
        pCINV17DInputRec.setUlIdStage(pInputMsg559.getCINV08SIG00().getUlIdStage());
        rc = cinv17dQUERYdam(sqlca, pCINV17DInputRec, pCINV17DOutputRec);
        
        /*
        ** SIR 2217: Only call ccmn19d.pc, if the stage is not I&R or
        ** SPC.
        */
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
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCINV22DInputRec.setSzNmFacilInvstFacility(pCINV17DOutputRec.getSzNmFacilInvstFacility());
        pCINV22DInputRec.setSzTxtFacilInvstAffilCmnt(pCINV17DOutputRec.getSzTxtFacilInvstAffilCmnt());
        pCINV22DInputRec.setSzTxtFacilInvstComments(pCINV17DOutputRec.getSzTxtFacilInvstComments());
        pCINV22DInputRec.setTsLastUpdate(pCINV17DOutputRec.getTsLastUpdate());
        pCINV22DInputRec.setTmSysTmFacilInvstBeg(pCINV17DOutputRec.getTmSysTmFacilInvstBeg());
        pCINV22DInputRec.setTmSysTmFacilInvstInc(pCINV17DOutputRec.getTmSysTmFacilInvstInc());
        pCINV22DInputRec.setTmSysTmFacilInvstInt(pCINV17DOutputRec.getTmSysTmFacilInvstInt());
        pCINV22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinv22dAUDdam(sqlca, pCINV22DInputRec, pCINV22DOutputRec);
        /***********************************************************
        ** SIR 2657:  Added DAM CINT07D to Retrieve CD_INCMG_STATUS
        ** from the Incoming Detail table.  If the STATUS is MFD 
        ** (Marked for Deletion), it is OK not to find a primary 
        ** worker and to ignore this SQL not found error.
        ***********************************************************/
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNB6D(CINV08SI pInputMsg560, CCMNB6DO pCCMNB6DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
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
        
        pCCMNB6DInputRec.setArchInputStruct(pInputMsg560.getArchInputStruct());
        pCCMNB6DInputRec.setUlIdStage(pInputMsg560.getCINV08SIG00().getUlIdStage());
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

    
    static int CallCLSC68D(CINV08SI pInputMsg561, int ulIdCaseMergeTo2, CLSC68DO * pCLSC68DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter   */
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
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
        pCLSC68DInputRec.setArchInputStruct(pInputMsg561.getArchInputStruct());
        pCLSC68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC68DO._CLSC68DO__ROWCLSC68DO_SIZE);
        pCLSC68DInputRec.setUlIdCaseMergeTo(ulIdCaseMergeTo2);
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
                        
                        //  Call DAM
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

    static int CallCINV90D(CINV08SI pInputMsg562, CINV08SO pOutputMsg518, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i304 = 0;
        
        /*
        ** Declare local variables
        */
        CINV90DI pCINV90DInputRec = null;
        CINV90DO pCINV90DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV90DInputRec = new CINV90DI();
        
        pCINV90DOutputRec = new CINV90DO();
        pCINV90DInputRec.setUlIdStage(pInputMsg562.getCINV08SIG00().getUlIdStage());
        pCINV90DInputRec.setArchInputStruct(pInputMsg562.getArchInputStruct());
        
        /*
        ** Retrieve the Conclusion Event ID for the stage
        */
        
        /*
        ** SIR #2491 : Placed the call to this DAM in the if statement to
        ** avoid looking for an INV event when not in a INV stage. SPR
        */
        rc = cinv90dQUERYdam(sqlca, pCINV90DInputRec, pCINV90DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i304 = 0;i304 < pCINV90DOutputRec.getArchOutputStruct().getUlRowQty();++i304) {
                    
                    if (pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i304).getUlIdAllegation() == pInputMsg562.getCINV08SIG00().getUlIdAllegation()) {
                        pOutputMsg518.setTsSysTsLastUpdate2(pCINV90DOutputRec.getROWCINV90DO_ARRAY().getROWCINV90DO(i304).getTsLastUpdate());
                    }
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = Messages.MSG_INV_NO_ALLEGS;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV70D(CINV08SI pInputMsg563, CINV08SO pOutputMsg519, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV70DI pCINV70DInputRec = null;
        CINV70DO pCINV70DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV70DInputRec = new CINV70DI();
        
        pCINV70DOutputRec = new CINV70DO();
        pCINV70DInputRec.setArchInputStruct(pInputMsg563.getArchInputStruct());
        
        if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg563.getArchInputStruct().getCReqFuncCd()) {
            pCINV70DInputRec.setUlIdAllegation(pInputMsg563.getCINV08SIG01_ARRAY().getCINV08SIG01(0).getUlIdAllegation());
        }
        else /* (REQ_FUNC_CD_UPDATE == pInputMsg->ArchInputStruct.cReqFuncCd) */
        {
            pCINV70DInputRec.setUlIdAllegation(pInputMsg563.getCINV08SIG00().getUlIdAllegation());
        }
        /*
        ** Call DAM 19 to get NM STAGE and primary worker 
        */
        rc = cinv70dQUERYdam(sqlca, pCINV70DInputRec, pCINV70DOutputRec);
        
        /*
        ** Analyze return code for CINV51D(VC)
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg519.setTsLastUpdate(pCINV70DOutputRec.getTsLastUpdate());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                // NEW USING / MODIFY SCENERIO WINDOW POPULATION
                // when the window is called from TO DO LIST
                
                // Call DAM 90 to get the information for TODO
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

}
