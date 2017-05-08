package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC89DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC89DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29DO;
/**************************************************************************
**
** Module File:   CINV01S.src
**
** Service Name:  CINV01S - RTRV PRSN LIST
**
** Description:   Retrieves information for the Person List Box from the
**                Person and Stage_Person_Link tables based upon either
**                a particular Stage or a particular Case.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**
**                HP-UX Ansi C Compiler
**
** Date Created:  01/21/95
**
** Programmer:    SPR/WHW
**
** DAMS called:   CINV58D
**                CINV34D
**                CCMN87D
**                CLSC21D
**                CMSC49D
**                CLSC89D
**
** Change History:
**
**  Date     User               SIR  Description
**  -------  ------------------ ---- --------------------------------------
**  08/09/95 DMV                1104 Added if statement around age calc, to
**                                   set age to Null if DOB as blank.
**  09/26/95 KJM                1468 Changed line 1502 to compare null date
**                                   to DeathYear instead of BirthYear
**  11/21/95 OVERENTR           1969 Added a dam to  search for the id_event
**                                   of the documents that were added to the
**                                   window.
**  01/22/95 BRUCKMK    SIR 2546: Added logic to separate the reporter on
**                      both the retrievals from cinv34d and cinv58d. The
**                      Reporter is placed in the reporter array, then
**                      checked for Duplicates, and then populated in the
**                      Output Message as the First Person.
**  02/13/95 DMV                2085 Added a call to Person Merge Retrieval,
**                                   if any data get's returned set the
**                                   Person Merge Flag for that row to TRUE.
**
** 3/14/96 ZIMMERNE  SIR #3885 - Added the Employee Flag Retrieval Dam -
**                   CINV29D.  This will be used to determine when to enable
**                   or disable the Records Check menu item on the window.
**
**  07/16/96 DYARGR  SIR 21816 - Memory not freed in cinv29d common function.
**
**  09/26/96 vanderm SIR 11473 - CCMN87D determins if a Risk Assesment is
**                   COMP or PEND for any people retrieved.  This DAM should
**                   only be called in the context of a search based on the
**                   ID_STAGE and not the ID_CASE.  The call was moved inside
**                   the if statement that is called if an ID_STAGE instead
**                   of calling it in all cases.
**
** 11/21/96 gonzalce SIR 22152 - The primary child is being sorted to the
**                   bottom of the person list in the subcare stage.  This
**                   is because PC was not defined in this service.  I added
**                   a #define for PC and a line of code for PC in the victim
**                   sorting code to fix the problem.
**
** 04/28/98 bradlea  SIR 14137 - The retrieve service will continue to retrieve
**                   all persons from the stage, but it will now compare the
**                   list of all persons retrieved to the list of alleged
**                   perpetrators and will only populate the service output
**                   message with information for all person ids on the alleged
**                   perpetrator list.
**
** 03/09/00 Sharmas  SIR 15387 - Since IRA is not associated with persons the
**                   message for changing the status of the event on addition
**                   of a new person to the case is disabled.
**
** 07/12/02 Blahapp  SIR 13758 - For names that will display in the person list,
**                   users need to see the suffix along with full name to be
**                   able to distinguish between, for example, Joe Smith, JR
**                   and Joe Smith, SR. I added the suffix field to the
**                   two DAMs that are called to populate the output record for
**                   cinv01s and concatenated the two fields in the service.
**
** 04/30/03  Srini	 SIR 17091: Added the error handling to take care of full
**					 table scans for ccmn87dQUERYdam.
**
** 09/27/04 DEJUANR  SIR 23058 - Add New UTC Person roles UC for when overall dispostion
**                   is UTC.  Follows the same logic as MOV.
**
** 09/22/05 douglacs SIR 23550 Add indicator for person characteristics entered to
**                   person list
** 09/22/05 douglacs SIR 23982 Add indicator for person ethnicity entered to
**                   person list
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv01s {
    private final static int UNKNOWN_SIZE = 0;
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String ALLEG_VICTIM = "VC";
    public static final String AV_PERP = "VP";
    public static final String ALLEG_PERP = "AP";
    public static final String NO_ROLE = "NO";
    public static final String PRIMARY_CHILD = "PC";
    public static final String UTD_INVST = "UD";
    public static final String UTD_MOVED = "UM";
    public // SIR 23058
    static final String UTD_UTC = "UC";
    public static final String UNKNOWN = "UK";
    public static final String SUS_PERP = "SP";
    public static final String DESG_VICT_PERP = "DB";
    public static final String DESG_VICT = "DV";
    public static final String DESG_PERP = "DP";
    public static final String PRINCIPAL = "PRN";
    public static final String COLLATERAL = "COL";
    public static final String STAFF_TYPE = "STF";
    public static final int MAX_AGE = 999;
    public static final String ASSESS_EVENT_TYPE = "ASM";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_PROCESS = "PROC";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String RISK_ASSMNT_TASK = "2290";
    public static final String FLR_EVENT_DESC_INIT_TDMHMR = "Initial Generation of TDMHMR Facility Letter to Reporter";
    public static final String FLR_EVENT_DESC_INIT_MHMR = "Initial Generation of MHMR Facility Letter to Reporter";
    public static final String FLR_EVENT_TYPE = "NOT";
    public static final int TDMHMR_BLOB_STRUCT_INDEX = 0;
    public static final int MHMR_BLOB_STRUCT_INDEX = 1;
    public static final int INITIAL_PAGE_NUMBER = 1;
    public static final String EMPLOYEE_CATEGORY = "EMP";
    //SIR 23550 - 1-person characteristics entered
    //2-no characteristics applicable entered
    public static final char PERSON_CHAR_ONE = '1';
    public static final char PERSON_CHAR_TWO = '2';
    /*
    ** MHMR Phase III - Item 5
    */
    public static final char ALLEGED_PERPS_ONLY = 'Z';
    
    /* SIR# 15387 */
    public static final String IRA = "Intranet Risk Assessment";
    //## END TUX/XML: Declare XML variables 
    
    
    //## BEGIN TUX/XML: Turn the XML buffer into an input message struct 
    /* Allocate the Input message that will be used within the service */
    static CINV01SI pInputMsg = null;
    CINV01SO CINV01S(CINV01SI cinv01si) {
        CINV01SO cinv01so = new CINV01SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        
        /*
        ** Call CLSS23D
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv01si.getArchInputStruct());
        
        if (cinv01si.getBSysIndCase() != 0) {
            
            
            //  Set rc to ARC_SUCCESS
            rc = CallCINV58D(cinv01si, cinv01so, pServiceStatus);
            
            if (SUCCESS != rc) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        else {
            rc = Cinv15s.CallCINV34D(cinv01si, cinv01so, pServiceStatus);
            
            if (SUCCESS != rc) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = Ccmn02u.CallCCMN87D(cinv01si, cinv01so, pServiceStatus);
            
            if (SUCCESS != rc) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        /*
        ** Call CCMN44D
        */
        rc = CallCLSC21D(cinv01si, cinv01so, pServiceStatus);
        
        if (SUCCESS != rc) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*Setup For service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv01si.getArchInputStruct() , cinv01so.getArchOutputStruct());
        
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
                
                //  RetVal not sufficient for Impact error handling.
                // Set rc to error code and call PROCESS_TUX_RC_ERROR
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv01so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV01SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    
    static int CallCINV34D(CINV01SI pInputMsg500, CINV01SO pOutputMsg458, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare Local Variables
        */
        int rc = 0;
        int LocalStage = 0;
        char bDup = '\u0000';
        int i280 = 0;
        int j = 0;
        int v = 0;
        int p = 0;
        int c = 0;
        int n = 0;
        int z = 0;
        int k = 0;
        int q = 0;/* SIR 2546 Counter */
        int d = 0;/* SIR 22152 Counter*/
        CINV34DI pCINV34DInputRec = null;
        CINV34DO pCINV34DOutputRec = null;
        CLSC89DI pCLSC89DInputRec = null;/* MHMR Phase III Item 5 */
        CLSC89DO pCLSC89DOutputRec = null;/* MHMR Phase III Item 5 */
        ROWCINV34DO/* Temporary Arrays for collating and sorting */
        [] PrincipalArray = null;
        ROWCINV34DO[] CollateralArray = null;
        ROWCINV34DO[] ConsolidatedArray = null;
        ROWCINV34DO[] TempSwap = null;
        ROWCINV34DO[] BadRoleTypeArray = null;
        ROWCINV34DO[] ReporterArray = null;
        ROWCINV34DO[] PrimaryChildArray = null;
        /*
        ** Loop thru both the MergeTo Person and MergeFrom Person
        ** struct. If same Person is found in both the cases
        ** which has a Person role of Primary Child and belongs
        ** to the same stage Than set the Duplicate flag to TRUE.
        */
        k = 0;
        z = k;
        
        
        /*****************************************************************************  ** The final listing cannot have any duplicates, so the following code makes
        ** sure that every IdPerson is unique in the list.
        *****************************************************************************/
        
        /* Initialize counters */
        n = z;
        c = n;
        p = c;
        v = p;
        
        j = v;
        i280 = j;
        
        /*
        ** Allocate memory for Input Structure.
        */
        pCINV34DInputRec = new CINV34DI();
        
        pCINV34DOutputRec = new CINV34DO();
        
        /*
        ** Allocate memory for sorting Arrays
        */
        
        PrincipalArray = new ROWCINV34DO[UNKNOWN_SIZE];
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            PrincipalArray[tmpi] = new ROWCINV34DO();
        }
        
        if (PrincipalArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
        }
        
        CollateralArray = new ROWCINV34DO[UNKNOWN_SIZE];
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            CollateralArray[tmpi] = new ROWCINV34DO();
        }
        
        if (CollateralArray == null) {
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
        }
        
        ConsolidatedArray = new ROWCINV34DO[UNKNOWN_SIZE];
        
        
        /*********************************************************************
        ** SIR 2546: Loop through Reporter Array first and add Reporters
        ** to Output Message first, so they will appear first in the listbox.
        *********************************************************************/
        
        /* Loop through ReporterArray */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            ConsolidatedArray[tmpi] = new ROWCINV34DO();
        }
        
        if (ConsolidatedArray == null) {
            
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
        }
        
        TempSwap = new ROWCINV34DO[UNKNOWN_SIZE];
        
        /* Read ConsolidatedArray up to current number of rows */
        /* checking for duplicates */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            TempSwap[tmpi] = new ROWCINV34DO();
        }
        
        if (TempSwap == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
        }
        
        BadRoleTypeArray = new ROWCINV34DO[UNKNOWN_SIZE];
        
        /*** END SIR 2546 ****/
        
        /*********************************************************************
        ** SIR 22152: Loop through Primary Child Array to place the primary child
        ** after the reporter in the listbox.
        *********************************************************************/
        
        /* Loop through PrimaryChildArray */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            BadRoleTypeArray[tmpi] = new ROWCINV34DO();
        }
        if (BadRoleTypeArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
        }
        
        /*
        ** SIR 2546:
        ** Allocate memory for sorting Arrays
        */
        ReporterArray = new ROWCINV34DO[UNKNOWN_SIZE];
        
        /* Read ConsolidatedArray up to current number of rows */
        /* checking for duplicates */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            ReporterArray[tmpi] = new ROWCINV34DO();
        }
        if (ReporterArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
            
        }
        
        /*
        ** SIR 22152 - Allocate memory for Primary Child Array
        */
        PrimaryChildArray = new ROWCINV34DO[UNKNOWN_SIZE];
        
        /*end SIR 22152*/
        
        /* Loop through PrincipalArray */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            PrimaryChildArray[tmpi] = new ROWCINV34DO();
        }
        if (PrimaryChildArray == null) {
            
            //  Call DAM
            
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            
            return rc;
        }
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        pCINV34DInputRec.setArchInputStruct(pInputMsg500.getArchInputStruct());
        pCINV34DInputRec.setUlIdStage(pInputMsg500.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(STAFF_TYPE);
        
        rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
        if (0 == rc) {
            
            // Read ConsolidatedArray up to current number of rows
            // checking for duplicates
            for (j = 0;j < (int) pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzNmPersonFull() += " " + pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdPersonSuffix();
                pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).setSzNmPersonFull(trim(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzNmPersonFull()));
            }
        }
        if (0 == rc) {
            
            // Loop through CollateralArray
            for (j = 0;j < (int) pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                if (pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getBIndStagePersReporter() == INDICATOR_YES) {
                    ReporterArray[q] = pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j);
                    q++;
                }
                
                // 
                // SIR 22152: The Primary Child should always appear after the
                // Reporter in the Person List.  Therefore, sort out Primary Child
                // here and place after the reporter.  Added an else if statement
                // to sort out PRIMARY_CHILD.
                // 
                
                else if (0 == PRIMARY_CHILD.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) {
                    PrimaryChildArray[d] = pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j);
                    d++;
                }
                
                // The person is a principal
                
                //  SIR 2546: Made "if" into "else if" 
                
                else if (0 == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersType().compareTo(PRINCIPAL)) {
                    if ((0 == ALLEG_VICTIM.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == AV_PERP.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == ALLEG_PERP.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == NO_ROLE.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == UTD_INVST.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == UTD_MOVED.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == UTD_UTC.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == UNKNOWN.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == SUS_PERP.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == DESG_VICT_PERP.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == DESG_VICT.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) || (0 == DESG_PERP.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole()))) {
                        PrincipalArray[p] = pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j);
                        p++;
                    }
                    else {
                        BadRoleTypeArray[z] = pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j);
                        z++;
                    }
                }
                
                
                // if they have no role, and type is collatoral
                else if ((0 == NO_ROLE.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersRole())) && (0 == COLLATERAL.compareTo(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j).getSzCdStagePersType()))) {
                    CollateralArray[c] = pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j);
                    c++;
                }
                else {
                    BadRoleTypeArray[z] = pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(j);
                    
                    
                    z++;
                }
            }
            i280 = 0;
            while (i280 < CINV34DO._CINV34DO__ROWCINV34DO_SIZE) {
                
                // ... continue adding to pData where pPerp left off.
                j = CINV34DO._CINV34DO__ROWCINV34DO_SIZE - 1;
                
                while (j > i280) {
                    
                    
                    // 
                    // Analyze error code
                    // 
                    if (((ReporterArray[j].getDtDtPersonBirth().year > ReporterArray[j - 1].getDtDtPersonBirth().year) || ((ReporterArray[j].getDtDtPersonBirth().year == ReporterArray[j - 1].getDtDtPersonBirth().year) && (ReporterArray[j].getDtDtPersonBirth().month > ReporterArray[j - 1].getDtDtPersonBirth().month)) || ((ReporterArray[j].getDtDtPersonBirth().year == ReporterArray[j - 1].getDtDtPersonBirth().year) && (ReporterArray[j].getDtDtPersonBirth().month == ReporterArray[j - 1].getDtDtPersonBirth().month) && (ReporterArray[j].getDtDtPersonBirth().day > ReporterArray[j - 1].getDtDtPersonBirth().day))) && (ReporterArray[j].getDtDtPersonBirth().year != 0)) {
                        TempSwap[0] = ReporterArray[j];
                        ReporterArray[j] = ReporterArray[j - 1];
                        ReporterArray[j - 1] = TempSwap[0];
                    }
                    
                    j--;
                }
                i280++;
            }
            i280 = 0;
            while (i280 < CINV34DO._CINV34DO__ROWCINV34DO_SIZE) {
                j = CINV34DO._CINV34DO__ROWCINV34DO_SIZE - 1;
                
                while (j > i280) {
                    //  SIR 647 
                    // Added check for sensative cases, if the indicator is true,
                    // Set the flag to TRUE, do NOT send the row back to the
                    // client.Added a second counter (d) to keep track of the row that 
                    // we are on in the DAM output message.
                    
                    // ERR #1459: The MSG_CMN_SENSITIVE_EVENTS message will only be sent 
                    // back if the case is sensitve AND the users does not have permission
                    // to view sensitive cases.
                    if (((PrincipalArray[j].getDtDtPersonBirth().year > PrincipalArray[j - 1].getDtDtPersonBirth().year) || ((PrincipalArray[j].getDtDtPersonBirth().year == PrincipalArray[j - 1].getDtDtPersonBirth().year) && (PrincipalArray[j].getDtDtPersonBirth().month > PrincipalArray[j - 1].getDtDtPersonBirth().month)) || ((PrincipalArray[j].getDtDtPersonBirth().year == PrincipalArray[j - 1].getDtDtPersonBirth().year) && (PrincipalArray[j].getDtDtPersonBirth().month == PrincipalArray[j - 1].getDtDtPersonBirth().month) && (PrincipalArray[j].getDtDtPersonBirth().day > PrincipalArray[j - 1].getDtDtPersonBirth().day))) && (PrincipalArray[j].getDtDtPersonBirth().year != 0)) {
                        TempSwap[0] = PrincipalArray[j];
                        PrincipalArray[j] = PrincipalArray[j - 1];
                        PrincipalArray[j - 1] = TempSwap[0];
                    }
                    j--;
                }
                i280++;
            }
            i280 = 0;
            while (i280 < CINV34DO._CINV34DO__ROWCINV34DO_SIZE) {
                j = CINV34DO._CINV34DO__ROWCINV34DO_SIZE - 1;
                
                while (j > i280) {
                    if ((0 > CollateralArray[j].getSzNmPersonFull().compareTo(CollateralArray[j - 1].getSzNmPersonFull())) && (0 != CollateralArray[j].getSzNmPersonFull().compareTo(0))) {
                        TempSwap[0] = CollateralArray[j];
                        CollateralArray[j] = CollateralArray[j - 1];
                        CollateralArray[j - 1] = TempSwap[0];
                    }
                    j--;
                }
                i280++;
            }
            n = 0;
            
            // Read ConsolidatedArray up to current number of rows
            // checking for duplicates
            for (q = 0;q < CINV34DO._CINV34DO__ROWCINV34DO_SIZE;q++) {
                LocalStage = ReporterArray[q].getUlIdPerson();
                if (0 == LocalStage) {
                    q = CINV34DO._CINV34DO__ROWCINV34DO_SIZE;
                    break;
                }
                else {
                    bDup = 0;
                    
                    // Loop through BadDataArray
                    for (j = 0;j < n + 1;j++) {
                        //  Populate Output Message
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    if ((!bDup) && (n < CINV34DO._CINV34DO__ROWCINV34DO_SIZE)) {
                        ConsolidatedArray[n] = ReporterArray[q];
                        n++;
                    }
                }
                
            }
            
            // Read ConsolidatedArray up to current number of rows
            // checking for duplicates
            for (d = 0;d < CINV34DO._CINV34DO__ROWCINV34DO_SIZE;d++) {
                // Initialize local variable and then assigned the
                // Array variable
                LocalStage = PrimaryChildArray[d].getUlIdPerson();
                if (0 == LocalStage) {
                    d = CINV34DO._CINV34DO__ROWCINV34DO_SIZE;
                    break;
                }
                else {
                    bDup = 0;
                    for (j = 0;j < n + 1;j++) {
                        // SIR# 15387
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    
                    if ((!bDup) && (n < CINV34DO._CINV34DO__ROWCINV34DO_SIZE)) {
                        ConsolidatedArray[n] = PrimaryChildArray[d];
                        
                        n++;
                    }
                }
            }
            for (p = 0;p < CINV34DO._CINV34DO__ROWCINV34DO_SIZE;p++) {
                LocalStage = PrincipalArray[p].getUlIdPerson();
                if (0 == LocalStage) {
                    p = CINV34DO._CINV34DO__ROWCINV34DO_SIZE;
                    break;
                }
                else {
                    bDup = 0;
                    //  Populate Output Message
                    for (j = 0;j < n + 1;j++) {
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    
                    //  Analyze error code
                    if ((!bDup) && (n < CINV34DO._CINV34DO__ROWCINV34DO_SIZE)) {
                        ConsolidatedArray[n] = PrincipalArray[p];
                        n++;
                    }
                }
            }
            //  Loop through DAM output, running validation processes
            for (c = 0;c < CINV34DO._CINV34DO__ROWCINV34DO_SIZE;c++) {
                // Initialize local variable and then assigned the
                // Array variable
                LocalStage = CollateralArray[c].getUlIdPerson();
                
                //  Populate Output Message
                
                if (0 == LocalStage) {
                    c = CINV34DO._CINV34DO__ROWCINV34DO_SIZE;
                    break;
                }
                else {
                    bDup = 0;
                    //  Loop through DAM output, running validation processes
                    for (j = 0;j < n + 1;j++) {
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    if ((!bDup) && (n < CINV34DO._CINV34DO__ROWCINV34DO_SIZE)) {
                        ConsolidatedArray[n] = CollateralArray[c];
                        n++;
                    }
                }
            }
            //  Loop through DAM output, running validation processes
            for (z = 0;z < CINV34DO._CINV34DO__ROWCINV34DO_SIZE;z++) {
                LocalStage = BadRoleTypeArray[z].getUlIdPerson();
                if (0 == LocalStage) {
                    z = CINV34DO._CINV34DO__ROWCINV34DO_SIZE;
                    break;
                }
                else {
                    bDup = 0;
                    //  Loop through DAM output, running validation processes
                    for (j = 0;j < n + 1;j++) {
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    
                    //  Analyze error code
                    if ((!bDup) && (n < CINV34DO._CINV34DO__ROWCINV34DO_SIZE)) {
                        ConsolidatedArray[n] = BadRoleTypeArray[z];
                        n++;
                    }
                }
            }
            
            ARC_UTLGetDateAndTime(pOutputMsg458.getDtWCDDtSystemDate() , 0);
            pOutputMsg458.getArchOutputStruct().setUlRowQty(0);
            pOutputMsg458.getArchOutputStruct().setBMoreDataInd(pCINV34DOutputRec.getArchOutputStruct().getBMoreDataInd());
            
            //  Populate Output Message
            
            if (!(pInputMsg500.getSzCdStageProgram().compareTo(CAPS_PROG_AFC) != 0) && ALLEGED_PERPS_ONLY == pInputMsg500.getSzSysCdWinMode()) {
                
                //  Allocate memory for Input and Output Structures
                pCLSC89DInputRec = new CLSC89DI();
                pCLSC89DOutputRec = new CLSC89DO();
                rc = CallCLSC89D(pInputMsg500, pOutputMsg458, pCLSC89DInputRec, pCLSC89DOutputRec, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        for (k = 0;k < pCLSC89DOutputRec.getArchOutputStruct().getUlRowQty();k++) {
                            
                            for (i280 = 0;i280 < CINV01SO._CINV01SO__ROWCINV01SOG00_SIZE;i280++) {
                                if (0 != ConsolidatedArray[i280].getUlIdPerson()) {
                                    if (ConsolidatedArray[i280].getUlIdPerson() == pCLSC89DOutputRec.getROWCLSC89DO_ARRAY().getROWCLSC89DO(k).getUlIdPerson()) {
                                        rc = CallCMSC49D(pInputMsg500, pOutputMsg458, ConsolidatedArray[i280].getUlIdPerson() , i280, pServiceStatus);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                rc = CallCINV29D(pInputMsg500, pOutputMsg458, ConsolidatedArray[i280].getUlIdPerson() , i280, pServiceStatus);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        }
                                        
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setSzNmPersonFull(ConsolidatedArray[i280].getSzNmPersonFull());
                                        
                                        // 
                                        // Service Macro Definitions
                                        // 
                                        
                                        // 
                                        // Function Prototypes
                                        // 
                                        // 
                                        // Create a function for each DAM that will be called and repeat the
                                        // following function prototype for each function.
                                        // EXAMPLE:  Service calls DAM named ZPIL01D,
                                        // the function that calls the DAM is CallZPIL01D,
                                        // and the function prototype is as follows.
                                        // static long CallZPIL01D(_CRES06SI *, 
                                        // _CRES06SO *, 
                                        // TUX_DECL_STATUSPARMS);
                                        // 
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setSzCdStagePersRelInt(ConsolidatedArray[i280].getSzCdStagePersRelInt());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setDtDtPersonBirth(ConsolidatedArray[i280].getDtDtPersonBirth());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setBIndPersonDobApprox(ConsolidatedArray[i280].getBIndPersonDobApprox());
                                        
                                        if (DateHelper.NULL_DATE != ConsolidatedArray[i280].getDtDtPersonBirth().year) {
                                            //  Populate Output Message if event list requested
                                            if (DateHelper.NULL_DATE == ConsolidatedArray[i280].getDtDtPersonDeath().year) {
                                                
                                                pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setLNbrPersonAge(Cint08s.CalcAge(ConsolidatedArray[i280].getDtDtPersonBirth() , pOutputMsg458.getDtWCDDtSystemDate()));
                                            }
                                            else {
                                                pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setLNbrPersonAge(Cint08s.CalcAge(ConsolidatedArray[i280].getDtDtPersonBirth() , ConsolidatedArray[i280].getDtDtPersonDeath()));
                                            }
                                        }
                                        else {
                                            pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setLNbrPersonAge(0);
                                        }
                                        
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setBIndStagePersReporter(ConsolidatedArray[i280].getBIndStagePersReporter());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setSzCdStagePersRole(ConsolidatedArray[i280].getSzCdStagePersRole());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setSzCdStagePersRelInt(ConsolidatedArray[i280].getSzCdStagePersRelInt());
                                        
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setCCdPersonSex(ConsolidatedArray[i280].getCCdPersonSex());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setSzCdStagePersType(ConsolidatedArray[i280].getSzCdStagePersType());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setSzCdStagePersSearchInd(ConsolidatedArray[i280].getSzCdStagePersSearchInd());
                                        
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setUlIdPerson(ConsolidatedArray[i280].getUlIdPerson());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setUlIdStagePerson(ConsolidatedArray[i280].getUlIdStagePerson());
                                        //  SIR 3048 - Service Authorization events should not
                                        // be returned to the client
                                        
                                        // 
                                        // SIR 20257: Added Events with Event Status of NEW to
                                        // the "if" statement which adds rows to the structure
                                        // for events that need to be submitted for approval.
                                        // If the Event has a status of NEW, it will not be
                                        // included in the structure and will thus not be updated
                                        // to a status of PENDing.
                                        // SIR 13057, 02/07/97 - If the event is an approval
                                        // event, do not change the event status to PENDing.
                                        // 
                                        if ((PERSON_CHAR_ONE == ConsolidatedArray[i280].getBCdPersonChar()) || (PERSON_CHAR_TWO == ConsolidatedArray[i280].getBCdPersonChar())) {
                                            pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setBCdPersonChar(INDICATOR_YES);
                                        }
                                        else {
                                            
                                            pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setBCdPersonChar(Cint14s.INDICATOR_NO);
                                        }
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setSzCdPersonEthnicGroup(ConsolidatedArray[i280].getSzCdPersonEthnicGroup());
                                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(k).setTsLastUpdate(ConsolidatedArray[i280].getTsLastUpdate());
                                        i280 = CINV01SO._CINV01SO__ROWCINV01SOG00_SIZE;
                                        pOutputMsg458.getArchOutputStruct().getUlRowQty()++;
                                    }
                                }
                            }
                        }
                }
            }
            else // not AFC and ALLEGED_PERPS_ONLY, NEW CODE
            {
                for (i280 = 0;i280 < CINV01SO._CINV01SO__ROWCINV01SOG00_SIZE;i280++) {
                    
                    if (0 != ConsolidatedArray[i280].getUlIdPerson()) {
                        
                        //  Call DAM
                        rc = CallCMSC49D(pInputMsg500, pOutputMsg458, ConsolidatedArray[i280].getUlIdPerson() , i280, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                rc = CallCINV29D(pInputMsg500, pOutputMsg458, ConsolidatedArray[i280].getUlIdPerson() , i280, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setSzNmPersonFull(ConsolidatedArray[i280].getSzNmPersonFull());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setSzCdStagePersRelInt(ConsolidatedArray[i280].getSzCdStagePersRelInt());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setDtDtPersonBirth(ConsolidatedArray[i280].getDtDtPersonBirth());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setBIndPersonDobApprox(ConsolidatedArray[i280].getBIndPersonDobApprox());
                        if (DateHelper.NULL_DATE != ConsolidatedArray[i280].getDtDtPersonBirth().year) {
                            if (DateHelper.NULL_DATE == ConsolidatedArray[i280].getDtDtPersonDeath().year) {
                                pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setLNbrPersonAge(Cint08s.CalcAge(ConsolidatedArray[i280].getDtDtPersonBirth() , pOutputMsg458.getDtWCDDtSystemDate()));
                            }
                            else {
                                pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setLNbrPersonAge(Cint08s.CalcAge(ConsolidatedArray[i280].getDtDtPersonBirth() , ConsolidatedArray[i280].getDtDtPersonDeath()));
                            }
                        }
                        else {
                            pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setLNbrPersonAge(0);
                        }
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setBIndStagePersReporter(ConsolidatedArray[i280].getBIndStagePersReporter());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setSzCdStagePersRole(ConsolidatedArray[i280].getSzCdStagePersRole());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setSzCdStagePersRelInt(ConsolidatedArray[i280].getSzCdStagePersRelInt());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setCCdPersonSex(ConsolidatedArray[i280].getCCdPersonSex());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setSzCdStagePersType(ConsolidatedArray[i280].getSzCdStagePersType());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setSzCdStagePersSearchInd(ConsolidatedArray[i280].getSzCdStagePersSearchInd());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setUlIdPerson(ConsolidatedArray[i280].getUlIdPerson());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setUlIdStagePerson(ConsolidatedArray[i280].getUlIdStagePerson());
                        if ((PERSON_CHAR_ONE == ConsolidatedArray[i280].getBCdPersonChar()) || (PERSON_CHAR_TWO == ConsolidatedArray[i280].getBCdPersonChar())) {
                            pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setBCdPersonChar(INDICATOR_YES);
                        }
                        else {
                            pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setBCdPersonChar(Cint14s.INDICATOR_NO);
                        }
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setSzCdPersonEthnicGroup(ConsolidatedArray[i280].getSzCdPersonEthnicGroup());
                        pOutputMsg458.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i280).setTsLastUpdate(ConsolidatedArray[i280].getTsLastUpdate());
                        pOutputMsg458.getArchOutputStruct().getUlRowQty()++;
                    }
                    else {
                        i280 = CINV01SO._CINV01SO__ROWCINV01SOG00_SIZE;
                    }
                }
            }
        }
        
        else {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCINV58D(CINV01SI pInputMsg501, CINV01SO pOutputMsg459, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code   */
        int LocalStage = 0;
        char bDup = '\u0000';
        int i281 = 0;
        int j = 0;
        int v = 0;
        int p = 0;
        int c = 0;
        int n = 0;
        int z = 0;
        int k = 0;/* Interger used for a looping logic
        SIR #20324 */
        int q = 0;/* SIR 2546 Counter */
        int d = 0;/* SIR 22152 Counter */
        CINV58DI pCINV58DInputRec = null;
        CINV58DO pCINV58DOutputRec = null;
        ROWCINV58DO/***Added for SIR 2546****/
        [] ReporterArray = null;
        ROWCINV58DO[] PrimaryChildArray = null;
        ROWCINV58DO[] PrincipalArray = null;
        ROWCINV58DO[] CollateralArray = null;
        ROWCINV58DO[] ConsolidatedArray = null;
        ROWCINV58DO[] TempSwap = null;
        ROWCINV58DO[] BadRoleTypeArray = null;
        /*
        ** The counter "k" will serve as an array index for the
        ** output array that will be passed back to the window.
        ** It will start with the first available array member.
        */
        k = 0;
        z = k;
        
        
        /*****************************************************************************  ** The final listing cannot have any duplicates, so the following code makes
        ** sure that every IdPerson is unique in the list.
        *****************************************************************************/
        
        /* Initialize counters */
        n = z;
        c = n;
        p = c;
        v/* MergeFrom Stage Local Struct loop counter */
         = p;
        j = v;
        i281 = j;
        
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV58DInputRec = new CINV58DI();
        
        pCINV58DOutputRec = new CINV58DO();
        
        /*
        ** Allocate memory for sorting Arrays
        */
        
        PrincipalArray = new ROWCINV58DO[UNKNOWN_SIZE];
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            PrincipalArray[tmpi] = new ROWCINV58DO();
        }
        
        if (PrincipalArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        
        CollateralArray = new ROWCINV58DO[UNKNOWN_SIZE];
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            CollateralArray[tmpi] = new ROWCINV58DO();
        }
        if (CollateralArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        
        ConsolidatedArray = new ROWCINV58DO[UNKNOWN_SIZE];
        
        /*********************************************************************
        ** SIR 2546: Loop through Reporter Array first and add Reporters
        ** to Output Message first, so they will appear first in the listbox.
        *********************************************************************/
        
        /* Loop through ReporterArray */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            ConsolidatedArray[tmpi] = new ROWCINV58DO();
        }
        
        if (ConsolidatedArray == null) {
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
        }
        
        TempSwap = new ROWCINV58DO[UNKNOWN_SIZE];
        
        /* Read ConsolidatedArray up to current number of rows */
        /* checking for duplicates */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            TempSwap[tmpi] = new ROWCINV58DO();
        }
        
        if (TempSwap == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        
        BadRoleTypeArray = new ROWCINV58DO[UNKNOWN_SIZE];
        
        /*** END SIR 2546 ****/
        
        /*********************************************************************
        ** SIR 22152: Loop through PrimaryChildArray after Reporter array to
        ** place the PRIMARY_CHILD after the reporter in the listbox.
        *********************************************************************/
        
        /* Loop through PrimaryChildArray */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            BadRoleTypeArray[tmpi] = new ROWCINV58DO();
        }
        
        if (BadRoleTypeArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        
        /*
        ** SIR 2546:
        ** Allocate memory for sorting Arrays
        */
        ReporterArray = new ROWCINV58DO[UNKNOWN_SIZE];
        
        /* Read ConsolidatedArray up to current number of rows */
        /* checking for duplicates */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            ReporterArray[tmpi] = new ROWCINV58DO();
        }
        if (ReporterArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            return rc;
        }
        
        /*
        ** SIR 22152 - Allocate memory for PrimaryChildArray
        */
        
        PrimaryChildArray = new ROWCINV58DO[UNKNOWN_SIZE];
        
        /*end SIR 22152*/
        
        /* Loop through PrincipalArray */
        for (int tmpi = 0;tmpi < UNKNOWN_SIZE;tmpi++) {
            PrimaryChildArray[tmpi] = new ROWCINV58DO();
        }
        if (PrimaryChildArray == null) {
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            return rc;
        }
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        Arrays.fill(0, 0, 0, 0);
        pCINV58DInputRec.setArchInputStruct(pInputMsg501.getArchInputStruct());
        pCINV58DInputRec.setUlIdCase(pInputMsg501.getUlIdCase());
        pCINV58DInputRec.setSzCdStagePersType(STAFF_TYPE);
        
        
        /* Call DAM */
        rc = cinv58dQUERYdam(sqlca, pCINV58DInputRec, pCINV58DOutputRec);
        if (0 == rc) {
            
            // Read ConsolidatedArray up to current number of rows
            // checking for duplicates
            for (j = 0;j < (int) pCINV58DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzNmPersonFull() += " " + pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdPersonSuffix();
            }
        }
        
        if (0 == rc) {
            
            // Loop through CollateralArray
            for (j = 0;j < (int) pCINV58DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                
                if (pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getBIndStagePersReporter() == INDICATOR_YES) {
                    ReporterArray[q] = pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j);
                    q++;
                }
                
                // 
                // SIR 22152: The Primary Child should always appear after the
                // Reporter in the Person List.  Therefore, sort out Primary Child
                // here and place after the reporter.  Added an else if statement
                // to sort out PRIMARY_CHILD.
                // 
                
                else if (0 == PRIMARY_CHILD.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) {
                    PrimaryChildArray[d] = pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j);
                    d++;
                }
                
                // The person is a principal
                
                //  SIR 2546: Made "if" into "else if" 
                
                // The person is a principal
                else if (0 == pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersType().compareTo(PRINCIPAL)) {
                    
                    if ((0 == ALLEG_VICTIM.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == AV_PERP.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == ALLEG_PERP.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == NO_ROLE.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == UTD_INVST.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == UTD_MOVED.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == UTD_UTC.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == UNKNOWN.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == SUS_PERP.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == DESG_VICT_PERP.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == DESG_VICT.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) || (0 == DESG_PERP.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole()))) {
                        PrincipalArray[p] = pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j);
                        p++;
                    }
                    else {
                        BadRoleTypeArray[z] = pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j);
                        z++;
                    }
                }
                
                
                // if they have no role, and type is collatoral
                else if ((0 == NO_ROLE.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersRole())) && (0 == COLLATERAL.compareTo(pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j).getSzCdStagePersType()))) {
                    CollateralArray[c] = pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j);
                    c++;
                }
                else {
                    BadRoleTypeArray[z] = pCINV58DOutputRec.getROWCINV58DO_ARRAY().getROWCINV58DO(j);
                    
                    //  <bang!>
                    z++;
                }
            }
            i281 = 0;
            while (i281 < CINV58DO._CINV58DO__ROWCINV58DO_SIZE) {
                j = CINV58DO._CINV58DO__ROWCINV58DO_SIZE - 1;
                
                while (j > i281) {
                    
                    if (((ReporterArray[j].getDtDtPersonBirth().year > ReporterArray[j - 1].getDtDtPersonBirth().year) || ((ReporterArray[j].getDtDtPersonBirth().year == ReporterArray[j - 1].getDtDtPersonBirth().year) && (ReporterArray[j].getDtDtPersonBirth().month > ReporterArray[j - 1].getDtDtPersonBirth().month)) || ((ReporterArray[j].getDtDtPersonBirth().year == ReporterArray[j - 1].getDtDtPersonBirth().year) && (ReporterArray[j].getDtDtPersonBirth().month == ReporterArray[j - 1].getDtDtPersonBirth().month) && (ReporterArray[j].getDtDtPersonBirth().day > ReporterArray[j - 1].getDtDtPersonBirth().day))) && (ReporterArray[j].getDtDtPersonBirth().year != 0)) {
                        TempSwap[0] = ReporterArray[j];
                        ReporterArray[j] = ReporterArray[j - 1];
                        ReporterArray[j - 1] = TempSwap[0];
                    }
                    j--;
                }
                i281++;
            }
            i281 = 0;
            while (i281 < CINV58DO._CINV58DO__ROWCINV58DO_SIZE) {
                j = CINV58DO._CINV58DO__ROWCINV58DO_SIZE - 1;
                
                while (j > i281) {
                    
                    if (((PrincipalArray[j].getDtDtPersonBirth().year > PrincipalArray[j - 1].getDtDtPersonBirth().year) || ((PrincipalArray[j].getDtDtPersonBirth().year == PrincipalArray[j - 1].getDtDtPersonBirth().year) && (PrincipalArray[j].getDtDtPersonBirth().month > PrincipalArray[j - 1].getDtDtPersonBirth().month)) || ((PrincipalArray[j].getDtDtPersonBirth().year == PrincipalArray[j - 1].getDtDtPersonBirth().year) && (PrincipalArray[j].getDtDtPersonBirth().month == PrincipalArray[j - 1].getDtDtPersonBirth().month) && (PrincipalArray[j].getDtDtPersonBirth().day > PrincipalArray[j - 1].getDtDtPersonBirth().day))) && (PrincipalArray[j].getDtDtPersonBirth().year != 0)) {
                        TempSwap[0] = PrincipalArray[j];
                        PrincipalArray[j] = PrincipalArray[j - 1];
                        PrincipalArray[j - 1] = TempSwap[0];
                    }
                    j--;
                }
                i281++;
            }
            i281 = 0;
            while (i281 < CINV58DO._CINV58DO__ROWCINV58DO_SIZE) {
                j = CINV58DO._CINV58DO__ROWCINV58DO_SIZE - 1;
                
                while (j > i281) {
                    
                    if ((0 > CollateralArray[j].getSzNmPersonFull().compareTo(CollateralArray[j - 1].getSzNmPersonFull())) && (0 != CollateralArray[j].getSzNmPersonFull().compareTo(0))) {
                        TempSwap[0] = CollateralArray[j];
                        CollateralArray[j] = CollateralArray[j - 1];
                        CollateralArray[j - 1] = TempSwap[0];
                    }
                    j--;
                }
                i281++;
            }
            //  Loop thru both the MergeTo Person and MergeFrom Person
            // struct. If same Person is found in both the cases
            // which has a Person role of Primary Child and belongs
            // to the same stage Than set the Duplicate flag to TRUE.
            n = 0;
            
            // Read ConsolidatedArray up to current number of rows
            // checking for duplicates
            for (q = 0;q < CINV58DO._CINV58DO__ROWCINV58DO_SIZE;q++) {
                // Initialize local variable and then assigned the
                // Array variable
                LocalStage = ReporterArray[q].getUlIdPerson();
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (0 == LocalStage) {
                    q = CINV58DO._CINV58DO__ROWCINV58DO_SIZE;
                    break;
                }
                else {
                    bDup = 0;
                    
                    // Loop through BadDataArray
                    for (j = 0;j < n + 1;j++) {
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    if ((!bDup) && (n < CINV58DO._CINV58DO__ROWCINV58DO_SIZE)) {
                        ConsolidatedArray[n] = ReporterArray[q];
                        n++;
                    }
                }
            }
            
            // Read ConsolidatedArray up to current number of rows
            // checking for duplicates
            for (d = 0;d < CINV58DO._CINV58DO__ROWCINV58DO_SIZE;d++) {
                LocalStage = PrimaryChildArray[d].getUlIdPerson();
                
                
                // 
                // NESTED DAM RETREIVAL FOR CCMN45D.  ALL FOR CASE SUCCESS IN CINT21D
                // 
                if (0 == LocalStage) {
                    d = CINV58DO._CINV58DO__ROWCINV58DO_SIZE;
                    break;
                }
                else {
                    bDup = 0;
                    
                    //  Populate Output Message
                    for (j = 0;j < n + 1;j++) {
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    if ((!bDup) && (n < CINV58DO._CINV58DO__ROWCINV58DO_SIZE)) {
                        ConsolidatedArray[n] = PrimaryChildArray[d];
                        n++;
                    }
                }
            }
            for (p = 0;p < CINV58DO._CINV58DO__ROWCINV58DO_SIZE;p++) {
                // Initialize local variable and then assigned the
                // Array variable
                LocalStage = PrincipalArray[p].getUlIdPerson();
                
                
                // 
                // Nested Dam call for CLSS44D all for case success in 
                // the CCMN45D Call
                // 
                
                if (0 == LocalStage) {
                    // loop thru MergeFromStageInfo
                    p = CINV58DO._CINV58DO__ROWCINV58DO_SIZE;
                    
                    break;
                }
                else {
                    bDup = 0;
                    for (j = 0;j < n + 1;j++) {
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    if ((!bDup) && (n < CINV58DO._CINV58DO__ROWCINV58DO_SIZE)) {
                        ConsolidatedArray[n] = PrincipalArray[p];
                        n++;
                    }
                }
            }
            for (c = 0;c < CINV58DO._CINV58DO__ROWCINV58DO_SIZE;c++) {
                LocalStage = CollateralArray[c].getUlIdPerson();
                if (0 == LocalStage) {
                    c = CINV58DO._CINV58DO__ROWCINV58DO_SIZE;
                    
                    break;
                }
                else {
                    bDup = 0;
                    for (j = 0;j < n + 1;j++) {
                        
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                    
                    
                    
                    if ((!bDup) && (n < CINV58DO._CINV58DO__ROWCINV58DO_SIZE)) {
                        ConsolidatedArray[n] = CollateralArray[c];
                        n++;
                    }
                }
            }
            for (z = 0;z < CINV58DO._CINV58DO__ROWCINV58DO_SIZE;z++) 
            
            
            {
                // Initialize local variable and then assigned the
                // Array variable
                LocalStage = BadRoleTypeArray[z].getUlIdPerson();
                if (0 == LocalStage) 
                {
                    z = CINV58DO._CINV58DO__ROWCINV58DO_SIZE;
                    
                    break;
                }
                else {
                    bDup = 0;
                    for (j = 0;j < n + 1;j++) {
                        if (ConsolidatedArray[j].getUlIdPerson() == LocalStage) {
                            bDup = 1;
                        }
                    }
                    
                    //  Set fields in CFIN02SO to fields in CSEC06DO
                    
                    //  If the Contract Id was passed as the search parameter,
                    // only populate the fields that relate to the 
                    // resource.  In addition, return the contract Id that was
                    // passed.  In this case, the Vendor ID
                    // (VID) is retrieved from the Resource_Address table.
                    if ((!bDup) && (n < CINV58DO._CINV58DO__ROWCINV58DO_SIZE)) {
                        ConsolidatedArray[n] = BadRoleTypeArray[z];
                        n++;
                    }
                }
            }
            
            // Get system date and copy into output message
            ARC_UTLGetDateAndTime(pOutputMsg459.getDtWCDDtSystemDate() , 0);
            pOutputMsg459.getArchOutputStruct().setUlRowQty(0);
            pOutputMsg459.getArchOutputStruct().setBMoreDataInd(pCINV58DOutputRec.getArchOutputStruct().getBMoreDataInd());
            for (i281 = 0;i281 < CINV01SO._CINV01SO__ROWCINV01SOG00_SIZE;i281++) {
                
                //  If the Contract Id is passed, return
                // MSG_CODE_NOT_FOUND with a severity of FND_SEVERITY_OK
                // since this means that the Id contract passed
                // does not exist on the CONTRACT table
                if (0 != ConsolidatedArray[i281].getUlIdPerson()) {
                    rc = CallCMSC49D(pInputMsg501, pOutputMsg459, ConsolidatedArray[i281].getUlIdPerson() , i281, pServiceStatus);
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            
                            //  Call DAM
                            rc = CallCINV29D(pInputMsg501, pOutputMsg459, ConsolidatedArray[i281].getUlIdPerson() , i281, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setSzNmPersonFull(ConsolidatedArray[i281].getSzNmPersonFull());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setSzCdStagePersRelInt(ConsolidatedArray[i281].getSzCdStagePersRelInt());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setDtDtPersonBirth(ConsolidatedArray[i281].getDtDtPersonBirth());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setBIndPersonDobApprox(ConsolidatedArray[i281].getBIndPersonDobApprox());
                    if (DateHelper.NULL_DATE != ConsolidatedArray[i281].getDtDtPersonBirth().year) {
                        if (DateHelper.NULL_DATE == ConsolidatedArray[i281].getDtDtPersonDeath().year) {
                            pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setLNbrPersonAge(Cint08s.CalcAge(ConsolidatedArray[i281].getDtDtPersonBirth() , pOutputMsg459.getDtWCDDtSystemDate()));
                        }
                        else {
                            pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setLNbrPersonAge(Cint08s.CalcAge(ConsolidatedArray[i281].getDtDtPersonBirth() , ConsolidatedArray[i281].getDtDtPersonDeath()));
                        }
                    }
                    else {
                        pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setLNbrPersonAge(0);
                    }
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setBIndStagePersReporter(ConsolidatedArray[i281].getBIndStagePersReporter());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setSzCdStagePersRole(ConsolidatedArray[i281].getSzCdStagePersRole());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setSzCdStagePersRelInt(ConsolidatedArray[i281].getSzCdStagePersRelInt());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setCCdPersonSex(ConsolidatedArray[i281].getCCdPersonSex());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setSzCdStagePersType(ConsolidatedArray[i281].getSzCdStagePersType());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setSzCdStagePersSearchInd(ConsolidatedArray[i281].getSzCdStagePersSearchInd());
                    pOutputMsg459.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i281).setUlIdPerson(ConsolidatedArray[i281].getUlIdPerson());
                    pOutputMsg459.getArchOutputStruct().getUlRowQty()++;
                }
                else {
                    i281 = CINV01SO._CINV01SO__ROWCINV01SOG00_SIZE;
                }
            }
        }
        else {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = 0;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCCMN87D(CINV01SI pInputMsg502, CINV01SO pOutputMsg460, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int counter = 0;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setUlIdStage(pInputMsg502.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(ASSESS_EVENT_TYPE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE_NUMBER);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(50);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        pOutputMsg460.setUlIdEvent(0);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                
                for (counter = 0;counter < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();counter++) {
                    if (0 != pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzTxtEventDescr().compareTo(IRA)) {
                        if (!(RISK_ASSMNT_TASK.compareTo(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdTask()) != 0) && (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0) ||!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdEventStatus() , EVENT_STATUS_COMPLETE, EVENT_STATUS_COMPLETE.length()) != 0))) {
                            pOutputMsg460.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getUlIdEvent());
                            pOutputMsg460.setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(counter).getSzCdEventStatus());
                            
                            break;
                        }
                    }
                }
                
                
                break;
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.SQL_SUCCESS;
                
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSC21D(CINV01SI pInputMsg503, CINV01SO pOutputMsg461, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int counter = 0;
        CLSC21DI pCLSC21DInputRec = null;
        CLSC21DO pCLSC21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC21DInputRec = new CLSC21DI();
        pCLSC21DOutputRec = new CLSC21DO();
        pCLSC21DInputRec.setUlIdEventStage(pInputMsg503.getUlIdStage());
        pCLSC21DInputRec.setSzCdEventType(FLR_EVENT_TYPE);
        pCLSC21DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE_NUMBER);
        pCLSC21DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC21DO._CLSC21DO__ROWCLSC21DO_SIZE);
        pOutputMsg461.getBIndBLOBExistsInDatabase()[TDMHMR_BLOB_STRUCT_INDEX] = false;
        pOutputMsg461.getBIndBLOBExistsInDatabase()[MHMR_BLOB_STRUCT_INDEX] = false;
        
        
        /*
        ** Call CSYS08D
        */
        rc = clsc21dQUERYdam(sqlca, pCLSC21DInputRec, pCLSC21DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (counter = 0;counter < pCLSC21DOutputRec.getArchOutputStruct().getUlRowQty();counter++) {
                    
                    //  Analyze error code
                    if (pCLSC21DOutputRec.getROWCLSC21DO_ARRAY().getROWCLSC21DO(counter).getSzTxtEventDescr().equals(FLR_EVENT_DESC_INIT_TDMHMR) &&!(pOutputMsg461.getBIndBLOBExistsInDatabase()[TDMHMR_BLOB_STRUCT_INDEX] != null)) {
                        pOutputMsg461.getUlIdEventBLOB_ARRAY().setUlIdEventBLOB(TDMHMR_BLOB_STRUCT_INDEX, pCLSC21DOutputRec.getROWCLSC21DO_ARRAY().getROWCLSC21DO(counter).getUlIdEvent());
                        pOutputMsg461.getBIndBLOBExistsInDatabase()[TDMHMR_BLOB_STRUCT_INDEX] = true;
                    }
                    else if (pCLSC21DOutputRec.getROWCLSC21DO_ARRAY().getROWCLSC21DO(counter).getSzTxtEventDescr().equals(FLR_EVENT_DESC_INIT_MHMR) &&!(pOutputMsg461.getBIndBLOBExistsInDatabase()[MHMR_BLOB_STRUCT_INDEX] != null)) {
                        pOutputMsg461.getUlIdEventBLOB_ARRAY().setUlIdEventBLOB(MHMR_BLOB_STRUCT_INDEX, pCLSC21DOutputRec.getROWCLSC21DO_ARRAY().getROWCLSC21DO(counter).getUlIdEvent());
                        pOutputMsg461.getBIndBLOBExistsInDatabase()[MHMR_BLOB_STRUCT_INDEX] = true;
                    }
                }
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.SQL_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CalcAge(FndInt3date pDOB, FndInt3date pSystemDate) {
        int iAge = 0;
        if ((pDOB.month > pSystemDate.month) || (pDOB.day > pSystemDate.day) && (pDOB.month == pSystemDate.month)) {
            // month and year > today, birthday has not been reached
            iAge = (pSystemDate.year - pDOB.year) - 1;
        }
        else {
            // birth date passed, age = current year - system year
            iAge = (pSystemDate.year - pDOB.year);
        }
        if (iAge > MAX_AGE) {
            iAge = MAX_AGE;
        }
        return iAge;
    }

    
    
    static int CallCMSC49D(CINV01SI pInputMsg504, CINV01SO pOutputMsg462, Pint ulIdPerson6, int i282, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CMSC49DI pCMSC49DInputRec = null;
        CMSC49DO pCMSC49DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCMSC49DInputRec = new CMSC49DI();
        
        pCMSC49DOutputRec = new CMSC49DO();
        pCMSC49DInputRec.setArchInputStruct(pInputMsg504.getArchInputStruct());
        pCMSC49DInputRec.setUlIdPerson(ulIdPerson6.value);
        rc = cmsc49dQUERYdam(sqlca, pCMSC49DInputRec, pCMSC49DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Added in string test 1/11/96 GRD
                // If the end date is null, set it to max date,
                // then see if the end date is larger than the
                // start date, if so skip the dam call and return
                // the appropriate message
                if (pCMSC49DOutputRec.getUlSysNbrGenericCntr() > 0) {
                    pOutputMsg462.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i282).setCWcdIndMerge('Y');
                }
                else {
                    
                    pOutputMsg462.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i282).setCWcdIndMerge('N');
                }
                return rc;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                return rc;
        }
    }

    static int CallCINV29D(CINV01SI pInputMsg505, CINV01SO pOutputMsg463, Pint ulIdPerson7, int i283, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV29DI pCINV29DInputRec = null;
        CINV29DO pCINV29DOutputRec = null;
        int m = 0;/* SIR #3885 */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINV29DInputRec = new CINV29DI();
        
        pCINV29DOutputRec = new CINV29DO();
        pCINV29DInputRec.setArchInputStruct(pInputMsg505.getArchInputStruct());
        pCINV29DInputRec.setUlIdPerson(ulIdPerson7.value);
        rc = cinv29dQUERYdam(sqlca, pCINV29DInputRec, pCINV29DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set the employee indicator to true if the
                // one of the rows returned has a category
                // of employee
                for (m = 0;(m < pCINV29DOutputRec.getArchOutputStruct().getUlRowQty());m++) {
                    
                    if (pCINV29DOutputRec.getROWCINV29DO_ARRAY().getROWCINV29DO(m).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY)) {
                        pOutputMsg463.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i283).setBIndActiveStatus(true);
                    }
                }
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg463.getROWCINV01SOG00_ARRAY().getROWCINV01SOG00(i283).setBIndActiveStatus(false);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return 0;
    }

    static int CallCLSC89D(CINV01SI pInputMsg506, CINV01SO * pOutputMsg464, CLSC89DI pCLSC89DInputRec, CLSC89DO pCLSC89DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int counter = 0;
        pCLSC89DInputRec.setUlIdStage(pInputMsg506.getUlIdStage());
        pCLSC89DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE_NUMBER);
        pCLSC89DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC89DO._CLSC89DO__ROWCLSC89DO_SIZE);
        rc = clsc89dQUERYdam(sqlca, pCLSC89DInputRec, pCLSC89DOutputRec);
        
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.SQL_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
