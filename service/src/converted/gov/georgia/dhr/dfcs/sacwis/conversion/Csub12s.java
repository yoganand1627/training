package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD35DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC09DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS17DO;
/**************************************************************************
**
** Module File:   csub12s.src
**
** Service Name:  CSUB12S
**
** Description:   This is the save service for the Guardianship Detail
**                window. It calls CINV51D, CAUD35D, CAUD36D, CAUD37D,
**                CSES07D. The Common functions Post Event, Check Stage
**                Event Status, Todo Function
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/27/1995
**
** Programmer:    Sameer Rao
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:14:44  $
**                      $Modtime:   28 Mar 1996 23:21:42  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/15/95  RAOSP     SIR #2304: Added DAM calls to update the Person
**                      Detail and CD_STAGE_TYPE.
**
**  01/02/96  RAOSP     SIR #2455: Changed conditions on the creation of
**                      SUB012 todo to reflect detail design.
**
**  01/21/96  WILSONET  SIR#2850: Should be (SERV_DELIVERY && APS)
**                      OR (SERV_DELIVERY  &&  CONTRACTED)
**
**  01/26/96  DYARGR    SIR 2968 - Added two dams to update the stage type
**                      properly.  New dams insure that there is at least
**                      one open guardianship of APS or CON to leave
**                      stage type as GUA, otherwise change it to REG.
**
**
**   1/23/03  DWW       Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  04/30/03  Srini     SIR 17091: Added the error handling to take care of
**                      full table scans for ccmn87dQUERYdam.
**
**  06/18/03  Srini     SIR 17924: Fixed the memsets as they were using
**                      _CAUD36DI and _CAUD36DO instead of CCMN87DI and
**                      CCMN87DO.
**
**  08/27/03  RIOSJA    SIR 18955 - Return 'bOtherAPSGuard' so that
**                      GrdnshpDetailConversation can set stage type in
**                      GlobalData accordingly. Also, while testing the fix
**                      for SIR 18955, I discovered that a condition was
**                      missing from the if statement below that allows the
**                      stage type to be changed to GUA if the Guardianship
**                      Type is APS or Contracted and the Guardianship
**                      Letters have been issued. The stage type should be
**                      set to GUA only if the Closure Date is null. I added
**                      that condition.
**  3/8/2005  gerryc    SIR 15280 - the three month review to dos should
**                      not be a part of SVC GUA stages, only SVC REG.  I
**                      added lots of code so that when making a new GUA,
**                      the to dos are removed, and when ending the GUA, they
**                      are recreated. The contact shell and event stays
**                      no matter what.
**  6/20/2005 malpans	SIR 23694 - Moodifications to Guardianship detail
**						for the new CRSR stages.
**
**  10/18/2005 yeehp	SIR 23803 - Added new guardian type DADs, this will
**                      replace the APS guardian type, but there will still
**                      be old APS guardian types from pre-DADs, added an
**                      or statement for each time an APS guardianship is checked
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub12s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int TS_EVENT = 0;
    public static final int TS_GUARD = 1;
    public static final int CURRENT = 0;
    public static final int NEXT = 1;
    public static final String STATUS_COMP = "COMP";
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String NEW = "NEW";
    public static final String PERS_GUARD = "G";
    public static final String SERV_DELIVERY = "SVC";
    public static final String STG_TYP_GUARD = "GUA";
    public static final String STG_TYP_REG = "REG";
    //SIR 23694 - Start
    public static final String STG_TYP_CGUARD = "C-GUA";
    public static final String STG_TYP_CREG = "C-REG";
    public static final String REC_IN_ERROR = "REC";
    
    public static final String APS = "APS";
    //SIR 23803 - Added new guardian type DADS
    public static final String DAD = "DAD";
    public static final String CONTRACTED = "CON";
    public static final String TEMP = "TEM";
    public static final String PER_ONLY = "PER";
    public static final String PER_LIMIT = "PLM";
    public static final String VICTIM = "VC";
    public static final String VIC_PERP = "VP";
    public static final String CLIENT = "CL";
    public static final int CSUB008 = 0;
    public static final int CSUB009 = 1;
    public static final int CSUB010 = 2;
    public static final int CSUB011 = 3;
    public static final int CSUB012 = 4;
    public static final int CSUB013 = 5;
    public static final int CSUB014 = 6;
    public static final int TODO_FLAGS_LEN = 7;
    
    public static final String TODO_CODE_SUB008 = "SUB008";
    public static final String TODO_CODE_SUB009 = "SUB009";
    public static final String TODO_CODE_SUB010 = "SUB010";
    public static final String TODO_CODE_SUB011 = "SUB011";
    public static final String TODO_CODE_SUB012 = "SUB012";
    public static final String TODO_CODE_SUB013 = "SUB013";
    public static final String TODO_CODE_SUB014 = "SUB014";
    public static final String TODO_SVC_THREE_MONTH = "SVC012";
    
    public static final int TWO_MONTHS = 2;
    public static final int FOUR_MONTHS = 4;
    public static final int FIFTEEN_DAYS = 15;
    public static final int ONE_YEAR = 1;
    public static final int TODO_DAY_DATE = 20;
    
    /* SIR 2968 */
    public static final String GUARDIAN_TASK = "6120";
    public static final String SVC_CD_TASK_CONTACT_APS = "6020";
    public static final int INITIAL_PAGE = 1;
    CSUB12SO CSUB12S(CSUB12SI csub12si) {
        CSUB12SO csub12so = new CSUB12SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        
        int RetVal = 0;
        String TodoFlags = new String();
        int i420 = 0;
        int bOtherAPSGuard1 = 0;
        boolean bStageTypeGuard = false;/*SIR 15280*/
        boolean bSwitchedGuardToReg = false;/*SIR 15280*/
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        
        CAUD35DI pCAUD35DInputRec = null;
        CAUD35DO pCAUD35DOutputRec = null;
        
        CAUD36DI pCAUD36DInputRec = null;
        CAUD36DO pCAUD36DOutputRec = null;
        
        CAUD37DI pCAUD37DInputRec = null;
        CAUD37DO pCAUD37DOutputRec = null;
        
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        CSES07DI pCSES07DInputRec = null;
        CSES07DO pCSES07DOutputRec = null;
        
        /*
        ** Since CreateEvent() has been replaced by this function, the
        ** following SIRs have been incorporated into the following code and
        ** are no longer specifically listed:
        **  ERR 1395 - Do not call ARC_UTLGetDateAndTime() if
        **             ulIdExistingEvent is NULL
        **  ERR 1818 - Ensure that the event status of the Record Call event
        **             is updated when the stage is Save&Assign'd.  When
        **             updating a current event, use the original
        **             DtEventOccurred, rather than the one obtained from
        **             the ARC_UTLGetDateAndTime() API.
        */
        
        /*
        ** Declare local variables
        */
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;/* SIR#1710 Check Stage/Event common function */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#1710 */
        CSUB40UI pTodoCommonInput = null;/* Todo Common function */
        
        CSUB40UO pTodoCommonOutput = null;
        CSYS08DI pCSYS08DInputRec = null;/* SIR #2304 */
        
        CSYS08DO pCSYS08DOutputRec = null;
        CCMN87DI pCCMN87DInputRec = null;/* SIR 2968 */
        
        CCMN87DO pCCMN87DOutputRec = null;
        
        CSEC09DI pCSEC09DInputRec = null;
        CSEC09DO pCSEC09DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub12si.getArchInputStruct());
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub12si.getArchInputStruct());
        pCCMN06UInputRec.setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csub12si.getROWCCMN01UIG00().getSzCdTask());
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
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        if ((SUCCESS == RetVal) && (WtcHelperConstants.REQ_FUNC_CD_ADD == csub12si.getArchInputStruct().getCReqFuncCd())) {
            // 
            // (BEGIN): CINV51D
            // This DAM has the potential to be called three times. The reason for
            // this is that the first time it searches for the VICTIM. If the
            // the VICTIM is not found it then searches for the VICTIM PERP. If
            // the VICTIM_PERP is not found the CLIENT is then searched for. They
            // must be searched for in this order for functional reasons.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCINV51DInputRec = new CINV51DI();
            
            pCINV51DOutputRec = new CINV51DO();
            pCINV51DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
            pCINV51DInputRec.setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
            pCINV51DInputRec.setSzCdStagePersRole(VICTIM);
            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            
            if (NO_DATA_FOUND == rc) {
                pCINV51DInputRec.setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
                pCINV51DInputRec.setSzCdStagePersRole(VIC_PERP);
                
                //  SIR 18563 - Populate dtEventOccurred with today's date, not LOC start date.
                rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            }
            
            
            // 
            // (END): Add / Update / Delete Resource Phone
            // 
            
            // 
            // (BEGIN): Add / Update / Delete F/A Home Interest Ethnicities
            // 
            
            if (NO_DATA_FOUND == rc) {
                pCINV51DInputRec.setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
                pCINV51DInputRec.setSzCdStagePersRole(CLIENT);
                
                //  Call CCMN01U
                rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            }
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set the RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    csub12si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    csub12si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    
                    // 
                    // (BEGIN): CAUD35D
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD35DInputRec = new CAUD35DI();
                    
                    pCAUD35DOutputRec = new CAUD35DO();
                    pCAUD35DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                    pCAUD35DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCAUD35DInputRec.setUlIdPerson(csub12si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getUlIdPerson());
                    pCAUD35DInputRec.setSzCdPersGuardCnsrv(PERS_GUARD);
                    rc = caud35dAUDdam(sqlca, pCAUD35DInputRec, pCAUD35DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set the RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            if ((0 == SERV_DELIVERY.compareTo(csub12si.getSzCdStage())) && ((0 == APS.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType())) || (0 == CONTRACTED.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType())) || (0 == DAD.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType()))) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().day) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().month) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().year) && (DateHelper.NULL_DATE == csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE == csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE == csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().year)) {
                                // 
                                // (BEGIN): CAUD36D
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD36DInputRec = new CAUD36DI();
                                
                                pCAUD36DOutputRec = new CAUD36DO();
                                pCAUD36DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                                pCAUD36DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                pCAUD36DInputRec.setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
                                if (0 == STG_TYP_CREG.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType()) || 0 == STG_TYP_CGUARD.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType())) {
                                    pCAUD36DInputRec.setSzCdStageType(STG_TYP_CGUARD);
                                }
                                else {
                                    pCAUD36DInputRec.setSzCdStageType(STG_TYP_GUARD);
                                }
                                rc = caud36dAUDdam(sqlca, pCAUD36DInputRec, pCAUD36DOutputRec);
                                
                                
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
                                
                                if (SUCCESS == RetVal) {
                                    rc = DeleteThreeMonthToDos(csub12si, csub12so, pServiceStatus);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            RetVal = SUCCESS;
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
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        
        /************************************************************************
        ** (END): Add / Update / Delete F/A Home Interest Ethnicities
        ************************************************************************/
        
        /************************************************************************
        ** (BEGIN): Characteristics & Resource Service Processing
        ************************************************************************/
        
        if (SUCCESS == RetVal) {
            // 
            // (BEGIN): Post Event
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(csub12si.getArchInputStruct());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub12si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub12si.getROWCCMN01UIG00().getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub12si.getROWCCMN01UIG00().getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub12si.getROWCCMN01UIG00().getSzTxtEventDescr());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub12si.getROWCCMN01UIG00().getTsLastUpdate());
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(csub12si.getROWCCMN01UIG00().getDtDtEventOccurred());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub12si.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub12si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub12si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(csub12si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getSzCdScrDataAction());
            if (csub12si.getROWCCMN01UIG00().getUlIdEvent() == 0) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            
            //  Analyze return code
            // 
            // SWITCH STATEMENT FOR CSES21D BEGIN
            // 
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    if (pCCMN01UOutputRec.getUlIdEvent() > 0) {
                        csub12so.setUlIdGuardEvent(pCCMN01UOutputRec.getUlIdEvent());
                    }
                    
                    else {
                        csub12so.setUlIdGuardEvent(csub12si.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    csub12so.getTsLastUpdate_ARRAY().setTsLastUpdate(TS_EVENT, pCCMN01UOutputRec.getTsLastUpdate());
                    
                    if (0 != csub12si.getROWCCMN01UIG00().getUlIdEvent()) {
                        // 
                        // (BEGIN): CINV43D
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCINV43DInputRec = new CINV43DI();
                        
                        pCINV43DOutputRec = new CINV43DO();
                        pCINV43DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                        pCINV43DInputRec.setUlIdEvent(csub12si.getROWCCMN01UIG00().getUlIdEvent());
                        
                        
                        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case NO_DATA_FOUND:
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                RetVal = SUCCESS;
                                
                                //  SIR #2304: Call CSYS08D to retrieve the ID_PERSON
                                // from the EVENT_PERSON_LINK table
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCSYS08DInputRec = new CSYS08DI();
                                
                                pCSYS08DOutputRec = new CSYS08DO();
                                pCSYS08DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                                pCSYS08DInputRec.getArchInputStruct().setUsPageNbr(1);
                                pCSYS08DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                                pCSYS08DInputRec.setUlIdEvent(csub12si.getROWCCMN01UIG00().getUlIdEvent());
                                //  Call CAUD11D
                                rc = csys08dQUERYdam(sqlca, pCSYS08DInputRec, pCSYS08DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        RetVal = SUCCESS;
                                        
                                        //  SIR #2304: Call CAUD35D to update Person
                                        // Detail
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCAUD35DInputRec = new CAUD35DI();
                                        
                                        pCAUD35DOutputRec = new CAUD35DO();
                                        pCAUD35DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                                        pCAUD35DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        pCAUD35DInputRec.setUlIdPerson(pCSYS08DOutputRec.getROWCSYS08DO_ARRAY().getROWCSYS08DO(0).getUlIdPerson());
                                        
                                        rc = caud35dAUDdam(sqlca, pCAUD35DInputRec, pCAUD35DOutputRec);
                                        
                                        //  Analyze return code
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                RetVal = SUCCESS;
                                                
                                                if ((0 == SERV_DELIVERY.compareTo(csub12si.getSzCdStage())) && ((0 == APS.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType())) || (0 == CONTRACTED.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType())) || (0 == DAD.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType()))) && ((DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().day) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().month) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().year) || (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().year))) {
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCAUD36DInputRec = new CAUD36DI();
                                                    
                                                    pCAUD36DOutputRec = new CAUD36DO();
                                                    pCAUD36DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                                                    pCAUD36DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                    pCAUD36DInputRec.setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
                                                    
                                                    
                                                    // 
                                                    // (END): Characteristics & Resource Service Processing
                                                    // 
                                                    
                                                    //  SIR 20083:
                                                    // Begin contract creation/modification process if the save service is
                                                    // successful up to this point
                                                    
                                                    // SIR#15787: Set ulAdoptiveOrFoster based on home type
                                                    // If IdResource is 0 then it's a new home.
                                                    // "A","G","K".
                                                    if ((DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().year)) {
                                                        //  We need to retrieve all the events with the
                                                        // Guardianship task, then retrieve each Guardianship
                                                        // detail record and look at the type and date closed
                                                        // to see if we change the stage type.
                                                        //  Allocate memory for DAM Input and Output Structures
                                                        pCCMN87DInputRec = new CCMN87DI();
                                                        
                                                        pCCMN87DOutputRec = new CCMN87DO();
                                                        pCCMN87DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                                                        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                                        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
                                                        pCCMN87DInputRec.setUlIdStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
                                                        pCCMN87DInputRec.setSzCdTask(GUARDIAN_TASK);
                                                        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
                                                        switch (rc) {
                                                                
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                for (i420 = 0;i420 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty() && bOtherAPSGuard1 == false;++i420) {
                                                                    //  If we found other Guardiansihps, we need
                                                                    // to retrieve the Guardianship record and
                                                                    // look at the type and close date
                                                                    //  Allocate memory for Input and Output Structures
                                                                    pCSEC09DInputRec = new CSEC09DI();
                                                                    
                                                                    
                                                                    pCSEC09DOutputRec = new CSEC09DO();
                                                                    pCSEC09DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                                                                    pCSEC09DInputRec.setUlIdGuardEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i420).getUlIdEvent());
                                                                    rc = csec09dQUERYdam(sqlca, pCSEC09DInputRec, pCSEC09DOutputRec);
                                                                    switch (rc) {
                                                                            
                                                                            //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                                                                            // if there is an attempt to store a duplicate primary key value.
                                                                            // pServiceStatus->explan_code and pServiceStatus->severity should 
                                                                            // be set to the appropriate values by the programmer.
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            
                                                                            if ((0 == APS.compareTo(pCSEC09DOutputRec.getSzCdGuardGuardianType())) || (0 == CONTRACTED.compareTo(pCSEC09DOutputRec.getSzCdGuardGuardianType())) || (0 == DAD.compareTo(pCSEC09DOutputRec.getSzCdGuardGuardianType()))) {
                                                                                // if this is new a home then pInputMsg->ulIdResource is zero.
                                                                                // But pOutputMsg->ulIdResource is holding the new id for the new home
                                                                                if ((DateHelper.NULL_DATE != pCSEC09DOutputRec.getDtDtGuardLetterIssued().day) && (DateHelper.NULL_DATE != pCSEC09DOutputRec.getDtDtGuardLetterIssued().month) && (DateHelper.NULL_DATE != pCSEC09DOutputRec.getDtDtGuardLetterIssued().year)) {
                                                                                    if ((DateHelper.NULL_DATE == pCSEC09DOutputRec.getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE == pCSEC09DOutputRec.getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE == pCSEC09DOutputRec.getDtDtGuardCloseDate().year)) {
                                                                                        
                                                                                        // 
                                                                                        // (BEGIN): Contracts existance determination.  Is there an open foster
                                                                                        // and adoptive contract for the home?
                                                                                        // 
                                                                                        
                                                                                        //  if home is non-prs or home is prs and home status is approved-active
                                                                                        // or approved-inactive, determine if contracts exist and create them if
                                                                                        // they don't exist
                                                                                        
                                                                                        if ((DateHelper.NULL_DATE == csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE == csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE == csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().year) && (csub12si.getROWCCMN01UIG00().getUlIdEvent() == pCSEC09DOutputRec.getUlIdGuardEvent())) {
                                                                                            bOtherAPSGuard1 = 1;
                                                                                        }
                                                                                        else if (csub12si.getROWCCMN01UIG00().getUlIdEvent() != pCSEC09DOutputRec.getUlIdGuardEvent()) {
                                                                                            bOtherAPSGuard1 = 1;
                                                                                        }
                                                                                    }
                                                                                    else {
                                                                                        bOtherAPSGuard1 = 0;
                                                                                    }
                                                                                }
                                                                                
                                                                                else {
                                                                                    bOtherAPSGuard1 = 0;
                                                                                }
                                                                            }
                                                                            else {
                                                                                bOtherAPSGuard1 = 0;
                                                                            }
                                                                            break;
                                                                            
                                                                        default :
                                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                            break;
                                                                    }
                                                                }
                                                                
                                                                
                                                                //  Start DAM Performance Timer
                                                                //##                        ARC_PRFDataAccessStartTime("CSES15D");
                                                                
                                                                
                                                                //  Call CSES15D
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                bOtherAPSGuard1 = 0;
                                                                break;
                                                                
                                                                //  SIR 2766 - The DAM should always return a date of some sort -
                                                                // either an actual date or NULL_DATE, so the SQL_NOT_FOUND case
                                                                // has been removed
                                                                
                                                                //  SIR#4329 - There are several possible cases when and SQL_NOT_FOUND
                                                                // case is possible and should not fall into the DEFAULT case.  Thus,
                                                                // and SQL_NOT_FOUND case is necessary.
                                                            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                                                                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                break;
                                                                
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        }
                                                        
                                                        if (bOtherAPSGuard1) {
                                                            if ((0 == STG_TYP_CREG.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType())) || (0 == STG_TYP_CGUARD.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType()))) {
                                                                pCAUD36DInputRec.setSzCdStageType(STG_TYP_CGUARD);
                                                            }
                                                            else {
                                                                pCAUD36DInputRec.setSzCdStageType(STG_TYP_GUARD);
                                                            }
                                                        }
                                                        
                                                        else if ((0 == STG_TYP_CREG.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType())) || (0 == STG_TYP_CGUARD.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType()))) {
                                                            if (0 == REC_IN_ERROR.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardCloseReason())) {
                                                                pCAUD36DInputRec.setSzCdStageType(STG_TYP_CREG);
                                                            }
                                                            else {
                                                                pCAUD36DInputRec.setSzCdStageType(STG_TYP_CGUARD);
                                                            }
                                                        }
                                                        else {
                                                            bSwitchedGuardToReg = true;
                                                            pCAUD36DInputRec.setSzCdStageType(STG_TYP_REG);
                                                        }
                                                    }
                                                    
                                                    
                                                    
                                                    else if ((0 == STG_TYP_CREG.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType())) || (0 == STG_TYP_CGUARD.compareTo(csub12si.getROWCSUB12SIG00().getSzCdStageType()))) {
                                                        pCAUD36DInputRec.setSzCdStageType(STG_TYP_CGUARD);
                                                    }
                                                    else {
                                                        bStageTypeGuard = true;
                                                        pCAUD36DInputRec.setSzCdStageType(STG_TYP_GUARD);
                                                    }
                                                    csub12so.setBOtherAPSGuard(bOtherAPSGuard1);
                                                    
                                                    
                                                    // Start DAM Performance Timer
                                                    //##                                    ARC_PRFDataAccessStartTime("CINV43D");
                                                    
                                                    
                                                    // Call To Do Update DAM: CINV43D
                                                    
                                                    rc = caud36dAUDdam(sqlca, pCAUD36DInputRec, pCAUD36DOutputRec);
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            RetVal = SUCCESS;
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                }
                                                if (SUCCESS == RetVal && (bOtherAPSGuard1 == true || bStageTypeGuard == true)) {
                                                    rc = DeleteThreeMonthToDos(csub12si, csub12so, pServiceStatus);
                                                    switch (rc) {
                                                            
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            RetVal = SUCCESS;
                                                            
                                                            
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            RetVal = Csub50s.FND_FAIL;
                                                            
                                                            break;
                                                    }
                                                }
                                                if (SUCCESS == RetVal && bSwitchedGuardToReg == true) {
                                                    rc = CreateThreeMonthToDos(csub12si, csub12so, pServiceStatus);
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            RetVal = SUCCESS;
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                }
                                                
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
                                        // 
                                        // OPTIONAL CODE NOTE (END): Generic Retrieve DAM 1
                                        // 
                                        
                                        
                                        break;
                                }
                                
                                break;
                                
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                
                                // 
                                // OPTIONAL CODE NOTE (END): Generic Retrieve DAM 1
                                // 
                                
                                break;
                        }
                    }
                    
                    
                    //  SIR 21003 - Changed "extendo" date
                    // processing to have == instead of =
                    
                    //  Compare dates to determine if one is greater than the
                    // other
                    //  If year is greater
                    if (SUCCESS == RetVal) {
                        // 
                        // (BEGIN): CAUD37D
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD37DInputRec = new CAUD37DI();
                        
                        pCAUD37DOutputRec = new CAUD37DO();
                        
                        pCAUD37DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                        
                        pCAUD37DInputRec.getArchInputStruct().setCReqFuncCd(csub12si.getArchInputStruct().getCReqFuncCd());
                        //  END "extendo" compare date processing
                        
                        if (csub12si.getROWCCMN01UIG00().getUlIdEvent() > 0) {
                            
                            pCAUD37DInputRec.setUlIdGuardEvent(csub12si.getROWCCMN01UIG00().getUlIdEvent());
                        }
                        
                        else {
                            
                            //  This default case contains only a break because the PostEvent
                            // Common Function has already called PROCESS_TUX_SQL_ERROR
                            //  DWW 03/06/2003
                            // Added an error handling block, because this actually sinks a timestamp
                            // mismatch returned from PostEvent
                            pCAUD37DInputRec.setUlIdGuardEvent(csub12so.getUlIdGuardEvent());
                        }
                        pCAUD37DInputRec.setTsLastUpdate(csub12si.getROWCSUB12SIG00().getTsLastUpdate());
                        pCAUD37DInputRec.setUlIdGuardPers(csub12si.getROWCSUB12SIG00().getUlIdGuardPers());
                        pCAUD37DInputRec.setUlIdGuardRsrc(csub12si.getROWCSUB12SIG00().getUlIdGuardRsrc());
                        pCAUD37DInputRec.setDtDtGuardCloseDate(csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate());
                        pCAUD37DInputRec.setDtDtGuardLetterIssued(csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued());
                        pCAUD37DInputRec.setDtDtGuardOrdered(csub12si.getROWCSUB12SIG00().getDtDtGuardOrdered());
                        pCAUD37DInputRec.setCIndGuardAgedOut(csub12si.getROWCSUB12SIG00().getCIndGuardAgedOut());
                        pCAUD37DInputRec.setSzAddrGuardCity(csub12si.getROWCSUB12SIG00().getSzAddrGuardCity());
                        pCAUD37DInputRec.setSzAddrGuardCnty(csub12si.getROWCSUB12SIG00().getSzAddrGuardCnty());
                        pCAUD37DInputRec.setSzAddrGuardLn1(csub12si.getROWCSUB12SIG00().getSzAddrGuardLn1());
                        pCAUD37DInputRec.setSzAddrGuardLn2(csub12si.getROWCSUB12SIG00().getSzAddrGuardLn2());
                        
                        pCAUD37DInputRec.setSzAddrGuardSt(csub12si.getROWCSUB12SIG00().getSzAddrGuardSt());
                        pCAUD37DInputRec.setSzAddrGuardZip(csub12si.getROWCSUB12SIG00().getSzAddrGuardZip());
                        pCAUD37DInputRec.setSzCdGuardCloseReason(csub12si.getROWCSUB12SIG00().getSzCdGuardCloseReason());
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        pCAUD37DInputRec.setSzCdGuardGuardianType(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType());
                        pCAUD37DInputRec.setSzCdGuardType(csub12si.getROWCSUB12SIG00().getSzCdGuardType());
                        pCAUD37DInputRec.setSzNbrGuardPhone(csub12si.getROWCSUB12SIG00().getSzNbrGuardPhone());
                        pCAUD37DInputRec.setSzNbrGuardPhoneExt(csub12si.getROWCSUB12SIG00().getSzNbrGuardPhoneExt());
                        pCAUD37DInputRec.setSzSdsGuardName(csub12si.getROWCSUB12SIG00().getSzSdsGuardName());
                        pCAUD37DInputRec.setSzTxtGuardAddrComment(csub12si.getROWCSUB12SIG00().getSzTxtGuardAddrComment());
                        pCAUD37DInputRec.setSzTxtGuardComments(csub12si.getROWCSUB12SIG00().getSzTxtGuardComments());
                        
                        //  Call DAM
                        rc = caud37dAUDdam(sqlca, pCAUD37DInputRec, pCAUD37DOutputRec);
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                // 
                                // (BEGIN): CSES07D
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCSES07DInputRec = new CSES07DI();
                                
                                pCSES07DOutputRec = new CSES07DO();
                                
                                pCSES07DInputRec.setArchInputStruct(csub12si.getArchInputStruct());
                                pCSES07DInputRec.setUlIdGuardEvent(pCAUD37DInputRec.getUlIdGuardEvent());
                                rc = cses07dQUERYdam(sqlca, pCSES07DInputRec, pCSES07DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub12so.getTsLastUpdate_ARRAY().setTsLastUpdate(TS_GUARD, pCSES07DOutputRec.getTsLastUpdate());
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        //  Set the RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        
                                        // 
                                        // APT 04/20/01 BEGIN SECURITY UPGRADE
                                        // Free pCLSCB3D Input and Output Rec's
                                        // 
                                        // 
                                        // OPTIONAL CODE NOTE (END): Generic Retrieve DAM 1
                                        // 
                                        
                                        break;
                                }
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                
                                //  Set the RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  Set the RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set the RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if ((SUCCESS == RetVal) && ((0 == APS.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType())) || (0 == DAD.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardGuardianType())))) {
            
            // 
            // (END): CLSS67D - List retrieval of Contract rows for and id resource.
            // 
            
            if ((0 != TEMP.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardType())) && (false == csub12si.getBSysIndDtClosedFlld()) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardCloseDate().year)) {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB014, true);
            }
            
            else {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB014, false);
            }
            if (WtcHelperConstants.REQ_FUNC_CD_ADD == csub12si.getArchInputStruct().getCReqFuncCd()) {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB008, true);
            }
            
            else {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB008, false);
            }
            if ((0 != TEMP.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardType())) && (false == csub12si.getBSysIndDtClosedFlld()) && (false == csub12si.getBSysIndDtLettersFlld()) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().day) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().month) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().year)) {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB012, true);
            }
            
            else {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB012, false);
            }
            if ((0 != TEMP.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardType())) && (0 != PER_ONLY.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardType())) && (0 != PER_LIMIT.compareTo(csub12si.getROWCSUB12SIG00().getSzCdGuardType())) && (false == csub12si.getBSysIndDtLettersFlld()) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().day) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().month) && (DateHelper.NULL_DATE != csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued().year)) {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB009, true);
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB010, true);
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB011, true);
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB013, true);
            }
            
            else {
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB009, false);
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB010, false);
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB011, false);
                TodoFlags = CStringUtils.setCharAt(TodoFlags, CSUB013, false);
            }
            
            
            //  Check the Flag settings within the TodoFlags string to determine
            // the Todo code settings
            for (i420 = 0;(i420 <= CSUB014) && (SUCCESS == RetVal);++i420) {
                if (true == TodoFlags.charAt(i420)) {
                    // 
                    // (BEGIN): Todo Common Function
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pTodoCommonInput = new CSUB40UI();
                    
                    pTodoCommonOutput = new CSUB40UO();
                    pTodoCommonInput.setArchInputStruct(csub12si.getArchInputStruct());
                    rc = ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    switch (i420) {
                            
                        case CSUB008:
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_SUB008);
                            break;
                            
                        case CSUB009:
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_SUB009);
                            break;
                            
                        case CSUB010:
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_SUB010);
                            pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued());
                            break;
                            
                        case CSUB011:
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_SUB011);
                            pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued());
                            break;
                        case CSUB012:
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_SUB012);
                            pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub12si.getROWCSUB12SIG00().getDtDtGuardLetterIssued());
                            break;
                            
                        case CSUB013:
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_SUB013);
                            if (pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month < FOUR_MONTHS || (pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month = FOUR_MONTHS) != 0 && pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day < FIFTEEN_DAYS) {
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month = TWO_MONTHS;
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day = FIFTEEN_DAYS;
                            }
                            
                            else {
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month = TWO_MONTHS;
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day = FIFTEEN_DAYS;
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().year = (pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().year + ONE_YEAR);
                            }
                            break;
                        case CSUB014:
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_SUB014);
                            break;
                    }
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub12si.getUlIdTodoPersCreator());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(csub12si.getROWCCMN01UIG00().getUlIdStage());
                    rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            //  Set the RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub12si.getArchInputStruct() , csub12so.getArchOutputStruct());
        
        /* SIR 19613 Change comparison of service returned
        /* from 60A-E to 63A-D
        */
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            // 
            // (BEGIN): CLSS68D - Retrieve contract service codes for
            // the CONTRACT COUNTY table.
            // 
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Start Performance Timer
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csub12so;
    }

    static int DeleteThreeMonthToDos(CSUB12SI pInputMsg829, CSUB12SO pOutputMsg776, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        Pint idThreeMonthReviewEvent = new Pint();
        /*
        ** do nothing
        */
        rc = CallCCMNB4D(pInputMsg829, pOutputMsg776, idThreeMonthReviewEvent, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        rc = CallCSYS17D(pInputMsg829, pOutputMsg776, idThreeMonthReviewEvent.value, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.SQL_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        return rc;
    }

    static int CreateThreeMonthToDos(CSUB12SI pInputMsg830, CSUB12SO pOutputMsg777, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        Pint ulIdPersonSupervisor = new Pint();
        Pint idThreeMonthReviewEvent = new Pint();
        rc = CallCCMNB4D(pInputMsg830, pOutputMsg777, idThreeMonthReviewEvent, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:// For Get Person Info
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        /*
        ** Call CSECC1D
        */
        rc = CallTodoCommonFunction(pInputMsg830, pOutputMsg777, pInputMsg830.getROWCCMN01UIG00().getUlIdPerson() , idThreeMonthReviewEvent.value, pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Csys07s.CallCCMN60D(pInputMsg830, pOutputMsg777, pServiceStatus, ulIdPersonSupervisor);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:// No Svc Auth Detail Rows Found
                if (ulIdPersonSupervisor.value != 0) {
                    rc = CallTodoCommonFunction(pInputMsg830, pOutputMsg777, ulIdPersonSupervisor.value, idThreeMonthReviewEvent.value, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                
                
                break;
            case NO_DATA_FOUND:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        return rc;
    }

    static int CallTodoCommonFunction(CSUB12SI pInputMsg831, CSUB12SO * pOutputMsg778, int ulIdEmployee, int ulIdEvent28, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        CSUB40UI pTodoCommonInput = null;
        CSUB40UO pTodoCommonOutput = null;
        FndInt3date dtTempDate = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pTodoCommonInput = new CSUB40UI();
        
        pTodoCommonOutput = new CSUB40UO();
        
        /*
        ** Populate Input Structure for DAM
        */
        
        /**********************************************************************
        ** three month review summary to dos should also go
        ** from the closed date of the guardianship, not the system date.
        **********************************************************************/
        dtTempDate = pInputMsg831.getROWCSUB12SIG00().getDtDtGuardCloseDate();
        dtTempDate.day = TODO_DAY_DATE;/* 20th day of month */
        pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtTempDate);
        
        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_SVC_THREE_MONTH);
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pInputMsg831.getROWCCMN01UIG00().getUlIdStage());
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(ulIdEvent28);
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(0);
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(ulIdEmployee);
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdEmployee);
        
        /*
        ** Call CCMN44D
        */
        rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  Set explan_data to usRow
                //##            sprintf(pReturnPB->appl_status.explan_data,
                //##                    "%u",
                //##                    usRow);
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                //  Set explan_data to usRow
                //##          sprintf(pReturnPB->appl_status.explan_data,
                //##                  "%u",
                //##                  usRow);
                
                break;
        }
        return rc;
    }

    static int CallCCMN60D(CSUB12SI pInputMsg832, CSUB12SO * pOutputMsg779, Arcxmlerrors.TUX_DECL_STATUSPARMS, Pint ulIdPersonSupervisor) {
        int rc = 0;/* Return code */
        CCMN60DI pCCMN60DInputRec = null;
        CCMN60DO pCCMN60DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN60DInputRec = new CCMN60DI();
        
        pCCMN60DOutputRec = new CCMN60DO();
        pCCMN60DInputRec.setUlIdPerson(pInputMsg832.getROWCCMN01UIG00().getUlIdPerson());
        
        
        /*
        ** Call CRES04D
        */
        rc = ccmn60dQUERYdam(sqlca, pCCMN60DInputRec, pCCMN60DOutputRec);
        switch (rc) {
                
                //  Success Case for Dam CSES77D
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdPersonSupervisor.value = pCCMN60DOutputRec.getUlIdPerson();
                break;
                
                //  Success Case for Dam CSES68D (APG)
            case NO_DATA_FOUND:
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        return rc;
    }

    static int CallCCMNB4D(CSUB12SI pInputMsg833, CSUB12SO * pOutputMsg780, Pint idThreeMonthReviewEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMNB4DI pCCMNB4DInputRec = null;
        CCMNB4DO pCCMNB4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB4DInputRec = new CCMNB4DI();
        
        pCCMNB4DOutputRec = new CCMNB4DO();
        pCCMNB4DInputRec.setArchInputStruct(pInputMsg833.getArchInputStruct());
        pCCMNB4DInputRec.setUlIdStage(pInputMsg833.getROWCCMN01UIG00().getUlIdStage());
        pCCMNB4DInputRec.setSzCdTask(SVC_CD_TASK_CONTACT_APS);
        rc = ccmnb4dQUERYdam(sqlca, pCCMNB4DInputRec, pCCMNB4DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                idThreeMonthReviewEvent.value = pCCMNB4DOutputRec.getUlIdEvent();
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSYS17D(CSUB12SI pInputMsg834, CSUB12SO * pOutputMsg781, int idThreeMonthReviewEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CSYS17DI pCSYS17DInputRec = null;
        CSYS17DO pCSYS17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS17DInputRec = new CSYS17DI();
        
        pCSYS17DOutputRec = new CSYS17DO();
        pCSYS17DInputRec.setArchInputStruct(pInputMsg834.getArchInputStruct());
        pCSYS17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        pCSYS17DInputRec.setUlIdEvent(idThreeMonthReviewEvent);
        rc = csys17dAUDdam(sqlca, pCSYS17DInputRec, pCSYS17DOutputRec);
        
        /*
        ** Set Calculated Retention date to maximum date
        */
        if ((WtcHelperConstants.SQL_SUCCESS != rc) && (NO_DATA_FOUND != rc)) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
