package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CreateCallOutStruct;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT12DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT74DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT74DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
/**************************************************************************
** 
** Module File:   cint12s.src
**
** Service Name:  CINT12S
**
** Description:   This service saves the data from Call Entry and modifies
**                the workload. 
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/6/94 
** 
** Programmer:    Mark Dunnagan, Andersen Consulting
**
** Archive Information: $Revision:   1.13  $
**                      $Date:   09 Apr 1999 16:06:00  $
**                      $Modtime:   06 Apr 1999 18:05:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/30/95  GUGLIEBS  Changed to reflect new INCOMING_DETAIL table.
**                      (NBR INCMG UNIT and CD INCMG REGION)
**
**  06/06/95  GUGLIEBS  Change for new CCMN80D - Query for
**                      ID_STAGE_PERSON_LINK and use to pass to CCMN80D.
**                      (PWO 569)
**
**  06/13/95  GUGLIEBS  Changed element used for the INCOMING_DETAIL
**                      CD_INCMG_REGION insert (from
**                      UnitStruct.szCdUnitRegion to
**                      CallEntrySvcStruct.szCdIncmgRegion)
**
**  06/14/95  GUGLIEBS  Was creating duplicate events and multiple
**                      situations due to the fact that the ID_EVENT
**                      wasn't always being populated in the
**                      CallEntryOutStruct and that the ID_SITUATION
**                      wasn't being returned on an update in the output
**                      record of the dam.
**
**  06/14/95  GUGLIEBS  Wasn't changing the CD_INCMG_STATUS to CLD for
**                      save and assign.
**
**  06/22/95  ELLIOTSL  Logic added to populate special handing information
**                      in the CAPS_CASE input message when the case is 
**                      created.
**
**  07/12/95  GUGLIEBS  Changed TodoType to TodoTask
**
**  08/01/95  DUNNAGME  SIR 1000 - Check added to allow creation of events
**                      for submission of I&Rs and Non-case related special
**                      requests.  They will not be deleted, as well, if 
**                      the user save and closes from within the Approval
**                      dialog.
**
**                      SIR 1012 - Add code to prevent creation of LE Notif
**                      ToDos for the supervisor.  Also, clean up if one 
**                      previously exists.
** 
**  08/10/95 DUNNAGME   SIR 1128 - Added code to remove Todos if user
**                      changes from an intake to I&R or Non-case related
**                      special request.
**
**                      SIR 1034 - Added code to delete Todos if user marks
**                      intake for deletion.
**
**  08/11/95 DUNNAGME   Added code to not invalidate approval todo if 
**                      status of call event is not pending.
**
**  08/15/95 DUNNAGME   Incorrect region variable was being populated in
**                      the CallEntrySvcStruct in the input message.  In
**                      the future, fixers reading these logs should be
**                      extremely careful not to make changes that
**                      complicate, confuse, or add elements to structures
**                      that already use an equivalent.
**
** 08/17/95  DUNNAGME   Timestamp functionality on ccmn80d seems to have 
**                      changed.  Added tsLastUpdate to cint20d so 
**                      delete and update of stage_person_link will 
**                      function correctly.
**  09/01/95    KRD     Modified due to data element name change of
**                      TsLastUpdate to tsLastUpdate.  Required a change to
**                      SendToDoToSupervisor().
**  09/15/95  HUSTONMJ  ERR#1395 - Cancelling out of Save and Assign or
**                      Submit and then saving to the workload was causing an
**                      APRV event, leaving the workers unable to modify the
**                      call from their workload.  Changes made to leave a
**                      COMP rather than APRV event.
**  09/21/95  HUSTONMJ  ERR#1478 - fix to ERR#1395
**
**  10/04/95  VISHNUR   SIR 1475 - Intake sometimes not showing up in
**                      workload.  The loss is pointed to losing id_unit in
**                      STAGE table.  To ensure that the id_unit is always
**                      available, the id_unit is put in
**                      pInputMsg->CallEntrySvcStruct when id_unit is
**                      retrieved in UpdateIncomingDetail function.
**                        
**  10/19/95  ELLIOTSL  ERR #1818: Logic added to CreateEvent to assure that
**                      a null date is never written and that the event 
**                      status is update whenever the intake is assigned.
**
**  01/24/96  ELLIOTSL  ERR #2909: When new records are created on the 
**                      STAGE, SITUATION and CAPS_CASE tables the 
**                      dtDtIncomingCall and tmTmIncmgCall needs to be 
**                      used for the start date and time.
** 03/19/96  OMARAJJ    SIR#2145 - Added id_resource to the save service
**                      to reflect the addition of this column to the 
**                      incoming_detail table. This variable is used to 
**                      generate the Notification L.E. form/facimile.  It
**                      is saved to the incoming_detail table where it
**                      retrieved during the creation of the form.
**4/19/96     HUGHESJR  Added CAUDC1D to update the stage person link
**                      table with an ID_CASE. This handles cases where
**                      the id_case did not already excist.
**
** 07/11/96   DYARGR    SIR 21786 - Memory not freed for CAUDC1D pointers.
**
** 07/26/96   zabihin   SIR 21891 : version control code was missing, I
**                      added the lines.
**  09/12/96    KRD     SIR 10881 - Ensured that I&Rs and non-case-related
**                      special requests do not have IdCase or IdSituation
**                      saved on the STAGE table.  Required a change to
**                      ModifyWorkload().
**  10/29/96    KRD     SIR 2928 - Removed IdAllegation from the output
**                      record of DAM CINT07D.  Required a changed to 
**                      SaveAndSubmitAndAssign().
**  11/27/96    KRD     SIR 22284 - Cleaned up service for maintainability
**                      and readability sake.  Changes included:
**                      1) Updated service to use a modified version of the
**                         Release 1 service shell.
**                      2) Moved the call to the Complex Delete package into
**                         its own DAM (DAM CINT74D) rather than being called
**                         directly from the service.
**                      3) Replaced macros PERSON_STAGE_ROLE_PRIMARY,
**                         NULL_INDICATOR, WINDOW_MODE_APPROVE,
**                         WINDOW_MODE_NEW_USING_OPEN,
**                         WINDOW_MODE_NEW_USING_CWA,
**                         WINDOW_MODE_NEW_USING_APS,
**                         WINDOW_MODE_NEW_USING_CAR, STATUS_CD_CLOSED,
**                         STATUS_CD_OPEN, STATUS_CD_SUBMITTED,
**                         STATUS_CD_MARK_FOR_DELETE, STAGE_TYPE_CD_IR,
**                         STAGE_TYPE_CD_SPECREQ, CLASSIFICATION_IR,
**                         CLASSIFICATION_SPECREQ, PROGRAM_CD_CHILD_LIC,
**                         PROGRAM_CD_RES_LIC, PROGRAM_CD_CPS
**                         with equivalents PRIMARY_ROLE_STAGE_OPEN,
**                         NULL_DATE, CAPS_WIN_MODE_APPRV,
**                         CAPS_WIN_MODE_NEW_USING_OPEN,
**                         CAPS_WIN_MODE_NEW_USING_CWA,
**                         CAPS_WIN_MODE_NEW_USING_APS,
**                         CAPS_WIN_MODE_NEW_USING_CAR,
**                         INCMG_STATUS_CD_CLOSED, INCMG_STATUS_CD_OPEN,
**                         INCMG_STATUS_CD_SUBMITTED,
**                         INCMG_STATUS_CD_MARK_DELETE, STAGE_CD_IR,
**                         STAGE_CD_SPECREQ, CLASS_IR, CLASS_SPC,
**                         CAPS_PROG_CCL, CAPS_PROG_RCL, CAPS_PROG_CPS
**                         from CAPS.H, ARCSRVR.H and INTAKE.H
**                      4) Removed macros STAGE_CD_INTAKE,
**                         REQ_FUNC_CD_MARK_FOR_DELETE, REQ_FUNC_CD_SAVE,
**                         REQ_FUNC_CD_SAVE_AND_ASSIGN,
**                         REQ_FUNC_CD_SAVE_AND_CLOSE,
**                         REQ_FUNC_CD_SAVE_AND_SUBMIT, RECORD_CALL_CD_TASK,
**                         NON_CASE_RELATED_PREFIX, 
**                         due to them already existing in CAPS.H, ARCSRVR.H
**                         and/or INTAKE.H
**                      5) Macros CASE_RELATED_PREFIX,
**                         EVENT_TYPE_STAGE_OPEN, TODO_DESC_LE_NOTIFICATION
**                         were defined but not used, so they have been
**                         removed.
**                      6) Replaced the function CreateEvent() and its
**                         DAMs with function CallPostEvent() which calls the
**                         PostEvent() common function.
**                      7) Removed unneccessary memory allocations from
**                         various functions
**                      8) Added check for rc prior to call to
**                         SendToDoToSupervisor()
**                      9) Modified SendToDoToSupervisor() to call the
**                         TodoCommonFunction().
**  01/06/97    KRD     SIR 22287 - DAM CINT55D has been altered in such a
**                      way that returning SQL_NOT_FOUND is a valid error.
**                      The error handling after the first call to the DAM in 
**                      RemoveFromWorkload() has been appropriately modified.
**                      The second DAM call in that function still considers
**                      SQL_NOT_FOUND to be acceptable (i.e., not an error).
**  02/05/97    KRD     SIR 12946 - The code to set the status of the Record
**                      Call event has been revisited due to a problem with
**                      duplicate approval events being created.  Required a
**                      change to CallPostEvent(). 
**   
**  04/11/97   SISSONM  SIR 11870 - I&Rs (and SPCs) were not being removed
**                      from the workloads of secondary workers when they
**                      were Save&Close'd or Mark'd for Deletion.  This
**                      would lead to Data Access Errors and other
**                      inconsistencies on the Assigned Workload window.
**                      Calls to DAMs CCMN80D and CINT20D in 
**                      RemoveFromWorkload() were replaced with a call to
**                      DAM CCMND3D to ensure that the I&Rs are properly
**                      removed.
**  05/22/97    klm     SIR 13725 - ModifyWorkLoad() was changed to ensure
**                      that the Classification is saved correctly.
** 
**  10/30/98    JJS     SIR 14354 - Pending Intake Closure Approvals are 
**                      not properly invalidated on the To_Do list because 
**                      the if statement checks to see if the call was
**                      submitted ("SBA").  SIR 13725 changed the call 
**                      status to open ("OPN") if an approval for a call
**                      is to be invalidated.  The previous SIR made a 
**                      change on the client but no subsequent change on
**                      server.   
**
**  01/22/98  SOHNJJ    SIR 15022 - Pending Intake Closure Approval To-Dos
**                      are not properly invalidated when they are accessed
**                      accessed through the "Case To-Dos" option from
**                      the Workload window.  The Invalidate function
**                      was only called when the window was NOT is Approval
**                      mode and when the intake was Open.  Now the
**                      Invalidate function will be called when the 
**                      window mode is in approval ("A") and the intake is
**                      in open ("OPN") or submitted ("SBA") status.
**
** 04/18/99   SOHNJJ    SIR #15169 -- This enhancement allows SWI supervisors
**                      to save or save and assign intakes in approval mode
**                      without invalidating the to-do.  The supervisor
**                      will be able to approve the to-do at any time after
**                      the save and assign.  However, if the worker goes
**                      back into the intake, the approval to-do will be
**                      invalidated.  This enhancement changes the way
**			SIR 15022 functions substantially.
**		
**  08/04/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**  
** 10/12/04    ochumd  Sir 23145 - Idcase and Idsituation were originally
**                     reset to zeros which were creating problems in the database.
**                     They are now being set to NULL_CHARACTER.
**
** 11/22/04    Ochumd  Sir# 23045 - each time a worker does new using, the
**                     UpdateIncomingDetail function is called also.  This should 
**                     not happen during new using or Delete.  The Update uses the
**                     info from the current record to update the newly created record
**                     hence the wrong worker phone number. Added code to prevent
**                     update after new using.
** 02/16/04    dejuanr SIR 16012 - It will only stay submitted if the Approve mode 
**                     and the Req Func is not Save and Close
** 07/20/05    ochumd  Sir 23720 - A check box and a comments box were added to the
**                     Special Handling Section on the Intake Actions page to track
**                     Methamphetamine cases.  As a result, two new columns were added
**                     to the Incoming_detail and caps_case tables.  Those new fields 
**                     were populated here for insert and update.
** 08/01/05    ochumd  Sir 23810 - Added cint79d.pc to count the number of PRNs with 
**                     Role of Client.
** 09/08/2005  ochumd  Sir 23647 - Any New Used Intake radio button should default 
**                     to original selection.  Currently it defaults to "CALL_TYPE_WKR_ID".
**                     Replaced :hI_szCdIncomingCallType:hI_szCdIncomingCallType_i with 
**                     CD_INCOMING_CALL_TYPE in the dam to ensure that original selection 
**                     is used at all times. 
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** 08/01/95 MED
*/

/*
** Extern for version control table.
*/






public class Cint12s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PERSON_TYPE_WORKER = "STF";
    public static final char REQ_FUNC_CD_NEW_USING = 'G';
    public static final String RECORD_CALL_EVENT_DESC = "Record call %lu.";
    public static final String NEW_USING_EVENT_DESC = "New using of call %lu.";
    public static final String TODO_LE_NOTIF_TASK = "1047";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final String EVENT_STATUS_APPROVED = "APRV";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String EVENT_TYPE_CALL = "CAL";
    public static final String EVENT_TYPE_PRIORITY_CHANGE = "PRT";
    public static final String EVENT_TYPE_NEW_USING = "STG";
    public static final char EVENT_NEW_USING_IND = 'N';
    public static final char EVENT_CHANGE_PRIORITY_IND = 'P';
    public static final String BUSINESS_PHONE_TYPE = "BS";
    public static final String CALL_TYPE_WKR_ID = "3";
    public static final String PRIORITY_EVENT_DESCR_ARROW = "->";
    /* ochumd  Sir 23810 Begin */
    public static final char APS_CRSR = 'C';
    public static final String PERSON_TYPE_PRN = "PRN";
    public static final String PERSON_ROLE_CLIENT = "CL";
    /* ochumd  Sir 23810 End   */
    /*
    ** 08/10/95 MED
    */
    public static final char REQ_FUNC_CD_DELETE_TODO = 'O';
    
    /*
    ** 08/15/95 MED   
    ** SIR #1164
    ** This #define is necessary for Workload to be able to sort items
    ** on the workload.  However, I am not aware of anywhere else in 
    ** the system where a character '0' is used instead of 0.  This does
    ** not seem like the proper value for a boolean, which the variable
    ** is named as.
    */
    public static final char EMP_IS_OLD = '0';
    
    /*
    ** SIR 22284 - Added macros used when calling the ToDo Common Function
    */
    public static final String TODO_CODE_LE_NOTIF = "INT001";
    
    
    
    public static final char CAPS_WIN_MODE_APPRV = 'A';
    public static final char CAPS_WIN_MODE_NEW_USING_APS = 'S';
    public static final char CAPS_WIN_MODE_NEW_USING_CWA = 'C';
    public static final char CAPS_WIN_MODE_NEW_USING_OPEN = 'O';
    int usPrnClientCounter = 0;/* Counter for Clients */
    
    /**************************************************************************
    ** Service Name:  CCMNA1S.SRC
    ***************************************************************************/
    static CINT12SI pInputMsg = null;
    static CINT12SO pOutputMsg = null;
    static int transactionflag = - 1;
    CINT12SO CINT12S(CINT12SI cint12si) {
        CINT12SO cint12so = new CINT12SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINT12S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINT12S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINT12S \n");
            bTransactionStarted = true;
        }
        String szCdStageClassification1 = new String();
        rc = ARC_PRFServiceStartTime_TUX(cint12si.ArchInputStruct);
        /* end SIR #20439: Added a new dam: cmsc50d */
        
        if ((CAPS_WIN_MODE_APPRV != cint12si.CallEntrySvcStruct.getSzSysCdWinMode()) && (0 == INCMG_STATUS_CD_OPEN.compareTo(cint12si.CallEntrySvcStruct.getCdIncmgStatus())) && (0 == EVENT_STATUS_PENDING.compareTo(cint12si.szCdEventStatus))) {
            
            //  Call DAM
            rc = InvalidateApproval(cint12si, cint12so, pServiceStatus);
        }
        
        /*
        ** If Merge Access is not Allowed, case is not closed and
        ** Search is needed than check if the logged in user is assigned to the
        ** given case as a primary worker.
        */
        if ((0 == cint12si.CallEntrySvcStruct.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) && (APS_CRSR == cint12si.CallEntrySvcStruct.getSzCdSpclReq()[0]) && ((REQ_FUNC_CD_SAVE_AND_SUBMIT == cint12si.ArchInputStruct.getCReqFuncCd()) || (REQ_FUNC_CD_SAVE_AND_ASSIGN == cint12si.ArchInputStruct.getCReqFuncCd()))) {
            
            // Call DAM to update person status to Inactive
            rc = CallCINT79D(cint12si, cint12so, pServiceStatus);
            if (usPrnClientCounter != 1) {
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INT_ROLE_CLIENT;
                rc = Messages.MSG_INT_ROLE_CLIENT;
            }
            else {
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
            }
        }
        if (!(rc != 0) && REQ_FUNC_CD_NEW_USING == cint12si.ArchInputStruct.getCReqFuncCd()) {
            rc = NewUsing(cint12si, cint12so, pServiceStatus, szCdStageClassification1);
        }
        if (!(rc != 0) && REQ_FUNC_CD_NEW_USING != cint12si.ArchInputStruct.getCReqFuncCd() && WtcHelperConstants.REQ_FUNC_CD_DELETE != cint12si.ArchInputStruct.getCReqFuncCd()) {
            
            //  Call DAM
            rc = UpdateIncomingDetail(cint12si, cint12so, pServiceStatus);
        }
        
        /*
        ** If MergeAccess indicator is Yes call Unit Access function
        ** for each primary worker returned in CLSC64DO, to determine
        ** if the logged in user is in the unit hierarchy of a primary 
        ** worker in the given case.
        */
        if (!(rc != 0) && (cint12si.CallEntrySvcStruct.getSzCdInfoAndRefrl()[0] != null || NON_CASE_RELATED_PREFIX == cint12si.CallEntrySvcStruct.getSzCdSpclReq()[0]) && (REQ_FUNC_CD_SAVE_AND_CLOSE == cint12si.ArchInputStruct.getCReqFuncCd() || Cint21s.REQ_FUNC_CD_SAVE == cint12si.ArchInputStruct.getCReqFuncCd() || REQ_FUNC_CD_SAVE_AND_SUBMIT == cint12si.ArchInputStruct.getCReqFuncCd() || REQ_FUNC_CD_SAVE_AND_ASSIGN == cint12si.ArchInputStruct.getCReqFuncCd())) {
            rc = CleanUpTables(cint12si, cint12so, pServiceStatus);
        }
        if (!(rc != 0) && (REQ_FUNC_CD_SAVE_AND_CLOSE == cint12si.ArchInputStruct.getCReqFuncCd() || REQ_FUNC_CD_MARK_FOR_DELETE == cint12si.ArchInputStruct.getCReqFuncCd())) {
            rc = RemoveFromWorkload(cint12si, cint12so, pServiceStatus);
        }
        if (!(rc != 0) && Cint21s.REQ_FUNC_CD_SAVE == cint12si.ArchInputStruct.getCReqFuncCd()) {
            rc = ModifyWorkload(cint12si, cint12so, pServiceStatus, szCdStageClassification1);
            
            //  Populate Output Message
            if (!(rc != 0) && 0 != cint12si.CallEntrySvcStruct.getUlIdEvent()) {
                rc = CallPostEvent(cint12si, cint12so, pServiceStatus, cint12si.CallEntrySvcStruct.getUlIdEvent() , (char) 0, null, null, null, null);
            }
        }
        if (!(rc != 0) && (REQ_FUNC_CD_SAVE_AND_SUBMIT == cint12si.ArchInputStruct.getCReqFuncCd() || REQ_FUNC_CD_SAVE_AND_ASSIGN == cint12si.ArchInputStruct.getCReqFuncCd())) {
            rc = SaveAndSubmitAndAssign(cint12si, cint12so, pServiceStatus, szCdStageClassification1);
        }
        
        if (!(rc != 0) && (0 == cint12si.CallEntrySvcStruct.getSzCdStageProgram().compareTo(CAPS_PROG_CCL) || 0 == cint12si.CallEntrySvcStruct.getSzCdStageProgram().compareTo(CAPS_PROG_RCL) || 0 == cint12si.CallEntrySvcStruct.getSzCdStageProgram().compareTo(Csub38s.CAPS_PROG_CPS)) && (REQ_FUNC_CD_SAVE_AND_SUBMIT == cint12si.ArchInputStruct.getCReqFuncCd() || REQ_FUNC_CD_SAVE_AND_ASSIGN == cint12si.ArchInputStruct.getCReqFuncCd()) && null == cint12si.CallEntrySvcStruct.getSzCdSpclReq()[0]) {
            
            //  Call DAM
            rc = SendToDoToSupervisor(cint12si, cint12so, pServiceStatus, szCdStageClassification1);
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        
        if (!(rc != 0) && WtcHelperConstants.REQ_FUNC_CD_DELETE == cint12si.ArchInputStruct.getCReqFuncCd()) {
            
            rc = CallCINT74D(cint12si, cint12so, pServiceStatus);
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint12si.ArchInputStruct, cint12so.ArchOutputStruct);
        
        /*
        ** Run-time versioning
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
        /* check to see if the Case indicator is true.  If so Call the DAM
        ** to retrieve everyone from the case.  If not Call the DAM to
        ** Retrieve everyone from the Stage
        */
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINT12S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINT12S\n");
        }
        return cint12so;
    }

    static int InvalidateApproval(CINT12SI pInputMsg438, CINT12SO pOutputMsg404, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN05UI pCCMN05UInputRec = null;
        CCMN05UO pCCMN05UOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN05UInputRec = new CCMN05UI();
        pCCMN05UOutputRec = new CCMN05UO();
        pCCMN05UInputRec.setArchInputStruct(pInputMsg438.ArchInputStruct);
        pCCMN05UInputRec.setUlIdEvent(pInputMsg438.CallEntrySvcStruct.getUlIdEvent());
        
        
        /*
        ** Call CMSC39D
        */
        rc = Ccmn05u.InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                //  To-Do Arch Enh BEGIN
                //  To-Do Arch Enh END
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
        }
        
        if (!(rc != 0)) {
            rc = CallPostEvent(pInputMsg438, pOutputMsg404, pServiceStatus, pInputMsg438.CallEntrySvcStruct.getUlIdEvent() , (char) 0, null, null, null, null);
        }
        return rc;
    }

    static int UpdateIncomingDetail(CINT12SI pInputMsg439, CINT12SO pOutputMsg405, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /* Declare local variables*/
        CINT02DI pCINT02DInputRec = null;
        CINT02DO pCINT02DOutputRec = null;
        CINT07DI pCINT07DInputRec = null;
        CINT07DO pCINT07DOutputRec = null;
        CCMNC0DI pCCMNC0DInputRec = null;
        CCMNC0DO pCCMNC0DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCCMNC0DInputRec = new CCMNC0DI();
        pCCMNC0DOutputRec = new CCMNC0DO();
        pCINT02DInputRec = new CINT02DI();
        pCINT02DOutputRec = new CINT02DO();
        pCINT07DInputRec = new CINT07DI();
        pCINT07DOutputRec = new CINT07DO();
        
        /*
        ** Start Sir #13369 durang
        ** Start Sir #13369b durang -Added NINETY_FIVE condition
        */
        if ((pCCMNC0DInputRec == null) || (pCCMNC0DOutputRec == null) || (pCINT02DInputRec == null) || (pCINT02DOutputRec == null) || (pCINT07DInputRec == null) || (pCINT07DOutputRec == null)) {
            Cint14s.FreePointers(6, new Object[]{
                new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
            );
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (!(pInputMsg439.CallEntrySvcStruct.getUlIdUnit() != 0)) {
            pCCMNC0DInputRec.setSzCdUnitProgram(pInputMsg439.UnitStruct.getSzCdUnitProgram());
            pCCMNC0DInputRec.setSzCdUnitRegion(pInputMsg439.UnitStruct.getSzCdUnitRegion());
            pCCMNC0DInputRec.setSzNbrUnit(pInputMsg439.UnitStruct.getSzNbrUnit());
            
            //  Call CSES63D
            rc = ccmnc0dQUERYdam(sqlca, pCCMNC0DInputRec, pCCMNC0DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(6, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    break;
            }
            if (!(rc != 0)) {
                pOutputMsg405.CreateCallOutStruct.setUlIdUnit(pCCMNC0DOutputRec.getUlIdUnit());
                pInputMsg439.CallEntrySvcStruct.setUlIdUnit(pCCMNC0DOutputRec.getUlIdUnit());
                pCINT02DInputRec.setSzNbrIncmgUnit(pCCMNC0DOutputRec.getSzNbrUnit());
                rc = FindUserInformation(pInputMsg439, pOutputMsg405, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case SUCCESS:
                        pCINT02DInputRec.setLNbrIncWkrPhone(pOutputMsg405.CINTS025G01.getLNbrPhone());
                        pCINT02DInputRec.setLNbrIncWkrExt(pOutputMsg405.CINTS025G01.getLNbrPhoneExtension());
                        
                        break;
                    case NO_DATA_FOUND:
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        break;
                        
                    default :
                        
                        break;
                }
            }
        }
        if (!(rc != 0)) {
            if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg439.ArchInputStruct.getCReqFuncCd()) {
                
                
                //  Call CMSC43D
                rc = ARC_UTLGetDateAndTime(pCINT02DInputRec.getDtDtIncomingCall() , pCINT02DInputRec.getTmTmIncmgCall());
                
                // 
                // END: CINV81D - END SIR 3596
                // 
                
                
                if (rc != 0) {
                    Cint14s.FreePointers(6, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pCINT02DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCINT02DInputRec.setSzCdIncmgRegion(pInputMsg439.CallEntrySvcStruct.getSzCdIncmgRegion());
            }
            
            
            else {
                pCINT07DInputRec.setUlIdStage(pInputMsg439.CallEntrySvcStruct.getUlIdStage());
                rc = cint07dQUERYdam(sqlca, pCINT07DInputRec, pCINT07DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        break;
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Cint14s.FreePointers(6, new Object[]{
                            new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                        );
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
                pCINT02DInputRec.setDtDtIncomingCall(pInputMsg439.CallEntrySvcStruct.getDtDtIncomingCall());
                pCINT02DInputRec.setTmTmIncmgCall(pInputMsg439.CallEntrySvcStruct.getTmTmIncmgCall());
                pCINT02DInputRec.setLNbrIncWkrPhone(pInputMsg439.CallEntrySvcStruct.getLNbrIncWkrPhone());
                pCINT02DInputRec.setLNbrIncWkrExt(pInputMsg439.CallEntrySvcStruct.getLNbrIncWkrExt());
                pCINT02DInputRec.setSzCdIncmgSpecHandling(pCINT07DOutputRec.getSzCdIncmgSpecHandling());
                pCINT02DInputRec.setTxtIncmgWorkerSafety(pCINT07DOutputRec.getTxtIncmgWorkerSafety());
                pCINT02DInputRec.setTxtIncomgSensitive(pCINT07DOutputRec.getTxtIncomgSensitive());
                pCINT02DInputRec.setBIndIncmgSensitive(pCINT07DOutputRec.getBIndIncmgSensitive());
                pCINT02DInputRec.setTxtIncomgSuspMeth(pCINT07DOutputRec.getTxtIncomgSuspMeth());
                pCINT02DInputRec.setBIndIncmgSuspMeth(pCINT07DOutputRec.getBIndIncmgSuspMeth());
                pCINT02DInputRec.setBIndIncmgWorkerSafety(pCINT07DOutputRec.getBIndIncmgWorkerSafety());
                pCINT02DInputRec.setBIndIncmgNoFactor(pCINT07DOutputRec.getBIndIncmgNoFactor());
                pCINT02DInputRec.setUlIdEvent(pCINT07DOutputRec.getUlIdEvent());
                pCINT02DInputRec.setSzCdIncmgAllegType(pCINT07DOutputRec.getSzCdIncmgAllegType());
                pCINT02DInputRec.setSzCdIncmgRegion(pCINT07DOutputRec.getSzCdIncmgRegion());
                pInputMsg439.CallEntrySvcStruct.setSzCdIncmgRegion(pCINT07DOutputRec.getSzCdIncmgRegion());
                pCINT02DInputRec.setSzNbrIncmgUnit(pCINT07DOutputRec.getSzNbrIncmgUnit());
                if (pInputMsg439.CallEntrySvcStruct.getSzCdIncomingCallType() != null) {
                    pCINT02DInputRec.setSzCdIncomingCallType(pInputMsg439.CallEntrySvcStruct.getSzCdIncomingCallType());
                }
                else {
                    pCINT02DInputRec.setSzCdIncomingCallType(pCINT07DOutputRec.getSzCdIncomingCallType());
                }
                pCINT02DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
        }
        if (!(rc != 0)) {
            pCINT02DInputRec.setUlIdPerson(pInputMsg439.CallEntrySvcStruct.getUlIdPerson());
            pCINT02DInputRec.setSzCdIncmgSex(pInputMsg439.CallEntrySvcStruct.getSzCdIncmgSex());
            pCINT02DInputRec.setSzCdIncmgAllegType(pInputMsg439.CallEntrySvcStruct.getSzCdIncmgAllegType());
            pCINT02DInputRec.setSzAddrIncmgStreetLn1(pInputMsg439.CallEntrySvcStruct.getSzAddrIncmgStreetLn1());
            pCINT02DInputRec.setSzAddrIncmgStreetLn2(pInputMsg439.CallEntrySvcStruct.getSzAddrIncmgStreetLn2());
            pCINT02DInputRec.setSzCdIncmgAddrType(pInputMsg439.CallEntrySvcStruct.getSzCdIncmgAddrType());
            pCINT02DInputRec.setSzAddrIncomingCallerCity(pInputMsg439.CallEntrySvcStruct.getSzAddrIncomingCallerCity());
            pCINT02DInputRec.setSzCdIncomingCallerState(pInputMsg439.CallEntrySvcStruct.getSzCdIncomingCallerState());
            pCINT02DInputRec.setSzAddrIncmgZip(pInputMsg439.CallEntrySvcStruct.getSzAddrIncmgZip());
            pCINT02DInputRec.setSzCdIncomingCallerCounty(pInputMsg439.CallEntrySvcStruct.getSzCdIncomingCallerCounty());
            pCINT02DInputRec.setSzNmIncmgRegardingFirst(pInputMsg439.CallEntrySvcStruct.getSzNmIncmgRegardingFirst());
            pCINT02DInputRec.setSzNmIncmgRegardingLast(pInputMsg439.CallEntrySvcStruct.getSzNmIncmgRegardingLast());
            pCINT02DInputRec.setSzCdIncomingDisposition(pInputMsg439.CallEntrySvcStruct.getSzCdIncomingDisposition());
            pCINT02DInputRec.setCdIncomingProgramType(pInputMsg439.CallEntrySvcStruct.getCdIncomingProgramType());
            pCINT02DInputRec.setUlIdStage(pInputMsg439.CallEntrySvcStruct.getUlIdStage());
            pCINT02DInputRec.setSzCdIncomingCallType(pInputMsg439.CallEntrySvcStruct.getSzCdIncomingCallType());
            pCINT02DInputRec.setNmIncomingCallerFirst(pInputMsg439.CallEntrySvcStruct.getNmIncomingCallerFirst());
            pCINT02DInputRec.setNmIncomingCallerLast(pInputMsg439.CallEntrySvcStruct.getNmIncomingCallerLast());
            pCINT02DInputRec.setNmIncomingCallerMiddle(pInputMsg439.CallEntrySvcStruct.getNmIncomingCallerMiddle());
            pCINT02DInputRec.setSzAddrIncWkrCity(pInputMsg439.CallEntrySvcStruct.getSzAddrIncWkrCity());
            pCINT02DInputRec.setSzNmIncWkrName(pInputMsg439.CallEntrySvcStruct.getSzNmIncWkrName());
            
            pCINT02DInputRec.setCdIncomingCallerSuffix(pInputMsg439.CallEntrySvcStruct.getCdIncomingCallerSuffix());
            
            pCINT02DInputRec.setSzNbrIncomingCallerPhone(pInputMsg439.CallEntrySvcStruct.getSzNbrIncomingCallerPhone());
            pCINT02DInputRec.setSzNbrIncmgCallerExt(pInputMsg439.CallEntrySvcStruct.getSzNbrIncmgCallerExt());
            pCINT02DInputRec.setSzCdIncmgPhoneType(pInputMsg439.CallEntrySvcStruct.getSzCdIncmgPhoneType());
            
            //## BEGIN TUX/XML: Declare XML variables 
            pCINT02DInputRec.setSzNmJurisdiction(pInputMsg439.CallEntrySvcStruct.getSzNmJurisdiction());
            pCINT02DInputRec.setUlIdResource(pInputMsg439.CallEntrySvcStruct.getUlIdResource());
            pCINT02DInputRec.setSzCdIncmgCallerInt(pInputMsg439.CallEntrySvcStruct.getSzCdIncmgCallerInt());
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            // 01/22/2003 DWW: Added for error handling
            if (((REQ_FUNC_CD_SAVE_AND_SUBMIT == pInputMsg439.ArchInputStruct.getCReqFuncCd()) || ((CAPS_WIN_MODE_APPRV == pInputMsg439.CallEntrySvcStruct.getSzSysCdWinMode()) && (REQ_FUNC_CD_SAVE_AND_CLOSE != pInputMsg439.ArchInputStruct.getCReqFuncCd()))) && (REQ_FUNC_CD_MARK_FOR_DELETE != pInputMsg439.ArchInputStruct.getCReqFuncCd())) {
                pCINT02DInputRec.setCdIncmgStatus(INCMG_STATUS_CD_SUBMITTED);
            }
            
            
            //  Save And Assign and Save And Close will
            // set the status to closed.
            else if ((REQ_FUNC_CD_SAVE_AND_ASSIGN == pInputMsg439.ArchInputStruct.getCReqFuncCd()) || (REQ_FUNC_CD_SAVE_AND_CLOSE == pInputMsg439.ArchInputStruct.getCReqFuncCd())) {
                pCINT02DInputRec.setCdIncmgStatus(INCMG_STATUS_CD_CLOSED);
            }
            
            
            else if (REQ_FUNC_CD_MARK_FOR_DELETE == pInputMsg439.ArchInputStruct.getCReqFuncCd()) {
                pCINT02DInputRec.setCdIncmgStatus(INCMG_STATUS_CD_MARK_DELETE);
            }
            
            
            else {
                pCINT02DInputRec.setCdIncmgStatus(INCMG_STATUS_CD_OPEN);
            }
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if ((REQ_FUNC_CD_SAVE_AND_CLOSE == pInputMsg439.ArchInputStruct.getCReqFuncCd()) || (REQ_FUNC_CD_SAVE_AND_ASSIGN == pInputMsg439.ArchInputStruct.getCReqFuncCd()) || (REQ_FUNC_CD_MARK_FOR_DELETE == pInputMsg439.ArchInputStruct.getCReqFuncCd())) {
                rc = ARC_UTLGetDateAndTime(pCINT02DInputRec.getDtIncomingCallDisposed() , pCINT02DInputRec.getTmSysTmCallDisp());
                if (rc != 0) {
                    Cint14s.FreePointers(6, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            
            else {
                pCINT02DInputRec.getDtIncomingCallDisposed().year = DateHelper.NULL_DATE;
                pCINT02DInputRec.getDtIncomingCallDisposed().month = DateHelper.NULL_DATE;
                pCINT02DInputRec.getDtIncomingCallDisposed().day = DateHelper.NULL_DATE;
            }
            
            
            //  Call CAUDA5D
            rc = cint02dAUDdam(sqlca, pCINT02DInputRec, pCINT02DOutputRec);
            
            
            // Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    
                    Cint14s.FreePointers(6, new Object[]{
                        
                        
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
            }
        }
        if (!(rc != 0)) {
            
            //  If lRC is <= 0 then then the closure date is before
            // or on the effective date and therefore is invalid
            if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg439.ArchInputStruct.getCReqFuncCd()) {
                pOutputMsg405.CreateCallOutStruct.setDtDtIncomingCall(pCINT02DInputRec.getDtDtIncomingCall());
                pOutputMsg405.CreateCallOutStruct.setTmTmIncmgCall(pCINT02DInputRec.getTmTmIncmgCall());
                pOutputMsg405.CreateCallOutStruct.setUlIdStage(pCINT02DOutputRec.getUlIdStage());
                
                //set rc value to FND_FAIL
                rc = UpdateTemporaryWorkload(pInputMsg439, pOutputMsg405, pServiceStatus);
            }
        }
        Cint14s.FreePointers(6, new Object[]{
            new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
        );
        return rc;
    }

    static int ModifyWorkload(CINT12SI pInputMsg440, CINT12SO pOutputMsg406, Arcxmlerrors.TUX_DECL_STATUSPARMS, String szCdStageClassification2) {
        int rc = 0;/* Return code */
        /* Declare local variables*/
        CCMN81DI pCCMN81DInputRec = null;
        CCMN81DO pCCMN81DOutputRec = null;
        CCMN80DI pCCMN80DInputRec = null;
        CCMN80DO pCCMN80DOutputRec = null;
        CINT20DI pCINT20DInputRec = null;
        CINT20DO pCINT20DOutputRec = null;
        CINT12DI pCINT12DInputRec = null;
        CINT12DO pCINT12DOutputRec = null;
        CINT21DI pCINT21DInputRec = null;/* Get NmPersonFull given IdPerson */
        
        
        CINT21DO pCINT21DOutputRec = null;
        CAUDC1DI pCAUDC1DInputRec = null;
        CAUDC1DO pCAUDC1DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCCMN81DInputRec = new CCMN81DI();
        pCCMN81DOutputRec = new CCMN81DO();
        pCCMN80DInputRec = new CCMN80DI();
        pCCMN80DOutputRec = new CCMN80DO();
        pCINT20DInputRec = new CINT20DI();
        pCINT20DOutputRec = new CINT20DO();
        pCINT12DInputRec = new CINT12DI();
        pCINT12DOutputRec = new CINT12DO();
        pCINT21DInputRec = new CINT21DI();
        pCINT21DOutputRec = new CINT21DO();
        pCAUDC1DInputRec = new CAUDC1DI();
        pCAUDC1DOutputRec = new CAUDC1DO();
        
        /*
        ** If DELETE, perform deletion based on stage of service and existence of
        ** duplicates.
        */
        if ((pCCMN81DInputRec == null) || (pCCMN81DOutputRec == null) || (pCCMN80DInputRec == null) || (pCCMN80DOutputRec == null) || (pCINT20DInputRec == null) || (pCINT20DOutputRec == null) || (pCINT12DInputRec == null) || (pCINT12DOutputRec == null) || (pCINT21DInputRec == null) || (pCINT21DOutputRec == null) || (pCAUDC1DInputRec == null) || (pCAUDC1DOutputRec == null)) {
            Cint14s.FreePointers(12, new Object[]{
                new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
            );
            
            //  Set rc to ARC_SUCCESS
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCINT20DInputRec.setUlIdStage(pInputMsg440.CallEntrySvcStruct.getUlIdStage());
        pCINT20DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
        pCINT20DInputRec.setSzCdStagePersType(PERSON_TYPE_WORKER);
        
        /*
        ** Call DAM
        */
        rc = cint20dQUERYdam(sqlca, pCINT20DInputRec, pCINT20DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pCCMN80DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                pCCMN80DInputRec.setTsLastUpdate(pCINT20DOutputRec.getTsLastUpdate());
                pCCMN80DInputRec.setUlIdStagePerson(pCINT20DOutputRec.getUlIdStagePerson());
                break;
            case NO_DATA_FOUND:
                pCCMN80DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Cint14s.FreePointers(12, new Object[]{
                    
                    new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        if /* stage is not INTAKE; delete the allegation */
        (!(rc != 0)) {
            pCINT21DInputRec.setUlIdStage(pInputMsg440.CallEntrySvcStruct.getUlIdStage());
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCINT12DInputRec.setSzCdStageCurrPriority(pCINT21DOutputRec.getSzCdStageCurrPriority());
                    pCINT12DInputRec.setSzCdStageInitialPriority(pCINT21DOutputRec.getSzCdStageInitialPriority());
                    pCINT12DInputRec.setSzCdStageReasonClosed(pCINT21DOutputRec.getSzCdStageReasonClosed());
                    pCINT12DInputRec.setSzCdStageRegion(pInputMsg440.CallEntrySvcStruct.getSzCdIncmgRegion());
                    pCINT12DInputRec.setSzCdStageRsnPriorityChgd(pCINT21DOutputRec.getSzCdStageRsnPriorityChgd());
                    pCINT12DInputRec.setSzCdStageClassification(pCINT21DOutputRec.getSzCdStageClassification());
                    pCINT12DInputRec.setTmSysTmStageStart(pCINT21DOutputRec.getTmSysTmStageStart());
                    pCINT12DInputRec.setDtDtStageStart(pCINT21DOutputRec.getDtDtStageStart());
                    
                    pCINT12DInputRec.setUlIdStage(pCINT21DInputRec.getUlIdStage());
                    pCINT12DInputRec.setUlIdUnit(pCINT21DOutputRec.getUlIdUnit());
                    pCINT12DInputRec.setSzNmStage(pCINT21DOutputRec.getSzNmStage());
                    pCINT12DInputRec.setSzTxtStagePriorityCmnts(pCINT21DOutputRec.getSzTxtStagePriorityCmnts());
                    pCINT12DInputRec.setSzTxtStageClosureCmnts(pCINT21DOutputRec.getSzTxtStageClosureCmnts());
                    pCINT12DInputRec.setBIndStageClose(pCINT21DOutputRec.getBIndStageClose());
                    pCINT12DInputRec.setTsLastUpdate(pCINT21DOutputRec.getTsLastUpdate());
                    break;
                case NO_DATA_FOUND:
                    pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCINT12DInputRec.setDtDtStageStart(pInputMsg440.CallEntrySvcStruct.getDtDtIncomingCall());
                    pCINT12DInputRec.setTmSysTmStageStart(pInputMsg440.CallEntrySvcStruct.getTmTmIncmgCall());
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        if (!(rc != 0)) {
            // ERR 1421: The following has been added to blank out the disposition.
            // There is no switch statement because there are no acceptable errors.
            if (REQ_FUNC_CD_SAVE_AND_ASSIGN != pInputMsg440.ArchInputStruct.getCReqFuncCd()) {
                pCINT12DInputRec.getDtDtStageClose().year = DateHelper.NULL_DATE;
                pCINT12DInputRec.getDtDtStageClose().month = DateHelper.NULL_DATE;
                
                pCINT12DInputRec.getDtDtStageClose().day = DateHelper.NULL_DATE;
                pCINT12DInputRec.setBIndStageClose(FND_NO);
            }
            
            
            else {
                pCINT12DInputRec.getDtDtStageClose().year = DateHelper.NULL_DATE;
                pCINT12DInputRec.getDtDtStageClose().month = DateHelper.NULL_DATE;
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pCINT12DInputRec.getDtDtStageClose().day = DateHelper.NULL_DATE;
                
                //  Determine victim's and perp's new roles, based on
                // their remaining allegations:
                // Named As         New Role
                // Victim & Perp    VICTIM_PERP
                // Victim Only      ALLEGED_VICTIM
                // Perp Only        ALLEGED_PERP
                // No Remaining     NO_ROLE
                // Allegations
                
                // Victim Role
                if (rc != 0) {
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                    
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pCINT12DInputRec.setSzCdStageReasonClosed(pInputMsg440.CallEntrySvcStruct.getSzCdStageReasonClosed());
            }
            
            if (!(pCINT12DInputRec.getSzNmStage()[0] != null)) {
                pCINT12DInputRec.setSzNmStage(pInputMsg440.CallEntrySvcStruct.getSzNmStage());
            }
            pCINT12DInputRec.setUlIdStage(pInputMsg440.CallEntrySvcStruct.getUlIdStage());
            pCINT12DInputRec.setSzCdStageCnty(pInputMsg440.CallEntrySvcStruct.getSzCdStageCnty());
            pCINT12DInputRec.setSzCdStageType(pInputMsg440.CallEntrySvcStruct.getSzCdStageType());
            pCINT12DInputRec.setSzCdStageProgram(pInputMsg440.CallEntrySvcStruct.getSzCdStageProgram());
            pCINT12DInputRec.setSzCdStage(pInputMsg440.CallEntrySvcStruct.getSzCdStage());
            
            if ((0 == pInputMsg440.CallEntrySvcStruct.getSzCdStage().compareTo(STAGE_CD_IR)) || (0 == pInputMsg440.CallEntrySvcStruct.getSzCdStage().compareTo(STAGE_CD_SPECREQ))) {
                pInputMsg440.CallEntrySvcStruct.setUlIdCase(null);
                pInputMsg440.CallEntrySvcStruct.setUlIdSituation(null);
            }
            pCINT12DInputRec.setUlIdCase(pInputMsg440.CallEntrySvcStruct.getUlIdCase());
            pCINT12DInputRec.setUlIdSituation(pInputMsg440.CallEntrySvcStruct.getUlIdSituation());
            pCINT12DInputRec.setSzCdStageRegion(pInputMsg440.CallEntrySvcStruct.getSzCdIncmgRegion());
            pCINT12DInputRec.setUlIdUnit(pInputMsg440.CallEntrySvcStruct.getUlIdUnit());
            
            if ((0 == pCINT12DInputRec.getSzCdStageClassification().compareTo(CLASS_IR)) || (0 == pCINT12DInputRec.getSzCdStageClassification().compareTo(CLASS_SPC))) {
                
                pCINT12DInputRec.getSzCdStageClassification()[0] = null;
            }
            
            
            // Perp Role
            if (null != pInputMsg440.CallEntrySvcStruct.getSzCdInfoAndRefrl()[0]) {
                pCINT12DInputRec.setSzCdStageClassification(CLASS_IR);
            }
            
            else if (null != pInputMsg440.CallEntrySvcStruct.getSzCdSpclReq()[0]) {
                pCINT12DInputRec.setSzCdStageClassification(CLASS_SPC);
            }
            
            //  Call DAM
            rc = cint12dAUDdam(sqlca, pCINT12DInputRec, pCINT12DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        if (!(rc != 0)) {
            
            if (WtcHelperConstants.REQ_FUNC_CD_UPDATE != pCCMN80DInputRec.getArchInputStruct().getCReqFuncCd()) {
                
                //  Set rc to ARC_SUCCESS
                rc = ARC_UTLGetDateAndTime(pCCMN80DInputRec.getDtDtStagePersLink() , 0);
                
                if (rc != 0) {
                    
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pCCMN80DInputRec.setUlIdPerson(pInputMsg440.CallEntrySvcStruct.getUlIdPerson());
                pCCMN80DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
                pCCMN80DInputRec.setSzCdStagePersType(PERSON_TYPE_WORKER);
                pCCMN80DInputRec.setUlIdStage(pInputMsg440.CallEntrySvcStruct.getUlIdStage());
                pCCMN80DInputRec.setBIndStagePersEmpNew(EMP_IS_OLD);
                
                //  Call DAM
                rc = ccmn80dAUDdam(sqlca, pCCMN80DInputRec, pCCMN80DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;
                        
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Cint14s.FreePointers(12, new Object[]{
                            new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                        );
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
        }
        if /* duplicate exists; allow deletion */
        (!(rc != 0)) {
            
            pCCMN81DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN81DInputRec.setDtDtEmpLastAssigned(pCCMN80DInputRec.getDtDtStagePersLink());
            pCCMN81DInputRec.setUlIdPerson(pInputMsg440.CallEntrySvcStruct.getUlIdPerson());
            
            //  Set rc to ARC_SUCCESS
            rc = ccmn81dAUDdam(sqlca, pCCMN81DInputRec, pCCMN81DOutputRec);
            
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        pCAUDC1DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        pCAUDC1DInputRec.setUlIdStage(pInputMsg440.CallEntrySvcStruct.getUlIdStage());
        
        pCAUDC1DInputRec.setUlIdCase(pOutputMsg406.CreateCallOutStruct.getUlIdCase());
        rc = caudc1dAUDdam(sqlca, pCAUDC1DInputRec, pCAUDC1DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Cint14s.FreePointers(12, new Object[]{
                    new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
                );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        if (EVENT_CHANGE_PRIORITY_IND == pInputMsg440.cSysIndEventToCreate &&!(rc != 0)) {
            rc = CallPostEvent(pInputMsg440, pOutputMsg406, pServiceStatus, 0, EVENT_CHANGE_PRIORITY_IND, pInputMsg440.szCdStageCurrPriority, pCINT12DInputRec.getSzCdStageCurrPriority() , pCINT21DOutputRec.getSzTxtStagePriorityCmnts() , pCINT21DOutputRec.getSzCdStageRsnPriorityChgd());
            
        }
        /* ERR 1421: The following has been added to blank out the disposition.
        ** There is no switch statement because there are no acceptable errors.
        */
        if (!(rc != 0)) {
            rc = UpdateTemporaryWorkload(pInputMsg440, pOutputMsg406, pServiceStatus);
        }
        szCdStageClassification2 = pCINT12DInputRec.getSzCdStageClassification();
        Cint14s.FreePointers(12, new Object[]{
            new Object[]{pCCMN81DInputRec, pCCMN81DOutputRec, pCCMN80DInputRec, pCCMN80DOutputRec, pCINT20DInputRec, pCINT20DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCAUDC1DInputRec, pCAUDC1DOutputRec}}
        
        );
        return rc;
    }

    static int SaveAndSubmitAndAssign(CINT12SI pInputMsg441, CINT12SO pOutputMsg407, Arcxmlerrors.TUX_DECL_STATUSPARMS, String szCdStageClassification3) {
        int rc = 0;/* Return code */
        /* Declare local variables*/
        char bOKToCreateCaseAndSituation = 1;
        CINT07DI pCINT07DInputRec = null;
        CINT07DO pCINT07DOutputRec = null;
        CCMNB2DI pCCMNB2DInputRec = null;
        CCMNB2DO pCCMNB2DOutputRec = null;
        
        /*
        ** CCMN45D - GET EVENT SMP -- WHAT IT DOES, WHEN IT IS CALLED, ETC.
        */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        CCMNB1DI pCCMNB1DInputRec = null;
        CCMNB1DO pCCMNB1DOutputRec = null;
        CINT02DI pCINT02DInputRec = null;
        CINT02DO pCINT02DOutputRec = null;
        CINT13DI pCINT13DInputRec = null;
        CINT13DO pCINT13DOutputRec = null;
        CINT24DI pCINT24DInputRec = null;
        CINT24DO pCINT24DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCCMNB1DInputRec = new CCMNB1DI();
        pCCMNB1DOutputRec = new CCMNB1DO();
        pCCMNB2DInputRec = new CCMNB2DI();
        pCCMNB2DOutputRec = new CCMNB2DO();
        pCINT21DInputRec = new CINT21DI();
        pCINT21DOutputRec = new CINT21DO();
        pCINT02DInputRec = new CINT02DI();
        pCINT02DOutputRec = new CINT02DO();
        pCINT13DInputRec = new CINT13DI();
        pCINT13DOutputRec = new CINT13DO();
        pCINT24DInputRec = new CINT24DI();
        pCINT24DOutputRec = new CINT24DO();
        pCINT07DInputRec = new CINT07DI();
        pCINT07DOutputRec = new CINT07DO();
        
        if ((pCCMNB1DInputRec == null) || (pCCMNB1DOutputRec == null) || (pCCMNB2DInputRec == null) || (pCCMNB2DOutputRec == null) || (pCINT21DInputRec == null) || (pCINT21DOutputRec == null) || (pCINT02DInputRec == null) || (pCINT02DOutputRec == null) || (pCINT13DInputRec == null) || (pCINT13DOutputRec == null) || (pCINT24DInputRec == null) || (pCINT24DOutputRec == null) || (pCINT07DInputRec == null) || (pCINT07DOutputRec == null)) {
            Cint14s.FreePointers(14, new Object[]{
                new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
            );
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        
        if (!(rc != 0)) {
            pCINT07DInputRec.setUlIdStage(pInputMsg441.CallEntrySvcStruct.getUlIdStage());
            rc = cint07dQUERYdam(sqlca, pCINT07DInputRec, pCINT07DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(14, new Object[]{
                        new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        if (!(rc != 0)) {
            pCINT21DInputRec.setUlIdStage(pInputMsg441.CallEntrySvcStruct.getUlIdStage());
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    
                    
                    
                    //  Start Performance Timer
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(14, new Object[]{
                        
                        new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        if (!(rc != 0)) {
            
            //  SIR #3274 - 2/23/96 - PURCELA - This logic was missing from updates
            // to Caps Resource.  If the home is Non Prs, then the Facility Type
            // needs to be reset to Private Agency.  Otherwise it is an F/A Home.
            // This logic also remedies the problem described in SIR #3320. Also,
            // the Resource Status needs to be updated if changing PRS and Non PRS
            // back and forth updates the F/A Home Status.
            
            if (pCINT21DOutputRec.getUlIdSituation() != 0) {
                pCINT24DInputRec.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                rc = cint24dQUERYdam(sqlca, pCINT24DInputRec, pCINT24DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pCINT13DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        pCINT13DInputRec.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                        pInputMsg441.CallEntrySvcStruct.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                        break;
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Cint14s.FreePointers(14, new Object[]{
                            new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                        );
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
            
            
            
            //  If there is no IdSituation, a Situation will be added
            // to the database.
            else {
                pCINT13DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
        }
        
        if (!(rc != 0) && pCINT21DOutputRec.getUlIdCase() != 0) {
            pCCMNB1DInputRec.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
            rc = ccmnb1dQUERYdam(sqlca, pCCMNB1DInputRec, pCCMNB1DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(14, new Object[]{
                        new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        
        
        
        /************************************************************************
        ** (END): Create/Update CAPS Resource
        ************************************************************************/
        
        /************************************************************************
        ** (BEGIN): Add / Update / Delete Resource Address
        ************************************************************************/
        
        if (!(rc != 0) && (0 == pInputMsg441.CallEntrySvcStruct.getSzCdStage().compareTo(STAGE_CD_IR) || 0 == pInputMsg441.CallEntrySvcStruct.getSzCdStage().compareTo(STAGE_CD_SPECREQ))) {
            //  Set flag so that program can decide whether or not to
            // create a case or situation.
            bOKToCreateCaseAndSituation = 0;
            pInputMsg441.CallEntrySvcStruct.setUlIdCase(0);
            pInputMsg441.CallEntrySvcStruct.setUlIdSituation(0);
            pOutputMsg407.CreateCallOutStruct.setUlIdEvent(0);
        }
        
        
        /*
        ** Modify the case information as needed.  Add a row if there 
        ** is no IdCase in the Stage table.  Otherwise, update the 
        ** existing row.
        */
        else if (!(rc != 0) && pCINT21DOutputRec.getUlIdCase() != 0) {
            pCCMNB2DInputRec.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
            pCCMNB2DInputRec.setBIndCaseArchived(pCCMNB1DOutputRec.getBIndCaseArchived());
            pCCMNB2DInputRec.setDtDtCaseClosed(pCCMNB1DOutputRec.getDtDtCaseClosed());
            
            pCCMNB2DInputRec.setTmSysTmCaseClosed(pCCMNB1DOutputRec.getTmSysTmCaseClosed());
            pCCMNB2DInputRec.setDtDtCaseOpened(pCCMNB1DOutputRec.getDtDtCaseOpened());
            pCCMNB2DInputRec.setTmSysTmCaseOpened(pCCMNB1DOutputRec.getTmSysTmCaseOpened());
            pCCMNB2DInputRec.setSzCdCaseSpeclHndlg(pCINT07DOutputRec.getSzCdIncmgSpecHandling());
            pCCMNB2DInputRec.setSzTxtCaseWorkerSafety(pCINT07DOutputRec.getTxtIncmgWorkerSafety());
            pCCMNB2DInputRec.setSzTxtCaseSensitiveCmnts(pCINT07DOutputRec.getTxtIncomgSensitive());
            pCCMNB2DInputRec.setBIndCaseSensitive(pCINT07DOutputRec.getBIndIncmgSensitive());
            pCCMNB2DInputRec.setSzTxtCaseSuspMeth(pCINT07DOutputRec.getTxtIncomgSuspMeth());
            pCCMNB2DInputRec.setBIndCaseSuspMeth(pCINT07DOutputRec.getBIndIncmgSuspMeth());
            pCCMNB2DInputRec.setBIndCaseWorkerSafety(pCINT07DOutputRec.getBIndIncmgWorkerSafety());
            pCCMNB2DInputRec.setTsSysTsLastUpdate2(pCCMNB1DOutputRec.getTsSysTsLastUpdate2());
            pCCMNB2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        
        
        /*
        ** If the case was not found.
        */
        else if (!(rc != 0) &&!(pCINT21DOutputRec.getUlIdCase() != 0)) {
            pCCMNB2DInputRec.setDtDtCaseOpened(pInputMsg441.CallEntrySvcStruct.getDtDtIncomingCall());
            pCCMNB2DInputRec.setTmSysTmCaseOpened(pInputMsg441.CallEntrySvcStruct.getTmTmIncmgCall());
            pCCMNB2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMNB2DInputRec.getDtDtCaseClosed().year = DateHelper.NULL_DATE;
            pCCMNB2DInputRec.getDtDtCaseClosed().month = DateHelper.NULL_DATE;
            
            pCCMNB2DInputRec.getDtDtCaseClosed().day = DateHelper.NULL_DATE;
        }
        if (!(rc != 0) && bOKToCreateCaseAndSituation != 0) {
            pCCMNB2DInputRec.setSzCdCaseProgram(pInputMsg441.CallEntrySvcStruct.getSzCdStageProgram());
            pCCMNB2DInputRec.setSzCdCaseRegion(pInputMsg441.CallEntrySvcStruct.getSzCdIncmgRegion());
            pCCMNB2DInputRec.setSzNmCase(pCINT21DOutputRec.getSzNmStage());
            pCCMNB2DInputRec.setSzCdCaseCounty(pInputMsg441.CallEntrySvcStruct.getSzCdStageCnty());
            pCCMNB2DInputRec.setSzCdCaseSpeclHndlg(pCINT07DOutputRec.getSzCdIncmgSpecHandling());
            pCCMNB2DInputRec.setSzTxtCaseWorkerSafety(pCINT07DOutputRec.getTxtIncmgWorkerSafety());
            pCCMNB2DInputRec.setSzTxtCaseSensitiveCmnts(pCINT07DOutputRec.getTxtIncomgSensitive());
            pCCMNB2DInputRec.setBIndCaseSensitive(pCINT07DOutputRec.getBIndIncmgSensitive());
            pCCMNB2DInputRec.setSzTxtCaseSuspMeth(pCINT07DOutputRec.getTxtIncomgSuspMeth());
            pCCMNB2DInputRec.setBIndCaseSuspMeth(pCINT07DOutputRec.getBIndIncmgSuspMeth());
            
            pCCMNB2DInputRec.setBIndCaseWorkerSafety(pCINT07DOutputRec.getBIndIncmgWorkerSafety());
            
            
            //  Call CCMN06U
            rc = ccmnb2dAUDdam(sqlca, pCCMNB2DInputRec, pCCMNB2DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == pCCMNB2DInputRec.getArchInputStruct().getCReqFuncCd()) {
                        pCINT13DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        pCINT13DInputRec.setUlIdCase(pCCMNB2DOutputRec.getUlIdCase());
                        pInputMsg441.CallEntrySvcStruct.setUlIdCase(pCCMNB2DOutputRec.getUlIdCase());
                        pOutputMsg407.CreateCallOutStruct.setUlIdCase(pCCMNB2DOutputRec.getUlIdCase());
                    }
                    
                    
                    else {
                        pInputMsg441.CallEntrySvcStruct.setUlIdCase(pCCMNB2DInputRec.getUlIdCase());
                        pOutputMsg407.CreateCallOutStruct.setUlIdCase(pCCMNB2DInputRec.getUlIdCase());
                        pCINT13DInputRec.setUlIdCase(pCCMNB1DInputRec.getUlIdCase());
                    }
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(14, new Object[]{
                        new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            if (!(rc != 0)) {
                
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == pCINT13DInputRec.getArchInputStruct().getCReqFuncCd()) {
                    pCINT13DInputRec.setDtDtSituationOpened(pInputMsg441.CallEntrySvcStruct.getDtDtIncomingCall());
                    pCINT13DInputRec.setTmSysTmSitOpened(pInputMsg441.CallEntrySvcStruct.getTmTmIncmgCall());
                    pCINT13DInputRec.getDtDtSituationClosed().year = DateHelper.NULL_DATE;
                    pCINT13DInputRec.getDtDtSituationClosed().month = DateHelper.NULL_DATE;
                    
                    pCINT13DInputRec.getDtDtSituationClosed().day = DateHelper.NULL_DATE;
                }
                
                //  ERR #2909: Because an API is no longer being called 
                // FreePointers and PROCESS_TUX_RC_ERROR_TRANSACT has been removed.
                
                
                else {
                    pCINT13DInputRec.setDtDtSituationOpened(pCINT24DOutputRec.getDtDtSituationOpened());
                    pCINT13DInputRec.setTmSysTmSitOpened(pCINT24DOutputRec.getTmSysTmSitOpened());
                    pCINT13DInputRec.setDtDtSituationClosed(pCINT24DOutputRec.getDtDtSituationClosed());
                    pCINT13DInputRec.setTmSysTmSitClosed(pCINT24DOutputRec.getTmSysTmSitClosed());
                }
                rc = cint13dAUDdam(sqlca, pCINT13DInputRec, pCINT13DOutputRec);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pInputMsg441.CallEntrySvcStruct.setUlIdSituation(pCINT13DOutputRec.getUlIdSituation());
                        pOutputMsg407.CreateCallOutStruct.setUlIdSituation(pCINT13DOutputRec.getUlIdSituation());
                        
                        break;
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Cint14s.FreePointers(14, new Object[]{
                            new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                        );
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
        }
        if (!(rc != 0)) {
            rc = ModifyWorkload(pInputMsg441, pOutputMsg407, pServiceStatus, szCdStageClassification3);
        }
        if (!(rc != 0) && (bOKToCreateCaseAndSituation != 0 || REQ_FUNC_CD_SAVE_AND_SUBMIT == pInputMsg441.ArchInputStruct.getCReqFuncCd() && (0 == pInputMsg441.CallEntrySvcStruct.getSzCdStage().compareTo(STAGE_CD_IR) || NON_CASE_RELATED_PREFIX == pInputMsg441.CallEntrySvcStruct.getSzCdSpclReq()[0]))) {
            
            //  Start DAM Performance Timer
            //##    ARC_PRFDataAccessStartTime("CINV51D");
            
            
            //  Call CINV51D
            rc = CallPostEvent(pInputMsg441, pOutputMsg407, pServiceStatus, pCINT07DOutputRec.getUlIdEvent() , (char) 0, null, null, null, null);
        }
        
        if (!(rc != 0)) {
            pCINT02DInputRec.setUlIdEvent(pOutputMsg407.CreateCallOutStruct.getUlIdEvent());
            pCINT02DInputRec.setUlIdPerson(pCINT07DOutputRec.getUlIdPerson());
            pCINT02DInputRec.setUlIdStage(pInputMsg441.CallEntrySvcStruct.getUlIdStage());
            pCINT02DInputRec.setSzCdIncmgAllegType(pCINT07DOutputRec.getSzCdIncmgAllegType());
            pCINT02DInputRec.setCdIncomingProgramType(pCINT07DOutputRec.getCdIncomingProgramType());
            pCINT02DInputRec.setDtIncomingCallDisposed(pCINT07DOutputRec.getDtIncomingCallDisposed());
            pCINT02DInputRec.setTmSysTmCallDisp(pCINT07DOutputRec.getTmSysTmCallDisp());
            pCINT02DInputRec.setSzNbrIncmgCallerExt(pCINT07DOutputRec.getSzNbrIncmgCallerExt());
            pCINT02DInputRec.setSzNmJurisdiction(pCINT07DOutputRec.getSzNmJurisdiction());
            pCINT02DInputRec.setUlIdResource(pCINT07DOutputRec.getUlIdResource());
            pCINT02DInputRec.setDtDtIncomingCall(pCINT07DOutputRec.getDtDtIncomingCall());
            pCINT02DInputRec.setTmTmIncmgCall(pCINT07DOutputRec.getTmTmIncmgCall());
            pCINT02DInputRec.setSzCdIncomingCallType(pCINT07DOutputRec.getSzCdIncomingCallType());
            pCINT02DInputRec.setNmIncomingCallerFirst(pCINT07DOutputRec.getNmIncomingCallerFirst());
            pCINT02DInputRec.setNmIncomingCallerMiddle(pCINT07DOutputRec.getNmIncomingCallerMiddle());
            
            pCINT02DInputRec.setNmIncomingCallerLast(pCINT07DOutputRec.getNmIncomingCallerLast());
            pCINT02DInputRec.setCdIncomingCallerSuffix(pCINT07DOutputRec.getCdIncomingCallerSuffix());
            pCINT02DInputRec.setSzCdIncmgSex(pCINT07DOutputRec.getSzCdIncmgSex());
            pCINT02DInputRec.setSzCdIncmgAddrType(pCINT07DOutputRec.getSzCdIncmgAddrType());
            pCINT02DInputRec.setSzNbrIncomingCallerPhone(pCINT07DOutputRec.getSzNbrIncomingCallerPhone());
            pCINT02DInputRec.setSzCdIncmgPhoneType(pCINT07DOutputRec.getSzCdIncmgPhoneType());
            pCINT02DInputRec.setSzAddrIncmgStreetLn1(pCINT07DOutputRec.getSzAddrIncmgStreetLn1());
            
            //## BEGIN TUX/XML: Declare XML variables
            pCINT02DInputRec.setSzAddrIncmgStreetLn2(pCINT07DOutputRec.getSzAddrIncmgStreetLn2());
            pCINT02DInputRec.setSzAddrIncomingCallerCity(pCINT07DOutputRec.getSzAddrIncomingCallerCity());
            pCINT02DInputRec.setSzCdIncomingCallerCounty(pCINT07DOutputRec.getSzCdIncomingCallerCounty());
            pCINT02DInputRec.setSzCdIncomingCallerState(pCINT07DOutputRec.getSzCdIncomingCallerState());
            pCINT02DInputRec.setSzAddrIncmgZip(pCINT07DOutputRec.getSzAddrIncmgZip());
            pCINT02DInputRec.setSzNmIncmgRegardingFirst(pCINT07DOutputRec.getSzNmIncmgRegardingFirst());
            pCINT02DInputRec.setSzNmIncmgRegardingLast(pCINT07DOutputRec.getSzNmIncmgRegardingLast());
            pCINT02DInputRec.setSzCdIncomingDisposition(pCINT07DOutputRec.getSzCdIncomingDisposition());
            pCINT02DInputRec.setSzCdIncmgCallerInt(pCINT07DOutputRec.getSzCdIncmgCallerInt());
            pCINT02DInputRec.setSzCdIncmgSpecHandling(pCINT07DOutputRec.getSzCdIncmgSpecHandling());
            pCINT02DInputRec.setTxtIncmgWorkerSafety(pCINT07DOutputRec.getTxtIncmgWorkerSafety());
            pCINT02DInputRec.setTxtIncomgSensitive(pCINT07DOutputRec.getTxtIncomgSensitive());
            pCINT02DInputRec.setCdIncmgStatus(pCINT07DOutputRec.getCdIncmgStatus());
            pCINT02DInputRec.setBIndIncmgSensitive(pCINT07DOutputRec.getBIndIncmgSensitive());
            
            pCINT02DInputRec.setBIndIncmgSuspMeth(pCINT07DOutputRec.getBIndIncmgSuspMeth());
            
            pCINT02DInputRec.setTxtIncomgSuspMeth(pCINT07DOutputRec.getTxtIncomgSuspMeth());
            
            pCINT02DInputRec.setBIndIncmgWorkerSafety(pCINT07DOutputRec.getBIndIncmgWorkerSafety());
            
            pCINT02DInputRec.setBIndIncmgNoFactor(pCINT07DOutputRec.getBIndIncmgNoFactor());
            pCINT02DInputRec.setSzAddrIncWkrCity(pCINT07DOutputRec.getSzAddrIncWkrCity());
            pCINT02DInputRec.setLNbrIncWkrPhone(pCINT07DOutputRec.getLNbrIncWkrPhone());
            pCINT02DInputRec.setLNbrIncWkrExt(pCINT07DOutputRec.getLNbrIncWkrExt());
            pCINT02DInputRec.setSzNmIncWkrName(pCINT07DOutputRec.getSzNmIncWkrName());
            pCINT02DInputRec.setSzNbrIncmgUnit(pCINT07DOutputRec.getSzNbrIncmgUnit());
            pCINT02DInputRec.setSzCdIncmgRegion(pCINT07DOutputRec.getSzCdIncmgRegion());
            
            
            // 
            // (END): Add / Update / Delete Resource Address
            // 
            
            // 
            // (BEGIN): Add / Update / Delete Resource Phone
            // 
            
            if (REQ_FUNC_CD_SAVE_AND_ASSIGN == pInputMsg441.ArchInputStruct.getCReqFuncCd()) {
                pCINT02DInputRec.setCdIncmgStatus(INCMG_STATUS_CD_CLOSED);
            }
            pCINT02DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            rc = cint02dAUDdam(sqlca, pCINT02DInputRec, pCINT02DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(14, new Object[]{
                        new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        Cint14s.FreePointers(14, new Object[]{
            new Object[]{pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT02DInputRec, pCINT02DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCINT24DInputRec, pCINT24DOutputRec, pCINT07DInputRec, pCINT07DOutputRec}}
        );
        return rc;
    }

    static int CallPostEvent(CINT12SI pInputMsg442, CINT12SO pOutputMsg408, Arcxmlerrors.TUX_DECL_STATUSPARMS, int ulIdExistingEvent, char cEventToCreate, String szInitPriority, String szCurrPriority, String szComments, String szRsnChanged) {
        int rc = 0;/* Return code */
        
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        String szPriorityEventDesc = new String();
        String szBuffer = new String();
        CCMN45DI CCMN45DInRec = null;
        CCMN45DO CCMN45DOutRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN01UInputRec = new CCMN01UI();
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(pInputMsg442.ArchInputStruct);
        rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        
        if (EVENT_NEW_USING_IND == cEventToCreate) {
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_NEW_USING);
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pOutputMsg408.CreateCallOutStruct.getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg442.CallEntrySvcStruct.getUlIdPerson());
            szBuffer = CIOUtils.sprintf(NEW_USING_EVENT_DESC, NEW_USING_EVENT_DESC, pInputMsg442.CallEntrySvcStruct.getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(szBuffer);
            pCCMN01UInputRec.getROWCCMN01UIG00().getSzCdTask()[0] = null;
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
        }
        
        
        else if (EVENT_CHANGE_PRIORITY_IND == cEventToCreate) {
            szPriorityEventDesc = szInitPriority;
            
            strncat(szPriorityEventDesc, PRIORITY_EVENT_DESCR_ARROW, PRIORITY_EVENT_DESCR_ARROW.length());
            
            strncat(szPriorityEventDesc, szCurrPriority, CSVC18DI.CD_STAGE_CURR_PRIORITY_LEN);
            
            //  This will be NULL, if the stage is an APS Program type.
            strncat(szPriorityEventDesc, szRsnChanged, CSVC18DI.CD_STAGE_RSN_PRIORITY_CHGD_LEN);
            
            strncat(szPriorityEventDesc, szComments, CSVC18DI.TXT_STAGE_PRIORITY_CMNTS_LEN - szPriorityEventDesc.length() - 1);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(szPriorityEventDesc);
            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_PRIORITY_CHANGE);
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pInputMsg442.CallEntrySvcStruct.getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg442.CallEntrySvcStruct.getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(RECORD_CALL_CD_TASK);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
        }
        
        
        else if (null == cEventToCreate) {
            
            if (0 != ulIdExistingEvent) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(ulIdExistingEvent);
                CCMN45DInRec.setUlIdEvent(ulIdExistingEvent);
                rc = CallCCMN45D(pInputMsg442, CCMN45DInRec, CCMN45DOutRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(CCMN45DOutRec.getROWCCMN45DO().getTsLastUpdate());
                pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(CCMN45DOutRec.getROWCCMN45DO().getDtDtEventOccurred());
            }
            
            
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(EVENT_TYPE_CALL);
            
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pInputMsg442.CallEntrySvcStruct.getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg442.CallEntrySvcStruct.getUlIdPerson());
            szBuffer = CIOUtils.sprintf(RECORD_CALL_EVENT_DESC, RECORD_CALL_EVENT_DESC, pInputMsg442.CallEntrySvcStruct.getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(szBuffer);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(RECORD_CALL_CD_TASK);
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(pInputMsg442.szCdEventStatus);
            
            if (CAPS_WIN_MODE_APPRV != pInputMsg442.CallEntrySvcStruct.getSzSysCdWinMode()) {
                
                if (REQ_FUNC_CD_SAVE_AND_ASSIGN == pInputMsg442.ArchInputStruct.getCReqFuncCd()) {
                    pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_APPROVED);
                }
                
                else {
                    pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
                }
            }
        }
        
        /*
        ** Call DAM
        */
        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                pOutputMsg408.CreateCallOutStruct.setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int RemoveFromWorkload(CINT12SI pInputMsg443, CINT12SO pOutputMsg409, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*     
        ** SIR 11870 - Removed dams CCMN80D, CINT20D from function; replaced 
        ** with ccmnd3d--this dam will retrieve rows from stage_person_link
        ** will delete from rows for primary and secondary workers when
        ** I&R intake has been SAVE&Closed or MarkedForDeletion
        */
        CCMND3DI pCCMND3DInputRec = null;
        CCMND3DO pCCMND3DOutputRec = null;
        CINT12DI pCINT12DInputRec = null;
        CINT12DO pCINT12DOutputRec = null;
        CINT55DI pCINT55DInputRec = null;
        CINT55DO pCINT55DOutputRec = null;
        
        
        /*
        ** Allocate and clear the memory for the dam calls
        ** Added call to ccmnd3d - 11870.
        */
        pCCMND3DInputRec = new CCMND3DI();
        pCCMND3DOutputRec = new CCMND3DO();
        
        pCINT12DInputRec = new CINT12DI();
        pCINT12DOutputRec = new CINT12DO();
        pCINT55DInputRec = new CINT55DI();
        pCINT55DOutputRec = new CINT55DO();
        if ((pCCMND3DInputRec == null) || (pCCMND3DOutputRec == null) || (pCINT12DInputRec == null) || (pCINT12DOutputRec == null) || (pCINT55DOutputRec == null) || (pCINT55DOutputRec == null)) {
            Cint14s.FreePointers(6, new Object[]{
                new Object[]{pCCMND3DInputRec, pCCMND3DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
            );
            
            //  Call CAUD20D.  The Contract Period ELB DAM receives IdContract and
            // performs an AUD on the indicated row.
            // Delete:  a stored procedure is called to perform a cascade delete
            // for Contract Version, Contract Service and Contract County.
            // Add:     Performs a full row insert into Contract Period Table
            // Modify:  Performs a full row update into Contract Period Table.
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCCMND3DInputRec.setArchInputStruct(pInputMsg443.ArchInputStruct);
        pCCMND3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        pCCMND3DInputRec.setUlIdStage(pInputMsg443.CallEntrySvcStruct.getUlIdStage());
        rc = ccmnd3dAUDdam(sqlca, pCCMND3DInputRec, pCCMND3DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Cint14s.FreePointers(6, new Object[]{
                    new Object[]{pCCMND3DInputRec, pCCMND3DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                
                );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        if (!(rc != 0) && (pInputMsg443.CallEntrySvcStruct.getSzCdInfoAndRefrl()[0] != null || NON_CASE_RELATED_PREFIX == pInputMsg443.CallEntrySvcStruct.getSzCdSpclReq()[0]) && CAPS_WIN_MODE_APPRV != pInputMsg443.CallEntrySvcStruct.getSzSysCdWinMode()) {
            pCINT55DInputRec.setUlIdStage(pInputMsg443.CallEntrySvcStruct.getUlIdStage());
            pCINT55DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            rc = cint55dAUDdam(sqlca, pCINT55DInputRec, pCINT55DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    break;
                    
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    
                    Cint14s.FreePointers(6, new Object[]{
                        new Object[]{pCCMND3DInputRec, pCCMND3DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
            if (!(rc != 0)) {
                pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                pCINT12DInputRec.setUlIdStage(pInputMsg443.CallEntrySvcStruct.getUlIdStage());
                
                //  Call CSES82D
                rc = cint12dAUDdam(sqlca, pCINT12DInputRec, pCINT12DOutputRec);
                
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        
                        break;
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Cint14s.FreePointers(6, new Object[]{
                            new Object[]{pCCMND3DInputRec, pCCMND3DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                        );
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        
                        break;
                    case NO_DATA_FOUND:
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
        }
        
        
        
        
        /*
        ** SIR #1034 08/10/95 - MED
        ** The call must be a Case related special request or
        ** a real intake or in approval mode. In this instance, 
        ** delete all Todos to the stage. This will indirectly
        ** take care of the LE Notif Todo, which was the original
        ** intent behind this SIR.
        */
        else if (!(rc != 0)) {
            pCINT55DInputRec.setUlIdStage(pInputMsg443.CallEntrySvcStruct.getUlIdStage());
            pCINT55DInputRec.getArchInputStruct().setCReqFuncCd(REQ_FUNC_CD_DELETE_TODO);
            rc = cint55dAUDdam(sqlca, pCINT55DInputRec, pCINT55DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    break;
                case NO_DATA_FOUND:
                    
                    //  Get the current date and store it in dtCurrentDate
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(6, new Object[]{
                        new Object[]{pCCMND3DInputRec, pCCMND3DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        if (!(rc != 0)) {
            
            //  Compare today's date with Period Start date
            rc = UpdateTemporaryWorkload(pInputMsg443, pOutputMsg409, pServiceStatus);
        }
        Cint14s.FreePointers(6, new Object[]{
            
            new Object[]{pCCMND3DInputRec, pCCMND3DOutputRec, pCINT12DInputRec, pCINT12DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
        );
        return rc;
    }

    static int CleanUpTables(CINT12SI pInputMsg444, CINT12SO * pOutputMsg410, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        int rc = 0;
        CINT12DI pCINT12DInputRec = null;
        CINT12DO pCINT12DOutputRec = null;
        /*
        ** Declare local variables
        */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        CINT13DI pCINT13DInputRec = null;
        CINT13DO pCINT13DOutputRec = null;
        CCMNB2DI pCCMNB2DInputRec = null;
        CCMNB2DO pCCMNB2DOutputRec = null;
        CCMNB1DI pCCMNB1DInputRec = null;
        CCMNB1DO pCCMNB1DOutputRec = null;
        CINT55DI pCINT55DInputRec = null;
        CINT55DO pCINT55DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINT12DInputRec = new CINT12DI();
        pCINT12DOutputRec = new CINT12DO();
        pCINT21DInputRec = new CINT21DI();
        pCINT21DOutputRec = new CINT21DO();
        pCINT13DInputRec = new CINT13DI();
        pCINT13DOutputRec = new CINT13DO();
        pCCMNB1DInputRec = new CCMNB1DI();
        pCCMNB1DOutputRec = new CCMNB1DO();
        pCCMNB2DInputRec = new CCMNB2DI();
        pCCMNB2DOutputRec = new CCMNB2DO();
        pCINT55DInputRec = new CINT55DI();
        pCINT55DOutputRec = new CINT55DO();
        
        /*
        ** SIR 13172 - If we're making a Foster/Adoptive placement, retrieve from
        ** RESOURCE_HISTORY the information that was valid at the time of the
        ** placement.  This will allow back-dated placements to be created.
        **
        ** The changes made for this SIR do not meet normal CAPS standards and should
        ** be cleaned up.
        */
        if ((pCINT12DInputRec == null) || (pCINT12DOutputRec == null) || (pCINT21DInputRec == null) || (pCINT21DOutputRec == null) || (pCINT13DInputRec == null) || (pCINT13DOutputRec == null) || (pCCMNB1DInputRec == null) || (pCCMNB1DOutputRec == null) || (pCCMNB2DInputRec == null) || (pCCMNB2DOutputRec == null) || (pCINT55DInputRec == null) || (pCINT55DOutputRec == null)) 
        {
            
            // 
            // Service Function
            // 
            // 
            // Service Function Prototypes
            // 
            
            Cint14s.FreePointers(12, new Object[]{
                new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec
                }}
            );
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        if (!(rc != 0)) {
            pCINT21DInputRec.setUlIdStage(pInputMsg444.CallEntrySvcStruct.getUlIdStage());
            
            // Delete the Todo
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;// break for SQL_NOT_FOUND for CINV51D(VP)
                case NO_DATA_FOUND:
                    break;// break for SQL_NOT_FOUND for CINV51D(VC)
                    // /*
                    // default for CINV51D(VC)
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}
                    }
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        if (!(rc != 0)) {
            pCINT12DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCINT12DInputRec.setSzCdStageCurrPriority(pCINT21DOutputRec.getSzCdStageCurrPriority());
            
            //## BEGIN TUX/XML: Declare XML variables 
            pCINT12DInputRec.setSzCdStageInitialPriority(pCINT21DOutputRec.getSzCdStageInitialPriority());
            pCINT12DInputRec.setSzCdStageReasonClosed(pCINT21DOutputRec.getSzCdStageReasonClosed());
            pCINT12DInputRec.setSzCdStageRegion(pCINT21DOutputRec.getSzCdStageRegion());
            pCINT12DInputRec.setSzCdStageRsnPriorityChgd(pCINT21DOutputRec.getSzCdStageRsnPriorityChgd());
            pCINT12DInputRec.setSzCdStageClassification(pCINT21DOutputRec.getSzCdStageClassification());
            pCINT12DInputRec.setTmSysTmStageStart(pCINT21DOutputRec.getTmSysTmStageStart());
            pCINT12DInputRec.setDtDtStageStart(pCINT21DOutputRec.getDtDtStageStart());
            pCINT12DInputRec.setUlIdUnit(pCINT21DOutputRec.getUlIdUnit());
            pCINT12DInputRec.setSzNmStage(pCINT21DOutputRec.getSzNmStage());
            pCINT12DInputRec.setSzTxtStagePriorityCmnts(pCINT21DOutputRec.getSzTxtStagePriorityCmnts());
            pCINT12DInputRec.setSzTxtStageClosureCmnts(pCINT21DOutputRec.getSzTxtStageClosureCmnts());
            pCINT12DInputRec.setBIndStageClose(pCINT21DOutputRec.getBIndStageClose());
            pCINT12DInputRec.setSzCdStageType(pCINT21DOutputRec.getSzCdStageType());
            pCINT12DInputRec.setSzCdStageProgram(pCINT21DOutputRec.getSzCdStageProgram());
            pCINT12DInputRec.setSzCdStage(pCINT21DOutputRec.getSzCdStage());
            pCINT12DInputRec.setSzCdStageCnty(pCINT21DOutputRec.getSzCdStageCnty());
            pCINT12DInputRec.setDtDtStageClose(pCINT21DOutputRec.getDtDtStageClose());
            pCINT12DInputRec.setTmSysTmStageClose(pCINT21DOutputRec.getTmSysTmStageClose());
            pCINT12DInputRec.setTsLastUpdate(pCINT21DOutputRec.getTsLastUpdate());
            pCINT12DInputRec.setUlIdStage(pCINT21DInputRec.getUlIdStage());
            // Update the Event Status (Intervening Update Strategy)
            rc = cint12dAUDdam(sqlca, pCINT12DInputRec, pCINT12DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                    );
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    // 
                    // (END): Retrieve DAM: ccmn44d     
                    // Get NmPersonFull given IdPerson
                    // 
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        
        /* Populate DAM Input Structure */
        /* SIR#3582: If a ChildPlacingAgency (CPA) exists validate its contract */
        if (!(rc != 0) && pCINT21DOutputRec.getUlIdSituation() != 0) {
            
            //## BEGIN TUX/XML: Declare XML variables
            pCINT13DInputRec.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
            pCINT13DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            
            
            // Save the Approval Determination
            rc = cint13dAUDdam(sqlca, pCINT13DInputRec, pCINT13DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}
                    }
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        if (!(rc != 0) && pCINT21DOutputRec.getUlIdCase() != 0) {
            pCINT55DInputRec.setUlIdStage(pInputMsg444.CallEntrySvcStruct.getUlIdStage());
            pCINT55DInputRec.getArchInputStruct().setCReqFuncCd(REQ_FUNC_CD_DELETE_TODO);
            
            // Delete the Todo
            rc = cint55dAUDdam(sqlca, pCINT55DInputRec, pCINT55DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                    // RIOSJA, SIR 19973
                case NO_DATA_FOUND:
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;// break for success of CINV51D (VC)
                    // /*
                    // CASE SQL_NOT_FOUND for CINV51D (VC)
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(12, new Object[]{
                        new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;// break for success of CCMN44
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
            if (!(rc != 0)) {
                pCCMNB1DInputRec.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
                rc = ccmnb1dQUERYdam(sqlca, pCCMNB1DInputRec, pCCMNB1DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                        // RIOSJA, SIR 19973
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;
                    case Arcutls.ARC_UTL_GENERAL_FAILURE:
                        Cint14s.FreePointers(12, new Object[]{
                            new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                        );
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                        break;// break for success of cinv51d (VP)
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
                pCCMNB2DInputRec.setTsSysTsLastUpdate2(pCCMNB1DOutputRec.getTsSysTsLastUpdate2());
                pCCMNB2DInputRec.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
                pCCMNB2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                
                // Populate DAM Input Structure
                
                if (!(rc != 0)) {
                    rc = ccmnb2dAUDdam(sqlca, pCCMNB2DInputRec, pCCMNB2DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;// break for success of CCMN44
                        case Arcutls.ARC_UTL_GENERAL_FAILURE:
                            Cint14s.FreePointers(12, new Object[]{
                                new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
                            );
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    }
                }
            }
        }
        Cint14s.FreePointers(12, new Object[]{
            new Object[]{pCINT12DInputRec, pCINT12DOutputRec, pCINT21DInputRec, pCINT21DOutputRec, pCINT13DInputRec, pCINT13DOutputRec, pCCMNB1DInputRec, pCCMNB1DOutputRec, pCCMNB2DInputRec, pCCMNB2DOutputRec, pCINT55DInputRec, pCINT55DOutputRec}}
        );
        
        if (NO_DATA_FOUND == rc) {
            return WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int FindUserInformation(CINT12SI pInputMsg445, CINT12SO pOutputMsg411, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /* Declare local variables*/
        CINT47DI pCINT47DInputRec = null;
        CINT47DO pCINT47DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT47DInputRec = new CINT47DI();
        pCINT47DOutputRec = new CINT47DO();
        
        pCINT47DInputRec.setUlIdPerson(pInputMsg445.CallEntrySvcStruct.getUlIdPerson());
        pCINT47DInputRec.setBIndPersonPhoneInvalid(FND_NO);
        pCINT47DInputRec.setBIndPersonPhonePrimary(FND_YES);
        pCINT47DInputRec.setSzCdPhoneType(BUSINESS_PHONE_TYPE);
        pCINT47DInputRec.setArchInputStruct(pInputMsg445.ArchInputStruct);
        rc = cint47dQUERYdam(sqlca, pCINT47DInputRec, pCINT47DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg411.CINTS025G01.setLNbrPhone(pCINT47DOutputRec.getLNbrPhone());
                pOutputMsg411.CINTS025G01.setLNbrPhoneExtension(pCINT47DOutputRec.getLNbrPhoneExtension());
                break;
            case NO_DATA_FOUND:
                
                
                //  Call CRES14D
                rc = WtcHelperConstants.ARC_SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int NewUsing(CINT12SI pInputMsg446, CINT12SO pOutputMsg412, Arcxmlerrors.TUX_DECL_STATUSPARMS, String szCdStageClassification4) {
        int rc = 0;/* Return code */
        CCMNC0DI pCCMNC0DInputRec = null;
        CCMNC0DO pCCMNC0DOutputRec = null;
        CINT56DI pCINT56DInputRec = null;
        CINT56DO pCINT56DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCCMNC0DInputRec = new CCMNC0DI();
        pCCMNC0DOutputRec = new CCMNC0DO();
        pCINT56DInputRec = new CINT56DI();
        pCINT56DOutputRec = new CINT56DO();
        
        /**************************************************************************
        ** End Call to ToDo Common Function - CSUB40U
        **************************************************************************/
        
        
        if ((pCCMNC0DInputRec == null) || (pCCMNC0DOutputRec == null) || (pCINT56DInputRec == null) || (pCINT56DOutputRec == null)) {
            Cint14s.FreePointers(4, new Object[]{
                new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
            );
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCCMNC0DInputRec.setSzCdUnitProgram(pInputMsg446.UnitStruct.getSzCdUnitProgram());
        pCCMNC0DInputRec.setSzCdUnitRegion(pInputMsg446.UnitStruct.getSzCdUnitRegion());
        pCCMNC0DInputRec.setSzNbrUnit(pInputMsg446.UnitStruct.getSzNbrUnit());
        rc = ccmnc0dQUERYdam(sqlca, pCCMNC0DInputRec, pCCMNC0DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                pOutputMsg412.CreateCallOutStruct.setUlIdUnit(pCCMNC0DOutputRec.getUlIdUnit());
                
                
                
                
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                
                // 
                // Function Prototypes
                // 
                Cint14s.FreePointers(4, new Object[]{
                    new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
                );
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        if (!(rc != 0)) {
            rc = FindUserInformation(pInputMsg446, pOutputMsg412, pServiceStatus);
        }
        if (!(rc != 0)) {
            pCINT56DInputRec.setUlIdStage(pInputMsg446.CallEntrySvcStruct.getUlIdStage());
            pCINT56DInputRec.setSzNmIncWkrName(pInputMsg446.CallEntrySvcStruct.getSzNmIncWkrName());
            
            pCINT56DInputRec.setLNbrIncWkrExt(pOutputMsg412.CINTS025G01.getLNbrPhoneExtension());
            pCINT56DInputRec.setCdIncmgStatus(INCMG_STATUS_CD_OPEN);
            pCINT56DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
            
            pCINT56DInputRec.setSzCdStageRegion(pInputMsg446.CallEntrySvcStruct.getSzCdIncmgRegion());
            pCINT56DInputRec.setSzCdStagePersType(PERSON_TYPE_WORKER);
            pCINT56DInputRec.setUlIdUnit(pCCMNC0DOutputRec.getUlIdUnit());
            pCINT56DInputRec.setSzAddrIncWkrCity(pInputMsg446.CallEntrySvcStruct.getSzAddrIncWkrCity());
            pCINT56DInputRec.setLNbrIncWkrPhone(pOutputMsg412.CINTS025G01.getLNbrPhone());
            pCINT56DInputRec.setSzNbrIncmgUnit(pInputMsg446.CallEntrySvcStruct.getSzNbrIncmgUnit());
            
            if (CAPS_WIN_MODE_NEW_USING_OPEN == pInputMsg446.CallEntrySvcStruct.getSzSysCdWinMode()) {
                pCINT56DInputRec.setDtDtIncomingCall(pInputMsg446.CallEntrySvcStruct.getDtDtIncomingCall());
                pCINT56DInputRec.setTmTmIncmgCall(pInputMsg446.CallEntrySvcStruct.getTmTmIncmgCall());
                rc = ARC_UTLGetDateAndTime(pCINT56DInputRec.getDtDtStageStart() , pCINT56DInputRec.getTmSysTmStageStart());
                
                if (rc != 0) {
                    Cint14s.FreePointers(4, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            // COPYSZ(pCINT56DInputRec->szCdIncomingCallType,
            // CALL_TYPE_WKR_ID);
            
            
            //  Situation 2.
            else if (CAPS_WIN_MODE_NEW_USING_CWA == pInputMsg446.CallEntrySvcStruct.getSzSysCdWinMode()) {
                rc = ARC_UTLGetDateAndTime(pCINT56DInputRec.getDtDtIncomingCall() , pCINT56DInputRec.getTmTmIncmgCall());
                
                if (!(rc != 0)) {
                    
                    // Declare FOUNDATION variables
                    
                    
                    //  Declare local variables
                    
                    
                    //  Start performance timer for service
                    rc = ARC_UTLGetDateAndTime(pCINT56DInputRec.getDtDtStageStart() , pCINT56DInputRec.getTmSysTmStageStart());
                }
                
                //  If it is not Null, check the type category else fall through to return FALSE
                if (rc != 0) {
                    Cint14s.FreePointers(4, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            // COPYSZ(pCINT56DInputRec->szCdIncomingCallType,
            // pInputMsg->CallEntrySvcStruct.szCdIncomingCallType);
            
            
            //  Situation 3.
            else if (CAPS_WIN_MODE_NEW_USING_APS == pInputMsg446.CallEntrySvcStruct.getSzSysCdWinMode()) {
                
                //  Run-time versioning
                
                //  Check buffer size
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                // 
                // Call DAMs to retrieve data
                // 
                //  Retrieve current date for date comparison
                rc = ARC_UTLGetDateAndTime(pCINT56DInputRec.getDtDtIncomingCall() , pCINT56DInputRec.getTmTmIncmgCall());
                
                if (!(rc != 0)) {
                    rc = ARC_UTLGetDateAndTime(pCINT56DInputRec.getDtDtStageStart() , pCINT56DInputRec.getTmSysTmStageStart());
                }
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (rc != 0) {
                    Cint14s.FreePointers(4, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            // COPYSZ(pCINT56DInputRec->szCdIncomingCallType,
            // CALL_TYPE_WKR_ID);
            
            
            //  Situation 4, CAPS_WIN_MODE_NEW_USING_CAR, no need to check.
            else {
                pCINT56DInputRec.setDtDtIncomingCall(pInputMsg446.CallEntrySvcStruct.getDtDtIncomingCall());
                pCINT56DInputRec.setTmTmIncmgCall(pInputMsg446.CallEntrySvcStruct.getTmTmIncmgCall());
                rc = ARC_UTLGetDateAndTime(pCINT56DInputRec.getDtDtStageStart() , pCINT56DInputRec.getTmSysTmStageStart());
                if (rc != 0) {
                    Cint14s.FreePointers(4, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
                    );
                }
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            pCINT56DInputRec.setUlIdPerson(pInputMsg446.CallEntrySvcStruct.getUlIdPerson());
            rc = cint56dAUDdam(sqlca, pCINT56DInputRec, pCINT56DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    
                    
                    break;
                case Arcutls.ARC_UTL_GENERAL_FAILURE:
                    Cint14s.FreePointers(4, new Object[]{
                        new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
                    );
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    break;
            }
            if (!(rc != 0)) {
                pOutputMsg412.CreateCallOutStruct.setDtDtIncomingCall(pCINT56DInputRec.getDtDtIncomingCall());
                
                pOutputMsg412.CreateCallOutStruct.setTmTmIncmgCall(pCINT56DInputRec.getTmTmIncmgCall());
                pOutputMsg412.CreateCallOutStruct.setUlIdStage(pCINT56DOutputRec.getUlIdStage());
                
                // 
                // SIR 1972: We no longer need this logic, since CLSC69D has been added
                // to retrieve the "DT_INCOMING_CALL" from the INCOMING_DETAIL table for
                // the Intake stage of the given ID_CASE.
                // 
                
                // 
                // If the DT_CPS_INVST_DTL_INTAKE in output record is NULL,
                // then retrieve the start date of the earliest intake for the
                // ID_STAGE and set DT_CPS_INVST_DTL_INTAKE equal to this date
                // if (pOutputMsg->ROWCINV10DOG00.dtDtCPSInvstDtlIntake.year == 0 ||
                // pOutputMsg->ROWCINV10DOG00.dtDtCPSInvstDtlIntake.year == NULL_DATE)
                // {
                // rc=CallCINV86D(pInputMsg,
                // pOutputMsg,
                // TUX_STATUSPARMS);
                // switch(rc)
                // {
                // case ARC_SUCCESS:
                // break;
                // default:
                // PROCESS_TUX_RC_ERROR_TRANSACT;
                // }
                // }
                // 
                
                
                //  If the DT_CPS_INVST_DTL_BEGUN in output record is NULL,
                // then retrieve the date of the earliest contact for the
                // ID_STAGE and set DT_CPS_INVST_DTL_BEGUN equal to this date
                
                // 
                // SIR 1947: Always get the Investigation Begun Date from
                // the Date of First Contact retrieved by DAM CSYS15D.
                // There is no need for an "if" statement here, since we always
                // want to call this DAM.
                // if (pOutputMsg->ROWCINV10DOG00.dtDtCPSInvstDtlBegun.year == 0 ||
                // pOutputMsg->ROWCINV10DOG00.dtDtCPSInvstDtlBegun.year == NULL_DATE)
                // 
                
                rc = CallPostEvent(pInputMsg446, pOutputMsg412, pServiceStatus, 0, EVENT_NEW_USING_IND, null, null, null, null);
                
                
                if (!(rc != 0)) {
                    pInputMsg446.CallEntrySvcStruct.setUlIdStage(pCINT56DOutputRec.getUlIdStage());
                }
            }
        }
        if (!(rc != 0)) {
            //04/09/2003  Srini:  Added the required error handling to return the error and exit the service.
            rc = ModifyWorkload(pInputMsg446, pOutputMsg412, pServiceStatus, szCdStageClassification4);
        }
        Cint14s.FreePointers(4, new Object[]{
            new Object[]{pCCMNC0DInputRec, pCCMNC0DOutputRec, pCINT56DInputRec, pCINT56DOutputRec}}
        );
        return rc;
    }

    static int UpdateTemporaryWorkload(CINT12SI pInputMsg447, CINT12SO pOutputMsg413, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINT57DI pCINT57DInputRec = null;
        CINT57DO pCINT57DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT57DInputRec = new CINT57DI();
        pCINT57DOutputRec = new CINT57DO();
        
        pCINT57DInputRec.setArchInputStruct(pInputMsg447.ArchInputStruct);
        
        /*
        ** JMC: SIR #22415
        ** Add a DAM call to update the person's age on the  
        ** person table after the relate.  
        */
        if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg447.ArchInputStruct.getCReqFuncCd()) {
            pCINT57DInputRec.setUlIdTempStagePersLink(pOutputMsg413.CreateCallOutStruct.getUlIdStage());
            pCINT57DInputRec.setUlIdTempStagePerson(pInputMsg447.CallEntrySvcStruct.getUlIdPerson());
            pCINT57DInputRec.setSzCdTempStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            pCINT57DInputRec.setSzCdTempStagePersType(PERSON_TYPE_WORKER);
            pCINT57DInputRec.setSzCdTempStage(STAGE_CD_INTAKE);
            pCINT57DInputRec.setUlIdTempStage(pOutputMsg413.CreateCallOutStruct.getUlIdStage());
            rc = ARC_UTLGetDateAndTime(pCINT57DInputRec.getDtDtTempStagePersLink() , 0);
            if (rc != 0) {
                Cint14s.FreePointers(2, new Object[]{
                    new Object[]{pCINT57DInputRec, pCINT57DOutputRec}}
                );
            }
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            pCINT57DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        
        
        /*
        ** The only other time this function will be called is when
        ** the stage record for the call is being created.  This implies
        ** that the call is being closed or is being placed on the
        ** workers true workload.  That being the case, this record can
        ** be deleted.
        */
        else {
            pCINT57DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            pCINT57DInputRec.setUlIdTempStage(pInputMsg447.CallEntrySvcStruct.getUlIdStage());
        }
        
        
        /*
        ** Call CLSC06D.  This DAM will retrieve all VID/Address records
        ** that exist for a particular resource ID.  No rows found will
        ** result in a successful return.
        */
        rc = cint57dAUDdam(sqlca, pCINT57DInputRec, pCINT57DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        return rc;
    }

    static int SendToDoToSupervisor(CINT12SI pInputMsg448, CINT12SO * pOutputMsg414, Arcxmlerrors.TUX_DECL_STATUSPARMS, String szCdStageClassification5) {
        int rc = 0;
        CINT58DO CINT58DOutRec = null;
        CSUB40UI pCSUB40UInputRec = null;
        CSUB40UO pCSUB40UOutputRec = null;
        FndInt3date dtNullDate = new FndInt3date( - 1, - 1, - 1);
        char bCPSOther = 0;
        
        /* SIR 10617 - calling the ccmn39d dam */
        if ((0 == szCdStageClassification5.compareTo(CLASS_CPS_OTH_AGENCY)) || (0 == szCdStageClassification5.compareTo(CLASS_CPS_OUT_OF_ST))) {
            bCPSOther = 1;
        }
        rc = Ccmn88s.CallCINT58D(pInputMsg448, CINT58DOutRec, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        /* 15028  switch(rc)
        *
        *    case SQL_NOT_FOUND:
        *      {
        *        bRsnDthEdit = TRUE;
        *
        *        pOutputMsg->CINV15SOG01.usSysNbrMessageCode[EditWarningRowCtr] =
        *          MSG_INV_RSN_DTH_EDIT;
        *
        *
        *         Increment counter by 1
        *
        *        EditWarningRowCtr++;
        *        break;
        *       }
        *
        *        case SQL_SUCCESS:
        *        {
        *            rc = ARC_SUCCESS;
        *            break;
        *        }
        *
        *        default:
        *              PROCESS_TUX_SQL_ERROR_TRANSACT;
        *
        *   }  end switch */
        
        /* SIR 15028 */
        /*
        ** Analyze error code
        */
        switch (rc) {
                // APT 9/5/2001 SECURITY UPGRADE: for case where no rows returned
            case WtcHelperConstants.ARC_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                if (bCPSOther) {
                    
                    //  Call DAM
                    rc = Ccmn35s.CallCCMN43D(pInputMsg448, CINT58DOutRec, pServiceStatus);
                }
                
                break;
            case NO_DATA_FOUND:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                if (!bCPSOther) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCSUB40UInputRec = new CSUB40UI();
                    
                    pCSUB40UOutputRec = new CSUB40UO();
                    pCSUB40UInputRec.setArchInputStruct(pInputMsg448.ArchInputStruct);
                    pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CODE_LE_NOTIF);
                    pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtNullDate);
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(pInputMsg448.CallEntrySvcStruct.getUlIdStage());
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(0);
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pInputMsg448.CallEntrySvcStruct.getUlIdPerson());
                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(0);
                    rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                            
                            break;
                    }
                }
                
                break;
                
            default :
                
                break;
        }
        return rc;
    }

    static void FreePointers(ushort usNbrPointers, Object[] argument) {
        int varargsIndex = 0;
        Object pPointerToFree = null;
        ushort usIndex = null;
        
        for (usIndex = null;usIndex < usNbrPointers;usIndex++) {
            pPointerToFree = argument[varargsIndex++];
        }
        return;
    }

    static int CallCINT74D(CINT12SI pInputMsg449, CINT12SO * pOutputMsg415, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT74DI pCINT74DInputRec = null;
        CINT74DO pCINT74DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT74DInputRec = new CINT74DI();
        
        
        pCINT74DOutputRec = new CINT74DO();
        pCINT74DInputRec.setArchInputStruct(pInputMsg449.ArchInputStruct);
        pCINT74DInputRec.setUlIdStage(pInputMsg449.CallEntrySvcStruct.getUlIdStage());
        rc = cint74dSPdam(sqlca, pCINT74DInputRec, pCINT74DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCCMN45D(CINT12SI pInputMsg450, CCMN45DI pDamInMsg, CCMN45DO pOutputMsg416, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = new CCMN45DI();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg450.ArchInputStruct);
        pCCMN45DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN45DInputRec.setUlIdEvent(pDamInMsg.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pOutputMsg416);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCINT79D(CINT12SI pInputMsg451, CINT12SO * pOutputMsg417, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT79DI pCINT79DInputRec = null;
        CINT79DO pCINT79DOutputRec = null;
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT79DInputRec = new CINT79DI();
        
        pCINT79DOutputRec = new CINT79DO();
        pCINT79DInputRec.setArchInputStruct(pInputMsg451.ArchInputStruct);
        pCINT79DInputRec.setUlIdStage(pInputMsg451.CallEntrySvcStruct.getUlIdStage());
        pCINT79DInputRec.setSzCdStagePersType(PERSON_TYPE_PRN);
        pCINT79DInputRec.setSzCdStagePersRole(PERSON_ROLE_CLIENT);
        rc = cint79dQUERYdam(sqlca, pCINT79DInputRec, pCINT79DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                usPrnClientCounter = pCINT79DOutputRec.getUsSysNbrPrnClientCount();
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    static int CallCINT58D(CINT12SI pInputMsg452, CINT58DO pOutputMsg418, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT58DI pCINT58DInputRec = null;
        CINT58DO pCINT58DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINT58DInputRec = new CINT58DI();
        
        pCINT58DOutputRec = new CINT58DO();
        pCINT58DInputRec.setArchInputStruct(pInputMsg452.ArchInputStruct);
        pCINT58DInputRec.setUlIdStage(pInputMsg452.CallEntrySvcStruct.getUlIdStage());
        pCINT58DInputRec.setSzCdTodoTask(TODO_LE_NOTIF_TASK);
        
        
        /*
        ** Call CSES56D
        */
        rc = cint58dQUERYdam(sqlca, pCINT58DInputRec, pCINT58DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg418 = pCINT58DOutputRec;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = NO_DATA_FOUND;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

    static int CallCCMN43D(CINT12SI pInputMsg453, CINT58DO pDamInMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN43DInputRec = new CCMN43DI();
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN43DOutputRec = new CCMN43DO();
        pCCMN43DInputRec.setArchInputStruct(pInputMsg453.ArchInputStruct);
        pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        pCCMN43DInputRec.setLdIdTodo(pDamInMsg.getLdIdTodo());
        pCCMN43DInputRec.tsLastUpdate = pDamInMsg.getTsLastUpdate();
        
        rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        return rc;
    }

}
