package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD36SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD70DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD70DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD75DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
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
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES01DO;
/**************************************************************************
**
** Module File:   CFAD36S.src
**
** Service Name:  CFAD36S
**
** Description:   Save service called from the F/A Home Close/ReOpen Home
**                window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/28/95
**
** Programmer:    Stephen Helmke
**
** Archive Information: $Revision:   1.9  $
**                      $Date:   12 Jul 2002 09:14:28  $
**                      $Modtime:   12 Jul 2002 08:47:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  2/26/96   PURCELA   SIR #3267 - In order to make this SIR work, a PROC
**                      event status became necessary.  The changes within
**                      the Save Service were made to accomodate this new
**                      possibility.  The Invalidate approval section is now
**                      entered only when the Current Event Status is
**                      specifically PEND, and Events will be updated when
**                      the Current Event Status is PROC.
**  2/27/96   PURCELA   SIR #3318 - Added DAMS CSES56D and CAUD75D to first
**                      retrieve a full row from the Records Retention table
**                      and then to remove that record from database when a
**                      home is reopened. Added the DAM copybooks and programs
**                      to CFAD36S program.  Also made Tabs smaller to remove
**                      huge indention.
**  2/28/96   PURCELA   SIR #3459 - The Reopen Case DAM, cmsc18d, was not
**                      passing in NULL_DATES to Date Case Closed.  This was
**                      causing mistaken determinations that the case was
**                      still closed.  NULL_DATE values are now passed.
**  3/22/96   PURCELA   SIR #4169 - Removed a call to CINV43D.  F/A Home
**                      windows should not remove ToDo's based on IdEvent
**                      because the IdEvent that is current may be associated
**                      with a different CdTask than the one being performed.
**
**  3/26/96   ZIMMERNE  SIR #4258 - CdRsrcFacilType was added to CFAD36SI.
**                      The if statement around Close Stage Case was modified
**                      to check the Resource Facility type. If you are
**                      closing a Non-PRS Home (RSRC_TYPE_PVT_AGENCY), Close
**                      Stage Case should be executed for the save.
**
**  4/17/96    ALIAM    SIR #20360 - Contract Enhancement.
**  4/28/96   PURCELA   SIR #20651 - Added a call to CCMND3D in order to
**                      create a Primary Worker for the Stage upon reopening
**                      of the home if a Historical Primary (HP) does not
**                      currecntly exist. (Converted Data Scenario)
**  5/2/96    DENTONRA  SIR #20846 - Changed to buisness from primary
**                      and added VID validation. Copy idResourceAddress
**                      if the address type if "buisness" and has a valid
**                      VID. (There can be more than one business address
**                      but only one with a VID.)
**  5/8/96    DENTONRA  SIR 21003 - Changed "extendo" date processing to
**                      have == instead of = .  Also, changed error
**                      processing of cses80d to allow sql-not-found because
**                      that is an acceptible condition.  It should not
**                      "blow-up" at that point.
**  05/09/96  PHILLILH  SIR #21024 - Set bIndStagePersEmpNew to EMP_IS_NEW
**                      so that '1' is returned to Assigned Workload
**                      and the row will be shaded.
**  6/27/96   PURCELA   SIR #10226 - Added a call to CAUDC3D to populate
**                      IdUnit of the worker to the Stage Table when a home
**                      is reopened.
**
**  7/8/96    DYARGR    SIR 21747 - Performance SIR. Corrected missing timers
**                      for two dams. Removed double allocation of memory.
**
**  8/1/96    YANTISTK  SIR 21910 - Removed PROCESS_TUX_RC_ERROR after ARC_UTLCompar
**                      eDateAndTime.
**  08/15/96  PHILLILH  SIR #21922 - BEGIN CAUD08D CONTRACT COUNTY update.
**                      This DAM was added because the contract county end
**                      date needs to be upated simulatneously with the
**                      contract_period and contract_county tables.
**
** 09/09/96 ZABIHIN    SIR 22177 - added ccmn37d in foundation and attached
**                     code to call the dam. The F/AHomes with out of state
**                     addresses would get a data access error becasuse of
**                     they were being saved with a null region.  This
**                     fix makes them default to the region of the primary
**                     worker
**
** 10/08/96 Saravigm    SIR 21795 - Setting the field date value to NULL date
**                      -1/-1/-1, instead of 00/00/0000
**
** 11/27/96 VANDERM    SIR 12560 - CFAD01V is being killed due to memory
**                     problems arising from cfad36s.src.  The memory for
**                     pCFAD01DInputRec was not being allocated and freed
**                     inside the same if statement.  Both the allocation
**                     and the free were moved.
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
** 6/24/2002    hadjimh SIR#15931. When trying to SAVE the approval of an adoptive
**                      home closure, error message 'Date you entered is not valid'
**                      occurs. When trying to close a non-prs home, the same error
**                      occurs(this error was found during testing).
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  03/25/03  Srini     Modified to check for the transaction and tpbegin only if it
**                      is not already started and similarly for tpcommit at the end.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
**
**  06/30/03  Srini     SIR 18602 - Modified to fix error handling for
**                      transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**                      PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to
**                      PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  08/21/2003  KRD     SIR 19600 - Modified 3 if-statements to use FND_YES
**                      rather than TRUE
**  09/04/03  A.Corley  SIR 19613 LOC Reduction -- Service Codes 60A-E are now
**                      being reduced to Service Codes 63A - D, updated code to compare and
**                      save with new codes.
**  11/17/03  A.Corley  SIR 22390 LOC Change -- Service Code 63C is now being used
**                      for Specialized home
**  12/16/03  A.Corley  SIR 22485 LOC Change -- Service Code 63D is now being used
**                      for Intense home
**  4/28/2004 gerryc    SIR 15670 - if the person who was originally assigned to the F/A home
**                      is no longer an active employee (they have a termination date), then
**                      reassign the F/A home to the person who is logged in.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad36s {
    static final int NULL_DATE1 = - 1;
    static final String EVENT_COMPLETE1 = "COMP";
    
    /* SIR #21024 */
    public static final char EMP_IS_NEW = '1';
    
    /* SIR #15787 */
    /* SIR 19613, 22390, 22485 Homes that are basic will only have
    ** Level A assigned to them, Homes that are Hab,
    ** Ther, and Prim Med will have Level A, B, C, and D
    */
    public static final int NBR_SVC_CODE_SIXTY_A = 1;
    public static final int NBR_SVC_CODE_SIXTY_AB = 2;
    public static final int NBR_SVC_CODE_SIXTY_ABC = 3;
    public static final int NBR_SVC_CODE_SIXTY_ABCD = 4;
    public static final int NBR_OF_HOME_TYPE = 7;
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String UNIT_MEMBER_IN_ASSIGNED = "IN";
    public static final String NULL_STRING = "";
    
    
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    /**************************************************************************
    **
    ** Function Name:  CCMN35S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    static CFAD36SI pInputMsg = null;
    static int transactionflag = - 1;
    CFAD36SO CFAD36S(CFAD36SI cfad36si) {
        CFAD36SO cfad36so = new CFAD36SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CFAD36S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CFAD36S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CFAD36S\n");
        }
        
        /**************************************************************************
        ** END CCMN01U
        **************************************************************************/
        
        
        /*
        ** SIR #4169 - 3/22/96 - PURCELA - Removed call to Complete ToDo DAM
        ** CINV43D.  F/A Home Dialog windows should not automatically remove
        ** manually created ToDo's
        */
        
        
        /* Re-open Home Processing */
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CFAD36S\n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare local variables
        */
        
        public public int RetVal = SUCCESS;
        
        char cSaveMode = '\u0000';
        CAUD47DI pCAUD47DInputRec = null;/* Stage Closure AUD */
        
        /* DAM Declaration */
        CAUD47DO pCAUD47DOutputRec = null;
        CAUD70DI pCAUD70DInputRec = null;/* Close Reopen Home AUD */
        
        CAUD70DO pCAUD70DOutputRec = null;
        CAUDA0DI pCAUDA0DInputRec = null;/* Home Worker AUD */
        
        CAUDA0DO pCAUDA0DOutputRec = null;
        CMSC17DI pCMSC17DInputRec = null;/* Situation Reopen */
        
        /*
        ** SIR #4169 - 3/22/96 - PURCELA - Removed the call to CINV43D - F/A Home
        ** Windows will not automatically remove manually created ToDo's.
        **
        ** _CINV43DI       *pCINV43DInputRec;
        ** _CINV43DO       *pCINV43DOutputRec;
        */
        
        CMSC17DO pCMSC17DOutputRec = null;
        CMSC18DI pCMSC18DInputRec = null;/* Case Reopen */
        
        CMSC18DO pCMSC18DOutputRec = null;
        CSES56DI pCSES56DInputRec = null;/* Retrieve Records Retention Row */
        
        /*
        ** SIR #3318 - 2/27/96 - PURCELA - Added DAM Input and Output Copybooks
        ** for CSES56D and CAUD75D
        */
        
        CSES56DO pCSES56DOutputRec = null;
        CAUD75DI pCAUD75DInputRec = null;/* Delete Records Retention Row */
        
        CAUD75DO pCAUD75DOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function */
        
        /* Common Functions Declaration */
        CCMN06UO pCCMN06UOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* Post Event */
        
        CCMN01UO pCCMN01UOutputRec = null;
        CCMN02UI pCCMN02UInputRec = null;/* Close Stage Case */
        
        CCMN02UO pCCMN02UOutputRec = null;
        CCMN05UI pCCMN05UInputRec = null;/* Invalidate Approval */
        
        CCMN05UO pCCMN05UOutputRec = null;
        CLSS67DI pCLSS67DInputRec = null;/* SIR #20360 */
        CLSS67DO pCLSS67DOutputRec = null;/* SIR #20360 */
        CLSS68DI pCLSS68DInputRec = null;/* SIR #20360 */
        CLSS68DO pCLSS68DOutputRec = null;/* SIR #20360 */
        CSES80DI pCSES80DInputRec = null;/* SIR #20360 */
        CSES80DO pCSES80DOutputRec = null;/* SIR #20360 */
        CSES81DI pCSES81DInputRec = null;/* SIR #20360 */
        CSES81DO pCSES81DOutputRec = null;/* SIR #20360 */
        CAUD01DI pCAUD01DInputRec = null;/* Contract AUD */
        
        /****************************SIR 20360**********************************/
        
        
        
        
        
        CAUD01DO pCAUD01DOutputRec = null;
        CAUD17DI pCAUD17DInputRec = null;/* Contract Service AUD */
        
        CAUD17DO pCAUD17DOutputRec = null;
        CAUD08DI pCAUD08DInputRec = null;/* Contract County AUD */
        
        CAUD08DO pCAUD08DOutputRec = null;
        CAUD15DI pCAUD15DInputRec = null;/* Contract Version AUD */
        
        CAUD15DO pCAUD15DOutputRec = null;
        CAUD20DI pCAUD20DInputRec = null;/* Contract Period AUD*/
        
        CAUD20DO pCAUD20DOutputRec = null;
        CLSS13DI pCLSS13DInputRec = null;/* Contract Service retrieval */
        
        CLSS13DO pCLSS13DOutputRec = null;
        CINT20DI pCINT20DInputRec = null;/* Primary worker retrieval */
        
        CINT20DO pCINT20DOutputRec = null;
        CRES13DI pCRES13DInputRec = null;/* Resource Address retrieval */
        
        CRES13DO pCRES13DOutputRec = null;
        CSES82DI pCSES82DInputRec = null;/* Region/County retrieval*/
        
        CSES82DO pCSES82DOutputRec = null;
        Cfad01a pCFAD01DInputRec = null;/* Working copybook used by the
        ** service for FAD/Contracts
        */
        CCMND3DI pCCMND3DInputRec = null;/* SIR 20651 */
        
        
        /***************************END SIR 20360******************************/
        
        CCMND3DO pCCMND3DOutputRec = null;
        CAUDC3DI pCAUDC3DInputRec = null;/* SIR #10226 */
        
        CAUDC3DO pCAUDC3DOutputRec = null;
        CCMN39DI pCCMN39DInputRec = null;/* SIR 22177 */
        CCMN39DO pCCMN39DOutputRec = null;/* SIR 22177 */
        
        
        int usRow = 0;
        
        int usInputRow = 0;
        
        int ulIdTemporaryUnit = 0;
        int ulIdTemporaryCase = 0;/* SIR #3930 */
        boolean bIndFosterContractExists = false;/* Indicates if that the foster
        contract exists SIR #20360 */
        boolean bIndAdoptContractExists = false;/* Indicates if that the foster
        contract exists SIR #20360 */
        char bIndUpdateFosterContract = 0;/* Indicates if that the foster
        contract exists SIR #20360 */
        char bIndUpdateAdoptContract = 0;/* Indicates if that the foster
        contract exists SIR #20360 */
        FndInt3date dtTempDate = null;/* Temporary date used for system date
        SIR #20360 */
        FndInt3date dtCurrentDate = null;/* Temporary date used for system date
        SIR #20360 */
        FndInt3date/* Temporary date to add 100 years
        SIR 20360*/
        dtTempDate2 = new FndInt3date(0, 0, 100);
        FndInt3date/* Temporary date to add 100 years
        SIR 20360 */
        dtTempDate3 = new FndInt3date( - 1, 0, 0);
        FndInt3date/* Temporary date add 1 day
        SIR 20360 */
        dtAddOneDay = new FndInt3date(1, 0, 0);
        int ulContractQty = 0;/* Counter for contracts returned from
        database SIR #20360 */
        int i216 = 0;
        int j = 0;/* Interger used for a looping logic
        SIR #20360 */
        int k = 0;/* Interger used for a looping logic
        SIR #20360 */
        int l = 0;/* Interger used for a looping logic
        SIR #20360 */
        int drc = 0;/* return code from ARC_UTLCompareDate
        function.  SIR #20360 */
        int usCreateContract = 0;/* Indicates the type of contract to be
        created.  SIR #20360 */
        int ulTempIdRsrcAddress = 0;/* Temporary variable to hold the
        ** primary resource address id
        ** SIR 20360
        */
        int ulIdTempContract = 0;/* Holds the contract ID created in
        in the contract AUD */
        int usCountyRow = 0;/* Holds contract county row index */
        int tempSvcRowQty = 0;/* Holds county service row index */
        int usUpdateContract = 0;/* Indicates if the contract being
        updated is foster or adoptive */
        boolean testBool = false;/* indicator for current contract flag */
        int ulAdoptiveOrFoster = 0;/* SIR #15787 */
        String szAdoptiveOrFoster = new String();/* SIR #15787 */
        
        
        
        
        
        
        
        
        
        
        
        
        String szCategoryType = new String();
        char bAdoptive = 1;/* SIR #15787 */
        boolean bFoster = true;
        int tmpSvcRowQty1 = 0;/* Holds county service row index */
        int tempSvcRowQty2 = 0;/* SIR #15931 temp row counter */
        /* SIR 22686 */
        boolean bGroupHome = false;
        rc = ARC_PRFServiceStartTime_TUX(cfad36si.getArchInputStruct());
        if ((SUCCESS == RetVal) && ((0 == HOME_STATUS_CLOSED.compareTo(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT))) || (0 == HOME_STATUS_PENDING_CLOSURE.compareTo(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT))))) {
            // 
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getSzCdTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
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
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
                    
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            if (0 == Cinv28s.EVENT_STATUS_PEND.compareTo(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getSzCdEventStatus())) {
                // 
                // BEGIN CCMN05U - Invalidate Approval
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCCMN05UInputRec = new CCMN05UI();
                
                pCCMN05UOutputRec = new CCMN05UO();
                
                pCCMN05UInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                
                pCCMN05UInputRec.setUlIdEvent(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdEvent());
                rc = Ccmn05u.InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // Set RetVal to FND_SUCCES
                        RetVal = SUCCESS;
                        
                        
                        // 
                        // BEGIN CCMN01U - Update the current event, setting the
                        // status to COMP.
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN01UInputRec = new CCMN01UI();
                        
                        pCCMN01UOutputRec = new CCMN01UO();
                        pCCMN01UInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        pCCMN01UInputRec.setROWCCMN01UIG00(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT));
                        if (false == cfad36si.getArchInputStruct().getUlSysNbrReserved1()) {
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(Cinv61s.EVENT_STATUS_COMP);
                        }
                        
                        // Call DAM and get one ID PERSON
                        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                                
                                // Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                break;
                                
                            default :
                                // RetVal = FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                        break;
                        
                        
                        
                    default :
                        
                        // Set RetVal to FND_SUCCES
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
            if ((SUCCESS == RetVal) && (false == cfad36si.getArchInputStruct().getUlSysNbrReserved1())) {
                
                // 
                // BEGIN CCMN01U - Create the New Event.
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCCMN01UInputRec = new CCMN01UI();
                
                pCCMN01UOutputRec = new CCMN01UO();
                pCCMN01UInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                pCCMN01UInputRec.setROWCCMN01UIG00(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT));
                if (0 == Cinv28s.EVENT_STATUS_PROC.compareTo(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getSzCdEventStatus())) {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdEvent());
                    pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getTsLastUpdate());
                }
                // .                    check to make sure the new primary worker is
                // still an active employee
                else {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                //  Start performance timer for service
                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                //  Analyze error code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                        cfad36so.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                        
                        // Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                        
                        // 
                        // BEGIN CAUD70D - Close/Reopen Home
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD70DInputRec = new CAUD70DI();
                        
                        pCAUD70DOutputRec = new CAUD70DO();
                        pCAUD70DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                        pCAUD70DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        pCAUD70DInputRec.setSzCdRsrcFaHomeStatus(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT));
                        pCAUD70DInputRec.setSzCdRsrcClosureRsn(cfad36si.getSzCdRsrcClosureRsn());
                        pCAUD70DInputRec.setSzCdRsrcInvolClosure(cfad36si.getSzCdRsrcInvolClosure());
                        
                        pCAUD70DInputRec.setSzCdRsrcRecmndReopen(cfad36si.getSzCdRsrcRecmndReopen());
                        pCAUD70DInputRec.setUlIdResource(cfad36si.getUlIdResource());
                        pCAUD70DInputRec.getTsLastUpdate()[(int) RESOURCE] = cfad36si.getTsLastUpdate_ARRAY().getTsLastUpdate((int) RESOURCE);
                        pCAUD70DInputRec.setCIndRsrcWriteHist(FND_YES);
                        pCAUD70DInputRec.setUlIdRsrcFaHomeEvent(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdEvent());
                        pCAUD70DInputRec.setSzCdRsrcStatus(cfad36si.getSzCdRsrcStatus());
                        rc = caud70dAUDdam(sqlca, pCAUD70DInputRec, pCAUD70DOutputRec);
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                if ((0 == HOME_STATUS_INQUIRY.compareTo(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.CURRENT))) || (0 == RSRC_TYPE_PVT_AGENCY.compareTo(cfad36si.getSzCdRsrcFacilType()))) {
                                    // 
                                    // BEGIN CCMN02U - Close Stage Case
                                    // 
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCCMN02UInputRec = new CCMN02UI();
                                    
                                    pCCMN02UOutputRec = new CCMN02UO();
                                    pCCMN02UInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                    pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
                                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(STAGE_CD_FAD);
                                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(Csub38s.CAPS_PROG_CPS);
                                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(cfad36si.getSzCdRsrcClosureRsn());
                                    rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            break;
                                            
                                            
                                            
                                        default :
                                            // Set RetVal to FND_SUCCESS
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                }
                                break;
                                // PWO 1037: svcshell.src: changed SQL_SUCCESS to ARC_SUCCESS
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                break;
                                
                                
                            default :
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                        break;
                        
                    default :
                        // RetVal = FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        
        /*
        ** SIR 15670 - update the row with the person logged in
        ** if the person who was originally assigned is no longer
        ** an active employee
        */
        else if (SUCCESS == RetVal) {
            
            // 
            // BEGIN CMSC17D - Re-opens the Situation
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCMSC17DInputRec = new CMSC17DI();
            
            pCMSC17DOutputRec = new CMSC17DO();
            pCMSC17DInputRec.getDtDtSituationClosed().year = NULL_DATE1;
            pCMSC17DInputRec.getDtDtSituationClosed().month = NULL_DATE1;
            pCMSC17DInputRec.getDtDtSituationClosed().day = NULL_DATE1;
            
            
            // 
            // Function Prototypes
            // 
            pCMSC17DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
            pCMSC17DInputRec.setUlIdSituation(cfad36si.getUlIdSituation());
            //  The employee has been switched from OUT to "IN" status for
            // this unit. (szCdUnitMemberInOut = IN the current assignment,
            // while szScrCdUnitMemberInOut = OUT (the original))
            // Delete all other occurences (other units) where this 
            // employee is "IN". An employee can only be IN-assigned to
            // one unit.
            
            //  PWO 1080:
            // Restored the call to the CallCCMNF4D function.
            // BEGIN PWO 416 -- Ensure that Unit Approvers who are
            // "IN"-assigned to this unit are no longer referenced as the 
            // approver on the original unit.
            // Call DAM to Update Unit Approver on the Unit table.
            rc = cmsc17dAUDdam(sqlca, pCMSC17DInputRec, pCMSC17DOutputRec);
            
            
            
            //  Analyze return code
            switch (rc) {
                    // PWO 1037: svcshell.src: changed FND_SUCCESS to ARC_SUCCESS
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    // 
                    // BEGIN CMSC18D - Reopens the Case
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC18DInputRec = new CMSC18DI();
                    
                    pCMSC18DOutputRec = new CMSC18DO();
                    pCMSC18DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                    
                    pCMSC18DInputRec.setUlIdCase(cfad36si.getUlIdCase());
                    pCMSC18DInputRec.getDtDtCaseClosed().year = NULL_DATE1;
                    pCMSC18DInputRec.getDtDtCaseClosed().month = NULL_DATE1;
                    pCMSC18DInputRec.getDtDtCaseClosed().day = NULL_DATE1;
                    
                    //  Call DAM to Delete Unit Member from the Employee unit link
                    // table.
                    // PWO 1037: svcshell.src: in the rc= statement below
                    // replaced the lines:
                    // pReturnPB, 
                    // pServiceStatus,
                    // pABHI);
                    // with:
                    // TUX_STATUSPARMS);
                    rc = cmsc18dAUDdam(sqlca, pCMSC18DInputRec, pCMSC18DOutputRec);
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            // 
                            // BEGIN CAUD47D - Reopens the stage
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCAUD47DInputRec = new CAUD47DI();
                            
                            pCAUD47DOutputRec = new CAUD47DO();
                            
                            pCAUD47DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                            pCAUD47DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            pCAUD47DInputRec.getDtDtStageClose().month = NULL_DATE1;
                            
                            pCAUD47DInputRec.getDtDtStageClose().day = NULL_DATE1;
                            pCAUD47DInputRec.getDtDtStageClose().year = NULL_DATE1;
                            pCAUD47DInputRec.getSzCdStageReasonClosed()[Csub17s.ZERO] = null;
                            
                            pCAUD47DInputRec.getSzTxtStageClosureCmnts()[Csub17s.ZERO] = null;
                            pCAUD47DInputRec.setUlIdStage(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
                            pCAUD47DInputRec.setTsLastUpdate(cfad36si.getTsLastUpdate_ARRAY().getTsLastUpdate((int) STAGE));
                            
                            //  Call Update UNIT EMP LINK DAM
                            // PWO 1037: svcshell.src: in the rc= statement below
                            // replaced the lines:
                            // pReturnPB, 
                            // pServiceStatus,
                            // pABHI);
                            // with:
                            // TUX_STATUSPARMS);
                            rc = caud47dAUDdam(sqlca, pCAUD47DInputRec, pCAUD47DOutputRec);
                            
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                    // PWO 1037: svcshell.src: added case ARC_SUCCESS:
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
                                    // 
                                    // BEGIN CAUDA0D - Assigns the case to the user
                                    // reopening the home (logged in user).
                                    // 
                                    //  Allocate memory for DAM Input and Output
                                    // Structures
                                    pCAUDA0DInputRec = new CAUDA0DI();
                                    
                                    pCAUDA0DOutputRec = new CAUDA0DO();
                                    
                                    // SIR 1829
                                    pCAUDA0DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                    pCAUDA0DInputRec.setUlIdStage(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
                                    //  A change was made to Unit information, so update UNIT
                                    
                                    //  Call Update UNIT DAM
                                    // PWO 1037: svcshell.src: in the rc= statement below
                                    // replaced the lines:
                                    // pReturnPB, 
                                    // pServiceStatus,
                                    // pABHI);
                                    // with:
                                    // TUX_STATUSPARMS);
                                    rc = cauda0dQUERYdam(sqlca, pCAUDA0DInputRec, pCAUDA0DOutputRec);
                                    
                                    // Analyze return code
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            // PWO 1037: svcshell.src: changed SQL_SUCCESS to ARC_SUCCESS
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Set RetVal to FND_SUCCESS
                                            RetVal = SUCCESS;
                                            
                                            
                                            // 
                                            // (BEGIN): Assign to Current Worker
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCCMND3DInputRec = new CCMND3DI();
                                            
                                            pCCMND3DOutputRec = new CCMND3DO();
                                            pCCMND3DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                            if (NO_DATA_FOUND == rc) {
                                                pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                
                                                //  function prototypes 
                                                pCCMND3DInputRec.setUlIdPerson(cfad36si.getUlIdPerson());
                                            }
                                            //  If years are equal and month is greater
                                            else if (pCAUDA0DOutputRec.getDtDtEmpTermination().year == NULL_DATE1 && pCAUDA0DOutputRec.getDtDtEmpTermination().month == NULL_DATE1 && pCAUDA0DOutputRec.getDtDtEmpTermination().day == NULL_DATE1) {
                                                pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                pCCMND3DInputRec.setUlIdStagePerson(pCAUDA0DOutputRec.getUlIdStagePerson());
                                                pCCMND3DInputRec.setUlIdPerson(pCAUDA0DOutputRec.getUlIdPerson());
                                            }
                                            //  If years and months are equal and day is greater
                                            else {
                                                pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                pCCMND3DInputRec.setUlIdStagePerson(pCAUDA0DOutputRec.getUlIdStagePerson());
                                                pCCMND3DInputRec.setUlIdPerson(cfad36si.getUlIdPerson());
                                            }
                                            pCCMND3DInputRec.setSzCdStagePersRelInt(PRS_WORKER);
                                            pCCMND3DInputRec.setSzCdStagePersRole(PRIM_WORKER);
                                            pCCMND3DInputRec.setSzCdStagePersType(PRS_WORKER);
                                            pCCMND3DInputRec.setUlIdStage(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
                                            pCCMND3DInputRec.setBIndStagePersEmpNew(EMP_IS_NEW);
                                            //  Call DAM to Update Parent Unit
                                            // PWO 1037: svcshell.src: in the rc= statement below
                                            // replaced the lines:
                                            // pReturnPB, 
                                            // pServiceStatus,
                                            // pABHI);
                                            // with:
                                            // TUX_STATUSPARMS);
                                            rc = ARC_UTLGetDateAndTime(pCCMND3DInputRec.getDtDtStagePersLink() , 0);
                                            
                                            
                                            // SIR #20159: Added a call to CallCAUDC2D function
                                            rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    // Set RetVal to FND_SUCCESS
                                                    
                                                    RetVal = SUCCESS;
                                                    
                                                    //  SIR #10226 - Add a call to CAUDC3D to update the
                                                    // new Primary Workers Unit to the Stage Table.
                                                    
                                                    // 
                                                    // (BEGIN): Update Workers Unit to the Stage Table
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCAUDC3DInputRec = new CAUDC3DI();
                                                    
                                                    pCAUDC3DOutputRec = new CAUDC3DO();
                                                    pCAUDC3DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                                    pCAUDC3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                    pCAUDC3DInputRec.setUlIdStage(pCCMND3DInputRec.getUlIdStage());
                                                    pCAUDC3DInputRec.setUlIdPerson(pCCMND3DInputRec.getUlIdPerson());
                                                    rc = caudc3dAUDdam(sqlca, pCAUDC3DInputRec, pCAUDC3DOutputRec);
                                                    
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            // Set RetVal to FND_SUCCESS
                                                            
                                                            RetVal = SUCCESS;
                                                            break;
                                                            
                                                        default :
                                                            pServiceStatus.explan_code = Csub50s.FND_FAIL;
                                                            
                                                            // Set RetVal to FND_FAIL
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                            break;
                                                    }
                                                    break;
                                                    
                                                default :
                                                    pServiceStatus.explan_code = Csub50s.FND_FAIL;
                                                    
                                                    // Set RetVal to FND_FAIL
                                                    
                                                    RetVal = Csub50s.FND_FAIL;
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                    break;
                                            }
                                            
                                            if (SUCCESS == RetVal) {
                                                
                                                // 
                                                // BEGIN CCMN01U - Post the Reopen home event
                                                // 
                                                //  Allocate memory for DAM Input and Output
                                                // Structures
                                                pCCMN01UInputRec = new CCMN01UI();
                                                
                                                pCCMN01UOutputRec = new CCMN01UO();
                                                pCCMN01UInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                pCCMN01UInputRec.setROWCCMN01UIG00(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT));
                                                rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                                                        
                                                        // Set RetVal to FND_SUCCESS
                                                        RetVal = SUCCESS;
                                                        
                                                        
                                                        // 
                                                        // BEGIN CAUD70D - Reopen Home on Resource
                                                        // Table
                                                        // 
                                                        //  Allocate memory for DAM Input and
                                                        // Output Structures
                                                        pCAUD70DInputRec = new CAUD70DI();
                                                        
                                                        pCAUD70DOutputRec = new CAUD70DO();
                                                        pCAUD70DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                                        pCAUD70DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                        pCAUD70DInputRec.setSzCdRsrcFaHomeStatus(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT));
                                                        pCAUD70DInputRec.setSzCdRsrcClosureRsn(cfad36si.getSzCdRsrcClosureRsn());
                                                        pCAUD70DInputRec.setSzCdRsrcInvolClosure(cfad36si.getSzCdRsrcInvolClosure());
                                                        pCAUD70DInputRec.setSzCdRsrcRecmndReopen(cfad36si.getSzCdRsrcRecmndReopen());
                                                        pCAUD70DInputRec.setUlIdResource(cfad36si.getUlIdResource());
                                                        pCAUD70DInputRec.getTsLastUpdate()[(int) RESOURCE] = cfad36si.getTsLastUpdate_ARRAY().getTsLastUpdate((int) RESOURCE);
                                                        
                                                        // The assumption is that there must be at least one
                                                        // person involved with the Risk Assessment. If no
                                                        // Principals were found then send back an error.
                                                        pCAUD70DInputRec.setCIndRsrcWriteHist(FND_YES);
                                                        
                                                        pCAUD70DInputRec.setUlIdRsrcFaHomeEvent(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.CURRENT).getUlIdEvent());
                                                        
                                                        pCAUD70DInputRec.setSzCdRsrcStatus(cfad36si.getSzCdRsrcStatus());
                                                        
                                                        //  Declare FOUNDATION variables
                                                        
                                                        //  Declare local variables
                                                        
                                                        
                                                        //  Start performance timer for service. All performance functions always
                                                        // return success so there is no need to check status.
                                                        rc = caud70dAUDdam(sqlca, pCAUD70DInputRec, pCAUD70DOutputRec);
                                                        
                                                        //  Analyze return code
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                // Set RetVal to FND_SUCCESS
                                                                RetVal = SUCCESS;
                                                                
                                                                //  SIR #3318 - 2/27/96 - PURCELA - Added call to
                                                                // DAMS CSES56D and CAUD75D to retrieve an then
                                                                // delete a Records Retention row from the
                                                                // database table when the home is successfully
                                                                // reopened.
                                                                
                                                                // 
                                                                // Call the REC RETN RTRV Dam - CSES56D
                                                                // Description - This DAM will retrieve a full
                                                                // row from RECORDS RETENTION table and will take
                                                                // as input ID_CASE
                                                                // 
                                                                
                                                                //  Allocate memory for DAM Input and Output Structures
                                                                pCSES56DInputRec = new CSES56DI();
                                                                
                                                                pCSES56DOutputRec = new CSES56DO();
                                                                
                                                                //## BEGIN TUX/XML: Declare XML variables 
                                                                pCSES56DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                                                pCSES56DInputRec.setUlIdCase(cfad36si.getUlIdCase());
                                                                
                                                                // SIR 21891 - missing versioning
                                                                //  Run-time Versioning
                                                                
                                                                //  Check buffer size
                                                                
                                                                //  Process error message and return to client
                                                                
                                                                //  Initialize output message and length
                                                                
                                                                //  Initialize service status fields
                                                                
                                                                // 
                                                                // Call DAMs to retrieve data
                                                                // 
                                                                rc = cses56dQUERYdam(sqlca, pCSES56DInputRec, pCSES56DOutputRec);
                                                                
                                                                
                                                                
                                                                //  Analyze return code
                                                                switch (rc) {
                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        
                                                                        
                                                                        // 
                                                                        // Call Primary Staff Simple Dam - CAUD75D
                                                                        // Description - This DAM will add/update
                                                                        // /delete a full row from the RECORDS
                                                                        // RETENTION table.
                                                                        // 
                                                                        
                                                                        //  Allocate memory for DAM Input and Output Structures
                                                                        pCAUD75DInputRec = new CAUD75DI();
                                                                        
                                                                        pCAUD75DOutputRec = new CAUD75DO();
                                                                        pCAUD75DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                                                        pCAUD75DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                                                                        pCAUD75DInputRec.setTsLastUpdate(pCSES56DOutputRec.getTsLastUpdate());
                                                                        pCAUD75DInputRec.setUlIdCase(cfad36si.getUlIdCase());
                                                                        rc = caud75dAUDdam(sqlca, pCAUD75DInputRec, pCAUD75DOutputRec);
                                                                        
                                                                        //  SIR 21747
                                                                        // Remove the extra stop timer
                                                                        
                                                                        //  Analyze return code
                                                                        switch (rc) {
                                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                break;
                                                                            case NO_DATA_FOUND:
                                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                                                                break;
                                                                                
                                                                            default :
                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                                                break;
                                                                        }
                                                                        break;
                                                                    case NO_DATA_FOUND:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        
                                                                        
                                                                        //  Start Performance Timer
                                                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                                                        break;
                                                                        
                                                                    default :
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                                        break;
                                                                }
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
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                                break;
                                                        }
                                                        break;
                                                        
                                                    default :
                                                        
                                                        //  Set RetVal to FND_FAIL
                                                        RetVal = Csub50s.FND_FAIL;
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                        break;
                                                }
                                            }
                                            break;
                                            
                                        default :
                                            
                                            //  Set RetVal to FND_FAIL
                                            RetVal = Csub50s.FND_FAIL;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            break;
                                    }
                                    
                                    
                                    break;
                                    
                                default :
                                    
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    //##                     return(ARC_SUCCESS);
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    
                                    break;
                            }
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            
                            break;
                            
                        default :
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            //##                  return(ARC_SUCCESS);
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            break;
                    }
                    
                    break;
                    
                default :
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            //  SIR 12560
            // moved allocation of memory for the CFAD01D input record so
            // that memory will be allocated throughout its use.
            //  Allocate memory for auxilary save service memory Structure
            pCFAD01DInputRec = new Cfad01a();
            
            if (SUCCESS == RetVal) {
                // 
                // (BEGIN): Contracts existance determination.  Is there an open foster
                // and adoptive contract for the home?
                // 
                
                // 
                // (BEGIN): CLSS67D - List retrieval of Contract rows for and id resource.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                
                pCLSS67DInputRec = new CLSS67DI();
                
                pCLSS67DOutputRec = new CLSS67DO();
                pCLSS67DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                pCLSS67DInputRec.setUlIdResource(cfad36si.getUlIdResource());
                pCLSS67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS67DO._CLSS67DO__ROWCLSS67DO_SIZE);
                pCLSS67DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
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
                        for (i216 = 0;i216 < ulContractQty;i216++) {
                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i216).getUlIdContract();
                            cfad36si.setSzCdCntrctRegion(pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i216).getSzCdCntrctRegion());
                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsLastUpdate = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i216).getTsLastUpdate();
                            
                            // 
                            // (BEGIN) CSES80D: Retrieve Contract Period table information
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES80DInputRec = new CSES80DI();
                            
                            pCSES80DOutputRec = new CSES80DO();
                            pCSES80DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                            pCSES80DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                            rc = cses80dQUERYdam(sqlca, pCSES80DInputRec, pCSES80DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm = pCSES80DOutputRec.getDtDtCnperTerm();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperStart = pCSES80DOutputRec.getDtDtCnperStart();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperClosure = pCSES80DOutputRec.getDtDtCnperClosure();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnperPeriod = pCSES80DOutputRec.getUlNbrCnperPeriod();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate2 = pCSES80DOutputRec.getTsLastUpdate();
                                    //  Populate start date with current date
                                    rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    
                                    if (pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.year > dtTempDate.year) {
                                        testBool = true;
                                    }
                                    //  If year, month and day are equal
                                    else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.month > dtTempDate.month)) {
                                        testBool = true;
                                    }
                                    else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.day > dtTempDate.day)) {
                                        testBool = true;
                                        
                                    }
                                    else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm.day == dtTempDate.day)) {
                                        testBool = true;
                                    }
                                    else {
                                        testBool = false;
                                    }
                                    
                                    if (testBool) {
                                        
                                        if (0 != CONTRACT_STATUS_CLOSED.compareTo(pCSES80DOutputRec.getSzCdCnperStatus())) {
                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].cSysIndContractCurrent = 1;
                                        }
                                        
                                        else {
                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].cSysIndContractCurrent = 0;
                                        }
                                    }
                                    
                                    else {
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i216].cSysIndContractCurrent = 0;
                                    }
                                    RetVal = SUCCESS;
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    //  Populate end date with current date
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    break;
                                    
                                default :
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                        }
                        
                        // 
                        // (END) CSES80D: Retrieve Contract Period table information
                        // 
                        
                        
                        
                        RetVal = SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Call CAUD61D
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
                if (SUCCESS == RetVal) {
                    
                    //  Loop through all contract rows returned from the previous DAMs
                    for (i216 = 0;i216 < ulContractQty;i216++) {
                        
                        if (pCFAD01DInputRec.ROWCFAD08SIG07[i216].cSysIndContractCurrent) {
                            // 
                            // (BEGIN): CSES81D - Contract Version retrieve for an idContract
                            // , contract period number, and version end date that is greater
                            // than the current date.
                            // 
                            
                            pCSES81DInputRec = new CSES81DI();
                            
                            pCSES81DOutputRec = new CSES81DO();
                            pCSES81DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                            pCSES81DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                            pCSES81DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnperPeriod);
                            pCSES81DInputRec.setDtDtCnverEnd(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnverEnd);
                            rc = cses81dQUERYdam(sqlca, pCSES81DInputRec, pCSES81DOutputRec);
                            
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnverVersion = pCSES81DOutputRec.getUlNbrCnverVersion();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdCnver = pCSES81DOutputRec.getUlIdCnver();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnverCreate = pCSES81DOutputRec.getDtDtCnverCreate();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnverEffective = pCSES81DOutputRec.getDtDtCnverEffective();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnverEnd = pCSES81DOutputRec.getDtDtCnverEnd();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate3 = pCSES81DOutputRec.getTsLastUpdate();
                                    
                                    
                                    // 
                                    // (BEGIN): CLSS13D - Retrieve contract service codes for
                                    // the contract, period, and version passed to the DAM.
                                    // 
                                    pCLSS13DInputRec = new CLSS13DI();
                                    
                                    pCLSS13DOutputRec = new CLSS13DO();
                                    // Pass timestamp mismatch back to client
                                    //##                  return (ARC_SUCCESS);
                                    pCLSS13DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                    pCLSS13DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                                    pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
                                    pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                    rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
                                    tmpSvcRowQty1 = 0;
                                    tempSvcRowQty = 0;
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            tmpSvcRowQty1 = pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();
                                            for (j = 0;j < pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate5[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getTsLastUpdate();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnsvcVersion[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcVersion();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdCnsvc[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlIdCnsvc();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnsvcLineItem[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcLineItem();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnsvcUnitRate[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcUnitRate();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulAmtCnsvcUnitRateUsed[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlAmtCnsvcUnitRateUsed();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].szNbrCnsvcUnitType[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzNbrCnsvcUnitType();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzCdCnsvcService();
                                                
                                                if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j]))) {
                                                    
                                                    bIndFosterContractExists = true;
                                                    bIndUpdateFosterContract = 1;
                                                }
                                                
                                                if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j]))) {
                                                    
                                                    bIndAdoptContractExists = true;
                                                    bIndUpdateAdoptContract = 1;
                                                }
                                                if (tempSvcRowQty >= 0) {
                                                    pCLSS68DInputRec = new CLSS68DI();
                                                    
                                                    pCLSS68DOutputRec = new CLSS68DO();
                                                    //##            return(ARC_SUCCESS);
                                                    pCLSS68DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                                    pCLSS68DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                                                    pCLSS68DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnperPeriod);
                                                    pCLSS68DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnverVersion);
                                                    pCLSS68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS68DO._CLSS68DO__ROWCLSS68DO_SIZE);
                                                    pCLSS68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                                    
                                                    //  Call DAM
                                                    rc = clss68dQUERYdam(sqlca, pCLSS68DInputRec, pCLSS68DOutputRec);
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                                            tempSvcRowQty = pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulSysNbrGenericCntr = pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getSzCdCncntyService();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate4[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getTsLastUpdate();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdCncnty[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlIdCncnty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyCounty[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getSzCdCncntyCounty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCncntyEffective[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getDtDtCncntyEffective();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCncntyEnd[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getDtDtCncntyEnd();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCncntyPeriod[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyPeriod();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCncntyVersion[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyVersion();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCncntyLineItem[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyLineItem();
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
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            break;
                                    }
                                    
                                    
                                    // 
                                    // (END): CLSS13D - Retrieve contract service codes for
                                    // the contract, period, and version passed to the DAM.
                                    // 
                                    
                                    RetVal = SUCCESS;
                                    break;
                                case NO_DATA_FOUND:
                                    break;
                                    
                                default :
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    
                                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
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
                pCINT20DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                pCINT20DInputRec.setUlIdStage(cfad36si.getROWCCMN01UIG00_ARRAY().getROWCCMN01UIG00(Csub68s.NEXT).getUlIdStage());
                
                
                // 
                // Analyze error code
                // 
                if (0 == HOME_STATUS_CLOSED.compareTo(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT))) {
                    pCINT20DInputRec.setSzCdStagePersRole(HISTORICAL_PRIM_WKR);
                }
                
                //  if someone with a division number is trying to save - i.e.
                // invalid region - then save the region as the state office
                // region.
                else {
                    pCINT20DInputRec.setSzCdStagePersRole(PRIM_WORKER);
                }
                pCINT20DInputRec.setSzCdStagePersType(Cint12s.PERSON_TYPE_WORKER);
                
                
                //  Start Performance Timer
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
                        
                        //  Set explan_data to usRow using sprintf
                        //##                sprintf(pReturnPB->appl_status.explan_data,
                        //##                        "%u",
                        //##                        usRow);
                        
                        break;
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
                pCRES13DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                pCRES13DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES13DO._CRES13DO__ROWCRES13DO_SIZE);
                pCRES13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                
                // 
                // Service Macro Definitions
                // 
                
                
                // 
                // Function Prototypes
                // 
                pCRES13DInputRec.setUlIdResource(cfad36si.getUlIdResource());
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
                            // 
                            // Populate Output Message
                            // 
                            
                            if ((0 == RSRC_BUIS_ADDR.compareTo(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getSzCdRsrcAddrType())) && (pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getSzNbrRsrcAddrVid() != null)) {
                                ulTempIdRsrcAddress = pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getUlIdRsrcAddress();
                                
                                //## BEGIN TUX/XML: Declare XML variables 
                                cfad36si.setSzCdRsrcCnty(pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getSzCdFacilityCounty());
                                
                                l = pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();
                            }
                        }
                        
                        
                        //  Set explan_data to usRow using sprintf
                        //##                sprintf(pReturnPB->appl_status.explan_data,
                        //##                        "%u",
                        //##                        usRow);
                        
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                        
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                        
                        
                    default :
                        pServiceStatus.explan_code = FND_ERROR;
                        
                        //  Set Return Value to FND_ERROR
                        RetVal = FND_ERROR;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        
                        
                        break;
                }
            }
            if ((RetVal == SUCCESS) && (FND_YES == cfad36si.getBIndRsrcNonPrs()) && (0 != HOME_STATUS_CLOSED.compareTo(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT)))) {
                //  Only create new contracts if one does not exist for foster or adoptive
                // contracts.
                while ((!bIndAdoptContractExists) || (!bIndFosterContractExists)) {
                    if (!bIndAdoptContractExists) {
                        bIndAdoptContractExists = true;
                        usCreateContract = ADOPTIVE;
                    }
                    
                    // 
                    // (END): CCMN39D - Retrieve Primary Worker's Region
                    // 
                    // end of SIR 22177
                    
                    else if (!bIndFosterContractExists) {
                        bIndFosterContractExists = true;
                        usCreateContract = Ccfc51u.FOSTER;
                    }
                    
                    if (0 == cfad36si.getSzCdRsrcCnty().compareTo(COUNTY_CD_OUT_OF_STATE)) {
                        // 
                        // (BEGIN): CCMN39D - Retrieve Primary Worker's Region
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN39DInputRec = new CCMN39DI();
                        
                        pCCMN39DOutputRec = new CCMN39DO();
                        pCCMN39DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                        pCCMN39DInputRec.setUlIdPerson(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                        pCCMN39DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
                        rc = ccmn39dQUERYdam(sqlca, pCCMN39DInputRec, pCCMN39DOutputRec);
                        
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                if ('0' == pCCMN39DOutputRec.getSzCdUnitRegion()[0]) {
                                    cfad36si.getSzCdRsrcRegion()[0] = pCCMN39DOutputRec.getSzCdUnitRegion()[1];
                                    
                                    
                                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                    cfad36si.getSzCdRsrcRegion()[1] = pCCMN39DOutputRec.getSzCdUnitRegion()[2];
                                    //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                    
                                    
                                    
                                }
                                
                                
                                else {
                                    cfad36si.setSzCdRsrcRegion(CAPS_UNIT_STATE_OFFICE);
                                }
                                
                                //  Set explan_data to usRow
                                // Note: Use sprintf
                                //##        sprintf(pReturnPB->appl_status.explan_data,
                                //##                "%u",
                                //##                usRow);
                                
                                break;
                                
                                
                            default :
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                
                                //  Set explan_data to usRow
                                // Note: Use sprintf
                                //##        sprintf(pReturnPB->appl_status.explan_data,
                                //##                "%u",
                                //##                usRow);
                                
                                break;
                        }
                    }
                    else {
                        
                        // 
                        // (BEGIN): CSES82D - Region retrieval from Region/County table
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES82DInputRec = new CSES82DI();
                        
                        pCSES82DOutputRec = new CSES82DO();
                        
                        //## BEGIN TUX/XML: Declare XML variables
                        pCSES82DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                        pCSES82DInputRec.setSzCdRsrcSvcCnty(cfad36si.getSzCdRsrcCnty());
                        
                        
                        //  Call CAUD53D to AUD all data on Cost_Reim_dtl table
                        rc = cses82dQUERYdam(sqlca, pCSES82DInputRec, pCSES82DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                cfad36si.setSzCdRsrcRegion(pCSES82DOutputRec.getSzCdRsrcSvcRegion());
                                
                                // Set RetVal to FND_SUCCESS
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
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                break;
                        }
                    }
                    
                    // 
                    // (END): CSES82D - Region/County retrieve
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD01DInputRec = new CAUD01DI();
                    
                    pCAUD01DOutputRec = new CAUD01DO();
                    pCAUD01DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                    pCAUD01DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCAUD01DInputRec.setUlIdResource(cfad36si.getUlIdResource());
                    pCAUD01DInputRec.setSzCdCntrctFuncType(STAGE_CD_FAD);
                    pCAUD01DInputRec.setSzCdCntrctProgramType(FA_PROGRAM);
                    pCAUD01DInputRec.setSzCdCntrctProcureType(PROVIDER_ENROLL);
                    pCAUD01DInputRec.setSzCdCntrctRegion(cfad36si.getSzCdRsrcRegion());
                    pCAUD01DInputRec.setCIndCntrctBudgLimit(NO_LIMIT);
                    pCAUD01DInputRec.setUlIdRsrcAddress(ulTempIdRsrcAddress);
                    pCAUD01DInputRec.setUlIdCntrctManager(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                    pCAUD01DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
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
                    pCAUD20DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                    pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCAUD20DInputRec.setUlIdContract(ulIdTempContract);
                    pCAUD20DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                    pCAUD20DInputRec.setUlNbrCnperPeriod(Ccmn19s.ONE);
                    rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    dtCurrentDate = dtTempDate;
                    
                    
                    //  Call CMSC21D to update DELVRD SVC DTL
                    
                    
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
                            
                            if (false == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                            }
                            else {
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                // 
                                // BEGIN CAUD15D  CONTRACT VERSION AUD
                                // 
                                
                                pCAUD15DInputRec = new CAUD15DI();
                                
                                pCAUD15DOutputRec = new CAUD15DO();
                                pCAUD15DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD15DInputRec.setUlIdContract(ulIdTempContract);
                                pCAUD15DInputRec.setUlNbrCnverPeriod(Ccmn19s.ONE);
                                pCAUD15DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                                pCAUD15DInputRec.setUlNbrCnverVersion(Ccmn19s.ONE);
                                rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                
                                dtCurrentDate = dtTempDate;
                                
                                
                                //  Call CAUD44D to update the status of an invoice
                                
                                
                                
                                rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                pCAUD15DInputRec.setDtDtCnverCreate(dtTempDate);
                                pCAUD15DInputRec.setDtDtCnverEffective(dtTempDate);
                                pCAUD15DInputRec.setDtDtCnverEnd(dtCurrentDate);
                                pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
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
                    if (Ccfc51u.FOSTER == usCreateContract) {
                        // 
                        // BEGIN CAUD17D - CONTRACT SERVICE
                        // 
                        
                        pCAUD17DInputRec = new CAUD17DI();
                        
                        pCAUD17DOutputRec = new CAUD17DO();
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                        pCAUD17DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                        pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                        pCAUD17DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                        pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                        pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                        pCAUD17DInputRec.setSzNbrCnsvcUnitType(DAY_24_HOURS);
                        pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                        
                        pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                        
                        usCountyRow = 0;
                        
                        
                        // SIR 19613
                        while (usCountyRow < NBR_SVC_CODE_SIXTY_ABCD && RetVal == SUCCESS) {
                            
                            pCAUD17DInputRec.setUlNbrCnsvcLineItem(usCountyRow + 1);
                            
                            switch (usCountyRow) {
                                case 0:
                                    
                                    // 
                                    // Service Macro Definitions
                                    // 
                                    
                                    // 
                                    // Function Prototypes
                                    // 
                                    
                                    pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_BASIC);
                                    pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_BASIC);
                                    break;
                                case 1:
                                    pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_MOD);
                                    
                                    //## BEGIN TUX/XML: Declare XML variables 
                                    pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_MOD);
                                    
                                    break;
                                case 2:
                                    pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_SPEC);
                                    pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_SPEC);
                                    
                                    break;
                                case 3:
                                    pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_INT);
                                    pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_INT);
                                    
                                    // 
                                    // END CCMN01U
                                    // 
                                    
                                    
                                    break;
                                    
                                    
                                default :
                                    
                                    //  PROCESS_TUX_SQL_ERROR_TRANSACT is not necssary because the common
                                    // function has already taken care of this call
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
                                    
                                    // 
                                    // END CCMN02U
                                    // 
                                    
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
                        pCAUD17DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                        pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD17DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                        pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                        pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                        pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                        pCAUD17DInputRec.setUlNbrCnsvcLineItem(Ccmn19s.ONE);
                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_ADP_SUB);
                        pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                        pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                        pCAUD17DInputRec.setSzNbrCnsvcUnitType(ADOPTION_SUBSIDY);
                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(SUBSIDY_PAYMENT);
                        
                        // Call CAUDE2D
                        rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                pCAUD17DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD17DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
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
                                
                                
                                //  Analyze return code
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
                                        
                                        // 
                                        // END CAUD70D
                                        // 
                                        
                                        
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
                    
                    // 
                    // END CAUD17D
                    // 
                    
                    // 
                    // BEGIN CAUD08D - Contract County Insert
                    // 
                    // begin SIR #15787
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD08DInputRec = new CAUD08DI();
                    
                    pCAUD08DOutputRec = new CAUD08DO();
                    
                    usCountyRow = 0;
                    ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_A;
                    bFoster = true;
                    
                    
                    // 
                    // Analyze error code
                    // 
                    if (Ccfc51u.FOSTER == usCreateContract) {
                        rc = Csub26s.CallCRES04D(cfad36si, szAdoptiveOrFoster, szCategoryType, pServiceStatus);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                RetVal = SUCCESS;
                                if (!(FA_CATG_ADOPT.compareTo(szCategoryType) != 0)) {
                                    bFoster = false;
                                }
                                
                                if (szAdoptiveOrFoster.charAt(0) == null) {
                                    ulAdoptiveOrFoster = 0;
                                }
                                
                                
                                else {
                                    //  SIR 22686 loop through the rows to see if any of them
                                    // are group homes, if they are set an indicator
                                    for (usCountyRow = 0;usCountyRow < NBR_OF_HOME_TYPE;usCountyRow++) {
                                        if (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_GROUP) {
                                            bGroupHome = true;
                                            
                                            // 
                                            // (END): Update IdUnit on the Stage Table
                                            // 
                                            
                                            break;
                                        }
                                        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                        
                                        
                                        
                                    }
                                    for (usCountyRow = 0;usCountyRow < NBR_OF_HOME_TYPE;usCountyRow++) {
                                        if ((szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_HABIL) || (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_THER) || (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_PRIM_MED)) {
                                            //## END TUX/XML: Turn the XML buffer into an input message struct 
                                            
                                            
                                            
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
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                
                                break;
                        }
                    }
                    
                    // SIR 19613
                    else if (ADOPTIVE == usCreateContract) {
                        ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_AB;
                    }
                    
                    
                    
                    else {
                        ulAdoptiveOrFoster = 0;
                    }
                    pCAUD08DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                    pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCAUD08DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                    
                    //  Initialize current date to dtTempDate(today's date) and
                    // Add years, no months and no years to dtCurrentDate
                    dtCurrentDate = dtTempDate;
                    rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                    pCAUD08DInputRec.setUlIdContract(ulIdTempContract);
                    pCAUD08DInputRec.setUlIdResource(cfad36si.getUlIdResource());
                    pCAUD08DInputRec.setSzCdCncntyCounty(pCFAD01DInputRec.ROWCFAD08SIG07[0].szCdCncntyCounty[0]);
                    pCAUD08DInputRec.setDtDtCncntyEffective(dtTempDate);
                    
                    pCAUD08DInputRec.setUlNbrCncntyPeriod(Ccmn19s.ONE);
                    
                    pCAUD08DInputRec.setUlNbrCncntyVersion(Ccmn19s.ONE);
                    // SIR#15787: Set ulAdoptiveOrFoster based on home type
                    // 19613 Basic only has 63A now
                    usCountyRow = 0;
                    //   County AUD processing CAUD08D
                    while (usCountyRow < ulAdoptiveOrFoster && SUCCESS == pServiceStatus.explan_code) {
                        
                        // 
                        // Call DAMs to retrieve data
                        // 
                        
                        if (Ccfc51u.FOSTER == usCreateContract && bFoster) {
                            
                            //  Analyze return code
                            switch (usCountyRow) {
                                case 0:
                                    
                                    
                                    pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_BASIC);
                                    
                                    // 
                                    // End Call to Primary Staff Simple Dam - CAUD75D
                                    // 
                                    
                                    break;
                                case 1:
                                    pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_MOD);
                                    
                                    break;
                                    
                                case 2:
                                    pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_SPEC);
                                    
                                    break;
                                    
                                case 3:
                                    pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_INT);
                                    
                                    // 
                                    // End Call to REC RETN RTRV Dam - CSES56D
                                    // 
                                    
                                    // End SIR #3318
                                    
                                    break;
                                    
                                    
                                default :
                                    
                                    break;
                            }
                        }
                        
                        //  PWO 1080: 
                        // If the employee to be modified has (or is proposed to have)
                        // MemberInOut status (in this unit) == IN, then
                        // check if the employee is currently the UNIT APPROVER 
                        // of the unit in which they are currently "IN" assigned.
                        // If the employee is the UNIT APPROVER of their current "IN"
                        // unit (and that current "IN" unit is not the unit being 
                        // modified right now), the CallCCMNG5D function will return 
                        // MSG_CMN_UNIT_APPROVER.  
                        // If the CallCCMNG5D function returns MSG_CMN_UNIT_APPROVER, 
                        // then the CallCCMN36D function needs to be called
                        // (see further comments within switch after 'rc=CallCCMN36D' line).
                        if ((ADOPTIVE == usCreateContract) && (Csub17s.ZERO == usCountyRow)) {
                            pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_ADP_SUB);
                        }
                        
                        // PWO 1080: Add if statement
                        if ((ADOPTIVE == usCreateContract) && (Ccmn19s.ONE == usCountyRow)) {
                            pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_ADP_NON_REC_SUB);
                        }
                        pCAUD08DInputRec.setUlNbrCncntyLineItem((usCountyRow + Ccmn19s.ONE));
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
                                
                                // 
                                // END CAUD70D
                                // 
                                
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
            //  If the CallCCMN36D function returns SQL_NOT_FOUND,
            // we cannot re-assign this employee to another unit.
            // If the current IdPerson that we are processing is 
            // the same IdPerson in pInputMsg->ROWCCMN22SIG01
            // (that is the Unit Approver for this unit), 
            // then in addition to not re-assigning the current
            // IdPerson, we should not continue processing the 
            // remaining employees in the pInputMsg. Return the
            // MSG_CMN_TMSTAMP_MISMATCH message to the user.
            // else
            // we may continue with the remaining employees
            // in the pInputMsg. The if statement following this 
            // switch statement (if (rc == ARC_SUCCESS)) contains
            // all remaining processing on the employee within this 
            // for loop.  With rc set to SQL_NOT_FOUND, we effectively
            // skip to the next employee in the pInputMsg.
            if (SUCCESS == RetVal) {
                
                // PWO 1080: Add if statement
                if ((FND_YES == cfad36si.getBIndRsrcNonPrs()) && (0 != HOME_STATUS_CLOSED.compareTo(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT)))) {
                    i216 = 0;
                    //  Only modify contracts when flags are TRUE
                    while (bIndUpdateAdoptContract != 0 || bIndUpdateFosterContract != 0) {
                        if (pCFAD01DInputRec.ROWCFAD08SIG07[i216].cSysIndContractCurrent) {
                            //  PWO 1080: removed this if statement: see comments above.
                            // }  end if 
                            
                            if (bIndUpdateAdoptContract != 0 && (0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]) || 0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]))) {
                                bIndUpdateAdoptContract = 0;
                                usUpdateContract = ADOPTIVE;
                            }
                            // SIR 19613
                            else if (bIndUpdateFosterContract != 0 && (0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[0]))) {
                                bIndUpdateFosterContract = 0;
                                usUpdateContract = Ccfc51u.FOSTER;
                            }
                            
                            // 
                            // BEGIN CAUD20D  CONTRACT PERIOD
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCAUD20DInputRec = new CAUD20DI();
                            
                            pCAUD20DOutputRec = new CAUD20DO();
                            pCAUD20DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                            pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            pCAUD20DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                            pCAUD20DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                            
                            pCAUD20DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnperPeriod);
                            
                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                            pCAUD20DInputRec.setDtDtCnperClosure(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperClosure);
                            pCAUD20DInputRec.setDtDtCnperTerm(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm);
                            pCAUD20DInputRec.setDtDtCnperStart(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperStart);
                            pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_ACTIVE);
                            pCAUD20DInputRec.setCIndCnperRenewal('N');
                            pCAUD20DInputRec.setCIndCnperSigned('Y');
                            pCAUD20DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate2);
                            rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    
                                    //  BEGIN PWO 420 -- Ensure that units that are deleted are not
                                    // referenced as the parent unit of any other units
                                    // SIR #20159: Added a call to CallCAUDC2D function
                                    if (false == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                                    }
                                    
                                    else {
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                    }
                                    
                                    // 
                                    // END CCMN01U
                                    // 
                                    
                                    
                                    break;
                                    
                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    
                                    // 
                                    // END CAUDA0D
                                    // 
                                    
                                    
                                    break;
                            }
                            
                            if ((pCFAD01DInputRec.ROWCFAD08SIG07[i216].cSysIndContractCurrent) && (usUpdateContract == Ccfc51u.FOSTER)) {
                                //  Start Performance Timer
                                rc = ContractVerSerCnty(cfad36si, pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract, pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnperPeriod, pServiceStatus);
                                
                                if (rc != SUCCESS) {
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                }
                            }
                        }
                        i216++;
                    }
                }
                
                if ((FND_YES == cfad36si.getBIndRsrcNonPrs()) && (0 == HOME_STATUS_CLOSED.compareTo(cfad36si.getSzCdRsrcFaHomeStatus_ARRAY().getSzCdRsrcFaHomeStatus(Csub68s.NEXT)))) {
                    
                    // 
                    // (BEGIN): CSES82D - Region retrieval from Region/County table
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES82DInputRec = new CSES82DI();
                    
                    pCSES82DOutputRec = new CSES82DO();
                    pCSES82DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                    pCSES82DInputRec.setSzCdRsrcSvcCnty(cfad36si.getSzCdRsrcCnty());
                    rc = cses82dQUERYdam(sqlca, pCSES82DInputRec, pCSES82DOutputRec);
                    
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            cfad36si.setSzCdCntrctRegion(pCSES82DOutputRec.getSzCdRsrcSvcRegion());
                            
                            // Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            
                            // 
                            // END CAUD47D
                            // 
                            
                            
                            break;
                            
                        default :
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            break;
                    }
                    i216 = 0;
                    //  Only modify contracts where flag is TRUE
                    while (bIndUpdateAdoptContract != 0 || bIndUpdateFosterContract != 0) {
                        
                        if (pCFAD01DInputRec.ROWCFAD08SIG07[i216].cSysIndContractCurrent) {
                            if (bIndUpdateAdoptContract != 0 && (0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]))) {
                                bIndUpdateAdoptContract = 0;
                                usUpdateContract = ADOPTIVE;
                            }
                            else if (bIndUpdateFosterContract != 0 && (0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[(int) FIRST_REC]))) {
                                bIndUpdateFosterContract = 0;
                                usUpdateContract = Ccfc51u.FOSTER;
                            }
                            
                            
                            
                            // 
                            // BEGIN CAUD20D  CONTRACT PERIOD
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCAUD20DInputRec = new CAUD20DI();
                            
                            pCAUD20DOutputRec = new CAUD20DO();
                            pCAUD20DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                            
                            pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            
                            pCAUD20DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                            pCAUD20DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                            pCAUD20DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnperPeriod);
                            
                            //  Run loop to guarantee all contract
                            // services will be checked.
                            // SIR 15931: szCdCncntyService changed to szCdCnsvcService
                            for (j = 0;j < tmpSvcRowQty1 && pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j].compareTo(NULL_STRING) != 0;j++) {
                                
                                if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j]))) {
                                    pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_CLOSED);
                                    rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    
                                    //  Call CheckStageEventStatus
                                    rc = ARC_UTLCompareDateAndTime((FndInt3date) & pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperStart, 0, (FndInt3date) & dtCurrentDate, 0);
                                    
                                    if (0 == rc) {
                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtAddOneDay);
                                        
                                        //## BEGIN TUX/XML: Declare XML variables
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    }
                                    pCAUD20DInputRec.setDtDtCnperTerm(dtCurrentDate);
                                    pCAUD20DInputRec.setDtDtCnperClosure(dtCurrentDate);
                                }
                                
                                if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j]))) {
                                    pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_SERVICE_HOLD);
                                    pCAUD20DInputRec.setDtDtCnperTerm(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperTerm);
                                    pCAUD20DInputRec.setDtDtCnperClosure(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperClosure);
                                }
                            }
                            pCAUD20DInputRec.setDtDtCnperStart(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnperStart);
                            pCAUD20DInputRec.setCIndCnperRenewal(FND_NO);
                            pCAUD20DInputRec.setCIndCnperSigned(FND_YES);
                            pCAUD20DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate2);
                            rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
                            
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                                    
                                    
                                    
                                    if (false == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                                    }
                                    else {
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        // 
                                        // BEGIN CAUD15D  CONTRACT VERSION AUD
                                        // 
                                        
                                        pCAUD15DInputRec = new CAUD15DI();
                                        
                                        pCAUD15DOutputRec = new CAUD15DO();
                                        pCAUD15DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                        pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        pCAUD15DInputRec.setUlIdCnver(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdCnver);
                                        pCAUD15DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                                        pCAUD15DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                                        pCAUD15DInputRec.setUlNbrCnverPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnperPeriod);
                                        pCAUD15DInputRec.setUlNbrCnverVersion(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCnverVersion);
                                        pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                                        pCAUD15DInputRec.setDtDtCnverCreate(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnverCreate);
                                        pCAUD15DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate3);
                                        pCAUD15DInputRec.setDtDtCnverEffective(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnverEffective);
                                        
                                        //  Run loop four times to guarantee all contract
                                        // services will be checked.
                                        // SIR 15931: szCdCncntyService changed to szCdCnsvcService
                                        for (j = 0;j < tmpSvcRowQty1;j++) {
                                            
                                            if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j]))) {
                                                
                                                
                                                //  Call CCMN05U
                                                rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                pCAUD15DInputRec.setDtDtCnverEnd(dtCurrentDate);
                                            }
                                            
                                            if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j]))) {
                                                pCAUD15DInputRec.setDtDtCnverEnd(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCnverEnd);
                                            }
                                        }
                                        rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                                        
                                        switch (rc) {
                                                
                                                // APT 9/5/2001 SECURITY UPGRADE - commented out the SQL_NOT_FOUND code for the
                                                // case in which no profiles exist for the person being deleted
                                                // this should not cause an error
                                                //            case SQL_NOT_FOUND:
                                                // Set severity to FND_SEVERITY_ERROR
                                                
                                                //            pServiceStatus->severity = FND_SEVERITY_ERROR;
                                                
                                                // Set explan_code to MSG_CMN_TMSTAMP_MISMATCH
                                                
                                                //            pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                                                
                                                // Set explan_data to ERR_SAVE_EMP_SEC_INFO
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                // 
                                                // SIR #21922 - BEGIN CAUD08D CONTRACT COUNTY update.  This
                                                // is added because the contract county end date needs to
                                                // be upated simulatneously with the contract_period and
                                                // contract_county tables.
                                                // 
                                                
                                                pCAUD08DInputRec = new CAUD08DI();
                                                
                                                pCAUD08DOutputRec = new CAUD08DO();
                                                
                                                //  Run loop four times to guarantee all contract
                                                // services will be checked.
                                                // SIR #15931: begin
                                                tempSvcRowQty2 = 5;
                                                if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[0])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[0]))) {
                                                    tempSvcRowQty2 = 2;
                                                }
                                                // SIR #15931: end.also changed the loop counter for
                                                // the following for loop from tempSvcRowQty to
                                                // tempSvcRowQty2 and added another condition
                                                for (j = 0;j < tempSvcRowQty2 && 0 != pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyCounty[0].compareTo(NULL_STRING);j++) {
                                                    pCAUD08DInputRec.setArchInputStruct(cfad36si.getArchInputStruct());
                                                    pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                    pCAUD08DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdContract);
                                                    pCAUD08DInputRec.setUlIdCncnty(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulIdCncnty[j]);
                                                    pCAUD08DInputRec.setUlIdCntrctWkr(cfad36si.getUlIdCntrctWkr());
                                                    
                                                    pCAUD08DInputRec.setUlIdResource(cfad36si.getUlIdResource());
                                                    pCAUD08DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCncntyPeriod[j]);
                                                    pCAUD08DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCncntyVersion[j]);
                                                    pCAUD08DInputRec.setSzCdCncntyCounty(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyCounty[j]);
                                                    pCAUD08DInputRec.setUlNbrCncntyLineItem(pCFAD01DInputRec.ROWCFAD08SIG07[i216].ulNbrCncntyLineItem[j]);
                                                    pCAUD08DInputRec.setDtDtCncntyEffective(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCncntyEffective[j]);
                                                    pCAUD08DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[i216].tsSysTsLastUpdate4[j]);
                                                    //## END TUX/XML: Turn the XML buffer into an input message struct
                                                    
                                                    
                                                    
                                                    if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j]))) 
                                                    {
                                                        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                                        pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                                                        pCAUD08DInputRec.setSzCdCncntyService(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCnsvcService[j]);
                                                    }
                                                    if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j]))) {
                                                        pCAUD08DInputRec.setDtDtCncntyEnd(pCFAD01DInputRec.ROWCFAD08SIG07[i216].dtDtCncntyEnd[j]);
                                                        pCAUD08DInputRec.setSzCdCncntyService(pCFAD01DInputRec.ROWCFAD08SIG07[i216].szCdCncntyService[j]);
                                                    }
                                                    //  IMPACT END
                                                    
                                                    //  Call CCMN01U
                                                    rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                                                    
                                                    switch (rc) {
                                                            // Multiple occurrances of this event are acceptable because the window
                                                            // will create a new event row every time the window is accessed from
                                                            // a Detail Pushbutton on the Task List.
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            break;
                                                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                            
                                                            // 
                                                            // END CMSC18D
                                                            // 
                                                            
                                                            
                                                            break;
                                                            
                                                        default :
                                                            
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                            
                                                            break;
                                                    }
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
                                    break;// break for CLSS67D
                                    
                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                        }
                        i216++;
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
        ARC_PRFServiceStopTime_TUX(cfad36si.getArchInputStruct() , cfad36so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        
        /*
        ** Start Date manipulation
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            
            
            
            //  End date manipulation
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CFAD36S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        /*SIR 22559*/
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CFAD36S\n");
        }
        return cfad36so;
    }

    static int CallCRES04D(CFAD36SI pInputMsg384, String szAdoptiveOrFoster, String szCategoryType, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        String szTempHomeType = new String();
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES04DInputRec = new CRES04DI();
        
        pCRES04DOutputRec = new CRES04DO();
        szTempHomeType = "";
        pCRES04DInputRec.setArchInputStruct(pInputMsg384.getArchInputStruct());
        pCRES04DInputRec.setUlIdResource(pInputMsg384.getUlIdResource());
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        /*
        ** No unit was found that matched the search criteria, so pass
        ** back a code to generate the appropriate error message
        */
        if (rc != 0) {
            
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        szTempHomeType = CStringUtils.setCharAt(szTempHomeType, 0, pCRES04DOutputRec.getCCdRsrcFaHomeType1());
        szTempHomeType = CStringUtils.setCharAt(szTempHomeType, 1, pCRES04DOutputRec.getCCdRsrcFaHomeType2());
        szTempHomeType = CStringUtils.setCharAt(szTempHomeType, 2, pCRES04DOutputRec.getCCdRsrcFaHomeType3());
        szTempHomeType = CStringUtils.setCharAt(szTempHomeType, 3, pCRES04DOutputRec.getCCdRsrcFaHomeType4());
        szTempHomeType = CStringUtils.setCharAt(szTempHomeType, 4, pCRES04DOutputRec.getCCdRsrcFaHomeType5());
        szTempHomeType = CStringUtils.setCharAt(szTempHomeType, 5, pCRES04DOutputRec.getCCdRsrcFaHomeType6());
        szTempHomeType = CStringUtils.setCharAt(szTempHomeType, 6, pCRES04DOutputRec.getCCdRsrcFaHomeType7());
        szAdoptiveOrFoster = szTempHomeType;
        szCategoryType = pCRES04DOutputRec.getSzCdRsrcCategory();
        return rc;
    }

    static int ContractVerSerCnty(CFAD36SI pInputMsg385, int ulIdContract2, int ulNbrCnperPeriod2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int RetVal = 0;/* Return code */
        int i217 = 0;
        int j = 0;
        int ulLocalAdoptOrFoster = 0;
        boolean bDeleteInsertContractCounty = true;
        boolean blFoster = true;
        int ulLocalNumberOfDays = 0;
        String szAdoptiveOrFoster = new String();
        /* SIR 22686 */
        boolean bGroupHome2 = false;
        FndInt3date dtTempDate = null;/* Temporary date used for system date */
        FndInt3date dtCurrentDate = null;/* Temporary date used for system date */
        FndInt3date/* Temporary date subtract 2 day */
        dtTempDate3 = new FndInt3date( - 2, 0, 0);
        FndInt3date/* Temporary date add 1 day */
        dtAddOneDay = new FndInt3date(1, 0, 0);
        
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
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
        ** Call Resource Link in order to determine prime status
        */
        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /*
        ** Call Contract County table to determine if the resource is contracted
        */
        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /*
        ** Call Resource Address table to retrieve addresses if they exist
        */
        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtTempDate3);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /*
        ** Resource Address SIRs, 6/3/96:
        ** For each Id returned from the Resource Address table,
        ** call a DAM to find out whether that address ID is linked
        ** to any contracts (status of contract irrelevant).
        */
        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtAddOneDay);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD15DInputRec = new CAUD15DI();
        
        pCAUD15DOutputRec = new CAUD15DO();
        pCAUD15DInputRec.setArchInputStruct(pInputMsg385.getArchInputStruct());
        
        pCAUD08DInputRec = new CAUD08DI();
        
        pCAUD08DOutputRec = new CAUD08DO();
        pCAUD08DInputRec.setArchInputStruct(pInputMsg385.getArchInputStruct());
        
        pCAUD17DInputRec = new CAUD17DI();
        
        pCAUD17DOutputRec = new CAUD17DO();
        
        pCAUD17DInputRec.setArchInputStruct(pInputMsg385.getArchInputStruct());
        
        pCLSS68DInputRec = new CLSS68DI();
        
        pCLSS68DOutputRec = new CLSS68DO();
        pCLSS68DInputRec.setArchInputStruct(pInputMsg385.getArchInputStruct());
        
        pCLSS13DInputRec = new CLSS13DI();
        
        pCLSS13DOutputRec = new CLSS13DO();
        pCLSS13DInputRec.setArchInputStruct(pInputMsg385.getArchInputStruct());
        
        pCSES01DInputRec = new CSES01DI();
        
        pCSES01DOutputRec = new CSES01DO();
        
        pCRES04DInputRec = new CRES04DI();
        
        pCRES04DOutputRec = new CRES04DO();
        pCSES01DInputRec.setArchInputStruct(pInputMsg385.getArchInputStruct());
        pCSES01DInputRec.setUlIdContract(ulIdContract2);
        pCSES01DInputRec.setUlNbrCnverPeriod(ulNbrCnperPeriod2);
        
        rc = cses01dQUERYdam(sqlca, pCSES01DInputRec, pCSES01DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                RetVal = SUCCESS;
                pCAUD15DInputRec.setUlIdContract(pCSES01DOutputRec.getUlIdContract());
                pCAUD15DInputRec.setUlIdCntrctWkr(pCSES01DOutputRec.getUlIdCntrctWkr());
                pCAUD15DInputRec.setUlNbrCnverPeriod(pCSES01DOutputRec.getUlNbrCnverPeriod());
                pCAUD15DInputRec.setUlNbrCnverVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
                pCAUD15DInputRec.setUlNbrCnverNoShowPct(pCSES01DOutputRec.getUlNbrCnverNoShowPct());
                pCAUD15DInputRec.setCIndCnverVerLock(pCSES01DOutputRec.getCIndCnverVerLock());
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
                for (i217 = 0;i217 < 2 && RetVal == SUCCESS && bDeleteInsertContractCounty;i217++) {
                    pCAUD15DInputRec.setDtDtCnverEnd(dtTempDate);
                    if (i217 == 1) {
                        pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                        pCAUD15DInputRec.setDtDtCnverEnd(pCSES01DOutputRec.getDtDtCnverEnd());
                        pCAUD15DInputRec.setDtDtCnverEffective(dtCurrentDate);
                        pCAUD15DInputRec.setUlNbrCnverVersion(pCSES01DOutputRec.getUlNbrCnverVersion() + 1);
                        pCAUD15DInputRec.setSzTxtCnverComment("");
                        pCAUD15DInputRec.setUlIdCnver(0);
                    }
                    //  This case is returned if a hotline has no address rows
                    
                    rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
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
            pCLSS13DInputRec.setUlIdContract(ulIdContract2);
            pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
            pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
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
            for (i217 = 0;i217 < 5 && RetVal == SUCCESS;i217++) {
                pCAUD17DInputRec.setUlIdContract(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlIdContract());
                pCAUD17DInputRec.setUlIdCntrctWkr(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlIdCntrctWkr());
                pCAUD17DInputRec.setUlNbrCnsvcVersion(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcVersion() + 1);
                pCAUD17DInputRec.setUlNbrCnsvcPeriod(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcPeriod());
                pCAUD17DInputRec.setUlNbrCnsvcLineItem(i217 + 1);
                switch (i217) {
                        // SIR 24002
                    case 0:
                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_FOST_LEV_BASIC);
                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(FOSTER_PAYMENT_LEV_BASIC);
                        break;
                        // END SIR 24002
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
                
                //## BEGIN TUX/XML: Declare XML variables 
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
                pCAUD17DInputRec.setUlAmtCnsvcUnitRateUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcUnitRateUsed());
                pCAUD17DInputRec.setTsLastUpdate(dtCurrentDate);
                rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                
                
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
        }
        if (RetVal == SUCCESS) {
            pCRES04DInputRec.setArchInputStruct(pInputMsg385.getArchInputStruct());
            pCRES04DInputRec.setUlIdResource(pInputMsg385.getUlIdResource());
            
            //  Call DAM
            rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    if (!(FA_CATG_ADOPT.compareTo(pCRES04DOutputRec.getSzCdRsrcCategory()) != 0)) {
                        blFoster = false;
                    }
                    szAdoptiveOrFoster = CStringUtils.setCharAt(szAdoptiveOrFoster, 0, pCRES04DOutputRec.getCCdRsrcFaHomeType1());
                    szAdoptiveOrFoster = CStringUtils.setCharAt(szAdoptiveOrFoster, 1, pCRES04DOutputRec.getCCdRsrcFaHomeType2());
                    szAdoptiveOrFoster = CStringUtils.setCharAt(szAdoptiveOrFoster, 2, pCRES04DOutputRec.getCCdRsrcFaHomeType3());
                    szAdoptiveOrFoster = CStringUtils.setCharAt(szAdoptiveOrFoster, 3, pCRES04DOutputRec.getCCdRsrcFaHomeType4());
                    szAdoptiveOrFoster = CStringUtils.setCharAt(szAdoptiveOrFoster, 4, pCRES04DOutputRec.getCCdRsrcFaHomeType5());
                    szAdoptiveOrFoster = CStringUtils.setCharAt(szAdoptiveOrFoster, 5, pCRES04DOutputRec.getCCdRsrcFaHomeType6());
                    szAdoptiveOrFoster = CStringUtils.setCharAt(szAdoptiveOrFoster, 6, pCRES04DOutputRec.getCCdRsrcFaHomeType7());
                    
                    // 19613 Basic only has 63A now
                    ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_A;
                    if (szAdoptiveOrFoster.charAt(0) == null) {
                        ulLocalAdoptOrFoster = 0;
                    }
                    else {
                        //  SIR 22686 loop through the rows to see if any of them
                        // are group homes, if they are set an indicator
                        for (i217 = 0;i217 < NBR_OF_HOME_TYPE;i217++) {
                            
                            if (szAdoptiveOrFoster.charAt(i217) == FOST_TYPE_GROUP) {
                                bGroupHome2 = true;
                                break;
                            }
                        }
                        
                        for (i217 = 0;i217 < NBR_OF_HOME_TYPE;i217++) {
                            if ((szAdoptiveOrFoster.charAt(i217) == FOST_TYPE_HABIL) || (szAdoptiveOrFoster.charAt(i217) == FOST_TYPE_THER) || (szAdoptiveOrFoster.charAt(i217) == FOST_TYPE_PRIM_MED)) {
                                
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
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        if (RetVal == SUCCESS) {
            pCLSS68DInputRec.setUlIdContract(ulIdContract2);
            pCLSS68DInputRec.setUlNbrCncntyPeriod(ulNbrCnperPeriod2);
            pCLSS68DInputRec.setUlNbrCncntyVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
            pCLSS68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS68DO._CLSS68DO__ROWCLSS68DO_SIZE);
            pCLSS68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            rc = clss68dQUERYdam(sqlca, pCLSS68DInputRec, pCLSS68DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
                    
                    //  Start Performance Timer
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
                for (i217 = 0;i217 < pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty() && RetVal == SUCCESS;i217++) {
                    pCAUD08DInputRec.setUlIdCncnty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlIdCncnty());
                    pCAUD08DInputRec.setTsLastUpdate(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getTsLastUpdate());
                    
                    
                    //  Initialize Service Status Fields
                    
                    
                    //  Perform Main Processing
                    
                    //  Set CARC14SO WCD DtSystemDate to current date
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
                
                for (i217 = 0;i217 < pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty() && RetVal == SUCCESS;i217++) {
                    pCAUD08DInputRec.setUlIdCncnty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlIdCncnty());
                    pCAUD08DInputRec.setSzCdCncntyCounty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getSzCdCncntyCounty());
                    pCAUD08DInputRec.setTsLastUpdate(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getTsLastUpdate());
                    pCAUD08DInputRec.setUlIdContract(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlIdContract());
                    pCAUD08DInputRec.setUlNbrCncntyPeriod(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlNbrCncntyPeriod());
                    pCAUD08DInputRec.setUlIdCntrctWkr(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlIdCntrctWkr());
                    pCAUD08DInputRec.setUlIdResource(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlIdResource());
                    pCAUD08DInputRec.setSzCdCncntyService(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getSzCdCncntyService());
                    pCAUD08DInputRec.setTmScrTmGeneric1(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getTmScrTmGeneric1());
                    pCAUD08DInputRec.setTmScrTmGeneric2(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getTmScrTmGeneric2());
                    pCAUD08DInputRec.setUlNbrCncntyLineItem(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlNbrCncntyLineItem());
                    pCAUD08DInputRec.setUlNbrCncntyVersion(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getUlNbrCncntyVersion());
                    pCAUD08DInputRec.setDtDtCncntyEffective(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i217).getDtDtCncntyEffective());
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
        
        if (RetVal == SUCCESS && blFoster) {
            pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCAUD08DInputRec.setUlIdCncnty(0);
            
            if (!bDeleteInsertContractCounty) {
                pCAUD08DInputRec.setUlNbrCncntyVersion(pCSES01DOutputRec.getUlNbrCnverVersion());
            }
            else {
                pCAUD08DInputRec.setUlNbrCncntyVersion(pCSES01DOutputRec.getUlNbrCnverVersion() + 1);
            }
            pCAUD08DInputRec.setSzCdCncntyCounty(pInputMsg385.getSzCdRsrcCnty());
            pCAUD08DInputRec.setTsLastUpdate(dtCurrentDate);
            pCAUD08DInputRec.setUlIdContract(pCSES01DOutputRec.getUlIdContract());
            pCAUD08DInputRec.setUlNbrCncntyPeriod(pCSES01DOutputRec.getUlNbrCnverPeriod());
            pCAUD08DInputRec.setUlIdCntrctWkr(pCSES01DOutputRec.getUlIdCntrctWkr());
            pCAUD08DInputRec.setUlIdResource(pInputMsg385.getUlIdResource());
            pCAUD08DInputRec.setTmScrTmGeneric1(pCSES01DOutputRec.getTmScrTmGeneric1());
            pCAUD08DInputRec.setTmScrTmGeneric2(pCSES01DOutputRec.getTmScrTmGeneric2());
            
            pCAUD08DInputRec.setDtDtCncntyEffective(dtCurrentDate);
            pCAUD08DInputRec.setDtDtCncntyEnd(pCSES01DOutputRec.getDtDtCnverEnd());
            
            for (i217 = 0;i217 < ulLocalAdoptOrFoster && RetVal == SUCCESS;i217++) {
                pCAUD08DInputRec.setUlNbrCncntyLineItem(i217 + 1);
                
                
                //  Analyze return code
                switch (i217) {
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
                        ;
                        
                    default :
                        break;
                }
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
        return rc;
    }

}
