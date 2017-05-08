package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV47SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB1DO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA4DO;
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
** Module File:   CINV47S.src
**
** Service Name:  CINV47S
**
** Description:   AUD for the Allegation Detail Window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  28 MAR 95
**
** Programmer:    Belinda Muse
** Archive Information: $Revision:   1.3  $
**                      $Date:   17 Dec 1996 19:07:04  $
**                      $Modtime:   17 Dec 1996 18:33:24  $
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
**  3/18/96  ODONNERJ   SIR #3737: Changed the "ADM" #define to "ARI". Also
**                      changed CD_ADMIN_RV to ADMIN_REVIEW to match other
**                      #define in other *.win and *.src files
**  04/21/96  ODONNERJ  SIR 20541 - WCD_GenericStruct.ldIdTodo is  populated
**                      by the Admin Review window with the Id Stage of the
**                      Admin Review since the WCD_GenericStruct.ulIdStage
**                      sent to the allegation window is actually the
**                      IdStage of the INVESTIGATION STAGE. The ldIdTodo is
**                      passed to cinv45s and cinv47s to trigger
**                      the CheckEventStatus Common Function for the Admin
**                      Review IdStage instead of INVESTIGATION IdStage.
**  05/20/96  OMARAJJ   SIR#21251 - Replace COPYSZ with MEMCPY for timestamp
**                      variables.
**  7/16/96   DYARGR    SIR 21814 - Free the pointers for cinvb1d
**  12/11/96  RIOSJA    SIR 22052 - A check on the NEGLECT TYPE field needs
**                      to be included as a condition for the duplicate row
**                      check for facility allegations (see cinv08s).
**  11/14/02  DWW       made the attempt to add a duplicate row or the
**                      attempt to delete a non-exising row return error codes
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**	07/21/03   Srini    SIR 18926 - Fixed the unmarshalling problem with
**						CdAllegDisposition field.
**
**  07/21/03	JEH	SIR 18828 - pInvdInput needs
**			ArchInputStruct.ulSysNbrReserved1 to be initialized
**
**  07/13/04   douglacs SIR 22756 - add new fields to licensing_invst_dtl
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv47s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String INTAKE = "INT";
    public static final String TASK_STATUS_COMPLETE = "COMP";
    public static final String PRINCIPAL = "PRN";
    public static final String ALLEGED_VICTIM = "VC";
    public static final String ALLEGED_PERP = "AP";
    public static final String VICTIM_PERP = "VP";
    public static final String NO_ROLE = "NO";
    
    
    public static final String APS = "APS";
    public static final String CPS = "CPS";
    public static final String RESIDENTIAL_LIC = "RCL";
    public static final String COMMUNITY_LIC = "CCL";
    
    /* SIR 3737 - Change "ADM" to "ARI" */
    public static final String ADMIN_REVIEW = "ARI";
    public static final String CASE_MERGED_IN_ERROR = "ZZZ";
    CINV47SO CINV47S(CINV47SI cinv47si) {
        CINV47SO cinv47so = new CINV47SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/* SIR#1710 */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        CCMNB6DO CCMNB6DOutputMsg = null;/* SIR #2141 Get ID_CASE for ID_STAGE */
        CLSC68DI CLSC68DInputMsg = null;/* SIR #2141 Send info to CASE_MERGE  */
        CLSC68DO CLSC68DOutputMsg = null;/* SIR #2141 Get info from CASE_MERGE */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        int AVVictimCnt = 0;/* # times victim is named as a victim in other allegations */
        int AVPerpCnt = 0;/* # times victim is named as a perp in other allegations   */
        int APVictimCnt = 0;/* # times perp is named as a victim in other allegations   */
        int APPerpCnt = 0;/* # times perp is named as a perp in other allegations     */
        rc = ARC_PRFServiceStartTime_TUX(cinv47si.getArchInputStruct());
        
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
        
        /*{*/
        /**************************************************************************
        ** SIR#1710
        ** (BEGIN): Common Function: ccmn06u Check Stage/Event common function.
        ****************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(cinv47si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv47si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cinv47si.getCINV47SIG().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cinv47si.getCINV47SIG().getSzCdTask());
        if (cinv47si.getLdIdTodo() != 0) {
            pCCMN06UInputRec.setUlIdStage(cinv47si.getLdIdTodo());
            
        }
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
        if (SUCCESS == RetVal &&!(CASE_MERGED_IN_ERROR.compareTo(cinv47si.getCINV47SIG().getCdAllegDisposition()) != 0)) {
            rc = Cinv08s.CallCCMNB6D(cinv47si, CCMNB6DOutputMsg, pServiceStatus);
            
            
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
            
            //   SIR 11449 - PAL stage will allowed to be opened in all regions
            
            if (Csub50s.FND_FAIL != RetVal) {
                CLSC68DInputMsg.setUlIdCaseMergeTo(CCMNB6DOutputMsg.getUlIdCase());
                rc = Cinv08s.CallCLSC68D(cinv47si, CLSC68DInputMsg.getUlIdCaseMergeTo() , CLSC68DOutputMsg, pServiceStatus);
                
                
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
            cinv47so.setUlIdVictim(cinv47si.getCINV47SIG().getUlIdVictim());
            cinv47so.setUlIdAllegedPerpetrator(cinv47si.getCINV47SIG().getUlIdAllegedPerpetrator());
            if (WtcHelperConstants.REQ_FUNC_CD_DELETE == cinv47si.getArchInputStruct().getCReqFuncCd()) {
                if (cinv47si.getCINV47SIG().getSzCdAllegIncidentStage().compareTo(INTAKE) != 0) {
                    rc = Ccmn03u.CallCINV07D(cinv47si, cinv47so, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            if (cinv47si.getCdAllegDisposition() != null) {
                                
                                //  Analyze error code
                                if (!(APS.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                                    rc = Cinv09s.CallBlankOverallDispositionAPS(cinv47si, cinv47so, pServiceStatus);
                                }
                                else if (!(RESIDENTIAL_LIC.compareTo(cinv47si.getSzCdStageProgram()) != 0) ||!(COMMUNITY_LIC.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                                    
                                    // call DAM
                                    rc = Cinv09s.CallBlankOverallDispositionLIC(cinv47si, cinv47so, pServiceStatus);
                                }
                                else if (!(CPS.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                                    //  Do nothing, the output message just returns success or
                                    // failure.
                                    rc = Cinv09s.CallBlankOverallDispositionCPS(cinv47si, cinv47so, pServiceStatus);
                                }
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            //  there were no ToDos to transfer to the new worker
                            rc = Cinv08s.CallCINVB2D(cinv47si, cinv47so, pServiceStatus);
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            AVVictimCnt = cinv47so.getUlIdVictim();
                            APVictimCnt = cinv47so.getUlIdAllegedPerpetrator();
                            rc = Cinv08s.CallCINVB3D(cinv47si, cinv47so, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            AVPerpCnt = cinv47so.getUlIdVictim();
                            APPerpCnt = cinv47so.getUlIdAllegedPerpetrator();
                            if ((AVVictimCnt > 0) && (AVPerpCnt > 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole2(VICTIM_PERP);
                            }
                            if ((AVVictimCnt == 0) && (AVPerpCnt > 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole2(ALLEGED_PERP);
                            }
                            
                            if ((AVVictimCnt > 0) && (AVPerpCnt == 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole2(ALLEGED_VICTIM);
                            }
                            if ((AVVictimCnt == 0) && (AVPerpCnt == 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole2(NO_ROLE);
                            }
                            if ((APVictimCnt > 0) && (APPerpCnt > 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole(VICTIM_PERP);
                            }
                            if ((APVictimCnt == 0) && (APPerpCnt > 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole(ALLEGED_PERP);
                            }
                            
                            if ((APVictimCnt > 0) && (APPerpCnt == 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole(ALLEGED_VICTIM);
                            }
                            
                            if ((APVictimCnt == 0) && (APPerpCnt == 0)) {
                                cinv47si.getCINV47SIG().setSzCdStagePersRole(NO_ROLE);
                            }
                            rc = Cinv08s.CallCINVA4D(cinv47si, cinv47so, pServiceStatus);
                            cinv47so.setUlIdVictim(cinv47si.getCINV47SIG().getUlIdVictim());
                            cinv47so.setUlIdAllegedPerpetrator(cinv47si.getCINV47SIG().getUlIdAllegedPerpetrator());
                            
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
                    rc = Cinv08s.CallCINVA1D(cinv47si, cinv47so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    if (cinv47so.getArchOutputStruct().getUlRowQty() > 1) {
                        rc = Ccmn03u.CallCINV07D(cinv47si, cinv47so, pServiceStatus);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                
                                if (cinv47si.getCdAllegDisposition() != null) {
                                    
                                    if (!(APS.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                                        
                                        //  Call DAM
                                        rc = Cinv09s.CallBlankOverallDispositionAPS(cinv47si, cinv47so, pServiceStatus);
                                    }
                                    else if (!(RESIDENTIAL_LIC.compareTo(cinv47si.getSzCdStageProgram()) != 0) ||!(COMMUNITY_LIC.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                                        
                                        rc = Cinv09s.CallBlankOverallDispositionLIC(cinv47si, cinv47so, pServiceStatus);
                                    }
                                    else if (!(CPS.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                                        
                                        rc = Cinv09s.CallBlankOverallDispositionCPS(cinv47si, cinv47so, pServiceStatus);
                                    }
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                rc = Cinv08s.CallCINVB2D(cinv47si, cinv47so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                
                                AVVictimCnt = cinv47so.getUlIdVictim();
                                APVictimCnt = cinv47so.getUlIdAllegedPerpetrator();
                                rc = Cinv08s.CallCINVB3D(cinv47si, cinv47so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                
                                AVPerpCnt = cinv47so.getUlIdVictim();
                                APPerpCnt = cinv47so.getUlIdAllegedPerpetrator();
                                
                                if ((AVVictimCnt > 0) && (AVPerpCnt > 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole2(VICTIM_PERP);
                                }
                                
                                if ((AVVictimCnt == 0) && (AVPerpCnt > 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole2(ALLEGED_PERP);
                                }
                                
                                if ((AVVictimCnt > 0) && (AVPerpCnt == 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole2(ALLEGED_VICTIM);
                                }
                                
                                if ((AVVictimCnt == 0) && (AVPerpCnt == 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole2(NO_ROLE);
                                }
                                
                                if ((APVictimCnt > 0) && (APPerpCnt > 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole(VICTIM_PERP);
                                }
                                
                                if ((APVictimCnt == 0) && (APPerpCnt > 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole(ALLEGED_PERP);
                                }
                                if ((APVictimCnt > 0) && (APPerpCnt == 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole(ALLEGED_VICTIM);
                                }
                                if ((APVictimCnt == 0) && (APPerpCnt == 0)) {
                                    cinv47si.getCINV47SIG().setSzCdStagePersRole(NO_ROLE);
                                }
                                
                                rc = Cinv08s.CallCINVA4D(cinv47si, cinv47so, pServiceStatus);
                                cinv47so.setUlIdVictim(cinv47si.getCINV47SIG().getUlIdVictim());
                                cinv47so.setUlIdAllegedPerpetrator(cinv47si.getCINV47SIG().getUlIdAllegedPerpetrator());
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
                rc = Cinv08s.CallCINVA1D(cinv47si, cinv47so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                if (cinv47so.getArchOutputStruct().getUlRowQty() > 0) {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_NO_DUP_LB_ROW;
                    rc = Messages.MSG_NO_DUP_LB_ROW;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                else // else if duplicates weren't found
                {
                    
                    if (cinv47si.getCdAllegDisposition() != null) {
                        
                        if (!(APS.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                            rc = Cinv09s.CallBlankOverallDispositionAPS(cinv47si, cinv47so, pServiceStatus);
                        }
                        else if (!(RESIDENTIAL_LIC.compareTo(cinv47si.getSzCdStageProgram()) != 0) ||!(COMMUNITY_LIC.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                            rc = Cinv09s.CallBlankOverallDispositionLIC(cinv47si, cinv47so, pServiceStatus);
                        }
                        else if (!(CPS.compareTo(cinv47si.getSzCdStageProgram()) != 0)) {
                            //  Parse the address so that it will be in the proper format.
                            rc = Cinv09s.CallBlankOverallDispositionCPS(cinv47si, cinv47so, pServiceStatus);
                        }
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  Validate the address and place the result into the
                    // the second of the two address structures in the output
                    // message.
                    rc = Cinv08s.CallCINVA4D(cinv47si, cinv47so, pServiceStatus);
                    
                    
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
                    rc = Ccmn03u.CallCINV07D(cinv47si, cinv47so, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            if (WtcHelperConstants.REQ_FUNC_CD_ADD == cinv47si.getArchInputStruct().getCReqFuncCd()) {
                                cinv47si.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                cinv47si.getArchInputStruct().setUlPageSizeNbr(CINVB1DO._CINVB1DO__ROWCINVB1DO_SIZE);
                                //  Call DAM to retrieve data
                                rc = Cinv08s.CallCINVB1D(cinv47si, cinv47so, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            break;
                            
                            //SIR 23664
                        case Messages.MSG_CMN_UPDATE_FAILED:
                            // 
                            // End SIR #21969
                            // 
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
            
            if ((0 != cinv47si.getUlIdEvent()) && (false == cinv47si.getArchInputStruct().getUlSysNbrReserved1())) {
                //  If the ZiptoCounty function was successful, we need to translate
                // the code to a valid Texas county code only if a Texas address.
                rc = Ccmn05u.CallCCMN62D(cinv47si, cinv47so, pServiceStatus);
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                // We also need to Invalidate the approval for the other windows
                // associated with this case
                
                //  Reserve memory for Invalidate Function structures
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                
                pInvdInput.setUlIdEvent(cinv47si.getUlIdEvent());
                pInvdInput.getArchInputStruct().setUlSysNbrReserved1(cinv47si.getArchInputStruct().getUlSysNbrReserved1());
                
                
                //  BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                
                //04/21/03 Srini: setting the rc =FND_SUCCESS so that exception is not thrown. The 
                //				  error is decoded from	  output object.
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
        ARC_PRFServiceStopTime_TUX(cinv47si.getArchInputStruct() , cinv47so.getArchOutputStruct());
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
        return cinv47so;
    }

    static int CallCINVA1D(CINV47SI pInputMsg745, CINV47SO pOutputMsg695, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINVA1DInputRec.setArchInputStruct(pInputMsg745.getArchInputStruct());
        pCINVA1DInputRec.setUlIdAllegedPerpetrator(pInputMsg745.getCINV47SIG().getUlIdAllegedPerpetrator());
        pCINVA1DInputRec.setUlIdVictim(pInputMsg745.getCINV47SIG().getUlIdVictim());
        pCINVA1DInputRec.setSzCdAllegType(pInputMsg745.getCINV47SIG().getSzCdAllegType());
        pCINVA1DInputRec.setUlIdStage(pInputMsg745.getCINV47SIG().getUlIdStage());
        pCINVA1DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinva1dQUERYdam(sqlca, pCINVA1DInputRec, pCINVA1DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                if (!((1 == pCINVA1DOutputRec.getArchOutputStruct().getUlRowQty()) && (pInputMsg745.getCINV47SIG().getUlIdAllegation() == pCINVA1DOutputRec.getUlIdAllegation()))) {
                    pOutputMsg695.getArchOutputStruct().setUlRowQty(pCINVA1DOutputRec.getArchOutputStruct().getUlRowQty());
                }
                else {
                    pOutputMsg695.getArchOutputStruct().setUlRowQty(0);
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVB2D(CINV47SI pInputMsg746, CINV47SO pOutputMsg696, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINVB2DInputRec.setArchInputStruct(pInputMsg746.getArchInputStruct());
        pCINVB2DInputRec.setUlIdPerson(pInputMsg746.getCINV47SIG().getUlIdVictim());
        pCINVB2DInputRec.setUlIdStage(pInputMsg746.getCINV47SIG().getUlIdStage());
        pCINVB2DInputRec.setUlIdAllegation(pInputMsg746.getCINV47SIG().getUlIdAllegation());
        rc = cinvb2dQUERYdam(sqlca, pCINVB2DInputRec, pCINVB2DOutputRec);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg696.setUlIdVictim(pCINVB2DOutputRec.getArchOutputStruct().getUlRowQty());
                pCINVB2DInputRec.setUlIdPerson(pInputMsg746.getCINV47SIG().getUlIdAllegedPerpetrator());
                
                
                //  Call CAUD70D
                rc = cinvb2dQUERYdam(sqlca, pCINVB2DInputRec, pCINVB2DOutputRec);
                // SIR 19613
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pOutputMsg696.setUlIdAllegedPerpetrator(pCINVB2DOutputRec.getArchOutputStruct().getUlRowQty());
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
                // 
                // (END): CLSS68D - Retrieve contract service codes for
                // the contract, period, and version passed to the DAM.
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVB3D(CINV47SI pInputMsg747, CINV47SO pOutputMsg697, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
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
        
        pCINVB3DInputRec.setArchInputStruct(pInputMsg747.getArchInputStruct());
        
        pCINVB3DInputRec.setUlIdPerson(pInputMsg747.getCINV47SIG().getUlIdVictim());
        
        pCINVB3DInputRec.setUlIdStage(pInputMsg747.getCINV47SIG().getUlIdStage());
        pCINVB3DInputRec.setUlIdAllegation(pInputMsg747.getCINV47SIG().getUlIdAllegation());
        
        /*
        ** Set rc to SQL_SUCCESS
        */
        rc = cinvb3dQUERYdam(sqlca, pCINVB3DInputRec, pCINVB3DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg697.setUlIdVictim(pCINVB3DOutputRec.getArchOutputStruct().getUlRowQty());
                
                pCINVB3DInputRec.setUlIdPerson(pInputMsg747.getCINV47SIG().getUlIdAllegedPerpetrator());
                rc = cinvb3dQUERYdam(sqlca, pCINVB3DInputRec, pCINVB3DOutputRec);
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        pOutputMsg697.setUlIdAllegedPerpetrator(pCINVB3DOutputRec.getArchOutputStruct().getUlRowQty());
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

    static int CallCINVB1D(CINV47SI pInputMsg748, CINV47SO pOutputMsg698, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINVB1DI pCINVB1DInputRec = null;
        CINVB1DO pCINVB1DOutputRec = null;
        int i377 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB1DInputRec = new CINVB1DI();
        
        pCINVB1DOutputRec = new CINVB1DO();
        
        pCINVB1DInputRec.setArchInputStruct(pInputMsg748.getArchInputStruct());
        pCINVB1DInputRec.setUlIdStage(pInputMsg748.getCINV47SIG().getUlIdStage());
        pCINVB1DInputRec.setSzCdStagePersType(PRINCIPAL);
        rc = cinvb1dQUERYdam(sqlca, pCINVB1DInputRec, pCINVB1DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                // Victim Timestamp
                for (i377 = 0;i377 < pCINVB1DOutputRec.getArchOutputStruct().getUlRowQty();i377++) {
                    if (pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i377).getUlIdPerson() == pOutputMsg698.getUlIdVictim()) {
                        
                        pOutputMsg698.setTsSysTsLastUpdate4(pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i377).getTsLastUpdate());
                    }
                }
                
                // Perp Timestamp
                for (i377 = 0;i377 < pCINVB1DOutputRec.getArchOutputStruct().getUlRowQty();i377++) {
                    
                    if (pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i377).getUlIdPerson() == pOutputMsg698.getUlIdAllegedPerpetrator()) {
                        pOutputMsg698.setTsSysTsLastUpdate3(pCINVB1DOutputRec.getROWCINVB1DO_ARRAY().getROWCINVB1DO(i377).getTsLastUpdate());
                    }
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCINV07D(CINV47SI pInputMsg749, CINV47SO * pOutputMsg699, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV07DI pCINV07DInputRec = null;
        CINV07DO pCINV07DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV07DInputRec = new CINV07DI();
        
        pCINV07DOutputRec = new CINV07DO();
        pCINV07DInputRec.setArchInputStruct(pInputMsg749.getArchInputStruct());
        pCINV07DInputRec.setCdAllegDisposition(pInputMsg749.getCINV47SIG().getCdAllegDisposition());
        pCINV07DInputRec.setSzCdAllegIncidentStage(pInputMsg749.getCINV47SIG().getSzCdAllegIncidentStage());
        pCINV07DInputRec.setSzCdAllegSeverity(pInputMsg749.getCINV47SIG().getSzCdAllegSeverity());
        pCINV07DInputRec.setSzCdAllegType(pInputMsg749.getCINV47SIG().getSzCdAllegType());
        pCINV07DInputRec.setSzTxtAllegDuration(pInputMsg749.getCINV47SIG().getSzTxtAllegDuration());
        pCINV07DInputRec.setUlIdAllegation(pInputMsg749.getCINV47SIG().getUlIdAllegation());
        pCINV07DInputRec.setUlIdAllegedPerpetrator(pInputMsg749.getCINV47SIG().getUlIdAllegedPerpetrator());
        pCINV07DInputRec.setUlIdVictim(pInputMsg749.getCINV47SIG().getUlIdVictim());
        pCINV07DInputRec.setUlIdStage(pInputMsg749.getCINV47SIG().getUlIdStage());
        pCINV07DInputRec.setBIndFacilAllegCancelHist(pInputMsg749.getCINV47SIG().getBIndFacilAllegCancelHist());
        pCINV07DInputRec.setTsLastUpdate(pInputMsg749.getCINV47SIG().getTsLastUpdate());
        pCINV07DInputRec.setArchInputStruct(pInputMsg749.getArchInputStruct());
        
        /*
        ** Call CCMN29D
        */
        rc = cinv07dAUDdam(sqlca, pCINV07DInputRec, pCINV07DOutputRec);
        
        /*
        ** Analyze return code
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
        return rc;
    }

    static int CallCINVA4D(CINV47SI pInputMsg750, CINV47SO * pOutputMsg700, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINVA4DInputRec.setArchInputStruct(pInputMsg750.getArchInputStruct());
        pCINVA4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINVA4DInputRec.setUlIdStage(pInputMsg750.getCINV47SIG().getUlIdStage());
        pCINVA4DInputRec.setUlIdPerson(pInputMsg750.getCINV47SIG().getUlIdVictim());
        pCINVA4DInputRec.setSzCdStagePersRole(pInputMsg750.getCINV47SIG().getSzCdStagePersRole2());
        pCINVA4DInputRec.setTsLastUpdate(pInputMsg750.getCINV47SIG().getTsSysTsLastUpdate4());
        rc = cinva4dAUDdam(sqlca, pCINVA4DInputRec, pCINVA4DOutputRec);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                if ((pInputMsg750.getCINV47SIG().getUlIdAllegedPerpetrator() != pInputMsg750.getCINV47SIG().getUlIdVictim()) && (0 != pInputMsg750.getCINV47SIG().getUlIdAllegedPerpetrator())) {
                    pCINVA4DInputRec.setArchInputStruct(pInputMsg750.getArchInputStruct());
                    pCINVA4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCINVA4DInputRec.setUlIdStage(pInputMsg750.getCINV47SIG().getUlIdStage());
                    pCINVA4DInputRec.setUlIdPerson(pInputMsg750.getCINV47SIG().getUlIdAllegedPerpetrator());
                    pCINVA4DInputRec.setSzCdStagePersRole(pInputMsg750.getCINV47SIG().getSzCdStagePersRole());
                    pCINVA4DInputRec.setTsLastUpdate(pInputMsg750.getCINV47SIG().getTsSysTsLastUpdate3());
                    rc = cinva4dAUDdam(sqlca, pCINVA4DInputRec, pCINVA4DOutputRec);
                    
                    //  Analyze error code
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
                            
                            //  Call DAM
                            rc = Messages.MSG_CMN_UPDATE_FAILED;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    }
                }
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
        return rc;
    }

    static int CallCCMN62D(CINV47SI pInputMsg751, CINV47SO * pOutputMsg701, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMN62DInputRec.setUlIdEvent(pInputMsg751.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(TASK_STATUS_COMPLETE);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        /*
        ** Compare dates to determine if one is greater than the
        ** other
        ** SIR 20948 - Change '=' to '==' to allow for correct
        ** comparison of dates.
        */
        /*
        ** If year is greater
        */
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallBlankOverallDispositionAPS(CINV47SI pInputMsg752, CINV47SO * pOutputMsg702, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        
        pCINV44DInputRec.setUlIdStage(pInputMsg752.getCINV47SIG().getUlIdStage());
        
        
        /*
        ** Call CLSS90D
        */
        rc = cinv44dQUERYdam(sqlca, pCINV44DInputRec, pCINV44DOutputRec);
        
        if (rc != 0) 
        {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            return rc;
        }
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
        
        if (rc != 0) /*
        ** IMPACT END
        */
        {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallBlankOverallDispositionLIC(CINV47SI pInputMsg753, CINV47SO * pOutputMsg703, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
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
        pCINV74DInputRec.setUlIdStage(pInputMsg753.getCINV47SIG().getUlIdStage());
        rc = cinv74dQUERYdam(sqlca, pCINV74DInputRec, pCINV74DOutputRec);
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
        
        //## BEGIN TUX/XML: Declare XML variables 
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
        
        
        /*
        ** Call caudb2
        */
        rc = cinv53dAUDdam(sqlca, pCINV53DInputRec, pCINV53DOutputRec);
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallBlankOverallDispositionCPS(CINV47SI pInputMsg754, CINV47SO * pOutputMsg704, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINV95DInputRec.setUlIdStage(pInputMsg754.getCINV47SIG().getUlIdStage());
        
        
        /**************************************************************************
        ** Call DAM
        ***************************************************************************/
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
        pCINVA8DInputRec.setBIndCpsInvstSafetyPln(pCINV95DOutputRec.getBIndCpsInvstSafetyPln());
        pCINVA8DInputRec.setTsLastUpdate(pCINV95DOutputRec.getTsLastUpdate());
        pCINVA8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinva8dAUDdam(sqlca, pCINVA8DInputRec, pCINVA8DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            //  11788- we want edit checks for all service authorizations
            // that are not DAYCARE.
        }
        
        /* return ARC_SUCCESS because no Service Auth event types were
        ** found so the code can continue processing
        */
        return rc;
    }

    static int CallCCMNB6D(CINV47SI pInputMsg755, CCMNB6DO pCCMNB6DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMNB6DInputRec.setArchInputStruct(pInputMsg755.getArchInputStruct());
        pCCMNB6DInputRec.setUlIdStage(pInputMsg755.getCINV47SIG().getUlIdStage());
        
        /*
        ** Call CCMND3D
        */
        rc = ccmnb6dQUERYdam(sqlca, pCCMNB6DInputRec, pCCMNB6DOutputRec);
        
        /*
        ** Analyze error code
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

    
    static int CallCLSC68D(CINV47SI pInputMsg756, int ulIdCaseMergeTo5, CLSC68DO * pCLSC68DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCLSC68DInputRec.setArchInputStruct(pInputMsg756.getArchInputStruct());
        
        pCLSC68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC68DO._CLSC68DO__ROWCLSC68DO_SIZE);
        pCLSC68DInputRec.setUlIdCaseMergeTo(ulIdCaseMergeTo5);
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
