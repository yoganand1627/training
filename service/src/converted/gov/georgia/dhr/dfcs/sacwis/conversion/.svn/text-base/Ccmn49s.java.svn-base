package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN49SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN49SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD75DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS30DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CCMN49S.src
**
** Service Name:  CCMN49S
**
** Description:   This service is used to reopen Subcare and PostAdoption
**                stages that have been closed. The service performs some
**                validation that the stage should be reopened, puts NULL_DATE
**                in the appropriate closed date fields, and in the case of
**                SUBcare moves Service Authorizations created in the
**                Adoption stage to the Subcare stage.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  April 30, 1996
**
** Programmer:    Greg Dyar
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   22 Nov 1996 11:10:36  $
**                      $Modtime:   22 Nov 1996 10:22:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  5/3/96    DYARGR    Initial Check-in.
**
**  5/6/96    DYARGR    Modified assignment of Reopened Post-Adoption stage
**                      for unit/string test.
**  05/08/96  PHILLILH  SIR #20988 - Allow for no rows returned for a
**                      reopened PAD stage.  Set Severity to Success if
**                      no rows are found for a PAD stage.
**
**  5/8/96    DYARGR    SIR 21004 - Post a STG event, not ROP at reopen.
**  05/09/96  PHILLILH  SIR #21002 - Set bIndStagePersEmpNew to EMP_IS_NEW
**                      so that '1' is returned to Assigned Workload
**                      and the row will be shaded.
**
**  5/14/96   DYARGR    SIR 21142 - Add to ToDo's to be created when reopening
**                      the Subcare stage.
**
**  5/15/96   ZIMMERNE  SIR #21152 - Changed #define for EVENT_TYPE_STG from
**                      'STG' to 'ROP.'  This is the event type posted for
**                      the reopening event when PostEvent common function
**                      (ccmn01u) is called.
**
**  5/20/96   DYARGR    SIR 21283 -  Only post 1 event when multiple Svc
**                      Auths are found. Were posting an event for each
**                      detail record found.
**
**  5/22/96   DYARGR    SIR 21370 - Need to make sure we are finding the
**                      correct ADO stage. Added a new dam to determine
**                      this.
**
** 10/31/96   VANDERM   SIR 10700 - When reopening a closed subcare stage
**                      for converted or merged cases, the adoption stage
**                      may be closed.  For these unique instances, the
**                      re-opened subcare stage will assigned to the user
**                      who is re-opening the stage and not the primary
**                      worker of the adoption stage.
**
** 11/03/96   SISSONM   SIR 20925 -  ADD functionality to reopen Family
**                      Subcare amd Family Reunification
**                      via the Case Summary Reopen Stage MI.
**
** 11/15/96  VANDERM    SIR 10700 - Two open subcare stages for the same
**                      primary child are not allowed.  Added dam clss30d
**                      and additional logic to determine if there is an
**                      open SUB stage for the same primary child or the
**                      stage we are trying to reopen.  If there is a
**                      message box will indicate that the stage cannot be
**                      reopened and work should be done in the open stage.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCCESS)  { rc=FND_SUCCESS; }
**
**   1/27/03   DWW      When MSG_ROP_SUB_OPEN set because open SUB exists,
**                      rc also set to RetVal so that exception will be
**                      thrown at end of processing
**
**  04/30/03   Srini    SIR 17091: Added the error handling to take care of
**                      full table scans for ccmn87dQUERYdam.
**
**  10/21/03   RIOSJA   SIR 19988 - Added more error handling so that service
**                      will return any errors it encounters.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn49s {
    
    public static final String SUBCARE = "SUB";
    public static final String POST_ADOPT = "PAD";
    
    /* SIR 20465 */
    public static final String ADOPTION = "ADO";
    
    public static final String SUB_EVENT_TXT_DESCRIPTION = "Subcare stage has been reopened";
    public static final String PAD_EVENT_TXT_DESCRIPTION = "PostAdoption stage has been reopened";
    
    public static final String FSU_EVENT_TXT_DESCRIPTION = "Family Subcare stage has been reopened";
    public static final String FRE_EVENT_TXT_DESCRIPTION = "Family Reunification stage has been reopened";
    
    
    public static final String STATUS_ACTIVE = "A";
    
    /*
    ** Declare FOUNDATION variables 
    */
    
    /*
    ** Case File Management Specific Variables
    */
    public static final String PRIMARY_WORKER = "PR";
    public static final String PRIMARY_CHILD = "PC";
    public static final String STAFF = "STF";
    
    public static final String ADOPTION_DISRUPT = "500";
    public static final String STATUS_APPROVED = "APRV";
    public static final String SUB_SVC_AUTH = "3020";
    public static final String ADO_SVC_AUTH = "8530";
    public static final String SERVICE_AUTH_TYPE = "AUT";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_TYPE_STG = "ROP";
    
    /** SIR 1847 **/
    public static final int INITIAL_PAGE = 1;
    
    public static final String SUB_CLOSURE = "3270";
    public static final String PAD_CLOSURE = "9260";
    public static final String FSU_CLOSURE = "4110";
    public static final String FRE_CLOSURE = "5560";
    public static final String FAM_SUBCARE_STAGE = "FSU";
    public static final String FAM_REUNIF_STAGE = "FRE";
    
    public static final String SUB_TODO_1 = "SUB001";
    
    /* SIR 21142 */
    public static final String SUB_TODO_2 = "SUB046";
    public static final String SUB_TODO_3 = "SUB047";
    
    /* SIR #21002 */
    public static final char EMP_IS_NEW = '1';
    CCMN49SO CCMN49S(CCMN49SI ccmn49si) {
        CCMN49SO ccmn49so = new CCMN49SO();
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
        int RetVal = SUCCESS;
        
        
        
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        
        CAUD47DI pCAUD47DInputRec = null;
        CAUD47DO pCAUD47DOutputRec = null;
        
        CCMN46DI pCCMN46DInputRec = null;
        CCMN46DO pCCMN46DOutputRec = null;
        
        
        CMSC18DI pCMSC18DInputRec = null;
        CMSC18DO pCMSC18DOutputRec = null;
        
        CMSC17DI pCMSC17DInputRec = null;
        CMSC17DO pCMSC17DOutputRec = null;
        
        
        CCMNB9DI pCCMNB9DInputRec = null;
        CCMNB9DO pCCMNB9DOutputRec = null;
        
        
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        
        CSES24DI pCSES24DInputRec = null;
        CSES24DO pCSES24DOutputRec = null;
        
        CLSS24DI pCLSS24DInputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;
        
        CAUD34DI pCAUD34DInputRec = null;
        CAUD34DO pCAUD34DOutputRec = null;
        
        CCMND2DI pCCMND2DInputRec = null;
        CCMND2DO pCCMND2DOutputRec = null;
        
        CCMN68DI pCCMN68DInputRec = null;
        CCMN68DO pCCMN68DOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* PostEvent common function */
        
        CCMN01UO pCCMN01UOutputRec = null;
        
        CAUD74DI pCAUD74DInputRec = null;
        CAUD74DO pCAUD74DOutputRec = null;
        
        CSES34DI pCSES34DInputRec = null;
        CSES34DO pCSES34DOutputRec = null;/*SIR#2142*/
        
        CLSC73DI pCLSC73DInputRec = null;
        CLSC73DO pCLSC73DOutputRec = null;
        
        CCMND3DI pCCMND3DInputRec = null;
        CCMND3DO pCCMND3DOutputRec = null;
        
        CAUD75DI pCAUD75DInputRec = null;
        CAUD75DO pCAUD75DOutputRec = null;
        
        CSES56DI pCSES56DInputRec = null;
        CSES56DO pCSES56DOutputRec = null;
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CSUB40UI pCSUB40UInputRec = null;
        CSUB40UO pCSUB40UOutputRec = null;
        
        CMSC19DI pCMSC19DInputRec = null;
        CMSC19DO pCMSC19DOutputRec = null;
        
        /*
        ** SIR 21370
        */
        CSEC29DI pCSEC29DInputRec = null;
        CSEC29DO pCSEC29DOutputRec = null;
        
        /*
        ** SIR 10700
        */
        CLSS30DI pCLSS30DInputRec = null;
        CLSS30DO pCLSS30DOutputRec = null;
        
        /*
        ** Other locals
        */
        FndInt3date dtDtNull = null;
        FndInt3date dtCurrentDate = null;
        FndInt3date dtDtMaxDate = null;
        
        int ulIdPrimWorker = 0;
        int ulIdSubWorker = 0;
        int ulIdSubLink = 0;
        int ulIdPADWorker = 0;
        int ulIdPADLink = 0;
        int ulIdAdoptionStage = 0;
        int ulIdPrimaryChild = 0;
        int ulIdSituation2 = 0;
        
        int bSvcAuthAlreadyExists = 0;
        int bDeleteHP = 0;
        int n = 0;
        int i170 = 0;
        int j = 0;
        int m = 0;
        
        /*
        ** Initialize locals
        */
        dtDtNull.day = DateHelper.NULL_DATE;
        dtDtNull.month = DateHelper.NULL_DATE;
        dtDtNull.year = DateHelper.NULL_DATE;
        
        dtCurrentDate.day = DateHelper.NULL_DATE;
        dtCurrentDate.month = DateHelper.NULL_DATE;
        dtCurrentDate.year = DateHelper.NULL_DATE;
        
        dtDtMaxDate.day = Arcutls.ARC_UTL_MAX_DAY;
        dtDtMaxDate.month = Arcutls.ARC_UTL_MAX_MONTH;
        dtDtMaxDate.year = Arcutls.ARC_UTL_MAX_YEAR;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn49si.getArchInputStruct());
        
        rc = ARC_UTLGetDateAndTime(dtCurrentDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        pCINT40DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        //    if (pParserData->bInScope){
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                RetVal = SUCCESS;
                ulIdSituation2 = pCINT40DOutputRec.getUlIdSituation();
                
                // 
                // Begin CAUD47D Reopen Stage
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCAUD47DInputRec = new CAUD47DI();
                
                pCAUD47DOutputRec = new CAUD47DO();
                
                pCAUD47DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCAUD47DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                pCAUD47DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                pCAUD47DInputRec.setDtDtStageClose(dtDtNull);
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pCAUD47DInputRec.setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
                rc = caud47dAUDdam(sqlca, pCAUD47DInputRec, pCAUD47DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        
                        //  Message explanation code
                        // already has appropriate
                        // error handling mechanism
                        
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        if (SUCCESS == RetVal) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_STG);
            // 
            // (END): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
            // 
            
            if (0 == SUBCARE.compareTo(ccmn49si.getSzCdStage())) {
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(SUB_EVENT_TXT_DESCRIPTION);
            }
            else if (0 == FAM_SUBCARE_STAGE.compareTo(ccmn49si.getSzCdStage())) {
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(FSU_EVENT_TXT_DESCRIPTION);
            }
            else if (0 == FAM_REUNIF_STAGE.compareTo(ccmn49si.getSzCdStage())) {
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(FRE_EVENT_TXT_DESCRIPTION);
            }
            else {
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(PAD_EVENT_TXT_DESCRIPTION);
            }
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccmn49si.getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(dtCurrentDate);
            
            
            
            //  Start Performance Timer
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    RetVal = SUCCESS;
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
                    
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if ((SUCCESS == RetVal) && (0 == POST_ADOPT.compareTo(ccmn49si.getSzCdStage()))) {
            //  Allocate memory for DAM Input and Output Structures
            pCMSC18DInputRec = new CMSC18DI();
            
            pCMSC18DOutputRec = new CMSC18DO();
            pCMSC18DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
            pCMSC18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCMSC18DInputRec.setUlIdCase(ccmn49si.getUlIdCase());
            pCMSC18DInputRec.setDtDtCaseClosed(dtDtNull);
            rc = cmsc18dAUDdam(sqlca, pCMSC18DInputRec, pCMSC18DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // 
                    // Begin Situation Reopen
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC17DInputRec = new CMSC17DI();
                    
                    pCMSC17DOutputRec = new CMSC17DO();
                    pCMSC17DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                    pCMSC17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCMSC17DInputRec.setUlIdSituation(ulIdSituation2);
                    pCMSC17DInputRec.setDtDtSituationClosed(dtDtNull);
                    rc = cmsc17dAUDdam(sqlca, pCMSC17DInputRec, pCMSC17DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Now assign this PostAdoption stage to the person
                            // who is reopening (should be a supervisor).
                            //  We need to determine who the HP for the PAD case
                            // is as they may be the same person reopening the
                            // PAD case and we need to UPDATE, not ADD the Stage
                            // Person Link row in that case
                            //  Allocate memory for DAM Input and Output Structures
                            pCCMNB9DInputRec = new CCMNB9DI();
                            
                            pCCMNB9DOutputRec = new CCMNB9DO();
                            pCCMNB9DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                            pCCMNB9DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                            
                            pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                            pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
                            
                            
                            //  Call CLSC10D
                            rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Loop through all rows returned looking for the
                                    // people that are not staff. For each row retrieved
                                    // that is not a staff person, make that person
                                    // active again.
                                    
                                    for (i170 = 0;i170 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                                        if (0 == STAFF.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getSzCdStagePersType())) {
                                            
                                            ulIdPADWorker = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdPerson();
                                            ulIdPADLink = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdStagePerson();
                                        }
                                    }
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
                            
                            // 
                            // End Retrieve of HP for PAD stage
                            // 
                            // 
                            // Begin Staff AUD Dam
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCCMND3DInputRec = new CCMND3DI();
                            
                            pCCMND3DOutputRec = new CCMND3DO();
                            pCCMND3DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                            if (ulIdPADWorker == ccmn49si.getUlIdPerson()) {
                                pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                pCCMND3DInputRec.setUlIdStagePerson(ulIdPADLink);
                            }
                            
                            else {
                                pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                
                                bDeleteHP = 1;
                            }
                            pCCMND3DInputRec.setSzCdStagePersRole(PRIMARY_WORKER);
                            pCCMND3DInputRec.setSzCdStagePersType(STAFF);
                            pCCMND3DInputRec.setBIndStagePersEmpNew(EMP_IS_NEW);
                            pCCMND3DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                            pCCMND3DInputRec.setUlIdPerson(ccmn49si.getUlIdPerson());
                            pCCMND3DInputRec.setDtDtStagePersLink(dtCurrentDate);
                            rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    if (bDeleteHP) {
                                        // 
                                        // Begin CMSC19D
                                        // 
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCMSC19DInputRec = new CMSC19DI();
                                        
                                        pCMSC19DOutputRec = new CMSC19DO();
                                        pCMSC19DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                        pCMSC19DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                                        pCMSC19DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                                        rc = cmsc19dAUDdam(sqlca, pCMSC19DInputRec, pCMSC19DOutputRec);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                
                                                RetVal = Csub50s.FND_FAIL;
                                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                    }
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
                            
                            
                            
                            
                            // 
                            // End Staff AUD Dam
                            // 
                            
                            
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
            //  If the dam call is successful and the stage returned is
            // ADO (Adoption) and the DtStageClosed != NULL_DATE then
            // use IdStage as Input to obtain staff for that Stage.
            if (SUCCESS == RetVal) {
                
                //  Allocate memory for DAM Input and Output Structures
                pCSES56DInputRec = new CSES56DI();
                
                pCSES56DOutputRec = new CSES56DO();
                pCSES56DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCSES56DInputRec.setUlIdCase(ccmn49si.getUlIdCase());
                
                
                //  Call CLSS08D
                rc = cses56dQUERYdam(sqlca, pCSES56DInputRec, pCSES56DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD75DInputRec = new CAUD75DI();
                        
                        pCAUD75DOutputRec = new CAUD75DO();
                        pCAUD75DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                        pCAUD75DInputRec.setTsLastUpdate(pCSES56DOutputRec.getTsLastUpdate());
                        pCAUD75DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                        pCAUD75DInputRec.setUlIdCase(ccmn49si.getUlIdCase());
                        
                        
                        //  Set rc to ARC_SUCCESS
                        rc = caud75dAUDdam(sqlca, pCAUD75DInputRec, pCAUD75DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                RetVal = SUCCESS;
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                
                                RetVal = Csub50s.FND_FAIL;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Set rc to ARC_SUCCESS
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                        
                }
                
                //  Retreive all non-staff persons associated with the
                // case and make them active, as they had been marked
                // inactive
                
                //  Allocate memory for DAM Input and Output Structures
                pCCMNB9DInputRec = new CCMNB9DI();
                
                pCCMNB9DOutputRec = new CCMNB9DO();
                pCCMNB9DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCCMNB9DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
                rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Loop through all rows returned looking for the
                        // people that are not staff. For each row retrieved
                        // that is not a staff person, make that person
                        // active again.
                        
                        for (i170 = 0;i170 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                            if (0 != STAFF.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getSzCdStagePersType())) {
                                // 
                                // Begin update person status dam
                                // 
                                //  Allocate memory for Input and Output Structures
                                pCAUD74DInputRec = new CAUD74DI();
                                
                                pCAUD74DOutputRec = new CAUD74DO();
                                pCAUD74DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                pCAUD74DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                pCAUD74DInputRec.setUlIdPerson(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdPerson());
                                pCAUD74DInputRec.setCdPersonStatus(STATUS_ACTIVE);
                                
                                //  Declare FOUNDATION variables
                                
                                //  Declare local variables
                                
                                //  Start performance timer for service. All performance functions always
                                // return success so there is no need to check status.
                                rc = caud74dAUDdam(sqlca, pCAUD74DInputRec, pCAUD74DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        
                                        // SIR 21891 - missing versioning
                                        //  Run-time Versioning
                                        
                                        //  Check buffer size
                                        
                                        //  Process error message and return to client
                                        
                                        //  Initialize output message and length
                                        
                                        //  Initialize service status fields
                                        
                                        // 
                                        // Call DAMs to retrieve data
                                        // 
                                        
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                }
                            }
                        }
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
        }
        if ((SUCCESS == RetVal) && (0 == SUBCARE.compareTo(ccmn49si.getSzCdStage()))) {
            
            //  SIR 21370
            // Find the PC of the current SUB stage first
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMNB9DInputRec = new CCMNB9DI();
            
            pCCMNB9DOutputRec = new CCMNB9DO();
            pCCMNB9DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
            pCCMNB9DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
            pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
            rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Loop through all rows returned looking for the
                    // people that are not staff. For each row retrieved
                    // that is not a staff person, make that person
                    // active again.
                    
                    for (i170 = 0;i170 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty() && 0 == ulIdPrimaryChild;i170++) {
                        
                        if (0 == PRIMARY_CHILD.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getSzCdStagePersRole())) {
                            
                            ulIdPrimaryChild = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdPerson();
                        }
                        
                    }
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
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
            
            
            // 
            // End find the PC of the SUB
            // 
            //  SIR 10700
            // Now find all SUB stages associated with the case that are open
            // and have the same the primary child of the SUB stage that is
            // being reopened.
            // 
            // Begin find SUB stage SIR 10700
            // 
            //  Call to the pCLSS30D dam select stages given case id.
            //  Allocate memory for Output Structure
            pCLSS30DOutputRec = new CLSS30DO();
            
            //  Allocate memory for Input Structure
            pCLSS30DInputRec = new CLSS30DI();
            
            pCLSS30DInputRec.setUlIdCase(ccmn49si.getUlIdCase());
            
            pCLSS30DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
            pCLSS30DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCLSS30DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS30DO._CLSS30DO__ROWCLSS30DO_SIZE);
            rc = clss30dQUERYdam(sqlca, pCLSS30DInputRec, pCLSS30DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    RetVal = SUCCESS;
                    
                    //  Loop through all the stages returned looking for all SUB stage
                    // that are not closed and not equal to the SUB stage being
                    // reopened.
                    
                    for (i170 = 0;i170 < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                        if ((0 == SUBCARE.compareTo(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i170).getSzCdStage())) && (DateHelper.NULL_DATE == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i170).getDtDtStageClose().day) && (DateHelper.NULL_DATE == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i170).getDtDtStageClose().month) && (DateHelper.NULL_DATE == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i170).getDtDtStageClose().year) && (pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i170).getUlIdStage() != ccmn49si.getUlIdStage())) {
                            //  if an open SUB stage is found that is not the SUB stage
                            // being reopened then call CCMNB9D to find the primary child
                            // of that stage.
                            
                            // 
                            // Find the PC of the SUB
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCCMNB9DInputRec = new CCMNB9DI();
                            
                            pCCMNB9DOutputRec = new CCMNB9DO();
                            pCCMNB9DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                            
                            //## BEGIN TUX/XML: Declare XML variables 
                            pCCMNB9DInputRec.setUlIdStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i170).getUlIdStage());
                            pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                            pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
                            rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    
                                    //  Loop through all rows returned looking for the
                                    // primary child. If that primary child is the same
                                    // as the primary child of the stage to be opened
                                    // display a message and return to calling window.
                                    
                                    for (j = 0;j < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                        if (0 == PRIMARY_CHILD.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(j).getSzCdStagePersRole()) && (ulIdPrimaryChild == pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(j).getUlIdPerson())) {
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_ROP_SUB_OPEN;
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                            rc = Csub50s.FND_FAIL;
                                        }
                                    }
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
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
            if (SUCCESS == RetVal) {
                
                //  Allocate memory for DAM Input and Output Structures
                pCSEC29DInputRec = new CSEC29DI();
                
                pCSEC29DOutputRec = new CSEC29DO();
                pCSEC29DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCSEC29DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                pCSEC29DInputRec.setUlIdCase(ccmn49si.getUlIdCase());
                pCSEC29DInputRec.setUlIdPerson(ulIdPrimaryChild);
                pCSEC29DInputRec.setSzCdStage(ADOPTION);
                pCSEC29DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                
                //  Call CLSC48D
                rc = csec29dQUERYdam(sqlca, pCSEC29DInputRec, pCSEC29DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        
                        //  Populate Output Message
                        
                        
                        ulIdAdoptionStage = pCSEC29DOutputRec.getUlIdStage();
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_ROP_NO_DISRUPT;
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            // 
            // (END): Retrieve DAM: csec30d      Adoption_subsidy simple retrieve
            // 
            
            //  SIR #4280 - Added "&& pInputMsg->CSUB26SIG00.ulIdRsrcFacil is not NULL"
            // to the following if statement.  This prevents calling CRES04D when the
            // placement type is Non-Certified Person and no resource id exists.
            
            if (SUCCESS == RetVal) {
                
                //  Allocate memory for DAM Input and Output Structures
                pCCMNB9DInputRec = new CCMNB9DI();
                
                pCCMNB9DOutputRec = new CCMNB9DO();
                pCCMNB9DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCCMNB9DInputRec.setUlIdStage(ulIdAdoptionStage);
                pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
                
                //  Call CSUB40U
                rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  SIR 10700
                        // If the adoption stage is closed a primary worker will
                        // not be returned from the dam.  If a primary worker
                        // is not found the worker reopening the stage will
                        // be assigned as the primary worker.  The primary worker
                        // is set equal to the user prior to looping through the
                        // the output of the dam.  If a primary worker is not
                        // found then the user will remain the primary worker of
                        // the re-opened subcare stage.
                        
                        ulIdPrimWorker = ccmn49si.getUlIdPerson();
                        
                        //  Loop through all rows returned looking for the
                        // primary worker of the adoption stage.
                        //  SIR 21370
                        // Removed if to look for Primary Child, we already
                        // know it
                        
                        for (i170 = 0;i170 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                            if ((0 == STAFF.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getSzCdStagePersType())) && (0 == PRIMARY_WORKER.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getSzCdStagePersRole()))) {
                                
                                ulIdPrimWorker = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdPerson();
                            }
                        }
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        pCCMNB9DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                        pCCMNB9DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                        pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                        pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
                        
                        //  Set rc to ARC_SUCCESS
                        rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Loop through all rows returned looking for the
                                // people that are not staff. For each row retrieved
                                // that is not a staff person, make that person
                                // active again.
                                
                                for (i170 = 0;i170 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                                    if (0 == STAFF.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getSzCdStagePersType())) {
                                        
                                        ulIdSubWorker = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdPerson();
                                        ulIdSubLink = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdStagePerson();
                                        
                                    }
                                }
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
                        
                        
                        
                        
                        // 
                        // End Retrieve of HP for Subcare stage
                        // 
                        
                        // 
                        // Begin Staff AUD
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMND3DInputRec = new CCMND3DI();
                        
                        pCCMND3DOutputRec = new CCMND3DO();
                        pCCMND3DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                        if (ulIdSubWorker == ulIdPrimWorker) {
                            pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            pCCMND3DInputRec.setUlIdStagePerson(ulIdSubLink);
                        }
                        
                        else {
                            pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            
                            bDeleteHP = 1;
                        }
                        pCCMND3DInputRec.setSzCdStagePersRole(PRIMARY_WORKER);
                        pCCMND3DInputRec.setSzCdStagePersType(STAFF);
                        pCCMND3DInputRec.setBIndStagePersEmpNew(EMP_IS_NEW);
                        //   PROCESS_TUX_SQL_ERROR_NOFREE is called only when there is an unexpected
                        // SQL error returned from the DAM.
                        pCCMND3DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        pCCMND3DInputRec.setUlIdPerson(ulIdPrimWorker);
                        pCCMND3DInputRec.setDtDtStagePersLink(dtCurrentDate);
                        
                        //  Call DAM
                        rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                if (bDeleteHP) {
                                    // 
                                    // Begin CMSC19D
                                    // 
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCMSC19DInputRec = new CMSC19DI();
                                    
                                    pCMSC19DOutputRec = new CMSC19DO();
                                    pCMSC19DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                    pCMSC19DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                                    pCMSC19DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                                    rc = cmsc19dAUDdam(sqlca, pCMSC19DInputRec, pCMSC19DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                }
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
            
            //  Get the FAD Home recruiter
            // If szCdRsrcRegion is NOT 99 (State Office: CAPS_UNIT_STATE_OFFICE)
            if (SUCCESS == RetVal) {
                //  Allocate memory for DAM Input and Output Structures
                pCSES34DInputRec = new CSES34DI();
                
                pCSES34DOutputRec = new CSES34DO();
                pCSES34DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCSES34DInputRec.setUlIdPlcmtChild(ulIdPrimaryChild);
                
                //  Start Performance Timer
                rc = cses34dQUERYdam(sqlca, pCSES34DInputRec, pCSES34DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        if ((DateHelper.NULL_DATE != pCSES34DOutputRec.getDtDtPlcmtEnd().day) && (Arcutls.ARC_UTL_MAX_YEAR != pCSES34DOutputRec.getDtDtPlcmtEnd().year) && (0 == ADOPTION_DISRUPT.compareTo(pCSES34DOutputRec.getSzCdPlcmtRemovalRsn()))) {
                            RetVal = SUCCESS;
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                        }
                        
                        
                        else {
                            RetVal = Csub50s.FND_FAIL;
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_ROP_NO_DISRUPT;
                        }
                        break;
                    case NO_DATA_FOUND:
                        
                        RetVal = Csub50s.FND_FAIL;
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_ROP_NO_DISRUPT;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if (SUCCESS == RetVal) {
                
                //  Allocate memory for DAM Input and Output Structures
                pCCMN87DInputRec = new CCMN87DI();
                
                pCCMN87DOutputRec = new CCMN87DO();
                pCCMN87DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
                pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                pCCMN87DInputRec.setUlIdStage(ulIdAdoptionStage);
                pCCMN87DInputRec.setSzCdTask(ADO_SVC_AUTH);
                pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SERVICE_AUTH_TYPE);
                rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
                switch (rc) 
                {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Populate Output Message
                        for (i170 = 0;i170 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                            
                            //  Check szCdRsrcRegion and convert it to szCdUnitRegion.
                            // This is done since Region is only 2 characters long on the
                            // caps_resource table and Region is 3 characters long on the unit table.
                            // The choices for szCdRsrcRegion are:  00 thru 11, and 99.
                            // 1) If the szCdRsrcRegion is 99 (State Office: CAPS_UNIT_STATE_OFFICE),
                            // then this dam would not be called (see the if prior to the line:
                            // "(BEGIN): Retrieve DAM: csec37d  Find employee with skill retrieve").
                            // 2) If the szCdRsrcRegion is 00 (2-digit Statewide intake: CAPS_UNIT_SWI),
                            // then set szCdUnitRegion to 515 (Statewide Intake: CAPS_REGION_SWI).
                            // 3) If the szCdRsrcRegion is 01 thru 11 (2-digit Regions),
                            // then the szCdUnitRegion should be prefaced with a '0': 001 thru 011.
                            // Copy '0' into the 1st digit of pCSEC37DInputRec->szCdUnitRegion
                            // Then copy the 1st digit of pCRES04DOutputRec->szCdRsrcRegion
                            // into the 2nd digit of pCSEC37DInputRec->szCdUnitRegion
                            // Then copy the 2nd digit of pCRES04DOutputRec->szCdRsrcRegion
                            // into the 3rd digit of pCSEC37DInputRec->szCdUnitRegion
                            if (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getSzCdEventStatus().compareTo(STATUS_APPROVED)) {
                                // 
                                // (END): Retrieve DAM: cses38d      Eligibility simple retrieve
                                // 
                                
                                //  SIR 23223 - if the placement is not a new one or a removal, check to see
                                // if the  resource was changed.  If it is, update open slots on both the
                                // old and new resources.  If the placement end date has already been
                                // entered, don't update open slots.
                                if (0 == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getSzCdEventType().compareTo(SERVICE_AUTH_TYPE)) {
                                    // 
                                    // BEGIN CSES24D
                                    // 
                                    //  Allocate memory for Input and Output Structures
                                    pCSES24DInputRec = new CSES24DI();
                                    
                                    pCSES24DOutputRec = new CSES24DO();
                                    pCSES24DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                    pCSES24DInputRec.setUlIdSvcAuthEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getUlIdEvent());
                                    rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
                                    
                                    
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            //  Use CLSC73d to make sure the Approved SvcAuth does not
                                            // already exist in the Subcare stage, if it does, don't
                                            // copy it back
                                            
                                            // 
                                            // Begin CLSC73D SvcAuthEventLink counter
                                            // 
                                            //  Allocate memory for Input and Output Structures
                                            pCLSC73DInputRec = new CLSC73DI();
                                            
                                            pCLSC73DOutputRec = new CLSC73DO();
                                            pCLSC73DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                            pCLSC73DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                            pCLSC73DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC73DO._CLSC73DO__ROWCLSC73DO_SIZE);
                                            pCLSC73DInputRec.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                                            
                                            
                                            //  Call CAUD01D.  This DAM AUDs a row on the contract table
                                            // based on the contract Id and the time stamp.
                                            rc = clsc73dQUERYdam(sqlca, pCLSC73DInputRec, pCLSC73DOutputRec);
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    // 
                                                    // first do the new resource
                                                    // 
                                                    if (pCLSC73DOutputRec.getArchOutputStruct().getUlRowQty() > 1) {
                                                        bSvcAuthAlreadyExists = 1;
                                                    }
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            }
                                            
                                            // SIR 14053 added the condition to only do this for F/A Homes
                                            if (!bSvcAuthAlreadyExists) {
                                                // 
                                                // BEGIN CSES23D
                                                // 
                                                //  Allocate memory for Input and Output Structures
                                                pCSES23DInputRec = new CSES23DI();
                                                
                                                pCSES23DOutputRec = new CSES23DO();
                                                pCSES23DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                                pCSES23DInputRec.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                                                rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
                                                
                                                //  Analyze error code
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        
                                                        // 
                                                        // second do the old resource
                                                        // 
                                                        if (FND_YES == pCSES23DOutputRec.getCIndSvcAuthComplete()) {
                                                            
                                                            //  Allocate memory for Input and Output Structures
                                                            pCLSS24DInputRec = new CLSS24DI();
                                                            
                                                            pCLSS24DOutputRec = new CLSS24DO();
                                                            pCLSS24DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                                            pCLSS24DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                                            pCLSS24DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE);
                                                            pCLSS24DInputRec.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                                                            rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    for (m = 0;m < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();m++) {
                                                                        
                                                                        // SIR 14053 added the condition to only do this for F/A Homes
                                                                        if ((ARC_UTLCompareDateAndTime((FndInt3date) & dtCurrentDate, 0, (FndInt3date) & pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getDtDtSvcAuthDtlTerm() , 0)) < 0) {
                                                                            //  Create a new event and finish copying the SvcAuth to
                                                                            // the Subcare stage
                                                                            // 
                                                                            // Create the new SvcAuth Event
                                                                            // 
                                                                            //  Allocate memory for Input and Output Structures
                                                                            pCCMN46DInputRec = new CCMN46DI();
                                                                            
                                                                            pCCMN46DOutputRec = new CCMN46DO();
                                                                            pCCMN46DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                                                            pCCMN46DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                                            pCCMN46DInputRec.setSzCdEventType(SERVICE_AUTH_TYPE);
                                                                            pCCMN46DInputRec.setDtDtEventOccurred(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getDtDtEventOccurred());
                                                                            pCCMN46DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
                                                                            pCCMN46DInputRec.setSzTxtEventDescr(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getSzTxtEventDescr());
                                                                            pCCMN46DInputRec.setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getSzCdEventStatus());
                                                                            pCCMN46DInputRec.setSzCdTask(SUB_SVC_AUTH);
                                                                            
                                                                            //  Call CSEC03D.  This DAM will retrieve all rows from the contract
                                                                            // table, the resource Id and resource name from the CAPS resource
                                                                            // table, the name from the Person table, and the Id
                                                                            // resource address from the resource address table
                                                                            // related to the contract Id passed.
                                                                            rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
                                                                            
                                                                            //  Analyze return code
                                                                            switch (rc) {
                                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                                    
                                                                                    // 
                                                                                    // Begin create the new SvcAuthEventLink record
                                                                                    // 
                                                                                    //  Allocate memory for Input and Output Structures
                                                                                    pCAUD34DInputRec = new CAUD34DI();
                                                                                    
                                                                                    pCAUD34DOutputRec = new CAUD34DO();
                                                                                    pCAUD34DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                                                                    pCAUD34DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                                                    pCAUD34DInputRec.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                                                                                    pCAUD34DInputRec.setUlIdSvcAuthEvent(pCCMN46DOutputRec.getUlIdEvent());
                                                                                    rc = caud34dAUDdam(sqlca, pCAUD34DInputRec, pCAUD34DOutputRec);
                                                                                    
                                                                                    //  Analyze return code
                                                                                    switch (rc) {
                                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                                            //  Now update the Event Person link row
                                                                                            // 
                                                                                            // Begin retrieve old event person link data
                                                                                            // 
                                                                                            //  Allocate memory for Input and Output Structures
                                                                                            pCCMND2DInputRec = new CCMND2DI();
                                                                                            
                                                                                            pCCMND2DOutputRec = new CCMND2DO();
                                                                                            
                                                                                            pCCMND2DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                                                                            
                                                                                            pCCMND2DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                                                                            
                                                                                            pCCMND2DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMND2DO._CCMND2DO__ROWCCMND2DO_SIZE);
                                                                                            pCCMND2DInputRec.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getUlIdEvent());
                                                                                            rc = ccmnd2dQUERYdam(sqlca, pCCMND2DInputRec, pCCMND2DOutputRec);
                                                                                            switch (rc) {
                                                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                                                    ccmn49so.getArchOutputStruct().setUlRowQty(pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty());
                                                                                                    
                                                                                                    //  For each row retrieved, create a new row with the newly
                                                                                                    // created event info
                                                                                                    for (n = 0;n < pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty();n++) {
                                                                                                        //  Populate output message
                                                                                                        // 
                                                                                                        // Begin create new Event Person Link row
                                                                                                        // 
                                                                                                        //  Allocate memory for Input and Output Structures
                                                                                                        pCCMN68DInputRec = new CCMN68DI();
                                                                                                        
                                                                                                        pCCMN68DOutputRec = new CCMN68DO();
                                                                                                        pCCMN68DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                                                                                        
                                                                                                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                                                                                        pCCMN68DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                                                                        pCCMN68DInputRec.setUlIdEvent(pCCMN46DOutputRec.getUlIdEvent());
                                                                                                        pCCMN68DInputRec.setUlIdPerson(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(n).getUlIdPerson());
                                                                                                        
                                                                                                        //  Call CLSC06D.  This DAM will retrieve all VID/Address records
                                                                                                        // that exist for a particular resource ID.  No rows found will
                                                                                                        // result in a successful return.
                                                                                                        rc = ccmn68dAUDdam(sqlca, pCCMN68DInputRec, pCCMN68DOutputRec);
                                                                                                        switch (rc) {
                                                                                                                
                                                                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                                                                //  Do nothing on success
                                                                                                                
                                                                                                                RetVal = SUCCESS;
                                                                                                                break;
                                                                                                                
                                                                                                                
                                                                                                            default :
                                                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                                        }
                                                                                                    }
                                                                                                    break;
                                                                                                    
                                                                                                default :
                                                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                            }
                                                                                            
                                                                                            
                                                                                            // 
                                                                                            // End retrieve old event person link data
                                                                                            // 
                                                                                            
                                                                                            
                                                                                            
                                                                                            RetVal = SUCCESS;
                                                                                            break;
                                                                                            
                                                                                            // 
                                                                                            // End create new Event Person Link row
                                                                                            // 
                                                                                            
                                                                                            
                                                                                            
                                                                                            
                                                                                        default :
                                                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                    }
                                                                                    break;
                                                                                    
                                                                                default :
                                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                            }
                                                                        }
                                                                        break;
                                                                        
                                                                    }
                                                                    break;
                                                                    
                                                                    
                                                                    // 
                                                                    // End Create the new SvcAuthEventLink record
                                                                    // 
                                                                    
                                                                default :
                                                                    RetVal = Csub50s.FND_FAIL;
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            }
                                                        }
                                                        break;
                                                        
                                                        
                                                    default :
                                                        
                                                        RetVal = Csub50s.FND_FAIL;
                                                        
                                                        // 
                                                        // Function Prototypes
                                                        // 
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                }
                                            }
                                            
                                            //  Set rc to ARC_SUCCESS
                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                            break;
                                            
                                            
                                            
                                            // 
                                            // END CLSS24D
                                            // 
                                            
                                            
                                            
                                        default :
                                            RetVal = Csub50s.FND_FAIL;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    }
                                }
                                
                            }
                        }
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Set rc to ARC_SUCCESS
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        
                        RetVal = SUCCESS;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            //  SIR#3582: Call DAM if Elig Worker has not been retrieved and
            // there is a mismatch between Facility and Child's LOC
            if (SUCCESS == RetVal) {
                
                //  Allocate memory for DAM Input and Output Structures
                pCSUB40UInputRec = new CSUB40UI();
                
                pCSUB40UOutputRec = new CSUB40UO();
                
                pCSUB40UInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCSUB40UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(SUB_TODO_1);
                
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ulIdPrimWorker);
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn49si.getUlIdStage());
                pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtCurrentDate);
                rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
                pCSUB40UInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCSUB40UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(SUB_TODO_2);
                
                // SIR#2085
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ulIdPrimWorker);
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn49si.getUlIdStage());
                pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtCurrentDate);
                rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
                
                // SIR #3885
                pCSUB40UInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                pCSUB40UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(SUB_TODO_3);
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ulIdPrimWorker);
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn49si.getUlIdStage());
                pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtCurrentDate);
                rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        break;
                        // 
                        // (END): Retrieve DAM: ccmn44d     
                        // Get NmPersonFull given IdPerson
                        // 
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        if ((SUCCESS == RetVal) && ((0 == FAM_SUBCARE_STAGE.compareTo(ccmn49si.getSzCdStage())) || (0 == FAM_REUNIF_STAGE.compareTo(ccmn49si.getSzCdStage())))) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMNB9DInputRec = new CCMNB9DI();
            
            pCCMNB9DOutputRec = new CCMNB9DO();
            pCCMNB9DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
            pCCMNB9DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
            pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
            
            //  Start Performance Timer
            rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Loop through all rows returned looking for the
                    // people that are staff.
                    
                    for (i170 = 0;i170 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                        if (0 == STAFF.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getSzCdStagePersType())) {
                            
                            ulIdSubWorker = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdPerson();
                            ulIdSubLink = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i170).getUlIdStagePerson();
                        }
                    }
                    break;
                    // 
                    // (END): Retrieve DAM: ccmn44d     
                    // Get NmPersonFull given IdPerson
                    // 
                    
                    
                    //  CASE SQL_NOT_FOUND for CINV51D (VP)
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
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMND3DInputRec = new CCMND3DI();
            
            pCCMND3DOutputRec = new CCMND3DO();
            pCCMND3DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMND3DInputRec.setUlIdStagePerson(ulIdSubLink);
            pCCMND3DInputRec.setSzCdStagePersRole(PRIMARY_WORKER);
            pCCMND3DInputRec.setSzCdStagePersType(STAFF);
            pCCMND3DInputRec.setBIndStagePersEmpNew(EMP_IS_NEW);
            pCCMND3DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
            pCCMND3DInputRec.setUlIdPerson(ccmn49si.getUlIdPerson());
            pCCMND3DInputRec.setDtDtStagePersLink(dtCurrentDate);
            
            //  Initialize Service Status Fields
            
            //  Perform Main Processing
            
            //  Set pOutputMsg WCD DtSystemDate to current date
            rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
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
            //  Find the closure event with ccmn87d
            // 
            // Begin CCMN87D
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCCMN87DInputRec = new CCMN87DI();
            
            pCCMN87DOutputRec = new CCMN87DO();
            pCCMN87DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
            pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
            pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN87DInputRec.setUlIdStage(ccmn49si.getUlIdStage());
            // 
            // (END): Retrieve DAM: cses38d      Eligibility simple retrieve
            // 
            
            if (0 == SUBCARE.compareTo(ccmn49si.getSzCdStage())) {
                pCCMN87DInputRec.setSzCdTask(SUB_CLOSURE);
                
            }
            else if (0 == FAM_SUBCARE_STAGE.compareTo(ccmn49si.getSzCdStage())) {
                pCCMN87DInputRec.setSzCdTask(FSU_CLOSURE);
            }
            else if (0 == FAM_REUNIF_STAGE.compareTo(ccmn49si.getSzCdStage())) {
                
                //## BEGIN TUX/XML: Declare XML variables 
                pCCMN87DInputRec.setSzCdTask(FRE_CLOSURE);
            }
            else {
                pCCMN87DInputRec.setSzCdTask(PAD_CLOSURE);
            }
            rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
            
            // 
            // Call DAMs to retrieve data
            // 
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Populate Output Message
                    for (i170 = 0;i170 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();i170++) {
                        // 
                        // BEGIN Retrieval for CCMN45D - GET EVENT SMP
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN45DInputRec = new CCMN45DI();
                        
                        pCCMN45DOutputRec = new CCMN45DO();
                        pCCMN45DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                        pCCMN45DInputRec.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getUlIdEvent());
                        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                // 
                                // Begin CCMN46D
                                // 
                                //  Allocate memory for Input and Output Structures
                                pCCMN46DInputRec = new CCMN46DI();
                                
                                pCCMN46DOutputRec = new CCMN46DO();
                                pCCMN46DInputRec.setArchInputStruct(ccmn49si.getArchInputStruct());
                                pCCMN46DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                                pCCMN46DInputRec.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i170).getUlIdEvent());
                                pCCMN46DInputRec.setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                                
                                //  Call CINT21D
                                rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                }
                                
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        }
                    }
                    
                    break;
                case NO_DATA_FOUND:
                    
                    //  Set ToDoFlags[*] to TRUE based on conditions being met.
                    if (0 == POST_ADOPT.compareTo(ccmn49si.getSzCdStage())) {
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                    }
                    else {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        RetVal = Csub50s.FND_FAIL;
                    }
                    
                    break;
                case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    break;
                    
                    // 
                    // End CCMN46D
                    // 
                    
                    
                    
                default :
                    
                    RetVal = Csub50s.FND_FAIL;
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
        ARC_PRFServiceStopTime_TUX(ccmn49si.getArchInputStruct() , ccmn49so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        if (RetVal == Csub50s.FND_FAIL) {
            
            //  Call CINV51D
            rc = Csub50s.FND_FAIL;
        }
        
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            // SIR#3582: If LOC/FLOC Mismatch set flag to true
            // Remove :INDICATOR_YES== pInputMsg->SysIndNewActualPlcmt
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
        
        return ccmn49so;
    }

}
