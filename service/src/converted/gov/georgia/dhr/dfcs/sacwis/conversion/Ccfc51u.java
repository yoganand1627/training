package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC51UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC51UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD75DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC59DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES75DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES77DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES77DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC70DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC70DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV74DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:   CCFC51U.src
**
** Service Name:  CCFC51U
**
** Description:   The Calculate Case Retention Date common function will
**                calculate the purge date for the electronic case file.
**                This calculation will mostly be derived from the stages
**                within the case.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 17, 1996
**
** Programmer:    Elizabeth P. Crystal
**
** Archive Information: $Revision:   1.4  $
**                      $Date:   21 Jan 1998 21:55:30  $
**                      $Modtime:   21 Jan 1998 19:32:28  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
** 01/13/04    BRAUCHS  IMPACT CCL/RCL Purge Project
**                      Added Record Retention Types of:
**                      LRO - Licensing - Disposition is Ruled Out (R/O)
**                      LUT	- Licensing - Disposition is Unable to Determine (UTD) or Moved (MOV)
**                      LRB	- Licensing - Disposition is Reason to Believe (RTB)
**                      LAD	- Licensing - Disposition is Administratively Closed (ADM)
**                      The overall disposition is retrieved from the Licensing Investigation
**                      Conclusion table via DAM CINV74D. Depending on the Disposition, one of the above
**                      retention types is applied.
**                      Search for "SPB" to find new code. Added case for RCL and CCL records.
**
** 3/11/96    CRYSTAEP  SIR #3743 - Inserted code to account for Service
**                      Delivery stages with and without the GUA (GUARDIANSHIP)
**                      Stage Type.  The ASR (Comm Service - No Guardianship)
**                      Code Type was introduced to account for a CdStage
**                      of "SVC" and a CdStageType of "GUA". The APG Code Type
**                      now represents a CdStage of "SVC" and a CdStageType
**                      which does not equal "GUA".  The AOC (APS Aging Out
**                      Child) Code Type was introduced to account for a
**                      CdStage which equals "AOC".  Code was also inserted
**                      to set a code type of IRC (Information
**                      Nd Referral Calls/NCRSR) for a CdStage of INR.
**
** 3/14/96   CRYSTAEP   The code for IRC (see above) was commented out
**                      because it is not case related, and this function
**                      is dependent upon an ID CASE. The IRC Code Type has
**                      been marked as an issue.
**
** 3/14/96   CRYSTAEP   SIR #3938 For Case Related Special Requests, the edit
**                      check was changed from a check that CdStage == SPC to
**                      a check that CdStageType begins with 'C-'.
**                      All Case Related Special Requests will have a
**                      Stage Type beginning with 'C-'.
**
** 3/18/96   CRYSTAEP   SIR #3932 For APS when checking Service Delivery
**                      stages, added logic to call DAM CSES77D to check the
**                      following: CD_GUARD_GUARDIAN_TYPE must equal
**                      APS or Contracted (APS or CON from Codes Table
**                      GUARTYP), CD_GUARD_CLOSE_REASON must not equal
**                      Recorded in Error (REC from Codes Table GARCLOS).
**                      If the latter conditions are met, retrieve the
**                      Code Type and Retention Period for APG - Guardianship.
**                      If the above conditions are not met but CdStage is
**                      still Service Delivery for APS, set the Code Type
**                      and Retention Period for ASR - Comm. Service -
**                      No Guardianship. This SIR is related to SIR 3743.
**
** 3/18/96  CRYSTAEP    SIR #3936 Logic for CIU and CIO edit checks will now
**                      check the RISK_ASSESSMENT table to determine risk
**                      factors associated with the case.
**                      The DAM CSES66D was changed to retrieve a
**                      count of rows from the RISK_ASSESSMENT table where
**                      CD_RISK_ASSMT_RISK_FIND = host:CD_RISK_ASSMT_RISK_FIND.
**                      The DAM previously was retrieving a count from the
**                      RISK_FACTORS table.  The new DAM will allow proper
**                      edit checks for Investigation stages.
**
** 3/19/96  CRYSTAEP    Changed code to allow DtCaseRetention and
**                      CodeTypeRetention to be set to CalculatedRetentionDate
**                      and CodeTypeTemp if CalculatedRetentionDate is >= to
**                      the DtCaseRetention. Previously, a new retention
**                      period and code type would replace the previous
**                      stage's retention period and code type only if the
**                      new data was greater than (instead of >=)
**                      the old data. This allowed a code type to be saved
**                      for the retention period that did not correspond
**                      to the most recent stage.
**
** 3/22/96  CRYSTAEP    DAM CSEC63D - REC RETEN YOUNGEST CHILD was modified
**                      to search for a CD_STAGE_PERS_TYPE of PRN instead of
**                      the role of PC for all children in the stage of the
**                      case.  It will retrieve the max date of birth from
**                      those children to determine if the retention
**                      period should be extended until the youngest
**                      child turns 18.  The DAM input message
**                      will now be populated with the ID STAGE from DAM
**                      CLSC59D instead of ID CASE.
**
** 3/23/96  CRYSTAEP    Changed ADOPTION_STG from "ADS" to "ADO".
**
** 3/25/96  CRYSTAEP    SIR #2444 - The logic for Case Related Special
**                      Requests was inserted into a separate "if" statement
**                      to ensure that it would not override other retention
**                      periods.
**
** 3/27/96  CRYSTAEP    SIR #4285 - Added logic for Post Adoption cases
**                      without conservatorship.
**
** 3/27/96  CRYSTAEP    SIR #4286 - Added logic for a new code for
**                      Adoption Cases that deals with a placement that
**                      has been end dated, or no placement.
**                      Added DAM CSEC70D to determine whether placements
**                      exists for stage and if the placements are end dated.
**                      The new code will correspond to Code Type
**                      AHR (Adoptive Home Record).The old AHR Code Type has
**                      been changed to AHC (Adoptive Home- Consummated).
**
**  4/4/96  CRYSTAEP    Added logic and a call to DAM CSEC08D to account
**                      for Intakes - Not Assigned for Investigation (CWA).
**                      If no rows returned from DAM, then the case will
**                      be CWA because there is no stage progressed to after
**                      the Intake.
**  4/26/96 WALLACBE    SIR #20714 - Added RECRETN Cobol/C interface function
**                      so that the call to RecordsRection() that it makes
**                      is resolvable.
**
**  4/30/96 CRYSTAEP    SIR #20787 - The calculated retention date will now
**                      be based off of the date the last stage in the case
**                      closed instead of the date the case closed.  This
**                      change will allow the calculation of an accurate
**                      retention date for merged cases.
**
**  12/4/96  GONZALCE   SIR# 21809 - Previouosly, Records Retention would only
**                      call REQ_FUNC_CD_ADD.  This change
**                      included adding an if/else statement to check
**                      pInputMsg->cIndRuloutOrAdm to see if the  case is
**                      in Admin Review.  If the case is in Admin Rewiew
**                      REQ_FUNC_CD_UPDATE is called, if not, REQ_FUNC_CD_ADD
**                      is called.  cIndRuloutOrAdm was added as an input variable
**                      using Foundation into the ccfc51ui.h file.
**
** 01/21/98  HENDERCR   SIR# 14420 - Incorrect Records Retention type set when
**                      risk assessment saved and then modified to another
**                      finding.  The code previously had the following constant
**                      defined:  SIGNIFICANT_RISK_FACTORS_IDENTIFIED
**                      with a value of 02.  Within the Risk Assessment window,
**                      if the users selected FACTORS CONTROLLED as the risk
**                      finding, a value of 02 (risk finding)would be assigned
**                      to the RISK_ASSESSMENT table for that stage.  If the stage
**                      had an overall disposition of R/O and if there was a risk
**                      finding = 01 (RISK_FACTORS_IDENTIFIED) the retention type
**                      would be set to CIR, else if the stage had an overall
**                      disposition of R/O and if their was a risk finding = 02
**                      (SIGNIFICANT_RISK_FACTORS_IDENTIFIED) the retention type
**                      would be INCORRECTLY set to CIR.
**
**                      The code was modified for the following changes.
**                      The else portion of assigning the records retention
**                      type to CIR when the risk finding was SIGNIFICANT_
**                      RISK_FACTORS_IDENTIFIED was removed.  The constant
**                      SIGNIFICANT_RISK_FACTORS_IDENTIFIED (02) was removed.
**                      The following two constants were added:  FACTORS_
**                      CONTROLLED (02) and RISK_ASSESSMENT_N\A (04).
**                      Two additional calls to dam CSES66D (Risk Assessment)
**                      were added for assigning records retention type CIU:
**                      FACTORS_CONTROLLED and RISK_ASSESSMENT_N\A.
** 07/14/04  DEJUANR    SIR 22983 - The FAMILY_MOVED - MOV dispostion was end dated and 
**                      replaced with UNABLE_TO_COMPLETE - UTC.  MOV has been left in the 
**                      code, but UTC has been added everywhere it is found and is replicating
**                      MOV's behaviour.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/**************************************************************************
** Service Macro Definitions
***************************************************************************/



/**************************************************************************
** Function Prototypes
***************************************************************************/
public class Ccfc51u {
    public static final int PAGE_SIZE_NUMBER = 100;
    public static final String INVEST_STAGE = "INV";
    public static final String NULL_STG_CLOSURE_REASON = "000";
    public static final String SPECIAL_REQUEST_STAGE_TYPE = "C-";
    public static final String FAMILY_PRESERVATION_STG = "FPR";
    public static final String SERVICE_DELIVERY_STG = "SVC";
    public static final String FAM_REUN_STG = "FRE";
    public static final String SUB_CARE_STG = "SUB";
    public static final String ADOPTION_STG = "ADO";
    public static final String ADOPTION_HOME_STG = "FAD";
    public static final String POST_ADOPTION_STG = "PAD";
    public static final String GUARD_GUARDIAN_TYPE_CONTRACTED = "CON";
    public static final String GUARD_CLOSE_REASON_REC_IN_ERROR = "REC";
    public static final String APS_AGING_OUT_CHILD_STG = "AOC";
    public static final String INTAKE_NOT_ASSIGNED_INVEST_STG = "INT";
    public static final String LEGAL_RISK = "L";
    public static final String FOSTER = "F";
    public static final String FOSTER_ADOPTIVE = "G";
    public static final String RULED_OUT = "R/O";
    public static final String DISPOSITION_RULED_OUT = "03";
    public static final String LICENSING_RULED_OUT = "LRO";
    public static final String LICENSING_UTD_MOVED = "LUT";
    public static final String LICENSING_REASON_TO_BELIEVE = "LRB";
    public static final String LICENSING_ADMINISTRATIVELY_CLOSED = "LAD";
    public static final String INVEST_CLOSED_NO_RISK = "CIU";
    public static final String INVEST_CLOSED_WITH_RISK = "CIR";
    public static final String INVEST_CLOSED_OTHER_RSNS = "CIO";
    public static final String INVEST_COMMUNITY = "ACP";
    public static final String INVEST_COMMUNITY_ADMIN_REV = "APR";
    public static final String INVEST_CLOSED_AFTER_ASSN = "CAA";
    public static final String CODE_SPECIAL_REQUEST = "CCR";
    public static final String CODE_FAMILY_PRESERVATION = "OPS";
    public static final String CODE_GUARDIANSHIP = "APG";
    public static final String CODE_INFO_ND_REFERRAL_CALLS = "IRC";
    public static final String CODE_COMM_SERV_NO_GUARD = "ASR";
    public static final String CODE_FAM_REUN_SUB_CARE = "CVS";
    public static final String CODE_ADOPTION = "ACH";
    public static final String CODE_ADOPTION_HOME_INQUIRY = "AHI";
    public static final String CODE_ADOPTION_HOME_CONSUMMATED = "AHC";
    public static final String CODE_ADOPTION_HOME_RECORD = "AHR";
    public static final String CODE_POST_ADOPTION = "PAR";
    public static final String CODE_FOSTER_ADOPTIVE_INQUIRY = "FHI";
    public static final String CODE_FOSTER_ADOPTIVE = "FHR";
    public static final String CODE_INVEST_FACILITY = "APF";
    public static final String CODE_INTAKE_NOT_ASSIGNED_INVEST = "CWA";
    public static final String RISK_FACTORS_IDENTIFIED = "01";
    public static final String FACTORS_CONTROLLED = "02";
    public static final String NO_SIGNIFICANT_RISK_FACTORS = "03";
    public static final String RISK_ASSESSMENT_NA = "04";
    public static final String FAMILY_MOVED = "MOV";
    public static final String UNABLE_TO_COMPLETE = "UTC";
    public static final String REASON_TO_BELIEVE = "RTB";
    public static final String UNABLE_TO_DETERMINE = "UTD";
    public static final String ADMINISTRATIVELY_CLOSED = "ADM";
    public static final int YOUNGEST_CHILD_DATE = 18;
    public static final int POST_ADOPT_AGE = 22;
    
    /*
    ** SIR 21809
    */
    public static final char ADMIN_REVIEW_YES = 'Y';
    public static final char ADMIN_REVIEW_NO = 'N';
    public static final String ADMIN_REVIEW = "ARI";
    static int RecordsRetention(CCFC51UI pInputMsg58, CCFC51UO pOutputMsg60, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i67 = 0;
        int rc = 0;
        int lRC3 = 0;
        FndInt3date dtDtCaseRetention = null;/* Case Retention Date */
        FndInt3date dtTempDtCaseClosed = null;/* Temporary Date Case Closed */
        FndInt3date dtCalculatedRetentionDate = null;/* Calculated Retention Date */
        FndInt3date dtTempStageClosed = null;/* SIR 20787 */
        FndInt3date dtTempDOB1 = null;/* Temporary Date of Birth1 */
        FndInt3date dtTempDOB2 = null;/* Temporary Date of Birth2 */
        FndInt3date dtTempDate = null;/* Temporary Date for Date API */
        FndInt3date dtDtStageClose1 = null;
        FndInt3date dtMaxStageClose = null;/* SIR 20787 */
        int usRowCounter = 0;/* Row counter          */
        int bMoreDataIndicator = 0;/* More Data Indicator  */
        int usTempCounter = 0;/* Loop counter for SIR 20787 */
        int usMaxDateCounter = 0;/* Loop counter for SIR 20787 */
        boolean bCodeSetFlag = false;/* Code Set Flag  */
        String szCodeTypeRetention = new String();/* Retention Code Type  */
        String szCodeTypeTemp = new String();/* Temporary Code Type  */
        int usPageNumber = 0;/* Page Number       */
        
        
        
        
        
        /*
        ** This DAM retrieves ID_PERSON and DT_PERSON_BIRTH (from PERSON table) for
        ** the youngest (DT_PERSON_BIRTH should be the MAX
        ** DOB) Primary Child (CD_STAGE_PERS_ROLE = 'PC'in the
        ** STAGE_PERSON_LINK table) for the case ID given as input.
        ** DAM should search through all the DISTINCT Primary Childs
        ** in the Case (for all the stages in the Case)
        */
        CSEC63DI pCSEC63DInputRec = null;
        CSEC63DO pCSEC63DOutputRec = null;
        
        /*
        ** This DAM will return a count of the RISK_FACTORS records that have
        ** CD_RISK_FACTOR = Input HostRiskFactor and the ID_STAGE = Input Host
        ** Input HostIdStage
        */
        CSES66DI pCSES66DInputRec = null;
        CSES66DO pCSES66DOutputRec = null;
        
        /*
        ** This DAM will return a count of the Admin Review associated
        ** with an ID_STAGE.
        */
        CSES67DI pCSES67DInputRec = null;
        CSES67DO pCSES67DOutputRec = null;
        
        /*
        ** This DAM will return a full row from the REC RETENTION TYPES table
        ** based on CD_RETENTION
        */
        CSES68DI pCSES68DInputRec = null;
        CSES68DO pCSES68DOutputRec = null;
        
        /*
        ** This DAM will add/update/delete a full row from the
        ** RECORDS RETENTION table.
        */
        CAUD75DI pCAUD75DInputRec = null;
        CAUD75DO pCAUD75DOutputRec = null;
        
        /*
        ** This dam retrieves a full row off the Caps_Case table
        */
        CCMND9DI pCCMND9DInputRec = null;
        CCMND9DO pCCMND9DOutputRec = null;
        
        /*
        ** This DAM will retrieve a full row from STAGE
        ** using ID_CASE as the input
        */
        CLSC59DI pCLSC59DInputRec = null;
        CLSC59DO pCLSC59DOutputRec = null;
        
        /*
        ** This DAM will check the Overall Disposition in the CPS INVST DETAIL
        ** table
        */
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        
        /*
        ** This Dam will retrieve a row from CAPS_RESOURCE given ID_STAGE
        */
        CSES41DI pCSES41DInputRec = null;
        CSES41DO pCSES41DOutputRec = null;
        
        /*
        ** This DAM will select a count from RESOURCE_HISTORY of the
        ** CD_RSRC_FA_HOME_STATUS that matches the selection criteria
        */
        CSES75DI pCSES75DInputRec = null;
        CSES75DO pCSES75DOutputRec = null;
        
        /*
        ** SIR #3932 -
        ** This DAM will retrieve a full row from the GUARDIANSHIP table given
        ** an ID CASE.
        */
        CSES77DI pCSES77DInputRec = null;
        CSES77DO pCSES77DOutputRec = null;
        
        /*
        ** SIR #4286 -
        ** This DAM will check to see if a placement for a given stage is closed.
        */
        CSEC70DI pCSEC70DInputRec = null;
        CSEC70DO pCSEC70DOutputRec = null;
        
        /*
        ** Added 4/4/96 -
        ** This DAM will pull a row from STAGE_LINK given an id stage. It will
        ** then join with the stage table to retrieve all columns from the row
        ** where STAGE equals the IdPreviousStage.
        */
        CSEC08DI pCSEC08DInputRec = null;
        CSEC08DO pCSEC08DOutputRec = null;
        /*
        ** Declare local variables
        */
        CINV74DI pCINV74DInputRec = null;
        CINV74DO pCINV74DOutputRec = null;
        usPageNumber = 1;/* Page Number       */
        
        /*
        ** Initialize Function's Local Variables
        */
        
        /*
        ** Case Retention Date
        */
        dtDtCaseRetention.day = DateHelper.NULL_DATE;
        dtDtCaseRetention.month = DateHelper.NULL_DATE;
        dtDtCaseRetention.year = DateHelper.NULL_DATE;
        
        /*
        ** Temporary Date Case Closed
        */
        dtTempDtCaseClosed.day = DateHelper.NULL_DATE;
        dtTempDtCaseClosed.month = DateHelper.NULL_DATE;
        dtTempDtCaseClosed.year = DateHelper.NULL_DATE;
        
        /*
        ** Calculated Retention Date
        */
        dtCalculatedRetentionDate.day = DateHelper.NULL_DATE;
        dtCalculatedRetentionDate.month = DateHelper.NULL_DATE;
        dtCalculatedRetentionDate.year = DateHelper.NULL_DATE;
        
        /*
        ** Temporary Date of Birth1
        */
        dtTempDOB1.day = DateHelper.NULL_DATE;
        dtTempDOB1.month = DateHelper.NULL_DATE;
        dtTempDOB1.year = DateHelper.NULL_DATE;
        
        /*
        ** Temporary Date of Birth2
        */
        dtTempDOB2.day = DateHelper.NULL_DATE;
        dtTempDOB2.month = DateHelper.NULL_DATE;
        dtTempDOB2.year = DateHelper.NULL_DATE;
        
        /*
        ** Temporary Date for ARC_UTLAddToDate API;
        ** TempDate is used to hold sNbrRecRtnTypeYear and sNbrRecRtnTypeMnth
        ** in order to compute the dtCalculatedRetentionDate
        */
        dtTempDate.day = 0;
        dtTempDate.month = 0;
        dtTempDate.year = 0;
        dtDtStageClose1.day = DateHelper.NULL_DATE;
        dtDtStageClose1.month = DateHelper.NULL_DATE;
        dtDtStageClose1.year = DateHelper.NULL_DATE;
        
        /*
        ** SIR 20787 - Date to hold date last stage closed
        */
        dtMaxStageClose.day = DateHelper.NULL_DATE;
        dtMaxStageClose.month = DateHelper.NULL_DATE;
        dtMaxStageClose.year = DateHelper.NULL_DATE;
        
        /*
        ** SIR 20787 - Temp Date to hold date last stage closed
        */
        dtTempStageClosed.day = DateHelper.NULL_DATE;
        dtTempStageClosed.month = DateHelper.NULL_DATE;
        dtTempStageClosed.year = DateHelper.NULL_DATE;
        usRowCounter = 0;/* Row counter          */
        usTempCounter = 0;/* SIR 20787            */
        usMaxDateCounter = 0;/* SIR 20787            */
        bMoreDataIndicator = 1;/* More Data Indicator  */
        bCodeSetFlag = false;/* Code Set Flag        */
        szCodeTypeRetention = "";
        szCodeTypeTemp = "";
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures for all DAMS
        ** used by function
        */
        
        /*
        ** Allocate memory for DAM CCMND9D Input and Output Structures
        */
        pCCMND9DInputRec = new CCMND9DI();
        
        pCCMND9DOutputRec = new CCMND9DO();
        
        /*
        ** Allocate memory for DAM CLSC59D Input and Output Structures
        */
        pCLSC59DInputRec = new CLSC59DI();
        
        pCLSC59DOutputRec = new CLSC59DO();
        
        
        /*
        ** Allocate memory for DAM CINV95D Input and Output Structures
        */
        pCINV95DInputRec = new CINV95DI();
        
        pCINV95DOutputRec = new CINV95DO();
        
        /*
        ** Allocate memory for DAM CSES66D Input and Output Structures
        */
        pCSES66DInputRec = new CSES66DI();
        
        pCSES66DOutputRec = new CSES66DO();
        
        /*
        ** Allocate memory for DAM CSES68D Input and Output Structures
        */
        pCSES68DInputRec = new CSES68DI();
        
        pCSES68DOutputRec = new CSES68DO();
        
        /*
        ** Allocate memory for DAM CSES67D Input and Output Structures
        */
        pCSES67DInputRec = new CSES67DI();
        
        pCSES67DOutputRec = new CSES67DO();
        
        /*
        ** Allocate memory for DAM CSEC63D Input and Output Structures
        */
        pCSEC63DInputRec = new CSEC63DI();
        
        pCSEC63DOutputRec = new CSEC63DO();
        
        /*
        ** Allocate memory for DAM CSES41D Input and Output Structures
        */
        pCSES41DInputRec = new CSES41DI();
        
        pCSES41DOutputRec = new CSES41DO();
        
        /*
        ** Allocate memory for DAM CSES75D Input and Output Structures
        */
        pCSES75DInputRec = new CSES75DI();
        
        pCSES75DOutputRec = new CSES75DO();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD75DInputRec = new CAUD75DI();
        
        pCAUD75DOutputRec = new CAUD75DO();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES77DInputRec = new CSES77DI();
        
        pCSES77DOutputRec = new CSES77DO();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSEC70DInputRec = new CSEC70DI();
        
        pCSEC70DOutputRec = new CSEC70DO();
        
        pCSEC08DInputRec = new CSEC08DI();
        
        pCSEC08DOutputRec = new CSEC08DO();
        
        /*
        ** Allocate memory for DAM CINV74D Input and Output Structures
        */
        pCINV74DInputRec = new CINV74DI();
        
        pCINV74DOutputRec = new CINV74DO();
        pCCMND9DInputRec.setUlIdCase(pInputMsg58.getUlIdCase());
        rc = ccmnd9dQUERYdam(sqlca, pCCMND9DInputRec, pCCMND9DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set local variable DtCaseRetention to CCMND9DO DtCaseClosed
                // dtDtCaseRetention.day    = dtTempStageClosed.day;
                // dtDtCaseRetention.month  = dtTempStageClosed.month;
                // dtDtCaseRetention.year   = dtTempStageClosed.year;
                
                //  Call DAM CLSC59D - STAGE RTRV LSC to retrieve a full row from the
                // STAGE table for each ID STAGE related to the Input ID_CASE
                while (bMoreDataIndicator) {
                    pCLSC59DInputRec.setUlIdCase(pInputMsg58.getUlIdCase());
                    pCLSC59DInputRec.getArchInputStruct().setUsPageNbr(usPageNumber);
                    pCLSC59DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NUMBER);
                    rc = clsc59dQUERYdam(sqlca, pCLSC59DInputRec, pCLSC59DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set local variable MoreDataIndicator to CLSC59DO
                            // MoreDataIndicator
                            bMoreDataIndicator = pCLSC59DOutputRec.getArchOutputStruct().getBMoreDataInd();
                            
                            
                            //  Set local variable DtCaseRetention to CLSC59DO
                            // DtStageClose of 1st stage retrieved.
                            dtDtCaseRetention.day = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(0).getDtDtStageClose().day;
                            dtDtCaseRetention.month = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(0).getDtDtStageClose().month;
                            dtDtCaseRetention.year = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(0).getDtDtStageClose().year;
                            
                            //  SIR 20787 - Perform looping logic to retrieve the
                            // date the last stage closed.
                            while (usTempCounter < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty()) {
                                
                                if (0 != pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usTempCounter).getSzCdStage().compareTo(ADMIN_REVIEW)) {
                                    dtDtStageClose1.day = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usTempCounter).getDtDtStageClose().day;
                                    dtDtStageClose1.month = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usTempCounter).getDtDtStageClose().month;
                                    dtDtStageClose1.year = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usTempCounter).getDtDtStageClose().year;
                                    
                                    //  Set dtMaxStageClose to currently greatest stage closure date
                                    dtMaxStageClose.day = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usMaxDateCounter).getDtDtStageClose().day;
                                    dtMaxStageClose.month = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usMaxDateCounter).getDtDtStageClose().month;
                                    dtMaxStageClose.year = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usMaxDateCounter).getDtDtStageClose().year;
                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtDtStageClose1, (char) 0, (FndInt3date) & dtMaxStageClose, (char) 0);
                                    if (lRC3 > 0) {
                                        //  Set MaxDate Counter to TempCounter
                                        usMaxDateCounter = usTempCounter;
                                        
                                        //  Set local variable DtCaseRetention to dtMaxStageClose
                                        dtDtCaseRetention.day = dtDtStageClose1.day;
                                        dtDtCaseRetention.month = dtDtStageClose1.month;
                                        dtDtCaseRetention.year = dtDtStageClose1.year;
                                    }
                                }
                                usTempCounter++;
                            }
                            
                            
                            //  Set dtTempStageClosed to dtDtCaseRetention
                            dtTempStageClosed.day = dtDtCaseRetention.day;
                            dtTempStageClosed.month = dtDtCaseRetention.month;
                            dtTempStageClosed.year = dtDtCaseRetention.year;
                            
                            // end SIR 20787
                            
                            //  Perform Record's Retention Logic
                            for (usRowCounter = 0;usRowCounter < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();usRowCounter++) {
                                
                                if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(INVEST_STAGE) != 0)) {
                                    
                                    //  Set Flag to FALSE
                                    bCodeSetFlag = false;
                                    
                                    if (!bCodeSetFlag) {
                                        
                                        if (pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageReasonClosed().compareTo(NULL_STG_CLOSURE_REASON) != 0 &&!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS) != 0)) {
                                            pCINV95DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                            rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
                                            
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    //## END TUX/XML: Turn the XML buffer into an input message struct
                                                    
                                                    
                                                    
                                                    if (!(pCINV95DOutputRec.getCdCpsOverallDisptn().compareTo(RULED_OUT) != 0)) {
                                                        pCSES66DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                        pCSES66DInputRec.setSzCdRiskFactor(NO_SIGNIFICANT_RISK_FACTORS);
                                                        rc = cses66dQUERYdam(sqlca, pCSES66DInputRec, pCSES66DOutputRec);
                                                        
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                // 
                                                                // Call DAMs to retrieve data
                                                                // 
                                                                //  PWO 663 - Change code structure to ensure that the system date
                                                                // will be returned even if no rows are found.
                                                                
                                                                //  If StageID array is passed as InputMsg then call DAM F9
                                                                if (pCSES66DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                                    //  Set CodeSetFlag = TRUE
                                                                    bCodeSetFlag = true;
                                                                    szCodeTypeTemp = INVEST_CLOSED_NO_RISK;
                                                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                                    
                                                                    switch (rc) {
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                                            pServiceStatus.explan_code = SUCCESS;
                                                                            if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                                dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                                dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                                dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                            }
                                                                            
                                                                            
                                                                            //  Set CalculatedRetentionDate =
                                                                            // CCMND9DO.DtCaseClosed +
                                                                            // CSES68DO.NbrRecRetentionYear +
                                                                            // CSES68DO.NbrRecRetentionMnth
                                                                            else {
                                                                                //  Set dtTempDate to Null
                                                                                dtTempDate.day = 0;
                                                                                dtTempDate.month = 0;
                                                                                dtTempDate.year = 0;
                                                                                
                                                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                                
                                                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                            }
                                                                            lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                            if (lRC3 >= 0) {
                                                                                dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                                dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                                dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                                szCodeTypeRetention = szCodeTypeTemp;
                                                                                
                                                                            }
                                                                            
                                                                            break;
                                                                        case NO_DATA_FOUND:
                                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                            
                                                                            // call DAM
                                                                            rc = Messages.MSG_DETAIL_DELETED;
                                                                            
                                                                            break;
                                                                            
                                                                            
                                                                            //  Default  Case for Dam CSES68D (CIU)
                                                                        default :
                                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                            return rc;
                                                                            break;
                                                                    }
                                                                }
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                // BEGIN SIR 14420
                                                                
                                                                
                                                                //  Call DAM CSES66D 2nd Call for Risk Factor ==
                                                                // FACTORS_CONTROLLED
                                                                else {
                                                                    pCSES66DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                                    pCSES66DInputRec.setSzCdRiskFactor(FACTORS_CONTROLLED);
                                                                    rc = cses66dQUERYdam(sqlca, pCSES66DInputRec, pCSES66DOutputRec);
                                                                    
                                                                    switch (rc) {
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                                            pServiceStatus.explan_code = SUCCESS;
                                                                            
                                                                            //  Analyze error code
                                                                            if (pCSES66DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                                                //  Set CodeSetFlag = TRUE
                                                                                bCodeSetFlag = true;
                                                                                szCodeTypeTemp = INVEST_CLOSED_NO_RISK;
                                                                                pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                                                rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                                                
                                                                                switch (rc) {
                                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                                        if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                                            dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                                            dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                                            dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                                        }
                                                                                        
                                                                                        
                                                                                        //  Set CalculatedRetentionDate =
                                                                                        // CCMND9DO.DtCaseClosed +
                                                                                        // CSES68DO.NbrRecRetentionYear +
                                                                                        // CSES68DO.NbrRecRetentionMnth
                                                                                        else {
                                                                                            //  Set dtTempDate to Null
                                                                                            dtTempDate.day = 0;
                                                                                            dtTempDate.month = 0;
                                                                                            dtTempDate.year = 0;
                                                                                            
                                                                                            dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                                            dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                                            
                                                                                            dtCalculatedRetentionDate = dtTempStageClosed;
                                                                                            
                                                                                            
                                                                                            //  Start Performance Timer
                                                                                            rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                                        }
                                                                                        lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                                        
                                                                                        if (lRC3 >= 0) {
                                                                                            dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                                            dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                                            dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                                            szCodeTypeRetention = szCodeTypeTemp;
                                                                                        }
                                                                                        break;
                                                                                    case NO_DATA_FOUND:
                                                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                                        pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                                        
                                                                                        
                                                                                        
                                                                                        //  Initialize Service Status Fields
                                                                                        
                                                                                        
                                                                                        
                                                                                        //  Perform Main Processing
                                                                                        
                                                                                        //  Set CCFC10SO WCD DtSystemDate to current date
                                                                                        rc = Messages.MSG_DETAIL_DELETED;
                                                                                        break;
                                                                                        
                                                                                        
                                                                                        //  Default  Case for Dam CSES68D (CIU)
                                                                                    default :
                                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                                        return rc;
                                                                                        break;
                                                                                }
                                                                            }
                                                                            
                                                                            
                                                                            
                                                                            
                                                                            
                                                                            //  Call DAM CSES66D 3rd Call for Risk Factor ==
                                                                            // RISK_ASSESSMENT_NA
                                                                            else {
                                                                                pCSES66DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                                                pCSES66DInputRec.setSzCdRiskFactor(RISK_ASSESSMENT_NA);
                                                                                rc = cses66dQUERYdam(sqlca, pCSES66DInputRec, pCSES66DOutputRec);
                                                                                switch (rc) {
                                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                                        if (pCSES66DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                                                            //  Set CodeSetFlag = TRUE
                                                                                            bCodeSetFlag = true;
                                                                                            szCodeTypeTemp = INVEST_CLOSED_NO_RISK;
                                                                                            pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                                                            rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                                                            
                                                                                            switch (rc) {
                                                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                                                    if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                                                        dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                                                        dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                                                        dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                                                    }
                                                                                                    
                                                                                                    
                                                                                                    //  Set CalculatedRetentionDate =
                                                                                                    // CCMND9DO.DtCaseClosed +
                                                                                                    // CSES68DO.NbrRecRetentionYear +
                                                                                                    // CSES68DO.NbrRecRetentionMnth
                                                                                                    else {
                                                                                                        //  Set dtTempDate to Null
                                                                                                        dtTempDate.day = 0;
                                                                                                        dtTempDate.month = 0;
                                                                                                        dtTempDate.year = 0;
                                                                                                        
                                                                                                        dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                                                        dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                                                        
                                                                                                        dtCalculatedRetentionDate = dtTempStageClosed;
                                                                                                        
                                                                                                        
                                                                                                        //  Call CINT21D
                                                                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                                                    }
                                                                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                                                    if (lRC3 >= 0) {
                                                                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                                                                    }
                                                                                                    break;// CAUD35D
                                                                                                case NO_DATA_FOUND:
                                                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                                                                    
                                                                                                    break;
                                                                                                    
                                                                                                    
                                                                                                    //  Default  Case for Dam CSES68D (CIU)
                                                                                                default :
                                                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                                                    
                                                                                                    return rc;
                                                                                                    break;// CSYS08D
                                                                                            }
                                                                                        }
                                                                                }
                                                                            }
                                                                    }
                                                                }
                                                                
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                break;// CINV43D
                                                                
                                                                //  Default Case for DAM CSES66D (CIU)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                
                                                                
                                                                break;
                                                        }
                                                    }
                                                    
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    
                                                    //  Call CCMN45D
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    
                                                    break;
                                                    
                                                    //  Default Case for DAM CINV95D (CIU)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    
                                                    // 
                                                    // (END): CSES07D
                                                    // 
                                                    
                                                    break;
                                            }
                                        }
                                    }
                                    if (!bCodeSetFlag) {
                                        
                                        if (pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageReasonClosed().compareTo(NULL_STG_CLOSURE_REASON) != 0 &&!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS) != 0)) {
                                            pCINV95DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                            rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
                                            
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    if (!(pCINV95DOutputRec.getCdCpsOverallDisptn().compareTo(RULED_OUT) != 0)) {
                                                        pCSES66DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                        pCSES66DInputRec.setSzCdRiskFactor(RISK_FACTORS_IDENTIFIED);
                                                        rc = cses66dQUERYdam(sqlca, pCSES66DInputRec, pCSES66DOutputRec);
                                                        
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                if (pCSES66DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                                    //  Set CodeSetFlag = TRUE
                                                                    bCodeSetFlag = true;
                                                                    szCodeTypeTemp = INVEST_CLOSED_WITH_RISK;
                                                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                                    
                                                                    
                                                                    //  Call CLSS44D
                                                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                                    
                                                                    
                                                                    
                                                                    //  Analyze return code
                                                                    switch (rc) {
                                                                            
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                                            pServiceStatus.explan_code = SUCCESS;
                                                                            
                                                                            if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                                dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                                dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                                dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                            }
                                                                            
                                                                            
                                                                            
                                                                            //  Set CalculatedRetentionDate =
                                                                            // CCMND9DO.DtCaseClosed +
                                                                            // CSES68DO.NbrRecRetentionYear +
                                                                            // CSES68DO.NbrRecRetentionMnth
                                                                            else {
                                                                                //  Set dtTempDate to Null
                                                                                dtTempDate.day = 0;
                                                                                dtTempDate.month = 0;
                                                                                dtTempDate.year = 0;
                                                                                
                                                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                                
                                                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                                                
                                                                                
                                                                                //  Set rc to ARC_SUCCESS
                                                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                                
                                                                                if (lRC3 >= 0) {
                                                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                                                }
                                                                            }
                                                                            
                                                                            break;
                                                                            
                                                                        case NO_DATA_FOUND:
                                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                            
                                                                            //  Set rc to ARC_SUCCESS
                                                                            rc = Messages.MSG_DETAIL_DELETED;
                                                                            
                                                                            break;
                                                                            
                                                                            //  Default Case for DAM CSES68D (CIR)
                                                                        default :
                                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                            return rc;
                                                                            
                                                                            // 
                                                                            // (END): CAUD37D
                                                                            // 
                                                                            break;
                                                                    }
                                                                }
                                                                
                                                                
                                                                break;
                                                                
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                
                                                                //  Set rc to ARC_SUCCESS
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                
                                                                break;
                                                                
                                                                
                                                                
                                                                //  Default Case for DAM CSES66D Call (CIR)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                
                                                                return rc;
                                                                
                                                                break;
                                                        }
                                                    }
                                                    
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    
                                                    break;
                                                    
                                                    //  Default Case for DAM CINV95D (CIR)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    
                                                    // Return the return code to the calling routine
                                                    return rc;
                                                    
                                                    break;
                                            }
                                        }
                                    }
                                    
                                    if (!bCodeSetFlag) {
                                        if (pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageReasonClosed().compareTo(NULL_STG_CLOSURE_REASON) != 0 &&!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS) != 0)) {
                                            pCINV95DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                            rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
                                            switch (rc) {
                                                    
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    if (!(pCINV95DOutputRec.getCdCpsOverallDisptn().compareTo(FAMILY_MOVED) != 0) ||!(pCINV95DOutputRec.getCdCpsOverallDisptn().compareTo(UNABLE_TO_COMPLETE) != 0) ||!(pCINV95DOutputRec.getCdCpsOverallDisptn().compareTo(REASON_TO_BELIEVE) != 0) ||!(pCINV95DOutputRec.getCdCpsOverallDisptn().compareTo(UNABLE_TO_DETERMINE) != 0)) {
                                                        
                                                        //  Set CodeSetFlag = TRUE
                                                        bCodeSetFlag = true;
                                                        szCodeTypeTemp = INVEST_CLOSED_OTHER_RSNS;
                                                        
                                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                        
                                                        //  Analyze return code
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                
                                                                //  Set CalculatedRetentionDate =
                                                                // CCMND9DO.DtCaseClosed +
                                                                // CSES68DO.NbrRecRetentionYear +
                                                                // CSES68DO.NbrRecRetentionMnth
                                                                
                                                                //  Set dtTempDate to Null
                                                                dtTempDate.day = 0;
                                                                dtTempDate.month = 0;
                                                                dtTempDate.year = 0;
                                                                
                                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                
                                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                                
                                                                //  Start Performance Timer
                                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                pCSEC63DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                                
                                                                
                                                                
                                                                //  Initialize Service Status Fields
                                                                
                                                                
                                                                
                                                                //  Perform Main Processing
                                                                
                                                                
                                                                //  Set CFIN02SO dtScrDtCurrentDate to current date
                                                                rc = csec63dQUERYdam(sqlca, pCSEC63DInputRec, pCSEC63DOutputRec);
                                                                
                                                                //  Analyze error code
                                                                switch (rc) // 
                                                                // Function Name: CalcAge
                                                                // Description:   This function will calculate the Age of a person given a
                                                                // DOB and the system date.
                                                                // 
                                                                {
                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        
                                                                        //  Using API set DtTempDOB1 to
                                                                        // CSEC63DO.dtDtPerson + YOUNGEST_CHILD_DATE years
                                                                        dtTempDOB1.year = YOUNGEST_CHILD_DATE;
                                                                        dtTempDOB1.month = 0;
                                                                        dtTempDOB1.day = 0;
                                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDOB1, (FndInt3date) & pCSEC63DOutputRec.getDtDtPersonBirth());
                                                                        lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtTempDOB1, (char) 0, (FndInt3date) & dtCalculatedRetentionDate, (char) 0);
                                                                        
                                                                        if (lRC3 > 0) 
                                                                        {
                                                                            
                                                                            dtCalculatedRetentionDate = dtTempDOB1;
                                                                        }
                                                                        lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                        
                                                                        if (lRC3 >= 0) {
                                                                            dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                            dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                            dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                            szCodeTypeRetention = szCodeTypeTemp;
                                                                        }
                                                                        
                                                                        
                                                                        break;
                                                                    case NO_DATA_FOUND:
                                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                        pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                        rc = Messages.MSG_DETAIL_DELETED;
                                                                        
                                                                        break;
                                                                        
                                                                        //  Default Case for Dam CSEC63D (CIO)
                                                                    default :
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                        return rc;
                                                                        
                                                                        break;
                                                                }
                                                                
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                
                                                                //  Call CSEC06D 
                                                                // If the window is in NEW mode, the
                                                                // service will call CSEC06D to retrieve information 
                                                                // specific to the contract from CONTRACT, 
                                                                // CAPS RESOURCE, AND RESOURCE ADDRESS.  In modify
                                                                // or BROWSE mode, the DAM will retrieve invoice
                                                                // information from INVOICE, in addition to the
                                                                // former information.
                                                                rc = Messages.MSG_DETAIL_DELETED;
                                                                break;
                                                                
                                                                //  Default Case for Dam CSES68D (CIO)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    //  Set rc to ARC_SUCCESS
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                    //  Default Case for Dam CINV95D (CIO)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                            }
                                        }
                                    }
                                    if (!bCodeSetFlag) {
                                        if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(CAPS_PROG_APS) != 0)) {
                                            pCSES67DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                            rc = cses67dQUERYdam(sqlca, pCSES67DInputRec, pCSES67DOutputRec);
                                            
                                            //  Analyze error code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    if (pCSES67DOutputRec.getUlSysNbrGenericCntr() == 0) {
                                                        //  Set CodeSetFlag to TRUE
                                                        bCodeSetFlag = true;
                                                        szCodeTypeTemp = INVEST_COMMUNITY;
                                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                        
                                                        //  Analyze error code
                                                        switch (rc) {
                                                                
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                    dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                    dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                    dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                    
                                                                }
                                                                
                                                                
                                                                //  Set CalculatedRetentionDate =
                                                                // CCMND9DO.DtCaseClosed +
                                                                // CSES68DO.NbrRecRetentionYear +
                                                                // CSES68DO.NbrRecRetentionMnth
                                                                else {
                                                                    
                                                                    //  Set dtTempDate to Null
                                                                    dtTempDate.day = 0;
                                                                    dtTempDate.month = 0;
                                                                    dtTempDate.year = 0;
                                                                    
                                                                    dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                    dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                    
                                                                    dtCalculatedRetentionDate = dtTempStageClosed;
                                                                    
                                                                    //  Call DAM
                                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                }
                                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                
                                                                //  Analyze error code
                                                                if (lRC3 >= 0) {
                                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                                }
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                rc = Messages.MSG_DETAIL_DELETED;
                                                                break;
                                                                
                                                                //  Default Case for Dam CSES68D (ACP)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    //  This employee is not a Unit Approver
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                    //  Default Case for Dam CSES67D (ACP)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                            }
                                        }
                                    }
                                    
                                    //  Analyze error code
                                    if (!bCodeSetFlag) {
                                        if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(CAPS_PROG_APS) != 0)) {
                                            pCSES67DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                            rc = cses67dQUERYdam(sqlca, pCSES67DInputRec, pCSES67DOutputRec);
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    if (pCSES67DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                        //  Set CodeSetFlag to TRUE
                                                        bCodeSetFlag = true;
                                                        szCodeTypeTemp = INVEST_COMMUNITY_ADMIN_REV;
                                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                    dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                    dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                    dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                }
                                                                
                                                                
                                                                //  Set CalculatedRetentionDate =
                                                                // CCMND9DO.DtCaseClosed +
                                                                // CSES68DO.NbrRecRetentionYear +
                                                                // CSES68DO.NbrRecRetentionMnth
                                                                else {
                                                                    
                                                                    
                                                                    //  Set dtTempDate to Null
                                                                    dtTempDate.day = 0;
                                                                    dtTempDate.month = 0;
                                                                    dtTempDate.year = 0;
                                                                    
                                                                    dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                    dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                    
                                                                    dtCalculatedRetentionDate = dtTempStageClosed;
                                                                    
                                                                    //  Call DAM
                                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                }
                                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                if (lRC3 >= 0) {
                                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                                }
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                //  Do nothing, the output message just returns success or failure
                                                                rc = Messages.MSG_DETAIL_DELETED;
                                                                break;
                                                                
                                                                //  Default Case for Dam CSES68D (ACP)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    //  This employee does not have any other "OUT" assignments
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                    //  Default Case for Dam CSES67D (ACP)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                            }
                                        }
                                    }
                                    
                                    //  Analyze error code
                                    if (!bCodeSetFlag) {
                                        
                                        //  Analyze error code
                                        if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(CAPS_PROG_AFC) != 0)) {
                                            
                                            //  Set CodeSetFlag to TRUE
                                            bCodeSetFlag = true;
                                            szCodeTypeTemp = CODE_INVEST_FACILITY;
                                            pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                            rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                        dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                        dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                        dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                    }
                                                    
                                                    
                                                    //  Set CalculatedRetentionDate =
                                                    // CCMND9DO.DtCaseClosed +
                                                    // CSES68DO.NbrRecRetentionYear +
                                                    // CSES68DO.NbrRecRetentionMnth
                                                    else {
                                                        
                                                        
                                                        //  Set dtTempDate to Null
                                                        dtTempDate.day = 0;
                                                        dtTempDate.month = 0;
                                                        dtTempDate.year = 0;
                                                        
                                                        dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                        dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                        
                                                        dtCalculatedRetentionDate = dtTempStageClosed;
                                                        
                                                        //  Call DAM
                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                    }
                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                    
                                                    if (lRC3 >= 0) {
                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                    }
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                    break;
                                                    
                                                    //  Default Case for Dam CSES68D (APF)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                                    //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                                    
                                                    
                                            }
                                        }
                                    }
                                    //## END TUX/XML: Turn the XML buffer into an input message struct
                                    
                                    
                                    
                                    if (!bCodeSetFlag) {
                                        if (pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageReasonClosed().compareTo(NULL_STG_CLOSURE_REASON) != 0 && (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(CAPS_PROG_CCL) != 0) ||!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(CAPS_PROG_RCL) != 0))) {
                                            userlog("SPB - Passed 1st IF Reason Closed ! null and either CCL or RCL \n");
                                            pCINV74DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                            rc = cinv74dQUERYdam(sqlca, pCINV74DInputRec, pCINV74DOutputRec);
                                            switch (rc) {
                                                    
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    if (!(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp().compareTo(RULED_OUT) != 0)) {
                                                        userlog("SPB - Disposition is R/O (LRO) \n");
                                                        //  All edits for Code Type LRO are passed so set
                                                        // variables accordingly and calculate stage
                                                        // retention date
                                                        
                                                        //  Set CodeSetFlag = TRUE
                                                        bCodeSetFlag = true;
                                                        szCodeTypeTemp = LICENSING_RULED_OUT;
                                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                        
                                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                        
                                                        //  Analyze error code
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                // 
                                                                // OPTIONAL CODE NOTE (END): Generic AUD
                                                                // 
                                                                
                                                                
                                                                // 
                                                                // OPTIONAL CODE NOTE (BEGIN): Generic AUD
                                                                // 
                                                                //  If the Retention value (RetVal) is FND_SUCCESS and IdPerson of the
                                                                // service input Message is 0, get the Id Person of the stage's primary
                                                                // child.
                                                                
                                                                if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                    dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                    dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                    dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                }
                                                                
                                                                
                                                                //  Set CalculatedRetentionDate
                                                                else {
                                                                    //  Set dtTempDate to Null
                                                                    dtTempDate.day = 0;
                                                                    dtTempDate.month = 0;
                                                                    dtTempDate.year = 0;
                                                                    dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                    dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                    
                                                                    dtCalculatedRetentionDate = dtTempStageClosed;
                                                                    
                                                                    //  Call DAM to retrieve data from the Incoming Detail
                                                                    // table so that we can only update the columns of
                                                                    // interest.
                                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                }
                                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                if (lRC3 >= 0) {
                                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                                }
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                
                                                                // Call DAM
                                                                rc = Messages.MSG_DETAIL_DELETED;
                                                                break;
                                                                
                                                                
                                                                //  Default  Case for Dam CSES68D (LRO)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                break;
                                                        }
                                                    }
                                                    //  Check if the Overall Disposition in the
                                                    // LICENSING_INVST_DTL table is LUT (UTD or MOV)
                                                    // 
                                                    else if (!(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp().compareTo(UNABLE_TO_DETERMINE) != 0) ||!(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp().compareTo(FAMILY_MOVED) != 0) ||!(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp().compareTo(UNABLE_TO_COMPLETE) != 0)) {
                                                        userlog("SPB - Disposition is UTD or MOV (LUT) \n");
                                                        //  All edits for Code Type LRO are passed so set
                                                        // variables accordingly and calculate stage
                                                        // retention date
                                                        
                                                        //  Set CodeSetFlag = TRUE
                                                        bCodeSetFlag = true;
                                                        szCodeTypeTemp = LICENSING_UTD_MOVED;
                                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                        
                                                        //  Analyze error code
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                    dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                    dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                    dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                }
                                                                
                                                                
                                                                //  Set CalculatedRetentionDate
                                                                else {
                                                                    //  Set dtTempDate to Null
                                                                    dtTempDate.day = 0;
                                                                    dtTempDate.month = 0;
                                                                    dtTempDate.year = 0;
                                                                    dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                    dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                    
                                                                    dtCalculatedRetentionDate = dtTempStageClosed;
                                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                }
                                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                if (lRC3 >= 0) {
                                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                                }
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                
                                                                
                                                                // Get the current date
                                                                
                                                                // Even if the DOB is APPROX we need to use it calculate the correct
                                                                // age as the service is not retrieving the most current age.
                                                                rc = Messages.MSG_DETAIL_DELETED;
                                                                break;
                                                                
                                                                
                                                                //  Default  Case for Dam CSES68D (LUT)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                break;
                                                        }
                                                    }
                                                    else if (!(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp().compareTo(REASON_TO_BELIEVE) != 0)) {
                                                        userlog("SPB - Disposition is RTB (LRB) \n");
                                                        //  All edits for Code Type LRO are passed so set
                                                        // variables accordingly and calculate stage
                                                        // retention date
                                                        
                                                        //  Set CodeSetFlag = TRUE
                                                        bCodeSetFlag = true;
                                                        szCodeTypeTemp = LICENSING_REASON_TO_BELIEVE;
                                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                        
                                                        //  Call DAM
                                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                    dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                    dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                    dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                }
                                                                
                                                                
                                                                //  Set CalculatedRetentionDate
                                                                else {
                                                                    //  Set dtTempDate to Null
                                                                    dtTempDate.day = 0;
                                                                    dtTempDate.month = 0;
                                                                    dtTempDate.year = 0;
                                                                    dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                    dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                    
                                                                    dtCalculatedRetentionDate = dtTempStageClosed;
                                                                    
                                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                }
                                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                if (lRC3 >= 0) {
                                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                                }
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                rc = Messages.MSG_DETAIL_DELETED;
                                                                break;
                                                                
                                                                
                                                                //  Default  Case for Dam CSES68D (LRB)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                break;
                                                        }
                                                    }
                                                    else if (!(pCINV74DOutputRec.getSzCdLicngInvstOvrallDisp().compareTo(ADMINISTRATIVELY_CLOSED) != 0)) {
                                                        userlog("SPB - Disposition is ADM (LAD) \n");
                                                        //  All edits for Code Type LAD are passed so set
                                                        // variables accordingly and calculate stage
                                                        // retention date
                                                        
                                                        //  Set CodeSetFlag = TRUE
                                                        bCodeSetFlag = true;
                                                        szCodeTypeTemp = LICENSING_ADMINISTRATIVELY_CLOSED;
                                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                        
                                                        //  Analyze return code
                                                        
                                                        // Sir # 14553 - Added one more condition to the following code to check
                                                        // if the IndDateModified is true .
                                                        
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                
                                                                if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                    dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                    dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                    dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                }
                                                                
                                                                
                                                                //  Set CalculatedRetentionDate
                                                                else {
                                                                    //  Set dtTempDate to Null
                                                                    dtTempDate.day = 0;
                                                                    dtTempDate.month = 0;
                                                                    dtTempDate.year = 0;
                                                                    dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                    dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                    
                                                                    dtCalculatedRetentionDate = dtTempStageClosed;
                                                                    
                                                                    //  Call DAM: select from the Name Table.
                                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                }
                                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                
                                                                // post event processing if Return Value is FND_SUCCESS
                                                                
                                                                if (lRC3 >= 0) {
                                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                                }
                                                                
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                
                                                                rc = Messages.MSG_DETAIL_DELETED;
                                                                break;
                                                                
                                                                
                                                                //  Default  Case for Dam CSES68D (LAD)
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                return rc;
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                    
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                    break;
                                                    
                                                    
                                                    //  Default  Case for Dam CINV74D
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                            }
                                        }
                                    }
                                    if (!bCodeSetFlag) {
                                        
                                        //  Set CodeSetFlag to TRUE
                                        bCodeSetFlag = true;
                                        szCodeTypeTemp = INVEST_CLOSED_AFTER_ASSN;
                                        pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                        rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                        
                                        // Analyze return code
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                    dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                    dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                    dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                }
                                                
                                                
                                                //  Set CalculatedRetentionDate =
                                                // CCMND9DO.DtCaseClosed +
                                                // CSES68DO.NbrRecRetentionYear +
                                                // CSES68DO.NbrRecRetentionMnth
                                                else {
                                                    
                                                    //  Set dtTempDate to Null
                                                    dtTempDate.day = 0;
                                                    dtTempDate.month = 0;
                                                    dtTempDate.year = 0;
                                                    
                                                    dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                    dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                    
                                                    dtCalculatedRetentionDate = dtTempStageClosed;
                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                }
                                                lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                
                                                // DAM inputs if event status is New or NULL
                                                
                                                //  Copy to the Event Person Link Structure based on IdEvent and Event
                                                // Status- modified 11/28/95
                                                
                                                if (lRC3 >= 0) {
                                                    dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                    dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                    dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                    szCodeTypeRetention = szCodeTypeTemp;
                                                }
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                
                                                //  Call DAM
                                                rc = Messages.MSG_DETAIL_DELETED;
                                                break;
                                                
                                                //  Default Case for Dam CSES68D (CAA)
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                return rc;
                                                break;
                                        }
                                    }
                                }
                                
                                
                                
                                
                                
                                //  Calculate Retention Date for Family Preservation
                                // Stage
                                else if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(FAMILY_PRESERVATION_STG) != 0)) {
                                    szCodeTypeTemp = CODE_FAMILY_PRESERVATION;
                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                    
                                    
                                    
                                    // Sir # 15352
                                    
                                    
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Set CalculatedRetentionDate =
                                            // CCMND9DO.DtCaseClosed +
                                            // CSES68DO.NbrRecRetentionYear +
                                            // CSES68DO.NbrRecRetentionMnth
                                            
                                            //  Set dtTempDate to Null
                                            dtTempDate.day = 0;
                                            dtTempDate.month = 0;
                                            dtTempDate.year = 0;
                                            
                                            dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                            dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                            
                                            dtCalculatedRetentionDate = dtTempStageClosed;
                                            rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            pCSEC63DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                            rc = csec63dQUERYdam(sqlca, pCSEC63DInputRec, pCSEC63DOutputRec);
                                            
                                            // Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    //  Using API set DtTempDOB2 to
                                                    // CSEC63DO.dtDtPerson + YOUNGEST_CHILD_DATE years
                                                    dtTempDOB2.year = YOUNGEST_CHILD_DATE;
                                                    dtTempDOB2.month = 0;
                                                    dtTempDOB2.day = 0;
                                                    
                                                    
                                                    //  Call DAM
                                                    rc = ARC_UTLAddToDate((FndInt3date) & dtTempDOB2, (FndInt3date) & pCSEC63DOutputRec.getDtDtPersonBirth());
                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtTempDOB2, (char) 0, (FndInt3date) & dtCalculatedRetentionDate, (char) 0);
                                                    
                                                    if (lRC3 > 0) {
                                                        
                                                        dtCalculatedRetentionDate = dtTempDOB2;
                                                    }
                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                    
                                                    //  Set IdEvent to common function IdEvent if in "add" mode
                                                    // Modified because of dummy event situations
                                                    
                                                    if (lRC3 >= 0) {
                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                    }
                                                    break;
                                                    
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                    break;
                                                    
                                                    //  Default Case for Dam CSEC63D (OPS)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                            }
                                            break;
                                            
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                            rc = Messages.MSG_DETAIL_DELETED;
                                            break;
                                            
                                            //  Default Case for Dam CSES68D (OPS)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            break;
                                    }
                                }
                                
                                
                                
                                
                                //  Calculate retention date for Service Delivery stages
                                // SIR #3743 - Insert to check for SERVICE_DELIVERY_STG
                                // SIR #3932 - Insert logic to check Guard Guardian Type and
                                // Guard Close Reason for an APS Service Delivery stage
                                else if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(SERVICE_DELIVERY_STG) != 0) &&!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(CAPS_PROG_APS) != 0)) {
                                    pCSES77DInputRec.setUlIdCase(pInputMsg58.getUlIdCase());
                                    rc = cses77dQUERYdam(sqlca, pCSES77DInputRec, pCSES77DOutputRec);
                                    //  Analyze return code
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            if ((!(pCSES77DOutputRec.getSzCdGuardGuardianType().compareTo(CAPS_PROG_APS) != 0) ||!(pCSES77DOutputRec.getSzCdGuardGuardianType().compareTo(GUARD_GUARDIAN_TYPE_CONTRACTED) != 0)) && pCSES77DOutputRec.getSzCdGuardCloseReason().compareTo(GUARD_CLOSE_REASON_REC_IN_ERROR) != 0) {
                                                szCodeTypeTemp = CODE_GUARDIANSHIP;
                                                
                                                pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                
                                                // Call DAM
                                                rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                            dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                            dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                            dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                        }
                                                        
                                                        
                                                        //  Set CalculatedRetentionDate =
                                                        // CCMND9DO.DtCaseClosed +
                                                        // CSES68DO.NbrRecRetentionYear +
                                                        // CSES68DO.NbrRecRetentionMnth
                                                        else {
                                                            
                                                            
                                                            //  Set dtTempDate to Null
                                                            dtTempDate.day = 0;
                                                            dtTempDate.month = 0;
                                                            dtTempDate.year = 0;
                                                            
                                                            dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                            dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                            
                                                            dtCalculatedRetentionDate = dtTempStageClosed;
                                                            // pOutputMsg->ArchOutputStruct.bMoreDataInd = 
                                                            // pCCMNH7DOutputRec->ArchOutputStruct.bMoreDataInd;
                                                            
                                                            rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                            
                                                            //## BEGIN TUX/XML: Declare XML variables 
                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                        }
                                                        lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                        if (lRC3 >= 0) {
                                                            dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                            dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                            dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                            szCodeTypeRetention = szCodeTypeTemp;
                                                        }
                                                        //  Do nothing, the output message just returns success or
                                                        // failure.
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                        rc = Messages.MSG_DETAIL_DELETED;
                                                        break;
                                                        
                                                        //  Default Case for Dam CSES68D (APG)
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                        return rc;
                                                        break;
                                                }
                                            }
                                            
                                            
                                            
                                            
                                            else {
                                                szCodeTypeTemp = CODE_COMM_SERV_NO_GUARD;
                                                pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                        
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        
                                                        
                                                        //  if the service is in "add" mode, move the IdEvent from the service
                                                        // output message to the DAM input message.  Else, the DAM input
                                                        // IdEvent is set to the IdEvent in the service input message.
                                                        // Set IdEvent to common function IdEvent if in "add" mode
                                                        if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                            dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                            dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                            dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                        }
                                                        
                                                        
                                                        //  Set CalculatedRetentionDate =
                                                        // CCMND9DO.DtCaseClosed +
                                                        // CSES68DO.NbrRecRetentionYear +
                                                        // CSES68DO.NbrRecRetentionMnth
                                                        else {
                                                            
                                                            
                                                            //  Set dtTempDate to Null
                                                            dtTempDate.day = 0;
                                                            dtTempDate.month = 0;
                                                            dtTempDate.year = 0;
                                                            
                                                            dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                            dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                            
                                                            dtCalculatedRetentionDate = dtTempStageClosed;
                                                            rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                        }
                                                        lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                        
                                                        //  if LOC type is "billing", the window is in modify mode,
                                                        // and current event status is "complete", set the Write history
                                                        // indicator flag
                                                        
                                                        // 01/10/96  saravigm  We want the indicator to be set regardless if the
                                                        // event is closed or in process.  The indicator should
                                                        // have no effects on payment.
                                                        if (lRC3 >= 0) {
                                                            dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                            dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                            dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                            szCodeTypeRetention = szCodeTypeTemp;
                                                        }
                                                        break;
                                                        
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                        rc = Messages.MSG_DETAIL_DELETED;
                                                        break;
                                                        
                                                        //  Default Case for Dam CSES68D (ASR)
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                        return rc;
                                                        break;
                                                }
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            szCodeTypeTemp = CODE_COMM_SERV_NO_GUARD;
                                            pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                            rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    
                                                    //  Start DAM Performance Timer
                                                    //##            ARC_PRFDataAccessStartTime("CAUD11D");
                                                    
                                                    // dejuanr - SIR 19986 - Call caude9d if it an ALOC.
                                                    if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                        dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                        dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                        dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                    }
                                                    
                                                    
                                                    //  Set CalculatedRetentionDate =
                                                    // CCMND9DO.DtCaseClosed +
                                                    // CSES68DO.NbrRecRetentionYear +
                                                    // CSES68DO.NbrRecRetentionMnth
                                                    else {
                                                        
                                                        
                                                        //  Set dtTempDate to Null
                                                        dtTempDate.day = 0;
                                                        dtTempDate.month = 0;
                                                        dtTempDate.year = 0;
                                                        
                                                        dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                        dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                        
                                                        dtCalculatedRetentionDate = dtTempStageClosed;
                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                    }
                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                    if (lRC3 >= 0) {
                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                    }
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                    break;
                                                    
                                                    //  Default Case for Dam CSES68D (ASR)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                            }
                                            break;
                                            
                                            //  Default Case for Dam CSES77D
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            break;
                                    }
                                }
                                
                                
                                
                                //  SIR #3743 - Added Code to Calculate Retention Date
                                // with Aging Out Child Stage
                                else if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageProgram().compareTo(CAPS_PROG_APS) != 0) &&!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(APS_AGING_OUT_CHILD_STG) != 0)) {
                                    szCodeTypeTemp = APS_AGING_OUT_CHILD_STG;
                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                    
                                    //  Call DAM
                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                            }
                                            
                                            
                                            //  Set CalculatedRetentionDate =
                                            // CCMND9DO.DtCaseClosed +
                                            // CSES68DO.NbrRecRetentionYear +
                                            // CSES68DO.NbrRecRetentionMnth
                                            else {
                                                
                                                //  Set dtTempDate to Null
                                                dtTempDate.day = 0;
                                                dtTempDate.month = 0;
                                                dtTempDate.year = 0;
                                                
                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                
                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            }
                                            lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                            // END SIR 19986
                                            
                                            //  Stop DAM Performance Timer
                                            //##            ARC_PRFDataAccessStopTime();
                                            
                                            
                                            // validation error processing
                                            if (lRC3 >= 0) {
                                                dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                szCodeTypeRetention = szCodeTypeTemp;
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                            rc = Messages.MSG_DETAIL_DELETED;
                                            break;
                                            
                                            //  Default Case for Dam CSES68D (AOC)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            break;
                                    }
                                }
                                
                                
                                
                                //  Calculate Retention Date with Family Reunification
                                // or Substitute Care Stage
                                else if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(FAM_REUN_STG) != 0) ||!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(SUB_CARE_STG) != 0)) {
                                    szCodeTypeTemp = CODE_FAM_REUN_SUB_CARE;
                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                            }
                                            
                                            
                                            //  Set CalculatedRetentionDate =
                                            // CCMND9DO.DtCaseClosed +
                                            // CSES68DO.NbrRecRetentionYear +
                                            // CSES68DO.NbrRecRetentionMnth
                                            else {
                                                
                                                
                                                //  Set dtTempDate to Null
                                                dtTempDate.day = 0;
                                                dtTempDate.month = 0;
                                                dtTempDate.year = 0;
                                                
                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                
                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            }
                                            lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                            if (lRC3 >= 0) {
                                                dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                szCodeTypeRetention = szCodeTypeTemp;
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                            rc = Messages.MSG_DETAIL_DELETED;
                                            break;
                                            
                                            //  Default Case for Dam CSES68D (CVS)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            break;
                                    }
                                }
                                
                                
                                
                                //  Calculate Retention Date with Adoption Stage
                                else if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(ADOPTION_STG) != 0)) {
                                    szCodeTypeTemp = CODE_ADOPTION;
                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                    
                                    // call DAM
                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Populate DAM input structure
                                            
                                            //  Set CSES15D IdEvent to CSUB17SI or CSUB17SO
                                            // IdEvent
                                            if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                            }
                                            
                                            
                                            //  Set CalculatedRetentionDate =
                                            // CCMND9DO.DtCaseClosed +
                                            // CSES68DO.NbrRecRetentionYear +
                                            // CSES68DO.NbrRecRetentionMnth
                                            else {
                                                
                                                //  Set dtTempDate to Null
                                                dtTempDate.day = 0;
                                                dtTempDate.month = 0;
                                                dtTempDate.year = 0;
                                                
                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                
                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            }
                                            lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                            
                                            //  DAM inserted 12/1/95 - was not updating
                                            // To - Do list upon completion
                                            
                                            // 
                                            // (BEGIN): DAM: cinv43d   To Do Completed
                                            // Processing
                                            // 
                                            if (lRC3 >= 0) {
                                                dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                szCodeTypeRetention = szCodeTypeTemp;
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                            rc = Messages.MSG_DETAIL_DELETED;
                                            break;
                                            
                                            //  Default Case for Dam CSES68D (ACH)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            break;
                                    }
                                }
                                
                                
                                
                                
                                //  Calculate Retention Date with Adoptive Home Stage,
                                // Adoptive Home Inquiry Stage, Foster Adoptive Stage,
                                // Foster Adoptive Inquiry Stage
                                // 
                                else if (!(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage().compareTo(ADOPTION_HOME_STG) != 0)) {
                                    pCSES41DInputRec.setUlIdRsrcFaHomeStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                    rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            if (!(pCSES41DOutputRec.getSzCdRsrcCategory().compareTo(FOSTER) != 0) ||!(pCSES41DOutputRec.getSzCdRsrcCategory().compareTo(LEGAL_RISK) != 0)) {
                                                pCSES75DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                
                                                //  Call DAM
                                                rc = cses75dQUERYdam(sqlca, pCSES75DInputRec, pCSES75DOutputRec);
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        
                                                        if (pCSES75DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                            //  Set CodeSetFlag to TRUE
                                                            bCodeSetFlag = true;
                                                            szCodeTypeTemp = CODE_FOSTER_ADOPTIVE;
                                                            pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                            
                                                            rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    
                                                                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                                                    // 01/22/2003 DWW: Added for error handling
                                                                    if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                        dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                        dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                        dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                    }
                                                                    
                                                                    
                                                                    //  Set CalculatedRetentionDate =
                                                                    // CCMND9DO.DtCaseClosed +
                                                                    // CSES68DO.NbrRecRetentionYear +
                                                                    // CSES68DO.NbrRecRetentionMnth
                                                                    else {
                                                                        
                                                                        //  Set dtTempDate to Null
                                                                        dtTempDate.day = 0;
                                                                        dtTempDate.month = 0;
                                                                        dtTempDate.year = 0;
                                                                        
                                                                        dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                        dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                        
                                                                        dtCalculatedRetentionDate = dtTempStageClosed;
                                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                    }
                                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                    if (lRC3 >= 0) {
                                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                                    }
                                                                    break;
                                                                case NO_DATA_FOUND:
                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                                    break;
                                                                    
                                                                    //  Default Case for Dam CSES68D
                                                                default :
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                    return rc;
                                                                    break;
                                                            }
                                                        }
                                                        
                                                        
                                                        
                                                        //  Count is not > 0, Code is CODE_FOSTER_ADOPTIVE_INQUIRY
                                                        else {
                                                            szCodeTypeTemp = CODE_FOSTER_ADOPTIVE_INQUIRY;
                                                            pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                            rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                        dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                        dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                        dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                    }
                                                                    
                                                                    
                                                                    //  Set CalculatedRetentionDate =
                                                                    // CCMND9DO.DtCaseClosed +
                                                                    // CSES68DO.NbrRecRetentionYear +
                                                                    // CSES68DO.NbrRecRetentionMnth
                                                                    else {
                                                                        
                                                                        //  Set dtTempDate to Null
                                                                        dtTempDate.day = 0;
                                                                        dtTempDate.month = 0;
                                                                        dtTempDate.year = 0;
                                                                        
                                                                        dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                        dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                        
                                                                        dtCalculatedRetentionDate = dtTempStageClosed;
                                                                        
                                                                        //  Call DAM
                                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                    }
                                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                    
                                                                    if (lRC3 >= 0) {
                                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                                    }
                                                                    break;
                                                                case NO_DATA_FOUND:
                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                    //  SQL_NOT_FOUND is a valid return from the DAM
                                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                                    break;
                                                                    
                                                                    //  Default Case for Dam CSES68D
                                                                default :
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                    return rc;
                                                                    break;
                                                            }
                                                        }
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                                        break;
                                                        
                                                        //  Default Case for Dam CSES75D
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                        return rc;
                                                        break;
                                                }
                                            }
                                            
                                            
                                            
                                            //  Else Category is Adoptive
                                            else {
                                                pCSES75DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                rc = cses75dQUERYdam(sqlca, pCSES75DInputRec, pCSES75DOutputRec);
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        
                                                        if (pCSES75DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                            
                                                            //  Set CodeSetFlag to TRUE
                                                            bCodeSetFlag = true;
                                                            pCSEC70DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                                            rc = csec70dQUERYdam(sqlca, pCSEC70DInputRec, pCSEC70DOutputRec);
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    //## END TUX/XML: Turn the XML buffer into an input message struct 
                                                                    
                                                                    
                                                                    
                                                                    if (pCSEC70DOutputRec.getUlSysNbrGenericCntr() > 0) {
                                                                        szCodeTypeTemp = CODE_ADOPTION_HOME_CONSUMMATED;
                                                                        
                                                                    }
                                                                    else {
                                                                        szCodeTypeTemp = CODE_ADOPTION_HOME_RECORD;
                                                                    }
                                                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                                    
                                                                    //  Analyze return code
                                                                    switch (rc) {
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                                            pServiceStatus.explan_code = SUCCESS;
                                                                            if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                                dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                                dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                                dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                            }
                                                                            
                                                                            
                                                                            //  Set CalculatedRetentionDate =
                                                                            // CCMND9DO.DtCaseClosed +
                                                                            // CSES68DO.NbrRecRetentionYear +
                                                                            // CSES68DO.NbrRecRetentionMnth
                                                                            else {
                                                                                
                                                                                //  Set dtTempDate to Null
                                                                                dtTempDate.day = 0;
                                                                                dtTempDate.month = 0;
                                                                                dtTempDate.year = 0;
                                                                                
                                                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                                
                                                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                            }
                                                                            lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                            
                                                                            
                                                                            if (lRC3 >= 0) {
                                                                                dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                                dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                                dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                                szCodeTypeRetention = szCodeTypeTemp;
                                                                            }
                                                                            break;
                                                                            
                                                                        case NO_DATA_FOUND:
                                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                            rc = Messages.MSG_DETAIL_DELETED;
                                                                            break;
                                                                            
                                                                            //  Default Case for Dam CSES68D
                                                                        default :
                                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                            return rc;
                                                                            break;
                                                                    }
                                                                    break;
                                                                case NO_DATA_FOUND:
                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                    
                                                                    //  Call DAM
                                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                                    break;
                                                                    
                                                                    //  Default Case for Dam CSEC70D
                                                                default :
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                    return rc;
                                                                    break;
                                                            }
                                                        }
                                                        
                                                        
                                                        
                                                        
                                                        //  Count is not > 0, Code is CODE_ADOPTION_HOME_INQUIRY
                                                        else {
                                                            szCodeTypeTemp = CODE_ADOPTION_HOME_INQUIRY;
                                                            pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                                            rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                                            switch (rc) {
                                                                    
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                                        dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                                        dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                                        dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                                    }
                                                                    
                                                                    
                                                                    //  Set CalculatedRetentionDate =
                                                                    // CCMND9DO.DtCaseClosed +
                                                                    // CSES68DO.NbrRecRetentionYear +
                                                                    // CSES68DO.NbrRecRetentionMnth
                                                                    else {
                                                                        
                                                                        //  Set dtTempDate to Null
                                                                        dtTempDate.day = 0;
                                                                        dtTempDate.month = 0;
                                                                        dtTempDate.year = 0;
                                                                        
                                                                        dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                                        dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                                        
                                                                        dtCalculatedRetentionDate = dtTempStageClosed;
                                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                                    }
                                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                                    if (lRC3 >= 0) {
                                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                                    }
                                                                    break;
                                                                    
                                                                case NO_DATA_FOUND:
                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                                    
                                                                    //  Call DAM
                                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                                    break;
                                                                    
                                                                    //  Default Case for Dam CSES68D
                                                                default :
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                                    
                                                                    return rc;
                                                                    break;
                                                            }
                                                        }
                                                        break;
                                                        
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                        rc = Messages.MSG_DETAIL_DELETED;
                                                        
                                                        break;
                                                        
                                                        //  Default Case for Dam CSES75D
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                        return rc;
                                                        
                                                        break;
                                                }
                                            }
                                            
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                            rc = Messages.MSG_DETAIL_DELETED;
                                            
                                            // 
                                            // Retrieve Name: DAM CSEC35D
                                            // 
                                            
                                            
                                            break;
                                            
                                            //  Default Case for Dam CSES41D
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            
                                            break;
                                    }
                                }
                                
                                
                                
                                //  SIR #4285 - Logic for Post Adoption Cases with out conservatorship.
                                // NOTE: This Code Type does NOT have a record on the REC RETEN TYPE
                                // table because there is not a standard number of years for the
                                // retention period. Instead, the case will be retained until
                                // the youngest child involved in the case turns 22 years old.
                                else if (0 == POST_ADOPTION_STG.compareTo(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage())) {
                                    szCodeTypeTemp = CODE_POST_ADOPTION;
                                    pCSEC63DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                    rc = csec63dQUERYdam(sqlca, pCSEC63DInputRec, pCSEC63DOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Using API set DtTempDOB2 to
                                            // CSEC63DO.dtDtPerson + POST_ADOPT_AGE years
                                            dtTempDOB2.year = POST_ADOPT_AGE;
                                            dtTempDOB2.month = 0;
                                            dtTempDOB2.day = 0;
                                            rc = ARC_UTLAddToDate((FndInt3date) & dtTempDOB2, (FndInt3date) & pCSEC63DOutputRec.getDtDtPersonBirth());
                                            
                                            
                                            dtCalculatedRetentionDate = dtTempDOB2;
                                            lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                            
                                            // SIR 3371
                                            
                                            if (lRC3 >= 0) {
                                                dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                szCodeTypeRetention = szCodeTypeTemp;
                                            }
                                            
                                            break;
                                            
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                            rc = Messages.MSG_DETAIL_DELETED;
                                            
                                            // 
                                            // Retrieve full row from the Person Table DAM CCMN44D.  
                                            // Only retrieve the full name of the person logged in.
                                            // 
                                            
                                            break;
                                            
                                            //  Default Case for Dam CSEC63D (PAR)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            
                                            break;
                                    }
                                }
                                if (0 == SPECIAL_REQUEST_STAGE_TYPE.substring(0, 2).compareTo(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStageType().substring(0, 2))) {
                                    szCodeTypeTemp = CODE_SPECIAL_REQUEST;
                                    pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                    rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                            }
                                            
                                            
                                            //  Set CalculatedRetentionDate =
                                            // CCMND9DO.DtCaseClosed +
                                            // CSES68DO.NbrRecRetentionYear +
                                            // CSES68DO.NbrRecRetentionMnth
                                            else {
                                                
                                                
                                                //  Set dtTempDate to Null
                                                dtTempDate.day = 0;
                                                dtTempDate.month = 0;
                                                dtTempDate.year = 0;
                                                
                                                dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                
                                                dtCalculatedRetentionDate = dtTempStageClosed;
                                                
                                                //  Call DAM
                                                rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            }
                                            lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                            
                                            //  Issue an "Advance Home Status" ToDo.
                                            if (lRC3 >= 0) {
                                                dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                szCodeTypeRetention = szCodeTypeTemp;
                                            }
                                            
                                            break;
                                            
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                            rc = Messages.MSG_DETAIL_DELETED;
                                            
                                            // 
                                            // Retrieve full row from the Person Table DAM CCMN44D
                                            // 
                                            
                                            break;
                                            
                                            //  Default Case for Dam CSES68D (CCR)
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            
                                            break;
                                    }
                                }
                                if (0 == INTAKE_NOT_ASSIGNED_INVEST_STG.compareTo(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getSzCdStage())) {
                                    pCSEC08DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(usRowCounter).getUlIdStage());
                                    rc = csec08dQUERYdam(sqlca, pCSEC08DInputRec, pCSEC08DOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            szCodeTypeTemp = CODE_INTAKE_NOT_ASSIGNED_INVEST;
                                            pCSES68DInputRec.setSzCdRecRtnType(szCodeTypeTemp);
                                            rc = cses68dQUERYdam(sqlca, pCSES68DInputRec, pCSES68DOutputRec);
                                            switch (rc) {
                                                    
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    if (INDICATOR_YES == pCSES68DOutputRec.getCIndRecRtnTypePerm()) {
                                                        dtCalculatedRetentionDate.year = Arcutls.ARC_UTL_MAX_YEAR;
                                                        dtCalculatedRetentionDate.month = Arcutls.ARC_UTL_MAX_MONTH;
                                                        dtCalculatedRetentionDate.day = Arcutls.ARC_UTL_MAX_DAY;
                                                    }
                                                    
                                                    
                                                    //  Set CalculatedRetentionDate =
                                                    // CCMND9DO.DtCaseClosed +
                                                    // CSES68DO.NbrRecRetentionYear +
                                                    // CSES68DO.NbrRecRetentionMnth
                                                    else {
                                                        
                                                        
                                                        //  Set dtTempDate to Null
                                                        dtTempDate.day = 0;
                                                        dtTempDate.month = 0;
                                                        dtTempDate.year = 0;
                                                        
                                                        dtTempDate.year += pCSES68DOutputRec.getSNbrRecRtnTypeYear();
                                                        dtTempDate.month += pCSES68DOutputRec.getSNbrRecRtnTypeMnth();
                                                        
                                                        dtCalculatedRetentionDate = dtTempStageClosed;
                                                        rc = ARC_UTLAddToDate((FndInt3date) & dtCalculatedRetentionDate, (FndInt3date) & dtTempDate);
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                                    }
                                                    lRC3 = ARC_UTLCompareDateAndTime((FndInt3date) & dtCalculatedRetentionDate, (char) 0, (FndInt3date) & dtDtCaseRetention, (char) 0);
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    if (lRC3 >= 0) {
                                                        dtDtCaseRetention.day = dtCalculatedRetentionDate.day;
                                                        dtDtCaseRetention.month = dtCalculatedRetentionDate.month;
                                                        dtDtCaseRetention.year = dtCalculatedRetentionDate.year;
                                                        szCodeTypeRetention = szCodeTypeTemp;
                                                    }
                                                    //  Do nothing, the output message just returns success or failure
                                                    break;
                                                    
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                                                    rc = Messages.MSG_DETAIL_DELETED;
                                                    break;
                                                    
                                                    //  Default Case for Dam CSES68D (CWA)
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                                    return rc;
                                                    break;
                                            }
                                            break;
                                            
                                            //  Default Case for Dam CSEC08D (CWA)
                                        default :
                                            
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                            return rc;
                                            break;
                                    }
                                }
                            }
                            //  Do nothing, the output message just returns success or failure
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                            
                            //  Call DAM
                            rc = Messages.MSG_DETAIL_DELETED;
                            
                            //  Set bMoreDataIndicator to FALSE
                            bMoreDataIndicator = 0;
                            break;
                            
                            //  Default Case for Dam CLSC59D
                        default :
                            
                            //  Set bMoreDataIndicator to FALSE
                            bMoreDataIndicator = 0;
                            
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                            return rc;
                            break;
                    }
                    
                    usPageNumber++;
                    
                    //  Reset local variable RowCounter to 0
                    usRowCounter = 0;
                }
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                //  DWW 12/10/2002
                // Added this change to rc, so that the service will return successfully
                // but will still launch the error list. This was required because
                // impact always checks return codes before it does a tpreturn
                rc = Messages.MSG_DETAIL_DELETED;
                break;
                
                //  Default Case for Dam CCMND9D
            default :
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                return rc;
                break;
        }
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            if (pInputMsg58.getCIndRuloutOrAdm() == ADMIN_REVIEW_YES) {
                pCAUD75DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            
            else {
                pCAUD75DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            pCAUD75DInputRec.setUlIdCase(pInputMsg58.getUlIdCase());
            
            //## BEGIN TUX/XML: Declare XML variables
            pCAUD75DInputRec.setSzCdRecRtnRetenType(szCodeTypeRetention);
            pCAUD75DInputRec.getDtDtRecRtnDstryActual().day = dtDtCaseRetention.day;
            pCAUD75DInputRec.getDtDtRecRtnDstryActual().month = dtDtCaseRetention.month;
            pCAUD75DInputRec.getDtDtRecRtnDstryActual().year = dtDtCaseRetention.year;
            pCAUD75DInputRec.getDtDtRecRtnDstryElig().day = dtDtCaseRetention.day;
            pCAUD75DInputRec.getDtDtRecRtnDstryElig().month = dtDtCaseRetention.month;
            pCAUD75DInputRec.getDtDtRecRtnDstryElig().year = dtDtCaseRetention.year;
            rc = caud75dAUDdam(sqlca, pCAUD75DInputRec, pCAUD75DOutputRec);
            
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                    //  Default Case for Dam CAUD75D
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                    return rc;
                    break;
            }
        }
        return rc;
    }

    void RECRETN(Pint ulIDCase, Pint ulRetCode) {
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        ;
        CCFC51UI InputRec = null;
        CCFC51UO OutputRec = null;
        
        InputRec.setUlIdCase(ulIDCase.value);
        rc = RecordsRetention(InputRec, OutputRec, pServiceStatus);
        (ulRetCode.value) = rc;
    }

}
