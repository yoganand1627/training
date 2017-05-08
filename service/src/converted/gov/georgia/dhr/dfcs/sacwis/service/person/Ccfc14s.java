package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD69DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD71DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD82DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD83DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD83DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC83DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC83DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC83DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC83DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV75DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC86DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC86DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDD3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDD3DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD88DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD88DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV31DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV31DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN96DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN96DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD78DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD78DO;
/**************************************************************************
**
** Module File:   ccfc14s.src
**
** Service Name:  CCFC14S
**
** Description:   This service will update functional tables, event tables
**                and the Person Merge Split table for either a Split or a
**                Merge.  If the service performs a split, only the Person
**                Merge/Split, the Category and Person tables are updated to
**                reflect the split.  If the function is Merge, various
**                functional tables, the Stage Person Link, and the Event
**                Person Link tables are updated to replace the Id Person of
**                the Merge Forward for all open stages.  In addition the
**                Category and Person (status fields) are updated to reflect
**                the merge.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/10/96
**
** Programmer:    Timothy R. Overend
**
** Archive Information: $Revision:   1.7  $
**                      $Date:   24 Jul 2002 10:51:30  $
**                      $Modtime:   24 Jul 2002 10:51:28  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/20/96  ELLIOTSL  SIR #3872: The CdStage that corresponds to a person
**                      with a category of "FAH" is "FAD", not "FAH".
**  04/15/96  OMARAJJ   SIR#4251 - Due to changes in the FAHome dialog, the
**                      category checkmarks should only be updated if the
**                      Person Forward/Person Merge is Associated with an
**                      FA Home stage and is a Principal/Colleral in that
**                      stage.
**  12/14/96  odonnerj  SIR# 11504 - Moved CAUD73D stage_person_link UPDATE
**                      out of SQL_NOT_FOUND for CAUD72D and set it up
**                      independently after CAUD72D. After deleting duplicate
**                      stage person link rows, this Dam WOULD NOT HAVE BEEN
**                      CALLED and the closed person id was left on open
**                      stage person link rows causing errors.
**  01/20/97  odonnerj  SIR# 11504 - Add Person Merge Remove Duplicate Allegation Function
**                      Description - this will retrieve all duped
**                      allegations and determine which one should be deleted.
**                      (INV deleted before INT when different cd_stage, and
**                      newest INT or INV deleted when same cd_stage). It
**                      also sets the disposition for the remaining allegation
**                      to NULL to require the user to re-determine the
**                      disposition since normally the disposition of
**                      one of the allegations have been reset to R/O or UTD.
**
**  01/27/97  gonzalce  SIR# 12838 - Comment out all of the dams which delete
**                      or update rows in the stage_person_link table.  Also,
**                      added three dams:  CLSC83D, CLSS74D, AND CAUDC5D which
**                      retrieve id_stages for duplicate rows in the stage
**                      person link table due to person merges and delete one
**                      of the duplicate rows. Also check to see that the
**                      remaining row is set to person_merge_forward, and if
**                      not update it.
**
**  02/07/97  odonnerj  SIR# 12838/11504 - Changed the error handling for
**                      the original code as well as for SIR 12838.  Also
**                      inserted all code inside if(FND_SUCCESS == rc)
**                      sections to ensure proper error handling.  The
**                      original code had several dams outside of the
**                      error handling which could commit changes
**                      when only FND_WARNING was returned to the
**                      window.  Moved CAUD73D to the end of the update section
**                      to ensure that it was called every time person_merge
**                      was ran and also to ensure that it would not run
**                      if one of the previous dams returned FND_FAIL.
**
**  05/02/97  hendercr  SIR# 13636 - Dams CLSS74D and CAUDC5D have been
**                      modified to reference the CD_STAGE_PERS_TYPE field, so
**                      that if the person closed in the person merge has a
**                      TYPE of PRN and the person forward has a TYPE of COL,
**                      after the merge, the merged person will have a TYPE
**                      of PRN.
**
**  01/15/98  sohnjj    SIR 14160 - EA Enhancement to update EA eligibility
**                      for the PERSON FOWARD during the Person Merge routine
**
**  09/12/01  blahapp   SIR 15447-merge - In a person merge, if the person closed has
**                      a date of death or reason for death and the person forward
**                      does not, the date of death or reason for death (or both)
**                      are now copied to the person table for the person forward.
**                      The code for this SIR adds a call to this DAM: CINV41D.
**
**  06/07/02  blahapp   SIR 15447-split - When two merged people are split back out,
**                      the person history table needs to be checked for entries
**                      made at the time of the merge. The table always gets an
**                      entry for the person closed during a merge (because his
**                      person status changed from "active" to "merged"), but an
**                      entry for the person forward will only happen if data from
**                      the person closed got transferred to the person forward.
**                      The first row in the table for the person forward with
**                      the date of last update equal to the date of last update of the
**                      merge tells us how things were before the merge and the next
**                      consecutive row tells us how they were after the merge.
**                      Barring the exception in the next paragraph, these two rows
**                      tell us what needs to be reversed in the event of a split. (We
**                      are using this round-about route with date of last update instead
**                      of date of merge because date of merge doesn't contain hours and
**                      minutes.)
**
**                      A third row, the current values in the person table, needs to be
**                      compared too; because, if any data that changed as a result of the
**                      merge were subsequently changed again, we don't want to restore
**                      those data to their pre-merge values.  We have to assume that
**                      the changes after the merge were intended for the person forward.
**
**                      One further complication:  the date of death and reason for death
**                      are linked. If the user changes either the date of death or the
**                      reason for death after a merge and before a split and those
**                      are data inherited from the person closed, the one that was
**                      not changed will not be restored back to the value it had before
**                      the merge, but keep the value it inherited from the person closed.
**
**                      This code uses two preexisting dams and one new one.
**                      The new dam, CINV75D, retrieves the first two rows referenced above.
**                      CCMN44D is called to retrieve the third row, some logic decides
**                      what to do based on what is in those three rows, and, finally,
**                      CINV41D is called to write the update back to the person table.
**
**                      The code handles the restoration of the only two elements
**                      from the person table that get copied over to person forward
**                      from person closed in a merge (in the event that closed
**                      had a value and forward didn't) but other elements that are
**                      added to the merge code in the future can be handled in this
**                      same split code.  See place marker in the code: "adding elements".
**
**  07/15/02  blahapp   SIR 14980 Person identifiers were not getting copied over to the
**                      person forward in a merge.  This SIR calls cint17d at the time of
**                      the merge to see what person identifiers exist for the person closed
**                      in the person_id table. One of 5 sets of actions happens for each of
**                      those identifiers depending on which of 5 categories the identifier
**                      belongs to.  The first four sets of actions only make changes to the
**                      person closed row. (That is, "it" in the sentences that follow
**                      refers to the person_closed row being processed.) The fifth set of
**                      actions also changes a person forward row.
**
**                      1) If the identifier is enddated, its person_id is changed to the
**                      person forward.
**                      2) If it isn't enddated but is of an id type that doesn't already
**                      exist for the person forward not enddated, its person_id is changed to
**                      person forward.
**                      3) If it isn't enddated and the same type already exists for the
**                      person forward also not endddated AND the type is not SSN, its type is
**                      changed to person forward and it is enddated.
**                      4) If it isn't enddated and the same type already exists for the
**                      person forward also not enddated and the type is SSN and between those
**                      two SSN's neither or both or only the one from the person forward is
**                      from the DHS interface, its  person_id is changed to person forward
**                      and it is enddated.
**                      5) If it isn't enddated and the same type already exists for the
**                      person forward also not enddated and the type is SSN and between those
**                      two SSN's only the one from the person closed is from the DHS
**                      interface, the id person_id is changed to person forward and the row
**                      that all this matching up happened with from the person *forward* is
**                      enddated.
**
**                      Cint18d is called to write the updates to the person_id table.
**
**  12/03/2002  KRD     IMPACT - The Tuxedo services handle errors differently
**                      than the Foundation services.  Due to this, a problem
**                      was found with the Person Split case - error handling
**                      logic was missing after the second call to CINV75D.
**                      Code has been added to return the error to the page,
**                      however this is only a temporary fix.  In addition,
**                      all of the tab indentions within the while-loop have
**                      modified to correctly delineate the code process
**                      flow.
**
**  12/19/2002  KRD     IMPACT - Per the Change Control Committee, the service
**                      should continue to operate as it does in CAPS and
**                      a SIR has been written to correct the underlying
**                      problem.  So, the missing error condition has been
**                      modified to return success, but it has been left in
**                      the service to facilitate the future correction.
**
**  01/10/2003  KRD     IMPACT - A problem also exists with the first call to
**                      CINV75D and temporary code has been written to allow
**                      the processing to continue as it does in CAPS.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**						to PROCESS_TUX_RC_ERROR_NOFREE after the
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**						input and output objects before they are allocated
**
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
**  09/05/03   Srini    SIR 19697 - IMPACT: Memory leak fix for pCINV75DInputRec &
**						pCINV75DOutputRec. pCAUD72DInputRec and pCAUD72DOutputRec are
**						being freed in the error condition but the allocation of the
**						pointers is commented. Commented those free's too.
**
**  09/11/03   Srini    SIR 19697 - iRowToUpdate is not initialized which gets set to
**						arbitrary value randomly and core dumps the server.
**  10/09/03  CORLEYAN  SIR 19918 - Whenever a person is merged the FCE tables added
**                      in impact need to be updated as well.  Added a call to a new
**                      DAM to update this information.
**
** 01/14/05   Hadjimh   SIR 23362. Copy over the phone & addresses from
**                      person closed to person forward.
**
** 01/14/05   Hadjimh   SIR 23337. Copy the education history from person closed
**                      to person forward in a person merge.
**
** 01/14/05   Hadjimh   SIR 23336. Name history table needs to be added to the
**						          person merge program.
**
** 01/14/05   Hadjimh   SIR# 22980: copying over the address of person_closed to
**                      person_forward is done in sir  23362 and copying over the name
**                      is done in sir 23336. With address, phone and name done in those
**                      sirs, we are hoping this error does not occur again.
** 01/14/05   Hadjimh   SIR 23220. duplicate person_eligibility records created by merge
**
**
** 01/14/05   Hadjimh   SIR 16019.  Person Characteristics need to be copied to
**						          the person forward from the person closed.
**
** 01/14/05   Hadjimh   SIR 15791. Any DPS Criminal History check conducted on a
**                      person_closed need to be moved to the person_forward.
**
** 01/14/05   Hadjimh   SIR 14934. Copy over income and resources of person closed
**                      to person forward
** 01/14/05   Hadjimh   SIR 22600.  Data Access Error occurs when searching for a person
**                      id on a person that was "sandwiched"  then split.  cd_person_status
**                      needs to be 'A' or 'I' whichever applies
** 01/14/05   Hadjimh   SIR 16305: Problem with Person Split. a chunk of codes which
**						was written to take care of split has been removed because the
**					    logic behind it was all wrong and was causing errors all over
**						the place. Split portion has never been complete and looks like
**					    it stays that way for now until further analysis be done.
** 04/20/05   Hadjimh   SIR#23436. Records check types that cannot be deleted should be
**                      copied forward in a person merge. (FPS History Check/20,
**                      DPS Direct Check/25, FBI Exigent Check/15, Central Registry/85)
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc14s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /*
    ** Person Status macros
    */
    public static final char CD_ACTIVE = 'A';
    public static final char CD_INACTIVE = 'I';
    public static final char CD_MERGED = 'M';
    
    /*
    ** Person Role macros
    */
    public static final char CD_VICTIM = 'V';
    public static final char CD_AP = 'A';
    public static final char CD_CHILD_PLAN = 'C';
    
    /*
    ** Type of table for the cdyn14d dam
    ** to switch on.
    */
    public static final char CD_LEGAL_ACT = 'A';
    public static final char CD_LEGAL_STAT = 'S';
    public static final char CD_PPT = 'P';
    
    /*
    ** Initial page setting
    */
    public static final int PAGE_NUM_ONE = 1;
    
    /*
    ** Possible Categories
    */
    public static final String FAH_CATEGORY = "FAH";
    public static final String CAS_CATEGORY = "CAS";
    
    /*
    ** Posible Stages
    */
    /* SIR #3872: The CdStage that corresponds to a person with a category of
    ** "FAH" is "FAD", not "FAH".
    */
    public static final String FA_HOME = "FAD";
    
    /* Person Types */
    public static final String PRINCIPAL = "PRN";
    public static final String COLLATERAL = "COL";
    
    
    /*
    ** Tasks to switch on
    */
    /*
    ** Legal Action
    */
    public static final int SUB_LEGAL_ACT = 3030;
    public static final int ADO_LEGAL_ACT = 8540;
    public static final int PAD_LEGAL_ACT = 9030;
    public static final int INV_LEGAL_ACT_1 = 2145;
    public static final int AGO_LEGAL_ACT = 5050;
    public static final int FSU_LEGAL_ACT = 4350;
    public static final int FRE_LEGAL_ACT = 5850;
    public static final int INV_LEGAL_ACT_2 = 2355;
    public static final int SVC_LEGAL_ACT = 6130;
    public static final int SVC_LEGAL_ACT_2 = 7210;
    
    /*
    ** Legal Status
    */
    public static final int SUB_LEGAL_STAT = 3050;
    public static final int ADO_LEGAL_STAT = 8560;
    public static final int PAD_LEGAL_STAT = 9050;
    public static final int INV_LEGAL_STAT = 2375;
    public static final int FSU_LEGAL_STAT = 4370;
    public static final int SVC_LEGAL_STAT = 7230;
    public static final int FRE_LEGAL_STAT = 5870;
    
    /*
    ** Placement
    */
    public static final int SUB_PLAC = 3080;
    public static final int ADO_PLAC = 8590;
    public static final int PAD_PLAC = 9080;
    
    /*
    ** Child Plan
    */
    public static final int SUB_CP = 3160;
    
    /*
    ** PPT
    */
    public static final int SUB_PPT = 3180;
    public static final int PAD_PPT = 9170;
    public static final int ADO_PPT = 8680;
    
    /*
    ** Risk Assessment
    */
    public static final int ADO_RISK_ASSMT = 8750;
    public static final int INV_RISK_ASSMT = 2290;
    public static final int SUB_RISK_ASSMT = 3250;
    public static final int PAD_RISK_ASSMT = 9240;
    public static final int SVC_RISK_ASSMT = 7185;
    
    /*
    ** Family Assessment
    */
    public static final int SVC_FAD_ASSMT = 7060;
    public static final int FRE_FAD_ASSMT = 5590;
    public static final int FSU_FAD_ASSMT = 4140;
    
    /*
    ** SIR 19918 FCE
    */
    public static final int FCE_APP = 3430;
    public static final int FCE_ELIG = 3120;
    public static final int FCE_REVIEW = 3440;
    public static final String NULL_STRING = "";
    
    public static final char FIRST_ROW = 'F';
    public static final char SECOND_ROW = 'S';
    
    Ccfc14s.PersonClosedArray PersonClosedArray;
    
    /* end 14980 */
    
    /*
    ** Conservatorship Removal
    */
    public static final int INV_HOME_REMOVAL = 2350;
    public static final int FSU_REMOVAL = 4330;
    public static final int SVC_REMOVAL = 7190;
    public static final int FRE_REMOVAL = 5830;
    
    /*
    ** Guardian
    */
    public static final int SVC_GUARD = 6120;
    public static final int INV_GUARD = 2140;
    
    /*
    ** SIR# 11504
    */
    public static final String INTAKE = "INT";
    public static final String INVESTIGATION = "INV";
    public static final int LOOP_TWICE = 2;
    
    /*
    ** SIR #14160
    */
    public static final int ORACLE_END_MONTH = 12;
    public static final int ORACLE_END_DAY = 31;
    public static final int ORACLE_END_YEAR = 4712;
    
    /* SIR 3225 */
    public static final int INITIAL_PAGE = 1;
    
    /*
    ** SIR #15447
    */
    public static final char WINDOW_MODE_PERSON = 'P';
    
    /* SIR 16019  */
    public static final char WINDOW_MODE_MERGE = 'M';
    
    
    /* SIR 23336: used in CINV31D3_CURSOR. returns valid names */
    public static final char IND_VALID_NAME = '2';
    
    /*********** start ccfc50s.src transfer ******************/
    /*********** start ccfc50s.src transfer ******************/
    /*
    ** Todo Description # defines
    */
    public static final String SPLIT_SHORT_DESC = " Split From ";
    public static final int SSD_LENGTH = 13;
    public static final String MERGE_SHORT_DESC = " Merged Into ";
    public static final int MSD_LENGTH = 14;
    public static final String SPLIT_LONG_DESC = "has been split from";
    public static final String MERGED_LONG_DESC = "has been merged into";
    public static final String BY_STRING = "by";
    
    /*
    ** ToDo Definitions
    */
    public static final String MERGE_TODO_CD = "CFC017";
    public static final String SPLIT_TODO_CD = "CFC018";
    public //SIR 14934
    static final String DPS_CODE = "10";
    public //SIR 23436
    static final String FBI_EXIGENT_CHK = "15";
    public //SIR 23436
    static final String FPS_HISTORY_CHK = "20";
    public //SIR 23436
    static final String DPS_DIRECT_CHK = "25";
    public //SIR 23436
    static final String CENTRAL_REGISTRY = "85";
    
    
    /*********** end ccfc50s.src transfer ******************/
    /*********** end ccfc50s.src transfer ******************/
    
    
    /* SIR 23220 */
    public static final String TITLE_19 = "001004005006010011013014";
    public static final String NON_TITLE_19 = "002003007008009012015";
    
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    /**************************************************************************
    **
    ** Function Name:  CINV16S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    static CCFC14SI pInputMsg = null;
    static CCFC14SO pOutputMsg = null;
    static int transactionflag = - 1;
    CCFC14SO CCFC14S(CCFC14SI ccfc14si) {
        CCFC14SO ccfc14so = new CCFC14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CCFC14S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCFC14S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else /* merge */
        if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCFC14S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCFC14S \n");
            bTransactionStarted = true;
        }
        
        /* SIR 15791: added CLSC63D */
        CLSC63DI CLSC63DI = null;
        CLSC63DO CLSC63DO = null;
        
        
        /*********** end   ccfc50s.src transfer ******************/
        
        CAUD63DI pCAUD63DInputRec = null;
        CAUD63DO pCAUD63DOutputRec = null;
        CAUD66DI pCAUD66DInputRec = null;
        CAUD66DO pCAUD66DOutputRec = null;
        CAUD67DI pCAUD67DInputRec = null;
        CAUD67DO pCAUD67DOutputRec = null;
        CAUD68DI pCAUD68DInputRec = null;
        CAUD68DO pCAUD68DOutputRec = null;
        CAUD69DI pCAUD69DInputRec = null;
        CAUD69DO pCAUD69DOutputRec = null;
        CAUD71DI pCAUD71DInputRec = null;
        CAUD71DO pCAUD71DOutputRec = null;
        //SIR#19697
        //  _CAUD72DI       *pCAUD72DInputRec;
        //  _CAUD72DO       *pCAUD72DOutputRec;
        CAUD73DI pCAUD73DInputRec = null;
        CAUD73DO pCAUD73DOutputRec = null;
        CAUD82DI pCAUD82DInputRec = null;
        CAUD82DO pCAUD82DOutputRec = null;
        CAUD83DI pCAUD83DInputRec = null;
        CAUD83DO pCAUD83DOutputRec = null;
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        CCMN44DI pCall2CCMN44DInputRec = null;
        CCMN44DO pCall2CCMN44DOutputRec = null;
        CCMNC2DI pCCMNC2DInputRec = null;
        CCMNC2DO pCCMNC2DOutputRec = null;
        CDYN14DI pCDYN14DInputRec = null;
        CDYN14DO pCDYN14DOutputRec = null;
        CDYN16DI pCDYN16DInputRec = null;
        CDYN16DO pCDYN16DOutputRec = null;
        CLSC47DI pCLSC47DInputRec = null;
        CLSC47DO pCLSC47DOutputRec = null;
        CLSS49DI pCLSS49DInputRec = null;
        CLSS49DO pCLSS49DOutputRec = null;
        CMSC23DI pCMSC23DInputRec = null;
        CMSC23DO pCMSC23DOutputRec = null;
        CSEC83DI pCSEC83DInputRec = null;
        CSEC83DO pCSEC83DOutputRec = null;
        CAUDC4DI pCAUDC4DInputRec = null;
        CAUDC4DO pCAUDC4DOutputRec = null;
        CINV07DI pCINV07DInputRec = null;
        CINV07DO pCINV07DOutputRec = null;
        
        /*
        ** SIR 12838 - ADD 3 NEW DAMS
        */
        CLSC83DI pCLSC83DInputRec = null;
        CLSC83DO pCLSC83DOutputRec = null;
        CLSS74DI pCLSS74DInputRec = null;
        CLSS74DO pCLSS74DOutputRec = null;
        CAUDC5DI pCAUDC5DInputRec = null;
        CAUDC5DO pCAUDC5DOutputRec = null;
        CMSC58DI pCMSC58DInputRec = null;
        CMSC58DO pCMSC58DOutputRec = null;
        
        
        /*
        ** SIR 15447 - person merge
        */
        
        CINV41DI CINV41DI = null;
        CINV41DO CINV41DO = null;
        
        /* SIR 15447 - person split */
        CINV75DI pCINV75DInputRec = null;
        CINV75DO pCINV75DOutputRec = null;
        
        
        /* SIR 16019 */
        CLSS60DI CLSS60DI = null;
        CLSS60DO CLSS60DO = null;
        /* SIR 16305 */
        CAUD74DI CAUD74DI = null;
        CAUD74DO CAUD74DO = null;
        
        /*
        ** SIR 14160 - EA Enhancements
        */
        CSECA4DI CSECA4DI = null;
        CSECA4DO CSECA4DO = null;
        CAUDD1DI CAUDD1DI = null;
        CAUDD1DO CAUDD1DO = null;
        CLSC86DI CLSC86DI = null;
        CLSC86DO CLSC86DO = null;
        CSECA6DI CSECA6DI = null;
        CSECA6DO CSECA6DO = null;
        CAUDD2DI CAUDD2DI = null;
        CAUDD2DO CAUDD2DO = null;
        CLSC87DI CLSC87DI = null;
        CLSC87DO CLSC87DO = null;
        CAUDD3DI CAUDD3DI = null;
        CAUDD3DO CAUDD3DO = null;
        
        
        int usRow = 0;
        int usInputRow = 0;
        
        int NumCdTask = 0;
        int i18 = 0;
        int j = 0;/*loop counter*/
        /*
        ** SIR 12838
        */
        int x = 0;
        //SIR#19697
        int iRowToUpdate = 0;
        boolean bIndBothActive = false;/* Boolean Flag */
        boolean bIndPersForwardActive = false;/* HH */
        boolean bIndPersCloseActive = false;/* Boolean Flag */
        boolean bIndFAHome = false;/* Boolean Flag */
        boolean bIndCase = false;/* Boolean Flag */
        boolean bPrincipal = false;/* SIR 13636: Boolean Flag */
        
        /*
        ** Boolean flags to store various results returned from
        ** dam calls.
        */
        
        
        /* SIR 14980 */
        char bMatch = 0;
        
        /*********** start ccfc50s.src transfer ******************/
        
        String TxtToDoDesc = new String();
        String TxtToDoLongDesc = new String();
        
        
        
        /*********** end   ccfc50s.src transfer ******************/
        
        /*
        ** SIR 15447
        */
        char bUpdateDeath = 0;
        char bPersTable = 0;
        
        /*
        ** SIR 14160 - EA Enhancements
        */
        Pchar bEA_Open = new Pchar();
        bEA_Open.value = 0;
        Pchar bDHS_Found = new Pchar();
        bDHS_Found.value = 0;
        Pchar bRowDifferent = new Pchar();
        bRowDifferent.value = 0;
        FndInt3date ClosedStartDate = null;
        FndInt3date ForwardStartDate = null;
        int a = 0;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc14si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields
        */
        
        /*
        ** Reserve the memory of the Dams that will be called more than once here.
        ** Allocate memory for them all at once, if any of them fail try and free
        ** all the memory and then return out of the service.  The memory will be
        ** freed on the bottom of the service if everything went well.
        */
        
        pCAUD63DInputRec = new CAUD63DI();
        
        pCAUD63DOutputRec = new CAUD63DO();
        /* 15447 split */
        
        pCINV75DInputRec = new CINV75DI();
        pCINV75DOutputRec = new CINV75DO();
        
        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE != ccfc14si.getArchInputStruct().getCReqFuncCd()) {
            rc = CallCompareAddress(ccfc14si, ccfc14so, pServiceStatus);
            
            //## BEGIN TUX/XML: Declare XML variables 
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = CallComparePhone(ccfc14si, ccfc14so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = CallCompareEducation(ccfc14si, ccfc14so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            if (rc == SUCCESS) {
                
                //  Call DAM
                rc = CallCompareChar(ccfc14si, ccfc14so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (rc == SUCCESS) {
                // make sure zero goes into output message 
                // DWW 02/26/03 - got rid of the ulRowQty reset so that it would not overwrite the number of
                // races returned
                // pOutputMsg->ArchOutputStruct.ulRowQty = 0;
                rc = CallCompareName(ccfc14si, ccfc14so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (rc == SUCCESS) {
                rc = CallCompareIncome(ccfc14si, ccfc14so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (rc == SUCCESS) {
                rc = CallCompareRecChk(ccfc14si, ccfc14so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccfc14si.getArchInputStruct().getCReqFuncCd()) {
            
            //  Call DAM
            rc = WtcHelperConstants.SQL_SUCCESS;
            
            //  While more rows are left to process and rc is success,
            // continue loop.
            //  IMPACT BEGIN - modify tabs for "readability"
            while ((usRow < ccfc14si.getArchInputStruct().getUlPageSizeNbr()) && (rc == WtcHelperConstants.SQL_SUCCESS)) {
                pCAUD63DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                pCAUD63DInputRec.setTsLastUpdate(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getTsLastUpdate());
                pCAUD63DInputRec.setDtDtPersMerge(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getDtDtPersMerge());
                pCAUD63DInputRec.setDtDtPersMergeSplit(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getDtDtPersMergeSplit());
                pCAUD63DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeForward());
                pCAUD63DInputRec.setUlIdPersMergeWrkr(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeWrkr());
                pCAUD63DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed());
                pCAUD63DInputRec.setUlIdPersMergeSplitWrkr(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeSplitWrkr());
                pCAUD63DInputRec.setUlIdPersonMerge(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersonMerge());
                pCAUD63DInputRec.setCIndPersMergeInvalid(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getCIndPersMergeInvalid());
                pCAUD63DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                rc = caud63dAUDdam(sqlca, pCAUD63DInputRec, pCAUD63DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        CAUD74DI.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed());
                        CAUD74DI.getCdPersonStatus()[0] = CD_INACTIVE;
                        
                        // Call INCOMING PERSON ID  query DAM.
                        rc = Ccmn02u.CallCAUD74D(CAUD74DI, CAUD74DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        rc = Csub50s.FND_FAIL;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
                usRow++;
            }
        }
        else {
            //  Set the active flags for later processing based upon the person
            // status retrieved from the person table. The first call is for the
            // id person forward.
            
            // 
            // Call the Person Retrieval Dam - CCMN44D
            // Description - This DAM will return one row from the person
            // table based upon the id_person passed into it.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN44DInputRec = new CCMN44DI();
            
            pCCMN44DOutputRec = new CCMN44DO();
            pCCMN44DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
            pCCMN44DInputRec.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Now call the same dam a second time, but this time pass in the id person
                    // for the person closed for later comparison with what was returned for the
                    // person forward just retrieved.
                    // 
                    // Call the Person Retrieval Dam - CCMN44D2
                    // Description - This DAM will return one row from the person
                    // table based upon the id_person passed into it.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCall2CCMN44DInputRec = new CCMN44DI();
                    
                    pCall2CCMN44DOutputRec = new CCMN44DO();
                    pCall2CCMN44DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                    pCall2CCMN44DInputRec.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                    
                    //  Call DAM
                    rc = ccmn44dQUERYdam(sqlca, pCall2CCMN44DInputRec, pCall2CCMN44DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            if (!(NULL_STRING.compareTo(pCCMN44DOutputRec.getSzCdPersonDeath()) != 0) && NULL_STRING.compareTo(pCall2CCMN44DOutputRec.getSzCdPersonDeath()) != 0 || DateHelper.NULL_DATE == pCCMN44DOutputRec.getDtDtPersonDeath().year && DateHelper.NULL_DATE != pCall2CCMN44DOutputRec.getDtDtPersonDeath().year) {
                                CINV41DI.setTsSysTsLastUpdate2(pCCMN44DOutputRec.getTsLastUpdate());
                                CINV41DI.setCCdPersonSex(pCCMN44DOutputRec.getCCdPersonSex());
                                CINV41DI.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                CINV41DI.setDtDtPersonBirth(pCCMN44DOutputRec.getDtDtPersonBirth());
                                CINV41DI.setBIndPersonDobApprox(pCCMN44DOutputRec.getBIndPersonDobApprox());
                                
                                if (!(NULL_STRING.compareTo(pCCMN44DOutputRec.getSzCdPersonDeath()) != 0) && NULL_STRING.compareTo(pCall2CCMN44DOutputRec.getSzCdPersonDeath()) != 0) {
                                    CINV41DI.setSzCdPersonDeath(pCall2CCMN44DOutputRec.getSzCdPersonDeath());
                                }
                                
                                
                                else {
                                    CINV41DI.setSzCdPersonDeath(pCCMN44DOutputRec.getSzCdPersonDeath());
                                }
                                
                                if ((DateHelper.NULL_DATE == pCCMN44DOutputRec.getDtDtPersonDeath().year) && (DateHelper.NULL_DATE != pCall2CCMN44DOutputRec.getDtDtPersonDeath().year)) {
                                    CINV41DI.setDtDtPersonDeath(pCall2CCMN44DOutputRec.getDtDtPersonDeath());
                                }
                                
                                
                                
                                
                                //  Since the CdStages are the same, delete the newest allegation
                                // This is always the 2nd Allegation since CSEC83D always places
                                // the newest allegation in IdAllegation2
                                else {
                                    CINV41DI.setDtDtPersonDeath(pCCMN44DOutputRec.getDtDtPersonDeath());
                                }
                                
                                CINV41DI.setSzCdPersonMaritalStatus(pCCMN44DOutputRec.getSzCdPersonMaritalStatus());
                                CINV41DI.setSzCdPersonLanguage(pCCMN44DOutputRec.getSzCdPersonLanguage());
                                CINV41DI.setSzCdPersonEthnicGroup(pCCMN44DOutputRec.getSzCdPersonEthnicGroup());
                                CINV41DI.setCdPersonStatus(pCCMN44DOutputRec.getCdPersonStatus());
                                CINV41DI.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                CINV41DI.setBCdPersonChar(pCCMN44DOutputRec.getBCdPersonChar());
                                CINV41DI.setSzCdPersonReligion(pCCMN44DOutputRec.getSzCdPersonReligion());
                                CINV41DI.setSzCdPersonLivArr(pCCMN44DOutputRec.getSzCdPersonLivArr());
                                CINV41DI.setSzTxtOccupation(pCCMN44DOutputRec.getSzTxtOccupation());
                                CINV41DI.setLNbrPersonAge(pCCMN44DOutputRec.getLNbrPersonAge());
                                rc = Ccmn03u.CallCINV41D(CINV41DI, CINV41DO, pServiceStatus);
                                
                                //  Analyze return code for CINV51D(VC)
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        break;
                                        
                                        
                                        //  SIR#3991 - Included the case SQL_NOT_FOUND with
                                        // SQL_SUCCESS because in situations when there is no
                                        // Unpaid Services and Training event the switch statement
                                        // should not skip the update to the ILS event.
                                    case NO_DATA_FOUND:
                                        
                                        
                                        
                                        break;
                                    default :// for caud63d
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                        
                                        break;
                                }
                            }
                            
                            //  Call DAM
                            rc = Cint19s.CallCINT17D(ccfc14si, ccfc14so, pServiceStatus);
                            
                            if ((CD_ACTIVE == pCCMN44DOutputRec.getCdPersonStatus()[0]) && (CD_ACTIVE == pCall2CCMN44DOutputRec.getCdPersonStatus()[0])) {
                                bIndBothActive = true;
                            }
                            
                            if (CD_ACTIVE == pCCMN44DOutputRec.getCdPersonStatus()[0]) {
                                bIndPersForwardActive = true;
                            }
                            
                            if (CD_ACTIVE == pCall2CCMN44DOutputRec.getCdPersonStatus()[0]) {
                                bIndPersCloseActive = true;
                            }
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                            rc = Csub50s.FND_FAIL;
                            
                            
                            
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            
                            break;
                    }
                    
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                    rc = Csub50s.FND_FAIL;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
            if (SUCCESS == rc) {
                // 
                // Call the Stage and Event List Retrieval Dam - CLSC47D
                // Description - This DAM will be used to retreive from Stage all open stages
                // a person is associated with, and if any events are in that
                // stage, retreive them also.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSC47DInputRec = new CLSC47DI();
                
                pCLSC47DOutputRec = new CLSC47DO();
                pCLSC47DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                
                pCLSC47DInputRec.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                pCLSC47DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                pCLSC47DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC47DO._CLSC47DO__ROWCLSC47DO_SIZE);
                rc = clsc47dQUERYdam(sqlca, pCLSC47DInputRec, pCLSC47DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                        // 
                        // End Call to EVENT STATUS AUD Dam - CAUD64D
                        // 
                        
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Reserve the memory for all of the dams that will be called in the for loop
                        // so that the memory will not be allocated and freed for each loop.
                        
                        pCDYN14DInputRec = new CDYN14DI();
                        pCDYN14DOutputRec = new CDYN14DO();
                        pCAUD67DInputRec = new CAUD67DI();
                        pCAUD67DOutputRec = new CAUD67DO();
                        pCAUD68DInputRec = new CAUD68DI();
                        pCAUD68DOutputRec = new CAUD68DO();
                        pCAUD69DInputRec = new CAUD69DI();
                        pCAUD69DOutputRec = new CAUD69DO();
                        pCDYN16DInputRec = new CDYN16DI();
                        pCDYN16DOutputRec = new CDYN16DO();
                        pCAUD71DInputRec = new CAUD71DI();
                        pCAUD71DOutputRec = new CAUD71DO();
                        pCAUD83DInputRec = new CAUD83DI();
                        pCAUD83DOutputRec = new CAUD83DO();
                        pCAUD82DInputRec = new CAUD82DI();
                        pCAUD82DOutputRec = new CAUD82DO();
                        //  SIR 19918
                        pCMSC58DInputRec = new CMSC58DI();
                        pCMSC58DOutputRec = new CMSC58DO();
                        if ((pCDYN14DInputRec == null) || (pCDYN14DOutputRec == null) || (pCAUD67DInputRec == null) || (pCAUD67DOutputRec == null) || (pCAUD68DInputRec == null) || (pCAUD68DOutputRec == null) || (pCAUD69DInputRec == null) || (pCAUD69DOutputRec == null) || (pCDYN16DInputRec == null) || (pCDYN16DOutputRec == null) || (pCAUD71DInputRec == null) || (pCAUD71DOutputRec == null) || (pCAUD83DInputRec == null) || (pCAUD83DOutputRec == null) || (pCAUD82DInputRec == null) || (pCAUD82DOutputRec == null)) {
                            
                            //  Call DAM
                            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        }
                        
                        //  Loop through all the rows returned from clsc47d and update the allegation
                        // event and functional tables for each row.
                        for (usRow = 0;((usRow < pCLSC47DOutputRec.getArchOutputStruct().getUlRowQty()) && (SUCCESS == rc));usRow++) {
                            
                            //  SIR  kjm 12/08/95
                            if ((usRow == 0) || (pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdStage() != pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow - 1).getUlIdStage())) {
                                
                                
                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                pCDYN14DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                pCDYN14DInputRec.getArchInputStruct().setCReqFuncCd(CD_VICTIM);
                                pCDYN14DInputRec.setUlIdStage(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdStage());
                                pCDYN14DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                pCDYN14DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                
                                rc = cdyn14dAUDdam(sqlca, pCDYN14DInputRec, pCDYN14DOutputRec);
                                
                                //  Analyze return code for CINV51D(VP)
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        break;
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Call DAM
                                        rc = SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        break;
                                }
                                pCDYN14DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                pCDYN14DInputRec.getArchInputStruct().setCReqFuncCd(CD_AP);
                                pCDYN14DInputRec.setUlIdStage(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdStage());
                                pCDYN14DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                // Process utility function failure
                                pCDYN14DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                
                                rc = cdyn14dAUDdam(sqlca, pCDYN14DInputRec, pCDYN14DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                        
                                        // 
                                        // End Call to Stage Person Link Retrieval Dam - CAUDA0D  SIR 22187
                                        // 
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        break;
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        rc = SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        break;
                                }
                            }
                            if ((SUCCESS == rc) && (0 != pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent())) {
                                pCAUD67DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                pCAUD67DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                pCAUD67DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                pCAUD67DInputRec.setUlIdEvent(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent());
                                pCAUD67DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                rc = caud67dAUDdam(sqlca, pCAUD67DInputRec, pCAUD67DOutputRec);
                                
                                //  Analyze return code for CINV51D(CL)
                                switch (rc) {
                                        
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        //##               PrepServiceExit(SVCPARMS);
                                        
                                        break;
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Call DAM
                                        rc = SUCCESS;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        //##               PrepServiceExit(SVCPARMS);
                                        
                                        break;
                                }
                            }
                            
                            if ((SUCCESS == rc) && (pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getSzCdTask()[0] != null)) {
                                //  First you need to convert the cd task to a numeric value so
                                // that the switch statement will work.
                                NumCdTask = atoi((char) pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getSzCdTask());
                                
                                //  Analyze return code
                                switch (NumCdTask) {
                                        
                                    case ADO_RISK_ASSMT:
                                        
                                        
                                    case INV_RISK_ASSMT:
                                    case SUB_RISK_ASSMT:
                                    case PAD_RISK_ASSMT:
                                        
                                    case SVC_RISK_ASSMT:
                                        pCAUD68DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                        pCAUD68DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                        pCAUD68DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                        pCAUD68DInputRec.setUlIdStage(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdStage());
                                        pCAUD68DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        
                                        rc = caud68dAUDdam(sqlca, pCAUD68DInputRec, pCAUD68DOutputRec);
                                        
                                        //  Analyze return code for CSES06D
                                        switch (rc) {
                                                
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                //##               PrepServiceExit(SVCPARMS);
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        
                                        break;
                                    case INV_HOME_REMOVAL:
                                        
                                    case FSU_REMOVAL:
                                        
                                    case SVC_REMOVAL:
                                        
                                    case FRE_REMOVAL:
                                        
                                        pCAUD69DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                        pCAUD69DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                        pCAUD69DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                        pCAUD69DInputRec.setUlIdEvent(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent());
                                        pCAUD69DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        rc = caud69dAUDdam(sqlca, pCAUD69DInputRec, pCAUD69DOutputRec);
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Call DAM
                                                rc = SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                
                                                break;
                                        }
                                        
                                        break;
                                    case SUB_PPT:
                                    case PAD_PPT:
                                    case ADO_PPT:
                                        
                                        rc = CallCDYN16D(ccfc14si, ccfc14so, pCDYN16DInputRec, pCDYN16DOutputRec, pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent() , CD_PPT, pServiceStatus);
                                        
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  The DAM CDYN02D will retrieve all records from the DELVRD SVC DTL
                                                // table that have an ID INVOICE equal to the one passed into the service
                                                
                                                //  Start Performance Timer
                                                rc = SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                    case SUB_CP:
                                        
                                        
                                        
                                        //  Initialize Service Status Fields
                                        
                                        //  Set CFIN10SO WCD DtSystemDate to current date
                                        rc = CallCDYN16D(ccfc14si, ccfc14so, pCDYN16DInputRec, pCDYN16DOutputRec, pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent() , CD_CHILD_PLAN, pServiceStatus);
                                        
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                    case SUB_LEGAL_ACT:
                                    case ADO_LEGAL_ACT:
                                    case PAD_LEGAL_ACT:
                                    case INV_LEGAL_ACT_1:
                                    case AGO_LEGAL_ACT:
                                    case FSU_LEGAL_ACT:
                                    case INV_LEGAL_ACT_2:
                                    case SVC_LEGAL_ACT:
                                    case SVC_LEGAL_ACT_2:
                                        
                                        
                                        //  Call CDYN02D to retrieve line items from the DELVRD_SVC_DTL table
                                        rc = CallCDYN16D(ccfc14si, ccfc14so, pCDYN16DInputRec, pCDYN16DOutputRec, pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent() , CD_LEGAL_ACT, pServiceStatus);
                                        
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                
                                                //  Set rc to ARC_SUCCESS
                                                rc = SUCCESS;
                                                break;
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                        
                                    case SUB_LEGAL_STAT:
                                        
                                    case ADO_LEGAL_STAT:
                                    case PAD_LEGAL_STAT:
                                    case INV_LEGAL_STAT:
                                    case FSU_LEGAL_STAT:
                                    case SVC_LEGAL_STAT:
                                        
                                        
                                    case FRE_LEGAL_STAT:
                                        rc = CallCDYN16D(ccfc14si, ccfc14so, pCDYN16DInputRec, pCDYN16DOutputRec, pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent() , CD_LEGAL_STAT, pServiceStatus);
                                        
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                rc = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                
                                                //## BEGIN TUX/XML: Declare XML variables 
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                    case SVC_FAD_ASSMT:
                                    case FRE_FAD_ASSMT:
                                    case FSU_FAD_ASSMT:
                                        pCAUD71DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                        pCAUD71DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                        pCAUD71DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                        pCAUD71DInputRec.setUlIdEvent(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent());
                                        pCAUD71DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        rc = caud71dAUDdam(sqlca, pCAUD71DInputRec, pCAUD71DOutputRec);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                                
                                            default :
                                                //##            return (0);
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                    case SUB_PLAC:
                                        
                                    case ADO_PLAC:
                                        
                                    case PAD_PLAC:
                                        pCAUD83DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                        pCAUD83DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                        pCAUD83DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                        //##            return (0);
                                        pCAUD83DInputRec.setUlIdPlcmtEvent(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent());
                                        pCAUD83DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        rc = caud83dAUDdam(sqlca, pCAUD83DInputRec, pCAUD83DOutputRec);
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Call DAM
                                                rc = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                                
                                            default :
                                                
                                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                    case SVC_GUARD:
                                        
                                    case INV_GUARD:
                                        pCAUD82DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                        pCAUD82DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                                        pCAUD82DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                        pCAUD82DInputRec.setUlIdEvent(pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdEvent());
                                        pCAUD82DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                        rc = caud82dAUDdam(sqlca, pCAUD82DInputRec, pCAUD82DOutputRec);
                                        
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Call DAM
                                                rc = SUCCESS;
                                                break;
                                                
                                            default :
                                                
                                                //  function prototypes 
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        break;
                                    case FCE_APP:
                                    case FCE_ELIG:
                                    case FCE_REVIEW:
                                        rc = CallCMSC58D(ccfc14si, ccfc14so, pCMSC58DInputRec, pCMSC58DOutputRec, pCLSC47DOutputRec.getROWCLSC47DO_ARRAY().getROWCLSC47DO(usRow).getUlIdStage() , pServiceStatus);
                                        
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                rc = SUCCESS;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                break;
                                        }
                                        break;
                                }
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            if (SUCCESS == rc) {
                // 
                // Call to CSEC83D - Retrieve Duped allegations
                // Description - This DAM Retrieves Duplicate allegation rows for
                // all OPEN stages in the CAPS database!!! WOW!!!!
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCSEC83DInputRec = new CSEC83DI();
                
                pCSEC83DOutputRec = new CSEC83DO();
                pCSEC83DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                pCSEC83DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                
                pCSEC83DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                pCSEC83DInputRec.getArchInputStruct().setUlPageSizeNbr(CSEC83DO._CSEC83DO__ROWCSEC83DO_SIZE);
                rc = csec83dQUERYdam(sqlca, pCSEC83DInputRec, pCSEC83DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                        
                        // case SQL_NOT_FOUND:
                        // pServiceStatus->severity = FND_SEVERITY_ERROR;
                        // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                        // RetVal = FND_SUCCESS;
                        // rc = MSG_CMN_TMSTAMP_MISMATCH;
                        // break;
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
                
                if (SUCCESS == rc) {
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCINV07DInputRec = new CINV07DI();
                    
                    pCINV07DOutputRec = new CINV07DO();
                    
                    pCINV07DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                    pCINV07DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                    
                    
                    
                    for (i18 = 0;i18 < pCSEC83DOutputRec.getArchOutputStruct().getUlRowQty();i18++) {
                        
                        if ((0 == pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getSzCdAllegIncidentStage().compareTo(INTAKE)) && (0 == pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getSzCdAllegIncidentStage2().compareTo(INVESTIGATION))) {
                            pCINV07DInputRec.setUlIdAllegation(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getUlIdAllegation2());
                            pCINV07DInputRec.setTsLastUpdate(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getTsSysTsLastUpdate2());
                            
                            
                            rc = cinv07dAUDdam(sqlca, pCINV07DInputRec, pCINV07DOutputRec);
                            pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).setUlIdAllegation2(0);
                        }
                        else if ((0 == pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getSzCdAllegIncidentStage2().compareTo(INTAKE)) && (0 == pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getSzCdAllegIncidentStage().compareTo(INVESTIGATION))) {
                            pCINV07DInputRec.setUlIdAllegation(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getUlIdAllegation());
                            pCINV07DInputRec.setTsLastUpdate(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getTsLastUpdate());
                            rc = cinv07dAUDdam(sqlca, pCINV07DInputRec, pCINV07DOutputRec);
                            pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).setUlIdAllegation(0);
                        }
                        
                        
                        else {
                            pCINV07DInputRec.setUlIdAllegation(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getUlIdAllegation2());
                            pCINV07DInputRec.setTsLastUpdate(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getTsSysTsLastUpdate2());
                            rc = cinv07dAUDdam(sqlca, pCINV07DInputRec, pCINV07DOutputRec);
                            pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).setUlIdAllegation2(0);
                        }
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                //  We don't care if no rows were found here so just
                                // exit switch
                                rc = SUCCESS;
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                rc = SUCCESS;
                                
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                    }
                }
                
                if (SUCCESS == rc) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUDC4DInputRec = new CAUDC4DI();
                    
                    pCAUDC4DOutputRec = new CAUDC4DO();
                    pCAUDC4DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                    pCAUDC4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    
                    //  Loop through CSEC83DOutputRec again. This time update based
                    // on IdAllegation
                    for (i18 = 0;i18 < pCSEC83DOutputRec.getArchOutputStruct().getUlRowQty();i18++) {
                        if (0 != pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getUlIdAllegation()) {
                            pCAUDC4DInputRec.setUlIdAllegation(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getUlIdAllegation());
                            pCAUDC4DInputRec.setTsLastUpdate(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getTsLastUpdate());
                            rc = caudc4dAUDdam(sqlca, pCAUDC4DInputRec, pCAUDC4DOutputRec);
                            
                            //  Analyze error code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    
                                    rc = SUCCESS;
                                    
                                    
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    rc = SUCCESS;
                                    
                                    break;
                                    
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    
                                    
                                    
                                    break;
                            }
                        }
                    }
                    
                    
                    
                    
                    //  Loop through CSEC83DOutputRec again. This time update based
                    // on IdAllegation2
                    for (i18 = 0;i18 < pCSEC83DOutputRec.getArchOutputStruct().getUlRowQty();i18++) {
                        if (0 != pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getUlIdAllegation2()) {
                            pCAUDC4DInputRec.setUlIdAllegation(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getUlIdAllegation2());
                            pCAUDC4DInputRec.setTsLastUpdate(pCSEC83DOutputRec.getROWCSEC83DO_ARRAY().getROWCSEC83DO(i18).getTsSysTsLastUpdate2());
                            rc = caudc4dAUDdam(sqlca, pCAUDC4DInputRec, pCAUDC4DOutputRec);
                            
                            //  Analyze error code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = SUCCESS;
                                    
                                    
                                    //  Set explan_data to usRow
                                    // Note: Use sprintf
                                    //##          sprintf(pReturnPB->appl_status.explan_data,
                                    //##                  "%u",
                                    //##                  usRow);
                                    
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    rc = SUCCESS;
                                    
                                    
                                    //  Note:  When setting the explan_code, the designer may have a
                                    // functional requirement for a specific message.  If so,
                                    // change MSG_DUPLICATE_RECORD to your specific message name
                                    
                                    
                                    //  Set explan_data to usRow
                                    // Note: Use sprintf
                                    //##          sprintf(pReturnPB->appl_status.explan_data,
                                    //##                  "%u",
                                    //##                  usRow);
                                    
                                    break;
                                    
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    
                                    break;
                            }
                        }
                    }
                }
            }
            
            if (SUCCESS == rc) {
                // 
                // Call the Person Merge List Retrieval Dam - CLSS49D
                // Description - This DAM will return the valid rows on the person merge
                // table where the host id is the Merge Forward.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSS49DInputRec = new CLSS49DI();
                
                pCLSS49DOutputRec = new CLSS49DO();
                pCLSS49DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                pCLSS49DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                pCLSS49DInputRec.setCIndPersMergeInvalid(FND_NO);
                pCLSS49DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                pCLSS49DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS49DO._CLSS49DO__ROWCLSS49DO_SIZE);
                //  We don't care if no rows were found here so just
                // exit switch
                rc = clss49dQUERYdam(sqlca, pCLSS49DInputRec, pCLSS49DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        break;
                        
                        
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        
                        
                        pCAUD63DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                        pCAUD63DInputRec.setCIndPersMergeInvalid(FND_NO);
                        pCAUD63DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                        pCAUD63DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                        pCAUD63DInputRec.setUlIdPersMergeWrkr(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeWrkr());
                        pCAUD63DInputRec.setDtDtPersMerge(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMerge());
                        pCAUD63DInputRec.setDtDtPersMergeSplit(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMergeSplit());
                        pCAUD63DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        rc = caud63dAUDdam(sqlca, pCAUD63DInputRec, pCAUD63DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //   The CMSC12D (Delvrd Svc Dtl Total) will retrieve the sum of all
                                // ((AMT SVC DTL UNIT RATE * NBR SVC DTL UNIT QTY) - AMT SVC DTL FEE PAID
                                // - AMT SVC DTL INCOME)s from the DELVRD SVC DTL table.
                                
                                //  Start Performance Timer
                                rc = SUCCESS;
                                break;
                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                rc = Csub50s.FND_FAIL;
                                break;
                                
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        //##                                 sprintf(pReturnPB->appl_status.explan_data,"%u", 
                        //##                                     pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                        break;
                }
            }
            if (SUCCESS == rc) {
                // 
                // Call the Person Merge List Retrieval Dam - CLSS49D
                // Description - This Dam will return the valid rows on the person merge
                // table where the host id is the Merge Closed.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSS49DInputRec = new CLSS49DI();
                
                pCLSS49DOutputRec = new CLSS49DO();
                pCLSS49DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                pCLSS49DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                pCLSS49DInputRec.setCIndPersMergeInvalid(FND_NO);
                pCLSS49DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                pCLSS49DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS49DO._CLSS49DO__ROWCLSS49DO_SIZE);
                rc = clss49dQUERYdam(sqlca, pCLSS49DInputRec, pCLSS49DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                        
                        //  SIR 1857: until further notice from Conversion team, this service
                        // needs to be able to handle NO ROWS FOUND as FND_SUCCESS.
                        
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Call caud63d the first time to update the person merge table
                        // where the person closed id is found in the person forward column
                        // and set the row to invalid.  Then if a row was updated call caud63d
                        // a second time to create a new row so that the person closed
                        // in the newly invalidated row is now merged into the new person
                        // merge sent from the window.  This situation is called a multiple
                        // merge.
                        // If the row that the person closed id was found in has the two
                        // id fields equal (i.e. the person was previously a person forward)
                        // then do not create the new row after the invalidation since
                        // this would end up duplicating the merge requested on the window so
                        // let the third call to caud63 do this.
                        
                        //  Loop through the dams
                        for (i18 = 0;((i18 < pCLSS49DOutputRec.getArchOutputStruct().getUlRowQty()) && (SUCCESS == rc));i18++) {
                            pCAUD63DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                            pCAUD63DInputRec.setTsLastUpdate(pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getTsLastUpdate());
                            pCAUD63DInputRec.setUlIdPersMergeForward(pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getUlIdPersMergeForward());
                            pCAUD63DInputRec.setUlIdPersMergeClosed(pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getUlIdPersMergeClosed());
                            pCAUD63DInputRec.setDtDtPersMerge(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMerge());
                            pCAUD63DInputRec.setDtDtPersMergeSplit(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMergeSplit());
                            pCAUD63DInputRec.setUlIdPersMergeWrkr(pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getUlIdPersMergeWrkr());
                            pCAUD63DInputRec.setUlIdPersonMerge(pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getUlIdPersonMerge());
                            pCAUD63DInputRec.setCIndPersMergeInvalid(FND_YES);
                            pCAUD63DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            
                            
                            //  Call CCMN44D
                            rc = caud63dAUDdam(sqlca, pCAUD63DInputRec, pCAUD63DOutputRec);
                            
                            //  Analyze error code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    break;
                                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                    rc = Csub50s.FND_FAIL;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                            
                            if ((SUCCESS == rc) && (pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getUlIdPersMergeForward() != pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getUlIdPersMergeClosed())) {
                                pCAUD63DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                pCAUD63DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                pCAUD63DInputRec.setUlIdPersMergeClosed(pCLSS49DOutputRec.getROWCLSS49DO_ARRAY().getROWCLSS49DO(i18).getUlIdPersMergeClosed());
                                pCAUD63DInputRec.setDtDtPersMerge(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMerge());
                                pCAUD63DInputRec.setDtDtPersMergeSplit(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMergeSplit());
                                pCAUD63DInputRec.setUlIdPersMergeWrkr(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeWrkr());
                                pCAUD63DInputRec.setCIndPersMergeInvalid(FND_NO);
                                pCAUD63DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                rc = caud63dAUDdam(sqlca, pCAUD63DInputRec, pCAUD63DOutputRec);
                                
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        break;
                                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                        
                                        
                                        //  Call CLSS34D
                                        rc = Csub50s.FND_FAIL;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                        //##                      sprintf(pReturnPB->appl_status.explan_data,"%u",
                                        //##                             pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                                        break;
                                }
                            }
                        }
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        //  Set explan_data to usInputRow
                        //##                     sprintf(pReturnPB->appl_status.explan_data,
                        //##                            "%u",
                        //##                       pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            
            if (SUCCESS == rc) {
                pCAUD63DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                pCAUD63DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                pCAUD63DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                pCAUD63DInputRec.setDtDtPersMerge(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMerge());
                pCAUD63DInputRec.setDtDtPersMergeSplit(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMergeSplit());
                pCAUD63DInputRec.setUlIdPersMergeWrkr(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeWrkr());
                pCAUD63DInputRec.setCIndPersMergeInvalid(FND_NO);
                pCAUD63DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                rc = caud63dAUDdam(sqlca, pCAUD63DInputRec, pCAUD63DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                        
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                        
                        
                        //  Call CMSC12D
                        rc = Csub50s.FND_FAIL;
                        //##                      sprintf(pReturnPB->appl_status.explan_data,
                        //##                              "%u",
                        //##                              pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            
            if (SUCCESS == rc) {
                CAUD74DI.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                CAUD74DI.getCdPersonStatus()[0] = CD_MERGED;
                
                //  Set rc to ARC_SUCCESS
                rc = Ccmn02u.CallCAUD74D(CAUD74DI, CAUD74DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
            if (SUCCESS == rc) {
                CAUD74DI.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                if (bIndPersForwardActive || bIndPersCloseActive) {
                    CAUD74DI.getCdPersonStatus()[0] = CD_ACTIVE;
                }
                else {
                    CAUD74DI.getCdPersonStatus()[0] = CD_INACTIVE;
                }
                
                
                //  Set rc to ARC_SUCCESS
                //Srini 02/24/03  Set the rc value to explain code as we check on rc value in the
                //TUX_CHECK_APPL_STATUS macro.
                //        rc = ARC_SUCCESS;
                rc = Ccmn02u.CallCAUD74D(CAUD74DI, CAUD74DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
            
            //  Analyze error code
            if (SUCCESS == rc) {
                // 
                // Call the Duplicate Stage Person Link Retrieval Dam - CLSC83D
                // Description - This DAM will retrieve the id_stage for all rows
                // in the stage_person_link table with duplicate
                // spl id's.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSC83DInputRec = new CLSC83DI();
                
                pCLSC83DOutputRec = new CLSC83DO();
                pCLSC83DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                pCLSC83DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                pCLSC83DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                pCLSC83DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                pCLSC83DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC83DO._CLSC83DO__ROWCLSC83DO_SIZE);
                //  Validate Resource ID
                rc = clsc83dQUERYdam(sqlca, pCLSC83DInputRec, pCLSC83DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        
                        // for loop to go through all the rows retrieved by clsc83d
                        
                        for (i18 = 0;i18 < pCLSC83DOutputRec.getArchOutputStruct().getUlRowQty();i18++) {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCLSS74DInputRec = new CLSS74DI();
                            
                            pCLSS74DOutputRec = new CLSS74DO();
                            
                            
                            // 
                            // Service Macro Definitions
                            // 
                            //  Window to Window input function indicators
                            
                            // 
                            // Function Prototypes
                            // 
                            
                            pCLSS74DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                            pCLSS74DInputRec.setUlIdStage(pCLSC83DOutputRec.getROWCLSC83DO_ARRAY().getROWCLSC83DO(i18).getUlIdStage());
                            pCLSS74DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                            
                            pCLSS74DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS74DO._CLSS74DO__ROWCLSS74DO_SIZE);
                            // Retrieve RESOURCE's Payment History
                            rc = clss74dQUERYdam(sqlca, pCLSS74DInputRec, pCLSS74DOutputRec);
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    // 
                                    // Call the Stage Person Merge AUD Dam - CAUDC5D
                                    // Description - This DAM will return id_stage_person_link, id_stage,
                                    // id_person, cd_stage_pers_role, dt_last_update for
                                    // duplicate rows (spl id's) in the stage_person_link table.
                                    // 
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCAUDC5DInputRec = new CAUDC5DI();
                                    
                                    pCAUDC5DOutputRec = new CAUDC5DO();
                                    pCAUDC5DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                                    
                                    // set counter
                                    x = 0;
                                    
                                    // for loop to go through all the rows retrieved by clss74d
                                    
                                    for (j = 0;j < pCLSS74DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                        
                                        if ((pCLSS74DOutputRec.getROWCLSS74DO_ARRAY().getROWCLSS74DO(j).getUlIdPerson() == ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward()) || (pCLSS74DOutputRec.getROWCLSS74DO_ARRAY().getROWCLSS74DO(j).getUlIdPerson() == ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed())) {
                                            
                                            if (0 == pCLSS74DOutputRec.getROWCLSS74DO_ARRAY().getROWCLSS74DO(j).getSzCdStagePersType().compareTo(PRINCIPAL)) {
                                                bPrincipal = true;
                                            }
                                            
                                            if (x == 0) {
                                                iRowToUpdate = j;
                                            }
                                            else {
                                                pCAUDC5DInputRec.setUlIdStagePerson(pCLSS74DOutputRec.getROWCLSS74DO_ARRAY().getROWCLSS74DO(j).getUlIdStagePerson());
                                                pCAUDC5DInputRec.setTsLastUpdate(pCLSS74DOutputRec.getROWCLSS74DO_ARRAY().getROWCLSS74DO(j).getTsLastUpdate());
                                                pCAUDC5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                                                //  Retrieve Total Payment Information
                                                rc = caudc5dAUDdam(sqlca, pCAUDC5DInputRec, pCAUDC5DOutputRec);
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = SUCCESS;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        break;
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                                        //  Validate Contract ID
                                                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                                        //##                                           sprintf(pReturnPB->appl_status.explan_data,
                                                        //##                                                   "%u",
                                                        //##                                                   pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                                                        break;
                                                        
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                                        break;
                                                }
                                            }
                                            x++;
                                        }
                                    }
                                    pCAUDC5DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                    pCAUDC5DInputRec.setUlIdStagePerson(pCLSS74DOutputRec.getROWCLSS74DO_ARRAY().getROWCLSS74DO(iRowToUpdate).getUlIdStagePerson());
                                    pCAUDC5DInputRec.setTsLastUpdate(pCLSS74DOutputRec.getROWCLSS74DO_ARRAY().getROWCLSS74DO(iRowToUpdate).getTsLastUpdate());
                                    
                                    if (bPrincipal) {
                                        pCAUDC5DInputRec.setSzCdStagePersType(PRINCIPAL);
                                    }
                                    else {
                                        // Process utility function failure
                                        pCAUDC5DInputRec.setSzCdStagePersType(COLLATERAL);
                                    }
                                    pCAUDC5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                    // Retrieve Contracts's Payment History
                                    rc = caudc5dAUDdam(sqlca, pCAUDC5DInputRec, pCAUDC5DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = SUCCESS;
                                            pServiceStatus.explan_code = SUCCESS;
                                            //  Retrieve Total Payment Information
                                            rc = SUCCESS;
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                            rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                            
                                            break;
                                            
                                    }
                                    //##                              sprintf(pReturnPB->appl_status.explan_data,
                                    //##                                      "%u",
                                    //##                                      pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                                    rc = Csub50s.FND_FAIL;
                                    //##                              sprintf(pReturnPB->appl_status.explan_data,
                                    //##                                      "%u",
                                    //##                                      pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                    break;
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Call DAM
                        rc = SUCCESS;
                        break;
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        
                        break;
                }
            }
            
            if (SUCCESS == rc) {
                
                // 
                // Call the Stage Person Link AUD Dam - CAUD73D
                // Description - This DAM updates all the rows in the STAGE_PERSON_LINK table
                // for open stages, replacing IdMergeClosed with IdMergeForward.
                // 
                //  Allocate memory for DAM Input and Output Structures
                
                pCAUD73DInputRec = new CAUD73DI();
                
                pCAUD73DOutputRec = new CAUD73DO();
                pCAUD73DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                pCAUD73DInputRec.setUlIdPersMergeForward(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                
                pCAUD73DInputRec.setUlIdPersMergeClosed(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                pCAUD73DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                rc = caud73dAUDdam(sqlca, pCAUD73DInputRec, pCAUD73DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        //  This employee is not a Unit Approver:
                        // continue processing the rest of the service.
                        rc = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
            }
            
            if (SUCCESS == rc) {
                CSECA4DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                CSECA4DI.setUlIdPersEligPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                bEA_Open.value = 0;
                rc = Ccmn02u.CallCSECA4D(CSECA4DI, CSECA4DO, bEA_Open, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                
                CAUDD1DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                CAUDD1DI.setSzCdPersEligType(CSECA4DO.getSzCdPersEligType());
                CAUDD1DI.setDtDtPersEligStart(CSECA4DO.getDtDtPersEligStart());
                //## END TUX/XML: Turn the XML buffer into an input message struct
                
                
                
                if (CSECA4DO.getDtDtPersEligEnd().year == - 1) {
                    CAUDD1DI.getDtDtPersEligEnd().month = ORACLE_END_MONTH;
                    CAUDD1DI.getDtDtPersEligEnd().day = ORACLE_END_DAY;
                    CAUDD1DI.getDtDtPersEligEnd().year = ORACLE_END_YEAR;
                }
                
                else {
                    CAUDD1DI.setDtDtPersEligEnd(CSECA4DO.getDtDtPersEligEnd());
                }
                
                if (CSECA4DO.getDtDtPersEligEaDeny().year == - 1) {
                    CAUDD1DI.getDtDtPersEligEaDeny().month = ORACLE_END_MONTH;
                    CAUDD1DI.getDtDtPersEligEaDeny().day = ORACLE_END_DAY;
                    //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
                    // SQL error returned from the DAM.
                    CAUDD1DI.getDtDtPersEligEaDeny().year = ORACLE_END_YEAR;
                }
                else {
                    
                    CAUDD1DI.setDtDtPersEligEaDeny(CSECA4DO.getDtDtPersEligEaDeny());
                }
                CAUDD1DI.setCdPersEligPrgStart(CSECA4DO.getCdPersEligPrgStart());
                CAUDD1DI.setCdPersEligPrgOpen(CSECA4DO.getCdPersEligPrgOpen());
                CAUDD1DI.setCdPersEligPrgClose(CSECA4DO.getCdPersEligPrgClose());
                
                ClosedStartDate = CSECA4DO.getDtDtPersEligStart();
                
                // 
                // (BEGIN): Retrieve Caps Resource Record
                // 
                
                if (bEA_Open.value != 0) {
                    CSECA4DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                    //  PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                    // SQL error returned from the DAM.
                    CSECA4DI.setUlIdPersEligPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                    bEA_Open.value = 0;
                    rc = Ccmn02u.CallCSECA4D(CSECA4DI, CSECA4DO, bEA_Open, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    ForwardStartDate = CSECA4DO.getDtDtPersEligStart();
                    if (bEA_Open.value != 0) {
                        if ((ClosedStartDate.year < ForwardStartDate.year) || ((ClosedStartDate.year == ForwardStartDate.year) && (ClosedStartDate.month < ForwardStartDate.month)) || ((ClosedStartDate.year == ForwardStartDate.year) && (ClosedStartDate.month == ForwardStartDate.month) && (ClosedStartDate.day < ForwardStartDate.day))) {
                            CAUDD1DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            CAUDD1DI.setUlIdPersElig(CSECA4DO.getUlIdPersElig());
                            CAUDD1DI.setUlIdPersEligPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                            
                            //  Call DAM
                            rc = CallCAUDD1D(CAUDD1DI, CAUDD1DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        }
                    }
                    else {
                        CAUDD1DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        CAUDD1DI.setUlIdPersEligPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                        rc = CallCAUDD1D(CAUDD1DI, CAUDD1DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                }
                
            }
            
            if (SUCCESS == rc) {
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                CLSC86DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                
                CLSC86DI.setUlIdPersEligPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                bDHS_Found.value = 0;
                rc = CallCLSC86D(CLSC86DI, CLSC86DO, bDHS_Found, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                if (bDHS_Found.value != 0) {
                    
                    for (i18 = 0;i18 < CLSC86DO.getArchOutputStruct().getUlRowQty();i18++) {
                        CSECA6DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                        CSECA6DI.setUlIdPersEligPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                        CSECA6DI.setSzCdPersEligType(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getSzCdPersEligType());
                        CSECA6DI.setDtDtPersEligStart(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligStart());
                        
                        
                        // 
                        // (END): Retrieve Caps Resource Record
                        // 
                        
                        
                        if (CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEnd().year == - 1) {
                            CSECA6DI.getDtDtPersEligEnd().month = ORACLE_END_MONTH;
                            CSECA6DI.getDtDtPersEligEnd().day = ORACLE_END_DAY;
                            CSECA6DI.getDtDtPersEligEnd().year = ORACLE_END_YEAR;
                        }
                        else {
                            //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                            // SQL error returned from the DAM.
                            CSECA6DI.setDtDtPersEligEnd(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEnd());
                        }
                        
                        // 
                        // (BEGIN): Retrieve Resource History Record
                        // 
                        
                        if (CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEaDeny().year == - 1) {
                            
                            CSECA6DI.getDtDtPersEligEaDeny().month = ORACLE_END_MONTH;
                            
                            //## BEGIN TUX/XML: Declare XML variables 
                            CSECA6DI.getDtDtPersEligEaDeny().day = ORACLE_END_DAY;
                            CSECA6DI.getDtDtPersEligEaDeny().year = ORACLE_END_YEAR;
                        }
                        else {
                            CSECA6DI.setDtDtPersEligEaDeny(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEaDeny());
                        }
                        CSECA6DI.setCdPersEligPrgStart(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getCdPersEligPrgStart());
                        CSECA6DI.setCdPersEligPrgOpen(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getCdPersEligPrgOpen());
                        CSECA6DI.setCdPersEligPrgClose(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getCdPersEligPrgClose());
                        bRowDifferent.value = 0;
                        //  This employee is not a Unit Approver: 
                        // continue processing the rest of the service.
                        rc = CallCSECA6D2(CSECA6DI, CSECA6DO, bRowDifferent, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        if (bRowDifferent.value != 0) {
                            CAUDD2DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                            CAUDD2DI.setUlIdPersEligPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                            CAUDD2DI.setSzCdPersEligType(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getSzCdPersEligType());
                            CAUDD2DI.setDtDtPersEligStart(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligStart());
                            if (CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEnd().year == - 1) {
                                CAUDD2DI.getDtDtPersEligEnd().month = ORACLE_END_MONTH;
                                CAUDD2DI.getDtDtPersEligEnd().day = ORACLE_END_DAY;
                                CAUDD2DI.getDtDtPersEligEnd().year = ORACLE_END_YEAR;
                                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                
                                
                            }
                            else {
                                CAUDD2DI.setDtDtPersEligEnd(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEnd());
                            }
                            
                            
                            // 
                            // (END): Retrieve Resource History Record
                            // 
                            
                            
                            // 
                            // (BEGIN): Retrieve Resource Characteristics
                            // 
                            
                            if (CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEaDeny().year == - 1) {
                                CAUDD2DI.getDtDtPersEligEaDeny().month = ORACLE_END_MONTH;
                                CAUDD2DI.getDtDtPersEligEaDeny().day = ORACLE_END_DAY;
                                CAUDD2DI.getDtDtPersEligEaDeny().year = ORACLE_END_YEAR;
                            }
                            else {
                                CAUDD2DI.setDtDtPersEligEaDeny(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getDtDtPersEligEaDeny());
                            }
                            CAUDD2DI.setCdPersEligPrgStart(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getCdPersEligPrgStart());
                            CAUDD2DI.setCdPersEligPrgOpen(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getCdPersEligPrgOpen());
                            CAUDD2DI.setCdPersEligPrgClose(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getCdPersEligPrgClose());
                            rc = CallCAUDD2D(CAUDD2DI, CAUDD2DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            CLSC87DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                            CLSC87DI.setUlIdPersElig(CLSC86DO.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i18).getUlIdPersElig());
                            CLSC87DI.setIdPersEligDtlPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
                            rc = CallCLSC87D(CLSC87DI, CLSC87DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            CAUDD3DI.setArchInputStruct(ccfc14si.getArchInputStruct());
                            
                            
                            for (a = 0;a < CLSC87DO.getArchOutputStruct().getUlRowQty();a++) {
                                CAUDD3DI.setUlIdPersElig(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getUlIdPersElig());
                                CAUDD3DI.setIdPersEligDtlPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                                CAUDD3DI.setMoPersEligDtlMonth(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getMoPersEligDtlMonth());
                                CAUDD3DI.setYrPersEligDtlYear(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getYrPersEligDtlYear());
                                CAUDD3DI.setCdPersEligDtlEligCode(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getCdPersEligDtlEligCode());
                                CAUDD3DI.setCdPersEligDtlTypeCase(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getCdPersEligDtlTypeCase());
                                CAUDD3DI.setCdPersEligDtlMedCov(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getCdPersEligDtlMedCov());
                                CAUDD3DI.setCdPersEligDtlStatInGrp(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getCdPersEligDtlStatInGrp());
                                CAUDD3DI.setCdPersEligDtlCaseStatus(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getCdPersEligDtlCaseStatus());
                                
                                CAUDD3DI.setCdPersEligDtlProgType(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getCdPersEligDtlProgType());
                                CAUDD3DI.setCdPersEligDtlCaseCateg(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getCdPersEligDtlCaseCateg());
                                CAUDD3DI.setDtPersEligDtlCaseCert(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getDtPersEligDtlCaseCert());
                                CAUDD3DI.setNbrPersEligDtlCaseNbr(CLSC87DO.getROWCLSC87DO_ARRAY().getROWCLSC87DO(a).getNbrPersEligDtlCaseNbr());
                                
                                //  The code in ccmn05u.src was analyzed and it was determined
                                // that no harm would befall this logic if it was allowed to
                                // invalidate an approval that had already been rejected or
                                // completed.
                                // We need this functionality because the only way a user will
                                // be able to modify a rejected intake will be to answer yes to
                                // the prompt to modify a submitted call, and proceed as normal.
                                // The service was coded to invalidate approvals if the incoming
                                // status was SBA, which it will be, and reset that status 
                                // according to the actions of the user.  Long live INTAKE.
                                // 08/01/95 MED
                                rc = CallCAUDD3D(CAUDD3DI, CAUDD3DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            }
                        }
                        
                    }
                }
            }
        }
        if (SUCCESS == rc) {
            
            // 
            // Call the Stage Person Link Retrieval Dam - CMSC23D
            // Description - This DAM a list of Stages where the Id Person (and all
            // persons merged with them) are on the Stage Person Link.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC23DInputRec = new CMSC23DI();
            
            pCMSC23DOutputRec = new CMSC23DO();
            pCMSC23DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
            pCMSC23DInputRec.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
            
            pCMSC23DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
            pCMSC23DInputRec.getArchInputStruct().setUlPageSizeNbr(CMSC23DO._CMSC23DO__ROWCMSC23DO_SIZE);
            
            rc = cmsc23dQUERYdam(sqlca, pCMSC23DInputRec, pCMSC23DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Initialize the FA home and Ind Case flags to false.
                    bIndFAHome = false;
                    bIndCase = false;
                    
                    //  Determine if the FAHome is a category or if the person forward
                    // is a principal or collateral.
                    for (i18 = 0;i18 < pCMSC23DOutputRec.getArchOutputStruct().getUlRowQty();i18++) {
                        if ((pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i18).getSzCdStage().equals(FA_HOME)) && ((pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i18).getSzCdStagePersType().equals(PRINCIPAL)) || (pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i18).getSzCdStagePersType().equals(COLLATERAL)))) {
                            bIndFAHome = true;
                        }
                        
                        
                        // 
                        // (END): Retrieve Resource Characteristics
                        // 
                        
                        // 
                        // (BEGIN): Retrieve Home Interest Ethnicities
                        // 
                        
                        if ((pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i18).getSzCdStagePersType().equals(PRINCIPAL)) || (pCMSC23DOutputRec.getROWCMSC23DO_ARRAY().getROWCMSC23DO(i18).getSzCdStagePersType().equals(COLLATERAL))) {
                            bIndCase = true;
                        }
                    }
                    if (bIndCase || bIndFAHome) {
                        //  Delete the current categories except FEM or EMP
                        // 
                        // Call the Category AUD Dam - CAUD66D
                        // Description - Deletes the CATEGORY table using the criteria from
                        // PERSON_MERGE.  Note this is done for both person
                        // merge and split.
                        // DELETE PERSON_CATEGORY  WHERE  ID_PERSON = :hI_ulIdPerson:hI_ulIdPerson_i
                        // AND    CD_PERSON_CATEGORY <>  'FEM'
                        // AND    CD_PERSON_CATEGORY <>  'EMP';
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUD66DInputRec = new CAUD66DI();
                        
                        pCAUD66DOutputRec = new CAUD66DO();
                        pCAUD66DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                        pCAUD66DInputRec.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                        pCAUD66DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                        rc = caud66dAUDdam(sqlca, pCAUD66DInputRec, pCAUD66DOutputRec);
                        
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                break;
                                
                            default :
                                rc = SUCCESS;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                //##                     sprintf(pReturnPB->appl_status.explan_data,
                                //##                             "%u",
                                //##                             pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                                break;
                        }
                    }
                    if (bIndCase) {
                        // 
                        // Call the Person Category AUD Dam - CCMNC2D
                        // Description - This DAM performs ADD/UPDATE/DELETE functionality on the
                        // PERSON CATEGORY table.
                        // ADD    - Full row add minus column DT LAST UPDATE
                        // UPDATE - Update CD PERSON CATEGORY given a search
                        // key of ID PERSON and a CD PERSON CATEGORY.
                        // The timestamp is not used.
                        // DELETE - Delete not performed
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMNC2DInputRec = new CCMNC2DI();
                        
                        pCCMNC2DOutputRec = new CCMNC2DO();
                        pCCMNC2DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                        pCCMNC2DInputRec.setSzCdCategoryCategory(CAS_CATEGORY);
                        pCCMNC2DInputRec.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                        pCCMNC2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        rc = ccmnc2dAUDdam(sqlca, pCCMNC2DInputRec, pCCMNC2DOutputRec);
                        
                        switch (rc) {
                                
                                //  On an UPDATE or DELETE statement, SQL_NOT_FOUND will be returned
                                // if there are no records meeting the WHERE clause criteria.  In
                                // most cases this will be caused by a timestamp mismatch.
                                // pServiceStatus->explan_code should be set to the appropriate
                                // message by the programmer.
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                break;
                                
                                //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                                // if there is an attempt to store a duplicate primary key value.
                                // pServiceStatus->explan_code and pServiceStatus->severity should 
                                // be set to the appropriate values by the programmer.
                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                rc = Csub50s.FND_FAIL;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                
                                //##                                     sprintf(pReturnPB->appl_status.explan_data,
                                //##                                             "%u",
                                //##                                             pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                                break;
                        }
                    }
                    
                    
                    // 
                    // (END): Retrieve Home Interest Ethnicities
                    // 
                    
                    // 
                    // (BEGIN): Retrieve Resource Address
                    // 
                    
                    if (bIndFAHome) {
                        // 
                        // Call the Person Category AUD Dam - CCMNC2D
                        // Description - This DAM performs ADD/UPDATE/DELETE functionality on the
                        // PERSON CATEGORY table.
                        // ADD    - Full row add minus column DT LAST UPDATE
                        // UPDATE - Update CD PERSON CATEGORY given a search
                        // key of ID PERSON and a CD PERSON CATEGORY.
                        // The timestamp is not used.
                        // DELETE - Delete not performed
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMNC2DInputRec = new CCMNC2DI();
                        
                        pCCMNC2DOutputRec = new CCMNC2DO();
                        pCCMNC2DInputRec.setArchInputStruct(ccfc14si.getArchInputStruct());
                        pCCMNC2DInputRec.setSzCdCategoryCategory(FAH_CATEGORY);
                        pCCMNC2DInputRec.setUlIdPerson(ccfc14si.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                        pCCMNC2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        rc = ccmnc2dAUDdam(sqlca, pCCMNC2DInputRec, pCCMNC2DOutputRec);
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                break;
                                
                            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                                rc = Csub50s.FND_FAIL;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
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
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    //##                        sprintf(pReturnPB->appl_status.explan_data,
                    //##                                "%u",
                    //##                                pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                    break;
            }
        }
        rc = CallToDo(ccfc14si, ccfc14so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc14si.getArchInputStruct() , ccfc14so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCFC14S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Start Performance Timer
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCFC14S \n");
        }
        return ccfc14so;
    }

    static int CallToDo(CCFC14SI pInputMsg8, CCFC14SO * pOutputMsg11, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int usRow = 0;
        int i19 = 0;
        int rc = 0;
        CLSC48DI pCLSC48DInputRec = null;
        CLSC48DO pCLSC48DOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;
        CSUB40UO pCSUB40UOutputRec = null;
        String TxtToDoDesc = new String();
        String TxtToDoLongDesc = new String();
        
        /*
        ** Allocate memory for DAM Input and Output Structures that is called inside
        ** the for loop.
        */
        
        pCLSC48DInputRec = new CLSC48DI();
        
        pCLSC48DOutputRec = new CLSC48DO();
        
        pCSUB40UInputRec = new CSUB40UI();
        
        pCSUB40UOutputRec = new CSUB40UO();
        
        
        /*
        ** Loop through all of the rows in case there is a multiple split involved.
        */
        for (usRow = 0;((usRow < pInputMsg8.getArchInputStruct().getUlPageSizeNbr()) && (WtcHelperConstants.ARC_SUCCESS == rc));usRow++) {
            pCLSC48DInputRec.setArchInputStruct(pInputMsg8.getArchInputStruct());
            pCLSC48DInputRec.setUlIdPersMergeForward(pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeForward());
            pCLSC48DInputRec.setUlIdPersMergeClosed(pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed());
            pCLSC48DInputRec.setUlIdPerson(pInputMsg8.getUlIdPersonRequestor());
            pCLSC48DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
            
            pCLSC48DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC48DO._CLSC48DO__ROWCLSC48DO_SIZE);
            rc = clsc48dQUERYdam(sqlca, pCLSC48DInputRec, pCLSC48DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    TxtToDoDesc = pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeClosed();
                    if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == pInputMsg8.getArchInputStruct().getCReqFuncCd()) {
                        strncat(TxtToDoDesc, SPLIT_SHORT_DESC, SSD_LENGTH);
                        TxtToDoLongDesc = (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeClosed()) + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed()) + " " + SPLIT_LONG_DESC + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeForward()) + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeForward()) + " " + BY_STRING + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMrgSpltWrkr()) + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeSplitWrkr());
                    }
                    else {
                        strncat(TxtToDoDesc, MERGE_SHORT_DESC, MSD_LENGTH);
                        TxtToDoLongDesc = (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeClosed()) + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeClosed()) + " " + MERGED_LONG_DESC + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeForward()) + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeForward()) + " " + BY_STRING + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeWrkr()) + " " + (pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeWrkr());
                    }
                    strncat(TxtToDoDesc, pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getSzScrNmPersMergeForward() , CCFC50SI.SCR_NM_PERS_MERGE_FORWARD_LEN);
                    
                    //  Loop through all of the workers that were returned form the clsc48d dam
                    // and send each one an alert about the merge.
                    for (i19 = 0;((i19 < pCLSC48DOutputRec.getArchOutputStruct().getUlRowQty()) && (WtcHelperConstants.ARC_SUCCESS == rc));i19++) {
                        
                        
                        pCSUB40UInputRec.setArchInputStruct(pInputMsg8.getArchInputStruct());
                        
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TxtToDoDesc);
                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfLongDesc(TxtToDoLongDesc);
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(pCLSC48DOutputRec.getROWCLSC48DO_ARRAY().getROWCLSC48DO(i19).getUlIdStage());
                        pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCLSC48DOutputRec.getROWCLSC48DO_ARRAY().getROWCLSC48DO(i19).getUlIdPerson());
                        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == pInputMsg8.getArchInputStruct().getCReqFuncCd()) {
                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getDtDtPersMergeSplit());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeSplitWrkr());
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(SPLIT_TODO_CD);
                        }
                        else {
                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getDtDtPersMerge());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(pInputMsg8.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(usRow).getUlIdPersMergeWrkr());
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(MERGE_TODO_CD);
                        }
                        pCSUB40UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        
                        
                        //  Call CAUD17D.  Update the services for the
                        // current version.
                        rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                        
                        switch (rc) 
                        {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                                
                        }
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    // 
                    // (END): Retrieve DAM: ccmn29d      Retrieve STF from StagePersonLink 
                    // 
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        return rc;
    }

    static int CallCompareRecChk(CCFC14SI pInputMsg9, CCFC14SO * pOutputMsg12, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i20 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        
        int tempIndex = 0;
        char bInsertRecChk = 0;
        
        CLSC53DI PersonForwardInput = null;
        CLSC53DO PersonForwardOutput = null;
        
        CLSC53DI PersonClosedInput = null;
        CLSC53DO PersonClosedOutput = null;
        
        FndInt3date ClosedStartDate = null;
        FndInt3date ForwardStartDate = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonForwardInput = new CLSC53DI();
        PersonForwardOutput = new CLSC53DO();
        PersonClosedInput = new CLSC53DI();
        PersonClosedOutput = new CLSC53DO();
        /*
        ** If the Corrective Action != "Other"
        */
        if ((PersonForwardInput == null) || (PersonForwardOutput == null) || (PersonClosedInput == null) || (PersonClosedOutput == null)) {
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        rc = CallCLSC53D(pInputMsg9.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward() , PersonForwardOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        rc = CallCLSC53D(pInputMsg9.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed() , PersonClosedOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        for (i20 = 0;i20 < PersonClosedOutput.getArchOutputStruct().getUlRowQty();i20++) {
            tempIndex = i20;
            ClosedStartDate = PersonClosedOutput.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i20).getDtDtRecCheckRequest();
            if (!(DPS_CODE.compareTo(PersonClosedOutput.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i20).getSzCdRecCheckCheckType()) != 0) ||!(FBI_EXIGENT_CHK.compareTo(PersonClosedOutput.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i20).getSzCdRecCheckCheckType()) != 0) ||!(FPS_HISTORY_CHK.compareTo(PersonClosedOutput.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i20).getSzCdRecCheckCheckType()) != 0) ||!(DPS_DIRECT_CHK.compareTo(PersonClosedOutput.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i20).getSzCdRecCheckCheckType()) != 0) ||!(CENTRAL_REGISTRY.compareTo(PersonClosedOutput.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i20).getSzCdRecCheckCheckType()) != 0)) {
                rc = CallCAUD87D(pInputMsg9, PersonClosedOutput, tempIndex, pServiceStatus);
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        return rc;
    }

    static int CallCLSC53D(int iPersonId, CLSC53DO pOutputMsg13, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        int rc = 0;
        int retCaud87 = 0;/* Return code from caud87d */
        int i21 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        CLSC53DI pCLSC53DInputRec = null;
        CLSC53DO pCLSC53DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC53DInputRec = new CLSC53DI();
        
        pCLSC53DOutputRec = new CLSC53DO();
        pCLSC53DInputRec.setArchInputStruct(pInputMsg.getArchInputStruct());
        pCLSC53DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC53DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC53DO._CLSC53DO__ROWCLSC53DO_SIZE);
        pCLSC53DInputRec.setUlIdRecCheckPerson(iPersonId);
        
        rc = clsc53dQUERYdam(sqlca, pCLSC53DInputRec, pCLSC53DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i21 = 0;i21 < pCLSC53DOutputRec.getArchOutputStruct().getUlRowQty();i21++) {
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setSzCdRecCheckCheckType(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getSzCdRecCheckCheckType());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setSzCdRecCheckStatus(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getSzCdRecCheckStatus());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setSzTxtRecCheckComments(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getSzTxtRecCheckComments());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setDtDtRecCheckCompleted(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getDtDtRecCheckCompleted());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setDtDtRecCheckRequest(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getDtDtRecCheckRequest());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setTsLastUpdate(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getTsLastUpdate());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setUlIdRecCheck(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getUlIdRecCheck());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setUlIdRecCheckPerson(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getUlIdRecCheckPerson());
                    
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setUlIdRecCheckRequestor(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getUlIdRecCheckRequestor());
                    pOutputMsg13.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).setUlIdStage(pCLSC53DOutputRec.getROWCLSC53DO_ARRAY().getROWCLSC53DO(i21).getUlIdStage());
                }
                pOutputMsg13.getArchOutputStruct().setUlRowQty(pCLSC53DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg13.getArchOutputStruct().setBMoreDataInd(pCLSC53DOutputRec.getArchOutputStruct().getBMoreDataInd());
                // CONTRACT COUNTY update
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pOutputMsg13.getArchOutputStruct().setUlRowQty(0);
                pOutputMsg13.getArchOutputStruct().setBMoreDataInd(pCLSC53DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCAUD87D(CCFC14SI pInputMsg10, CLSC53DO pOutputMsg14, int k, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        
        CAUD87DI pCAUD87DInputRec = null;
        CAUD87DO pCAUD87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD87DInputRec = new CAUD87DI();
        
        pCAUD87DOutputRec = new CAUD87DO();
        pCAUD87DInputRec.setArchInputStruct(pInputMsg10.getArchInputStruct());
        pCAUD87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD87DInputRec.setSzCdRecCheckCheckType(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getSzCdRecCheckCheckType());
        pCAUD87DInputRec.setSzCdRecCheckStatus(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getSzCdRecCheckStatus());
        pCAUD87DInputRec.setSzTxtRecCheckComments(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getSzTxtRecCheckComments());
        pCAUD87DInputRec.setDtDtRecCheckCompleted(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getDtDtRecCheckCompleted());
        pCAUD87DInputRec.setDtDtRecCheckRequest(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getDtDtRecCheckRequest());
        pCAUD87DInputRec.setTsLastUpdate(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getTsLastUpdate());
        pCAUD87DInputRec.setUlIdRecCheck(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getUlIdRecCheck());
        pCAUD87DInputRec.setUlIdRecCheckPerson(pInputMsg10.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCAUD87DInputRec.setUlIdRecCheckRequestor(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getUlIdRecCheckRequestor());
        pCAUD87DInputRec.setUlIdStage(pOutputMsg14.getROWCLSC53DO_ARRAY().getROWCLSC53DO(k).getUlIdStage());
        rc = caud87dAUDdam(sqlca, pCAUD87DInputRec, pCAUD87DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                
                //  CSYS06D - CNTCT DTL NARR -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
                
                
                //  Start Performance Timer
                rc = Messages.MSG_DUPLICATE_RECORD;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCompareIncome(CCFC14SI pInputMsg11, CCFC14SO * pOutputMsg15, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        int retCaud88 = 0;
        int i22 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        String szTemp = new String();
        int tempIndex = 0;
        int lRCTo = 0;/* Return code for Date Compare */
        int lRCFrom = 0;/* Return code for Date Compare */
        int lRCSys = 0;/* Return code for Date Compare */
        
        /* string to hold the concatenated Education for comparison */
        String szForward = new String();
        String szClosed = new String();
        
        boolean bInsertIncome = false;
        
        CLSS58DI PersonClosedInput = null;
        CLSS58DO PersonClosedOutput = null;
        
        CLSS58DI PersonForwardInput = null;
        CLSS58DO PersonForwardOutput = null;
        
        
        FndInt3date dtSysdate = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonClosedInput = new CLSS58DI();
        PersonClosedOutput = new CLSS58DO();
        PersonForwardInput = new CLSS58DI();
        PersonForwardOutput = new CLSS58DO();
        
        /*
        ** SIR#20654: It is necessary to change InputRec to
        ** DtSvcAuthEff if there is a Effective Date
        */
        if ((PersonClosedInput == null) || (PersonClosedOutput == null) || (PersonForwardOutput == null) || (PersonForwardInput == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        
        /*
        ** Call CCMN06U
        */
        rc = ARC_UTLGetDateAndTime(dtSysdate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        PersonClosedInput.setUlIdPerson(pInputMsg11.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        rc = CallCLSS58D(PersonClosedInput, PersonClosedOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        PersonForwardInput.setUlIdPerson(pInputMsg11.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        rc = CallCLSS58D(PersonForwardInput, PersonForwardOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        for (i22 = 0;i22 < PersonClosedOutput.getArchOutputStruct().getUlRowQty();i22++) {
            tempIndex = i22;
            szClosed = NULL_STRING;
            szTemp = PersonClosedOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i22).getSzCdIncRsrcIncome();
            szClosed = szTemp;
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i22).getSzCdIncRsrcType();
            
            strncat(szClosed, szTemp, szTemp.length());
            
            // if dtDtIncRsrcTo is not max date, check to see if it's after today
            lRCSys = 1;
            if (PersonClosedOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i22).getDtDtIncRsrcTo().year != DateHelper.NULL_DATE && PersonClosedOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i22).getDtDtIncRsrcTo().month != DateHelper.NULL_DATE && PersonClosedOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i22).getDtDtIncRsrcTo().day != DateHelper.NULL_DATE) {
                lRCSys = ARC_UTLCompareDateAndTime((FndInt3date) & PersonClosedOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i22).getDtDtIncRsrcTo() , 0, (FndInt3date) & dtSysdate, 0);
            }
            szForward = NULL_STRING;
            // select one record and compare it with all the existing incomes in
            // person forward. insert if no match found
            for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty() && lRCSys > 0;j++) {
                szTemp = PersonForwardOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(j).getSzCdIncRsrcIncome();
                szForward = szTemp;
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(j).getSzCdIncRsrcType();
                strncat(szForward, szTemp, szTemp.length());
                lRCFrom = 0;
                if (PersonForwardOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(j).getDtDtIncRsrcTo().year != DateHelper.NULL_DATE && PersonForwardOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(j).getDtDtIncRsrcTo().month != DateHelper.NULL_DATE && PersonForwardOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(j).getDtDtIncRsrcTo().day != DateHelper.NULL_DATE) {
                    lRCFrom = ARC_UTLCompareDateAndTime((FndInt3date) & PersonClosedOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i22).getDtDtIncRsrcFrom() , 0, (FndInt3date) & PersonForwardOutput.getROWCLSS58DO_ARRAY().getROWCLSS58DO(j).getDtDtIncRsrcTo() , 0);
                }
                if (0 != szForward.compareTo(szClosed)) {
                    bInsertIncome = true;
                }
                else if (lRCFrom > 0) {
                    bInsertIncome = true;
                }
                else {
                    bInsertIncome = false;
                    
                    
                    // 
                    // End Call to EVENT STATUS AUD Dam - CAUD64D
                    // 
                    
                    break;
                }
                szForward = NULL_STRING;
            }
            if (PersonForwardOutput.getArchOutputStruct().getUlRowQty() == 0) {
                bInsertIncome = true;
            }
            
            //  SIR# ETW: Add CSES26D to retrieve Dt Situation Opened
            // Retrieve Dt regardless of window mode in case it is
            // needed within the window.
            
            if (bInsertIncome) {
                
                //  Call CCMN01U
                rc = CallCAUD88D(pInputMsg11, PersonClosedOutput, i22, pServiceStatus);
                
                
                
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
            }
        }
        return rc;
    }

    static int CallCLSC63D(CCFC14SI pInputMsg12, CLSS58DO pOutputMsg16, int k, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i23 = 0;
        /*
        ** Declare local variables
        */
        CLSC63DI pCLSC63DInputRec = null;
        CLSC63DO pCLSC63DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC63DInputRec = new CLSC63DI();
        
        pCLSC63DOutputRec = new CLSC63DO();
        pCLSC63DInputRec.setArchInputStruct(pInputMsg12.getArchInputStruct());
        pCLSC63DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC63DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC63DO._CLSC63DO__ROWCLSC63DO_SIZE);
        pCLSC63DInputRec.setUlIdPerson(pInputMsg12.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCLSC63DInputRec.setSzCdIncRsrcType(pOutputMsg16.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getSzCdIncRsrcType());
        pCLSC63DInputRec.setDtDtIncRsrcFrom(pOutputMsg16.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getDtDtIncRsrcFrom());
        
        pCLSC63DInputRec.setDtDtIncRsrcTo(pOutputMsg16.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getDtDtIncRsrcTo());
        pCLSC63DInputRec.setUlIdIncRsrc(pOutputMsg16.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getUlIdIncRsrc());
        pCLSC63DInputRec.setSzCdIncRsrcIncome(pOutputMsg16.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getSzCdIncRsrcIncome());
        
        /* get id event from new three month event */
        
        //find the max id event of 3 month review task, 6020.  (use the first row returned)
        rc = clsc63dQUERYdam(sqlca, pCLSC63DInputRec, pCLSC63DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                
                // create to do for worker
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                // find supervisor id
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCLSS58D(CLSS58DI pInputMsg13, CLSS58DO pOutputMsg17, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i24 = 0;
        /*
        ** Declare local variables
        */
        CLSS58DI pCLSS58DInputRec = null;
        CLSS58DO pCLSS58DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS58DInputRec = new CLSS58DI();
        
        pCLSS58DOutputRec = new CLSS58DO();
        pCLSS58DInputRec.setArchInputStruct(pInputMsg13.getArchInputStruct());
        pCLSS58DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS58DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS58DO._CLSS58DO__ROWCLSS58DO_SIZE);
        pCLSS58DInputRec.setUlIdPerson(pInputMsg13.getUlIdPerson());
        rc = clss58dQUERYdam(sqlca, pCLSS58DInputRec, pCLSS58DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i24 = 0;i24 < pCLSS58DOutputRec.getArchOutputStruct().getUlRowQty();++i24) {
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setLAmtIncRsrc(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getLAmtIncRsrc());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setSzCdIncRsrcIncome(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getSzCdIncRsrcIncome());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setSzCdIncRsrcType(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getSzCdIncRsrcType());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setDtDtIncRsrcFrom(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getDtDtIncRsrcFrom());
                    
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setDtDtIncRsrcTo(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getDtDtIncRsrcTo());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setUlIdPerson(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getUlIdPerson());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setUlIdIncRsrcWorker(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getUlIdIncRsrcWorker());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setUlIdIncRsrc(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getUlIdIncRsrc());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setCIndIncRsrcNotAccess(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getCIndIncRsrcNotAccess());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setSzNmPersonFull(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getSzNmPersonFull());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setSzSdsIncRrcsSource(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getSzSdsIncRrcsSource());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setSzSdsIncRsrcVerfMethod(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getSzSdsIncRsrcVerfMethod());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setTsLastUpdate(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getTsLastUpdate());
                    pOutputMsg17.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).setSzTxtIncRsrcDesc(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i24).getSzTxtIncRsrcDesc());
                }
                
                //## BEGIN TUX/XML: Declare XML variables
                pOutputMsg17.getArchOutputStruct().setUlRowQty(pCLSS58DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg17.getArchOutputStruct().setBMoreDataInd(pCLSS58DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg17.getArchOutputStruct().setUlRowQty(0);
                pOutputMsg17.getArchOutputStruct().setBMoreDataInd(pCLSS58DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                // END OF CONTRACT UPDATE SEGMENT
                
                
                //  SIR #20358 - Free memory for DAM input structure.
                //  SIR 22100 memory fixes
                // free(pCFAD01DInputRec);
                // THIS IS THE END OF CONTRACT CODE
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCAUD88D(CCFC14SI pInputMsg14, CLSS58DO pOutputMsg18, int k, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i25 = k;
        /*
        ** Declare local variables
        */
        CAUD88DI pCAUD88DInputRec = null;
        CAUD88DO pCAUD88DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUD88DInputRec = new CAUD88DI();
        
        pCAUD88DOutputRec = new CAUD88DO();
        pCAUD88DInputRec.setArchInputStruct(pInputMsg14.getArchInputStruct());
        pCAUD88DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCAUD88DInputRec.setLAmtIncRsrc(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getLAmtIncRsrc());
        pCAUD88DInputRec.setSzCdIncRsrcIncome(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getSzCdIncRsrcIncome());
        pCAUD88DInputRec.setSzCdIncRsrcType(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getSzCdIncRsrcType());
        pCAUD88DInputRec.setDtDtIncRsrcFrom(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getDtDtIncRsrcFrom());
        pCAUD88DInputRec.setDtDtIncRsrcTo(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getDtDtIncRsrcTo());
        pCAUD88DInputRec.setUlIdPerson(pInputMsg14.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCAUD88DInputRec.setUlIdIncRsrcWorker(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getUlIdIncRsrcWorker());
        pCAUD88DInputRec.setUlIdIncRsrc(0);
        
        pCAUD88DInputRec.setCIndIncRsrcNotAccess(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getCIndIncRsrcNotAccess());
        
        pCAUD88DInputRec.setSzSdsIncRrcsSource(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getSzSdsIncRrcsSource());
        
        pCAUD88DInputRec.setSzSdsIncRsrcVerfMethod(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getSzSdsIncRsrcVerfMethod());
        /***********************************************************
        ** END CAUD20D
        ************************************************************/
        
        /* SIR #15787: Added the if statement
        ** On closing the home, no need to use this function.
        if( (TRUE == pCFAD01DInputRec->ROWCFAD08SIG07[i].cSysIndContractCurrent) &&
        !bIndUpdateFosterContract )
        {
        rc = ContractVerSerCnty(pInputMsg,
        pCFAD01DInputRec->ROWCFAD08SIG07[i].ulIdContract,
        pCFAD01DInputRec->ROWCFAD08SIG07[i].ulNbrCnperPeriod,
        TUX_STATUSPARMS);
        if (rc != FND_SUCCESS)
        {
        PROCESS_TUX_RC_ERROR_TRANSACT;
        }
        } */
        
        
        
        /*
        ** Increment counter outside of current loop because
        ** we are keeping track of ALL contracts
        */
        pCAUD88DInputRec.setTsLastUpdate(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getTsLastUpdate());
        pCAUD88DInputRec.setSzTxtIncRsrcDesc(pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(k).getSzTxtIncRsrcDesc());
        
        /*
        ** Call DAM
        */
        rc = caud88dAUDdam(sqlca, pCAUD88DInputRec, pCAUD88DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg18.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i25).setUlIdIncRsrc(pCAUD88DOutputRec.getUlIdIncRsrc());
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                
                //  Populate PostEvent Common Function Input Structure
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
        }
        return rc;
    }

    static int CallCINV41D(CINV41DI pInputMsg15, CINV41DO * pOutputMsg19, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        CINV41DI pCINV41DInputRec = null;
        CINV41DO pCINV41DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV41DInputRec = new CINV41DI();
        
        pCINV41DOutputRec = new CINV41DO();
        pCINV41DInputRec.setArchInputStruct(pInputMsg15.getArchInputStruct());
        pCINV41DInputRec.getArchInputStruct().setCReqFuncCd(WINDOW_MODE_PERSON);
        pCINV41DInputRec.setDtDtPersonBirth(pInputMsg15.getDtDtPersonBirth());
        pCINV41DInputRec.setLNbrPersonAge(pInputMsg15.getLNbrPersonAge());
        pCINV41DInputRec.setSzCdPersonLivArr(pInputMsg15.getSzCdPersonLivArr());
        pCINV41DInputRec.setTsSysTsLastUpdate2(pInputMsg15.getTsSysTsLastUpdate2());
        pCINV41DInputRec.setSzCdPersonDeath(pInputMsg15.getSzCdPersonDeath());
        pCINV41DInputRec.setSzCdPersonEthnicGroup(pInputMsg15.getSzCdPersonEthnicGroup());
        pCINV41DInputRec.setSzCdPersonLanguage(pInputMsg15.getSzCdPersonLanguage());
        pCINV41DInputRec.setSzCdPersonMaritalStatus(pInputMsg15.getSzCdPersonMaritalStatus());
        pCINV41DInputRec.setSzCdPersonReligion(pInputMsg15.getSzCdPersonReligion());
        pCINV41DInputRec.setCdPersonStatus(pInputMsg15.getCdPersonStatus());
        pCINV41DInputRec.setCCdPersonSex(pInputMsg15.getCCdPersonSex());
        pCINV41DInputRec.setDtDtPersonDeath(pInputMsg15.getDtDtPersonDeath());
        pCINV41DInputRec.setSzNmPersonFull(pInputMsg15.getSzNmPersonFull());
        
        pCINV41DInputRec.setSzTxtOccupation(pInputMsg15.getSzTxtOccupation());
        
        pCINV41DInputRec.setBCdPersonChar(pInputMsg15.getBCdPersonChar());
        
        pCINV41DInputRec.setBIndPersonDobApprox(pInputMsg15.getBIndPersonDobApprox());
        
        pCINV41DInputRec.setUlIdPerson(pInputMsg15.getUlIdPerson());
        
        /*
        ** Call DAM
        */
        rc = cinv41dAUDdam(sqlca, pCINV41DInputRec, pCINV41DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                //##            return (FND_SUCCESS);
                break;
                
            default :
                
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCDYN16D(CCFC14SI pInputMsg16, CCFC14SO * pOutputMsg20, CDYN16DI pCDYN16DInputRec, CDYN16DO pCDYN16DOutputRec, int ulIdEvent1, char ReqFunc, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;
        pCDYN16DInputRec.setArchInputStruct(pInputMsg16.getArchInputStruct());
        pCDYN16DInputRec.setUlIdPersMergeClosed(pInputMsg16.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        pCDYN16DInputRec.setUlIdPersMergeForward(pInputMsg16.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCDYN16DInputRec.setUlIdEvent(ulIdEvent1);
        pCDYN16DInputRec.getArchInputStruct().setCReqFuncCd(ReqFunc);
        
        /*
        ** We also need to find the user's phone, extension,
        ** etc for a new call, so that the information may
        ** be saved to the incoming detail table.
        */
        rc = cdyn16dAUDdam(sqlca, pCDYN16DInputRec, pCDYN16DOutputRec);
        return rc;
    }

    static int CallCMSC58D(CCFC14SI pInputMsg17, CCFC14SO * pOutputMsg21, CMSC58DI pCMSC58DInputRec, CMSC58DO pCMSC58DOutputRec, int ulIdStage1, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        pCMSC58DInputRec.setArchInputStruct(pInputMsg17.getArchInputStruct());
        pCMSC58DInputRec.setUlIdPersMergeClosed(pInputMsg17.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        pCMSC58DInputRec.setUlIdPersMergeForward(pInputMsg17.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCMSC58DInputRec.setUlIdStage(ulIdStage1);
        
        rc = cmsc58dAUDdam(sqlca, pCMSC58DInputRec, pCMSC58DOutputRec);
        return rc;
    }

    static int CallCSECA4D(CSECA4DI pInputMsg18, CSECA4DO pOutputMsg22, String pbEA_Open, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (pCSECA4DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCSECA4DInputRec.setArchInputStruct(pInputMsg18.getArchInputStruct());
        pCSECA4DInputRec.setUlIdPersEligPerson(pInputMsg18.getUlIdPersEligPerson());
        rc = cseca4dQUERYdam(sqlca, pCSECA4DInputRec, pCSECA4DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pbEA_Open = CStringUtils.setCharAt(pbEA_Open, 0, true);
                pOutputMsg22.setUlIdPersElig(pCSECA4DOutputRec.getUlIdPersElig());
                pOutputMsg22.setUlIdPersEligPerson(pCSECA4DOutputRec.getUlIdPersEligPerson());
                pOutputMsg22.setSzCdPersEligType(pCSECA4DOutputRec.getSzCdPersEligType());
                pOutputMsg22.setDtDtPersEligStart(pCSECA4DOutputRec.getDtDtPersEligStart());
                pOutputMsg22.setDtDtPersEligEnd(pCSECA4DOutputRec.getDtDtPersEligEnd());
                pOutputMsg22.setDtDtPersEligEaDeny(pCSECA4DOutputRec.getDtDtPersEligEaDeny());
                pOutputMsg22.setCdPersEligPrgStart(pCSECA4DOutputRec.getCdPersEligPrgStart());
                pOutputMsg22.setCdPersEligPrgOpen(pCSECA4DOutputRec.getCdPersEligPrgOpen());
                pOutputMsg22.setCdPersEligPrgClose(pCSECA4DOutputRec.getCdPersEligPrgClose());
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCAUDD1D(CAUDD1DI pInputMsg19, CAUDD1DO * pOutputMsg23, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CAUDD1DI pCAUDD1DInputRec = null;
        CAUDD1DO pCAUDD1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD1DInputRec = new CAUDD1DI();
        pCAUDD1DOutputRec = new CAUDD1DO();
        
        if (pCAUDD1DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (pCAUDD1DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCAUDD1DInputRec.setArchInputStruct(pInputMsg19.getArchInputStruct());
        pCAUDD1DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg19.getArchInputStruct().getCReqFuncCd());
        
        pCAUDD1DInputRec.setUlIdPersElig(pInputMsg19.getUlIdPersElig());
        pCAUDD1DInputRec.setUlIdPersEligPerson(pInputMsg19.getUlIdPersEligPerson());
        pCAUDD1DInputRec.setSzCdPersEligType(pInputMsg19.getSzCdPersEligType());
        
        pCAUDD1DInputRec.setDtDtPersEligStart(pInputMsg19.getDtDtPersEligStart());
        pCAUDD1DInputRec.setDtDtPersEligEnd(pInputMsg19.getDtDtPersEligEnd());
        pCAUDD1DInputRec.setDtDtPersEligEaDeny(pInputMsg19.getDtDtPersEligEaDeny());
        
        pCAUDD1DInputRec.setCdPersEligPrgStart(pInputMsg19.getCdPersEligPrgStart());
        pCAUDD1DInputRec.setCdPersEligPrgOpen(pInputMsg19.getCdPersEligPrgOpen());
        pCAUDD1DInputRec.setCdPersEligPrgClose(pInputMsg19.getCdPersEligPrgClose());
        
        
        /*
        ** Call CSES49D
        */
        rc = caudd1dAUDdam(sqlca, pCAUDD1DInputRec, pCAUDD1DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCLSC86D(CLSC86DI pInputMsg20, CLSC86DO pOutputMsg24, String pbDHS_Found, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CLSC86DI pCLSC86DInputRec = null;
        CLSC86DO pCLSC86DOutputRec = null;
        int i26 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC86DInputRec = new CLSC86DI();
        pCLSC86DOutputRec = new CLSC86DO();
        
        /* SIR #20439: Added a new dam: cmsc50d */
        if (pCLSC86DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (pCLSC86DOutputRec == null) {
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCLSC86DInputRec.setArchInputStruct(pInputMsg20.getArchInputStruct());
        pCLSC86DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC86DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC86DO._CLSC86DO__ROWCLSC86DO_SIZE);
        pCLSC86DInputRec.setUlIdPersEligPerson(pInputMsg20.getUlIdPersEligPerson());
        
        /*
        ** Call DAM
        */
        rc = clsc86dQUERYdam(sqlca, pCLSC86DInputRec, pCLSC86DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pbDHS_Found = CStringUtils.setCharAt(pbDHS_Found, 0, true);
                pOutputMsg24.getArchOutputStruct().setUlRowQty(pCLSC86DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i26 = 0;i26 < pCLSC86DOutputRec.getArchOutputStruct().getUlRowQty();++i26) {
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setUlIdPersElig(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getUlIdPersElig());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setSzCdPersEligType(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getSzCdPersEligType());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setUlIdPersEligPerson(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getUlIdPersEligPerson());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setDtDtPersEligStart(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getDtDtPersEligStart());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setDtDtPersEligEnd(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getDtDtPersEligEnd());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setDtDtPersEligEaDeny(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getDtDtPersEligEaDeny());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setCdPersEligPrgStart(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getCdPersEligPrgStart());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setCdPersEligPrgOpen(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getCdPersEligPrgOpen());
                    pOutputMsg24.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).setCdPersEligPrgClose(pCLSC86DOutputRec.getROWCLSC86DO_ARRAY().getROWCLSC86DO(i26).getCdPersEligPrgClose());
                }
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                //  The DAM populates the output message for us, so we don't need
                // to do that here
                rc = SUCCESS;
                // 
                // (END): Retrieve DAM: ccmn44d     
                // Get NmPersonFull given IdPerson
                // 
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCSECA6D(CSECA6DI pInputMsg21, CSECA6DO * pOutputMsg25, String pbRowDifferent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSECA6DI pCSECA6DInputRec = null;
        CSECA6DO pCSECA6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA6DInputRec = new CSECA6DI();
        pCSECA6DOutputRec = new CSECA6DO();
        if (pCSECA6DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (pCSECA6DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCSECA6DInputRec.setArchInputStruct(pInputMsg21.getArchInputStruct());
        pCSECA6DInputRec.setUlIdPersEligPerson(pInputMsg21.getUlIdPersEligPerson());
        pCSECA6DInputRec.setSzCdPersEligType(pInputMsg21.getSzCdPersEligType());
        pCSECA6DInputRec.setDtDtPersEligStart(pInputMsg21.getDtDtPersEligStart());
        pCSECA6DInputRec.setDtDtPersEligEnd(pInputMsg21.getDtDtPersEligEnd());
        pCSECA6DInputRec.setDtDtPersEligEaDeny(pInputMsg21.getDtDtPersEligEaDeny());
        pCSECA6DInputRec.setCdPersEligPrgStart(pInputMsg21.getCdPersEligPrgStart());
        pCSECA6DInputRec.setCdPersEligPrgOpen(pInputMsg21.getCdPersEligPrgOpen());
        pCSECA6DInputRec.setCdPersEligPrgClose(pInputMsg21.getCdPersEligPrgClose());
        rc = cseca6dQUERYdam(sqlca, pCSECA6DInputRec, pCSECA6DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                // 01/22/2003 DWW: Added for error handling
                if (0 == pCSECA6DOutputRec.getUlSysNbrGenericCntr()) {
                    pbRowDifferent = CStringUtils.setCharAt(pbRowDifferent, 0, true);
                }
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                
                //  COMMENT THE DAM CALL HERE -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
                
                //  Start Performance Timer
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCAUDD2D(CAUDD2DI pInputMsg22, CAUDD2DO * pOutputMsg26, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CAUDD2DI pCAUDD2DInputRec = null;
        CAUDD2DO pCAUDD2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD2DInputRec = new CAUDD2DI();
        pCAUDD2DOutputRec = new CAUDD2DO();
        
        if (pCAUDD2DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        if (pCAUDD2DOutputRec == null) {
            
            
            //  Start performance timer for Data Access Module 
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCAUDD2DInputRec.setArchInputStruct(pInputMsg22.getArchInputStruct());
        pCAUDD2DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg22.getArchInputStruct().getCReqFuncCd());
        pCAUDD2DInputRec.setSzCdPersEligType(pInputMsg22.getSzCdPersEligType());
        pCAUDD2DInputRec.setUlIdPersEligPerson(pInputMsg22.getUlIdPersEligPerson());
        pCAUDD2DInputRec.setDtDtPersEligStart(pInputMsg22.getDtDtPersEligStart());
        pCAUDD2DInputRec.setDtDtPersEligEnd(pInputMsg22.getDtDtPersEligEnd());
        pCAUDD2DInputRec.setDtDtPersEligEaDeny(pInputMsg22.getDtDtPersEligEaDeny());
        pCAUDD2DInputRec.setCdPersEligPrgStart(pInputMsg22.getCdPersEligPrgStart());
        pCAUDD2DInputRec.setCdPersEligPrgOpen(pInputMsg22.getCdPersEligPrgOpen());
        
        
        /**************************************************************************
        ** Call DAM
        ***************************************************************************/
        rc = caudd2dAUDdam(sqlca, pCAUDD2DInputRec, pCAUDD2DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCLSC87D(CLSC87DI pInputMsg23, CLSC87DO pOutputMsg27, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CLSC87DI pCLSC87DInputRec = null;
        CLSC87DO pCLSC87DOutputRec = null;
        int i27 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC87DInputRec = new CLSC87DI();
        pCLSC87DOutputRec = new CLSC87DO();
        
        /*
        ** Set Calculated Retention date to maximum date
        */
        if (pCLSC87DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        if (pCLSC87DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCLSC87DInputRec.setArchInputStruct(pInputMsg23.getArchInputStruct());
        pCLSC87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC87DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC87DO._CLSC87DO__ROWCLSC87DO_SIZE);
        pCLSC87DInputRec.setUlIdPersElig(pInputMsg23.getUlIdPersElig());
        pCLSC87DInputRec.setIdPersEligDtlPerson(pInputMsg23.getIdPersEligDtlPerson());
        
        /*
        ** Call CAUD20D.  The Contract Period ELB DAM receives IdContract and
        ** performs an AUD on the indicated row.
        ** Delete:  a stored procedure is called to perform a cascade delete
        **          for Contract Version, Contract Service and Contract County.
        ** Add:     Performs a full row insert into Contract Period Table
        ** Modify:  Performs a full row update into Contract Period Table.
        */
        rc = clsc87dQUERYdam(sqlca, pCLSC87DInputRec, pCLSC87DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg27.getArchOutputStruct().setUlRowQty(pCLSC87DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i27 = 0;i27 < pCLSC87DOutputRec.getArchOutputStruct().getUlRowQty();++i27) {
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setUlIdPersElig(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getUlIdPersElig());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setMoPersEligDtlMonth(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getMoPersEligDtlMonth());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setYrPersEligDtlYear(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getYrPersEligDtlYear());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setCdPersEligDtlEligCode(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getCdPersEligDtlEligCode());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setCdPersEligDtlTypeCase(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getCdPersEligDtlTypeCase());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setCdPersEligDtlMedCov(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getCdPersEligDtlMedCov());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setCdPersEligDtlStatInGrp(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getCdPersEligDtlStatInGrp());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setCdPersEligDtlCaseStatus(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getCdPersEligDtlCaseStatus());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setCdPersEligDtlProgType(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getCdPersEligDtlProgType());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setCdPersEligDtlCaseCateg(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getCdPersEligDtlCaseCateg());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setDtPersEligDtlCaseCert(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getDtPersEligDtlCaseCert());
                    pOutputMsg27.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).setNbrPersEligDtlCaseNbr(pCLSC87DOutputRec.getROWCLSC87DO_ARRAY().getROWCLSC87DO(i27).getNbrPersEligDtlCaseNbr());
                }
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

    static int CallCAUDD3D(CAUDD3DI pInputMsg24, CAUDD3DO * pOutputMsg28, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CAUDD3DI pCAUDD3DInputRec = null;
        CAUDD3DO pCAUDD3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDD3DInputRec = new CAUDD3DI();
        pCAUDD3DOutputRec = new CAUDD3DO();
        if (pCAUDD3DInputRec == null) {
            
            
            //  Set rc to ARC_SUCCESS
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (pCAUDD3DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCAUDD3DInputRec.setArchInputStruct(pInputMsg24.getArchInputStruct());
        pCAUDD3DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg24.getArchInputStruct().getCReqFuncCd());
        pCAUDD3DInputRec.setUlIdPersElig(pInputMsg24.getUlIdPersElig());
        pCAUDD3DInputRec.setIdPersEligDtlPerson(pInputMsg24.getIdPersEligDtlPerson());
        pCAUDD3DInputRec.setMoPersEligDtlMonth(pInputMsg24.getMoPersEligDtlMonth());
        pCAUDD3DInputRec.setYrPersEligDtlYear(pInputMsg24.getYrPersEligDtlYear());
        pCAUDD3DInputRec.setCdPersEligDtlEligCode(pInputMsg24.getCdPersEligDtlEligCode());
        pCAUDD3DInputRec.setCdPersEligDtlTypeCase(pInputMsg24.getCdPersEligDtlTypeCase());
        pCAUDD3DInputRec.setCdPersEligDtlMedCov(pInputMsg24.getCdPersEligDtlMedCov());
        pCAUDD3DInputRec.setCdPersEligDtlStatInGrp(pInputMsg24.getCdPersEligDtlStatInGrp());
        pCAUDD3DInputRec.setCdPersEligDtlCaseStatus(pInputMsg24.getCdPersEligDtlCaseStatus());
        pCAUDD3DInputRec.setCdPersEligDtlProgType(pInputMsg24.getCdPersEligDtlProgType());
        pCAUDD3DInputRec.setCdPersEligDtlCaseCateg(pInputMsg24.getCdPersEligDtlCaseCateg());
        pCAUDD3DInputRec.setDtPersEligDtlCaseCert(pInputMsg24.getDtPersEligDtlCaseCert());
        pCAUDD3DInputRec.setNbrPersEligDtlCaseNbr(pInputMsg24.getNbrPersEligDtlCaseNbr());
        rc = caudd3dAUDdam(sqlca, pCAUDD3DInputRec, pCAUDD3DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Call CCMN03U
                rc = SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
        
    }

    static int CallCINT17D(CCFC14SI pInputMsg25, CCFC14SO pOutputMsg29, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    
    {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        int ulRowCounter = 0;
        int ulCurrentRow = 0;/* Loop counter */
        CINT17DI pCINT17DInputRec = null;
        CINT17DO pCINT17DOutputRec = null;
        CINT18DI pCINT18DInputRec = null;
        CINT18DO pCINT18DOutputRec = null;
        
        int a = 0;
        boolean bMatch = false;
        FndInt3date TempDate = null;
        int saved_forward_row = - 1;
        int tempforwardrow = 0;
        boolean bstoreforwardrow = false;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT17DInputRec = new CINT17DI();
        
        pCINT17DOutputRec = new CINT17DO();
        pCINT17DInputRec.setUlIdPerson(pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        pCINT17DInputRec.setBSysIndIntake(0);
        pCINT17DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINT17DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT17DO._CINT17DO__ROWCINT17DO_SIZE);
        
        /*
        ** Call CSEC25D
        */
        rc = cint17dQUERYdam(sqlca, pCINT17DInputRec, pCINT17DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Transfer rows to a temporary array so the output structure
                // from the DAM will be freed up to use for the next call to the DAM
                // to get the rows for the person forward.
                
                
                for (ulRowCounter = 0;ulRowCounter < pCINT17DOutputRec.getArchOutputStruct().getUlRowQty();ulRowCounter++) {
                    PersonClosedArray.PersonClosedRow[ulRowCounter].szCdPersonIdType = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getSzCdPersonIdType();
                    
                    // PersonClosedArray.PersonClosedRow[ulRowCounter].szCdScrDataAction = NULL;
                    
                    PersonClosedArray.PersonClosedRow[ulRowCounter].bIndPersonIDInvalid = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getBIndPersonIDInvalid();
                    PersonClosedArray.PersonClosedRow[ulRowCounter].szDescPersonID = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getSzDescPersonID();
                    
                    PersonClosedArray.PersonClosedRow[ulRowCounter].dtPersonIDStart = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getDtPersonIDStart();
                    
                    PersonClosedArray.PersonClosedRow[ulRowCounter].dtPersonIDEnd = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getDtPersonIDEnd();
                    PersonClosedArray.PersonClosedRow[ulRowCounter].szNbrPersonIdNumber = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getSzNbrPersonIdNumber();
                    
                    PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPersonId = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getUlIdPersonId();
                    
                    PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPerson = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getUlIdPerson();
                    PersonClosedArray.PersonClosedRow[ulRowCounter].tsSysTsLastUpdate2 = pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getTsSysTsLastUpdate2();
                }
                
                // save the # of rows
                int ClosedRowsQty = pCINT17DOutputRec.getArchOutputStruct().getUlRowQty();
                
                // Now call cint17d a second time to get the rows for the person forward.
                
                //  Allocate memory for Input and Output Structures
                pCINT17DInputRec = new CINT17DI();
                
                pCINT17DOutputRec = new CINT17DO();
                pCINT17DInputRec.setUlIdPerson(pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                pCINT17DInputRec.setBSysIndIntake((char) (0));
                pCINT17DInputRec.getArchInputStruct().setUsPageNbr(1);
                
                pCINT17DInputRec.getArchInputStruct().setUlPageSizeNbr(pCINT17DInputRec.getArchInputStruct().getUlPageSizeNbr());
                ;
                
                // Set rc to ARC_SUCCESS
                rc = cint17dQUERYdam(sqlca, pCINT17DInputRec, pCINT17DOutputRec);
                
                if (rc != 0) {
                    
                    //  Analyze error code
                    
                    switch (rc) {
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = SUCCESS;
                            pServiceStatus.explan_code = SUCCESS;
                            rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                            
                            // change person_id to the person forward.
                            for (ulRowCounter = 0;ulRowCounter < ClosedRowsQty;ulRowCounter++) {
                                PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPerson = pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward();
                                //##  return RetVal;
                            }
                            
                            break;
                        default :
                            
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    }
                }
                
                
                else {
                    for (ulRowCounter = 0;ulRowCounter < ClosedRowsQty;ulRowCounter++) 
                    
                    {
                        
                        if (PersonClosedArray.PersonClosedRow[ulRowCounter].dtPersonIDEnd.year == DateHelper.NULL_DATE) {
                            // Second question:   Does the person forward also have a valid id of this
                            // type that is not end_dated? We need to loop through all of the person_forward rows
                            // to see if any are of this type. If one is, break out and save what row # you were on.
                            
                            bMatch = false;
                            
                            for (tempforwardrow = 0;tempforwardrow < pCINT17DOutputRec.getArchOutputStruct().getUlRowQty();tempforwardrow++) 
                            {
                                
                                if (((PersonClosedArray.PersonClosedRow[ulRowCounter].szCdPersonIdType.compareTo(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(tempforwardrow).getSzCdPersonIdType())) == 0) && (pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(tempforwardrow).getBIndPersonIDInvalid() == 'N') && (pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(tempforwardrow).getDtPersonIDEnd().year == DateHelper.NULL_DATE)) 
                                {
                                    bMatch = true;
                                    
                                    break;
                                }
                                
                            }
                            if (bMatch) 
                            {
                                
                                if ((PersonClosedArray.PersonClosedRow[ulRowCounter].szCdPersonIdType.compareTo("SSN")) == 0) {
                                    if (((PersonClosedArray.PersonClosedRow[ulRowCounter].szDescPersonID.compareTo("SSA verified via DHS RECEIVE Interface\000\000")) == 0) && ((pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(tempforwardrow).getSzDescPersonID().compareTo("SSA verified via DHS RECEIVE Interface\000\000")) != 0)) {
                                        PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPerson = pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward();
                                        
                                        bstoreforwardrow = true;
                                        saved_forward_row = tempforwardrow;
                                        rc = ARC_UTLGetDateAndTime(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getDtPersonIDEnd() , 0);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                        
                                    }
                                    else {
                                        
                                        //  Call CSECC2D
                                        rc = ARC_UTLGetDateAndTime(TempDate, 0);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                        
                                        PersonClosedArray.PersonClosedRow[ulRowCounter].dtPersonIDEnd = TempDate;
                                        
                                        // If there is a match in id type and the type is not SSN,
                                        // end_date the id.
                                        
                                        PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPerson = pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward();
                                    }
                                }
                                else {
                                    PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPerson = pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward();
                                    
                                    // Set rc to ARC_SUCCESS
                                    rc = ARC_UTLGetDateAndTime(TempDate, 0);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                                    
                                    PersonClosedArray.PersonClosedRow[ulRowCounter].dtPersonIDEnd = TempDate;
                                    //##  return RetVal;
                                }
                                
                            }
                            else {
                                PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPerson = pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward();
                            }
                        }
                        // else the row is marked invalid so just change the id to the person forward
                        else {
                            PersonClosedArray.PersonClosedRow[ulRowCounter].ulIdPerson = pInputMsg25.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward();
                        }
                    }
                }
                
                
                
                // Call CINT18D to send the changes to the person_id table.
                // Copy all the values in and send them off one at a time
                
                //  Allocate memory for Input and Output Structures
                pCINT18DInputRec = new CINT18DI();
                pCINT18DOutputRec = new CINT18DO();
                
                if (!(pCINT18DInputRec != null) ||!(pCINT18DOutputRec != null)) {
                    rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    return rc;
                }
                pCINT18DInputRec.setArchInputStruct(pCINT17DInputRec.getArchInputStruct());
                
                for (ulCurrentRow = 0;ulCurrentRow < ClosedRowsQty;ulCurrentRow++) {
                    pCINT18DInputRec.setSzCdPersonIdType(PersonClosedArray.PersonClosedRow[ulCurrentRow].szCdPersonIdType);
                    pCINT18DInputRec.setBIndPersonIDInvalid(PersonClosedArray.PersonClosedRow[ulCurrentRow].bIndPersonIDInvalid);
                    pCINT18DInputRec.setSzDescPersonID(PersonClosedArray.PersonClosedRow[ulCurrentRow].szDescPersonID);
                    pCINT18DInputRec.setDtPersonIDStart(PersonClosedArray.PersonClosedRow[ulCurrentRow].dtPersonIDStart);
                    pCINT18DInputRec.setDtPersonIDEnd(PersonClosedArray.PersonClosedRow[ulCurrentRow].dtPersonIDEnd);
                    pCINT18DInputRec.setSzNbrPersonIdNumber(PersonClosedArray.PersonClosedRow[ulCurrentRow].szNbrPersonIdNumber);
                    pCINT18DInputRec.setUlIdPerson(PersonClosedArray.PersonClosedRow[ulCurrentRow].ulIdPerson);
                    pCINT18DInputRec.setUlIdPersonId(PersonClosedArray.PersonClosedRow[ulCurrentRow].ulIdPersonId);
                    pCINT18DInputRec.setTsSysTsLastUpdate2(PersonClosedArray.PersonClosedRow[ulCurrentRow].tsSysTsLastUpdate2);
                    pCINT18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    rc = cint18dAUDdam(sqlca, pCINT18DInputRec, pCINT18DOutputRec);
                    
                    if (rc != 0) {
                        switch (rc) {
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        }
                    }
                    
                    
                    else {
                        pOutputMsg29.setArchOutputStruct(pCINT18DOutputRec.getArchOutputStruct());
                    }
                }
                
                if (bstoreforwardrow) {
                    //  Allocate memory for Input and Output Structures
                    pCINT18DInputRec = new CINT18DI();
                    pCINT18DOutputRec = new CINT18DO();
                    
                    if (!(pCINT18DInputRec != null) ||!(pCINT18DOutputRec != null)) {
                        
                        //  Call CRES04D
                        rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        return rc;
                    }
                    pCINT18DInputRec.setArchInputStruct(pCINT17DInputRec.getArchInputStruct());
                    pCINT18DInputRec.setSzCdPersonIdType(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getSzCdPersonIdType());
                    pCINT18DInputRec.setBIndPersonIDInvalid(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getBIndPersonIDInvalid());
                    pCINT18DInputRec.setSzDescPersonID(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getSzDescPersonID());
                    pCINT18DInputRec.setDtPersonIDStart(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getDtPersonIDStart());
                    pCINT18DInputRec.setDtPersonIDEnd(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getDtPersonIDEnd());
                    pCINT18DInputRec.setSzNbrPersonIdNumber(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getSzNbrPersonIdNumber());
                    pCINT18DInputRec.setUlIdPerson(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getUlIdPerson());
                    pCINT18DInputRec.setUlIdPersonId(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getUlIdPersonId());
                    pCINT18DInputRec.setTsSysTsLastUpdate2(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(saved_forward_row).getTsSysTsLastUpdate2());
                    pCINT18DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    rc = cint18dAUDdam(sqlca, pCINT18DInputRec, pCINT18DOutputRec);
                    
                    if (rc != 0) {
                        switch (rc) {
                                // There are no acceptible errors for this service.
                                // This switch statement, which does nothing but "default",
                                // will be left so that it will be easy to add additional
                                // error handling later.
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        }
                    }
                    
                    
                    else {
                        pOutputMsg29.setArchOutputStruct(pCINT18DOutputRec.getArchOutputStruct());
                    }
                    //##             return ARC_ERR_MALLOC_FAILED;
                }
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                break;
                // There are no acceptible errors for this service.
                // This switch statement, which does nothing but "default",
                // will be left so that it will be easy to add additional
                // error handling later.
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                //##             return ARC_ERR_MALLOC_FAILED;
        }
        return rc;
    }

    static int CallCAUD74D(CAUD74DI pInputMsg26, CAUD74DO * pOutputMsg30, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
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
        pCAUD74DInputRec.setArchInputStruct(pInputMsg26.getArchInputStruct());
        pCAUD74DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCAUD74DInputRec.setUlIdPerson(pInputMsg26.getUlIdPerson());
        pCAUD74DInputRec.setCdPersonStatus(pInputMsg26.getCdPersonStatus());
        rc = caud74dAUDdam(sqlca, pCAUD74DInputRec, pCAUD74DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCINV48D(CCFC14SI pInputMsg27, CLSS60DO pOutputMsg31, int iIndex, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        
        CINV48DI pCINV48DInputRec = null;
        CINV48DO pCINV48DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV48DInputRec = new CINV48DI();
        
        pCINV48DOutputRec = new CINV48DO();
        pCINV48DInputRec.setArchInputStruct(pInputMsg27.getArchInputStruct());
        pCINV48DInputRec.getArchInputStruct().setCReqFuncCd(WINDOW_MODE_MERGE);
        pCINV48DInputRec.getROWCINV48DI().setUlIdPerson(pInputMsg27.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCINV48DInputRec.getROWCINV48DI().setSzCdCharCategory(pOutputMsg31.getROWCLSS60DO_ARRAY().getROWCLSS60DO(iIndex).getSzCdCharCategory());
        pCINV48DInputRec.getROWCINV48DI().setCdCharacteristic(pOutputMsg31.getROWCLSS60DO_ARRAY().getROWCLSS60DO(iIndex).getCdCharacteristic());
        pCINV48DInputRec.getROWCINV48DI().setDtDtCharStart(pOutputMsg31.getROWCLSS60DO_ARRAY().getROWCLSS60DO(iIndex).getDtDtCharStart());
        pCINV48DInputRec.getROWCINV48DI().setDtDtCharEnd(pOutputMsg31.getROWCLSS60DO_ARRAY().getROWCLSS60DO(iIndex).getDtDtCharEnd());
        rc = cinv48dAUDdam(sqlca, pCINV48DInputRec, pCINV48DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CAUD81D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCompareChar(CCFC14SI pInputMsg28, CCFC14SO * pOutputMsg32, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i28 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        int tempIndex = 0;
        boolean bInsertChar = false;
        
        /* string to hold the concatenated Characteristic and Category for comparison */
        String szCharCategoryForward = new String();
        String szCharCategoryClosed = new String();
        CLSS60DI PersonForwardInput = null;
        CLSS60DO PersonForwardOutput = null;
        
        CLSS60DI PersonClosedInput = null;
        CLSS60DO PersonClosedOutput = null;
        
        FndInt3date dtSysdate = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonForwardInput = new CLSS60DI();
        PersonForwardOutput = new CLSS60DO();
        PersonClosedInput = new CLSS60DI();
        PersonClosedOutput = new CLSS60DO();
        if ((PersonForwardInput == null) || (PersonForwardOutput == null) || (PersonClosedInput == null) || (PersonClosedOutput == null)) {
            
            //  Call DAM
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        rc = ARC_UTLGetDateAndTime(dtSysdate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        PersonForwardInput.setUlIdPerson(pInputMsg28.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        PersonForwardInput.setDtScrDtCharEffDate(dtSysdate);
        rc = Ccmn03u.CallCLSS60D(PersonForwardInput, PersonForwardOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        PersonClosedInput.setUlIdPerson(pInputMsg28.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        PersonClosedInput.setDtScrDtCharEffDate(dtSysdate);
        
        /*
        ** Call DAM
        */
        rc = Ccmn03u.CallCLSS60D(PersonClosedInput, PersonClosedOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        /* compare all the CHARACTERISTICS for person_closed to person_forward */
        for (i28 = 0;i28 < PersonClosedOutput.getArchOutputStruct().getUlRowQty();i28++) {
            tempIndex = i28;
            szCharCategoryClosed = PersonClosedOutput.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i28).getSzCdCharCategory();
            szCharCategoryClosed += ",";
            strncat(szCharCategoryClosed, PersonClosedOutput.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i28).getCdCharacteristic() , CLSS60DO.CD_CHARACTERISTIC_LEN - 1);
            szCharCategoryForward = NULL_STRING;
            // select one record and compare it with all the existing chars in
            // person forward. insert if no match found
            for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty();j++) {
                szCharCategoryForward = PersonForwardOutput.getROWCLSS60DO_ARRAY().getROWCLSS60DO(j).getSzCdCharCategory();
                szCharCategoryForward += ",";
                
                strncat(szCharCategoryForward, PersonForwardOutput.getROWCLSS60DO_ARRAY().getROWCLSS60DO(j).getCdCharacteristic() , CLSS60DO.CD_CHARACTERISTIC_LEN - 1);
                if (0 == szCharCategoryForward.compareTo(szCharCategoryClosed)) {
                    bInsertChar = false;
                    break;
                }
                else {
                    bInsertChar = true;
                }
                szCharCategoryForward = NULL_STRING;
            }
            if (PersonForwardOutput.getArchOutputStruct().getUlRowQty() == 0) {
                bInsertChar = true;
            }
            // check if MergeFrom & MergeTo cases match previous record
            if (bInsertChar) {
                rc = CallCINV48D(pInputMsg28, PersonClosedOutput, tempIndex, pServiceStatus);
                
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        return rc;
    }

    static int CallCompareName(CCFC14SI pInputMsg29, CCFC14SO * pOutputMsg33, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i29 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        String szTemp = new String();
        int tempIndex = 0;
        boolean bInsertName = false;
        char bPrimaryNameExist = 0;
        
        
        /* string to hold the concatenated name for comparison */
        String szForward = new String();
        String szClosed = new String();
        CINV31DI PersonForwardInput = null;
        CINV31DO PersonForwardOutput = null;
        
        CINV31DI PersonClosedInput = null;
        CINV31DO PersonClosedOutput = null;
        
        FndInt3date dtSysdate = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonForwardInput = new CINV31DI();
        PersonForwardOutput = new CINV31DO();
        PersonClosedInput = new CINV31DI();
        PersonClosedOutput = new CINV31DO();
        
        if ((PersonForwardInput == null) || (PersonForwardOutput == null) || (PersonClosedInput == null) || (PersonClosedOutput == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        rc = ARC_UTLGetDateAndTime(dtSysdate, 0);
        
        //## BEGIN TUX/XML: Declare XML variables
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        PersonForwardInput.setUlIdPerson(pInputMsg29.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        PersonForwardInput.setBSysIndIntake(IND_VALID_NAME);
        rc = Cinv25s.CallCINV31D(PersonForwardInput, PersonForwardOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        PersonClosedInput.setUlIdPerson(pInputMsg29.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        PersonClosedInput.setBSysIndIntake(IND_VALID_NAME);
        rc = Cinv25s.CallCINV31D(PersonClosedInput, PersonClosedOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /* check to see if person_forward has primary name */
        for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty() && PersonForwardOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(j).getBIndNameInvalid() == 'N';j++) {
            if (PersonForwardOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(j).getBIndNamePrimary() == 'Y') {
                bPrimaryNameExist = 1;
            }
        }
        
        
        for (i29 = 0;i29 < PersonClosedOutput.getArchOutputStruct().getUlRowQty() && PersonClosedOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(i29).getBIndNameInvalid() == 'N';i29++) {
            tempIndex = i29;
            szClosed = NULL_STRING;
            szTemp = PersonClosedOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(i29).getSzNmNameFirst();
            szClosed = szTemp;
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(i29).getSzNmNameLast();
            strncat(szClosed, szTemp, szTemp.length());
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(i29).getSzNmNameMiddle();
            strncat(szClosed, szTemp, szTemp.length());
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(i29).getSzCdNameSuffix();
            strncat(szClosed, szTemp, szTemp.length());
            szForward = NULL_STRING;
            // select one record and compare it with all the existing names in
            // person forward. insert if no match found
            for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty();j++) {
                szTemp = PersonForwardOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(j).getSzNmNameFirst();
                szForward = szTemp;
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(j).getSzNmNameLast();
                strncat(szForward, szTemp, szTemp.length());
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(j).getSzNmNameMiddle();
                strncat(szForward, szTemp, szTemp.length());
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCINV31DO_ARRAY().getROWCINV31DO(j).getSzCdNameSuffix();
                strncat(szForward, szTemp, szTemp.length());
                //## END TUX/XML: Turn the XML buffer into an input message struct
                
                
                
                if (0 == szForward.compareTo(szClosed)) {
                    bInsertName = false;
                    
                    break;
                }
                else {
                    bInsertName = true;
                }
                szForward = NULL_STRING;
            }
            if (PersonForwardOutput.getArchOutputStruct().getUlRowQty() == 0) {
                bInsertName = true;
            }
            if (bInsertName) {
                
                rc = CallCCMNA0D(pInputMsg29, PersonClosedOutput, tempIndex, bPrimaryNameExist, pServiceStatus);
                
                
                // only if the status is not new
                
                if (rc != SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        return rc;
    }

    static int CallCINV31D(CINV31DI pInputMsg30, CINV31DO pOutputMsg34, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* declare local variables */
        int rc = 0;
        int i30 = 0;
        
        /* Declare local variables */
        CINV31DI pCINV31DInputRec = null;
        CINV31DO pCINV31DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV31DInputRec = new CINV31DI();
        
        pCINV31DOutputRec = new CINV31DO();
        pCINV31DInputRec.setArchInputStruct(pInputMsg30.getArchInputStruct());
        pCINV31DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCINV31DInputRec.getArchInputStruct().setUlPageSizeNbr(CINV31DO._CINV31DO__ROWCINV31DO_SIZE);
        pCINV31DInputRec.setUlIdPerson(pInputMsg30.getUlIdPerson());
        rc = cinv31dQUERYdam(sqlca, pCINV31DInputRec, pCINV31DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                // Populate Output Message
                for (i30 = 0;i30 < pCINV31DOutputRec.getArchOutputStruct().getUlRowQty();i30++) {
                    
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setSzCdNameSuffix(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getSzCdNameSuffix());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setDtDtNameEndDate(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getDtDtNameEndDate());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setDtDtNameStartDate(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getDtDtNameStartDate());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setUlIdName(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getUlIdName());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setUlIdPerson(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getUlIdPerson());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setBIndNameInvalid(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getBIndNameInvalid());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setBIndNamePrimary(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getBIndNamePrimary());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setSzNmNameFirst(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getSzNmNameFirst());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setSzNmNameLast(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getSzNmNameLast());
                    pOutputMsg34.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).setSzNmNameMiddle(pCINV31DOutputRec.getROWCINV31DO_ARRAY().getROWCINV31DO(i30).getSzNmNameMiddle());
                }
                
                pOutputMsg34.getArchOutputStruct().setUlRowQty(pCINV31DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg34.getArchOutputStruct().setBMoreDataInd(pCINV31DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  Call DAM
                rc = SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                pOutputMsg34.getArchOutputStruct().setUlRowQty(0);
                rc = SUCCESS;
                break;
                //  pCCMN99DInputRec->ulSysIdPriorPerson is the Person
                // who currently has the ToDo's ('WHERE' clause).
                // pCCMN99DInputRec->ulIdPerson is the Person to whom
                // the ToDo's are to be assigned ('SET' clause).
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNA0D(CCFC14SI pInputMsg31, CINV31DO pOutputMsg35, int iIndex, char bPrimaryExist, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNA0DI pCCMNA0DInputRec = null;
        CCMNA0DO pCCMNA0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNA0DInputRec = new CCMNA0DI();
        pCCMNA0DOutputRec = new CCMNA0DO();
        pCCMNA0DInputRec.setArchInputStruct(pInputMsg31.getArchInputStruct());
        pCCMNA0DInputRec.setUlIdPerson(pInputMsg31.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        rc = ARC_UTLGetDateAndTime(pCCMNA0DInputRec.getDtDtNameStartDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pCCMNA0DInputRec.getDtDtNameEndDate().day = DateHelper.NULL_DATE;
        pCCMNA0DInputRec.getDtDtNameEndDate().month = DateHelper.NULL_DATE;
        pCCMNA0DInputRec.getDtDtNameEndDate().year = DateHelper.NULL_DATE;
        pCCMNA0DInputRec.setBIndNameInvalid(pOutputMsg35.getROWCINV31DO_ARRAY().getROWCINV31DO(iIndex).getBIndNameInvalid());
        
        if (bPrimaryExist != 0) {
            pCCMNA0DInputRec.setBIndNamePrimary(FND_NO);
        }
        else {
            pCCMNA0DInputRec.setBIndNamePrimary(pOutputMsg35.getROWCINV31DO_ARRAY().getROWCINV31DO(iIndex).getBIndNamePrimary());
        }
        pCCMNA0DInputRec.setSzNmNameFirst(pOutputMsg35.getROWCINV31DO_ARRAY().getROWCINV31DO(iIndex).getSzNmNameFirst());
        pCCMNA0DInputRec.setSzNmNameLast(pOutputMsg35.getROWCINV31DO_ARRAY().getROWCINV31DO(iIndex).getSzNmNameLast());
        pCCMNA0DInputRec.setSzNmNameMiddle(pOutputMsg35.getROWCINV31DO_ARRAY().getROWCINV31DO(iIndex).getSzNmNameMiddle());
        pCCMNA0DInputRec.setSzCdNameSuffix(pOutputMsg35.getROWCINV31DO_ARRAY().getROWCINV31DO(iIndex).getSzCdNameSuffix());
        
        /*
        ** Call DAM
        */
        rc = ccmna0dAUDdam(sqlca, pCCMNA0DInputRec, pCCMNA0DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSS60D(CLSS60DI pInputMsg32, CLSS60DO pOutputMsg36, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i31 = 0;
        /*
        ** Declare local variables
        */
        CLSS60DI pCLSS60DInputRec = null;
        CLSS60DO pCLSS60DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS60DInputRec = new CLSS60DI();
        
        pCLSS60DOutputRec = new CLSS60DO();
        pCLSS60DInputRec.setArchInputStruct(pInputMsg32.getArchInputStruct());
        pCLSS60DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS60DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS60DO._CLSS60DO__ROWCLSS60DO_SIZE);
        pCLSS60DInputRec.setUlIdPerson(pInputMsg32.getUlIdPerson());
        pCLSS60DInputRec.setDtScrDtCharEffDate(pInputMsg32.getDtScrDtCharEffDate());
        /* get the records from case_merge table for case_merge_to id */
        rc = clss60dQUERYdam(sqlca, pCLSS60DInputRec, pCLSS60DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i31 = 0;i31 < pCLSS60DOutputRec.getArchOutputStruct().getUlRowQty();++i31) {
                    pOutputMsg36.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).setSzCdCharCategory(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).getSzCdCharCategory());
                    pOutputMsg36.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).setCdCharacteristic(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).getCdCharacteristic());
                    pOutputMsg36.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).setUlIdCharacteristics(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).getUlIdCharacteristics());
                    pOutputMsg36.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).setDtDtCharStart(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).getDtDtCharStart());
                    pOutputMsg36.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).setDtDtCharEnd(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).getDtDtCharEnd());
                    pOutputMsg36.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).setTsLastUpdate(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i31).getTsLastUpdate());
                }
                pOutputMsg36.getArchOutputStruct().setUlRowQty(pCLSS60DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg36.getArchOutputStruct().setBMoreDataInd(pCLSS60DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                // get the records from case_merge table as case_merge_from id
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pOutputMsg36.getArchOutputStruct().setUlRowQty(0);
                pOutputMsg36.getArchOutputStruct().setBMoreDataInd(pCLSS60DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSECA6D2(CSECA6DI pInputMsg33, CSECA6DO * pOutputMsg37, String pbRowDifferent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSECA6DI pCSECA6DInputRec = null;
        CSECA6DO pCSECA6DOutputRec = null;
        int i32 = 0;
        int j = 0;
        String szTemp = new String();// this is to hold elig type
        char bTitle19 = 0;// this group is title 19
        boolean bNonTitle19 = false;// this group is non-title 19
        char bTitle19Exists = 0;//  title 19 exists
        boolean bNonTitle19Exists = false;//  non-title 19 exists
        
        /* when merging two persons,
        ** if person_forward in any specific period has elig_type of title 19,
        **	 then DO NOT do anything.
        ** else if person_forward in any specific period does not have elig_type of
        **   title 19 or has no elig_type, then if person_closed has any, bring it over
        */
        
        // group one is XIX which means CD_PERS_ELIG_ELIG_TYPE is
        // one or more of these types ('001','004','005','006','010','011','013','014')
        
        
        // group two is non-XIX which means CD_PERS_ELIG_ELIG_TYPE is
        // one or more of these types ('002','003','007','008','009','012','015')
        
        
        
        char bDuplicate19 = 0;
        char bDuplicateNon19 = 0;
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA6DInputRec = new CSECA6DI();
        pCSECA6DOutputRec = new CSECA6DO();
        if (pCSECA6DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        /*
        ** Check for NULL pointers, return fatal error if found.
        */
        if (pCSECA6DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCSECA6DInputRec.setArchInputStruct(pInputMsg33.getArchInputStruct());
        pCSECA6DInputRec.setUlIdPersEligPerson(pInputMsg33.getUlIdPersEligPerson());
        pCSECA6DInputRec.setDtDtPersEligStart(pInputMsg33.getDtDtPersEligStart());
        pCSECA6DInputRec.setDtDtPersEligEnd(pInputMsg33.getDtDtPersEligEnd());
        
        /* i+3 because szCdPersEligType has 3 char. we want to get the next
        ** szCdPersEligType when we increment i. 21: because there are 7 EligType
        ** and each has 3 characters. this loop determines if szCdPersEligType is
        ** of type XIX or non-XIX
        */
        for (i32 = 0;i32 < TITLE_19.length();i32 += 3) {
            pCSECA6DInputRec.setSzCdPersEligType(szTemp = TITLE_19[i32]);
            bTitle19 = (pInputMsg33.getSzCdPersEligType().equals(pCSECA6DInputRec.getSzCdPersEligType()));
            
            if (bTitle19 != 0) {
                bNonTitle19 = false;
                
                break;
            }
        }
        
        
        /*
        ** Call CCMN60D
        */
        rc = SUCCESS;
        pCSECA6DInputRec.setSzCdPersEligType(NULL_STRING);
        /* regardless of szCdPersEligType being title 19, we have to check to see if
        ** person_forward has any title19 in that specific period and that's what
        ** this first loop does.
        */
        
        
        for (i32 = 0;i32 < TITLE_19.length() && rc == SUCCESS;i32 += 3) {
            pCSECA6DInputRec.setSzCdPersEligType(szTemp = TITLE_19[i32]);
            
            
            //  Call CCMN43D
            rc = cseca6dQUERYdam(sqlca, pCSECA6DInputRec, pCSECA6DOutputRec);
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    if (pCSECA6DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                        bTitle19Exists = 1;
                    }
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  CALL CCMN43D
                    
                    rc = SUCCESS;
                    
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Call CCMN43D
                    rc = SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
            if (bTitle19Exists != 0) {
                
                break;
            }
        }
        
        
        /* we check to see if person_forward has any of non_title19 in that
        ** specific period and that's what this loop does.
        */
        for (i32 = 0;i32 < NON_TITLE_19.length() && rc == SUCCESS &&!(bTitle19Exists != 0);i32 += 3) {
            pCSECA6DInputRec.setSzCdPersEligType(szTemp = NON_TITLE_19[i32]);
            //*60D* isn't used in this branch
            //                  free(pCCMN60DInputRec);
            //                  free(pCCMN60DOutputRec);
            rc = cseca6dQUERYdam(sqlca, pCSECA6DInputRec, pCSECA6DOutputRec);
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    //  Blindly return rc code to allow user to determine
                    // proper course of action
                    
                    // 
                    // Prepare output message to be returned and return
                    // 
                    if (pCSECA6DOutputRec.getUlSysNbrGenericCntr() >= 1) {
                        bNonTitle19Exists = true;
                    }
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = SUCCESS;
                    
                    //  Set explan_data to usRow
                    // Note: Use sprintf
                    //##                          sprintf(pReturnPB->appl_status.explan_data,
                    //##                                  "%u",
                    //##                                  usVersionRow);
                    
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Call CSEC04D
                    rc = SUCCESS;
                    
                    //  Set explan_data to usRow
                    // Note: Use sprintf
                    //##                          sprintf(pReturnPB->appl_status.explan_data,
                    //##                                  "%u",
                    //##                                  usVersionRow);
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
            if (bNonTitle19Exists) {
                
                break;
            }
        }
        if (bTitle19Exists != 0) {
            pbRowDifferent = CStringUtils.setCharAt(pbRowDifferent, 0, false);
        }
        else if (!(bTitle19Exists != 0) && bTitle19 != 0) {
            pbRowDifferent = CStringUtils.setCharAt(pbRowDifferent, 0, true);
        }
        else if (!(bTitle19Exists != 0) && bNonTitle19Exists &&!(bTitle19 != 0)) {
            pbRowDifferent = CStringUtils.setCharAt(pbRowDifferent, 0, false);
        }
        else if (!(bTitle19Exists != 0) &&!bNonTitle19Exists) {
            pbRowDifferent = CStringUtils.setCharAt(pbRowDifferent, 0, true);
        }
        return rc;
    }

    static int CallComparePhone(CCFC14SI pInputMsg34, CCFC14SO * pOutputMsg38, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i33 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        /*
        ** Declare local variables
        */
        String szTemp = new String();
        int tempIndex = 0;
        int ulIdAddress = 0;
        boolean bInsertPhone = false;
        char bPrimaryPhoneExist = 0;
        
        /* string to hold the concatenated phone for comparison */
        String szForward = new String();
        String szClosed = new String();
        
        CCMNB0DI PersonForwardInput = null;
        CCMNB0DO PersonForwardOutput = null;
        
        CCMNB0DI PersonClosedInput = null;
        CCMNB0DO PersonClosedOutput = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonForwardInput = new CCMNB0DI();
        PersonForwardOutput = new CCMNB0DO();
        PersonClosedInput = new CCMNB0DI();
        PersonClosedOutput = new CCMNB0DO();
        if ((PersonForwardInput == null) || (PersonForwardOutput == null) || (PersonClosedInput == null) || (PersonClosedOutput == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        PersonForwardInput.setUlIdPerson(pInputMsg34.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        PersonForwardInput.setBSysIndIntake(IND_VALID_NAME);
        
        /*
        ** Call DAM
        */
        rc = CallCCMNB0D(PersonForwardInput, PersonForwardOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        PersonClosedInput.setUlIdPerson(pInputMsg34.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        PersonClosedInput.setBSysIndIntake(IND_VALID_NAME);
        
        rc = CallCCMNB0D(PersonClosedInput, PersonClosedOutput, pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /* check to see if person_forward has primary phone */
        for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty() && PersonForwardOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(j).getBIndPersonPhoneInvalid() == 'N';j++) {
            if (PersonForwardOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(j).getBIndPersonPhonePrimary() == 'Y') {
                bPrimaryPhoneExist = 1;
            }
        }
        
        for (i33 = 0;i33 < PersonClosedOutput.getArchOutputStruct().getUlRowQty() && PersonClosedOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i33).getBIndPersonPhoneInvalid() == 'N';i33++) {
            tempIndex = i33;
            szClosed = NULL_STRING;
            szTemp = PersonClosedOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i33).getLNbrPhone();
            szClosed = szTemp;
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i33).getLNbrPhoneExtension();
            
            strncat(szClosed, szTemp, szTemp.length());
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i33).getSzCdPhoneType();
            strncat(szClosed, szTemp, szTemp.length());
            szForward = NULL_STRING;
            // select one record and compare it with all the existing phones in
            // person forward. insert if no match found
            for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty() && PersonForwardOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i33).getBIndPersonPhoneInvalid() == 'N';j++) {
                szTemp = PersonForwardOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(j).getLNbrPhone();
                szForward = szTemp;
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(j).getLNbrPhoneExtension();
                strncat(szForward, szTemp, szTemp.length());
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(j).getSzCdPhoneType();
                strncat(szForward, szTemp, szTemp.length());
                
                if (0 == szForward.compareTo(szClosed)) {
                    bInsertPhone = false;
                    break;
                }
                else {
                    bInsertPhone = true;
                }
                szForward = NULL_STRING;
            }
            
            if (PersonForwardOutput.getArchOutputStruct().getUlRowQty() == 0) {
                bInsertPhone = true;
            }
            
            if (bInsertPhone) {
                
                userlog("CallComparePhone_person_id_is:=%d", pInputMsg34.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
                rc = CallCCMN95D(pInputMsg34, PersonClosedOutput, tempIndex, bPrimaryPhoneExist, pServiceStatus);
                userlog("CallComparePhone_explan_code:%d, rc_is:%d", pServiceStatus.explan_code, rc);
                
                
                //  Analyze return code
                switch (rc) {
                        // A return of SQL_NOT_FOUND is successful
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            //  end check of valid resource id
        }
        return rc;
    }

    static int CallCCMN95D(CCFC14SI pInputMsg35, CCMNB0DO pOutputMsg39, int iIndex, char bPrimaryExist, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i34 = iIndex;
        int rc = 0;/* Return code */
        
        CCMN95DI pCCMN95DInputRec = null;
        CCMN95DO pCCMN95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMN95DInputRec = new CCMN95DI();
        
        pCCMN95DOutputRec = new CCMN95DO();
        pCCMN95DInputRec.setArchInputStruct(pInputMsg35.getArchInputStruct());
        pCCMN95DInputRec.getROWCCMN95DI().setUlIdPerson(pInputMsg35.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCCMN95DInputRec.getROWCCMN95DI().setUlIdPhone(0);
        pCCMN95DInputRec.getROWCCMN95DI().setSzCdPhoneType(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getSzCdPhoneType());
        pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhone(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getLNbrPhone());
        pCCMN95DInputRec.getROWCCMN95DI().setLNbrPhoneExtension(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getLNbrPhoneExtension());
        pCCMN95DInputRec.getROWCCMN95DI().setDtDtPersonPhoneStart(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getDtDtPersonPhoneStart());
        pCCMN95DInputRec.getROWCCMN95DI().getDtDtPersonPhoneEnd().day = DateHelper.NULL_DATE;
        pCCMN95DInputRec.getROWCCMN95DI().getDtDtPersonPhoneEnd().month = DateHelper.NULL_DATE;
        pCCMN95DInputRec.getROWCCMN95DI().getDtDtPersonPhoneEnd().year = DateHelper.NULL_DATE;
        
        /*
        ** Populate DAM input structure
        */
        
        if (bPrimaryExist != 0) {
            
            pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhonePrimary(FND_NO);
        }
        else {
            
            pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhonePrimary(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getBIndPersonPhonePrimary());
        }
        pCCMN95DInputRec.getROWCCMN95DI().setBIndPersonPhoneInvalid(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getBIndPersonPhoneInvalid());
        pCCMN95DInputRec.getROWCCMN95DI().setSzTxtPhoneComments(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getSzTxtPhoneComments());
        pCCMN95DInputRec.getROWCCMN95DI().setTsLastUpdate(pOutputMsg39.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i34).getTsLastUpdate());
        pCCMN95DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        userlog("CallCCMN95D_person_id_is:%d", pInputMsg35.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        rc = ccmn95dAUDdam(sqlca, pCCMN95DInputRec, pCCMN95DOutputRec);
        
        userlog("CallCCMN95D_explan_code_is:%d, rc_is=%d", pServiceStatus.explan_code, rc);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMNB0D(CCMNB0DI pInputMsg36, CCMNB0DO pOutputMsg40, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i35 = 0;
        CCMNB0DI pCCMNB0DInputRec = null;
        CCMNB0DO pCCMNB0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMNB0DInputRec = new CCMNB0DI();
        
        pCCMNB0DOutputRec = new CCMNB0DO();
        pCCMNB0DInputRec.setArchInputStruct(pInputMsg36.getArchInputStruct());
        pCCMNB0DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNB0DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB0DO._CCMNB0DO__ROWCCMNB0DO_SIZE);
        pCCMNB0DInputRec.setUlIdPerson(pInputMsg36.getUlIdPerson());
        pCCMNB0DInputRec.setBSysIndIntake(1);
        pCCMNB0DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(0, 147);
        pCCMNB0DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(1, 112);
        pCCMNB0DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(2, 12);
        pCCMNB0DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(3, 31);
        pCCMNB0DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(4, 1);
        pCCMNB0DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(5, 1);
        pCCMNB0DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(6, 1);
        rc = ccmnb0dQUERYdam(sqlca, pCCMNB0DInputRec, pCCMNB0DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  Declare FOUNDATION variables
                    
                    //  Declare local variables
                    
                    //  Start performance timer for service
                    rc = SUCCESS;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg40.getArchOutputStruct().setUlRowQty(pCCMNB0DOutputRec.getArchOutputStruct().getUlRowQty());
            
            for (i35 = 0;i35 < pCCMNB0DOutputRec.getArchOutputStruct().getUlRowQty();++i35) {
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setSzCdPhoneType(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getSzCdPhoneType());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setLNbrPhone(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getLNbrPhone());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setLNbrPhoneExtension(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getLNbrPhoneExtension());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setDtDtPersonPhoneStart(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getDtDtPersonPhoneStart());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setDtDtPersonPhoneEnd(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getDtDtPersonPhoneEnd());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setBIndPersonPhonePrimary(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getBIndPersonPhonePrimary());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setBIndPersonPhoneInvalid(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getBIndPersonPhoneInvalid());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setSzTxtPhoneComments(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getSzTxtPhoneComments());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setUlIdPhone(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getUlIdPhone());
                pOutputMsg40.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).setTsLastUpdate(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i35).getTsLastUpdate());
            }
        }
        return rc;
    }

    static int CallCompareAddress(CCFC14SI pInputMsg37, CCFC14SO * pOutputMsg41, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i36 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        String szTemp = new String();
        int tempIndex = 0;
        Pint ulIdAddress = new Pint();
        ulIdAddress.value = 0;
        boolean bInsertAddress = false;
        char bPrimaryAddressExist = 0;
        
        /* string to hold the concatenated address for comparison */
        String szForward = new String();
        String szClosed = new String();
        CCMN96DI PersonForwardInput = null;
        CCMN96DO PersonForwardOutput = null;
        
        CCMN96DI PersonClosedInput = null;
        CCMN96DO PersonClosedOutput = null;
        
        FndInt3date dtSysdate = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonForwardInput = new CCMN96DI();
        PersonForwardOutput = new CCMN96DO();
        PersonClosedInput = new CCMN96DI();
        PersonClosedOutput = new CCMN96DO();
        if ((PersonForwardInput == null) || (PersonForwardOutput == null) || (PersonClosedInput == null) || (PersonClosedOutput == null)) {
            
            //  Call CCMN44D
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        /*
        ** Call CINV51D
        */
        rc = ARC_UTLGetDateAndTime(dtSysdate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        PersonForwardInput.setUlIdPerson(pInputMsg37.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        PersonForwardInput.setBSysIndIntake(IND_VALID_NAME);
        rc = Ccmn42s.CallCCMN96D(PersonForwardInput, PersonForwardOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        PersonClosedInput.setUlIdPerson(pInputMsg37.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        PersonClosedInput.setBSysIndIntake(IND_VALID_NAME);
        rc = Ccmn42s.CallCCMN96D(PersonClosedInput, PersonClosedOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        /* check to see if person_forward has primary address */
        for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty() && PersonForwardOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getBIndPersAddrLinkInvalid() == 'N';j++) {
            if (PersonForwardOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getBIndPersAddrLinkPrimary() == 'Y') {
                bPrimaryAddressExist = 1;
            }
        }
        
        for (i36 = 0;i36 < PersonClosedOutput.getArchOutputStruct().getUlRowQty() && PersonClosedOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i36).getBIndPersAddrLinkInvalid() == 'N';i36++) {
            tempIndex = i36;
            szClosed = NULL_STRING;
            szTemp = PersonClosedOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i36).getLAddrZip();
            szClosed = szTemp;
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i36).getSzCdAddrState();
            
            strncat(szClosed, szTemp, szTemp.length());
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i36).getSzAddrCity();
            strncat(szClosed, szTemp, szTemp.length());
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i36).getSzAddrPersAddrStLn1();
            strncat(szClosed, szTemp, szTemp.length());
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i36).getSzAddrPersAddrStLn2();
            strncat(szClosed, szTemp, szTemp.length());
            szForward = NULL_STRING;
            // select one record and compare it with all the existing names in
            // person forward. insert if no match found
            for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty() && PersonForwardOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getBIndPersAddrLinkInvalid() == 'N';j++) {
                szTemp = PersonForwardOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getLAddrZip();
                szForward = szTemp;
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getSzCdAddrState();
                strncat(szForward, szTemp, szTemp.length());
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getSzAddrCity();
                strncat(szForward, szTemp, szTemp.length());
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getSzAddrPersAddrStLn1();
                strncat(szForward, szTemp, szTemp.length());
                szForward += ",";
                szTemp = PersonClosedOutput.getROWCCMN96DO_ARRAY().getROWCCMN96DO(j).getSzAddrPersAddrStLn2();
                strncat(szForward, szTemp, szTemp.length());
                if (0 == szForward.compareTo(szClosed)) {
                    bInsertAddress = false;
                    break;
                }
                else {
                    bInsertAddress = true;
                }
                szForward = NULL_STRING;
            }
            if (PersonForwardOutput.getArchOutputStruct().getUlRowQty() == 0) {
                bInsertAddress = true;
            }
            if (bInsertAddress) {
                
                //  Call CCMN44D
                rc = CallCCMNA8D(pInputMsg37, PersonClosedOutput, tempIndex, ulIdAddress, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                        // 
                        // (END): Retrieve DAM: ccmn44d     
                        // Get NmPersonFull given IdPerson
                        // 
                        
                        
                        //  CASE SQL_NOT_FOUND for CINV51D (VP)
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                //  Call CINV51D
                rc = CallCCMNA9D(pInputMsg37, PersonClosedOutput, tempIndex, ulIdAddress, bPrimaryAddressExist, pServiceStatus);
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
        }
        return rc;
    }

    static int CallCCMNA8D(CCFC14SI pInputMsg38, CCMN96DO pOutputMsg42, int iIndex, Pint ulIdAddress, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i37 = iIndex;
        int rc = 0;/* Return code */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        CCMNA8DI pCCMNA8DInputRec = null;
        CCMNA8DO pCCMNA8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMNA8DInputRec = new CCMNA8DI();
        
        pCCMNA8DOutputRec = new CCMNA8DO();
        pCCMNA8DInputRec.setArchInputStruct(pInputMsg38.getArchInputStruct());
        pCCMNA8DInputRec.setSzAddrPersAddrStLn1(pOutputMsg42.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i37).getSzAddrPersAddrStLn1());
        pCCMNA8DInputRec.setSzAddrPersAddrStLn2(pOutputMsg42.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i37).getSzAddrPersAddrStLn2());
        pCCMNA8DInputRec.setSzAddrCity(pOutputMsg42.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i37).getSzAddrCity());
        pCCMNA8DInputRec.setLAddrZip(pOutputMsg42.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i37).getLAddrZip());
        pCCMNA8DInputRec.setSzCdAddrCounty(pOutputMsg42.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i37).getSzCdAddrCounty());
        pCCMNA8DInputRec.setSzAddrPersAddrAttn(pOutputMsg42.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i37).getSzAddrPersAddrAttn());
        pCCMNA8DInputRec.setSzCdAddrState(pOutputMsg42.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i37).getSzCdAddrState());
        pCCMNA8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        rc = ccmna8dAUDdam(sqlca, pCCMNA8DInputRec, pCCMNA8DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdAddress.value = pCCMNA8DOutputRec.getLdIdAddress();
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                // declare FOUNDATION variables
                
                // local variables
                
                // Start performance timer for service
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNA9D(CCFC14SI pInputMsg39, CCMN96DO pOutputMsg43, int iIndex, Pint ulIdAddress, char bPrimaryExist, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i38 = iIndex;
        
        /*
        ** Declare local variables 
        */
        int rc = 0;
        CCMNA9DI pCCMNA9DInputRec = null;
        CCMNA9DO pCCMNA9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMNA9DInputRec = new CCMNA9DI();
        
        pCCMNA9DOutputRec = new CCMNA9DO();
        pCCMNA9DInputRec.setArchInputStruct(pInputMsg39.getArchInputStruct());
        pCCMNA9DInputRec.setSzCdPersAddrLinkType(pOutputMsg43.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i38).getSzCdPersAddrLinkType());
        pCCMNA9DInputRec.setDtDtPersAddrLinkEnd(pOutputMsg43.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i38).getDtDtPersAddrLinkEnd());
        pCCMNA9DInputRec.setDtDtPersAddrLinkStart(pInputMsg39.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getDtDtPersMerge());
        pCCMNA9DInputRec.setUlIdPerson(pInputMsg39.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCCMNA9DInputRec.setLdIdAddress(ulIdAddress.value);
        pCCMNA9DInputRec.setUlIdAddrPersonLink(pOutputMsg43.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i38).getUlIdAddrPersonLink());
        pCCMNA9DInputRec.setBIndPersAddrLinkInvalid(pOutputMsg43.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i38).getBIndPersAddrLinkInvalid());
        
        if (bPrimaryExist != 0) {
            pCCMNA9DInputRec.setBIndPersAddrLinkPrimary(FND_NO);
        }
        else {
            pCCMNA9DInputRec.setBIndPersAddrLinkPrimary(pOutputMsg43.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i38).getBIndPersAddrLinkPrimary());
        }
        pCCMNA9DInputRec.setSzTxtPersAddrCmnts(pOutputMsg43.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i38).getSzTxtPersAddrCmnts());
        pCCMNA9DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        rc = ccmna9dAUDdam(sqlca, pCCMNA9DInputRec, pCCMNA9DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            case NO_DATA_FOUND:
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                // 
                // Call DAMs to retrieve data
                // 
                //  Call PostEvent
                // 
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN96D(CCMN96DI pInputMsg40, CCMN96DO pOutputMsg44, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i39 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN96DI pCCMN96DInputRec = null;
        CCMN96DO pCCMN96DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCCMN96DInputRec = new CCMN96DI();
        
        pCCMN96DOutputRec = new CCMN96DO();
        pCCMN96DInputRec.setUlIdPerson(pInputMsg40.getUlIdPerson());
        pCCMN96DInputRec.setBSysIndIntake(1);
        pCCMN96DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(0, 147);
        pCCMN96DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(1, 112);
        pCCMN96DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(2, 12);
        pCCMN96DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(3, 31);
        pCCMN96DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(4, 1);
        pCCMN96DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(5, 1);
        pCCMN96DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(6, 1);
        pCCMN96DInputRec.setArchInputStruct(pInputMsg40.getArchInputStruct());
        pCCMN96DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN96DInputRec.getArchInputStruct().setUlPageSizeNbr(65);
        rc = ccmn96dQUERYdam(sqlca, pCCMN96DInputRec, pCCMN96DOutputRec);
        
        /**************************************************************************
        ** END CCMN05U
        **************************************************************************/
        
        /*
        ** IMPACT BEGIN - Don't create a new event in "Approver mode"
        **
        **  Original code:
        **  if (FND_SUCCESS == RetVal)
        */
        if (rc != 0) {
            
            //  Analyze return code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = SUCCESS;
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            //  Populate Output Message
            for (i39 = 0;i39 < pCCMN96DOutputRec.getArchOutputStruct().getUlRowQty();++i39) {
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setBIndPersAddrLinkPrimary(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getBIndPersAddrLinkPrimary());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setBIndPersAddrLinkInvalid(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getBIndPersAddrLinkInvalid());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzCdPersAddrLinkType(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzCdPersAddrLinkType());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzAddrPersAddrStLn1(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzAddrPersAddrStLn1());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzAddrPersAddrStLn2(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzAddrPersAddrStLn2());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzAddrPersAddrAttn(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzAddrPersAddrAttn());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzAddrCity(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzAddrCity());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setLAddrZip(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getLAddrZip());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzCdAddrCounty(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzCdAddrCounty());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzCdAddrState(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzCdAddrState());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setSzTxtPersAddrCmnts(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getSzTxtPersAddrCmnts());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setTsSysTsLastUpdate2(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getTsSysTsLastUpdate2());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setTsLastUpdate(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getTsLastUpdate());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setDtDtPersAddrLinkStart(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getDtDtPersAddrLinkStart());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setDtDtPersAddrLinkEnd(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getDtDtPersAddrLinkEnd());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setLdIdAddress(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getLdIdAddress());
                pOutputMsg44.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).setUlIdAddrPersonLink(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i39).getUlIdAddrPersonLink());
            }
            pOutputMsg44.getArchOutputStruct().setUlRowQty(pCCMN96DOutputRec.getArchOutputStruct().getUlRowQty());
        }
        return rc;
    }

    static int CallCompareEducation(CCFC14SI pInputMsg41, CCFC14SO * pOutputMsg45, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i40 = 0;
        int j = 0;
        /*
        ** Declare local variables
        */
        String szTemp = new String();
        int tempIndex = 0;
        int lRC1 = 0;
        
        boolean bInsertEducation = false;
        
        /* string to hold the concatenated Education for comparison */
        String szForward = new String();
        String szClosed = new String();
        
        CLSC49DI PersonForwardInput = null;
        CLSC49DO PersonForwardOutput = null;
        
        CLSC49DI PersonClosedInput = null;
        CLSC49DO PersonClosedOutput = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        PersonForwardInput = new CLSC49DI();
        PersonForwardOutput = new CLSC49DO();
        PersonClosedInput = new CLSC49DI();
        PersonClosedOutput = new CLSC49DO();
        
        /*
        ** SIR #4322 - 3/28/96 - PURCELA - Added conditionality into each case
        ** that the Event Status is not being set to COMP.  If this is occurring,
        ** then then all ToDos should not be created, except for FAD038 (The
        ** Alert to create a new Subsidy Period).
        */
        
        /*
        ** If the todo indicator for the Application Sent is false
        **  process todo.
        */
        if ((PersonForwardInput == null) || (PersonForwardOutput == null) || (PersonClosedInput == null) || (PersonClosedOutput == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        PersonForwardInput.setUlIdPerson(pInputMsg41.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        rc = CallCLSC49D(PersonForwardInput, PersonForwardOutput, pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        PersonClosedInput.setUlIdPerson(pInputMsg41.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeClosed());
        
        /*
        ** Call DAM
        */
        rc = CallCLSC49D(PersonClosedInput, PersonClosedOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        
        for (i40 = 0;i40 < PersonClosedOutput.getArchOutputStruct().getUlRowQty();i40++) {
            tempIndex = i40;
            szClosed = NULL_STRING;
            szTemp = PersonClosedOutput.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i40).getSzNmEdhistSchool();
            szClosed = szTemp;
            szClosed += ",";
            szTemp = PersonClosedOutput.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i40).getSzCdEdhistEnrollGrade();
            strncat(szClosed, szTemp, szTemp.length());
            szForward = NULL_STRING;
            // select one record and compare it with all the existing names in
            // person forward. insert if no match found
            for (j = 0;j < PersonForwardOutput.getArchOutputStruct().getUlRowQty();j++) {
                szTemp = PersonForwardOutput.getROWCLSC49DO_ARRAY().getROWCLSC49DO(j).getSzNmEdhistSchool();
                szForward = szTemp;
                szForward += ",";
                szTemp = PersonForwardOutput.getROWCLSC49DO_ARRAY().getROWCLSC49DO(j).getSzCdEdhistEnrollGrade();
                strncat(szForward, szTemp, szTemp.length());
                lRC1 = ARC_UTLCompareDateAndTime((FndInt3date) & PersonForwardOutput.getROWCLSC49DO_ARRAY().getROWCLSC49DO(j).getDtDtEdhistEnrollDate() , 0, (FndInt3date) & PersonClosedOutput.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i40).getDtDtEdhistEnrollDate() , 0);
                //  If CFAD40SI CFAD40SIGOO DtAdptsubAppSent is not NULL_DATE and
                // CFAD40SI CFAD40SIGOO DtAdptSubAppReturned is  Null_Date,
                // set ToDoFlag[FAD037] to true.
                if (0 != szForward.compareTo(szClosed) && lRC1 != 0) {
                    bInsertEducation = true;
                }
                else {
                    bInsertEducation = false;
                    
                    break;
                }
                szForward = NULL_STRING;
            }
            
            
            //  If the todo indicator for the Agreement Sent is false
            // process todo.
            if (PersonForwardOutput.getArchOutputStruct().getUlRowQty() == 0) {
                bInsertEducation = true;
            }
            
            //  If CFAD40SI CFAD40SIGOO dtDtAdptSubAgreeSent is not NULL_DATE and
            // CFAD40SI CFAD40SIGOO dtDtAdptSubAgreeRetn is  Null_Date,
            // set ToDoFlag[FAD040] to true.
            if (bInsertEducation) {
                rc = CallCAUD78D(pInputMsg41, PersonClosedOutput, tempIndex, pServiceStatus);
                
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
            }
        }
        return rc;
    }

    static int CallCAUD78D(CCFC14SI pInputMsg42, CLSC49DO pOutputMsg46, int iIndex, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i41 = iIndex;
        int rc = 0;/* Return code */
        CAUD78DI pCAUD78DInputRec = null;
        CAUD78DO pCAUD78DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCAUD78DInputRec = new CAUD78DI();
        
        pCAUD78DOutputRec = new CAUD78DO();
        pCAUD78DInputRec.setArchInputStruct(pInputMsg42.getArchInputStruct());
        pCAUD78DInputRec.setTsLastUpdate(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getTsLastUpdate());
        pCAUD78DInputRec.setDtDtEdhistEnrollDate(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getDtDtEdhistEnrollDate());
        pCAUD78DInputRec.setDtDtEdhistWithdrawnDate(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getDtDtEdhistWithdrawnDate());
        pCAUD78DInputRec.setCIndEdhistTeaSchool(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getCIndEdhistTeaSchool());
        
        pCAUD78DInputRec.setSzAddrEdhistCity(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzAddrEdhistCity());
        pCAUD78DInputRec.setSzAddrEdhistCnty(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzAddrEdhistCnty());
        pCAUD78DInputRec.setSzAddrEdhistState(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzAddrEdhistState());
        pCAUD78DInputRec.setSzAddrEdhistStreetLn1(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzAddrEdhistStreetLn1());
        pCAUD78DInputRec.setSzAddrEdhistStreetLn2(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzAddrEdhistStreetLn2());
        pCAUD78DInputRec.setSzAddrEdhistZip(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzAddrEdhistZip());
        pCAUD78DInputRec.setSzNbrEdhistPhone(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzNbrEdhistPhone());
        pCAUD78DInputRec.setSzNbrEdhistPhoneExt(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzNbrEdhistPhoneExt());
        pCAUD78DInputRec.setSzTxtEdhistAddrCmnt(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzTxtEdhistAddrCmnt());
        pCAUD78DInputRec.setSzCdEdhistEnrollGrade(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistEnrollGrade());
        pCAUD78DInputRec.setSzCdEdhistWithdrawnGrade(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistWithdrawnGrade());
        pCAUD78DInputRec.setSzCdEdhistNeeds1(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds1());
        pCAUD78DInputRec.setSzCdEdhistNeeds2(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds2());
        pCAUD78DInputRec.setSzCdEdhistNeeds3(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds3());
        pCAUD78DInputRec.setSzCdEdhistNeeds4(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds4());
        pCAUD78DInputRec.setSzCdEdhistNeeds5(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds5());
        pCAUD78DInputRec.setSzCdEdhistNeeds6(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds6());
        pCAUD78DInputRec.setSzCdEdhistNeeds7(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds7());
        pCAUD78DInputRec.setSzCdEdhistNeeds8(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzCdEdhistNeeds8());
        pCAUD78DInputRec.setSzNmEdhistSchool(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzNmEdhistSchool());
        pCAUD78DInputRec.setSzNmEdhistSchDist(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getSzNmEdhistSchDist());
        
        pCAUD78DInputRec.setUlIdEdhist(0);
        pCAUD78DInputRec.setUlIdResource(pOutputMsg46.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i41).getUlIdResource());
        pCAUD78DInputRec.setUlIdPerson(pInputMsg42.getROWCCFC14SIG00_ARRAY().getROWCCFC14SIG00(0).getUlIdPersMergeForward());
        pCAUD78DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        
        /*
        ** Call DAM
        */
        rc = caud78dAUDdam(sqlca, pCAUD78DInputRec, pCAUD78DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSC49D(CLSC49DI pInputMsg43, CLSC49DO pOutputMsg47, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i42 = 0;
        CLSC49DI pCLSC49DInputRec = null;
        CLSC49DO pCLSC49DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCLSC49DInputRec = new CLSC49DI();
        
        pCLSC49DOutputRec = new CLSC49DO();
        pCLSC49DInputRec.setArchInputStruct(pInputMsg43.getArchInputStruct());
        pCLSC49DInputRec.setUlIdPerson(pInputMsg43.getUlIdPerson());
        pCLSC49DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC49DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC49DO._CLSC49DO__ROWCLSC49DO_SIZE);
        rc = clsc49dQUERYdam(sqlca, pCLSC49DInputRec, pCLSC49DOutputRec);
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    
                    rc = SUCCESS;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            pOutputMsg47.getArchOutputStruct().setUlRowQty(pCLSC49DOutputRec.getArchOutputStruct().getUlRowQty());
            
            for (i42 = 0;i42 < pCLSC49DOutputRec.getArchOutputStruct().getUlRowQty();++i42) {
                
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzNmEdhistSchDist(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzNmEdhistSchDist());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzNmEdhistSchool(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzNmEdhistSchool());
                
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds1(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds1());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds2(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds2());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds3(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds3());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds4(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds4());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds5(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds5());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds6(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds6());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds7(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds7());
                
                //  When retrieving records from the STAGE table, if an error
                // occurs, excluding SQL_NOT_FOUND, the function calls
                // returns a general error to the calling Service. The function
                // aborts processing and all changes to the database are rolled
                // back. A general error message is displayed upon returning to
                // the client.
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistNeeds8(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistNeeds8());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistEnrollGrade(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistEnrollGrade());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzCdEdhistWithdrawnGrade(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzCdEdhistWithdrawnGrade());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzAddrEdhistCity(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzAddrEdhistCity());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzAddrEdhistCnty(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzAddrEdhistCnty());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzAddrEdhistState(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzAddrEdhistState());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzAddrEdhistStreetLn1(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzAddrEdhistStreetLn1());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzAddrEdhistStreetLn2(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzAddrEdhistStreetLn2());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzAddrEdhistZip(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzAddrEdhistZip());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzNbrEdhistPhone(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzNbrEdhistPhone());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzNbrEdhistPhoneExt(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzNbrEdhistPhoneExt());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setSzTxtEdhistAddrCmnt(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getSzTxtEdhistAddrCmnt());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setTsLastUpdate(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getTsLastUpdate());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setDtDtEdhistEnrollDate(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getDtDtEdhistEnrollDate());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setDtDtEdhistWithdrawnDate(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getDtDtEdhistWithdrawnDate());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setCIndEdhistTeaSchool(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getCIndEdhistTeaSchool());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setUlIdEdhist(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getUlIdEdhist());
                pOutputMsg47.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).setUlIdResource(pCLSC49DOutputRec.getROWCLSC49DO_ARRAY().getROWCLSC49DO(i42).getUlIdResource());
            }
        }
        return rc;
    }

}
