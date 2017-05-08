package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS69DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC72DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD99DI;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD99DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC72DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES92DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES92DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT60DO;
/**************************************************************************
**
** Module File:   CINV05S.src
**
** Service Name:  AUD Person Detail
**
** Description:   This Service calls 2 DAMS to update a number of tables.  A
**                Row is entered or updated in the Person, relationship,
**                Stage person link, and the To Do.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/20/95
**
** Programmer:    Diane M. Verso
**
** DAMS called:   CINV41D
**                CCMN43D
**                CINV51D
**                CINV32D
**                CCMN44D  SIR 2142
**                CSES38D  SIR 2142
**                CAUD18D  SIR 2142
**                CCMN45D  SIR 2142
**                CCMN01U  SIR 2142
**                CSEC30D  SIR 2142
**                CAUD81D  SIR 2142
**                CAUD99D  SIR 2142
**                CLSC72D  SIR 2142
**                CSES32D  SIR 2142
**                CSES34D  SIR 2142
**                CCMNC2D  SIR 3766
**                CSES92D  SIR 10462
**                CINT07D  SIR 10462
**                CAUDD5D  SIR 15512
**                CAUDD4D  SIR 15512
**
**
**
** Change History:
**
**  Date     User               SIR  Description
**  -------  ------------------ ---  --------------------------------------
**
**  11/21/95  YANTISTK SIR#1710 Added CheckStageEventStatus common function.
**
**  01/09/96  DENTONRA SIR#2142 When a NEW date of death is saved to
**                              the person detail window, the following has
**                              been added:  DT ELIG END on ELIGIBILITY table
**                              will be filled with date of death and event
**                              updated to "COMP".  Active record on ADOPTION
**                              SUBSIDY table will be updated.  If either an
**                              ELIGIBILITY or ADOPTION SUBSIDY record exists
**                              a row will be added to the MEDICAID_UPDATE
**                              table. Only one row will be added for ELIG
**                              only if both ELIG & ADOP have rows. Todo will
**                              be sent to primary worker in subcare if there
**                              is an active open record, in lieu of an alert.
**                              Alert will be sent to regional director if
**                              cause of death is abuse/neglect and child is
**                              under 18 years of age OR program is CPS and
**                              legal status of 010 through 080 exists.
**  03/25/96  DENTONRA SIR#4202 Deleted ALL code using PostEvent function to
**                              create an event for this todo.  Need to use
**                              event retrieved from cses34d in order to
**                              navigate to the proper placement.
**  03/27/96  DENTONRA SIR#3766 Added another call to update person
**                              category table if the window has
**                              passed two characteristics in through
**                              szCdCategoryCategory
**  04/02/96  YANTISTK SIR#20118 Set the ReqFuncCd to
**                               REQ_FUNC_CD_ADD in the call to ccmnc2d,
**                               because it was failing if one was relating
**                               a person to a case, because the ReqFuncCd
**                               was not being set to A U or D. Also added
**                               an indicator variable that is set in the
**                               client to prevent a call to ccmnc2d if a
**                               FAH category already exists on the
**                               Person_Category table.
**  4/16/96   PURCELA   SIR #20350 - The Closure Code for Adoption Subsidies
**                      due to Child Death is 'CS', not '050'.  This #define
**                      was changed.  In addition, there can be multiple open
**                      Adoption Subsidies, so a new DAM, CLSS69D, was coded
**                      to replace CSEC30D.  The previous version was only
**                      retrieveing one Adoption Subsidy Record.  Looping was
**                      then performed with the Closure DAM to record the
**                      Closing of all open Adoption Subsidies.
** 10/1/96    ODONNERJ  SIR 10462 - Sometimes the worker who created the
**                      which uses a id_person stored in an Investigation
**                      if that intake is marked for deletion or the intake
**                      is still stored only on the incoming detail table
**                      then their is no row in the stage person link table
**                      for the given worker id and no todo can be sent.
**                      This fix uses a new dam CSES92D to look for the
**                      worker in the temp_stage_person_link table and
**                      CINT07D to search for the worker in the incoming
**                      detail table.
**  03/12/97    KRD     SIR 10348 - To ensure that the timestamps on the
**                      name's start and end dates are set properly, we need
**                      to process the name changes in reverse order.
**                      Required a change to the loop processing in
**                      CallCINV32D().
**  05/15/97  RIOSJA    MHMR Phase III Item 19 - If a person in a case is in
**                      more than one open stage and a change is made to the
**                      person's demographic information, a ToDo will be
**                      created for the primary workers of the open stages.
**                      A ToDo will not be created for the worker making the
**                      change to the demographic information. (Demographic
**                      information includes: sex, ethnicity, language,
**                      marital status, occupation, religion, DOB, DOD,
**                      indicator for approx. DOB, and living arrangement.)
** 10/19/00   EHC       SIR 15512 - Need to add calls to newly created DAMS
**                      to add and delete the Person_Race and Person_Ethnicity
**                      tables.
**
** 06/11/01   ANG       Security upgrade - added code so that
**                      if a person with the SEC_MNTN_PERSON
**                      attribute tries to save, a flag will
**                      be passed in so that the common
**                      function ccmn06u will not be called.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  04/30/03   Srini    SIR 17091: Added the error handling to take care of full
**                      table scans for ccmn87dQUERYdam. Removed the unnecessary
**                      PERF_TIMER_END statements.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**	07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**						before the InvalidateAprvl call.
**
**  03/25/04  corleyan  SIR 22637 - If we are deleting a person, and that
**                      person is not tied to any stage or person events
**                      and the person is not an employee,
**                      we want to run complex delete for that person.
**                      Added a call to CINT60D to check for events and delete
**                      the person.
**
**  10/28/04  CORLEYAN  SIR 23101 - Only do the New death date check if the person
**                      is not being added.
**
**  09/26/05  Malpans   SIR 24002 -Disaster Relief Indicatorsz(CdDisasterRlf)
*					    added on Person Detail Page.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv05s {
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String ALERT = "A";
    public static final String TODO_DESC = "Person information has been changed";
    
    /*
    ** MHMR Phase III Item 19 (RIOSJA) - Changed long description from "person
    ** information has been changed by another program" to "person information
    ** has been changed by another user".
    */
    public static final String TODO_LONG_DESC = " person information has been changed by another user";
    
    public static final String CD_PRIMARY_WORKER = "PR";
    public static final String EVENT_STATUS_PROCESS = "PROC";
    public static final String CONCL_EVENT_TYPE = "CCL";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_NEW = "NEW";
    
    public static final String CHILD_DEATH_CODE = "CS";
    
    public static final String PLACEMENT = "PLA";
    public static final String PLMT_TSK = "3080";
    public static final String SUB_DTH_TSK_CD = "SUB044";
    public static final String ADP_DTH_TSK_CD = "ADP001";
    public static final String PAD_DTH_TSK_CD = "PAD001";
    public static final String ALERT_DTH_TSK_CD = "SUB045";
    public static final String ADOPT = "ADO";
    public static final String POST_ADOPT = "PAD";
    public static final String SUB_CARE = "SUB";
    
    
    public static final int LEG_ST_MIN = 10;
    public static final int LEG_ST_MAX = 80;
    public static final int MAX_CLD_AGE = 18;
    public static final String ABU_NEG_DTH1 = "ABN";
    public static final String ABU_NEG_DTH2 = "ABO";
    public static final String ABU_NEG_DTH3 = "ABD";
    
    public static final String LONG_DESC = "End the currently active placement since the child has died.";
    
    public static final char UPDATE_CODE = 'U';
    public static final char ADD_CODE = 'A';
    
    /* 15512 - Needed constants in order to loop through race and ethnicity
    **         record groups correctly.
    */
    public static final int MAX_RACE_ROWS = 6;
    public static final int MAX_ETHNIC_ROWS = 2;
    public static final int CODE_LEN = 3;
    public static final String NULL_STRING = "";
    
    /* Eligibility Selected Codes */
    public static final String IV_E = "010";
    public static final String STATE_PAID = "020";
    public static final String MAO = "030";
    public static final String ELIG_DETRM_TYPE = "FCD";
    public static final String DENY = "DEN";
    
    /* Adoption Subsidy determination codes */
    public static final String IV_E_FIN_AND_MED = "01";
    public static final String MEDCAD_ONLY = "05";
    public static final String STATE_FIN_AND_MED = "07";
    public static final String STATE_MED_ONLY = "11";
    public static final String STATE_FIN_AND_MED_ASST = "13";
    public static final String STATE_MED_ASST_ONLY = "15";
    public static final String ADOP_SUB_TYPE = "ADS";
    
    
    
    public static final int INITIAL_PAGE = 1;
    public static final int PAGE_SIZE = 50;
    public static final String INTAKE_OPEN = "OPN";
    public static final String INTAKE_SUBMIT_FOR_APPROVAL = "SBA";
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    
    
    /**************************************************************************
    ** Function Prototypes
    ***************************************************************************/
    
    
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    /**************************************************************************
    **
    ** Function Name:  CCON21S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    static CINV05SI pInputMsg = null;
    CINV05SO CINV05S(CINV05SI cinv05si) {
        CINV05SO cinv05so = new CINV05SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int RetVal = SUCCESS;/*SIR#1710 */
        int i289 = 0;
        int u = 0;/*SIR#2142 - Row counter */
        CCMN06UI pCCMN06UInputRec = null;/* SIR#2426 */
        CCMN06UO pCCMN06UOutputRec = null;/* SIR#2426 */
        CSES32DO pCSES32DOutputRec = null;/*SIR#2142*/
        CSES34DO pCSES34DOutputRec = null;
        
        CCMN01UI pCCMN01UInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        CSES38DO pCSES38DOutputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        CLSS69DO pCLSS69DOutputRec = null;
        CSUB40UI pTodoCommonInput = null;/*SIR#2142-ToDoCommonFunc*/
        CSUB40UO pTodoCommonOutput = null;/*SIR#2142-ToDoCommonFunc*/
        CLSC72DO pCLSC72DOutputRec = null;
        CAUD99DI pCAUD99DInputRec = null;/* Medicaid Update                     */
        boolean bNewDeath = false;/*SIR#2142  Date of Death change indicator    */
        boolean bTodoNecessary = false;/*SIR#2142  Necessary to send todo flag*/
        boolean bToDoFlag = false;/*SIR#2142 Stage no match so send todo flag*/
        char bEligExists = 0;/*SIR#2142 Used if elig row exists*/
        char bAdopExists = 0;/*SIR#2142 Used if adop subsidy row exists*/
        char szCdCodeFlag = '\u0000';
        String szTempCdEligSelected = "";/*SIR#2142 Passes selected elig type*/
        String/*SIR#2142 Passes adop sub type*/
        [] szTempCdAdopSubDetrm = new char[10][3];
        Pint ulOutputIdEvent = new Pint();
        ulOutputIdEvent.value = 0;
        int ulTempIdEvent = 0;
        int[] ulTempIdAdptSub = new int[10];/*SIR#2142 Used to pass IdAdptSub from output to DAMs*/
        int lTempLegalStatus = 0;/*SIR#2142 Temporary integer legal status */
        Pint ulAdopTempEvent = new Pint();
        ulAdopTempEvent.value = 0;
        FndInt3date dtCurrDate3 = null;
        int iAdsCtr = 0;
        int iLoopCtr = 0;/* SIR #20350 */
        rc = ARC_PRFServiceStartTime_TUX(cinv05si.getArchInputStruct());
        if ('N' == cinv05si.getBSysIndGeneric()) {
            // 
            // SIR#1710
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cinv05si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv05si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(cinv05si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cinv05si.getSzCdTask());
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
        }
        /* Sir 13720 */
        if (!((DateHelper.NULL_DATE == cinv05si.getDtDtPersonDeath().day) && (DateHelper.NULL_DATE == cinv05si.getDtDtPersonDeath().month) && (DateHelper.NULL_DATE == cinv05si.getDtDtPersonDeath().year)) &&!WtcHelperConstants.REQ_FUNC_CD_ADD == cinv05si.getArchInputStruct().getCReqFuncCd()) {
            if (SUCCESS == RetVal) {
                //  Allocate memory for DAM Output Structure
                pCCMN44DOutputRec = new CCMN44DO();
                
                
                //  Call CRES04D- Validate ACCLAIM Id
                rc = Csub31s.CallCCMN44D(cinv05si, cinv05so, pCCMN44DOutputRec, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        if ((DateHelper.NULL_DATE == pCCMN44DOutputRec.getDtDtPersonDeath().day) && (DateHelper.NULL_DATE == pCCMN44DOutputRec.getDtDtPersonDeath().month) && (DateHelper.NULL_DATE == pCCMN44DOutputRec.getDtDtPersonDeath().year)) {
                            bNewDeath = true;
                        }
                        
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        
                        break;
                        
                        //  Post warning if date of death not recorded on Person table
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_WARNING;
                        pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                        
                    default :
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        break;
                }
            }
            if (bNewDeath) {
                
                if (SUCCESS == RetVal) {
                    
                    // 
                    // BEGIN: Retrieve/update active record from ELIGIBILITY table using
                    // CSES38D & CAUD18D
                    // 
                    //  Allocate memory for DAM Output Structure
                    pCSES38DOutputRec = new CSES38DO();
                    
                    
                    //  Set rc to SSM_FIN_INVALID_RSRC_ID
                    rc = CallCSES38D(cinv05si, cinv05so, pCSES38DOutputRec, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            //  Set "event exists" indicator to true.  This indicator
                            // will allow/prevent processing of the Event table by
                            // CCMN45D (below).  This indicator will also be used
                            // by CAUD99D (below).
                            bEligExists = 1;
                            szTempCdEligSelected = pCSES38DOutputRec.getSzCdEligSelected();
                            
                            //  Copy Id_event from output into temp variable
                            // for use by DAM ccmn45 below
                            ulTempIdEvent = pCSES38DOutputRec.getUlIdEligibilityEvent();
                            rc = CallCAUD18D(cinv05si, cinv05so, pCSES38DOutputRec, pServiceStatus);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    
                                    break;
                                    
                                default :
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    //End of change
                                    break;
                            }
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            break;
                            
                        default :
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                }
                if ((SUCCESS == RetVal) && (bEligExists)) {
                    // 
                    // BEGIN: Retrieve/update active record from EVENT table using
                    // CCMN45D and CCMN01U (PostEvent)
                    // 
                    //  Allocate memory for DAM Output Structure
                    pCCMN45DOutputRec = new CCMN45DO();
                    
                    //  Start performance timer for service. All performance functions always
                    // return success so there is no need to check status.
                    rc = Cint40s.CallCCMN45D(cinv05si, cinv05so, pCCMN45DOutputRec, ulTempIdEvent, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            //  Call CCMN01U to update active record from ELIGIBILITY
                            
                            //  Reserve memory for PostEvent Function structure
                            pCCMN01UInputRec = new CCMN01UI();
                            
                            //  Set code flage to update
                            szCdCodeFlag = UPDATE_CODE;
                            if (false == cinv05si.getArchInputStruct().getUlSysNbrReserved1()) {
                                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
                            }
                            else {
                                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_PENDING);
                            }
                            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(cinv05si.getDtDtPersonDeath().month + "/" + cinv05si.getDtDtPersonDeath().day + "/" + cinv05si.getDtDtPersonDeath().year);
                            rc = CallCCMN01U(cinv05si, cinv05so, pCCMN01UInputRec, ulOutputIdEvent, szCdCodeFlag, pServiceStatus);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    
                                    break;
                                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                            break;
                            
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            break;
                            
                        default :
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                }
                if (SUCCESS == RetVal) {
                    // 
                    // BEGIN: Retrieve/update active record from ADOPTION SUBSIDY
                    // table using CSEC30D and CAUD81D
                    // 
                    
                    //  SIR #20350 - 4/16/96 - PURCELA - Replaced the call to CSEC30D
                    // with a call to CLSS68D which was created for this SIR.  Multiple
                    // Open Subsidies may need to be retrieved.  With this in mind,
                    // the calls to CAUD81D and CAUD99D will have to be placed inside
                    // for loops to close all the open Subsidies and to trigger the
                    // closures to the Medicaid Update Table.
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCLSS69DOutputRec = new CLSS69DO();
                    
                    rc = CallCLSS69D(cinv05si, cinv05so, pCLSS69DOutputRec, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            //  Set "adopt exists" indicator to true. This indicator
                            // will be used by CAUD99D (below).
                            bAdopExists = 1;
                            
                            // initilaize the temporary Adopt. Sub. variables
                            
                            for (iLoopCtr = 0;iLoopCtr < 10;iLoopCtr++) {
                                szTempCdAdopSubDetrm[iAdsCtr] = "";
                                
                                ulTempIdAdptSub[iAdsCtr] = 0;
                            }
                            
                            for (iAdsCtr = 0;iAdsCtr < 10 && 0 != pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getUlIdAdptSub();iAdsCtr++) {
                                szTempCdAdopSubDetrm[iAdsCtr] = pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getSzCdAdptSubDeterm();
                                
                                //  Set temporary variable to carry id adop sub info
                                // to CAUD99d (below).
                                ulTempIdAdptSub[iAdsCtr] = pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getUlIdAdptSub();
                                rc = CallCAUD81D(cinv05si, cinv05so, pCLSS69DOutputRec, iAdsCtr, pServiceStatus);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        
                                        break;
                                        
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                        
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        
                                        break;
                                        
                                    default :
                                        
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        break;
                                }
                            }
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            
                            break;
                            
                        default :
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                }
                if (SUCCESS == RetVal) {
                    if (true == bEligExists && (!(IV_E.compareTo(szTempCdEligSelected) != 0) ||!(STATE_PAID.compareTo(szTempCdEligSelected) != 0) ||!(MAO.compareTo(szTempCdEligSelected) != 0))) {
                        //  Set bAdopExists flag to false. We only want one record
                        // added to the Medicaid table so if Elig record conditions
                        // are met, then no other row should be added.
                        bAdopExists = 0;
                        
                        //  Allocate memory for Input Structure
                        pCAUD99DInputRec = new CAUD99DI();
                        pCAUD99DInputRec.setUlIdMedUpdStage(cinv05si.getUlIdStage());
                        pCAUD99DInputRec.setUlIdMedUpdPerson(cinv05si.getUlIdPerson());
                        pCAUD99DInputRec.setUlIdMedUpdRecord(ulTempIdEvent);
                        pCAUD99DInputRec.setSzCdMedUpdType(ELIG_DETRM_TYPE);
                        pCAUD99DInputRec.setSzCdMedUpdTransTypE(DENY);
                        
                        rc = Ccmn44s.CallCAUD99D(cinv05si, cinv05so, pCAUD99DInputRec, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                
                                break;
                                
                            default :
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                
                                break;
                        }
                    }
                    
                    
                    //  Processing for Adoption case
                    
                    //  SIR #20350 - 4/16/96 - PURCELA - Place this logic within a for
                    // loop to accomodate multiple open Adoption Subsidies.
                    
                    for (iAdsCtr = 0;iAdsCtr < 10 && 0 != ulTempIdAdptSub[iAdsCtr];iAdsCtr++) {
                        if (true == bAdopExists && (!(IV_E_FIN_AND_MED.compareTo(szTempCdAdopSubDetrm[iAdsCtr]) != 0) ||!(MEDCAD_ONLY.compareTo(szTempCdAdopSubDetrm[iAdsCtr]) != 0) ||!(STATE_FIN_AND_MED.compareTo(szTempCdAdopSubDetrm[iAdsCtr]) != 0) ||!(STATE_MED_ONLY.compareTo(szTempCdAdopSubDetrm[iAdsCtr]) != 0) ||!(STATE_FIN_AND_MED_ASST.compareTo(szTempCdAdopSubDetrm[iAdsCtr]) != 0) ||!(STATE_MED_ASST_ONLY.compareTo(szTempCdAdopSubDetrm[iAdsCtr]) != 0))) {
                            //  Allocate memory for Input Structure
                            pCAUD99DInputRec = new CAUD99DI();
                            pCAUD99DInputRec.setUlIdMedUpdStage(cinv05si.getUlIdStage());
                            pCAUD99DInputRec.setUlIdMedUpdPerson(cinv05si.getUlIdPerson());
                            pCAUD99DInputRec.setUlIdMedUpdRecord(ulTempIdAdptSub[iAdsCtr]);
                            pCAUD99DInputRec.setSzCdMedUpdType(ADOP_SUB_TYPE);
                            
                            pCAUD99DInputRec.setSzCdMedUpdTransTypE(DENY);
                            rc = Ccmn44s.CallCAUD99D(cinv05si, cinv05so, pCAUD99DInputRec, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                                    
                                default :
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                    }
                }
                if (SUCCESS == RetVal) {
                    // 
                    // BEGIN:  Retrieve row to verify if child was in Actual placement .
                    // (CSES34D)If no row, then no actual placement and no todo
                    // needs to be sent.  If row, then later processing will
                    // determine to whom the to do should be sent.
                    // 
                    //  Allocate memory for DAM Output Structure
                    pCSES34DOutputRec = new CSES34DO();
                    
                    rc = CallCSES34D(cinv05si, cinv05so, pCSES34DOutputRec, ulAdopTempEvent, pServiceStatus);
                    
                    //  Stage program is not populated in this service because it
                    // should only be decided when the call is closed, assigned, or
                    // submitted.
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set todo necessary flag to true
                            bTodoNecessary = true;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set todo necessary flag to false
                            bTodoNecessary = false;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                if (SUCCESS == RetVal) {
                    if (bTodoNecessary) {
                        // 
                        // BEGIN: Retrieve row to determine primary worker(s)
                        // for child. (CLSC72D) Call PostEvent (CCMN01U) to
                        // create an event.  Send ToDo to primary
                        // worker(s) (CCMN40U).
                        // 
                        //  Allocate memory for DAM Output Structure
                        pCLSC72DOutputRec = new CLSC72DO();
                        rc = CallCLSC72D(cinv05si, cinv05so, pCLSC72DOutputRec, pServiceStatus);
                        switch (rc) {
                                
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                //  Loop through all rows returned from CLSC72D
                                // and Create and event and Todo for each returned
                                // row
                                for (i289 = 0;i289 < pCLSC72DOutputRec.getArchOutputStruct().getUlRowQty();i289++) {
                                    //  Evaluate OutputRec to determine which stage
                                    // is open for child and send ToDos ONLY to
                                    // those workers
                                    // 
                                    // SIR 4202 - Deleted ALL code using PostEvent function to create an event
                                    // for this todo.  Need to use event retrieved from cses34d
                                    // in order to navigate to the proper placement.
                                    // 
                                    //  Reserve memory for input structure
                                    pTodoCommonInput = new CSUB40UI();
                                    
                                    //  Reserve memory for output structure
                                    pTodoCommonOutput = new CSUB40UO();
                                    pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day = DateHelper.NULL_DATE;
                                    pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month = DateHelper.NULL_DATE;
                                    pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().year = DateHelper.NULL_DATE;
                                    if (!(SUB_CARE.compareTo(pCLSC72DOutputRec.getROWCLSC72DO_ARRAY().getROWCLSC72DO(i289).getSzCdStage()) != 0)) {
                                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(SUB_DTH_TSK_CD);
                                    }
                                    else if (!(ADOPT.compareTo(pCLSC72DOutputRec.getROWCLSC72DO_ARRAY().getROWCLSC72DO(i289).getSzCdStage()) != 0)) {
                                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(ADP_DTH_TSK_CD);
                                    }
                                    else if (!(POST_ADOPT.compareTo(pCLSC72DOutputRec.getROWCLSC72DO_ARRAY().getROWCLSC72DO(i289).getSzCdStage()) != 0)) {
                                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(PAD_DTH_TSK_CD);
                                    }
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pCLSC72DOutputRec.getROWCLSC72DO_ARRAY().getROWCLSC72DO(i289).getUlIdStage());
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(cinv05si.getUlIdPersonId());
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCLSC72DOutputRec.getROWCLSC72DO_ARRAY().getROWCLSC72DO(i289).getUlIdPerson());
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pCLSC72DOutputRec.getROWCLSC72DO_ARRAY().getROWCLSC72DO(i289).getUlIdPerson());
                                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(ulAdopTempEvent.value);
                                    
                                    rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                }
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                break;
                                
                            default :
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    
                }
                if (SUCCESS == RetVal) {
                    // 
                    // BEGIN: Send alert to Regional Director. (CSES32D &
                    // SendToDo Function) given below conditions
                    // 
                    //  Call CSES32D to determine most recent legal status of child
                    //  Allocate memory for DAM Output Structure
                    pCSES32DOutputRec = new CSES32DO();
                    
                    // Call ARC_FRMProduceFormData to format the data
                    rc = CallCSES32D(cinv05si, cinv05so, pCSES32DOutputRec, pServiceStatus);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            //  For use in comparison to #defined integers, LegalStatus
                            // will be converted from a string to an integer.
                            lTempLegalStatus = atoi(pCSES32DOutputRec.getSzCdLegalStatStatus());
                            if (!(Csub38s.CAPS_PROG_CPS.compareTo(cinv05si.getSzCdStageProgram()) != 0) && (LEG_ST_MIN <= lTempLegalStatus && LEG_ST_MAX >= lTempLegalStatus || MAX_CLD_AGE >= cinv05si.getLNbrPersonAge() && (!(ABU_NEG_DTH1.compareTo(cinv05si.getSzCdPersonDeath()) != 0) ||!(ABU_NEG_DTH2.compareTo(cinv05si.getSzCdPersonDeath()) != 0) ||!(ABU_NEG_DTH3.compareTo(cinv05si.getSzCdPersonDeath()) != 0)))) {
                                //  Reserve memory for input structure
                                pTodoCommonInput = new CSUB40UI();
                                
                                //  Reserve memory for output structure
                                pTodoCommonOutput = new CSUB40UO();
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day = DateHelper.NULL_DATE;
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month = DateHelper.NULL_DATE;
                                pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().year = DateHelper.NULL_DATE;
                                pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(cinv05si.getUlIdStage());
                                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(ALERT_DTH_TSK_CD);
                                pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(cinv05si.getUlIdPersonId());
                                rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
            }
        }
        if (SUCCESS == RetVal) {
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            //04/10/03 Srini: Modified the error handling to set rc to explan_code 
            rc = Ccfc14s.CallCINV41D(cinv05si, cinv05so, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            // if current date is only 2 days different from Eff date, then
            // don't update contract_version and contract-county tables
            // There are 1440 Minutes in One Day
            if (SUCCESS == RetVal && WtcHelperConstants.REQ_FUNC_CD_DELETE == cinv05si.getArchInputStruct().getCReqFuncCd()) {
                rc = Cint08s.CallCINT60D(cinv05si, cinv05so, pServiceStatus);
            }
            if ((0 != (0.compareTo(cinv05si.getSzCdCategoryCategory_ARRAY().getSzCdCategoryCategory(1)))) && (cinv05si.getBIndChkd() != FND_YES)) {
                rc = Ccmn05s.CallCCMNC2D(cinv05si, cinv05so, pServiceStatus);
            }
            
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (SUCCESS == RetVal) {
                
                //  Call DAM
                rc = Ccmn05s.CallCAUDD5D(cinv05si, cinv05so, pServiceStatus);
                
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
            }
            
            // Find out the levels of care of the resource
            if (SUCCESS == RetVal) {
                
                rc = Ccmn05s.CallCAUDD4D(cinv05si, cinv05so, pServiceStatus);
                
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                        
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        break;
                }
            }
            
            if ((WtcHelperConstants.REQ_FUNC_CD_ADD == cinv05si.getArchInputStruct().getCReqFuncCd()) && (cinv05si.getArchInputStruct().getUlPageSizeNbr() > 0)) {
                // pServiceStatus->severity = FND_SEVERITY_ERROR;
                // pServiceStatus->explan_code = ARC_ERR_SQL_ERROR;
                // rc = ARC_ERR_SQL_ERROR;
                
                rc = Cint02s.CallCINV32D(cinv05si, cinv05so, pServiceStatus);
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            if (cinv05si.getBSysIndCreateToDo() != 0) {
                for (i289 = 0;i289 < cinv05si.getUlRowQty_ARRAY().getUlRowQty(0);i289++) {
                    //  Reinitialize Todo flag for each for loop
                    // SIR 2142
                    bToDoFlag = true;
                    
                    //  Because a todo has already been sent to the workers
                    // of the open stage(s) in the event of a child death,
                    // there is no need to send another todo, notifing same
                    // worker of change in data.  SIR 2142
                    
                    //  This for loop will check the current [i] row's ulIdStage
                    // with that of each of the IdStages returned from LSC72.
                    // If match is made then todo is NOT sent. SIR 2142
                    for (u = 0;u <= pCLSC72DOutputRec.getArchOutputStruct().getUlRowQty();u++) {
                        if (cinv05si.getCINV05SIG_ARRAY().getCINV05SIG(i289).getUlIdStage() == pCLSC72DOutputRec.getROWCLSC72DO_ARRAY().getROWCLSC72DO(u).getUlIdStage()) {
                            bToDoFlag = false;
                        }
                    }
                    // SIR 22686 if group home is false, save 63A-D else save 63A-C
                    if (bToDoFlag) {
                        rc = CallCINV51D(cinv05si, cinv05so, pServiceStatus, i289);
                        
                        if (rc != SUCCESS) {
                            
                            
                            // Update the selected records from previous DAM
                            if (rc == NO_DATA_FOUND) {
                                //  Description:
                                // SELECT  CD_PERSON_CATEGORY, DT_LAST_UPDATE, ID_PERSON
                                // FROM   PERSON_CATEGORY
                                // WHERE   Id_Person = :hI_ulIdPerson:hI_ulIdPerson_i;
                                rc = CallCSES92D(cinv05si, cinv05so, pServiceStatus, i289);
                                if (rc != SUCCESS) {
                                    
                                    // Insert new records into Contract_County
                                    if (rc == NO_DATA_FOUND) {
                                        
                                        rc = Ccmn13s.CallCINT07D(cinv05si, cinv05so, pServiceStatus, i289);
                                        if (rc != SUCCESS) {
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        }
                                    }
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                            }
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        if ((cinv05si.getUlIdTodoPersAssigned() != cinv05si.getUlIdPersonId()) && (cinv05si.getUlIdTodoPersAssigned() != 0)) {
                            rc = Ccmn19s.CallCCMN43D(cinv05si, cinv05so, pServiceStatus, (char) i289);
                            if (rc != SUCCESS) {
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                        }
                    }
                }
            }
            if (cinv05si.getUlIdEvent() != 0 && false == cinv05si.getArchInputStruct().getUlSysNbrReserved1()) {
                rc = DemoteEvents(cinv05si, cinv05so, pServiceStatus);
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv05si.getArchInputStruct() , cinv05so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            //  Call DAM
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
        return cinv05so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV05SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCCMN44D(CINV05SI pInputMsg523, CINV05SO * pOutputMsg481, CCMN44DO pCCMN44DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN44DI pCCMN44DInputRec = null;
        
        
        /*
        ** Allocate memory for Input Structure
        */
        pCCMN44DInputRec = new CCMN44DI();
        pCCMN44DInputRec.setArchInputStruct(pInputMsg523.getArchInputStruct());
        
        pCCMN44DInputRec.setUlIdPerson(pInputMsg523.getUlIdPerson());
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                
                break;
                // There should be at least one entry for a person.
                
            default :
                
                // 
                // End Call to PAL Closure Liv Arr Dam - CMSC15D
                // 
                break;
        }
        return rc;
    }

    static int CallCSES38D(CINV05SI pInputMsg524, CINV05SO * pOutputMsg482, CSES38DO pCSES38DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSES38DI pCSES38DInputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCSES38DInputRec = new CSES38DI();
        pCSES38DInputRec.setArchInputStruct(pInputMsg524.getArchInputStruct());
        pCSES38DInputRec.setUlIdPerson(pInputMsg524.getUlIdPerson());
        
        /*
        ** Call DAM
        */
        rc = cses38dQUERYdam(sqlca, pCSES38DInputRec, pCSES38DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                break;
        }
        return rc;
    }

    static int CallCAUD18D(CINV05SI pInputMsg525, CINV05SO * pOutputMsg483, CSES38DO pCSES38DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CAUD18DI pCAUD18DInputRec = null;
        CAUD18DO pCAUD18DOutputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCAUD18DInputRec = new CAUD18DI();
        
        /*
        ** Allocate memory for Output Structure
        */
        pCAUD18DOutputRec = new CAUD18DO();
        pCAUD18DInputRec.setArchInputStruct(pInputMsg525.getArchInputStruct());
        pCAUD18DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg525.getArchInputStruct().getCReqFuncCd());
        pCAUD18DInputRec.setUlIdEligibilityEvent(pCSES38DOutputRec.getUlIdEligibilityEvent());
        pCAUD18DInputRec.setTsLastUpdate(pCSES38DOutputRec.getTsLastUpdate());
        pCAUD18DInputRec.setUlIdPerson(pCSES38DOutputRec.getUlIdPerson());
        pCAUD18DInputRec.setUlIdPersonUpdate(pCSES38DOutputRec.getUlIdPersonUpdate());
        pCAUD18DInputRec.setSzCdEligActual(pCSES38DOutputRec.getSzCdEligActual());
        pCAUD18DInputRec.setSzCdEligCsupQuest1(pCSES38DOutputRec.getSzCdEligCsupQuest1());
        pCAUD18DInputRec.setSzCdEligCsupQuest2(pCSES38DOutputRec.getSzCdEligCsupQuest2());
        pCAUD18DInputRec.setSzCdEligCsupQuest3(pCSES38DOutputRec.getSzCdEligCsupQuest3());
        
        pCAUD18DInputRec.setSzCdEligCsupQuest4(pCSES38DOutputRec.getSzCdEligCsupQuest4());
        pCAUD18DInputRec.setSzCdEligCsupQuest5(pCSES38DOutputRec.getSzCdEligCsupQuest5());
        pCAUD18DInputRec.setSzCdEligCsupQuest6(pCSES38DOutputRec.getSzCdEligCsupQuest6());
        
        pCAUD18DInputRec.setSzCdEligCsupQuest7(pCSES38DOutputRec.getSzCdEligCsupQuest7());
        pCAUD18DInputRec.setSzCdEligMedEligGroup(pCSES38DOutputRec.getSzCdEligMedEligGroup());
        pCAUD18DInputRec.setSzCdEligSelected(pCSES38DOutputRec.getSzCdEligSelected());
        pCAUD18DInputRec.setDtDtEligCsupReferral(pCSES38DOutputRec.getDtDtEligCsupReferral());
        pCAUD18DInputRec.setDtDtEligReview(pCSES38DOutputRec.getDtDtEligReview());
        pCAUD18DInputRec.setDtDtEligStart(pCSES38DOutputRec.getDtDtEligStart());
        pCAUD18DInputRec.setCIndEligCsupSend(pCSES38DOutputRec.getCIndEligCsupSend());
        pCAUD18DInputRec.setCIndEligWriteHistory(pCSES38DOutputRec.getCIndEligWriteHistory());
        pCAUD18DInputRec.setSzTxtEligComment(pCSES38DOutputRec.getSzTxtEligComment());
        pCAUD18DInputRec.setBSysIndPrfrmValidation(FND_NO);
        pCAUD18DInputRec.setDtDtEligEnd(pInputMsg525.getDtDtPersonDeath());
        
        /*
        ** Set PostEvent DtSystemDate to current date
        */
        rc = caud18dAUDdam(sqlca, pCAUD18DInputRec, pCAUD18DOutputRec);
        return rc;
    }

    static int CallCCMN45D(CINV05SI pInputMsg526, CINV05SO * pOutputMsg484, CCMN45DO pCCMN45DOutputRec, int ulTempIdEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg526.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(ulTempIdEvent);
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                break;
                
            default :
                break;
        }
        return rc;
    }

    static int CallCCMN01U(CINV05SI pInputMsg527, CINV05SO * pOutputMsg485, CCMN01UI pCCMN01UInputRec, Pint ulOutputIdEvent, char szCdCodeFlag, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN01UO pCCMN01UOutputRec = null;
        
        /*
        ** Reserve memory for PostEvent Function output structure
        */
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(pInputMsg527.getArchInputStruct());
        
        if (ADD_CODE == szCdCodeFlag) {
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        
        else if (UPDATE_CODE == szCdCodeFlag) {
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                
                
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                
                break;
                
            case Messages.MSG_CMN_UPDATE_FAILED:
                
                // 
                // SIR #21922 - END CAUD08D CONTRACT COUNTY update
                // 
                
                break;
                
            default :
                
                
                break;
        }
        ulOutputIdEvent.value = pCCMN01UOutputRec.getUlIdEvent();
        return rc;
    }

    static int CallCLSS69D(CINV05SI pInputMsg528, CINV05SO * pOutputMsg486, CLSS69DO pCLSS69DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CLSS69DI pCLSS69DInputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCLSS69DInputRec = new CLSS69DI();
        pCLSS69DInputRec.setArchInputStruct(pInputMsg528.getArchInputStruct());
        pCLSS69DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS69DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE);
        pCLSS69DInputRec.setUlAdptSubPerson(pInputMsg528.getUlIdPerson());
        pCLSS69DInputRec.setDtDtPersonDeath(pInputMsg528.getDtDtPersonDeath());
        rc = clss69dQUERYdam(sqlca, pCLSS69DInputRec, pCLSS69DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Start Performance Timer
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                break;
                
            default :
                break;
        }
        return rc;
    }

    static int CallCAUD81D(CINV05SI pInputMsg529, CINV05SO * pOutputMsg487, CLSS69DO pCLSS69DOutputRec, int iAdsCtr, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CAUD81DI pCAUD81DInputRec = null;
        CAUD81DO pCAUD81DOutputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCAUD81DInputRec = new CAUD81DI();
        
        /*
        ** Allocate memory for Output Structure
        */
        pCAUD81DOutputRec = new CAUD81DO();
        pCAUD81DInputRec.setArchInputStruct(pInputMsg529.getArchInputStruct());
        pCAUD81DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg529.getArchInputStruct().getCReqFuncCd());
        pCAUD81DInputRec.setTsLastUpdate(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getTsLastUpdate());
        pCAUD81DInputRec.setUlIdAdptSub(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getUlIdAdptSub());
        
        pCAUD81DInputRec.setUlAdptSubPerson(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getUlAdptSubPerson());
        pCAUD81DInputRec.setUlIdAdptSubPayee(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getUlIdAdptSubPayee());
        pCAUD81DInputRec.setUlIdPlcmtEvent(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getUlIdPlcmtEvent());
        pCAUD81DInputRec.setSAmtAdptSub(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getSAmtAdptSub());
        pCAUD81DInputRec.setSzCdAdptSubDeterm(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getSzCdAdptSubDeterm());
        pCAUD81DInputRec.setDtDtAdptSubAgreeRetn(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubAgreeRetn());
        pCAUD81DInputRec.setDtDtAdptSubAgreeSent(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubAgreeSent());
        pCAUD81DInputRec.setDtDtAdptSubAppReturned(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubAppReturned());
        pCAUD81DInputRec.setDtDtAdptSubAppSent(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubAppSent());
        pCAUD81DInputRec.setDtDtAdptSubApprvd(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubApprvd());
        pCAUD81DInputRec.setDtDtAdptSubEffective(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubEffective());
        pCAUD81DInputRec.setDtDtAdptSubEnd(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubEnd());
        pCAUD81DInputRec.setDtDtAdptSubLastInvc(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getDtDtAdptSubLastInvc());
        pCAUD81DInputRec.setCIndAdptSubThirdParty(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getCIndAdptSubThirdParty());
        pCAUD81DInputRec.setCIndAdptSubProcess(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getCIndAdptSubProcess());
        pCAUD81DInputRec.setSzTxtAdptSubRsn(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(iAdsCtr).getSzTxtAdptSubRsn());
        pCAUD81DInputRec.setSzCdAdptSubCloseRsn(CHILD_DEATH_CODE);
        rc = caud81dAUDdam(sqlca, pCAUD81DInputRec, pCAUD81DOutputRec);
        
        
        /*
        ** Analyze return code
        ** LRO switch
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                break;
        }
        return rc;
    }

    static int CallCAUD99D(CINV05SI pInputMsg530, CINV05SO * pOutputMsg488, CAUD99DI pCAUD99DInputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CAUD99DO pCAUD99DOutputRec = null;
        
        /*
        ** Allocate memory for Output Structure
        */
        pCAUD99DOutputRec = new CAUD99DO();
        pCAUD99DInputRec.setArchInputStruct(pInputMsg530.getArchInputStruct());
        pCAUD99DInputRec.getArchInputStruct().setCReqFuncCd(ADD_CODE);
        rc = caud99dAUDdam(sqlca, pCAUD99DInputRec, pCAUD99DOutputRec);
        return rc;
    }

    static int CallCLSC72D(CINV05SI pInputMsg531, CINV05SO * pOutputMsg489, CLSC72DO pCLSC72DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CLSC72DI pCLSC72DInputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCLSC72DInputRec = new CLSC72DI();
        pCLSC72DInputRec.setArchInputStruct(pInputMsg531.getArchInputStruct());
        pCLSC72DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSC72DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC72DO._CLSC72DO__ROWCLSC72DO_SIZE);
        pCLSC72DInputRec.setUlIdPerson(pInputMsg531.getUlIdPerson());
        rc = clsc72dQUERYdam(sqlca, pCLSC72DInputRec, pCLSC72DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                break;
                
            default :
                break;
        }
        return rc;
    }

    static int CallCSES32D(CINV05SI pInputMsg532, CINV05SO * pOutputMsg490, CSES32DO pCSES32DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSES32DI pCSES32DInputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCSES32DInputRec = new CSES32DI();
        pCSES32DInputRec.setArchInputStruct(pInputMsg532.getArchInputStruct());
        pCSES32DInputRec.setUlIdPerson(pInputMsg532.getUlIdPerson());
        
        
        /*
        ** Call CAUD76D
        */
        rc = cses32dQUERYdam(sqlca, pCSES32DInputRec, pCSES32DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                break;
        }
        return rc;
    }

    static int CallCSES34D(CINV05SI pInputMsg533, CINV05SO * pOutputMsg491, CSES34DO pCSES34DOutputRec, Pint ulAdopTempEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSES34DI pCSES34DInputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCSES34DInputRec = new CSES34DI();
        pCSES34DInputRec.setArchInputStruct(pInputMsg533.getArchInputStruct());
        pCSES34DInputRec.setUlIdPlcmtChild(pInputMsg533.getUlIdPerson());
        rc = cses34dQUERYdam(sqlca, pCSES34DInputRec, pCSES34DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                ulAdopTempEvent.value = pCSES34DOutputRec.getUlIdPlcmtEvent();
                break;
                
            case NO_DATA_FOUND:
                break;
                
            default :
                break;
        }
        
        return rc;
    }

    static int CallCINV41D(CINV05SI pInputMsg534, CINV05SO pOutputMsg492, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV41DI pCINV41DInputRec = null;
        CINV41DO pCINV41DOutputRec = null;
        int i290 = 0;
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV41DInputRec = new CINV41DI();
        
        pCINV41DOutputRec = new CINV41DO();
        rc = ARC_UTLGetDateAndTime(pCINV41DInputRec.getDtDtStagePersLink() , 0);
        pCINV41DInputRec.setSzCdStagePersType(pInputMsg534.getSzCdStagePersType());
        pCINV41DInputRec.setSzCdStagePersRole(pInputMsg534.getSzCdStagePersRole());
        pCINV41DInputRec.setSzCdStagePersRelInt(pInputMsg534.getSzCdStagePersRelInt());
        pCINV41DInputRec.setBIndStagePersReporter(pInputMsg534.getBIndStagePersReporter());
        pCINV41DInputRec.setUlIdStagePerson(pInputMsg534.getUlIdStagePerson());
        
        pCINV41DInputRec.setTsLastUpdate(pInputMsg534.getTsLastUpdate());
        pCINV41DInputRec.setSzCdStagePersSearchInd(pInputMsg534.getSzCdStagePersSearchInd());
        pCINV41DInputRec.setBIndStagePersInLaw(pInputMsg534.getBIndStagePersInLaw());
        pCINV41DInputRec.setCCdPersonSex(pInputMsg534.getCCdPersonSex());
        pCINV41DInputRec.setSzCdDisasterRlf(pInputMsg534.getSzCdDisasterRlf());
        pCINV41DInputRec.setLNbrPersonAge(pInputMsg534.getLNbrPersonAge());
        pCINV41DInputRec.setSzNmPersonFull(pInputMsg534.getSzNmPersonFull());
        /*
        **  PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
        **  SQL error returned from the DAM.
        */
        pCINV41DInputRec.setDtDtPersonBirth(pInputMsg534.getDtDtPersonBirth());
        
        pCINV41DInputRec.setBIndPersonDobApprox(pInputMsg534.getBIndPersonDobApprox());
        pCINV41DInputRec.setDtDtPersonDeath(pInputMsg534.getDtDtPersonDeath());
        pCINV41DInputRec.setSzCdPersonDeath(pInputMsg534.getSzCdPersonDeath());
        pCINV41DInputRec.setSzCdPersonMaritalStatus(pInputMsg534.getSzCdPersonMaritalStatus());
        pCINV41DInputRec.setSzCdPersonLanguage(pInputMsg534.getSzCdPersonLanguage());
        pCINV41DInputRec.setSzCdPersonEthnicGroup(pInputMsg534.getSzCdPersonEthnicGroup());
        pCINV41DInputRec.setSzCdCategoryCategory(pInputMsg534.getSzCdCategoryCategory_ARRAY().getSzCdCategoryCategory(0));
        pCINV41DInputRec.setCdPersonStatus(pInputMsg534.getCdPersonStatus());
        
        pCINV41DInputRec.setUlIdStage(pInputMsg534.getUlIdStage());
        pCINV41DInputRec.setUlIdPerson(pInputMsg534.getUlIdPerson());
        pCINV41DInputRec.setBCdPersonChar(pInputMsg534.getBCdPersonChar());
        pCINV41DInputRec.setSzCdPersGuardCnsrv(pInputMsg534.getSzCdPersGuardCnsrv());
        pCINV41DInputRec.setSzCdPersonReligion(pInputMsg534.getSzCdPersonReligion());
        pCINV41DInputRec.setSzCdPersonLivArr(pInputMsg534.getSzCdPersonLivArr());
        pCINV41DInputRec.setDtDtPersonDeath(pInputMsg534.getDtDtPersonDeath());
        pCINV41DInputRec.setSzTxtOccupation(pInputMsg534.getSzTxtOccupation());
        
        pCINV41DInputRec.setUlIdCase(pInputMsg534.getUlIdCase());
        pCINV41DInputRec.setTsSysTsLastUpdate2(pInputMsg534.getTsSysTsLastUpdate2());
        pCINV41DInputRec.setArchInputStruct(pInputMsg534.getArchInputStruct());
        rc = cinv41dAUDdam(sqlca, pCINV41DInputRec, pCINV41DOutputRec);
        /*
        ** checking to see if someone with a division number is trying
        ** to save.  if not then delete the leading zero in the region
        ** number
        */
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    //  Do nothing, the output message just returns success or
                    // failure.
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg492.setUlIdPerson(pCINV41DOutputRec.getUlIdPerson());
        }
        return rc;
    }

    static int CallCCMNC2D(CINV05SI pInputMsg535, CINV05SO pOutputMsg493, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNC2DI pCCMNC2DInputRec = null;
        CCMNC2DO pCCMNC2DOutputRec = null;
        int i291 = 0;
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC2DInputRec = new CCMNC2DI();
        
        pCCMNC2DOutputRec = new CCMNC2DO();
        pCCMNC2DInputRec.setSzCdCategoryCategory(pInputMsg535.getSzCdCategoryCategory_ARRAY().getSzCdCategoryCategory(1));
        pCCMNC2DInputRec.setUlIdPerson(pOutputMsg493.getUlIdPerson());
        pCCMNC2DInputRec.setArchInputStruct(pInputMsg535.getArchInputStruct());
        pCCMNC2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        rc = ccmnc2dAUDdam(sqlca, pCCMNC2DInputRec, pCCMNC2DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN43D(CINV05SI pInputMsg536, CINV05SO * pOutputMsg494, Arcxmlerrors.TUX_DECL_STATUSPARMS, int i292) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        FndInt3date System_date = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN43DInputRec = new CCMN43DI();
        
        pCCMN43DOutputRec = new CCMN43DO();
        
        rc = ARC_UTLGetDateAndTime(System_date, 0);
        pCCMN43DInputRec.setSzCdTodoTask(null);
        pCCMN43DInputRec.setSzCdTodoType(ALERT);
        pCCMN43DInputRec.setDtDtTodoCompleted(System_date);
        pCCMN43DInputRec.setDtDtTodoCreated(System_date);
        pCCMN43DInputRec.setDtDtTodoDue(System_date);
        pCCMN43DInputRec.getDtDtTaskDue().year = DateHelper.NULL_DATE;
        pCCMN43DInputRec.getDtDtTaskDue().month = DateHelper.NULL_DATE;
        pCCMN43DInputRec.getDtDtTaskDue().day = DateHelper.NULL_DATE;
        pCCMN43DInputRec.setUlIdCase(pInputMsg536.getCINV05SIG_ARRAY().getCINV05SIG(i292).getUlIdCase());
        pCCMN43DInputRec.setUlIdEvent(0);
        pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg536.getUlIdTodoPersAssigned());
        
        pCCMN43DInputRec.setUlIdTodoPersCreator(0);
        pCCMN43DInputRec.setUlIdTodoPersWorker(0);
        pCCMN43DInputRec.setUlIdStage(pInputMsg536.getCINV05SIG_ARRAY().getCINV05SIG(i292).getUlIdStage());
        pCCMN43DInputRec.setSzTxtTodoDesc(TODO_DESC);
        pCCMN43DInputRec.setTxtTodoLongDesc(pInputMsg536.getSzNmPersonFull());
        pCCMN43DInputRec.getTxtTodoLongDesc() += TODO_LONG_DESC;
        pInputMsg536.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCCMN43DInputRec.setArchInputStruct(pInputMsg536.getArchInputStruct());
        
        rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCINV51D(CINV05SI pInputMsg537, CINV05SO * pOutputMsg495, Arcxmlerrors.TUX_DECL_STATUSPARMS, int i293) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV51DInputRec = new CINV51DI();
        
        pCINV51DOutputRec = new CINV51DO();
        pCINV51DInputRec.setArchInputStruct(pInputMsg537.getArchInputStruct());
        pInputMsg537.getArchInputStruct().setUsPageNbr(1);
        pInputMsg537.getArchInputStruct().setUlPageSizeNbr(1);
        pCINV51DInputRec.setUlIdStage(pInputMsg537.getCINV05SIG_ARRAY().getCINV05SIG(i293).getUlIdStage());
        pCINV51DInputRec.setSzCdStagePersRole(CD_PRIMARY_WORKER);
        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                case NO_DATA_FOUND:
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pInputMsg537.setUlIdTodoPersAssigned(pCINV51DOutputRec.getUlIdTodoPersAssigned());
        }
        return rc;
    }

    static int CallCINV32D(CINV05SI pInputMsg538, CINV05SO pOutputMsg496, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* Declare local variables */
        CINV32DI pCINV32DInputRec = null;
        CINV32DO pCINV32DOutputRec = null;
        _SSANAMESTRUCT SSANameStruct;
        int i294 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV32DInputRec = new CINV32DI();
        
        pCINV32DOutputRec = new CINV32DO();
        pCINV32DInputRec.setArchInputStruct(pInputMsg538.getArchInputStruct());
        
        /*
        ** Populate Input Structure for DAM
        **
        ** SIR 10348 - CINV32D keeps track of the timestamps on the Start and End
        ** dates.  The primary names in the input message are sorted in
        ** reverse-modified order (i.e., the most recent primary name added or
        ** modified will be at beginning of the input message).  To ensure that
        ** the names receive the timestamps in the proper order, we need to
        ** process the list in reverse order.  This requires a change to the
        ** for loop from:
        **     for (i=0; i<pInputMsg->ArchInputStruct.ulPageSizeNbr; i++)
        ** to:
        **     for (i=pInputMsg->ArchInputStruct.ulPageSizeNbr - 1; i>=0; i--)
        */
        for (i294 = pInputMsg538.getArchInputStruct().getUlPageSizeNbr() - 1;i294 >= 0;i294--) {
            pCINV32DInputRec.setSzCdNameSuffix(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getSzCdNameSuffix());
            pCINV32DInputRec.setDtDtNameEndDate(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getDtDtNameEndDate());
            pCINV32DInputRec.setDtDtNameStartDate(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getDtDtNameStartDate());
            pCINV32DInputRec.setUlIdName(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getUlIdName());
            pCINV32DInputRec.setUlIdPerson(pOutputMsg496.getUlIdPerson());
            
            pCINV32DInputRec.setBIndNameInvalid(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getBIndNameInvalid());
            pCINV32DInputRec.setBIndNamePrimary(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getBIndNamePrimary());
            pCINV32DInputRec.setSzNmNameFirst(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getSzNmNameFirst());
            pCINV32DInputRec.setSzNmNameLast(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getSzNmNameLast());
            pCINV32DInputRec.setSzNmNameMiddle(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getSzNmNameMiddle());
            pCINV32DInputRec.setTsLastUpdate(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getTsLastUpdate());
            pCINV32DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg538.getROWCINV26SIG00_ARRAY().getROWCINV26SIG00(i294).getSzCdScrDataAction());
            
            
            // * retrieve Birthday
            rc = cinv32dAUDdam(sqlca, pCINV32DInputRec, pCINV32DOutputRec);
            if (rc != 0) {
                switch (rc) {
                        
                    case NO_DATA_FOUND:
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        break;
                        
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
        }
        
        return rc;
    }

    static int DemoteEvents(CINV05SI pInputMsg539, CINV05SO * pOutputMsg497, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN87DInputRec = new CCMN87DI();
        pCCMN87DOutputRec = new CCMN87DO();
        pInvdInput = new CCMN05UI();
        pInvdOutput = new CCMN05UO();
        pCCMN62DInputRec.setUlIdEvent(pInputMsg539.getUlIdEvent());
        pCCMN62DInputRec.setSzCdEventStatus(EVENT_STATUS_PROCESS);
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            default :
                return rc;
                break;
        }
        pCCMN87DInputRec.setUlIdStage(pInputMsg539.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CONCL_EVENT_TYPE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call CSUB40U
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                break;
            default :
                return rc;
                break;
        }
        
        
        
        /* BEGIN NEW  LICENSING INV CODE - SPB  ********************************************** */
        /*
        ** Perform edits for Licensing investigation (CCL or RCL)
        */
        if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
            pInvdInput.setArchInputStruct(pInputMsg539.getArchInputStruct());
            pInvdInput.setUlIdEvent(pInputMsg539.getUlIdEvent());
            rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                    
                default :
                    return rc;
                    break;
            }
        }
        return rc;
    }

    static int CallCSES92D(CINV05SI pInputMsg540, CINV05SO * pOutputMsg498, Arcxmlerrors.TUX_DECL_STATUSPARMS, int i295) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSES92DI pCSES92DInputRec = null;
        CSES92DO pCSES92DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES92DInputRec = new CSES92DI();
        
        pCSES92DOutputRec = new CSES92DO();
        pCSES92DInputRec.setArchInputStruct(pInputMsg540.getArchInputStruct());
        pInputMsg540.getArchInputStruct().setUsPageNbr(1);
        pInputMsg540.getArchInputStruct().setUlPageSizeNbr(1);
        pCSES92DInputRec.setUlIdStage(pInputMsg540.getCINV05SIG_ARRAY().getCINV05SIG(i295).getUlIdStage());
        pCSES92DInputRec.setSzCdStagePersRole(CD_PRIMARY_WORKER);
        
        
        /*
        ** Call CAUD78D
        */
        rc = cses92dQUERYdam(sqlca, pCSES92DInputRec, pCSES92DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                case NO_DATA_FOUND:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pInputMsg540.setUlIdTodoPersAssigned(pCSES92DOutputRec.getUlIdTempStagePerson());
        }
        return rc;
    }

    
    static int CallCINT07D(CINV05SI pInputMsg541, CINV05SO * pOutputMsg499, Arcxmlerrors.TUX_DECL_STATUSPARMS, int i296) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT07DI pCINT07DInputRec = null;
        CINT07DO pCINT07DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT07DInputRec = new CINT07DI();
        
        pCINT07DOutputRec = new CINT07DO();
        pCINT07DInputRec.setArchInputStruct(pInputMsg541.getArchInputStruct());
        pInputMsg541.getArchInputStruct().setUsPageNbr(1);
        pInputMsg541.getArchInputStruct().setUlPageSizeNbr(1);
        
        
        pCINT07DInputRec.setUlIdStage(pInputMsg541.getCINV05SIG_ARRAY().getCINV05SIG(i296).getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = cint07dQUERYdam(sqlca, pCINT07DInputRec, pCINT07DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else if (0 == pCINT07DOutputRec.getCdIncmgStatus().compareTo(INTAKE_OPEN)) {
            pInputMsg541.setUlIdTodoPersAssigned(pCINT07DOutputRec.getUlIdPerson());
        }
        else if (0 == pCINT07DOutputRec.getCdIncmgStatus().compareTo(INTAKE_SUBMIT_FOR_APPROVAL)) {
            pInputMsg541.setUlIdTodoPersAssigned(pCINT07DOutputRec.getUlIdPerson());
        }
        else {
            pInputMsg541.setUlIdTodoPersAssigned(0);
            
        }
        return rc;
    }

    static int CallCAUDD5D(CINV05SI pInputMsg542, CINV05SO pOutputMsg500, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i297 = 0;
        int rc = 0;
        int RetVal = SUCCESS;
        
        CAUDD5DI pCAUDD5DInputRec = null;
        CAUDD5DO pCAUDD5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD5DInputRec = new CAUDD5DI();
        pCAUDD5DOutputRec = new CAUDD5DO();
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        pCAUDD5DInputRec.setArchInputStruct(pInputMsg542.getArchInputStruct());
        pCAUDD5DInputRec.setUlIdPerson(pOutputMsg500.getUlIdPerson());
        
        /*
        ** Loop through races
        */
        for (i297 = 0;((i297 < pInputMsg542.getUlRowQty_ARRAY().getUlRowQty(1)) && (rc == 0));i297++) {
            pCAUDD5DInputRec.setSzCdPersonRace(pInputMsg542.getROWCINV05SIG01_ARRAY().getROWCINV05SIG01(i297).getSzCdPersonRace());
            (pCAUDD5DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg542.getROWCINV05SIG01_ARRAY().getROWCINV05SIG01(i297).getSzCdScrDataAction()));
            
            if (pCAUDD5DInputRec.getArchInputStruct().getCReqFuncCd() != null) {
                
                //  Run-time Versioning
                
                //  Check buffer size 
                // Process error message and return to client
                // Initialize output message and length
                
                // Initialize service status fields
                
                // Call DAMs to retrieve data
                rc = caudd5dAUDdam(sqlca, pCAUDD5DInputRec, pCAUDD5DOutputRec);
            }
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    RetVal = SUCCESS;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        return rc;
    }

    static int CallCAUDD4D(CINV05SI pInputMsg543, CINV05SO pOutputMsg501, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i298 = 0;
        int rc = 0;/* Return code */
        int RetVal = SUCCESS;
        
        CAUDD4DI pCAUDD4DInputRec = null;
        CAUDD4DO pCAUDD4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD4DInputRec = new CAUDD4DI();
        pCAUDD4DOutputRec = new CAUDD4DO();
        pCAUDD4DInputRec.setArchInputStruct(pInputMsg543.getArchInputStruct());
        pCAUDD4DInputRec.setUlIdPerson(pOutputMsg501.getUlIdPerson());
        
        /*
        ** Loop through ethnicities
        */
        for (i298 = 0;((i298 < pInputMsg543.getUlRowQty_ARRAY().getUlRowQty(2)) && (rc == 0));i298++) {
            pCAUDD4DInputRec.setSzCdPersonEthnicity(pInputMsg543.getROWCINV05SIG02_ARRAY().getROWCINV05SIG02(i298).getSzCdPersonEthnicity());
            (pCAUDD4DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg543.getROWCINV05SIG02_ARRAY().getROWCINV05SIG02(i298).getSzCdScrDataAction()));
            
            if (pCAUDD4DInputRec.getSzCdPersonEthnicity()[0] != null) {
                rc = caudd4dAUDdam(sqlca, pCAUDD4DInputRec, pCAUDD4DOutputRec);
            }
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                case NO_DATA_FOUND:
                    
                    //  Call The CloseOpenStage Function
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    break;
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    //  Confirm that the INV stage was progressed to
                    // SUB/FSU stages.
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    RetVal = SUCCESS;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        return rc;
    }

    static int CallCINT60D(CINV05SI pInputMsg544, CINV05SO * pOutputMsg502, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT60DI pCINT60DInputRec = null;
        CINT60DO pCINT60DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT60DInputRec = new CINT60DI();
        
        
        pCINT60DOutputRec = new CINT60DO();
        pCINT60DInputRec.setArchInputStruct(pInputMsg544.getArchInputStruct());
        pCINT60DInputRec.setUlIdPerson(pInputMsg544.getUlIdPerson());
        pCINT60DInputRec.setBIndDelPerson(FND_YES);
        
        
        /*
        ** Call CSES77D
        */
        rc = cint60dQUERYdam(sqlca, pCINT60DInputRec, pCINT60DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CSES68D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
