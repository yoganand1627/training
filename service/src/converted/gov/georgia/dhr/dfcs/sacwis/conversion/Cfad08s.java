package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD54DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN39DO;
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
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC6DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
/**************************************************************************
**
** Module File:   CFAD08S.src
**
** Service Name:  CFAD08S
**
** Description:   This service will either add a new F/A Home to CAPS or
**                will modify Home Demographic information on an existing
**                home.  It will also perform event status checking, call
**                post event, and update any To - Do's.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/20/1995
**
** Programmer:    Ari Purcell
**
** Archive Information: $Revision:   1.12  $
**                      $Date:   18 Nov 1998 15:03:34  $
**                      $Modtime:   18 Nov 1998 11:38:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/22/96  ADKINSMC  SIR #3304 - Added code to pass the Stage Type of
**                      REG to CINT12D.
**  2/23/96   PURCELA   SIR #3274 - Added Facilty Type/Resource Ststus Elements
**                      to logic and header of CAUD58D in order to correctly
**                      update to Caps Resource.  Previously, Type and Status
**                      created originally were unable to be modified, but
**                      the correct values can now be updated.
**  2/29/96   ADKINSMC  SIR #3310 - Added an if statement around the dam
**                      called to create alert's. Now, alert will only be
**                      created for PRS Homes.
**  3/5/96    PURCELA   SIR #3428 - Added Indicator of PRS change to the
**                      Input Copybook for this Service, and passed this
**                      value through to CFAD01U so that Resource Services
**                      and Service categories will be reset correctly if
**                      this changes.
**  3/08/96   VISHNUR   SIR #3715 - Added code to set pCCMND3DInputRec->
**                      bIndStagePersEmpNew to FND_YES. This indicator
**                      is used to shade the new stages on the work load.
**  3/18/96   PURCELA   SIR #3930 - Created DAMS CAUDB9D and CAUDC0D to
**                      update the Region on the Stage and Case Tables.
**                      Modified CAUD58D to update Resource Region and
**                      Resource Maintainer as necessary.  Added call to
**                      CSEC02D to retrieve the Stage's IdCase so that the
**                      Case table can be updated
**   3Apr96   sladewmf  SIR 20005: Changed pCINT12DInputRec->dtDtStageClose
**                      from ARC_MAX_YEAR, MONTH, DAY to NULL_DATE because
**                      the unit_sum_view (used on the unit summary window)
**                      counts # of stages by checking for NULL_DATE in the
**                      DT_STAGE_CLOSE field on the STAGE table.
**  18Apr96   sladewmf  SIR 20506: Set pCINT13DInputRec->dtDtSituationClosed
**                      to NULL_DATE because the Case Merge Batch
**                      program checks for NULL_DATE in the
**                      DT_SITUATION_CLOSED field on the SITUATION table,
**                      to determine if a Situation is opened or closed.
**
**  5/6/96   CRYSTAEP   SIR #20874- Changed looping to ensure that the
**                      contract county update will take place successfully.
**  5/8/96   DENTONRA   SIR 21003 - Changed "extendo" date processing to
**                      have == instead of = .  Also, changed error
**                      processing of cses80d to allow sql-not-found because
**                      that is an acceptible condition.  It should not
**                      "blow-up" at that point.
**  6/10/96  PURCELA    SIR #5378 - Based on the RESOURCE_ADDRESS to
**                      CAPS_RESOURCE trigger, we must sequentially perform
**                      deletes, updates, and then adds.  This will prevent
**                      the Address on Caps Resource from being set to
**                      NULL while a Primary Address exists on Resource
**                      Address.
** 8/19/96 ZABIHIN     SIR 10617 -  added ccmn37d in foundation and attached
**                     code to call the dam.  The F/AHomes with out of state
**                     addresses would get a data access error becasuse of
**                     they were being saved with a null region.  This
**                     fix makes them default to the region of the primary
**                     worker
**
** 09/18/96  CHESSMTL   SIR 22039 - Modified code dealing with updating
**                      existing Contract data - When a new Version
**                      is added (this happens when the primary address
**                      changes to another county), County Records will be
**                      end dated for Adoptive Contracts as well as the Foster
**                      Care Contracts.
**                      In addition, we will insert Version and County line
**                      items with the same end date as the prior Version
**                      had, not 100 years from today.
**                      Also had to modify all instances of setting the date
**                      back 1 day.  For some reason, the ARC function used
**                      to add/subtract from a date cannot accept -1 as a
**                      entry because -1 has been reserved to mean no change.
**                      Therefore in order to subtract one day, we have to
**                      subtract 2 days and then add one day.
**
** 9/25/96   ZABIHIN    SIR 11077 - When the VID for a NonPrs Home was deleted
**                      and the home was changed to PRS, an oracle exception
**                      was raised and would result in data access error.
**                      now when this exception is raised a msg box will
**                      pop up telling the user that thye cannot delete the
**                      VID, they should modify it.
**
** 10/23/96  vanderm    SIR 11973 - For converted F/A homes, the service code
**                      for contracts with new versions resulting from
**                      changes in the home demographics where reversed for
**                      the foster and adoptive contracts.  Conditionals
**                      added to check the type of contract which is selected.
**                      If a foster contract version is added foster codes are
**                      used.  If a adoptive version is added adoptive codes
**                      are now use.  For system generated contracts the
**                      adoptive contract is always first.  However, for
**                      converted foster contracts the foster contract is
**                      fist.  The new conditionals check the service codes
**                      of the contracts to determine if it is a foster or
**                      adoptive contract.
**
**  04/20/97  SGM   FINANCIAL ENHANCEMENT- Inserting a DAM call to this service
**   SIR#13691      so when a change is made to the vendor ID, CAUDC6D.PC
**                  will be able to update all the invoices that are still
**                  pending for the vendor with the correct vendor id.
**   9/21/98   CSD  SIR #14747 DT_RSRC_CERT should be populated for
**                             F/A homes when they are opened or re-opened
**   9/21/98   CSD  SIR #14568 DT_RSRC_CLOSE should be populated for
**                             F/A homes when they are closed
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
**  02/29/03   SRINI    IMPACT: Replaced EVENT with TS_EVENT for tsLastUpdate array as EVENT is 2 which
**                      is more than the array can accept i.e 2
**  03/25/03  Srini     Modified to check for the transaction and tpbegin only if it
**            is not already started and similarly for tpcommit at the end.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**            to PROCESS_TUX_RC_ERROR_NOFREE after the
**            ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**            input and output objects before they are allocated
**
**  06/30/03  Srini   SIR 18602 - Modified to fix error handling for
**            transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**            PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to
**            PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**  09/04/03  A.Corley  SIR 19613 LOC Reduction -- Service Codes 60A-E are now
**                      being reduced to Service Codes 63A - D, updated code to compare and
**                      save with new codes.
**  11/17/03  A.Corley  SIR 22390 LOC Change -- Service Code 63C is now being used
**                      for Specialized homes.
**  12/16/03  A.Corley  SIR 22485 LOC Change -- Service Code 63D is now being used
**                      for Specialized homes.
**  12/16/03  A.Corley  SIR 22485 LOC Change -- Service Code 63D is now being used
**                      for Specialized homes.
**  4/23/2004 gerryc    SIR 14700 - cIndRsrcWriteHist should be set to No unless
**                      license info, status, or category is changed, or the
**                      record is being added.  This is taken care of by cfad38s.
**  7/2/2004  gerryc    SIR 15891 - added comments to show where resource service
**                      processing happens.
**  03/18/05  Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
**                      field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
**                      Adoptive Home checkbox is checked, staff will have to select a
**                      'Certifying Entity'. to indicate the certifying agency
**                      2) This will be a required field when the Non-FPS Adoptive Home
**                      checkbox is checked for a new home. 3) If a user is modifying an
**                      existing Non-FPS Adoptive Home, this new field will be required,
**                      unless the home status is also being changed to 'Pending Closure'
**                      or 'Closed'.
/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/




public class Cfad08s {
    public static final int MSG_RES_UNIQUE_VID = 8051;
    public static final int MSG_DUPLICATE_RECORD = 9029;
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char IND_YES = '1';
    public static final String UNIT_MEMBER_IN_ASSIGNED = "IN";
    public static final int EXCEPTION_ERROR_CODE = - 6510;
    
    /* SIR #15787 */
    /* SIR 19613, 22390, 22485 Homes that are basic will only have
    ** Level A assigned to them, Homes that are Hab,
    ** Ther, and Prim Med will have Level A, B, C and D
    */
    public static final int NBR_SVC_CODE_SIXTY_A = 1;
    public static final int NBR_SVC_CODE_SIXTY_AB = 2;
    public static final int NBR_SVC_CODE_SIXTY_ABC = 3;
    public static final int NBR_SVC_CODE_SIXTY_ABCD = 4;
    public static final int NBR_OF_HOME_TYPE = 7;
    static int transactionflag = - 1;
    CFAD08SO CFAD08S(CFAD08SI cfad08si) {
        CFAD08SO cfad08so = new CFAD08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code  */
        rc = ARC_UTLCheckServiceBatchBlock("CFAD08S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CFAD08S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            
        }
        
        /* END - CREATE A CASE - CCMNB2D */
        
        
        /*
        ** SIR #3930 - 3/18/96 - PURCELA - Added an else if statement that will
        ** cause stage and case tables to be updated if the County Change indicator
        ** is true.
        */
        
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CFAD08S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CFAD08S\n");
            bTransactionStarted = true;
        }
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        /*
        ** Declare local variables
        */
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        CCMND3DI pCCMND3DInputRec = null;
        CCMND3DO pCCMND3DOutputRec = null;
        CRES26DI pCRES26DInputRec = null;
        CRES26DO pCRES26DOutputRec = null;
        CRES25DI pCRES25DInputRec = null;
        CRES25DO pCRES25DOutputRec = null;
        CAUD54DI pCAUD54DInputRec = null;
        CAUD54DO pCAUD54DOutputRec = null;
        CFAD01UI pCFAD01UInputRec = null;
        CFAD01UO pCFAD01UOutputRec = null;
        CCMNB2DI pCCMNB2DInputRec = null;
        CCMNB2DO pCCMNB2DOutputRec = null;
        CAUD55DI pCAUD55DInputRec = null;
        CAUD55DO pCAUD55DOutputRec = null;
        CAUD58DI pCAUD58DInputRec = null;
        CAUD58DO pCAUD58DOutputRec = null;
        CINT13DI pCINT13DInputRec = null;
        CINT13DO pCINT13DOutputRec = null;
        CINT12DI pCINT12DInputRec = null;
        CINT12DO pCINT12DOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;
        CSUB40UO pCSUB40UOutputRec = null;
        CSES73DI pCSES73DInputRec = null;
        CSES73DO pCSES73DOutputRec = null;
        CSEC02DI pCSEC02DInputRec = null;/* SIR #3930 */
        CSEC02DO pCSEC02DOutputRec = null;/* SIR #3930 */
        CAUDB9DI pCAUDB9DInputRec = null;/* SIR #3930 */
        CAUDB9DO pCAUDB9DOutputRec = null;/* SIR #3930 */
        CAUDC0DI pCAUDC0DInputRec = null;/* SIR #3930 */
        CAUDC0DO pCAUDC0DOutputRec = null;/* SIR #3930 */
        CCMN39DI pCCMN39DInputRec = null;/* SIR 10617 */
        CCMN39DO pCCMN39DOutputRec = null;/* SIR 10617 */
        CLSS67DI pCLSS67DInputRec = null;/* SIR #20083 */
        CLSS67DO pCLSS67DOutputRec = null;/* SIR #20083 */
        CLSS68DI pCLSS68DInputRec = null;/* SIR #20083 */
        CLSS68DO pCLSS68DOutputRec = null;/* SIR #20083 */
        CSES80DI pCSES80DInputRec = null;/* SIR #20083 */
        CSES80DO pCSES80DOutputRec = null;/* SIR #20083 */
        CSES81DI pCSES81DInputRec = null;/* SIR #20083 */
        CSES81DO pCSES81DOutputRec = null;/* SIR #20083 */
        CAUD01DI pCAUD01DInputRec = null;/* Contract AUD */
        
        
        
        
        /****************************SIR 20083**********************************/
        
        
        
        
        
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
        
        CAUDC6DI pCAUDC6DInputRec = null;
        CAUDC6DO pCAUDC6DOutputRec = null;/* SIR 13691 */
        
        /***************************END SIR 20083******************************/
        
        int RetVal = SUCCESS;
        
        int usRow = 0;
        
        int usInputRow = 0;
        
        int ulIdTemporaryUnit = 0;
        int ulIdTemporaryCase = 0;/* SIR #3930 */
        boolean bIndFosterContractExists = false;/* Indicates if that the foster
        contract exists SIR #20083 */
        boolean bIndAdoptContractExists = false;/* Indicates if that the foster
        contract exists SIR #20083 */
        char bIndUpdateFosterContract = 0;/* Indicates if that the foster
        contract exists SIR #20083 */
        char bIndUpdateAdoptContract = 0;/* Indicates if that the foster
        contract exists SIR #20083 */
        FndInt3date dtTempDate = null;/* Temporary date used for system date
        SIR #20083 */
        FndInt3date dtCurrentDate = null;/* Temporary date used for system date
        SIR #20083 */
        FndInt3date/* Temporary date to add 100 years
        SIR 20083 */
        dtTempDate2 = new FndInt3date(0, 0, 100);
        FndInt3date/* Temporary date to add 100 years
        SIR 20083 */
        dtTempDate3 = new FndInt3date( - 1, 0, 0);
        
        /* TLC 09/19/96 Added some variables for subtracting a day from a date */
        FndInt3date dtTempDate4 = new FndInt3date( - 2, 0, 0);
        
        FndInt3date dtTempDate5 = new FndInt3date(1, 0, 0);
        int ulContractQty = 0;/* Counter for contracts returned from
        database SIR #20083 */
        int i208 = 0;
        int j = 0;/* Interger used for a looping logic
        SIR #20083 */
        int k = 0;
        int l = 0;/* Interger used for a looping logic
        SIR #20083 */
        int drc = 0;/* return code from ARC_UTLCompareDate
        function.  SIR #20083 */
        int usCreateContract = 0;/* Indicates the type of contract to
        be created.  SIR #20083 */
        int ulTempIdRsrcAddress = 0;/* Temporary variable to hold the
        ** primary resource address id
        ** SIR 20083
        */
        int ulIdTempContract = 0;/* Holds the contract ID created in
        in the contract AUD SIR 20083 */
        int usCountyRow = 0;/* Holds contract county row index
        SIR 20083 */
        int usUpdateContract = 0;/* Indicates if the contract being
        updated is foster or adoptive
        SIR 20083 */
        boolean testBool = false;/* Boolean indicator used to compare
        dates SIR 20083 */
        String szTempRegion = new String();/* Used to compare old and new region */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* SIR #15787 */
        int ulAdoptiveOrFoster = 0;
        String szAdoptiveOrFoster = new String();
        int CounterP = 0;
        boolean bAdoptive = true;
        boolean bFoster = true;
        int tmpSvcRowQty1 = 0;
        int tempSvcRowQty = 0;
        
        
        /* SIR 22686 */
        boolean bGroupHome = false;
        rc = ARC_PRFServiceStartTime_TUX(cfad08si.getArchInputStruct());
        cfad08so.setUlIdStage(cfad08si.getROWCFAD08SIG06().getUlIdStage());
        szTempRegion = cfad08si.getSzCdCntrctRegion();
        if (0 != cfad08si.getROWCFAD08SIG06().getUlIdStage()) 
        {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(cfad08si.getROWCFAD08SIG06().getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cfad08si.getROWCFAD08SIG06().getSzCdTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            //  Analyze error code
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
        }
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCSES73DInputRec = new CSES73DI();
            
            pCSES73DOutputRec = new CSES73DO();
            pCSES73DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
            pCSES73DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
            pCSES73DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            pCSES73DInputRec.setUlIdPerson(cfad08si.getROWCFAD08SIG06().getUlIdPerson());
            pCSES73DInputRec.setSzCdUnitMemberInOut("IN");
            
            //  Call DAM
            rc = cses73dQUERYdam(sqlca, pCSES73DInputRec, pCSES73DOutputRec);
            
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set Return Value to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    //  Populate Temporary Unit Id Storage Variable
                    
                    ulIdTemporaryUnit = pCSES73DOutputRec.getUlIdUnit();
                    break;
                    
                default :
                    pServiceStatus.explan_code = FND_ERROR;
                    
                    //  Set Return Value to FND_ERROR
                    RetVal = FND_ERROR;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        
        if ((SUCCESS == RetVal) && (null == cfad08si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(0)[0])) 
        {
            // BEGIN - CREATE A CASE
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMNB2DInputRec = new CCMNB2DI();
            
            pCCMNB2DOutputRec = new CCMNB2DO();
            pCCMNB2DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
            pCCMNB2DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
            pCCMNB2DInputRec.setSzCdCaseCounty(cfad08si.getSzCdRsrcCnty());
            pCCMNB2DInputRec.setSzCdCaseProgram(FA_PROGRAM);
            pCCMNB2DInputRec.setSzCdCaseRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
            pCCMNB2DInputRec.setDtDtCaseOpened(cfad08si.getDtSysDtGenericSysdate());
            pCCMNB2DInputRec.getDtDtCaseClosed().year = DateHelper.NULL_DATE;
            pCCMNB2DInputRec.getDtDtCaseClosed().month = DateHelper.NULL_DATE;
            pCCMNB2DInputRec.getDtDtCaseClosed().day = DateHelper.NULL_DATE;
            pCCMNB2DInputRec.setSzNmCase(cfad08si.getROWCFAD08SIG04().getSzNmRshsResource());
            rc = ccmnb2dAUDdam(sqlca, pCCMNB2DInputRec, pCCMNB2DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // Set RetVal to FND_SUCCESS
                    
                    RetVal = SUCCESS;
                    
                    // BEGIN - CREATE A SITUATION - CINT13D
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCINT13DInputRec = new CINT13DI();
                    
                    pCINT13DOutputRec = new CINT13DO();
                    pCINT13DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCINT13DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
                    pCINT13DInputRec.setUlIdCase(pCCMNB2DOutputRec.getUlIdCase());
                    pCINT13DInputRec.setNbrSitOccurrence(FA_SIT_OCCUR);
                    
                    pCINT13DInputRec.setDtDtSituationOpened(cfad08si.getDtSysDtGenericSysdate());
                    pCINT13DInputRec.getDtDtSituationClosed().year = DateHelper.NULL_DATE;
                    pCINT13DInputRec.getDtDtSituationClosed().month = DateHelper.NULL_DATE;
                    pCINT13DInputRec.getDtDtSituationClosed().day = DateHelper.NULL_DATE;
                    rc = cint13dAUDdam(sqlca, pCINT13DInputRec, pCINT13DOutputRec);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            // set RetVal to FND_SUCCESS
                            
                            RetVal = SUCCESS;
                            
                            // BEGIN - CREATE STAGE  - CINT12D
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCINT12DInputRec = new CINT12DI();
                            
                            pCINT12DOutputRec = new CINT12DO();
                            pCINT12DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCINT12DInputRec.setSzCdStageType("REG");
                            pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
                            pCINT12DInputRec.setSzCdStage(STAGE_CD_FAD);
                            pCINT12DInputRec.setSzCdStageCnty(cfad08si.getSzCdRsrcCnty());
                            pCINT12DInputRec.setSzCdStageProgram(FA_PROGRAM);
                            pCINT12DInputRec.setSzCdStageRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                            
                            pCINT12DInputRec.setDtDtStageStart(cfad08si.getDtSysDtGenericSysdate());
                            pCINT12DInputRec.getDtDtStageClose().year = DateHelper.NULL_DATE;
                            pCINT12DInputRec.getDtDtStageClose().month = DateHelper.NULL_DATE;
                            pCINT12DInputRec.getDtDtStageClose().day = DateHelper.NULL_DATE;
                            pCINT12DInputRec.setSzNmStage(cfad08si.getROWCFAD08SIG04().getSzNmRshsResource());
                            pCINT12DInputRec.setUlIdCase(pCCMNB2DOutputRec.getUlIdCase());
                            pCINT12DInputRec.setUlIdSituation(pCINT13DOutputRec.getUlIdSituation());
                            pCINT12DInputRec.setUlIdUnit(ulIdTemporaryUnit);
                            rc = cint12dAUDdam(sqlca, pCINT12DInputRec, pCINT12DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    cfad08so.setUlIdStage(pCINT12DOutputRec.getUlIdStage());
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    // set RetVal to FND_SUCCESS
                                    
                                    RetVal = SUCCESS;
                                    // 
                                    // END CAUD20D
                                    // 
                                    // SIR #15787: Added the if statement
                                    
                                    if (Cint14s.INDICATOR_NO == cfad08si.getROWCFAD08SIG04().getCIndRshsNonPrs()) {
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCSUB40UInputRec = new CSUB40UI();
                                        
                                        pCSUB40UOutputRec = new CSUB40UO();
                                        pCSUB40UInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                        pCSUB40UInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
                                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(DEMOGRAPHICS_TODO_UPDATE_STATUS);
                                        
                                        
                                        pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(cfad08si.getDtSysDtGenericSysdate());
                                        
                                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(cfad08so.getUlIdStage());
                                        
                                        
                                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(cfad08si.getROWCFAD08SIG06().getUlIdPerson());
                                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(cfad08si.getROWCFAD08SIG06().getUlIdPerson());
                                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(cfad08si.getROWCFAD08SIG06().getUlIdPerson());
                                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(DEMOG_LITERAL_1 + cfad08si.getROWCFAD08SIG04().getSzNmRshsResource() + DEMOG_LITERAL_2);
                                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfLongDesc(DEMOG_LONG_LITERAL);
                                        rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                                        
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                // Set RetVal to FND_SUCCESS
                                                
                                                RetVal = SUCCESS;
                                                break;
                                                
                                            default :
                                                
                                                // Set RetVal to FND_FAIL
                                                
                                                RetVal = Csub50s.FND_FAIL;
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        
                                    }
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
                    break;
                    
                default :
                    pServiceStatus.explan_code = Csub50s.FND_FAIL;
                    
                    // Set RetVal to FND_FAIL
                    
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        
        else if ((SUCCESS == RetVal) && (null != cfad08si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(0)[0]) && (INDICATOR_YES == cfad08si.getCSysRsrcCntyChg())) {
            // 
            // (BEGIN): Retrieve IdCase from Caps Case
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC02DInputRec = new CSEC02DI();
            
            pCSEC02DOutputRec = new CSEC02DO();
            pCSEC02DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
            pCSEC02DInputRec.setUlIdStage(cfad08si.getROWCFAD08SIG06().getUlIdStage());
            rc = csec02dQUERYdam(sqlca, pCSEC02DInputRec, pCSEC02DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    ulIdTemporaryCase = pCSEC02DOutputRec.getUlIdCase();
                    
                    // 
                    // (BEGIN): Update the Region and County on the Case Table
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUDC0DInputRec = new CAUDC0DI();
                    
                    pCAUDC0DOutputRec = new CAUDC0DO();
                    pCAUDC0DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCAUDC0DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCAUDC0DInputRec.setUlIdCase(ulIdTemporaryCase);
                    
                    pCAUDC0DInputRec.setSzCdCaseRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                    pCAUDC0DInputRec.setSzCdCaseCounty(cfad08si.getSzCdRsrcCnty());
                    rc = caudc0dAUDdam(sqlca, pCAUDC0DInputRec, pCAUDC0DOutputRec);
                    
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            // 
                            // (BEGIN): Update the Region and County on the Stage Table
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCAUDB9DInputRec = new CAUDB9DI();
                            
                            pCAUDB9DOutputRec = new CAUDB9DO();
                            pCAUDB9DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCAUDB9DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            pCAUDB9DInputRec.setSzCdStageRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                            pCAUDB9DInputRec.setSzCdStageCnty(cfad08si.getSzCdRsrcCnty());
                            pCAUDB9DInputRec.setUlIdStage(cfad08si.getROWCFAD08SIG06().getUlIdStage());
                            
                            //  Call CheckStageEventStatus
                            rc = caudb9dAUDdam(sqlca, pCAUDB9DInputRec, pCAUDB9DOutputRec);
                            
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                    break;
                                    
                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                            break;
                            
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            break;
                            
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
            
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(cfad08si.getROWCFAD08SIG06().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(cfad08si.getROWCFAD08SIG06().getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(cfad08si.getROWCFAD08SIG06().getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(cfad08si.getROWCFAD08SIG06().getSzTxtEventDescr());
            
            
            
            
            
            
            // If the Home status is closed for a Non-PRS F/A Home than the
            // home's foster contract will be updated to a status of "Closed"
            // the Contract Period term date, Contract Period closure date,
            // and Contract Version end date will be updated.
            // The contract status of adoptive contract will be set to
            // "Service Hold".
            
            
            //  SIR 19600 - Modified statement to use FND_YES rather than TRUE.
            // original code:
            // if((TRUE == pInputMsg->bIndRsrcNonPrs)  &&
            if (0 == cfad08si.getROWCFAD08SIG06().getUlIdStage()) {
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(cfad08so.getUlIdStage());
            }
            
            else {
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(cfad08si.getROWCFAD08SIG06().getUlIdStage());
            }
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(cfad08si.getROWCFAD08SIG06().getDtDtEventOccurred());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(cfad08si.getROWCFAD08SIG06().getUlIdPerson());
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfad08so.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                    cfad08so.getTsLastUpdate_ARRAY().setTsLastUpdate(Csub12s.TS_EVENT, pCCMN01UOutputRec.getTsLastUpdate());
                    
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
        }
        if ((SUCCESS == RetVal) && (null == cfad08si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(0)[0])) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMND3DInputRec = new CCMND3DI();
            
            pCCMND3DOutputRec = new CCMND3DO();
            pCCMND3DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
            pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
            pCCMND3DInputRec.setSzCdStagePersRelInt(PRS_WORKER);
            pCCMND3DInputRec.setSzCdStagePersRole(PRIM_WORKER);
            pCCMND3DInputRec.setSzCdStagePersType(PRS_WORKER);
            pCCMND3DInputRec.setUlIdPerson(cfad08si.getROWCFAD08SIG06().getUlIdPerson());
            pCCMND3DInputRec.setUlIdStage(cfad08so.getUlIdStage());
            pCCMND3DInputRec.setBIndStagePersEmpNew(IND_YES);
            pCCMND3DInputRec.setDtDtStagePersLink(cfad08si.getDtSysDtGenericSysdate());
            
            //  Start performance timer for service. All performance functions always
            // return success so there is no need to check status.
            rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
            
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
        }
        if (SUCCESS == RetVal) {
            if (null == cfad08si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(0)[0]) {
                //  Allocate memory for DAM Input and Output Structures
                pCAUD55DInputRec = new CAUD55DI();
                
                pCAUD55DOutputRec = new CAUD55DO();
                pCAUD55DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                pCAUD55DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
                pCAUD55DInputRec.setSzCdRsrcCategory(cfad08si.getROWCFAD08SIG04().getSzCdRshsCategory());
                pCAUD55DInputRec.setSzCdRsrcEthnicity(cfad08si.getROWCFAD08SIG04().getSzCdRshsEthnicity());
                if (INDICATOR_YES == cfad08si.getROWCFAD08SIG04().getCIndRshsNonPrs()) {
                    pCAUD55DInputRec.setSzCdRsrcFacilType(RSRC_TYPE_PVT_AGENCY);
                }
                
                
                else {
                    pCAUD55DInputRec.setSzCdRsrcFacilType(RSRC_TYPE_FA_HOME);
                }
                pCAUD55DInputRec.setSzCdRsrcLanguage(cfad08si.getROWCFAD08SIG04().getSzCdRshsLanguage());
                pCAUD55DInputRec.setSzCdRsrcMaritalStatus(cfad08si.getROWCFAD08SIG04().getSzCdRshsMaritalStatus());
                pCAUD55DInputRec.setSzCdRsrcFaHomeStatus(cfad08si.getROWCFAD08SIG04().getSzCdRshsFaHomeStatus());
                pCAUD55DInputRec.setSzCdRsrcRespite(cfad08si.getROWCFAD08SIG04().getSzCdRshsRespite());
                pCAUD55DInputRec.setSzCdRsrcSourceInquiry(cfad08si.getROWCFAD08SIG04().getSzCdRshsSourceInquiry());
                if (0 == pCAUD55DInputRec.getSzCdRsrcFaHomeStatus().compareTo(HOME_STATUS_APVD_ACT)) {
                    pCAUD55DInputRec.setSzCdRsrcStatus(RSRC_STAT_ACTIVE);
                }
                
                else {
                    pCAUD55DInputRec.setSzCdRsrcStatus(RSRC_STAT_INACTIVE);
                }
                pCAUD55DInputRec.setSzCdRsrcType(OTHER_FACIL_RSRC_TYPE);
                
                
                pCAUD55DInputRec.setBIndRsrcNonPrs(cfad08si.getROWCFAD08SIG04().getCIndRshsNonPrs());
                pCAUD55DInputRec.setDNbrRsrcAnnualIncome(cfad08si.getROWCFAD08SIG04().getDNbrRshsAnnualIncome());
                
                pCAUD55DInputRec.setSzCdRsrcRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                pCAUD55DInputRec.setSzCdCertifyEntity(cfad08si.getROWCFAD08SIG04().getSzCdCertifyEntity());
                pCAUD55DInputRec.setSzCdRsrcMaintainer(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                pCAUD55DInputRec.setSzCdRsrcReligion(cfad08si.getROWCFAD08SIG04().getSzCdRshsReligion());
                pCAUD55DInputRec.setDtDtRsrcMarriage(cfad08si.getROWCFAD08SIG04().getDtDtRshsMarriage());
                pCAUD55DInputRec.setUlIdRsrcFaHomeEvent(cfad08so.getUlIdEvent());
                
                pCAUD55DInputRec.setUlIdRsrcFaHomeStage(cfad08so.getUlIdStage());
                
                pCAUD55DInputRec.setCIndRsrcCareProv(cfad08si.getROWCFAD08SIG04().getCIndRshsCareProv());
                
                pCAUD55DInputRec.setCIndRsrcEmergPlace(cfad08si.getROWCFAD08SIG05().getCIndRsrcEmergPlace());
                pCAUD55DInputRec.setCIndRsrcTransport(cfad08si.getROWCFAD08SIG05().getCIndRsrcTransport());
                pCAUD55DInputRec.setBIndRsrcIndivStudy(cfad08si.getROWCFAD08SIG04().getCIndRshsIndivStudy());
                pCAUD55DInputRec.setCIndRsrcWriteHist(INDICATOR_YES);
                pCAUD55DInputRec.setUNbrRsrcIntChildren(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntChildren());
                pCAUD55DInputRec.setUNbrRsrcIntFeAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntFeAgeMax());
                pCAUD55DInputRec.setUNbrRsrcIntFeAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntFeAgeMin());
                pCAUD55DInputRec.setUNbrRsrcIntMaAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntMaAgeMax());
                pCAUD55DInputRec.setUNbrRsrcIntMaAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntMaAgeMin());
                //  PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                pCAUD55DInputRec.setSzNmResource(cfad08si.getROWCFAD08SIG04().getSzNmRshsResource());
                
                pCAUD55DInputRec.setSzNmRsrcLastUpdate(cfad08si.getArchInputStruct().getSzUserId());
                pCAUD55DInputRec.setSzTxtRsrcComments(cfad08si.getROWCFAD08SIG05().getSzTxtRsrcComments());
                pCAUD55DInputRec.setCSysIndRsrcPrsChg(cfad08si.getCSysIndRsrcPrsChg());
                
                //  Run-time versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                // * Initialize service status fields
                
                // 
                // Get System Date and Time for return to Client
                // 
                
                rc = caud55dAUDdam(sqlca, pCAUD55DInputRec, pCAUD55DOutputRec);
                
                switch (rc) {
                        
                        //  SIR 22287 - DAM CINT55D has been modified in such a way
                        // that returning SQL_NOT_FOUND is an actual error.  As a
                        // result, the case setting rc to ARC_SUCCESS has been removed.
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        cfad08so.setUlIdResource(pCAUD55DOutputRec.getUlIdResource());
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
                        //  } * end if *
                        //  IMPACT END
                        break;
                }
            }
            
            else {
                //  Allocate memory for DAM Input and Output Structures
                pCAUD58DInputRec = new CAUD58DI();
                
                pCAUD58DOutputRec = new CAUD58DO();
                pCAUD58DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                pCAUD58DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
                pCAUD58DInputRec.setSzCdRsrcEthnicity(cfad08si.getROWCFAD08SIG04().getSzCdRshsEthnicity());
                
                pCAUD58DInputRec.setSzCdRsrcLanguage(cfad08si.getROWCFAD08SIG04().getSzCdRshsLanguage());
                pCAUD58DInputRec.setSzCdRsrcReligion(cfad08si.getROWCFAD08SIG04().getSzCdRshsReligion());
                pCAUD58DInputRec.setSzCdRsrcMaritalStatus(cfad08si.getROWCFAD08SIG04().getSzCdRshsMaritalStatus());
                pCAUD58DInputRec.setSzCdRsrcFaHomeStatus(cfad08si.getROWCFAD08SIG04().getSzCdRshsFaHomeStatus());
                pCAUD58DInputRec.setSzCdRsrcRespite(cfad08si.getROWCFAD08SIG04().getSzCdRshsRespite());
                pCAUD58DInputRec.setSzCdRsrcSourceInquiry(cfad08si.getROWCFAD08SIG04().getSzCdRshsSourceInquiry());
                pCAUD58DInputRec.setDtDtRsrcMarriage(cfad08si.getROWCFAD08SIG04().getDtDtRshsMarriage());
                //  PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                pCAUD58DInputRec.setUlIdEvent(cfad08so.getUlIdEvent());
                
                pCAUD58DInputRec.setUlIdResource(cfad08si.getUlIdResource());
                pCAUD58DInputRec.setCIndRsrcCareProv(cfad08si.getROWCFAD08SIG04().getCIndRshsCareProv());
                pCAUD58DInputRec.setCIndRsrcEmergPlace(cfad08si.getROWCFAD08SIG05().getCIndRsrcEmergPlace());
                pCAUD58DInputRec.setBIndRsrcNonPrs(cfad08si.getROWCFAD08SIG04().getCIndRshsNonPrs());
                pCAUD58DInputRec.setSzCdCertifyEntity(cfad08si.getROWCFAD08SIG04().getSzCdCertifyEntity());
                if (INDICATOR_YES == cfad08si.getROWCFAD08SIG04().getCIndRshsNonPrs()) {
                    pCAUD58DInputRec.setSzCdRsrcFacilType(RSRC_TYPE_PVT_AGENCY);
                }
                //  If years are equal and month is greater
                else {
                    pCAUD58DInputRec.setSzCdRsrcFacilType(RSRC_TYPE_FA_HOME);
                }
                //  If service codes are for a foster contract
                // do foster processing
                // SIR 19613
                if (0 == pCAUD58DInputRec.getSzCdRsrcFaHomeStatus().compareTo(HOME_STATUS_APVD_ACT)) {
                    pCAUD58DInputRec.setSzCdRsrcStatus(RSRC_STAT_ACTIVE);
                }
                //  If years and months are equal and day is greater
                else {
                    pCAUD58DInputRec.setSzCdRsrcStatus(RSRC_STAT_INACTIVE);
                }
                pCAUD58DInputRec.setDNbrRsrcAnnualIncome(cfad08si.getROWCFAD08SIG04().getDNbrRshsAnnualIncome());
                pCAUD58DInputRec.setCIndRsrcTransport(cfad08si.getROWCFAD08SIG05().getCIndRsrcTransport());
                pCAUD58DInputRec.setBIndRsrcIndivStudy(cfad08si.getROWCFAD08SIG04().getCIndRshsIndivStudy());
                pCAUD58DInputRec.setCIndRsrcWriteHist(Cint14s.INDICATOR_NO);
                pCAUD58DInputRec.setUNbrRsrcIntChildren(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntChildren());
                pCAUD58DInputRec.setUNbrRsrcIntFeAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntFeAgeMax());
                pCAUD58DInputRec.setUNbrRsrcIntFeAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntFeAgeMin());
                pCAUD58DInputRec.setUNbrRsrcIntMaAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntMaAgeMax());
                pCAUD58DInputRec.setUNbrRsrcIntMaAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcIntMaAgeMin());
                pCAUD58DInputRec.setUNbrRsrcFMAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcFMAgeMax());
                pCAUD58DInputRec.setUNbrRsrcFMAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcFMAgeMin());
                pCAUD58DInputRec.setUNbrRsrcMlAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcMlAgeMax());
                pCAUD58DInputRec.setUNbrRsrcMlAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcMlAgeMin());
                
                pCAUD58DInputRec.setSzTxtRsrcComments(cfad08si.getROWCFAD08SIG05().getSzTxtRsrcComments());
                
                //## BEGIN TUX/XML: Declare XML variables
                pCAUD58DInputRec.setCSysIndRsrcPrsChg(cfad08si.getCSysIndRsrcPrsChg());
                pCAUD58DInputRec.setSzCdRsrcRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                pCAUD58DInputRec.setSzCdRsrcMaintainer(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                pCAUD58DInputRec.setTsLastUpdate(cfad08si.getROWCFAD08SIG04().getTsLastUpdate());
                
                // 
                // Call DAMs to retrieve data
                // 
                
                //  retrieve EMPLOYEE information
                rc = caud58dAUDdam(sqlca, pCAUD58DInputRec, pCAUD58DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        cfad08so.setUlIdResource(pCAUD58DInputRec.getUlIdResource());
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
            }
        }
        
        
        /*
        ** If above function returns zero, the dates are
        ** the same and we need to add one day to current
        ** date before setting Term and Closure date to it.
        ** This will avoid an error on the window regarding
        ** start date can not equal term or closure date.
        */
        if (SUCCESS == RetVal) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCRES25DInputRec = new CRES25DI();
            
            pCRES25DOutputRec = new CRES25DO();
            
            //  retrieve NAME information
            rc = WtcHelperConstants.SQL_SUCCESS;
            
            //  SIR #5398 - 6/10/96 - PURCELA - Update address in 3 seperate ways.
            // First perform all deletes, then perform all updates, then all adds.
            // This is due to the trigger from RESOURCE_ADDRESS to CAPS_RESOURCE.
            // Previously, changing (UPDATE) a Primary Address to Business and also
            // adding a new Primary Address (ADD) was causing the trigger to set
            // CAPS_RESOURCE Address values to NULL.  By performing all Updates and
            // Deletes first, we can alleviate the problem.
            
            //  While more rows are left to process and rc is zero,
            // continue loop.
            for (usRow = 0;((usRow < MAX_NUM_ADDR_ROWS) && (SUCCESS == RetVal));usRow++) {
                
                
                
                //  If service codes are for an adoptive contract
                // do adoptive processing
                // SIR 15931: szCdCncntyService changed to szCdCnsvcService
                if (WtcHelperConstants.REQ_FUNC_CD_DELETE == cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdSysDataActionOutcome()) {
                    pCRES25DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCRES25DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdSysDataActionOutcome());
                    pCRES25DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                    pCRES25DInputRec.setSzAddrRsrcAddrAttn(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrAttn());
                    pCRES25DInputRec.setSzAddrRsrcAddrCity(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrCity());
                    pCRES25DInputRec.setSzAddrRsrcAddrStLn1(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrStLn1());
                    pCRES25DInputRec.setSzAddrRsrcAddrStLn2(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrStLn2());
                    pCRES25DInputRec.setSzAddrRsrcAddrZip(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrZip());
                    pCRES25DInputRec.setSzCdFacilityCounty(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdFacilityCounty());
                    pCRES25DInputRec.setSzCdRsrcAddrSchDist(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrSchDist());
                    pCRES25DInputRec.setSzCdFacilityState(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdFacilityState());
                    pCRES25DInputRec.setSzCdRsrcAddrType(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrType());
                    pCRES25DInputRec.setSzNbrRsrcAddrVid(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzNbrRsrcAddrVid());
                    pCRES25DInputRec.setSzTxtRsrcAddrComments(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzTxtRsrcAddrComments());
                    pCRES25DInputRec.setTsLastUpdate(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getTsLastUpdate());
                    pCRES25DInputRec.setUlIdRsrcAddress(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getUlIdRsrcAddress());
                    
                    //  retrieve PERSON information
                    rc = cres25dAUDdam(sqlca, pCRES25DInputRec, pCRES25DOutputRec);
                    
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            // Set RetVal to FND_SUCCESS
                            
                            RetVal = SUCCESS;
                            
                            
                            
                            break;
                            
                        case EXCEPTION_ERROR_CODE:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_FAD_VID_REQ;
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            
                            break;
                            
                            // SIR 11077
                            
                        default :
                            
                            // Set RetVal to FND_FAIL
                            
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            break;
                    }
                }
            }
            
            
            
            
            //  While more rows are left to process and rc is zero,
            // continue loop.
            for (usRow = 0;((usRow < MAX_NUM_ADDR_ROWS) && (SUCCESS == RetVal));usRow++) {
                
                if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdSysDataActionOutcome()) {
                    pCRES25DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCRES25DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdSysDataActionOutcome());
                    pCRES25DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                    pCRES25DInputRec.setSzAddrRsrcAddrAttn(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrAttn());
                    pCRES25DInputRec.setSzAddrRsrcAddrCity(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrCity());
                    pCRES25DInputRec.setSzAddrRsrcAddrStLn1(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrStLn1());
                    pCRES25DInputRec.setSzAddrRsrcAddrStLn2(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrStLn2());
                    pCRES25DInputRec.setSzAddrRsrcAddrZip(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrZip());
                    pCRES25DInputRec.setSzCdFacilityCounty(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdFacilityCounty());
                    pCRES25DInputRec.setSzCdRsrcAddrSchDist(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrSchDist());
                    pCRES25DInputRec.setSzCdFacilityState(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdFacilityState());
                    pCRES25DInputRec.setSzCdRsrcAddrType(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrType());
                    pCRES25DInputRec.setSzNbrRsrcAddrVid(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzNbrRsrcAddrVid());
                    pCRES25DInputRec.setSzTxtRsrcAddrComments(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzTxtRsrcAddrComments());
                    pCRES25DInputRec.setTsLastUpdate(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getTsLastUpdate());
                    pCRES25DInputRec.setUlIdRsrcAddress(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getUlIdRsrcAddress());
                    
                    //  retrieve PERSON ID information
                    rc = cres25dAUDdam(sqlca, pCRES25DInputRec, pCRES25DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            // Set RetVal to FND_SUCCESS
                            
                            RetVal = SUCCESS;
                            
                            //   04/20/97  SGM FINANCIAL ENHANCEMENT- Inserting a DAM call to this service
                            // SIR#13691 so when a change is made to the vendor ID, CAUDC6D.PC
                            // will be able to update all the invoices that are still
                            // pending for the vendor with the correct vendor id.
                            
                            pCAUDC6DInputRec = new CAUDC6DI();
                            pCAUDC6DOutputRec = new CAUDC6DO();
                            pCAUDC6DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCAUDC6DInputRec.setSzNbrRsrcAddrVid(pCRES25DInputRec.getSzNbrRsrcAddrVid());
                            pCAUDC6DInputRec.setUlIdRsrcAddress(pCRES25DInputRec.getUlIdRsrcAddress());
                            pCAUDC6DInputRec.getArchInputStruct().setCReqFuncCd(pCRES25DInputRec.getArchInputStruct().getCReqFuncCd());
                            
                            //  retrieve EMP JOB HISTORY information
                            rc = caudc6dAUDdam(sqlca, pCAUDC6DInputRec, pCAUDC6DOutputRec);
                            
                            switch (rc) {
                                    
                                    //  Reset the return code so that
                                    // processing may continue.
                                    // SIR 22287 - Just a comment -- when DAM CINT55D is called
                                    // here, SQL_NOT_FOUND is not considered an error.
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    // Set RetVal to FND_SUCCESS
                                    
                                    RetVal = SUCCESS;
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    // Set RetVal to FND_SUCCESS
                                    
                                    RetVal = SUCCESS;
                                    break;
                                    
                                default :
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                            //  do not create the To-Do if there is
                            // no Supervisor.
                            break;
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT() break;
                        case MSG_RES_UNIQUE_VID:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = MSG_RES_UNIQUE_VID;
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT() break;
                        case EXCEPTION_ERROR_CODE:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_FAD_VID_REQ;
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                            
                            // SIR 11077
                            
                        default :
                            
                            // Set RetVal to FND_FAIL
                            
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                }
            }
            
            
            
            
            
            //  While more rows are left to process and rc is zero,
            // continue loop.
            for (usRow = 0;((usRow < MAX_NUM_ADDR_ROWS) && (SUCCESS == RetVal));usRow++) {
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdSysDataActionOutcome()) {
                    pCRES25DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    
                    pCRES25DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdSysDataActionOutcome());
                    
                    pCRES25DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                    pCRES25DInputRec.setSzAddrRsrcAddrAttn(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrAttn());
                    pCRES25DInputRec.setSzAddrRsrcAddrCity(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrCity());
                    pCRES25DInputRec.setSzAddrRsrcAddrStLn1(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrStLn1());
                    pCRES25DInputRec.setSzAddrRsrcAddrStLn2(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrStLn2());
                    pCRES25DInputRec.setSzAddrRsrcAddrZip(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzAddrRsrcAddrZip());
                    pCRES25DInputRec.setSzCdFacilityCounty(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdFacilityCounty());
                    pCRES25DInputRec.setSzCdRsrcAddrSchDist(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrSchDist());
                    pCRES25DInputRec.setSzCdFacilityState(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdFacilityState());
                    pCRES25DInputRec.setSzCdRsrcAddrType(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrType());
                    
                    pCRES25DInputRec.setSzNbrRsrcAddrVid(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzNbrRsrcAddrVid());
                    pCRES25DInputRec.setSzTxtRsrcAddrComments(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzTxtRsrcAddrComments());
                    pCRES25DInputRec.setTsLastUpdate(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getTsLastUpdate());
                    pCRES25DInputRec.setUlIdRsrcAddress(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getUlIdRsrcAddress());
                    
                    //  retrieve EMPLOYEE SKILL information
                    rc = cres25dAUDdam(sqlca, pCRES25DInputRec, pCRES25DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            // Set RetVal to FND_SUCCESS
                            
                            RetVal = SUCCESS;
                            break;
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT() break;
                        case MSG_RES_UNIQUE_VID:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = MSG_RES_UNIQUE_VID;
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT() break;
                            
                            //  On an UPDATE or DELETE statement, SQL_NOT_FOUND will be returned
                            // if there are no records meeting the WHERE clause criteria.  In
                            // most cases this will be caused by a timestamp mismatch.
                            // pServiceStatus->explan_code should be set to the appropriate
                            // message by the programmer.
                        case EXCEPTION_ERROR_CODE:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_FAD_VID_REQ;
                            
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            break;
                            
                            // SIR 11077
                            
                        default :
                            
                            // Set RetVal to FND_FAIL
                            
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                }
            }
            
            // Reset usRow to Zero
            
            usRow = 0;
        }
        if (SUCCESS == RetVal) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCRES26DInputRec = new CRES26DI();
            
            pCRES26DOutputRec = new CRES26DO();
            
            // 15512  It retrieves Race adn Ethnicity from the Person Table
            
            rc = WtcHelperConstants.SQL_SUCCESS;
            
            //  While more rows are left to process and rc is zero,
            // continue loop.
            for (usRow = 0;((usRow < MAX_NUM_PHONE_ROWS) && (SUCCESS == RetVal));usRow++) {
                //  If service codes are for a foster contract
                // do foster processing
                // SIR 19613
                if (null != cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getSzCdSysDataActionOutcome()) {
                    pCRES26DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCRES26DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getSzCdSysDataActionOutcome());
                    pCRES26DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                    pCRES26DInputRec.setSzCdFacilPhoneType(cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getSzCdFacilPhoneType());
                    pCRES26DInputRec.setLNbrFacilPhoneNumber(cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getLNbrFacilPhoneNumber());
                    pCRES26DInputRec.setLNbrFacilPhoneExtension(cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getLNbrFacilPhoneExtension());
                    pCRES26DInputRec.setSzTxtRsrcPhoneComments(cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getSzTxtRsrcPhoneComments());
                    pCRES26DInputRec.setTsLastUpdate(cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getTsLastUpdate());
                    pCRES26DInputRec.setUlIdRsrcPhone(cfad08si.getROWCFAD08SIG00_ARRAY().getROWCFAD08SIG00(usRow).getUlIdRsrcPhone());
                    
                    rc = cres26dAUDdam(sqlca, pCRES26DInputRec, pCRES26DOutputRec);
                    
                    switch (rc) {
                            
                            //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                            // if there is an attempt to store a duplicate primary key value.
                            // pServiceStatus->explan_code should be set to the appropriate
                            // message by the programmer.
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
                }
            }
            
            // Reset usRow to Zero
            
            usRow = 0;
        }
        
        
        /*
        ** If service codes are for an adoptive contract
        ** do foster processing
        **SIR 15931: szCdCncntyService changed to szCdCnsvcService */
        
        if (SUCCESS == RetVal) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCAUD54DInputRec = new CAUD54DI();
            
            pCAUD54DOutputRec = new CAUD54DO();
            //  retrieve UNIT information
            rc = WtcHelperConstants.SQL_SUCCESS;
            
            //  While more rows are left to process and rc is zero,
            // continue loop.
            for (usRow = 0;((usRow < MAX_NUM_ETHNICITY_ROWS) && (SUCCESS == RetVal));usRow++) {
                if (null != cfad08si.getROWCFAD08SIG03_ARRAY().getROWCFAD08SIG03(usRow).getSzCdSysDataActionOutcome()) {
                    pCAUD54DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCAUD54DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                    pCAUD54DInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getROWCFAD08SIG03_ARRAY().getROWCFAD08SIG03(usRow).getSzCdSysDataActionOutcome());
                    pCAUD54DInputRec.setSzCdFaHomeIntEthnicity(cfad08si.getROWCFAD08SIG03_ARRAY().getROWCFAD08SIG03(usRow).getSzCdFaHomeIntEthnicity());
                    pCAUD54DInputRec.setTsLastUpdate(cfad08si.getROWCFAD08SIG03_ARRAY().getROWCFAD08SIG03(usRow).getTsLastUpdate());
                    
                    //  retrieve OFFICE information
                    rc = caud54dAUDdam(sqlca, pCAUD54DInputRec, pCAUD54DOutputRec);
                    
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
                }
            }
            
            // Reset usRow to Zero
            
            usRow = 0;
        }
        if (SUCCESS == RetVal) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCFAD01UInputRec = new CFAD01UI();
            
            pCFAD01UOutputRec = new CFAD01UO();
            pCFAD01UInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
            pCFAD01UInputRec.getArchInputStruct().setCReqFuncCd(cfad08si.getArchInputStruct().getCReqFuncCd());
            pCFAD01UInputRec.setCSysIndRsrcCharChg(cfad08si.getCSysIndRsrcCharChg());
            pCFAD01UInputRec.setCSysIndRsrcPrsChg(cfad08si.getCSysIndRsrcPrsChg());
            pCFAD01UInputRec.setUlIdResource(cfad08so.getUlIdResource());
            pCFAD01UInputRec.setUNbrRsrcMlAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcMlAgeMax());
            pCFAD01UInputRec.setUNbrRsrcMlAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcMlAgeMin());
            pCFAD01UInputRec.setUNbrRsrcFMAgeMax(cfad08si.getROWCFAD08SIG05().getUNbrRsrcFMAgeMax());
            pCFAD01UInputRec.setUNbrRsrcFMAgeMin(cfad08si.getROWCFAD08SIG05().getUNbrRsrcFMAgeMin());
            if (WtcHelperConstants.REQ_FUNC_CD_ADD == pCFAD01UInputRec.getArchInputStruct().getCReqFuncCd()) {
                pCFAD01UInputRec.setCSysIndCategoryChange(INDICATOR_YES);
            }
            
            for (usRow = 0;usRow <= MAX_NUM_ADDR_ROWS && null != cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrType()[0];usRow++) {
                
                //  If service codes are for a foster contract
                // do foster processing
                // SIR 19613
                if ((0 == ADDRESS_TYPE_PRIMARY.compareTo(cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdRsrcAddrType())) && (null != cfad08si.getROWCFAD08SIG01_ARRAY().getROWCFAD08SIG01(usRow).getSzCdSysDataActionOutcome())) {
                    pCFAD01UInputRec.setBSysIndAddressChange(INDICATOR_YES);
                }
            }
            
            
            for (usRow = 0;usRow < MAX_NUM_CHARACTERISTICS_ROWS;usRow++) {
                pCFAD01UInputRec.getCFAD01UIG00_ARRAY().getCFAD01UIG00(usRow).setSzCdRsrcCharChrctr(cfad08si.getROWCFAD08SIG02_ARRAY().getROWCFAD08SIG02(usRow).getSzCdRsrcCharChrctr());
                pCFAD01UInputRec.getCFAD01UIG00_ARRAY().getCFAD01UIG00(usRow).setDtDtRsrcCharDateAdded(cfad08si.getROWCFAD08SIG02_ARRAY().getROWCFAD08SIG02(usRow).getDtDtRsrcCharDateAdded());
            }
            pCFAD01UInputRec.setCSysIndFosterTypeChange(Cint14s.INDICATOR_NO);
            pCFAD01UInputRec.setBSysIndAgeChange(Cint14s.INDICATOR_NO);
            rc = Cfad01u.CFAD01U(pCFAD01UInputRec, pCFAD01UOutputRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // Set RetVal to FND_SUCCESS
                    
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    
                    // Set RetVal to FND_FAIL
                    
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
                    //##        PrepServiceExit(SVCPARMS);
            }
            //##        PrepServiceExit(SVCPARMS);
        }
        
        
        /*
        ** If service codes are for an adoptive contract
        ** do adoptive processing
        */
        if (!(FA_CATG_FOST.compareTo(cfad08si.getROWCFAD08SIG04().getSzCdRshsCategory()) != 0)) {
            bAdoptive = false;
        }
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        /* 01/22/2003 DWW: Added for error handling */
        if (!(FA_CATG_ADOPT.compareTo(cfad08si.getROWCFAD08SIG04().getSzCdRshsCategory()) != 0)) {
            bFoster = false;
        }
        //03/25/03 Srini: Modified to check for the transaction and commit only if it is started locally.
        //  TUX_CHECK_APPL_STATUS
        if (cfad08si.getUlIdResource() == 0) {
            cfad08si.setUlIdResource(cfad08so.getUlIdResource());
        }
        rc = Cfin21s.CallCRES04D(cfad08si, szAdoptiveOrFoster, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
        }
        
        
        pCFAD01DInputRec = new Cfad01a();
        //Commit only if we began the transaction in this service
        if ((INDICATOR_YES == cfad08si.getROWCFAD08SIG04().getCIndRshsNonPrs()) || ((Cint14s.INDICATOR_NO == cfad08si.getROWCFAD08SIG04().getCIndRshsNonPrs()) && ((0 == HOME_STATUS_APVD_ACT.compareTo(cfad08si.getROWCFAD08SIG04().getSzCdRshsFaHomeStatus())) || (0 == HOME_STATUS_APVD_INACT.compareTo(cfad08si.getROWCFAD08SIG04().getSzCdRshsFaHomeStatus()))))) {
            if (SUCCESS == RetVal) {
                
                // 
                // (BEGIN): CLSS67D - List retrieval of Contract rows for and id resource.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                
                pCLSS67DInputRec = new CLSS67DI();
                
                pCLSS67DOutputRec = new CLSS67DO();
                pCLSS67DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                pCLSS67DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                pCLSS67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS67DO._CLSS67DO__ROWCLSS67DO_SIZE);
                
                pCLSS67DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                rc = clss67dQUERYdam(sqlca, pCLSS67DInputRec, pCLSS67DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Populate Output Message
                        
                        //  Set fields in CFAD08SO to fields in CLSS67DO
                        
                        ulContractQty = pCLSS67DOutputRec.getArchOutputStruct().getUlRowQty();
                        
                        
                        //  Loop through all contract rows returned from the previous DAM
                        for (i208 = 0;i208 < ulContractQty;i208++) {
                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i208).getUlIdContract();
                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdCntrctManager = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i208).getUlIdCntrctManager();
                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdRsrcAddress = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i208).getUlIdRsrcAddress();
                            cfad08si.setSzCdCntrctRegion(pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i208).getSzCdCntrctRegion());
                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsLastUpdate = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(i208).getTsLastUpdate();
                            
                            
                            // 
                            // (BEGIN) CSES80D: Retrieve Contract Period table information
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES80DInputRec = new CSES80DI();
                            
                            pCSES80DOutputRec = new CSES80DO();
                            pCSES80DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCSES80DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                            rc = cses80dQUERYdam(sqlca, pCSES80DInputRec, pCSES80DOutputRec);
                            
                            //  Analyze error code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm = pCSES80DOutputRec.getDtDtCnperTerm();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperClosure = pCSES80DOutputRec.getDtDtCnperClosure();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnperPeriod = pCSES80DOutputRec.getUlNbrCnperPeriod();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnperStatus = pCSES80DOutputRec.getSzCdCnperStatus();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsSysTsLastUpdate2 = pCSES80DOutputRec.getTsLastUpdate();
                                    rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    if (pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.year > dtTempDate.year) {
                                        testBool = true;
                                    }
                                    //  If year, month and day are equal
                                    else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.month > dtTempDate.month)) {
                                        testBool = true;
                                    }
                                    else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.day > dtTempDate.day)) {
                                        testBool = true;
                                        //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                        
                                        
                                    }
                                    else if ((pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnperTerm.day == dtTempDate.day)) {
                                        testBool = true;
                                    }
                                    else {
                                        testBool = false;
                                    }
                                    if (testBool) {
                                        if (0 != CONTRACT_STATUS_CLOSED.compareTo(pCSES80DOutputRec.getSzCdCnperStatus())) {
                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].cSysIndContractCurrent = INDICATOR_YES;
                                        }
                                        
                                        else {
                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].cSysIndContractCurrent = Cint14s.INDICATOR_NO;
                                        }
                                    }
                                    
                                    //  if someone with a division number is trying to save - i.e.
                                    // invalid region - then save the region as the state office
                                    // region.
                                    else {
                                        pCFAD01DInputRec.ROWCFAD08SIG07[i208].cSysIndContractCurrent = Cint14s.INDICATOR_NO;
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
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
                
                if (SUCCESS == RetVal) {
                    
                    //  Loop through all contract rows returned from the previous DAMs
                    for (i208 = 0;i208 < ulContractQty;i208++) {
                        if (INDICATOR_YES == pCFAD01DInputRec.ROWCFAD08SIG07[i208].cSysIndContractCurrent) {
                            
                            // 
                            // (BEGIN): CSES81D - Contract Version retrieve for an idContract
                            // , contract period number, and version end date that is greater
                            // than the current date.
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES81DInputRec = new CSES81DI();
                            
                            pCSES81DOutputRec = new CSES81DO();
                            pCSES81DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCSES81DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                            pCSES81DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnperPeriod);
                            pCSES81DInputRec.getArchInputStruct().setUlPageSizeNbr(Csys08s.INITIAL_PAGE);
                            pCSES81DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                            rc = cses81dQUERYdam(sqlca, pCSES81DInputRec, pCSES81DOutputRec);
                            
                            //  SIR# 10717 - Added Switch and case MSG_NO_TASK_AVAIL_SAVE_INT_NOW
                            // Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdCnver = pCSES81DOutputRec.getUlIdCnver();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion = pCSES81DOutputRec.getUlNbrCnverVersion();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverCreate = pCSES81DOutputRec.getDtDtCnverCreate();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverEffective = pCSES81DOutputRec.getDtDtCnverEffective();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverEnd = pCSES81DOutputRec.getDtDtCnverEnd();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsSysTsLastUpdate3 = pCSES81DOutputRec.getTsLastUpdate();
                                    
                                    // 
                                    // (BEGIN): CLSS13D - Retrieve contract service codes for
                                    // the contract, period, and version passed to the DAM.
                                    // 
                                    
                                    pCLSS13DInputRec = new CLSS13DI();
                                    
                                    pCLSS13DOutputRec = new CLSS13DO();
                                    pCLSS13DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                    pCLSS13DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                                    pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
                                    pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                    rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            tmpSvcRowQty1 = pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();
                                            for (j = 0;j < pCLSS13DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsSysTsLastUpdate5[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getTsLastUpdate();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnsvcVersion[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcVersion();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdCnsvc[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlIdCnsvc();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnsvcLineItem[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcLineItem();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnsvcUnitRate[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlNbrCnsvcUnitRate();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulAmtCnsvcUnitRateUsed[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getUlAmtCnsvcUnitRateUsed();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].szNbrCnsvcUnitType[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzNbrCnsvcUnitType();
                                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j] = pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(j).getSzCdCnsvcService();
                                                
                                                if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j]))) {
                                                    
                                                    bIndFosterContractExists = true;
                                                    bIndUpdateFosterContract = 1;
                                                }
                                                
                                                if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j]))) {
                                                    
                                                    bIndAdoptContractExists = true;
                                                    bIndUpdateAdoptContract = 1;
                                                }
                                                
                                                if (tempSvcRowQty >= 0) {
                                                    pCLSS68DInputRec = new CLSS68DI();
                                                    
                                                    pCLSS68DOutputRec = new CLSS68DO();
                                                    pCLSS68DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                                    pCLSS68DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                                                    pCLSS68DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnperPeriod);
                                                    pCLSS68DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion);
                                                    pCLSS68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS68DO._CLSS68DO__ROWCLSS68DO_SIZE);
                                                    pCLSS68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                                    rc = clss68dQUERYdam(sqlca, pCLSS68DInputRec, pCLSS68DOutputRec);
                                                    
                                                    //  Analyze return code for CINT21D
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //  Call DAM
                                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                                            tempSvcRowQty = pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulSysNbrGenericCntr = pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCncntyService[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getSzCdCncntyService();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsSysTsLastUpdate4[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getTsLastUpdate();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdCncnty[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlIdCncnty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCncntyCounty[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getSzCdCncntyCounty();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCncntyEffective[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getDtDtCncntyEffective();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCncntyEnd[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getDtDtCncntyEnd();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCncntyPeriod[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyPeriod();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCncntyVersion[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyVersion();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCncntyLineItem[j] = pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(j).getUlNbrCncntyLineItem();
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
                
                pCINT20DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                
                //## BEGIN TUX/XML: Declare XML variables 
                pCINT20DInputRec.setUlIdStage(cfad08so.getUlIdStage());
                pCINT20DInputRec.setSzCdStagePersRole(PERSON_STAGE_ROLE_PRIMARY);
                pCINT20DInputRec.setSzCdStagePersType(Cint12s.PERSON_TYPE_WORKER);
                rc = cint20dQUERYdam(sqlca, pCINT20DInputRec, pCINT20DOutputRec);
                
                //  The DAM CINT21D retrieves and entire row from the STAGE table.  Only
                // those rows that appears in CINT03W's BFCD are of interest and will
                // be copied.
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
                pCRES13DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                pCRES13DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES13DO._CRES13DO__ROWCRES13DO_SIZE);
                pCRES13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                pCRES13DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                
                //  Call DAM
                rc = cres13dQUERYdam(sqlca, pCRES13DInputRec, pCRES13DOutputRec);
                
                
                //  SIR# 10717 - Added Switch and case MSG_NO_TASK_AVAIL_SAVE_INT_NOW
                // Analyze return code
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
                                pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCncntyCounty[(int) FIRST_REC] = pCRES13DOutputRec.getROWCRES13DO_ARRAY().getROWCRES13DO(l).getSzCdFacilityCounty();
                                
                                l = pCRES13DOutputRec.getArchOutputStruct().getUlRowQty();
                            }
                        }
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
            
            if (RetVal == SUCCESS) {
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
                    
                    if (0 == cfad08si.getSzCdRsrcCnty().compareTo(COUNTY_CD_OUT_OF_STATE)) {
                        // 
                        // (BEGIN): CCMN39D - Retrieve Primary Worker's Region
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN39DInputRec = new CCMN39DI();
                        
                        pCCMN39DOutputRec = new CCMN39DO();
                        pCCMN39DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                        pCCMN39DInputRec.setUlIdPerson(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                        pCCMN39DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
                        rc = ccmn39dQUERYdam(sqlca, pCCMN39DInputRec, pCCMN39DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                // * Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                if ('0' == pCCMN39DOutputRec.getSzCdUnitRegion()[0]) {
                                    cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion()[0] = pCCMN39DOutputRec.getSzCdUnitRegion()[1];
                                    cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion()[1] = pCCMN39DOutputRec.getSzCdUnitRegion()[2];
                                }
                                else {
                                    cfad08si.getROWCFAD08SIG04().setSzCdRshsRegion(CAPS_UNIT_STATE_OFFICE);
                                }
                                break;
                                
                            default :
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                    }
                    
                    // 
                    // (END): CCMN39D - Retrieve Primary Worker's Region
                    // 
                    // end of SIR 10617
                    
                    
                    
                    //  ADD 
                    
                    // 
                    // (BEGIN): CAUD01D CONTRACT AUD
                    // 
                    
                    pCAUD01DInputRec = new CAUD01DI();
                    
                    pCAUD01DOutputRec = new CAUD01DO();
                    pCAUD01DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCAUD01DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCAUD01DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                    pCAUD01DInputRec.setSzCdCntrctFuncType(STAGE_CD_FAD);
                    pCAUD01DInputRec.setSzCdCntrctProgramType(FA_PROGRAM);
                    pCAUD01DInputRec.setSzCdCntrctProcureType(PROVIDER_ENROLL);
                    pCAUD01DInputRec.setSzCdCntrctRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                    pCAUD01DInputRec.setCIndCntrctBudgLimit(NO_LIMIT);
                    pCAUD01DInputRec.setUlIdRsrcAddress(ulTempIdRsrcAddress);
                    pCAUD01DInputRec.setUlIdCntrctManager(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                    pCAUD01DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                    rc = caud01dAUDdam(sqlca, pCAUD01DInputRec, pCAUD01DOutputRec);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            
                            // Pass returned contract into the temporary variable
                            ulIdTempContract = pCAUD01DOutputRec.getUlIdContract();
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                            
                        default :
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
                    
                    pCAUD20DInputRec = new CAUD20DI();
                    
                    pCAUD20DOutputRec = new CAUD20DO();
                    pCAUD20DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCAUD20DInputRec.setUlIdContract(ulIdTempContract);
                    pCAUD20DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                    pCAUD20DInputRec.setUlNbrCnperPeriod(Ccmn19s.ONE);
                    rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    dtCurrentDate = dtTempDate;
                    
                    //  Declare FOUNDATION variables
                    
                    //  Declare local variables
                    
                    //  Start performance timer for service
                    rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    pCAUD20DInputRec.setDtDtCnperClosure(dtCurrentDate);
                    pCAUD20DInputRec.setDtDtCnperTerm(dtCurrentDate);
                    pCAUD20DInputRec.setDtDtCnperStart(dtTempDate);
                    pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_ACTIVE);
                    pCAUD20DInputRec.setCIndCnperRenewal(NO_RENEWAL);
                    pCAUD20DInputRec.setCIndCnperSigned(SIGNED_YES);
                    
                    // SIR 21891 - missing versioning
                    //  Run-time Versioning
                    
                    
                    //  Check buffer size
                    
                    //  Process error message and return to client
                    
                    //  Initialize output message and length
                    
                    //  Initialize service status fields
                    
                    // 
                    // Call DAMs to update data.  The Person DAM is always called in order
                    // to create a person.  The address, phone, name, and ID dams are called
                    // only if that data has been changed for the person.
                    // 
                    
                    //  Person and Stage Person Link
                    rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
                    
                    //  Analyze error code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            
                            if (false == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                            }
                            else {
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                // added this for sir#15787
                                RetVal = SUCCESS;
                                
                                // 
                                // BEGIN CAUD15D  CONTRACT VERSION AUD
                                // 
                                
                                pCAUD15DInputRec = new CAUD15DI();
                                
                                pCAUD15DOutputRec = new CAUD15DO();
                                pCAUD15DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                
                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD15DInputRec.setUlIdContract(ulIdTempContract);
                                pCAUD15DInputRec.setUlNbrCnverPeriod(Ccmn19s.ONE);
                                pCAUD15DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                                pCAUD15DInputRec.setUlNbrCnverVersion(Ccmn19s.ONE);
                                pCAUD15DInputRec.setDtDtCnverCreate(dtTempDate);
                                pCAUD15DInputRec.setDtDtCnverEffective(dtTempDate);
                                rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                
                                //  Initialize current date to dtTempDate(today's date) and
                                // Add 100 years, no months and no years to dtCurrentDate
                                dtCurrentDate = dtTempDate;
                                
                                rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
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
                                        pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        break;
                                }
                            }
                            break;
                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    
                    if (Ccfc51u.FOSTER == usCreateContract) 
                    {
                        
                        // begin SIR #15787: Portion A is replaced by lines 5899 to #6091
                        
                        // 
                        // BEGIN CAUD17D - CONTRACT SERVICE
                        // 
                        pCAUD17DInputRec = new CAUD17DI();
                        
                        pCAUD17DOutputRec = new CAUD17DO();
                        // 
                        // Function Prototypes
                        // 
                        
                        //  To-Do Alert creator (ToDo AUD) Dam input is formatted in Main Svc Func
                        pCAUD17DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                        pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                        
                        //  Get Approval Related Events, output is stored in Bridge Structure
                        // declared in svc main function for subsequent service use
                        pCAUD17DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                        pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                        pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                        pCAUD17DInputRec.setSzNbrCnsvcUnitType(DAY_24_HOURS);
                        
                        //  Get supervisor Person ID. Result is stored in Svc Main Declared ULONG
                        pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                        pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                        
                        CounterP = 0;
                        
                        // SIR 19613 Write new codes 63A-D to Contract_Service Table
                        while (CounterP < NBR_SVC_CODE_SIXTY_ABCD && RetVal == SUCCESS) {
                            pCAUD17DInputRec.setUlNbrCnsvcLineItem(CounterP + 1);
                            
                            //  Analyze return code
                            switch (CounterP) {
                                case 0:
                                    
                                    //  Pro/Demote Event Status for approval related events Svc Main Declared
                                    // Structure Bridge 57 used as input
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
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    RetVal = SUCCESS;
                                    break;
                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                            CounterP++;
                        }
                    }
                    if (ADOPTIVE == usCreateContract) {
                        // 
                        // BEGIN CAUD17D
                        // 
                        
                        pCAUD17DInputRec = new CAUD17DI();
                        
                        pCAUD17DOutputRec = new CAUD17DO();
                        
                        pCAUD17DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                        pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD17DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                        
                        // SIR#2006
                        pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                        pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                        pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                        pCAUD17DInputRec.setUlNbrCnsvcLineItem(Ccmn19s.ONE);
                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_ADP_SUB);
                        
                        // SIR#2006
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
                                pCAUD17DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                
                                //  Retrieve functions
                                
                                // SIR#2006
                                pCAUD17DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                                pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                                pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                                pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                                
                                // SIR#2006
                                pCAUD17DInputRec.setUlNbrCnsvcLineItem(TWO);
                                pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_ADP_NON_REC_SUB);
                                pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                                pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                
                                // SIR#2006
                                pCAUD17DInputRec.setSzNbrCnsvcUnitType(ADOPTION_SUBSIDY);
                                pCAUD17DInputRec.setUlNbrCnsvcUnitRate(SUBSIDY_PAYMENT);
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
                                        pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        break;
                                }
                                break;
                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                    }
                    if (SUCCESS == RetVal) 
                    {
                        // 
                        // BEGIN CAUD08D - Contract County Insert
                        // 
                        
                        pCAUD08DInputRec = new CAUD08DI();
                        
                        pCAUD08DOutputRec = new CAUD08DO();
                        pCAUD08DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                        
                        // SIR#2006
                        pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD08DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                        
                        //  Initialize current date to dtTempDate(today's date) and
                        // Add years, no months and no years to dtCurrentDate
                        dtCurrentDate = dtTempDate;
                        rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                        
                        // SIR#2006
                        pCAUD08DInputRec.setUlIdContract(ulIdTempContract);
                        pCAUD08DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                        pCAUD08DInputRec.setSzCdCncntyCounty(cfad08si.getSzCdRsrcCnty());
                        pCAUD08DInputRec.setDtDtCncntyEffective(dtTempDate);
                        pCAUD08DInputRec.setUlNbrCncntyPeriod(Ccmn19s.ONE);
                        
                        // SIR#2006
                        pCAUD08DInputRec.setUlNbrCncntyVersion(Ccmn19s.ONE);
                        
                        usCountyRow = 0;
                        
                        // SIR 19613, 22390, 22485 If the home is baisic, only 63A will be written to
                        // Contract_County table, if it is Habil, Ther, or prim med, 63A, B, C and D
                        // will be written to the contract_county table
                        ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_A;
                        if (Ccfc51u.FOSTER == usCreateContract) {
                            if (szAdoptiveOrFoster.charAt(0) == null) {
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
                                    
                                    if ((szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_HABIL) || (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_THER) || (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_PRIM_MED)) {
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
                        
                        //  if someone with a division number is trying to save - i.e.
                        // invalid region - then save the region as the state office
                        // region.
                        else if (ADOPTIVE == usCreateContract) {
                            ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_AB;
                        }
                        
                        // 
                        // (END): CCMN39D - Retrieve Primary Worker's Region
                        // 
                        // end of SIR 10617
                        
                        else {
                            ulAdoptiveOrFoster = 0;
                        }
                        
                        usCountyRow = 0;
                        //   County AUD processing CAUD08D
                        // SIR 19613
                        while (usCountyRow < ulAdoptiveOrFoster && SUCCESS == pServiceStatus.explan_code) {
                            
                            if (Ccfc51u.FOSTER == usCreateContract && bFoster) {
                                pCAUD08DInputRec.setUlIdCncnty(0);
                                
                                //  Analyze return code
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
                                        
                                        // SIR#2006
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
                                    
                                    // SIR#2006
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                            usCountyRow++;
                        }
                    }
                }
            }
            if ((SUCCESS == RetVal) && (INDICATOR_YES == cfad08si.getCSysRsrcCntyChg())) {
                
                if (0 == cfad08si.getSzCdRsrcCnty().compareTo(COUNTY_CD_OUT_OF_STATE)) {
                    // 
                    // (BEGIN): CCMN39D - Retrieve Primary Worker's Region
                    // 
                    
                    pCCMN39DInputRec = new CCMN39DI();
                    
                    pCCMN39DOutputRec = new CCMN39DO();
                    pCCMN39DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    pCCMN39DInputRec.setUlIdPerson(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                    
                    //  SIR 13618 - MHMR Enhancement for AFC Investigation "Waiting for
                    // Superintendent Comments". If the Investigation is approved,
                    // the Superintendent Notified indicator will be set to 'Y'
                    // (indicator selected).
                    // This DAM updates the Facility Investigation table.
                    pCCMN39DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
                    rc = ccmn39dQUERYdam(sqlca, pCCMN39DInputRec, pCCMN39DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            RetVal = SUCCESS;
                            
                            
                            
                            //  Initialize Service Status Fields
                            
                            //  Perform Main Processing (BEGIN) 
                            
                            
                            //  IMPACT BEGIN - moved code from here which (re)set the cReqFuncCd until
                            // after the delete code below
                            // Original code:
                            // Set value of cReqFuncCd based on Id Event
                            // if(NULL == pInputMsg->ROWCCMN01UIG00.ulIdEvent)
                            // {
                            // pInputMsg->ArchInputStruct.cReqFuncCd = REQ_FUNC_CD_ADD;
                            // }
                            // else
                            // {
                            // pInputMsg->ArchInputStruct.cReqFuncCd = REQ_FUNC_CD_UPDATE;
                            // }
                            // IMACT END
                            
                            
                            // Ochumd sir# 19989  if the Category is Other and service is either
                            // of the two services 67A or 67B and the function is ADD then find
                            // out if a relative placement has been made otherwise skip.
                            
                            if ('0' == pCCMN39DOutputRec.getSzCdUnitRegion()[0]) {
                                cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion()[0] = pCCMN39DOutputRec.getSzCdUnitRegion()[1];
                                cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion()[1] = pCCMN39DOutputRec.getSzCdUnitRegion()[2];
                            }
                            
                            else {
                                
                                
                                // SIR 14160
                                cfad08si.getROWCFAD08SIG04().setSzCdRshsRegion(CAPS_UNIT_STATE_OFFICE);
                            }
                            break;
                            
                        default :
                            
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
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
                    pCSES82DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                    
                    pCSES82DInputRec.setSzCdRsrcSvcCnty(cfad08si.getSzCdRsrcCnty());
                    
                    //  Update the status of all Investigation Events to Approved
                    rc = cses82dQUERYdam(sqlca, pCSES82DInputRec, pCSES82DOutputRec);
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            cfad08si.setSzCdCntrctRegion(pCSES82DOutputRec.getSzCdRsrcSvcRegion());
                            
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
                i208 = 0;
                
                while (bIndUpdateAdoptContract != 0 || bIndUpdateFosterContract != 0) {
                    if (INDICATOR_YES == pCFAD01DInputRec.ROWCFAD08SIG07[i208].cSysIndContractCurrent) {
                        if (bIndUpdateAdoptContract != 0 && (0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]))) {
                            bIndUpdateAdoptContract = 0;
                            usUpdateContract = ADOPTIVE;
                        }
                        else if (bIndUpdateFosterContract != 0 && (0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]) || 0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[(int) FIRST_REC]))) {
                            bIndUpdateFosterContract = 0;
                            usUpdateContract = Ccfc51u.FOSTER;
                        }
                        
                        // 
                        // END Retrieval for CSEC58D - Prim Child Info Rtrv
                        // 
                        
                        //  The following if condition is executed if the
                        // previous DAM call was successful
                        
                        if (0 != cfad08si.getSzCdCntrctRegion().compareTo(szTempRegion)) {
                            
                            // 
                            // (BEGIN): CAUD01D CONTRACT AUD
                            // 
                            
                            pCAUD01DInputRec = new CAUD01DI();
                            
                            pCAUD01DOutputRec = new CAUD01DO();
                            
                            pCAUD01DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCAUD01DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                            pCAUD01DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            
                            pCAUD01DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                            pCAUD01DInputRec.setSzCdCntrctFuncType(STAGE_CD_FAD);
                            pCAUD01DInputRec.setSzCdCntrctProgramType(FA_PROGRAM);
                            
                            pCAUD01DInputRec.setSzCdCntrctProcureType(PROVIDER_ENROLL);
                            pCAUD01DInputRec.setSzCdCntrctRegion(cfad08si.getROWCFAD08SIG04().getSzCdRshsRegion());
                            pCAUD01DInputRec.setCIndCntrctBudgLimit(NO_LIMIT);
                            
                            pCAUD01DInputRec.setUlIdRsrcAddress(ulTempIdRsrcAddress);
                            pCAUD01DInputRec.setUlIdCntrctManager(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                            pCAUD01DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                            
                            // SIR 15189
                            pCAUD01DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsLastUpdate);
                            rc = caud01dAUDdam(sqlca, pCAUD01DInputRec, pCAUD01DOutputRec);
                            
                            
                            
                            //  Analyze return code
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
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                        }
                        
                        // 
                        // END CAUD01D CONTRACT HEADER UPDATE
                        // 
                        
                        
                        // 
                        // BEGIN CAUD15D  CONTRACT VERSION UPDATE
                        // 
                        
                        pCAUD15DInputRec = new CAUD15DI();
                        
                        pCAUD15DOutputRec = new CAUD15DO();
                        pCAUD15DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                        
                        // SIR #15787
                        pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        pCAUD15DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                        pCAUD15DInputRec.setUlNbrCnverPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnperPeriod);
                        pCAUD15DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                        pCAUD15DInputRec.setUlNbrCnverVersion(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion);
                        
                        // SIR #15920
                        pCAUD15DInputRec.setDtDtCnverCreate(pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverCreate);
                        pCAUD15DInputRec.setDtDtCnverEffective(pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverEffective);
                        if (INDICATOR_YES == cfad08si.getBIndEndDateMod()) {
                            rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            
                            //  Initialize current date to dtTempDate(today's date) and
                            // add no day, no months and 100 years to dtCurrentDate
                            dtCurrentDate = dtTempDate;
                            
                            //  Call CloseOpenStage to Close Investigation and Open
                            // Service Delivery
                            rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                            
                            // SIR #15101
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            pCAUD15DInputRec.setDtDtCnverEnd(pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverEnd);
                        }
                        
                        
                        
                        //  TLC 09/18/96 SIR #22039 Changed this if to an else if and
                        // copied in the same logic used for foster care line items
                        // found above
                        // if service code is a adoptive code
                        else {
                            rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
                            
                            
                            // SIR 23334
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            
                            //  Initialize current date to dtTempDate(today's date) and
                            // subtract 1 day, no months and no years to dtCurrentDate
                            //  TLC 09/19/96 Replaced dtTempDate3 with dtTempDate4 and added
                            // calculation with dtTempDate5.  We have to subtract 2 days and then
                            // add a day in order for ARC_UTLAddToDate to work
                            dtCurrentDate = dtTempDate;
                            rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate4);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            
                            //  Call CloseStageCase to Close both the Investigation and
                            // the Case
                            rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate5);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            pCAUD15DInputRec.setDtDtCnverEnd(dtCurrentDate);
                        }
                        pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                        pCAUD15DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsSysTsLastUpdate3);
                        
                        //  Update the status of all Investigation Events to Approved
                        rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                break;
                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                        
                        // 
                        // END CAUD15D - Contract Version update
                        // 
                        
                        // 
                        // BEGIN CAUD08D - Contract County update
                        // 
                        
                        pCAUD08DInputRec = new CAUD08DI();
                        
                        pCAUD08DOutputRec = new CAUD08DO();
                        
                        j = 0;
                        
                        while (j < pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulSysNbrGenericCntr && SUCCESS == pServiceStatus.explan_code) {
                            pCAUD08DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            pCAUD08DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                            pCAUD08DInputRec.setUlIdCncnty(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdCncnty[j]);
                            pCAUD08DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                            pCAUD08DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                            if (INDICATOR_YES == cfad08si.getBIndEndDateMod()) {
                                pCAUD08DInputRec.setSzCdCncntyCounty(cfad08si.getSzCdRsrcCnty() rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0));
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                
                                //  Initialize current date to dtTempDate(today's date) and
                                // add no days, no months and 100 years to dtCurrentDate
                                dtCurrentDate = dtTempDate;
                                rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                // Process utility function failure
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                pCAUD08DInputRec.setDtDtCncntyEnd(pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverEnd);
                                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                
                                
                                
                            }
                            else {
                                pCAUD08DInputRec.setSzCdCncntyCounty(cfad08si.getSzCdRsrcCnty());
                                
                                //  The ARC_UTLCompareDateAndTime function
                                // will check if the dtDtPlcmtEnd retrieved by CSECC1D occured
                                // prior to the Svc Auth effective date.  If so, then the
                                // Placement has ended and the No Placement message should
                                // be displayed. If NULL DATE is retrieved then the ARC
                                // function is not necessary.
                                if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j]))) {
                                    rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    
                                    //  Initialize current date to dtTempDate(today's date) and
                                    // subtract one day, no months and no years to dtCurrentDate
                                    //  TLC 09/19/96 Replaced dtTempDate3 with dtTempDate4 and added
                                    // calculation with dtTempDate5.  We have to subtract 2 days and then
                                    // add a day in order for ARC_UTLAddToDate to work
                                    dtCurrentDate = dtTempDate;
                                    
                                    //  Call CloseStageCase to Close both the Investigation and
                                    // the Case
                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate4);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    
                                    //  Update the status of all Service Delivery Events to Approved
                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate5);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                                }
                                else if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j]))) {
                                    rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    
                                    //  Initialize current date to dtTempDate(today's date) and
                                    // subtract one day, no months and no years to dtCurrentDate
                                    //  TLC 09/19/96 Replaced dtTempDate3 with dtTempDate4 and added
                                    // calculation with dtTempDate5.  We have to subtract 2 days and then
                                    // add a day in order for ARC_UTLAddToDate to work
                                    dtCurrentDate = dtTempDate;
                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate4);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    
                                    //  Call CloseStageCase to Close both the Service Delivery Stage and
                                    // the Case
                                    rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate5);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                                }
                            }
                            pCAUD08DInputRec.setSzCdCncntyService(pCFAD01DInputRec.ROWCFAD08SIG07[i208].szCdCnsvcService[j]);
                            pCAUD08DInputRec.setDtDtCncntyEffective(pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCncntyEffective[j]);
                            pCAUD08DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[i208].tsSysTsLastUpdate4[j]);
                            pCAUD08DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCncntyPeriod[j]);
                            pCAUD08DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCncntyVersion[j]);
                            pCAUD08DInputRec.setUlNbrCncntyLineItem(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCncntyLineItem[j]);
                            rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                            
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
                            j++;
                        }
                        
                        //  If CSECC1DO CdPlcmtLivArr is not "DD"
                        // No plcmt Message is displayed and no other dam
                        // should be executed.
                        
                        //  If the Date Placement End occurs before Service Auth Eff date then the
                        // No Placement message should be displayed.
                        
                        if (INDICATOR_YES != cfad08si.getBIndEndDateMod()) {
                            
                            // 
                            // BEGIN CAUD15D  CONTRACT VERSION AUD
                            // 
                            
                            pCAUD15DInputRec = new CAUD15DI();
                            
                            pCAUD15DOutputRec = new CAUD15DO();
                            pCAUD15DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            pCAUD15DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                            pCAUD15DInputRec.setUlNbrCnverPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnperPeriod);
                            pCAUD15DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                            pCAUD15DInputRec.setUlNbrCnverVersion((pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion + 1));
                            rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            pCAUD15DInputRec.setDtDtCnverCreate(dtTempDate);
                            pCAUD15DInputRec.setDtDtCnverEffective(dtTempDate);
                            pCAUD15DInputRec.setDtDtCnverEnd(pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverEnd);
                            pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                            rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    //  Do nothing, the output message just returns success or
                                    // failure.
                                    break;
                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                            if (Ccfc51u.FOSTER == usUpdateContract) {
                                
                                // 
                                // BEGIN CAUD17D - CONTRACT SERVICE
                                // 
                                
                                pCAUD17DInputRec = new CAUD17DI();
                                
                                pCAUD17DOutputRec = new CAUD17DO();
                                // Process utility function failure
                                pCAUD17DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD17DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                                pCAUD17DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                                pCAUD17DInputRec.setUlNbrCnsvcPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnperPeriod);
                                pCAUD17DInputRec.setUlNbrCnsvcVersion((pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion + 1));
                                pCAUD17DInputRec.setSzNbrCnsvcUnitType(DAY_24_HOURS);
                                pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                                pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                
                                CounterP = 0;
                                
                                // SIR 19613 Write new codes 63A-D to Contract_Service Table
                                while (CounterP < NBR_SVC_CODE_SIXTY_ABCD && RetVal == SUCCESS) {
                                    pCAUD17DInputRec.setUlNbrCnsvcLineItem(CounterP + 1);
                                    
                                    //  Analyze return code
                                    switch (CounterP) {
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
                                    
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            RetVal = SUCCESS;
                                            break;// from for loop
                                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                            RetVal = Csub50s.FND_FAIL;
                                            break;// SIR 2977 - Break from switch BSM
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            RetVal = Csub50s.FND_FAIL;
                                            
                                            break;
                                    }
                                    CounterP++;
                                }
                            }
                            if (ADOPTIVE == usUpdateContract) {
                                // 
                                // BEGIN CAUD17D
                                // 
                                
                                pCAUD17DInputRec = new CAUD17DI();
                                
                                pCAUD17DOutputRec = new CAUD17DO();
                                pCAUD17DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD17DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                                
                                //## BEGIN TUX/XML: Declare XML variables
                                pCAUD17DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                                pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                                pCAUD17DInputRec.setUlNbrCnsvcVersion((pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion + 1));
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
                                        
                                        pCAUD17DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                                        pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        pCAUD17DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                                        
                                        pCAUD17DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                                        pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                                        pCAUD17DInputRec.setUlNbrCnsvcVersion((pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion + 1));
                                        
                                        pCAUD17DInputRec.setUlNbrCnsvcLineItem(TWO);
                                        pCAUD17DInputRec.setSzCdCnsvcService(CD_SERV_ADP_NON_REC_SUB);
                                        pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                                        
                                        pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                        pCAUD17DInputRec.setSzNbrCnsvcUnitType(ADOPTION_SUBSIDY);
                                        pCAUD17DInputRec.setUlNbrCnsvcUnitRate(SUBSIDY_PAYMENT);
                                        
                                        //  Call DAM
                                        rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                break;
                                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                                
                                                break;
                                                
                                            default :
                                                
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;// from for loop
                                        }
                                        break;// Break from switch
                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = MSG_DUPLICATE_RECORD;
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        
                                        break;
                                }
                            }
                            
                            // 
                            // END CAUD17D
                            // 
                            
                            // Beg SIR #15787: Lines 6465 to 6707 is placed instead of
                            // Portion B at the end of this program
                            // if (FND_SUCCESS == RetVal)
                            // {
                            // 
                            // BEGIN CAUD08D - Contract County Insert
                            // 
                            
                            pCAUD08DInputRec = new CAUD08DI();
                            
                            pCAUD08DOutputRec = new CAUD08DO();
                            pCAUD08DInputRec.setArchInputStruct(cfad08si.getArchInputStruct());
                            
                            pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            pCAUD08DInputRec.setUlIdCntrctWkr(cfad08si.getUlIdCntrctWkr());
                            
                            //  Initialize current date to dtTempDate(today's date) and
                            // Add years, no months and no years to dtCurrentDate
                            dtCurrentDate = dtTempDate;
                            
                            rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                            pCAUD08DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulIdContract);
                            
                            pCAUD08DInputRec.setUlIdResource(cfad08so.getUlIdResource());
                            pCAUD08DInputRec.setSzCdCncntyCounty(cfad08si.getSzCdRsrcCnty());
                            pCAUD08DInputRec.setDtDtCncntyEffective(dtTempDate);
                            pCAUD08DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnperPeriod);
                            
                            usCountyRow = 0;
                            
                            
                            // SIR 19613, 22390, 22485 If the home is baisic, only 63A will be written to
                            // Contract_County table, if it is Habil, Ther, or prim med, 63A, B, C and D
                            // will be written to the contract_county table
                            
                            // need to set the maximum number of services to be written
                            // to the contract-county table
                            ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_A;
                            // 
                            // (END): Common Function: ccmn06u   Check Stage/Event common function
                            // 
                            
                            
                            //  IMPACT BEGIN - Added code to call DAM CAUDE7D which will delete
                            // all Service Auth-related data from the database.
                            if (Ccfc51u.FOSTER == usUpdateContract) {
                                if (szAdoptiveOrFoster.charAt(0) == null) {
                                    ulAdoptiveOrFoster = 0;
                                }
                                else {
                                    //  SIR 22686 loop through the rows to see if any of them
                                    // are group homes, if they are set an indicator
                                    for (usCountyRow = 0;usCountyRow < NBR_OF_HOME_TYPE;usCountyRow++) {
                                        // SIR 22824
                                        if (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_GROUP) {
                                            
                                            bGroupHome = true;
                                            
                                            break;
                                        }
                                    }
                                    for (usCountyRow = 0;usCountyRow < NBR_OF_HOME_TYPE;usCountyRow++) {
                                        //  Set value of cReqFuncCd based on Id Event
                                        if ((szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_HABIL) || (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_THER) || (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_PRIM_MED)) {
                                            if (!bGroupHome) {
                                                // 19613, 22390, 22485 Habil, Ther, and Prim Med homes use two codes 63A, B, C & D
                                                ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABCD;
                                                // END SIR 23416
                                                
                                                
                                                
                                                
                                                
                                                
                                                break;
                                            }
                                            else {
                                                ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABC;
                                                break;// from for loop
                                            }
                                        }
                                    }
                                }
                            }
                            else if (ADOPTIVE == usUpdateContract) {
                                ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_AB;
                            }
                            else {
                                ulAdoptiveOrFoster = 0;
                            }
                            
                            usCountyRow = 0;
                            
                            //   County AUD processing CAUD08D
                            // 19613
                            while (usCountyRow < ulAdoptiveOrFoster && SUCCESS == pServiceStatus.explan_code) {
                                if (Ccfc51u.FOSTER == usUpdateContract && bFoster) {
                                    pCAUD08DInputRec.setUlIdCncnty(0);
                                    
                                    
                                    
                                    //  Analyze return code
                                    switch (usCountyRow) {
                                        case 0:
                                            pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_FOST_LEV_BASIC);
                                            break;// SIR 2977 - Break from switch BSM
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
                                
                                //  Copy out Post Event returned variables for future save
                                // Post Event currently does not send out ID EVENT on an update
                                if ((ADOPTIVE == usUpdateContract) && (Csub17s.ZERO == usCountyRow)) {
                                    pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_ADP_SUB);
                                }
                                
                                //  Re-Set value of cReqFuncCd based on Id Svc Auth
                                if ((ADOPTIVE == usUpdateContract) && (Ccmn19s.ONE == usCountyRow)) {
                                    pCAUD08DInputRec.setSzCdCncntyService(CD_SERV_ADP_NON_REC_SUB);
                                }
                                pCAUD08DInputRec.setUlNbrCncntyLineItem((usCountyRow + Ccmn19s.ONE));
                                pCAUD08DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[i208].ulNbrCnverVersion + 1);
                                
                                //  Delete at least 1 row from STAGE_PERSON_LINK for the primary
                                // worker and any other rows for subsequent -secondary workers 
                                // when SavingNClosing or MarkingForDeletion an I&R Intake 11870
                                rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                
                                //  Initialize current date to dtTempDate(today's date) and
                                // Add no days, no months and 100 years to dtCurrentDate
                                dtCurrentDate = dtTempDate;
                                rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                pCAUD08DInputRec.setDtDtCncntyEnd(pCFAD01DInputRec.ROWCFAD08SIG07[i208].dtDtCnverEnd);
                                
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
                                        
                                        //  Free memory before processing any user function error.
                                        // By the time the return code is checked,
                                        // all clean-up processing has occured.
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                                usCountyRow++;
                            }
                        }
                    }
                    i208++;
                }
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(cfad08si.getArchInputStruct() , cfad08so.getArchOutputStruct());
        
        /* SIR 21130
        ** Add invalidate approval common function to invalidate the
        ** conclusion event if it has been submitted and the user
        ** has added a new record or modified an existing record
        */
        if (RetVal == SUCCESS) {
            
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            // SIR 22824
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CFAD08S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CFAD08S\n");
        }
        return cfad08so;
    }

    static int CallCRES04D(CFAD08SI pInputMsg383, String szAdoptiveOrFoster, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCRES04DInputRec.setArchInputStruct(pInputMsg383.getArchInputStruct());
        
        pCRES04DInputRec.setUlIdResource(pInputMsg383.getUlIdResource());
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
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
        return rc;
    }

}
