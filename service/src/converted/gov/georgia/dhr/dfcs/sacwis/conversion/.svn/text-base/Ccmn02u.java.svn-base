package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC51UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC51UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD76DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN69DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS30DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC9DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc14s;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB9DI;
/**************************************************************************
**
** Module File:   CCMN02U.src
**
** Service Name:  CloseStageCase
**
** Description:   This shared library function provides the necessary
**                updates required to close a stage. If a case and a
**                situation are associated with the stage, and there are
**                no other open stages associated with the case, the
**                situation and the case are also closed.
**
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2-14-95
**
** Programmer:    Alex Ramirez
**
** Archive Information: $Revision:   1.0.2.10  $
**                      $Date:   29 Sep 1999 16:08:22  $
**                      $Modtime:   05 Aug 1999 15:47:44  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/06/95  RAMIREAP  Cleaned code. Eliminated ID CASE and ID PERSON from
**                      function's input structure.
**  03/07/95  RAMIREAP  Function no longer checks to see if Situation and
**                      Case being closed have already a closing date. Update
**                      of dates is performed no matter what.
**  04/10/95  RAMIREAP  If another open stage exists for the current case then
**                      neither the situation nor the case are closed; only
**                      the stage is closed.
**  04/19/95  ISF/APR   Modified error handling.
**  06/27/95  RAMIREAP  Removed references to DAM CCMNB9D.
**  06/27/95  RAMIREAP  Added references to DAM CCMNG2D. This DAM is now used
**                      in replacement of CCMNB9D. This allowed the
**                      elimination of nested looping within the function.
**  06/28/95  RAMIREAP  Eliminated mallocs for all structures. Structures are
**                      declared as regular variables and not as pointers.
**  06/28/95  RAMIREAP  Implemented code standards using the service shell
**                      as an example.
**  06/28/95  RAMIREAP  Modified error handling.
**  06/28/95  RAMIREAP  Added more detailed comments, specially for error-
**                      handling.
**  06/28/95  RAMIREAP  Element TXT EVENT DESCRIPTION was replaced by
**                      TXT EVENT DESCR in CCMN02UI copybook.
**  06/28/95  RAMIREAP  No to-do's are required now. If a stage is closed
**                      and no to-do's are linked to the stage, the DAM that
**                      deletes to-do's does not return an error on
**                      SQL_NOT_FOUND.
**  06/28/95  RAMIREAP  Added the posting of a case-closure event when a
**                      situation and a case are closed.
**  07/07/95  RAMIREAP  Added memsets for all declared structures.
**  07/07/95  RAMIREAP  Attached copybooks for DAM CCMNB9D to function's
**                      program (see next fix for reasoning).
**  07/07/95  RAMIREAP  Added logic for updating the STAGE_PERSON_LINK
**                      records whose CD_STAGE_PERS_ROLE is either
**                      "DB" or "DV". Field value is updated to "CL". This
**                      logic is only executed when function is dealing with
**                      a closure of an APS Investigation. DAM CCMNB9D is
**                      used to retrieve records from the STAGE_PERSON_LINK
**                      table.
**  07/12/95  RAMIREAP  Added CD_STAGE_REASON_CLOSE to DAM's CCMND4D Input
**                      Copybook record.
**
**  07/17/95  RAMIREAP  Added ID_STAGE_PERSON_LINK as an input element to
**                      DAM CCMND3D. Changed logic when updating a record
**                      in DAM CCMND3D. The search is now performed on
**                      ID_STAGE_PERSON_LINK and nothing more. This forced
**                      DAM's CCMNG2D and CCMNB9D to retrieve ID_STAGE_
**                      PERSON_LINK. Added element to both DAM's Output
**                      Records and modified their PC files. Added logic
**                      to this Function in order to handle changes.
**  09/28/95    KRD     Superficial changes to match the Release 1.x
**                      service shell.
**  10/03/95    KRD     SIR 1594 - CD_STAGE_PERS_ROLE code values have been
**                      changed from "DB" and "DV" to "VC" and "VP".
**  10/05/95    KRD     SIR 1642 - The event description
**
**  02/13/96   DYARGR   SIR 3104 - Added progression of Service
**                      Authorizations when closing the Investigation stage
**                      for CPS.
**  02/26/96    KRD     SIR 5026 - IdPerson is now being passed into the
**                      function and should be used when posting the stage
**                      closure event.
**  02/27/96   DYARGR   SIR 3318 - When closing the case, we should either
**                      create a new records retention record or modify the
**                      existing one. Also had to add dam to retrieve idOffice
**                      for the employee for the case_file_management table.
**
**  03/18/96  DYARGR    SIR 3625 - When closing a stage, we need to see if
**                      any of the persons are involved in another stage. If
**                      not, the person should be marked as inactive.
**
**  04/04/96  YANTISTK  SIR 20064 - Set page size before call to cinv33d.
**
** 04/08/96   DYARGR    SIR 20076 - Modify logic for movement of Service
**                      Authorizations when closing a stage. See Service
**                      Authorization change order.
**
**  04/10/96  YANTISTK  SIR 20329 - Before checking to see if there are
**                      any open stages associated with a case we need
**                      to see if the case is already closed. This is
**                      necessary for Admin Review, because Admin Review
**                      can be open even if the case is closed.
**
**  04/23/96 DYARGR     SIR 20616 - Using the DtStageClose wrong in
**                      determining which stages to progress to
**                      Should be looking for NULL DATE or MAX DATE
**
**  5/6/96   DYARGR     SIR 20762 - Added logic to move Service Auths
**                      to the Subcare stage when the Adoption stage
**                      is being closed and the closure reason is
**                      Adoption Consumated.
**
** 05/8/96  DYARGR      SIR 20987 - Modified #define for Closure code
**                      and changed if test.
**
** 05/13/96 DYARGR      SIR 20910 - When looking for duplicated SvcAuth's
**                      we need to compare the stage we are trying to
**                      move the SvcAuth's to the stage the SvcAuths reside
**                      in, if they already exist in the stage we are
**                      trying to move them to, then don't move them. However,
**                      just having the if test look for the existence of
**                      the SvcAuth in 1 stage and 1 stage only will not
**                      work as they may have been created in a previous
**                      stage and moved forward.
**
** 5/14/96  DYARGR      SIR 21162 - Added INV to if test for stages not to
**                      move Service Auth's to, regardless of what the start
**                      date of the INV stage is.
** 5/15/96  HELMKEST    SIR 21170 - Removed SIR 21162. Remove the
**                      investigation condition from this if test.
**
** 5/15/96  DYARGR      SIR 21218 - Removed SIR 21170, put 21162 back in
**                      Confused yet? PBuida - Do not move SvcAuth's back
**                      to INV stage.
**
** 5/20/96  DYARGR      SIR 21288 - Do not progress SvcAuth's into the
**                      Adoption stage.
**
** 5/21/96  DYARGR      SIR 21336 - Added logic to determine which SUB stage
**                      is the appropriate stage to send approved Auths
**                      to.
**
** 12/2/96  GONZALCE    SIR# 21809 - Add two dam calls, CALLCSES63D and
**                      CALLCINV95D to retrieve admin review records and
**                      the stage's overall disposition.  This functionality
**                      did not exist previously in this service.  Also added
**                      cIndRuloutOrAdm as an input variable in ccfc51ui.h
**                      to be able to determine when a case is or is not in
**                      Admin Review.  This addition was necessary to pass the
**                      information to pCCFC51UInputRec and call the correct
**                      code in Records Retention.
**
** 12/19/97 SOHNJJ      SIR #14160 - Add code to close EA eligibility when
**                      a stage is closed and the principal is not involved
**                      in any other changes.
**
** 08/04/98 SOHNJJ      SIR #14663 - Closing a stage or case where one or
**                      more of the principle have EA eligibility that is
**                      open to STARS caused an internal error.  CAPS never
**                      closes EA eligibility that is open to STARS.  There
**                      was, however, no code to handle principles with
**                      STARS EA eligibility.  Added code that will handle
**                      STARS EA eligibility by checking to see if it is
**                      open to STARS before entering the code segment that
**                      will close EA eligibility.
**
** 08/04/99 SOHNJJ      SIR #15189 - New federal regulations regarding the
**                      use of TANF funds require changes in the code that
**                      closes open EA eligibility records.  After October
**                      1, 1999, only the EA deny date will be updated upon
**                      case closure.  The EA end date will be 12 months from
**                      the start date minus one day and will never be updated.
**                      The EA eligibility record will close upon case closure
**                      or when the current system date is past the end date.
*
** 03/19/01 WEBSTED     ADDED Include files that SHOULD be in the .pc file
**                      because having the include files in FND cause
**                      some kind of irreversible loop. Put them in this file
**                      and all errors depart
**
** 04/30/03    Srini    SIR 17091: Added the error handling to take care of
**                      full table scans for ccmn87dQUERYdam.
**
** 06/11/03    Srini    SIR#17903 -Added another check to see  what the program
**                      is, so that only CPS ARI stage go in.
**
** 03/16/04  RIOSJA     SIR 19973 - If a stage suitable for receiving the
**                      open service auths is not found, return an error
**                      message informing the user that "Open services auths
**                      were found" so they can close them first.
**
** 03/24/04  RIOSJA     SIR 16227 - Added ARI to the list of stages not
**                      eligible to receive Service Auths from a closed stage.
**
** 07/30/04  RIOSJA     SIR 16123 - Approved FORMER_DAY_CARE service auths
**                      are allowed to remain open even for the last stage
**                      of the case. We do not require a stage to which to
**                      progress this type of service auth.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
/*************************************************************************
** 3 MAR 2001 - WEBSTE
** Added the following 6 include files so that they do not have to be include
** into ccmn03u.pc. Including them in the .pc file (in foundation) causes
** very confusing FND Error
**************************************************************************/



/**************************************************************************
** Service Macro Definitions
***************************************************************************/
/*
** SIR 3104
** Removed 1st 5 #define's FND_.. as they are no longer needed
*/
public class Ccmn02u {
    public static final int NULL_DATE = - 1;
    public static final int INITIAL_PAGE = 1;
    public static final String SPC_STAGE = "SPC";
    public static final String INR_STAGE = "I&R";
    public static final String PRIMARY = "PR";
    public static final String HISTORICAL_PRIMARY = "HP";
    public static final String EVENT_STATUS = "COMP";
    public static final String EVENT_TYPE = "STG";
    public static final String SPC_EVENT_DESC = "SPC Stage Closed";
    public static final String INR_EVENT_DESC = "I&R Stage Closed";
    public static final String CASE_EVENT_DESC = "Case Closed";
    public static final String CASE_CLOSURE_EVENT = "CAS";
    /*
    ** SIR 1594 - definitions of PERSON_ROLE_BOTH and PERSON_ROLE_VICTIM changed
    ** from "DB" to "VC" and "DV" to "VP", respectively
    */
    public static final String PERSON_ROLE_BOTH = "VC";
    public static final String PERSON_ROLE_VICTIM = "VP";
    public static final String PERSON_ROLE_CLIENT = "CL";
    public static final String APS_PROGRAM = "APS";
    public static final String INVESTIGATION = "INV";
    
    /*
    ** SIR 1642 - macro definition for the hyphen in the event description
    */
    public static final String HYPHEN = " - ";
    
    /*
    ** SIR 3104
    */
    public static final String CPS_PROGRAM = "CPS";
    public static final String SERVICE_AUTH_TYPE = "AUT";
    public static final String FSU_PROGRAM = "FSU";
    public static final String SVC_AUTH_CD_TASK = "2310";
    public static final String FSU_SVC_AUTH_TASK = "4190";
    public static final String EMPTY_STR = "";
    
    /*
    ** SIR 3587
    */
    public static final char PRS_OFFICE = 'P';
    
    /*
    ** SIR 3625
    */
    public static final char CD_INACTIVE = 'I';
    public static final String STAFF = "STF";
    
    /*
    ** SIR 20076
    */
    public static final String ARI_STAGE = "ARI";
    public static final String POST_ADOPT = "PAD";
    public static final String SUBCARE = "SUB";
    public static final String PREP_ADULT = "PAL";
    public static final String FPR_PROGRAM = "FPR";
    public static final String FRE_PROGRAM = "FRE";
    public static final String ADOPTION = "ADO";
    public static final String EVENT_STATUS_APRV = "APRV";
    public static final String FPR_SVC_AUTH_TASK = "7100";
    public static final String FRE_SVC_AUTH_TASK = "5640";
    public static final String ADO_SVC_AUTH_TASK = "8530";
    public static final String SUB_SVC_AUTH_TASK = "3020";
    
    /* SIR 20762*/
    public static final String ADOPTION_DISRUPT = "020";
    
    /*
    ** SIR 21336
    */
    public static final String PRIMARY_CHILD = "PC";
    
    /*
    ** SIR# 21809
    */
    public static final String CPS_ADMIN_REVIEW = "ARI";
    public static final String ALLEG_RULED_OUT = "R/O";
    public static final char ADMIN_REVIEW_YES = 'Y';
    public static final char ADMIN_REVIEW_NO = 'N';
    
    /*
    ** SIR #14160
    */
    public static final String STARS = "S";
    public static final String CAPS = "C";
    public static final String BOTH = "B";
    public static final int EA_RULE_CHANGE_MONTH = 9;
    public static final int EA_RULE_CHANGE_DAY = 1;
    public static final int EA_RULE_CHANGE_YEAR = 1997;
    public static final char BOTH_NULL = '3';
    
    /*
    **SIR #15189
    **#define POST_RULE_DATE       '4'
    **#define PRE_RULE_DATE        '5'
    **#define CAPS_STARS_POST_RULE '6'
    **#define CAPS_STARS_PRE_RULE  '7'
    */
    
    /*
    **  SIR 15189
    */
    public static final char UPDATE_DENY_DATE = '4';
    public static final char UPDATE_DENY_OPEN_CLOSE = '5';
    
    /* RIOSJA, SIR 16123 */
    public static final String FORMER_DAY_CARE = "40M";
    static int CloseStageCase(CCMN02UI pInputMsg63, CCMN02UO pOutputMsg65, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i69 = 0;
        int ulIdPrimaryWorker = 0;
        
        /*
        ** SIR 3104
        */
        FndInt3date DtToday = null;
        int n = 0;
        int m = 0;
        int j = 0;
        /*
        ** SIR 20076
        ** Modified the name for more generic use
        */
        int ulTempIdStage = 0;
        int lRC4 = 0;
        
        
        /*
        ** SIR 20076
        */
        FndInt3date DtTempStageStart = null;
        
        
        String szTempCdStage = new String();
        
        int ulFPRIdStage = 0;
        int ulFSUIdStage = 0;
        int ulFREIdStage = 0;
        int ulADOIdStage = 0;
        
        boolean bTempStageFound = false;
        
        /*
        ** SIR 20910
        */
        int bMultSvcAuth = 0;
        
        /*
        ** SIR 21336
        */
        int ulIdPrimChild = 0;
        
        /*
        ** SIR 14160
        */
        
        Pchar bEA_Open_Found = new Pchar();
        bEA_Open_Found.value = 0;
        char bAPS = 0;
        char bCPS = 0;
        char bEA_Close = 0;
        boolean bEA_Rule_Change = false;
        FndInt3date dtSysdate = null;
        int a = 0;
        
        /*
        ** Declare DAM's input and ouput structure headers
        */
        CCMN46DI CCMN46DI = null;
        CCMN46DO CCMN46DO = null;
        CCMNB8DO CCMNB8DO = null;
        CCMNB9DO CCMNB9DO = null;
        CCMNC5DI CCMNC5DI = null;
        CCMNC5DO CCMNC5DO = null;
        CCMNC6DI CCMNC6DI = null;
        CCMND1DI CCMND1DI = null;
        CCMND3DI CCMND3DI = null;
        CCMNF6DI CCMNF6DI = null;
        CCMNF6DO CCMNF6DO = null;
        CCMNG2DO CCMNG2DO = null;
        CINT13DI CINT13DI = null;
        CINT21DO CINT21DO = null;
        CINT24DI CINT24DI = null;
        CINT24DO CINT24DO = null;
        
        /*
        ** SIR 3104
        */
        CCMN87DI CCMN87DI = null;
        CCMN87DO CCMN87DO = null;
        CCMND2DI CCMND2DI = null;
        CCMND2DO CCMND2DO = null;
        CCMN68DI CCMN68DI = null;
        CCMN68DO CCMN68DO = null;
        CSES24DI CSES24DI = null;
        CSES24DO CSES24DO = null;
        CSES23DI CSES23DI = null;
        CSES23DO CSES23DO = null;
        CLSC73DI CLSC73DI = null;
        CLSC73DO CLSC73DO = null;
        CLSS24DI CLSS24DI = null;
        CLSS24DO CLSS24DO = null;
        CAUD34DI CAUD34DI = null;
        CAUD34DO CAUD34DO = null;
        
        /*
        ** SIR 3318
        */
        
        CCFC51UI CCFC51UI = null;
        CCFC51UO CCFC51UO = null;
        CSES57DI CSES57DI = null;
        CSES57DO CSES57DO = null;
        CAUD76DI CAUD76DI = null;
        CAUD76DO CAUD76DO = null;
        CCMN69DI CCMN69DI = null;
        CCMN69DO CCMN69DO = null;
        
        /*
        ** SIR 3625
        */
        CAUD74DI CAUD74DI = null;
        CAUD74DO CAUD74DO = null;
        CINV33DI CINV33DI = null;
        CINV33DO CINV33DO = null;
        
        /*
        ** SIR 20076
        */
        CLSS30DI CLSS30DI = null;
        CLSS30DO CLSS30DO = null;
        
        /*
        ** SIR 21336
        */
        CSEC29DI CSEC29DI = null;
        CSEC29DO CSEC29DO = null;
        
        /*
        ** SIR 21809
        */
        CSES63DI CSES63DI = null;
        CSES63DO CSES63DO = null;
        CINV95DI CINV95DI = null;
        CINV95DO CINV95DO = null;
        
        
        /*
        ** SIR 14160 - Declare input output structure for DAM's
        */
        
        CSECA4DI CSECA4DI = null;
        CSECA4DO CSECA4DO = null;
        CAUDC9DI CAUDC9DI = null;
        CAUDC9DO CAUDC9DO = null;
        pServiceStatus.severity = SUCCESS;
        pServiceStatus.explan_code = SUCCESS;
        
        DtTempStageStart.day = NULL_DATE;
        DtTempStageStart.month = NULL_DATE;
        DtTempStageStart.year = NULL_DATE;
        
        if (0 != pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(SPC_STAGE) && 0 != pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(INR_STAGE)) {
            pInputMsg63.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pInputMsg63.getArchInputStruct().setUlPageSizeNbr(CCMNB8DO.get_CCMNB8DO__ROWCCMNB8DO_SIZE());
            rc = Ccmn03u.CallCCMNB8D(pInputMsg63, CCMNB8DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        
        /*
        ** Look for a Narrative/Blob using the given ID EVENT.
        */
        rc = Ccmn03u.CallCINT21D(pInputMsg63, CINT21DO, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        if (NULL_DATE == CINT21DO.getDtDtStageClose().year) {
            
            pInputMsg63.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = Ccmn03u.CallCCMND4D(pInputMsg63, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            CCMN46DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
            CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            
            if (0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(SPC_STAGE) || 0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(INR_STAGE)) {
                CCMN46DI.setSzCdEventStatus(EVENT_STATUS);
                CCMN46DI.setSzCdEventType(EVENT_TYPE);
            }
            else {
                CCMN46DI.setSzCdEventStatus(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgStatus());
                CCMN46DI.setSzCdEventType(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgEventType());
            }
            CCMN46DI.setUlIdPerson(pInputMsg63.getCCMN02UIG00().getUlIdPerson());
            
            CCMN46DI.setUlIdStage(pInputMsg63.getCCMN02UIG00().getUlIdStage());
            //  Don't break if a PRIMARY CASEWORKER is not found. The user
            // can still go to Staff Search Window to select a caseworker.
            rc = ARC_UTLGetDateAndTime(CCMN46DI.getDtDtEventOccurred() , 0);
            
            // 
            // Function Prototypes
            // 
            // SIR 15280
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            
            if ((0 != pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(SPC_STAGE)) && (0 != pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(INR_STAGE))) {
                CCMN46DI.setSzTxtEventDescr(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzTxtStageProgEvntDesc());
            }
            else if (0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(SPC_STAGE)) {
                CCMN46DI.setSzTxtEventDescr(SPC_EVENT_DESC);
            }
            else if (0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(INR_STAGE)) {
                
                CCMN46DI.setSzTxtEventDescr(INR_EVENT_DESC);
            }
            if (null != pInputMsg63.getCCMN02UIG00().getSzTxtEventDescr()[0]) {
                
                strncat(CCMN46DI.getSzTxtEventDescr() , HYPHEN, sizeof () - CCMN46DI.getSzTxtEventDescr().length());
                //  event description passed in
                strncat(CCMN46DI.getSzTxtEventDescr() , pInputMsg63.getCCMN02UIG00().getSzTxtEventDescr() , sizeof () - CCMN46DI.getSzTxtEventDescr().length());
            }
            
            //  Finally, we need to determine if there is a Stage Conclusion
            // Event in the tables. If there is, and it is pending, then we
            // need to return this fact to the client. Any Contacts recorded
            // against Closure Pending Stages will invalidate the Approval
            // Event. pOutputMsg->ulIdEvent is populated with the ID EVENT of
            // the Stage Conclusion Event IF it exists AND IF it's status is PENDING.
            rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    pOutputMsg65.setUlIdEvent(CCMN46DO.getUlIdEvent());
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
            
            rc = Ccmn03u.CallCCMNG2D(pInputMsg63, CCMNG2DO, pServiceStatus);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            CCMN69DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
            CCMN69DI.setUlIdPerson(CCMNG2DO.getUlIdPerson());
            
            
            //  SIR 13618 - Call CINVB8D to determine if a Request for Review
            // contact was recorded.
            rc = Ccmn04s.CallCCMN69D(CCMN69DI, CCMN69DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            CCMND3DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
            
            CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            CCMND3DI.setSzCdStagePersRelInt(CCMNG2DO.getSzCdStagePersRelInt());
            CCMND3DI.setSzCdStagePersRole(HISTORICAL_PRIMARY);
            CCMND3DI.setSzCdStagePersSearchInd(CCMNG2DO.getSzCdStagePersSearchInd());
            
            CCMND3DI.setSzCdStagePersType(CCMNG2DO.getSzCdStagePersType());
            CCMND3DI.setSzTxtStagePersNotes(CCMNG2DO.getSzTxtStagePersNotes());
            CCMND3DI.setUlIdPerson(CCMNG2DO.getUlIdPerson());
            CCMND3DI.setUlIdStagePerson(CCMNG2DO.getUlIdStagePerson());
            
            CCMND3DI.setBIndStagePersInLaw(CCMNG2DO.getBIndStagePersInLaw());
            CCMND3DI.setBIndStagePersReporter(CCMNG2DO.getBIndStagePersReporter());
            CCMND3DI.setBIndStagePersEmpNew(CCMNG2DO.getBIndStagePersEmpNew());
            CCMND3DI.setUlIdStage(pInputMsg63.getCCMN02UIG00().getUlIdStage());
            CCMND3DI.setDtDtStagePersLink(CCMNG2DO.getDtDtStagePersLink());
            CCMND3DI.setTsLastUpdate(CCMNG2DO.getTsLastUpdate());
            
            
            //SIR 22860 - removed if ( (0 == strcmp (pOutputMsg->szCdStageProgram, APS_STAGE)) &&
            //                     ( 0 == strcmp (pOutputMsg->szCdStage,INVESTIGATION) )
            //  SIR 14235 - Retrieve the Intake start date
            rc = CallCCMND3D(CCMND3DI, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            CCMND3DI.setUlIdStage(pInputMsg63.getCCMN02UIG00().getUlIdStage());
            
            //  Load translation map with service name and version
            
            //  SIR 903        8/5/95           maxhamkj
            // Get current date and time.
            // 
            rc = CallCCMND3D(CCMND3DI, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            if (0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(INVESTIGATION) && 0 == pInputMsg63.getCCMN02UIG00().getSzCdStageProgram().compareTo(APS_PROGRAM)) {
                //  Unlike typical DAM calls, a Common Function handles its own
                // SQL errors.  So, after returning, we should call
                // PROCESS_RC_ERROR rather than PROCESS_TUX_SQL_ERROR_TRANSACT
                pInputMsg63.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pInputMsg63.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO.get_CCMNB9DO__ROWCCMNB9DO_SIZE());
                
                do {
                    rc = Ccmn03u.CallCCMNB9D(pInputMsg63, CCMNB9DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (i69 = 0;i69 < CCMNB9DO.getArchOutputStruct().getUlRowQty();++i69) {
                        if (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzCdStagePersRole().compareTo(PERSON_ROLE_BOTH) || 0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzCdStagePersRole().compareTo(PERSON_ROLE_VICTIM)) {
                            CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            CCMND3DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                            CCMND3DI.setSzCdStagePersRelInt(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzCdStagePersRelInt());
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_CLIENT);
                            CCMND3DI.setSzCdStagePersSearchInd(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzCdStagePersSearchInd());
                            CCMND3DI.setSzCdStagePersType(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzCdStagePersType());
                            
                            CCMND3DI.setSzTxtStagePersNotes(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzTxtStagePersNotes());
                            CCMND3DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getUlIdPerson());
                            CCMND3DI.setUlIdStagePerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getUlIdStagePerson());
                            CCMND3DI.setBIndStagePersInLaw(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getBIndStagePersInLaw());
                            CCMND3DI.setBIndStagePersReporter(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getBIndStagePersReporter());
                            CCMND3DI.setBIndStagePersEmpNew(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getBIndStagePersEmpNew());
                            CCMND3DI.setUlIdStage(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getUlIdStage());
                            CCMND3DI.setDtDtStagePersLink(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getDtDtStagePersLink());
                            CCMND3DI.setTsLastUpdate(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getTsLastUpdate());
                            
                            //  Start Performance Timer
                            rc = CallCCMND3D(CCMND3DI, pServiceStatus);
                        }
                    }
                    pInputMsg63.getArchInputStruct().getUsPageNbr()++;
                }
                
                while (CCMNB9DO.getArchOutputStruct().getBMoreDataInd() == true);
            }
            pInputMsg63.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pInputMsg63.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO.get_CCMNB9DO__ROWCCMNB9DO_SIZE());
            
            //  Initialize Service Status Fields
            
            //  Perform Main Processing
            
            //  Set pOutputMsg WCD DtSystemDate to current date
            rc = Ccmn03u.CallCCMNB9D(pInputMsg63, CCMNB9DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            //  Loop through all rows retrieved from stage person link
            for (i69 = 0;i69 < CCMNB9DO.getArchOutputStruct().getUlRowQty();i69++) {
                if (0 != CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzCdStagePersType().compareTo(STAFF)) {
                    CINV33DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getUlIdPerson());
                    
                    //   
                    // Function Prototypes
                    // 
                    //  SIR 1767 - prototype for call to DAM CINT58D
                    CINV33DI.setSzCdStageProgram(pInputMsg63.getCCMN02UIG00().getSzCdStageProgram());
                    
                    //  SIR#2177 : 14 December 1995
                    // From this point, the code was re-written to correspond
                    // to the changed window code.  (CSUB40W.WIN)
                    
                    //  SIR 21130 - retrieves the id_event of the Stage closure event if there
                    // is one.
                    rc = Cint10s.CallCINV33D(CINV33DI, CINV33DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    if (0 == CINV33DO.getArchOutputStruct().getUlRowQty()) {
                        CAUD74DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getUlIdPerson());
                        
                        //  SIR 20217 - prototype for call to DAM CINT21D
                        CAUD74DI.getCdPersonStatus()[0] = CD_INACTIVE;
                        rc = Ccfc14s.CallCAUD74D(CAUD74DI, CAUD74DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                    {
                        
                        
                        
                        bAPS = 0;
                        bCPS = 0;
                        bEA_Close = 0;
                        
                        for (a = 0;a < CINV33DO.getArchOutputStruct().getUlRowQty();a++) {
                            if ((0 == CINV33DO.getROWCINV33DO_ARRAY().getROWCINV33DO(a).getSzCdStageProgram().compareTo("APS")) || (0 == CINV33DO.getROWCINV33DO_ARRAY().getROWCINV33DO(a).getSzCdStageProgram().compareTo("AFC"))) {
                                bAPS = 1;
                            }
                            
                            if (0 == CINV33DO.getROWCINV33DO_ARRAY().getROWCINV33DO(a).getSzCdStageProgram().compareTo("CPS")) {
                                bCPS = 1;
                                
                            }
                        }
                        
                        if (bAPS != 0 &&!(bCPS != 0)) {
                            bEA_Close = 1;
                        }
                        
                        if (0 == CINV33DO.getArchOutputStruct().getUlRowQty() || bEA_Close != 0) {
                            CSECA4DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                            
                            //## BEGIN TUX/XML: Declare XML variables 
                            CSECA4DI.setUlIdPersEligPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getUlIdPerson());
                            bEA_Open_Found.value = 0;
                            bEA_Rule_Change = false;
                            rc = Ccfc14s.CallCSECA4D(CSECA4DI, CSECA4DO, bEA_Open_Found, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            
                            if (bEA_Open_Found.value != 0 && 0 != CSECA4DO.getCdPersEligPrgOpen().compareTo(STARS)) {
                                
                                //  Call CINV51D
                                rc = ARC_UTLGetDateAndTime(dtSysdate, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                CAUDC9DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                                CAUDC9DI.setUlIdPersElig(CSECA4DO.getUlIdPersElig());
                                
                                if ((0 == CSECA4DO.getCdPersEligPrgOpen().compareTo(BOTH)) && (0 == CSECA4DO.getCdPersEligPrgClose().compareTo(EMPTY_STR))) {
                                    CAUDC9DI.setCdPersEligPrgOpen(STARS);
                                    CAUDC9DI.setCdPersEligPrgClose(CAPS);
                                    CAUDC9DI.getArchInputStruct().setCReqFuncCd(BOTH_NULL);
                                }
                                
                                if ((0 == CSECA4DO.getCdPersEligPrgOpen().compareTo(BOTH)) && (0 == CSECA4DO.getCdPersEligPrgClose().compareTo(STARS))) {
                                    CAUDC9DI.setCdPersEligPrgClose(BOTH);
                                    CAUDC9DI.setDtDtPersEligEaDeny(dtSysdate);
                                    CAUDC9DI.getArchInputStruct().setCReqFuncCd(UPDATE_DENY_DATE);
                                }
                                if ((0 == CSECA4DO.getCdPersEligPrgOpen().compareTo(CAPS)) && (0 == CSECA4DO.getCdPersEligPrgClose().compareTo(EMPTY_STR))) {
                                    CAUDC9DI.setCdPersEligPrgClose(CAPS);
                                    CAUDC9DI.setDtDtPersEligEaDeny(dtSysdate);
                                    CAUDC9DI.getArchInputStruct().setCReqFuncCd(UPDATE_DENY_DATE);
                                }
                                if ((0 == CSECA4DO.getCdPersEligPrgOpen().compareTo(CAPS)) && (0 == CSECA4DO.getCdPersEligPrgClose().compareTo(STARS))) {
                                    CAUDC9DI.setCdPersEligPrgOpen(BOTH);
                                    CAUDC9DI.setCdPersEligPrgClose(BOTH);
                                    CAUDC9DI.setDtDtPersEligEaDeny(dtSysdate);
                                    CAUDC9DI.getArchInputStruct().setCReqFuncCd(UPDATE_DENY_OPEN_CLOSE);
                                }
                                rc = Ccmn03u.CallCAUDC9D(CAUDC9DI, CAUDC9DO, pServiceStatus);
                                
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                
                            }
                        }
                    }
                }
            }
            if (CINT21DO.getUlIdCase() != 0) 
            {
                CCMNC5DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                CCMNC5DI.setUlIdCase(CINT21DO.getUlIdCase());
                rc = Ccmn35s.CallCCMNC5D(CCMNC5DI, CCMNC5DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                if ((0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(CPS_ADMIN_REVIEW)) && (0 == pInputMsg63.getCCMN02UIG00().getSzCdStageProgram().compareTo("CPS"))) {
                    
                    //  Call CCMN44D
                    rc = CallCSES63D(pInputMsg63, CSES63DO, pServiceStatus);
                    CINV95DI.setUlIdStage(CSES63DO.getUlIdStageRelated());
                    rc = Cinv11s.CallCINV95D(CINV95DI, CINV95DO, pServiceStatus);
                }
                if (((CCMNC5DO.getDtDtCaseClosed().day == NULL_DATE) && (CCMNC5DO.getDtDtCaseClosed().month == NULL_DATE) && (CCMNC5DO.getDtDtCaseClosed().year == NULL_DATE)) || ((0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(CPS_ADMIN_REVIEW)) && (0 == CINV95DO.getCdCpsOverallDisptn().compareTo(ALLEG_RULED_OUT)))) {
                    CCMNF6DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                    CCMNF6DI.setUlIdCase(CINT21DO.getUlIdCase());
                    rc = Ccmn03u.CallCCMNF6D(CCMNF6DI, CCMNF6DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    //  Analyze error code
                    if (CCMNF6DO.getArchOutputStruct().getUlRowQty() == 0) {
                        if ((0 != pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(CPS_ADMIN_REVIEW)) || ((0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(CPS_ADMIN_REVIEW)) && ((CCMNC5DO.getDtDtCaseClosed().day == NULL_DATE) && (CCMNC5DO.getDtDtCaseClosed().month == NULL_DATE) && (CCMNC5DO.getDtDtCaseClosed().year == NULL_DATE)))) {
                            CINT24DI.setUlIdSituation(CINT21DO.getUlIdSituation());
                            
                            
                            //  Call CCMN45D
                            rc = CallCINT24D(CINT24DI, CINT24DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CINT13DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                            CINT13DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            CINT13DI.setUlIdSituation(CINT21DO.getUlIdSituation());
                            CINT13DI.setUlIdCase(CINT21DO.getUlIdCase());
                            CINT13DI.setDtDtSituationOpened(CINT24DO.getDtDtSituationOpened());
                            rc = ARC_UTLGetDateAndTime(CINT13DI.getDtDtSituationClosed() , 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            rc = CallCINT13D(CINT13DI, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CCMNC6DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                            CCMNC6DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            CCMNC6DI.setSzCdCaseCounty(CCMNC5DO.getSzCdCaseCounty());
                            CCMNC6DI.setSzCdCaseProgram(CCMNC5DO.getSzCdCaseProgram());
                            CCMNC6DI.setSzCdCaseRegion(CCMNC5DO.getSzCdCaseRegion());
                            CCMNC6DI.setSzCdCaseSpeclHndlg(CCMNC5DO.getSzCdCaseSpeclHndlg());
                            CCMNC6DI.setSzNmCase(CCMNC5DO.getSzNmCase());
                            CCMNC6DI.setSzTxtCaseSensitiveCmnts(CCMNC5DO.getSzTxtCaseSensitiveCmnts());
                            CCMNC6DI.setSzTxtCaseWorkerSafety(CCMNC5DO.getSzTxtCaseWorkerSafety());
                            CCMNC6DI.setUlIdCase(CCMNC5DO.getUlIdCase());
                            CCMNC6DI.setDtDtCaseOpened(CCMNC5DO.getDtDtCaseOpened());
                            CCMNC6DI.setBIndCaseArchived(CCMNC5DO.getBIndCaseArchived());
                            CCMNC6DI.setBIndCaseSensitive(CCMNC5DO.getBIndCaseSensitive());
                            CCMNC6DI.setBIndCaseWorkerSafety(CCMNC5DO.getBIndCaseWorkerSafety());
                            
                            //  Call CINV51D
                            rc = ARC_UTLGetDateAndTime(CCMNC6DI.getDtDtCaseClosed() , 0);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            rc = CallCCMNC6D(CCMNC6DI, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            CCMN46DI.setSzCdEventStatus(EVENT_STATUS);
                            CCMN46DI.setSzCdEventType(CASE_CLOSURE_EVENT);
                            CCMN46DI.setUlIdPerson(0);
                            CCMN46DI.setSzTxtEventDescr(CASE_EVENT_DESC);
                            rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CCMND1DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                            CCMND1DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                            CCMND1DI.setUlIdCase(CINT21DO.getUlIdCase());
                            
                            //  Call CCMN44D
                            rc = CallCCMND1D(CCMND1DI, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                        CCFC51UI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                        CCFC51UI.setUlIdCase(CINT21DO.getUlIdCase());
                        if (0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(CPS_ADMIN_REVIEW)) {
                            CCFC51UI.setCIndRuloutOrAdm(ADMIN_REVIEW_YES);
                        }
                        else {
                            CCFC51UI.setCIndRuloutOrAdm(ADMIN_REVIEW_NO);
                        }
                        rc = CallCCFC51U(CCFC51UI, CCFC51UO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        
                        if ((0 != pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(CPS_ADMIN_REVIEW)) || ((0 == pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(CPS_ADMIN_REVIEW)) && ((CCMNC5DO.getDtDtCaseClosed().day == NULL_DATE) && (CCMNC5DO.getDtDtCaseClosed().month == NULL_DATE) && (CCMNC5DO.getDtDtCaseClosed().year == NULL_DATE)))) {
                            CSES57DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                            CSES57DI.setUlIdCase(CINT21DO.getUlIdCase());
                            rc = CallCSES57D(CSES57DI, CSES57DO, pServiceStatus);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case (WtcHelperConstants.SQL_SUCCESS):
                                    
                                case (NO_DATA_FOUND):
                                    CAUD76DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                                    
                                    if (WtcHelperConstants.SQL_SUCCESS == rc) {
                                        CAUD76DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        CAUD76DI.setUlIdCase(CSES57DO.getUlIdCase());
                                        CAUD76DI.setTsLastUpdate(CSES57DO.getTsLastUpdate());
                                        CAUD76DI.setSztxtCaseFileLocateInfo(CSES57DO.getSztxtCaseFileLocateInfo());
                                    }
                                    
                                    
                                    
                                    else {
                                        CAUD76DI.setUlIdCase(CINT21DO.getUlIdCase());
                                        CAUD76DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                    }
                                    CAUD76DI.setUlIdUnit(CINT21DO.getUlIdUnit());
                                    CAUD76DI.setUlIdOffice(CCMN69DO.getUlIdOffice());
                                    CAUD76DI.setSzCdCaseFileOfficeType(PRS_OFFICE);
                                    
                                    //  Call CSES11D
                                    rc = CallCAUD76D(CAUD76DI, CAUD76DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    break;
                            }
                        }
                    }
                }
            }
            
            if (CINT21DO.getUlIdCase() == 0 || CCMNF6DO.getArchOutputStruct().getUlRowQty() != 0) {
                pInputMsg63.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                rc = CallCCMNC9D(pInputMsg63, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
        }
        else /* Stage is already closed ERROR */
        {
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Messages.MSG_CMN_STAGE_CLOSED;
            rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
            return rc;
        }
        
        /*
        ** SIR 22284 - This function has been modified to call the
        ** TodoCommonFunction() rather than making the DAMs calls itself.
        **
        ** Here is how the function processes:
        **    check to see if the LE Notif ToDo already exists
        **    if so, then check to see if the stage classification is
        **           COS or COA
        **           if so, then delete that ToDo
        **           if not, exit the function
        **    if not, create the LE Notif ToDo if the stage classification is
        **            not COS or COA
        */
        
        if ((0 != pInputMsg63.getCCMN02UIG00().getSzCdStage().compareTo(POST_ADOPT)) && (0 == pInputMsg63.getCCMN02UIG00().getSzCdStageProgram().compareTo(CPS_PROGRAM)) && (CCMNF6DO.getArchOutputStruct().getUlRowQty() != 0)) {
            CLSS30DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
            CLSS30DI.setUlIdCase(CINT21DO.getUlIdCase());
            
            //  Call CINV51D
            rc = Cinv15s.CallCLSS30D(CLSS30DI, CLSS30DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            //  a todo exists.  if the classification is COS or COA, we need
            // to delete the todo
            if (0 != ADOPTION.compareTo(pInputMsg63.getCCMN02UIG00().getSzCdStage())) {
                
                for (j = 0;j < CLSS30DO.getArchOutputStruct().getUlRowQty() && bTempStageFound == false;j++) {
                    
                    //  a todo does not exist, so we need to create it as long as the
                    // classification is not COS or COA
                    if ((((NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year) && (NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().day) && (NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().month)) || (DateHelper.ARC_MAX_YEAR == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year)) && (CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getUlIdStage() != pInputMsg63.getCCMN02UIG00().getUlIdStage())) {
                        lRC4 = ARC_UTLCompareDateAndTime((FndInt3date) & DtTempStageStart, (char) 0, (FndInt3date) & CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageStart() , (char) 0);
                        if ((lRC4 < 0) && ((0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(PREP_ADULT)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ARI_STAGE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(SUBCARE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(INVESTIGATION)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ADOPTION)))) {
                            ulTempIdStage = CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getUlIdStage();
                            szTempCdStage = CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage();
                            
                            DtTempStageStart = CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageStart();
                        }
                        //  If the start dates are equal there is a hierarchy to follow
                        // we need to find the Family Preservation stage, then FSU stage
                        // then the FRE stage, then the ADO stage. The first one of these
                        // found open is used
                        // SIR 21288 - Added ADO to if test
                        // RIOSJA SIR 16227 - Added ARI to the list of stages not eligible
                        // to receive Service Auths from a closed stage.
                        else if ((lRC4 == 0) && ((0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(PREP_ADULT)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ARI_STAGE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(SUBCARE)) && (0 != CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getSzCdStage().compareTo(ADOPTION)))) {
                            
                            for (i69 = 0;i69 < CLSS30DO.getArchOutputStruct().getUlRowQty();i69++) {
                                if (((NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year) && (NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().day) && (NULL_DATE == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().month)) || (DateHelper.ARC_MAX_YEAR == CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(j).getDtDtStageClose().year)) {
                                    
                                    if (0 == FPR_PROGRAM.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i69).getSzCdStage())) {
                                        ulFPRIdStage = CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i69).getUlIdStage();
                                        bTempStageFound = true;
                                    }
                                    else if (0 == FSU_PROGRAM.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i69).getSzCdStage())) {
                                        ulFSUIdStage = CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i69).getUlIdStage();
                                        bTempStageFound = true;
                                    }
                                    else if (0 == FRE_PROGRAM.compareTo(CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i69).getSzCdStage())) {
                                        ulFREIdStage = CLSS30DO.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i69).getUlIdStage();
                                        bTempStageFound = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //  SIR 20987
            // #define was modified to fit closure reason not placement closure reason
            else if (0 == ADOPTION_DISRUPT.compareTo(pInputMsg63.getCCMN02UIG00().getSzCdStageReasonClosed())) {
                pInputMsg63.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pInputMsg63.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO.get_CCMNB9DO__ROWCCMNB9DO_SIZE());
                rc = Ccmn03u.CallCCMNB9D(pInputMsg63, CCMNB9DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                
                for (i69 = 0;i69 < CCMNB9DO.getArchOutputStruct().getUlRowQty() && 0 == ulIdPrimChild;++i69) {
                    
                    if (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getSzCdStagePersRole().compareTo(PRIMARY_CHILD)) {
                        ulIdPrimChild = CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i69).getUlIdPerson();
                    }
                }
                CSEC29DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                
                CSEC29DI.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                CSEC29DI.setUlIdPerson(ulIdPrimChild);
                CSEC29DI.setUlIdCase(CINT21DO.getUlIdCase());
                CSEC29DI.setSzCdStagePersRole(PRIMARY_CHILD);
                CSEC29DI.setSzCdStage(SUBCARE);
                rc = Ccmn03u.CallCSEC29D(CSEC29DI, CSEC29DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                
                bTempStageFound = true;
                
                ulTempIdStage = CSEC29DO.getUlIdStage();
                szTempCdStage = CSEC29DO.getSzCdStage();
                DtTempStageStart = CSEC29DO.getDtDtStageStart();
                
                ulFPRIdStage = 0;
                ulFSUIdStage = 0;
                ulFREIdStage = 0;
                ulADOIdStage = 0;
            }
            CCMN87DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
            
            CCMN87DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            
            CCMN87DI.setUlIdStage(pInputMsg63.getCCMN02UIG00().getUlIdStage());
            
            if (0 == INVESTIGATION.compareTo(pInputMsg63.getCCMN02UIG00().getSzCdStage())) {
                
                CCMN87DI.setSzCdTask(SVC_AUTH_CD_TASK);
            }
            else if (0 == SUBCARE.compareTo(pInputMsg63.getCCMN02UIG00().getSzCdStage())) {
                CCMN87DI.setSzCdTask(SUB_SVC_AUTH_TASK);
            }
            
            if (0 == ADOPTION.compareTo(pInputMsg63.getCCMN02UIG00().getSzCdStage())) {
                CCMN87DI.setSzCdTask(ADO_SVC_AUTH_TASK);
            }
            
            if (0 == FSU_PROGRAM.compareTo(pInputMsg63.getCCMN02UIG00().getSzCdStage())) {
                CCMN87DI.setSzCdTask(FSU_SVC_AUTH_TASK);
            }
            else if (0 == FRE_PROGRAM.compareTo(pInputMsg63.getCCMN02UIG00().getSzCdStage())) {
                CCMN87DI.setSzCdTask(FRE_SVC_AUTH_TASK);
            }
            
            //  Call CCMN44D
            rc = Ccmn03u.CallCCMN87D(CCMN87DI, CCMN87DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            if (CCMN87DO.getArchOutputStruct().getUlRowQty() > 0) {
                for (i69 = 0;i69 < CCMN87DO.getArchOutputStruct().getUlRowQty();i69++) {
                    if (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getSzCdEventType().compareTo(SERVICE_AUTH_TYPE)) {
                        CSES24DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                        CSES24DI.setUlIdSvcAuthEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getUlIdEvent());
                        rc = Ccmn03u.CallCSES24D(CSES24DI, CSES24DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        
                        CLSC73DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                        CLSC73DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                        rc = CallCLSC73D(CLSC73DI, CLSC73DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        if (CLSC73DO.getArchOutputStruct().getUlRowQty() == 1) {
                            bMultSvcAuth = 0;
                        }
                        else if (CLSC73DO.getArchOutputStruct().getUlRowQty() > 1) {
                            for (n = 0;n < CLSC73DO.getArchOutputStruct().getUlRowQty() && bMultSvcAuth == false;n++) {
                                if (((NULL_DATE == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getDtDtStageClose().day) && (NULL_DATE == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getDtDtStageClose().month) && (NULL_DATE == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getDtDtStageClose().year)) || (DateHelper.ARC_MAX_YEAR == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getDtDtStageClose().year)) {
                                    if ((0 != ulFPRIdStage) && (0 == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getSzCdStage().compareTo(FPR_PROGRAM))) {
                                        
                                        bMultSvcAuth = 1;
                                    }
                                    else if ((0 != ulFSUIdStage) && (0 == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getSzCdStage().compareTo(FSU_PROGRAM))) {
                                        bMultSvcAuth = 1;
                                    }
                                    
                                    else if ((0 != ulFREIdStage) && (0 == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getSzCdStage().compareTo(FRE_PROGRAM))) {
                                        bMultSvcAuth = 1;
                                    }
                                    else if ((0 != ulADOIdStage) && (0 == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getSzCdStage().compareTo(ADOPTION))) {
                                        bMultSvcAuth = 1;
                                    }
                                    else if ((0 != ulTempIdStage) && (0 == CLSC73DO.getROWCLSC73DO_ARRAY().getROWCLSC73DO(n).getSzCdStage().compareTo(szTempCdStage))) {
                                        bMultSvcAuth = 1;
                                    }
                                }
                            }
                        }
                        if (!bMultSvcAuth) {
                            CSES23DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                            CSES23DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                            
                            //  Call CSES11D
                            rc = Ccmn03u.CallCSES23D(CSES23DI, CSES23DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            if (FND_YES == CSES23DO.getCIndSvcAuthComplete()) {
                                CLSS24DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                                CLSS24DI.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                CLSS24DI.getArchInputStruct().setUlPageSizeNbr(CLSS24DO.get_CLSS24DO__ROWCLSS24DO_SIZE());
                                
                                CLSS24DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                rc = Ccmn03u.CallCLSS24D(CLSS24DI, CLSS24DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                rc = ARC_UTLGetDateAndTime(DtToday, 0);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                
                                for (m = 0;m < CLSS24DO.getArchOutputStruct().getUlRowQty();m++) {
                                    lRC4 = ARC_UTLCompareDateAndTime((FndInt3date) & DtToday, (char) 0, (FndInt3date) & CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getDtDtSvcAuthDtlTerm() , (char) 0);
                                    
                                    
                                    
                                    
                                    //  Analyze error code
                                    if ((lRC4 < 0) && (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getSzCdEventStatus().compareTo(EVENT_STATUS_APRV))) {
                                        CCMN46DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                                        CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                        CCMN46DI.setSzCdEventStatus(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getSzCdEventStatus());
                                        CCMN46DI.setDtDtEventOccurred(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getDtDtEventOccurred());
                                        CCMN46DI.setSzTxtEventDescr(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getSzTxtEventDescr());
                                        CCMN46DI.setSzCdEventType(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getSzCdEventType());
                                        if (ulFPRIdStage > 0) {
                                            CCMN46DI.setUlIdStage(ulFPRIdStage);
                                            CCMN46DI.setSzCdTask(FPR_SVC_AUTH_TASK);
                                        }
                                        else if (ulFSUIdStage > 0) {
                                            CCMN46DI.setUlIdStage(ulFSUIdStage);
                                            CCMN46DI.setSzCdTask(FSU_SVC_AUTH_TASK);
                                        }
                                        else if (ulFREIdStage > 0) {
                                            CCMN46DI.setUlIdStage(ulFREIdStage);
                                            CCMN46DI.setSzCdTask(FRE_SVC_AUTH_TASK);
                                        }
                                        
                                        //  SIR 21288
                                        // Removed ADO
                                        // else if(ulADOIdStage > 0)
                                        // {
                                        // Ccmn46di.ulIdStage = ulADOIdStage;
                                        // COPYSZ(Ccmn46di.szCdTask, ADO_SVC_AUTH_TASK);
                                        // } end if ADO stage is populated
                                        else {
                                            CCMN46DI.setUlIdStage(ulTempIdStage);
                                            if (0 == szTempCdStage.compareTo(FPR_PROGRAM)) {
                                                CCMN46DI.setSzCdTask(FPR_SVC_AUTH_TASK);
                                            }
                                            else if (0 == szTempCdStage.compareTo(FSU_PROGRAM)) {
                                                CCMN46DI.setSzCdTask(FSU_SVC_AUTH_TASK);
                                            }
                                            else if (0 == szTempCdStage.compareTo(FRE_PROGRAM)) {
                                                
                                                CCMN46DI.setSzCdTask(FRE_SVC_AUTH_TASK);
                                            }
                                            else if (0 == szTempCdStage.compareTo(SUBCARE)) {
                                                CCMN46DI.setSzCdTask(SUB_SVC_AUTH_TASK);
                                            }
                                        }
                                        
                                        
                                        //  Analyze error code
                                        if (CCMN46DI.getUlIdStage() == 0) {
                                            
                                            //  CPS
                                            // Disposition & Corresponding Role:
                                            // Reason to Believe = DV
                                            // Unable To Determine = UD
                                            // Family Moved = UM
                                            // Ruled Out = NO
                                            // Administrative Closure = NO
                                            if (0 != CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getSzCdSvcAuthDtlSvc().compareTo(FORMER_DAY_CARE)) {
                                                return Messages.MSG_SVA_OPN_AUTHS;
                                            }
                                            else {
                                                break;
                                            }
                                        }
                                        CCMN46DI.setUlIdPerson(0);
                                        
                                        //  Call CSES11D
                                        rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                        CAUD34DI.setUlIdSvcAuthEvent(CCMN46DO.getUlIdEvent());
                                        CAUD34DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                        CAUD34DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                                        rc = Ccmn03u.CallCAUD34D(CAUD34DI, CAUD34DO, pServiceStatus);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                        CCMND2DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                                        CCMND2DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i69).getUlIdEvent());
                                        rc = Ccmn03u.CallCCMND2D(CCMND2DI, CCMND2DO, pServiceStatus);
                                        
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                        
                                        //  For each row retrieved from EventPersonLink we
                                        // need to make a copy of that with the new IdEvent
                                        for (n = 0;n < CCMND2DO.getArchOutputStruct().getUlRowQty();n++) {
                                            
                                            CCMN68DI.setArchInputStruct(pInputMsg63.getArchInputStruct());
                                            CCMN68DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                            CCMN68DI.setUlIdPerson(CCMND2DO.getROWCCMND2DO_ARRAY().getROWCCMND2DO(n).getUlIdPerson());
                                            CCMN68DI.setUlIdEvent(CCMN46DO.getUlIdEvent());
                                            
                                            //  Call CCMN44D
                                            rc = Ccmn01u.CallCCMN68D(CCMN68DI, CCMN68DO, pServiceStatus);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                return WtcHelperConstants.ARC_SUCCESS;
            }
            
            else {
                return WtcHelperConstants.ARC_SUCCESS;
            }
        }
        
        else {
            
            return WtcHelperConstants.ARC_SUCCESS;
        }
    }

    static int CallCCMN46D(CCMN46DI pInputMsg64, CCMN46DO pOutputMsg66, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
        pCCMN46DInputRec.setArchInputStruct(pInputMsg64.getArchInputStruct());
        pCCMN46DInputRec.setSzCdEventType(pInputMsg64.getSzCdEventType());
        pCCMN46DInputRec.setDtDtEventOccurred(pInputMsg64.getDtDtEventOccurred());
        pCCMN46DInputRec.setUlIdStage(pInputMsg64.getUlIdStage());
        pCCMN46DInputRec.setSzTxtEventDescr(pInputMsg64.getSzTxtEventDescr());
        pCCMN46DInputRec.setSzCdEventStatus(pInputMsg64.getSzCdEventStatus());
        if (0 != pInputMsg64.getSzCdTask().compareTo(EMPTY_STR)) {
            pCCMN46DInputRec.setSzCdTask(pInputMsg64.getSzCdTask());
        }
        pCCMN46DInputRec.setUlIdPerson(pInputMsg64.getUlIdPerson());
        
        /*
        ** Call DAM
        */
        rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
        
        
        /*
        ** Analyze return code
        ** LRB switch
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg66.setUlIdEvent(pCCMN46DOutputRec.getUlIdEvent());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNB8D(CCMN02UI pInputMsg65, CCMNB8DO pOutputMsg67, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        CCMNB8DI pCCMNB8DInputRec = null;
        CCMNB8DO pCCMNB8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB8DInputRec = new CCMNB8DI();
        
        pCCMNB8DOutputRec = new CCMNB8DO();
        pCCMNB8DInputRec.setArchInputStruct(pInputMsg65.getArchInputStruct());
        pCCMNB8DInputRec.setSzCdStage(pInputMsg65.getCCMN02UIG00().getSzCdStage());
        pCCMNB8DInputRec.setSzCdStageProgram(pInputMsg65.getCCMN02UIG00().getSzCdStageProgram());
        pCCMNB8DInputRec.setSzCdStageReasonClosed(pInputMsg65.getCCMN02UIG00().getSzCdStageReasonClosed());
        
        /*
        ** Call DAM
        */
        rc = ccmnb8dQUERYdam(sqlca, pCCMNB8DInputRec, pCCMNB8DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg67.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).setSzCdStageProgEventType(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgEventType());
                pOutputMsg67.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).setSzCdStageProgStatus(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgStatus());
                pOutputMsg67.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).setSzTxtStageProgEvntDesc(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzTxtStageProgEvntDesc());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINT21D(CCMN02UI pInputMsg66, CINT21DO pOutputMsg68, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setArchInputStruct(pInputMsg66.getArchInputStruct());
        pCINT21DInputRec.setUlIdStage(pInputMsg66.getCCMN02UIG00().getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg68.setSzCdStage(pCINT21DOutputRec.getSzCdStage());
                
                //## BEGIN TUX/XML: Declare XML variables
                pOutputMsg68.setSzCdStageClassification(pCINT21DOutputRec.getSzCdStageClassification());
                pOutputMsg68.setSzCdStageCnty(pCINT21DOutputRec.getSzCdStageCnty());
                pOutputMsg68.setSzCdStageCurrPriority(pCINT21DOutputRec.getSzCdStageCurrPriority());
                pOutputMsg68.setSzCdStageInitialPriority(pCINT21DOutputRec.getSzCdStageInitialPriority());
                pOutputMsg68.setSzCdStageProgram(pCINT21DOutputRec.getSzCdStageProgram());
                pOutputMsg68.setSzCdStageReasonClosed(pCINT21DOutputRec.getSzCdStageReasonClosed());
                pOutputMsg68.setSzCdStageRegion(pCINT21DOutputRec.getSzCdStageRegion());
                pOutputMsg68.setSzCdStageRsnPriorityChgd(pCINT21DOutputRec.getSzCdStageRsnPriorityChgd());
                pOutputMsg68.setSzCdStageType(pCINT21DOutputRec.getSzCdStageType());
                pOutputMsg68.setDtDtStageClose(pCINT21DOutputRec.getDtDtStageClose());
                pOutputMsg68.setDtDtStageStart(pCINT21DOutputRec.getDtDtStageStart());
                pOutputMsg68.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
                pOutputMsg68.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                pOutputMsg68.setUlIdStage(pCINT21DOutputRec.getUlIdStage());
                pOutputMsg68.setSzNmStage(pCINT21DOutputRec.getSzNmStage());
                pOutputMsg68.setUlIdUnit(pCINT21DOutputRec.getUlIdUnit());
                pOutputMsg68.setSzTxtStagePriorityCmnts(pCINT21DOutputRec.getSzTxtStagePriorityCmnts());
                
                pOutputMsg68.setSzTxtStageClosureCmnts(pCINT21DOutputRec.getSzTxtStageClosureCmnts());
                pOutputMsg68.setBIndStageClose(pCINT21DOutputRec.getBIndStageClose());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMND4D(CCMN02UI pInputMsg67, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMND4DI pCCMND4DInputRec = null;
        CCMND4DO pCCMND4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND4DInputRec = new CCMND4DI();
        
        pCCMND4DOutputRec = new CCMND4DO();
        pCCMND4DInputRec.setArchInputStruct(pInputMsg67.getArchInputStruct());
        pCCMND4DInputRec.setUlIdStage(pInputMsg67.getCCMN02UIG00().getUlIdStage());
        pCCMND4DInputRec.setSzCdStageReasonClosed(pInputMsg67.getCCMN02UIG00().getSzCdStageReasonClosed());
        rc = ARC_UTLGetDateAndTime(pCCMND4DInputRec.getDtDtStageClose() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Call DAM
        */
        rc = ccmnd4dAUDdam(sqlca, pCCMND4DInputRec, pCCMND4DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Call dam to retrieve people
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMNG2D(CCMN02UI pInputMsg68, CCMNG2DO pOutputMsg69, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMNG2DI pCCMNG2DInputRec = null;
        CCMNG2DO pCCMNG2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG2DInputRec = new CCMNG2DI();
        
        pCCMNG2DOutputRec = new CCMNG2DO();
        pCCMNG2DInputRec.setArchInputStruct(pInputMsg68.getArchInputStruct());
        pCCMNG2DInputRec.setUlIdStage(pInputMsg68.getCCMN02UIG00().getUlIdStage());
        rc = ccmng2dQUERYdam(sqlca, pCCMNG2DInputRec, pCCMNG2DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg69.setSzCdStagePersRelInt(pCCMNG2DOutputRec.getSzCdStagePersRelInt());
                pOutputMsg69.setSzCdStagePersRole(pCCMNG2DOutputRec.getSzCdStagePersRole());
                pOutputMsg69.setSzCdStagePersSearchInd(pCCMNG2DOutputRec.getSzCdStagePersSearchInd());
                pOutputMsg69.setSzCdStagePersType(pCCMNG2DOutputRec.getSzCdStagePersType());
                pOutputMsg69.setSzTxtStagePersNotes(pCCMNG2DOutputRec.getSzTxtStagePersNotes());
                
                pOutputMsg69.setUlIdPerson(pCCMNG2DOutputRec.getUlIdPerson());
                
                pOutputMsg69.setUlIdStagePerson(pCCMNG2DOutputRec.getUlIdStagePerson());
                pOutputMsg69.setBIndStagePersInLaw(pCCMNG2DOutputRec.getBIndStagePersInLaw());
                pOutputMsg69.setBIndStagePersReporter(pCCMNG2DOutputRec.getBIndStagePersReporter());
                pOutputMsg69.setBIndStagePersEmpNew(pCCMNG2DOutputRec.getBIndStagePersEmpNew());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pOutputMsg69.setUlIdStage(pCCMNG2DOutputRec.getUlIdStage());
                pOutputMsg69.setDtDtStagePersLink(pCCMNG2DOutputRec.getDtDtStagePersLink());
                pOutputMsg69.setTsLastUpdate(pCCMNG2DOutputRec.getTsLastUpdate());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMND3D(CCMND3DI pInputMsg69, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        CCMND3DI pCCMND3DInputRec = null;
        CCMND3DO pCCMND3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND3DInputRec = new CCMND3DI();
        
        pCCMND3DOutputRec = new CCMND3DO();
        pCCMND3DInputRec.setArchInputStruct(pInputMsg69.getArchInputStruct());
        pCCMND3DInputRec.setUlIdStage(pInputMsg69.getUlIdStage());
        
        if (pInputMsg69.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
            pCCMND3DInputRec.setSzCdStagePersRelInt(pInputMsg69.getSzCdStagePersRelInt());
            pCCMND3DInputRec.setSzCdStagePersRole(pInputMsg69.getSzCdStagePersRole());
            pCCMND3DInputRec.setSzCdStagePersSearchInd(pInputMsg69.getSzCdStagePersSearchInd());
            pCCMND3DInputRec.setSzCdStagePersType(pInputMsg69.getSzCdStagePersType());
            pCCMND3DInputRec.setSzTxtStagePersNotes(pInputMsg69.getSzTxtStagePersNotes());
            pCCMND3DInputRec.setUlIdPerson(pInputMsg69.getUlIdPerson());
            pCCMND3DInputRec.setUlIdStagePerson(pInputMsg69.getUlIdStagePerson());
            pCCMND3DInputRec.setBIndStagePersInLaw(pInputMsg69.getBIndStagePersInLaw());
            pCCMND3DInputRec.setBIndStagePersReporter(pInputMsg69.getBIndStagePersReporter());
            pCCMND3DInputRec.setBIndStagePersEmpNew(pInputMsg69.getBIndStagePersEmpNew());
            pCCMND3DInputRec.setDtDtStagePersLink(pInputMsg69.getDtDtStagePersLink());
            pCCMND3DInputRec.setTsLastUpdate(pInputMsg69.getTsLastUpdate());
        }
        rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
        
        if (pCCMND3DInputRec.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    // ARC_CBTLogMessage(CBT_ARCH, CBT_SEVERITY_ERROR, 1,
                    // szErrLogMsg);
                    // ARC_CBTLogMessage(CBT_ARCH, CBT_SEVERITY_ERROR, 1,
                    // pszSqrCmdToken);
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
            }
        }
        else if (pCCMND3DInputRec.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    // ARC_CBTLogMessage(CBT_ARCH, CBT_SEVERITY_ERROR, 1, szErrLogMsg);
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
            }
        }
        return rc;
    }

    static int CallCCMNF6D(CCMNF6DI pInputMsg70, CCMNF6DO pOutputMsg70, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i70 = 0;
        /*
        ** Declare local variables
        */
        
        CCMNF6DI pCCMNF6DInputRec = null;
        CCMNF6DO pCCMNF6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF6DInputRec = new CCMNF6DI();
        
        pCCMNF6DOutputRec = new CCMNF6DO();
        pCCMNF6DInputRec.setArchInputStruct(pInputMsg70.getArchInputStruct());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCCMNF6DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNF6DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNF6DO._CCMNF6DO__ROWCCMNF6DO_SIZE);
        pCCMNF6DInputRec.setUlIdCase(pInputMsg70.getUlIdCase());
        rc = ccmnf6dQUERYdam(sqlca, pCCMNF6DInputRec, pCCMNF6DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Copy the number of records retrieved to the output message
                //  SIR 3104
                // Added for loop to acutally look at the data returned
                
                for (i70 = 0;i70 < pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty();i70++) {
                    pOutputMsg70.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i70).setUlIdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i70).getUlIdStage());
                    pOutputMsg70.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i70).setSzCdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i70).getSzCdStage());
                }
                pOutputMsg70.getArchOutputStruct().setUlRowQty(pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pOutputMsg70.getArchOutputStruct().setUlRowQty(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINT24D(CINT24DI pInputMsg71, CINT24DO pOutputMsg71, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT24DI pCINT24DInputRec = null;
        CINT24DO pCINT24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT24DInputRec = new CINT24DI();
        
        pCINT24DOutputRec = new CINT24DO();
        pCINT24DInputRec.setArchInputStruct(pInputMsg71.getArchInputStruct());
        pCINT24DInputRec.setUlIdSituation(pInputMsg71.getUlIdSituation());
        rc = cint24dQUERYdam(sqlca, pCINT24DInputRec, pCINT24DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg71.setDtDtSituationOpened(pCINT24DOutputRec.getDtDtSituationOpened());
                pOutputMsg71.setDtDtSituationClosed(pCINT24DOutputRec.getDtDtSituationClosed());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINT13D(CINT13DI pInputMsg72, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        
        CINT13DI pCINT13DInputRec = null;
        CINT13DO pCINT13DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT13DInputRec = new CINT13DI();
        
        pCINT13DOutputRec = new CINT13DO();
        pCINT13DInputRec.setArchInputStruct(pInputMsg72.getArchInputStruct());
        pCINT13DInputRec.setUlIdSituation(pInputMsg72.getUlIdSituation());
        pCINT13DInputRec.setUlIdCase(pInputMsg72.getUlIdCase());
        pCINT13DInputRec.setDtDtSituationOpened(pInputMsg72.getDtDtSituationOpened());
        pCINT13DInputRec.setDtDtSituationClosed(pInputMsg72.getDtDtSituationClosed());
        rc = cint13dAUDdam(sqlca, pCINT13DInputRec, pCINT13DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNC5D(CCMNC5DI pInputMsg73, CCMNC5DO pOutputMsg72, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMNC5DInputRec.setArchInputStruct(pInputMsg73.getArchInputStruct());
        
        pCCMNC5DInputRec.setUlIdCase(pInputMsg73.getUlIdCase());
        rc = ccmnc5dQUERYdam(sqlca, pCCMNC5DInputRec, pCCMNC5DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                // 
                // Function Prototypes
                // 
                pOutputMsg72.setSzCdCaseCounty(pCCMNC5DOutputRec.getSzCdCaseCounty());
                pOutputMsg72.setSzCdCaseProgram(pCCMNC5DOutputRec.getSzCdCaseProgram());
                pOutputMsg72.setSzCdCaseRegion(pCCMNC5DOutputRec.getSzCdCaseRegion());
                
                pOutputMsg72.setSzCdCaseSpeclHndlg(pCCMNC5DOutputRec.getSzCdCaseSpeclHndlg());
                pOutputMsg72.setDtDtCaseClosed(pCCMNC5DOutputRec.getDtDtCaseClosed());
                pOutputMsg72.setDtDtCaseOpened(pCCMNC5DOutputRec.getDtDtCaseOpened());
                
                pOutputMsg72.setUlIdCase(pCCMNC5DOutputRec.getUlIdCase());
                pOutputMsg72.setBIndCaseArchived(pCCMNC5DOutputRec.getBIndCaseArchived());
                pOutputMsg72.setBIndCaseSensitive(pCCMNC5DOutputRec.getBIndCaseSensitive());
                
                pOutputMsg72.setBIndCaseWorkerSafety(pCCMNC5DOutputRec.getBIndCaseWorkerSafety());
                pOutputMsg72.setSzNmCase(pCCMNC5DOutputRec.getSzNmCase());
                pOutputMsg72.setSzTxtCaseSensitiveCmnts(pCCMNC5DOutputRec.getSzTxtCaseSensitiveCmnts());
                
                pOutputMsg72.setSzTxtCaseWorkerSafety(pCCMNC5DOutputRec.getSzTxtCaseWorkerSafety());
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                
                //  Start performance timer for service
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNC6D(CCMNC6DI pInputMsg74, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        
        CCMNC6DI pCCMNC6DInputRec = null;
        CCMNC6DO pCCMNC6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC6DInputRec = new CCMNC6DI();
        
        pCCMNC6DOutputRec = new CCMNC6DO();
        pCCMNC6DInputRec.setArchInputStruct(pInputMsg74.getArchInputStruct());
        pCCMNC6DInputRec.setSzCdCaseCounty(pInputMsg74.getSzCdCaseCounty());
        pCCMNC6DInputRec.setSzCdCaseProgram(pInputMsg74.getSzCdCaseProgram());
        pCCMNC6DInputRec.setSzCdCaseRegion(pInputMsg74.getSzCdCaseRegion());
        pCCMNC6DInputRec.setSzCdCaseSpeclHndlg(pInputMsg74.getSzCdCaseSpeclHndlg());
        pCCMNC6DInputRec.setSzNmCase(pInputMsg74.getSzNmCase());
        pCCMNC6DInputRec.setSzTxtCaseSensitiveCmnts(pInputMsg74.getSzTxtCaseSensitiveCmnts());
        pCCMNC6DInputRec.setSzTxtCaseWorkerSafety(pInputMsg74.getSzTxtCaseWorkerSafety());
        pCCMNC6DInputRec.setUlIdCase(pInputMsg74.getUlIdCase());
        pCCMNC6DInputRec.setDtDtCaseOpened(pInputMsg74.getDtDtCaseOpened());
        pCCMNC6DInputRec.setBIndCaseArchived(pInputMsg74.getBIndCaseArchived());
        pCCMNC6DInputRec.setBIndCaseSensitive(pInputMsg74.getBIndCaseSensitive());
        pCCMNC6DInputRec.setBIndCaseWorkerSafety(pInputMsg74.getBIndCaseWorkerSafety());
        
        /*
        ** for the Service Auth event, search the
        ** SVC_AUTH_EVENT_LINK table to get the
        ** corresponding SvcAuthDtlTermDate
        */
        rc = ARC_UTLGetDateAndTime(pCCMNC6DInputRec.getDtDtCaseClosed() , 0);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        rc = ccmnc6dAUDdam(sqlca, pCCMNC6DInputRec, pCCMNC6DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  search SVC_AUTH_DETAIL table to retrieve
                // the SvcAuthDtlTermDate
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMND1D(CCMND1DI pInputMsg75, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code     */
        
        /*
        ** Declare local variables
        */
        
        CCMND1DI pCCMND1DInputRec = null;
        CCMND1DO pCCMND1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND1DInputRec = new CCMND1DI();
        
        pCCMND1DOutputRec = new CCMND1DO();
        pCCMND1DInputRec.setArchInputStruct(pInputMsg75.getArchInputStruct());
        
        
        /**************************************************************************
        ** Service Macro Definitions
        ***************************************************************************/
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        
        pCCMND1DInputRec.setUlIdCase(pInputMsg75.getUlIdCase());
        /* create to do for supervisor */
        rc = ccmnd1dAUDdam(sqlca, pCCMND1DInputRec, pCCMND1DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMNC9D(CCMN02UI pInputMsg76, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        CCMNC9DI pCCMNC9DInputRec = null;
        CCMNC9DO pCCMNC9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC9DInputRec = new CCMNC9DI();
        
        pCCMNC9DOutputRec = new CCMNC9DO();
        pCCMNC9DInputRec.setArchInputStruct(pInputMsg76.getArchInputStruct());
        pCCMNC9DInputRec.setUlIdStage(pInputMsg76.getCCMN02UIG00().getUlIdStage());
        rc = ccmnc9dAUDdam(sqlca, pCCMNC9DInputRec, pCCMNC9DOutputRec);
        /*
        ** SIR 3204 
        ** Added if test above, only needed when progressing from Intake
        ** rc is initialized to ARC_SUCCESS above
        */
        switch (rc) {
            case NO_DATA_FOUND:
                
                
                
                //  Start Performance Timer
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNB9D(CCMN02UI pInputMsg77, CCMNB9DO pOutputMsg73, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i71 = 0;
        /*
        ** Declare local variables
        */
        CCMNB9DI pCCMNB9DInputRec = null;
        CCMNB9DO pCCMNB9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB9DInputRec = new CCMNB9DI();
        pCCMNB9DOutputRec = new CCMNB9DO();
        if (pCCMNB9DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        if (pCCMNB9DOutputRec == null) {
            
            //  The PROCESS_TUX_RC_ERROR macro after the call to DAM CCMN32D handles
            // 2 cases - 1) the user does not have access and 2) the database
            // had a fatal error.  So, the user has access to the Unit since
            // either the bIsApprover flag is TRUE or DAM CCMN32D returned
            // FND_SUCCESS.
            // The user has access to the Unit, so get Unit Summary
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCCMNB9DInputRec.setArchInputStruct(pInputMsg77.getArchInputStruct());
        pCCMNB9DInputRec.setUlIdStage(pInputMsg77.getCCMN02UIG00().getUlIdStage());
        
        rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i71 = 0;i71 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();++i71) {
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setSzCdStagePersRelInt(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getSzCdStagePersRelInt());
                    
                    
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setSzCdStagePersRole(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getSzCdStagePersRole());
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setSzCdStagePersSearchInd(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getSzCdStagePersSearchInd());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setSzCdStagePersType(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getSzCdStagePersType());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setSzTxtStagePersNotes(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getSzTxtStagePersNotes());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setUlIdPerson(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getUlIdPerson());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setUlIdStagePerson(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getUlIdStagePerson());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setBIndStagePersInLaw(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getBIndStagePersInLaw());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setBIndStagePersReporter(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getBIndStagePersReporter());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setBIndStagePersEmpNew(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getBIndStagePersEmpNew());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setUlIdStage(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getUlIdStage());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setDtDtStagePersLink(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getDtDtStagePersLink());
                    pOutputMsg73.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).setTsLastUpdate(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i71).getTsLastUpdate());
                }
                pOutputMsg73.getArchOutputStruct().setUlRowQty(pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg73.getArchOutputStruct().setBMoreDataInd(pCCMNB9DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN87D(CCMN87DI pInputMsg78, CCMN87DO pOutputMsg74, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i72 = 0;
        int rc = 0;
        
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg78.getArchInputStruct());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
        pCCMN87DInputRec.setUlIdStage(pInputMsg78.getUlIdStage());
        pCCMN87DInputRec.setSzCdTask(pInputMsg78.getSzCdTask());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SERVICE_AUTH_TYPE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                for (i72 = 0;i72 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();++i72) {
                    pOutputMsg74.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).getUlIdEvent());
                    pOutputMsg74.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).setSzCdEventType(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).getSzCdEventType());
                    pOutputMsg74.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).setSzCdTask(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).getSzCdTask());
                    pOutputMsg74.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).setSzTxtEventDescr(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).getSzTxtEventDescr());
                    pOutputMsg74.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).setDtDtEventOccurred(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).getDtDtEventOccurred());
                    pOutputMsg74.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i72).getSzCdEventStatus());
                }
                pOutputMsg74.getArchOutputStruct().setUlRowQty(pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg74.getArchOutputStruct().setBMoreDataInd(pCCMN87DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                // 
                // End Call to Stage Person Link Dam - CSEC51D
                // 
                
                break;
                
            case NO_DATA_FOUND:
                pOutputMsg74.getArchOutputStruct().setUlRowQty(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                // 
                // End Call to Most Recent Acutal Discharge Dam - CCMN44D
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSES23D(CSES23DI pInputMsg79, CSES23DO pOutputMsg75, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES23DInputRec = new CSES23DI();
        
        pCSES23DOutputRec = new CSES23DO();
        pCSES23DInputRec.setArchInputStruct(pInputMsg79.getArchInputStruct());
        pCSES23DInputRec.setUlIdSvcAuth(pInputMsg79.getUlIdSvcAuth());
        
        /*
        ** Call CAUD58D
        */
        rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg75.setCIndSvcAuthComplete(pCSES23DOutputRec.getCIndSvcAuthComplete());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSES24D(CSES24DI pInputMsg80, CSES24DO pOutputMsg76, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
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
        pCSES24DInputRec.setArchInputStruct(pInputMsg80.getArchInputStruct());
        pCSES24DInputRec.setUlIdSvcAuthEvent(pInputMsg80.getUlIdSvcAuthEvent());
        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg76.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                
                //  Get the current date and store it in dtCurrentDate
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCLSS24D(CLSS24DI pInputMsg81, CLSS24DO pOutputMsg77, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i73 = 0;
        /*
        ** Declare local variables
        */
        CLSS24DI pCLSS24DInputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS24DInputRec = new CLSS24DI();
        
        pCLSS24DOutputRec = new CLSS24DO();
        pCLSS24DInputRec.setArchInputStruct(pInputMsg81.getArchInputStruct());
        pCLSS24DInputRec.setUlIdSvcAuth(pInputMsg81.getUlIdSvcAuth());
        
        /*
        ** Add 100 years to todays date
        */
        rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg77.getArchOutputStruct().setUlRowQty(pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i73 = 0;i73 < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();++i73) {
                    pOutputMsg77.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i73).setDtDtSvcAuthDtlTerm(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i73).getDtDtSvcAuthDtlTerm());
                    pOutputMsg77.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i73).setSzCdSvcAuthDtlSvc(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i73).getSzCdSvcAuthDtlSvc());
                }
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCAUD34D(CAUD34DI pInputMsg82, CAUD34DO * pOutputMsg78, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CAUD34DI pCAUD34DInputRec = null;
        CAUD34DO pCAUD34DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD34DInputRec = new CAUD34DI();
        
        pCAUD34DOutputRec = new CAUD34DO();
        
        //## BEGIN TUX/XML: Declare XML variables
        pCAUD34DInputRec.setArchInputStruct(pInputMsg82.getArchInputStruct());
        pCAUD34DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCAUD34DInputRec.setUlIdSvcAuth(pInputMsg82.getUlIdSvcAuth());
        pCAUD34DInputRec.setUlIdSvcAuthEvent(pInputMsg82.getUlIdSvcAuthEvent());
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = caud34dAUDdam(sqlca, pCAUD34DInputRec, pCAUD34DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMND2D(CCMND2DI pInputMsg83, CCMND2DO pOutputMsg79, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i74 = 0;
        /*
        ** Declare local variables
        */
        CCMND2DI pCCMND2DInputRec = null;
        CCMND2DO pCCMND2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND2DInputRec = new CCMND2DI();
        
        pCCMND2DOutputRec = new CCMND2DO();
        
        pCCMND2DInputRec.setArchInputStruct(pInputMsg83.getArchInputStruct());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCCMND2DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMND2DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMND2DO._CCMND2DO__ROWCCMND2DO_SIZE);
        pCCMND2DInputRec.setUlIdEvent(pInputMsg83.getUlIdEvent());
        rc = ccmnd2dQUERYdam(sqlca, pCCMND2DInputRec, pCCMND2DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg79.getArchOutputStruct().setUlRowQty(pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i74 = 0;i74 < pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty();++i74) {
                    pOutputMsg79.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i74).setUlIdPerson(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i74).getUlIdPerson());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN68D(CCMN68DI pInputMsg84, CCMN68DO * pOutputMsg80, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN68DI pCCMN68DInputRec = null;
        CCMN68DO pCCMN68DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN68DInputRec = new CCMN68DI();
        
        pCCMN68DOutputRec = new CCMN68DO();
        
        pCCMN68DInputRec.setArchInputStruct(pInputMsg84.getArchInputStruct());
        pCCMN68DInputRec.setUlIdEvent(pInputMsg84.getUlIdEvent());
        pCCMN68DInputRec.setUlIdPerson(pInputMsg84.getUlIdPerson());
        
        /*
        ** Call DAM
        */
        rc = ccmn68dAUDdam(sqlca, pCCMN68DInputRec, pCCMN68DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCLSC73D(CLSC73DI pInputMsg85, CLSC73DO pOutputMsg81, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code  */
        int i75 = 0;
        /*
        ** Declare local variables
        */
        CLSC73DI pCLSC73DInputRec = null;
        CLSC73DO pCLSC73DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC73DInputRec = new CLSC73DI();
        pCLSC73DOutputRec = new CLSC73DO();
        if (pCLSC73DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        if (pCLSC73DOutputRec == null) {
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCLSC73DInputRec.setArchInputStruct(pInputMsg85.getArchInputStruct());
        
        pCLSC73DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC73DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC73DO._CLSC73DO__ROWCLSC73DO_SIZE);
        pCLSC73DInputRec.setUlIdSvcAuth(pInputMsg85.getUlIdSvcAuth());
        rc = clsc73dQUERYdam(sqlca, pCLSC73DInputRec, pCLSC73DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i75 = 0;i75 < pCLSC73DOutputRec.getArchOutputStruct().getUlRowQty();++i75) {
                    
                    
                    // SIR 3625
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setSzCdStage(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getSzCdStage());
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setSzCdEventType(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getSzCdEventType());
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setUlIdStage(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getUlIdStage());
                    
                    
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setUlIdEvent(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getUlIdEvent());
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setDtDtStageClose(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getDtDtStageClose());
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setSzCdEventStatus(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getSzCdEventStatus());
                    
                    //  SIR 20076
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setSzCdTask(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getSzCdTask());
                    pOutputMsg81.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).setUlIdSvcAuth(pCLSC73DOutputRec.getROWCLSC73DO_ARRAY().getROWCLSC73DO(i75).getUlIdSvcAuth());
                }
                pOutputMsg81.getArchOutputStruct().setUlRowQty(pCLSC73DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                //  SIR 21336
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMN69D(CCMN69DI pInputMsg86, CCMN69DO pOutputMsg82, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN69DI pCCMN69DInputRec = null;
        CCMN69DO pCCMN69DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN69DInputRec = new CCMN69DI();
        
        pCCMN69DOutputRec = new CCMN69DO();
        pCCMN69DInputRec.setArchInputStruct(pInputMsg86.getArchInputStruct());
        pCCMN69DInputRec.setUlIdPerson(pInputMsg86.getUlIdPerson());
        
        /* Promote related Events */
        rc = ccmn69dQUERYdam(sqlca, pCCMN69DInputRec, pCCMN69DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg82.setUlIdOffice(pCCMN69DOutputRec.getUlIdOffice());
                
                // Delete the Todo
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCFC51U(CCFC51UI pInputMsg87, CCFC51UO * pOutputMsg83, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCFC51UI pCCFC51UInputRec = null;
        CCFC51UO pCCFC51UOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCFC51UInputRec = new CCFC51UI();
        
        pCCFC51UOutputRec = new CCFC51UO();
        pCCFC51UInputRec.setArchInputStruct(pInputMsg87.getArchInputStruct());
        
        /* ochumd  Sir 23810 Begin */
        pCCFC51UInputRec.setUlIdCase(pInputMsg87.getUlIdCase());
        pCCFC51UInputRec.setCIndRuloutOrAdm(pInputMsg87.getCIndRuloutOrAdm());
        
        
        /*
        ** Call CSUB40U
        */
        rc = Ccfc51u.RecordsRetention(pCCFC51UInputRec, pCCFC51UOutputRec, pServiceStatus);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Set rc to SQL_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSES57D(CSES57DI pInputMsg88, CSES57DO pOutputMsg84, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSES57DI pCSES57DInputRec = null;
        CSES57DO pCSES57DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES57DInputRec = new CSES57DI();
        
        pCSES57DOutputRec = new CSES57DO();
        pCSES57DInputRec.setArchInputStruct(pInputMsg88.getArchInputStruct());
        pCSES57DInputRec.setUlIdCase(pInputMsg88.getUlIdCase());
        rc = cses57dQUERYdam(sqlca, pCSES57DInputRec, pCSES57DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg84.setUlIdCase(pCSES57DOutputRec.getUlIdCase());
                pOutputMsg84.setTsLastUpdate(pCSES57DOutputRec.getTsLastUpdate());
                pOutputMsg84.setSztxtCaseFileLocateInfo(pCSES57DOutputRec.getSztxtCaseFileLocateInfo());
                pOutputMsg84.setUlIdOffice(pCSES57DOutputRec.getUlIdOffice());
                pOutputMsg84.setUlIdUnit(pCSES57DOutputRec.getUlIdUnit());
                pOutputMsg84.setSzAddrCaseFileCity(pCSES57DOutputRec.getSzAddrCaseFileCity());
                pOutputMsg84.setSzAddrCaseFileStLn1(pCSES57DOutputRec.getSzAddrCaseFileStLn1());
                pOutputMsg84.setSzAddrCaseFileStLn2(pCSES57DOutputRec.getSzAddrCaseFileStLn2());
                pOutputMsg84.setSzCdCaseFileOfficeType(pCSES57DOutputRec.getSzCdCaseFileOfficeType());
                pOutputMsg84.setDtDtCaseFileArchCompl(pCSES57DOutputRec.getDtDtCaseFileArchCompl());
                pOutputMsg84.setTmScrTmGeneric1(pCSES57DOutputRec.getTmScrTmGeneric1());
                pOutputMsg84.setDtDtCaseFileArchElig(pCSES57DOutputRec.getDtDtCaseFileArchElig());
                pOutputMsg84.setTmScrTmGeneric2(pCSES57DOutputRec.getTmScrTmGeneric2());
                pOutputMsg84.setSzNmCaseFileOffice(pCSES57DOutputRec.getSzNmCaseFileOffice());
                rc = WtcHelperConstants.SQL_SUCCESS;
                
                break;
                
            case (NO_DATA_FOUND):
                
                //  Call DAM
                rc = NO_DATA_FOUND;
                
                break;
            default :
                
                
                //  Increment contract counter
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCAUD76D(CAUD76DI pInputMsg89, CAUD76DO * pOutputMsg85, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CAUD76DI pCAUD76DInputRec = null;
        CAUD76DO pCAUD76DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD76DInputRec = new CAUD76DI();
        
        pCAUD76DOutputRec = new CAUD76DO();
        pCAUD76DInputRec.setArchInputStruct(pInputMsg89.getArchInputStruct());
        
        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == pCAUD76DInputRec.getArchInputStruct().getCReqFuncCd()) {
            pCAUD76DInputRec.setTsLastUpdate(pInputMsg89.getTsLastUpdate());
            pCAUD76DInputRec.setSztxtCaseFileLocateInfo(pInputMsg89.getSztxtCaseFileLocateInfo());
        }
        pCAUD76DInputRec.setUlIdUnit(pInputMsg89.getUlIdUnit());
        pCAUD76DInputRec.setUlIdOffice(pInputMsg89.getUlIdOffice());
        pCAUD76DInputRec.setUlIdCase(pInputMsg89.getUlIdCase());
        pCAUD76DInputRec.setSzCdCaseFileOfficeType(pInputMsg89.getSzCdCaseFileOfficeType());
        pCAUD76DInputRec.getDtDtCaseFileArchCompl().day = NULL_DATE;
        pCAUD76DInputRec.getDtDtCaseFileArchCompl().month = NULL_DATE;
        pCAUD76DInputRec.getDtDtCaseFileArchCompl().year = NULL_DATE;
        pCAUD76DInputRec.getDtDtCaseFileArchElig().day = NULL_DATE;
        pCAUD76DInputRec.getDtDtCaseFileArchElig().month = NULL_DATE;
        pCAUD76DInputRec.getDtDtCaseFileArchElig().year = NULL_DATE;
        rc = caud76dAUDdam(sqlca, pCAUD76DInputRec, pCAUD76DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV33D(CINV33DI pInputMsg90, CINV33DO pOutputMsg86, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i76 = 0;
        
        /*
        ** Declare local variables
        */
        CINV33DI pCINV33DInputRec = null;
        CINV33DO pCINV33DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV33DInputRec = new CINV33DI();
        
        pCINV33DOutputRec = new CINV33DO();
        pCINV33DInputRec.setUlIdPerson(pInputMsg90.getUlIdPerson());
        pCINV33DInputRec.setSzCdStageProgram(pInputMsg90.getSzCdStageProgram());
        pCINV33DInputRec.setArchInputStruct(pInputMsg90.getArchInputStruct());
        pCINV33DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINV33DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV33DO._CINV33DO__ROWCINV33DO_SIZE);
        rc = cinv33dQUERYdam(sqlca, pCINV33DInputRec, pCINV33DOutputRec);
        if (rc != 0) {
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pOutputMsg86.getArchOutputStruct().setUlRowQty(0);
                    rc = 0;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
            }
        }
        
        else {
            
            //  Populate Output Message
            for (i76 = 0;i76 < pCINV33DOutputRec.getArchOutputStruct().getUlRowQty();++i76) {
                pOutputMsg86.getROWCINV33DO_ARRAY().getROWCINV33DO(i76).setUlIdCase(pCINV33DOutputRec.getROWCINV33DO_ARRAY().getROWCINV33DO(i76).getUlIdCase());
                pOutputMsg86.getROWCINV33DO_ARRAY().getROWCINV33DO(i76).setUlIdStage(pCINV33DOutputRec.getROWCINV33DO_ARRAY().getROWCINV33DO(i76).getUlIdStage());
                pOutputMsg86.getROWCINV33DO_ARRAY().getROWCINV33DO(i76).setSzCdStageProgram(pCINV33DOutputRec.getROWCINV33DO_ARRAY().getROWCINV33DO(i76).getSzCdStageProgram());
            };
            pOutputMsg86.getArchOutputStruct().setUlRowQty(pCINV33DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg86.getArchOutputStruct().setBMoreDataInd(pCINV33DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCAUD74D(CAUD74DI pInputMsg91, CAUD74DO * pOutputMsg87, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CAUD74DI pCAUD74DInputRec = null;
        CAUD74DO pCAUD74DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD74DInputRec = new CAUD74DI();
        
        pCAUD74DOutputRec = new CAUD74DO();
        pCAUD74DInputRec.setArchInputStruct(pInputMsg91.getArchInputStruct());
        pCAUD74DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD74DInputRec.setUlIdPerson(pInputMsg91.getUlIdPerson());
        pCAUD74DInputRec.setCdPersonStatus(pInputMsg91.getCdPersonStatus());
        rc = caud74dAUDdam(sqlca, pCAUD74DInputRec, pCAUD74DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCLSS30D(CLSS30DI pInputMsg92, CLSS30DO pOutputMsg88, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i77 = 0;
        
        /*
        ** Declare local variables
        */
        CLSS30DI pCLSS30DInputRec = null;
        CLSS30DO pCLSS30DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS30DInputRec = new CLSS30DI();
        
        pCLSS30DOutputRec = new CLSS30DO();
        pCLSS30DInputRec.setUlIdCase(pInputMsg92.getUlIdCase());
        pCLSS30DInputRec.setArchInputStruct(pInputMsg92.getArchInputStruct());
        pCLSS30DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSS30DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS30DO._CLSS30DO__ROWCLSS30DO_SIZE);
        rc = clss30dQUERYdam(sqlca, pCLSS30DInputRec, pCLSS30DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                for (i77 = 0;i77 < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty();++i77) {
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setUlIdStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getUlIdStage());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStageType(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStageType());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setTsLastUpdate(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getTsLastUpdate());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setUlIdUnit(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getUlIdUnit());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setUlIdCase(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getUlIdCase());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setDtDtStageClose(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getDtDtStageClose());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStageClassification(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStageClassification());
                    
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStageCurrPriority(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStageCurrPriority());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStageReasonClosed(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStageReasonClosed());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStageCnty(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStageCnty());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzNmStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzNmStage());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStageRegion(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStageRegion());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setDtDtStageStart(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getDtDtStageStart());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setUlIdSituation(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getUlIdSituation());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStageProgram(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStageProgram());
                    pOutputMsg88.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).setSzCdStage(pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i77).getSzCdStage());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                pOutputMsg88.getArchOutputStruct().setUlRowQty(pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty());
                
                pOutputMsg88.getArchOutputStruct().setBMoreDataInd(pCLSS30DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCSEC29D(CSEC29DI pInputMsg93, CSEC29DO pOutputMsg89, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i78 = 0;
        
        /*
        ** Declare local variables
        */
        CSEC29DI pCSEC29DInputRec = null;
        CSEC29DO pCSEC29DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC29DInputRec = new CSEC29DI();
        
        pCSEC29DOutputRec = new CSEC29DO();
        pCSEC29DInputRec.setUlIdPerson(pInputMsg93.getUlIdPerson());
        pCSEC29DInputRec.setArchInputStruct(pInputMsg93.getArchInputStruct());
        pCSEC29DInputRec.setUlIdPerson(pInputMsg93.getUlIdPerson());
        pCSEC29DInputRec.setUlIdCase(pInputMsg93.getUlIdCase());
        pCSEC29DInputRec.setSzCdStagePersRole(pInputMsg93.getSzCdStagePersRole());
        pCSEC29DInputRec.setSzCdStage(pInputMsg93.getSzCdStage());
        rc = csec29dQUERYdam(sqlca, pCSEC29DInputRec, pCSEC29DOutputRec);
        
        
        /* Analyze error code */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg89.setUlIdStage(pCSEC29DOutputRec.getUlIdStage());
                pOutputMsg89.setSzCdStage(pCSEC29DOutputRec.getSzCdStage());
                pOutputMsg89.setDtDtStageStart(pCSEC29DOutputRec.getDtDtStageStart());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                
                // 
                // Service Macro Definitions
                // 
                
                // 
                // Function Prototypes
                // 
                pOutputMsg89.getArchOutputStruct().setUlRowQty(pCSEC29DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg89.getArchOutputStruct().setBMoreDataInd(pCSEC29DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCSES63D(CCMN02UI pInputMsg94, CSES63DO pOutputMsg90, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i79 = 0;
        int j = 0;
        
        /*
        ** Declare local variables
        */
        CSES63DI pCSES63DInputRec = null;
        CSES63DO pCSES63DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structure
        */
        
        pCSES63DInputRec = new CSES63DI();
        
        pCSES63DOutputRec = new CSES63DO();
        pCSES63DInputRec.setUlIdStage(pInputMsg94.getCCMN02UIG00().getUlIdStage());
        pCSES63DInputRec.setArchInputStruct(pInputMsg94.getArchInputStruct());
        rc = cses63dQUERYdam(sqlca, pCSES63DInputRec, pCSES63DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg90.setUlIdStageRelated(pCSES63DOutputRec.getUlIdStageRelated());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV95D(CINV95DI pInputMsg95, CINV95DO pOutputMsg91, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i80 = 0;
        
        /*
        ** Declare local variables
        */
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV95DInputRec = new CINV95DI();
        
        pCINV95DOutputRec = new CINV95DO();
        pCINV95DInputRec.setArchInputStruct(pInputMsg95.getArchInputStruct());
        pCINV95DInputRec.setUlIdStage(pInputMsg95.getUlIdStage());
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg91.setCdCpsOverallDisptn(pCINV95DOutputRec.getCdCpsOverallDisptn());
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    
    static int CallCSECA4D(CSECA4DI pInputMsg96, CSECA4DO pOutputMsg92, String pbEA_Open_Found, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSECA4DI pCSECA4DInputRec = null;
        CSECA4DO pCSECA4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA4DInputRec = new CSECA4DI();
        pCSECA4DOutputRec = new CSECA4DO();
        
        if (pCSECA4DInputRec == null) {
            
            //  Populate Input Structure for DAM
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        if (pCSECA4DOutputRec == null) {
            
            //  Call DAM: perfroms a full row retrieval based on
            // a given period, county,service code and resource
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCSECA4DInputRec.setArchInputStruct(pInputMsg96.getArchInputStruct());
        pCSECA4DInputRec.setUlIdPersEligPerson(pInputMsg96.getUlIdPersEligPerson());
        pCSECA4DInputRec.setSzCdPersEligType(pInputMsg96.getSzCdPersEligType());
        rc = cseca4dQUERYdam(sqlca, pCSECA4DInputRec, pCSECA4DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg92.setUlIdPersElig(pCSECA4DOutputRec.getUlIdPersElig());
                pOutputMsg92.setDtDtPersEligStart(pCSECA4DOutputRec.getDtDtPersEligStart());
                
                pOutputMsg92.setCdPersEligPrgOpen(pCSECA4DOutputRec.getCdPersEligPrgOpen());
                // 
                // Function Prototypes
                // 
                pOutputMsg92.setCdPersEligPrgClose(pCSECA4DOutputRec.getCdPersEligPrgClose());
                pbEA_Open_Found = CStringUtils.setCharAt(pbEA_Open_Found, 0, true);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                //##        return (FND_SUCCESS);
        }
        return rc;
    }

    static int CallCAUDC9D(CAUDC9DI pInputMsg97, CAUDC9DO * pOutputMsg93, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
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
        
        //SIR#17445 05/12/03 Srini: Following deviates from the general procedure as this service is called
        // by another service and it can also be called directly.
        //	TUX_CHECK_APPL_STATUS
        if (pCAUDC9DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        //Commit only if we began the transaction in this service
        if (pCAUDC9DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCAUDC9DInputRec.setArchInputStruct(pInputMsg97.getArchInputStruct());
        /* Process utility fuction failure */
        pCAUDC9DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg97.getArchInputStruct().getCReqFuncCd());
        pCAUDC9DInputRec.setCdPersEligPrgOpen(pInputMsg97.getCdPersEligPrgOpen());
        pCAUDC9DInputRec.setCdPersEligPrgClose(pInputMsg97.getCdPersEligPrgClose());
        pCAUDC9DInputRec.setUlIdPersElig(pInputMsg97.getUlIdPersElig());
        pCAUDC9DInputRec.setDtDtPersEligEaDeny(pInputMsg97.getDtDtPersEligEaDeny());
        pCAUDC9DInputRec.setDtDtPersEligEnd(pInputMsg97.getDtDtPersEligEnd());
        rc = caudc9dAUDdam(sqlca, pCAUDC9DInputRec, pCAUDC9DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

}
