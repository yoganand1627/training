package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES94DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES70DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES70DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC75DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC75DO;
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
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccfc14s;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cinv34s;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC54DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES94DO;
/**************************************************************************
**
** Module File:   CCMN03U.src
**
** Service Name:  CloseOpenStage
**
** Description:   This archived library function provides the necessary edits
**                and updates required to close a stage and open a new one.
**                It generates all the required events and to-do's related
**                with the closure of a stage and the opening of a new one.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2-14-95
**
** Programmer:    Alex Ramirez
**
** Archive Information: $Revision:   1.19  $
**                      $Date:   06 Jan 2000 16:10:54  $
**                      $Modtime:   06 Jan 2000 15:04:58  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/27/95  PITMANGS  SIR 395 - Change dates to dam ccmn43d.pc so it
**                      writes the dates of an alert properly
**  04/10/95  RAMIREAP  Before opening a new stage, the function checks if
**                      a stage of the same CD STAGE exists for the current
**                      case. If this stage is open, the function just
**                      closes the previous stage and exits without opening
**                      the new stage.
**  04/17/95  RAMIREAP  When creating a "shell" record in the LICENSING INV
**                      DTL table the function now handles programs CCL
**                      or RCL.
**  04/19/95  ISF/APR   Modified error handling.
**  07/10/95  RAMIREAP  Performed a comprehensive revision of code and
**                      functionality.
**  07/13/95  RAMIREAP  Deleted DT_TODO_DUE from the function's Output
**                      Message. Element is no longer needed since
**                      functionality in the Assigned Workload window
**                      changed and this was the only window using the
**                      element.
**  07/13/95  RAMIREAP  Added DT_LAST_UPDATE to DAM CCMND3D's Output
**                      record. This timestamp will be passed all the way
**                      back to the client. Assigned Workload uses this
**                      timestamp when performing updates to the
**                      STAGE_PERSON_LINK table.
**  07/16/95  RAMIREAP  Incorporated changes identified by Ian Fogarty
**                      during code review.
**  07/16/95  RAMIREAP  Eliminated several macros that were already defined
**                      in CAPS.h
**  07/17/95  RAMIREAP  Attached DAM CCMN45D to retrieve the
**                      ID_EVENT_PERSON for the EVENT record since DAM
**                      CCMN87D doesn't.  This DAM is only called when DAM
**                      CCMN87D is.
**  07/17/95  RAMIREAP  Modified calls to DAM's so when a date field needs
**                      to be passed as NULL, its values are -1 (NullDate).
**  07/17/95  RAMIREAP  Added ID_STAGE_PERSON_LINK as an input element to
**                      DAM CCMND3D. Changed logic when updating a record
**                      in DAM CCMND3D. The search is now performed on
**                      ID_STAGE_PERSON_LINK and nothing more. This forced
**                      DAM's CCMNG2D and CCMNB9D to retrieve ID_STAGE_
**                      PERSON_LINK. Added element to both DAM's Output
**                      Records and modified their PC files. Added logic
**                      to this Function in order to handle changes.
**  07/18/95  RAMIREAP  Fixed index to post-event/to-do's loop. I was
**                      using the wrong index variable.
**  07/19/95  RAMIREAP  Removed all logic handling "SPC" and "I&R". These
**                      type of stages WILL never invoke the Stage
**                      Progression Logic nor window.
**  07/19/95  RAMIREAP  Found an error in the Outcome Matrix logic. I was
**                      using "=" in the IFs statements instead of "=="
**  07/19/95  RAMIREAP  Found that page number was not being passed
**                      into DAM CCMN87D.
**  18Aug95  sladewmf   SIR 826: Added an 'if' statement to accept
**                      ulIdPerson.
**  31Aug95  sladewmf   SIR 1154: CloseOpenStage: added an if statement,
**                      and added four new functions: CallCCMNH0D, G7D,
**                      G8D, G9D.
**  09/28/95    KRD     SIR 1553 - When an INTake stage for Program AFC
**                      is progressed, a row should be written to the
**                      FACIL_ALLEG table for every row written to the
**                      ALLEGATION table.  This was not being done, so a
**                      new DAM CINV54D has been created and code to call
**                      that DAM added.
**  10/03/95    KRD     SIR 1594 - CD_STAGE_PERS_ROLE code values have been
**                      changed from "DB" and "DV" to "VC" and "VP".
**                      SIR 1595 - The TODO table needs to be cleaned up
**                      when a non-INTake stage is closed.  All
**                      non-completed, system-generated TODOs should be
**                      deleted.  A new DAM CCMNH1D has been created and
**                      code to call that DAM added.
**  10/07/95    KRD     SIR 1680 - Added an if-statement (similar to the
**                      one for SIR 826) to ensure that ToDos are written
**                      to the proper employee if a stage is Save&Assign'ed
**                      to a different primary worker.
**  10/12/95    KRD     SIR 1716 - Modified code so that the current date
**                      is saved in DT_TODO_COMPLETED for alerts sent to
**                      primary workers when an Intake stage is closed that
**                      contains principals involved in other Intakes.
**  10/19/95    KRD     SIR 1876 - For Program CPS, the days due for the
**                      SPECIAL_DATE was being calculated incorrectly.  It
**                      has been modified to be the 15th of the following
**                      month, not the 15th of 3 months hence.
**  10/24/95    aliam   SIR 1867- Took out the code where stage progression
**                      adds Facility investigation date begun.
**  11/14/95   DYARGR   Added logic for Subcare and Service Authorization
**                      for Release 2.1.  Main modifications: Flag added
**                      to determine if the calling window should close
**                      AND open a stage or just open a stage (Subcare),
**                      determine if the primary child in the stage to
**                      be opened is an existing primary child in another
**                      stage, call ToDo Common Function to send todo's and
**                      alerts to appropriate people for subcare. Service
**                      Auth: create a new case and situation, determine the
**                      passed in person's role, determine #1 on call worker
**                      to assign as primary worker initially, update the
**                      stage row for GUAardinship, update old stages GUA-
**                      ardianship event's status. LINES 2847 - 3044 SHOULD
**                      BE UNCOMMENTED for testing with Service Authorization.
**  12/14/95    aliam   SIR 1972 - dtIncomingCall copied to
**                      dtFacilInvstIntake
**  12/18/95   DYARGR   SIR 2318 - When creating a SUBcare stage from
**                      INVestigation or Family PReservation, the CdStageType
**                      for the new subcare stage should be REG always.
**  12/28/95    KRD     SIR 2355 - A change was made for Release 2.x to
**                      accept a value for dtDtStageStart as input.  However,
**                      the if-statements which checked for a value only
**                      checked against NULL_DATE.  If dtDtStageStart is not
**                      populated by the calling service, then the value will
**                      be NULL (0) since the input message is memset to
**                      NULL.  So, the if-statements have been modified to
**                      check for both cases (NULL and NULL_DATE).
**                      Another Release 2.x change failed to copy the roles
**                      and types for persons linked to stages other than
**                      AOC.  This was corrected by adding an else-statement.
**  01/09/96  MCRAEBS   Changed Service Plan record creation to include FSU
**                      and FRE stages. SIR 2490 BSM
**  01/10/96  BRUCKMK   SIR 2582: The Type was not being passed to DAM
**                      CCMND3D when updating and adding to the stage person
**                      link table.
**  01/10/96  BRUCKMK   SIR 2581: The selected person from the Person List
**                      during stage progression needs to be given the role
**                      of Primary Child for the next stage.
**  01/10/96  MCRAEBS   SIR 2521 - Added validation to only search for the
**                      IdSvcAuth if the Event type in the ccmn87[i] output
**                      is 'AUT'.  Also, all of the code associated with
**                      progressing SvcAuth was commented out.  Removed the
**                      comments to make this portion of code active. This
**                      code was never tested in Construction, String, or
**                      Function Test.    BSM
**  01/12/96  BRUCKMK   SIR 2585: When progressing from INTAKE directly to
**                      SUBCARE or Family Subcare, then the Stage Type should
**                      remain the same and shouldn't be set to "REG".
**  01/14/96    KRD     SIR 2345 - When an INTake stage for program AFC is
**                      progressed, the bIndIncmgOnGrnds and
**                      bIndIncmgFacilAbSupvd indicators set on the Intake
**                      Facility Detail window and saved on the
**                      INCOMING_FACIL should be copied to the dummy rows
**                      created for the FACIL_ALLEG table.  To do this, a
**                      call to DAM CINT09D was added to retrieve the
**                      indicators which are then passed to CINV54D.
**                      SIR 2452 - For some reason, the code to call CCMNH1D
**                      for SIR 1595 was commented out (possibly during the
**                      testing of another SIR).  This has been corrected.
**
**  01/16/96  DYARGR    Added a dam to check if the Guardianship was
**                      still open, if it is, then the stage type of SVC
**                      should be GUA, otherwise it should be REG.
**
**  01/16/96  MCRAEBS   SIR 2712 - Send in SvcAuth CdTask to CCMN87D if
**                      User Program is APS.  Need correct CdTask to
**                      progress SvcAuth Events.
**
**  01/17/96  ZIMMERNE  SIR #2673 - An if statement was added so that the
**                      todo event description is retrieved from the
**                      todo_info table for all todos except SUB001 - Apply
**                      for Foster Care Assistance.  This ensures that the
**                      correct todo short description will be retrieved and
**                      populated on the todo window.  Also, a COPYSZ was
**                      deleted that passed the Person Assigned into Todo
**                      Common Input.  This again allows the Person Assigned
**                      to be retrieved and ensures that the task is sent to
**                      the correct worker.
**
**  01/17/96 DYARGR     SIR #2733 - When opening AOC, added REQ_FUNC_CD_ADD
**                      to the dam inputs to create the new case and
**                      situtation.
**
**  01/17/96 DYARGR     SIR #2756 - IdStage used throughout the program was
**                      being overwritten when calling CINT41D.  This was
**                      removed.
**  01/19/96 DYARGR     SIR #1922 - Added 4 dams to handle marking the
**                      aged characteristic for any person in a stage
**                      that is progressing from Intake to Investigation,
**                      is a PRN and VC or VP, and does not have the
**                      aged characteristic checked already.
**
**  01/20/96 DYARGR     SIR #2822 - If the stage being opened is AOC, then
**                      the PC from the stage being progressed from must
**                      have his/her role changed to CL. This code was
**                      only being executed when we were closing a stage
**                      and not in 'OpenOnlyMode'.
**
**  01/20/96 DYARGR     SIR #2819 - When opening FRE from SUB, the name
**                      of the new FRE stage should be the case name, not
**                      the previous stage's name. Added a dam call to
**                      retrieve the case name.
**  01/23/96 DYARGR     SIR 2844 - Need to add the creation of the Todo's
**                      for the new AOC stage created when progressing
**                      from CPS to AOC.  This is hardcoded because we
**                      don't determine the new worker (who is APS and not
**                      CPS) until much lower in Stage Progression.
**
**  01/24/96 DYARGR     SIR 2921 - The check that was used to determine if
**                      there was an existing stage of the same type being
**                      opened would not work for opening an AOC stage.
**                      Logic was added only in the case of AOC to determine
**                      if there is an open AOC stage.
**  01/24/96 SOOLEYAG   SIR 2884/2894 - The reporter, person search, and
**                      In-Law indicators returned from ccmnb9d DAM were not
**                      being passed into the ccmnd3d DAM (which adds/updates
**                      the stage_person_link table).
**
**  01/29/96   MCRAEBS  SIR 2877 - We only want to create ONE event row if
**                                 an SA Detail record is found with a
**                                 term date greater than today's date.
**
**  01/29/96  SOOLEYAG  SIR 2698 - Corrected the problem where stage prog.
**                      code(automatically from INT to INV) was assigning
**                      the intake to the person who took the intake instead
**                      of the primary person assigned.
**
**  01/30/96   DYARGR   SIR 3050 - When progressing Service Auth events,
**                      we want to change the event status for pending
**                      Service Auth's from the previous stage to complete
**                      for the target stage to avoid one approval event
**                      for two Service Authorizations.
**
**  02/06/96   DYARGR  Release 2.2 Update for Admin Review. Added logic
**                     to only copy requestor over to new stage in stage
**                     person link; admin review does not go through same
**                     checks to allow opening of the stage; create an
**                     event row for Administrative Review and a shell
**                     record for that.
**
**  02/08/96 ODONNERJ  Release 2.2 Update for Admin Review.  Added logic
**                     to not return an ERROR if the stage has been closed
**                     if it is and ARI or and ARF
**
**  02/14/96   DYARGR  SIR 3173 - Populate all dates for Admin Review table
**                     as NULL_DATE and set CdAdminRvStatus to PROC, when
**                     creating the shell AdminReview record.
**                     (ODONNERJ - Set CdAdminRvStatus to In Process "010")
**
**  02/14/96  DYARGR   SIR 3104 & 3105 - Redevelopment of Service
**                     Authorization Progression.  We don't progress
**                     SvcAuth's to the new SUBcare stage being created by
**                     CVS Removal, only progress these SvcAuth's to the
**                     Family SUbcare stage. Only approved SvcAuth's (at time
**                     of CVS Removal) are progressed, all others are
**                     progressed to the FSU stage when the Investigation
**                     stage is concluded. Dam call for 3105, included in
**                     older versions of CloseOpenStage (clsc73d) is not
**                     needed here as this check is made in CloseStageCase
**                     when progressing SvcAuth's as the Investigation is
**                     concluded.
**  02/26/96  DYARGR   SIR 3375 - Add logic to handle PAL stages, including
**                     creating the StagePersonLink row, assigning the
**                     stage to the PAL coordinator.
**  03/04/96  DYARGR   SIR 3602 - When opening the AOC stage, the roles
**                     of everyone but the primary worker and the primary
**                     child should be changed to NO and designation to
**                     COLlarteral.
**
** 03/05/96  DYARGR    SIR 3609 - PAL ILS assessment cannot be created with
**                     the normal stage progression logic because we have
**                     not determined the PAL Coordinator to assign the stage
**                     to at that time. Moved the creation of this to after
**                     the determination and writing of the stage person
**                     link row for the PAL Coordinator. Removed the row
**                     from the stage progression table for this PAL ILS
**                     ToDo.
**
**  03/07/96  DYARGR   SIR 3612 - Added logic to progress Service Auth's
**                     from AOC to Service Delivery.
**
**  03/11/96  DYARGR   SIR 3773 - Added to logic determining when a AOC stage
**                     has already been opened for a Client. Now retrieves
**                     again from StagePerson link.
**
**  03/11/96  DYARGR   SIR 3776 - CdTodo was not being passed to ToDo common
**                     function when opening the PAL stage.
**
**  03/13/96  DYARGR   SIR 3771 - Major revamp to fix problems with Stage
**                     Progression for 2.2.
**                     1. If nmPersonFull is not passed into function, use
**                        the previous stage name as the new stage name for
**                        ADO, PAD.
**                     2. Added logic to allow for manually opening an
**                        Adoption Stage, and checking for an already open
**                        Adoptions stage.
**
**  03/19/96  DYARGR   SIR 4051 - When opening PAD stage with CRSR, don't
**                     follow normal processing logic.
**
**  03/21/96  DYARGR   SIR 4099 - Modified copying of persons to newly
**                     created PAL stage.
**
**  03/25/96  DYARGR   SIR 3738 - Added comment to code for SIR reference;
**                     modified values being passed to AdminReview functional
**                     row.
** 03/28/96   DYARGR   SIR 4356 - Stage type should not change when CRSR,
**                     except when opening the SUBcare stage via CVS Removal.
** 04/02/96   DYARGR   SIR 20117 - Modified if test for opening the AOC stage
**                     to look for the new client to be in either the AOC or
**                     SVC stage.
**
** 04/08/96   DYARGR   SIR 20078 - Modified logic for progressing Service
**                     Authorizations between stages. See Service
**                     Authorization Change Order for full details.
**
** 04/12/96   ODONNERJ SIR 20380: Add MaxDate to the DtStageClose for
**                     Admin Review Stages.
**
** 04/16/96   ODONNERJ SIR 20316: Case/Merge split R1R2 Impact. Move all
**                     persons not already assigned to the SVC Stage from the
**                     INV Stage to SVC stage except for persons with
**                     CdStageType of STF.
**
** 04/17/96   ODONNERJ SIR 20253: Stage progression has versioning problems.
**                     Greg and Robert have discussed and merged all fixes
**                     into this copy of code which will be checked into
**                     VHTEST and eventually promoted to QA to replace the
**                     branched version in QA. The current copy in VHTEST
**                     will be destroyed since it has the most branching
**                     problems.
**
** 04/18/96   sladewmf  SIR 20506: Set pCINT13DInputRec->dtDtSituationClosed
**                      to NULL_DATE because the Case Merge Batch
**                      program checks for NULL_DATE in the
**                      DT_SITUATION_CLOSED field on the SITUATION table,
**                      to determine if a Situation is opened or closed.
**
** 04/29/96  DYARGR    SIR 20316: Add ability to handle sql_not_found for
**                     clsc75d
**
** 04/30/96  ODONNERJ  SIR 20316: PURCELLA and ODONNERJ updated the callbacks
**                     to CLSC75D and CCMND3D.  The main problem was the
**                     IdStageRelated needed to be passed not the IdStage.
**
** 5/14/96   DYARGR    SIR 21169 - If we are opening a family stage from
**                     a SUB stage, we need to not copy the PC over as a
**                     PC to the new stage.
**
** 5/19/96  DYARGR     SIR 21252 - Added if test when writing events to
**                     not write the event when the FRE stage is being
**                     opened from the Placement window. Problem with
**                     Stage Progression table, but to fix the table breaks
**                     the Stage Progression window.
**
** 5/19/96  DYARGR     SIR 21288 - Don't progress SvcAuth's into Adoption
**
** 5/24/96  DYARGR     SIR 21405 - Added an if in CallCCMNB8D to change
**                     the CdStageRsnClosed passed in when going from
**                     ADO to PAD.
**
** 9/6/96   RIOSJA     SIR 10942 - "szCdSitCurrStatus" was never being
**                     populated in the SITUATION table, so the data element
**                     was removed from the database and the field was
**                     commented out in this file.
**
**  09/09/96    KRD    SIR 22250 - PROCESS_TUX_SQL_ERROR_NOFREE should only be called
**                     when there is an unexpected SQL return code from a
**                     DAM.  The error handling for CallCSES21D() has been
**                     corrected.
**
**  09/30/96 VANDERM   SIR 21770 - Users person ID was not being written to
**                     the event table for stage open and closure events.
**                     The input message to CCMN46D (event posting dam) was
**                     populated with the user's ID.
**
**  12/16/96 ODONNERJ  SIR# 21885 - If Status of GUA Event is NEW then skip
**
**  03/13/97 gonzalce  SIR 11437 - Added functionality pass a new message
**                     to the StageProgression window instead of a data
**                     access error.  The data access error was occurring
**                     when the PAL coordinator for the unit was being
**                     assigned a case the he/she was a COL/PRN in.
**
** 03/13/97  MATTESJM  SIR 13445 - Added functionality to pass a new message
**                     to the StageProgression window to prevent stage
**                     progression to a PAL stage if one already exists
**                     for the id_person of the PC passed in.  Created
**                     CSES94D to count the number of stages that the PC is
**                     currently in for the given cd_stage (ex. PAL).  If
**                     the count(*) returned is > 0, display a new message
**                     that the Child currently exists as a PC in a PAL
**                     stage.
**  07/17/97  klm SIR# 13463 - If progressing to AOC, the Stage Type
**      should always be REG.  So, added a COPYSZ to default
**      the stage type properly before the call to CINT12D.
**
**
** 07/17/97  PAULS     SIR 13720 -The Three Month Review Todo was being sent
**                     to the  wrong worker. It  was being sent to the person
**                     who created the Intake instead of the worker who was
**                     assigned the intake. Changed this to make the todo
**                     go to the right worker. The Three Month Review Todo
**                     is now Using The TodoCommon Function. Created a contact
**                     for the Three month review Todo type.
** 10/17/97 GRIERDH    SIR 13770 - User should only receive user message
**                     MSG_CANT_ASSIGN_WORKER if the user could not add
**                     a primary to the stage_person_link table.  If the
**                     stage_person_link error is for any other
**                     CD_STAGE_PERS_ROLE, ignore error and return success
**                     since person is already in the stage
** 12/04/97 SOHNJJ      SIR 14160 - EA Enhancements as designated by design.
** 07/30/99 DOUGLACS    SIR 15189 - EA Modifications
** 10/13/99 SOHNJJ      SIR 15189 - Corrected EA modification coding errors and
**                      cleaned up redundancies.  This EA modification was
**                      created under the new State and Federal guidelines of
**                      October 1, 1999.  A new DAM csec85d was added to determine
**                      if a closed EA record had a start date at least 12 months
**                      prior to the current date.  DAM caudc9d was modified
**                      to automatically calculate an end date that is 12 months
**                      minus 1 day from the start date.  The EA Deny date
**                      continues to be entered as '12/31/4712'.  This code is
**                      duplicated in ccmn03u.src to accomadate FPR progression.
**
** 01/06/00 KOMARAE     SIR 15346 added memset to initialize fields to correct
**                      memory leaks.  Also rearranged the memory allocation
**
** 03/19/01 WEBSTED     ADDED Include files that SHOULD be in the .pc file,
**          because having the include files in FND causes
**          some kind of irreversible loop. Put them in this file,
**          and all errors depart.
**
**  03/27/2003  KRD     IMPACT - Corrected error handling within CallCLSS60D()
**                      and added PROCESS_TUX_RC_ERROR_NOFREE macros
**                      where missing after 5 CallDAM functions.
**  04/09/2003  Srini   IMPACT - Added the case of SQL_NOT_FOUND to return
**                      MSG_NO_ROWS_RETURNED for the csec66d dam.
**
**  04/11/2003  Srini   IMPACT - Added the switch case statement after the CallCSEC66D
**                      to take care of the MSG_NO_ROWS_RETURNED and also added goto and
**                      END statements to take care of the intermediate exit.
**
**  04/30/03   Srini   SIR 17091: Added the error handling to take care of full
**                     table scans for ccmn87dQUERYdam.
**
**  05/14/2003  KRD     SIR 17344 - Added DAM CAUDE8D to properly create a
**                      Family Plan event in IMPACT.  Required changes to
**                      CallCSVC15D().
**
**  06/16/2003  KRD     SIR 18135 - DAM CAUDE8D is also needed for Child's
**                      Service Plan events, too, and, as it turns out,
**                      CSVC15D is no longer needed, so CallSVC15D() has
**                      been replaced with CallCAUDE8D().
**
**  11/12/03 RIOSJA     SIR 22411 - Only alert ToDo's should be created for
**                      family stages. The ToDo information can be found in
**                      the STAGE_PROG table.
**  10/22/04 gerryc     SIR 15052 - When creating FSU and SUB stages, all
**                      roles should be set to NO, except for the primary child.
**  09/07/05 douglacs   SIR 23781 - AOC stages no longer go to an AOC router,
**                      they should now stay on the workload of the person
**                      creating the AOC stage.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/**************************************************************************
** 3 MAR 2001 - WEBSTED
** Added the following 6 include files so that they do not have to be included
** into ccmn03u.pc. Including them in the .pc file (in foundation) causes a
** very confusing FND Error.
**************************************************************************/


/***************************************************************************
** Function Macro Definitions
****************************************************************************/
public class Ccmn03u {
    /*
    ** SIR 2327 - macro needed for CallProgress()
    */
    public static final int INITIAL_PAGE = 1;
    
    public static final String NULL_STRING = "";
    
    
    
    public static final String INTAKE = "INT";
    public static final String INVESTIGATION = "INV";
    public static final String FPR_PROGRAM = "FPR";
    public static final String FSU_PROGRAM = "FSU";
    public static final String FRE_PROGRAM = "FRE";
    public static final String SUBCARE = "SUB";
    
    public static final String ADOPTION = "ADO";
    public static final String POST_ADOPT = "PAD";
    public static final String PREP_ADULT = "PAL";
    public static final String CHILD_SER_PLAN = "CSP";
    
    /*
    ** Update to Stage Progression for Release 2.1 for Service Auth
    ** GRD
    */
    public static final String AGE_OUT = "AOC";
    public static final String GUARDIANSHIP_TASK = "2140";
    public static final String GUARDIANSHIP_TYPE = "GUA";
    public static final String SERVICE_AUTH_TYPE = "AUT";
    public static final String STATUS_COMPLETE = "COMP";
    
    public static final String UPDATE_GUARDIANSHIP_CD_TASK = "6120";
    public static final String UPDATE_SERVICE_AUTH_TASK = "6075";
    public static final String SUBCARE_SVC_AUTH_TASK = "3020";
    public static final String FSU_SVC_AUTH_TASK = "4190";
    public static final String APS_SVC_AUTH_TASK = "2100";
    public static final String FAMILY_PRES_TASK = "7080";
    
    public static final String ADULT_PROTECTIVE_SERVICES = "APS";
    
    
    public static final String PERSON_ROLE_CLIENT = "CL";
    /*
    ** SIR 1594 - definitions of PERSON_ROLE_BOTH and PERSON_ROLE_VICTIM changed
    ** from "DB" to "VC" and "DV" to "VP", respectively
    */
    public static final String PERSON_ROLE_VICTIM = "VP";
    public static final String PERSON_ROLE_BOTH = "VC";
    /*
    ** Update to Stage Progression for Release 2.1
    ** with Subcare, added the following 2 #define's GRD
    */
    public static final String PERSON_ROLE_PRIM_CHILD = "PC";
    public static final String PERSON_ROLE_PRINCIPAL = "PRN";
    /*
    ** Update to Stage Progression for Release 2.1
    ** for Service Auth with following 3 defines GRD
    */
    public static final String PERSON_ROLE_PERP = "AP";
    public static final String PERSON_ROLE_NONE = "NO";
    public static final String PERSON_COLLATERAL = "COL";
    
    
    
    public static final String STAFF = "STF";
    
    public static final char STAGE_PROG_OLD_STAGE = 'O';
    public static final char STAGE_PROG_NEW_STAGE = 'N';
    
    public static final String EVENT_STATUS_PROCESS = "PROC";
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String INV_OUTCOME_MATRIX_TASK = "2090";
    public static final String SVC_OUTCOME_MATRIX_TASK = "6070";
    public static final String EVENT_TYPE_PLN = "PLN";
    public static final String CONCLUSION_EVENT = "CCL";
    
    public static final String EMPTY_STR = "";
    public static final char EMP_NEW = '1';
    public static final char EMP_OLD = '0';
    public static final String CONTACT = "CON";
    /* SIR 1154: changed next define: it was CSPV, which is no longer used */
    public static final String C3MT = "C3MT";
    public static final String BMTH = "BMTH";
    public static final int SPECIAL_DATE = 99;
    /*************SIR# 1829: Add the following #define***********************/
    public static final String SERVICE_DELIVERY = "SVC";
    public static final String APS_INT_TO_INV_TASK = "2030";
    public static final String APS_INV_TO_SVC_TASK = "6020";
    
    /* Stage Prog Update Release 2.1 GRD */
    public static final String SITUATION_OPEN = "OPN";
    public static final int SITUATION_OCCUR = 1;
    
    /* SIR 2318: define for CdStageType */
    public static final String STAGE_TYPE_REG = "REG";
    
    
    /* SIR #2673: Holds the todo code for todo descriptions */
    public static final String TODO_CODE = "SUB001";
    
    /* SIR 2757 : Used for time comparisions */
    public static final int FIVE_PM = '5';
    public static final char MIDNIGHT = '2';
    public static final String PM = "PM";
    public static final String AM = "AM";
    /* SIR 2785 */
    public static final String CONTRACTED = "CON";
    /* SIR 1922 */
    public static final String ADULT_FACILITY = "AFC";
    public static final int AGED_PERSON_AGE = 65;
    public static final int SIXTY_FIVE_IN_DAYS = 365;
    public static final int MINUTES_IN_DAYS = 1440;
    public static final String AGED_CHARACTERISTIC = "04";
    public static final String APS_CHARACTERISTIC = "CAP";
    public static final char CHARACT_NA_NOT_CHECK = '1';
    public static final char WINDOW_MODE_PERSON = 'P';
    
    /* SIR 2844 */
    public static final String AOC_CLIENT_ASSES_ALERT = "AOC001";
    public static final String AOC_QUARTERLY_REVIEW = "AOC002";
    public static final int TWENTIETH_DAY = 20;
    public static final String APS_CONTACT_TASK = "5010";
    public static final String CONTRACT = "CON";
    public static final String QUART_EVENT_DESC = "3 Month Review Due by End of the Month";
    
    /* SIR 3050 */
    public static final String EVENT_STATUS_PEND = "PEND";
    
    /* Release 2.2 Update */
    public static final String ADMIN_REVIEW = "ARI";
    public static final String FAD_REVIEW = "ARF";
    
    public static final String STATUS_APPROVED = "APRV";
    
    /* SIR 3173 */
    public static final String IN_PROCESS = "010";
    
    /* SIR 3609 */
    public static final String PAL_ILS_TODO = "CFC009";
    public static final String PAL_ILS_TASK = "3530";
    public static final String PAL_ILS_EVENT_TYPE = "ILS";
    public static final String PAL_ILS_DESCRIPTION = "PAL ILS Assessment Information";
    
    /* SIR 3665 */
    public static final String AOC_OUTCOME_MATRIX_TASK = "5030";
    public static final String AOC_SVC_AUTH_TASK = "5040";
    
    /* SIR 3771 */
    public static final String ADOPTION_SUBSIDY_TASK = "8610";
    public static final String PAD_SUBSIDY_TASK = "9100";
    public static final String SUBSIDY_TYPE = "ADP";
    public static final String CHILD_PROTECTIVE_SERVICES = "CPS";
    public static final String PAD_EVENT_DESCRIPTION = "Post Adoption Stage Closed";
    
    /* SIR 4356 */
    public static final String CASE_REL_SPEC_REQ = "C-";
    
    /* SIR 20078 */
    public static final String FRE_SVC_AUTH_TASK = "5640";
    public static final String FPR_SVC_AUTH_TASK = "7100";
    public static final String ADO_SVC_AUTH_TASK = "8530";
    
    /* Sir 13720 */
    public static final String THREE_MONTH_REVIEW = "2030";
    
    /*
    ** SIR 11437 - check for rc = 16502 and add new message
    */
    public static final int ASSIGN_ERROR = - 1;
    
    /*
    ** SIR 13445 - ReqFuncCode = C,used in CSES94D
    */
    public static final char CLOSE = 'C';
    
    /*
    ** SIR 14160
    */
    public static final int NO_END_DATE = - 1;
    public static final int ORACLE_END_MONTH = 12;
    public static final int ORACLE_END_DAY = 31;
    public static final int ORACLE_END_YEAR = 4712;
    public static final char EA_ADD = '1';
    public static final char EA_UPDATE = '2';
    
    /*
    ** SIR 18135
    */
    public static final char SPACE = ' ';
    static int CloseOpenStage(CCMN03UI pInputMsg102, CCMN03UO pOutputMsg98, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        boolean goto_END = false;
        int rc = 0;/* Return code */
        int i85 = 0;
        int m = 0;/* Used as a counter in FOR loop */
        int n = 0;/* Used as a counter in FOR loop */
        Tm time;
        /* SIR 1154: commented out definitions of sYearFlag, no longer needed */
        /* short           sYearFlag            = 0;                          */
        int ulIdConclusionEvent = 0;
        int ulIdServicePlanEvent = 0;
        int usRowCtr = 0;
        int bMoreRows = 1;
        String szTempString = new String();
        FndInt3date DtToday = null;
        FndInt3date NullDate = null;
        /*
        ** Stage Progression Update
        ** Release 2.1 GRD
        */
        int bGuardInProc = 0;
        int lRC5 = 0;
        FndInt3date dtDtIncomingCall1 = null;
        String tmTmIncmgCall1 = new String();
        
        /*
        ** SIR 1922
        ** Added to hold calculated age
        */
        int lAPSCalculatedAge = 0;
        boolean bIndAgedChecked = false;
        int lDays = 0;
        int lAgeDiff = 0;
        
        /*
        ** SIR 2757
        */
        FndInt3date dtDtOnCall = null;
        String tmTmOnCall = new String();
        FndInt3date dtDtOnCallAdd = null;
        int bRCSearchFound = 0;
        
        /*
        ** SIR 2844
        */
        boolean bIndNoAOCTodo = false;
        
        /*
        ** SIR 3104
        */
        int ulFSUIdStage = 0;
        
        /*
        ** SIR 3171
        */
        int bIndAutoAdopt = 0;
        boolean bAdoptNoSvc = false;
        int bClosePAD = 0;
        
        /*
        ** SIR 20380
        */
        FndInt3date MaxDate = null;
        
        /*
        ** SIR 14160
        */
        
        Pchar bEA_Eligible = new Pchar();
        bEA_Eligible.value = 0;
        Pchar bEA_Found = new Pchar();
        bEA_Found.value = 0;
        FndInt3date dtTempDate = null;
        
        /*
        ** SIR 15189
        */
        char bEA_12Months = '\u0000';
        FndInt3date dtSysdate = null;
        
        
        /*
        ** Declare input and output structure for DAM's
        */
        CCMN43DI CCMN43DI = null;
        CCMN45DI CCMN45DI = null;
        CCMN45DO CCMN45DO = null;
        CCMN46DI CCMN46DI = null;
        CCMN46DO CCMN46DO = null;
        CCMNB8DO CCMNB8DO = null;
        CCMNB9DO CCMNB9DO = null;
        CCMNC1DI CCMNC1DI = null;
        CCMND3DI CCMND3DI = null;
        CCMND3DO CCMND3DO = null;
        CCMNE4DO CCMNE4DO = null;
        CCMNE5DI CCMNE5DI = null;
        CCMNE5DO CCMNE5DO = null;
        CCMNF6DI CCMNF6DI = null;
        CCMNF6DO CCMNF6DO = null;
        CCMNG2DO CCMNG2DO = null;
        CCMN87DI CCMN87DI = null;
        CCMN87DO CCMN87DO = null;
        CINT12DI CINT12DI = null;
        CINT19DO CINT19DO = null;
        CINT21DO CINT21DO = null;
        CINV07DI CINV07DI = null;
        /*
        ** SIR 1553 - Declare output record for CINV07D
        */
        CINV07DO CINV07DO = null;
        CINV12DI CINV12DI = null;
        CINV24DI CINV24DI = null;
        CINV53DI CINV53DI = null;
        CINV54DI CINV54DI = null;
        /*
        ** SIR 18135 - replaced CSVC15D with CAUDE8D
        */
        CAUDE8DI CAUDE8DI = null;
        CSYS07DI CSYS07DI = null;
        
        /* SIR 1154: Declare input and output structure for DAM's  */
        CCMNH0DO CCMNH0DO = null;
        CCMNG7DI CCMNG7DI = null;
        CCMNG8DI CCMNG8DI = null;
        CCMNG9DI CCMNG9DI = null;
        
        /*
        ** SIR 1553 - Declare input structure for CINVB4D
        */
        CINVB4DI CINVB4DI = null;
        /*
        ** SIR 1595 - Declare input structure for CCMNH1D
        */
        CCMNH1DI CCMNH1DI = null;
        /*
        ** SIR 2345 - Declare output structure for CINT09D
        */
        CINT09DO CINT09DO = null;
        
        /*
        ** Release 2.1 Stage Progression update GRD
        */
        CSES21DI CSES21DI = null;
        CSUB40UI pTodoCommonInput = null;
        CSUB40UO pTodoCommonOutput = null;
        
        /*
        ** SIR# 13445 - Release 2.1 Stage Progression update JMM
        */
        CSES94DI CSES94DI = null;
        
        /*
        ** Release 2.1 Stage Progression Service Auth GRD
        */
        CCMNB2DI CCMNB2DI = null;
        CCMNB2DO CCMNB2DO = null;
        CINT13DI CINT13DI = null;
        CINT13DO CINT13DO = null;
        CINT41DI CINT41DI = null;
        CINT41DO CINT41DO = null;
        CSES23DI CSES23DI = null;
        CSES23DO CSES23DO = null;
        CSES24DI CSES24DI = null;
        CSES24DO CSES24DO = null;
        CLSS24DI CLSS24DI = null;
        CLSS24DO CLSS24DO = null;
        CAUD34DI CAUD34DI = null;
        CAUD34DO CAUD34DO = null;
        CCMND2DI CCMND2DI = null;
        CCMND2DO CCMND2DO = null;
        CCMN68DI CCMN68DI = null;
        CCMN68DO CCMN68DO = null;
        CCMN79DI CCMN79DI = null;
        CCMN79DO CCMN79DO = null;
        CSES70DI CSES70DI = null;
        CSES70DO CSES70DO = null;
        
        /*
        ** SIR 2647
        */
        CSEC09DI CSEC09DI = null;
        CSEC09DO CSEC09DO = null;
        
        /*
        ** SIR 1922
        */
        CCMN44DI CCMN44DI = null;
        CCMN44DO CCMN44DO = null;
        CLSS60DI CLSS60DI = null;
        CLSS60DO CLSS60DO = null;
        CINV48DI CINV48DI = null;
        CINV48DO CINV48DO = null;
        CINV41DI CINV41DI = null;
        CINV41DO CINV41DO = null;
        
        /*
        ** SIR 2819
        */
        CCMND9DI CCMND9DI = null;
        CCMND9DO CCMND9DO = null;
        
        /*
        ** SIR 2921
        */
        CLSC45DI CLSC45DI = null;
        CLSC45DO CLSC45DO = null;
        
        /*
        ** Release 2.2 Update
        */
        CAUDA3DI CAUDA3DI = null;
        CAUDA3DO CAUDA3DO = null;
        
        /*
        ** SIR 3375
        */
        CSEC66DI CSEC66DI = null;
        CSEC66DO CSEC66DO = null;
        
        /*
        ** SIR 3773
        */
        CSEC29DI CSEC29DI = null;
        CSEC29DO CSEC29DO = null;
        
        /*
        ** SIR 3771
        */
        CSES64DI CSES64DI = null;
        CSES64DO CSES64DO = null;
        
        CAUDB2DI CAUDB2DI = null;
        CAUDB2DO CAUDB2DO = null;
        
        CCMN02UI pCCMN02UInputRec = null;
        CCMN02UO pCCMN02UOutputRec = null;
        
        CLSS63DI CLSS63DI = null;
        CLSS63DO CLSS63DO = null;
        
        /*
        ** SIR 20078
        */
        CLSC73DI CLSC73DI = null;
        CLSC73DO CLSC73DO = null;
        
        /* SIR 20316 - Add to SVC stage_person_link */
        CLSC75DI CLSC75DI = null;
        CLSC75DO CLSC75DO = null;
        
        /* SIR 14160 - Declare input output structure for DAM's */
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
        
        /* SIR 15189 - Declare input output structure for DAM's */
        CSEC85DI CSEC85DI = null;
        CSEC85DO CSEC85DO = null;
        pServiceStatus.severity = FND_SEVERITY_OK;
        pServiceStatus.explan_code = SUCCESS;
        
        /*
        ** Initialize NullDate struct
        */
        NullDate.day = - 1;
        NullDate.month = - 1;
        NullDate.year = - 1;
        
        /*
        ** SIR 20380 : Initialize MaxDate
        */
        MaxDate.day = 31;
        MaxDate.month = 12;
        MaxDate.year = 4712;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        /*
        ** Start performance timer for service. All performance functions always
        ** return success so there is no need to check status.
        */
        rc = ARC_UTLGetDateAndTime(DtToday, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Retrieve narrative information if previous DAM retrieved an
        ** ID_EVENT
        */
        if (INDICATOR_YES != pInputMsg102.getCSysIndSStgOpenOnly()) {
            pInputMsg102.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pInputMsg102.getArchInputStruct().setUlPageSizeNbr(CCMNB8DO.get_CCMNB8DO__ROWCCMNB8DO_SIZE());
            pInputMsg102.getArchInputStruct().setCReqFuncCd(STAGE_PROG_OLD_STAGE);
            rc = Ccmn02u.CallCCMNB8D(pInputMsg102, CCMNB8DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        rc = Ccmn02u.CallCINT21D(pInputMsg102, CINT21DO, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        //SIR 17596 - IMPACT: Added code to make Service Transaction aware
        //  Following deviates from the general procedure as this service is called by another service and
        //  it can also be called directly.
        //  TUX_CHECK_APPL_STATUS
        if (DateHelper.NULL_DATE != CINT21DO.getDtDtStageClose().year && (0 != pInputMsg102.getSzCdStageOpen().compareTo(ADMIN_REVIEW) && 0 != pInputMsg102.getSzCdStageOpen().compareTo(FAD_REVIEW))) {
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Messages.MSG_CMN_STAGE_CLOSED;
            
            // Get today's date
            rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
            return rc;
        }
        //Commit only if we began the transaction in this service
        if (INDICATOR_YES != pInputMsg102.getCSysIndSStgOpenOnly()) {
            pInputMsg102.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = Ccmn02u.CallCCMND4D(pInputMsg102, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
            CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            CCMN46DI.setUlIdStage(pInputMsg102.getUlIdStage());
            CCMN46DI.setUlIdPerson(pInputMsg102.getUlIdPerson());
            CCMN46DI.setDtDtEventOccurred(DtToday);
            
            //  Only use the following fields from
            // Stage Progression record where CD_STAGE_PROG_OPEN is equal
            // to the stage selected for opening
            for (i85 = 0;i85 < CCMNB8DO.getArchOutputStruct().getUlRowQty();i85++) {
                if (0 == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i85).getSzCdStageProgOpen().compareTo(pInputMsg102.getSzCdStageOpen())) {
                    CCMN46DI.setSzTxtEventDescr(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i85).getSzTxtStageProgEvntDesc());
                    CCMN46DI.setSzCdEventStatus(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i85).getSzCdStageProgStatus());
                    CCMN46DI.setSzCdEventType(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i85).getSzCdStageProgEventType());
                    break;
                }
            }
            rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            rc = Ccmn02u.CallCCMNG2D(pInputMsg102, CCMNG2DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
            CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            CCMND3DI.setSzCdStagePersRelInt(CCMNG2DO.getSzCdStagePersRelInt());
            CCMND3DI.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_CLOSED);
            CCMND3DI.setSzCdStagePersSearchInd(CCMNG2DO.getSzCdStagePersSearchInd());
            CCMND3DI.setSzCdStagePersType(CCMNG2DO.getSzCdStagePersType());
            CCMND3DI.setSzTxtStagePersNotes(CCMNG2DO.getSzTxtStagePersNotes());
            CCMND3DI.setUlIdPerson(CCMNG2DO.getUlIdPerson());
            CCMND3DI.setUlIdStagePerson(CCMNG2DO.getUlIdStagePerson());
            CCMND3DI.setBIndStagePersInLaw(CCMNG2DO.getBIndStagePersInLaw());
            CCMND3DI.setBIndStagePersReporter(CCMNG2DO.getBIndStagePersReporter());
            CCMND3DI.setBIndStagePersEmpNew(EMP_OLD);
            CCMND3DI.setUlIdStage(pInputMsg102.getUlIdStage());
            CCMND3DI.setDtDtStagePersLink(CCMNG2DO.getDtDtStagePersLink());
            
            //  function prototypes 
            CCMND3DI.setTsLastUpdate(CCMNG2DO.getTsLastUpdate());
            rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
            CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            CCMND3DI.setUlIdStage(pInputMsg102.getUlIdStage());
            rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            if (0 != pInputMsg102.getSzCdStage().compareTo(INTAKE)) {
                CCMNH1DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                CCMNH1DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                CCMNH1DI.setUlIdStage(pInputMsg102.getUlIdStage());
                rc = CallCCMNH1D(CCMNH1DI, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
        }
        
        if ((0 == pInputMsg102.getSzCdStageOpen().compareTo(FPR_PROGRAM)) && (INDICATOR_YES != pInputMsg102.getCSysIndSStgOpenOnly()) && (0 == pInputMsg102.getSzCdStage().compareTo(INVESTIGATION))) {
            rc = Ccmn35s.CallCSECA2D(pInputMsg102, CSECA2DO, bEA_Eligible, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            if (bEA_Eligible.value != 0) {
                rc = ARC_UTLGetDateAndTime(dtSysdate, 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                
                //  Call DAM
                
                rc = Ccmn35s.CallCLSC18D(pInputMsg102, CLSC18DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                
                for (i85 = 0;i85 < CLSC18DO.getArchOutputStruct().getUlRowQty();i85++) {
                    CSECA1DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CSECA1DI.setUlIdPersEligPerson(CLSC18DO.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i85).getUlIdPerson());
                    bEA_Found.value = 0;
                    
                    rc = Ccmn35s.CallCSECA1D(CSECA1DI, CSECA1DO, bEA_Found, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    if (bEA_Found.value != 0) {
                        
                        if (((CSECA1DO.getDtDtPersEligEnd().year > dtSysdate.year) || ((CSECA1DO.getDtDtPersEligEnd().year == dtSysdate.year) && (CSECA1DO.getDtDtPersEligEnd().month >= dtSysdate.month)) || ((CSECA1DO.getDtDtPersEligEnd().year == dtSysdate.year) && (CSECA1DO.getDtDtPersEligEnd().month == dtSysdate.month) && (CSECA1DO.getDtDtPersEligEnd().day >= dtSysdate.day))) && (CSECA1DO.getDtDtPersEligEaDeny().year == NO_END_DATE)) {
                            CAUDC9DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CAUDC9DI.getArchInputStruct().setCReqFuncCd(EA_UPDATE);
                            
                            CAUDC9DI.setUlIdPersElig(CSECA1DO.getUlIdPersElig());
                            
                            if ((0 == CSECA1DO.getCdPersEligPrgStart().compareTo("S")) && (0 == CSECA1DO.getCdPersEligPrgOpen().compareTo("S"))) {
                                CAUDC9DI.setCdPersEligPrgOpen("B");
                            }
                            else {
                                CAUDC9DI.setCdPersEligPrgOpen("C");
                            }
                            rc = Ccmn02u.CallCAUDC9D(CAUDC9DI, CAUDC9DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                        
                        
                        else {
                            CSEC85DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CSEC85DI.setDtDtPersEligStart(CSECA1DO.getDtDtPersEligStart());
                            
                            bEA_12Months = 0;
                            rc = Ccmn35s.CallCSEC85D(CSEC85DI, CSEC85DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            //## END TUX/XML: Turn the XML buffer into an input message struct 
                            
                            
                            
                            if ((CSEC85DO.getDtDtPersEligEnd().year < dtSysdate.year) || ((CSEC85DO.getDtDtPersEligEnd().year == dtSysdate.year) && (CSEC85DO.getDtDtPersEligEnd().month <= dtSysdate.month)) || ((CSEC85DO.getDtDtPersEligEnd().year == dtSysdate.year) && (CSEC85DO.getDtDtPersEligEnd().month == dtSysdate.month) && (CSEC85DO.getDtDtPersEligEnd().day <= dtSysdate.day))) {
                                bEA_12Months = 1;
                            }
                        }
                    }
                    {
                        if (!(bEA_Found.value != 0) || bEA_12Months != 0) {
                            CSECA3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CSECA3DI.setUlIdStage(pInputMsg102.getUlIdStage());
                            rc = Ccmn35s.CallCSECA3D(CSECA3DI, CSECA3DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CAUDC9DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CAUDC9DI.setUlIdPersEligPerson(CSECA1DI.getUlIdPersEligPerson());
                            CAUDC9DI.getArchInputStruct().setCReqFuncCd(EA_ADD);
                            CAUDC9DI.setDtDtPersEligStart(CSECA3DO.getDtDtSvcAuthDtlBegin());
                            rc = Ccmn02u.CallCAUDC9D(CAUDC9DI, CAUDC9DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                    }
                }
            }
        }
        if ((0 != SUBCARE.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != ADOPTION.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != POST_ADOPT.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != FAD_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen()))) {
            
            //  If Add is passed as the request code, set the date
            // created to the start date, and the generation 'type' to
            // 'U'.  These fields are only used in the ADD case.
            if (0 != CINT21DO.getUlIdCase()) {
                if (0 != AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                    CCMNF6DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CCMNF6DI.setUlIdCase(CINT21DO.getUlIdCase());
                    rc = Ccmn02u.CallCCMNF6D(CCMNF6DI, CCMNF6DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (i85 = 0;i85 < CCMNF6DO.getArchOutputStruct().getUlRowQty();i85++) {
                        if (0 == CCMNF6DO.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i85).getSzCdStage().compareTo(pInputMsg102.getSzCdStageOpen())) {
                            
                            //  Analyze error code
                            if ((0 == INVESTIGATION.compareTo(pInputMsg102.getSzCdStage())) && (0 == SERVICE_DELIVERY.compareTo(pInputMsg102.getSzCdStageOpen()))) {
                                CLSC75DI.setUlIdStage(pInputMsg102.getUlIdStage());
                                CLSC75DI.setUlIdStageRelated(CCMNF6DO.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i85).getUlIdStage());
                                rc = CallCLSC75D(CLSC75DI, CLSC75DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                
                                for (i85 = 0;i85 < CLSC75DO.getArchOutputStruct().getUlRowQty();++i85) {
                                    
                                    //## BEGIN TUX/XML: Declare XML variables
                                    CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                    CCMND3DI.setUlIdStage(CCMNF6DO.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i85).getUlIdStage());
                                    CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                    CCMND3DI.setSzCdStagePersRole(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersRole());
                                    CCMND3DI.setSzCdStagePersType(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersType());
                                    CCMND3DI.setSzCdStagePersSearchInd(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersSearchInd());
                                    
                                    CCMND3DI.setSzTxtStagePersNotes(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzTxtStagePersNotes());
                                    CCMND3DI.setBIndStagePersInLaw(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getBIndStagePersInLaw());
                                    CCMND3DI.setDtDtStagePersLink(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getDtDtStagePersLink());
                                    //##           return (rc);
                                    CCMND3DI.setSzCdStagePersRelInt(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersRelInt());
                                    CCMND3DI.setUlIdStage(CLSC75DI.getUlIdStageRelated());
                                    CCMND3DI.setBIndStagePersReporter(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getBIndStagePersReporter());
                                    CCMND3DI.setBIndStagePersEmpNew(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getBIndStagePersEmpNew());
                                    //##           return (rc);
                                    CCMND3DI.setUlIdPerson(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getUlIdPerson());
                                    CCMND3DI.setUlIdStagePerson(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getUlIdStagePerson());
                                    rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                }
                            }
                            return SUCCESS;
                        }
                    }
                }
                //  SIR 2921
                // No check was being done to ensure that there was
                // not an open AOC stage for this person already
                // existing.  All the logic in this else  was
                // added to test for this before continuing with
                // progression.  If an open AOC stage is found for
                // this person, we will return FND_SUCCESS as is done
                // above for finding an existing stage of the same
                // type being opened.
                else {
                    pInputMsg102.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                    pInputMsg102.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO.get_CCMNB9DO__ROWCCMNB9DO_SIZE());
                    rc = Ccmn02u.CallCCMNB9D(pInputMsg102, CCMNB9DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (i85 = 0;i85 < CCMNB9DO.getArchOutputStruct().getUlRowQty();++i85) {
                        
                        if (0 == PERSON_ROLE_PRIM_CHILD.compareTo(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole())) {
                            CLSC45DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                            rc = CallCLSC45D(CLSC45DI, CLSC45DO, pServiceStatus);
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            
                            //  Loop through all the rows returned by this
                            // dam looking for an AOC stage. If the date
                            // closed is null or max date, then return
                            // success but stop stage progression
                            //  SIR 20117
                            // Modified if statement to look for either the AOC or
                            // Service Delivery stage
                            
                            for (m = 0;m < CLSC45DO.getArchOutputStruct().getUlRowQty();m++) {
                                
                                if ((0 == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getSzCdStage().compareTo(AGE_OUT)) || (0 == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getSzCdStage().compareTo(SERVICE_DELIVERY))) {
                                    
                                    if (((NullDate.day == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().day) && (NullDate.month == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().month) && (NullDate.year == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().year)) || ((DateHelper.ARC_MAX_DAY == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().day) && (DateHelper.ARC_MAX_MONTH == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().month) && (DateHelper.ARC_MAX_YEAR == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().year))) {
                                        CSEC29DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                                        CSEC29DI.setUlIdCase(CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getUlIdCase());
                                        CSEC29DI.setSzCdStagePersRole(PERSON_ROLE_CLIENT);
                                        CSEC29DI.setSzCdStage(CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getSzCdStage());
                                        
                                        //  Populate Input Structure for DAM
                                        rc = Ccmn02u.CallCSEC29D(CSEC29DI, CSEC29DO, pServiceStatus);
                                        
                                        if (CSEC29DO.getUlIdPerson() > 0) {
                                            return SUCCESS;
                                            
                                        }
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    }
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        
        
        
        else if ((0 != ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != FAD_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen()))) {
            
            if (0 == SUBCARE.compareTo(pInputMsg102.getSzCdStageOpen())) {
                
                //  Call DAM
                rc = CallCSES21D(pInputMsg102, pOutputMsg98, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
            else if (0 < pInputMsg102.getUlScrIdPrimChild()) {
                
                if (0 == PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                    
                    rc = CallCSES94D(pInputMsg102, pOutputMsg98, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                else {
                    CLSC45DI.setUlIdPerson(pInputMsg102.getUlScrIdPrimChild());
                    rc = CallCLSC45D(CLSC45DI, CLSC45DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    //  Loop through all the rows returned by this
                    // dam looking for an AOC stage. If the date
                    // closed is null or max date, then return
                    // success but stop stage progression
                    for (m = 0;m < CLSC45DO.getArchOutputStruct().getUlRowQty();m++) {
                        
                        if (0 == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getSzCdStage().compareTo(pInputMsg102.getSzCdStageOpen())) {
                            
                            if (((NullDate.day == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().day) && (NullDate.month == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().month) && (NullDate.year == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().year)) || ((DateHelper.ARC_MAX_DAY == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().day) && (DateHelper.ARC_MAX_MONTH == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().month) && (DateHelper.ARC_MAX_YEAR == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().year))) {
                                
                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                CSEC29DI.setUlIdPerson(pInputMsg102.getUlScrIdPrimChild());
                                CSEC29DI.setUlIdCase(CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getUlIdCase());
                                CSEC29DI.setSzCdStagePersRole(PERSON_ROLE_PRIM_CHILD);
                                CSEC29DI.setSzCdStage(pInputMsg102.getSzCdStageOpen());
                                rc = Ccmn02u.CallCSEC29D(CSEC29DI, CSEC29DO, pServiceStatus);
                                
                                if (CSEC29DO.getUlIdPerson() > 0) {
                                    return SUCCESS;
                                }
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            }
                        }
                    }
                }
            }
            else {
                pInputMsg102.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pInputMsg102.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO.get_CCMNB9DO__ROWCCMNB9DO_SIZE());
                rc = Ccmn02u.CallCCMNB9D(pInputMsg102, CCMNB9DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                
                for (i85 = 0;i85 < CCMNB9DO.getArchOutputStruct().getUlRowQty();++i85) {
                    
                    if (0 == PERSON_ROLE_PRIM_CHILD.compareTo(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole())) {
                        CLSC45DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                        if (0 == PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                            pInputMsg102.setUlScrIdPrimChild(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                            
                            //  Call DAM
                            rc = CallCSES94D(pInputMsg102, pOutputMsg98, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                        else {
                            rc = CallCLSC45D(CLSC45DI, CLSC45DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            
                            //  Loop through all the rows returned by this
                            // dam looking for an AOC stage. If the date
                            // closed is null or max date, then return
                            // success but stop stage progression
                            for (m = 0;m < CLSC45DO.getArchOutputStruct().getUlRowQty();m++) {
                                
                                //  Initialize DAM input and output areas
                                
                                if (0 == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getSzCdStage().compareTo(pInputMsg102.getSzCdStageOpen())) {
                                    
                                    
                                    if (((NullDate.day == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().day) && (NullDate.month == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().month) && (NullDate.year == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().year)) || ((DateHelper.ARC_MAX_DAY == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().day) && (DateHelper.ARC_MAX_MONTH == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().month) && (DateHelper.ARC_MAX_YEAR == CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getDtDtStageClose().year))) {
                                        CSEC29DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                                        CSEC29DI.setUlIdCase(CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getUlIdCase());
                                        CSEC29DI.setSzCdStagePersRole(PERSON_ROLE_PRIM_CHILD);
                                        CSEC29DI.setSzCdStage(pInputMsg102.getSzCdStageOpen());
                                        rc = Ccmn02u.CallCSEC29D(CSEC29DI, CSEC29DO, pServiceStatus);
                                        
                                        //  Initialize DAM input and output areas
                                        
                                        if (CSEC29DO.getUlIdPerson() > 0) {
                                            
                                            
                                            if (0 != CLSC45DO.getROWCLSC45DO_ARRAY().getROWCLSC45DO(m).getSzCdStage().compareTo(ADOPTION)) {
                                                return SUCCESS;
                                            }
                                            //  This is being added for the manual opening of the Adoption
                                            // stage. If ulIdPrimaryChild is passed in, we are opening
                                            // the Adoption stage via the placement window. This is when
                                            // Service Authorizations are moved. We set a flag to know
                                            // that the Adoption stage is already open, but we need to
                                            // move the service authorizations now as opposed to when
                                            // the Adoption stage is manually opened.
                                            else if (pInputMsg102.getUlScrIdPrimChild() == 0) {
                                                return SUCCESS;
                                            }
                                            
                                            else {
                                                bIndAutoAdopt = 1;
                                            }
                                        }
                                        // 
                                        // Function Prototypes
                                        // 
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    }
                                }
                            }
                        }
                    }
                    // SIR 16114
                }
            }
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        
        if ((0 != ADOPTION.compareTo(pInputMsg102.getSzCdStageOpen())) || ((0 == ADOPTION.compareTo(pInputMsg102.getSzCdStageOpen())) && (!bIndAutoAdopt))) {
            pInputMsg102.getArchInputStruct().setCReqFuncCd(STAGE_PROG_NEW_STAGE);
            
            //  If previous function was successful, then call
            // next DAM.
            if (null == pInputMsg102.getSzCdStageReasonClosed()[0]) {
                pInputMsg102.setSzCdStageReasonClosed(pInputMsg102.getSzCdStage());
            }
            rc = Ccmn02u.CallCCMNB8D(pInputMsg102, CCMNB8DO, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            CINT12DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
            CINT12DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            CINT12DI.setSzCdStage(pInputMsg102.getSzCdStageOpen());
            
            // SARE2001 JMC NEW CODE BEGIN
            //  If previous function was successful, then call next DAM
            // to check if "Initial contact" has been recorded.
            // RIOSJA, SIR 16114 - "Initial contact" edit is not required
            // unless stage is INV.
            if (0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                
                //## BEGIN TUX/XML: Declare XML variables 
                CINT12DI.setSzCdStageClassification(ADULT_PROTECTIVE_SERVICES);
            }
            else {
                CINT12DI.setSzCdStageClassification(CINT21DO.getSzCdStageClassification());
            }
            CINT12DI.setSzCdStageCnty(CINT21DO.getSzCdStageCnty());
            // SARE2001 JMC NEW CODE END
            
            // SARE2001 SLC NEW CODE END
            //  If previous function was successful and
            // the event has been posted, then call
            // next DAM.
            if ((0 != SUBCARE.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != ADOPTION.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen()))) {
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                // 01/22/2003 DWW: Added for error handling
                if (0 == FRE_PROGRAM.compareTo(pInputMsg102.getSzCdStageOpen())) {
                    CCMND9DI.setUlIdCase(CINT21DO.getUlIdCase());
                    rc = Ccmn37s.CallCCMND9D(CCMND9DI, CCMND9DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    CINT12DI.setSzNmStage(CCMND9DO.getSzNmCase());
                }
                
                else if ((0 == PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != 0.compareTo(pInputMsg102.getSzNmPersonFull()))) {
                    CINT12DI.setSzNmStage(pInputMsg102.getSzNmPersonFull());
                }
                else {
                    CINT12DI.setSzNmStage(CINT21DO.getSzNmStage());
                }
            }
            //  SIR 3171
            // If the NmPerson Full passed in is empty, use the previous
            // stage name as the new stage name.
            else if (0 == 0.compareTo(pInputMsg102.getSzNmPersonFull())) {
                CINT12DI.setSzNmStage(CINT21DO.getSzNmStage());
            }
            else {
                CINT12DI.setSzNmStage(pInputMsg102.getSzNmPersonFull());
            }
            if (((DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().day) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().month) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().year)) || ((0 == pInputMsg102.getDtDtStageStart().day) && (0 == pInputMsg102.getDtDtStageStart().month) && (0 == pInputMsg102.getDtDtStageStart().year))) {
                CINT12DI.setDtDtStageStart(DtToday);
            }
            else {
                CINT12DI.setDtDtStageStart(pInputMsg102.getDtDtStageStart());
            }
            CINT12DI.setDtDtStageClose(NullDate);
            if ((0 == pInputMsg102.getSzCdStageOpen().compareTo(ADMIN_REVIEW)) || (0 == pInputMsg102.getSzCdStageOpen().compareTo(FAD_REVIEW))) {
                CINT12DI.setDtDtStageClose(MaxDate);
            }
            CINT12DI.setUlIdCase(CINT21DO.getUlIdCase());
            CINT12DI.setUlIdUnit(CINT21DO.getUlIdUnit());
            CINT12DI.setUlIdSituation(CINT21DO.getUlIdSituation());
            CINT12DI.setSzCdStageCurrPriority(CINT21DO.getSzCdStageCurrPriority());
            CINT12DI.setSzCdStageInitialPriority(CINT21DO.getSzCdStageCurrPriority());
            
            if (0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                CINT12DI.setSzCdStageProgram(ADULT_PROTECTIVE_SERVICES);
            }
            else {
                CINT12DI.setSzCdStageProgram(CINT21DO.getSzCdStageProgram());
            }
            CINT12DI.setSzCdStageRegion(CINT21DO.getSzCdStageRegion());
            if (0 != SUBCARE.compareTo(pInputMsg102.getSzCdStageOpen())) {
                if ((0 != CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSCdStageProgStageType().compareTo(EMPTY_STR)) && (0 != CASE_REL_SPEC_REQ.substring(0, 2).compareTo(CINT21DO.getSzCdStageType().substring(0, 2)))) {
                    
                    CINT12DI.setSzCdStageType(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSCdStageProgStageType());
                    pOutputMsg98.setSzCdStageType(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSCdStageProgStageType());
                }
                else {
                    CINT12DI.setSzCdStageType(CINT21DO.getSzCdStageType());
                    pOutputMsg98.setSzCdStageType(CINT21DO.getSzCdStageType());
                }
            }
            else if (0 == pInputMsg102.getSzCdStage().compareTo(INTAKE)) {
                CINT12DI.setSzCdStageType(CINT21DO.getSzCdStageType());
                pOutputMsg98.setSzCdStageType(CINT21DO.getSzCdStageType());
            }
            else {
                CINT12DI.setSzCdStageType(STAGE_TYPE_REG);
                pOutputMsg98.setSzCdStageType(STAGE_TYPE_REG);
            }
            if ((0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) || ((0 == POST_ADOPT.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != INTAKE.compareTo(pInputMsg102.getSzCdStage())))) {
                CCMNB2DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                if (0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) // 
                // (END): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
                // 
                
                
                
                {
                    CCMNB2DI.setSzCdCaseProgram(ADULT_PROTECTIVE_SERVICES);
                }
                else {
                    CCMNB2DI.setSzCdCaseProgram(CINT21DO.getSzCdStageProgram());
                }
                CCMNB2DI.setSzCdCaseCounty(CINT21DO.getSzCdStageCnty());
                rc = ARC_UTLGetDateAndTime(CCMNB2DI.getDtDtCaseOpened() , CCMNB2DI.getTmSysTmCaseOpened());
                
                CCMNB2DI.setDtDtCaseClosed(NullDate);
                //  Call DAM if good code
                
                if (0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                    
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    CCMNB2DI.setSzNmCase(CINT21DO.getSzNmStage());
                }
                else {
                    CLSS63DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    rc = Ccmn02u.CallCCMNB9D(pInputMsg102, CCMNB9DO, pServiceStatus);
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (i85 = 0;i85 < CCMNB9DO.getArchOutputStruct().getUlRowQty() && 0 == pInputMsg102.getUlScrIdPrimChild();++i85) {
                        
                        //  SIR (NO NUMBER) The following line said:
                        // if (SQL_SUCCESS == 0)
                        // instead of what it now says. -- RML
                        
                        //  Analyze error code
                        if (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_PRIM_CHILD)) {
                            pInputMsg102.setUlScrIdPrimChild(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                        }
                    }
                    CLSS63DI.setUlIdPerson(pInputMsg102.getUlScrIdPrimChild());
                    rc = CallCLSS63D(CLSS63DI, CLSS63DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    CCMNB2DI.setSzNmCase(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(0).getSzNmResource());
                }
                CCMNB2DI.setSzCdCaseRegion(CINT21DO.getSzCdStageRegion());
                rc = CallCCMNB2D(CCMNB2DI, CCMNB2DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                CINT13DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                CINT13DI.setUlIdCase(CCMNB2DO.getUlIdCase());
                CINT13DI.setDtDtSituationOpened(DtToday);
                CINT13DI.setNbrSitOccurrence(SITUATION_OCCUR);
                
                //  Start performance timer for service. All performance functions always
                // return success so there is no need to check status.
                rc = CallCINT13D(CINT13DI, CINT13DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                CINT12DI.setUlIdCase(CCMNB2DO.getUlIdCase());
                CINT12DI.setUlIdSituation(CINT13DO.getUlIdSituation());
                if (0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                    CINT12DI.setSzCdStageType(STAGE_TYPE_REG);
                }
            }
            
            //  Run-time versioning
            
            //  Check buffer size
            
            //  Process error message and return to client
            
            //  Initialize output message and length
            
            //  Initialize service status fields
            
            // 
            // Call DAMs to retrieve data
            // 
            
            //  Retrieve current date for date comparison
            rc = CallCINT12D(CINT12DI, pOutputMsg98, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            
            //  Post Stage Opening Events, Task-Events, and Task-To-Do's
            //  Stage Progression Update for Subcare Release 2.1
            // GRD
            // We looping through the rows returned from the Stage
            // Progression table, we may need to post events.  An
            // event should be posted if there is an event type in
            // that row of the stage progression table.  Alerts will
            // not be posted as events, but todo's and informational
            // events (that the stage was created) will be posted.
            //  Loop through all the records returned by DAM CCMNB8D
            for (usRowCtr = 0;usRowCtr < CCMNB8DO.getArchOutputStruct().getUlRowQty();usRowCtr++) {
                
                if ((null != CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgEventType()[0]) && (SPACE != CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgEventType()[0])) {
                    
                    if (!(0 == FRE_PROGRAM.compareTo(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgRsnClosed())) && (0 == PREP_ADULT.compareTo(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgOpen()))) {
                        CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                        CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        CCMN46DI.setDtDtEventOccurred(DtToday);
                        CCMN46DI.setSzCdTask(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgTask());
                        CCMN46DI.setSzTxtEventDescr(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzTxtStageProgEvntDesc());
                        CCMN46DI.setSzCdEventStatus(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgStatus());
                        CCMN46DI.setSzCdEventType(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgEventType());
                        CCMN46DI.setUlIdPerson(pInputMsg102.getUlIdPerson());
                        rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                }
                if ((0 == CCMNG2DO.getUlIdPerson()) && ((0 != pInputMsg102.getSzCdStageOpen().compareTo(ADMIN_REVIEW)) && (0 != pInputMsg102.getSzCdStageOpen().compareTo(FAD_REVIEW)))) {
                    
                    //  Use the Stage ID to retrieve Investigation Detail info.
                    rc = Ccmn02u.CallCCMNG2D(pInputMsg102, CCMNG2DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                //## END TUX/XML: Turn the XML buffer into an input message struct
                
                
                
                if (0 != NULL_STRING.compareTo(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgTodoInfo())) {
                    //  Allocate memory for the Todo Input& Output
                    pTodoCommonInput = new CSUB40UI();
                    
                    pTodoCommonOutput = new CSUB40UO();
                    pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgTodoInfo());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(CCMNG2DO.getUlIdPerson());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pInputMsg102.getUlIdPerson());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pOutputMsg98.getUlIdStage());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(CCMN46DO.getUlIdEvent());
                    if (TODO_CODE == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgTodoInfo()) {
                        pTodoCommonInput.getCSUB40UIG00().setSzSysTxtTodoCfDesc(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzTxtStageProgEvntDesc());
                    }
                    if (((DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().day) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().month) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().year)) || ((0 == pInputMsg102.getDtDtStageStart().day) && (0 == pInputMsg102.getDtDtStageStart().month) && (0 == pInputMsg102.getDtDtStageStart().year))) {
                        pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DtToday);
                    }
                    else {
                        pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pInputMsg102.getDtDtStageStart());
                    }
                    
                    
                    //  SIR 23663-Use the Stage ID to retrieve Stage Person Role of Alleged Perpetrator.
                    rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            if (0 == pTodoCommonOutput.getSzCdTodoTask().compareTo(THREE_MONTH_REVIEW)) {
                                CSYS07DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                
                                //  Exit service
                                CSYS07DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                CSYS07DI.setUlIdEvent(pTodoCommonOutput.getUlIdEvent());
                                CSYS07DI.setUlIdStage(pTodoCommonOutput.getUlIdStage());
                                CSYS07DI.setDtDtMonthlySummBegin(NullDate);
                                
                                //  Exit service
                                CSYS07DI.setDtDtMonthlySummEnd(NullDate);
                                CSYS07DI.setDtDTContactOccurred(NullDate);
                                CSYS07DI.setSzCdContactType(C3MT);
                                
                                
                                
                                //  Use the Stage ID to retrieve Stage info.
                                rc = CallCSYS07D(CSYS07DI, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            }
                            break;
                            
                        default :
                            
                            //  Exit service
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                            break;
                    }
                }
                
                if (0 == CCMN46DI.getSzCdEventType().compareTo(CONCLUSION_EVENT)) {
                    ulIdConclusionEvent = CCMN46DO.getUlIdEvent();
                }
                //  If the event just created is of type "PLN", then save the ID_EVENT
                // in a local variable. This id will be used when creating a shell
                // record in any of the Service Plan table
                // SIR 18135 - Also save the id for "CSP" events
                else if ((0 == CCMN46DI.getSzCdEventType().compareTo(EVENT_TYPE_PLN)) || (0 == CCMN46DI.getSzCdEventType().compareTo(CHILD_SER_PLAN))) {
                    ulIdServicePlanEvent = CCMN46DO.getUlIdEvent();
                }
                
                //  SIR # 15353 - CCMN44D Checks for Person's Date of birth
                if (0 != CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzTxtStageProgTodoDesc().compareTo(EMPTY_STR) && 0 == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgTodoInfo().compareTo(EMPTY_STR)) {
                    CCMN43DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CCMN43DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CCMN43DI.setSzCdTodoTask(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgTask());
                    if (0 == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgTask().compareTo(FAMILY_PRES_TASK)) {
                        
                        
                        CCMN43DI.setSzCdTodoType(ALERT_TODO);
                    }
                    else {
                        CCMN43DI.setSzCdTodoType(TASK_TODO);
                    }
                    CCMN43DI.setDtDtTodoCreated(DtToday);
                    
                    CCMN43DI.setDtDtTodoCompleted(NullDate);
                    CCMN43DI.setUlIdCase(CINT21DO.getUlIdCase());
                    CCMN43DI.setUlIdEvent(CCMN46DO.getUlIdEvent());
                    if (0 != pInputMsg102.getUlIdPerson()) // 
                    // (END): Retrieve DAM: cses11d      Legal Status simple retrieve
                    // 
                    
                    
                    {
                        
                        CCMN43DI.setUlIdTodoPersAssigned(pInputMsg102.getUlIdPerson());
                        CCMN43DI.setUlIdTodoPersWorker(pInputMsg102.getUlIdPerson());
                    }
                    else {
                        CCMN43DI.setUlIdTodoPersAssigned(CCMNG2DO.getUlIdPerson());
                        CCMN43DI.setUlIdTodoPersWorker(CCMNG2DO.getUlIdPerson());
                    }
                    CCMN43DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CCMN43DI.setSzTxtTodoDesc(CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzTxtStageProgTodoDesc());
                    time.getYear() = DtToday.year - 1900;
                    
                    if (SPECIAL_DATE == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getUlNbrStageProgDaysDue()) {
                        
                        //  If Status Effective Date Is Greater Than Person's DOB
                        // display message.
                        if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) {
                            time.getMonth() = DtToday.month + 2;
                            time.getDate() = 20;
                        }
                        else if (0 == pInputMsg102.getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS)) // 
                        // (END): Retrieve DAM: cses11d      Legal Status simple retrieve
                        // 
                        
                        
                        
                        {
                            time.getMonth() = DtToday.month;
                            time.getDate() = 15;
                        }
                    }
                    else {
                        time.getMonth() = DtToday.month - 1;
                        time.getDate() = DtToday.day + CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getUlNbrStageProgDaysDue();
                    }
                    
                    time.getTime();
                    CCMN43DI.getDtDtTodoDue().year = time.getYear() + 1900;
                    CCMN43DI.getDtDtTodoDue().month = time.getMonth() + 1;
                    CCMN43DI.getDtDtTodoDue().day = time.getDate();
                    CCMN43DI.getDtDtTaskDue().year = time.getYear() + 1900;
                    
                    //## BEGIN TUX/XML: Declare XML variables
                    CCMN43DI.getDtDtTaskDue().month = time.getMonth() + 1;
                    CCMN43DI.getDtDtTaskDue().day = time.getDate();
                    
                    //  SIR 1969: Use ulIdEvent to Retrieve Boolean Indicator for BLOB
                    
                    
                    
                    rc = CallCCMN43D(CCMN43DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    if (0 == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgEventType().compareTo(CONTACT)) {
                        CSYS07DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                        CSYS07DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        CSYS07DI.setUlIdEvent(CCMN46DO.getUlIdEvent());
                        CSYS07DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        CSYS07DI.setDtDtMonthlySummBegin(NullDate);
                        CSYS07DI.setDtDtMonthlySummEnd(NullDate);
                        CSYS07DI.setDtDTContactOccurred(NullDate);
                        
                        
                        //  SIR# 15352 - CMSC54D checks for consecutive terminating legal statuses
                        if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) {
                            CSYS07DI.setSzCdContactType(C3MT);
                        }
                        else if (0 == pInputMsg102.getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS)) {
                            CSYS07DI.setSzCdContactType(BMTH);
                        }
                        rc = CallCSYS07D(CSYS07DI, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                }
                if ((0 == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgEventType().compareTo(ADMIN_REVIEW)) || (0 == CCMNB8DO.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(usRowCtr).getSzCdStageProgEventType().compareTo(FAD_REVIEW))) {
                    
                    CAUDA3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CAUDA3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CAUDA3DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CAUDA3DI.setUlIdEvent(CCMN46DO.getUlIdEvent());
                    CAUDA3DI.setUlIdPerson(pInputMsg102.getUlScrIdPrimChild());
                    CAUDA3DI.setUlIdStageRelated(pInputMsg102.getUlIdStage());
                    CAUDA3DI.setDtDtAdminRvAppealNotif(NullDate);
                    CAUDA3DI.setDtDtAdminRvAppealReview(NullDate);
                    CAUDA3DI.setDtDtAdminRvDue(NullDate);
                    CAUDA3DI.setDtDtAdminRvEmgcyRel(NullDate);
                    CAUDA3DI.setDtDtAdminRvHearing(NullDate);
                    CAUDA3DI.setDtDtAdminRvReqAppeal(NullDate);
                    rc = CallCAUDA3D(CAUDA3DI, CAUDA3DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
            }
            if (0 == pInputMsg102.getSzCdStage().compareTo(INTAKE)) {
                
                
                
                //  Populate DAM input structure
                
                if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                    rc = Ccmn85s.CallCINT09D(pInputMsg102, CINT09DO, pServiceStatus);
                    
                    //  Increment counter by 1
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                pInputMsg102.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                pInputMsg102.getArchInputStruct().setUlPageSizeNbr(CINT19DO.get_CINT19DO__ROWCINT19DO_SIZE());
                
                do {
                    
                    rc = CallCINT19D(pInputMsg102, CINT19DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    //  Create new allegations in the Allegation table
                    for (i85 = 0;i85 < CINT19DO.getArchOutputStruct().getUlRowQty();i85++) {
                        CINV07DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                        CINV07DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        
                        CINV07DI.setSzCdAllegIncidentStage(INTAKE);
                        CINV07DI.setSzCdAllegType(CINT19DO.getROWCINT19DO_ARRAY().getROWCINT19DO(i85).getSzCdIntakeAllegType());
                        CINV07DI.setUlIdVictim(CINT19DO.getROWCINT19DO_ARRAY().getROWCINT19DO(i85).getUlIdVictim());
                        
                        CINV07DI.setUlIdAllegedPerpetrator(CINT19DO.getROWCINT19DO_ARRAY().getROWCINT19DO(i85).getUlIdAllegedPerpetrator());
                        CINV07DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        
                        if (0 != pInputMsg102.getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS) && 0 != pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_CCL) && 0 != pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_RCL)) {
                            CINV07DI.setSzTxtAllegDuration(CINT19DO.getROWCINT19DO_ARRAY().getROWCINT19DO(i85).getCTxtIntakeAllegDuration());
                        }
                        rc = Cinv47s.CallCINV07D(CINV07DI, CINV07DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        
                        
                        if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                            CINVB4DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CINVB4DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            CINVB4DI.setUlIdAllegation(CINV07DO.getUlIdAllegation());
                            CINVB4DI.setBIndFacilAllegAbOffGr(CINT09DO.getBIndIncmgOnGrnds());
                            CINVB4DI.setBIndFacilAllegSupvd(CINT09DO.getBIndIncmgFacilAbSupvd());
                            rc = CallCINVB4D(CINVB4DI, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                    }
                    pInputMsg102.getArchInputStruct().getUsPageNbr()++;
                }
                while (CINT19DO.getArchOutputStruct().getBMoreDataInd() == true);
            }
            
            
            //  SIR# 14234 - Add CINT21D to retrieve whether the stage is closed
            // or not regardless of window mode.
            
            if ((0 == pInputMsg102.getSzCdStageOpen().compareTo(INVESTIGATION)) && ((0 != ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen())) || (0 != FAD_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen())))) {
                if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) {
                    CINV24DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CINV24DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CINV24DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CINV24DI.setUlIdEvent(ulIdConclusionEvent);
                    CINV24DI.setDtDtApsInvstBegun(DtToday);
                    CINV24DI.setDtDtApsInvstCltAssmt(NullDate);
                    CINV24DI.setDtDtApsInvstCmplt(NullDate);
                    
                    //  Call DAM
                    rc = CallCINV24D(CINV24DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                //  If new stage's program is CPS, create a new record
                // in the CPS_INVST_DETAIL table
                else if (0 == pInputMsg102.getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS)) {
                    CINV12DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CINV12DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CINV12DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CINV12DI.setUlIdEvent(ulIdConclusionEvent);
                    CINV12DI.setDtDtCPSInvstDtlBegun(NullDate);
                    CINV12DI.setDtDtCPSInvstDtlAssigned(DtToday);
                    CINV12DI.setDtDtCpsInvstDtlComplt(NullDate);
                    if (0 == pInputMsg102.getSzCdStage().compareTo(INTAKE)) {
                        CINV12DI.setDtDtCPSInvstDtlIntake(CINT21DO.getDtDtStageStart());
                    }
                    else {
                        CINV12DI.setDtDtCPSInvstDtlIntake(NullDate);
                    }
                    
                    //  Do nothing
                    
                    rc = CallCINV12D(CINV12DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                //  If new stage's program is CCL or RCL, create a new record
                // in the LICENSING_INVST_DTL table
                else if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_CCL) || 0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_RCL)) {
                    CINV53DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    
                    CINV53DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CINV53DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CINV53DI.setUlIdEvent(ulIdConclusionEvent);
                    CINV53DI.setDtDtLicngInvstDtlBegun(DtToday);
                    CINV53DI.setDtDtLicngInvstAssigned(DtToday);
                    CINV53DI.setDtDtLicngInvstComplt(NullDate);
                    
                    if (0 == pInputMsg102.getSzCdStage().compareTo(INTAKE)) {
                        CINV53DI.setDtDtLicngInvstIntake(CINT21DO.getDtDtStageStart());
                    }
                    else {
                        CINV53DI.setDtDtLicngInvstIntake(NullDate);
                    }
                    rc = CallCINV53D(CINV53DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                
                //  If new stage's program is FAC, create a new record
                // in the FACILITY_INVST_DTL table
                else if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                    CINV54DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CINV54DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CINV54DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CINV54DI.setUlIdEvent(ulIdConclusionEvent);
                    CINV54DI.setDtDtFacilInvstBegun(NullDate);
                    CINV54DI.setDtDtFacilInvstIncident(NullDate);
                    
                    CINV54DI.setDtDtFacilInvstComplt(NullDate);
                    
                    //  Perform invalidation processing when End Date is
                    // after the Stage Closure Date and display message
                    if (0 == pInputMsg102.getSzCdStage().compareTo(INTAKE)) {
                        rc = Ccfc40s.CallCSEC54D(pInputMsg102, dtDtIncomingCall1, tmTmIncmgCall1, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        CINV54DI.setDtDtFacilInvstIntake(dtDtIncomingCall1);
                        CINV54DI.setTmSysTmFacilInvstInt(tmTmIncmgCall1);
                    }
                    else {
                        CINV54DI.setDtDtFacilInvstIntake(NullDate);
                    }
                    rc = CallCINV54D(CINV54DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                else {
                    rc = Messages.ARC_ERR_BAD_FUNC_CD;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
            }
            
            
            // 
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
            // 
            if (((0 == pInputMsg102.getSzCdStageOpen().compareTo(SUBCARE)) || (0 == pInputMsg102.getSzCdStageOpen().compareTo(FPR_PROGRAM)) || (0 == pInputMsg102.getSzCdStageOpen().compareTo(FSU_PROGRAM)) || (0 == pInputMsg102.getSzCdStageOpen().compareTo(FRE_PROGRAM))) && (ulIdServicePlanEvent != 0)) {
                CAUDE8DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                CAUDE8DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                CAUDE8DI.setUlIdEvent(ulIdServicePlanEvent);
                CAUDE8DI.setCIndImpactCreated(FND_YES);
                rc = CallCAUDE8D(CAUDE8DI, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
            
            pInputMsg102.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pInputMsg102.getArchInputStruct().setUlPageSizeNbr(CCMNB9DO.get_CCMNB9DO__ROWCCMNB9DO_SIZE());
            if (INDICATOR_YES != pInputMsg102.getCSysIndSStgOpenOnly()) {
                do {
                    
                    
                    //  Start Performance Timer
                    rc = Ccmn02u.CallCCMNB9D(pInputMsg102, CCMNB9DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (i85 = 0;i85 < CCMNB9DO.getArchOutputStruct().getUlRowQty();++i85) {
                        CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                        CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        CCMND3DI.setSzCdStagePersRelInt(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRelInt());
                        if (0 == pInputMsg102.getSzCdStage().compareTo(INVESTIGATION) && 0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS) && (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_BOTH) || 0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_VICTIM))) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_CLIENT);
                            CCMND3DI.setSzCdStagePersType(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType());
                        }
                        else if ((0 == pInputMsg102.getSzCdStage().compareTo(AGE_OUT)) && (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_PRIM_CHILD))) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_CLIENT);
                            CCMND3DI.setSzCdStagePersType(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType());
                        }
                        
                        else if (0 == pInputMsg102.getSzCdStage().compareTo(AGE_OUT) && ((0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_BOTH)) || (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_VICTIM)) || (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_PERP)))) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_NONE);
                            CCMND3DI.setSzCdStagePersType(PERSON_COLLATERAL);
                        }
                        
                        // 
                        // SIR 2581: The selected person from the Person List during
                        // stage progression needs to be given the role of
                        // Primary Child for the next stage.
                        // 
                        else if ((CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson() == pInputMsg102.getUlScrIdPrimChild()) && ((0 == SUBCARE.compareTo(pInputMsg102.getSzCdStageOpen())) || (0 == ADOPTION.compareTo(pInputMsg102.getSzCdStageOpen())) || (0 == POST_ADOPT.compareTo(pInputMsg102.getSzCdStageOpen())) || (0 == PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())))) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_PRIM_CHILD);
                            CCMND3DI.setSzCdStagePersType(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType());
                        }
                        
                        else {
                            CCMND3DI.setSzCdStagePersRole(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole());
                            CCMND3DI.setSzCdStagePersType(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType());
                        }
                        CCMND3DI.setSzCdStagePersSearchInd(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersSearchInd());
                        CCMND3DI.setDtDtStagePersLink(DtToday);
                        CCMND3DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                        CCMND3DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        CCMND3DI.setBIndStagePersInLaw(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getBIndStagePersInLaw());
                        CCMND3DI.setBIndStagePersReporter(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getBIndStagePersReporter());
                        
                        //  Populate Common Function Input Structure
                        
                        //  SIR#2177 : 14 December 1995
                        // If/else was added to pass the correct ReqFuncCd that will
                        // be used in PostEventCommonFunction
                        if ((0 == ADULT_PROTECTIVE_SERVICES.compareTo(pInputMsg102.getSzCdStageProgram())) || (0 == ADULT_FACILITY.compareTo(pInputMsg102.getSzCdStageProgram()))) {
                            // 
                            // (END): Common Function: ccmn06u   Check Stage/Event common function
                            // 
                            
                            if ((0 == PERSON_ROLE_PRINCIPAL.compareTo(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType())) && ((0 == PERSON_ROLE_VICTIM.compareTo(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole())) || (0 == PERSON_ROLE_BOTH.compareTo(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole()))) && (0 == pInputMsg102.getSzCdStageOpen().compareTo(INVESTIGATION))) {
                                CCMN44DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                                rc = Ccmn04s.CallCCMN44D(CCMN44DI, CCMN44DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                
                                // SIR 21130 - if the closure event is pending then do not call post
                                // event invalidate the approval.
                                // The if statement and its contents were added
                                // IMPACT BEGIN - Don't demote events when in "Approver mode"
                                if ((DateHelper.NULL_DATE != CCMN44DO.getDtDtPersonBirth().day) && (DateHelper.NULL_DATE != CCMN44DO.getDtDtPersonBirth().month) && (DateHelper.NULL_DATE != CCMN44DO.getDtDtPersonBirth().year)) {
                                    //  Compare today's date to child's date of birth
                                    lAgeDiff = ARC_UTLCompareDateAndTime((FndInt3date) & DtToday, (char) 0, (FndInt3date) & CCMN44DO.getDtDtPersonBirth() , (char) 0);
                                    
                                    lDays = lAgeDiff / MINUTES_IN_DAYS;
                                    
                                    lAPSCalculatedAge = (int) lDays / SIXTY_FIVE_IN_DAYS;
                                }
                                else {
                                    lAPSCalculatedAge = CCMN44DO.getLNbrPersonAge();
                                }
                                //  IMPACT END
                                if (lAPSCalculatedAge >= AGED_PERSON_AGE) {
                                    CLSS60DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                                    CLSS60DI.setDtScrDtCharEffDate(DtToday);
                                    rc = Ccfc14s.CallCLSS60D(CLSS60DI, CLSS60DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    if (CLSS60DO.getArchOutputStruct().getUlRowQty() > 0) {
                                        for (m = 0;m < CLSS60DO.getArchOutputStruct().getUlRowQty() && bIndAgedChecked == false;m++) {
                                            if ((0 == AGED_CHARACTERISTIC.compareTo(CLSS60DO.getROWCLSS60DO_ARRAY().getROWCLSS60DO(m).getCdCharacteristic())) && (0 == APS_CHARACTERISTIC.compareTo(CLSS60DO.getROWCLSS60DO_ARRAY().getROWCLSS60DO(m).getSzCdCharCategory()))) {
                                                bIndAgedChecked = true;
                                            }
                                        }
                                    }
                                    
                                    // Return if InvalidateAprvl() failed.
                                    if (!bIndAgedChecked) {
                                        CINV48DI.getROWCINV48DI().setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                                        CINV48DI.getROWCINV48DI().setSzCdCharCategory(APS_CHARACTERISTIC);
                                        CINV48DI.getROWCINV48DI().setCdCharacteristic(AGED_CHARACTERISTIC);
                                        CINV48DI.getROWCINV48DI().setDtDtCharStart(DtToday);
                                        CINV48DI.getROWCINV48DI().getDtDtCharEnd().day = DateHelper.ARC_MAX_DAY;
                                        
                                        CINV48DI.getROWCINV48DI().getDtDtCharEnd().month = DateHelper.ARC_MAX_MONTH;
                                        CINV48DI.getROWCINV48DI().getDtDtCharEnd().year = DateHelper.ARC_MAX_YEAR;
                                        
                                        
                                        //  Call CCMN96D
                                        rc = Cinv34s.CallCINV48D(CINV48DI, CINV48DO, pServiceStatus);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                        CINV41DI.setTsSysTsLastUpdate2(CCMN44DO.getTsLastUpdate());
                                        
                                        CINV41DI.setCCdPersonSex(CCMN44DO.getCCdPersonSex());
                                        
                                        CINV41DI.setSzNmPersonFull(CCMN44DO.getSzNmPersonFull());
                                        
                                        //## BEGIN TUX/XML: Declare XML variables 
                                        CINV41DI.setDtDtPersonBirth(CCMN44DO.getDtDtPersonBirth());
                                        CINV41DI.setBIndPersonDobApprox(CCMN44DO.getBIndPersonDobApprox());
                                        CINV41DI.setDtDtPersonDeath(CCMN44DO.getDtDtPersonDeath());
                                        CINV41DI.setSzCdPersonDeath(CCMN44DO.getSzCdPersonDeath());
                                        CINV41DI.setSzCdPersonMaritalStatus(CCMN44DO.getSzCdPersonMaritalStatus());
                                        CINV41DI.setSzCdPersonLanguage(CCMN44DO.getSzCdPersonLanguage());
                                        CINV41DI.setSzCdPersonEthnicGroup(CCMN44DO.getSzCdPersonEthnicGroup());
                                        CINV41DI.setCdPersonStatus(CCMN44DO.getCdPersonStatus());
                                        CINV41DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                                        CINV41DI.setBCdPersonChar(CHARACT_NA_NOT_CHECK);
                                        CINV41DI.setSzCdPersonReligion(CCMN44DO.getSzCdPersonReligion());
                                        CINV41DI.setSzCdPersonLivArr(CCMN44DO.getSzCdPersonLivArr());
                                        CINV41DI.setSzTxtOccupation(CCMN44DO.getSzTxtOccupation());
                                        CINV41DI.setLNbrPersonAge(CCMN44DO.getLNbrPersonAge());
                                        
                                        
                                        //  Set rc to ARC_SUCCESS
                                        rc = Ccfc14s.CallCINV41D(CINV41DI, CINV41DO, pServiceStatus);
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    }
                                }
                            }
                        }
                        // SIR 21130 -end if the closure event is pending then do not call post
                        
                        //  IMPACT BEGIN
                        //  IMPACT END
                        
                        // SIR 21130 - if closure event is not pending or there is no other
                        // legal status event call post event
                        // SIR 19357 - in approval mode if closure is pending, should still
                        // update event description if legal status changes are made.  Should
                        // update event data all the time, so removed if statement
                        //if (strcmp(pInputMsg->szCdEventStatus[STAGE_CLOSURE] ,EVENT_PEND) ||
                        //     pInputMsg->ROWCCMN01UIG00.ulIdEvent == 0 ||
                        //     ( 0 == strcmp(pInputMsg->szCdEventStatus[STAGE_CLOSURE] ,EVENT_PEND) &&
                        //       TRUE == pInputMsg->ArchInputStruct.ulSysNbrReserved1))
                        if (0 != CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PRIMARY_ROLE_STAGE_CLOSED)) {
                            if (0 != POST_ADOPT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                                rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                if (0 == pInputMsg102.getSzCdStage().compareTo(INVESTIGATION) && 0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS) && (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_BOTH) || 0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_VICTIM))) {
                                    CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                    CCMND3DI.setUlIdStage(pInputMsg102.getUlIdStage());
                                    CCMND3DI.setDtDtStagePersLink(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getDtDtStagePersLink());
                                    CCMND3DI.setBIndStagePersEmpNew(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getBIndStagePersEmpNew());
                                    CCMND3DI.setSzTxtStagePersNotes(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzTxtStagePersNotes());
                                    CCMND3DI.setTsLastUpdate(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getTsLastUpdate());
                                    CCMND3DI.setUlIdStagePerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdStagePerson());
                                    CCMND3DI.setSzCdStagePersSearchInd(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersSearchInd());
                                    CCMND3DI.setBIndStagePersInLaw(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getBIndStagePersInLaw());
                                    CCMND3DI.setBIndStagePersReporter(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getBIndStagePersReporter());
                                    rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                }
                            }
                            else if ((0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_PRIM_CHILD)) || (0 == INTAKE.compareTo(pInputMsg102.getSzCdStage()) && (0 != STAFF.compareTo(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType())))) {
                                
                                
                                //  Call CCMNB0D
                                rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            }
                        }
                    }
                    pInputMsg102.getArchInputStruct().getUsPageNbr()++;
                }
                while (CCMNB9DO.getArchOutputStruct().getBMoreDataInd() == true);
                
                if ((0 == INVESTIGATION.compareTo(pInputMsg102.getSzCdStage())) && (0 == SERVICE_DELIVERY.compareTo(pInputMsg102.getSzCdStageOpen()))) {
                    CLSC75DI.setUlIdStage(pInputMsg102.getUlIdStage());
                    CLSC75DI.setUlIdStageRelated(pOutputMsg98.getUlIdStage());
                    
                    
                    //  Set rc to ARC_SUCCESS
                    rc = CallCLSC75D(CLSC75DI, CLSC75DO, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (i85 = 0;i85 < CLSC75DO.getArchOutputStruct().getUlRowQty();++i85) {
                        
                        CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                        
                        
                        CCMND3DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                        CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        CCMND3DI.setSzCdStagePersRole(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersRole());
                        
                        //## BEGIN TUX/XML: Declare XML variables 
                        CCMND3DI.setSzCdStagePersType(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersType());
                        CCMND3DI.setSzCdStagePersSearchInd(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersSearchInd());
                        CCMND3DI.setSzTxtStagePersNotes(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzTxtStagePersNotes());
                        CCMND3DI.setBIndStagePersInLaw(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getBIndStagePersInLaw());
                        CCMND3DI.setDtDtStagePersLink(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getDtDtStagePersLink());
                        CCMND3DI.setSzCdStagePersRelInt(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getSzCdStagePersRelInt());
                        CCMND3DI.setUlIdStage(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getUlIdStage());
                        CCMND3DI.setBIndStagePersReporter(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getBIndStagePersReporter());
                        CCMND3DI.setBIndStagePersEmpNew(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getBIndStagePersEmpNew());
                        CCMND3DI.setUlIdPerson(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getUlIdPerson());
                        CCMND3DI.setUlIdStagePerson(CLSC75DO.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i85).getUlIdStagePerson());
                        rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                }
            }
            //  IMPACT END
            
            
            //  Stage Progression Update for Subcare Release 2.1
            // If the functional window only creates the subcare stage
            // we should retrieve all principals associated with the
            // old stage, and update Stage_Person_link with the new
            // stage id and principals (including the primary child)
            // GRD
            else if (0 != FAD_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen())) {
                do {
                    rc = Ccmn02u.CallCCMNB9D(pInputMsg102, CCMNB9DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    for (i85 = 0;i85 < CCMNB9DO.getArchOutputStruct().getUlRowQty();++i85) {
                        CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                        CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        CCMND3DI.setSzCdStagePersType(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType());
                        // SIR 21130 - end if closure event is not pending or there is no other
                        // legal status event call post event
                        
                        
                        // SIR 21130 -moved this from the SQL_SUCCESS of the switch statement
                        // because the has to call all the following event if we do not call
                        // post event
                        // If post event is called -- else statement entered -- the rc refers
                        // back to the POSTEVENT call ; if not rc refers back to CCMN62 call.
                        if ((CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson() == pInputMsg102.getUlScrIdPrimChild()) && ((0 == SUBCARE.compareTo(pInputMsg102.getSzCdStageOpen())) || (0 == ADOPTION.compareTo(pInputMsg102.getSzCdStageOpen())) || (0 == POST_ADOPT.compareTo(pInputMsg102.getSzCdStageOpen())) || (0 == PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())))) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_PRIM_CHILD);
                        }
                        else if ((0 == pInputMsg102.getSzCdStageOpen().compareTo(AGE_OUT)) && (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_PRIM_CHILD))) {
                            //##		      return (FND_SUCCESS);
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_CLIENT);
                        }
                        //  SIR 3602
                        // Roles were not being changed correctly when progressing
                        // to aging out stage, added if test to change everyone who
                        // is not the primary child to a no role collateral
                        else if (0 == pInputMsg102.getSzCdStageOpen().compareTo(AGE_OUT) && ((0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_BOTH)) || (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_VICTIM)) || (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_NONE)) || (0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_PERP)))) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_NONE);
                            CCMND3DI.setSzCdStagePersType(PERSON_COLLATERAL);
                        }
                        //  SIR 21169
                        // If we have a PC role and we are opening a Family
                        // stage we should not copy the person to the new stage
                        // as a PC, but as a DV
                        else if ((0 == CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole().compareTo(PERSON_ROLE_PRIM_CHILD)) && ((0 == pInputMsg102.getSzCdStageOpen().compareTo(FPR_PROGRAM)) || (0 == pInputMsg102.getSzCdStageOpen().compareTo(FRE_PROGRAM)))) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_BOTH);
                        }
                        //  SIR 15052 - when creating SUB and FSU stages, set all
                        // persons' roles to no role, except for the primary child in SUB
                        else if (0 == pInputMsg102.getSzCdStageOpen().compareTo(SUBCARE) || 0 == pInputMsg102.getSzCdStageOpen().compareTo(FSU_PROGRAM)) {
                            CCMND3DI.setSzCdStagePersRole(PERSON_ROLE_NONE);
                        }
                        else {
                            CCMND3DI.setSzCdStagePersRole(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRole());
                        }
                        CCMND3DI.setDtDtStagePersLink(DtToday);
                        CCMND3DI.setUlIdPerson(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getUlIdPerson());
                        CCMND3DI.setSzCdStagePersRelInt(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersRelInt());
                        CCMND3DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        CCMND3DI.setSzCdStagePersSearchInd(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersSearchInd());
                        CCMND3DI.setBIndStagePersInLaw(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getBIndStagePersInLaw());
                        CCMND3DI.setBIndStagePersReporter(CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getBIndStagePersReporter());
                        if ((0 != CCMNB9DO.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i85).getSzCdStagePersType().compareTo(STAFF)) && (0 != ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen()))) {
                            
                            //  Start performance timer for service. All performance functions always
                            // return success so there is no need to check status.
                            rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                        //  SIR 4099 - Removed else that was here for PrimChild and
                        // PAL stage; we want to copy all persons into the new PAL
                        // stage
                        // else if ((0 == strcmp(PREP_ADULT,pInputMsg->szCdStageOpen))&&
                        // (0 == strcmp(Ccmnb9do.ROWCCMNB9DO[i].szCdStagePersRole,
                        // PERSON_ROLE_PRIM_CHILD)))
                        else if ((CCMND3DI.getUlIdPerson() == pInputMsg102.getUlScrIdPrimChild()) && (0 == ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen()))) {
                            rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                    }
                    pInputMsg102.getArchInputStruct().getUsPageNbr()++;
                }
                while (CCMNB9DO.getArchOutputStruct().getBMoreDataInd() == true);
            }
            CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
            CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            CCMND3DI.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
            CCMND3DI.setSzCdStagePersType(STAFF);
            CCMND3DI.setBIndStagePersEmpNew(EMP_NEW);
            if (0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                CCMND3DI.setUlIdPerson(pInputMsg102.getUlIdPerson());
            }
            
            else if (pInputMsg102.getUlIdPerson() > 0) {
                CCMND3DI.setUlIdPerson(pInputMsg102.getUlIdPerson());
            }
            else {
                CCMND3DI.setUlIdPerson(CCMNG2DO.getUlIdPerson());
            }
            if (0 == PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                CSEC66DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                CSEC66DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                rc = CallCSEC66D(CSEC66DI, CSEC66DO, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_NO_ROWS_RETURNED:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = rc;
                        goto_END = true;
                        if (goto_END) {
                            break;
                        }
                        break;
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                if (!goto_END) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    CCMND3DI.setUlIdPerson(CSEC66DO.getUlIdPerson());
                }
            }
            
            //  Populate DAM input structure
            if (!goto_END) {
                CCMND3DI.setDtDtStagePersLink(DtToday);
                CCMND3DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                
                
                //  Call cSEC71dQUERYdam
                rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                pOutputMsg98.setTsLastUpdate(CCMND3DO.getTsLastUpdate());
                
                if (0 == AGE_OUT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                    i85 = 0;
                    while ((!bIndNoAOCTodo) && (WtcHelperConstants.SQL_SUCCESS == rc)) {
                        //  Allocate memory for the Todo Input& Output
                        pTodoCommonInput = new CSUB40UI();
                        
                        pTodoCommonOutput = new CSUB40UO();
                        if (0 == i85) {
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(AOC_CLIENT_ASSES_ALERT);
                            i85++;
                        }
                        else {
                            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(AOC_QUARTERLY_REVIEW);
                            CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                            CCMN46DI.setDtDtEventOccurred(DtToday);
                            CCMN46DI.setSzCdTask(APS_CONTACT_TASK);
                            
                            CCMN46DI.setSzTxtEventDescr(QUART_EVENT_DESC);
                            CCMN46DI.setSzCdEventStatus(EVENT_STATUS_NEW);
                            CCMN46DI.setSzCdEventType(CONTRACT);
                            CCMN46DI.setUlIdPerson(pInputMsg102.getUlIdPerson());
                            rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            
                            
                            bIndNoAOCTodo = true;
                        }
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(CCMND3DI.getUlIdPerson());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pOutputMsg98.getUlIdStage());
                        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(CCMN46DO.getUlIdEvent());
                        if (((DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().day) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().month) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().year)) || ((0 == pInputMsg102.getDtDtStageStart().day) && (0 == pInputMsg102.getDtDtStageStart().month) && (0 == pInputMsg102.getDtDtStageStart().year))) {
                            pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DtToday);
                        }
                        else {
                            pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pInputMsg102.getDtDtStageStart());
                        }
                        if (0 == pTodoCommonInput.getCSUB40UIG00().getSzSysCdTodoCf().compareTo(AOC_QUARTERLY_REVIEW)) {
                            pTodoCommonInput.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day = TWENTIETH_DAY;
                        }
                        rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                if (0 == pTodoCommonOutput.getSzCdTodoTask().compareTo(APS_CONTACT_TASK)) {
                                    CSYS07DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                    CSYS07DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                    CSYS07DI.setUlIdEvent(pTodoCommonOutput.getUlIdEvent());
                                    CSYS07DI.setUlIdStage(pTodoCommonOutput.getUlIdStage());
                                    CSYS07DI.setDtDtMonthlySummBegin(NullDate);
                                    CSYS07DI.setDtDtMonthlySummEnd(NullDate);
                                    CSYS07DI.setDtDTContactOccurred(NullDate);
                                    CSYS07DI.setSzCdContactType(C3MT);
                                    
                                    //  Call CheckStageEventStatus
                                    rc = CallCSYS07D(CSYS07DI, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                }
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                                break;
                        }
                    }
                }
                
                
                
                //  SIR 3609
                // Similar to AOC stage, for PAL, we can't use the Todo Common
                // Function with stage progression table above to assign the PAL ILS
                // assessment because we don't know who the current worker is
                // yet. If we reach this point in the code, we have determined
                // the PAL Coordinator for the region.
                else if (0 == PREP_ADULT.compareTo(pInputMsg102.getSzCdStageOpen())) {
                    
                    //  Allocate memory for the Todo Input& Output
                    pTodoCommonInput = new CSUB40UI();
                    
                    pTodoCommonOutput = new CSUB40UO();
                    CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CCMN46DI.setDtDtEventOccurred(DtToday);
                    CCMN46DI.setSzCdTask(PAL_ILS_TASK);
                    CCMN46DI.setSzTxtEventDescr(PAL_ILS_DESCRIPTION);
                    CCMN46DI.setSzCdEventStatus(EVENT_STATUS_NEW);
                    CCMN46DI.setSzCdEventType(PAL_ILS_EVENT_TYPE);
                    CCMN46DI.setUlIdPerson(pInputMsg102.getUlIdPerson());
                    rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(CCMND3DI.getUlIdPerson());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pOutputMsg98.getUlIdStage());
                    pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(CCMN46DO.getUlIdEvent());
                    pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(PAL_ILS_TODO);
                    
                    //  Populate DAM input structure
                    
                    if (((DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().day) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().month) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().year)) || ((0 == pInputMsg102.getDtDtStageStart().day) && (0 == pInputMsg102.getDtDtStageStart().month) && (0 == pInputMsg102.getDtDtStageStart().year))) {
                        pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(DtToday);
                    }
                    else {
                        pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(pInputMsg102.getDtDtStageStart());
                    }
                    rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                            
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                            break;
                    }
                }
                CCMNC1DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                CCMNC1DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                CCMNC1DI.setUlIdPriorStage(pInputMsg102.getUlIdStage());
                CCMNC1DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                
                //  Call the Invalidate function
                rc = CallCCMNC1D(CCMNC1DI, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                
                //  SIR 14053 - update open slots in resource if legal status is adoption
                // consummated for an ADD
                if (((0 == pInputMsg102.getSzCdStage().compareTo(INVESTIGATION)) || (0 == pInputMsg102.getSzCdStage().compareTo(AGE_OUT))) && (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) && (0 != pInputMsg102.getSzCdStageOpen().compareTo(ADMIN_REVIEW))) {
                    CCMN87DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CCMN87DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    CCMN87DI.setUlIdStage(pInputMsg102.getUlIdStage());
                    if (0 == pInputMsg102.getSzCdStage() // delete processing
                    .compareTo(INVESTIGATION)) {
                        CCMN87DI.setSzCdTask(INV_OUTCOME_MATRIX_TASK);
                    }
                    else {
                        CCMN87DI.setSzCdTask(AOC_OUTCOME_MATRIX_TASK);
                    }
                    
                    rc = Ccmn02u.CallCCMN87D(CCMN87DI, CCMN87DO, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    if (CCMN87DO.getArchOutputStruct().getUlRowQty() == 1) {
                        CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        CCMN46DI.setDtDtEventOccurred(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getDtDtEventOccurred());
                        CCMN46DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                        CCMN46DI.setSzCdTask(SVC_OUTCOME_MATRIX_TASK);
                        
                        CCMN46DI.setSzTxtEventDescr(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzTxtEventDescr());
                        
                        // SIR 15166 Moving free cmsc52 into loop that malloc'd it
                        
                        CCMN46DI.setSzCdEventStatus(EVENT_STATUS_PROCESS);
                        CCMN46DI.setSzCdEventType(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventType());
                        
                        CCMN45DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                        
                        //  IMPACT BEGIN
                        //  IMPACT END
                        //  
                        //      This code was comment out for SIR  22371 and SIR 22384 -- dickmaec
                        //    
                        //       /* ****** MHMR3 Item8.5 begin *******************
                        //       ** Check to see if the ToCreateEvent Flag was
                        //       ** set to yes. If so, create a second event
                        //       ** for the Referral Form.
                        //       */
                        //       if (pInputMsg->cSysIndEventToCreate)
                        //       {
                        //           /*
                        //           ** Initialize Post Event Structure
                        //           */
                        //           memset(&PostEventRec, NULL, sizeof(_ROWCCMN01UIG00));
                        //
                        //           /*
                        //           ** This will always be an add
                        //           */
                        //
                        //           pInputMsg->ArchInputStruct.cReqFuncCd = REQ_FUNC_CD_ADD;
                        //
                        //           /*
                        //           ** Fill event Structure
                        //           */
                        //
                        //           PostEventRec.ulIdStage = pInputMsg->ROWCINV18SIG01.ulIdStage;
                        //
                        //           /* The worker logged in */
                        //           PostEventRec.ulIdPerson = pInputMsg->ROWCINV18SIG01.ulIdPerson;
                        //
                        //           COPYSZ(PostEventRec.szCdEventType, EVENT_TYPE_CASE);
                        //
                        //           /* This is filled with SysDate in the window */
                        //           PostEventRec.dtDtEventOccurred =
                        //                      pInputMsg->ROWCINV18SIG01.dtDtEventOccurred;
                        //
                        //           COPYSZ(PostEventRec.szTxtEventDescr,
                        //                     EVENT_REFERRAL_DESC);
                        //
                        //            /*
                        //            ** IMPACT BEGIN - If in "Approver Mode", set status to PEND
                        //            */
                        //            if (FALSE == pInputMsg->ArchInputStruct.ulSysNbrReserved1)
                        //            {
                        //                COPYSZ(PostEventRec.szCdEventStatus, EVENT_STATUS_COMPLETE);
                        //            } /* end if */
                        //            else
                        //            {
                        //                COPYSZ(PostEventRec.szCdEventStatus, EVENT_STATUS_PENDING);
                        //            } /* end else */
                        //            /*
                        //            ** IMPACT END
                        //            */
                        //
                        //           rc = CallPostEvent(&pInputMsg->ArchInputStruct,
                        //                      &PostEventRec,
                        //                      &ulOutputEvent,
                        //                     TUX_STATUSPARMS);
                        //           switch(rc)
                        //           {
                        //             case MSG_CMN_TMSTAMP_MISMATCH:
                        //
                        //               /*
                        //               ** Exit service
                        //               */
                        //               PROCESS_TUX_RC_ERROR_TRANSACT;
                        ////##               PrepServiceExit(SVCPARMS);
                        //
                        //               break;
                        //             default:
                        //               PROCESS_TUX_RC_ERROR_TRANSACT;
                        //               break;
                        //           } /* end switch */
                        //
                        //           pInputMsg->ArchInputStruct.cReqFuncCd = REQ_FUNC_CD_UPDATE;
                        //
                        //       } /* end pInputMsg->cSysIndEventToCreate  */
                        //
                        //       /* ****** MHMR3 Item8.5 end ****************** */
                        
                        
                        rc = Ccmn01u.CallCCMN45D(CCMN45DI, CCMN45DO, pServiceStatus);
                        
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        CCMN46DI.setUlIdPerson(CCMN45DO.getROWCCMN45DO().getUlIdPerson());
                        CCMN46DI.setTsLastUpdate(CCMN45DO.getROWCCMN45DO().getTsLastUpdate());
                        rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                    else if (CCMN87DO.getArchOutputStruct().getUlRowQty() == 0) {
                        CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                        CCMN46DI.setDtDtEventOccurred(DtToday);
                        CCMN46DI.setSzCdTask(SVC_OUTCOME_MATRIX_TASK);
                        CCMN46DI.setSzCdEventStatus(EVENT_STATUS_NEW);
                        CCMN46DI.setSzCdEventType(EVENT_TYPE_PLN);
                        
                        //  ERR#1869 Retrieve timestamps to return to window
                        // Retrieve TS_LAST_UPDATE for event
                        rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                    else {
                        
                        // Retrieve TS_LAST_UPDATE for stage
                        rc = Messages.ARC_ERR_BAD_FUNC_CD;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                    CCMN87DI.setUlIdStage(pInputMsg102.getUlIdStage());
                    CCMN87DI.setSzCdTask(GUARDIANSHIP_TASK);
                    
                    // Retrieve TS_LAST_UPDATE for Facility Investigation Dtl
                    rc = Ccmn02u.CallCCMN87D(CCMN87DI, CCMN87DO, pServiceStatus);
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    if ((SUCCESS == rc) && (CCMN87DO.getArchOutputStruct().getUlRowQty() > 0)) {
                        
                        //  SIR 2646
                        // Loop through all of the Guardianship event rows
                        // and retrieve the Guardianship detail record.
                        for (i85 = 0;i85 < CCMN87DO.getArchOutputStruct().getUlRowQty();i85++) {
                            if (0 != EVENT_STATUS_NEW.compareTo(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventStatus())) {
                                CSEC09DI.setUlIdGuardEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                                rc = CallCSEC09D(CSEC09DI, CSEC09DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            }
                            if (((DateHelper.NULL_DATE == CSEC09DO.getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE == CSEC09DO.getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE == CSEC09DO.getDtDtGuardCloseDate().year)) && ((0 == CSEC09DO.getSzCdGuardGuardianType().compareTo(ADULT_PROTECTIVE_SERVICES)) || (0 == CSEC09DO.getSzCdGuardGuardianType().compareTo(CONTRACTED))) && ((DateHelper.NULL_DATE != CSEC09DO.getDtDtGuardLetterIssued().day) && (DateHelper.NULL_DATE != CSEC09DO.getDtDtGuardLetterIssued().month) && (DateHelper.NULL_DATE != CSEC09DO.getDtDtGuardLetterIssued().year))) {
                                
                                
                                //  SIR 14053 - update open slots in resource if legal status is adoption
                                // consummated for a delete
                                if (CCMN87DO.getArchOutputStruct().getUlRowQty() > 0) {
                                    CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                    CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                                    CCMN46DI.setDtDtEventOccurred(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getDtDtEventOccurred());
                                    CCMN46DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                                    CCMN46DI.setSzCdTask(UPDATE_GUARDIANSHIP_CD_TASK);
                                    CCMN46DI.setSzTxtEventDescr(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzTxtEventDescr());
                                    CCMN46DI.setSzCdEventStatus(EVENT_STATUS_PROCESS);
                                    CCMN46DI.setSzCdEventType(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventType());
                                    CCMN45DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                                    rc = Ccmn01u.CallCCMN45D(CCMN45DI, CCMN45DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    CCMN46DI.setUlIdPerson(CCMN45DO.getROWCCMN45DO().getUlIdPerson());
                                    CCMN46DI.setTsLastUpdate(CCMN45DO.getROWCCMN45DO().getTsLastUpdate());
                                    rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    
                                    //  If we have Guardianship recs we need to update the
                                    // stage table, but only need to do this once, not each
                                    // time through the loop. So set the flag to true. GRD
                                    bGuardInProc = 1;
                                }
                            }
                            
                            else if ((DateHelper.NULL_DATE == CSEC09DO.getDtDtGuardCloseDate().day) && (DateHelper.NULL_DATE == CSEC09DO.getDtDtGuardCloseDate().month) && (DateHelper.NULL_DATE == CSEC09DO.getDtDtGuardCloseDate().year)) {
                                
                                
                                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                // 01/22/2003 DWW: Added for error handling
                                if (CCMN87DO.getArchOutputStruct().getUlRowQty() > 0) {
                                    CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                    CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                                    CCMN46DI.setDtDtEventOccurred(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getDtDtEventOccurred());
                                    CCMN46DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                                    CCMN46DI.setSzCdTask(UPDATE_GUARDIANSHIP_CD_TASK);
                                    CCMN46DI.setSzTxtEventDescr(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzTxtEventDescr());
                                    CCMN46DI.setSzCdEventStatus(EVENT_STATUS_PROCESS);
                                    CCMN46DI.setSzCdEventType(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventType());
                                    CCMN45DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                                    
                                    //  Call DAM
                                    rc = Ccmn01u.CallCCMN45D(CCMN45DI, CCMN45DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                    CCMN46DI.setUlIdPerson(CCMN45DO.getROWCCMN45DO().getUlIdPerson());
                                    CCMN46DI.setTsLastUpdate(CCMN45DO.getROWCCMN45DO().getTsLastUpdate());
                                    rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                }
                            }
                        }
                    }
                    CINT41DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    CINT41DI.setSzCdStage(pInputMsg102.getSzCdStageOpen());
                    CINT41DI.setSzCdStageClassification(CINT21DO.getSzCdStageClassification());
                    CINT41DI.setSzCdStageCnty(CINT21DO.getSzCdStageCnty());
                    CINT41DI.setSzNmStage(CINT21DO.getSzNmStage());
                    CINT41DI.setSzCdStageCurrPriority(CINT21DO.getSzCdStageCurrPriority());
                    CINT41DI.setSzCdStageInitialPriority(CINT21DO.getSzCdStageCurrPriority());
                    if (((DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().day) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().month) && (DateHelper.NULL_DATE == pInputMsg102.getDtDtStageStart().year)) || ((0 == pInputMsg102.getDtDtStageStart().day) && (0 == pInputMsg102.getDtDtStageStart().month) && (0 == pInputMsg102.getDtDtStageStart().year))) {
                        CINT41DI.setDtDtStageStart(DtToday);
                    }
                    else {
                        CINT41DI.setDtDtStageStart(pInputMsg102.getDtDtStageStart());
                    }
                    CINT41DI.setDtDtStageClose(NullDate);
                    CINT41DI.setUlIdCase(CINT21DO.getUlIdCase());
                    CINT41DI.setUlIdUnit(CINT21DO.getUlIdUnit());
                    CINT41DI.setUlIdSituation(CINT21DO.getUlIdSituation());
                    CINT41DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CINT41DI.setTsLastUpdate(pOutputMsg98.getTsSysTsLastUpdate2());
                    if (bGuardInProc) {
                        CINT41DI.setSzCdStageType(GUARDIANSHIP_TYPE);
                    }
                    else {
                        CINT41DI.setSzCdStageType(STAGE_TYPE_REG);
                    }
                    rc = Cint21s.CallCINT41D(CINT41DI, pOutputMsg98, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
            }
        }
        
        /* Analyze error code */
        if (!(goto_END)) {
            if ((0 == pInputMsg102.getSzCdStageOpen().compareTo(ADOPTION)) && (0 == pInputMsg102.getUlScrIdPrimChild())) {
                bAdoptNoSvc = true;
            }
            if (((0 != ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != FAD_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != pInputMsg102.getSzCdStageOpen().compareTo(SUBCARE)) && (0 != pInputMsg102.getSzCdStageOpen().compareTo(PREP_ADULT)) && (0 != pInputMsg102.getSzCdStageOpen().compareTo(AGE_OUT)) && (0 != pInputMsg102.getSzCdStageOpen().compareTo(POST_ADOPT))) && (0 != pInputMsg102.getSzCdStageOpen().compareTo(ADOPTION))) {
                CCMN87DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                CCMN87DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                CCMN87DI.setUlIdStage(pInputMsg102.getUlIdStage());
                CCMN87DI.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SERVICE_AUTH_TYPE);
                if ((0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) && (0 == pInputMsg102.getSzCdStage().compareTo(INVESTIGATION))) {
                    CCMN87DI.setSzCdTask(APS_SVC_AUTH_TASK);
                }
                else if ((0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) && (0 == pInputMsg102.getSzCdStage().compareTo(AGE_OUT))) {
                    CCMN87DI.setSzCdTask(AOC_SVC_AUTH_TASK);
                }
                
                //  Call DAM
                rc = Ccmn02u.CallCCMN87D(CCMN87DI, CCMN87DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                if (CCMN87DO.getArchOutputStruct().getUlRowQty() > 0) {
                    for (i85 = 0;i85 < CCMN87DO.getArchOutputStruct().getUlRowQty();i85++) {
                        if (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventType().compareTo(SERVICE_AUTH_TYPE)) {
                            CSES24DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CSES24DI.setUlIdSvcAuthEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                            rc = Ccmn02u.CallCSES24D(CSES24DI, CSES24DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CSES23DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CSES23DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                            rc = Ccmn02u.CallCSES23D(CSES23DI, CSES23DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            if (FND_YES == CSES23DO.getCIndSvcAuthComplete()) {
                                CLSS24DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                CLSS24DI.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                CLSS24DI.getArchInputStruct().setUlPageSizeNbr(CLSS24DO.get_CLSS24DO__ROWCLSS24DO_SIZE());
                                CLSS24DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                rc = Ccmn02u.CallCLSS24D(CLSS24DI, CLSS24DO, pServiceStatus);
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                
                                //  Loop through all the rows returned from this service
                                // and add a new event row. The new event row will
                                // be exactly the same as retrieved above except it will
                                // use the new IdStage, the CdEventTask will be the CdTask
                                // for Service Auth and the IdEvent will be new
                                for (m = 0;m < CLSS24DO.getArchOutputStruct().getUlRowQty();m++) {
                                    lRC5 = ARC_UTLCompareDateAndTime((FndInt3date) & DtToday, (char) 0, (FndInt3date) & CLSS24DO.getROWCLSS24DO_ARRAY().getROWCLSS24DO(m).getDtDtSvcAuthDtlTerm() , (char) 0);
                                    if (lRC5 < 0) {
                                        if (0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) {
                                            CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                            CCMN46DI.setSzCdEventStatus(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventStatus());
                                            CCMN46DI.setDtDtEventOccurred(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getDtDtEventOccurred());
                                            CCMN46DI.setSzTxtEventDescr(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzTxtEventDescr());
                                            CCMN46DI.setSzCdEventType(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventType());
                                            CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                                            if (0 == pInputMsg102.getSzCdStageOpen().compareTo(SUBCARE)) {
                                                CCMN46DI.setSzCdTask(SUBCARE_SVC_AUTH_TASK);
                                            }
                                            else if (0 == pInputMsg102.getSzCdStageOpen().compareTo(FSU_PROGRAM)) {
                                                CCMN46DI.setSzCdTask(FSU_SVC_AUTH_TASK);
                                            }
                                            else {
                                                CCMN46DI.setSzCdTask(UPDATE_SERVICE_AUTH_TASK);
                                            }
                                            
                                            //  Start performance timer for service. All performance functions always
                                            // return success so there is no need to check status.
                                            rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            
                                            
                                            CAUD34DI.setUlIdSvcAuthEvent(CCMN46DO.getUlIdEvent());
                                            
                                            CAUD34DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                            
                                            CAUD34DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                            rc = Ccmn02u.CallCAUD34D(CAUD34DI, CAUD34DO, pServiceStatus);
                                            
                                            //  SQL_NOT_FOUND is not acceptable since the period creates
                                            // a version upon saving the period
                                            
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            
                                            //##                    return (FND_SUCCESS); 
                                            CCMND2DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                            
                                            CCMND2DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                                            rc = Ccmn02u.CallCCMND2D(CCMND2DI, CCMND2DO, pServiceStatus);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            
                                            //  For each row retrieved from EventPersonLink we
                                            // need to make a copy of that with the new IdEvent
                                            for (n = 0;n < CCMND2DO.getArchOutputStruct().getUlRowQty();n++) {
                                                CCMN68DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                                CCMN68DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                CCMN68DI.setUlIdPerson(CCMND2DO.getROWCCMND2DO_ARRAY().getROWCCMND2DO(n).getUlIdPerson());
                                                CCMN68DI.setUlIdEvent(CCMN46DO.getUlIdEvent());
                                                
                                                //  Call CCMN06U
                                                rc = Ccmn01u.CallCCMN68D(CCMN68DI, CCMN68DO, pServiceStatus);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            }
                                            break;
                                        }
                                        else if (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventStatus().compareTo(STATUS_APPROVED)) {
                                            CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                            CCMN46DI.setSzCdEventStatus(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventStatus());
                                            CCMN46DI.setDtDtEventOccurred(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getDtDtEventOccurred());
                                            CCMN46DI.setSzTxtEventDescr(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzTxtEventDescr());
                                            CCMN46DI.setSzCdEventType(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventType());
                                            CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                                            if (0 == pInputMsg102.getSzCdStageOpen().compareTo(ADOPTION)) {
                                                CCMN46DI.setSzCdTask(ADO_SVC_AUTH_TASK);
                                            }
                                            else if (0 == pInputMsg102.getSzCdStageOpen().compareTo(FSU_PROGRAM)) {
                                                CCMN46DI.setSzCdTask(FSU_SVC_AUTH_TASK);
                                            }
                                            else if (0 == pInputMsg102.getSzCdStageOpen().compareTo(FPR_PROGRAM)) {
                                                CCMN46DI.setSzCdTask(FPR_SVC_AUTH_TASK);
                                            }
                                            else if (0 == pInputMsg102.getSzCdStageOpen().compareTo(FRE_PROGRAM)) {
                                                CCMN46DI.setSzCdTask(FRE_SVC_AUTH_TASK);
                                            }
                                            else {
                                                CCMN46DI.setSzCdTask(UPDATE_SERVICE_AUTH_TASK);
                                            }
                                            rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            CAUD34DI.setUlIdSvcAuthEvent(CCMN46DO.getUlIdEvent());
                                            CAUD34DI.setUlIdSvcAuth(CSES24DO.getUlIdSvcAuth());
                                            CAUD34DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                            rc = Ccmn02u.CallCAUD34D(CAUD34DI, CAUD34DO, pServiceStatus);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            CCMND2DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                            CCMND2DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                                            rc = Ccmn02u.CallCCMND2D(CCMND2DI, CCMND2DO, pServiceStatus);
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                                            
                                            //  For each row retrieved from EventPersonLink we
                                            // need to make a copy of that with the new IdEvent
                                            for (n = 0;n < CCMND2DO.getArchOutputStruct().getUlRowQty();n++) {
                                                CCMN68DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                                                CCMN68DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                CCMN68DI.setUlIdPerson(CCMND2DO.getROWCCMND2DO_ARRAY().getROWCCMND2DO(n).getUlIdPerson());
                                                CCMN68DI.setUlIdEvent(CCMN46DO.getUlIdEvent());
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
                }
            }
            
            // Analyze error code
            if (0 == pInputMsg102.getSzCdStage().compareTo(INTAKE)) {
                rc = CallCCMNE4D(pInputMsg102, CCMNE4DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                CCMNE5DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                
                for (i85 = 0;i85 < CCMNE4DO.getArchOutputStruct().getUlRowQty();++i85) {
                    CCMNE5DI.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                    CCMNE5DI.getArchInputStruct().setUlPageSizeNbr(CCMNE5DO.get_CCMNE5DO__ROWCCMNE5DO_SIZE());
                    CCMNE5DI.setUlIdPerson(CCMNE4DO.getROWCCMNE4DO_ARRAY().getROWCCMNE4DO(i85).getUlIdPerson());
                    CCMNE5DI.setUlIdCase(CINT21DO.getUlIdCase());
                    
                    do {
                        
                        //  SIR# 21916 Add Consitency Check between EA Questions,
                        // Safety Plan, and Risk Findings
                        rc = CallCCMNE5D(CCMNE5DI, CCMNE5DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        
                        for (m = 0;m < CCMNE5DO.getArchOutputStruct().getUlRowQty();++m) {
                            szTempString = CCMNE4DO.getROWCCMNE4DO_ARRAY().getROWCCMNE4DO(i85).getSzNmPersonFull();
                            szTempString += " is involved in Intake " + CINT21DO.getSzNmStage();
                            CCMN43DI.setSzTxtTodoDesc(szTempString CCMN43DI.setSzCdTodoType(ALERT_TODO));
                            CCMN43DI.setUlIdTodoPersAssigned(CCMNE5DO.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(m).getUlIdPerson());
                            CCMN43DI.setUlIdTodoPersWorker(CCMNE5DO.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(m).getUlIdPerson());
                            CCMN43DI.setDtDtTodoCreated(DtToday);
                            CCMN43DI.setDtDtTodoDue(DtToday);
                            CCMN43DI.setUlIdCase(CCMNE5DO.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(m).getUlIdCase());
                            CCMN43DI.setUlIdStage(CCMNE5DO.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(m).getUlIdStage());
                            CCMN43DI.setDtDtTodoCompleted(DtToday);
                            CCMN43DI.setDtDtTaskDue(NullDate);
                            CCMN43DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CCMN43DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            // end SIR# 21916
                            
                            //  SIR 13761 - Added Dam to do an Edit check for Marital
                            // Status and Ethnicity.
                            rc = CallCCMN43D(CCMN43DI, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                        }
                        CCMNE5DI.getArchInputStruct().getUsPageNbr()++;
                    }
                    while (CCMNE5DO.getArchOutputStruct().getBMoreDataInd() == true);
                }
            }
            
            // Analyze error code
            if ((0 == pInputMsg102.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) && (0 != ADMIN_REVIEW.compareTo(pInputMsg102.getSzCdStageOpen()))) {
                rc = CallCCMNH0D(pInputMsg102, CCMNH0DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                
                for (i85 = 0;i85 < CCMNH0DO.getArchOutputStruct().getUlRowQty();++i85) {
                    CCMNG7DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CCMNG7DI.setUlIdEvent(CCMNH0DO.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i85).getUlIdEvent());
                    CCMNG7DI.setTsLastUpdate(CCMNH0DO.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i85).getTsSysTsLastUpdate3());
                    CCMNG8DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CCMNG8DI.setUlIdEvent(CCMNH0DO.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i85).getUlIdEvent());
                    CCMNG8DI.setTsLastUpdate(CCMNH0DO.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i85).getTsSysTsLastUpdate2());
                    CCMNG9DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CCMNG9DI.setLdIdTodo(CCMNH0DO.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i85).getLdIdTodo());
                    CCMNG9DI.setTsLastUpdate(CCMNH0DO.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i85).getTsLastUpdate());
                    
                    // Analyze error code
                    if (0 == pInputMsg102.getSzCdStageOpen().compareTo(INVESTIGATION)) {
                        CCMNG7DI.setSzCdTask(APS_INT_TO_INV_TASK);
                        CCMNG9DI.setSzCdTask(APS_INT_TO_INV_TASK);
                    }
                    else if (0 == pInputMsg102.getSzCdStageOpen().compareTo(SERVICE_DELIVERY)) {
                        CCMNG7DI.setSzCdTask(APS_INV_TO_SVC_TASK);
                        
                        CCMNG9DI.setSzCdTask(APS_INV_TO_SVC_TASK);
                    }
                    CCMNG7DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    
                    CCMNG8DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CCMNG9DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    
                    
                    
                    CCMNG7DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    CCMNG8DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    CCMNG9DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    //  Set all TODOs associated with event to COMPLETED
                    rc = CallCCMNG7D(CCMNG7DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    //  Retrieve all the events associated with the Investigation
                    rc = CallCCMNG8D(CCMNG8DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    rc = CallCCMNG9D(CCMNG9DI, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
            }
            
            if ((0 == POST_ADOPT.compareTo(pInputMsg102.getSzCdStageOpen())) && (0 != INTAKE.compareTo(pInputMsg102.getSzCdStage()))) {
                
                //  We need to link the people from the FAD stage to the
                // new stage
                // We must use the rows retrieved above for the persons
                for (i85 = 0;i85 < CLSS63DO.getArchOutputStruct().getUlRowQty();i85++) {
                    CCMND3DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    CCMND3DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    CCMND3DI.setSzCdStagePersRelInt(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getSzCdStagePersRelInt());
                    CCMND3DI.setSzCdStagePersRole(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getSzCdStagePersRole());
                    CCMND3DI.setSzCdStagePersType(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getSzCdStagePersType());
                    CCMND3DI.setSzCdStagePersSearchInd(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getSzCdStagePersSearchInd());
                    CCMND3DI.setDtDtStagePersLink(DtToday);
                    CCMND3DI.setUlIdPerson(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getUlIdPerson());
                    CCMND3DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                    CCMND3DI.setBIndStagePersInLaw(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getBIndStagePersInLaw());
                    CCMND3DI.setBIndStagePersReporter(CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getBIndStagePersReporter());
                    
                    if (0 != CLSS63DO.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i85).getSzCdStagePersType().compareTo(STAFF)) {
                        rc = CallCCMND3D(CCMND3DI, CCMND3DO, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    }
                }
                CCMN87DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                CCMN87DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                CCMN87DI.setUlIdStage(pInputMsg102.getUlIdStage());
                
                CCMN87DI.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SUBSIDY_TYPE);
                CCMN87DI.setSzCdTask(ADOPTION_SUBSIDY_TASK);
                
                //  Call DAM
                rc = Ccmn02u.CallCCMN87D(CCMN87DI, CCMN87DO, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                if (CCMN87DO.getArchOutputStruct().getUlRowQty() > 0) {
                    //  If more than one row was returned, loop through
                    // all rows and retrieve the Adoption Subsidy
                    for (i85 = 0;i85 < CCMN87DO.getArchOutputStruct().getUlRowQty();i85++) {
                        if (0 == CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventStatus().compareTo(EVENT_STATUS_PROCESS)) 
                        {
                            CSES64DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CSES64DI.setUlIdEvent(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getUlIdEvent());
                            rc = CallCSES64D(CSES64DI, CSES64DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CCMN46DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CCMN46DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            CCMN46DI.setSzCdEventStatus(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventStatus());
                            CCMN46DI.setDtDtEventOccurred(DtToday);
                            CCMN46DI.setSzTxtEventDescr(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzTxtEventDescr());
                            CCMN46DI.setSzCdEventType(CCMN87DO.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i85).getSzCdEventType());
                            CCMN46DI.setUlIdStage(pOutputMsg98.getUlIdStage());
                            CCMN46DI.setSzCdTask(PAD_SUBSIDY_TASK);
                            rc = Ccmn01u.CallCCMN46D(CCMN46DI, CCMN46DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            CAUDB2DI.setArchInputStruct(pInputMsg102.getArchInputStruct());
                            CAUDB2DI.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                            CAUDB2DI.setUlIdEvent(CCMN46DO.getUlIdEvent());
                            CAUDB2DI.setUlIdAdptSub(CSES64DO.getUlIdAdptSub());
                            rc = CallCAUDB2D(CAUDB2DI, CAUDB2DO, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            
                            bClosePAD = 1;
                        }
                    }
                }
                
                
                
                else 
                {
                    bClosePAD = 0;
                }
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (!bClosePAD) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN02UInputRec = new CCMN02UI();
                    
                    pCCMN02UOutputRec = new CCMN02UO();
                    pCCMN02UInputRec.setArchInputStruct(pInputMsg102.getArchInputStruct());
                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(POST_ADOPT);
                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(CHILD_PROTECTIVE_SERVICES);
                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(POST_ADOPT);
                    pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(pOutputMsg98.getUlIdStage());
                    rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                            
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                            break;
                    }
                }
            }
        }
        return rc;
    }

    
    static int CallCINT21D(CCMN03UI pInputMsg103, CINT21DO pOutputMsg99, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINT21DInputRec.setArchInputStruct(pInputMsg103.getArchInputStruct());
        pCINT21DInputRec.setUlIdStage(pInputMsg103.getUlIdStage());
        /*
        ** There is not a Law Enforcement Notification ToDo, so the
        ** service can continue
        */
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg99.setSzCdStage(pCINT21DOutputRec.getSzCdStage());
                pOutputMsg99.setSzCdStageClassification(pCINT21DOutputRec.getSzCdStageClassification());
                pOutputMsg99.setSzCdStageCnty(pCINT21DOutputRec.getSzCdStageCnty());
                pOutputMsg99.setSzCdStageCurrPriority(pCINT21DOutputRec.getSzCdStageCurrPriority());
                pOutputMsg99.setSzCdStageInitialPriority(pCINT21DOutputRec.getSzCdStageInitialPriority());
                
                pOutputMsg99.setSzCdStageProgram(pCINT21DOutputRec.getSzCdStageProgram());
                
                pOutputMsg99.setSzCdStageReasonClosed(pCINT21DOutputRec.getSzCdStageReasonClosed());
                
                pOutputMsg99.setSzCdStageRegion(pCINT21DOutputRec.getSzCdStageRegion());
                pOutputMsg99.setSzCdStageRsnPriorityChgd(pCINT21DOutputRec.getSzCdStageRsnPriorityChgd());
                pOutputMsg99.setSzCdStageType(pCINT21DOutputRec.getSzCdStageType());
                pOutputMsg99.setSzTxtStagePriorityCmnts(pCINT21DOutputRec.getSzTxtStagePriorityCmnts());
                pOutputMsg99.setSzTxtStageClosureCmnts(pCINT21DOutputRec.getSzTxtStageClosureCmnts());
                pOutputMsg99.setSzNmStage(pCINT21DOutputRec.getSzNmStage());
                pOutputMsg99.setDtDtStageClose(pCINT21DOutputRec.getDtDtStageClose());
                pOutputMsg99.setDtDtStageStart(pCINT21DOutputRec.getDtDtStageStart());
                pOutputMsg99.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
                pOutputMsg99.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                pOutputMsg99.setUlIdStage(pCINT21DOutputRec.getUlIdStage());
                pOutputMsg99.setUlIdUnit(pCINT21DOutputRec.getUlIdUnit());
                pOutputMsg99.setBIndStageClose(pCINT21DOutputRec.getBIndStageClose());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    
    static int CallCCMND4D(CCMN03UI pInputMsg104, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMND4DInputRec.setArchInputStruct(pInputMsg104.getArchInputStruct());
        pCCMND4DInputRec.setUlIdStage(pInputMsg104.getUlIdStage());
        pCCMND4DInputRec.setSzCdStageReasonClosed(pInputMsg104.getSzCdStageReasonClosed());
        rc = ARC_UTLGetDateAndTime(pCCMND4DInputRec.getDtDtStageClose() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        rc = ccmnd4dAUDdam(sqlca, pCCMND4DInputRec, pCCMND4DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    
    static int CallCCMNG2D(CCMN03UI pInputMsg105, CCMNG2DO pOutputMsg100, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
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
        pCCMNG2DInputRec.setArchInputStruct(pInputMsg105.getArchInputStruct());
        pCCMNG2DInputRec.setUlIdStage(pInputMsg105.getUlIdStage());
        rc = ccmng2dQUERYdam(sqlca, pCCMNG2DInputRec, pCCMNG2DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg100.setSzCdStagePersRelInt(pCCMNG2DOutputRec.getSzCdStagePersRelInt());
                pOutputMsg100.setSzCdStagePersRole(pCCMNG2DOutputRec.getSzCdStagePersRole());
                pOutputMsg100.setSzCdStagePersSearchInd(pCCMNG2DOutputRec.getSzCdStagePersSearchInd());
                pOutputMsg100.setSzCdStagePersType(pCCMNG2DOutputRec.getSzCdStagePersType());
                pOutputMsg100.setSzTxtStagePersNotes(pCCMNG2DOutputRec.getSzTxtStagePersNotes());
                pOutputMsg100.setUlIdPerson(pCCMNG2DOutputRec.getUlIdPerson());
                pOutputMsg100.setUlIdStagePerson(pCCMNG2DOutputRec.getUlIdStagePerson());
                pOutputMsg100.setBIndStagePersInLaw(pCCMNG2DOutputRec.getBIndStagePersInLaw());
                pOutputMsg100.setBIndStagePersReporter(pCCMNG2DOutputRec.getBIndStagePersReporter());
                pOutputMsg100.setBIndStagePersEmpNew(pCCMNG2DOutputRec.getBIndStagePersEmpNew());
                pOutputMsg100.setUlIdStage(pCCMNG2DOutputRec.getUlIdStage());
                pOutputMsg100.setDtDtStagePersLink(pCCMNG2DOutputRec.getDtDtStagePersLink());
                pOutputMsg100.setTsLastUpdate(pCCMNG2DOutputRec.getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMND3D(CCMND3DI pInputMsg106, CCMND3DO pOutputMsg101, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
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
        pCCMND3DInputRec.setArchInputStruct(pInputMsg106.getArchInputStruct());
        pCCMND3DInputRec.setUlIdStage(pInputMsg106.getUlIdStage());
        
        if (pInputMsg106.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE || pInputMsg106.getArchInputStruct().getCReqFuncCd() == ServiceConstants.REQ_FUNC_CD_ADD) {
            
            pCCMND3DInputRec.setSzCdStagePersRelInt(pInputMsg106.getSzCdStagePersRelInt());
            pCCMND3DInputRec.setSzCdStagePersRole(pInputMsg106.getSzCdStagePersRole());
            pCCMND3DInputRec.setSzCdStagePersSearchInd(pInputMsg106.getSzCdStagePersSearchInd());
            pCCMND3DInputRec.setSzCdStagePersType(pInputMsg106.getSzCdStagePersType());
            pCCMND3DInputRec.setSzTxtStagePersNotes(pInputMsg106.getSzTxtStagePersNotes());
            pCCMND3DInputRec.setUlIdPerson(pInputMsg106.getUlIdPerson());
            pCCMND3DInputRec.setUlIdStagePerson(pInputMsg106.getUlIdStagePerson());
            pCCMND3DInputRec.setBIndStagePersInLaw(pInputMsg106.getBIndStagePersInLaw());
            pCCMND3DInputRec.setBIndStagePersReporter(pInputMsg106.getBIndStagePersReporter());
            pCCMND3DInputRec.setBIndStagePersEmpNew(pInputMsg106.getBIndStagePersEmpNew());
            pCCMND3DInputRec.setUlIdStage(pInputMsg106.getUlIdStage());
            pCCMND3DInputRec.setDtDtStagePersLink(pInputMsg106.getDtDtStagePersLink());
            pCCMND3DInputRec.setTsLastUpdate(pInputMsg106.getTsLastUpdate());
        }
        rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
        if (pCCMND3DInputRec.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE || pCCMND3DInputRec.getArchInputStruct().getCReqFuncCd() == ServiceConstants.REQ_FUNC_CD_ADD) {
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pOutputMsg101.setTsLastUpdate(pCCMND3DOutputRec.getTsLastUpdate());
                    
                    //  Start Performance Timer
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case ASSIGN_ERROR:
                    
                    if (0 == pInputMsg106.getSzCdStagePersRole().compareTo(PRIMARY_ROLE_STAGE_OPEN)) {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CANT_ASSIGN_WORKER;
                        rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                        break;
                    }
                    else {
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                    }
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
            }
        }
        else if (pCCMND3DInputRec.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    
                    //  Call CSEC10D - performs current date check
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
            }
        }
        return rc;
    }

    static int CallCCMNB8D(CCMN03UI pInputMsg107, CCMNB8DO pOutputMsg102, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i86 = 0;
        
        CCMNB8DI pCCMNB8DInputRec = null;
        CCMNB8DO pCCMNB8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB8DInputRec = new CCMNB8DI();
        
        pCCMNB8DOutputRec = new CCMNB8DO();
        pCCMNB8DInputRec.setArchInputStruct(pInputMsg107.getArchInputStruct());
        pCCMNB8DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB8DO._CCMNB8DO__ROWCCMNB8DO_SIZE);
        
        if (pInputMsg107.getArchInputStruct().getCReqFuncCd() == STAGE_PROG_NEW_STAGE) {
            pCCMNB8DInputRec.setSzCdStage(pInputMsg107.getSzCdStageOpen());
        }
        else if (pInputMsg107.getArchInputStruct().getCReqFuncCd() == STAGE_PROG_OLD_STAGE) {
            pCCMNB8DInputRec.setSzCdStage(pInputMsg107.getSzCdStage());
        }
        else {
            rc = Messages.ARC_ERR_BAD_FUNC_CD;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCCMNB8DInputRec.setSzCdStageProgram(pInputMsg107.getSzCdStageProgram());
        
        /* There should always be an ID EVENT on the
        ** Event table which the Risk Assessment
        ** window should obtain,  If the time
        ** stamp is not received, then an error occurred
        */
        pCCMNB8DInputRec.setSzCdStageReasonClosed(pInputMsg107.getSzCdStageReasonClosed());
        if ((pInputMsg107.getArchInputStruct().getCReqFuncCd() == STAGE_PROG_NEW_STAGE) && (0 == POST_ADOPT.compareTo(pCCMNB8DInputRec.getSzCdStage()))) {
            
            pCCMNB8DInputRec.setSzCdStageReasonClosed(ADOPTION);
        }
        
        /*
        ** Call DAM
        */
        rc = ccmnb8dQUERYdam(sqlca, pCCMNB8DInputRec, pCCMNB8DOutputRec);
        switch (rc) {
                
                // SIR 2284: handle error where user tries to delete
                // VID for primary addr record of contracted resource
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i86 = 0;i86 < pCCMNB8DOutputRec.getArchOutputStruct().getUlRowQty();++i86) {
                    
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzCdStageProgStage(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzCdStageProgStage());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzCdStageProgRsnClosed(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzCdStageProgRsnClosed());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSCdStageProgProgram(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSCdStageProgProgram());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setBIndStageProgClose(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getBIndStageProgClose());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzCdStageProgOpen(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzCdStageProgOpen());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzCdStageProgEventType(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzCdStageProgEventType());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzCdStageProgStatus(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzCdStageProgStatus());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzTxtStageProgEvntDesc(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzTxtStageProgEvntDesc());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSCdStageProgStageType(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSCdStageProgStageType());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzCdStageProgTask(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzCdStageProgTask());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setUlNbrStageProgDaysDue(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getUlNbrStageProgDaysDue());
                    
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzTxtStageProgTodoDesc(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzTxtStageProgTodoDesc());
                    pOutputMsg102.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).setSzCdStageProgTodoInfo(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(i86).getSzCdStageProgTodoInfo());
                }
                pOutputMsg102.getArchOutputStruct().setUlRowQty(pCCMNB8DOutputRec.getArchOutputStruct().getUlRowQty());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN46D(CCMN46DI pInputMsg108, CCMN46DO pOutputMsg103, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMN46DInputRec.setArchInputStruct(pInputMsg108.getArchInputStruct());
        pCCMN46DInputRec.setDtDtEventOccurred(pInputMsg108.getDtDtEventOccurred());
        pCCMN46DInputRec.setUlIdStage(pInputMsg108.getUlIdStage());
        pCCMN46DInputRec.setUlIdPerson(pInputMsg108.getUlIdPerson());
        pCCMN46DInputRec.setUlIdEvent(pInputMsg108.getUlIdEvent());
        pCCMN46DInputRec.setSzTxtEventDescr(pInputMsg108.getSzTxtEventDescr());
        pCCMN46DInputRec.setSzCdEventStatus(pInputMsg108.getSzCdEventStatus());
        pCCMN46DInputRec.setSzCdTask(pInputMsg108.getSzCdTask());
        pCCMN46DInputRec.setSzCdEventType(pInputMsg108.getSzCdEventType());
        pCCMN46DInputRec.setTsLastUpdate(pInputMsg108.getTsLastUpdate());
        if (0 == pInputMsg108.getSzCdEventType().compareTo(SERVICE_AUTH_TYPE)) {
            pCCMN46DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            if (0 == pInputMsg108.getSzCdEventStatus().compareTo(EVENT_STATUS_PEND)) {
                
                // 
                // Function Prototypes
                // 
                pCCMN46DInputRec.setSzCdEventStatus(STATUS_COMPLETE);
            }
        }
        rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
        
        
        /*
        ** Analyze return code
        ** LRB switch
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg103.setUlIdEvent(pCCMN46DOutputRec.getUlIdEvent());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINT12D(CINT12DI pInputMsg109, CCMN03UO pOutputMsg104, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CINT12DI pCINT12DInputRec = null;
        CINT12DO pCINT12DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT12DInputRec = new CINT12DI();
        
        pCINT12DOutputRec = new CINT12DO();
        pCINT12DInputRec.setArchInputStruct(pInputMsg109.getArchInputStruct());
        pCINT12DInputRec.setSzCdStage(pInputMsg109.getSzCdStage());
        pCINT12DInputRec.setSzCdStageClassification(pInputMsg109.getSzCdStageClassification());
        pCINT12DInputRec.setSzCdStageCnty(pInputMsg109.getSzCdStageCnty());
        pCINT12DInputRec.setSzCdStageCurrPriority(pInputMsg109.getSzCdStageCurrPriority());
        pCINT12DInputRec.setSzCdStageInitialPriority(pInputMsg109.getSzCdStageInitialPriority());
        pCINT12DInputRec.setSzCdStageProgram(pInputMsg109.getSzCdStageProgram());
        pCINT12DInputRec.setSzCdStageRegion(pInputMsg109.getSzCdStageRegion());
        pCINT12DInputRec.setUlIdUnit(pInputMsg109.getUlIdUnit());
        pCINT12DInputRec.setSzCdStageType(pInputMsg109.getSzCdStageType());
        pCINT12DInputRec.setDtDtStageStart(pInputMsg109.getDtDtStageStart());
        
        pCINT12DInputRec.setDtDtStageClose(pInputMsg109.getDtDtStageClose());
        
        pCINT12DInputRec.setUlIdCase(pInputMsg109.getUlIdCase());
        pCINT12DInputRec.setUlIdSituation(pInputMsg109.getUlIdSituation());
        pCINT12DInputRec.setSzNmStage(pInputMsg109.getSzNmStage());
        
        
        /*
        ** Call CCMN43D
        */
        rc = cint12dAUDdam(sqlca, pCINT12DInputRec, pCINT12DOutputRec);
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg104.setUlIdStage(pCINT12DOutputRec.getUlIdStage());
                pOutputMsg104.setTsSysTsLastUpdate2(pCINT12DOutputRec.getTsLastUpdate());
                
                
                //  Call CCMN43D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINT19D(CCMN03UI pInputMsg110, CINT19DO pOutputMsg105, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i87 = 0;
        /*
        ** Declare local variables
        */
        CINT19DI pCINT19DInputRec = null;
        CINT19DO pCINT19DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT19DInputRec = new CINT19DI();
        
        pCINT19DOutputRec = new CINT19DO();
        pCINT19DInputRec.setArchInputStruct(pInputMsg110.getArchInputStruct());
        pCINT19DInputRec.setUlIdStage(pInputMsg110.getUlIdStage());
        /*
        ** if the return code (rc) of the call to the ccmn79dQUERYdam
        ** was successful, it means that we have a valid ulIdOnCall
        ** which needs to be passed to the next dam (28d).
        ** In order to pass this ulIdOnCall to the 28d dam,
        ** set the rc variable = ARC_SUCCESS and
        ** set the *tempulIdOnCall = the ulIdOnCall.
        */
        rc = cint19dQUERYdam(sqlca, pCINT19DInputRec, pCINT19DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i87 = 0;i87 < pCINT19DOutputRec.getArchOutputStruct().getUlRowQty();++i87) {
                    pOutputMsg105.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).setUlIdAllegation(pCINT19DOutputRec.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).getUlIdAllegation());
                    pOutputMsg105.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).setSzCdIntakeAllegType(pCINT19DOutputRec.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).getSzCdIntakeAllegType());
                    pOutputMsg105.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).setCTxtIntakeAllegDuration(pCINT19DOutputRec.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).getCTxtIntakeAllegDuration());
                    pOutputMsg105.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).setUlIdVictim(pCINT19DOutputRec.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).getUlIdVictim());
                    pOutputMsg105.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).setUlIdAllegedPerpetrator(pCINT19DOutputRec.getROWCINT19DO_ARRAY().getROWCINT19DO(i87).getUlIdAllegedPerpetrator());
                }
                pOutputMsg105.getArchOutputStruct().setUlRowQty(pCINT19DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg105.getArchOutputStruct().setBMoreDataInd(pCINT19DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                pOutputMsg105.getArchOutputStruct().setUlRowQty(0);
                pOutputMsg105.getArchOutputStruct().setBMoreDataInd(pCINT19DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV07D(CINV07DI pInputMsg111, CINV07DO pOutputMsg106, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        
        CINV07DI pCINV07DInputRec = null;
        CINV07DO pCINV07DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV07DInputRec = new CINV07DI();
        
        pCINV07DOutputRec = new CINV07DO();
        pCINV07DInputRec.setArchInputStruct(pInputMsg111.getArchInputStruct());
        pCINV07DInputRec.setSzCdAllegIncidentStage(pInputMsg111.getSzCdAllegIncidentStage());
        pCINV07DInputRec.setSzCdAllegType(pInputMsg111.getSzCdAllegType());
        pCINV07DInputRec.setUlIdAllegedPerpetrator(pInputMsg111.getUlIdAllegedPerpetrator());
        pCINV07DInputRec.setUlIdStage(pInputMsg111.getUlIdStage());
        pCINV07DInputRec.setUlIdVictim(pInputMsg111.getUlIdVictim());
        pCINV07DInputRec.setSzTxtAllegDuration(pInputMsg111.getSzTxtAllegDuration());
        rc = cinv07dAUDdam(sqlca, pCINV07DInputRec, pCINV07DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg106.setUlIdAllegation(pCINV07DOutputRec.getUlIdAllegation());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV24D(CINV24DI pInputMsg112, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV24DI pCINV24DInputRec = null;
        CINV24DO pCINV24DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV24DInputRec = new CINV24DI();
        
        pCINV24DOutputRec = new CINV24DO();
        pCINV24DInputRec.setArchInputStruct(pInputMsg112.getArchInputStruct());
        pCINV24DInputRec.setUlIdStage(pInputMsg112.getUlIdStage());
        pCINV24DInputRec.setUlIdEvent(pInputMsg112.getUlIdEvent());
        pCINV24DInputRec.setDtDtApsInvstBegun(pInputMsg112.getDtDtApsInvstBegun());
        pCINV24DInputRec.setDtDtApsInvstCltAssmt(pInputMsg112.getDtDtApsInvstCltAssmt());
        pCINV24DInputRec.setDtDtApsInvstCmplt(pInputMsg112.getDtDtApsInvstCmplt());
        rc = cinv24dAUDdam(sqlca, pCINV24DInputRec, pCINV24DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV12D(CINV12DI pInputMsg113, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV12DI pCINV12DInputRec = null;
        CINV12DO pCINV12DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV12DInputRec = new CINV12DI();
        
        pCINV12DOutputRec = new CINV12DO();
        pCINV12DInputRec.setArchInputStruct(pInputMsg113.getArchInputStruct());
        pCINV12DInputRec.setUlIdStage(pInputMsg113.getUlIdStage());
        pCINV12DInputRec.setUlIdEvent(pInputMsg113.getUlIdEvent());
        pCINV12DInputRec.setDtDtCPSInvstDtlIntake(pInputMsg113.getDtDtCPSInvstDtlIntake());
        pCINV12DInputRec.setDtDtCPSInvstDtlBegun(pInputMsg113.getDtDtCPSInvstDtlBegun());
        pCINV12DInputRec.setDtDtCPSInvstDtlAssigned(pInputMsg113.getDtDtCPSInvstDtlAssigned());
        pCINV12DInputRec.setDtDtCpsInvstDtlComplt(pInputMsg113.getDtDtCpsInvstDtlComplt());
        
        rc = cinv12dAUDdam(sqlca, pCINV12DInputRec, pCINV12DOutputRec);
        
        /*
        ** Analyze return code
        */
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  retrieve all Service Authorization events for a particular
                // IdEvent
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV53D(CINV53DI pInputMsg114, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV53DI pCINV53DInputRec = null;
        CINV53DO pCINV53DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV53DInputRec = new CINV53DI();
        
        pCINV53DOutputRec = new CINV53DO();
        pCINV53DInputRec.setArchInputStruct(pInputMsg114.getArchInputStruct());
        pCINV53DInputRec.setUlIdStage(pInputMsg114.getUlIdStage());
        pCINV53DInputRec.setUlIdEvent(pInputMsg114.getUlIdEvent());
        pCINV53DInputRec.setDtDtLicngInvstDtlBegun(pInputMsg114.getDtDtLicngInvstDtlBegun());
        pCINV53DInputRec.setDtDtLicngInvstIntake(pInputMsg114.getDtDtLicngInvstIntake());
        pCINV53DInputRec.setDtDtLicngInvstAssigned(pInputMsg114.getDtDtLicngInvstAssigned());
        pCINV53DInputRec.setDtDtLicngInvstComplt(pInputMsg114.getDtDtLicngInvstComplt());
        rc = cinv53dAUDdam(sqlca, pCINV53DInputRec, pCINV53DOutputRec);
        
        /*
        ** Analyze error code
        */
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:// Resource Retrieve
                
                //  Call CAUD17D.  The Contract Service AUD performs a full row
                // insert to the Contract Service table.
                rc = WtcHelperConstants.ARC_SUCCESS;
                //  Do nothing, the output message just returns success or
                // failure.
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV54D(CINV54DI pInputMsg115, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV54DI pCINV54DInputRec = null;
        CINV54DO pCINV54DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV54DInputRec = new CINV54DI();
        
        pCINV54DOutputRec = new CINV54DO();
        pCINV54DInputRec.setArchInputStruct(pInputMsg115.getArchInputStruct());
        pCINV54DInputRec.setUlIdStage(pInputMsg115.getUlIdStage());
        pCINV54DInputRec.setUlIdEvent(pInputMsg115.getUlIdEvent());
        pCINV54DInputRec.setDtDtFacilInvstBegun(pInputMsg115.getDtDtFacilInvstBegun());
        pCINV54DInputRec.setDtDtFacilInvstIntake(pInputMsg115.getDtDtFacilInvstIntake());
        pCINV54DInputRec.setTmSysTmFacilInvstInt(pInputMsg115.getTmSysTmFacilInvstInt());
        pCINV54DInputRec.setDtDtFacilInvstIncident(pInputMsg115.getDtDtFacilInvstIncident());
        pCINV54DInputRec.setDtDtFacilInvstComplt(pInputMsg115.getDtDtFacilInvstComplt());
        rc = cinv54dAUDdam(sqlca, pCINV54DInputRec, pCINV54DOutputRec);
        
        
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

    
    static int CallCCMNB9D(CCMN03UI pInputMsg116, CCMNB9DO pOutputMsg107, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/*Return Code*/
        int i88 = 0;
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
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            //## BEGIN TUX/XML: Declare XML variables 
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCCMNB9DInputRec.setArchInputStruct(pInputMsg116.getArchInputStruct());
        pCCMNB9DInputRec.setUlIdStage(pInputMsg116.getUlIdStage());
        rc = ccmnb9dQUERYdam(sqlca, pCCMNB9DInputRec, pCCMNB9DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i88 = 0;i88 < pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty();++i88) {
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setSzCdStagePersRelInt(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getSzCdStagePersRelInt());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setSzCdStagePersRole(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getSzCdStagePersRole());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setSzCdStagePersSearchInd(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getSzCdStagePersSearchInd());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setSzCdStagePersType(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getSzCdStagePersType());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setSzTxtStagePersNotes(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getSzTxtStagePersNotes());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setUlIdPerson(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getUlIdPerson());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setUlIdStagePerson(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getUlIdStagePerson());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setBIndStagePersInLaw(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getBIndStagePersInLaw());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setBIndStagePersReporter(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getBIndStagePersReporter());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setBIndStagePersEmpNew(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getBIndStagePersEmpNew());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setUlIdStage(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getUlIdStage());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setDtDtStagePersLink(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getDtDtStagePersLink());
                    pOutputMsg107.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).setTsLastUpdate(pCCMNB9DOutputRec.getROWCCMNB9DO_ARRAY().getROWCCMNB9DO(i88).getTsLastUpdate());
                }
                pOutputMsg107.getArchOutputStruct().setUlRowQty(pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg107.getArchOutputStruct().setBMoreDataInd(pCCMNB9DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pOutputMsg107.getArchOutputStruct().setUlRowQty(pCCMNB9DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg107.getArchOutputStruct().setBMoreDataInd(pCCMNB9DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMN43D(CCMN43DI pInputMsg117, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN43DInputRec = new CCMN43DI();
        
        pCCMN43DOutputRec = new CCMN43DO();
        pCCMN43DInputRec.setArchInputStruct(pInputMsg117.getArchInputStruct());
        pCCMN43DInputRec.setSzCdTodoTask(pInputMsg117.getSzCdTodoTask());
        pCCMN43DInputRec.setSzCdTodoType(pInputMsg117.getSzCdTodoType());
        pCCMN43DInputRec.setDtDtTodoCreated(pInputMsg117.getDtDtTodoCreated());
        pCCMN43DInputRec.setDtDtTodoDue(pInputMsg117.getDtDtTodoDue());
        pCCMN43DInputRec.setDtDtTaskDue(pInputMsg117.getDtDtTaskDue());
        pCCMN43DInputRec.setDtDtTodoCompleted(pInputMsg117.getDtDtTodoCompleted());
        pCCMN43DInputRec.setUlIdCase(pInputMsg117.getUlIdCase());
        pCCMN43DInputRec.setUlIdEvent(pInputMsg117.getUlIdEvent());
        pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg117.getUlIdTodoPersAssigned());
        pCCMN43DInputRec.setUlIdTodoPersCreator(pInputMsg117.getUlIdTodoPersCreator());
        pCCMN43DInputRec.setUlIdTodoPersWorker(pInputMsg117.getUlIdTodoPersWorker());
        pCCMN43DInputRec.setUlIdStage(pInputMsg117.getUlIdStage());
        pCCMN43DInputRec.setSzTxtTodoDesc(pInputMsg117.getSzTxtTodoDesc());
        pCCMN43DInputRec.setTxtTodoLongDesc(pInputMsg117.getTxtTodoLongDesc());
        rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNC1D(CCMNC1DI pInputMsg118, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMNC1DI pCCMNC1DInputRec = null;
        CCMNC1DO pCCMNC1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC1DInputRec = new CCMNC1DI();
        
        pCCMNC1DOutputRec = new CCMNC1DO();
        pCCMNC1DInputRec.setArchInputStruct(pInputMsg118.getArchInputStruct());
        pCCMNC1DInputRec.setUlIdPriorStage(pInputMsg118.getUlIdPriorStage());
        pCCMNC1DInputRec.setUlIdStage(pInputMsg118.getUlIdStage());
        rc = ccmnc1dAUDdam(sqlca, pCCMNC1DInputRec, pCCMNC1DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMNE4D(CCMN03UI pInputMsg119, CCMNE4DO pOutputMsg108, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i89 = 0;
        /*
        ** Declare local variables
        */
        CCMNE4DI pCCMNE4DInputRec = null;
        CCMNE4DO pCCMNE4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE4DInputRec = new CCMNE4DI();
        
        pCCMNE4DOutputRec = new CCMNE4DO();
        pCCMNE4DInputRec.setArchInputStruct(pInputMsg119.getArchInputStruct());
        pCCMNE4DInputRec.setUlIdStage(pInputMsg119.getUlIdStage());
        pCCMNE4DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNE4DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNE4DO._CCMNE4DO__ROWCCMNE4DO_SIZE);
        
        /*
        ** Call CCMND9D
        */
        rc = ccmne4dQUERYdam(sqlca, pCCMNE4DInputRec, pCCMNE4DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i89 = 0;i89 < pCCMNE4DOutputRec.getArchOutputStruct().getUlRowQty();++i89) {
                    pOutputMsg108.getROWCCMNE4DO_ARRAY().getROWCCMNE4DO(i89).setSzNmPersonFull(pCCMNE4DOutputRec.getROWCCMNE4DO_ARRAY().getROWCCMNE4DO(i89).getSzNmPersonFull());
                    pOutputMsg108.getROWCCMNE4DO_ARRAY().getROWCCMNE4DO(i89).setUlIdPerson(pCCMNE4DOutputRec.getROWCCMNE4DO_ARRAY().getROWCCMNE4DO(i89).getUlIdPerson());
                }
                pOutputMsg108.getArchOutputStruct().setUlRowQty(pCCMNE4DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg108.getArchOutputStruct().setBMoreDataInd(pCCMNE4DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                
                //  Call CLSC59D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNE5D(CCMNE5DI pInputMsg120, CCMNE5DO pOutputMsg109, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i90 = 0;
        /*
        ** Declare local variables
        */
        CCMNE5DI pCCMNE5DInputRec = null;
        CCMNE5DO pCCMNE5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE5DInputRec = new CCMNE5DI();
        
        pCCMNE5DOutputRec = new CCMNE5DO();
        pCCMNE5DInputRec.setArchInputStruct(pInputMsg120.getArchInputStruct());
        pCCMNE5DInputRec.setUlIdPerson(pInputMsg120.getUlIdPerson());
        pCCMNE5DInputRec.setUlIdCase(pInputMsg120.getUlIdCase());
        
        
        /*
        ** Call CSES69D
        */
        rc = ccmne5dQUERYdam(sqlca, pCCMNE5DInputRec, pCCMNE5DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i90 = 0;i90 < pCCMNE5DOutputRec.getArchOutputStruct().getUlRowQty();++i90) {
                    pOutputMsg109.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(i90).setUlIdPerson(pCCMNE5DOutputRec.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(i90).getUlIdPerson());
                    pOutputMsg109.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(i90).setUlIdStage(pCCMNE5DOutputRec.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(i90).getUlIdStage());
                    pOutputMsg109.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(i90).setUlIdCase(pCCMNE5DOutputRec.getROWCCMNE5DO_ARRAY().getROWCCMNE5DO(i90).getUlIdCase());
                }
                
                
                //  The Adoptive or Non PRS placement does not
                // have a legal status of Adoption Consumated
                // so we should increment the placement
                // counter
                
                pOutputMsg109.getArchOutputStruct().setUlRowQty(pCCMNE5DOutputRec.getArchOutputStruct().getUlRowQty());
                
                pOutputMsg109.getArchOutputStruct().setBMoreDataInd(pCCMNE5DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg109.getArchOutputStruct().setUlRowQty(pCCMNE5DOutputRec.getArchOutputStruct().getUlRowQty());
                
                
                pOutputMsg109.getArchOutputStruct().setBMoreDataInd(pCCMNE5DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCAUDE8D(CAUDE8DI pInputMsg121, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CAUDE8DI pCAUDE8DInputRec = null;
        CAUDE8DO pCAUDE8DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDE8DInputRec = new CAUDE8DI();
        
        pCAUDE8DOutputRec = new CAUDE8DO();
        pCAUDE8DInputRec.setArchInputStruct(pInputMsg121.getArchInputStruct());
        pCAUDE8DInputRec.setUlIdEvent(pInputMsg121.getUlIdEvent());
        pCAUDE8DInputRec.setCIndImpactCreated(pInputMsg121.getCIndImpactCreated());
        rc = caude8dAUDdam(sqlca, pCAUDE8DInputRec, pCAUDE8DOutputRec);
        
        /*
        ** Analyze error code
        */
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCSYS07D(CSYS07DI pInputMsg122, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSYS07DI pCSYS07DInputRec = null;
        CSYS07DO pCSYS07DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS07DInputRec = new CSYS07DI();
        
        pCSYS07DOutputRec = new CSYS07DO();
        pCSYS07DInputRec.setArchInputStruct(pInputMsg122.getArchInputStruct());
        pCSYS07DInputRec.setUlIdEvent(pInputMsg122.getUlIdEvent());
        pCSYS07DInputRec.setUlIdStage(pInputMsg122.getUlIdStage());
        /* Process utility function failure */
        pCSYS07DInputRec.setUlIdPerson(pInputMsg122.getUlIdPerson());
        pCSYS07DInputRec.setSzCdContactLocation(pInputMsg122.getSzCdContactLocation());
        pCSYS07DInputRec.setSzCdContactMethod(pInputMsg122.getSzCdContactMethod());
        pCSYS07DInputRec.setSzCdContactOthers(pInputMsg122.getSzCdContactOthers());
        pCSYS07DInputRec.setSzCdContactPurpose(pInputMsg122.getSzCdContactPurpose());
        pCSYS07DInputRec.setSzCdContactType(pInputMsg122.getSzCdContactType());
        pCSYS07DInputRec.setBIndContactAttempted(pInputMsg122.getBIndContactAttempted());
        pCSYS07DInputRec.setDtDtMonthlySummBegin(pInputMsg122.getDtDtMonthlySummBegin());
        pCSYS07DInputRec.setDtDtMonthlySummEnd(pInputMsg122.getDtDtMonthlySummEnd());
        
        pCSYS07DInputRec.setDtDTContactOccurred(pInputMsg122.getDtDTContactOccurred());
        
        rc = csys07dAUDdam(sqlca, pCSYS07DInputRec, pCSYS07DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                //## BEGIN TUX/XML: Declare XML variables
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMNF6D(CCMNF6DI pInputMsg123, CCMNF6DO pOutputMsg110, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i91 = 0;
        int rc = 0;/* Return code  */
        
        CCMNF6DI pCCMNF6DInputRec = null;
        CCMNF6DO pCCMNF6DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF6DInputRec = new CCMNF6DI();
        
        pCCMNF6DOutputRec = new CCMNF6DO();
        pCCMNF6DInputRec.setArchInputStruct(pInputMsg123.getArchInputStruct());
        pCCMNF6DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMNF6DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNF6DO._CCMNF6DO__ROWCCMNF6DO_SIZE);
        pCCMNF6DInputRec.setUlIdCase(pInputMsg123.getUlIdCase());
        
        
        /*
        ** Declare local variables 
        */
        /*
        ** Start performance timer for service 
        */
        rc = ccmnf6dQUERYdam(sqlca, pCCMNF6DInputRec, pCCMNF6DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i91 = 0;i91 < pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty();++i91) {
                    pOutputMsg110.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i91).setUlIdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i91).getUlIdStage());
                    pOutputMsg110.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i91).setSzCdStage(pCCMNF6DOutputRec.getROWCCMNF6DO_ARRAY().getROWCCMNF6DO(i91).getSzCdStage());
                }
                pOutputMsg110.getArchOutputStruct().setUlRowQty(pCCMNF6DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg110.getArchOutputStruct().setUlRowQty(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN87D(CCMN87DI pInputMsg124, CCMN87DO pOutputMsg111, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i92 = 0;
        int rc = 0;/* Return code */
        
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg124.getArchInputStruct());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN87DO._CCMN87DO__ROWCCMN87DO_SIZE);
        pCCMN87DInputRec.setUlIdStage(pInputMsg124.getUlIdStage());
        pCCMN87DInputRec.setSzCdTask(pInputMsg124.getSzCdTask());
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i92 = 0;i92 < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();++i92) {
                    pOutputMsg111.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).getUlIdEvent());
                    pOutputMsg111.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).setSzCdEventType(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).getSzCdEventType());
                    pOutputMsg111.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).setSzCdTask(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).getSzCdTask());
                    pOutputMsg111.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).setSzTxtEventDescr(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).getSzTxtEventDescr());
                    pOutputMsg111.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).setDtDtEventOccurred(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).getDtDtEventOccurred());
                    pOutputMsg111.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(i92).getSzCdEventStatus());
                }
                pOutputMsg111.getArchOutputStruct().setUlRowQty(pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty());
                
                pOutputMsg111.getArchOutputStruct().setBMoreDataInd(pCCMN87DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                
                //## BEGIN TUX/XML: Declare XML variables 
                pOutputMsg111.getArchOutputStruct().setUlRowQty(0);
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                //  do nothing
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                // 
                // End Call to Stage Person Link Dam - CINV51D
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    
    static int CallCCMN45D(CCMN45DI pInputMsg125, CCMN45DO pOutputMsg112, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i93 = 0;
        int rc = 0;/* Return code */
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg125.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg125.getUlIdEvent());
        
        /*
        ** Call DAM
        */
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg112.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg112.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNH0D(CCMN03UI pInputMsg126, CCMNH0DO pOutputMsg113, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i94 = 0;
        /*
        ** Declare local variables
        */
        CCMNH0DI pCCMNH0DInputRec = null;
        CCMNH0DO pCCMNH0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNH0DInputRec = new CCMNH0DI();
        
        pCCMNH0DOutputRec = new CCMNH0DO();
        pInputMsg126.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pInputMsg126.getArchInputStruct().setUlPageSizeNbr(CCMNH0DO._CCMNH0DO__ROWCCMNH0DO_SIZE);
        pCCMNH0DInputRec.setArchInputStruct(pInputMsg126.getArchInputStruct());
        pCCMNH0DInputRec.setUlIdStage(pInputMsg126.getUlIdStage());
        rc = ccmnh0dQUERYdam(sqlca, pCCMNH0DInputRec, pCCMNH0DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                for (i94 = 0;i94 < pCCMNH0DOutputRec.getArchOutputStruct().getUlRowQty();++i94) {
                    pOutputMsg113.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).setLdIdTodo(pCCMNH0DOutputRec.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).getLdIdTodo());
                    pOutputMsg113.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).setTsLastUpdate(pCCMNH0DOutputRec.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).getTsLastUpdate());
                    pOutputMsg113.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).setUlIdEvent(pCCMNH0DOutputRec.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).getUlIdEvent());
                    pOutputMsg113.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).setTsSysTsLastUpdate2(pCCMNH0DOutputRec.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).getTsSysTsLastUpdate2());
                    pOutputMsg113.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).setTsSysTsLastUpdate3(pCCMNH0DOutputRec.getROWCCMNH0DO_ARRAY().getROWCCMNH0DO(i94).getTsSysTsLastUpdate3());
                }
                pOutputMsg113.getArchOutputStruct().setUlRowQty(pCCMNH0DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg113.getArchOutputStruct().setUlRowQty(0);
                
                //  Call the Invalidate function
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNG7D(CCMNG7DI pInputMsg127, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i95 = 0;
        int rc = 0;/* Return code */
        
        CCMNG7DI pCCMNG7DInputRec = null;
        CCMNG7DO pCCMNG7DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG7DInputRec = new CCMNG7DI();
        
        pCCMNG7DOutputRec = new CCMNG7DO();
        pCCMNG7DInputRec.setArchInputStruct(pInputMsg127.getArchInputStruct());
        pCCMNG7DInputRec.setUlIdStage(pInputMsg127.getUlIdStage());
        pCCMNG7DInputRec.setUlIdEvent(pInputMsg127.getUlIdEvent());
        pCCMNG7DInputRec.setTsLastUpdate(pInputMsg127.getTsLastUpdate());
        pCCMNG7DInputRec.setSzCdTask(pInputMsg127.getSzCdTask());
        
        
        /***************************END SIR 20083******************************/
        
        
        /*
        ** Start Performance Timer
        */
        rc = ccmng7dAUDdam(sqlca, pCCMNG7DInputRec, pCCMNG7DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                
                //  Initialize Service Status Fields
                
                
                //  Set CFAD07SO WCD DtSystemDate to current date
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                // 
                // End Call to Person Table AUD Dam - CAUD74
                // 
                // END SIR#3845
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNG8D(CCMNG8DI pInputMsg128, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i96 = 0;
        int rc = 0;/* Return code */
        
        CCMNG8DI pCCMNG8DInputRec = null;
        CCMNG8DO pCCMNG8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG8DInputRec = new CCMNG8DI();
        
        pCCMNG8DOutputRec = new CCMNG8DO();
        pCCMNG8DInputRec.setArchInputStruct(pInputMsg128.getArchInputStruct());
        pCCMNG8DInputRec.setUlIdStage(pInputMsg128.getUlIdStage());
        pCCMNG8DInputRec.setUlIdEvent(pInputMsg128.getUlIdEvent());
        pCCMNG8DInputRec.setTsLastUpdate(pInputMsg128.getTsLastUpdate());
        
        /*
        ** Call DAM
        */
        rc = ccmng8dAUDdam(sqlca, pCCMNG8DInputRec, pCCMNG8DOutputRec);
        
        
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

    static int CallCCMNG9D(CCMNG9DI pInputMsg129, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i97 = 0;
        int rc = 0;
        
        CCMNG9DI pCCMNG9DInputRec = null;
        CCMNG9DO pCCMNG9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG9DInputRec = new CCMNG9DI();
        
        pCCMNG9DOutputRec = new CCMNG9DO();
        pCCMNG9DInputRec.setArchInputStruct(pInputMsg129.getArchInputStruct());
        pCCMNG9DInputRec.setUlIdStage(pInputMsg129.getUlIdStage());
        pCCMNG9DInputRec.setLdIdTodo(pInputMsg129.getLdIdTodo());
        pCCMNG9DInputRec.setTsLastUpdate(pInputMsg129.getTsLastUpdate());
        pCCMNG9DInputRec.setSzCdTask(pInputMsg129.getSzCdTask());
        rc = ccmng9dAUDdam(sqlca, pCCMNG9DInputRec, pCCMNG9DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINVB4D(CINVB4DI pInputMsg130, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINVB4DI pCINVB4DInputRec = null;
        CINVB4DO pCINVB4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB4DInputRec = new CINVB4DI();
        pCINVB4DOutputRec = new CINVB4DO();
        pCINVB4DInputRec.setUlIdAllegation(pInputMsg130.getUlIdAllegation());
        pCINVB4DInputRec.setBIndFacilAllegAbOffGr(pInputMsg130.getBIndFacilAllegAbOffGr());
        pCINVB4DInputRec.setBIndFacilAllegSupvd(pInputMsg130.getBIndFacilAllegSupvd());
        pCINVB4DInputRec.setArchInputStruct(pInputMsg130.getArchInputStruct());
        
        rc = cinvb4dAUDdam(sqlca, pCINVB4DInputRec, pCINVB4DOutputRec);
        
        
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

    static int CallCCMNH1D(CCMNH1DI pInputMsg131, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNH1DI pCCMNH1DInputRec = null;
        CCMNH1DO pCCMNH1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNH1DInputRec = new CCMNH1DI();
        pCCMNH1DOutputRec = new CCMNH1DO();
        pCCMNH1DInputRec.setUlIdStage(pInputMsg131.getUlIdStage());
        pCCMNH1DInputRec.setArchInputStruct(pInputMsg131.getArchInputStruct());
        rc = ccmnh1dAUDdam(sqlca, pCCMNH1DInputRec, pCCMNH1DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                //  Do nothing, the output message just returns success or
                // failure.
                break;
                
                
            default :
                
                
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCSES21D(CCMN03UI pInputMsg132, CCMN03UO * pOutputMsg114, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSES21DI pCSES21DInputRec = null;
        CSES21DO pCSES21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES21DInputRec = new CSES21DI();
        pCSES21DOutputRec = new CSES21DO();
        pCSES21DInputRec.setUlIdStage(pInputMsg132.getUlIdStage());
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCSES21DInputRec.setUlIdPerson(pInputMsg132.getUlScrIdPrimChild());
        pCSES21DInputRec.setSzCdStagePersRole(PERSON_ROLE_PRIM_CHILD);
        pCSES21DInputRec.setArchInputStruct(pInputMsg132.getArchInputStruct());
        rc = cses21dQUERYdam(sqlca, pCSES21DInputRec, pCSES21DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCSES21DOutputRec.getUlSysNbrUlongKey() > 0) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SUB_SUBC_STAGE_EXISTS;
                    rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                // 
                // (END): CLSS68D - Retrieve contract service codes for
                // the contract, period, and version passed to the DAM.
                // 
                
                
                break;
        }
        return rc;
    }

    static int CallCCMNB2D(CCMNB2DI pInputMsg133, CCMNB2DO pOutputMsg115, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i98 = 0;
        int rc = 0;/* Return code */
        
        CCMNB2DI pCCMNB2DInputRec = null;
        CCMNB2DO pCCMNB2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB2DInputRec = new CCMNB2DI();
        
        pCCMNB2DOutputRec = new CCMNB2DO();
        
        pCCMNB2DInputRec.setArchInputStruct(pInputMsg133.getArchInputStruct());
        pCCMNB2DInputRec.setSzCdCaseProgram(pInputMsg133.getSzCdCaseProgram());
        
        pCCMNB2DInputRec.setSzCdCaseCounty(pInputMsg133.getSzCdCaseCounty());
        pCCMNB2DInputRec.setDtDtCaseOpened(pInputMsg133.getDtDtCaseOpened());
        pCCMNB2DInputRec.setTmSysTmCaseOpened(pInputMsg133.getTmSysTmCaseOpened());
        
        pCCMNB2DInputRec.setDtDtCaseClosed(pInputMsg133.getDtDtCaseClosed());
        pCCMNB2DInputRec.setTmSysTmCaseClosed(pInputMsg133.getTmSysTmCaseClosed());
        pCCMNB2DInputRec.setSzNmCase(pInputMsg133.getSzNmCase());
        
        pCCMNB2DInputRec.setSzCdCaseRegion(pInputMsg133.getSzCdCaseRegion());
        
        /*
        ** Call DAM
        */
        rc = ccmnb2dAUDdam(sqlca, pCCMNB2DInputRec, pCCMNB2DOutputRec);
        
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg115.setUlIdCase(pCCMNB2DOutputRec.getUlIdCase());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINT13D(CINT13DI pInputMsg134, CINT13DO pOutputMsg116, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i99 = 0;
        int rc = 0;/* Return code */
        
        CINT13DI pCINT13DInputRec = null;
        CINT13DO pCINT13DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT13DInputRec = new CINT13DI();
        
        pCINT13DOutputRec = new CINT13DO();
        pCINT13DInputRec.setArchInputStruct(pInputMsg134.getArchInputStruct());
        pCINT13DInputRec.setUlIdCase(pInputMsg134.getUlIdCase());
        pCINT13DInputRec.setDtDtSituationOpened(pInputMsg134.getDtDtSituationOpened());
        pCINT13DInputRec.setNbrSitOccurrence(pInputMsg134.getNbrSitOccurrence());
        pCINT13DInputRec.getDtDtSituationClosed().year = DateHelper.NULL_DATE;
        pCINT13DInputRec.getDtDtSituationClosed().month = DateHelper.NULL_DATE;
        pCINT13DInputRec.getDtDtSituationClosed().day = DateHelper.NULL_DATE;
        
        /*
        ** Call DAM
        */
        rc = cint13dAUDdam(sqlca, pCINT13DInputRec, pCINT13DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg116.setUlIdSituation(pCINT13DOutputRec.getUlIdSituation());
                
                
                //  Call CCMN05U
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINT41D(CINT41DI pInputMsg135, CCMN03UO * pOutputMsg117, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CINT41DI pCINT41DInputRec = null;
        CINT41DO pCINT41DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT41DInputRec = new CINT41DI();
        
        pCINT41DOutputRec = new CINT41DO();
        pCINT41DInputRec.setArchInputStruct(pInputMsg135.getArchInputStruct());
        
        pCINT41DInputRec.setSzCdStage(pInputMsg135.getSzCdStage());
        pCINT41DInputRec.setSzCdStageClassification(pInputMsg135.getSzCdStageClassification());
        pCINT41DInputRec.setSzCdStageCnty(pInputMsg135.getSzCdStageCnty());
        pCINT41DInputRec.setSzCdStageCurrPriority(pInputMsg135.getSzCdStageCurrPriority());
        pCINT41DInputRec.setSzCdStageInitialPriority(pInputMsg135.getSzCdStageInitialPriority());
        pCINT41DInputRec.setSzCdStageProgram(pInputMsg135.getSzCdStageProgram());
        pCINT41DInputRec.setSzCdStageRegion(pInputMsg135.getSzCdStageRegion());
        
        pCINT41DInputRec.setUlIdUnit(pInputMsg135.getUlIdUnit());
        pCINT41DInputRec.setSzCdStageType(pInputMsg135.getSzCdStageType());
        pCINT41DInputRec.setDtDtStageStart(pInputMsg135.getDtDtStageStart());
        pCINT41DInputRec.setDtDtStageClose(pInputMsg135.getDtDtStageClose());
        pCINT41DInputRec.setUlIdCase(pInputMsg135.getUlIdCase());
        pCINT41DInputRec.setUlIdSituation(pInputMsg135.getUlIdSituation());
        pCINT41DInputRec.setSzNmStage(pInputMsg135.getSzNmStage());
        pCINT41DInputRec.setTsLastUpdate(pInputMsg135.getTsLastUpdate());
        pCINT41DInputRec.setUlIdStage(pInputMsg135.getUlIdStage());
        
        rc = cint41dAUDdam(sqlca, pCINT41DInputRec, pCINT41DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:// caud15d
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSES23D(CSES23DI pInputMsg136, CSES23DO pOutputMsg118, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
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
        pCSES23DInputRec.setArchInputStruct(pInputMsg136.getArchInputStruct());
        pCSES23DInputRec.setUlIdSvcAuth(pInputMsg136.getUlIdSvcAuth());
        rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg118.setCIndSvcAuthComplete(pCSES23DOutputRec.getCIndSvcAuthComplete());
                
                
                //  Initialize rc for loop
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSES24D(CSES24DI pInputMsg137, CSES24DO pOutputMsg119, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        
        pCSES24DInputRec.setArchInputStruct(pInputMsg137.getArchInputStruct());
        pCSES24DInputRec.setUlIdSvcAuthEvent(pInputMsg137.getUlIdSvcAuthEvent());
        
        rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg119.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCLSS24D(CLSS24DI pInputMsg138, CLSS24DO pOutputMsg120, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i100 = 0;
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
        pCLSS24DInputRec.setArchInputStruct(pInputMsg138.getArchInputStruct());
        pCLSS24DInputRec.setUlIdSvcAuth(pInputMsg138.getUlIdSvcAuth());
        rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg120.getArchOutputStruct().setUlRowQty(pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i100 = 0;i100 < pCLSS24DOutputRec.getArchOutputStruct().getUlRowQty();++i100) {
                    pOutputMsg120.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i100).setDtDtSvcAuthDtlTerm(pCLSS24DOutputRec.getROWCLSS24DO_ARRAY().getROWCLSS24DO(i100).getDtDtSvcAuthDtlTerm());
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCAUD34D(CAUD34DI pInputMsg139, CAUD34DO * pOutputMsg121, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCAUD34DInputRec.setArchInputStruct(pInputMsg139.getArchInputStruct());
        pCAUD34DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCAUD34DInputRec.setUlIdSvcAuth(pInputMsg139.getUlIdSvcAuth());
        pCAUD34DInputRec.setUlIdSvcAuthEvent(pInputMsg139.getUlIdSvcAuthEvent());
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

    static int CallCCMND2D(CCMND2DI pInputMsg140, CCMND2DO pOutputMsg122, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i101 = 0;
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
        pCCMND2DInputRec.setArchInputStruct(pInputMsg140.getArchInputStruct());
        pCCMND2DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMND2DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMND2DO._CCMND2DO__ROWCCMND2DO_SIZE);
        pCCMND2DInputRec.setUlIdEvent(pInputMsg140.getUlIdEvent());
        rc = ccmnd2dQUERYdam(sqlca, pCCMND2DInputRec, pCCMND2DOutputRec);
        
        /*
        ** Analyze return code for CINV51D(VC)
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg122.getArchOutputStruct().setUlRowQty(pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i101 = 0;i101 < pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty();++i101) {
                    pOutputMsg122.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i101).setUlIdPerson(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i101).getUlIdPerson());
                }
                
                //  Call DAM
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN68D(CCMN68DI pInputMsg141, CCMN68DO * pOutputMsg123, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMN68DInputRec.setArchInputStruct(pInputMsg141.getArchInputStruct());
        pCCMN68DInputRec.setUlIdEvent(pInputMsg141.getUlIdEvent());
        
        pCCMN68DInputRec.setUlIdPerson(pInputMsg141.getUlIdPerson());
        /* 
        ** It is possible to have a unit without employees (this 
        ** must be true in order to delete the unit)
        */
        rc = ccmn68dAUDdam(sqlca, pCCMN68DInputRec, pCCMN68DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;// break for CLSS67D
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCCMN79D(CCMN79DI pInputMsg142, CCMN79DO pOutputMsg124, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN79DI pCCMN79DInputRec = null;
        CCMN79DO pCCMN79DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN79DInputRec = new CCMN79DI();
        
        pCCMN79DOutputRec = new CCMN79DO();
        pCCMN79DInputRec.setArchInputStruct(pInputMsg142.getArchInputStruct());
        pCCMN79DInputRec.setSzCdOnCallCounty(pInputMsg142.getSzCdOnCallCounty());
        pCCMN79DInputRec.setSzCdOnCallProgram(pInputMsg142.getSzCdOnCallProgram());
        pCCMN79DInputRec.setDtDtOnCallStart(pInputMsg142.getDtDtOnCallStart());
        pCCMN79DInputRec.setTmOnCallStart(pInputMsg142.getTmOnCallStart());
        /*
        ** Copies rows from the INCOMING_PERSON_ETHNICITY table to the
        ** PERSON_ETHNICITY table
        */
        rc = ccmn79dQUERYdam(sqlca, pCCMN79DInputRec, pCCMN79DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg124.getROWCCMN79DO().setUlIdOnCall(pCCMN79DOutputRec.getROWCCMN79DO().getUlIdOnCall());
                //  Copies rows from the INCOMING_NAME table to the
                // NAME table
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                //  Update STAGE_PERSON_LINK changing the ID_PERSON to the
                // ID_RELATED_PERSON
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSES70D(CSES70DI pInputMsg143, CSES70DO pOutputMsg125, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSES70DI pCSES70DInputRec = null;
        CSES70DO pCSES70DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES70DInputRec = new CSES70DI();
        
        pCSES70DOutputRec = new CSES70DO();
        pCSES70DInputRec.setArchInputStruct(pInputMsg143.getArchInputStruct());
        pCSES70DInputRec.setUlIdOnCall(pInputMsg143.getUlIdOnCall());
        
        /*
        ** Call CCMN45D
        */
        rc = cses70dQUERYdam(sqlca, pCSES70DInputRec, pCSES70DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg125.setUlIdPerson(pCSES70DOutputRec.getUlIdPerson());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg125.setUlIdPerson(0);
                
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCSEC54D(CCMN03UI pInputMsg144, FndInt3date dtDtIncomingCall2, String tmTmIncmgCall2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSEC54DI pCSEC54DInputRec = null;
        CSEC54DO pCSEC54DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC54DInputRec = new CSEC54DI();
        pCSEC54DOutputRec = new CSEC54DO();
        pCSEC54DInputRec.setUlIdStage(pInputMsg144.getUlIdStage());
        pCSEC54DInputRec.setArchInputStruct(pInputMsg144.getArchInputStruct());
        rc = csec54dQUERYdam(sqlca, pCSEC54DInputRec, pCSEC54DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                dtDtIncomingCall2 = pCSEC54DOutputRec.getDtDtIncomingCall();
                tmTmIncmgCall2 = pCSEC54DOutputRec.getTmTmIncmgCall();
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        
        return rc;
    }

    static int CallCINT09D(CCMN03UI pInputMsg145, CINT09DO pOutputMsg126, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT09DI pCINT09DInputRec = null;
        CINT09DO pCINT09DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT09DInputRec = new CINT09DI();
        
        
        pCINT09DOutputRec = new CINT09DO();
        pCINT09DInputRec.setArchInputStruct(pInputMsg145.getArchInputStruct());
        pCINT09DInputRec.setUlIdStage(pInputMsg145.getUlIdStage());
        rc = cint09dQUERYdam(sqlca, pCINT09DInputRec, pCINT09DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg126.setBIndIncmgFacilAbSupvd(pCINT09DOutputRec.getBIndIncmgFacilAbSupvd());
                pOutputMsg126.setBIndIncmgOnGrnds(pCINT09DOutputRec.getBIndIncmgOnGrnds());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                break;
        }
        return rc;
    }

    static int CallCSEC09D(CSEC09DI pInputMsg146, CSEC09DO pOutputMsg127, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSEC09DI pCSEC09DInputRec = null;
        CSEC09DO pCSEC09DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC09DInputRec = new CSEC09DI();
        
        
        pCSEC09DOutputRec = new CSEC09DO();
        pCSEC09DInputRec.setArchInputStruct(pInputMsg146.getArchInputStruct());
        pCSEC09DInputRec.setUlIdGuardEvent(pInputMsg146.getUlIdGuardEvent());
        rc = csec09dQUERYdam(sqlca, pCSEC09DInputRec, pCSEC09DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg127.setUlIdGuardEvent(pCSEC09DOutputRec.getUlIdGuardEvent());
                pOutputMsg127.setUlIdGuardPers(pCSEC09DOutputRec.getUlIdGuardPers());
                
                pOutputMsg127.setUlIdGuardRsrc(pCSEC09DOutputRec.getUlIdGuardRsrc());
                pOutputMsg127.setDtDtGuardCloseDate(pCSEC09DOutputRec.getDtDtGuardCloseDate());
                pOutputMsg127.setDtDtGuardLetterIssued(pCSEC09DOutputRec.getDtDtGuardLetterIssued());
                pOutputMsg127.setDtDtGuardOrdered(pCSEC09DOutputRec.getDtDtGuardOrdered());
                pOutputMsg127.setSzCdGuardGuardianType(pCSEC09DOutputRec.getSzCdGuardGuardianType());
                // 
                // OPTIONAL CODE NOTE (END): Generic List AUD
                // 
                
                
                
                //  Start Performance Timer
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                // END SIR 21952
                
                break;
        }
        return rc;
    }

    static int CallCCMN44D(CCMN44DI pInputMsg147, CCMN44DO pOutputMsg128, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN44DInputRec = new CCMN44DI();
        
        
        pCCMN44DOutputRec = new CCMN44DO();
        pCCMN44DInputRec.setArchInputStruct(pInputMsg147.getArchInputStruct());
        pCCMN44DInputRec.setUlIdPerson(pInputMsg147.getUlIdPerson());
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg128.setDtDtPersonBirth(pCCMN44DOutputRec.getDtDtPersonBirth());
                pOutputMsg128.setLNbrPersonAge(pCCMN44DOutputRec.getLNbrPersonAge());
                pOutputMsg128.setSzCdPersonLivArr(pCCMN44DOutputRec.getSzCdPersonLivArr());
                pOutputMsg128.setTsLastUpdate(pCCMN44DOutputRec.getTsLastUpdate());
                pOutputMsg128.setSzCdPersonDeath(pCCMN44DOutputRec.getSzCdPersonDeath());
                pOutputMsg128.setSzCdPersonEthnicGroup(pCCMN44DOutputRec.getSzCdPersonEthnicGroup());
                pOutputMsg128.setSzCdPersonLanguage(pCCMN44DOutputRec.getSzCdPersonLanguage());
                pOutputMsg128.setSzCdPersonMaritalStatus(pCCMN44DOutputRec.getSzCdPersonMaritalStatus());
                pOutputMsg128.setSzCdPersonReligion(pCCMN44DOutputRec.getSzCdPersonReligion());
                pOutputMsg128.setCdPersonStatus(pCCMN44DOutputRec.getCdPersonStatus());
                pOutputMsg128.setCCdPersonSex(pCCMN44DOutputRec.getCCdPersonSex());
                pOutputMsg128.setDtDtPersonDeath(pCCMN44DOutputRec.getDtDtPersonDeath());
                pOutputMsg128.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                pOutputMsg128.setSzTxtOccupation(pCCMN44DOutputRec.getSzTxtOccupation());
                
                pOutputMsg128.setSzCdPersGuardCnsrv(pCCMN44DOutputRec.getSzCdPersGuardCnsrv());
                
                pOutputMsg128.setBScrIndPersChrctr(pCCMN44DOutputRec.getBScrIndPersChrctr());
                pOutputMsg128.setBCdPersonChar(pCCMN44DOutputRec.getBCdPersonChar());
                pOutputMsg128.setBIndPersCancelHist(pCCMN44DOutputRec.getBIndPersCancelHist());
                pOutputMsg128.setBIndPersonDobApprox(pCCMN44DOutputRec.getBIndPersonDobApprox());
                
                // Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                break;
        }
        return rc;
    }

    
    static int CallCLSS60D(CLSS60DI pInputMsg148, CLSS60DO pOutputMsg129, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        int i102 = 0;
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
        if (pCLSS60DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        /* To-Do Arch Enh BEGIN */
        
        if (pCLSS60DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        pCLSS60DInputRec.setArchInputStruct(pInputMsg148.getArchInputStruct());
        
        pCLSS60DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        
        pCLSS60DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS60DO._CLSS60DO__ROWCLSS60DO_SIZE);
        
        pCLSS60DInputRec.setUlIdPerson(pInputMsg148.getUlIdPerson());
        
        pCLSS60DInputRec.setDtScrDtCharEffDate(pInputMsg148.getDtScrDtCharEffDate());
        rc = clss60dQUERYdam(sqlca, pCLSS60DInputRec, pCLSS60DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i102 = 0;i102 < pCLSS60DOutputRec.getArchOutputStruct().getUlRowQty();++i102) {
                    
                    pOutputMsg129.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).setSzCdCharCategory(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).getSzCdCharCategory());
                    
                    pOutputMsg129.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).setCdCharacteristic(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).getCdCharacteristic());
                    
                    pOutputMsg129.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).setUlIdCharacteristics(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).getUlIdCharacteristics());
                    
                    pOutputMsg129.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).setDtDtCharStart(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).getDtDtCharStart());
                    
                    pOutputMsg129.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).setDtDtCharEnd(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).getDtDtCharEnd());
                    
                    pOutputMsg129.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).setTsLastUpdate(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i102).getTsLastUpdate());
                }
                pOutputMsg129.getArchOutputStruct().setUlRowQty(pCLSS60DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg129.getArchOutputStruct().setBMoreDataInd(pCLSS60DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pOutputMsg129.getArchOutputStruct().setUlRowQty(0);
                pOutputMsg129.getArchOutputStruct().setBMoreDataInd(pCLSS60DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCINV48D(CINV48DI pInputMsg149, CINV48DO * pOutputMsg130, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINV48DInputRec.setArchInputStruct(pInputMsg149.getArchInputStruct());
        pCINV48DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCINV48DInputRec.getROWCINV48DI().setUlIdPerson(pInputMsg149.getROWCINV48DI().getUlIdPerson());
        pCINV48DInputRec.getROWCINV48DI().setSzCdCharCategory(pInputMsg149.getROWCINV48DI().getSzCdCharCategory());
        pCINV48DInputRec.getROWCINV48DI().setCdCharacteristic(pInputMsg149.getROWCINV48DI().getCdCharacteristic());
        pCINV48DInputRec.getROWCINV48DI().setDtDtCharStart(pInputMsg149.getROWCINV48DI().getDtDtCharStart());
        pCINV48DInputRec.getROWCINV48DI().setDtDtCharEnd(pInputMsg149.getROWCINV48DI().getDtDtCharEnd());
        rc = cinv48dAUDdam(sqlca, pCINV48DInputRec, pCINV48DOutputRec);
        
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

    static int CallCINV41D(CINV41DI pInputMsg150, CINV41DO * pOutputMsg131, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCINV41DInputRec.setArchInputStruct(pInputMsg150.getArchInputStruct());
        pCINV41DInputRec.getArchInputStruct().setCReqFuncCd(WINDOW_MODE_PERSON);
        pCINV41DInputRec.setDtDtPersonBirth(pInputMsg150.getDtDtPersonBirth());
        pCINV41DInputRec.setLNbrPersonAge(pInputMsg150.getLNbrPersonAge());
        pCINV41DInputRec.setSzCdPersonLivArr(pInputMsg150.getSzCdPersonLivArr());
        pCINV41DInputRec.setTsSysTsLastUpdate2(pInputMsg150.getTsSysTsLastUpdate2());
        pCINV41DInputRec.setSzCdPersonDeath(pInputMsg150.getSzCdPersonDeath());
        pCINV41DInputRec.setSzCdPersonEthnicGroup(pInputMsg150.getSzCdPersonEthnicGroup());
        pCINV41DInputRec.setSzCdPersonLanguage(pInputMsg150.getSzCdPersonLanguage());
        pCINV41DInputRec.setSzCdPersonMaritalStatus(pInputMsg150.getSzCdPersonMaritalStatus());
        pCINV41DInputRec.setSzCdPersonReligion(pInputMsg150.getSzCdPersonReligion());
        pCINV41DInputRec.setCdPersonStatus(pInputMsg150.getCdPersonStatus());
        pCINV41DInputRec.setCCdPersonSex(pInputMsg150.getCCdPersonSex());
        pCINV41DInputRec.setDtDtPersonDeath(pInputMsg150.getDtDtPersonDeath());
        pCINV41DInputRec.setSzNmPersonFull(pInputMsg150.getSzNmPersonFull());
        pCINV41DInputRec.setSzTxtOccupation(pInputMsg150.getSzTxtOccupation());
        
        pCINV41DInputRec.setBCdPersonChar(pInputMsg150.getBCdPersonChar());
        pCINV41DInputRec.setBIndPersonDobApprox(pInputMsg150.getBIndPersonDobApprox());
        pCINV41DInputRec.setUlIdPerson(pInputMsg150.getUlIdPerson());
        rc = cinv41dAUDdam(sqlca, pCINV41DInputRec, pCINV41DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                //  Do nothing, the output message just returns success or
                // failure.
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMND9D(CCMND9DI pInputMsg151, CCMND9DO pOutputMsg132, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMND9DI pCCMND9DInputRec = null;
        CCMND9DO pCCMND9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND9DInputRec = new CCMND9DI();
        
        
        pCCMND9DOutputRec = new CCMND9DO();
        pCCMND9DInputRec.setArchInputStruct(pInputMsg151.getArchInputStruct());
        pCCMND9DInputRec.setUlIdCase(pInputMsg151.getUlIdCase());
        rc = ccmnd9dQUERYdam(sqlca, pCCMND9DInputRec, pCCMND9DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg132.setSzCdCaseCounty(pCCMND9DOutputRec.getSzCdCaseCounty());
                pOutputMsg132.setTsLastUpdate(pCCMND9DOutputRec.getTsLastUpdate());
                pOutputMsg132.setSzCdCaseProgram(pCCMND9DOutputRec.getSzCdCaseProgram());
                pOutputMsg132.setSzCdCaseRegion(pCCMND9DOutputRec.getSzCdCaseRegion());
                pOutputMsg132.setSzCdCaseSpeclHndlg(pCCMND9DOutputRec.getSzCdCaseSpeclHndlg());
                pOutputMsg132.setDtDtCaseClosed(pCCMND9DOutputRec.getDtDtCaseClosed());
                pOutputMsg132.setDtDtCaseOpened(pCCMND9DOutputRec.getDtDtCaseOpened());
                pOutputMsg132.setUlIdCase(pCCMND9DOutputRec.getUlIdCase());
                pOutputMsg132.setBIndCaseArchived(pCCMND9DOutputRec.getBIndCaseArchived());
                pOutputMsg132.setBIndCaseSensitive(pCCMND9DOutputRec.getBIndCaseSensitive());
                pOutputMsg132.setBIndCaseWorkerSafety(pCCMND9DOutputRec.getBIndCaseWorkerSafety());
                pOutputMsg132.setSzNmCase(pCCMND9DOutputRec.getSzNmCase());
                pOutputMsg132.setSzTxtCaseSensitiveCmnts(pCCMND9DOutputRec.getSzTxtCaseSensitiveCmnts());
                
                pOutputMsg132.setSzTxtCaseWorkerSafety(pCCMND9DOutputRec.getSzTxtCaseWorkerSafety());
                
                //  Start performance timer for Data Access Module 
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCLSC45D(CLSC45DI pInputMsg152, CLSC45DO pOutputMsg133, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i103 = 0;
        /*
        ** Declare local variables
        */
        CLSC45DI pCLSC45DInputRec = null;
        CLSC45DO pCLSC45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC45DInputRec = new CLSC45DI();
        pCLSC45DOutputRec = new CLSC45DO();
        
        if (pCLSC45DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        if (pCLSC45DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCLSC45DInputRec.setArchInputStruct(pInputMsg152.getArchInputStruct());
        pCLSC45DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSC45DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC45DO._CLSC45DO__ROWCLSC45DO_SIZE);
        pCLSC45DInputRec.setUlIdPerson(pInputMsg152.getUlIdPerson());
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Start performance timer for service
        */
        rc = clsc45dQUERYdam(sqlca, pCLSC45DInputRec, pCLSC45DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i103 = 0;i103 < pCLSC45DOutputRec.getArchOutputStruct().getUlRowQty();++i103) {
                    pOutputMsg133.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).setSzCdStagePersType(pCLSC45DOutputRec.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).getSzCdStagePersType());
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                    pOutputMsg133.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).setSzCdStagePersRelInt(pCLSC45DOutputRec.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).getSzCdStagePersRelInt());
                    pOutputMsg133.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).setUlIdStage(pCLSC45DOutputRec.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).getUlIdStage());
                    pOutputMsg133.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).setDtDtStageStart(pCLSC45DOutputRec.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).getDtDtStageStart());
                    pOutputMsg133.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).setDtDtStageClose(pCLSC45DOutputRec.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).getDtDtStageClose());
                    pOutputMsg133.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).setSzCdStage(pCLSC45DOutputRec.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).getSzCdStage());
                    pOutputMsg133.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).setUlIdCase(pCLSC45DOutputRec.getROWCLSC45DO_ARRAY().getROWCLSC45DO(i103).getUlIdCase());
                }
                pOutputMsg133.getArchOutputStruct().setUlRowQty(pCLSC45DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg133.getArchOutputStruct().setBMoreDataInd(pCLSC45DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCAUDA3D(CAUDA3DI pInputMsg153, CAUDA3DO * pOutputMsg134, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CAUDA3DI pCAUDA3DInputRec = null;
        CAUDA3DO pCAUDA3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDA3DInputRec = new CAUDA3DI();
        
        pCAUDA3DOutputRec = new CAUDA3DO();
        
        pCAUDA3DInputRec.setArchInputStruct(pInputMsg153.getArchInputStruct());
        
        pCAUDA3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        
        pCAUDA3DInputRec.setUlIdStage(pInputMsg153.getUlIdStage());
        
        pCAUDA3DInputRec.setUlIdPerson(pInputMsg153.getUlIdPerson());
        pCAUDA3DInputRec.setUlIdEvent(pInputMsg153.getUlIdEvent());
        pCAUDA3DInputRec.setUlIdStageRelated(pInputMsg153.getUlIdStageRelated());
        pCAUDA3DInputRec.setTsLastUpdate(pInputMsg153.getTsLastUpdate());
        pCAUDA3DInputRec.setDtDtAdminRvAppealNotif(pInputMsg153.getDtDtAdminRvAppealNotif());
        pCAUDA3DInputRec.setDtDtAdminRvAppealReview(pInputMsg153.getDtDtAdminRvAppealReview());
        pCAUDA3DInputRec.setDtDtAdminRvDue(pInputMsg153.getDtDtAdminRvDue());
        pCAUDA3DInputRec.setDtDtAdminRvEmgcyRel(pInputMsg153.getDtDtAdminRvEmgcyRel());
        pCAUDA3DInputRec.setDtDtAdminRvHearing(pInputMsg153.getDtDtAdminRvHearing());
        pCAUDA3DInputRec.setDtDtAdminRvReqAppeal(pInputMsg153.getDtDtAdminRvReqAppeal());
        pCAUDA3DInputRec.setSzCdAdminRvStatus(pInputMsg153.getSzCdAdminRvStatus());
        
        /*
        ** Call CSEC33D
        */
        rc = cauda3dAUDdam(sqlca, pCAUDA3DInputRec, pCAUDA3DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                // check to see if age is required
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                // 
                // End Call to Post Event Common Function - CCMN01U
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                break;
        }
        return rc;
    }

    static int CallCSEC66D(CSEC66DI pInputMsg154, CSEC66DO pOutputMsg135, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSEC66DI pCSEC66DInputRec = null;
        CSEC66DO pCSEC66DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC66DInputRec = new CSEC66DI();
        
        
        pCSEC66DOutputRec = new CSEC66DO();
        pCSEC66DInputRec.setArchInputStruct(pInputMsg154.getArchInputStruct());
        pCSEC66DInputRec.setUlIdStage(pInputMsg154.getUlIdStage());
        rc = csec66dQUERYdam(sqlca, pCSEC66DInputRec, pCSEC66DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg135.setUlIdPerson(pCSEC66DOutputRec.getUlIdPerson());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCSEC29D(CSEC29DI pInputMsg155, CSEC29DO pOutputMsg136, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
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
        pCSEC29DInputRec.setArchInputStruct(pInputMsg155.getArchInputStruct());
        pCSEC29DInputRec.setUlIdPerson(pInputMsg155.getUlIdPerson());
        pCSEC29DInputRec.setUlIdCase(pInputMsg155.getUlIdCase());
        pCSEC29DInputRec.setSzCdStagePersRole(pInputMsg155.getSzCdStagePersRole());
        pCSEC29DInputRec.setSzCdStage(pInputMsg155.getSzCdStage());
        rc = csec29dQUERYdam(sqlca, pCSEC29DInputRec, pCSEC29DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg136.setUlIdPerson(pCSEC29DOutputRec.getUlIdPerson());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg136.setUlIdPerson(0);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                break;
        }
        return rc;
    }

    static int CallCSES64D(CSES64DI pInputMsg156, CSES64DO pOutputMsg137, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSES64DI pCSES64DInputRec = null;
        CSES64DO pCSES64DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES64DInputRec = new CSES64DI();
        
        
        pCSES64DOutputRec = new CSES64DO();
        pCSES64DInputRec.setArchInputStruct(pInputMsg156.getArchInputStruct());
        pCSES64DInputRec.setUlIdEvent(pInputMsg156.getUlIdEvent());
        rc = cses64dQUERYdam(sqlca, pCSES64DInputRec, pCSES64DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                pOutputMsg137.setUlIdAdptSub(pCSES64DOutputRec.getUlIdAdptSub());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCAUDB2D(CAUDB2DI pInputMsg157, CAUDB2DO * pOutputMsg138, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CAUDB2DI pCAUDB2DInputRec = null;
        CAUDB2DO pCAUDB2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDB2DInputRec = new CAUDB2DI();
        
        
        pCAUDB2DOutputRec = new CAUDB2DO();
        pCAUDB2DInputRec.setArchInputStruct(pInputMsg157.getArchInputStruct());
        pCAUDB2DInputRec.setUlIdEvent(pInputMsg157.getUlIdEvent());
        pCAUDB2DInputRec.setUlIdAdptSub(pInputMsg157.getUlIdAdptSub());
        
        
        
        /*
        ** COMMENT THE DAM CALL HERE -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
        */
        
        /*
        ** Start Performance Timer
        */
        rc = caudb2dAUDdam(sqlca, pCAUDB2DInputRec, pCAUDB2DOutputRec);
        switch (rc) /* clss11d */
        {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCLSS63D(CLSS63DI pInputMsg158, CLSS63DO pOutputMsg139, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i104 = 0;
        /*
        ** Declare local variables
        */
        CLSS63DI pCLSS63DInputRec = null;
        CLSS63DO pCLSS63DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS63DInputRec = new CLSS63DI();
        pCLSS63DOutputRec = new CLSS63DO();
        
        if (pCLSS63DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        if (pCLSS63DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCLSS63DInputRec.setArchInputStruct(pInputMsg158.getArchInputStruct());
        pCLSS63DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCLSS63DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS63DO._CLSS63DO__ROWCLSS63DO_SIZE);
        pCLSS63DInputRec.setUlIdPerson(pInputMsg158.getUlIdPerson());
        rc = clss63dQUERYdam(sqlca, pCLSS63DInputRec, pCLSS63DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i104 = 0;i104 < pCLSS63DOutputRec.getArchOutputStruct().getUlRowQty();++i104) {
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setSzNmResource(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getSzNmResource());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setSzNmRsrcContact(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getSzNmRsrcContact());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setUlIdResource(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getUlIdResource());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setUlIdRsrcFaHomeStage(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getUlIdRsrcFaHomeStage());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setSzCdStagePersRole(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getSzCdStagePersRole());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setSzCdStagePersType(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getSzCdStagePersType());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setSzCdStagePersSearchInd(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getSzCdStagePersSearchInd());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setSzCdStagePersRelInt(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getSzCdStagePersRelInt());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setUlIdPerson(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getUlIdPerson());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setBIndStagePersReporter(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getBIndStagePersReporter());
                    pOutputMsg139.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).setBIndStagePersInLaw(pCLSS63DOutputRec.getROWCLSS63DO_ARRAY().getROWCLSS63DO(i104).getBIndStagePersInLaw());
                }
                pOutputMsg139.getArchOutputStruct().setUlRowQty(pCLSS63DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg139.getArchOutputStruct().setBMoreDataInd(pCLSS63DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCLSC75D(CLSC75DI pInputMsg159, CLSC75DO pOutputMsg140, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i105 = 0;
        /*
        ** Declare local variables
        */
        CLSC75DI pCLSC75DInputRec = null;
        CLSC75DO pCLSC75DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC75DInputRec = new CLSC75DI();
        pCLSC75DOutputRec = new CLSC75DO();
        if (pCLSC75DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        if (pCLSC75DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        pCLSC75DInputRec.setArchInputStruct(pInputMsg159.getArchInputStruct());
        
        pCLSC75DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        
        pCLSC75DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC75DO._CLSC75DO__ROWCLSC75DO_SIZE);
        pCLSC75DInputRec.setUlIdStage(pInputMsg159.getUlIdStage());
        pCLSC75DInputRec.setUlIdStageRelated(pInputMsg159.getUlIdStageRelated());
        
        
        /*
        ** Call CMSC34D
        */
        rc = clsc75dQUERYdam(sqlca, pCLSC75DInputRec, pCLSC75DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate output message
                for (i105 = 0;i105 < pCLSC75DOutputRec.getArchOutputStruct().getUlRowQty();++i105) {
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setSzCdStagePersType(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getSzCdStagePersType());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setSzCdStagePersRelInt(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getSzCdStagePersRelInt());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setUlIdStage(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getUlIdStage());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setSzCdStage(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getSzCdStage());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setSzCdStagePersRole(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getSzCdStagePersRole());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setSzCdStagePersSearchInd(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getSzCdStagePersSearchInd());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setSzTxtStagePersNotes(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getSzTxtStagePersNotes());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setBIndStagePersInLaw(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getBIndStagePersInLaw());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setDtDtStagePersLink(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getDtDtStagePersLink());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setBIndStagePersReporter(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getBIndStagePersReporter());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setBIndStagePersEmpNew(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getBIndStagePersEmpNew());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setUlIdPerson(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getUlIdPerson());
                    pOutputMsg140.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).setUlIdStagePerson(pCLSC75DOutputRec.getROWCLSC75DO_ARRAY().getROWCLSC75DO(i105).getUlIdStagePerson());
                }
                pOutputMsg140.getArchOutputStruct().setUlRowQty(pCLSC75DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg140.getArchOutputStruct().setBMoreDataInd(pCLSC75DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg140.getArchOutputStruct().setUlRowQty(0);
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSES94D(CCMN03UI pInputMsg160, CCMN03UO * pOutputMsg141, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSES94DI pCSES94DInputRec = null;
        CSES94DO pCSES94DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES94DInputRec = new CSES94DI();
        pCSES94DOutputRec = new CSES94DO();
        pCSES94DInputRec.setSzCdStage(PREP_ADULT);
        pCSES94DInputRec.setUlIdPerson(pInputMsg160.getUlScrIdPrimChild());
        pCSES94DInputRec.setSzCdStagePersRole(PERSON_ROLE_PRIM_CHILD);
        pCSES94DInputRec.setArchInputStruct(pInputMsg160.getArchInputStruct());
        pCSES94DInputRec.getArchInputStruct().setCReqFuncCd(CLOSE);
        
        rc = cses94dQUERYdam(sqlca, pCSES94DInputRec, pCSES94DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pCSES94DOutputRec.getUlSysNbrUlongKey() > 0) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_PAL_STAGE_EXISTS;
                    
                    //  re-format the TodoTxtDescr - BSM
                    
                    //  Get the decode value of the SvcAuthService
                    rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  END SIR 2376 - BSM
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCSECA2D(CCMN03UI pInputMsg161, CSECA2DO pOutputMsg142, String pbEA_Eligible, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
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
        if (pCSECA2DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        if (pCSECA2DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCSECA2DInputRec.setArchInputStruct(pInputMsg161.getArchInputStruct());
        pCSECA2DInputRec.setIdCpsInvstStage(pInputMsg161.getUlIdStage());
        
        rc = cseca2dQUERYdam(sqlca, pCSECA2DInputRec, pCSECA2DOutputRec);
        switch (rc) {
                // Handle specific functional errors
            case WtcHelperConstants.SQL_SUCCESS:
                pbEA_Eligible = CStringUtils.setCharAt(pbEA_Eligible, 0, true);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg142.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCLSC18D(CCMN03UI pInputMsg162, CLSC18DO pOutputMsg143, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CLSC18DI pCLSC18DInputRec = null;
        CLSC18DO pCLSC18DOutputRec = null;
        int i106 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC18DInputRec = new CLSC18DI();
        pCLSC18DOutputRec = new CLSC18DO();
        
        if (pCLSC18DInputRec == null) {
            
            
            
            //  Start Performance Timer
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        if (pCLSC18DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCLSC18DInputRec.setArchInputStruct(pInputMsg162.getArchInputStruct());
        pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        
        pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC18DO._CLSC18DO__ROWCLSC18DO_SIZE);
        pCLSC18DInputRec.setSzCdStagePersType(PERSON_ROLE_PRINCIPAL);
        pCLSC18DInputRec.setUlIdStage(pInputMsg162.getUlIdStage());
        rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                pOutputMsg143.getArchOutputStruct().setUlRowQty(pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());
                
                for (i106 = 0;i106 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty();++i106) {
                    pOutputMsg143.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i106).setUlIdPerson(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i106).getUlIdPerson());
                }
                
                
                //  Call CAUD23D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg143.getArchOutputStruct().setUlRowQty(0);
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSECA1D(CSECA1DI pInputMsg163, CSECA1DO pOutputMsg144, String pbEA_Found, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
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
        /*
        ** The task event status is not NULL.  Check task
        ** event status against the
        ** event table status.  If the Event table status is >=
        ** the Task table status, then enable the NEW PB.  
        ** Otherwise, disable it.
        */
        
        if (pCSECA1DInputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        
        
        if (pCSECA1DOutputRec == null) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        pCSECA1DInputRec.setArchInputStruct(pInputMsg163.getArchInputStruct());
        pCSECA1DInputRec.setUlIdPersEligPerson(pInputMsg163.getUlIdPersEligPerson());
        pCSECA1DInputRec.setSzCdPersEligType(pInputMsg163.getSzCdPersEligType());
        
        /*
        ** Call DAM
        */
        rc = cseca1dQUERYdam(sqlca, pCSECA1DInputRec, pCSECA1DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg144.setUlIdPersElig(pCSECA1DOutputRec.getUlIdPersElig());
                pOutputMsg144.setUlIdPersEligPerson(pCSECA1DOutputRec.getUlIdPersEligPerson());
                pOutputMsg144.setSzCdPersEligType(pCSECA1DOutputRec.getSzCdPersEligType());
                pOutputMsg144.setDtDtPersEligStart(pCSECA1DOutputRec.getDtDtPersEligStart());
                pOutputMsg144.setDtDtPersEligEnd(pCSECA1DOutputRec.getDtDtPersEligEnd());
                pOutputMsg144.setDtDtPersEligEaDeny(pCSECA1DOutputRec.getDtDtPersEligEaDeny());
                pOutputMsg144.setCdPersEligPrgStart(pCSECA1DOutputRec.getCdPersEligPrgStart());
                pOutputMsg144.setCdPersEligPrgOpen(pCSECA1DOutputRec.getCdPersEligPrgOpen());
                pOutputMsg144.setCdPersEligPrgClose(pCSECA1DOutputRec.getCdPersEligPrgClose());
                pbEA_Found = CStringUtils.setCharAt(pbEA_Found, 0, true);
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg144.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
        
    }

    
    static int CallCAUDC9D(CAUDC9DI pInputMsg164, CAUDC9DO pOutputMsg145, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
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
        pCAUDC9DInputRec.setArchInputStruct(pInputMsg164.getArchInputStruct());
        pCAUDC9DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg164.getArchInputStruct().getCReqFuncCd());
        pCAUDC9DInputRec.setUlIdPersEligPerson(pInputMsg164.getUlIdPersEligPerson());
        pCAUDC9DInputRec.setDtDtPersEligStart(pInputMsg164.getDtDtPersEligStart());
        pCAUDC9DInputRec.setDtDtPersEligEnd(pInputMsg164.getDtDtPersEligEnd());
        pCAUDC9DInputRec.setCdPersEligPrgStart(pInputMsg164.getCdPersEligPrgStart());
        pCAUDC9DInputRec.setCdPersEligPrgOpen(pInputMsg164.getCdPersEligPrgOpen());
        pCAUDC9DInputRec.setDtDtPersEligEaDeny(pInputMsg164.getDtDtPersEligEaDeny());
        pCAUDC9DInputRec.setUlIdPersElig(pInputMsg164.getUlIdPersElig());
        pCAUDC9DInputRec.setCdPersEligPrgClose(pInputMsg164.getCdPersEligPrgClose());
        
        rc = caudc9dAUDdam(sqlca, pCAUDC9DInputRec, pCAUDC9DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg145.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCSECA3D(CSECA3DI pInputMsg165, CSECA3DO pOutputMsg146, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
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
        pCSECA3DInputRec.setArchInputStruct(pInputMsg165.getArchInputStruct());
        pCSECA3DInputRec.setIdEventStage(pInputMsg165.getIdEventStage());
        pCSECA3DInputRec.setUlIdStage(pInputMsg165.getUlIdStage());
        rc = cseca3dQUERYdam(sqlca, pCSECA3DInputRec, pCSECA3DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg146.setDtDtSvcAuthDtlBegin(pCSECA3DOutputRec.getDtDtSvcAuthDtlBegin());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg146.getArchOutputStruct().setUlRowQty(0);
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
    }

    static int CallCSEC85D(CSEC85DI pInputMsg166, CSEC85DO pOutputMsg147, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
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
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCSEC85DInputRec.setArchInputStruct(pInputMsg166.getArchInputStruct());
        pCSEC85DInputRec.setDtDtPersEligStart(pInputMsg166.getDtDtPersEligStart());
        rc = csec85dQUERYdam(sqlca, pCSEC85DInputRec, pCSEC85DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg147.setDtDtPersEligEnd(pCSEC85DOutputRec.getDtDtPersEligEnd());
                
                // Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg147.getArchOutputStruct().setUlRowQty(0);
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

}
