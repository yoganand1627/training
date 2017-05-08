package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS70DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS70DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC72DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC72DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES54DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECC2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECC2DO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cinv05s;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
/**************************************************************************
**
** Module File:    csub31s.src
**
** Service Name:   csub31s
**
** Description:   This is the retrieval service
**                for the Placement Detail window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  21Oct95
**
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.8  $
**                      $Date:   08 Oct 1998 14:31:12  $
**                      $Modtime:   08 Oct 1998 08:19:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   30Nov95  sladewmf  Initial check-in.
**
**  03/03/96  WILSONET  Uncomment and correctly format the ARC_FRMGetDecode
**                      that is used to determine whether a contract is
**                      valid.  Need PlacementService.
**
**  03/05/96  WILSONET  SIR#3574: Fill in the Agency Name, not the Facility
**                      Name in both fields.  CallCRES04D.PC to populate
**                      AgencyName for contracted and non-paid.
**
**  03/22/96  WILSONET  SIR#3582: Search for Billing Level of Care and
**                      perform contract validation.  If no Billing LOC
**                      then search for Requested.  If no Requested LOC
**                      then display message.  (MESSAGE TO BE CREATED)
**
**  05/21/96  WILSONET  SIR#21325: Display LOC Inconsistency Alert when
**                      there is a direct Service match with the contract
**                      but the Living Arrangement selected is Basic,
**                      Rcvng, or Legal Risk and BLOC is not ONE.
**
**  06/06/96  WILSONET  SIR#21600: This fix will involve hard-coding the
**                      adoptive service code 96D when the living
**                      arrangement selected is "Adoptive Placement" and
**                      the placement type is "PRS F/A Home"
**
**  08/16/96  vanderm   SIR 10821 -  CRES04D dam added to retieve the
**                      facility type of the FA home.  If the a Non-PRS
**                      home is selected with a placement type of PRS FA home
**                      an error is returned to the Placement Detail window.
**  09/17/96  TOPPINTW  SIR 21130 - Added logic for invalidate pend closure
**                      approval event.  Added DAMs CINT21D and CCMN87D to
**                      retrieve event data.
**  12/17/96  ZABIHIN   SIR 21130b - removed everything related to SIR 21130
**                      the information was added in the wrong service.
**                      the correct retrieve service is csub25s.
**                      Look at comments in csub18w, csub25s and csub26s
**
** 01/19/97   SISSONM   SIR 20731b - added 2 data elements from dam output
**                      to service output message d.o ->s.o. (category and
**                      emergency placement) The Legal risk choice from the
**                      living arrangement listbox on the placement detail
**                      window will be populated if the category type is
**                      Legal Risk.  The Receiving choice will be populated
**                      in the listbox provided that Emergency placement has
**                      been checked for a placement on the Maintain
**                      Nonlicensing->Interests window.
**  05/29/97    KRD     SIR 13172 - In order to allow the creation of
**                      back-dated f/a home placements, we need to retrieve
**                      the f/a home type that were current at the time of
**                      of the placement date.  We can do this by calling
**                      CRES54D which retrieve from the RESOURCE_HISTORY
**                      table in place of CRES04D.
**                      The changes made for this SIR do not meet normal
**                      CAPS standards and should be cleaned up.
**
** 10/08/1998   hallrv  SIR 14938:  Modified the service to accommodate the
**                      addition of PACE contract.  For the most part, PACE
**                      is treated the same as TYC and JPC.
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
**  09/04/03  A.Corley	SIR 19613 LOC Reduction -- Service Codes 60A-E are now
**                      being reduced to Service Codes 63A - D, updated code to compare and
**                      save with new codes.
**  06/10/04  CORLEYAN  SIR 15078 Ensure that If the person has an ALOC > 2
**                      that they have entered Person Characterstics for
**                      Child Placement.  If they have not, display
**                      an error message.
**	06/24/04  Hadjimh   SIR#15983. In CAPS user was NOT able to save Placement if level of care
**						was not specified. However in IMPACT user was allowed to do so if they only
**						wanted to Save but not when SaveAndSubmit the Placement. This caused the
**						wrong FAD contract attaches to a placement
**  08/10/04  CORLEYAN  SIR 22462 - If the Placement type is contracted, the FLOC end and effective
**                      dates can be equal to the placement date and it should still pass editing
**                      added a new dam so that if it is contracted (not Foster adopt), the
**                      Facility level of care can still be found.
**  09/16/04  CORLEYAN  SIR 23155 - When the user attempts to select a home that was not active at
**                      the time of the placement (no appropriate row on the resource_history table),
**                      for F/A Home placement types, set the no Home Hist row to YES so that
**                      a message indicating that can be displayed on the page.
**  10/08/04  CORLEYAN  SIR 23136 - Placement is attaching to the wrong contract for Foster Adoptive
**                      placements where there is not an active row in the contract county table for
**                      the correct service code at the time of placement.  If that row is not found
**                      and it is a foster adoptive placement, set active contract to no.
**  10/27/04  CORLEYAN  SIR 23112 - When adding a placement with Placement_Type 'FPS Fost/Adopt Home'
**                      that start between 09/01/01 and 08/31/03 Service Codes 60A-C should be used
**                      when searching in the contract_county table.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
/*
** Extern for version control table.
*/






public class Csub31s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String CPA = "02";
    public static final String FOST_ADOPT = "020";
    public static final String CONTRACT = "030";
    public static final String NON_PAID = "040";
    public static final String TYC = "050";
    public static final String JUV_PROB = "060";
    public static final String PACE = "070";
    
    /* SIR#3582: Define for All FA Home Types */
    public static final String BASIC_LIV_ARR = "GA";
    public static final String RCVNG_LIV_ARR = "GP";
    public static final String LGL_RISK_LIV_ARR = "GW";
    public static final String HABILITATE_LIV_ARR = "GD";
    public static final String THERAPEUTIC_LIV_ARR = "GG";
    public static final String MED_NEEDS_LIV_ARR = "GK";
    
    /* SIR#21600: Define Adoptive Placement Living Arrangement */
    public static final String ADOPTIVE_LIV_ARR = "GT";
    
    /* SIR#3582: Validate Contract for both Requested and Billing LOC */
    public static final String BILLING = "BLOC";
    public static final String REQUESTED = "RLOC";
    /* 15078 */
    public static final String AUTHORIZED = "ALOC";
    
    /* SIR#3582: #define ACTIVE   "ACT" Use 'A' to check for FLOCStatus */
    public static final char ACTIVE = 'A';
    
    /* SIR#3582: Add PLOC_ONE to Verify Living Arrangmnt */
    public static final String PLOC_ONE = "010";
    /* SIR 15078 */
    public static final String PLOC_TWO = "020";
    public static final String PLOC_BASIC = "210";
    
    public static final String NULL_STRING = "";
    public static final String PLCMT_CODES_TABLE = "CPLCMTSC";
    public static final int CODE_LENGTH = 9;
    
    /* SIR#15787: This code table is used for services after 08/31/2001 */
    public static final String PLCMT_CODES_TABLE2 = "PLCMNTSV";
    public static final int CODE_LENGTH_2 = 10;
    public static final String AGE_REQ_CODES_TABLE = "CAGERQRD";
    public static final int AGE_CODE_LENGTH = 5;
    
    /* SIR#3582: Define NM BATCH PARAMETER for JPC and TYC */
    public static final String JPC_VENDOR_ID = "JPC-VID";
    public static final String TYC_VENDOR_ID = "TYC-VID";
    public static final String PACE_VENDOR_ID = "PACE-VID";
    
    /* SIR#3582: Define LivingArrangement Service codes for PRS F/A Homes */
    public static final String BASIC_RCVNG_LGL_RISK = "95L";
    public static final String HABIL_THERA_PRIMARY = "95M";
    
    /* SIR#15787: Define New Service codes for PRS F/A Homes */
    /* SIR#19613: Define New Service codes for PRS F/A Homes */
    public static final String BASIC_RCVNG_LGL_RISK_A = "63A";
    public static final String MOD_RCVNG_LGL_RISK_B = "63B";
    public static final String SPEC_THERA_PRIMARY_C = "63C";
    public static final String INT_THERA_PRIMARY_D = "63D";
    public static final int AGE_LIMIT = 12;
    
    /* SIR#23112: Use 60A-C for Service codes b/w 09/01/01 and 08/31/03 */
    public static final String BASIC_60A = "60A";
    public static final String BASIC_60B = "60B";
    public static final String HABIL_THERA_60C = "60C";
    
    
    /* SIR#21600: Adoptive Placement Service Code hardcoded as 96D */
    public static final String ADOPTIVE_HOME_SVC = "96D";
    
    
    /* SIR 15078 */
    public static final String CHILD_PLACE_CATEGORY = "CPL";
    CSUB31SO CSUB31S(CSUB31SI csub31si) {
        CSUB31SO csub31so = new CSUB31SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i428 = 0;
        int j = 0;/* SIR#3582 */
        int k = 0;
        int lrc = 0;/* SIR#3582: rc for Date Compare */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        
        String LocAndType = new String();
        String EmergString = new String();
        int RetVal = SUCCESS;
        int ulContractQty = 0;/* Counter for contracts returned */
        
        /* from database SIR #3582        */
        
        /* Set ValidContractFound boolean */
        char cValidContractFound = Cint14s.INDICATOR_NO;
        
        /* SIR#15787 Begin */
        FndInt3date Dt_Foster_Care_Rate_Change = null;
        FndInt3date dtTempYearBorn = null;
        int iAge = 0;
        int FosterCareRateChange = 0;
        String cAgeReqDecodeChar = new String();
        String LocAgeRequired = new String();
        /* SIR#15787 End */
        
        /* SIR#23112 Begin */
        FndInt3date Dt_Service_Code_Change = null;
        int ServiceCodeChange = 0;
        _FND_ERROR_BLOCK FndErrorBlock;
        _CODE_PARM_BLOCK CodeParmBlock;
        _CTB_DECODE * pData;
        CSEC24DI pCSEC24DInputRec = null;/* Resource simple retrieve          */
        
        
        
        
        CSEC24DO pCSEC24DOutputRec = null;
        CSEC25DI pCSEC25DInputRec = null;/* Facility_loc simple retrieve      */
        
        CSEC25DO pCSEC25DOutputRec = null;
        CRES04DI pCRES04DInputRec = null;/* Caps_resource simple retrieve     */
        
        CRES04DO pCRES04DOutputRec = null;
        CSEC33DI pCSEC33DInputRec = null;/* Person_loc simple retrieve        */
        
        CSEC33DO pCSEC33DOutputRec = null;
        CSEC26DI pCSEC26DInputRec = null;/* Contract county & period retrieve */
        
        CSEC26DO pCSEC26DOutputRec = null;
        CLSS70DI pCLSS70DInputRec = null;/* Retrieves contract based */
        CLSS70DO pCLSS70DOutputRec = null;/* on IdRsrc, Date & County */
        CSEC72DI pCSEC72DInputRec = null;/* Contract/Period Validate */
        CSEC72DO pCSEC72DOutputRec = null;/* All Stati but PENDING    */
        CSEC73DI pCSEC73DInputRec = null;/* Contract Retrieve for        */
        CSEC73DO pCSEC73DOutputRec = null;/* TYC, JPC and PACE Placements */
        CRES54DI pCRES54DInputRec = null;/* Caps_resource simple retrieve     */
        
        /* SIR#3582: Remove CLSC74D and CLSS67D        */
        /* SIR#3582: Add CLSS70D, CSEC72D, and CSEC73D */
        
        
        
        CRES54DO pCRES54DOutputRec = null;
        
        /*
        ** SIR 15078 This dam retrieves Char by Category
        */
        CLSS46DI pCLSS46DInputRec = null;
        CLSS46DO pCLSS46DOutputRec = null;
        CSECC2DI pCSECC2DInputRec = null;/* Facility_loc simple retrieve      */
        
        /*
        ** SIR 22462 This dam Facility LOC row for contracted placements (non Foster Adopt)
        */
        
        CSECC2DO pCSECC2DOutputRec = null;
        
        /*
        ** RetVal not sufficient for Impact error handling.
        ** Set rc to error code and call PROCESS_TUX_RC_ERROR
        */
        rc = ARC_PRFServiceStartTime_TUX(csub31si.getArchInputStruct());
        
        /*
        ** Run-time versioning
        */
        
        /*
        ** Check Output Buffer Size
        */
        /*
        ** Process error message and return to client
        */
        Dt_Foster_Care_Rate_Change.day = 1;
        Dt_Foster_Care_Rate_Change.month = 9;
        Dt_Foster_Care_Rate_Change.year = 2001;
        
        /* SIR 23112 */
        Dt_Service_Code_Change.day = 1;
        Dt_Service_Code_Change.month = 9;
        Dt_Service_Code_Change.year = 2003;
        
        /*
        ** Initialize Service Status Fields
        */
        
        /*
        ** Perform Main Processing
        */
        
        /* SIR 10821
        ** CRES04D dam added to retieve the facility type of the FA home.  If
        ** the a Non-PRS home is selected with a placement type of PRS FA home
        ** an error is returned to the Placement Detail window.
        */
        
        /* SIR#15787 Begin: Check to see If date is 9/1/2001 or after*/
        FosterCareRateChange = ARC_UTLCompareDateAndTime((FndInt3date) & csub31si.getDtDtPlcmtStart() , (char) 0, (FndInt3date) & Dt_Foster_Care_Rate_Change, (char) 0);
        
        /* SIR#23112 Begin: Check to see If date is 9/1/2004 or after*/
        ServiceCodeChange = ARC_UTLCompareDateAndTime((FndInt3date) & csub31si.getDtDtPlcmtStart() , (char) 0, (FndInt3date) & Dt_Service_Code_Change, (char) 0);
        
        /*
        ** RetVal not sufficient for Impact error handling.
        ** Set rc to error code and call PROCESS_TUX_RC_ERROR
        */
        rc = Cinv05s.CallCCMN44D(csub31si, csub31so, pServiceStatus, dtTempYearBorn);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ARC_UTLCompareDateAndTime((FndInt3date) & csub31si.getDtDtPlcmtStart() , (char) 0, (FndInt3date) & dtTempYearBorn, (char) 0);
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc /= 525600;
        /* month and year > today, birthday has not been reached */
        iAge = rc;
        
        /* SIR#15787 End */
        
        /**************************************************************************
        ** (BEGIN): CRES04D - full row retrieve (to get the Facility Type)
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCRES04DInputRec = new CRES04DI();
        
        pCRES04DOutputRec = new CRES04DO();
        pCRES04DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
        pCRES04DInputRec.setUlIdResource(csub31si.getUlIdResource());
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if ((0 == pCRES04DOutputRec.getSzCdRsrcFacilType().compareTo("71")) && (0 == csub31si.getSzCdPlcmtType().compareTo("020"))) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_SUB_NON_PRS;
                    RetVal = Csub50s.FND_FAIL;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                }
                csub31so.setSzCdRsrcCategory(pCRES04DOutputRec.getSzCdRsrcCategory());
                csub31so.setCIndRsrcEmergPlace(pCRES04DOutputRec.getCIndRsrcEmergPlace());
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        if (SUCCESS == RetVal) {
            
            // 
            // (BEGIN): Retrieve DAM: csec24d      Resource simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCSEC24DInputRec = new CSEC24DI();
            
            pCSEC24DOutputRec = new CSEC24DO();
            pCSEC24DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
            pCSEC24DInputRec.setUIdRsrcLinkChild(csub31si.getUlIdResource());
            
            pCSEC24DInputRec.setSzCdRsrcLinkType(CPA);
            rc = csec24dQUERYdam(sqlca, pCSEC24DInputRec, pCSEC24DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Call CINT21D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    csub31so.setUlIdRsrcAgency(pCSEC24DOutputRec.getUIdRsrcLinkParent());
                    if ((0 == CONTRACT.compareTo(csub31si.getSzCdPlcmtType())) || (0 == NON_PAID.compareTo(csub31si.getSzCdPlcmtType())) || (0 == JUV_PROB.compareTo(csub31si.getSzCdPlcmtType())) || (0 == TYC.compareTo(csub31si.getSzCdPlcmtType())) || (0 == PACE.compareTo(csub31si.getSzCdPlcmtType()))) {
                        // 
                        // (BEGIN): Retrieve DAM: cres04d      Caps_resource simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCRES04DInputRec = new CRES04DI();
                        
                        pCRES04DOutputRec = new CRES04DO();
                        
                        pCRES04DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                        pCRES04DInputRec.setUlIdResource(pCSEC24DOutputRec.getUIdRsrcLinkParent());
                        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
                        
                        //  Analyze error code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub31so.setSzNmPlcmtAgency(pCRES04DOutputRec.getSzNmResource());
                                
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
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    
                    //  If the Adoption Consumated legal status
                    // record was found, then the placement
                    // should not count.  Do not increment
                    // the Counter
                    
                    break;
            }
            
            if ((0 == CONTRACT.compareTo(csub31si.getSzCdPlcmtType())) || (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) || (0 == JUV_PROB.compareTo(csub31si.getSzCdPlcmtType())) || (0 == TYC.compareTo(csub31si.getSzCdPlcmtType())) || (0 == PACE.compareTo(csub31si.getSzCdPlcmtType()))) {
                
                if (SUCCESS == RetVal) {
                    
                    if (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                        
                        // 
                        // (BEGIN): Retrieve DAM: csec25d      Facility_loc simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCSEC25DInputRec = new CSEC25DI();
                        
                        pCSEC25DOutputRec = new CSEC25DO();
                        pCSEC25DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                        
                        if (0 != csub31so.getUlIdRsrcAgency()) {
                            pCSEC25DInputRec.setUlIdResource(csub31so.getUlIdRsrcAgency());
                        }
                        else {
                            pCSEC25DInputRec.setUlIdResource(csub31si.getUlIdResource());
                        }
                        pCSEC25DInputRec.setDtDtPlcmtStart(csub31si.getDtDtPlcmtStart());
                        
                        //  Call DAM
                        rc = csec25dQUERYdam(sqlca, pCSEC25DInputRec, pCSEC25DOutputRec);
                        
                        //  Analyze return code
                        //  Analyze return code
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub31so.setCCdFlocStatus1(pCSEC25DOutputRec.getCCdFlocStatus1());
                                csub31so.setCCdFlocStatus2(pCSEC25DOutputRec.getCCdFlocStatus2());
                                csub31so.setCCdFlocStatus3(pCSEC25DOutputRec.getCCdFlocStatus3());
                                csub31so.setCCdFlocStatus4(pCSEC25DOutputRec.getCCdFlocStatus4());
                                csub31so.setCCdFlocStatus5(pCSEC25DOutputRec.getCCdFlocStatus5());
                                csub31so.setCCdFlocStatus6(pCSEC25DOutputRec.getCCdFlocStatus6());
                                csub31so.setCCdFlocStatus7(pCSEC25DOutputRec.getCCdFlocStatus7());
                                csub31so.setCCdFlocStatus8(pCSEC25DOutputRec.getCCdFlocStatus8());
                                csub31so.setCCdFlocStatus9(pCSEC25DOutputRec.getCCdFlocStatus9());
                                csub31so.setCCdFlocStatus10(pCSEC25DOutputRec.getCCdFlocStatus10());
                                csub31so.setCCdFlocStatus11(pCSEC25DOutputRec.getCCdFlocStatus11());
                                csub31so.setCCdFlocStatus12(pCSEC25DOutputRec.getCCdFlocStatus12());
                                csub31so.setCCdFlocStatus13(pCSEC25DOutputRec.getCCdFlocStatus13());
                                csub31so.setCCdFlocStatus14(pCSEC25DOutputRec.getCCdFlocStatus14());
                                csub31so.setCCdFlocStatus15(pCSEC25DOutputRec.getCCdFlocStatus15());
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
                                break;
                                
                            default :
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                
                                break;
                        }
                    }
                    // 
                    // (END): Retrieve DAM: csec25d      Facility_loc simple retrieve
                    // 
                    else {
                        // 
                        // (BEGIN): Retrieve DAM: csecc2d      Facility_loc simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCSECC2DInputRec = new CSECC2DI();
                        
                        pCSECC2DOutputRec = new CSECC2DO();
                        pCSECC2DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                        
                        if (0 != csub31so.getUlIdRsrcAgency()) {
                            pCSECC2DInputRec.setUlIdResource(csub31so.getUlIdRsrcAgency());
                        }
                        else {
                            pCSECC2DInputRec.setUlIdResource(csub31si.getUlIdResource());
                        }
                        pCSECC2DInputRec.setDtDtPlcmtStart(csub31si.getDtDtPlcmtStart());
                        rc = csecc2dQUERYdam(sqlca, pCSECC2DInputRec, pCSECC2DOutputRec);
                        
                        //  Analyze return code
                        //  Analyze return code
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub31so.setCCdFlocStatus1(pCSECC2DOutputRec.getCCdFlocStatus1());
                                csub31so.setCCdFlocStatus2(pCSECC2DOutputRec.getCCdFlocStatus2());
                                csub31so.setCCdFlocStatus3(pCSECC2DOutputRec.getCCdFlocStatus3());
                                csub31so.setCCdFlocStatus4(pCSECC2DOutputRec.getCCdFlocStatus4());
                                csub31so.setCCdFlocStatus5(pCSECC2DOutputRec.getCCdFlocStatus5());
                                csub31so.setCCdFlocStatus6(pCSECC2DOutputRec.getCCdFlocStatus6());
                                csub31so.setCCdFlocStatus7(pCSECC2DOutputRec.getCCdFlocStatus7());
                                csub31so.setCCdFlocStatus8(pCSECC2DOutputRec.getCCdFlocStatus8());
                                csub31so.setCCdFlocStatus9(pCSECC2DOutputRec.getCCdFlocStatus9());
                                csub31so.setCCdFlocStatus10(pCSECC2DOutputRec.getCCdFlocStatus10());
                                csub31so.setCCdFlocStatus11(pCSECC2DOutputRec.getCCdFlocStatus11());
                                csub31so.setCCdFlocStatus12(pCSECC2DOutputRec.getCCdFlocStatus12());
                                csub31so.setCCdFlocStatus13(pCSECC2DOutputRec.getCCdFlocStatus13());
                                csub31so.setCCdFlocStatus14(pCSECC2DOutputRec.getCCdFlocStatus14());
                                csub31so.setCCdFlocStatus15(pCSECC2DOutputRec.getCCdFlocStatus15());
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
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
                    
                    if (0 != FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                        // 
                        // (BEGIN): Retrieve DAM: cres04d      Caps_resource simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCRES04DInputRec = new CRES04DI();
                        
                        pCRES04DOutputRec = new CRES04DO();
                        pCRES04DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                        
                        if (0 != csub31so.getUlIdRsrcAgency()) {
                            pCRES04DInputRec.setUlIdResource(csub31so.getUlIdRsrcAgency());
                        }
                        else // Otherwise, use the Facility's IdResource
                        {
                            pCRES04DInputRec.setUlIdResource(csub31si.getUlIdResource());
                        }
                        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
                    }
                    
                    else {
                        // 
                        // (BEGIN): Retrieve DAM: cres54d      resource_history simple retrieve
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCRES54DInputRec = new CRES54DI();
                        
                        pCRES54DOutputRec = new CRES54DO();
                        pCRES54DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                        
                        if (0 != csub31so.getUlIdRsrcAgency()) {
                            pCRES54DInputRec.setUlIdResource(csub31so.getUlIdRsrcAgency());
                        }
                        else // Otherwise, use the Facility's IdResource
                        {
                            pCRES54DInputRec.setUlIdResource(csub31si.getUlIdResource());
                            
                            //SIR 23664
                        }
                        pCRES54DInputRec.setDtDtPlcmtStart(csub31si.getDtDtPlcmtStart());
                        rc = cres54dQUERYdam(sqlca, pCRES54DInputRec, pCRES54DOutputRec);
                    }
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            if (0 != FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                                csub31so.setCCdRsrcFaHomeType1(pCRES04DOutputRec.getCCdRsrcFaHomeType1());
                                csub31so.setCCdRsrcFaHomeType2(pCRES04DOutputRec.getCCdRsrcFaHomeType2());
                                csub31so.setCCdRsrcFaHomeType3(pCRES04DOutputRec.getCCdRsrcFaHomeType3());
                                csub31so.setCCdRsrcFaHomeType4(pCRES04DOutputRec.getCCdRsrcFaHomeType4());
                                
                                csub31so.setCCdRsrcFaHomeType5(pCRES04DOutputRec.getCCdRsrcFaHomeType5());
                                
                                csub31so.setCCdRsrcFaHomeType6(pCRES04DOutputRec.getCCdRsrcFaHomeType6());
                                
                                csub31so.setCCdRsrcFaHomeType7(pCRES04DOutputRec.getCCdRsrcFaHomeType7());
                                csub31so.setSzCdRsrcOwnership(pCRES04DOutputRec.getSzCdRsrcOwnership());
                                //END SIR 23664
                                
                                //SIR 23771
                            }
                            
                            
                            else {
                                csub31so.setCCdRsrcFaHomeType1(pCRES54DOutputRec.getCCdRshsFaHomeType1());
                                csub31so.setCCdRsrcFaHomeType2(pCRES54DOutputRec.getCCdRshsFaHomeType2());
                                csub31so.setCCdRsrcFaHomeType3(pCRES54DOutputRec.getCCdRshsFaHomeType3());
                                csub31so.setCCdRsrcFaHomeType4(pCRES54DOutputRec.getCCdRshsFaHomeType4());
                                csub31so.setCCdRsrcFaHomeType5(pCRES54DOutputRec.getCCdRshsFaHomeType5());
                                csub31so.setCCdRsrcFaHomeType6(pCRES54DOutputRec.getCCdRshsFaHomeType6());
                                csub31so.setCCdRsrcFaHomeType7(pCRES54DOutputRec.getCCdRshsFaHomeType7());
                                csub31so.setSzCdRsrcOwnership(pCRES54DOutputRec.getSzCdRshsOwnership());
                                //END SIR 23771
                                
                            }
                            
                            
                            // 
                            // (BEGIN): Retrieve DAM: csec33d      Person_loc simple retrieve
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCSEC33DInputRec = new CSEC33DI();
                            
                            pCSEC33DOutputRec = new CSEC33DO();
                            csub31so.setCSysIndALoc(Cint14s.INDICATOR_NO);
                            pCSEC33DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                            pCSEC33DInputRec.setUlIdPerson(csub31si.getUlIdPlcmtChild());
                            pCSEC33DInputRec.setDtScrDtCurrentDate(csub31si.getDtDtPlcmtStart());
                            pCSEC33DInputRec.setSzCdPlocType(AUTHORIZED);
                            rc = csec33dQUERYdam(sqlca, pCSEC33DInputRec, pCSEC33DOutputRec);
                            
                            //  Analyze error code
                            switch (rc) {
                                    // continue rc analysis for ccmn45d with second a
                                    // case of switch
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    
                                    if (0 != PLOC_ONE.compareTo(pCSEC33DOutputRec.getSzCdPlocChild()) && 0 != PLOC_TWO.compareTo(pCSEC33DOutputRec.getSzCdPlocChild()) && 0 != PLOC_BASIC.compareTo(pCSEC33DOutputRec.getSzCdPlocChild())) {
                                        //  Call CLSS46D - Rtrv Char By Category
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCLSS46DInputRec = new CLSS46DI();
                                        
                                        pCLSS46DOutputRec = new CLSS46DO();
                                        pCLSS46DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                                        pCLSS46DInputRec.setUlIdPerson(csub31si.getUlIdPlcmtChild());
                                        pCLSS46DInputRec.setSzCdCharCategory(CHILD_PLACE_CATEGORY);
                                        pCLSS46DInputRec.getArchInputStruct().setUsPageNbr(1);
                                        pCLSS46DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS46DO._CLSS46DO__ROWCLSS46DO_SIZE);
                                        rc = clss46dQUERYdam(sqlca, pCLSS46DInputRec, pCLSS46DOutputRec);
                                        switch (rc) {
                                                
                                                
                                                // continue rc analysis for CINT21D with second case
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                csub31so.setCSysIndALoc(Cint14s.INDICATOR_NO);
                                                
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                csub31so.setCSysIndALoc(INDICATOR_YES);
                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                break;
                                        }
                                        
                                        // 
                                        // (BEGIN): SIR 20840 Retreive resource address row(s) cres13d
                                        // 
                                        
                                        
                                        break;
                                    }
                                    
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    break;
                                    
                                default :
                                    // Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    
                                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    break;
                            }
                            pCSEC33DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                            pCSEC33DInputRec.setUlIdPerson(csub31si.getUlIdPlcmtChild());
                            pCSEC33DInputRec.setDtScrDtCurrentDate(csub31si.getDtDtPlcmtStart());
                            pCSEC33DInputRec.setSzCdPlocType(BILLING);
                            rc = csec33dQUERYdam(sqlca, pCSEC33DInputRec, pCSEC33DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    
                                    // Compare the DtPlcmtStart with the PLOC End Date
                                    lrc = ARC_UTLCompareDateAndTime((FndInt3date) & csub31si.getDtDtPlcmtStart() , (char) 0, (FndInt3date) & pCSEC33DOutputRec.getDtDtPlocEnd() , (char) 0);
                                    if (lrc != 0) {
                                        LocAndType = pCSEC33DOutputRec.getSzCdPlocChild();
                                        strncat(LocAndType, csub31si.getSzCdRsrcFacilType() , sizeof ());
                                        LocAgeRequired = LocAndType;
                                        EmergString = CStringUtils.setCharAt(EmergString, 0, csub31si.getCIndPlcmetEmerg());
                                        strncat(LocAndType, EmergString, sizeof ());
                                        strncat(LocAndType, csub31si.getSzCdPlcmtType() , sizeof ());
                                        if (FosterCareRateChange >= 0) {
                                            
                                            //  Call DAM
                                            rc = ARC_UTLGetDecode((char) cAgeReqDecodeChar, LocAgeRequired, AGE_CODE_LENGTH, (char) AGE_REQ_CODES_TABLE);
                                            
                                            if (!(cAgeReqDecodeChar.compareTo(CharDecodeY) != 0)) {
                                                
                                                if (iAge >= AGE_LIMIT) {
                                                    strncat(LocAndType, CharOne, sizeof ());
                                                }
                                                else {
                                                    strncat(LocAndType, CharZero, sizeof ());
                                                }
                                            }
                                            else {
                                                LocAndType += CharX;
                                            }
                                            rc = ARC_UTLGetDecode((char) csub31so.getSzCdPlcmtService() , LocAndType, CODE_LENGTH_2, (char) PLCMT_CODES_TABLE2);
                                        }
                                        else {
                                            rc = ARC_UTLGetDecode((char) csub31so.getSzCdPlcmtService() , LocAndType, CODE_LENGTH, (char) PLCMT_CODES_TABLE);
                                        }
                                        if (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                                            if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(BASIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(RCVNG_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(LGL_RISK_LIV_ARR))) {
                                                
                                                if (FosterCareRateChange >= 0) {
                                                    if (ServiceCodeChange >= 0) {
                                                        csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK_A);
                                                    }
                                                    else if (iAge >= AGE_LIMIT) {
                                                        csub31so.setSzCdPlcmtService(BASIC_60B);
                                                    }
                                                    else {
                                                        csub31so.setSzCdPlcmtService(BASIC_60A);
                                                    }
                                                }
                                                else {
                                                    csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK);
                                                }
                                                
                                                if (0 != PLOC_ONE.compareTo(pCSEC33DOutputRec.getSzCdPlocChild())) {
                                                    csub31so.setBIndChkd(INDICATOR_YES);
                                                }
                                            }
                                            else if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(HABILITATE_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(THERAPEUTIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(MED_NEEDS_LIV_ARR))) {
                                                if (FosterCareRateChange >= 0) {
                                                    if (ServiceCodeChange >= 0) {
                                                        csub31so.setSzCdPlcmtService(MOD_RCVNG_LGL_RISK_B);
                                                    }
                                                    else {
                                                        csub31so.setSzCdPlcmtService(HABIL_THERA_60C);
                                                    }
                                                }
                                                else {
                                                    csub31so.setSzCdPlcmtService(HABIL_THERA_PRIMARY);
                                                }
                                            }
                                            // SIR#21600: Hard Code 96D as Svc Code for Adoptive Home
                                            else if (0 == csub31si.getSzCdRsrcFacilType().compareTo(ADOPTIVE_LIV_ARR)) {
                                                csub31so.setSzCdPlcmtService(ADOPTIVE_HOME_SVC);
                                            }
                                        }
                                        if (Arcutls.ARC_UTL_DECODE_ERROR == rc) {
                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                        }
                                        
                                        else {
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        }
                                    }
                                    
                                    
                                    else if (0 == lrc) {
                                        pCSEC33DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                                        pCSEC33DInputRec.setUlIdPerson(csub31si.getUlIdPlcmtChild());
                                        pCSEC33DInputRec.setDtScrDtCurrentDate(csub31si.getDtDtPlcmtStart());
                                        
                                        pCSEC33DInputRec.setSzCdPlocType(REQUESTED);
                                        rc = csec33dQUERYdam(sqlca, pCSEC33DInputRec, pCSEC33DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                LocAndType = pCSEC33DOutputRec.getSzCdPlocChild();
                                                strncat(LocAndType, csub31si.getSzCdRsrcFacilType() , sizeof ());
                                                LocAgeRequired = LocAndType;
                                                EmergString = CStringUtils.setCharAt(EmergString, 0, csub31si.getCIndPlcmetEmerg());
                                                strncat(LocAndType, EmergString, sizeof ());
                                                strncat(LocAndType, csub31si.getSzCdPlcmtType() , sizeof ());
                                                if (FosterCareRateChange >= 0) {
                                                    
                                                    
                                                    //  Start performance timer for service. All performance functions always
                                                    // return success so there is no need to check status.
                                                    rc = ARC_UTLGetDecode((char) cAgeReqDecodeChar, LocAgeRequired, AGE_CODE_LENGTH, (char) AGE_REQ_CODES_TABLE);
                                                    
                                                    if (!(cAgeReqDecodeChar.compareTo(CharDecodeY) != 0)) {
                                                        if (iAge >= AGE_LIMIT) {
                                                            strncat(LocAndType, CharOne, sizeof ());
                                                        }
                                                        else {
                                                            strncat(LocAndType, CharZero, sizeof ());
                                                        }
                                                    }
                                                    else {
                                                        LocAndType += CharX;
                                                    }
                                                    
                                                    // SIR 21891 - missing versioning
                                                    //  Run-time Versioning
                                                    
                                                    //  Check buffer size
                                                    
                                                    //  Process error message and return to client
                                                    
                                                    //  Initialize output message and length
                                                    
                                                    //  Initialize service status fields
                                                    
                                                    // 
                                                    // Call DAMs to update data
                                                    // 
                                                    //  Call DAM to update CAPS_RESOURCE table
                                                    rc = ARC_UTLGetDecode((char) csub31so.getSzCdPlcmtService() , LocAndType, CODE_LENGTH_2, (char) PLCMT_CODES_TABLE2);
                                                }
                                                else {
                                                    
                                                    //  Call DAM to update SPEC_SVCS table
                                                    rc = ARC_UTLGetDecode((char) csub31so.getSzCdPlcmtService() , LocAndType, CODE_LENGTH, (char) PLCMT_CODES_TABLE);
                                                }
                                                
                                                if (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                                                    if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(BASIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(RCVNG_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(LGL_RISK_LIV_ARR))) {
                                                        if (FosterCareRateChange >= 0) {
                                                            if (ServiceCodeChange >= 0) {
                                                                csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK_A);
                                                            }
                                                            else if (iAge >= AGE_LIMIT) {
                                                                csub31so.setSzCdPlcmtService(BASIC_60B);
                                                            }
                                                            else {
                                                                csub31so.setSzCdPlcmtService(BASIC_60A);
                                                            }
                                                        }
                                                        else {
                                                            csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK);
                                                        }
                                                        
                                                        if (0 != PLOC_ONE.compareTo(pCSEC33DOutputRec.getSzCdPlocChild())) {
                                                            
                                                            //## BEGIN TUX/XML: Declare XML variables 
                                                            csub31so.setBIndChkd(INDICATOR_YES);
                                                        }
                                                    }
                                                    else if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(HABILITATE_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(THERAPEUTIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(MED_NEEDS_LIV_ARR))) {
                                                        
                                                        if (FosterCareRateChange >= 0) {
                                                            
                                                            if (ServiceCodeChange >= 0) {
                                                                csub31so.setSzCdPlcmtService(MOD_RCVNG_LGL_RISK_B);
                                                            }
                                                            else {
                                                                csub31so.setSzCdPlcmtService(HABIL_THERA_60C);
                                                            }
                                                        }
                                                        else {
                                                            csub31so.setSzCdPlcmtService(HABIL_THERA_PRIMARY);
                                                        }
                                                    }
                                                    
                                                    // SIR#21600: Hard Code 96D as Svc Code for Adoptive Home
                                                    else if (0 == csub31si.getSzCdRsrcFacilType().compareTo(ADOPTIVE_LIV_ARR)) {
                                                        csub31so.setSzCdPlcmtService(ADOPTIVE_HOME_SVC);
                                                    }
                                                }
                                                
                                                if (Arcutls.ARC_UTL_DECODE_ERROR == rc) {
                                                    
                                                    //  Call DAM to update FACILITY_LOC table
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                }
                                                
                                                else {
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                }
                                                
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                csub31so.setCSysIndLocChange(INDICATOR_YES);
                                                
                                                break;
                                                
                                            default :
                                                // Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                
                                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                break;
                                        }
                                    }
                                    
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    pCSEC33DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                                    
                                    //## BEGIN TUX/XML: Declare XML variables
                                    pCSEC33DInputRec.setUlIdPerson(csub31si.getUlIdPlcmtChild());
                                    pCSEC33DInputRec.setDtScrDtCurrentDate(csub31si.getDtDtPlcmtStart());
                                    pCSEC33DInputRec.setSzCdPlocType(REQUESTED);
                                    rc = csec33dQUERYdam(sqlca, pCSEC33DInputRec, pCSEC33DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            LocAndType = pCSEC33DOutputRec.getSzCdPlocChild();
                                            strncat(LocAndType, csub31si.getSzCdRsrcFacilType() , sizeof ());
                                            LocAgeRequired = LocAndType;
                                            EmergString = CStringUtils.setCharAt(EmergString, 0, csub31si.getCIndPlcmetEmerg());
                                            strncat(LocAndType, EmergString, sizeof ());
                                            strncat(LocAndType, csub31si.getSzCdPlcmtType() , sizeof ());
                                            
                                            if (FosterCareRateChange >= 0) {
                                                
                                                //  Call DAM
                                                rc = ARC_UTLGetDecode((char) cAgeReqDecodeChar, LocAgeRequired, AGE_CODE_LENGTH, (char) AGE_REQ_CODES_TABLE);
                                                
                                                if (!(cAgeReqDecodeChar.compareTo(CharDecodeY) != 0)) {
                                                    
                                                    if (iAge >= AGE_LIMIT) {
                                                        strncat(LocAndType, CharOne, sizeof ());
                                                    }
                                                    else {
                                                        strncat(LocAndType, CharZero, sizeof ());
                                                    }
                                                }
                                                else {
                                                    LocAndType += CharX;
                                                }
                                                
                                                rc = ARC_UTLGetDecode((char) csub31so.getSzCdPlcmtService() , LocAndType, CODE_LENGTH_2, (char) PLCMT_CODES_TABLE2);
                                            }
                                            else {
                                                rc = ARC_UTLGetDecode((char) csub31so.getSzCdPlcmtService() , LocAndType, CODE_LENGTH, (char) PLCMT_CODES_TABLE);
                                            }
                                            if (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                                                if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(BASIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(RCVNG_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(LGL_RISK_LIV_ARR))) {
                                                    if (FosterCareRateChange >= 0) {
                                                        if (ServiceCodeChange >= 0) {
                                                            csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK_A);
                                                        }
                                                        else if (iAge >= AGE_LIMIT) {
                                                            csub31so.setSzCdPlcmtService(BASIC_60B);
                                                        }
                                                        else {
                                                            csub31so.setSzCdPlcmtService(BASIC_60A);
                                                        }
                                                    }
                                                    else {
                                                        csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK);
                                                    }
                                                    if (0 != PLOC_ONE.compareTo(pCSEC33DOutputRec.getSzCdPlocChild())) {
                                                        csub31so.setBIndChkd(INDICATOR_YES);
                                                    }
                                                }
                                                else if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(HABILITATE_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(THERAPEUTIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(MED_NEEDS_LIV_ARR))) {
                                                    
                                                    if (FosterCareRateChange >= 0) {
                                                        
                                                        if (ServiceCodeChange >= 0) {
                                                            csub31so.setSzCdPlcmtService(MOD_RCVNG_LGL_RISK_B);
                                                        }
                                                        else {
                                                            csub31so.setSzCdPlcmtService(HABIL_THERA_60C);
                                                        }
                                                    }
                                                    else {
                                                        csub31so.setSzCdPlcmtService(HABIL_THERA_PRIMARY);
                                                    }
                                                }
                                                // SIR#21600: Hard Code 96D as SvcCd for Adoptive Home
                                                else if (0 == csub31si.getSzCdRsrcFacilType().compareTo(ADOPTIVE_LIV_ARR)) {
                                                    csub31so.setSzCdPlcmtService(ADOPTIVE_HOME_SVC);
                                                }
                                            }
                                            
                                            if (Arcutls.ARC_UTL_DECODE_ERROR == rc) {
                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                            }
                                            
                                            else {
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            csub31so.setCSysIndLocChange(INDICATOR_YES);
                                            
                                            break;
                                            
                                        default :
                                            // Set RetVal to FND_FAIL
                                            RetVal = Csub50s.FND_FAIL;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                    // Do not free(pCSEC33DInputRec) NOW.  It is freed BELOW.
                                    
                                    // 
                                    // End Second Call to validate contract that matches REQUESTED 
                                    // 
                                    
                                    
                                default :
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                            break;
                        case NO_DATA_FOUND:
                            
                            if (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Call DAM
                                
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                //  Anything but SQL_SUCCESS is an unacceptable error
                                csub31so.setBSysIndHomeHist(INDICATOR_YES);
                                break;
                            }
                            else {
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                            }
                            
                        default :
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    
                    if (!0 != FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                    }
                }
            }
            
            if ((0 == CONTRACT.compareTo(csub31si.getSzCdPlcmtType())) || (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) || (0 == JUV_PROB.compareTo(csub31si.getSzCdPlcmtType())) || (0 == TYC.compareTo(csub31si.getSzCdPlcmtType())) || (0 == PACE.compareTo(csub31si.getSzCdPlcmtType())) && (SUCCESS == RetVal)) {
                if (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType()) && 0 == 0.compareTo(csub31so.getSzCdPlcmtService())) {
                    if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(BASIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(RCVNG_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(LGL_RISK_LIV_ARR))) {
                        
                        if (FosterCareRateChange >= 0) {
                            
                            if (ServiceCodeChange >= 0) {
                                csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK_A);
                            }
                            else if (iAge >= AGE_LIMIT) {
                                csub31so.setSzCdPlcmtService(BASIC_60B);
                            }
                            else {
                                csub31so.setSzCdPlcmtService(BASIC_60A);
                            }
                        }
                        else {
                            csub31so.setSzCdPlcmtService(BASIC_RCVNG_LGL_RISK);
                        }
                    }
                    else if ((0 == csub31si.getSzCdRsrcFacilType().compareTo(HABILITATE_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(THERAPEUTIC_LIV_ARR)) || (0 == csub31si.getSzCdRsrcFacilType().compareTo(MED_NEEDS_LIV_ARR))) {
                        
                        if (FosterCareRateChange >= 0) {
                            //## END TUX/XML: Turn the XML buffer into an input message struct
                            
                            
                            if (ServiceCodeChange >= 0) {
                                //  Anything but SQL_SUCCESS is an unacceptable error
                                csub31so.setSzCdPlcmtService(MOD_RCVNG_LGL_RISK_B);
                            }
                            else {
                                csub31so.setSzCdPlcmtService(HABIL_THERA_60C);
                            }
                        }
                        else {
                            csub31so.setSzCdPlcmtService(HABIL_THERA_PRIMARY);
                        }
                    }
                    
                    else if (0 == csub31si.getSzCdRsrcFacilType().compareTo(ADOPTIVE_LIV_ARR)) {
                        csub31so.setSzCdPlcmtService(ADOPTIVE_HOME_SVC);
                    }
                    
                }
                // End SIR#15983
                // 
                // (BEGIN): Retrieve DAM: csec26d  Contract county & period retrieve
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCSEC26DInputRec = new CSEC26DI();
                
                pCSEC26DOutputRec = new CSEC26DO();
                pCSEC26DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                
                //  If a good validated address is returned then set boolean bOutOfState
                // variable equal to TRUE(non-zero) if it isn't a Texas address and
                // FALSE(0) if not, otherwise set boolean based on the parsed address
                // state.
                if (0 != csub31so.getUlIdRsrcAgency()) {
                    pCSEC26DInputRec.setUlIdResource(csub31so.getUlIdRsrcAgency());
                }
                else // Otherwise, use the Facility's IdResource
                {
                    pCSEC26DInputRec.setUlIdResource(csub31si.getUlIdResource());
                }
                pCSEC26DInputRec.setDtScrDtCurrentDate(csub31si.getDtDtPlcmtStart());
                pCSEC26DInputRec.setSzCdCncntyCounty(csub31si.getSzAddrPlcmtCnty());
                pCSEC26DInputRec.setSzCdCncntyService(csub31so.getSzCdPlcmtService());
                rc = csec26dQUERYdam(sqlca, pCSEC26DInputRec, pCSEC26DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // Set indicator to signal that a valid contract was found
                        cValidContractFound = INDICATOR_YES;
                        
                        //  Capture the return code of the validation and send it
                        // back to the client to be decoded.
                        if (INDICATOR_YES != csub31so.getBIndChkd()) {
                            csub31so.setBIndChkd(Cint14s.INDICATOR_NO);
                        }
                        
                        //  Retrieve the county by zipcode if Code1 returns a zipcode and it is a
                        // Texas address.
                        if ((0 != JUV_PROB.compareTo(csub31si.getSzCdPlcmtType())) && (0 != TYC.compareTo(csub31si.getSzCdPlcmtType())) && (0 != PACE.compareTo(csub31si.getSzCdPlcmtType()))) {
                            csub31so.setUlIdContract(pCSEC26DOutputRec.getUlIdContract());
                        }
                        csub31so.setSzCdCnperStatus(pCSEC26DOutputRec.getSzCdCnperStatus());
                        break;
                    case NO_DATA_FOUND:
                        if (0 == FOST_ADOPT.compareTo(csub31si.getSzCdPlcmtType())) {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            cValidContractFound = Cint14s.INDICATOR_NO;
                        }
                        else {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            
                            
                            // Retrieve counties for a city if :
                            // -Code1 returns CODE1_INVALID_HOUSE_NBR and there is a city.
                            // -Code1 returns CODE1_INVALID_ZIPS and there is a city.
                            // -Code1 returns CODE1_ADDRESS_MULTIPLE and there is a city.
                            // Basically, if a city exists and a zip doesn't.
                            
                            //  If the return code is not successful for ZipToCounty call, then
                            // call the DAM to retrieve counties for a city only if a Texas address,
                            // otherwise copy the out of state county code, decode & the row quantity
                            // indicator(equal to 1) to the output message.
                            if (ACTIVE == csub31so.getCCdFlocStatus1()) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            else {
                                csub31so.setBIndActiveStatus(Cint14s.INDICATOR_NO);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus2()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                
                                
                                
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus3()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus4()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            
                            
                            // 
                            // Analyze error code
                            // 
                            if ((ACTIVE == csub31so.getCCdFlocStatus5()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus6()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            
                            if ((ACTIVE == csub31so.getCCdFlocStatus7()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            
                            if ((ACTIVE == csub31so.getCCdFlocStatus8()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            
                            if ((ACTIVE == csub31so.getCCdFlocStatus9()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            
                            if ((ACTIVE == csub31so.getCCdFlocStatus10()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus11()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus12()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus13()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus14()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            if ((ACTIVE == csub31so.getCCdFlocStatus15()) && (csub31so.getBIndActiveStatus() != INDICATOR_YES)) {
                                csub31so.setBIndActiveStatus(INDICATOR_YES);
                            }
                            
                            // analyze error code
                            if (INDICATOR_YES == csub31so.getBIndActiveStatus()) {
                                // 
                                // (BEGIN): CLSS70D - List retrieval of Contract rows for and id resource.
                                // 
                                
                                
                                pCLSS70DInputRec = new CLSS70DI();
                                
                                pCLSS70DOutputRec = new CLSS70DO();
                                pCLSS70DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                                
                                if (0 != csub31so.getUlIdRsrcAgency()) {
                                    pCLSS70DInputRec.setUlIdResource(csub31so.getUlIdRsrcAgency());
                                }
                                else // Otherwise, use the Facility's IdResource
                                {
                                    pCLSS70DInputRec.setUlIdResource(csub31si.getUlIdResource());
                                }
                                pCLSS70DInputRec.setSzCdCncntyCounty(csub31si.getSzAddrPlcmtCnty());
                                pCLSS70DInputRec.setDtDtPlcmtStart(csub31si.getDtDtPlcmtStart());
                                pCLSS70DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS70DO._CLSS70DO__ROWCLSS70DO_SIZE);
                                pCLSS70DInputRec.getArchInputStruct().setUsPageNbr(1);
                                
                                
                                //  Call CAUD18D
                                rc = clss70dQUERYdam(sqlca, pCLSS70DInputRec, pCLSS70DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Set fields in CFAD08SO to fields in CLSS70DO
                                        
                                        ulContractQty = pCLSS70DOutputRec.getArchOutputStruct().getUlRowQty();
                                        
                                        //  Loop through all contract rows returned from the previous DAM
                                        for (k = 0;((k < ulContractQty) && (cValidContractFound != INDICATOR_YES));k++) {
                                            
                                            // 
                                            // (BEGIN): CSEC72D - Full row retrieval to verify contract is not PENDING.
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCSEC72DInputRec = new CSEC72DI();
                                            
                                            pCSEC72DOutputRec = new CSEC72DO();
                                            pCSEC72DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                                            pCSEC72DInputRec.setUlIdContract(pCLSS70DOutputRec.getROWCLSS70DO_ARRAY().getROWCLSS70DO(k).getUlIdContract());
                                            pCSEC72DInputRec.setUlNbrCnperPeriod(pCLSS70DOutputRec.getROWCLSS70DO_ARRAY().getROWCLSS70DO(k).getUlNbrCncntyPeriod());
                                            rc = csec72dQUERYdam(sqlca, pCSEC72DInputRec, pCSEC72DOutputRec);
                                            
                                            //  Analyze error code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    if ((0 != JUV_PROB.compareTo(csub31si.getSzCdPlcmtType())) && (0 != TYC.compareTo(csub31si.getSzCdPlcmtType())) && (0 != PACE.compareTo(csub31si.getSzCdPlcmtType()))) {
                                                        csub31so.setUlIdContract(pCSEC72DOutputRec.getUlIdContract());
                                                    }
                                                    
                                                    // SIR#3582: set Indicator to show that a contract was found
                                                    cValidContractFound = INDICATOR_YES;
                                                    csub31so.setBIndChkd(INDICATOR_YES);
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    
                                                    // SIR#3582: set Indicator to show that no contract was found
                                                    cValidContractFound = Cint14s.INDICATOR_NO;
                                                    csub31so.setBIndChkd(Cint14s.INDICATOR_NO);
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                        }
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Call DAM
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        
                                        // SIR#3582: set Indicator to show that no contract was found
                                        cValidContractFound = Cint14s.INDICATOR_NO;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                        }
                        break;
                        
                        // 
                        // (END): CLSS70D - List retrieval of Contract rows for and id resource.
                        // 
                        
                        
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            if (Cint14s.INDICATOR_NO == cValidContractFound) {
                csub31so.setBSysIndGeneric(INDICATOR_YES);
            }
            
            //  If a contract was found DO NOT set the Generic Indicator to YES.
            // bSysIndGeneric is set to YES to Display that a contract was not found.
            else {
                csub31so.setBSysIndGeneric(Cint14s.INDICATOR_NO);
                
                if ((0 == JUV_PROB.compareTo(csub31si.getSzCdPlcmtType())) || (0 == TYC.compareTo(csub31si.getSzCdPlcmtType())) || (0 == PACE.compareTo(csub31si.getSzCdPlcmtType()))) {
                    // 
                    // (BEGIN): Retrieve DAM: csec73d   Contract Rtrv for TYC/JPC/PACE 
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSEC73DInputRec = new CSEC73DI();
                    
                    pCSEC73DOutputRec = new CSEC73DO();
                    pCSEC73DInputRec.setArchInputStruct(csub31si.getArchInputStruct());
                    pCSEC73DInputRec.setDtDtPlcmtStart(csub31si.getDtDtPlcmtStart());
                    
                    if (0 == JUV_PROB.compareTo(csub31si.getSzCdPlcmtType())) {
                        pCSEC73DInputRec.setSzNmBatchParameter(JPC_VENDOR_ID);
                    }
                    else if (0 == TYC.compareTo(csub31si.getSzCdPlcmtType())) {
                        pCSEC73DInputRec.setSzNmBatchParameter(TYC_VENDOR_ID);
                    }
                    else if (0 == PACE.compareTo(csub31si.getSzCdPlcmtType())) {
                        pCSEC73DInputRec.setSzNmBatchParameter(PACE_VENDOR_ID);
                    }
                    rc = csec73dQUERYdam(sqlca, pCSEC73DInputRec, pCSEC73DOutputRec);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            csub31so.setUlIdContract(pCSEC73DOutputRec.getUlIdContract());
                            csub31so.setBSysIndNoDataFound(Cint14s.INDICATOR_NO);
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            rc = WtcHelperConstants.ARC_SUCCESS;// No other approvers to invalidate
                            csub31so.setBSysIndNoDataFound(INDICATOR_YES);
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
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
        ARC_PRFServiceStopTime_TUX(csub31si.getArchInputStruct() , csub31so.getArchOutputStruct());
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
        return csub31so;
    }

    static int CallCCMN44D(CSUB31SI pInputMsg839, CSUB31SO * pOutputMsg784, Arcxmlerrors.TUX_DECL_STATUSPARMS, FndInt3date dtTempYearBorn) {
        int rc = 0;
        int i429 = 0;
        /* local variables */
        
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN44DInputRec = new CCMN44DI();
        
        pCCMN44DOutputRec = new CCMN44DO();
        
        pCCMN44DInputRec.setArchInputStruct(pInputMsg839.getArchInputStruct());
        pCCMN44DInputRec.setUlIdPerson(pInputMsg839.getUlIdPlcmtChild());
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                dtTempYearBorn = pCCMN44DOutputRec.getDtDtPersonBirth();
                
                // 
                // End Call to Stage Closure Dam - CAUD47D
                // 
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

}
