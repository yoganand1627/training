package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD38SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD98DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD98DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD01DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES82DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB7DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES01DO;
/**************************************************************************
**
** Module File:   CFAD38S.src
**
** Service Name:  Home License Save
**
** Description:   This service checks for Stage/Event, and Post Event
**                information.  It also updates CAPS_RESOURCE, and
**                family LOC information.  If a change has been made to
**                the child's foster type, a ToDo will be sent to each
**                child's primary worker.  There is a trigger on CAPS_RESOURCE
** 	              which checks IND_RSRC_WRITE_HIST and updates RESOURCE_HISTORY
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 22, 1995
**
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   10 Mar 1997 17:36:26  $
**                      $Modtime:   10 Mar 1997 18:09:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/22/96  VISHNUR   SIR 3321 - The future date of todo alert is wrong.
**                      Added code to pass current date.
**  03/01/96  VISHNUR   SIR 3276 - Pssing NULL_DATE for FLOC end date is
**                      not creating a MAX_DATE in facility_loc. So passing
**                      MAX_DATE instead of NULL_DATE.
**  03/11/96  VISHNUR   SIR 3276 - Change in Foster type is not being
**                      reflected on Resource Services. Before calling
**                      cfad01u cSysIndFosterTypeChange needs to be passed.
**  03/14/96  VISHNUR   SIR 3867 - The LOC for 3,4 is showing only 3,4
**                      needs to show 1,2,3 & 4.
**                      Completely modified the process of updating the FLOC.
**                      Whatever processing that is done on the Client side
**                      is ignored. In this save service dam CSEC25D is
**                      called to retrieve the current status of FLOC and
**                      determine how it should be updated based on present
**                      Home status and Foster types.
**                      A new row is inserted using CAUD80D.
**  3/22/96   PURCELA   SIR #4164 - Pass the Worker of the Stage as well
**                      as who the ToDo will be assigned to into the ToDo
**                      Common Function.  The Worker must be passed in
**                      they could be a Historical Primary, in which case
**                      CINV51D should not be executed within CSUB40U.
**
**  4/11/96   CRYSTAEP  SIR #20358 - Change Order Enhancement:
**                      Added logic in Success Case of DAM CAUD98D
**                      to allow for the creation or update of
**                      contracts for NonPRS Homes.  The contract tables
**                      will be updated upon saving of the window for a
**                      change in the F/A Home Status field.The service will
**                      validate that two contracts exist for a NonPRS Home-
**                      a Foster and an Adoptive contract.  The service will
**                      retrieve all contracts for the FA Home that have a
**                      period term date that is >= the current date. Contracts
**                      will be created for homes that do not have a Home
**                      Status of "Closed" and do not have existing Foster
**                      and Adoptive contracts.
**  5/8/96    DENTONRA  SIR 21003 - Changed "extendo" date processing to
**                      have == instead of = .  Also, changed error
**                      processing of cses80d to allow sql-not-found because
**                      that is an acceptible condition.  It should not
**                      "blow-up" at that point.
**
**  03/10/97  GONZALCE  SIR 11917 - Added a new dam to update the todo table.
**                      CAUDB7D.PC will update the dt_todo_completed to
**                      SYSDATE for any FAD todo's that are completed for a
**                      specific id_stage.
**
** 9/10/2001    Hadjimh SIR #15787 & 13380: A change is requested to the
**                      Foster Care Rate Structure.  The revised structure will add the
**                      element of age to the determination of service code,
**                      The new rate structure will take effect September 1,
**                      2001, for services delivered after August 31, 2001.
**                      Regardless of whether the associated contract can serve LOC 1
**                      or LOC 1 and 2 clients, CONTRACT_SERVICE rows are currently set up
**                      for both level 1 (service code 95L) and level 2 (service code 95M).
**                      CONTRACT_COUNTY rows are linked to both. Because the contract is
**                      set up for both level 1 and level 2, the home may be incorrectly
**                      reimbursed at the level 2 rate.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  03/25/03  Srini     Modified to check for the transaction and tpbegin only if it
**                                              is not already started and similarly for tpcommit at the end.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                                              to PROCESS_TUX_RC_ERROR_NOFREE after the
**                                              ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                                              input and output objects before they are allocated
**
**  06/25/03  Srini    SIR#18334 Added new fields to be saved by the CAUD98D dam.
**
**  06/30/03  Srini     SIR 18602 - Modified to fix error handling for
**                                              transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**                                              PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to
**                                              PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  08/29/03 MMcClain,  SIR 19596, set all Change flags when calling cfad01u
**
**  09/04/03  A.Corley  SIR 19613 LOC Reduction -- Service Codes 60A-E are now
**                      being reduced to Service Codes 63A - D, updated code to compare and
**                      save with new codes.
**
**  10/24/2003 Matthew McClain  SIR 19998, Contracts don't need to be updated
**                      for closed status; that's handled by cfad36
**  11/17/03  A.Corley	SIR 22390 LOC Change -- Service Code 63C is now being used
**                      for Specialized home, also add FLOC 5 if the home is
**                      ther, habil, or prim med
**  12/16/03  A.Corley	SIR 22485 LOC Change -- Service Code 63D is now being used
**                      for Intense home, also add FLOC 6 if the home is
**                      ther, habil, or prim med
**  4/22/2004 gerryc	SIR 14700 - only set indicator to update RESOURCE_HISTORY if
**                      the status, category, or the license info has been
**                      changed.
**  03/18/05  Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
**                      field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
**                      Adoptive Home checkbox is checked, staff will have to select a
**                      'Certifying Entity'. to indicate the certifying agency
**                      2) This will be a required field when the Non-FPS Adoptive Home
**                      checkbox is checked for a new home. 3) If a user is modifying an
**                      existing Non-FPS Adoptive Home, this new field will be required,
**                      unless the home status is also being changed to 'Pending Closure'
**                      or 'Closed'.
**  09/19/05  yeehp     SIR 23890 - changed level of care to service level
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad38s {
    
    /*
    ** Declare FOUNDATION variables
    */
    
    /*
    ** SIR #5379 - 6/6/96 - PURCELA - Set a pound define for number of
    ** times to loop through F/A Home types to determine Facility LOC.
    ** Previous looping was occurring too many times which caused garbage to
    ** be held in one Foster Type.  This was triggering a Facility Level of
    ** Care to be created for Adoptive Homes, and this should never happen.
    */
    
    static final int NUM_FOSTER_TYPES = 5;
    
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    
    
    /**************************************************************************
    ** Function Prototypes
    ***************************************************************************/
    
    /* SIR #15787 */
    /* SIR 19613, 22390, 22485, 22686 Homes that are basic will only have
    ** Level A assigned to them, Homes that are Hab,
    ** Ther, and Prim Med will have Level A, B, C & D
    */
    public static final int NBR_SVC_CODE_SIXTY_A = 1;
    public static final int NBR_SVC_CODE_SIXTY_AB = 2;
    public static final int NBR_SVC_CODE_SIXTY_ABC = 3;
    public static final int NBR_SVC_CODE_SIXTY_ABCD = 4;
    public static final int NBR_OF_HOME_TYPE = 7;
    static int transactionflag = - 1;
    CFAD38SO CFAD38S(CFAD38SI cfad38si) {
        CFAD38SO cfad38so = new CFAD38SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CFAD38S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        /*
        ** Populate Output Message
        */
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CFAD38S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
            // SQL error returned from the DAM.
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        /*
        ** If years are equal and month is greater
        */
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CFAD38S\n");
        }
        /*
        ** If years and months are equal and day is greater
        */
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CFAD38S\n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare local variables
        */
        //##  short rc = FND_SUCCESS,
        public int RetVal = SUCCESS;
        int NbrHistPage = 0;
        int i219 = 0;
        char bInsert = 0;/* SIR 3867 */
        int /* for any type Checked   */
        usTypeChecked = 0;
        int usType2Checked = 0;
        int usLbRow = 0;
        
        
        
        /* end SIR 3867 */
        
        /* SIR 22686 */
        boolean bGroupHome = false;
        
        /*
        ** SIR #5379 - Commented this to replace it with NUM_FOSTER_TYPES
        **
        ** USHORT NUMLBFOSTERHOMETYPESROWS = 10;  Max number of types
        */
        
        
        char CdFaHomeType = '\u0000';
        
        FndInt3date dtSystemDate = null;
        int ulAdoptiveOrFoster = 0;/* SIR #15787 */
        String szAdoptiveOrFoster = new String();
        CAUD98DI pCAUD98DInputRec = null;/* Rsrc From Lic AUD */
        
        
        CAUD98DO pCAUD98DOutputRec = null;
        CAUD80DI pCAUD80DInputRec = null;/* Facility Loc AUD */
        
        CAUD80DO pCAUD80DOutputRec = null;
        CLSC51DI pCLSC51DInputRec = null;/* Updates Resource History */
        
        CLSC51DO pCLSC51DOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;/*SIR#1710*/
        CCMN06UO pCCMN06UOutputRec = null;/*SIR#1710*/
        CCMN01UI pCCMN01UInputRec = null;/* Post Event common function          */
        CCMN01UO pCCMN01UOutputRec = null;
        CSUB40UI pTodoCommonInput = null;/* ToDo common function */
        
        CSUB40UO pTodoCommonOutput = null;
        CFAD01UI pCFAD01UInputRec = null;/* Characteristics Rebuild common function */
        
        CFAD01UO pCFAD01UOutputRec = null;
        CCMN05UI pCCMN05UInputRec = null;/* Invalidate Approval */
        
        CCMN05UO pCCMN05UOutputRec = null;
        CSEC25DI pCSEC25DInputRec = null;/* Facility_loc simple retrieve      */
        
        CSEC25DO pCSEC25DOutputRec = null;
        Cfad01a pCFAD01DInputRec = null;/* DAM Copybook for Contract Record
        Group; SIR 20358       */
        CLSS67DI pCLSS67DInputRec = null;/* SIR #20358 */
        CLSS67DO pCLSS67DOutputRec = null;/* SIR #20358 */
        CLSS68DI pCLSS68DInputRec = null;/* CONTRACT_COUNTY Retrieve  */
        
        CLSS68DO pCLSS68DOutputRec = null;
        CSES80DI pCSES80DInputRec = null;/* SIR #20358 */
        CSES80DO pCSES80DOutputRec = null;/* SIR #20358 */
        CSES81DI pCSES81DInputRec = null;/* SIR #20358 */
        CSES81DO pCSES81DOutputRec = null;/* SIR #20358 */
        CAUD01DI pCAUD01DInputRec = null;/* Contract AUD */
        
        
        /*
        ** SIR #20358 -
        ** The latter copybook, CFAD01A, is not for a DAM.  Instead, it is acting
        ** as a "WCD" for the service.  The Service Input Record could not hold
        ** the Record Group, CFAD08SIG07, because it is too large so it is
        ** included in this DAM copybook.
        */
        
        /* The following DAMs are for a Contract Change Order - SIR #20358 */
        
        
        
        
        
        CAUD01DO pCAUD01DOutputRec = null;
        CAUD17DI pCAUD17DInputRec = null;/* Contract Service AUD */
        
        CAUD17DO pCAUD17DOutputRec = null;
        CAUD08DI pCAUD08DInputRec = null;/* Contract County AUD */
        
        CAUD08DO pCAUD08DOutputRec = null;
        CAUD15DI pCAUD15DInputRec = null;/* Contract Version AUD */
        
        CAUD15DO pCAUD15DOutputRec = null;
        CAUD20DI pCAUD20DInputRec = null;/* Contract Period AUD*/
        
        CAUD20DO pCAUD20DOutputRec = null;
        
        CLSS13DI pCLSS13DInputRec = null;
        CLSS13DO pCLSS13DOutputRec = null;
        CINT20DI pCINT20DInputRec = null;/* Stage Person Link Retrieve */
        
        CINT20DO pCINT20DOutputRec = null;
        CRES13DI pCRES13DInputRec = null;/* Address Data Retrieve */
        
        CRES13DO pCRES13DOutputRec = null;
        CSES82DI pCSES82DInputRec = null;/* Region retrieval      */
        
        CSES82DO pCSES82DOutputRec = null;
        CAUDB7DI pCAUDB7DInputRec = null;/* Sir 11917 TODO Update */
        CAUDB7DO pCAUDB7DOutputRec = null;/* Sir 11917 TODO Update */
        boolean bIndFosterContractExists = false;/* Indicates if that the foster
        contract exists SIR #20358 */
        boolean bIndAdoptContractExists = false;/* Indicates if that the foster
        contract exists SIR #20358 */
        char bIndUpdateFosterContract = 0;/* Indicates if that the foster
        contract exists SIR #20358 */
        char bIndUpdateAdoptContract = 0;/* Indicates if that the foster
        contract exists SIR #20358 */
        FndInt3date dtTempDate = null;/* Temporary date used for system date
        SIR #20358 */
        FndInt3date dtCurrentDate = null;/* Temporary date used for system date
        SIR #20358 */
        FndInt3date dtTempDate2 = null;/* Temporary date to add 100 years
        SIR 20358 */
        FndInt3date dtTempDate3 = null;/* Temporary date to add 100 years
        SIR 20358 */
        int ulContractQty = 0;/* Counter for contracts returned from
        database SIR #20358 */
        int m = 0;/* Interger used for a looping logic
        SIR #20358 */
        int j = 0;/* Interger used for a looping logic
        SIR #20358 */
        int k = 0;
        int l = 0;/* Interger used for a looping logic
        SIR #20358 */
        int usCreateContract = 0;/* Indicates the type of contract to be
        created.  SIR #20358 */
        int usUpdateContract = 0;/* Indicates the type of contract to be
        created.  SIR #20358 */
        int ulTempIdRsrcAddress = 0;/* Temporary variable to hold the
        ** primary resource address id
        ** SIR 20358
        */
        int ulIdTempCntrctWkr = 0;/* Holds the logged on worker ID */
        int ulIdTempContract = 0;/* Holds the contract ID created in
        in the contract AUD */
        int usCountyRow = 0;/* Holds contract county row index */
        boolean testBool = false;/* Variable for Compare Date and Time */
        boolean bAdoptive = true;/* SIR #15787 */
        boolean bFoster = true;
        
        /*
        ** SIR 11917
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        int tmpSvcRowQty1 = 0;
        int tempSvcRowQty = 0;
        /*
        ** Initialize Temporary date fields
        */
        dtTempDate2.day = 0;
        dtTempDate2.month = 0;
        dtTempDate2.year = 100;
        
        dtTempDate3.day = - 1;
        dtTempDate3.month = 0;
        dtTempDate3.year = 0;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(cfad38si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        RetVal = SUCCESS;
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        ** for CCMN06U
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        
        pCCMN06UInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cfad38si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getSzCdTask());
        
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case Messages.MSG_SYS_MULT_INST:
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
                // SIR 15978 - CWC 02/01/2002
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                // 
                // (END): Retrieve DAM: cres04d      Caps_resource simple retrieve
                // 
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                //  Set RetVal to FND_FAIL
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        
        if (SUCCESS == RetVal && 0 < cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdEvent()) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN05UInputRec = new CCMN05UI();
            
            pCCMN05UOutputRec = new CCMN05UO();
            pCCMN05UInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
            pCCMN05UInputRec.setUlIdEvent(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdEvent());
            rc = Ccmn05u.InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // Set RetVal to FND_SUCCES
                    RetVal = SUCCESS;
                    
                    
                    //  Post Event Processing
                    
                    //  Allocate memory for Common Function Input and Output Structures
                    // for CCMN01U
                    pCCMN01UInputRec = new CCMN01UI();
                    
                    pCCMN01UOutputRec = new CCMN01UO();
                    
                    pCCMN01UInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    
                    pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getSzCdTask());
                    pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getSzCdEventStatus());
                    pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getSzCdEventType());
                    pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getSzTxtEventDescr());
                    pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getTsLastUpdate());
                    
                    ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                    pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdEvent());
                    pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdStage());
                    pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdPerson());
                    rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                        default :// CCMN01U
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                    break;
                default :// CCMN05U
                    
                    
                    // Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            //  Allocate memory for Common Function Input and Output Structures
            // for CCMN01U
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            
            pCCMN01UInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getSzTxtEventDescr());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getTsLastUpdate());
            
            ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdPerson());
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfad38so.setUlIdEvent(pCCMN01UInputRec.getROWCCMN01UIG00().getUlIdEvent());
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    
                    //  Update specific columns on CAPS_RESOURCE
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD98DInputRec = new CAUD98DI();
                    
                    pCAUD98DOutputRec = new CAUD98DO();
                    //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                    // SQL error returned from the DAM.
                    pCAUD98DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                    
                    pCAUD98DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCAUD98DInputRec.setSzCdRsrcCategory(cfad38si.getSzCdRsrcCategory());
                    pCAUD98DInputRec.setSzCdRsrcFaHomeStatus(cfad38si.getSzCdRsrcFaHomeStatus());
                    pCAUD98DInputRec.setSzCdRsrcStatus(cfad38si.getSzCdRsrcStatus());
                    pCAUD98DInputRec.setSzNmRsrcLastUpdate(cfad38si.getSzNmRsrcLastUpdate());
                    pCAUD98DInputRec.setTsLastUpdate(cfad38si.getTsLastUpdate());
                    pCAUD98DInputRec.setUlIdResource(cfad38si.getUlIdResource());
                    pCAUD98DInputRec.setUNbrRsrcMlAgeMin(cfad38si.getUNbrRsrcMlAgeMin());
                    pCAUD98DInputRec.setUNbrRsrcMlAgeMax(cfad38si.getUNbrRsrcMlAgeMax());
                    pCAUD98DInputRec.setUNbrRsrcFMAgeMin(cfad38si.getUNbrRsrcFMAgeMin());
                    pCAUD98DInputRec.setUNbrRsrcFMAgeMax(cfad38si.getUNbrRsrcFMAgeMax());
                    pCAUD98DInputRec.setUNbrRsrcFacilCapacity(cfad38si.getUNbrRsrcFacilCapacity());
                    pCAUD98DInputRec.setSNbrRsrcOpenSlots(cfad38si.getSNbrRsrcOpenSlots());
                    pCAUD98DInputRec.setCCdRsrcFaHomeType1(cfad38si.getCCdRsrcFaHomeType1()[0]);
                    pCAUD98DInputRec.setCCdRsrcFaHomeType2(cfad38si.getCCdRsrcFaHomeType1()[1]);
                    pCAUD98DInputRec.setCCdRsrcFaHomeType3(cfad38si.getCCdRsrcFaHomeType1()[2]);
                    pCAUD98DInputRec.setCCdRsrcFaHomeType4(cfad38si.getCCdRsrcFaHomeType1()[3]);
                    
                    pCAUD98DInputRec.setCCdRsrcFaHomeType5(cfad38si.getCCdRsrcFaHomeType1()[4]);
                    pCAUD98DInputRec.setCCdRsrcFaHomeType6(cfad38si.getCCdRsrcFaHomeType1()[5]);
                    pCAUD98DInputRec.setCCdRsrcFaHomeType7(cfad38si.getCCdRsrcFaHomeType1()[6]);
                    
                    pCAUD98DInputRec.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                    pCAUD98DInputRec.setSzCdRsrcClosureRsn(cfad38si.getSzCdRsrcClosureRsn());
                    pCAUD98DInputRec.setSzCdRsrcInvolClosure(cfad38si.getSzCdRsrcInvolClosure());
                    pCAUD98DInputRec.setSzCdRsrcRecmndReopen(cfad38si.getSzCdRsrcRecmndReopen());
                    pCAUD98DInputRec.setCIndRsrcWriteHist(cfad38si.getCIndRshsWriteHist());
                    rc = caud98dAUDdam(sqlca, pCAUD98DInputRec, pCAUD98DOutputRec);
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            if ((INDICATOR_YES == cfad38si.getBSysIndGeneric()) && ((INDICATOR_YES == cfad38si.getCIndRshsNonPrs()) || ((Cint14s.INDICATOR_NO == cfad38si.getCIndRshsNonPrs()) && ((0 == HOME_STATUS_APVD_ACT.compareTo(cfad38si.getSzCdRsrcFaHomeStatus())) || (0 == HOME_STATUS_APVD_INACT.compareTo(cfad38si.getSzCdRsrcFaHomeStatus())))))) {
                                
                                // 
                                // End Call to Get Event Simple Dam - CCMN45D
                                // 
                                
                                
                                if (SUCCESS == RetVal) {
                                    
                                    //  Allocate memory for DAM Input Structure (CFAD01A)
                                    pCFAD01DInputRec = new Cfad01a();
                                    if (!(FA_CATG_FOST.compareTo(cfad38si.getSzCdRsrcCategory()) != 0) ||!(FA_CATG_LEG_RISK.compareTo(cfad38si.getSzCdRsrcCategory()) != 0)) {
                                        bAdoptive = false;
                                    }
                                    if (!(FA_CATG_ADOPT.compareTo(cfad38si.getSzCdRsrcCategory()) != 0)) {
                                        bFoster = false;
                                    }
                                    
                                    // End SIR# 15787
                                    // 
                                    // (BEGIN): CLSS67D - List retrieval of Contract rows for and id resource.
                                    // 
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    
                                    pCLSS67DInputRec = new CLSS67DI();
                                    
                                    pCLSS67DOutputRec = new CLSS67DO();
                                    pCLSS67DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                    pCLSS67DInputRec.setUlIdResource(cfad38si.getUlIdResource());
                                    pCLSS67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS67DO._CLSS67DO__ROWCLSS67DO_SIZE);
                                    pCLSS67DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                    
                                    //  Call DAM
                                    rc = clss67dQUERYdam(sqlca, pCLSS67DInputRec, pCLSS67DOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Populate Output Message
                                            
                                            //  Set fields in CFAD08SO to fields in CLSS67DO
                                            
                                            ulContractQty = pCLSS67DOutputRec.getArchOutputStruct().getUlRowQty();
                                            
                                            
                                            //  Loop through all contract rows returned from the previous DAM
                                            for (m = 0;m < ulContractQty;m++) {
                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(m).getUlIdContract();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].tsLastUpdate = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(m).getTsLastUpdate();
                                                
                                                // 
                                                // (BEGIN) CSES80D: Retrieve Contract Period table information
                                                // 
                                                
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCSES80DInputRec = new CSES80DI();
                                                
                                                pCSES80DOutputRec = new CSES80DO();
                                                pCSES80DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                                pCSES80DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                rc = cses80dQUERYdam(sqlca, pCSES80DInputRec, pCSES80DOutputRec);
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                        
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm = pCSES80DOutputRec.getDtDtCnperTerm();
                                                        pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperClosure = pCSES80DOutputRec.getDtDtCnperClosure();
                                                        pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperStart = pCSES80DOutputRec.getDtDtCnperStart();
                                                        pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod = pCSES80DOutputRec.getUlNbrCnperPeriod();
                                                        pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate2 = pCSES80DOutputRec.getTsLastUpdate();
                                                        rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                        
                                                        if (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year > dtTempDate.year) {
                                                            testBool = true;
                                                        }
                                                        //  If year, month and day are equal
                                                        else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month > dtTempDate.month)) {
                                                            testBool = true;
                                                        }
                                                        else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.day > dtTempDate.day)) {
                                                            testBool = true;
                                                        }
                                                        else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.day == dtTempDate.day)) {
                                                            testBool = true;
                                                        }
                                                        else {
                                                            testBool = false;
                                                        }
                                                        
                                                        //  SIR 22196
                                                        // Conditional added to check if the PAL Service Authorization is
                                                        // pending.  If it is the PAL stage should not be allowed to close
                                                        
                                                        if (testBool) {
                                                            
                                                            if (0 != CONTRACT_STATUS_CLOSED.compareTo(pCSES80DOutputRec.getSzCdCnperStatus())) {
                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = INDICATOR_YES;
                                                            }
                                                            
                                                            else {
                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = Cint14s.INDICATOR_NO;
                                                            }
                                                        }
                                                        
                                                        
                                                        
                                                        else {
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = Cint14s.INDICATOR_NO;
                                                        }
                                                        
                                                        RetVal = SUCCESS;
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                                        break;
                                                        
                                                    default :
                                                        //  Set RetVal to FND_SUCCESS
                                                        RetVal = Csub50s.FND_FAIL;
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                        break;
                                                }
                                            }
                                            
                                            // 
                                            // (END) CSES80D: Retrieve Contract Period table information
                                            // 
                                            
                                            //  Set RetVal to FND_SUCCESS
                                            RetVal = SUCCESS;
                                            
                                            
                                            break;
                                            
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Call DAM
                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                            
                                            break;
                                            
                                        default :
                                            
                                            //  Increment the warning counter.
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            
                                            break;
                                    }
                                    
                                    if (SUCCESS == RetVal) {
                                        
                                        //  Loop through all contract rows returned from the previous DAMs
                                        for (m = 0;m < ulContractQty;m++) {
                                            
                                            if (INDICATOR_YES == pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) {
                                                
                                                // 
                                                // (BEGIN): CSES81D - Contract Version retrieve for an idContract
                                                // , contract period number, and version end date that is greater
                                                // than the current date.
                                                // 
                                                
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCSES81DInputRec = new CSES81DI();
                                                
                                                pCSES81DOutputRec = new CSES81DO();
                                                pCSES81DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                                
                                                //  Increment the id_event counter telling CCMN62D how many
                                                // id_events to expect for closure.
                                                pCSES81DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                pCSES81DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod);
                                                rc = cses81dQUERYdam(sqlca, pCSES81DInputRec, pCSES81DOutputRec);
                                                
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                        
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnverVersion = pCSES81DOutputRec.getUlNbrCnverVersion();
                                                        pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate3 = pCSES81DOutputRec.getTsLastUpdate();
                                                        
                                                        // 
                                                        // (BEGIN): CLSS13D - Retrieve contract service codes for
                                                        // the contract, period, and version passed to the DAM.
                                                        // 
                                                        pCLSS13DInputRec = new CLSS13DI();
                                                        
                                                        pCLSS13DOutputRec = new CLSS13DO();
                                                        
                                                        pCLSS13DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                                        pCLSS13DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                        pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
                                                        pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                                        rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
                                                        
                                                        
                                                        
                                                        //  Analyze return code
                                                        switch (rc) {
                                                                
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                tmpSvcRowQty1 = pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();
                                                                for (j = 0;j < pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate5[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getTsLastUpdate();
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnsvcVersion[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcVersion();
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCnsvc[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlIdCnsvc();
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnsvcLineItem[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcLineItem();
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnsvcUnitRate[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcUnitRate();
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].ulAmtCnsvcUnitRateUsed[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlAmtCnsvcUnitRateUsed();
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].szNbrCnsvcUnitType[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzNbrCnsvcUnitType();
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzCdCnsvcService();
                                                                    
                                                                    if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                                        
                                                                        bIndFosterContractExists = true;
                                                                        bIndUpdateFosterContract = 1;
                                                                    }
                                                                    
                                                                    if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                                        
                                                                        bIndAdoptContractExists = true;
                                                                        bIndUpdateAdoptContract = 1;
                                                                    }
                                                                    if (tempSvcRowQty >= 0) {
                                                                        pCLSS68DInputRec = new CLSS68DI();
                                                                        
                                                                        pCLSS68DOutputRec = new CLSS68DO();
                                                                        pCLSS68DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                                                        pCLSS68DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                                        pCLSS68DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod);
                                                                        pCLSS68DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnverVersion);
                                                                        pCLSS68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS68DO._CLSS68DO__ROWCLSS68DO_SIZE);
                                                                        pCLSS68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                                                        rc = clss68dQUERYdam(sqlca, pCLSS68DInputRec, pCLSS68DOutputRec);
                                                                        
                                                                        
                                                                        //  Analyze return code
                                                                        switch (rc) {
                                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                
                                                                                //  Call DAM
                                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                                tempSvcRowQty = pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].ulSysNbrGenericCntr = pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getSzCdCncntyService();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate4[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getTsLastUpdate();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCncnty[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlIdCncnty();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyCounty[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getSzCdCncntyCounty();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCncntyEffective[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getDtDtCncntyEffective();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCncntyEnd[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getDtDtCncntyEnd();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCncntyPeriod[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyPeriod();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCncntyVersion[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyVersion();
                                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCncntyLineItem[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyLineItem();
                                                                                
                                                                                
                                                                                break;
                                                                            case NO_DATA_FOUND:
                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                
                                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                                tempSvcRowQty = - 1;
                                                                                
                                                                                break;
                                                                            default :
                                                                                
                                                                                RetVal = Csub50s.FND_FAIL;
                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                                                
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_CON_NO_SVC_CODE;
                                                                bIndFosterContractExists = false;
                                                                bIndUpdateFosterContract = 0;
                                                                
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                
                                                                // Break for CSEC33D SQL_SUCCESS for REQUESTED LOC search
                                                                break;
                                                                
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                                
                                                                break;
                                                        }
                                                        
                                                        
                                                        // 
                                                        // (END): CLSS13D - Retrieve contract service codes for
                                                        // the contract, period, and version passed to the DAM.
                                                        // 
                                                        
                                                        
                                                        // Set RetVal to FND_SUCCESS
                                                        RetVal = SUCCESS;
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        break;// Break for SQL_SUCCESS for BILLING
                                                        
                                                    default :
                                                        //  Set RetVal to FND_FAIL
                                                        RetVal = Csub50s.FND_FAIL;
                                                        //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                                                        // SQL error returned from the DAM.
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                        
                                                        // Break for CSEC33D SQL_SUCCESS for REQUESTED LOC search
                                                        break;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (SUCCESS == RetVal) {
                                    
                                    // 
                                    // (BEGIN) CINT20D: Retrieve Primary Worker from Stage Person Link.
                                    // 
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCINT20DInputRec = new CINT20DI();
                                    
                                    pCINT20DOutputRec = new CINT20DO();
                                    
                                    pCINT20DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                    pCINT20DInputRec.setUlIdStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
                                    pCINT20DInputRec.setSzCdStagePersRole(PERSON_STAGE_ROLE_PRIMARY);
                                    pCINT20DInputRec.setSzCdStagePersType(Cint12s.PERSON_TYPE_WORKER);
                                    rc = cint20dQUERYdam(sqlca, pCINT20DInputRec, pCINT20DOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager = pCINT20DOutputRec.getUlIdPerson();
                                            
                                            
                                            RetVal = SUCCESS;
                                            
                                            break;
                                            
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                            
                                        default :
                                            //  Set RetVal to FND_FAIL
                                            RetVal = Csub50s.FND_FAIL;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            break;// Break for SQL_NOT_FOUND for search for BILLING
                                    }
                                    
                                    // 
                                    // (END) CINT20D: Retrieve Primary Worker from Stage Person Link.
                                    // 
                                    // 
                                    // (BEGIN): CRES13D Retrieve Resource Address
                                    // 
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCRES13DInputRec = new CRES13DI();
                                    
                                    pCRES13DOutputRec = new CRES13DO();
                                    pCRES13DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                    pCRES13DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES13DO._CRES13DO__ROWCRES13DO_SIZE);
                                    pCRES13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                    pCRES13DInputRec.setUlIdResource(cfad38si.getUlIdResource());
                                    rc = cres13dQUERYdam(sqlca, pCRES13DInputRec, pCRES13DOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Set Return Value to FND_SUCCESS
                                            RetVal = SUCCESS;
                                            
                                            //  Populate Output Message
                                            
                                            //  Set fields in CFAD07SOG01 to fields in CRES13DO
                                            
                                            for (l = 0;l < pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();l++) {
                                                if ((0 == RSRC_BUIS_ADDR.compareTo(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getSzCdRsrcAddrType())) && (pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getSzNbrRsrcAddrVid() != null)) {
                                                    ulTempIdRsrcAddress = pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getUlIdRsrcAddress();
                                                    
                                                    l = pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();
                                                }
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = Csub50s.FND_FAIL;
                                            break;// END SQL_SUCCESS for main block
                                            
                                            
                                        default :
                                            pServiceStatus.explan_code = FND_ERROR;
                                            
                                            //  Set Return Value to FND_ERROR
                                            RetVal = FND_ERROR;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            
                                            break;
                                    }
                                }
                                
                                if (RetVal == SUCCESS) //  neither the user nor any of the designees is the approver,
                                // check for access to the Unit
                                {
                                    //  Only create new contracts if one does not exist for foster or adoptive
                                    // contracts.
                                    while ((!bIndAdoptContractExists) || (!bIndFosterContractExists)) {
                                        
                                        if (!bIndAdoptContractExists) {
                                            bIndAdoptContractExists = true;
                                            usCreateContract = ADOPTIVE;
                                        }
                                        else if (!bIndFosterContractExists) {
                                            bIndFosterContractExists = true;
                                            usCreateContract = Ccfc51u.FOSTER;
                                        }
                                        
                                        
                                        //  ADD 
                                        
                                        //  Call DAM CSES82D to retrieve szCdRsrcSvcRegion.
                                        // Input is szCdRsrcSvcCnty.
                                        
                                        // 
                                        // (BEGIN): CSES82D
                                        // 
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCSES82DInputRec = new CSES82DI();
                                        
                                        pCSES82DOutputRec = new CSES82DO();
                                        pCSES82DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                        pCSES82DInputRec.setSzCdRsrcSvcCnty(cfad38si.getSzCdRsrcCnty());
                                        rc = cses82dQUERYdam(sqlca, pCSES82DInputRec, pCSES82DOutputRec);
                                        
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                cfad38si.setSzCdRshsRegion(pCSES82DOutputRec.getSzCdRsrcSvcRegion());
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                break;
                                                
                                            default :
                                                //  Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                                                // SQL error returned from the DAM.
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        
                                        // 
                                        // END CSES82D
                                        // 
                                        
                                        
                                        // 
                                        // (BEGIN): CAUD01D CONTRACT AUD
                                        // 
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCAUD01DInputRec = new CAUD01DI();
                                        
                                        pCAUD01DOutputRec = new CAUD01DO();
                                        
                                        pCAUD01DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                        pCAUD01DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        pCAUD01DInputRec.setUlIdResource(cfad38si.getUlIdResource());
                                        pCAUD01DInputRec.setSzCdCntrctFuncType(STAGE_CD_FAD);
                                        pCAUD01DInputRec.setSzCdCntrctProgramType(FA_PROGRAM);
                                        pCAUD01DInputRec.setSzCdCntrctProcureType(PROVIDER_ENROLL);
                                        
                                        pCAUD01DInputRec.setSzCdCntrctRegion(cfad38si.getSzCdRshsRegion());
                                        pCAUD01DInputRec.setCIndCntrctBudgLimit(NO_LIMIT);
                                        pCAUD01DInputRec.setUlIdRsrcAddress(ulTempIdRsrcAddress);
                                        pCAUD01DInputRec.setUlIdCntrctManager(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                                        pCAUD01DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                        
                                        //  Call DAM
                                        rc = caud01dAUDdam(sqlca, pCAUD01DInputRec, pCAUD01DOutputRec);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                
                                                // Pass returned contract into the temporary variable
                                                ulIdTempContract = pCAUD01DOutputRec.getUlIdContract();
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                //  Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                
                                                break;
                                        }
                                        
                                        // 
                                        // END CAUD01D
                                        // 
                                        // 
                                        // BEGIN CAUD20D  CONTRACT PERIOD
                                        // 
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCAUD20DInputRec = new CAUD20DI();
                                        
                                        pCAUD20DOutputRec = new CAUD20DO();
                                        pCAUD20DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                        pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        pCAUD20DInputRec.setUlIdContract(ulIdTempContract);
                                        //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                                        // SQL error returned from the DAM.
                                        pCAUD20DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                        
                                        
                                        pCAUD20DInputRec.setUlNbrCnperPeriod(Ccmn19s.ONE);
                                        
                                        rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                        
                                        dtCurrentDate = dtTempDate;
                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                        pCAUD20DInputRec.setDtDtCnperClosure(dtCurrentDate);
                                        pCAUD20DInputRec.setDtDtCnperTerm(dtCurrentDate);
                                        pCAUD20DInputRec.setDtDtCnperStart(dtTempDate);
                                        pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_ACTIVE);
                                        pCAUD20DInputRec.setCIndCnperRenewal(NO_RENEWAL);
                                        pCAUD20DInputRec.setCIndCnperSigned(SIGNED_YES);
                                        rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
                                        
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                if ((int) Cint14s.INDICATOR_NO == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                                                }
                                                else {
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    // 
                                                    // BEGIN CAUD15D  CONTRACT VERSION
                                                    // 
                                                    
                                                    //   CAUD15D - CONTRACT VERSION AUD
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCAUD15DInputRec = new CAUD15DI();
                                                    
                                                    pCAUD15DOutputRec = new CAUD15DO();
                                                    
                                                    pCAUD15DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                                    
                                                    pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                    pCAUD15DInputRec.setUlIdContract(ulIdTempContract);
                                                    pCAUD15DInputRec.setUlNbrCnverPeriod(Ccmn19s.ONE);
                                                    pCAUD15DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                                    pCAUD15DInputRec.setUlNbrCnverVersion(Ccmn19s.ONE);
                                                    rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                    
                                                    dtCurrentDate = dtTempDate;
                                                    pCAUD15DInputRec.setDtDtCnverCreate(dtTempDate);
                                                    pCAUD15DInputRec.setDtDtCnverEffective(dtTempDate);
                                                    
                                                    // Retrieve Case Id for the current stage
                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                    pCAUD15DInputRec.setDtDtCnverEnd(dtCurrentDate);
                                                    pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                                                    
                                                    //  Call DAM
                                                    rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            break;
                                                            
                                                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                            
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                            break;// break for CLSS70D
                                                    }
                                                    
                                                    break;
                                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                    
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                    break;// break for SQL_NOT_FOUND of CSEC26D
                                                    
                                                }
                                        }
                                        
                                        if (Ccfc51u.FOSTER == usCreateContract) {
                                            // 
                                            // BEGIN CAUD17D - CONTRACT SERVICE
                                            // 
                                            
                                            pCAUD17DInputRec = new CAUD17DI();
                                            
                                            pCAUD17DOutputRec = new CAUD17DO();
                                            pCAUD17DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                            pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                            pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                                            
                                            pCAUD17DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                            pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                                            pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                                            
                                            pCAUD17DInputRec.setSzNbrCnsvcUnitType(DAY_24_HOURS);
                                            pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                                            pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                            
                                            usCountyRow = 0;
                                            
                                            // SIR 19613
                                            while (usCountyRow < NBR_SVC_CODE_SIXTY_ABCD && RetVal == SUCCESS) {
                                                pCAUD17DInputRec.setUlNbrCnsvcLineItem(usCountyRow + 1);
                                                
                                                //  Analyze return code
                                                switch (usCountyRow) {
                                                        
                                                    case 0:
                                                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_BASIC);
                                                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_BASIC);
                                                        break;
                                                    case 1:
                                                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_MOD);
                                                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_MOD);
                                                        
                                                        break;
                                                    case 2:
                                                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_SPEC);
                                                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_SPEC);
                                                        
                                                        break;
                                                    case 3:
                                                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_INT);
                                                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_INT);
                                                        
                                                        break;
                                                        
                                                    default :
                                                        
                                                        break;
                                                }
                                                
                                                rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                                switch (rc) {
                                                        
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        RetVal = SUCCESS;
                                                        
                                                        break;
                                                        
                                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                        RetVal = Csub50s.FND_FAIL;
                                                        
                                                        break;
                                                        
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                        RetVal = Csub50s.FND_FAIL;
                                                        
                                                        break;
                                                }
                                                usCountyRow++;
                                            }
                                        }
                                        
                                        if (ADOPTIVE == usCreateContract) {
                                            // 
                                            // BEGIN CAUD17D
                                            // 
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCAUD17DInputRec = new CAUD17DI();
                                            
                                            pCAUD17DOutputRec = new CAUD17DO();
                                            pCAUD17DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                            pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                            pCAUD17DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                            pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                                            pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                                            pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                                            pCAUD17DInputRec.setUlNbrCnsvcLineItem(Ccmn19s.ONE);
                                            pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_ADP_SUB);
                                            pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                                            pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                            pCAUD17DInputRec.setSzNbrCnsvcUnitType(ADOPTION_SUBSIDY);
                                            pCAUD17DInputRec.setUlNbrCnsvcUnitRate(SUBSIDY_PAYMENT);
                                            rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    pCAUD17DInputRec = new CAUD17DI();
                                                    
                                                    pCAUD17DOutputRec = new CAUD17DO();
                                                    pCAUD17DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                                    pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                    pCAUD17DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                                    pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                                                    pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                                                    pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                                                    pCAUD17DInputRec.setUlNbrCnsvcLineItem(TWO);
                                                    pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_ADP_NON_REC_SUB);
                                                    pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                                                    pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                                    pCAUD17DInputRec.setSzNbrCnsvcUnitType(ADOPTION_SUBSIDY);
                                                    pCAUD17DInputRec.setUlNbrCnsvcUnitRate(SUBSIDY_PAYMENT);
                                                    rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            break;
                                                            
                                                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                            
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                            
                                                            break;
                                                    }
                                                    break;
                                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                    break;
                                            }
                                            
                                        }
                                        
                                        usCountyRow = 0;
                                        
                                        // SIR 19613, 22390, 22485 If the home is baisic, only 63A will be written to
                                        // Contract_County table, if it is Habil, Ther, or prim med, 63A, B, C & D
                                        // will be written to the contract_county table
                                        
                                        ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_A;
                                        
                                        if (Ccfc51u.FOSTER == usCreateContract) {
                                            
                                            if (cfad38si.getCCdRsrcFaHomeType1()[0] == null) {
                                                ulAdoptiveOrFoster = 0;
                                            }
                                            else {
                                                //  SIR 22686 loop through the rows to see if any of them
                                                // are group homes, if they are set an indicator
                                                for (usCountyRow = 0;usCountyRow < NBR_OF_HOME_TYPE;usCountyRow++) {
                                                    
                                                    if (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_GROUP) {
                                                        
                                                        bGroupHome = true;
                                                        break;
                                                    }
                                                }
                                                for (usCountyRow = 0;usCountyRow < NBR_OF_HOME_TYPE;usCountyRow++) {
                                                    if ((cfad38si.getCCdRsrcFaHomeType1()[usCountyRow] == FOST_TYPE_HABIL) || (cfad38si.getCCdRsrcFaHomeType1()[usCountyRow] == FOST_TYPE_THER) || (cfad38si.getCCdRsrcFaHomeType1()[usCountyRow] == FOST_TYPE_PRIM_MED)) {
                                                        if (!bGroupHome) {
                                                            // 19613, 22390, 22485 Habil, Ther, and Prim Med homes use two codes 63A, B, C & D
                                                            ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABCD;
                                                            break;
                                                        }
                                                        else {
                                                            ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABC;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        
                                        // 19613
                                        else if (ADOPTIVE == usCreateContract) {
                                            ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_AB;
                                        }
                                        else {
                                            ulAdoptiveOrFoster = 0;
                                            
                                        }
                                        // 
                                        // BEGIN CAUD08D - Contract County Insert
                                        // 
                                        
                                        pCAUD08DInputRec = new CAUD08DI();
                                        
                                        pCAUD08DOutputRec = new CAUD08DO();
                                        pCAUD08DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                        pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        pCAUD08DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                        
                                        //  Initialize current date to dtTempDate(today's date) and
                                        // Add years, no months and no years to dtCurrentDate
                                        dtCurrentDate = dtTempDate;
                                        
                                        //  Call DAM
                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                        pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                                        pCAUD08DInputRec.setUlIdContract(ulIdTempContract);
                                        pCAUD08DInputRec.setUlIdResource(cfad38si.getUlIdResource());
                                        pCAUD08DInputRec.setSzCdCncntyCounty(cfad38si.getSzCdRsrcCnty());
                                        pCAUD08DInputRec.setDtDtCncntyEffective(dtTempDate);
                                        pCAUD08DInputRec.setUlNbrCncntyPeriod(Ccmn19s.ONE);
                                        pCAUD08DInputRec.setUlNbrCncntyVersion(Ccmn19s.ONE);
                                        
                                        usCountyRow = 0;
                                        //   County AUD processing CAUD08D
                                        // SIR 19613
                                        while (usCountyRow < ulAdoptiveOrFoster && SUCCESS == pServiceStatus.explan_code) {
                                            
                                            if (Ccfc51u.FOSTER == usCreateContract && bFoster) {
                                                
                                                //  Analyze error code
                                                switch (usCountyRow) {
                                                    case 0:
                                                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_BASIC);
                                                        break;
                                                    case 1:
                                                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_MOD);
                                                        break;
                                                    case 2:
                                                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_SPEC);
                                                        break;
                                                    case 3:
                                                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_INT);
                                                        break;
                                                        
                                                    default :
                                                        break;
                                                }
                                            }
                                            if ((ADOPTIVE == usCreateContract) && (Csub17s.ZERO == usCountyRow)) {
                                                pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_ADP_SUB);
                                            }
                                            if ((ADOPTIVE == usCreateContract) && (Ccmn19s.ONE == usCountyRow)) {
                                                pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_ADP_NON_REC_SUB);
                                            }
                                            pCAUD08DInputRec.setUlNbrCncntyLineItem((usCountyRow + Ccmn19s.ONE));
                                            rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                                            
                                            //  Analyze error code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    RetVal = SUCCESS;
                                                    break;
                                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = WtcHelperConstants.SQL_DUPLICATE_KEY;
                                                    RetVal = Csub50s.FND_FAIL;
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                    RetVal = Csub50s.FND_FAIL;
                                                    break;
                                            }
                                            usCountyRow++;
                                        }
                                    }
                                }
                                if ((RetVal == SUCCESS) && ((0 == cfad38si.getSzCdRsrcFaHomeStatus().compareTo(HOME_STATUS_APVD_INACT)) || (0 == cfad38si.getSzCdRsrcFaHomeStatus().compareTo(HOME_STATUS_APVD_ACT)))) {
                                    //  Set counter for contract rows to zero
                                    m = 0;
                                    
                                    //  Only modify contracts when flags are TRUE
                                    while (bIndUpdateAdoptContract != 0 || bIndUpdateFosterContract != 0) {
                                        if (INDICATOR_YES == pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) {
                                            if (bIndUpdateAdoptContract != 0 && (0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]))) {
                                                bIndUpdateAdoptContract = 0;
                                                usUpdateContract = ADOPTIVE;
                                            }
                                            
                                            else if (bIndUpdateFosterContract != 0 && (0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]))) {
                                                bIndUpdateFosterContract = 0;
                                                usUpdateContract = Ccfc51u.FOSTER;
                                            }
                                            // 
                                            // BEGIN CAUD20D  CONTRACT PERIOD
                                            // 
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCAUD20DInputRec = new CAUD20DI();
                                            
                                            pCAUD20DOutputRec = new CAUD20DO();
                                            pCAUD20DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                                            pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                            pCAUD20DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                            pCAUD20DInputRec.setUlIdCntrctWkr(cfad38si.getUlIdCntrctWkr());
                                            pCAUD20DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod);
                                            pCAUD20DInputRec.setDtDtCnperClosure(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperClosure);
                                            pCAUD20DInputRec.setDtDtCnperTerm(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm);
                                            pCAUD20DInputRec.setDtDtCnperStart(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperStart);
                                            if (!(cfad38si.getSzCdRsrcFaHomeStatus().compareTo(HOME_STATUS_APVD_INACT) != 0)) {
                                                pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_SERVICE_HOLD);
                                            }
                                            
                                            else if (!(cfad38si.getSzCdRsrcFaHomeStatus().compareTo(HOME_STATUS_APVD_ACT) != 0)) {
                                                pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_ACTIVE);
                                            }
                                            pCAUD20DInputRec.setCIndCnperRenewal('N');
                                            pCAUD20DInputRec.setCIndCnperSigned('Y');
                                            pCAUD20DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate2);
                                            rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
                                            
                                            //  Analyze error code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    
                                                    // 
                                                    // populate Input Structure for DAM 
                                                    // County, Region, IdOnCall
                                                    
                                                    if (false == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                                                    }
                                                    
                                                    else {
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                    }
                                                    break;
                                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                    
                                                    break;
                                            }
                                            if ((INDICATOR_YES == pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) && (usUpdateContract == Ccfc51u.FOSTER) && (0 == HOME_STATUS_APVD_ACT.compareTo(cfad38si.getSzCdRsrcFaHomeStatus())) && (INDICATOR_YES == cfad38si.getCIndRshsNonPrs()) && (INDICATOR_YES == cfad38si.getCSysIndFosterTypeChange() || INDICATOR_YES == cfad38si.getCSysIndCategoryChange())) {
                                                rc = Ccmn35s.ContractVerSerCnty(cfad38si, pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract, pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod, cfad38si.getUlIdResource() , pServiceStatus);
                                                
                                                // if region is 98(statewide), then use code  "255" for county
                                                if (rc != SUCCESS) {
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                }
                                            }
                                        }
                                        m++;
                                    }
                                }
                            }
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            RetVal = Csub50s.FND_FAIL;
                            
                            break;
                        default :// CAUD98D
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                    break;
                default :// CCMN01U
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            
            
            //  SIR 11917- Added the TODO AUD Dam, CAUDB7D, to the
            // save service so that whenever the data for FAD to do's
            // is saved, the associated TODOs, if any, will
            // be taken off the Staff TODO List.The CAUDB7D dam updates
            // the date TODO completed and removes the TODO from the
            // TODO list whenever the window data is saved.
            
            pCAUDB7DInputRec = new CAUDB7DI();
            
            pCAUDB7DOutputRec = new CAUDB7DO();
            pCAUDB7DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
            pCAUDB7DInputRec.getArchInputStruct().setCReqFuncCd(cfad38si.getArchInputStruct().getCReqFuncCd());
            pCAUDB7DInputRec.setUlIdStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
            pCAUDB7DInputRec.setSzCdTodoTask(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getSzCdTask());
            rc = caudb7dAUDdam(sqlca, pCAUDB7DInputRec, pCAUDB7DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    
                    break;
            }
        }
        
        /* Analyze error code */
        if (SUCCESS == RetVal) {
            // 
            // (BEGIN): Retrieve DAM: csec25d      Facility_loc simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCSEC25DInputRec = new CSEC25DI();
            
            pCSEC25DOutputRec = new CSEC25DO();
            pCSEC25DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
            
            pCSEC25DInputRec.setUlIdResource(cfad38si.getUlIdResource());
            rc = ARC_UTLGetDateAndTime(pCSEC25DInputRec.getDtDtPlcmtStart() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            rc = csec25dQUERYdam(sqlca, pCSEC25DInputRec, pCSEC25DOutputRec);
            
            //  Populate Input Structure for DAM
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    RetVal = SUCCESS;
                    pCSEC25DOutputRec.setCCdFlocStatus1((char) (0));
                    pCSEC25DOutputRec.setCCdFlocStatus2((char) (0));
                    pCSEC25DOutputRec.setCCdFlocStatus3((char) (0));
                    pCSEC25DOutputRec.setCCdFlocStatus4((char) (0));
                    pCSEC25DOutputRec.setCCdFlocStatus5((char) (0));
                    pCSEC25DOutputRec.setCCdFlocStatus6((char) (0));
                    
                    
                    
                    
                    break;
                    
                default :
                    
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    
                    break;
            }
            
            // Analyze error code
            if (SUCCESS == RetVal) {
                //  Any types checked processing -
                // Set the usTypeChecked with # rows checked.
                
                //  SIR #5379 - 6/6/96 - PURCELA - Set a pound define for number of
                // times to loop through F/A Home types to determine Facility LOC.
                // Previous looping was occurring too many times which caused garbage to
                // be held in one Foster Type.  This was triggering a Facility Level of
                // Care to be created for Adoptive Homes, and this should never happen.
                
                for (usLbRow = 0;usLbRow < NUM_FOSTER_TYPES;usLbRow++) {
                    if (cfad38si.getCCdRsrcFaHomeType1()[usLbRow] != null) {
                        usTypeChecked++;
                        
                        break;
                    }
                }
                
                //  Any Habitative, Therapuetic or Primary medical checked processing -
                // Set the usType2Checked with # rows checked.
                //  SIR #5379 - 6/6/96 - PURCELA - Set a pound define for number of
                // times to loop through F/A Home types to determine Facility LOC.
                // Previous looping was occurring too many times which caused garbage to
                // be held in one Foster Type.  This was triggering a Facility Level of
                // Care to be created for Adoptive Homes, and this should never happen.
                
                
                for (usLbRow = 0;usLbRow < NUM_FOSTER_TYPES;usLbRow++) {
                    if ((FOST_TYPE_HABIL == cfad38si.getCCdRsrcFaHomeType1()[usLbRow]) || (FOST_TYPE_THER == cfad38si.getCCdRsrcFaHomeType1()[usLbRow]) || (FOST_TYPE_PRIM_MED == cfad38si.getCCdRsrcFaHomeType1()[usLbRow])) {
                        usType2Checked++;
                    }
                    
                    // if region is 98(statewide), then use code  "255" for county
                    if (FOST_TYPE_GROUP == cfad38si.getCCdRsrcFaHomeType1()[usLbRow]) {
                        bGroupHome = true;
                    }
                }
                
                // Analyze error code
                if (!(HOME_STATUS_PENDING_APPROVAL.compareTo(cfad38si.getSzCdRsrcFaHomeStatus()) != 0)) {
                    if ((pCSEC25DOutputRec.getCCdFlocStatus1() == 0) && (usTypeChecked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus1(FLOC_HOLD);
                        bInsert = 1;
                    }
                    
                    if ((pCSEC25DOutputRec.getCCdFlocStatus2() == 0) && (usTypeChecked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus2(FLOC_HOLD);
                        bInsert = 1;
                    }
                    if ((pCSEC25DOutputRec.getCCdFlocStatus3() == 0) && (usType2Checked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus3(FLOC_HOLD);
                        bInsert = 1;
                    }
                    
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus3() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus3((char) (0));
                        bInsert = 1;
                    }
                    if ((pCSEC25DOutputRec.getCCdFlocStatus4() == 0) && (usType2Checked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus4(FLOC_HOLD);
                        bInsert = 1;
                    }
                    
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus4() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus4((char) (0));
                        bInsert = 1;
                    }
                    
                    //  Analyze error code
                    if ((pCSEC25DOutputRec.getCCdFlocStatus5() == 0) && (usType2Checked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus5(FLOC_HOLD);
                        bInsert = 1;
                    }
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus5() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus5((char) (0));
                        bInsert = 1;
                    }
                    
                    if ((pCSEC25DOutputRec.getCCdFlocStatus6() == 0) && (usType2Checked > 0) &&!bGroupHome) {
                        pCSEC25DOutputRec.setCCdFlocStatus6(FLOC_HOLD);
                        bInsert = 1;
                    }
                    
                    
                    
                    
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus6() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus6((char) (0));
                        bInsert = 1;
                    }
                    
                    else if (pCSEC25DOutputRec.getCCdFlocStatus6() == FLOC_ACTIVE && bGroupHome) {
                        pCSEC25DOutputRec.setCCdFlocStatus6((char) (0));
                        bInsert = 1;
                    }
                }
                
                else if (!(HOME_STATUS_APVD_ACT.compareTo(cfad38si.getSzCdRsrcFaHomeStatus()) != 0)) {
                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                    
                    
                    
                    if ((pCSEC25DOutputRec.getCCdFlocStatus1() != FLOC_ACTIVE) && (usTypeChecked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus1(FLOC_ACTIVE);
                        bInsert = 1;
                    }
                    
                    //## BEGIN TUX/XML: Call another Tuxedo service: CARC07S
                    if ((pCSEC25DOutputRec.getCCdFlocStatus2() != FLOC_ACTIVE) && (usTypeChecked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus2(FLOC_ACTIVE);
                        bInsert = 1;
                    }
                    
                    if ((pCSEC25DOutputRec.getCCdFlocStatus3() != FLOC_ACTIVE) && (usType2Checked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus3(FLOC_ACTIVE);
                        bInsert = 1;
                    }
                    
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus3() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus3((char) (0));
                        bInsert = 1;
                    }
                    if ((pCSEC25DOutputRec.getCCdFlocStatus4() != FLOC_ACTIVE) && (usType2Checked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus4(FLOC_ACTIVE);
                        bInsert = 1;
                    }
                    
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus4() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus4((char) (0));
                        bInsert = 1;
                    }
                    if ((pCSEC25DOutputRec.getCCdFlocStatus5() != FLOC_ACTIVE) && (usType2Checked > 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus5(FLOC_ACTIVE);
                        bInsert = 1;
                    }
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus5() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus5((char) (0));
                        bInsert = 1;
                    }
                    if ((pCSEC25DOutputRec.getCCdFlocStatus6() != FLOC_ACTIVE) && (usType2Checked > 0) &&!bGroupHome) {
                        pCSEC25DOutputRec.setCCdFlocStatus6(FLOC_ACTIVE);
                        bInsert = 1;
                    }
                    else if ((pCSEC25DOutputRec.getCCdFlocStatus6() == FLOC_ACTIVE) && (usType2Checked == 0)) {
                        pCSEC25DOutputRec.setCCdFlocStatus6((char) (0));
                        bInsert = 1;
                    }
                    else if (pCSEC25DOutputRec.getCCdFlocStatus6() == FLOC_ACTIVE && bGroupHome) {
                        pCSEC25DOutputRec.setCCdFlocStatus6((char) (0));
                        bInsert = 1;
                    }
                }
                
                if (bInsert) {
                    //  Insert new LOC rec
                    pCAUD80DInputRec = new CAUD80DI();
                    
                    pCAUD80DOutputRec = new CAUD80DO();
                    pCAUD80DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
                    pCAUD80DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCAUD80DInputRec.setCCdFlocStatus1(pCSEC25DOutputRec.getCCdFlocStatus1());
                    pCAUD80DInputRec.setCCdFlocStatus2(pCSEC25DOutputRec.getCCdFlocStatus2());
                    pCAUD80DInputRec.setCCdFlocStatus3(pCSEC25DOutputRec.getCCdFlocStatus3());
                    pCAUD80DInputRec.setCCdFlocStatus4(pCSEC25DOutputRec.getCCdFlocStatus4());
                    pCAUD80DInputRec.setCCdFlocStatus5(pCSEC25DOutputRec.getCCdFlocStatus5());
                    pCAUD80DInputRec.setCCdFlocStatus6(pCSEC25DOutputRec.getCCdFlocStatus6());
                    pCAUD80DInputRec.setCCdFlocStatus7(null);
                    pCAUD80DInputRec.setCCdFlocStatus8(null);
                    pCAUD80DInputRec.setCCdFlocStatus9(null);
                    pCAUD80DInputRec.setCCdFlocStatus10(null);
                    pCAUD80DInputRec.setCCdFlocStatus11(null);
                    pCAUD80DInputRec.setCCdFlocStatus12(null);
                    pCAUD80DInputRec.setCCdFlocStatus13(null);
                    pCAUD80DInputRec.setCCdFlocStatus14(null);
                    pCAUD80DInputRec.setCCdFlocStatus15(null);
                    
                    //  Set CAUD80D Floc Effective date
                    // to SystemDate
                    ARC_UTLGetDateAndTime(pCAUD80DInputRec.getDtDtFlocEffect() , 0);
                    pCAUD80DInputRec.getDtDtFlocEnd().month = 12;
                    pCAUD80DInputRec.getDtDtFlocEnd().day = 31;
                    pCAUD80DInputRec.getDtDtFlocEnd().year = 4712;
                    pCAUD80DInputRec.setUlIdResource(cfad38si.getUlIdResource());
                    pCAUD80DInputRec.setCIndFlocCancelAudit(INDICATOR_YES);
                    
                    if (bGroupHome) {
                        pCAUD80DInputRec.setSNbrFlocLevelsOfCare(5);
                    }
                    else if (null != pCSEC25DOutputRec.getCCdFlocStatus6()) {
                        pCAUD80DInputRec.setSNbrFlocLevelsOfCare(6);
                    }
                    else {
                        pCAUD80DInputRec.setSNbrFlocLevelsOfCare(2);
                    }
                    // SELECT I.*, P.NM_PERSON_FULL
                    // FROM    INCOME_AND_RESOURCES I,PERSON  P
                    // WHERE   I.ID_PERSON =  :?
                    rc = caud80dAUDdam(sqlca, pCAUD80DInputRec, pCAUD80DOutputRec);
                    
                    //  Analyze error code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            RetVal = SUCCESS;
                            
                            
                            
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            RetVal = Csub50s.FND_FAIL;
                            
                            
                            break;
                    }
                }
            }
        }
        
        if (SUCCESS == RetVal && FND_YES == cfad38si.getCSysIndAppStatusChange()) {
            pTodoCommonInput = new CSUB40UI();
            
            pTodoCommonOutput = new CSUB40UO();
            pTodoCommonInput.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD047");
            
            // SIR - 3321
            // Set CSUB40UI DtTodoCfDueFrom
            // to SystemDate
            ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
            
            pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfDesc("If ");
            pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += cfad38si.getSzNmResource() + " Home is still an Applicant, please follow-up.";
            rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
                    break;
                default :// CSUB40U
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    RetVal = Csub50s.FND_FAIL;
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    // END SIR 14420
                    
                    
                    
                    
                    break;
            }
        }
        
        if (INDICATOR_YES == cfad38si.getCSysIndFosterTypeChange()) {
            pCLSC51DInputRec = new CLSC51DI();
            
            pCLSC51DOutputRec = new CLSC51DO();
            pCLSC51DInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
            pCLSC51DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            pCLSC51DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC51DO._CLSC51DO__ROWCLSC51DO_SIZE);
            pCLSC51DInputRec.setSzCdPlcmtActPlanned(PLCMT_ACTUAL);
            
            //  Set CLSC51D Rshs Effective date
            // to SystemDate
            ARC_UTLGetDateAndTime(pCLSC51DInputRec.getDtDtRshsEffective() , 0);
            //  Set CLSC51D Rshs End date
            // to SystemDate
            ARC_UTLGetDateAndTime(pCLSC51DInputRec.getDtDtRshsEnd() , 0);
            pCLSC51DInputRec.setUlIdRsrcFacil(cfad38si.getUlIdResource());
            // insert into income_and_resources table
            rc = clsc51dQUERYdam(sqlca, pCLSC51DInputRec, pCLSC51DOutputRec);
            
            //  Analyze error code
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    //  Send ToDo to each worker
                    
                    for (i219 = 0;i219 < pCLSC51DOutputRec.getArchOutputStruct().getUlRowQty() && SUCCESS == RetVal;i219++) {
                        pTodoCommonInput = new CSUB40UI();
                        
                        pTodoCommonOutput = new CSUB40UO();
                        pTodoCommonInput.getArchInputStruct().setCReqFuncCd(cfad38si.getArchInputStruct().getCReqFuncCd());
                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf("FAD027");
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
                        
                        //  Set CSUB40UI DtTodoCfDueFrom
                        // to SystemDate
                        ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i219).getUlIdPerson());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i219).getUlIdPerson());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(cfad38si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdPerson());
                        
                        pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfDesc(pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i219).getSzNmPersonFull());
                        pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += "'s foster home has had foster types added or deleted.";
                        pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfLongDesc("Foster Home Types were added or deleted for the ");
                        pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() += cfad38si.getSzNmResource() + " home on ";
                        
                        //  Set dtSystemDate
                        // to SystemDate
                        ARC_UTLGetDateAndTime(dtSystemDate, 0);
                        pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfLongDesc(dtSystemDate.month + "/" + dtSystemDate.day + "/" + dtSystemDate.year);
                        pTodoCommonInput.getCSUB40UIG00().getSzSysTxtTodoCfLongDesc() += ".  " + pCLSC51DOutputRec.getROWCLSC51DO_ARRAY().getROWCLSC51DO(i219).getSzNmPersonFull() + " was placed in this home during this time.  This may " + "affect the child's billing service level and/or placement.  " + "Contact the child's eligibility worker if appropriate.";
                        rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                RetVal = SUCCESS;
                                
                                break;
                            default :// CSUB40U
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                RetVal = Csub50s.FND_FAIL;
                                
                                break;
                        }
                    }
                    
                    
                    
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    RetVal = Csub50s.FND_FAIL;
                    
                    
                    break;
            }
        }
        
        if ((INDICATOR_YES == cfad38si.getCSysIndFosterTypeChange() || INDICATOR_YES == cfad38si.getCSysIndCategoryChange() || INDICATOR_YES == cfad38si.getCSysIndFeAgeChange() || INDICATOR_YES == cfad38si.getCSysIndMaAgeChange()) && SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCFAD01UInputRec = new CFAD01UI();
            
            pCFAD01UOutputRec = new CFAD01UO();
            pCFAD01UInputRec.setArchInputStruct(cfad38si.getArchInputStruct());
            pCFAD01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCFAD01UInputRec.setUlIdResource(cfad38si.getUlIdResource());
            pCFAD01UInputRec.setUNbrRsrcMlAgeMin(cfad38si.getUNbrRsrcMlAgeMin());
            pCFAD01UInputRec.setUNbrRsrcMlAgeMax(cfad38si.getUNbrRsrcMlAgeMax());
            pCFAD01UInputRec.setUNbrRsrcFMAgeMin(cfad38si.getUNbrRsrcFMAgeMin());
            pCFAD01UInputRec.setUNbrRsrcFMAgeMax(cfad38si.getUNbrRsrcFMAgeMax());
            pCFAD01UInputRec.setBSysIndAddressChange(Cint14s.INDICATOR_NO);
            pCFAD01UInputRec.setBSysIndAgeChange(Cint14s.INDICATOR_NO);
            if (INDICATOR_YES == cfad38si.getCSysIndFeAgeChange() || INDICATOR_YES == cfad38si.getCSysIndMaAgeChange()) {
                pCFAD01UInputRec.setBSysIndAgeChange(INDICATOR_YES);
                
            }
            pCFAD01UInputRec.setCSysIndCategoryChange(cfad38si.getCSysIndCategoryChange());
            pCFAD01UInputRec.setCSysIndFosterTypeChange(cfad38si.getCSysIndFosterTypeChange());
            pCFAD01UInputRec.setCSysIndRsrcCharChg(Cint14s.INDICATOR_NO);
            pCFAD01UInputRec.setCSysIndRsrcPrsChg(Cint14s.INDICATOR_NO);
            rc = Cfad01u.CFAD01U(pCFAD01UInputRec, pCFAD01UOutputRec, pServiceStatus);
            
            // }
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
                    
                    
                    
                    
                    
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    RetVal = Csub50s.FND_FAIL;
                    
                    
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfad38si.getArchInputStruct() , cfad38so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            //  Call DAM
            rc = SUCCESS;
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CFAD38S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                //  Updates the Person's Age on the PERSON table
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CFAD38S\n");
        }
        
        return cfad38so;
    }

    static int ContractVerSerCnty(CFAD38SI pInputMsg386, int ulIdContract3, int ulNbrCnperPeriod3, int ulIdResource9, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int RetVal = 0;/* Return code */
        int i220 = 0;
        int j = 0;
        int ulLocalAdoptOrFoster = 0;
        boolean bDeleteInsertContractCounty = true;
        boolean blFoster = true;
        int ulLocalNumberOfDays = 0;
        
        /* SIR 22686 */
        boolean bGroupHome2 = false;
        FndInt3date dtTempDate = null;/* Temporary date used for system date */
        FndInt3date dtCurrentDate = null;/* Temporary date used for system date */
        FndInt3date/* Temporary date subtract 2 day */
        dtTempDate3 = new FndInt3date( - 2, 0, 0);
        FndInt3date/* Temporary date add 1 day */
        dtAddOneDay = new FndInt3date(1, 0, 0);
        CSES01DI pCSES01DInputRec = null;/* Contract Version retrieve */
        
        CSES01DO pCSES01DOutputRec = null;
        CLSS13DI pCLSS13DInputRec = null;/* Contract Service retrieval */
        
        CLSS13DO pCLSS13DOutputRec = null;
        CLSS68DI pCLSS68DInputRec = null;/* CONTRACT_COUNTY Retrieve  */
        
        CLSS68DO pCLSS68DOutputRec = null;
        CAUD17DI pCAUD17DInputRec = null;/* Contract Service AUD */
        
        CAUD17DO pCAUD17DOutputRec = null;
        CAUD08DI pCAUD08DInputRec = null;/* Contract County AUD */
        
        CAUD08DO pCAUD08DOutputRec = null;
        CAUD15DI pCAUD15DInputRec = null;/* Contract Version AUD */
        
        CAUD15DO pCAUD15DOutputRec = null;
        
        
        /*
        ** Call CLSCB3D
        */
        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtTempDate3);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        
        /*
        ** Call CSES00D
        */
        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtAddOneDay);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD15DInputRec = new CAUD15DI();
        
        pCAUD15DOutputRec = new CAUD15DO();
        pCAUD15DInputRec.setArchInputStruct(pInputMsg386.getArchInputStruct());
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD08DInputRec = new CAUD08DI();
        
        pCAUD08DOutputRec = new CAUD08DO();
        pCAUD08DInputRec.setArchInputStruct(pInputMsg386.getArchInputStruct());
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD17DInputRec = new CAUD17DI();
        
        pCAUD17DOutputRec = new CAUD17DO();
        pCAUD17DInputRec.setArchInputStruct(pInputMsg386.getArchInputStruct());
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS68DInputRec = new CLSS68DI();
        
        pCLSS68DOutputRec = new CLSS68DO();
        
        pCLSS68DInputRec.setArchInputStruct(pInputMsg386.getArchInputStruct());
        
        
        /*
        ** Allocate memory for DAM Input and Output
        ** Structures
        */
        pCLSS13DInputRec = new CLSS13DI();
        
        pCLSS13DOutputRec = new CLSS13DO();
        pCLSS13DInputRec.setArchInputStruct(pInputMsg386.getArchInputStruct());
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES01DInputRec = new CSES01DI();
        
        pCSES01DOutputRec = new CSES01DO();
        pCSES01DInputRec.setArchInputStruct(pInputMsg386.getArchInputStruct());
        
        pCSES01DInputRec.setUlIdContract(ulIdContract3);
        pCSES01DInputRec.setUlNbrCnverPeriod(ulNbrCnperPeriod3);
        rc = cses01dQUERYdam(sqlca, pCSES01DInputRec, pCSES01DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                RetVal = SUCCESS;
                pCAUD15DInputRec.setUlIdContract(pCSES01DOutputRec.getUlIdContract());
                pCAUD15DInputRec// SIR #2141 Retreivs rows for
                .setUlIdCntrctWkr(pCSES01DOutputRec.getUlIdCntrctWkr());
                pCAUD15DInputRec// CASE_MERGE for retreived case
                .setUlNbrCnverPeriod(pCSES01DOutputRec.getUlNbrCnverPeriod());
                
                pCAUD15DInputRec.setUlNbrCnverVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
                pCAUD15DInputRec.setUlNbrCnverNoShowPct(pCSES01DOutputRec.getUlNbrCnverNoShowPct());
                pCAUD15DInputRec.setCIndCnverVerLock(pCSES01DOutputRec.getCIndCnverVerLock());
                
                // SIR 23096 Start
                pCAUD15DInputRec.setSzTxtCnverComment(pCSES01DOutputRec.getSzTxtCnverComment());
                pCAUD15DInputRec.setUlIdCnver(pCSES01DOutputRec.getUlIdCnver());
                pCAUD15DInputRec.getTmScrTmGeneric1();
                pCAUD15DInputRec.setTmScrTmGeneric1(pCSES01DOutputRec.getTmScrTmGeneric1());
                pCAUD15DInputRec.setDtDtCnverEnd(dtTempDate);
                pCAUD15DInputRec.setTmScrTmGeneric2(pCSES01DOutputRec.getTmScrTmGeneric2());
                pCAUD15DInputRec.setDtDtCnverEffective(pCSES01DOutputRec.getDtDtCnverEffective());
                
                ulLocalNumberOfDays = ARC_UTLCompareDateAndTime((FndInt3date) & dtCurrentDate, 0, (FndInt3date) & pCAUD15DInputRec.getDtDtCnverEffective() , 0);
                if ((ulLocalNumberOfDays / 1440) <= 2) {
                    bDeleteInsertContractCounty = false;
                }
                pCAUD15DInputRec.setDtDtCnverCreate(pCSES01DOutputRec.getDtDtCnverCreate());
                pCAUD15DInputRec.setTmScrTmGeneric3(pCSES01DOutputRec.getTmScrTmGeneric3());
                pCAUD15DInputRec.setTsLastUpdate(pCSES01DOutputRec.getTsLastUpdate());
                pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                // i=0 for Update, i=1 for Add function
                for (i220 = 0;i220 < 2 && RetVal == SUCCESS && bDeleteInsertContractCounty;i220++) {
                    
                    if (i220 == 1) {
                        pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                        pCAUD15DInputRec.setDtDtCnverEnd(pCSES01DOutputRec.getDtDtCnverEnd());
                        pCAUD15DInputRec.setDtDtCnverEffective(dtCurrentDate);
                        pCAUD15DInputRec.setUlNbrCnverVersion(pCSES01DOutputRec.getUlNbrCnverVersion() + 1);
                        pCAUD15DInputRec.setSzTxtCnverComment("");
                        pCAUD15DInputRec.setUlIdCnver(0);
                    }
                    rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            RetVal = SUCCESS;
                            break;
                            
                            
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                            RetVal = Csub50s.FND_FAIL;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
                break;
                
            default :
                RetVal = Csub50s.FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        if (RetVal == SUCCESS && bDeleteInsertContractCounty) {
            pCLSS13DInputRec.setUlIdContract(ulIdContract3);
            pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
            pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            
            
            //  Call CLSS12D
            rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        if (RetVal == SUCCESS && bDeleteInsertContractCounty) {
            pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCAUD17DInputRec.setUlIdCnsvc(0);
            for (i220 = 0;i220 < NBR_SVC_CODE_SIXTY_ABCD && RetVal == SUCCESS;i220++) {
                pCAUD17DInputRec.setUlIdContract(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlIdContract());
                pCAUD17DInputRec.setUlIdCntrctWkr(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlIdCntrctWkr());
                pCAUD17DInputRec.setUlNbrCnsvcVersion(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcVersion() + 1);
                pCAUD17DInputRec.setUlNbrCnsvcPeriod(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcPeriod());
                pCAUD17DInputRec.setUlNbrCnsvcLineItem(i220 + 1);
                
                
                //  Analyze return code
                switch (i220) {
                    case 0:
                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_BASIC);
                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_BASIC);
                        break;
                    case 1:
                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_MOD);
                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_MOD);
                        break;
                        //  SIR#3661 - Added and SQL_NOT_FOUND case with the
                        // SUCCESS case when calling CINV43D, the TODO Update
                        // Dam so that when no TODO exist the Save service won't
                        // fail.
                        
                    case 2:
                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_SPEC);
                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_SPEC);
                        break;
                    case 3:
                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_INT);
                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_INT);
                        break;
                        
                    default :
                        break;
                }
                pCAUD17DInputRec.setSzCdCnsvcPaymentType(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getSzCdCnsvcPaymentType());
                pCAUD17DInputRec.setCIndCnsvcNewRow(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getCIndCnsvcNewRow());
                pCAUD17DInputRec.setSzNbrCnsvcUnitType(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getSzNbrCnsvcUnitType());
                pCAUD17DInputRec.setUlNbrCnsvcFedMatch(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcFedMatch());
                pCAUD17DInputRec.setUlNbrCnsvcLocalMatch(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcLocalMatch());
                pCAUD17DInputRec.setUlAmtCnsvcAdminAllUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcAdminAllUsed());
                pCAUD17DInputRec.setUlAmtCnsvcEquip(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcEquip());
                pCAUD17DInputRec.setUlAmtCnsvcEquipUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcEquipUsed());
                pCAUD17DInputRec.setUlAmtCnsvcFrgBenft(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcFrgBenft());
                pCAUD17DInputRec.setUlAmtCnsvcFrgBenftUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcFrgBenftUsed());
                pCAUD17DInputRec.setUlAmtCnsvcOffItemUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcOffItemUsed());
                pCAUD17DInputRec.setUlAmtCnsvcOther(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcOther());
                pCAUD17DInputRec.setUlAmtCnsvcOtherUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcOtherUsed());
                pCAUD17DInputRec.setUlAmtCnsvcSalary(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcSalary());
                pCAUD17DInputRec.setUlAmtCnsvcSalaryUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcSalaryUsed());
                pCAUD17DInputRec.setUlAmtCnsvcSupply(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcSupply());
                pCAUD17DInputRec.setUlAmtCnsvcSupplyUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcSupplyUsed());
                pCAUD17DInputRec.setUlAmtCnsvcTravel(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcTravel());
                pCAUD17DInputRec.setUlAmtCnsvcTravelUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcTravelUsed());
                pCAUD17DInputRec.setUlAmtCnsvcUnitRate(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcUnitRate());
                //  Unlike typical DAM calls, a Common Function handles its own
                // SQL errors.  So, after returning, we should call
                // PROCESS_RC_ERROR rather than PROCESS_TUX_SQL_ERROR_TRANSACT
                pCAUD17DInputRec.setUlAmtCnsvcUnitRateUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcUnitRateUsed());
                
                pCAUD17DInputRec.setTsLastUpdate(dtCurrentDate);
                
                rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                        
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        if (!(FA_CATG_ADOPT.compareTo(pInputMsg386.getSzCdRsrcCategory()) != 0)) {
            blFoster = false;
        }
        
        ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_AB;
        
        if (RetVal == SUCCESS) {
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if (pInputMsg386.getCCdRsrcFaHomeType1()[0] == null) {
                ulLocalAdoptOrFoster = 0;
            }
            else {
                //  SIR 22686 loop through the rows to see if any of them
                // are group homes, if they are set an indicator
                for (i220 = 0;i220 < NBR_OF_HOME_TYPE;i220++) {
                    
                    
                    
                    //  Initialize Service Status Fields
                    
                    // 
                    // Perform Main Processing                                              
                    // 
                    
                    //  SIR 2575 01/19/96  BSM
                    // CheckStageEventStatus needs to be called before retrieving
                    // the SvcAuth.  If the current stage has been closed by another
                    // user, the current user will receive a MsgBox alert, and will be
                    // unable to navigate to the SvcAuth dialog
                    // SIR 2879 01/23/96  CRG
                    // Only call CheckStageEventStatus if the window mode is NOT INQUIRE
                    
                    if (pInputMsg386.getCCdRsrcFaHomeType1()[i220] == FOST_TYPE_GROUP) {
                        bGroupHome2 = true;
                        break;
                    }
                }
                for (i220 = 0;i220 < NBR_OF_HOME_TYPE;i220++) {
                    if ((pInputMsg386.getCCdRsrcFaHomeType1()[i220] == FOST_TYPE_HABIL) || (pInputMsg386.getCCdRsrcFaHomeType1()[i220] == FOST_TYPE_THER) || (pInputMsg386.getCCdRsrcFaHomeType1()[i220] == FOST_TYPE_PRIM_MED)) {
                        if (!bGroupHome2) {
                            // 19613, 22390, 22485 Habil, Ther, and Prim Med homes use two codes 63A, B, C & D
                            ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_ABCD;
                            break;
                        }
                        else {
                            ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_ABC;
                            break;
                        }
                    }
                }
            }
        }
        /*********************************************************************
        ** (END): Common Function: ccmn06u  ** Check Stage/Event common
        ** function
        *********************************************************************/
        
        /*
        ** SIR 2903
        ** If we are in Investigation or Family Preservation, we
        ** should make sure that Subcare and Family Subcare have
        ** not been opened yet.  If they have, we need to return
        ** a message to the client and not allow the user to
        ** create a new Service Authorization from within Investigation
        ** or Family Preservation. We also only want to do this in New
        ** or New Using mode. The first dam retrieves a full row from
        ** the stage table for the current stage (to get the idCase). This
        ** is a model break but is less invasive that ensuring that IdCase
        ** is carried throughout the window code, since it currently is
        ** not.
        */
        /*
        ** SIR 20465
        ** Added logic for other stages (don't do this for APS) and modified
        ** if for the stage to make sure it's open when not allowing the user
        ** to not open the header window in new mode
        */
        /*
        ** SIR 20507
        ** Add date stage close is null or max before forcing the user to
        ** use a progressed stage to create new service auths
        */
        if (RetVal == SUCCESS) {
            pCLSS68DInputRec.setUlIdContract(ulIdContract3);
            pCLSS68DInputRec.setUlNbrCncntyPeriod(ulNbrCnperPeriod3);
            pCLSS68DInputRec.setUlNbrCncntyVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
            pCLSS68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS68DO._CLSS68DO__ROWCLSS68DO_SIZE);
            pCLSS68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            rc = clss68dQUERYdam(sqlca, pCLSS68DInputRec, pCLSS68DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    break;
                    
                    //  Populate ToDo Common Function's input structure
                    // Evaluate on FAD037 FAD038 FAD040 FAD041 FAD042
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
                    
                    //  Call CLSS15D
                    rc = SUCCESS;
                    break;
                    
                    
                default :
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        if (RetVal == SUCCESS) {
            if (!bDeleteInsertContractCounty) {
                pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                for (i220 = 0;i220 < pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty() && RetVal == SUCCESS;i220++) {
                    pCAUD08DInputRec.setUlIdCncnty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlIdCncnty());
                    
                    pCAUD08DInputRec.setTsLastUpdate(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getTsLastUpdate());
                    
                    
                    //  Set rc to ARC_SUCCESS
                    rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
            }
            else {
                pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                
                for (i220 = 0;i220 < pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty() && RetVal == SUCCESS;i220++) {
                    pCAUD08DInputRec.setUlIdCncnty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlIdCncnty());
                    pCAUD08DInputRec.setSzCdCncntyCounty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getSzCdCncntyCounty());
                    pCAUD08DInputRec.setTsLastUpdate(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getTsLastUpdate());
                    pCAUD08DInputRec.setUlIdContract(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlIdContract());
                    
                    pCAUD08DInputRec.setUlNbrCncntyPeriod(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlNbrCncntyPeriod());
                    pCAUD08DInputRec.setUlIdCntrctWkr(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlIdCntrctWkr());
                    pCAUD08DInputRec.setUlIdResource(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlIdResource());
                    pCAUD08DInputRec.setSzCdCncntyService(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getSzCdCncntyService());
                    pCAUD08DInputRec.setTmScrTmGeneric1(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getTmScrTmGeneric1());
                    pCAUD08DInputRec.setTmScrTmGeneric2(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getTmScrTmGeneric2());
                    pCAUD08DInputRec.setUlNbrCncntyLineItem(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlNbrCncntyLineItem());
                    pCAUD08DInputRec.setUlNbrCncntyVersion(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getUlNbrCncntyVersion());
                    pCAUD08DInputRec.setDtDtCncntyEffective(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i220).getDtDtCncntyEffective());
                    
                    pCAUD08DInputRec.setDtDtCncntyEnd(dtTempDate);
                    rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            RetVal = SUCCESS;
                            break;
                            
                            
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = WtcHelperConstants.SQL_DUPLICATE_KEY;
                            RetVal = Csub50s.FND_FAIL;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
            }
        }
        /*
        ** Investigation stage
        */
        if (RetVal == SUCCESS && blFoster) {
            pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCAUD08DInputRec.setUlIdCncnty(0);
            if (!bDeleteInsertContractCounty) {
                pCAUD08DInputRec.setUlNbrCncntyVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
            }
            else {
                pCAUD08DInputRec.setUlNbrCncntyVersion(pCSES01DOutputRec.getUlNbrCnverVersion() + 1);
            }
            pCAUD08DInputRec.setSzCdCncntyCounty(pInputMsg386.getSzCdRsrcCnty());
            
            pCAUD08DInputRec.setTsLastUpdate(pCSES01DOutputRec.getTsLastUpdate());
            pCAUD08DInputRec.setUlIdContract(pCSES01DOutputRec.getUlIdContract());
            pCAUD08DInputRec.setUlNbrCncntyPeriod(pCSES01DOutputRec.getUlNbrCnverPeriod());
            pCAUD08DInputRec.setUlIdCntrctWkr(pCSES01DOutputRec.getUlIdCntrctWkr());
            pCAUD08DInputRec.setUlIdResource(ulIdResource9);
            pCAUD08DInputRec.setTmScrTmGeneric1(pCSES01DOutputRec.getTmScrTmGeneric1());
            pCAUD08DInputRec.setTmScrTmGeneric2(pCSES01DOutputRec.getTmScrTmGeneric2());
            
            pCAUD08DInputRec.setDtDtCncntyEffective(dtCurrentDate);
            pCAUD08DInputRec.setDtDtCncntyEnd(pCSES01DOutputRec.getDtDtCnverEnd());
            
            
            // SIR 19613 Write new codes 63A-D to Contract_Service Table
            for (i220 = 0;i220 < ulLocalAdoptOrFoster && RetVal == SUCCESS;i220++) {
                pCAUD08DInputRec.setUlNbrCncntyLineItem(i220 + 1);
                
                switch (i220) {
                        
                    case 0:
                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_BASIC);
                        break;
                    case 1:
                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_MOD);
                        break;
                    case 2:
                        
                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_SPEC);
                        break;
                        
                    case 3:
                        pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_INT);
                        break;
                        
                    default :
                        break;
                }
                rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = WtcHelperConstants.SQL_DUPLICATE_KEY;
                        RetVal = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        RetVal = Csub50s.FND_FAIL;
                        
                        
                        break;
                }
            }
        }
        return rc;
    }

}
