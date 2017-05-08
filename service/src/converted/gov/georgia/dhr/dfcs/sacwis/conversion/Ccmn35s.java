package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN35SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN91DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN91DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB4DI;
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
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES82DO;
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
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC85DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC85DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC5DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNI2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNI2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN61DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN61DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN88DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD52DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES01DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS82DO;
/*****************************************************************************
**
** Module File:   CCMN35S.SRC
**
** Service Name:  CCMN35S
**
** Description:   Saves information change on Approval Window (CCMN65W).
**                Updates the status of all related events to the Approval.
**                Sends out appropriate To-Do notifications.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/11/95
**
** Programmer:    Ian Fogarty
**
** Archive Information: $Revision:   1.8  $
**                      $Date:   25 Jun 2002 08:54:56  $
**                      $Modtime:   24 Jun 2002 07:40:34  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  ---------------------------------------------------
**  02/23/95  FOGARTIS  SIR#67 - Approval Event Update Added to enforce
**                      intervening update error.
**  02/23/95  FOGARTIS  SIR#73 - Approval Status Service Error Processing
**                      standardized.
**  04/04/95  FOGARTIS  SIR#72 - Stage Progression and Stage Closure code
**                      added. Logic will be invoked if Window action was
**                      COMplete approval and Stage Progression mode,
**                      determined by the Retrieve Service, is applicable.
**  10/31/95  YANTISTK  SIR#2006 Create Todos for Child Plan, Service Auth.,
**                      and FA Home events.
**  11/29/95  GOLDBEDA  Removed call to PostEvent on ChildPlan Events. Also
**                      passing zero as EventId to ToDoCommonFunction.
**  12/20/95  MCRAEBS   SIR 2376 - Two things are being fixed here:  First,
**                      APS will no longer receive their todos from Approval
**                      Status - APS workers receive todos from
**                      CCON19S - SvcAuthSave.  Second,  CPS todo text
**                      and date formatting will be corrected.  BSM
**  01/20/96  BRUCKMK   SIR 2668 - Corrected incorrect brackets.
**
**  01/23/96  PAKRSSI   R1/R2 Impact - Modified SIR #2006 to change the
**                      last if else statement for F/A Home. Also removed
**                      #define INITIAL_PAGE to fix a redefinition error.
**  02/12/96  WANGSS    Added SQL_NOT_FOUND case to CSEC25D call.  1403 is
**                      a normal process and should be handled as if the
**                      DAM call were successful.
**  03/01/96  VISHNUR   SIR 3276 - Pssing NULL_DATE for FLOC end date is
**                      not creating a MAX_DATE in facility_loc. So passing
**                      MAX_DATE instead of NULL_DATE.
**                      Also fixed the IF statement for FLOC logic.
**
**  03/19/96  ADKINSMC  SIR 4030 - An else if statement was added so if the
**                      task is Re-evaluation then CSUB40C will be called
**                      to create a task, FAD043.
**  3/19/96   PURCELA   SIR #4046 - Modified code so that if a Close Home
**                      Event is being approved, the Cd Task is not copied
**                      to the Event Table.  Users should not be able to
**                      detail click from a task or event list to see a
**                      Home Closure Event.
**  04/15/96  DENTONRA  SIR #20324 - Added automatic contract processing
**                      as according to FAD Contract change order.
**  05/01/96  HELMKEST  SIR 20813:  Update the contract table when approving
**                      the home. This is necessary if a prs home has been
**                      reopened and the region has changed before the home
**                      has been re-approved.
**  5/8/96    DENTONRA  SIR 21003 - Changed "extendo" date processing to
**                      have == instead of = .  Also, changed error
**                      processing of cses80d to allow sql-not-found because
**                      that is an acceptible condition.  It should not
**                      "blow-up" at that point.
**  5/9/96    DENTONRA  SIR 20903 - CompareDateAndTime continues to cause
**                      problems when dates being compared are widely
**                      divergent.  In the case of this SIR, we are removing
**                      the PROCESS_TUX_RC_ERROR because we only care if it
**                      is zero or not zero and processing is in place
**                      already.
**  6/3/96    PURCELA   SIR #5379 - Do not End Date the FLOC's for Adoptive
**                      Homes when the task is Maintain Licensing.  This
**                      would prevent placements at a later interval.
**  6/12/96   PURCELA   SIR #10053 - Inserted multiple checks on and setting
**                      of FND_SUCCESS = RetVal.  There previously was no
**                      stoppage of processing if necessary DAMS failed.
**                      Additional performance issues were addressed as
**                      well and can be detailed by their specific comments.
**
**  7/8/96    DYARGR    SIR 21750 - Add performance timers for cmsc46d.
**  08/15/96  PHILLILH  SIR #21922 - BEGIN CAUD08D CONTRACT COUNTY update.
**                      This DAM was added because the contract county end
**                      date needs to be upated simulatneously with the
**                      contract_period and contract_county tables.
**  8/15/96   SISSONM   SIR 2952 - When approving an out-of-state home,
**                      SAVE failed.
**
**  9/30/96   VANDERM SIR 21770 - Worker who closed/opened a stage was
**                      not being populated.  Added code to populate
**                      the input message of CloseOpenStage with the approval
**                      requesters ID.
**  3/17/97   DURANG    SIR 13120 - When closing an ADO stage with the reason
**                      adoption consummated, the ADO stage would be closed but
**                      the the case would remain open.
**
**  04/16/97  RIOSJA    SIR 13618 - MHMR Enhancement for AFC Investigation
**                      "Waiting for Superintendent Comments". If the
**                      Investigation is approved, the Superintendent
**                      Notified indicator will be set to 'Y' (indicator
**                      selected). The Superintendent Notified Indicator will
**                      not be set to 'Y' if the szCdTask = 1040, which is
**                      the task for approving an Intake call.
**
**  12/29/97  SOHNJJ    SIR 14160 - EA Enhancement: During investigation
**                      conclusion, update or add EA eligibility.
**  07/16/98  PAULS     SIR 13197 - Pal coordinators not receiving PAL alerts
**                      on their Todo list when their Service Auths are expiring
**  09/30/98  DMV       SIR 14939 The SuperInt Notification check box is
**                      being checked incorrectly when the Exten Req Form
**                      was approved. Updated if statement to exclude
**                      Extension Request.
**  9/21/98   DOUGLACS  SIR #14747 DT_RSRC_CERT should be populated for
**                                 PRS homes when they are approved.
**  9/21/98   DOUGLACS  SIR #14568 DT_RSRC_CLOSE should be populated for
**                                 PRS homes when closure is approved.
**  07/30/99  DOUGLACS  SIR 15189 - EA Modifications
**  10/13/99  SOHNJJ    SIR 15189 - Corrected EA modification coding errors and
**                      cleaned up redundancies.  This EA modification was
**                      created under the new State and Federal guidelines of
**                      October 1, 1999.  A new DAM csec85d was added to determine
**                      if a closed EA record had a start date at least 12 months
**                      prior to the current date.  DAM caudc9d was modified
**                      to automatically calculate an end date that is 12 months
**                      minus 1 day from the start date.  The EA Deny date
**                      continues to be entered as '12/31/4712'.  This code is
**                      duplicated in ccmn03u.src to accomadate FPR progression.
**  01/06/00  SOHNJJ    SIR 15346 - Running purify indicated some memory
**                      created by unitialized variables in a for loop.
**                      Initialized the following DAM function structures:
**                      cseca1di, cseca1do, cseca3di, cseca3do, and
**                      caudc9di, caudc9do.  Also removed an unused output
**                      variable in the DAM function CallCseca3d.
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
** 3/18/2002    Hadjimh SIR#15920. When modifications are made to the following elements:
**                      NBR_RSRC_FACIL_CAPACITY, NBR_RSRC_INT_FE_AGE_MAX
**                      NBR_RSRC_INT_FE_AGE_MIN, NBR_RSRC_INT_MA_AGE_MAX
**                      NBR_RSRC_INT_MA_AGE_MIN, F/A Home Study
**                      and the window is Saved & Submitted for approval, a new contract
**                      version is written to the foster care contract. Changes to
**                      these items does not impact the kind of service the home can
**                      provide. The creation of new versions needlessly adds rows
**                      to the database tables. Only modifications to the Category
**                      and/or F/A Home Type should cause new contract versions
**                      to be created
** 6/24/2002    hadjimh SIR#15931. When trying to SAVE the approval of an adoptive
**                      home closure, error message 'Date you entered is not valid'
**                      occurs.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  07/10/03    Srini   SIR 18231 - Changed TRUE to INDICATOR_YES for the variable
**                      bIndDesigneeAprvl.
**  08/15/2003 Matthew McClain SIR 18827, patched SIR 15931, used
**                      szCdCncntyCounty[j] instead of szCdCncntyCounty[0]
**  09/04/03  A.Corley  SIR 19613 LOC Reduction -- Service Codes 60A-E are now
**                      being reduced to Service Codes 63A - D, updated code to compare and
**                      save with new codes.
**  11/17/03  A.Corley  SIR 22390 LOC Change -- Service Code 63C is now being used
**                      for Specialized homes.  Also, FLOC code 5 will be used
**                      for any home that is habil, ther, and prim med
**  12/16/03  A.Corley  SIR 22485 LOC Change -- Service Code 63D is now being used
**                      for Intense homes.  Also, FLOC code 6 will be used
**                      for any home that is habil, ther, and prim med
**  12/16/03  A.Corley  SIR 22686 LOC Change -- For Group Homes that are
**                      habil, ther and prim med, only write 63A-C, otherwise
**                      continue to write 63A-D
**  03/17/04  A.Corley  SIR 22735 - Changed NAME_LEN from 25 to 26 so that
**                      there is space for the new line character at the
**                      end of the string. Updated To-Do description so
**                      that length will not exceed 80 characters.
**  03/19/04  RIOSJA    SIR 19973 - Added a case to the return code switch
**                      statement for calls to CloseStageCase (CCMN02U)
**                      Common Function to handle MSG_SVA_OPN_AUTHS return
**                      code. The error message needs to propogate up and
**                      be sent back to the calling conversation so an
**                      appropriate error message can be displayed to the
**                      user.
**  03/31/04  RIOSJA    SIR 22741 - A person is eligible for emergency
**                      assistance for only one incident within a single
**                      year. This service would query a person's most recent
**                      EA record (if one exists) and compare it to sysdate
**                      (today's date) to determine if one year had passed
**                      since the last incident. The problem with that
**                      logic is that the Start Date of the new EA record
**                      is not necessarily today's date. Rather, the Start
**                      Date will be the earliest of the following dates:
**                      1.) Earliest service auth from the INV stage,
**                      2.) Date of conservatorship removal, or 3.) Date
**                      of stage closure of this INV stage (today's date).
**                      I updated the service code to use the effective
**                      Start Date instead of sysdate for the comparison.
**                      I also added more comments to the code.
**  05/10/04  Dickmaec  SIR 13232 - Added Adoption Plan task code of 8660
**                      and added the logic that will allow the new task
**                      to be produced.
**  08/17/04  RIOSJA    SIR 13418 - Added 'Date Plan Completed' and 'Next
**                      Review Date' fields to the Child Plan Detail page
**                      so that the worker can enter those dates. Need to
**                      pass Next Review Date to the TodoCommonFunction so
**                      it can be used to create the todo. Also need to
**                      pass Date Plan Completed to CAUD25D so that it can
**                      saved to the database.
** 09/02/2004 Hadjimh   SIR# 15101. Modify alerts sent to staff following
**						supervisor approval of events to Include Case Name
**						and Case ID Number
** 02/24/05   CORLEYAN  SIR 16177 - Allow for opening of PAD stages when
**                      ADO special request stages are being closed, this
**                      will work the same as adoption consummated
** 03/30/05   H Maralla SIR 19057 - To-Do Detail Page should display Event Type that has been
**                      been approved or disapproved.
**
** 07/17/2005 CASDORJM - SIR 23334 - Added APPROVAL REJECTION ccmni3d save
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn35s {
    
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char SP_NOT_APPL = 'N';
    public static final char SP_MANUAL = 'W';
    public static final char SP_AUTOMATIC = 'P';
    public static final char SP_CASECLOSE = 'C';
    
    public static final String WIN_REJECT = "REJ";
    public static final String WIN_COMPAPRV = "COM";
    public static final String WIN_APPROVE = "APR";
    public static final String WIN_INVALID = "INV";
    
    public static final String TODO_ALERT = "A";
    
    public static final String EVT_COMPLETE = "COMP";
    public static final String EVT_APPROVED = "APRV";
    public static final String UNIT_MEMBER_IN_ASSIGNED = "IN";
    public static final String ADO_CMTD = "010";
    public static final String UNAB_COMP = "20";
    public static final String REQ_WITH = "30";
    public static final String SVC_COMP = "10";
    
    /***************************************************************************
    ** Program Types
    ***************************************************************************/
    public static final String PROGRAM_AFC = "AFC";
    public static final int SERVICES_LEN = 25;
    /*
    ** CORLEYAN, SIR 22735 - Changed NAME_LEN from 25 to 26
    ** so that there is space for the new line character at
    ** the end of the string.
    */
    public static final int NAME_LEN = 26;
    public static final String SERVICES = "CSVCCODE";
    public static final int THIRTY_DAYS = 43200;
    int lRC = 0;
    String szSvcDecode = new String();/* placeholder for svc decode */
    FndInt3date dtCurrDate;/* placeholder for current date         */
    FndInt3date dtCPSAdd;/* used to set due dates  */
    
    
    /***************************************************************************
    ** Task Codes
    ***************************************************************************/
    public static final String CHILD_PLAN = "3160";
    public static final String ADOPTION_PLAN = "8660";
    public static final String SA_APS_SVC_DELIV = "6075";
    public static final String SA_APS_INVEST = "2100";
    public static final String SA_APS_AGE_OUT = "5040";
    public static final String SA_CPS_FAM_PRES = "7100";
    public static final String SA_CPS_INVEST = "2310";
    public static final String SA_CPS_ADOPT = "8530";
    public static final String SA_CPS_POST_ADOPT = "9020";
    public static final String SA_CPS_SUBCARE = "3020";
    public static final String SA_CPS_FAM_REUN = "5640";
    
    /*
    ** SIR 13197- The code for PAL was incorrect. Corrected that.
    ** The  Alert for PAL was not showing up because of this.
    */
    
    public static final String SA_CPS_PAL = "3520";
    public static final String FA_HOME_HME = "8200";
    public static final String FA_HOME_RVF = "8220";
    
    public static final String RE_EVALUATE = "8090";
    
    public static final String APPROVE_INT_CALL = "1040";
    
    public static final String APPROVE_EXT_REQ = "2395";
    /***************************************************************************
    ** Child Plan -- Plan Types
    ***************************************************************************/
    public static final String INIT_PLAN = "IPN";
    public static final String INIT_PLAN_PAL = "IPL";
    public static final String REVIEW = "RVW";
    public static final String REVIEW_PAL = "RVL";
    public static final String FAC_REVIEW = "FRV";
    public static final String FAC_REVIEW_PAL = "FRP";
    public static final String ADOPT_PLAN = "ADP";
    public static final String INIT_PLAN_THER = "IPT";
    public static final String INIT_PAL_THER = "IPP";
    public static final String REVIEW_THER = "RVT";
    public static final String REVIEW_PAL_THER = "RVP";
    
    /***************************************************************************
    ** Todo Codes
    ***************************************************************************/
    public static final String TODO_SUB_DUE_6MOS = "SUB015";
    public static final String TODO_ADO_DUE_6MOS = "ADO015";
    public static final String TODO_SUB_DUE_3MOS = "SUB016";
    public static final String TODO_SVC_AUTH_APS = "CON002";
    public static final String TODO_SVC_AUTH_CPS = "CON001";
    public static final String TODO_FA_HOME = "FAD043";
    
    /***************************************************************************
    ** Status Codes
    ***************************************************************************/
    public static final String PEND_APPRVL = "PV";
    public static final String APPRVD_ACTIVE = "PA";
    public static final String PEND_CLOSURE = "SP";
    public static final String CLOSED = "SD";
    public static final String ACTIVE = "01";
    public static final String INACTIVE = "02";
    public static final String FA_HOME_STAT_APPRVD = "APVD";
    public static final String NULL_STRING = "";
    /**************************************************************************
    ** ToDo Alert Descriptions
    ***************************************************************************/
    public static final String APR_WORKER = "New approval determination logged. Outstanding requests exist.";
    public static final String APR_DESIGNEE = "Designee Logged Approval. Outstanding requests exist.";
    public static final String REJ_WORKER = "Rejection determination logged. Other approval requests invalidated.";
    public static final String REJ_DESIGNEE = "Designee Logged Rejection. Other requests invalidated.";
    public static final String COM_WORKER = "Approval Complete! Events have been frozen.";
    public static final String COM_DESIGNEE = "Designee Logged Approval. Events have been frozen.";
    
    /*14160
    ** SIR
    */
    public static final int NO_END_DATE = - 1;
    public static final int ORACLE_END_MONTH = 12;
    public static final int ORACLE_END_DAY = 31;
    public static final int ORACLE_END_YEAR = 4712;
    public static final String PERSON_ROLE_PRINCIPAL = "PRN";
    public static final char EA_ADD = '1';
    public static final char EA_UPDATE = '2';
    
    /* SIR 19613, 22390, 22485, 22686 Homes that are basic will only have
    ** Level A assigned to them, Homes that are Hab,
    ** Ther, Prim Med, and not Group will have Level A, B, C and D, Homes
    ** that are Hab, Ther, Prim Med and Group will have level A, B, and C
    */
    public static final int NBR_SVC_CODE_SIXTY_A = 1;
    public static final int NBR_SVC_CODE_SIXTY_AB = 2;
    public static final int NBR_SVC_CODE_SIXTY_ABC = 3;
    public static final int NBR_SVC_CODE_SIXTY_ABCD = 4;
    public static final int NBR_OF_HOME_TYPE = 7;
    CCMN35SO CCMN35S(CCMN35SI ccmn35si) {
        CCMN35SO ccmn35so = new CCMN35SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i160 = 0;
        int l = 0;/* SIR#2006 index counter */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        int CounterP = 0;
        int RetVal = SUCCESS;/* R1/R2 Impact */
        int usSysNbrSvcDtlCount1 = 0;
        int usPageNo = 0;/*SIR#2006*/
        Pint ulIdSupervisor = new Pint();
        int ulLocalNbrGenericCntr = 0;/* R1/R2 Impact */
        Pint ulIdSvcAuth1 = new Pint();
        Pint ulIdResource1 = new Pint();
        int ulIdEvent2 = 0;
        int tempSvcRowQty = 0;/* temp County Service row counter */
        
        FndInt3date dtNullDate = null;
        TsLastUpdate_ARRAY tsMaxTimeStamp = new String();
        String tsLastUpdate1 = new String();
        String szNmPersonFull1 = new String();
        String szCdRsrcFaHomeStatus1 = new String();
        String szCdRsrcCategory1 = new String();
        boolean bChange = true;/* R1/R2 Impact */
        int ulAdoptiveOrFoster = 0;/* SIR #15787 */
        String szAdoptiveOrFoster = new String();
        boolean bAdoptive = true;/* SIR #15787 */
        boolean bFoster = true;
        int tmpSvcRowQty1 = 0;
        int tempSvcRowQty2 = 0;/* SIR #15931 temp row counter */
        /*
        ** SIR 14160
        */
        
        Pchar bEA_Sub = new Pchar();
        bEA_Sub.value = 0;
        Pchar bEA_Eligible = new Pchar();
        bEA_Eligible.value = 0;
        Pchar bEA_Found = new Pchar();
        bEA_Found.value = 0;
        FndInt3date dtSysdate = null;
        /* SIR 15189 */
        char bEA_12Months = '\u0000';
        
        /* SIR 15920. */
        boolean CategoryHomeType = false;
        
        /* SIR 22686 */
        boolean bGroupHome = false;
        CCMN57DO pBRIDGECCMN57DO = null;
        CCMN43DI pTodoStruct = null;
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        CCMN03UI pCCMN03UInputRec = null;
        CCMN03UO pCCMN03UOutputRec = null;
        CSUB40UI pTodoCommonInput = null;/* SIR#2006 */
        CSUB40UO pTodoCommonOutput = null;/* SIR#2006 */
        CSES19DO pCSES19DOutputRec = null;/* SIR#2006 */
        CCMN01UI pCCMN01UInputRec = null;
        
        CCMN01UO pCCMN01UOutputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;/* SIR#2006 */
        CCMN91DI pCCMN91DInputRec = null;/* R1/R2 Impact */
        CCMN91DO pCCMN91DOutputRec = null;/* R1/R2 Impact */
        CSEC25DI pCSEC25DInputRec = null;/* R1/R2 Impact */
        CSEC25DO pCSEC25DOutputRec = null;/* R1/R2 Impact */
        CMSC46DO pCMSC46DOutputRec = null;/* R1/R2 Impact */
        CMSC46DI pCMSC46DInputRec = null;/* R1/R2 Impact */
        CAUDB3DI pCAUDB3DInputRec = null;/* R1/R2 Impact */
        CAUDB3DO pCAUDB3DOutputRec = null;/* R1/R2 Impact */
        CSES41DO pCSES41DOutputRec = null;/* R1/R2 Impact */
        CSES41DI pCSES41DInputRec = null;/* R1/R2 Impact */
        CAUD80DI pCAUD80DInputRec = null;/* R1/R2 Impact */
        CAUD80DO pCAUD80DOutputRec = null;/* R1/R2 Impact */
        CAUDB4DO pCAUDB4DOutputRec = null;/* R1/R2 Impact */
        CAUDB4DI pCAUDB4DInputRec = null;/* R1/R2 Impact */
        CCMN39DI pCCMN39DInputRec = null;/* SIR #21952*/
        CCMN39DO pCCMN39DOutputRec = null;/* SIR #21952*/
        CLSS67DI pCLSS67DInputRec = null;/* SIR #20324 */
        CLSS67DO pCLSS67DOutputRec = null;/* SIR #20324 */
        CLSS68DI pCLSS68DInputRec = null;/* SIR #20358 */
        CLSS68DO pCLSS68DOutputRec = null;/* SIR #20358 */
        CSES80DI pCSES80DInputRec = null;/* SIR #20324 */
        CSES80DO pCSES80DOutputRec = null;/* SIR #20324 */
        CSES81DI pCSES81DInputRec = null;/* SIR #20324 */
        CSES81DO pCSES81DOutputRec = null;/* SIR #20324 */
        CSES82DI pCSES82DInputRec = null;/* SIR #20324 */
        CSES82DO pCSES82DOutputRec = null;/* SIR #20324 */
        CAUD01DI pCAUD01DInputRec = null;/* Contract AUD */
        /****************************SIR 20324**********************************/
        
        
        
        
        
        
        CAUD01DO pCAUD01DOutputRec = null;
        CAUD17DI pCAUD17DInputRec = null;/* Contract Service AUD */
        
        CAUD17DO pCAUD17DOutputRec = null;
        CAUD08DI pCAUD08DInputRec = null;/* Contract County AUD */
        
        CAUD08DO pCAUD08DOutputRec = null;
        CAUD15DI pCAUD15DInputRec = null;/* Contract Version AUD */
        
        CAUD15DO pCAUD15DOutputRec = null;
        CAUD20DI pCAUD20DInputRec = null;/* Contract Period AUD*/
        
        CAUD20DO pCAUD20DOutputRec = null;
        CLSS13DI pCLSS13DInputRec = null;/* Contract Service DAM */
        
        CLSS13DO pCLSS13DOutputRec = null;
        CINT20DI pCINT20DInputRec = null;/* Primary worker retrieval */
        
        CINT20DO pCINT20DOutputRec = null;
        CRES13DI pCRES13DInputRec = null;/* Resource Address retrieval */
        
        CRES13DO pCRES13DOutputRec = null;
        
        
        /* SIR 14160 - Declare input output structure for DAM's */
        
        CSECA8DI CSECA8DI = null;
        CSECA8DO CSECA8DO = null;
        
        CSECA2DI CSECA2DI = null;
        CSECA2DO CSECA2DO = null;
        
        CLSC18DI CLSC18DI = null;
        CLSC18DO CLSC18DO = null;
        
        CSECA1DI CSECA1DI = null;
        CSECA1DO CSECA1DO = null;
        
        CAUDC9DI CAUDC9DI = null;
        CAUDC9DO CAUDC9DO = null;
        
        CSECA3DI CSECA3DI = null;
        CSECA3DO CSECA3DO = null;
        
        /* SIR 15189 */
        CSEC85DI CSEC85DI = null;
        CSEC85DO CSEC85DO = null;
        
        /*
        ** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ** BELOW IS NOT AN ACTUAL DAM CALLED IN THIS SERVICE.  THIS STRUCTURE
        ** WILL SERVE AS A "WCD" FOR THIS SERVICE.  THE SIZE OF THE STRUCTURE
        ** WAS TOO LARGE TO PLACE IN THE PINIT FOR THIS SERVICE.  NEED IT TO
        ** RETREIVE AND STORE CONTRACT INFORMATION.
        ** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        */
        Cfad01a pCFAD01DInputRec = null;
        
        
        /* Begin SIR# 15101 */
        CCMNC5DI CCMNC5DI = null;
        CCMNC5DO CCMNC5DO = null;
        String szCaseNameCaseId = new String();
        String szCaseName = new String();
        String szTempCaseId = new String();
        boolean bIndFosterContractExists = false;/* Indicates if that the foster
        contract exists SIR #20324 */
        boolean bIndAdoptContractExists = false;/* Indicates if that the foster
        contract exists SIR #20324 */
        char bIndUpdateFosterContract = 0;/* Indicates if that the foster
        contract exists SIR #20324 */
        char bIndUpdateAdoptContract = 0;/* Indicates if that the foster
        contract exists SIR #20324 */
        FndInt3date dtTempDate = null;/* Temporary date used for system date
        SIR #20324 */
        FndInt3date dtCurrentDate = null;/* Temporary date used for system date
        SIR #20324 */
        FndInt3date/* Temporary date to add 100 years
        SIR 20324 */
        dtTempDate2 = new FndInt3date(0, 0, 100);
        FndInt3date/* Temporary date subtract 1 day
        SIR 20324 */
        dtTempDate3 = new FndInt3date( - 1, 0, 0);
        FndInt3date/* Temporary date add 1 day
        SIR 20324 */
        dtAddOneDay = new FndInt3date(1, 0, 0);
        int ulContractQty = 0;/* Counter for contracts returned from
        database SIR #20324 */
        int j = 0;/* Interger used for a looping logic
        SIR #20324 */
        int k = 0;/* Interger used for a looping logic
        SIR #20358 */
        int m = 0;/* Interger used for a looping logic
        SIR #20324 */
        int n = 0;/* Interger used for a looping logic
        SIR #20324 */
        int usCreateContract = 0;/* Indicates the type of contract to be
        created.  SIR #20324 */
        int usUpdateContract = 0;/* Indicates the type of contract to be
        update.  SIR #20324 */
        int ulTempIdRsrcAddress = 0;/* Temporary variable to hold the
        ** primary resource address id
        ** SIR 20324
        */
        int ulIdTempCntrctWkr = 0;/* Holds the logged on worker ID */
        int ulIdTempContract = 0;/* Holds the contract ID created in
        in the contract AUD */
        int usCountyRow = 0;/* Holds contract county row index */
        int usCountyTypeRow = 0;/* Holds contract county row type index */
        String szTempCdRsrcCnty = new String();/*temp county from resource */
        String szTempCdRsrcFaHomeStatus = new String();/*temp resource home status*/
        String szTempCdCntrctRegion = new String();/*temp resource region*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        boolean testBool = false;
        /***************************END SIR 20324******************************/
        
        /* Allocate for Service local area, holding 57's output and 62's input */
        pBRIDGECCMN57DO = new CCMN57DO();
        
        /* Allocate for Service local area, reusable Todo Input Structure 43D  */
        pTodoStruct = new CCMN43DI();
        
        
        /*
        ** Call CMSC06D
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn35si.getArchInputStruct());
        
        /*
        ** Initialize service status fields
        */
        
        /*
        ** Setup NULL DATE and MAX TIMESTAMP VARIABLES
        */
        dtNullDate.month = DateHelper.NULL_DATE;
        dtNullDate.day = DateHelper.NULL_DATE;
        dtNullDate.year = DateHelper.NULL_DATE;
        tsMaxTimeStamp = CStringUtils.setCharAt(tsMaxTimeStamp, 0, 147);
        tsMaxTimeStamp = CStringUtils.setCharAt(tsMaxTimeStamp, 1, 112);
        tsMaxTimeStamp = CStringUtils.setCharAt(tsMaxTimeStamp, 2, 12);
        tsMaxTimeStamp = CStringUtils.setCharAt(tsMaxTimeStamp, 3, 31);
        tsMaxTimeStamp = CStringUtils.setCharAt(tsMaxTimeStamp, 4, 1);
        tsMaxTimeStamp = tsMaxTimeStamp.substring(0, 5);
        tsMaxTimeStamp = tsMaxTimeStamp.substring(0, 6);
        
        if ((0 == ccmn35si.getROWCCMN61DI().getSzCdApproversStatus().compareTo(EVT_APPROVED)) && (0 == ccmn35si.getAprvlStageProg().getSzCdStageProgram().compareTo(PROGRAM_AFC)) &&!((0 == ccmn35si.getROWCCMN01UIG00().getSzCdTask().compareTo(APPROVE_INT_CALL)) || (0 == ccmn35si.getROWCCMN01UIG00().getSzCdTask().compareTo(APPROVE_EXT_REQ)))) {
            rc = CallCAUDC7D(ccmn35si, ccmn35so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        if (ccmn35si.getSzWcdCdAprvlWinaction().equals(WIN_INVALID)) {
            pTodoStruct.setLdIdTodo(ccmn35si.getLdIdTodo());
            tsMaxTimeStamp = pTodoStruct.getTsLastUpdate_ARRAY();
            pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
            
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*** SAVE APPROVAL DETERMINATION SCENERIO ***/
        
        else if (ccmn35si.getSzWcdCdAprvlWinaction().equals(WIN_APPROVE)) {
            
            //  Call DAM
            rc = Ccmn01u.CallCCMN46D(ccmn35si, ccmn35so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                default :
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            //  Call DAM
            rc = CallCCMN61D(ccmn35si, ccmn35so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    
                    break;
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            pTodoStruct.setLdIdTodo(ccmn35si.getLdIdTodo());
            tsMaxTimeStamp = pTodoStruct.getTsLastUpdate_ARRAY();
            pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            //  pCINV74DOutputRec will be returned to the calling service
            // and will be freed there.
            rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pTodoStruct.setSzCdTodoType(TODO_ALERT);
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCreated() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCompleted() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoDue() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            pTodoStruct.setDtDtTaskDue(dtNullDate);
            pTodoStruct.setUlIdCase(ccmn35si.getUlIdCase());
            pTodoStruct.setUlIdTodoPersAssigned(ccmn35si.getUlIdPerson());
            pTodoStruct.setUlIdTodoPersWorker(ccmn35si.getUlIdPerson());
            pTodoStruct.setUlIdStage(ccmn35si.getUlIdStage());
            pTodoStruct.setSzCdTodoTask(ccmn35si.getSzCdTask());
            pTodoStruct.setSzTxtTodoDesc(APR_WORKER);
            
            //  Call DAM
            rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
            
            //  Check for allocation errors.
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (INDICATOR_YES == ccmn35si.getBIndDesigneeAprvl()) {
                rc = CallCCMN60D(ccmn35si, ulIdSupervisor, pServiceStatus);
                
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pTodoStruct.setSzCdTodoType(TODO_ALERT);
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCreated() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                //  Call DAM
                
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCompleted() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoDue() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pTodoStruct.setDtDtTaskDue(dtNullDate);
                pTodoStruct.setUlIdCase(ccmn35si.getUlIdCase());
                pTodoStruct.setUlIdTodoPersAssigned(ulIdSupervisor.value);
                pTodoStruct.setUlIdTodoPersWorker(ccmn35si.getUlIdPerson());
                pTodoStruct.setUlIdStage(ccmn35si.getUlIdStage());
                pTodoStruct.setSzCdTodoTask(ccmn35si.getSzCdTask());
                pTodoStruct.setSzTxtTodoDesc(APR_DESIGNEE);
                
                rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (rc != SUCCESS) {
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        /*** SAVE REJECTION DETERMINATION SCENARIO ***/
        
        else if (ccmn35si.getSzWcdCdAprvlWinaction().equals(WIN_REJECT)) {
            rc = CallCCMNI2D(ccmn35si, ccmn35so, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    break;
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = Ccmn01u.CallCCMN46D(ccmn35si, ccmn35so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    
                    break;
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    
                    // 
                    // Function Prototypes
                    // 
                    // SIR 21130 - this dam will update the event status in the event table
                    // without a time stamp if closure event was pending and something was
                    // modified in the legal status window.
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            
            //  Call DAM
            
            rc = CallCCMN61D(ccmn35si, ccmn35so, pServiceStatus);
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            rc = Ccmn05u.CallCCMN88D(ccmn35si, ccmn35so, pServiceStatus);
            if (rc != SUCCESS) {
                
                //  SIR 14053 - this sub function will take the input and output messages
                // and figure out whether or not to update the open slots in the caps_resource
                // table.  This will only be called if the new legal status is adoption
                // consummated.
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            rc = CallCCMN57D(ccmn35si, ccmn35so, pBRIDGECCMN57DO, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = Csub26s.CallCCMN62D(ccmn35si, ccmn35so, pBRIDGECCMN57DO, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            pTodoStruct.setLdIdTodo(ccmn35si.getLdIdTodo());
            tsMaxTimeStamp = pTodoStruct.getTsLastUpdate_ARRAY();
            pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            
            //  Declare FOUNDATION variables
            
            //  Declare local variables
            
            //  Start Performance Timer for service
            rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pTodoStruct.setSzCdTodoType(TODO_ALERT);
            
            //  Retrieve Svc Ref Chklist Info from CPS_CHECKLIST
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCreated() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCompleted() , 0);
            // Process utility function failure
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoDue() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            pTodoStruct.setDtDtTaskDue(dtNullDate);
            
            pTodoStruct.setUlIdCase(ccmn35si.getUlIdCase());
            pTodoStruct.setUlIdTodoPersAssigned(ccmn35si.getUlIdPerson());
            pTodoStruct.setUlIdTodoPersWorker(ccmn35si.getUlIdPerson());
            pTodoStruct.setUlIdStage(ccmn35si.getUlIdStage());
            pTodoStruct.setSzCdTodoTask(ccmn35si.getSzCdTask());
            pTodoStruct.setSzTxtTodoDesc(REJ_WORKER);
            rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (INDICATOR_YES == ccmn35si.getBIndDesigneeAprvl()) {
                rc = CallCCMN60D(ccmn35si, ulIdSupervisor, pServiceStatus);
                
                //  Analyze error code
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pTodoStruct.setSzCdTodoType(TODO_ALERT);
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCreated() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  Call DAM
                
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCompleted() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                //  Do nothing, the output message just returns success or failure
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoDue() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pTodoStruct.setDtDtTaskDue(dtNullDate);
                pTodoStruct.setUlIdCase(ccmn35si.getUlIdCase());
                pTodoStruct.setUlIdTodoPersAssigned(ulIdSupervisor.value);
                pTodoStruct.setUlIdTodoPersWorker(ccmn35si.getUlIdPerson());
                pTodoStruct.setUlIdStage(ccmn35si.getUlIdStage());
                pTodoStruct.setSzCdTodoTask(ccmn35si.getSzCdTask());
                pTodoStruct.setSzTxtTodoDesc(REJ_DESIGNEE);
                rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
                
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            //  SIR#2006 If Approval was rejected and the event is FA Home
            // retrieve the record from the Resource History table that
            // has the most recent Date Effective and the FA Home Status is
            // not Pending Approved or Pending Closed.  Update the Resource
            // record with the FA Home Status from the Resource History record.
            
            for (i160 = 0;i160 < pBRIDGECCMN57DO.getArchOutputStruct().getUlRowQty();i160++) {
                
                if (!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(FA_HOME_HME) != 0)) {
                    rc = CallCSEC38D(ccmn35si, pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getUlIdEvent() , szCdRsrcFaHomeStatus1, ulIdResource1, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    rc = CallCRES04D(ccmn35si, ulIdResource1.value, tsLastUpdate1, null, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    rc = CallCAUD52D(ccmn35si, ulIdResource1.value, tsLastUpdate1, szCdRsrcFaHomeStatus1, ACTIVE, pServiceStatus);
                    switch (rc) {
                            
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
        }
        
        
        /*** SAVE COMPLETED APPROVAL DETERMINATION SCENERIO ***/
        
        else if (ccmn35si.getSzWcdCdAprvlWinaction().equals(WIN_COMPAPRV)) {
            
            //  Call DAM
            
            rc = Ccmn01u.CallCCMN46D(ccmn35si, ccmn35so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    
                    
                    
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //  Do nothing, the output message just returns success or failure
            rc = CallCCMN61D(ccmn35si, ccmn35so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    break;
                    
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = CallCCMN57D(ccmn35si, ccmn35so, pBRIDGECCMN57DO, pServiceStatus);
            
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            rc = Csub26s.CallCCMN62D(ccmn35si, ccmn35so, pBRIDGECCMN57DO, pServiceStatus);
            
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            pTodoStruct.setLdIdTodo(ccmn35si.getLdIdTodo());
            tsMaxTimeStamp = pTodoStruct.getTsLastUpdate_ARRAY();
            pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pTodoStruct.setSzCdTodoType(TODO_ALERT);
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCreated() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCompleted() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoDue() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            pTodoStruct.setDtDtTaskDue(dtNullDate);
            pTodoStruct.setUlIdCase(ccmn35si.getUlIdCase());
            pTodoStruct.setUlIdTodoPersAssigned(ccmn35si.getUlIdPerson());
            pTodoStruct.setUlIdTodoPersWorker(ccmn35si.getUlIdPerson());
            pTodoStruct.setUlIdStage(ccmn35si.getUlIdStage());
            pTodoStruct.setSzCdTodoTask(ccmn35si.getSzCdTask());
            pTodoStruct.setSzTxtTodoDesc(COM_WORKER);
            // END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if (pTodoStruct.getUlIdCase() > 0) {
                rc = Ccmn02u.CallCCMNC5D(ccmn35si, szCaseName, pServiceStatus);
                
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        pTodoStruct.setSzTxtTodoDesc(COM_WORKER);
                        pTodoStruct.getSzTxtTodoDesc() += "(" + szCaseName;
                        szTempCaseId = ccmn35si.getUlIdCase();
                        pTodoStruct.getSzTxtTodoDesc() += "," + szTempCaseId + ")";
                        RetVal = SUCCESS;
                        
                        
                        
                        
                        break;
                    case Messages.MSG_NO_ROWS_RETURNED:
                        RetVal = SUCCESS;
                        
                        
                        break;
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        break;
                }
            }
            
            //  Start Performance Timer
            rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
            
            if (rc != SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (INDICATOR_YES == ccmn35si.getBIndDesigneeAprvl()) {
                rc = CallCCMN60D(ccmn35si, ulIdSupervisor, pServiceStatus);
                
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                pTodoStruct.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pTodoStruct.setSzCdTodoType(TODO_ALERT);
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCreated() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  Call CSUB80D
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoCompleted() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                rc = ARC_UTLGetDateAndTime(pTodoStruct.getDtDtTodoDue() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                pTodoStruct.setDtDtTaskDue(dtNullDate);
                
                pTodoStruct.setUlIdCase(ccmn35si.getUlIdCase());
                pTodoStruct.setUlIdTodoPersAssigned(ulIdSupervisor.value);
                pTodoStruct.setUlIdTodoPersWorker(ccmn35si.getUlIdPerson());
                pTodoStruct.setUlIdStage(ccmn35si.getUlIdStage());
                pTodoStruct.setSzCdTodoTask(ccmn35si.getSzCdTask());
                pTodoStruct.setSzTxtTodoDesc(COM_DESIGNEE);
                rc = Cint12s.CallCCMN43D(pTodoStruct, ccmn35so, pServiceStatus);
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            //  If this is not a new event, retrieve the Removal Event Detail
            if ((SP_MANUAL == ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode()) || (SP_AUTOMATIC == ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode())) {
                
                //  Allocate memory for CloseOpenStage Input & Output Structures
                pCCMN03UInputRec = new CCMN03UI();
                
                pCCMN03UOutputRec = new CCMN03UO();
                pCCMN03UInputRec.setUlIdStage(ccmn35si.getUlIdStage());
                pCCMN03UInputRec.setSzCdStage(ccmn35si.getSzCdStage());
                pCCMN03UInputRec.setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
                pCCMN03UInputRec.setSzCdStageOpen(ccmn35si.getAprvlStageProg().getSzCdStageOpen());
                pCCMN03UInputRec.setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
                
                pCCMN03UInputRec.setUlIdPerson(ccmn35si.getUlIdPerson());
                if (0 == Ccmn86s.ADOPTION_STAGE.compareTo(ccmn35si.getSzCdStage()) && (0 == ADO_CMTD.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || 0 == UNAB_COMP.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || 0 == REQ_WITH.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || 0 == SVC_COMP.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()))) {
                    pCCMN03UInputRec.setCSysIndSStgOpenOnly(INDICATOR_YES);
                }
                rc = Ccmn03u.CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            
            else if (SP_CASECLOSE == ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode()) {
                bEA_Sub.value = 0;
                
                //  Call DAM
                rc = CallCSECA8D(ccmn35si, CSECA8DO, bEA_Sub, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                if (bEA_Sub.value != 0) {
                    rc = Ccmn03u.CallCSECA2D(ccmn35si, CSECA2DO, bEA_Eligible, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    
                    if (bEA_Eligible.value != 0) {
                        rc = ARC_UTLGetDateAndTime(dtSysdate, 0);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        rc = Ccmn03u.CallCLSC18D(ccmn35si, CLSC18DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        //  Loop through each principal, and determine whether or
                        // not an 'EA' PERSON_ELIGIBILITY record should be written
                        // for that principal. A person is eligible for emergency
                        // assistance for only one incident per year.
                        for (i160 = 0;i160 < CLSC18DO.getArchOutputStruct().getUlRowQty();i160++) {
                            
                            CSECA1DI.setArchInputStruct(ccmn35si.getArchInputStruct());
                            
                            CSECA1DI.setUlIdPersEligPerson(CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i160).getUlIdPerson());
                            bEA_Found.value = 0;
                            
                            //  Call CMSC54D
                            rc = Ccmn03u.CallCSECA1D(CSECA1DI, CSECA1DO, bEA_Found, pServiceStatus);
                            
                            //## BEGIN TUX/XML: Declare XML variables
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            if (bEA_Found.value != 0) {
                                if (((CSECA1DO.getDtDtPersEligEnd().year > dtSysdate.year) || ((CSECA1DO.getDtDtPersEligEnd().year == dtSysdate.year) && (CSECA1DO.getDtDtPersEligEnd().month > dtSysdate.month)) || ((CSECA1DO.getDtDtPersEligEnd().year == dtSysdate.year) && (CSECA1DO.getDtDtPersEligEnd().month == dtSysdate.month) && (CSECA1DO.getDtDtPersEligEnd().day >= dtSysdate.day))) && (CSECA1DO.getDtDtPersEligEaDeny().year == NO_END_DATE)) {
                                    CAUDC9DI.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    CAUDC9DI.getArchInputStruct().setCReqFuncCd(EA_UPDATE);
                                    CAUDC9DI.setUlIdPersElig(CSECA1DO.getUlIdPersElig());
                                    if ((0 == CSECA1DO.getCdPersEligPrgStart().compareTo("S")) && (0 == CSECA1DO.getCdPersEligPrgOpen().compareTo("S"))) {
                                        CAUDC9DI.setCdPersEligPrgOpen("B");
                                    }
                                    else {
                                        CAUDC9DI.setCdPersEligPrgOpen("C");
                                    }
                                    rc = Ccmn02u.CallCAUDC9D(CAUDC9DI, CAUDC9DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                
                                else {
                                    CSEC85DI.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    CSEC85DI.setDtDtPersEligStart(CSECA1DO.getDtDtPersEligStart());
                                    
                                    bEA_12Months = 0;
                                    Ccmn03u.CallCSEC85D(CSEC85DI, CSEC85DO, pServiceStatus);
                                    CSECA3DI.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    CSECA3DI.setUlIdStage(ccmn35si.getUlIdStage());
                                    rc = Ccmn03u.CallCSECA3D(CSECA3DI, CSECA3DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    if ((CSEC85DO.getDtDtPersEligEnd().year < CSECA3DO.getDtDtSvcAuthDtlBegin().year) || ((CSEC85DO.getDtDtPersEligEnd().year == CSECA3DO.getDtDtSvcAuthDtlBegin().year) && (CSEC85DO.getDtDtPersEligEnd().month < CSECA3DO.getDtDtSvcAuthDtlBegin().month)) || ((CSEC85DO.getDtDtPersEligEnd().year == CSECA3DO.getDtDtSvcAuthDtlBegin().year) && (CSEC85DO.getDtDtPersEligEnd().month == CSECA3DO.getDtDtSvcAuthDtlBegin().month) && (CSEC85DO.getDtDtPersEligEnd().day < CSECA3DO.getDtDtSvcAuthDtlBegin().day))) {
                                        bEA_12Months = 1;
                                    }
                                }
                            }
                            {
                                
                                //  Perform Removal Reason Processing
                                if (!(bEA_Found.value != 0) || bEA_12Months != 0) {
                                    CSECA3DI.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    CSECA3DI.setUlIdStage(ccmn35si.getUlIdStage());
                                    rc = Ccmn03u.CallCSECA3D(CSECA3DI, CSECA3DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    CAUDC9DI.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    CAUDC9DI.setUlIdPersEligPerson(CSECA1DI.getUlIdPersEligPerson());
                                    CAUDC9DI.getArchInputStruct().setCReqFuncCd(EA_ADD);
                                    CAUDC9DI.setDtDtPersEligStart(CSECA3DO.getDtDtSvcAuthDtlBegin());
                                    
                                    //  Call CINT21D
                                    rc = Ccmn02u.CallCAUDC9D(CAUDC9DI, CAUDC9DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                            }
                        }
                    }
                }
                
                //  Allocate memory for CloseStageCase Input & Output Structures
                pCCMN02UInputRec = new CCMN02UI();
                
                pCCMN02UOutputRec = new CCMN02UO();
                pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(ccmn35si.getUlIdStage());
                pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(ccmn35si.getSzCdStage());
                pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
                pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
                //SIR 18934 - fix error handling
                rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        break;
                        
                    case Messages.MSG_SVA_OPN_AUTHS:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_SVA_OPN_AUTHS;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            if (SP_AUTOMATIC == ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode() && 0 == Ccmn86s.ADOPTION_STAGE.compareTo(ccmn35si.getSzCdStage()) && (0 == ADO_CMTD.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || 0 == UNAB_COMP.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || 0 == REQ_WITH.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()) || 0 == SVC_COMP.compareTo(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed()))) {
                //  Allocate memory for CloseStageCase Input & Output Structures
                pCCMN02UInputRec = new CCMN02UI();
                
                pCCMN02UOutputRec = new CCMN02UO();
                pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(ccmn35si.getUlIdStage());
                pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(ccmn35si.getSzCdStage());
                pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
                pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(ccmn35si.getAprvlStageProg().getSzCdStageReasonClosed());
                rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    case Messages.MSG_SVA_OPN_AUTHS:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_SVA_OPN_AUTHS;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            
            //  End SIR 13120 durang
            
            
            // 
            // Begin SIR#2006 - YANTISTK - 10/31/95
            // For approval of Subcare, Service Authorization or FA Home,
            // a standard set of To_Dos must be created for the worker. Do not
            // generate a Todo if the Case is going to close.
            // 
            
            for (i160 = 0;i160 < pBRIDGECCMN57DO.getArchOutputStruct().getUlRowQty();i160++) {
                if ((!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(CHILD_PLAN) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(ADOPTION_PLAN) != 0)) && ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode() != SP_CASECLOSE) {
                    //  Retrieve a functional record from the Child Plan table
                    // using IdEvent, in order to create ToDos for Child Plan events.
                    
                    // Allocate for Service local area, CSES19D Output Structure
                    pCSES19DOutputRec = new CSES19DO();
                    rc = CallCSES19D(ccmn35si, pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getUlIdEvent() , pCSES19DOutputRec, pServiceStatus);
                    switch (rc) {
                            
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  GOLDBEDA 11/29/95 - Removed call to PostEvent
                    
                    //  Allocate memory for Todo Input and Output structures.
                    pTodoCommonInput = new CSUB40UI();
                    
                    pTodoCommonOutput = new CSUB40UO();
                    if (!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(INIT_PLAN) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(INIT_PLAN_PAL) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(REVIEW) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(REVIEW_PAL) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(FAC_REVIEW) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(FAC_REVIEW_PAL) != 0)) {
                        // Process utility fuction failure
                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_SUB_DUE_6MOS);
                    }
                    
                    // SIR13232 -- Creates the new Adoption Plan Todo*
                    else if (!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(ADOPT_PLAN) != 0)) {
                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_ADO_DUE_6MOS);
                    }
                    
                    else if (!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(INIT_PLAN_THER) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(INIT_PAL_THER) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(REVIEW_THER) != 0) ||!(pCSES19DOutputRec.getSzCdCspPlanType().compareTo(REVIEW_PAL_THER) != 0)) {
                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_SUB_DUE_3MOS);
                    }
                    pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pCSES19DOutputRec.getDtDtCspNextReview());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(0);
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccmn35si.getROWCCMN61DI().getUlIdPerson());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn35si.getUlIdStage());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(0);
                    
                    //  Call CheckStageEventStatus
                    rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    rc = CallCAUD25D(ccmn35si, pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getUlIdEvent() , pTodoCommonOutput.getDtDtTodoDue() , pCSES19DOutputRec, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                
                //  SIR 2376 - Two things are being fixed here:  First, APS will
                // no longer receive their todos from Approval Status - APS workers
                // receive todos from CCON19S - SvcAuthSave.  Second,  CPS todo text
                // and date formatting will be corrected.  BSM
                
                // 
                // SIR 2668: Corrected the brackets
                // 
                else if ((!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_FAM_PRES) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_INVEST) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_ADOPT) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_POST_ADOPT) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_SUBCARE) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_FAM_REUN) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_PAL) != 0)) && ccmn35si.getAprvlStageProg().getCWCDCdStageProgressMode() != SP_CASECLOSE) {
                    rc = Cinv20s.CallCSES24D(ccmn35si, pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getUlIdEvent() , ulIdSvcAuth1, pServiceStatus);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    // Allocate for Service local area, CLSS24D Output Structure
                    pCLSS24DOutputRec = new CLSS24DO();
                    pCLSS24DOutputRec.getArchOutputStruct().setBMoreDataInd(1);
                    usPageNo = Csys08s.INITIAL_PAGE;
                    
                    while (pCLSS24DOutputRec.getArchOutputStruct().getBMoreDataInd() != 0) {
                        
                        // This is the id-event of the closure event
                        rc = CallCLSS24D(ccmn35si, ulIdSvcAuth1.value, usPageNo, pCLSS24DOutputRec, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                break;
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        
                        for (l = 0;l < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();l++) {
                            
                            rc = CallCINV81D(ccmn35si, pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getUlIdPerson() , szNmPersonFull1, pServiceStatus);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.ARC_SUCCESS:
                                    break;
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            
                            //  Allocate memory for Todo Input and Output structures.
                            pTodoCommonInput = new CSUB40UI();
                            
                            pTodoCommonOutput = new CSUB40UO();
                            if (!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_FAM_PRES) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_INVEST) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_ADOPT) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_POST_ADOPT) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_SUBCARE) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_FAM_REUN) != 0) ||!(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(SA_CPS_PAL) != 0)) {
                                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_SVC_AUTH_CPS);
                            }
                            pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).setDtSvcAuthDtlShow(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getDtDtSvcAuthDtlTerm());
                            rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrDate, 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            lRC = ARC_UTLCompareDateAndTime(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getDtSvcAuthDtlShow() , 0, dtCurrDate, 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            
                            // } end if Child NA attribute FALSE
                            
                            //  See if event was last saved with Adult Rem Char
                            // NA box checked before retrieving Adult Rem Chars
                            if (lRC > THIRTY_DAYS) {
                                //  Set the value of dtCPS add to 30 days less than
                                // the term date
                                dtCPSAdd.day = - 30;
                                dtCPSAdd.month = 0;
                                dtCPSAdd.year = 0;
                                rc = ARC_UTLAddToDate((FndInt3date) & pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getDtSvcAuthDtlShow() , (FndInt3date) & dtCPSAdd);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            
                            else {
                                pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).setDtSvcAuthDtlShow(dtCurrDate);
                            }
                            pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getDtSvcAuthDtlShow());
                            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(0);
                            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                            // Process utility fuction failure
                            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn35si.getUlIdStage());
                            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(0);
                            
                            //  Call PostEvent
                            rc = ARC_FRMGetDecode((char) szSvcDecode, (char) pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getSzCdSvcAuthDtlSvc() , SERVICES_LEN, (char) SERVICES);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfDesc("SA " + szNmPersonFull1 + " - " + szSvcDecode + " expires on " + (pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getDtDtSvcAuthDtlTerm().month) + "/" + (pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getDtDtSvcAuthDtlTerm().day) + "/" + (pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(l).getDtDtSvcAuthDtlTerm().year));
                            
                            // CSD - 4/16/03 - fix for error handling to return correct error
                            rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                            
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.ARC_SUCCESS:
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                        }
                        usPageNo++;
                    }
                }
                
                
                
                // 
                // BEGIN R1/R2 IMPACT FOR F/A HOME 1/23/96
                // 
                
                else if (0 == (pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(TASK_MNTN_LIC))) {
                    if (0 == (ccmn35si.getSzWcdCdAprvlWinaction().compareTo(WIN_COMPAPRV))) {
                        // call CMSC46D to retrieve RESOURCE_HISTORY
                        
                        //  Allocate common function Input and Output Structures
                        pCMSC46DInputRec = new CMSC46DI();
                        
                        pCMSC46DOutputRec = new CMSC46DO();
                        pCMSC46DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                        pCMSC46DInputRec.setUlIdRsrcFaHomeStage(ccmn35si.getUlIdStage());
                        pCMSC46DInputRec.setSzCdRshsFaHomeStatus(HOME_STATUS_APVD_ACT);
                        rc = cmsc46dQUERYdam(sqlca, pCMSC46DInputRec, pCMSC46DOutputRec);
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                
                                //  Set pCMSC46DOutputRec->ulSysNbrGenericCntr
                                // to ulLocalNbrGenericCntr.  The counter is
                                // needed in the if statement below, but
                                // CMSC46DOutputRec will be freed before the
                                // counter is checked
                                ulLocalNbrGenericCntr = pCMSC46DOutputRec.getUlSysNbrGenericCntr();
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                        if (ulLocalNbrGenericCntr == 0 && RetVal == SUCCESS) {
                            // Create Todo
                            
                            //  Allocate memory for Common Function Input
                            // and Output Structures
                            
                            pTodoCommonInput = new CSUB40UI();
                            
                            pTodoCommonOutput = new CSUB40UO();
                            pTodoCommonInput.setArchInputStruct(ccmn35si.getArchInputStruct());
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_FA_HOME);
                            ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccmn35si.getUlIdPerson());
                            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                            pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn35si.getUlIdStage());
                            rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                            }
                        }
                        
                        
                        //  Call dams to retrieve and validate person detail data
                        if (RetVal == SUCCESS) {
                            
                            //  Allocate common function Input and Output Structures
                            pCCMN01UInputRec = new CCMN01UI();
                            
                            pCCMN01UOutputRec = new CCMN01UO();
                            pCCMN01UInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(TASK_MNTN_LIC);
                            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(null);
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(Cinv14s.EVENT_STATUS_APRV);
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_HOME);
                            
                            ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(0);
                            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccmn35si.getUlIdStage());
                            
                            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccmn35si.getUlIdPerson());
                            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr("Changed home status to Approved- Active.");
                            
                            //## BEGIN TUX/XML: Declare XML variables
                            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            
                            //  Call CINV43D
                            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    
                                    
                                    // CREATE AN APPROVAL LINK
                                    
                                    
                                    //  Allocate memory for Input and Output Structures
                                    pCCMN91DInputRec = new CCMN91DI();
                                    
                                    pCCMN91DOutputRec = new CCMN91DO();
                                    pCCMN91DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    pCCMN91DInputRec.setUlIdApproval(ccmn35si.getUlIdApproval());
                                    pCCMN91DInputRec.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                                    pCCMN91DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                    
                                    //  Set rc to ARC_SUCCESS
                                    rc = ccmn91dAUDdam(sqlca, pCCMN91DInputRec, pCCMN91DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            
                                            //  Set RetVal to FND_SUCCESS
                                            RetVal = SUCCESS;
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                            
                                            break;
                                    }
                                    if (RetVal == SUCCESS) {
                                        
                                        //  Allocate memory for Input and Output Structures
                                        pCAUDB3DInputRec = new CAUDB3DI();
                                        
                                        pCAUDB3DOutputRec = new CAUDB3DO();
                                        pCAUDB3DInputRec.setSzCdRsrcFaHomeStatus(HOME_STATUS_APVD_ACT);
                                        pCAUDB3DInputRec.setSzCdRsrcStatus(RSRC_STAT_ACTIVE);
                                        pCAUDB3DInputRec.setUlIdRsrcFaHomeEvent(pCCMN01UOutputRec.getUlIdEvent());
                                        pCAUDB3DInputRec.setUlIdRsrcFaHomeStage(ccmn35si.getUlIdStage());
                                        pCAUDB3DInputRec.setCIndRsrcWriteHist(FND_YES);
                                        pCAUDB3DInputRec.setDtDtApproversDetermination(ccmn35si.getROWCCMN61DI().getDtDtApproversDetermination());
                                        pCAUDB3DInputRec.setUlIdApproval(ccmn35si.getUlIdApproval());
                                        pCAUDB3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        rc = caudb3dAUDdam(sqlca, pCAUDB3DInputRec, pCAUDB3DOutputRec);
                                        
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                break;
                                            case Messages.MSG_FAD_NO_CARETAKER:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_FAD_NO_CARETAKER;
                                                RetVal = Csub50s.FND_FAIL;
                                                
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
                        }
                        if (RetVal == SUCCESS) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES41DInputRec = new CSES41DI();
                            
                            pCSES41DOutputRec = new CSES41DO();
                            pCSES41DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                            pCSES41DInputRec.setUlIdRsrcFaHomeStage(ccmn35si.getUlIdStage());
                            pCSES41DInputRec.getArchInputStruct().setUsPageNbr(1);
                            pCSES41DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                            rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
                            
                            //  Analyze error code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    ulIdResource1.value = pCSES41DOutputRec.getUlIdResource();
                                    
                                    
                                    if (!(FA_CATG_FOST.compareTo(pCSES41DOutputRec.getSzCdRsrcCategory()) != 0) ||!(FA_CATG_LEG_RISK.compareTo(pCSES41DOutputRec.getSzCdRsrcCategory()) != 0)) {
                                        bAdoptive = false;
                                    }
                                    
                                    //  Compare the birthdate and the system date to determine if
                                    // the difference between the two is  equal to or greater than
                                    // 18 years.  If so a message is returned
                                    if (!(FA_CATG_ADOPT.compareTo(pCSES41DOutputRec.getSzCdRsrcCategory()) != 0)) {
                                        bFoster = false;
                                    }
                                    
                                    
                                    //  Perform Stage Person Link retrieval
                                    //  Allocate memory for DAM Input and Output Structures
                                    
                                    else {
                                        
                                        //  If Category is not Adopt, retrieve the currently effective
                                        // Facilility_LOC row, see if an HOLD statuses need to be
                                        // updated to APPROVED.  If so, call a DAM to end date the
                                        // currently effective LOC row & insert the new LOC row.
                                        
                                        // Call CSEC25D
                                        
                                        //  Allocate memory for Input and Output Structures
                                        pCSEC25DInputRec = new CSEC25DI();
                                        
                                        pCSEC25DOutputRec = new CSEC25DO();
                                        pCSEC25DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                        pCSEC25DInputRec.getArchInputStruct().setUsPageNbr(1);
                                        pCSEC25DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                                        
                                        pCSEC25DInputRec.setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                                        
                                        //  Call CAUD05D
                                        rc = ARC_UTLGetDateAndTime(pCSEC25DInputRec.getDtDtPlcmtStart() , 0);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        rc = csec25dQUERYdam(sqlca, pCSEC25DInputRec, pCSEC25DOutputRec);
                                        
                                        //  Analyze error code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                if (pCSEC25DOutputRec.getCCdFlocStatus1() == FLOC_HOLD) {
                                                    pCSEC25DOutputRec.setCCdFlocStatus1(FLOC_ACTIVE);
                                                    bChange = true;
                                                }
                                                if (pCSEC25DOutputRec.getCCdFlocStatus2() == FLOC_HOLD) {
                                                    pCSEC25DOutputRec.setCCdFlocStatus2(FLOC_ACTIVE);
                                                    bChange = true;
                                                }
                                                
                                                //  If a row is retrieved in this dam then a subcare
                                                // stage already exists, and the user should be
                                                // notified
                                                //  If test for number of rows returned..
                                                // CSES21D will always return rc = 0
                                                // because it returns count. If the number of rows
                                                // returned is 0 and rc = sql_success then we
                                                // have a subcare stage does not exist and we can
                                                // continue; if the number of rows returned is 
                                                // greater than 0, then a subcare stage exists
                                                // and we should return the message to the user
                                                if (pCSEC25DOutputRec.getCCdFlocStatus3() == FLOC_HOLD) {
                                                    pCSEC25DOutputRec.setCCdFlocStatus3(FLOC_ACTIVE);
                                                    bChange = true;
                                                }
                                                //  SIR#2389: 8 January 1996
                                                // Check for bCdPersonChar value of '2'. If value is NO_PERSON_CHAR
                                                // or '2' that means NA was chosen on person char window.
                                                if (pCSEC25DOutputRec.getCCdFlocStatus4() == FLOC_HOLD) {
                                                    pCSEC25DOutputRec.setCCdFlocStatus4(FLOC_ACTIVE);
                                                    bChange = true;
                                                }
                                                if (pCSEC25DOutputRec.getCCdFlocStatus5() == FLOC_HOLD) {
                                                    pCSEC25DOutputRec.setCCdFlocStatus5(FLOC_ACTIVE);
                                                    bChange = true;
                                                }
                                                if (pCSEC25DOutputRec.getCCdFlocStatus6() == FLOC_HOLD) {
                                                    pCSEC25DOutputRec.setCCdFlocStatus6(FLOC_ACTIVE);
                                                    bChange = true;
                                                }
                                                if (bChange) {
                                                    //  Allocate memory for Input and Output Structures
                                                    pCAUD80DInputRec = new CAUD80DI();
                                                    
                                                    pCAUD80DOutputRec = new CAUD80DO();
                                                    pCAUD80DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                                    pCAUD80DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                    pCAUD80DInputRec.setUlIdResource(pCSEC25DOutputRec.getUlIdResource());
                                                    pCAUD80DInputRec.setCCdFlocStatus1(pCSEC25DOutputRec.getCCdFlocStatus1());
                                                    pCAUD80DInputRec.setCCdFlocStatus2(pCSEC25DOutputRec.getCCdFlocStatus2());
                                                    pCAUD80DInputRec.setCCdFlocStatus3(pCSEC25DOutputRec.getCCdFlocStatus3());
                                                    pCAUD80DInputRec.setCCdFlocStatus4(pCSEC25DOutputRec.getCCdFlocStatus4());
                                                    pCAUD80DInputRec.setCCdFlocStatus5(pCSEC25DOutputRec.getCCdFlocStatus5());
                                                    pCAUD80DInputRec.setCCdFlocStatus6(pCSEC25DOutputRec.getCCdFlocStatus6());
                                                    pCAUD80DInputRec.setCCdFlocStatus7(pCSEC25DOutputRec.getCCdFlocStatus7());
                                                    pCAUD80DInputRec.setCCdFlocStatus8(pCSEC25DOutputRec.getCCdFlocStatus8());
                                                    pCAUD80DInputRec.setCCdFlocStatus9(pCSEC25DOutputRec.getCCdFlocStatus9());
                                                    pCAUD80DInputRec.setCCdFlocStatus10(pCSEC25DOutputRec.getCCdFlocStatus10());
                                                    pCAUD80DInputRec.setCCdFlocStatus11(pCSEC25DOutputRec.getCCdFlocStatus11());
                                                    pCAUD80DInputRec.setCCdFlocStatus12(pCSEC25DOutputRec.getCCdFlocStatus12());
                                                    pCAUD80DInputRec.setCCdFlocStatus13(pCSEC25DOutputRec.getCCdFlocStatus13());
                                                    pCAUD80DInputRec.setCCdFlocStatus14(pCSEC25DOutputRec.getCCdFlocStatus14());
                                                    pCAUD80DInputRec.setCCdFlocStatus15(pCSEC25DOutputRec.getCCdFlocStatus15());
                                                    pCAUD80DInputRec.setSNbrFlocLevelsOfCare(pCSEC25DOutputRec.getSNbrFlocLevelsOfCare());
                                                    rc = ARC_UTLGetDateAndTime(pCAUD80DInputRec.getDtDtFlocEffect() , 0);
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                    
                                                    pCAUD80DInputRec.getDtDtFlocEnd().month = 12;
                                                    pCAUD80DInputRec.getDtDtFlocEnd().day = 31;
                                                    pCAUD80DInputRec.getDtDtFlocEnd().year = 4712;
                                                    pCAUD80DInputRec.setCIndFlocCancelAudit(INDICATOR_YES);
                                                    
                                                    //  Call TodoCommonFunction
                                                    rc = caud80dAUDdam(sqlca, pCAUD80DInputRec, pCAUD80DOutputRec);
                                                    
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
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                }
                                                
                                                break;
                                                
                                                // case SQL_NOT_FOUND:
                                                // pServiceStatus->severity = FND_SEVERITY_ERROR;
                                                // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                                                // RetVal = FND_SUCCESS;
                                                // rc = MSG_CMN_TMSTAMP_MISMATCH;
                                                // break;
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                //  Set RetVal to FND_SUCCESS
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
                        }
                    }
                    
                    
                    
                    // Begin SIR#15787: Set ulAdoptiveOrFoster based on home type
                    ulAdoptiveOrFoster = 0;
                    rc = CallCRES04D(ccmn35si, ulIdResource1.value, tsLastUpdate1, szAdoptiveOrFoster, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                    
                    
                    
                    if (SUCCESS == RetVal) {
                        
                        //  Allocate memory for pseudo"WCD" structure
                        pCFAD01DInputRec = new Cfad01a();
                        
                        // 
                        // (BEGIN): Contracts existance determination.  Is there an open foster
                        // and adoptive contract for the home?
                        // 
                        
                        // 
                        // (BEGIN): CLSS67D - List retrieval of Contract rows for and id resource.
                        // 
                        
                        pCLSS67DInputRec = new CLSS67DI();
                        
                        pCLSS67DOutputRec = new CLSS67DO();
                        pCLSS67DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                        pCLSS67DInputRec.setUlIdResource(ulIdResource1.value);
                        pCLSS67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS67DO._CLSS67DO__ROWCLSS67DO_SIZE);
                        pCLSS67DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                        rc = clss67dQUERYdam(sqlca, pCLSS67DInputRec, pCLSS67DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set fields in CFAD08SO to fields in CLSS67DO
                                ulContractQty = pCLSS67DOutputRec.getArchOutputStruct().getUlRowQty();
                                
                                //  Loop through all contract rows returned from the previous DAM
                                for (m = 0;m < ulContractQty;m++) {
                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(m).getUlIdContract();
                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].tsLastUpdate = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(m).getTsLastUpdate();
                                    
                                    // 
                                    // (BEGIN) CSES80D: Retrieve Contract Period table information
                                    // 
                                    
                                    pCSES80DInputRec = new CSES80DI();
                                    
                                    pCSES80DOutputRec = new CSES80DO();
                                    pCSES80DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    //##             ARC_PRFServiceStopTime( pfpb, pRTAF );
                                    pCSES80DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                    
                                    
                                    //  Call CAUDB8D
                                    rc = cses80dQUERYdam(sqlca, pCSES80DInputRec, pCSES80DOutputRec);
                                    
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm = pCSES80DOutputRec.getDtDtCnperTerm();
                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperClosure = pCSES80DOutputRec.getDtDtCnperClosure();
                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperStart = pCSES80DOutputRec.getDtDtCnperStart();
                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod = pCSES80DOutputRec.getUlNbrCnperPeriod();
                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate2 = pCSES80DOutputRec.getTsLastUpdate();
                                            
                                            // CSD - 4/16/03 - fix for error handling to return correct error
                                            rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            
                                            
                                            
                                            //  SIR 5043
                                            // Add logic to determine which stage we are coming from and if
                                            // it is INVestigation or Family PReservation, then we need to 
                                            // see if there is a Conclusion or Closure event and what the 
                                            // status is
                                            if (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year > dtTempDate.year) {
                                                testBool = true;
                                            }
                                            //  If years are equal and month is greater
                                            else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month > dtTempDate.month)) {
                                                testBool = true;
                                            }
                                            //  If years and months are equal and day is greater
                                            else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.day > dtTempDate.day)) {
                                                testBool = true;
                                            }
                                            //  If year, month and day are equal
                                            else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.day == dtTempDate.day)) {
                                                testBool = true;
                                            }
                                            else {
                                                testBool = false;
                                            }
                                            if (testBool) {
                                                if (0 != CONTRACT_STATUS_CLOSED.compareTo(pCSES80DOutputRec.getSzCdCnperStatus())) {
                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = 1;
                                                }
                                                else {
                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = 0;
                                                }
                                            }
                                            else {
                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = 0;
                                            }
                                            RetVal = SUCCESS;
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                            break;
                                            
                                        default :
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
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
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        if (SUCCESS == RetVal) {
                            
                            //  Loop through all contract rows returned from the previous DAMs
                            for (m = 0;m < ulContractQty;m++) {
                                if (pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) {
                                    
                                    // 
                                    // (BEGIN): CSES81D - Contract Version retrieve for an idContract
                                    // , contract period number, and version end date that is greater
                                    // than the current date.
                                    // 
                                    
                                    pCSES81DInputRec = new CSES81DI();
                                    
                                    pCSES81DOutputRec = new CSES81DO();
                                    pCSES81DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
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
                                            pCLSS13DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                            pCLSS13DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                            pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
                                            pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                            
                                            //  Call CAUD05D
                                            rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
                                            tempSvcRowQty = 0;
                                            
                                            //  Analyze error code
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
                                                        
                                                        // SIR 18571 - also set CCL for FSU and FRE stages
                                                        if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                            
                                                            bIndFosterContractExists = true;
                                                            bIndUpdateFosterContract = 1;
                                                        }
                                                        //  Populate Output Message
                                                        if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                            
                                                            bIndAdoptContractExists = true;
                                                            bIndUpdateAdoptContract = 1;
                                                        }
                                                        
                                                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                                        // 01/22/2003 DWW: Added for error handling
                                                        if (tempSvcRowQty >= 0) {
                                                            pCLSS68DInputRec = new CLSS68DI();
                                                            
                                                            pCLSS68DOutputRec = new CLSS68DO();
                                                            pCLSS68DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
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
                                                                    
                                                                    //  Call CAUD07D
                                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                                    tempSvcRowQty = - 1;
                                                                    break;
                                                                default :
                                                                    
                                                                    RetVal = Csub50s.FND_FAIL;
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                    
                                                default :
                                                    
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
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
                    }
                    
                    if (SUCCESS == RetVal) {
                        
                        // 
                        // (BEGIN) CINT20D: Retrieve Primary Worker from Stage Person Link.
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCINT20DInputRec = new CINT20DI();
                        
                        pCINT20DOutputRec = new CINT20DO();
                        pCINT20DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                        pCINT20DInputRec.setUlIdStage(ccmn35si.getUlIdStage());
                        pCINT20DInputRec.setSzCdStagePersRole(PERSON_STAGE_ROLE_PRIMARY);
                        pCINT20DInputRec.setSzCdStagePersType(Cint12s.PERSON_TYPE_WORKER);
                        rc = cint20dQUERYdam(sqlca, pCINT20DInputRec, pCINT20DOutputRec);
                        
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
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                // 
                                // (END): Retrieve DAM: cses37d      Placement simple retrieve
                                // 
                                break;
                        }
                        
                        if (SUCCESS == RetVal) {
                            // 
                            // (BEGIN): CRES13D Retrieve Resource Address
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCRES13DInputRec = new CRES13DI();
                            
                            pCRES13DOutputRec = new CRES13DO();
                            pCRES13DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                            pCRES13DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES13DO._CRES13DO__ROWCRES13DO_SIZE);
                            pCRES13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                            pCRES13DInputRec.setUlIdResource(ulIdResource1.value);
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
                                    
                                    //  If the city is not found, we treat the return code as
                                    // success.  The city could be out of state.
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
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                    }
                    
                    if (RetVal == SUCCESS) {
                        
                        // 
                        // (BEGIN): CSES41D - Retreive Resource Info
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES41DInputRec = new CSES41DI();
                        
                        pCSES41DOutputRec = new CSES41DO();
                        pCSES41DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                        pCSES41DInputRec.setUlIdRsrcFaHomeStage(ccmn35si.getUlIdStage());
                        rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                szTempCdRsrcCnty = pCSES41DOutputRec.getSzCdRsrcCnty();
                                
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
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        
                        if (SUCCESS == RetVal) {
                            
                            if (0 == szTempCdRsrcCnty.compareTo(COUNTY_CD_OUT_OF_STATE)) {
                                // 
                                // (BEGIN): CCMN39D - Retrieve Primary Worker's Region
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMN39DInputRec = new CCMN39DI();
                                
                                pCCMN39DOutputRec = new CCMN39DO();
                                pCCMN39DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCCMN39DInputRec.setUlIdPerson(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                                pCCMN39DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
                                
                                // Call DAM
                                rc = ccmn39dQUERYdam(sqlca, pCCMN39DInputRec, pCCMN39DOutputRec);
                                
                                
                                // Analyze return code
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        // * Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        if ('0' == pCCMN39DOutputRec.getSzCdUnitRegion()[0]) {
                                            szTempCdCntrctRegion = CStringUtils.setCharAt(szTempCdCntrctRegion, 0, pCCMN39DOutputRec.getSzCdUnitRegion()[1]);
                                            szTempCdCntrctRegion = CStringUtils.setCharAt(szTempCdCntrctRegion, 1, pCCMN39DOutputRec.getSzCdUnitRegion()[2]);
                                        }
                                        //   If someone with a division number is trying to save then
                                        // it will be defaulted to state office.
                                        
                                        else {
                                            szTempCdCntrctRegion = CAPS_UNIT_STATE_OFFICE;
                                        }
                                        break;
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        // 
                                        // (END): Common Function: ccmn03u   CloseOpenStage common function
                                        // 
                                        break;
                                }
                            }
                            
                            // 
                            // (END): CCMN39D - Retrieve Primary Worker's Region
                            // 
                            
                            else {
                                // 
                                // (BEGIN): CSES82D - Region retrieval from Region/County table
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCSES82DInputRec = new CSES82DI();
                                
                                pCSES82DOutputRec = new CSES82DO();
                                pCSES82DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCSES82DInputRec.setSzCdRsrcSvcCnty(szTempCdRsrcCnty);
                                //  if you get 'SQL_NOT_FOUND' (that is, row not found, 1403)
                                // when attempting a delete that is okay; it means that there were 
                                // no employees associated with that ID_ON_CALL, which is okay.
                                // if rc is anything other than SQL_NOT_FOUND, 
                                // then execute PROCESS_TUX_SQL_ERROR_TRANSACT.
                                rc = cses82dQUERYdam(sqlca, pCSES82DInputRec, pCSES82DOutputRec);
                                
                                //  Analyze error code
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        szTempCdCntrctRegion = pCSES82DOutputRec.getSzCdRsrcSvcRegion();
                                        
                                        // Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        break;
                                        break;
                                        
                                    default :
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                        }
                        
                        // 
                        // (END): CSES82D - Region/County retrieve
                        // 
                        
                        
                        
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
                            if (SUCCESS == RetVal) {
                                // 
                                // (BEGIN): CAUD01D CONTRACT AUD
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD01DInputRec = new CAUD01DI();
                                
                                pCAUD01DOutputRec = new CAUD01DO();
                                pCAUD01DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCAUD01DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD01DInputRec.setUlIdResource(ulIdResource1.value);
                                pCAUD01DInputRec.setSzCdCntrctFuncType(STAGE_CD_FAD);
                                pCAUD01DInputRec.setSzCdCntrctProgramType(FA_PROGRAM);
                                pCAUD01DInputRec.setSzCdCntrctProcureType(PROVIDER_ENROLL);
                                pCAUD01DInputRec.setSzCdCntrctRegion(szTempCdCntrctRegion);
                                pCAUD01DInputRec.setCIndCntrctBudgLimit(NO_LIMIT);
                                pCAUD01DInputRec.setUlIdRsrcAddress(ulTempIdRsrcAddress);
                                pCAUD01DInputRec.setUlIdCntrctManager(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                                pCAUD01DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
                                rc = caud01dAUDdam(sqlca, pCAUD01DInputRec, pCAUD01DOutputRec);
                                
                                
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
                                        
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                            }
                            
                            if (SUCCESS == RetVal) {
                                // 
                                // BEGIN CAUD20D  CONTRACT PERIOD
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD20DInputRec = new CAUD20DI();
                                
                                pCAUD20DOutputRec = new CAUD20DO();
                                pCAUD20DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD20DInputRec.setUlIdContract(ulIdTempContract);
                                pCAUD20DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
                                pCAUD20DInputRec.setUlNbrCnperPeriod(Ccmn19s.ONE);
                                rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                
                                dtCurrentDate = dtTempDate;
                                rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
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
                                            
                                            //  SIR #10053 - 6/12/96 - PURCELA - Set RetVal to
                                            // FND_FAIL
                                            RetVal = Csub50s.FND_FAIL;
                                        }
                                        
                                        
                                        else {
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  SIR #10053 - 6/12/96 - PURCELA - Set RetVal to
                                            // FND_SUCCESS
                                            RetVal = SUCCESS;
                                            
                                            
                                            // 
                                            // BEGIN CAUD15D  CONTRACT VERSION
                                            // 
                                            
                                            //   CAUD15D - CONTRACT VERSION AUD
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCAUD15DInputRec = new CAUD15DI();
                                            
                                            pCAUD15DOutputRec = new CAUD15DO();
                                            pCAUD15DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                            
                                            pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                            
                                            pCAUD15DInputRec.setUlIdContract(ulIdTempContract);
                                            pCAUD15DInputRec.setUlNbrCnverPeriod(Ccmn19s.ONE);
                                            pCAUD15DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
                                            pCAUD15DInputRec.setUlNbrCnverVersion(Ccmn19s.ONE);
                                            rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            
                                            dtCurrentDate = dtTempDate;
                                            pCAUD15DInputRec.setDtDtCnverCreate(dtTempDate);
                                            pCAUD15DInputRec.setDtDtCnverEffective(dtTempDate);
                                            rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            pCAUD15DInputRec.setDtDtCnverEnd(dtCurrentDate);
                                            pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                                            rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                                            
                                            //  Analyze return code
                                            
                                            switch (rc) {
                                                    
                                                    //  SIR 20878- If no record exists, display MSG_REC_RETN_NOT_FOUND
                                                    // to inform user that no Records Retention data exists for the
                                                    // case. (This will take care of cases in which data has not yet
                                                    // been assigned for conversion).
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    RetVal = SUCCESS;
                                                    break;
                                                    
                                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                    RetVal = SUCCESS;
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    
                                                    //  SIR #10053 - 6/12/96 - PURCELA - Set RetVal to
                                                    // FND_SUCCESS
                                                    RetVal = SUCCESS;
                                                    // 
                                                    // (END): Retrieve DAM: cmsc14d      Check # of PAL training elements
                                                    // 
                                                    break;
                                            }
                                        }
                                        break;
                                        
                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                        RetVal = Csub50s.FND_FAIL;
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        RetVal = Csub50s.FND_FAIL;
                                        
                                        break;
                                }
                            }
                            
                            if (Ccfc51u.FOSTER == usCreateContract && SUCCESS == RetVal) {
                                // 
                                // BEGIN CAUD17D - CONTRACT SERVICE
                                // 
                                
                                pCAUD17DInputRec = new CAUD17DI();
                                
                                pCAUD17DOutputRec = new CAUD17DO();
                                pCAUD17DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD17DInputRec.setUlIdContract(ulIdTempContract);
                                pCAUD17DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
                                pCAUD17DInputRec.setUlNbrCnsvcPeriod(Ccmn19s.ONE);
                                pCAUD17DInputRec.setUlNbrCnsvcVersion(Ccmn19s.ONE);
                                pCAUD17DInputRec.setSzNbrCnsvcUnitType(DAY_24_HOURS);
                                pCAUD17DInputRec.setSzCdCnsvcPaymentType(UNIT_RATE_PAYMENT_TYPE);
                                pCAUD17DInputRec.setCIndCnsvcNewRow(FND_NO);
                                
                                CounterP = 0;
                                
                                // SIR 19613 There are now 4 Service Codes for Foster Levels, only
                                // Loop through and save those codes
                                while (CounterP < NBR_SVC_CODE_SIXTY_ABCD && RetVal == SUCCESS) {
                                    pCAUD17DInputRec.setUlNbrCnsvcLineItem(CounterP + 1);
                                    
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
                                    
                                    // Call DAM
                                    rc = caud17dAUDdam(sqlca, pCAUD17DInputRec, pCAUD17DOutputRec);
                                    
                                    //  Analyze error code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            RetVal = SUCCESS;
                                            
                                            // 
                                            // End Call to Stage Person Link Retrieval Dam - CMSC23D
                                            // 
                                            
                                            //  DO NOT use PAYEE - That is the facility or the person
                                            // who will be receiving money, not the AdptSubsidyWorker.
                                            // If rc = SQL_SUCCESS,   ulIdAdptSubPayee will be > 0
                                            // If rc = SQL_NOT_FOUND, ulIdAdptSubPayee will be = 0
                                            break;
                                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                            RetVal = Csub50s.FND_FAIL;
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                    CounterP++;
                                }
                            }
                            
                            if (ADOPTIVE == usCreateContract && SUCCESS == RetVal) {
                                // 
                                // BEGIN CAUD17D
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD17DInputRec = new CAUD17DI();
                                
                                pCAUD17DOutputRec = new CAUD17DO();
                                pCAUD17DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD17DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
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
                                        
                                        //  SIR #10053 - 6/12/96 - PURCELA - Added setting
                                        // of RetVal to FND_SUCCESS
                                        
                                        RetVal = SUCCESS;
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCAUD17DInputRec = new CAUD17DI();
                                        
                                        pCAUD17DOutputRec = new CAUD17DO();
                                        pCAUD17DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                        pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        pCAUD17DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
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
                                                
                                                //  SIR #10053 - 6/12/96 - PURCELA - Added setting
                                                // of RetVal to FND_SUCCESS
                                                
                                                RetVal = SUCCESS;
                                                break;
                                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                
                                                //  SIR #10053 - 6/12/96 - PURCELA - Added setting
                                                // of RetVal to FND_FAIL
                                                
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                //  SIR #10053 - 6/12/96 - PURCELA - Added setting
                                                // of RetVal to FND_FAIL
                                                
                                                RetVal = Csub50s.FND_FAIL;
                                                // 
                                                // (END): Retrieve DAM: csec37d      Find employee with skill retrieve
                                                // 
                                                break;
                                        }
                                        break;
                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                        
                                        //  SIR #10053 - 6/12/96 - PURCELA - Added setting
                                        // of RetVal to FND_FAIL
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        // 
                                        // (END): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
                                        // 
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        //  SIR #10053 - 6/12/96 - PURCELA - Added setting
                                        // of RetVal to FND_FAIL
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            
                            if (SUCCESS == RetVal) {
                                // 
                                // BEGIN CAUD08D - Contract County Insert
                                // 
                                
                                pCAUD08DInputRec = new CAUD08DI();
                                
                                pCAUD08DOutputRec = new CAUD08DO();
                                pCAUD08DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                pCAUD08DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());// SIR #13420
                                
                                //  Initialize current date to dtTempDate(today's date) and
                                // Add years, no months and no years to dtCurrentDate
                                dtCurrentDate = dtTempDate;
                                
                                // Call DAM
                                rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtTempDate2);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                                pCAUD08DInputRec.setUlIdContract(ulIdTempContract);
                                pCAUD08DInputRec.setUlIdResource(ulIdResource1.value);
                                pCAUD08DInputRec.setSzCdCncntyCounty(szTempCdRsrcCnty);// SIR #13420
                                pCAUD08DInputRec.setDtDtCncntyEffective(dtTempDate);
                                pCAUD08DInputRec.setUlNbrCncntyPeriod(Ccmn19s.ONE);
                                pCAUD08DInputRec.setUlNbrCncntyVersion(Ccmn19s.ONE);
                                
                                // 
                                // END CAUD17D
                                // 
                                
                                // BEGIN SIR #15787: From "BEGIN CAUD08D..." to "END CAUD08D..."
                                // is replace by this new code
                                
                                usCountyRow = 0;
                                
                                // 19613 Basic homes now use only one code
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
                                                
                                                // 
                                                // (END): Retrieve DAM: cres04d      Caps_resource simple retrieve
                                                // 
                                                break;
                                            }
                                        }
                                        for (usCountyRow = 0;usCountyRow < NBR_OF_HOME_TYPE;usCountyRow++) {
                                            if (szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_HABIL || szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_THER || szAdoptiveOrFoster.charAt(usCountyRow) == FOST_TYPE_PRIM_MED) {
                                                
                                                if (!bGroupHome) {
                                                    // 19613, 22390, 22485 Habil, Ther, and Prim Med homes use two codes 63A, B, C & D
                                                    ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABCD;
                                                    break;
                                                }
                                                else {
                                                    ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_ABC;
                                                    // 
                                                    // (END): Retrieve DAM: csec29d      Stage & StagePersonLink retrieve
                                                    // 
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                else if (ADOPTIVE == usCreateContract) {
                                    ulAdoptiveOrFoster = NBR_SVC_CODE_SIXTY_AB;
                                }
                                else {
                                    ulAdoptiveOrFoster = 0;
                                }
                                
                                usCountyRow = 0;
                                //   County AUD processing CAUD08D
                                while (usCountyRow < ulAdoptiveOrFoster && SUCCESS == pServiceStatus.explan_code) {
                                    
                                    if (Ccfc51u.FOSTER == usCreateContract && bFoster) {
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
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                    usCountyRow++;
                                }
                            }
                        }
                    }
                    
                    if (RetVal == SUCCESS) {
                        
                        m = 0;
                        //  Only modify contracts when flags are TRUE
                        while (bIndUpdateAdoptContract != 0 || bIndUpdateFosterContract != 0) {
                            if (pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) {
                                //## END TUX/XML: Turn the XML buffer into an input message struct
                                
                                
                                
                                if (bIndUpdateAdoptContract != 0 && (0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]))) {
                                    bIndUpdateAdoptContract = 0;
                                    usUpdateContract = ADOPTIVE;
                                }
                                
                                else if (bIndUpdateFosterContract != 0 && (0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]) || 0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[0]))) {
                                    bIndUpdateFosterContract = 0;
                                    usUpdateContract = Ccfc51u.FOSTER;
                                }
                                
                                // SIR 20813:  Update the contract table when approving the home.
                                // This is necessary if a prs home has been reopened and the region
                                // has changed before the home has been re-approved.
                                
                                // 
                                // (BEGIN): CAUD01D CONTRACT AUD
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCAUD01DInputRec = new CAUD01DI();
                                
                                pCAUD01DOutputRec = new CAUD01DO();
                                pCAUD01DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCAUD01DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                pCAUD01DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                pCAUD01DInputRec.setUlIdResource(ulIdResource1.value);
                                pCAUD01DInputRec.setSzCdCntrctFuncType(STAGE_CD_FAD);
                                pCAUD01DInputRec.setSzCdCntrctProgramType(FA_PROGRAM);
                                pCAUD01DInputRec.setSzCdCntrctProcureType(PROVIDER_ENROLL);
                                pCAUD01DInputRec.setSzCdCntrctRegion(szTempCdCntrctRegion);
                                pCAUD01DInputRec.setCIndCntrctBudgLimit(NO_LIMIT);
                                pCAUD01DInputRec.setUlIdRsrcAddress(ulTempIdRsrcAddress);
                                pCAUD01DInputRec.setUlIdCntrctManager(pCFAD01DInputRec.ROWCFAD08SIG07[(int) FIRST_REC].ulIdCntrctManager);
                                pCAUD01DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
                                pCAUD01DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[m].tsLastUpdate);
                                rc = caud01dAUDdam(sqlca, pCAUD01DInputRec, pCAUD01DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  SIR #10053 - 6/12/96 - PURCELA - Added setting
                                        // of RetVal to FND_SUCCESS
                                        
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
                                
                                if (SUCCESS == RetVal) {
                                    // 
                                    // BEGIN CAUD20D  CONTRACT PERIOD
                                    // 
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCAUD20DInputRec = new CAUD20DI();
                                    
                                    pCAUD20DOutputRec = new CAUD20DO();
                                    pCAUD20DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    
                                    pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                    pCAUD20DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                    pCAUD20DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
                                    
                                    
                                    // 
                                    // Service Macro Definitions
                                    // 
                                    
                                    // 
                                    // Function Prototypes
                                    // 
                                    pCAUD20DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod);
                                    pCAUD20DInputRec.setDtDtCnperClosure(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperClosure);
                                    pCAUD20DInputRec.setDtDtCnperTerm(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm);
                                    
                                    pCAUD20DInputRec.setDtDtCnperStart(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperStart);
                                    pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_ACTIVE);
                                    pCAUD20DInputRec.setCIndCnperRenewal('N');
                                    pCAUD20DInputRec.setCIndCnperSigned('Y');
                                    pCAUD20DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate2);
                                    
                                    // Call DAM
                                    rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            if (false == pCAUD20DOutputRec.getUlSysCdGenericReturnCode()) {
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_CON_CLOSURE_AFTER_EFF;
                                                RetVal = Csub50s.FND_FAIL;
                                            }
                                            
                                            else {
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                RetVal = SUCCESS;
                                            }
                                            break;
                                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                }
                                // 
                                // END CAUD20D
                                // 
                                
                                // SIR #15787:
                                // SIR 15920: Called CheckCatHomeType function and Added
                                // CategoryHomeType == 0 condition to the if statement. We only want to
                                // create new version if Category and/or home type is changed
                                CategoryHomeType = CheckCatHomeType(ccmn35si, ulIdResource1.value, pServiceStatus);
                                if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) && (usUpdateContract == Ccfc51u.FOSTER) &&!CategoryHomeType) {
                                    rc = Cfad38s.ContractVerSerCnty(ccmn35si, pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract, pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod, ulIdResource1.value, pServiceStatus);
                                    if (rc != SUCCESS) {
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                    }
                                }
                            }
                            m++;
                        }
                    }
                }
                
                // 
                // END SIR 20324: CONTRACT CREATION/MODIFICATION
                // 
                
                
                //  SIR 4030 - Added else if to call CSUB40V, to create a Todo, when the
                // task is re-evaluate and Approved
                else if ((0 == (pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(RE_EVALUATE))) && (0 == (ccmn35si.getSzWcdCdAprvlWinaction().compareTo(WIN_COMPAPRV)))) {
                    // Create Todo
                    
                    //  Allocate memory for Common Function Input
                    // and Output Structures
                    
                    pTodoCommonInput = new CSUB40UI();
                    
                    pTodoCommonOutput = new CSUB40UO();
                    pTodoCommonInput.setArchInputStruct(ccmn35si.getArchInputStruct());
                    pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_FA_HOME);
                    ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccmn35si.getUlIdPerson());
                    //   PROCESS_TUX_SQL_ERROR_NOFREE is called only when there is an unexpected
                    // SQL error returned from the DAM.
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn35si.getUlIdStage());
                    rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
                
                //  Analyze error code
                if ((0 == (pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask().compareTo(TASK_CLOSE_HOME))) && (RetVal == SUCCESS)) {
                    
                    // END SIR#72 - ISF - 04.03.95
                    
                    //  SVC AUTH ENH -- If the stage is closed, stage close date
                    // and IndStageClose need to be passed to
                    // CallCINV51D to be used in logic there
                    if (0 == (ccmn35si.getSzWcdCdAprvlWinaction().compareTo(WIN_COMPAPRV))) {
                        //  Create an Event
                        
                        //  Allocate common function Input and Output Structures
                        pCCMN01UInputRec = new CCMN01UI();
                        
                        pCCMN01UOutputRec = new CCMN01UO();
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        pCCMN01UInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask("");
                        pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(null);
                        
                        //  Run-time versioning
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(Cinv14s.EVENT_STATUS_APRV);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_HOME);
                        
                        ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(0);
                        
                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(ccmn35si.getUlIdStage());
                        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(ccmn35si.getUlIdPerson());
                        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr("Home Closed.");
                        pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                ulIdEvent2 = pCCMN01UOutputRec.getUlIdEvent();
                                
                                
                                // CREATE AN APPROVAL LINK
                                
                                //  Only create an approval link if the event was created successfully
                                // above
                                
                                //  Allocate memory for Input and Output Structures
                                pCCMN91DInputRec = new CCMN91DI();
                                
                                pCCMN91DOutputRec = new CCMN91DO();
                                pCCMN91DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                pCCMN91DInputRec.setUlIdApproval(ccmn35si.getUlIdApproval());
                                pCCMN91DInputRec.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                                
                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                pCCMN91DInputRec.setTsLastUpdate(pCCMN01UOutputRec.getTsLastUpdate());
                                pCCMN91DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                rc = ccmn91dAUDdam(sqlca, pCCMN91DInputRec, pCCMN91DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        
                                        //  Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                                
                                if (RetVal == SUCCESS) {
                                    
                                    //  Allocate memory for Input and Output Structures
                                    pCAUDB3DInputRec = new CAUDB3DI();
                                    
                                    pCAUDB3DOutputRec = new CAUDB3DO();
                                    pCAUDB3DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                    pCAUDB3DInputRec.setSzCdRsrcFaHomeStatus(HOME_STATUS_CLOSED);
                                    pCAUDB3DInputRec.setSzCdRsrcStatus(RSRC_STAT_INACTIVE);
                                    pCAUDB3DInputRec.setUlIdRsrcFaHomeEvent(ulIdEvent2);
                                    pCAUDB3DInputRec.setUlIdRsrcFaHomeStage(ccmn35si.getUlIdStage());
                                    pCAUDB3DInputRec.setCIndRsrcWriteHist(FND_YES);
                                    pCAUDB3DInputRec.setDtDtApproversDetermination(ccmn35si.getROWCCMN61DI().getDtDtApproversDetermination());
                                    pCAUDB3DInputRec.setUlIdApproval(ccmn35si.getUlIdApproval());
                                    pCAUDB3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                    
                                    //  Call DAM
                                    rc = caudb3dAUDdam(sqlca, pCAUDB3DInputRec, pCAUDB3DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            
                                            //  Set RetVal to FND_SUCCESS
                                            RetVal = SUCCESS;
                                            break;
                                        case Messages.MSG_FAD_INVAL_CLOSE_DT:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_FAD_INVAL_CLOSE_DT;
                                            RetVal = Csub50s.FND_FAIL;
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
                        
                        if (RetVal == SUCCESS) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES41DInputRec = new CSES41DI();
                            
                            pCSES41DOutputRec = new CSES41DO();
                            pCSES41DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                            pCSES41DInputRec.setUlIdRsrcFaHomeStage(ccmn35si.getUlIdStage());
                            pCSES41DInputRec.getArchInputStruct().setUsPageNbr(1);
                            pCSES41DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                            
                            
                            
                            rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    ulIdResource1.value = pCSES41DOutputRec.getUlIdResource();
                                    
                                    if (WtcHelperConstants.ARC_SUCCESS == rc) {
                                        pCFAD01DInputRec = new Cfad01a();
                                        
                                        // 
                                        // (BEGIN): Contracts existance determination.  Is there an open foster
                                        // and adoptive contract for the home?
                                        // 
                                        
                                        // 
                                        // (BEGIN): CLSS67D - List retrieval of Contract rows for and id resource.
                                        // 
                                        
                                        pCLSS67DInputRec = new CLSS67DI();
                                        
                                        pCLSS67DOutputRec = new CLSS67DO();
                                        pCLSS67DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                        pCLSS67DInputRec.setUlIdResource(ulIdResource1.value);
                                        pCLSS67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS67DO._CLSS67DO__ROWCLSS67DO_SIZE);
                                        pCLSS67DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                        rc = clss67dQUERYdam(sqlca, pCLSS67DInputRec, pCLSS67DOutputRec);
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Set fields in CFAD08SO to fields in CLSS67DO
                                                
                                                ulContractQty = pCLSS67DOutputRec.getArchOutputStruct().getUlRowQty();
                                                
                                                //  Loop through all contract rows returned from the previous DAM
                                                for (m = 0;m < ulContractQty;m++) {
                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(m).getUlIdContract();
                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].tsLastUpdate = pCLSS67DOutputRec.getROWCLSS67DO_ARRAY().getROWCLSS67DO(m).getTsLastUpdate();
                                                    
                                                    // 
                                                    // (BEGIN) CSES80D: Retrieve Contract Period table information
                                                    // 
                                                    
                                                    pCSES80DInputRec = new CSES80DI();
                                                    
                                                    pCSES80DOutputRec = new CSES80DO();
                                                    pCSES80DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                                    pCSES80DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                    
                                                    //  Declare FOUNDATION variables
                                                    
                                                    //  Declare local variables
                                                    
                                                    
                                                    // Start performance timer
                                                    
                                                    rc = cses80dQUERYdam(sqlca, pCSES80DInputRec, pCSES80DOutputRec);
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCntrctWkr = pCSES80DOutputRec.getUlIdCntrctWkr();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm = pCSES80DOutputRec.getDtDtCnperTerm();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperClosure = pCSES80DOutputRec.getDtDtCnperClosure();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperStart = pCSES80DOutputRec.getDtDtCnperStart();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod = pCSES80DOutputRec.getUlNbrCnperPeriod();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate2 = pCSES80DOutputRec.getTsLastUpdate();
                                                            rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                            
                                                            if (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year > dtTempDate.year) {
                                                                testBool = true;
                                                            }
                                                            //  If years are equal and month is greater
                                                            else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month > dtTempDate.month)) {
                                                                testBool = true;
                                                            }
                                                            //  If years and months are equal and day is greater
                                                            else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.day > dtTempDate.day)) {
                                                                testBool = true;
                                                            }
                                                            //  If year, month and day are equal
                                                            else if ((pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.year == dtTempDate.year) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.month == dtTempDate.month) && (pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm.day == dtTempDate.day)) {
                                                                testBool = true;
                                                            }
                                                            else {
                                                                testBool = false;
                                                            }
                                                            if (testBool) {
                                                                if (0 != CONTRACT_STATUS_CLOSED.compareTo(pCSES80DOutputRec.getSzCdCnperStatus())) {
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = 1;
                                                                }
                                                                else {
                                                                    pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = 0;
                                                                }
                                                            }
                                                            else {
                                                                pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent = 0;
                                                            }
                                                            RetVal = SUCCESS;
                                                            break;
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                                            
                                                            break;
                                                            
                                                        default :
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
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
                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                break;
                                                
                                            default :
                                                
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                break;
                                        }
                                        
                                        //  Analyze error code
                                        if (SUCCESS == RetVal) {
                                            //  Loop through all contract rows returned from the previous DAMs
                                            for (m = 0;m < ulContractQty;m++) {
                                                if (pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) {
                                                    
                                                    // 
                                                    // (BEGIN): CSES81D - Contract Version retrieve for an idContract
                                                    // , contract period number, and version end date that is greater
                                                    // than the current date.
                                                    // 
                                                    
                                                    pCSES81DInputRec = new CSES81DI();
                                                    
                                                    pCSES81DOutputRec = new CSES81DO();
                                                    pCSES81DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
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
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCnver = pCSES81DOutputRec.getUlIdCnver();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnverCreate = pCSES81DOutputRec.getDtDtCnverCreate();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnverEnd = pCSES81DOutputRec.getDtDtCnverEnd();
                                                            pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnverEffective = pCSES81DOutputRec.getDtDtCnverEffective();
                                                            
                                                            // 
                                                            // (BEGIN): CLSS13D - Retrieve contract service codes for
                                                            // the contract, period, and version passed to the DAM.
                                                            // 
                                                            pCLSS13DInputRec = new CLSS13DI();
                                                            
                                                            pCLSS13DOutputRec = new CLSS13DO();
                                                            pCLSS13DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                                            pCLSS13DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                            pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
                                                            
                                                            pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                                            rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
                                                            tempSvcRowQty = 0;
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
                                                                            pCLSS68DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                                                            pCLSS68DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                                            pCLSS68DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod);
                                                                            pCLSS68DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnverVersion);
                                                                            pCLSS68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS68DO._CLSS68DO__ROWCLSS68DO_SIZE);
                                                                            pCLSS68DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
                                                                            rc = clss68dQUERYdam(sqlca, pCLSS68DInputRec, pCLSS68DOutputRec);
                                                                            switch (rc) {
                                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                    pServiceStatus.explan_code = SUCCESS;
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
                                                                                    // 
                                                                                    // (END): Common Function: ccmn01u   Post Event common function
                                                                                    // 
                                                                                    break;
                                                                                case NO_DATA_FOUND:
                                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                                                    tempSvcRowQty = - 1;
                                                                                    break;
                                                                                default :
                                                                                    
                                                                                    RetVal = Csub50s.FND_FAIL;
                                                                                    
                                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
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
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    
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
                                                            break;
                                                            
                                                        default :
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (SUCCESS == RetVal) {
                                        // 
                                        // (BEGIN): Contract modification process if the contract already
                                        // exists and a change has been made to the home's
                                        // status SIR 20324
                                        // 
                                        //  UPDATE CODE 
                                        //  Initialize contract counter
                                        m = 0;
                                        //  Only modify contracts where flag is TRUE
                                        while (bIndUpdateAdoptContract != 0 || bIndUpdateFosterContract != 0) {
                                            
                                            //  Analyze error code
                                            if (pCFAD01DInputRec.ROWCFAD08SIG07[m].cSysIndContractCurrent) {
                                                if (bIndUpdateAdoptContract != 0) {
                                                    bIndUpdateAdoptContract = 0;
                                                    usUpdateContract = ADOPTIVE;
                                                }
                                                
                                                else if (bIndUpdateFosterContract != 0) {
                                                    bIndUpdateFosterContract = 0;
                                                    usUpdateContract = Ccfc51u.FOSTER;
                                                }
                                                
                                                // 
                                                // BEGIN CAUD20D  CONTRACT PERIOD
                                                // 
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCAUD20DInputRec = new CAUD20DI();
                                                
                                                pCAUD20DOutputRec = new CAUD20DO();
                                                
                                                //## BEGIN TUX/XML: Declare XML variables
                                                pCAUD20DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                                pCAUD20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                pCAUD20DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                pCAUD20DInputRec.setUlIdCntrctWkr(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCntrctWkr);
                                                pCAUD20DInputRec.setUlNbrCnperPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod);
                                                
                                                //  Run loop four times to guarantee all contract
                                                // services will be checked.
                                                for (j = 0;j < tmpSvcRowQty1;j++) {
                                                    
                                                    if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                        pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_CLOSED);
                                                        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                        rc = ARC_UTLCompareDateAndTime((FndInt3date) & pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperStart, 0, (FndInt3date) & dtCurrentDate, 0);
                                                        
                                                        if (0 == rc) {
                                                            rc = ARC_UTLAddToDate((FndInt3date) & dtCurrentDate, (FndInt3date) & dtAddOneDay);
                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                        }
                                                        pCAUD20DInputRec.setDtDtCnperTerm(dtCurrentDate);
                                                        pCAUD20DInputRec.setDtDtCnperClosure(dtCurrentDate);
                                                    }
                                                    
                                                    if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                        pCAUD20DInputRec.setSzCdCnperStatus(CONTRACT_STATUS_SERVICE_HOLD);
                                                        pCAUD20DInputRec.setDtDtCnperTerm(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperTerm);
                                                        pCAUD20DInputRec.setDtDtCnperClosure(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperClosure);
                                                    }
                                                }
                                                pCAUD20DInputRec.setDtDtCnperStart(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnperStart);
                                                pCAUD20DInputRec.setCIndCnperRenewal('N');
                                                pCAUD20DInputRec.setCIndCnperSigned('Y');
                                                pCAUD20DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate2);
                                                rc = caud20dAUDdam(sqlca, pCAUD20DInputRec, pCAUD20DOutputRec);
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
                                                            // BEGIN CAUD15D  CONTRACT VERSION
                                                            // 
                                                            
                                                            //   CAUD15D - CONTRACT VERSION AUD
                                                            
                                                            //  Allocate memory for DAM Input and Output Structures
                                                            pCAUD15DInputRec = new CAUD15DI();
                                                            
                                                            pCAUD15DOutputRec = new CAUD15DO();
                                                            pCAUD15DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                                            pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                            pCAUD15DInputRec.setUlIdCnver(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCnver);
                                                            pCAUD15DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                            pCAUD15DInputRec.setUlIdCntrctWkr(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCntrctWkr);
                                                            pCAUD15DInputRec.setUlNbrCnverPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnperPeriod);
                                                            pCAUD15DInputRec.setUlNbrCnverVersion(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCnverVersion);
                                                            pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                                                            pCAUD15DInputRec.setDtDtCnverCreate(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnverCreate);
                                                            pCAUD15DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate3);
                                                            pCAUD15DInputRec.setDtDtCnverEffective(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnverEffective);
                                                            
                                                            //  Run loop four times to guarantee all contract
                                                            // services will be checked.
                                                            for (j = 0;j < tmpSvcRowQty1;j++) {
                                                                if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                                    rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                    pCAUD15DInputRec.setDtDtCnverEnd(dtCurrentDate);
                                                                }
                                                                
                                                                if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCnsvcService[j]))) {
                                                                    pCAUD15DInputRec.setDtDtCnverEnd(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCnverEnd);
                                                                }
                                                            }
                                                            
                                                            //  Call the Invalidate function
                                                            rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                                                            //  SIR 3692 - Added error processing to include a msg no rows returned
                                                            // which will cancel further processing and return RC to the window
                                                            // which will show a message box informing the user of the lack of data.
                                                            switch (rc) {
                                                                    
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
                                                                    if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[0])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[0]))) {
                                                                        tempSvcRowQty2 = 2;
                                                                    }
                                                                    // SIR #15931: end.also changed the loop counter for
                                                                    // the following for loop from tempSvcRowQty to
                                                                    // tempSvcRowQty2 and added another condition
                                                                    for (j = 0;j < tempSvcRowQty2 && 0 != pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyCounty[j].compareTo(NULL_STRING);j++) {
                                                                        pCAUD08DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                                                        pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                                                        pCAUD08DInputRec.setUlIdContract(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdContract);
                                                                        pCAUD08DInputRec.setUlIdCncnty(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulIdCncnty[j]);
                                                                        pCAUD08DInputRec.setUlIdCntrctWkr(ccmn35si.getUlIdCntrctWkr());
                                                                        pCAUD08DInputRec.setUlIdResource(ulIdResource1.value);
                                                                        pCAUD08DInputRec.setUlNbrCncntyPeriod(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCncntyPeriod[j]);
                                                                        pCAUD08DInputRec.setUlNbrCncntyVersion(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCncntyVersion[j]);
                                                                        pCAUD08DInputRec.setSzCdCncntyCounty(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyCounty[j]);
                                                                        pCAUD08DInputRec.setSzCdCncntyService(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j]);
                                                                        pCAUD08DInputRec.setUlNbrCncntyLineItem(pCFAD01DInputRec.ROWCFAD08SIG07[m].ulNbrCncntyLineItem[j]);
                                                                        pCAUD08DInputRec.setDtDtCncntyEffective(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCncntyEffective[j]);
                                                                        pCAUD08DInputRec.setTsLastUpdate(pCFAD01DInputRec.ROWCFAD08SIG07[m].tsSysTsLastUpdate4[j]);
                                                                        if ((0 == CD_SERV_FOST_L1.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j])) || (0 == CD_SERV_FOST_L2.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_BASIC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_MOD.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_SPEC.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j])) || (0 == CD_SERV_FOST_LEV_INT.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j]))) {
                                                                            rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
                                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                            pCAUD08DInputRec.setDtDtCncntyEnd(dtCurrentDate);
                                                                        }
                                                                        
                                                                        if ((0 == CD_SERV_ADP_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j])) || (0 == CD_SERV_ADP_NON_REC_SUB.compareTo(pCFAD01DInputRec.ROWCFAD08SIG07[m].szCdCncntyService[j]))) {
                                                                            
                                                                            pCAUD08DInputRec.setDtDtCncntyEnd(pCFAD01DInputRec.ROWCFAD08SIG07[m].dtDtCncntyEnd[j]);
                                                                        }
                                                                        rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
                                                                        
                                                                        switch (rc) {
                                                                                // End SIR#3813
                                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                pServiceStatus.explan_code = SUCCESS;
                                                                                break;
                                                                                
                                                                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                                                break;
                                                                                
                                                                            default :
                                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                                break;
                                                                        }
                                                                    }
                                                                    break;
                                                                    
                                                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                                    break;
                                                                    
                                                                default :
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    
                                                                    break;
                                                            }
                                                        }
                                                        
                                                        break;
                                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                                        
                                                        break;
                                                        
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        
                                                        break;
                                                }
                                            }
                                            m++;
                                        }
                                    }
                                    
                                    if (0 != pCSES41DOutputRec.getSzCdRsrcCategory().compareTo(FA_CATG_ADOPT)) {
                                        
                                        //  This logic is applicable to non-Adoptive homes.
                                        // Adoptive homes do not have LOCs.
                                        
                                        // Call CAUDB4D
                                        
                                        //  Allocate memory for Input and Output Structures
                                        pCAUDB4DInputRec = new CAUDB4DI();
                                        
                                        pCAUDB4DOutputRec = new CAUDB4DO();
                                        pCAUDB4DInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                        pCAUDB4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        pCAUDB4DInputRec.setUlIdResource(pCSES41DOutputRec.getUlIdResource());
                                        
                                        //  Call the Invalidate function
                                        rc = ARC_UTLGetDateAndTime(pCAUDB4DInputRec.getDtDtFlocEnd() , 0);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        rc = caudb4dAUDdam(sqlca, pCAUDB4DInputRec, pCAUDB4DOutputRec);
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                RetVal = Csub50s.FND_FAIL;
                                                
                                                break;
                                        }
                                    }
                                    if (RetVal == SUCCESS) {
                                        //  Allocate memory for Common Function Input and Output Structures
                                        pCCMN02UInputRec = new CCMN02UI();
                                        
                                        pCCMN02UOutputRec = new CCMN02UO();
                                        pCCMN02UInputRec.setArchInputStruct(ccmn35si.getArchInputStruct());
                                        pCCMN02UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        
                                        pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(ccmn35si.getUlIdStage());
                                        
                                        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(ccmn35si.getSzCdStage());
                                        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(ccmn35si.getAprvlStageProg().getSzCdStageProgram());
                                        pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(pCSES41DOutputRec.getSzCdRsrcClosureRsn());
                                        rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                break;
                                                
                                            case Messages.MSG_SVA_OPN_AUTHS:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_SVA_OPN_AUTHS;
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                break;
                                                
                                            default :
                                                // Set RetVal to FND_SUCCESS
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                    }
                                    break;
                                    
                                default :
                                    
                                    
                                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    break;
                                    
                            }
                        }
                    }
                }
                //  If there is too much data to fit in this one message, set
                // the severity and explan_code appropriately.
                if (pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i160).getSzCdTask() == FA_HOME_RVF) {
                    if (0 == (ccmn35si.getSzWcdCdAprvlWinaction().compareTo(WIN_APPROVE))) {
                        
                        // Generate a Todo by calling CSUB40U
                        
                        //  Allocate memory for Common Function Input
                        // and Output Structures
                        
                        pTodoCommonInput = new CSUB40UI();
                        
                        pTodoCommonOutput = new CSUB40UO();
                        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_UPDATE_STATUS);
                        
                        //  Set CSUB40UI DtTodoCfDueFrom
                        // to NULL_DATE
                        ARC_UTLGetDateAndTime(pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(ccmn35si.getUlIdPerson());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(ulIdEvent2);
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(ccmn35si.getUlIdStage());
                        
                        //  Call the Invalidate function
                        rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                        
                        //  Analyze error code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                
                                break;
                        }
                    }
                }
            }
        }
        
        /*** INVALID WINDOW ACTION MODE - ERROR! ***/
        else {
            rc = Messages.ARC_ERR_BAD_FUNC_CD;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version
        */
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn35si.getArchInputStruct() , ccmn35so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            
            //  Start Performance Timer
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
                
                
                
                //  Initialize Service Status Fields
                
                
                //  Perform Main Processing
                
                //  Set CFIN26SO WCD DtSystemDate to current date
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn35so;
    }

    static int CallCCMN43D(CCMN43DI pTodoStruct, CCMN35SO * pOutputMsg289, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN43DO pCCMN43DOutputRec = new CCMN43DO();
        
        rc = ccmn43dAUDdam(sqlca, pTodoStruct, pCCMN43DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                    
                    // RIOSJA, SIR 19973
                case NO_DATA_FOUND:
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN46D(CCMN35SI pInputMsg306, CCMN35SO * pOutputMsg290, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN46DI pCCMN46DInputRec = null;
        CCMN46DO pCCMN46DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN46DInputRec = new CCMN46DI();
        
        pCCMN46DOutputRec = new CCMN46DO();
        pCCMN46DInputRec.setUlIdEvent(pInputMsg306.getROWCCMN01UIG00().getUlIdEvent());
        pCCMN46DInputRec.setUlIdPerson(pInputMsg306.getROWCCMN01UIG00().getUlIdPerson());
        pCCMN46DInputRec.setUlIdStage(pInputMsg306.getROWCCMN01UIG00().getUlIdStage());
        pCCMN46DInputRec.setDtDtEventOccurred(pInputMsg306.getROWCCMN01UIG00().getDtDtEventOccurred());
        pCCMN46DInputRec.setTsLastUpdate(pInputMsg306.getROWCCMN01UIG00().getTsLastUpdate());
        pCCMN46DInputRec.setSzCdEventStatus(pInputMsg306.getROWCCMN01UIG00().getSzCdEventStatus());
        pCCMN46DInputRec.setSzCdTask(pInputMsg306.getROWCCMN01UIG00().getSzCdTask());
        pCCMN46DInputRec.setSzCdEventType(pInputMsg306.getROWCCMN01UIG00().getSzCdEventType());
        pCCMN46DInputRec.setSzTxtEventDescr(pInputMsg306.getROWCCMN01UIG00().getSzTxtEventDescr());
        pCCMN46DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg306.getArchInputStruct().getCReqFuncCd());
        rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
        
        /*
        ** Analyze error code
        */
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Call DAM
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        return rc;
    }

    static int CallCCMN57D(CCMN35SI pInputMsg307, CCMN35SO * pOutputMsg291, CCMN57DO pBRIDGECCMN57DO, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i161 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN57DI pCCMN57DInputRec = new CCMN57DI();
        
        pCCMN57DInputRec.setUlIdApproval(pInputMsg307.getUlIdApproval());
        pCCMN57DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCCMN57DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN57DO._CCMN57DO__ROWCCMN57DO_SIZE);
        rc = ccmn57dQUERYdam(sqlca, pCCMN57DInputRec, pBRIDGECCMN57DO);
        if (rc != 0) {
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        else {
            
            //  The first Dam call, CLSC49D, will retrieve all rows from the Education 
            // History table for a given Id_Person
            
            //  Start Performance Timer
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMN60D(CCMN35SI pInputMsg308, Pint pulIdSupervisor, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN60DI pCCMN60DInputRec = null;
        CCMN60DO pCCMN60DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN60DInputRec = new CCMN60DI();
        
        pCCMN60DOutputRec = new CCMN60DO();
        pCCMN60DInputRec.setUlIdPerson(pInputMsg308.getUlIdPerson());
        rc = ccmn60dQUERYdam(sqlca, pCCMN60DInputRec, pCCMN60DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pulIdSupervisor.value = pCCMN60DOutputRec.getUlIdPerson();
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMNI2D(CCMN35SI pInputMsg309, CCMN35SO * pOutputMsg292, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNI2DI pCCMNI2DInputRec = null;
        CCMNI2DO pCCMNI2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNI2DInputRec = new CCMNI2DI();
        
        pCCMNI2DOutputRec = new CCMNI2DO();
        pCCMNI2DInputRec.setUlIdCase(pInputMsg309.getROWCCMNI2DI().getUlIdCase());
        pCCMNI2DInputRec.setUlIdStage(pInputMsg309.getROWCCMNI2DI().getUlIdStage());
        
        pCCMNI2DInputRec.setUlIdRejector(pInputMsg309.getROWCCMNI2DI().getUlIdRejector());
        pCCMNI2DInputRec.setDtDtRejection(pInputMsg309.getROWCCMNI2DI().getDtDtRejection());
        pCCMNI2DInputRec.setBIndApsEffort(pInputMsg309.getROWCCMNI2DI().getBIndApsEffort());
        
        pCCMNI2DInputRec.setBIndCareEntered(pInputMsg309.getROWCCMNI2DI().getBIndCareEntered());
        pCCMNI2DInputRec.setBIndEvidence(pInputMsg309.getROWCCMNI2DI().getBIndEvidence());
        pCCMNI2DInputRec.setBIndMissingEvidRptr(pInputMsg309.getROWCCMNI2DI().getBIndMissingEvidRptr());
        
        pCCMNI2DInputRec.setBIndMissingEvidAp(pInputMsg309.getROWCCMNI2DI().getBIndMissingEvidAp());
        pCCMNI2DInputRec.setBIndMissingEvidMp(pInputMsg309.getROWCCMNI2DI().getBIndMissingEvidMp());
        pCCMNI2DInputRec.setBIndMissingEvidCl(pInputMsg309.getROWCCMNI2DI().getBIndMissingEvidCl());
        
        pCCMNI2DInputRec.setBIndMissingEvidPhoto(pInputMsg309.getROWCCMNI2DI().getBIndMissingEvidPhoto());
        
        
        /***************************************************************************  
        ** Function Prototypes
        ****************************************************************************/
        pCCMNI2DInputRec.setBIndMissingEvidDe(pInputMsg309.getROWCCMNI2DI().getBIndMissingEvidDe());
        pCCMNI2DInputRec.setBIndMissingEvidOther(pInputMsg309.getROWCCMNI2DI().getBIndMissingEvidOther());
        pCCMNI2DInputRec.setBIndDiscretionaryReason(pInputMsg309.getROWCCMNI2DI().getBIndDiscretionaryReason());
        pCCMNI2DInputRec.setSzNMRejector(pInputMsg309.getROWCCMNI2DI().getSzNMRejector());
        pCCMNI2DInputRec.setSzTxtApproversComments(pInputMsg309.getROWCCMNI2DI().getSzTxtApproversComments());
        pCCMNI2DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg309.getArchInputStruct().getCReqFuncCd());
        
        /*
        ** Call DAM
        */
        rc = ccmni2dAUDdam(sqlca, pCCMNI2DInputRec, pCCMNI2DOutputRec);
        
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN61D(CCMN35SI pInputMsg310, CCMN35SO * pOutputMsg293, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN61DI pCCMN61DInputRec = null;
        CCMN61DO pCCMN61DOutputRec = null;
        
        /*
        ** Allocate memory for Dam I/O Records
        */
        pCCMN61DInputRec = new CCMN61DI();
        
        pCCMN61DOutputRec = new CCMN61DO();
        pCCMN61DInputRec.getROWCCMN61DI().setDtDtApproversDetermination(pInputMsg310.getROWCCMN61DI().getDtDtApproversDetermination());
        pCCMN61DInputRec.getROWCCMN61DI().setTmScrTmApprovalTime(pInputMsg310.getROWCCMN61DI().getTmScrTmApprovalTime());
        pCCMN61DInputRec.getROWCCMN61DI().setUlIdPerson(pInputMsg310.getROWCCMN61DI().getUlIdPerson());
        pCCMN61DInputRec.getROWCCMN61DI().setSzCdApproversStatus(pInputMsg310.getROWCCMN61DI().getSzCdApproversStatus());
        pCCMN61DInputRec.getROWCCMN61DI().setSzTxtApproversComments(pInputMsg310.getROWCCMN61DI().getSzTxtApproversComments());
        pCCMN61DInputRec.getROWCCMN61DI().setUlIdApprovers(pInputMsg310.getROWCCMN61DI().getUlIdApprovers());
        pCCMN61DInputRec.getROWCCMN61DI().setTsLastUpdate(pInputMsg310.getROWCCMN61DI().getTsLastUpdate());
        pCCMN61DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg310.getArchInputStruct().getCReqFuncCd());
        rc = ccmn61dAUDdam(sqlca, pCCMN61DInputRec, pCCMN61DOutputRec);
        
        /*
        ** Populate DAM input structure
        */
        
        /*
        ** Set CAUD75DI ReqFuncCode to CCFC22SI ReqFuncCode
        */
        
        /*
        ** SIR# 21809 - Add if/else statement based on value of pInputMsg->cIndRuloutOrAdm.
        ** If the case is in Admin Review (YES), call REQ_FUNC_CD_UPDATE, if the case is not
        ** Admin Review then call REQ_FUNC_CD_ADD.
        */
        
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN62D(CCMN35SI pInputMsg311, CCMN35SO * pOutputMsg294, CCMN57DO pBRIDGECCMN57DO, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        int iCount = 0;
        
        /*
        ** Declare local variables
        */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        if (pInputMsg311.getSzWcdCdAprvlWinaction().equals(WIN_COMPAPRV)) {
            pCCMN62DInputRec.setSzCdEventStatus(EVT_APPROVED);
        }
        else {
            pCCMN62DInputRec.setSzCdEventStatus(EVT_COMPLETE);
        }
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg311.getArchInputStruct().getCReqFuncCd());
        
        /*
        ** Update Loop for all related events stop if error encountered
        */
        for (iCount = 0;(iCount < pBRIDGECCMN57DO.getArchOutputStruct().getUlRowQty()) && (0 == rc);iCount++) {
            pCCMN62DInputRec.setUlIdEvent(pBRIDGECCMN57DO.getROWCCMN57DO_ARRAY().getROWCCMN57DO(iCount).getUlIdEvent());
            rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
            if (rc != 0) {
                
                switch (rc) {
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
        }
        return rc;
    }

    static int CallCCMN88D(CCMN35SI pInputMsg312, CCMN35SO * pOutputMsg295, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN88DI pCCMN88DInputRec = null;
        CCMN88DO pCCMN88DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN88DInputRec = new CCMN88DI();
        
        pCCMN88DOutputRec = new CCMN88DO();
        pCCMN88DInputRec.setUlIdApproval(pInputMsg312.getUlIdApproval());
        pCCMN88DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg312.getArchInputStruct().getCReqFuncCd());
        rc = ccmn88dAUDdam(sqlca, pCCMN88DInputRec, pCCMN88DOutputRec);
        
        
        /**********
        ** RIOSJA, SIR 19973 - If all Service Auth edits have passed so far,
        ** and if one or more APRV'd Service Auths exist with Term Date in
        ** the future, confirm that an eligible stage exists to which we can
        ** progress those Service Auths. If an eligible stage does not exist,
        ** set bPassedSvcAuthEdit to FALSE so that we can display an
        ** appropriate error message below.
        ** NOTE: THE FOLLOWING CODE WAS COPIED FROM THE CLOSE-STAGE-CASE
        ** COMMON FUNCTION (CCMN02U) AND MODIFIED SLIGHTLY FOR USE HERE.
        */
        if (rc != 0) {
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCSES19D(CCMN35SI pInputMsg313, int ulIdEvent3, CSES19DO pCSES19DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSES19DI pCSES19DInputRec = new CSES19DI();
        
        pCSES19DInputRec.setArchInputStruct(pInputMsg313.getArchInputStruct());
        pCSES19DInputRec.setUlIdChildPlanEvent(ulIdEvent3);
        
        /*
        ** Start performance timer for service 
        */
        rc = cses19dQUERYdam(sqlca, pCSES19DInputRec, pCSES19DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCSES24D(CCMN35SI pInputMsg314, int ulIdEvent4, Pint ulIdSvcAuth2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSES24DI pCSES24DInputRec = null;
        CSES24DO pCSES24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES24DInputRec = new CSES24DI();
        
        pCSES24DOutputRec = new CSES24DO();
        pCSES24DInputRec.setArchInputStruct(pInputMsg314.getArchInputStruct());
        pCSES24DInputRec.setUlIdSvcAuthEvent(ulIdEvent4);
        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        ulIdSvcAuth2.value = pCSES24DOutputRec.getUlIdSvcAuth();
        return rc;
    }

    static int CallCLSS24D(CCMN35SI pInputMsg315, int ulIdSvcAuth3, int usPageNo, CLSS24DO pCLSS24DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CLSS24DI pCLSS24DInputRec = new CLSS24DI();
        pCLSS24DInputRec.setArchInputStruct(pInputMsg315.getArchInputStruct());
        
        pCLSS24DInputRec.getArchInputStruct().setUsPageNbr(usPageNo);
        
        /*
        #include "ccmn95di.h"
        #include "ccmn95do.h"
        */
        
        /**************************************************************************
        ** Service Macro Definitions
        ***************************************************************************/
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pCLSS24DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS24DO._CLSS24DO__ROWCLSS24DO_SIZE);
        pCLSS24DInputRec.setUlIdSvcAuth(ulIdSvcAuth3);
        
        /* retrieve date and time from the server */
        rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
        if (rc != 0) {
            
            //  We need to handle two different situations for
            // what we retrieve from CSES57D
            switch (rc) {
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCINV81D(CCMN35SI pInputMsg316, int ulIdPerson5, String szNmPersonFull2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV81DI pCINV81DInputRec = null;
        CINV81DO pCINV81DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV81DInputRec = new CINV81DI();
        
        pCINV81DOutputRec = new CINV81DO();
        pCINV81DInputRec.setArchInputStruct(pInputMsg316.getArchInputStruct());
        pCINV81DInputRec.setUlIdPerson(ulIdPerson5);
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
        if (rc != 0) {
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        szNmPersonFull2 = pCINV81DOutputRec.getSzNmPersonFull();
        return rc;
    }

    static int CallCAUD25D(CCMN35SI pInputMsg317, int ulIdEvent5, FndInt3date dtDtTodoDue1, CSES19DO pCSES19DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CAUD25DI pCAUD25DInputRec = null;
        CAUD25DO pCAUD25DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD25DInputRec = new CAUD25DI();
        
        pCAUD25DOutputRec = new CAUD25DO();
        
        pCAUD25DInputRec.setArchInputStruct(pInputMsg317.getArchInputStruct());
        pCAUD25DInputRec.setUlIdChildPlanEvent(ulIdEvent5);
        pCAUD25DInputRec.setTsLastUpdate(pCSES19DOutputRec.getTsLastUpdate());
        pCAUD25DInputRec.setUlIdPerson(pCSES19DOutputRec.getUlIdPerson());
        pCAUD25DInputRec.setSzCdCspPlanPermGoal(pCSES19DOutputRec.getSzCdCspPlanPermGoal());
        pCAUD25DInputRec.setSzCdCspPlanType(pCSES19DOutputRec.getSzCdCspPlanType());
        pCAUD25DInputRec.setDtDtCspPermGoalTarget(pCSES19DOutputRec.getDtDtCspPermGoalTarget());
        pCAUD25DInputRec.setTmScrTmGeneric1(pCSES19DOutputRec.getTmScrTmGeneric1());
        pCAUD25DInputRec.setDtDtCspNextReview(dtDtTodoDue1);
        pCAUD25DInputRec.setTmScrTmGeneric2(pCSES19DOutputRec.getTmScrTmGeneric2());
        pCAUD25DInputRec.setSzTxtCspLengthOfStay(pCSES19DOutputRec.getSzTxtCspLengthOfStay());
        
        pCAUD25DInputRec.setSzTxtCspDiscrepancy(pCSES19DOutputRec.getSzTxtCspDiscrepancy());
        pCAUD25DInputRec.setSzTxtCspParticipComment(pCSES19DOutputRec.getSzTxtCspParticipComment());
        pCAUD25DInputRec.setDtDtCspPlanCompleted(pCSES19DOutputRec.getDtDtCspPlanCompleted());
        pCAUD25DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = caud25dAUDdam(sqlca, pCAUD25DInputRec, pCAUD25DOutputRec);
        
        if (rc != 0) {
            
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //   SIR 11473
                    // Moved call to DAM CCMN87D inside of the else statement.
                    // CCMN87D will only be called when the ID_STAGE is passed to the service.
                    
                    //  ERR# 1495 HUSTONMJ 10/02/95
                    // Call CCMN87D to retrieve Risk Assessment ulIdEvent.  If Status of
                    // Risk Assessment is PEND or COMP, return to Person List so that
                    // events can be demoted on update.
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    rc = Messages.MSG_DUPLICATE_RECORD;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCSES43D(CCMN35SI pInputMsg318, int ulIdEvent6, String szCdRsrcFaHomeStatus2, String tsLastUpdate2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSES43DI pCSES43DInputRec = null;
        CSES43DO pCSES43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES43DInputRec = new CSES43DI();
        
        pCSES43DOutputRec = new CSES43DO();
        pCSES43DInputRec.setArchInputStruct(pInputMsg318.getArchInputStruct());
        pCSES43DInputRec.setUlIdRsrcFaHomeEvent(ulIdEvent6);
        rc = cses43dQUERYdam(sqlca, pCSES43DInputRec, pCSES43DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        szCdRsrcFaHomeStatus2 = pCSES43DOutputRec.getSzCdRsrcFaHomeStatus();
        tsLastUpdate2 = pCSES43DOutputRec.getTsLastUpdate();
        return rc;
    }

    static int CallCAUD52D(CCMN35SI pInputMsg319, int ulIdEvent7, String tsLastUpdate3, String szCdRsrcFaHomeStatus3, String szCdRsrcStatus1, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CAUD52DI pCAUD52DInputRec = null;
        CAUD52DO pCAUD52DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD52DInputRec = new CAUD52DI();
        
        pCAUD52DOutputRec = new CAUD52DO();
        
        pCAUD52DInputRec.setArchInputStruct(pInputMsg319.getArchInputStruct());
        pCAUD52DInputRec.setSzCdRsrcFaHomeStatus(szCdRsrcFaHomeStatus3);
        pCAUD52DInputRec.setSzCdRsrcStatus(szCdRsrcStatus1);
        pCAUD52DInputRec.setTsLastUpdate(tsLastUpdate3);
        pCAUD52DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        rc = caud52dAUDdam(sqlca, pCAUD52DInputRec, pCAUD52DOutputRec);
        
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    rc = Messages.MSG_DUPLICATE_RECORD;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        
        return rc;
    }

    static int CallCSEC38D(CCMN35SI pInputMsg320, int ulIdEvent8, String szCdRsrcFaHomeStatus4, Pint ulIdResource2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSEC38DI pCSEC38DInputRec = null;
        CSEC38DO pCSEC38DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC38DInputRec = new CSEC38DI();
        
        pCSEC38DOutputRec = new CSEC38DO();
        
        pCSEC38DInputRec.setArchInputStruct(pInputMsg320.getArchInputStruct());
        pCSEC38DInputRec.setUlIdRsrcFaHomeEvent(ulIdEvent8);
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = csec38dQUERYdam(sqlca, pCSEC38DInputRec, pCSEC38DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        szCdRsrcFaHomeStatus4 = pCSEC38DOutputRec.getSzCdRshsFaHomeStatus();
        ulIdResource2.value = pCSEC38DOutputRec.getUlIdResource();
        return rc;
    }

    static int CallCSEC46D(CCMN35SI pInputMsg321, String szCdFaHomeStatus, Pint usSysNbrSvcDtlCount2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSEC46DI pCSEC46DInputRec = null;
        CSEC46DO pCSEC46DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC46DInputRec = new CSEC46DI();
        
        pCSEC46DOutputRec = new CSEC46DO();
        pCSEC46DInputRec.setArchInputStruct(pInputMsg321.getArchInputStruct());
        pCSEC46DInputRec.setSzCdRshsFaHomeStatus(szCdFaHomeStatus);
        rc = csec46dQUERYdam(sqlca, pCSEC46DInputRec, pCSEC46DOutputRec);
        if (rc != 0) {
            switch (rc) {
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
            }
        }
        usSysNbrSvcDtlCount2.value = pCSEC46DOutputRec.getUsSysNbrSvcDtlCount();
        return rc;
    }

    static int CallCRES04D(CCMN35SI pInputMsg322, int ulIdResource3, String tsLastUpdate4, String szAdoptiveOrFoster, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code  */
        
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
        pCRES04DInputRec.setArchInputStruct(pInputMsg322.getArchInputStruct());
        pCRES04DInputRec.setUlIdResource(ulIdResource3);
        
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        tsLastUpdate4 = pCRES04DOutputRec.getTsLastUpdate();
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

    static int CallCAUDC7D(CCMN35SI pInputMsg323, CCMN35SO * pOutputMsg296, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CAUDC7DI pCAUDC7DInputRec = null;
        CAUDC7DO pCAUDC7DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDC7DInputRec = new CAUDC7DI();
        pCAUDC7DOutputRec = new CAUDC7DO();
        pCAUDC7DInputRec.setIdFacilInvstStage(pInputMsg323.getUlIdStage());
        pCAUDC7DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUDC7DInputRec.setArchInputStruct(pInputMsg323.getArchInputStruct());
        rc = caudc7dAUDdam(sqlca, pCAUDC7DInputRec, pCAUDC7DOutputRec);
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    
                    //  Start DAM Performance Timer
                    //##  ARC_PRFDataAccessStartTime("CSUB81D");
                    
                    //  Call CSUB81D
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCSECA8D(CCMN35SI pInputMsg324, CSECA8DO * pOutputMsg297, String pbEA_Sub, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSECA8DI pCSECA8DInputRec = null;
        CSECA8DO pCSECA8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA8DInputRec = new CSECA8DI();
        pCSECA8DOutputRec = new CSECA8DO();
        /**************************************************************************
        ** (END): Add/Update AUD DAM: cxxxyyd     ** Medicaid_update AUD dam
        **************************************************************************/
        /* * OR *: FALSE = cSysIndPlcmtDifMedAdr && TRUE = SysIndNewActualPlcmt */
        
        if (pCSECA8DInputRec == null) {
            
            
            //  Call CSES48D
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (pCSECA8DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCSECA8DInputRec.setArchInputStruct(pInputMsg324.getArchInputStruct());
        pCSECA8DInputRec.setUlIdStage(pInputMsg324.getUlIdStage());
        rc = cseca8dQUERYdam(sqlca, pCSECA8DInputRec, pCSECA8DOutputRec);
        
        //04/11/03 Srini: Added the switch case to take care of MSG_NO_ROWS_RETURNED and also added goto
        //                to exit from the method to the calling service when we get error.
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pbEA_Sub = CStringUtils.setCharAt(pbEA_Sub, 0, true);
                
                
                //  Call CLSS40D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCSECA2D(CCMN35SI pInputMsg325, CSECA2DO pOutputMsg298, String pbEA_Eligible, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables 
        */
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSECA2DI pCSECA2DInputRec = null;
        CSECA2DO pCSECA2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA2DInputRec = new CSECA2DI();
        pCSECA2DOutputRec = new CSECA2DO();
        
        /*
        ** Analyze error code
        */
        if (pCSECA2DInputRec == null) {
            
            //  Populate Input Structure
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (pCSECA2DOutputRec == null) {
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        pCSECA2DInputRec.setArchInputStruct(pInputMsg325.getArchInputStruct());
        pCSECA2DInputRec.setIdCpsInvstStage(pInputMsg325.getUlIdStage());
        
        /*
        ** Call PostEvent
        */
        rc = cseca2dQUERYdam(sqlca, pCSECA2DInputRec, pCSECA2DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pbEA_Eligible = CStringUtils.setCharAt(pbEA_Eligible, 0, true);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                
                //  Call PostEvent 
                // 
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg298.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCLSC18D(CCMN35SI pInputMsg326, CLSC18DO pOutputMsg299, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CLSC18DI pCLSC18DInputRec = null;
        CLSC18DO pCLSC18DOutputRec = null;
        int i162 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC18DInputRec = new CLSC18DI();
        pCLSC18DOutputRec = new CLSC18DO();
        if (pCLSC18DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (pCLSC18DOutputRec == null) {
            
            
            //  Call CAUD22D
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* SIR# FINANCIAL ENHANCEMENT */
        pCLSC18DInputRec.setArchInputStruct(pInputMsg326.getArchInputStruct());
        pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC18DO._CLSC18DO__ROWCLSC18DO_SIZE);
        pCLSC18DInputRec.setSzCdStagePersType(PERSON_ROLE_PRINCIPAL);
        pCLSC18DInputRec.setUlIdStage(pInputMsg326.getUlIdStage());
        rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg299.getArchOutputStruct().setUlRowQty(pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i162 = 0;i162 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty();++i162) {
                    pOutputMsg299.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i162).setUlIdPerson(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i162).getUlIdPerson());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                // Call CAUDE1D
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg299.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCSECA1D(CSECA1DI pInputMsg327, CSECA1DO pOutputMsg300, String pbEA_Found, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSECA1DI pCSECA1DInputRec = null;
        CSECA1DO pCSECA1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA1DInputRec = new CSECA1DI();
        pCSECA1DOutputRec = new CSECA1DO();
        
        if (pCSECA1DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (pCSECA1DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCSECA1DInputRec.setArchInputStruct(pInputMsg327.getArchInputStruct());
        pCSECA1DInputRec.setUlIdPersEligPerson(pInputMsg327.getUlIdPersEligPerson());
        pCSECA1DInputRec.setSzCdPersEligType(pInputMsg327.getSzCdPersEligType());
        rc = cseca1dQUERYdam(sqlca, pCSECA1DInputRec, pCSECA1DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg300.setUlIdPersElig(pCSECA1DOutputRec.getUlIdPersElig());
                pOutputMsg300.setUlIdPersEligPerson(pCSECA1DOutputRec.getUlIdPersEligPerson());
                //  Default is not what we expect so an error/warning will not be
                // returned here.
                pOutputMsg300.setSzCdPersEligType(pCSECA1DOutputRec.getSzCdPersEligType());
                
                pOutputMsg300.setDtDtPersEligStart(pCSECA1DOutputRec.getDtDtPersEligStart());
                pOutputMsg300.setDtDtPersEligEnd(pCSECA1DOutputRec.getDtDtPersEligEnd());
                pOutputMsg300.setDtDtPersEligEaDeny(pCSECA1DOutputRec.getDtDtPersEligEaDeny());
                pOutputMsg300.setCdPersEligPrgStart(pCSECA1DOutputRec.getCdPersEligPrgStart());
                pOutputMsg300.setCdPersEligPrgOpen(pCSECA1DOutputRec.getCdPersEligPrgOpen());
                pOutputMsg300.setCdPersEligPrgClose(pCSECA1DOutputRec.getCdPersEligPrgClose());
                pbEA_Found = CStringUtils.setCharAt(pbEA_Found, 0, true);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg300.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    
    static int CallCAUDC9D(CAUDC9DI pInputMsg328, CAUDC9DO pOutputMsg301, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CAUDC9DI pCAUDC9DInputRec = null;
        CAUDC9DO pCAUDC9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDC9DInputRec = new CAUDC9DI();
        pCAUDC9DOutputRec = new CAUDC9DO();
        if (pCAUDC9DInputRec == null) {
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (pCAUDC9DOutputRec == null) {
            
            
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCAUDC9DInputRec.setArchInputStruct(pInputMsg328.getArchInputStruct());
        pCAUDC9DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg328.getArchInputStruct().getCReqFuncCd());
        pCAUDC9DInputRec.setUlIdPersEligPerson(pInputMsg328.getUlIdPersEligPerson());
        pCAUDC9DInputRec.setDtDtPersEligStart(pInputMsg328.getDtDtPersEligStart());
        pCAUDC9DInputRec.setDtDtPersEligEnd(pInputMsg328.getDtDtPersEligEnd());
        /* Process utility fuction failure */
        pCAUDC9DInputRec.setCdPersEligPrgStart(pInputMsg328.getCdPersEligPrgStart());
        pCAUDC9DInputRec.setCdPersEligPrgOpen(pInputMsg328.getCdPersEligPrgOpen());
        pCAUDC9DInputRec.setDtDtPersEligEaDeny(pInputMsg328.getDtDtPersEligEaDeny());
        pCAUDC9DInputRec.setUlIdPersElig(pInputMsg328.getUlIdPersElig());
        pCAUDC9DInputRec.setCdPersEligPrgClose(pInputMsg328.getCdPersEligPrgClose());
        
        /*
        ** This is OK, return SQL_NOT_FOUND
        */
        rc = caudc9dAUDdam(sqlca, pCAUDC9DInputRec, pCAUDC9DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Call INCOMING PERSON query DAM.
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg301.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCSECA3D(CSECA3DI pInputMsg329, CSECA3DO pOutputMsg302, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSECA3DI pCSECA3DInputRec = null;
        CSECA3DO pCSECA3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA3DInputRec = new CSECA3DI();
        pCSECA3DOutputRec = new CSECA3DO();
        /* SIR 22686 if group home is false, save 63A-D else save 63A-C*/
        if (pCSECA3DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (pCSECA3DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCSECA3DInputRec.setArchInputStruct(pInputMsg329.getArchInputStruct());
        pCSECA3DInputRec.setIdEventStage(pInputMsg329.getIdEventStage());
        
        pCSECA3DInputRec.setUlIdStage(pInputMsg329.getUlIdStage());
        rc = cseca3dQUERYdam(sqlca, pCSECA3DInputRec, pCSECA3DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg302.setDtDtSvcAuthDtlBegin(pCSECA3DOutputRec.getDtDtSvcAuthDtlBegin());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            case NO_DATA_FOUND:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg302.getArchOutputStruct().setUlRowQty(0);
            default :
                
                //## BEGIN TUX/XML: Declare XML variables 
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCSEC85D(CSEC85DI pInputMsg330, CSEC85DO pOutputMsg303, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSEC85DI pCSEC85DInputRec = null;
        CSEC85DO pCSEC85DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC85DInputRec = new CSEC85DI();
        pCSEC85DOutputRec = new CSEC85DO();
        if (pCSEC85DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (pCSEC85DOutputRec == null) {
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCSEC85DInputRec.setArchInputStruct(pInputMsg330.getArchInputStruct());
        pCSEC85DInputRec.setDtDtPersEligStart(pInputMsg330.getDtDtPersEligStart());
        
        rc = csec85dQUERYdam(sqlca, pCSEC85DInputRec, pCSEC85DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg303.setDtDtPersEligEnd(pCSEC85DOutputRec.getDtDtPersEligEnd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pOutputMsg303.getArchOutputStruct().setUlRowQty(0);
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int ContractVerSerCnty(CCMN35SI pInputMsg331, int ulIdContract1, int ulNbrCnperPeriod1, int ulIdResource4, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int RetVal = 0;/* Return code */
        int i163 = 0;
        int j = 0;
        int ulLocalAdoptOrFoster = 0;
        int ulLocalNumberOfDays = 0;
        boolean bDeleteInsertContractCounty = true;
        boolean blFoster = true;
        String tmpContractCounty = new String();
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
        CLSS68DI pCLSS68DInputRec = null;/* SIR #20083 */
        CLSS68DO pCLSS68DOutputRec = null;/* SIR #20083 */
        CAUD17DI pCAUD17DInputRec = null;/* Contract Service AUD */
        
        CAUD17DO pCAUD17DOutputRec = null;
        CAUD08DI pCAUD08DInputRec = null;/* Contract County AUD */
        
        CAUD08DO pCAUD08DOutputRec = null;
        CAUD15DI pCAUD15DInputRec = null;/* Contract Version AUD */
        
        CAUD15DO pCAUD15DOutputRec = null;
        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtCurrentDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Start performance timer for service
        */
        rc = ARC_UTLGetDateAndTime((FndInt3date) & dtTempDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        
        /* This service will only be used to populate the person identifiers
        ** listbox.
        */
        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtTempDate3);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = ARC_UTLAddToDate((FndInt3date) & dtTempDate, (FndInt3date) & dtAddOneDay);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD15DInputRec = new CAUD15DI();
        
        pCAUD15DOutputRec = new CAUD15DO();
        
        pCAUD15DInputRec.setArchInputStruct(pInputMsg331.getArchInputStruct());
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD08DInputRec = new CAUD08DI();
        
        pCAUD08DOutputRec = new CAUD08DO();
        pCAUD08DInputRec.setArchInputStruct(pInputMsg331.getArchInputStruct());
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCAUD17DInputRec = new CAUD17DI();
        
        pCAUD17DOutputRec = new CAUD17DO();
        pCAUD17DInputRec.setArchInputStruct(pInputMsg331.getArchInputStruct());
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS68DInputRec = new CLSS68DI();
        
        pCLSS68DOutputRec = new CLSS68DO();
        pCLSS68DInputRec.setArchInputStruct(pInputMsg331.getArchInputStruct());
        
        
        /*
        ** Allocate memory for DAM Input and Output
        ** Structures
        */
        pCLSS13DInputRec = new CLSS13DI();
        
        pCLSS13DOutputRec = new CLSS13DO();
        pCLSS13DInputRec.setArchInputStruct(pInputMsg331.getArchInputStruct());
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES01DInputRec = new CSES01DI();
        
        pCSES01DOutputRec = new CSES01DO();
        
        pCRES04DInputRec = new CRES04DI();
        
        pCRES04DOutputRec = new CRES04DO();
        pCSES01DInputRec.setArchInputStruct(pInputMsg331.getArchInputStruct());
        pCSES01DInputRec.setUlIdContract(ulIdContract1);
        pCSES01DInputRec.setUlNbrCnverPeriod(ulNbrCnperPeriod1);
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
                for (i163 = 0;i163 < 2 && RetVal == SUCCESS && bDeleteInsertContractCounty;i163++) {
                    if (i163 == 1) {
                        pCAUD15DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCAUD15DInputRec.setCIndCnverVerLock(FND_YES);
                        pCAUD15DInputRec.setDtDtCnverEnd(pCSES01DOutputRec.getDtDtCnverEnd());
                        pCAUD15DInputRec.setDtDtCnverEffective(dtCurrentDate);
                        pCAUD15DInputRec.setTsLastUpdate(dtCurrentDate);
                        pCAUD15DInputRec.setSzTxtCnverComment("");
                        pCAUD15DInputRec.setUlNbrCnverVersion(pCSES01DOutputRec.getUlNbrCnverVersion() + 1);
                        pCAUD15DInputRec.setUlIdCnver(0);
                    }
                    
                    // Call DAM
                    rc = caud15dAUDdam(sqlca, pCAUD15DInputRec, pCAUD15DOutputRec);
                    
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
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            RetVal = Csub50s.FND_FAIL;
                            break;
                    }
                }
                break;
                
            default :
                RetVal = Csub50s.FND_FAIL;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        if (RetVal == SUCCESS && bDeleteInsertContractCounty) {
            pCLSS13DInputRec.setUlIdContract(ulIdContract1);
            pCLSS13DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS13DO._CLSS13DO__ROWCLSS13DO_SIZE);
            pCLSS13DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
            rc = clss13dQUERYdam(sqlca, pCLSS13DInputRec, pCLSS13DOutputRec);
            
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
        /* SIR 22686 if group home is false, save 63A-D else save 63A-C*/
        if (RetVal == SUCCESS && bDeleteInsertContractCounty) {
            pCAUD17DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            
            pCAUD17DInputRec.setUlIdCnsvc(0);
            for (i163 = 0;i163 < NBR_SVC_CODE_SIXTY_ABCD && RetVal == SUCCESS;i163++) {
                pCAUD17DInputRec.setUlIdContract(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlIdContract());
                
                pCAUD17DInputRec.setUlIdCntrctWkr(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlIdCntrctWkr());
                pCAUD17DInputRec.setUlNbrCnsvcVersion(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcVersion() + 1);
                pCAUD17DInputRec.setUlNbrCnsvcPeriod(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlNbrCnsvcPeriod());
                pCAUD17DInputRec.setUlNbrCnsvcLineItem(i163 + 1);
                switch (i163) {
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
                pCAUD17DInputRec.setUlAmtCnsvcUnitRateUsed(pCLSS13DOutputRec.getROWCLSS13DO_ARRAY().getROWCLSS13DO(0).getUlAmtCnsvcUnitRateUsed());
                pCAUD17DInputRec.setTsLastUpdate(dtCurrentDate);
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
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        
        if (RetVal == SUCCESS) {
            
            pCRES04DInputRec.setArchInputStruct(pInputMsg331.getArchInputStruct());
            pCRES04DInputRec.setUlIdResource(ulIdResource4);
            rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
            ulLocalAdoptOrFoster = 0;
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
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
                    
                    ulLocalAdoptOrFoster = NBR_SVC_CODE_SIXTY_A;
                    
                    if (szAdoptiveOrFoster.charAt(0) == null) {
                        ulLocalAdoptOrFoster = 0;
                    }
                    else {
                        //  SIR 22686 loop through the rows to see if any of them
                        // are group homes, if they are set an indicator
                        for (i163 = 0;i163 < NBR_OF_HOME_TYPE;i163++) {
                            
                            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                            // 01/22/2003 DWW: Added for error handling
                            if (szAdoptiveOrFoster.charAt(i163) == FOST_TYPE_GROUP) {
                                bGroupHome2 = true;
                                break;
                            }
                        }
                        for (i163 = 0;i163 < NBR_OF_HOME_TYPE;i163++) {
                            //03/25/03 Srini: Modified to check for the transaction and commit only if it is started locally.
                            //  TUX_CHECK_APPL_STATUS
                            if ((szAdoptiveOrFoster.charAt(i163) == FOST_TYPE_HABIL) || (szAdoptiveOrFoster.charAt(i163) == FOST_TYPE_THER) || (szAdoptiveOrFoster.charAt(i163) == FOST_TYPE_PRIM_MED)) {
                                //Commit only if we began the transaction in this service
                                if (!bGroupHome2) {
                                    // 19613, 22390 Habil, Ther, and Prim Med homes use two codes 63A, B, C & D
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
                    tmpContractCounty = pCRES04DOutputRec.getSzCdRsrcCnty();
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if (RetVal == SUCCESS) {
            pCLSS68DInputRec.setUlIdContract(ulIdContract1);
            pCLSS68DInputRec.setUlNbrCncntyPeriod(ulNbrCnperPeriod1);
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
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    RetVal = SUCCESS;
                    
                    
                    //  Start performance timer for service. All performance functions always
                    // return success so there is no need to check status.
                    rc = SUCCESS;
                    break;
                    
                default :
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (RetVal == SUCCESS) {
            
            if (!bDeleteInsertContractCounty) {
                pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                for (i163 = 0;i163 < pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty() && RetVal == SUCCESS;i163++) {
                    pCAUD08DInputRec.setUlIdCncnty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlIdCncnty());
                    pCAUD08DInputRec.setTsLastUpdate(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getTsLastUpdate());
                    
                    //  Run-time versioning
                    
                    //  Check buffer size
                    
                    //  Process error message and return to client
                    
                    // Initialize output message and length
                    
                    
                    //  Initialize service status fields
                    
                    // 
                    // Call DAMs to retrieve data
                    // 
                    
                    
                    //  Call CAPS Resource to retrieve Resource data
                    
                    rc = caud08dAUDdam(sqlca, pCAUD08DInputRec, pCAUD08DOutputRec);
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
            else {
                
                pCAUD08DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                
                for (i163 = 0;i163 < pCLSS68DOutputRec.getArchOutputStruct().getUlRowQty() && RetVal == SUCCESS;i163++) {
                    
                    pCAUD08DInputRec.setUlIdCncnty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlIdCncnty());
                    pCAUD08DInputRec.setSzCdCncntyCounty(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getSzCdCncntyCounty());
                    pCAUD08DInputRec.setTsLastUpdate(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getTsLastUpdate());
                    pCAUD08DInputRec.setUlIdContract(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlIdContract());
                    pCAUD08DInputRec.setUlNbrCncntyPeriod(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlNbrCncntyPeriod());
                    pCAUD08DInputRec.setUlIdCntrctWkr(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlIdCntrctWkr());
                    pCAUD08DInputRec.setUlIdResource(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlIdResource());
                    pCAUD08DInputRec.setSzCdCncntyService(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getSzCdCncntyService());
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    pCAUD08DInputRec.setTmScrTmGeneric1(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getTmScrTmGeneric1());
                    pCAUD08DInputRec.setTmScrTmGeneric2(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getTmScrTmGeneric2());
                    pCAUD08DInputRec.setUlNbrCncntyLineItem(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlNbrCncntyLineItem());
                    pCAUD08DInputRec.setUlNbrCncntyVersion(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getUlNbrCncntyVersion());
                    pCAUD08DInputRec.setDtDtCncntyEffective(pCLSS68DOutputRec.getROWCLSS68DO_ARRAY().getROWCLSS68DO(i163).getDtDtCncntyEffective());
                    pCAUD08DInputRec.setDtDtCncntyEnd(dtTempDate);
                    
                    //  Call Resource Phone to retrieve the phone data
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
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
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
            pCAUD08DInputRec.setSzCdCncntyCounty(tmpContractCounty);
            pCAUD08DInputRec.setTsLastUpdate(pCSES01DOutputRec.getTsLastUpdate());
            pCAUD08DInputRec.setUlIdContract(pCSES01DOutputRec.getUlIdContract());
            pCAUD08DInputRec.setUlNbrCncntyPeriod(pCSES01DOutputRec.getUlNbrCnverPeriod());
            pCAUD08DInputRec.setUlIdCntrctWkr(pCSES01DOutputRec.getUlIdCntrctWkr());
            pCAUD08DInputRec.setUlIdResource(ulIdResource4);
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            pCAUD08DInputRec.setTmScrTmGeneric1(pCSES01DOutputRec.getTmScrTmGeneric1());
            pCAUD08DInputRec.setTmScrTmGeneric2(pCSES01DOutputRec.getTmScrTmGeneric2());
            pCAUD08DInputRec.setDtDtCncntyEffective(dtCurrentDate);
            pCAUD08DInputRec.setDtDtCncntyEnd(pCSES01DOutputRec.getDtDtCnverEnd());
            
            for (i163 = 0;i163 < ulLocalAdoptOrFoster && RetVal == SUCCESS;i163++) {
                
                // 
                // Function Prototypes
                // 
                
                pCAUD08DInputRec.setUlNbrCncntyLineItem(i163 + 1);
                
                //  Analyze error code
                switch (i163) {
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
                
                //  CRES38D and CRES15D both check to see if a resource ID
                // is found in either the parent or child columns of the
                // resource link table.  These retrieves determine the contracted
                // status of a resource, reflected on the window by the checkboxes
                // prime and sub.
                
                //  Call Resource Link in order to determine sub status
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
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        RetVal = Csub50s.FND_FAIL;
                        break;
                }
            }
        }
        return rc;
    }

    static int CheckCatHomeType(CCMN35SI pInputMsg332, int ulIdResource5, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int RetVal = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        
        String szCategoryHomeType1 = new String();
        String szHomeType1 = new String();
        String szCategoryHomeType2 = new String();
        String szHomeType2 = new String();
        
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        
        CLSS82DI pCLSS82DInputRec = null;
        CLSS82DO pCLSS82DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        
        pCRES04DInputRec = new CRES04DI();
        
        pCRES04DOutputRec = new CRES04DO();
        
        pCLSS82DInputRec = new CLSS82DI();
        
        pCLSS82DOutputRec = new CLSS82DO();
        szCategoryHomeType1 = "";
        szCategoryHomeType2 = "";
        szHomeType1 = "";
        szHomeType2 = "";
        
        pCRES04DInputRec.setArchInputStruct(pInputMsg332.getArchInputStruct());
        pCLSS82DInputRec.setArchInputStruct(pInputMsg332.getArchInputStruct());
        pCRES04DInputRec.setUlIdResource(ulIdResource5);
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size 
        */
        
        /*
        ** Process error message and return to client 
        */
        
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields 
        */
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                RetVal = SUCCESS;
                szCategoryHomeType1 = pCRES04DOutputRec.getSzCdRsrcCategory();
                szHomeType1 = CStringUtils.setCharAt(szHomeType1, 0, pCRES04DOutputRec.getCCdRsrcFaHomeType1());
                szHomeType1 = CStringUtils.setCharAt(szHomeType1, 1, pCRES04DOutputRec.getCCdRsrcFaHomeType2());
                szHomeType1 = CStringUtils.setCharAt(szHomeType1, 2, pCRES04DOutputRec.getCCdRsrcFaHomeType3());
                szHomeType1 = CStringUtils.setCharAt(szHomeType1, 3, pCRES04DOutputRec.getCCdRsrcFaHomeType4());
                szHomeType1 = CStringUtils.setCharAt(szHomeType1, 4, pCRES04DOutputRec.getCCdRsrcFaHomeType5());
                szHomeType1 = CStringUtils.setCharAt(szHomeType1, 5, pCRES04DOutputRec.getCCdRsrcFaHomeType6());
                szHomeType1 = CStringUtils.setCharAt(szHomeType1, 6, pCRES04DOutputRec.getCCdRsrcFaHomeType7());
                szCategoryHomeType1 += szHomeType1;
                break;
            default :
                Arcxmlerrors// SIR #2141 Retreive ID_CASE
                .PROCESS_TUX_RC_ERROR();
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        pCLSS82DInputRec/* locally defined output of DAM */
        .setUlIdResource(ulIdResource5);
        
        pCLSS82DInputRec.setSzCdRsrcFaHomeStatus("040");
        pCLSS82DInputRec/* SIR #2141 Retreivs rows for   */
        .getArchInputStruct().setUlPageSizeNbr(CLSS82DO._CLSS82DO__ROWCLSS53DO_SIZE);
        pCLSS82DInputRec/* CASE_MERGE for retreived case */
        .getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        rc = clss82dQUERYdam(sqlca, pCLSS82DInputRec, pCLSS82DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                RetVal = SUCCESS;
                szCategoryHomeType2 = pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getSzCdRshsCategory();
                szHomeType2 = CStringUtils.setCharAt(szHomeType2, 0, pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getCCdRshsFaHomeType1());
                szHomeType2 = CStringUtils.setCharAt(szHomeType2, 1, pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getCCdRshsFaHomeType2());
                szHomeType2 = CStringUtils.setCharAt(szHomeType2, 2, pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getCCdRshsFaHomeType3());
                szHomeType2 = CStringUtils.setCharAt(szHomeType2, 3, pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getCCdRshsFaHomeType4());
                szHomeType2 = CStringUtils.setCharAt(szHomeType2, 4, pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getCCdRshsFaHomeType5());
                szHomeType2 = CStringUtils.setCharAt(szHomeType2, 5, pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getCCdRshsFaHomeType6());
                szHomeType2 = CStringUtils.setCharAt(szHomeType2, 6, pCLSS82DOutputRec.getROWCLSS53DO_ARRAY().getROWCLSS53DO(1).getCCdRshsFaHomeType7());
                szCategoryHomeType2 += szHomeType2;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                RetVal = Csub50s.FND_FAIL;
                break;
                
        }
        if (0 == szCategoryHomeType2.compareTo(szCategoryHomeType1)) {
            RetVal = 1;
        }
        return RetVal;
    }

    static int CallCCMNC5D(CCMN35SI pInputMsg333, String szCaseName, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNC5DI pCCMNC5DInputRec = null;
        CCMNC5DO pCCMNC5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC5DInputRec = new CCMNC5DI();
        
        pCCMNC5DOutputRec = new CCMNC5DO();
        pCCMNC5DInputRec.setArchInputStruct(pInputMsg333.getArchInputStruct());
        
        pCCMNC5DInputRec.setUlIdCase(pInputMsg333.getUlIdCase());
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size 
        */
        
        /*
        ** Process error message and return to client 
        */
        
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields 
        */
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        
        /*
        ** A change was made to Unit Information, so get ID UNIT PARENT 
        */
        rc = ccmnc5dQUERYdam(sqlca, pCCMNC5DInputRec, pCCMNC5DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                szCaseName = NULL_STRING;
                
                strncat(szCaseName, pCCMNC5DOutputRec.getSzNmCase() , 16);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                //  Start performance timer for service
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
