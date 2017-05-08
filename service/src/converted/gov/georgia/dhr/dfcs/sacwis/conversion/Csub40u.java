package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:   CSUB40U.src
**
** Service Name:  CSUB40U
**
** Description:   This service performs the business logic neccessary
**                to execute the TODO COMMON FUNCTION. This service
**                will help standardize/formalize how Todo's are created.
**                It will prevent hard-coding, of Todo descriptions, due
**                dates, and other data within the functional program.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09/14/95
**
** Programmer:    Sameer Rao
**                Andersen Consulting
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   21 Jul 1997 15:31:48  $
**                      $Modtime:   21 Jul 1997 15:07:18  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/21/96  vanderm   SIR 11966 - Memory problem.  Memory for the default
**                      case should only free memory allocated prior to the
**                      switch statement.
**  06/23/97  cyskd     SVC AUTH ENH -- If approving service authorizations
**                      in a closed stage, the ID of the historical primary
**                      worker for that stage must be used.
**  07/17/97  PAULS     SIR 13720 - Three month review contact todos  which
**                      are created during Stage Progression from Intake to
**                      Investigation were only being sent to the worker.
**                      They should also  be sent to the Supervisor.Before
**                      this fix was made this was implemented outside the
**                      the TodoCommon function(in ccmn03u.src). So added
**                      a row in the Todo Info table to incorporate the
**                      "Three Month Review Todo". This forced it to go into
**                      Todo Common Function. Within the TodoCommon Function
**                      added functionality to send a todo to the Worker and
**                      the Supervisor.
**
**  09/30/2002  KRD     To-Do Arch Enh - Failed to provide usable comments.
**                      The following changes were made to provide the
**                      ability to enable/disable to-dos:
**                      (a) Updated DAM CSES08D to include a new column
**                          (IND_TODO_INFO_ENABLED).
**                      (b) Updated this function to check the value
**                          retrieved from that column (in
**                          cIndTodoInfoEnabled) and determine whether or
**                          not the to-do should be created.
**                      (c) Modified the function to support
**                          non-case-related to-dos by not calling the
**                          DAMs to retrieve case and worker info.
**                      All of the changes are surrounded by BEGIN and END
**                      tags: (To-Do Arch Enh BEGIN & To-Do Arch Enh END)
**
**  05/01/2003  KRD     IMPACT - The To-Do Arch Enh code was missing from
**                      the IMPACT version of the common function.  That
**                      problem has been rectified.
**
**  08/17/04  RIOSJA    SIR 13418 - Added 'Next Review Date' to Child Plan
**                      Detail page so that the worker can enter that date.
**                      When creating the todo for the next review, this
**                      service will no longer use "offset" data from the
**                      TODO_INFO table because Child Plan no longer functions
**                      like the other modules that use that table. For Child
**                      Plans, the next review todo will be due on the date
**                      entered by the worker, and the todo should be
**                      displayed one month before that due date.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/**************************************************************************
** Service Macro Definitions
***************************************************************************/
public class Csub40u {
    public static final String CD_MEMBER = "60";
    public static final String CD_LEAD = "40";
    
    /* SIR 5124 */
    public static final String NULL_STRING = "";
    public static final char CD_TODO_TASK = 'T';
    public static final String HIST_PRIM_ROLE_STAGE_CLOSE = "HP";
    public static final char CLOSE_STAGE = 'Y';
    public static final String THREE_MONTH = "2030";
    public static final int TWENTIETH_DAY = 20;
    
    public static final int NEGATIVE_TWO = - 2;
    public static final int POSITIVE_ONE = 1;
    public static final String TODO_INFO_SUB015 = "SUB015";
    public static final String TODO_INFO_SUB016 = "SUB016";
    public static final String TODO_INFO_ADO015 = "ADO015";
    static int TodoCommonFunction(CSUB40UI pInputMsg840, CSUB40UO pOutputMsg785, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        FndInt3date dtDtSystemDate = null;/* Value used for Date Todo Created */
        FndInt3date dtNullDate = null;/* Used to initialize Todo Comp. date field */
        FndInt3date dtTempDate = null;/* Used to temp hold/calculate Todo Due dates */
        
        
        /*
        ** This variable will be used to
        ** calculate the Date Todo Due and
        ** Date Sit. Task Due
        */
        FndInt3date dtShiftDate = null;
        
        /*
        ** DAM Declarations
        */
        CSES08DI pCSES08DInputRec = null;
        CSES08DO pCSES08DOutputRec = null;
        
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        
        CCMN60DI pCCMN60DInputRec = null;
        CCMN60DO pCCMN60DOutputRec = null;
        
        CSEC04DI pCSEC04DInputRec = null;
        CSEC04DO pCSEC04DOutputRec = null;
        
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        pServiceStatus.severity = FND_SEVERITY_OK;
        pServiceStatus.explan_code = SUCCESS;
        
        /*
        ** Initialize dtNullDate
        */
        dtNullDate.day = DateHelper.NULL_DATE;
        dtNullDate.month = DateHelper.NULL_DATE;
        dtNullDate.year = DateHelper.NULL_DATE;
        rc = ARC_UTLGetDateAndTime(dtDtSystemDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        /*************************************************************
        ** END CAUD08D
        **************************************************************/
        
        /* After updating the old records, a new CONTRACT VERSION, CONTRACT
        ** SERVICE, and CONTRACT COUNTY record should be written.  Service and
        ** county record will be written for each service in the contract.
        ** SIR 20083
        */
        
        /*
        ** Only add a new contract version, service(s), and county if the
        ** overwrite indicator is FALSE.  This allows an old version to be
        ** overwritten when the contract version has been created in the last
        ** two days
        */
        if (DateHelper.NULL_DATE == pInputMsg840.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day && DateHelper.NULL_DATE == pInputMsg840.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month && DateHelper.NULL_DATE == pInputMsg840.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().year) {
            pInputMsg840.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtDtSystemDate);
        }
        
        
        /*
        ** Allocate memory for CSES08D Input and Output Structures
        */
        pCSES08DInputRec = new CSES08DI();
        
        pCSES08DOutputRec = new CSES08DO();
        pCSES08DInputRec.setArchInputStruct(pInputMsg840.getArchInputStruct());
        pCSES08DInputRec.setSzCdTodoInfo(pInputMsg840.getCSUB40UIG00().getSzSysCdTodoCf());
        
        /*
        ** Call DAM
        */
        rc = cses08dQUERYdam(sqlca, pCSES08DInputRec, pCSES08DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                if (INDICATOR_YES == pCSES08DOutputRec.getCIndTodoInfoEnabled()) {
                    //  Create the ToDo
                    
                    // To-Do Arch Enh END
                    
                    //  Allocate memory for CCMN43D Input and Output Structures
                    pCCMN43DInputRec = new CCMN43DI();
                    
                    pCCMN43DOutputRec = new CCMN43DO();
                    
                    pCCMN43DInputRec.setArchInputStruct(pInputMsg840.getArchInputStruct());
                    if (0 != pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfStage()) {
                        //  To-Do Arch Enh END
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCINT40DInputRec = new CINT40DI();
                        
                        pCINT40DOutputRec = new CINT40DO();
                        pCINT40DInputRec.setArchInputStruct(pInputMsg840.getArchInputStruct());
                        pCINT40DInputRec.setUlIdStage(pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfStage());
                        
                        // SIR#60 - Removed dtDtTask Due from this dam call
                        
                        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                pCCMN43DInputRec.setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                                break;
                                
                            default :
                                return rc;
                        }
                        
                        // 
                        // END CAUD15D
                        // 
                        //  SIR 20874 - Changed looping to ensure that logic will execute
                        // to insert Adoptive Contract Service row
                        if (0 != pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfPersWkr()) {
                            
                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                            pCCMN43DInputRec.setUlIdTodoPersWorker(pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfPersWkr());
                        }
                        
                        else {
                            // Call CINV51D to return the Primary employee
                            
                            //  Allocate memory for CINV51D Input and Output Structures
                            pCINV51DInputRec = new CINV51DI();
                            
                            pCINV51DOutputRec = new CINV51DO();
                            pCINV51DInputRec.setArchInputStruct(pInputMsg840.getArchInputStruct());
                            pCINV51DInputRec.setUlIdStage(pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfStage());
                            if (CLOSE_STAGE == pCINT40DOutputRec.getBIndStageClose()) {
                                if (pCINT40DOutputRec.getDtDtStageClose().year != DateHelper.NULL_DATE) {
                                    pCINV51DInputRec.setSzCdStagePersRole(HIST_PRIM_ROLE_STAGE_CLOSE);
                                }
                            }
                            else {
                                pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
                            }
                            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    pCCMN43DInputRec.setUlIdTodoPersWorker(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                    break;
                                    
                                default :
                                    return rc;
                            }
                        }
                    }
                    pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCCMN43DInputRec.setSzCdTodoTask(pCSES08DOutputRec.getSzCdTodoInfoTask());
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    pCCMN43DInputRec.getSzCdTodoType()[0] = pCSES08DOutputRec.getCCdTodoInfoType();
                    pCCMN43DInputRec.setUlIdEvent(pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfEvent());
                    pCCMN43DInputRec.setUlIdStage(pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfStage());
                    
                    // 
                    // END CAUD17D
                    // 
                    // END SIR #15787
                    //  SIR 20874 - Changed looping to ensure that logic will execute
                    // to insert Adoptive Contract Service row
                    if (0 != NULL_STRING.compareTo(pInputMsg840.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc())) {
                        pCCMN43DInputRec.setTxtTodoLongDesc(pInputMsg840.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc());
                    }
                    
                    else {
                        pCCMN43DInputRec.setTxtTodoLongDesc(pCSES08DOutputRec.getSzTxtTodoInfoLongDesc());
                    }
                    if (0 != NULL_STRING.compareTo(pInputMsg840.getCSUB40UIG00().getSzSysTxtTodoCfDesc())) {
                        pCCMN43DInputRec.setSzTxtTodoDesc(pInputMsg840.getCSUB40UIG00().getSzSysTxtTodoCfDesc());
                    }
                    
                    else {
                        pCCMN43DInputRec.setSzTxtTodoDesc(pCSES08DOutputRec.getSzTxtTodoInfoDesc());
                    }
                    
                    
                    //  When creating the todo, the due date and the display
                    // date will be calculated based upon the start date
                    // passed into this function.
                    dtTempDate = pInputMsg840.getCSUB40UIG00().getDtSysDtTodoCfDueFrom();
                    if (0 == TODO_INFO_SUB015.compareTo(pInputMsg840.getCSUB40UIG00().getSzSysCdTodoCf()) || 0 == TODO_INFO_SUB016.compareTo(pInputMsg840.getCSUB40UIG00().getSzSysCdTodoCf()) || 0 == TODO_INFO_ADO015.compareTo(pInputMsg840.getCSUB40UIG00().getSzSysCdTodoCf())) {
                        dtShiftDate.day = pCSES08DOutputRec.getSNbrTodoInfoDueDd();
                        dtShiftDate.month = NEGATIVE_TWO;
                        dtShiftDate.year = pCSES08DOutputRec.getSNbrTodoInfoDueYy();
                        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtShiftDate);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        
                        dtShiftDate.day = pCSES08DOutputRec.getSNbrTodoInfoDueDd();
                        dtShiftDate.month = POSITIVE_ONE;
                        dtShiftDate.year = pCSES08DOutputRec.getSNbrTodoInfoDueYy();
                    }
                    else {
                        //  Calculate the date the todo should be displayed by
                        // shifting the start date that was passed into this
                        // function by the "offset" specified in the TODO_INFO
                        // table. Store that offset value in "dtShiftDate".
                        dtShiftDate.day = pCSES08DOutputRec.getSNbrTodoInfoDueDd();
                        dtShiftDate.month = pCSES08DOutputRec.getSNbrTodoInfoDueMm();
                        dtShiftDate.year = pCSES08DOutputRec.getSNbrTodoInfoDueYy();
                        
                    }
                    
                    //  Call DAM
                    rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtShiftDate);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    pCCMN43DInputRec.setDtDtTodoDue(dtTempDate);
                    if (0 == THREE_MONTH.compareTo(pCSES08DOutputRec.getSzCdTodoInfoTask())) {
                        pCCMN43DInputRec.getDtDtTodoDue().day = TWENTIETH_DAY;
                    }
                    if (CD_TODO_TASK == pCSES08DOutputRec.getCCdTodoInfoType()) {
                        pCCMN43DInputRec.setUlIdTodoPersCreator(0);
                        
                        dtShiftDate.day = pCSES08DOutputRec.getSNbrTodoInfoTaskDueDd();
                        
                        dtShiftDate.month = pCSES08DOutputRec.getSNbrTodoInfoTaskDueMm();
                        
                        dtShiftDate.year = pCSES08DOutputRec.getSNbrTodoInfoTaskDueYy();
                        
                        //  Reset temp date to ensure proper value in calculation
                        dtTempDate = pInputMsg840.getCSUB40UIG00().getDtSysDtTodoCfDueFrom();
                        
                        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtShiftDate);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        pCCMN43DInputRec.setDtDtTaskDue(dtTempDate);
                        if (0 == THREE_MONTH.compareTo(pCSES08DOutputRec.getSzCdTodoInfoTask())) {
                            pCCMN43DInputRec.getDtDtTaskDue().day = TWENTIETH_DAY;
                        }
                    }
                    
                    else {
                        pCCMN43DInputRec.setUlIdTodoPersCreator(pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfPersCrea());
                        pCCMN43DInputRec.setDtDtTaskDue(dtNullDate);
                    }
                    
                    pCCMN43DInputRec.setDtDtTodoCreated(dtDtSystemDate);
                    pCCMN43DInputRec.setDtDtTodoCompleted(dtNullDate);
                    if (0 != pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfPersAssgn()) {
                        pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg840.getCSUB40UIG00().getUlSysIdTodoCfPersAssgn());
                        rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                                
                            default :
                                return rc;
                        }
                    }
                    
                    
                    else if (0 == CD_MEMBER.compareTo(pCSES08DOutputRec.getSzCdTodoInfoPersAssignd())) {
                        pCCMN43DInputRec.setUlIdTodoPersAssigned(pCCMN43DInputRec.getUlIdTodoPersWorker());
                        rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                                
                            default :
                                return rc;
                        }
                    }
                    
                    
                    else if (0 == CD_LEAD.compareTo(pCSES08DOutputRec.getSzCdTodoInfoPersAssignd())) {
                        // Call CCMN60D to retrieve the Supervisor
                        
                        //  Allocate memory for CCMN60D Input and Output Structures
                        pCCMN60DInputRec = new CCMN60DI();
                        
                        pCCMN60DOutputRec = new CCMN60DO();
                        pCCMN60DInputRec.setArchInputStruct(pInputMsg840.getArchInputStruct());
                        pCCMN60DInputRec.setUlIdPerson(pCCMN43DInputRec.getUlIdTodoPersWorker());
                        
                        
                        //  Start performance timer for Data Access Module 
                        rc = ccmn60dQUERYdam(sqlca, pCCMN60DInputRec, pCCMN60DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pCCMN43DInputRec.setUlIdTodoPersAssigned(pCCMN60DOutputRec.getUlIdPerson());
                                
                                
                                // 
                                // Call DAM
                                // 
                                rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        
                                        if (0 == THREE_MONTH.compareTo(pCSES08DOutputRec.getSzCdTodoInfoTask())) {
                                            pCCMN43DInputRec.setUlIdTodoPersAssigned(pCCMN43DInputRec.getUlIdTodoPersWorker());
                                            rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    break;
                                                default :
                                                    return rc;
                                            }
                                        }
                                        break;
                                        
                                        
                                    default :
                                        return rc;
                                }
                                break;
                                
                                
                                
                                
                            default :
                                pCCMN43DInputRec.setUlIdTodoPersAssigned(pCCMN43DInputRec.getUlIdTodoPersWorker());
                                rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        break;
                                        
                                        
                                    default :
                                        return rc;
                                }
                                break;
                        }
                    }
                    
                    
                    //  If Person Assigned is completely unknown continue with this
                    // check.
                    else {
                        // Call CSEC04D to retrieve ID PERSON
                        
                        //  Allocate memory for CSEC04D Input and Output Structures
                        pCSEC04DInputRec = new CSEC04DI();
                        
                        pCSEC04DOutputRec = new CSEC04DO();
                        pCSEC04DInputRec.setArchInputStruct(pInputMsg840.getArchInputStruct());
                        pCSEC04DInputRec.setUlIdPerson(pCCMN43DInputRec.getUlIdTodoPersWorker());
                        pCSEC04DInputRec.setSzCdUnitMemberRole(pCSES08DOutputRec.getSzCdTodoInfoPersAssignd());
                        rc = csec04dQUERYdam(sqlca, pCSEC04DInputRec, pCSEC04DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pCCMN43DInputRec.setUlIdTodoPersAssigned(pCSEC04DOutputRec.getUlIdPerson());
                                
                                //  Call DAM
                                rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        break;
                                        
                                        
                                    default :
                                        return rc;
                                }
                                break;
                                
                                
                                
                                
                                
                            default :
                                pCCMN43DInputRec.setUlIdTodoPersAssigned(pCCMN43DInputRec.getUlIdTodoPersWorker());
                                
                                rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        break;
                                        
                                    default :
                                        return rc;
                                }
                                break;
                        }
                    }
                    pOutputMsg785.setSzCdTodoTask(pCCMN43DInputRec.getSzCdTodoTask());
                    pOutputMsg785.setSzCdTodoType(pCCMN43DInputRec.getSzCdTodoType());
                    pOutputMsg785.setDtDtTaskDue(pCCMN43DInputRec.getDtDtTodoCompleted());
                    pOutputMsg785.setDtDtTodoCompleted(pCCMN43DInputRec.getDtDtTodoCreated());
                    pOutputMsg785.setDtDtTodoCreated(pCCMN43DInputRec.getDtDtTodoDue());
                    
                    pOutputMsg785.setDtDtTodoDue(pCCMN43DInputRec.getDtDtTaskDue());
                    pOutputMsg785.setUlIdCase(pCCMN43DInputRec.getUlIdCase());
                    pOutputMsg785.setUlIdEvent(pCCMN43DInputRec.getUlIdEvent());
                    pOutputMsg785.setUlIdStage(pCCMN43DInputRec.getUlIdStage());
                    pOutputMsg785.setLdIdTodo(pCCMN43DInputRec.getLdIdTodo());
                    pOutputMsg785.setUlIdTodoPersAssigned(pCCMN43DInputRec.getUlIdTodoPersAssigned());
                    pOutputMsg785.setUlIdTodoPersCreator(pCCMN43DInputRec.getUlIdTodoPersCreator());
                    pOutputMsg785.setUlIdTodoPersWorker(pCCMN43DInputRec.getUlIdTodoPersWorker());
                    pOutputMsg785.setSzTxtTodoDesc(pCCMN43DInputRec.getSzTxtTodoDesc());
                    pOutputMsg785.setTxtTodoLongDesc(pCCMN43DInputRec.getTxtTodoLongDesc());
                }
                break;
                
            default :
                return rc;
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

}
