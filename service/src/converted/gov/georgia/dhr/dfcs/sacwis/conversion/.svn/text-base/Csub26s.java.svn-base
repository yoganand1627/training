package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB26SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD99DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD99DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS69DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC16DO;
/***************************************************************************
**
** Module File:   CSUB26S.src
**
** Service Name:  CSUB26S
**
** Description:   This is the save service for
**                the Placement Detail window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  21Oct95
**
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.18  $
**                      $Date:   31 Mar 1999 08:03:34  $
**                      $Modtime:   30 Mar 1999 16:15:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   30Nov95  sladewmf  Initial check-in.
**
**  2/5/96    DYARGR    There is no way to determine if we are in modify mode
**                      because we came from the todo list.  Added a call to
**                      cses37d before adding to the placement table to determine
**                      if that placement record already exists.  If it does
**                      we will update, if it doesn't we will add to the
**                      placement table.
**
**  02/22/96  WILSONET  SIR#3358: The only time that CAUD99D is called is
**                      when actual is selected for the first time.  This
**                      is in order to create the ToDo associated with
**                      the placement information.  Set to ReqFuncAdd.
**
**  03/13/96  DYARGR    SIR 3171 - Added some intialization parameters so
**                      Stage Progression would work correctly.
**
**  03/14/96  DYARGR    SIR 3577 - Count from CMSC09D should be one (as in
**                      one of these left)
**  03/18/96  DYARGR    SIR 3970 - ulIdSendPalFollowUp should be validated
**                      against true, not INDICATOR_YES
**
**  03/20/96  WILSONET  SIR#3949, 3948: An ulIdAdoptSubWorker is an employee
**                      who is assigned to the Adoption Stage (PR,SC,HP) that
**                      has the skill of ADOPTION_SUBSIDY_SPECIALIST (ADS).
**                      Three DAMS added: CMSC23D, CCMNB9D, CCMN31D.
**
**  03/27/96  ZIMMERNE  SIR #4280 - Added "&& IdResource is Null" to the if
**                      statement around the call to CRES04D, the
**                      Caps_Resource simple retrieve.  This dam should not
**                      be called when the placement type is Non-Certified
**                      Person because no IdResource exists.
**
**  04/02/96  WILSONET  SIR#4274:  UPDATE from PLANNED to ACTUAL
**                      The problem with using existing Case Update is that
**                      if the start date does not change no date validation
**                      will occur.  This is due to two incorrect assumptions
**                      1) that the date would have been validated on the
**                      insert and 2) that unless a change occurred there
**                      would be no reason to validate the date and check
**                      for overlap/gap.
**  4/17/96   PURCELA   SIR #20339 - Replace the incorrect DAM CSEC30D with
**                      DAM CLSS69D to retrieve open Adoption Subsidies.  The
**                      first record returned by this DAM will be used to
**                      send the Alert to the Adoption Subsidy Worker.
**
** 05/16/96   WILSONET  SIR#3582: See Contracts Validation Re-Design and
**                      sign off packet. Alert needs to be sent to Elig
**                      Worker (or Supervisor) if FLOC/PLOC Mismatch.
**
**  07/29/96  ZABIHIN   SIR 21424 - the number of rows in the list box needed
**                      to be 9 rows, but there was only 7, two more rows were
**                      added.
**
**  09/05/96  TOPPINTW  SIR 21130 - Prevents the addition of placements to
**                      a pending closure stage.
**
**  09/23/96  GLOORJW   SIR 10983 - Reverse the update of the open slots
**                      on the resource table since it was working backwards
**
**  9/30/96   VANDERM   SIR 21770 - Worker who closed/opened a stage was
**                      not being populated.  Added code to populate
**                      the input message of CloseOpenStage with the approval
**                      requesters ID.
**
**  11/01/96  VANDERM   SIR 22097 - Federal legilation was enacted which
**                      removes the prohibition against making Title IV-E
**                      foster care payments to for-profit facilities.  Thus,
**                      the billing validation edit preventing such payments
**                      was removed.  The alert generated to review a child's
**                      eligibility was also removed.
**  12/17/96  ZABIHIN   SIR 21130b - the retrieve service retrieves
**                      IdEvent and status of the stage closure event
**                      this service will invalidate the pendig approval for
**                      the closure event if legal status is changed after the
**                      stage has been submitted for approval.
**                      the previous fix for 21130 , does not set the
**                      pending closure to COMP if placement has been changed
**                      Look at the comments in csub18w, and csub25s
**  01/06/97  BRUCKMK   SIR 21330c: The Invalidate Approval function also has
**                      to be called for the Placement event if its status
**                      was pending.  This needs to be done so that the
**                      record on the Approvers table is set from 'PEND' to
**                      'INVD', which will give the standard Invalid Approval
**                      message when navigating on the now invalid Approval
**                      ToDo.
**
** 08/22/97   SARAVIGM  SIR#14169: Need to add appropriate code so that
**                      permanent date in being saved from the window.
**                      The change was made for the input for caud45d.pc
** 10/30/97   PAULS     SIR 14163 - Added 8 rows the placement Info LB.
**                      This is in connection with the Out of State adoptions
**                      that has to be reflected on the AFCARS report.
** 05/15/98   HENDERCR  SIR 14502 - Modified code to use the Current Date;
**                      instead of the Placement Start Date when creating
**                      a Placement Event record.
** 03/01/99   DOUGLACS  SIR 14113 bundle - Open Slots problems - Add alert
**                      to-do when actual placement occurs that causes the
**                      FAD home to exceed capacity.  Send alert to FAD worker.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**   02/10/03   Srini   Added following line for error handling:
**                      if (RetVal == FND_FAIL)  { rc=FND_FAIL; }
**
**  03/14/2003  KRD     IMPACT - Employee skills no longer exist and are
**                      handled by security attributes now.  So, the call
**                      to CCMN31D has been replaced with a call to CLSCB4D
**                      and the logic was changed to account for this.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**  06/09/2003  Srini   SIR#18020- Modified the marshaling of
**                      sNbrRsrcOpenSlots field from marshalUlElement to
**                      marshalIntElement.
**  10/10/2004  gerryc  SIR 14053 - only update open slots for FAD homes
**  11/12/2004  gerryc  SIR 23223 - added functions for CallCRES04D and
**                      CallCMSC16D.  This modularized the code.  I also
**                      added logic so that on an update, if the resource id
**                      was changed, open slots would get updated in the
**                      outgoing resouce if it was an F/A home, and updated
**                      in the new resouce if it was an F/A home.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/* SIR 21130b */
/* SIR 21130b */


/*
** Extern for version control table.
*/






public class Csub26s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int CURRENT = 0;
    public static final int NEXT = 1;
    public static final String ACTUAL = "A";
    public static final String PEND = "PEND";
    public static final String NEW = "NEW";
    public static final int EVENT = 0;
    public static final int PLCMT = 1;
    public static final String FOST_ADOPT = "020";
    public static final String CONTRACTED = "030";
    public static final String SUBCARE = "SUB";
    public static final String ADOPT = "ADO";
    public static final String FAM_REUNIF = "FRE";
    /* SIR#3949: Code was changed from "029" to "FAC" for Recruiter/Coordinator*/
    public static final String RECRUITER = "FAC";
    public static final String STAFF = "STF";
    /* Security for Adoption Subsidy window*/
    public static final String ADOPTION_SUBSIDY_SPECIALIST = "ADS";
    public static final String ADOPTION = "060";
    public static final String RETURN_HOME = "010";
    public static final String WITH_RELATIVES = "020";
    public static final String COURT_ORDERED = "150";
    public static final String EMANCIPATED = "160";
    public static final String NOT_ELIG = "40";
    public static final String COUNTY_PAID = "50";
    public static final String PRIMARY_CHILD = "PC";
    public static final String PAL = "PAL";
    public static final String TASKFOLLOWUP = "3560";
    public static final String EVENTFOLLOWUP = "FUP";
    public static final String NULL_STRING = "";
    public static final String CLOSE_SUB_STAGE = "3270";
    public static final String CLOSE_ADO_STAGE = "8770";
    public static final char CLOSE_OPEN_STAGE = '1';
    public static final char OPEN_STAGE = '2';
    public static final char YES = 'Y';
    public static final char NO = 'N';
    public static final String PLACEMENT = "PLA";
    public static final String SUSTAINED = "SUS";
    public static final int SUB005 = 0;
    public static final int SUB028 = 1;
    public static final int SUB030 = 2;
    public static final int SUB031 = 3;
    public static final int SUB032 = 4;
    public static final int SUB033 = 5;
    public static final int SUB034 = 6;
    public static final int SUB035 = 7;
    public static final int SUB036 = 8;
    public static final int SUB037 = 9;
    public static final int SUB038 = 10;
    public static final int SUB039 = 11;
    public static final int SUB041 = 12;
    public static final int SUB042 = 13;
    public static final int SUB048 = 14;
    public static final int FAD050 = 15;
    public static final String TODO_INFO_05_CODE = "SUB005";
    public static final String TODO_INFO_28_CODE = "SUB028";
    public static final String TODO_INFO_30_CODE = "SUB030";
    public static final String TODO_INFO_31_CODE = "SUB031";
    public static final String TODO_INFO_32_CODE = "SUB032";
    public static final String TODO_INFO_33_CODE = "SUB033";
    public static final String TODO_INFO_34_CODE = "SUB034";
    public static final String TODO_INFO_35_CODE = "SUB035";
    public static final String TODO_INFO_36_CODE = "SUB036";
    public static final String TODO_INFO_37_CODE = "SUB037";
    public static final String TODO_INFO_38_CODE = "SUB038";
    public static final String TODO_INFO_39_CODE = "SUB039";
    public static final String TODO_INFO_41_CODE = "SUB041";
    public static final String TODO_INFO_42_CODE = "SUB042";
    public static final String TODO_INFO_48_CODE = "SUB048";
    public static final String TODO_INFO_FAD50_CODE = "FAD050";
    
    public static final String WAS_PLACED_ON = " was placed on ";
    public static final String EVENT_DESCRIPTION = "Pal FollowUp Information";
    public static final String CAPACITY_EXCEEDED = "Capacity exceeded by ";
    public static final String CAPACITY_EXCEEDED1 = ".  Remove a child/Change capacity.";
    public static final int MAX_MONTH = 12;
    public static final int MAX_DAY = 31;
    public static final int MAX_YEAR = 4712;
    public static final int INITIAL_PAGE = 1;
    public static final int PAGE_SIZE_NBR = 50;
    
    public static final int PAGE_SIZE = 10;
    
    /* define SIR 21130b*/
    public static final int ID_PLCEMNT = 0;
    public static final int ID_CLOSURE = 1;
    public static final int CLOSURE_STATUS = 2;
    public static final char UPDATE = 'U';
    /* end define SIR 21130b*/
    
    /*
    ** IMPACT BEGIN - macros for security attribute check
    */
    public static final char LT_ONE = '1';
    public static final int SEC_ADOPT_ASSIST_SPEC = 71;
    /*
    ** Declare local variables
    */
    /* The ARC_SUCCESS initializtion has been added to the following line
    ** so that the logic relevant exiting out of the loop in this function
    ** will work correctly.
    */
    public static final String PRIV_AGENCY_ADPT_HOME = "71";
    public static final String FPS_FA_HOME = "70";
    //## END TUX/XML: Declare XML variables
    
    
    //## BEGIN TUX/XML: Turn the XML buffer into an input message struct
    /* Allocate the Input message that will be used within the service */
    static CSUB26SI pInputMsg = null;
    CSUB26SO CSUB26S(CSUB26SI csub26si) {
        CSUB26SO csub26so = new CSUB26SO();
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
        int i424 = 0;
        int j = 0;
        int iLoopCounter = 0;
        int lRC11 = 0;
        FndInt3date CurrentDate = null;
        String ToDoFlags = new String();
        String szCdEligSelected1 = new String();
        String szDateString = new String();
        int ulNbrStagesOpen = 0;
        int ulIdFadWorker = 0;
        int ulIdEligibilityWorker = 0;
        int ulIdPalWorker1 = 0;
        int ulIdAdoptSubWorker = 0;
        int ulIdSendPalFollowUp = 0;
        int ulIdHomeStage = 0;
        int ulIdPalStage1 = 0;
        int ulIdFadRecruiter = 0;
        int lOpenSlots = 0;/* 14113 */
        String szCdRsrcFacilType1 = new String();
        Pint bIndEvent = new Pint();/*indicator for closure event status, if PEND it
        ** will be set to FALSE*/
        bIndEvent.value = 1;
        int ulIdEvent29 = 0;
        int usUpdateSlots = 0;/* SIR 23223 */
        
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        CCMN05UI pCCMN05UInputRec = null;/* Invalidate Approval common function */
        
        CCMN05UO pCCMN05UOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* Post Event common function */
        CCMN01UO pCCMN01UOutputRec = null;
        CINV43DI pCINV43DInputRec = null;/* Sir 3513 TODO Update Dam */
        CINV43DO pCINV43DOutputRec = null;/* Sir 3513 TODO Update Dam */
        CAUD45DI pCAUD45DInputRec = null;/* Placement Generic AUD dam           */
        
        CAUD45DO pCAUD45DOutputRec = null;
        CSES37DI pCSES37DInputRec = null;/* Placement simple retrieve           */
        
        CSES37DO pCSES37DOutputRec = null;
        CMSC09DI pCMSC09DInputRec = null;/* Nbr of other SUBCARE stages in case */
        
        CMSC09DO pCMSC09DOutputRec = null;
        CAUD99DI pCAUD99DInputRec = null;
        
        CAUD99DO pCAUD99DOutputRec = null;
        CCMNB8DI pCCMNB8DInputRec = null;/* Stage progression simple retrieve   */
        
        CCMNB8DO pCCMNB8DOutputRec = null;
        CCMN03UI pCCMN03UInputRec = null;/* CloseOpenStage common function      */
        
        CCMN03UO pCCMN03UOutputRec = null;
        CSES38DI pCSES38DInputRec = null;/* Eligibility simple retrieve         */
        CSES38DO pCSES38DOutputRec = null;
        CSEC29DI pCSEC29DInputRec = null;/* Stage & StagePersonLink retrieve    */
        
        CSEC29DO pCSEC29DOutputRec = null;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        CMSC23DI pCMSC23DInputRec = null;/* Full Retrieve from StagePersonLink  */
        CMSC23DO pCMSC23DOutputRec = null;/* given a particular Person*/
        CCMNB9DI pCCMNB9DInputRec = null;/* Use IdStage from StagePersonLink to */
        CCMNB9DO pCCMNB9DOutputRec = null;/* to obtain Persons (staff) in stage  */
        
        /* Remove CSEC30D - Adoption Subsidy Retrieve */
        /* SIR#3949: Add CMSC23D, CCMNB9D, CCMN31D to obtain Adopt Subsidy Worker  */
        
        
        /*
        ** IMPACT BEGIN - Replaced call to CCMN31D with a call to CLSCB4D
        **
        **  _CCMN31DI       *pCCMN31DInputRec;  * Employee Skills simple retrieve     *
        **  _CCMN31DO       *pCCMN31DOutputRec;
        */
        CLSCB4DI pCLSCB4DInputRec = null;
        CLSCB4DO pCLSCB4DOutputRec = null;
        CRES04DI pCRES04DInputRec = null;/* Caps_resource simple retrieve       */
        /*
        ** IMPACT END
        */
        CRES04DO pCRES04DOutputRec = null;
        CSEC37DI pCSEC37DInputRec = null;/* Find employee with skill retrieve   */
        
        CSEC37DO pCSEC37DOutputRec = null;
        CMSC14DI pCMSC14DInputRec = null;/* Check # of PAL training elements    */
        
        CMSC14DO pCMSC14DOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;/* ToDo common function: from ToDoInfo */
        
        CSUB40UO pCSUB40UOutputRec = null;
        CLSS69DI pCLSS69DInputRec = null;/* SIR #20339 */
        CLSS69DO pCLSS69DOutputRec = null;/* SIR #20339 */
        
        
        /*
        ** Call CCMN45D
        */
        rc = ARC_PRFServiceStartTime_TUX(csub26si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields
        */
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub26si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(csub26si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(csub26si.getROWCCMN01UIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(csub26si.getROWCCMN01UIG00().getSzCdTask());
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
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
        
        if (SUCCESS == RetVal) {
            
            if (0 == csub26si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(CLOSURE_STATUS).compareTo(PEND)) {
                csub26so.setUlIdEvent(csub26si.getROWCCMN01UIG00().getUlIdEvent());
                
                pCCMN05UInputRec = new CCMN05UI();
                
                pCCMN05UOutputRec = new CCMN05UO();
                pCCMN05UInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                pCCMN05UInputRec.setUlIdEvent(csub26si.getUlIdEvent_ARRAY().getUlIdEvent(ID_CLOSURE));
                rc = Ccmn05u.InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
                
                if (WtcHelperConstants.ARC_SUCCESS != rc) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                if (false == csub26si.getArchInputStruct().getUlSysNbrReserved1()) {
                    bIndEvent.value = 1;
                    
                    
                    //  Call CSYS06D
                    rc = Ccmn35s.CallCCMN62D(csub26si, csub26so, bIndEvent, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            if (0 == csub26si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(CURRENT).compareTo(PEND)) {
                csub26so.setUlIdEvent(csub26si.getROWCCMN01UIG00().getUlIdEvent());
                
                pCCMN05UInputRec = new CCMN05UI();
                
                
                pCCMN05UOutputRec = new CCMN05UO();
                pCCMN05UInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                pCCMN05UInputRec.setUlIdEvent(csub26si.getROWCCMN01UIG00().getUlIdEvent());
                
                
                //  Set rc to ARC_SUCCESS
                rc = Ccmn05u.InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
                
                if (WtcHelperConstants.ARC_SUCCESS != rc) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            //  SIR 2766 - If the date returned from the DAM is NULL_DATE,
            // then an initial contact has not been performed to begin an
            // investigation, so a warning message should be returned to
            // the client
            // SIR 4201: converted cases will not have contacts.  Thus,
            // if this DAM returns null_date and a DtlBegun already
            // has a value in the output message, we should NOT return an
            // error.
            
            //  CASE 1:  A case created using CAPS & no contact is recorded
            if ((0 == csub26si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(CLOSURE_STATUS).compareTo(PEND)) && (WtcHelperConstants.REQ_FUNC_CD_ADD != csub26si.getArchInputStruct().getCReqFuncCd()) && (false == csub26si.getArchInputStruct().getUlSysNbrReserved1())) {
                bIndEvent.value = 0;
                
                
                //  Set rc to ARC_SUCCESS
                rc = Ccmn35s.CallCCMN62D(csub26si, csub26so, bIndEvent, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            
            else {
                
                
                // 
                // (BEGIN): Common Function: ccmn01u   Post Event common function
                // 
                //  Allocate memory for Common Function Input and Output Structures
                pCCMN01UInputRec = new CCMN01UI();
                
                pCCMN01UOutputRec = new CCMN01UO();
                pCCMN01UInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub26si.getROWCCMN01UIG00().getUlIdEvent());
                
                pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub26si.getROWCCMN01UIG00().getTsLastUpdate());
                
                
                //  Set rc to ARC_SUCCESS
                rc = ARC_UTLGetDateAndTime(CurrentDate, 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(CurrentDate);
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub26si.getROWCCMN01UIG00().getUlIdStage());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub26si.getROWCCMN01UIG00().getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub26si.getROWCCMN01UIG00().getSzCdTask());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub26si.getROWCCMN01UIG00().getSzCdEventStatus());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub26si.getROWCCMN01UIG00().getSzCdEventType());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub26si.getROWCCMN01UIG00().getSzTxtEventDescr());
                
                //  CASE1:
                if (!(NEW.compareTo(csub26si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(CURRENT)) != 0) ||!(NULL_STRING.compareTo(csub26si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(CURRENT)) != 0)) {
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
                    pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                if (0 == csub26si.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                else {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                }
                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        ulIdEvent29 = pCCMN01UOutputRec.getUlIdEvent();
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        csub26so.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                        csub26so.getTsLastUpdate_ARRAY().setTsLastUpdate(EVENT, pCCMN01UOutputRec.getTsLastUpdate());
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
        if (rc == WtcHelperConstants.SQL_SUCCESS) {
            
            //  Copy the Contact Date into the output message, so long as
            // the date is not null
            if (0 != csub26si.getROWCCMN01UIG00().getUlIdEvent()) {
                
                // 
                // (BEGIN): Update DAM: cinv43d      ToDo Complete AUD dam: update only
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCINV43DInputRec = new CINV43DI();
                
                pCINV43DOutputRec = new CINV43DO();
                pCINV43DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                pCINV43DInputRec.setUlIdEvent(csub26si.getROWCCMN01UIG00().getUlIdEvent());
                rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Call CINT21D
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        break;
                }
            }
            // 
            // (END): Update DAM: cinv43d      ToDo Complete AUD dam: update only
            // 
            
            // 
            // (BEGIN): Add/Update AUD DAM: caud45d      Placement Generic AUD dam
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCAUD45DInputRec = new CAUD45DI();
            
            pCAUD45DOutputRec = new CAUD45DO();
            pCAUD45DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
            
            if ((WtcHelperConstants.REQ_FUNC_CD_UPDATE == csub26si.getArchInputStruct().getCReqFuncCd()) && (INDICATOR_YES == csub26si.getSysIndNewActualPlcmt())) {
                pCAUD45DInputRec.getArchInputStruct().setCReqFuncCd(csub26si.getSysIndNewActualPlcmt());
            }
            else {
                pCAUD45DInputRec.getArchInputStruct().setCReqFuncCd(csub26si.getArchInputStruct().getCReqFuncCd());
            }
            pCAUD45DInputRec.setBSysIndPrfrmValidation(csub26si.getBSysIndPrfrmValidation());
            
            if (0 == csub26si.getROWCCMN01UIG00().getUlIdEvent()) {
                pCAUD45DInputRec.setUlIdPlcmtEvent(csub26so.getUlIdEvent());
            }
            else // (0 != pInputMsg->ROWCCMN01UIG00.ulIdEvent)
            {
                pCAUD45DInputRec.setUlIdPlcmtEvent(csub26si.getROWCCMN01UIG00().getUlIdEvent());
                pCAUD45DInputRec.setTsLastUpdate(csub26si.getCSUB26SIG00().getTsLastUpdate());
            }
            pCAUD45DInputRec.setUlIdStage(csub26si.getROWCCMN01UIG00().getUlIdStage());
            pCAUD45DInputRec.setUlIdCase(csub26si.getUlIdCase());
            pCAUD45DInputRec.setCIndPlcmtWriteHistory(csub26si.getCSUB26SIG00().getCIndPlcmtWriteHistory());
            pCAUD45DInputRec.setUlIdPlcmtAdult(csub26si.getCSUB26SIG00().getUlIdPlcmtAdult());
            pCAUD45DInputRec.setUlIdPlcmtChild(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
            pCAUD45DInputRec.setUlIdContract(csub26si.getCSUB26SIG00().getUlIdContract());
            pCAUD45DInputRec.setUlIdRsrcAgency(csub26si.getCSUB26SIG00().getUlIdRsrcAgency());
            pCAUD45DInputRec.setUlIdRsrcFacil(csub26si.getCSUB26SIG00().getUlIdRsrcFacil());
            
            pCAUD45DInputRec.setSzAddrPlcmtCity(csub26si.getCSUB26SIG00().getSzAddrPlcmtCity());
            pCAUD45DInputRec.setSzAddrPlcmtCnty(csub26si.getCSUB26SIG00().getSzAddrPlcmtCnty());
            pCAUD45DInputRec.setSzAddrPlcmtLn1(csub26si.getCSUB26SIG00().getSzAddrPlcmtLn1());
            pCAUD45DInputRec.setSzAddrPlcmtLn2(csub26si.getCSUB26SIG00().getSzAddrPlcmtLn2());
            pCAUD45DInputRec.setSzAddrPlcmtSt(csub26si.getCSUB26SIG00().getSzAddrPlcmtSt());
            pCAUD45DInputRec.setSzAddrPlcmtZip(csub26si.getCSUB26SIG00().getSzAddrPlcmtZip());
            pCAUD45DInputRec.setSzCdPlcmtLivArr(csub26si.getCSUB26SIG00().getSzCdPlcmtLivArr());
            pCAUD45DInputRec.setSzCdPlcmtRemovalRsn(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn());
            pCAUD45DInputRec.setSzCdPlcmtActPlanned(csub26si.getCSUB26SIG00().getSzCdPlcmtActPlanned());
            pCAUD45DInputRec.setSzCdPlcmtType(csub26si.getCSUB26SIG00().getSzCdPlcmtType());
            
            pCAUD45DInputRec.setSzCdPlcmtService(csub26si.getCSUB26SIG00().getSzCdPlcmtService());
            pCAUD45DInputRec.setDtDtPlcmtCaregvrDiscuss(csub26si.getCSUB26SIG00().getDtDtPlcmtCaregvrDiscuss());
            pCAUD45DInputRec.setDtDtPlcmtChildDiscuss(csub26si.getCSUB26SIG00().getDtDtPlcmtChildDiscuss());
            pCAUD45DInputRec.setDtDtPlcmtChildPlan(csub26si.getCSUB26SIG00().getDtDtPlcmtChildPlan());
            pCAUD45DInputRec.setDtDtPlcmtEducLog(csub26si.getCSUB26SIG00().getDtDtPlcmtEducLog());
            
            if ((DateHelper.NULL_DATE == csub26si.getCSUB26SIG00().getDtDtPlcmtEnd().day) && (DateHelper.NULL_DATE == csub26si.getCSUB26SIG00().getDtDtPlcmtEnd().month) && (DateHelper.NULL_DATE == csub26si.getCSUB26SIG00().getDtDtPlcmtEnd().year)) {
                pCAUD45DInputRec.getDtDtPlcmtEnd().month = MAX_MONTH;
                
                pCAUD45DInputRec.getDtDtPlcmtEnd().day = MAX_DAY;
                pCAUD45DInputRec.getDtDtPlcmtEnd().year = MAX_YEAR;
            }
            else {
                pCAUD45DInputRec.setDtDtPlcmtEnd(csub26si.getCSUB26SIG00().getDtDtPlcmtEnd());
            }
            pCAUD45DInputRec.setDtDtPlcmtMeddevHistory(csub26si.getCSUB26SIG00().getDtDtPlcmtMeddevHistory());
            pCAUD45DInputRec.setDtDtPlcmtParentsNotif(csub26si.getCSUB26SIG00().getDtDtPlcmtParentsNotif());
            pCAUD45DInputRec.setDtDtPlcmtPreplaceVisit(csub26si.getCSUB26SIG00().getDtDtPlcmtPreplaceVisit());
            pCAUD45DInputRec.setDtDtPlcmtSchoolRecords(csub26si.getCSUB26SIG00().getDtDtPlcmtSchoolRecords());
            pCAUD45DInputRec.setDtDtPlcmtPermEff(csub26si.getDtDtPlcmtPermEff());
            pCAUD45DInputRec.setDtDtPlcmtStart(csub26si.getCSUB26SIG00().getDtDtPlcmtStart());
            pCAUD45DInputRec.setCIndPlcmtContCntct(csub26si.getCSUB26SIG00().getCIndPlcmtContCntct());
            pCAUD45DInputRec.setCIndPlcmtEducLog(csub26si.getCSUB26SIG00().getCIndPlcmtEducLog());
            pCAUD45DInputRec.setCIndPlcmetEmerg(csub26si.getCSUB26SIG00().getCIndPlcmetEmerg());
            pCAUD45DInputRec.setCIndPlcmtNotApplic(csub26si.getCSUB26SIG00().getCIndPlcmtNoneApply());
            pCAUD45DInputRec.setCIndPlcmtSchoolDoc(csub26si.getCSUB26SIG00().getCIndPlcmtSchoolDoc());
            pCAUD45DInputRec.setSzNbrPlcmtPhoneExt(csub26si.getCSUB26SIG00().getSzNbrPlcmtPhoneExt());
            pCAUD45DInputRec.setSzNbrPlcmtTelephone(csub26si.getCSUB26SIG00().getSzNbrPlcmtTelephone());
            pCAUD45DInputRec.setSzNmPlcmtAgency(csub26si.getCSUB26SIG00().getSzNmPlcmtAgency());
            pCAUD45DInputRec.setSzNmPlcmtContact(csub26si.getCSUB26SIG00().getSzNmPlcmtContact());
            
            //## BEGIN TUX/XML: Declare XML variables 
            pCAUD45DInputRec.setSzNmPlcmtFacil(csub26si.getCSUB26SIG00().getSzNmPlcmtFacil());
            pCAUD45DInputRec.setSzNmPlcmtPersonFull(csub26si.getCSUB26SIG00().getSzNmPlcmtPersonFull());
            pCAUD45DInputRec.setSzTxtPlcmtAddrComment(csub26si.getCSUB26SIG00().getSzTxtPlcmtAddrComment());
            pCAUD45DInputRec.setSzTxtPlcmtDiscussion(csub26si.getCSUB26SIG00().getSzTxtPlcmtDiscussion());
            pCAUD45DInputRec.setSzTxtPlcmtDocuments(csub26si.getCSUB26SIG00().getSzTxtPlcmtDocuments());
            pCAUD45DInputRec.setSzTxtPlcmtRemovalRsn(csub26si.getCSUB26SIG00().getSzTxtPlcmtRemovalRsn());
            pCAUD45DInputRec.setSzCdPlcmtInfo1(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(0));
            pCAUD45DInputRec.setSzCdPlcmtInfo2(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(1));
            pCAUD45DInputRec.setSzCdPlcmtInfo3(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(2));
            pCAUD45DInputRec.setSzCdPlcmtInfo4(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(3));
            pCAUD45DInputRec.setSzCdPlcmtInfo5(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(4));
            pCAUD45DInputRec.setSzCdPlcmtInfo6(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(5));
            pCAUD45DInputRec.setSzCdPlcmtInfo7(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(6));
            
            // 
            // SIR 16037: Add call to update when user logs into CAPS Toolbar  CWC
            // 
            
            //  BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            
            pCAUD45DInputRec.setSzCdPlcmtInfo8(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(7));
            pCAUD45DInputRec.setSzCdPlcmtInfo9(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(8));
            pCAUD45DInputRec.setSzCdPlcmtInfo10(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(9));
            pCAUD45DInputRec.setSzCdPlcmtInfo11(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(10));
            pCAUD45DInputRec.setSzCdPlcmtInfo12(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(11));
            pCAUD45DInputRec.setSzCdPlcmtInfo13(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(12));
            pCAUD45DInputRec.setSzCdPlcmtInfo14(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(13));
            pCAUD45DInputRec.setSzCdPlcmtInfo15(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(14));
            pCAUD45DInputRec.setSzCdPlcmtInfo16(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(15));
            pCAUD45DInputRec.setSzCdPlcmtInfo17(csub26si.getCSUB26SIG01().getSzCdPlcmtInfo_ARRAY().getSzCdPlcmtInfo(16));
            lRC11 = ARC_UTLCompareDateAndTime((FndInt3date) & csub26si.getCSUB26SIG00().getDtDtPlcmtStart() , (char) 0, (FndInt3date) & pCAUD45DInputRec.getDtDtPlcmtEnd() , (char) 0);
            
            if (lRC11 <= 0) {
                rc = caud45dAUDdam(sqlca, pCAUD45DInputRec, pCAUD45DOutputRec);
            }
            
            else {
                rc = WtcHelperConstants.SQL_SUCCESS;
                pCAUD45DOutputRec.setUlSysNbrValidationMsg(Messages.MSG_ERR_BAD_FUNC_CD);
            }
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                case NO_DATA_FOUND:
                    
                    if ((WtcHelperConstants.REQ_FUNC_CD_UPDATE == csub26si.getArchInputStruct().getCReqFuncCd()) && (NO_DATA_FOUND == rc)) {
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    }
                    else // ADD = cReqFuncCd OR (UPDATE = cReqFuncCd & rc = SQL_SUCCESS)
                    {
                        pServiceStatus.explan_code = pCAUD45DOutputRec.getUlSysNbrValidationMsg();
                        
                        if (0 < pCAUD45DOutputRec.getUlSysNbrValidationMsg()) {
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                        }
                        else // (0 == pCAUD45DOutputRec->ulSysNbrValidationMsg)
                        {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            
                            if (INDICATOR_YES == csub26si.getBSysIndGeneric()) {
                                // 
                                // (BEGIN): Retrieve DAM: cses37d      Placement simple retrieve
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCSES37DInputRec = new CSES37DI();
                                
                                pCSES37DOutputRec = new CSES37DO();
                                pCSES37DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                pCSES37DInputRec.setUlIdPlcmtEvent(pCAUD45DInputRec.getUlIdPlcmtEvent());
                                
                                
                                //  Call CINV81D
                                rc = cses37dQUERYdam(sqlca, pCSES37DInputRec, pCSES37DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub26so.getTsLastUpdate_ARRAY().setTsLastUpdate(PLCMT, pCSES37DOutputRec.getTsLastUpdate());
                                        break;// break for CLSS67D
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        break;
                                }
                            }
                        }
                    }
                    
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            // END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            
            
            
            
        }
        if (SUCCESS == RetVal) {
            if (!(ACTUAL.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtActPlanned()) != 0) && INDICATOR_YES == csub26si.getCSysIndPlcmtChgAdrAdm() && Cint14s.INDICATOR_NO == csub26si.getCSysIndPlcmtDifMedAdr() || Cint14s.INDICATOR_NO == csub26si.getCSysIndPlcmtDifMedAdr() && INDICATOR_YES == csub26si.getSysIndNewActualPlcmt()) {
                // 
                // (BEGIN): Add/Update AUD DAM: caud99d      Medicaid_update AUD dam
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCAUD99DInputRec = new CAUD99DI();
                
                pCAUD99DOutputRec = new CAUD99DO();
                pCAUD99DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                pCAUD99DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCAUD99DInputRec.setUlIdMedUpdRecord(csub26so.getUlIdEvent());
                pCAUD99DInputRec.setUlIdMedUpdPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
                pCAUD99DInputRec.setUlIdMedUpdStage(csub26si.getROWCCMN01UIG00().getUlIdStage());
                pCAUD99DInputRec.setSzCdMedUpdType(PLACEMENT);
                pCAUD99DInputRec.setSzCdMedUpdTransTypE(SUSTAINED);
                
                
                //  Set rc to ARC_SUCCESS
                rc = caud99dAUDdam(sqlca, pCAUD99DInputRec, pCAUD99DOutputRec);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                        
                    default :
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        break;
                }
            }
        }
        
        if (SUCCESS == RetVal && INDICATOR_YES == csub26si.getSysIndNewRemovalPlcmt() && (!(RETURN_HOME.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0) ||!(ADOPTION.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0))) {
            
            if (!(RETURN_HOME.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0)) {
                // 
                // (BEGIN): Retrieve DAM: cmsc09d      Nbr of other SUBCARE stages in case
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCMSC09DInputRec = new CMSC09DI();
                
                pCMSC09DOutputRec = new CMSC09DO();
                pCMSC09DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                pCMSC09DInputRec.setSzCdStage(SUBCARE);
                
                pCMSC09DInputRec.setUlIdCase(csub26si.getUlIdCase());
                pCMSC09DInputRec.setUlIdStage(csub26si.getROWCCMN01UIG00().getUlIdStage());
                
                
                //  Set rc to ARC_SUCCESS
                rc = cmsc09dQUERYdam(sqlca, pCMSC09DInputRec, pCMSC09DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Populate ulNbrStagesOpen
                        ulNbrStagesOpen = pCMSC09DOutputRec.getUlSysNbrGenericCntr();
                        
                        // WE PROBABLY DONT NEED THIS CASE
                        
                        break;
                        
                    default :
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        break;
                }
            }
            
            if ((SUCCESS == RetVal) && (0 == ulNbrStagesOpen)) {
                // 
                // (BEGIN): Retrieve DAM: ccmnb8d      Stage progression simple retrieve
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCCMNB8DInputRec = new CCMNB8DI();
                
                pCCMNB8DOutputRec = new CCMNB8DO();
                pCCMNB8DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                pCCMNB8DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                
                pCCMNB8DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NBR);
                pCCMNB8DInputRec.setSzCdStage(SUBCARE);
                pCCMNB8DInputRec.setSzCdStageProgram(Csub38s.CAPS_PROG_CPS);
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (!(RETURN_HOME.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0)) {
                    
                    pCCMNB8DInputRec.setSzCdStageReasonClosed(FAM_REUNIF);
                }
                else if (!(ADOPTION.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0)) {
                    pCCMNB8DInputRec.setSzCdStageReasonClosed(ADOPT);
                }
                rc = ccmnb8dQUERYdam(sqlca, pCCMNB8DInputRec, pCCMNB8DOutputRec);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        if ((CLOSE_OPEN_STAGE == pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getBIndStageProgClose()) || (OPEN_STAGE == pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getBIndStageProgClose())) {
                            // 
                            // (BEGIN): Common Function: ccmn03u   CloseOpenStage common function
                            // 
                            //  Allocate memory for Common Function Input and Output Structures
                            pCCMN03UInputRec = new CCMN03UI();
                            
                            pCCMN03UOutputRec = new CCMN03UO();
                            pCCMN03UInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                            pCCMN03UInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                            pCCMN03UInputRec.setUlIdStage(csub26si.getROWCCMN01UIG00().getUlIdStage());
                            
                            pCCMN03UInputRec.setSzCdStageProgram(Csub38s.CAPS_PROG_CPS);
                            pCCMN03UInputRec.setUlIdPerson(csub26si.getROWCCMN01UIG00().getUlIdPerson());
                            pCCMN03UInputRec.setSzCdStage(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgRsnClosed());
                            pCCMN03UInputRec.setSzCdStageOpen(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgOpen());
                            pCCMN03UInputRec.setSzCdStageReasonClosed(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgRsnClosed());
                            pCCMN03UInputRec.setDtDtStageStart(csub26si.getCSUB26SIG00().getDtDtPlcmtEnd());
                            pCCMN03UInputRec.setUlScrIdPrimChild(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
                            if (CLOSE_OPEN_STAGE == pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getBIndStageProgClose()) {
                                pCCMN03UInputRec.setCSysIndSStgOpenOnly(NO);
                            }
                            if (OPEN_STAGE == pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getBIndStageProgClose()) {
                                
                                pCCMN03UInputRec.setCSysIndSStgOpenOnly(YES);
                            }
                            rc = Ccmn03u.CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    break;
                                    
                                default :
                                    //  Set RetVal to FND_FAIL
                                    RetVal = Csub50s.FND_FAIL;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        break;
                        
                    default :
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
        }
        
        if (SUCCESS == RetVal && (INDICATOR_YES == csub26si.getSysIndNewActualPlcmt() || INDICATOR_YES == csub26si.getSysIndNewRemovalPlcmt())) {
            if (0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacil() && 0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacil()) {
                rc = Cfad36s.CallCRES04D(csub26si, szCdRsrcFacilType1, csub26si.getCSUB26SIG00().getUlIdRsrcFacil() , pServiceStatus);
                
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:// Get Month
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            if (SUCCESS == RetVal && 0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacil() && (FPS_FA_HOME.equals(szCdRsrcFacilType1) || PRIV_AGENCY_ADPT_HOME.equals(szCdRsrcFacilType1))) {
                
                if (INDICATOR_YES == csub26si.getSysIndNewActualPlcmt()) {
                    usUpdateSlots = - 1;
                }
                else if (INDICATOR_YES == csub26si.getSysIndNewRemovalPlcmt()) {
                    usUpdateSlots = 1;
                }
                rc = CallCMSC16D(csub26si, csub26si.getCSUB26SIG00().getUlIdRsrcFacil() , usUpdateSlots, pServiceStatus);
                
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:// Get Day
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            
            // 
            // (BEGIN): Retrieve DAM: cses38d      Eligibility simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCSES38DInputRec = new CSES38DI();
            
            pCSES38DOutputRec = new CSES38DO();
            pCSES38DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
            pCSES38DInputRec.setUlIdPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
            
            //  Call DAM
            rc = cses38dQUERYdam(sqlca, pCSES38DInputRec, pCSES38DOutputRec);
            
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    if (WtcHelperConstants.SQL_SUCCESS == rc) {
                        ulIdEligibilityWorker = pCSES38DOutputRec.getUlIdPersonUpdate();
                        szCdEligSelected1 = pCSES38DOutputRec.getSzCdEligSelected();
                    }
                    // 
                    // (BEGIN): Retrieve DAM: csec29d      Stage & StagePersonLink retrieve
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCSEC29DInputRec = new CSEC29DI();
                    
                    pCSEC29DOutputRec = new CSEC29DO();
                    pCSEC29DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                    pCSEC29DInputRec.setUlIdCase(csub26si.getUlIdCase());
                    pCSEC29DInputRec.setUlIdPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
                    pCSEC29DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                    pCSEC29DInputRec.setSzCdStage(PAL);
                    //  Do nothing, the output message just returns success or failure
                    rc = csec29dQUERYdam(sqlca, pCSEC29DInputRec, pCSEC29DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ulIdPalStage1 = pCSEC29DOutputRec.getUlIdStage();
                            
                            if (0 < ulIdPalStage1) {
                                //  Determine Primary worker for the Pal Stage
                                // 
                                // (BEGIN): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCINV51DInputRec = new CINV51DI();
                                
                                pCINV51DOutputRec = new CINV51DO();
                                pCINV51DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                pCINV51DInputRec.setUlIdStage(pCSEC29DOutputRec.getUlIdStage());
                                pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
                                //  This employee does not have any other "OUT" assignments
                                rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                
                                
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        ulIdPalWorker1 = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                                        
                                        if (0 < pCINV51DOutputRec.getUlIdTodoPersAssigned() && (!(RETURN_HOME.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0) ||!(WITH_RELATIVES.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0) ||!(COURT_ORDERED.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0) ||!(EMANCIPATED.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0))) {
                                            //  PAL Training Elements processing
                                            // 
                                            // (BEGIN): Retrieve DAM: cmsc14d      Check # of PAL training elements
                                            // 
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCMSC14DInputRec = new CMSC14DI();
                                            
                                            pCMSC14DOutputRec = new CMSC14DO();
                                            pCMSC14DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                            pCMSC14DInputRec.setUlIdStage(pCSEC29DOutputRec.getUlIdStage());
                                            pCMSC14DInputRec.setUlIdPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
                                            rc = cmsc14dQUERYdam(sqlca, pCMSC14DInputRec, pCMSC14DOutputRec);
                                            switch (rc) {
                                                    
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    //  Populate the output message
                                                    ulIdSendPalFollowUp = pCMSC14DOutputRec.getUlSysNbrValidationMsg();
                                                    break;
                                                    
                                                default :
                                                    //  Set RetVal to FND_FAIL
                                                    RetVal = Csub50s.FND_FAIL;
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                        }
                                        break;
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            
                            if ((SUCCESS == RetVal) && (0 == ADOPT.compareTo(csub26si.getSzCdStage()))) {
                                //  Get Adoption Subsidy worker for the child
                                
                                //  SIR #20339 - 4/17/96 - PURCELA - Change the retrieval DAM from CSEC30D
                                // to CLSS69D.  The previous DAM was searching for Adoption Subsidies with
                                // end date of MAX DATE.  This could never happen.
                                
                                // 
                                // (BEGIN): Retrieve DAM: clss69d      Adoption_subsidy simple retrieve
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCLSS69DInputRec = new CLSS69DI();
                                
                                pCLSS69DOutputRec = new CLSS69DO();
                                pCLSS69DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                pCLSS69DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                pCLSS69DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE);
                                pCLSS69DInputRec.setUlAdptSubPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
                                pCLSS69DInputRec.setDtDtPersonDeath(csub26si.getCSUB26SIG00().getDtDtPlcmtEnd());
                                rc = clss69dQUERYdam(sqlca, pCLSS69DInputRec, pCLSS69DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        // 
                                        // Call the Stage Person Link Retrieval Dam - CMSC23D
                                        // Description - This DAM a list of Stages where the Id Person (and all
                                        // persons merged with them) are on the Stage Person Link.
                                        // 
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCMSC23DInputRec = new CMSC23DI();
                                        
                                        pCMSC23DOutputRec = new CMSC23DO();
                                        pCMSC23DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                        pCMSC23DInputRec.setUlIdPerson(pCLSS69DOutputRec.getROWCLSS69DO_ARRAY().getROWCLSS69DO(0).getUlAdptSubPerson());
                                        pCMSC23DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                        pCMSC23DInputRec.getArchInputStruct().setUlPageSizeNbr(CMSC23DO._CMSC23DO__ROWCMSC23DO_SIZE);
                                        rc = cmsc23dQUERYdam(sqlca, pCMSC23DInputRec, pCMSC23DOutputRec);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Determine if the current stage is an OPEN ADOPTION STAGE
                                                for (i424 = 0;i424 < pCMSC23DOutputRec.getArchOutputStruct().getUlRowQty() && ulIdAdoptSubWorker == 0;i424++) {
                                                    
                                                    if ((pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i424).getSzCdStage().equals(ADOPT)) && ((DateHelper.NULL_DATE == pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i424).getDtDtStageClose().year) && (DateHelper.NULL_DATE == pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i424).getDtDtStageClose().month) && (DateHelper.NULL_DATE == pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i424).getDtDtStageClose().day))) {
                                                        
                                                        //  Allocate memory for Input and Output Structures
                                                        pCCMNB9DInputRec = new CCMNB9DI();
                                                        pCCMNB9DOutputRec = new CCMNB9DO();
                                                        
                                                        if (pCCMNB9DInputRec == null) {
                                                            
                                                            //  Declare FOUNDATION variables
                                                            
                                                            //  Declare local variables
                                                            
                                                            //  Start performance timer for service
                                                            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                        }
                                                        
                                                        
                                                        if (pCCMNB9DOutputRec == null) {
                                                            
                                                            // SIR 21891 - missing versioning
                                                            //  Run-time Versioning
                                                            
                                                            //  Check buffer size
                                                            
                                                            //  Process error message and return to client
                                                            
                                                            //  Initialize output message and length
                                                            
                                                            //  Initialize service status fields
                                                            
                                                            // 
                                                            // Call DAMs to retrieve data
                                                            // 
                                                            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                        }
                                                        pCCMNB9DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                                        pCCMNB9DInputRec.setUlIdStage(pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i424).getUlIdStage());
                                                        pCCMNB9DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                                        pCCMNB9DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO._CCMNB9DO__ROWCCMNB9DO_SIZE);
                                                        rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
                                                        
                                                        
                                                        //  Analyze return code
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                //  Populate output message
                                                                for (j = 0;j < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty() && ulIdAdoptSubWorker == 0;++j) {
                                                                    
                                                                    if (0 == STAFF.compareTo(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(j).getSzCdStagePersType())) {
                                                                        //  IMPACT BEGIN - Replaced call to CCMN31D with a call to CLSCB4D
                                                                        // BEGIN Retrieval for CCMN31D EMPLOYEE SKILLS   
                                                                        // Allocate memory for DAM Input and Output Structures
                                                                        // pCCMN31DInputRec =
                                                                        // (_CCMN31DI *) malloc(sizeof(_CCMN31DI));
                                                                        // if (pCCMN31DInputRec == NULL)
                                                                        // {
                                                                        // rc = ARC_ERR_MALLOC_FAILED;
                                                                        // PROCESS_TUX_RC_ERROR;
                                                                        // }
                                                                        // pCCMN31DOutputRec =
                                                                        // (_CCMN31DO *) malloc(sizeof(_CCMN31DO));
                                                                        // if (pCCMN31DOutputRec == NULL)
                                                                        // {
                                                                        // free(pCCMN31DInputRec);
                                                                        // rc = ARC_ERR_MALLOC_FAILED;
                                                                        // PROCESS_TUX_RC_ERROR;
                                                                        // }
                                                                        // Initialize DAM Input and Output Structures
                                                                        // memset( pCCMN31DInputRec, NULL, sizeof(_CCMN31DI));
                                                                        // memset( pCCMN31DOutputRec, NULL, sizeof(_CCMN31DO));
                                                                        // Populate DAM input structure
                                                                        // Use IdPerson Returned from CCMNB9
                                                                        // as input to Employee skills check
                                                                        // pCCMN31DInputRec->ulIdPerson =
                                                                        // pCCMNB9DOutputRec->ROWCCMNB9DO[j].ulIdPerson;
                                                                        // Start DAM Performance Timer
                                                                        // ARC_PRFDataAccessStartTime("CCMN31D");
                                                                        // Call CCMN31D
                                                                        // rc=ccmn31dQUERYdam((void *)&sqlca,
                                                                        // pCCMN31DInputRec,
                                                                        // pCCMN31DOutputRec);
                                                                        // Stop DAM Performance Timer
                                                                        // ARC_PRFDataAccessStopTime();
                                                                        // Added SQL_NOT_FOUND in the case
                                                                        // that the employee has no skills
                                                                        // Analyze return code for CCMN31D
                                                                        // switch(rc)
                                                                        // {
                                                                        // case SQL_SUCCESS:
                                                                        // Set severity to FND_SEVERITY_OK *
                                                                        // pServiceStatus->severity = FND_SEVERITY_OK;
                                                                        // Set explan_code to FND_SUCCESS  *
                                                                        // pServiceStatus->explan_code = FND_SUCCESS;
                                                                        // CHECK THE ULROWQTY AND CDEMPSKILL
                                                                        // FIELDS IN THE DAM WHEN IT IS CREATED
                                                                        // for(iLoopCounter = 0;
                                                                        // ((iLoopCounter < pCCMN31DOutputRec->ArchOutputStruct.ulRowQty)
                                                                        // && (FALSE == bSkillFound));
                                                                        // iLoopCounter++)
                                                                        // {
                                                                        // if(0 == strcmp(pCCMN31DOutputRec->szCdEmpSkill[iLoopCounter],
                                                                        // ADOPTION_SUBSIDY_SPECIALIST))
                                                                        // {
                                                                        // bSkillFound = TRUE;
                                                                        // ulIdAdoptSubWorker =
                                                                        // pCCMNB9DOutputRec->ROWCCMNB9DO[j].ulIdPerson;
                                                                        // } * end if *
                                                                        // } * end for for skills loop *
                                                                        // break; *break for CASE SUCCESS and NOT_FOUND in CCMN31D*
                                                                        // case SQL_NOT_FOUND:
                                                                        // Set severity to FND_SEVERITY_OK *
                                                                        // pServiceStatus->severity = FND_SEVERITY_OK;
                                                                        // Set explan_code to FND_SUCCESS  *
                                                                        // pServiceStatus->explan_code = FND_SUCCESS;
                                                                        // break;
                                                                        // default:
                                                                        // PROCESS_TUX_SQL_ERROR;
                                                                        // RetVal = FND_FAIL;
                                                                        // break;
                                                                        // }*END switch for CCMN31D*
                                                                        // Free Memory from DAM Input and Output Structures
                                                                        // free(pCCMN31DInputRec);
                                                                        // free(pCCMN31DOutputRec);
                                                                        // END Retrieval for CCMN31D EMPLOYEE SKILLS
                                                                        // 
                                                                        //  Allocate memory for DAM Input and Output Structures
                                                                        pCLSCB4DInputRec = new CLSCB4DI();
                                                                        
                                                                        pCLSCB4DOutputRec = new CLSCB4DO();
                                                                        pCLSCB4DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                                                        pCLSCB4DInputRec.setUlIdPerson(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(j).getUlIdPerson());
                                                                        // 11/14/2002 DWW - Deleted bOKDuplicates to make service function more normally
                                                                        // BOOL             bOKDuplicates = TRUE;  /* for ERR#1797
                                                                        //  Start performance timer for service. All performance functions always
                                                                        // return success so there is no need to check status.
                                                                        rc = clscb4dQUERYdam(sqlca, pCLSCB4DInputRec, pCLSCB4DOutputRec);
                                                                        
                                                                        
                                                                        //  Analyze return code
                                                                        switch (rc) {
                                                                                
                                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                RetVal = SUCCESS;
                                                                                iLoopCounter = 0;// SIR#3949: Add loop counter variable
                                                                                
                                                                                //  loop through the returned security profiles looking for the
                                                                                // SEC_ADOPT_ASSIST_SPEC attribute
                                                                                for (ulIdAdoptSubWorker = 0;((iLoopCounter < pCLSCB4DOutputRec.getArchOutputStruct().getUlRowQty()) && (0 == ulIdAdoptSubWorker));iLoopCounter++) {
                                                                                    if (LT_ONE == pCLSCB4DOutputRec.getROWCLSCB4DO_ARRAY().getROWCLSCB4DO(iLoopCounter).getSzTxtSecurityClassProfil()[SEC_ADOPT_ASSIST_SPEC]) {
                                                                                        //  this person has the attribute so set the worker
                                                                                        ulIdAdoptSubWorker = pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(j).getUlIdPerson();
                                                                                    }
                                                                                }
                                                                                break;
                                                                                
                                                                                //  SIR #20075 - 4/2/96 - PURCELA - Added SQL NOT FOUND
                                                                                // case to compensate for no placements.
                                                                                
                                                                            case NO_DATA_FOUND:
                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                RetVal = SUCCESS;
                                                                                
                                                                                ulIdAdoptSubWorker = 0;
                                                                                break;
                                                                                
                                                                            default :
                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                RetVal = Csub50s.FND_FAIL;
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                break;
                                                                
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        }
                                                    }
                                                }
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                break;
                                        }
                                        
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        // DO NOT use ulIdAdptSubPayee. If NotFound, set worker to 0.
                                        // ulIdAdoptSubWorker = pCSEC30DOutputRec->ulIdAdptSubPayee;
                                        ulIdAdoptSubWorker = 0;
                                        
                                        break;
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            if (SUCCESS == RetVal && (!(FOST_ADOPT.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtType()) != 0) ||!(ADOPT.compareTo(csub26si.getSzCdStage()) != 0)) && 0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacil()) {
                                //  Get ulIdRsrcFaHomeStage given a ulIdResource
                                // 
                                // (BEGIN): Retrieve DAM: cres04d      Caps_resource simple retrieve
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCRES04DInputRec = new CRES04DI();
                                
                                pCRES04DOutputRec = new CRES04DO();
                                pCRES04DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                pCRES04DInputRec.setUlIdResource(csub26si.getCSUB26SIG00().getUlIdRsrcFacil());
                                
                                
                                //  Call CheckStageEventStatus
                                rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Populate the ulIdHomeStage variable
                                        ulIdHomeStage = pCRES04DOutputRec.getUlIdRsrcFaHomeStage();
                                        lOpenSlots = pCRES04DOutputRec.getSNbrRsrcOpenSlots();// 14113
                                        
                                        //  Get primary worker for the FAD Home
                                        // 
                                        // (BEGIN): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
                                        // 
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCINV51DInputRec = new CINV51DI();
                                        
                                        pCINV51DOutputRec = new CINV51DO();
                                        pCINV51DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                        pCINV51DInputRec.setUlIdStage(pCRES04DOutputRec.getUlIdRsrcFaHomeStage());
                                        
                                        pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
                                        
                                        //  Call CCMNB6D to retreive the ID_CASE for the given stage
                                        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  If rc = SQL_SUCCESS,   ulIdTodoPersAssigned will be > 0
                                                // If rc = SQL_NOT_FOUND, ulIdTodoPersAssigned will be = 0
                                                ulIdFadWorker = pCINV51DOutputRec.getUlIdTodoPersAssigned();
                                                if (pCRES04DOutputRec.getSzCdRsrcRegion().compareTo(CAPS_UNIT_STATE_OFFICE) != 0) {
                                                    // 
                                                    // (BEGIN): Retrieve DAM: csec37d      Find employee with skill retrieve
                                                    // 
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCSEC37DInputRec = new CSEC37DI();
                                                    
                                                    pCSEC37DOutputRec = new CSEC37DO();
                                                    pCSEC37DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                                                    pCSEC37DInputRec.setSzCdEmpSkill(RECRUITER);
                                                    pCSEC37DInputRec.setSzCdUnitProgram(Csub38s.CAPS_PROG_CPS);
                                                    if (!(pCRES04DOutputRec.getSzCdRsrcRegion().compareTo(CAPS_UNIT_SWI) != 0)) {
                                                        pCSEC37DInputRec.setSzCdUnitRegion(CAPS_REGION_SWI);
                                                    }
                                                    else {
                                                        pCSEC37DInputRec.getSzCdUnitRegion()[0] = '0';
                                                        pCSEC37DInputRec.getSzCdUnitRegion()[1] = pCRES04DOutputRec.getSzCdRsrcRegion()[0];
                                                        pCSEC37DInputRec.getSzCdUnitRegion()[2] = pCRES04DOutputRec.getSzCdRsrcRegion()[1];
                                                    }
                                                    
                                                    //  Call CLSC68D to retreive the ID_CASE for the given stage
                                                    rc = csec37dQUERYdam(sqlca, pCSEC37DInputRec, pCSEC37DOutputRec);
                                                    
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                            
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //  If rc = SQL_SUCCESS,   ulIdPerson will be > 0
                                                            // If rc = SQL_NOT_FOUND, ulIdPerson will be = 0
                                                            ulIdFadRecruiter = pCSEC37DOutputRec.getUlIdPerson();
                                                            break;
                                                            
                                                        default :
                                                            //  Set RetVal to FND_FAIL
                                                            RetVal = Csub50s.FND_FAIL;
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            break;
                                                    }
                                                }
                                                
                                                break;
                                                
                                            default :
                                                //  Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                break;
                                        }
                                        // 
                                        // End SIR #21969
                                        // 
                                        break;
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            break;
                            
                        default :
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (SUCCESS == RetVal && Cint14s.INDICATOR_NO == csub26si.getSysIndNewActualPlcmt() && Cint14s.INDICATOR_NO == csub26si.getSysIndNewRemovalPlcmt() && csub26si.getCSUB26SIG00().getUlIdRsrcFacil() != csub26si.getCSUB26SIG00().getUlIdRsrcFacilOriginal() && (DateHelper.NULL_DATE == csub26si.getCSUB26SIG00().getDtDtPlcmtEnd().day && DateHelper.NULL_DATE == csub26si.getCSUB26SIG00().getDtDtPlcmtEnd().month && DateHelper.NULL_DATE == csub26si.getCSUB26SIG00().getDtDtPlcmtEnd().year)) {
            if (0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacil() && 0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacil()) {
                rc = Cfad36s.CallCRES04D(csub26si, szCdRsrcFacilType1, csub26si.getCSUB26SIG00().getUlIdRsrcFacil() , pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                
            }
            if (SUCCESS == RetVal && 0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacil() && (FPS_FA_HOME.equals(szCdRsrcFacilType1) || PRIV_AGENCY_ADPT_HOME.equals(szCdRsrcFacilType1))) {
                rc = CallCMSC16D(csub26si, csub26si.getCSUB26SIG00().getUlIdRsrcFacil() , - 1, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            if (0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacilOriginal() && 0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacilOriginal()) {
                szCdRsrcFacilType1 = "";
                rc = Cfad36s.CallCRES04D(csub26si, szCdRsrcFacilType1, csub26si.getCSUB26SIG00().getUlIdRsrcFacilOriginal() , pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        //  Set RetVal to FND_FAIL
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            if (SUCCESS == RetVal && 0 != csub26si.getCSUB26SIG00().getUlIdRsrcFacilOriginal() && (FPS_FA_HOME.equals(szCdRsrcFacilType1) || PRIV_AGENCY_ADPT_HOME.equals(szCdRsrcFacilType1))) {
                rc = CallCMSC16D(csub26si, csub26si.getCSUB26SIG00().getUlIdRsrcFacilOriginal() , 1, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        
                        RetVal = Csub50s.FND_FAIL;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
        }
        if ((INDICATOR_YES == csub26si.getCSysIndPlcmtLocMatch()) && (0 == ulIdEligibilityWorker) && (SUCCESS == RetVal)) {
            // 
            // (BEGIN): Retrieve DAM: cses38d      Eligibility simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCSES38DInputRec = new CSES38DI();
            
            pCSES38DOutputRec = new CSES38DO();
            pCSES38DInputRec.setArchInputStruct(csub26si.getArchInputStruct());
            pCSES38DInputRec.setUlIdPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
            
            //  Victim
            // Get # of times the victim was named as a victim and
            // the number of times the perp was named as a victim
            // in other allegations within this stage, other than
            // the allegation being deleted. Counts will be stored
            // in ulIdVictim and ulIdAllegedPerpetrator, respectively,
            // (they have the right data type) then reset before
            // exiting the service.
            rc = cses38dQUERYdam(sqlca, pCSES38DInputRec, pCSES38DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    if (WtcHelperConstants.SQL_SUCCESS == rc) {
                        ulIdEligibilityWorker = pCSES38DOutputRec.getUlIdPersonUpdate();
                        szCdEligSelected1 = pCSES38DOutputRec.getSzCdEligSelected();
                    }
                    break;
                    
                default :
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            
            if (INDICATOR_YES == csub26si.getCSysIndPlcmtDifMedAdr()) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB005, true);
            }
            
            if (INDICATOR_YES == csub26si.getSysIndNewActualPlcmt() &&!(FOST_ADOPT.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtType()) != 0) && 0 < ulIdHomeStage && 0 < ulIdFadWorker) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB028, true);
            }
            
            if (INDICATOR_YES == csub26si.getSysIndNewActualPlcmt() && 0 < ulIdEligibilityWorker && FOST_ADOPT.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtType()) != 0 && CONTRACTED.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtType()) != 0 && NOT_ELIG.compareTo(szCdEligSelected1) != 0 && COUNTY_PAID.compareTo(szCdEligSelected1) != 0) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB030, true);
            }
            
            if ((INDICATOR_YES == csub26si.getSysIndNewRemovalPlcmt()) && (0 < ulIdPalStage1) && (0 < ulIdPalWorker1)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB031, true);
            }
            
            if ((INDICATOR_YES == csub26si.getCSysIndPlcmtLocMatch()) && (0 < ulIdEligibilityWorker)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB048, true);
            }
            else if ((INDICATOR_YES == csub26si.getCSysIndPlcmtLocMatch()) && (0 == ulIdEligibilityWorker)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB032, true);
            }
            if ((INDICATOR_YES == csub26si.getSysIndNewActualPlcmt()) && (INDICATOR_YES == csub26si.getCSysIndPlcmtFacCntrct())) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB035, true);
            }
            
            if ((INDICATOR_YES == csub26si.getSysIndNewActualPlcmt()) && (INDICATOR_YES == csub26si.getCSysIndPlcmtFacCntrct()) && (0 < ulIdEligibilityWorker)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB036, true);
            }
            
            if (INDICATOR_YES == csub26si.getSysIndNewRemovalPlcmt() && 0 < ulNbrStagesOpen &&!(RETURN_HOME.compareTo(csub26si.getCSUB26SIG00().getSzCdPlcmtRemovalRsn()) != 0)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB037, true);
            }
            
            if ((INDICATOR_YES == csub26si.getSysIndNewActualPlcmt()) && (0 < ulIdPalStage1) && (0 < ulIdPalWorker1)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB038, true);
            }
            
            if ((INDICATOR_YES == csub26si.getSysIndNewRemovalPlcmt()) && (0 < ulIdAdoptSubWorker)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB039, true);
            }
            if ((INDICATOR_YES == csub26si.getSysIndNewRemovalPlcmt()) && (ulIdSendPalFollowUp) && (0 < ulIdPalStage1) && (0 < ulIdPalWorker1)) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB041, true);
            }
            
            if (INDICATOR_YES == csub26si.getSysIndNewActualPlcmt() &&!(ADOPT.compareTo(csub26si.getSzCdStage()) != 0) && 0 < ulIdHomeStage && 0 < ulIdFadRecruiter) {
                ToDoFlags = CStringUtils.setCharAt(ToDoFlags, SUB042, true);
            }
        }
        
        if ((INDICATOR_YES == csub26si.getSysIndNewActualPlcmt()) && (0 < ulIdHomeStage) && (0 < ulIdFadWorker) && (0 > lOpenSlots)) {
            ToDoFlags = CStringUtils.setCharAt(ToDoFlags, FAD050, true);
        }
        
        /*
        ** Perp
        **
        ** Same as above for perp - # of times victim was named
        ** as a perp and # of times perp was named as a perp
        ** in other allegations in the stage.
        */
        rc = ARC_UTLGetDateAndTime(CurrentDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCSUB40UInputRec = new CSUB40UI();
        
        pCSUB40UOutputRec = new CSUB40UO();
        
        for (i424 = 0;((i424 <= FAD050) && (SUCCESS == RetVal));i424++) {
            if (true == ToDoFlags.charAt(i424)) {
                pCSUB40UInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub26si.getROWCCMN01UIG00().getUlIdPerson());
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(csub26si.getROWCCMN01UIG00().getUlIdEvent());
                pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(CurrentDate);
                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(csub26si.getROWCCMN01UIG00().getUlIdStage());
                
                
                //  Analyze return code
                switch (i424) {
                    case SUB005:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_05_CODE);
                        break;
                    case SUB028:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_28_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ulIdHomeStage);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdFadWorker);
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(csub26si.getSzNmStage());
                        pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += WAS_PLACED_ON;
                        szDateString = csub26si.getCSUB26SIG00().getDtDtPlcmtStart().month + "/" + csub26si.getCSUB26SIG00().getDtDtPlcmtStart().day + "/" + csub26si.getCSUB26SIG00().getDtDtPlcmtStart().year;
                        pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += szDateString;
                        break;
                    case SUB030:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_30_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdEligibilityWorker);
                        
                        break;
                    case SUB031:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_31_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdPalWorker1);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ulIdPalStage1);
                        //  do nothing, we want to return the error code
                        break;
                        
                    case SUB032:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_32_CODE);
                        break;
                    case SUB033:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_33_CODE);
                        break;
                    case SUB034:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_34_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdEligibilityWorker);
                        break;
                    case SUB035:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_35_CODE);
                        break;
                        
                    case SUB036:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_36_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdEligibilityWorker);
                        break;
                    case SUB037:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_37_CODE);
                        break;
                        
                    case SUB038:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_38_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdPalWorker1);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ulIdPalStage1);
                        break;
                        
                    case SUB039:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_39_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdAdoptSubWorker);
                        break;
                    case SUB042:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_42_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdFadRecruiter);
                        break;
                        
                    case SUB041:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_41_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdPalWorker1);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ulIdPalStage1);
                    case SUB048:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_48_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdEligibilityWorker);
                        break;
                        
                    case FAD050:
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_FAD50_CODE);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(ulIdFadWorker);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(ulIdHomeStage);
                        pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += CAPACITY_EXCEEDED + csub26si.getSzNmStage() + CAPACITY_EXCEEDED1;
                        break;
                        
                        
                        
                        // 
                        // (BEGIN): Common Function: ccmn01u   Post Event common function
                        // 
                        //  Allocate memory for Common Function Input and Output Structures
                        pCCMN01UInputRec = new CCMN01UI();
                        
                        pCCMN01UOutputRec = new CCMN01UO();
                        pCCMN01UInputRec.setArchInputStruct(csub26si.getArchInputStruct());
                        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(CurrentDate);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ulIdPalStage1);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(0);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub26si.getROWCCMN01UIG00().getUlIdPerson());
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(TASKFOLLOWUP);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(NEW);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENTFOLLOWUP);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(EVENT_DESCRIPTION);
                        pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub26si.getCSUB26SIG00().getUlIdPlcmtChild());
                        pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        
                        // Update victim's and perp's role in STAGE_PERSON_LINK.
                        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(pCCMN01UOutputRec.getUlIdEvent());
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
                        break;
                }
                
                if (SUCCESS == RetVal) {
                    //  Determine if duplicates exist.
                    rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
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
        
        if (INDICATOR_YES == csub26si.getSysIndNewActualPlcmt()) {
            csub26so.setSNbrRsrcOpenSlots(lOpenSlots);
        }
        else {
            csub26so.setSNbrRsrcOpenSlots(0);
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub26si.getArchInputStruct() , csub26so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        if (RetVal == Csub50s.FND_FAIL) {
            rc = Csub50s.FND_FAIL;
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
        return csub26so;
    }

    
    static int CallCCMN62D(CSUB26SI pInputMsg836, CSUB26SO * pOutputMsg783, Pint pbIndEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setArchInputStruct(pInputMsg836.getArchInputStruct());
        
        
        
        /**************************************************************************
        ** (END): CLSS67D - List retrieval of Contract rows for and id resource.
        **************************************************************************/
        
        if (pbIndEvent.value) {
            pCCMN62DInputRec.setUlIdEvent(pInputMsg836.getUlIdEvent_ARRAY().getUlIdEvent(ID_CLOSURE));
            pCCMN62DInputRec.setSzCdEventStatus("COMP");
        }
        
        else {
            pCCMN62DInputRec.setUlIdEvent(pInputMsg836.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN62DInputRec.setSzCdEventStatus(pInputMsg836.getROWCCMN01UIG00().getSzCdEventStatus());
        }
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(UPDATE);
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  SIR 13172 need to enter an if statement about if FA Home than call new dam
                // else call cres04d
                //  Call CRES54D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    
    static int CallCRES04D(CSUB26SI pInputMsg837, String szCdRsrcFacilType2, int ulIdResource10, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES04DInputRec = new CRES04DI();
        
        pCRES04DOutputRec = new CRES04DO();
        pCRES04DInputRec.setArchInputStruct(pInputMsg837.getArchInputStruct());
        
        pCRES04DInputRec.setUlIdResource(ulIdResource10);
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        szCdRsrcFacilType2 = pCRES04DOutputRec.getSzCdRsrcFacilType();
        return rc;
    }

    static int CallCMSC16D(CSUB26SI pInputMsg838, int ulIdResource11, int usUpdateSlots, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CMSC16DI pCMSC16DInputRec = null;/* Update NBR_RSRC_OPEN_SLOTS   */
        
        /*
        ** Declare local variables
        */
        CMSC16DO pCMSC16DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCMSC16DInputRec = new CMSC16DI();
        
        pCMSC16DOutputRec = new CMSC16DO();
        pCMSC16DInputRec.setArchInputStruct(pInputMsg838.getArchInputStruct());
        pCMSC16DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCMSC16DInputRec.setUlIdResource(ulIdResource11);
        pCMSC16DInputRec.setSNbrRsrcOpenSlots(usUpdateSlots);
        
        rc = cmsc16dAUDdam(sqlca, pCMSC16DInputRec, pCMSC16DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  SQL_NOT_FOUND is a valid return code
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
