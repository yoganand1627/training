package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS90DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS90DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS71DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES86DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES86DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS24DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS24DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC10DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC10DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC18DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC59DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES26DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
**
** Module File:    CCON18S.src
**
** Service Name:   CCON18S - Service Authorization Retrieve
**
** Description:   This service will perform the retrieval of Service
**                Authorization Header information as well as some validation
**                logic.  Using ID EVENT it will retrieve from the
**                SVC_AUTH_LINK table the ID SVC AUTH.  If the Window mode
**                is Modify or Browse then this ID will be used to retrieve
**                Header information from the SVC AUTH table.  Also using the
**                ID EVENT, the CD EVENT STATUS will be retrieved from the
**                EVENT table.  Using ID RESOURCE the NM RESOURCE will be
**                retrieved from the CAPS_RESOURCE table.
**                     If the mode is NEW then certain validations will have
**                to be performed:  If the user Program is APS then the
**                ID STAGE will be used to check if there is a row on the
**                EVENT table where CD TASK is 'Client Assessment' (2080).
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  23 October 1995
**
** Programmer:    Brian McRae
**
** Archive Information: $Revision:   1.7  $
**                      $Date:   12 Jun 1997 14:58:44  $
**                      $Modtime:   12 Jun 1997 14:04:24  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/29/95  MCRAEBS   SA Header window must pass at all times contract
**                      detail fields to the Service Auth List window for
**                      use in the SA Detail window.  Currently, these
**                      fields will be properly populated only if a resource
**                      validation has occurred.  The Retrieve service
**                      does not retrieve this contract information.
**                      Changes made:
**                      1. CSEC10D was changed to accept a date as an
**                         input value
**                      2. CSEC57D was created to retrieve addtional
**                         contract information.
**                      3. Retrieve service now calls CSEC10D within the
**                         success of the SvcAuth retrieve dam.  CSEC57D
**                         will be called within the success of CSEC10D.
**                      4. The following fields will be copied from the
**                         dam outputs to the output message and then on to
**                         the WCD of CCON13W:
**                              szCdCnperStatus
**                              szCdCnrctRegion
**                              dtDtCnperClosure
**                              dtDtCnperStart
**                              ulIdCntrctManager
**                              cIndCnperRenewal
**                              ulNbrCncntyPeriod
**                              ulNbrCncntyVersion
**  11/30/95  FOGARTIS  Modification to passed date to CSEC10D. Using
**                      timestamp from the Svc Auth Link table instead of
**                      the Svc Auth Table so that we can get back to the
**                      first save date.
**
**  01/05/96  MCRAEBS   SIR 2255 - Only perform client assessment check
**                      if current stage is Investigation
**
**  01/12/96  MCRAEBS   SIR 2621 - Populate CdTask for APS Client Assessment
**                      check based on CdStage passed from CCON13     BSM
**
**  01/19/96  MCRAEBS   SIR 2575 - CheckStageEventStatus needs to be called
**                      before retrieving the SvcAuth.  If the current stage
**                      has been closed by another user, the current user
**                      will receive a MsgBox alert, and will be unable to
**                      navigate to the SvcAuth dialog
**
**  01/23/96  GUARRICR  SIR 2851 - Revised logic to compare input Unit Program
**                      against "APS" to compare with entire string.
**
**  01/23/96  GUARRICR  SIR 2879 - Added logic to check input function code
**                      before calling CheckStageEventStatus. The service
**                      will not call CheckStageEventStatus if the window
**                      mode is INQUIRE.
**
**  01/30/96  DYARGR    SIR 2903 - Added dam to determine if there are SUBcare
**                      FamilySUbcare stages existing for the same case. If
**                      SUB or FSU stages exist, then don't open the Service
**                      Authorization window for Investigation or Family
**                      Reunification.
**
**  02/01/96  GUARRICR  SIR 3079 - Retrieved and sent Budget Limit
**                      Indicator variable for Contract back to Service
**                      Auth Header window.
**
** 02/13/96   MCRAEBS   SIR 3106 - Added CLSC18D to retrieve all Principals
**                      for the Stage.  The service will also delete all
**                      Primarys but the client if the User Pgm is APS.
**
** 02/15/96   MCRAEBS   SIR 3192 - Added VP (Victim Perp) role to APS Primary
**                      Client Retrieve (See SIR 3106)   BSM
**
** 02/19/96   MCRAEBS   SIR 3200 - Reset the value of ulRowQty to 1 if the
**                      User Program is APS or IdEvent is not Null BSM
**
** 04/11/96  WILSONET   SVC-FIX: Add dtDtSvcAuthEff to the Output Message.
**
** 04/14/96  WILSONET   SIR#(ETW): Add CSES26D to service in order to
**                      validate the dtSvcAuthEff against the
**                      SituationOpened Date.
**
** 04/16/96  DYARGR     SIR 20465 - Modified logic for when not to allow the
**                      Service Auth header window to be opened in new mode
**                      Added logic for other stages and also to verify that
**                      the stage the Service Auth's should be entered in is
**                      open.
**
** 04/18/96 DYARGR      SIR 20507 - Didn't check for stage being open in SIR
**                      20465. Added date stage close is null or max date.
**
** 04/22/96 PHILLILH    SIR #20525 - Add DAM CINT21D to service to retrieve
**                      dtStageClose so that the window mode is not changed
**                      to Modify if a Stage is closed.  Set the Stage Close
**                      Indicator to TRUE if dtStageClose is not NULL or not
**                      MAX_DATE
**
** 04/24/96  DYARGR     SIR 20635 - Modified message passed back when the
**                      window should not be opened for stages other than
**                      SUBcare.
**
** 04/24/96  WILSONET   SIR#20654: It is necessary to change InputRec to
**                      DtSvcAuthEff if there is an Effective Date
**
** 04/25/96  DYARGR     SIR 20656 - Get the message correct for the Subcare
**                      stage.
**
** 04/25/96  DYARGR     SIR 20659 - RetVal should be set when an error has
**                      occurred so processing will not continue.
**
** 04/30/96  DYARGR     SIR 20789 - Should not try to retrieve the client
**                      or victim for CPS stages.
** 05/02/96  PHILLILH   SIR #20890 - Commented out Family Reunification
**                      else statement so that Service Auths can be created
**                      for Family Reunification Stages.  Always allow new
**                      Service Auths in FRE Stage because of the possibility
**                      of doing a removal from the FRE stage and still
**                      having the original FSU stage open.
** 05/07/96  PHILLILH   SIR #20914 - Added if statement so that new Service
**                      Auths cannot be created in FSU stage when a FRE
**                      stage is open.
** 05/28/96  OMARAJJ    SIR#21477 - Added a new input to the call for CSES23D
**                      ulIdStage.  This change is necessary to adjust for
**                      merged persons.  See CSES23d.pc for addtional comments.
** 05/31/96  OMARAJJ    SIR#21535 - Replaced the call to CSES23D with the call
**                      to a new DAM CSES85D.  The new Dam accounts for merged
**                      persons by "filtering" the input id person through
**                      the person merge view table.
** 07/09/96  MAXHAMKJ   Performance SIR: Broke out cses85d into three DAM
**                      calls to prevent Person table full scans.  The new
**                      DAMs replacing cses85d are cses23d (SvcAuthHdr),
**                      clss71d (new DAM - gets PersonForward IDs from the
**                      Person Merge table - if person has been merged).
**
** 07/17/96  MCRAEBS    SIR#10259/SIR#10387 - Fixed GPFs on SA Retrieval.
**                      Checked for and found possible memory leaks.  BSM
**
** 08/14/96  ADKINSMC   SIR 21130 - Added invalidate approval logic for Svc
**                      Auth, including the logic to determine if the
**                      Conclusion or Closure event has been submitted for
**                      approval. We have to retrieve this info in the
**                      retrieve service.
** 06/12/97  CYSKD      SVC AUTH ENH - Added code to pass stage close date
**                      from CINT21D to the service output header file.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  02/18/2003  KRD     IMPACT - Modified code to correctly clear the person
**                      array.
**
**  02/19/2003  KRD     IMPACT - Also need to ensure that the number of rows
**                      returned is 1, when the array is cleared.  It was
**                      done more-or-less correctly in one place, but not
**                      the other.  Modified for-loop to avoid accessing
**                      memory outside of the array structure.
**
**  04/30/03   Srini    SIR 17091: Added the error handling to take care of full
**                      table scans for ccmn87dQUERYdam.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
**
**  07/23/03   Srini    SIR 18309 - Added a new field error_message to be sent as
**                      part of the output struct when MSG_CON_NO_CLIENT_FACTOR
**                      happens.
**
**  09/17/2003 Matthew McClain SIR 19811 - added PAL to types of stages
**                             SIR 21130 should have handled
**
**  05/04/04  CORLEYAN	SIR 19608 -- Add Suffix as an output of the service for display
**                      on Service Auth Header
**  04/17/05  CORLEYAN  SIR 23538 - Added retrieval of Donnated Community
**                      Service Information
**  08/18/05  NALLAVS   SIR 23703 -- Added code to Edit requiring at least one problem on the
**                      Outcome Matrix not working if Outcome Matrix is opened,
**                      but no problem has been identified.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/






public class Ccon18s {
    static final int NAME_LEN1 = 32;
    static final int MAX_DATEDAY1 = 31;
    static final int MAX_DATEMONTH1 = 12;
    static final int MAX_DATEYEAR1 = 4712;
    static final String FAMILY_PRES1 = "FPR";
    static final String SUBCARE1 = "SUB";
    static final String FAMILY_SUBCARE1 = "FSU";
    static final String FAM_REUNIFICATION1 = "FRE";
    static final String ADOPTION1 = "ADO";
    static final String POST_ADOPTION1 = "PAD";
    static final String INV_CCL_TYPE1 = "CCL";
    static final String FPR_CCL_TYPE1 = "STG";
    static final String EVENT_STATUS_PENDING1 = "PEND";
    static final String PAL1 = "PAL";
    static final String PAL_CCL_TYPE = "STG";
    static final String APS1 = "APS";
    static final String NEW1 = "NEW";
    static final String INV_OUTCOME_MATRIX = "2090";
    static final String AOC_OUTCOME_MATRIX = "5030";
    static final String SVC_OUTCOME_MATRIX = "6070";
    static final int INITIAL_PAGE2 = 1;
    static final String INVESTIGATION1 = "INV";
    static final String AGING_OUT1 = "AOC";
    static final String SERVICE_DELIVERY1 = "SVC";
    static final int FND_FAILURE1 = 1;
    static final String VC_PERP = "VP";
    static final int ONE_ROW1 = 1;
    static final String PRINCIPAL1 = "PRN";
    static final int MAX_ROWS = 50;
    static final String CLIENT1 = "CL";
    static final String VICTIM1 = "VC";
    
    /*
    ** SIR 2903
    ** Added FRE stage type
    */
    static final String FAMILY_REUNIF = "FRE";
    static final String SUBCARE1 = "SUB";
    static final String FAMILY_SUBCARE1 = "FSU";
    static final int INITIAL_PAGE2 = 1;
    static final int MSG_SVA_NOT_FROM_INVEST1 = 8332;
    static final String ADOPTION1 = "ADO";
    static final String FAMILY_PRES1 = "FPR";
    static final String PRIMARY_CHILD2 = "PC";
    CCON18SO CCON18S(CCON18SI ccon18si) {
        CCON18SO ccon18so = new CCON18SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        
        int rc = FND_SUCCESS;
        
        /*
        ** Call DAM
        */
        rc = ARC_UTLCheckServiceBatchBlock("CCON18S", pServiceStatus);
        
        /*
        ** Free memory before processing any user function error.
        ** By the time the return code is checked,
        ** all clean-up processing has occured.
        */
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        public public public public int i199 = 0;
        
        
        int RetVal = SUCCESS;
        int ulIdPersonTemp = 0;/* Placeholder for IdPerson */
        String szNmPersonFullTemp = new String();/* Placeholder for Person Name */
        String szCdNameSuffixTemp = new String();/* Placeholder for Person Suffix */
        /* 19608 */
        
        
        /*
        ** SIR 20465
        */
        int ulIdSubPerson = 0;
        int j = 0;
        
        /*
        ** SIR 2903
        */
        boolean bIndFoundSub = false;
        FndInt3date dtDtStageClose5 = null;
        
        /*
        ** initialize CCMN87D  pointers.
        ** CCMN87D uses ID STAGE to check for rows on the EVENT table where CD TASK
        ** is 'Client Assessment' (2080)
        */
        public public public public public public public public public public public CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** SIR 23703 - Initialize CLSS90D  pointers.
        ** CLSS90D uses ID STAGE to check for rows on the APS OUTCOME MATRIX TABLE  */
        CLSS90DI pCLSS90DInputRec = null;
        CLSS90DO pCLSS90DOutputRec = null;
        
        
        /*
        ** Initialize CCMN45D  pointers.
        **
        ** CCMN45 is called to retrieve Events
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Initialize CSES24D pointers
        **
        ** CSES24D is called to retrieve the ID SVC AUTH from
        ** the SVC_AUTH_EVENT_LINK table
        */
        CSES24DI pCSES24DInputRec = null;
        CSES24DO pCSES24DOutputRec = null;
        
        /*
        ** Initialize CSES85D pointers
        **
        ** CSES85D is called to retrieve the Header information from the
        ** SERVICE_AUTHORIZATION table
        **
        ** _CSES85DI       *pCSES85DInputRec;
        ** _CSES85DO       *pCSES85DOutputRec;
        **
        ** SIR 21766:  CSES85D has been broken into three different DAMs, and
        ** will no longer be called.  The three new DAMs are below:
        */
        
        /*
        ** Svc Auth header retrieve
        */
        
        CSES23DI pCSES23DInputRec = null;
        CSES23DO pCSES23DOutputRec = null;
        
        CLSS71DI pCLSS71DInputRec = null;
        CLSS71DO pCLSS71DOutputRec = null;
        
        CSES86DI pCSES86DInputRec = null;
        CSES86DO pCSES86DOutputRec = null;
        
        
        
        /*
        ** declare CLSS24D - Service Authorization Detail Retrieve; called
        ** to see if there is a row on the SVC_AUTH_DTL table, and if so
        ** set the DtlRecExist indicator to TRUE
        */
        CLSS24DI pCLSS24DInputRec = null;
        CLSS24DO pCLSS24DOutputRec = null;
        
        /*
        ** Initialize CRES04D pointers
        **
        ** CRES04D is called to retrieve Resource information from the
        ** CAPS_RESOURCE table
        */
        CRES04DI pCRES04DInputRec = null;
        CRES04DO pCRES04DOutputRec = null;
        
        /*
        ** Initialize CSEC10D pointers
        **
        ** CSEC10 is called to retrieve a row from Contract_County given
        ** the host variable match when it falls within a specific date
        ** period.
        */
        CSEC10DI pCSEC10DInputRec = null;
        CSEC10DO pCSEC10DOutputRec = null;
        
        /*
        ** Initialize CSEC57D pointers
        **
        ** CSEC57 is called to select a full row from the contract & contract
        ** period table given data from the Output of CSEC10D
        */
        CSEC57DI pCSEC57DInputRec = null;
        CSEC57DO pCSEC57DOutputRec = null;
        
        /*
        ** Initialize CheckStageEventStatus pointers
        **
        ** CheckStageEventStatus is called to check the status of the current
        ** stage.  If the stage has been closed by another worker, the current
        ** user will receive a message and will not be allowed to navigate
        ** into the SvcAuth dialog (SIR 2575)
        */
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        
        /*
        ** Initialize CLSC18D pointers
        **
        ** CLSC18D is called to retrieve all principals for the given stage.
        ** This data will be used to populate the 'Primary Client' combo box
        ** on CCON13W.  SIR 3106   BSM
        */
        CLSC18DI pCLSC18DInputRec = null;
        CLSC18DO pCLSC18DOutputRec = null;
        
        /*
        ** SIR 2903
        ** Added new dam
        */
        CLSC59DI pCLSC59DInputRec = null;
        CLSC59DO pCLSC59DOutputRec = null;
        
        /*
        ** SIR# ETW: Added new DAM
        ** CSES26D is called to retrieve the DtSituationOpened
        ** given an input of ulIdStage.
        */
        CSES26DI pCSES26DInputRec = null;
        CSES26DO pCSES26DOutputRec = null;
        
        /*
        ** SIR #20525
        */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        public public public public public public public public public public public public public public public public public public public public public public public public rc = ARC_PRFServiceStartTime_TUX(ccon18si.getArchInputStruct());
        
        /*
        ** IMPACT BEGIN - Leave event status in PEND, if in "Approver mode"
        */
        if (WINDOW_MODE_INQUIRE != ccon18si.getArchInputStruct().getCReqFuncCd()) {
            // 
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common
            // function
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(ccon18si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(ccon18si.getSzCdTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    break;
                case Messages.MSG_SYS_STAGE_CLOSED:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_INVALID_TASK;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE1;
                    
                    break;
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE1;
                    break;
                case Messages.MSG_SYS_MULT_INST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE1;
                    
                    //  SIR#3054: Added missing break statements to the
                    // nested switches.  Missing statements were causing the
                    // logic to fall into the default case and failing the
                    // service.
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE1;
                    break;
            }
        }
        if (((WINDOW_MODE_NEW == ccon18si.getArchInputStruct().getCReqFuncCd()) || (WINDOW_MODE_NEW_USING == ccon18si.getArchInputStruct().getCReqFuncCd())) && (0 != ccon18si.getSzCdUnitProgram().compareTo(APS1))) {
            //  Allocate memory for DAM Input and Output Structures
            pCLSC59DInputRec = new CLSC59DI();
            
            pCLSC59DOutputRec = new CLSC59DO();
            pCLSC59DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
            pCLSC59DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE2);
            pCLSC59DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC59DO._CLSC59DO__ROWCLSC59DO_SIZE);
            pCLSC59DInputRec.setUlIdCase(ccon18si.getUlIdCase());
            rc = clsc59dQUERYdam(sqlca, pCLSC59DInputRec, pCLSC59DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    //  Loop through all the rows returned by the dam and
                    // see if there have been any SUBcare or Family SUbcare
                    // stages opened
                    //  SIR 20465
                    // Modified the If test when looping through the rows
                    // Make sure the stage the SvcAuths should be entered in
                    // is open and added logic for other stages.
                    for (i199 = 0;i199 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty() && bIndFoundSub == false;i199++) {
                        if ((0 == ccon18si.getSzCdStage().compareTo(INVESTIGATION1)) && ((0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(SUBCARE1)) || (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(FAMILY_SUBCARE1)) || (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(FAMILY_REUNIF)) || (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(ADOPTION1)) || (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(FAMILY_PRES1))) && ((DateHelper.NULL_DATE == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year) || (DateHelper.ARC_MAX_YEAR == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year))) {
                            pServiceStatus.severity = FND_SEVERITY_WARNING;
                            pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_NEW_STAGE;
                            
                            
                            RetVal = FND_FAILURE1;
                            bIndFoundSub = true;
                        }
                        //  Subcare stage
                        // Two if's here, one if the Family Reunification stage is open
                        // and one if there is an Adoption stage open. If the Adoption
                        // stage is open, we have to make sure it's an Adoption stage for
                        // that child.
                        else if ((0 == ccon18si.getSzCdStage().compareTo(SUBCARE1)) && (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(FAMILY_REUNIF)) && ((DateHelper.NULL_DATE == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year) || (DateHelper.ARC_MAX_YEAR == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year))) {
                            pServiceStatus.severity = FND_SEVERITY_WARNING;
                            pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_NEW_STAGE;
                            
                            
                            RetVal = FND_FAILURE1;
                            bIndFoundSub = true;
                        }
                        //  Subcare with an Adoption stage open
                        else if ((0 == ccon18si.getSzCdStage().compareTo(SUBCARE1)) && (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(ADOPTION1)) && ((DateHelper.NULL_DATE == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year) || (DateHelper.ARC_MAX_YEAR == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year))) {
                            //  Call CLSC18D to find the PC for the SUBcare stage and
                            // store it locally
                            //  Allocate memory for DAM Input and Output Structures
                            // for CLSC18D
                            pCLSC18DInputRec = new CLSC18DI();
                            
                            pCLSC18DOutputRec = new CLSC18DO();
                            pCLSC18DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                            pCLSC18DInputRec.setSzCdStagePersType(PRINCIPAL1);
                            pCLSC18DInputRec.setUlIdStage(ccon18si.getUlIdStage());
                            
                            pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE2);
                            pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_ROWS);
                            rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set fields in CCON22SO to fields in CLSC18DO
                                    for (j = 0;j < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                        if (0 == PRIMARY_CHILD2.compareTo(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(j).getSzCdStagePersRole())) {
                                            
                                            ulIdSubPerson = pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(j).getUlIdPerson();
                                        }
                                    }
                                    pCLSC18DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                    pCLSC18DInputRec.setSzCdStagePersType(PRINCIPAL1);
                                    pCLSC18DInputRec.setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getUlIdStage());
                                    pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE2);
                                    pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_ROWS);
                                    rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
                                    
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            //  Set fields in CCON22SO to fields in CLSC18DO
                                            for (j = 0;j < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty();j++) {
                                                if ((0 == PRIMARY_CHILD2.compareTo(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(j).getSzCdStagePersRole())) && (pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(j).getUlIdPerson() == ulIdSubPerson)) {
                                                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                                                    pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_NEW_STAGE;
                                                    
                                                    
                                                    RetVal = FND_FAILURE1;
                                                    bIndFoundSub = true;
                                                }
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = Messages.MSG_CON_PRINCIPLE;
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                    
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = Messages.MSG_CON_PRINCIPLE;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        
                        
                        
                        //  Family Reunification stage
                        // SIR #20890 - Commented out Family Reunification else statement
                        // so that Service Auths can be created for Family Reunification
                        // Stages at all times.  Always allow new Service Auths in FRE
                        // Stage because of the possibility of doing a removal from the
                        // FRE stage and still having the original FSU stage open.
                        // 
                        // else if((0 == strcmp(pInputMsg->szCdStage, FAMILY_REUNIF))&&
                        // (0 == strcmp(pCLSC59DOutputRec->ROWCLSC59DO[i].szCdStage,FAMILY_SUBCARE))&&
                        // ((NULL_DATE == pCLSC59DOutputRec->ROWCLSC59DO[i].dtDtStageClose.year)||
                        // (ARC_MAX_YEAR == pCLSC59DOutputRec->ROWCLSC59DO[i].dtDtStageClose.year)))
                        // {
                        // pServiceStatus->severity = FND_SEVERITY_WARNING;
                        // pServiceStatus->explan_code = MSG_SVC_AUTH_NEW_STAGE;
                        // RetVal = FND_FAILURE;
                        // bIndFoundSub = TRUE;
                        // }* end if Family Reunification *
                        // 
                        //  Family Preservation stage
                        else if ((0 == ccon18si.getSzCdStage().compareTo(FAMILY_PRES1)) && (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(FAMILY_SUBCARE1)) && ((DateHelper.NULL_DATE == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year) || (DateHelper.ARC_MAX_YEAR == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year))) {
                            pServiceStatus.severity = FND_SEVERITY_WARNING;
                            pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_NEW_STAGE;
                            
                            
                            RetVal = FND_FAILURE1;
                            bIndFoundSub = true;
                        }
                        
                        //  SIR #20914 - Family Subcare Stage
                        // Should not be able to create a new Service Auth in FSU
                        // when an FRE stage is open.
                        
                        else if ((0 == ccon18si.getSzCdStage().compareTo(FAMILY_SUBCARE1)) && (0 == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getSzCdStage().compareTo(FAMILY_REUNIF)) && ((DateHelper.NULL_DATE == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year) || (DateHelper.ARC_MAX_YEAR == pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i199).getDtDtStageClose().year))) {
                            pServiceStatus.severity = FND_SEVERITY_WARNING;
                            pServiceStatus.explan_code = Messages.MSG_SVC_AUTH_NEW_STAGE;
                            
                            
                            RetVal = FND_FAILURE1;
                            bIndFoundSub = true;
                            
                        }
                    }
                    
                    //  SIR#3054: Added missing break statements to the
                    // nested switches.  Missing statements were causing the
                    // logic to fall into the default case and failing the
                    // service.
                    break;
                    
                    
                default :
                    
                    RetVal = FND_FAILURE1;
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            //  SIR 3106 - Call CLSC18D regardless of Event Status.  CLSC18D
            // will return all Principals for the Id Stage   BSM
            
            //  Allocate memory for DAM Input and Output Structures
            // for CLSC18D
            pCLSC18DInputRec = new CLSC18DI();
            
            pCLSC18DOutputRec = new CLSC18DO();
            pCLSC18DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
            pCLSC18DInputRec.setSzCdStagePersType(PRINCIPAL1);
            
            pCLSC18DInputRec.setUlIdStage(ccon18si.getUlIdStage());
            pCLSC18DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE2);
            pCLSC18DInputRec.getArchInputStruct().setUlPageSizeNbr(MAX_ROWS);
            
            //  Call DAM
            rc = clsc18dQUERYdam(sqlca, pCLSC18DInputRec, pCLSC18DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CCON22SO to fields in CLSC18DO
                    for (i199 = 0;i199 < pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty();i199++) {
                        ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).setSzCdStagePersRole(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i199).getSzCdStagePersRole());
                        
                        ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).setSzNmPersonFull(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i199).getSzNmPersonFull());
                        ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).setUlIdPerson(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i199).getUlIdPerson());
                        ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).setSzCdNameSuffix(pCLSC18DOutputRec.getROWCLSC18DO_ARRAY().getROWCLSC18DO(i199).getSzCdNameSuffix());
                    }
                    ccon18so.getArchOutputStruct().setUlRowQty(pCLSC18DOutputRec.getArchOutputStruct().getUlRowQty());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = Messages.MSG_CON_PRINCIPLE;
                    
                    //  SIR 20659
                    // Add RetVal fail
                    RetVal = Csub50s.FND_FAIL;
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            if (0 == APS1.compareTo(ccon18si.getSzCdUnitProgram())) {
                //  IMPACT BEGIN - Arrays in C go from zero to "count - 1".
                // So, the loop has been corrected to ensure we don't go off into
                // uncharted memory...
                // original code:
                // for(i = 0; i <= pOutputMsg->ArchOutputStruct.ulRowQty; i++)
                for (i199 = 0;i199 < ccon18so.getArchOutputStruct().getUlRowQty();i199++) {
                    
                    //  If ReqFuncCd from InputMsg = ADD,
                    // allocate memory for DAM Input and Output Structures
                    if (0 == ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getSzCdStagePersRole().compareTo(VICTIM1) || 0 == ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getSzCdStagePersRole().compareTo(CLIENT1) || 0 == ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getSzCdStagePersRole().compareTo(VC_PERP)) {
                        //  Copy the IdPerson and NmPersonFull to placeholder variables
                        ulIdPersonTemp = ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getUlIdPerson();
                        szNmPersonFullTemp = ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getSzNmPersonFull();
                        szCdNameSuffixTemp = ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getSzCdNameSuffix();
                        ccon18so.ROWCCON18SOG00 = new ROWCCON18SOG00[]();
                        
                        
                        //  Loop through returned rows.
                        // Check to see if any of them match
                        // a row in the SPLink table.
                        // If yes, then that IdPersonForward
                        // needs to replace the existing
                        // IdPrimaryClient in the output msg.
                        // If no, then don't change the existing
                        // primary client person ID.
                        
                        for (int ROWCCON18SOG001 = 0;ROWCCON18SOG001 < ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00Count();ROWCCON18SOG001++) {
                            ccon18so.getROWCCON18SOG00_ARRAY().setROWCCON18SOG00(ROWCCON18SOG001, new ROWCCON18SOG00());
                        }
                        ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(0).setUlIdPerson(ulIdPersonTemp);
                        
                        ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(0).setSzNmPersonFull(szNmPersonFullTemp);
                        ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(0).setSzCdNameSuffix(szCdNameSuffixTemp);
                        
                        //  re-initialize temp variables
                        ulIdPersonTemp = 0;
                        Arrays.fill(szNmPersonFullTemp, 0, NAME_LEN1, 0);
                        Arrays.fill(szCdNameSuffixTemp, 0, 3, 0);
                        ccon18so.getArchOutputStruct().setUlRowQty(ONE_ROW1);
                    }
                }
            }
            if ((0 == ccon18si.getUlIdEvent()) && (0 == strncmp(ccon18si.getSzCdUnitProgram() , APS1, APS1.length()))) {
                
                // SIR 23703-Check outcome matrix problems exits and if not outcome matrix problem then an
                // error message is displayed
                //  Allocate memory for DAM Input and Output Structures
                pCLSS90DInputRec = new CLSS90DI();
                
                pCLSS90DOutputRec = new CLSS90DO();
                pCLSS90DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                
                pCLSS90DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE2);
                pCLSS90DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS90DO._CLSS90DO__ROWCLSS90DO_SIZE);
                pCLSS90DInputRec.setUlIdStage(ccon18si.getUlIdStage());
                
                rc = clss90dQUERYdam(sqlca, pCLSS90DInputRec, pCLSS90DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // SIR #21883 - End bracket of For Loop is deleted here
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CON_NO_CLIENT_FACTOR;
                        ccon18so.setError_message(Messages.MSG_CON_NO_CLIENT_FACTOR);
                        rc = SUCCESS;
                        RetVal = SUCCESS;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        RetVal = Csub50s.FND_FAIL;
                        
                        break;
                }
            }
            else if (0 != ccon18si.getUlIdEvent()) {
                //  Allocate memory for DAM Input and Output Structures
                pCCMN45DInputRec = new CCMN45DI();
                
                pCCMN45DOutputRec = new CCMN45DO();
                pCCMN45DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                
                pCCMN45DInputRec.setUlIdEvent(ccon18si.getUlIdEvent());
                rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccon18so.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                        ccon18so.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                        ccon18so.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                        
                        ccon18so.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                        ccon18so.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                        ccon18so.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                        ccon18so.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                        ccon18so.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                        ccon18so.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                        if (!(ccon18si.getSzCdUnitProgram().compareTo(APS1) != 0) &&!(ccon18so.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(NEW1) != 0)) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCCMN87DInputRec = new CCMN87DI();
                            
                            pCCMN87DOutputRec = new CCMN87DO();
                            pCCMN87DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                            pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            
                            //  If authorization occurs from a contract outside
                            // the users region, create a todo for that region's
                            // supervisor.
                            
                            //  SIR 2840 01/20/96  BSM
                            // Only create the todo if the Service Authorization has
                            // been completed.
                            if (0 == ccon18si.getSzCdStage().compareTo(INVESTIGATION1)) {
                                pCCMN87DInputRec.setSzCdTask(INV_OUTCOME_MATRIX);
                            }
                            else if (0 == ccon18si.getSzCdStage().compareTo(AGING_OUT1)) {
                                pCCMN87DInputRec.setSzCdTask(AOC_OUTCOME_MATRIX);
                            }
                            else // stage is Service Delivery
                            {
                                pCCMN87DInputRec.setSzCdTask(SVC_OUTCOME_MATRIX);
                            }
                            pCCMN87DInputRec.setUlIdStage(ccon18so.getROWCCMN01UIG00().getUlIdStage());
                            
                            //  Call DAM
                            rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CON_NO_CLIENT_FACTOR;
                                    ccon18so.setError_message(Messages.MSG_CON_NO_CLIENT_FACTOR);
                                    
                                    rc = SUCCESS;
                                    RetVal = SUCCESS;
                                    break;
                                case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                                    rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                                    RetVal = Csub50s.FND_FAIL;
                                    
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    RetVal = Csub50s.FND_FAIL;
                                    
                                    break;
                            }
                        }
                        
                        if (ccon18so.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(NEW1) != 0) {
                            //  Allocate memory for DAM Input and Output Structures
                            pCSES24DInputRec = new CSES24DI();
                            
                            pCSES24DOutputRec = new CSES24DO();
                            pCSES24DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                            pCSES24DInputRec.setUlIdSvcAuthEvent(ccon18si.getUlIdEvent());
                            rc = cses24dQUERYdam(sqlca, pCSES24DInputRec, pCSES24DOutputRec);
                            
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    ccon18so.setUlIdSvcAuth(pCSES24DOutputRec.getUlIdSvcAuth());
                                    
                                    //    begin 21766 SIR changes 7/10/96 
                                    
                                    
                                    //  21766: Allocate memory for DAM Input and Output Structures
                                    // No longer using CSES85D - replaced with CSES23D
                                    pCSES23DInputRec = new CSES23DI();
                                    
                                    pCSES23DOutputRec = new CSES23DO();
                                    pCSES23DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                    pCSES23DInputRec.setUlIdSvcAuth(ccon18so.getUlIdSvcAuth());
                                    
                                    //  Call DAM
                                    rc = cses23dQUERYdam(sqlca, pCSES23DInputRec, pCSES23DOutputRec);
                                    
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            ccon18so.setUlIdResource(pCSES23DOutputRec.getUlIdResource());
                                            ccon18so.setCIndSvcAuthComplete(pCSES23DOutputRec.getCIndSvcAuthComplete());
                                            ccon18so.setUlIdContract(pCSES23DOutputRec.getUlIdContract());
                                            ccon18so.setCIndDntdCmmtySvc(pCSES23DOutputRec.getCIndDntdCmmtySvc());
                                            ccon18so.setSzCdSvcAuthCounty(pCSES23DOutputRec.getSzCdSvcAuthCounty());
                                            ccon18so.setSzCdSvcAuthRegion(pCSES23DOutputRec.getSzCdSvcAuthRegion());
                                            ccon18so.setSzCdSvcAuthService(pCSES23DOutputRec.getSzCdSvcAuthService());
                                            ccon18so.setSzCdSvcAuthCategory(pCSES23DOutputRec.getSzCdSvcAuthCategory());
                                            ccon18so.setSzTxtSvcAuthComments(pCSES23DOutputRec.getSzTxtSvcAuthComments());
                                            ccon18so.setSzTxtSvcAuthSecProvdr(pCSES23DOutputRec.getSzTxtSvcAuthSecProvdr());
                                            ccon18so.setSzCdSvcAuthCounty(pCSES23DOutputRec.getSzCdSvcAuthCounty());
                                            ccon18so.setDtDtSvcAuthEff(pCSES23DOutputRec.getDtDtSvcAuthEff());
                                            ccon18so.setTsLastUpdate(pCSES23DOutputRec.getTsLastUpdate());
                                            
                                            
                                            //  Allocate memory for the Person Merge Lst DAM call.
                                            pCLSS71DInputRec = new CLSS71DI();
                                            
                                            pCLSS71DOutputRec = new CLSS71DO();
                                            pCLSS71DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                            pCLSS71DInputRec.getArchInputStruct().setUlPageSizeNbr(INITIAL_PAGE2);
                                            pCLSS71DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE2);
                                            pCLSS71DInputRec.setUlIdPrimaryClient(pCSES23DOutputRec.getUlIdPrimaryClient());
                                            rc = clss71dQUERYdam(sqlca, pCLSS71DInputRec, pCLSS71DOutputRec);
                                            
                                            if (pCLSS71DOutputRec.getROWCLSS71DO_ARRAY().getROWCLSS71DO(0).getUlIdPersMergeForward() != 0) {
                                                
                                                //  Allocate memory for the StagePersLink Chk DAM call.
                                                pCSES86DInputRec = new CSES86DI();
                                                
                                                pCSES86DOutputRec = new CSES86DO();
                                                pCSES86DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                                pCSES86DInputRec.setUlIdStage(ccon18si.getUlIdStage());
                                                
                                                //  end of Kym's changes for Perf SIR#21766 
                                                
                                                
                                                //  SIR 3106 - Loop through the CCON18SOG00 structure to find
                                                // the IdPerson that matches the IdPrimaryClient returned from
                                                // CSES23D.  (Or the new IdPrimaryClient found in the Person
                                                // Merge/SPlink DAM calls.)
                                                // We only want to send this NmPersonFull and
                                                // IdPerson back to the client
                                                // IMPACT BEGIN - Arrays in C go from zero to "count - 1".
                                                // So, the loop has been corrected to ensure we don't
                                                // go off into uncharted memory...
                                                // original code:
                                                // for(i = 0; i <= pOutputMsg->ArchOutputStruct.ulRowQty; i++)
                                                for (i199 = 0;i199 < pCLSS71DOutputRec.getArchOutputStruct().getUlRowQty();i199++) {
                                                    pCSES86DInputRec.setUlIdPersMergeForward(pCLSS71DOutputRec.getROWCLSS71DO_ARRAY().getROWCLSS71DO(i199).getUlIdPersMergeForward());
                                                    rc = cses86dQUERYdam(sqlca, pCSES86DInputRec, pCSES86DOutputRec);
                                                    
                                                    switch (rc) {
                                                        case SUCCESS:
                                                            pCSES23DOutputRec.setUlIdPrimaryClient(pCSES86DInputRec.getUlIdPersMergeForward());
                                                            
                                                            break;
                                                        case NO_DATA_FOUND:
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                            
                                                            break;
                                                    }
                                                }
                                            }
                                            else if ((rc != SUCCESS) && (rc != NO_DATA_FOUND)) {
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            }
                                            for (i199 = 0;i199 < ccon18so.getArchOutputStruct().getUlRowQty();i199++) {
                                                
                                                
                                                //  Call InvalidateApproval Common Function if PREVIOUS CdEvent
                                                // status in CCON19SI is pending 'PEND'
                                                if (ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getUlIdPerson() == pCSES23DOutputRec.getUlIdPrimaryClient()) {
                                                    //  Copy the IdPerson and NmPersonFull to placeholder variables
                                                    ulIdPersonTemp = ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getUlIdPerson();
                                                    szNmPersonFullTemp = ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getSzNmPersonFull();
                                                    szCdNameSuffixTemp = ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(i199).getSzCdNameSuffix();
                                                    ccon18so.ROWCCON18SOG00 = new ROWCCON18SOG00[]();
                                                    for (int ROWCCON18SOG001 = 0;ROWCCON18SOG001 < ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00Count();ROWCCON18SOG001++) {
                                                        ccon18so.getROWCCON18SOG00_ARRAY().setROWCCON18SOG00(ROWCCON18SOG001, new ROWCCON18SOG00());
                                                    }
                                                    ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(0).setUlIdPerson(ulIdPersonTemp);
                                                    ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(0).setSzNmPersonFull(szNmPersonFullTemp);
                                                    ccon18so.getROWCCON18SOG00_ARRAY().getROWCCON18SOG00(0).setSzCdNameSuffix(szCdNameSuffixTemp);
                                                    
                                                    //  re-initialize temp variables
                                                    ulIdPersonTemp = 0;
                                                    
                                                    Arrays.fill(szNmPersonFullTemp, 0, NAME_LEN1, 0);
                                                    Arrays.fill(szCdNameSuffixTemp, 0, 3, 0);
                                                    ccon18so.getArchOutputStruct().setUlRowQty(ONE_ROW1);
                                                }
                                            }
                                            //  IMPACT END
                                            
                                            
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCLSS24DInputRec = new CLSS24DI();
                                            
                                            pCLSS24DOutputRec = new CLSS24DO();
                                            pCLSS24DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                            pCLSS24DInputRec.getArchInputStruct().setUlPageSizeNbr(INITIAL_PAGE2);
                                            pCLSS24DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE2);
                                            pCLSS24DInputRec.setUlIdSvcAuth(ccon18so.getUlIdSvcAuth());
                                            
                                            //  Call DAM
                                            rc = clss24dQUERYdam(sqlca, pCLSS24DInputRec, pCLSS24DOutputRec);
                                            
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    ccon18so.setBScrIndDtlRecExist(true);
                                                    
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    ccon18so.setBScrIndDtlRecExist(false);
                                                    
                                                    
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCSEC10DInputRec = new CSEC10DI();
                                            
                                            pCSEC10DOutputRec = new CSEC10DO();
                                            pCSEC10DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                            pCSEC10DInputRec.setUlIdResource(ccon18so.getUlIdResource());
                                            pCSEC10DInputRec.setSzCdCncntyCounty(ccon18so.getSzCdSvcAuthCounty());
                                            pCSEC10DInputRec.setSzCdCncntyService(ccon18so.getSzCdSvcAuthService());
                                            
                                            if (((DateHelper.NULL_DATE != ccon18so.getDtDtSvcAuthEff().day) && (DateHelper.NULL_DATE != ccon18so.getDtDtSvcAuthEff().month) && (DateHelper.NULL_DATE != ccon18so.getDtDtSvcAuthEff().year)) && ((0 != ccon18so.getDtDtSvcAuthEff().day) && (0 != ccon18so.getDtDtSvcAuthEff().month) && (0 != ccon18so.getDtDtSvcAuthEff().year))) {
                                                pCSEC10DInputRec.setDtScrDtCurrentDate(pCSES23DOutputRec.getDtDtSvcAuthEff());
                                            }
                                            else {
                                                
                                                rc = ARC_UTLHostToDateAndTime(pCSEC10DInputRec.getDtScrDtCurrentDate() , pCSEC10DInputRec.getTmScrTmGeneric1() , pCSES24DOutputRec.getTsLastUpdate() , 0);
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            }
                                            rc = csec10dQUERYdam(sqlca, pCSEC10DInputRec, pCSEC10DOutputRec);
                                            
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    ccon18so.setUlNbrCncntyPeriod(pCSEC10DOutputRec.getUlNbrCncntyPeriod());
                                                    ccon18so.setUlNbrCncntyVersion(pCSEC10DOutputRec.getUlNbrCncntyVersion());
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCSEC57DInputRec = new CSEC57DI();
                                                    
                                                    pCSEC57DOutputRec = new CSEC57DO();
                                                    pCSEC57DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                                    pCSEC57DInputRec.setUlIdContract(pCSEC10DOutputRec.getUlIdContract());
                                                    pCSEC57DInputRec.setUlNbrCnperPeriod(pCSEC10DOutputRec.getUlNbrCncntyPeriod());
                                                    rc = csec57dQUERYdam(sqlca, pCSEC57DInputRec, pCSEC57DOutputRec);
                                                    
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            ccon18so.setUlIdCntrctManager(pCSEC57DOutputRec.getUlIdCntrctManager());
                                                            ccon18so.setDtDtCnperClosure(pCSEC57DOutputRec.getDtDtCnperClosure());
                                                            ccon18so.setDtDtCnperStart(pCSEC57DOutputRec.getDtDtCnperStart());
                                                            ccon18so.setCIndCnperRenewal(pCSEC57DOutputRec.getCIndCnperRenewal());
                                                            ccon18so.setSzCdCnperStatus(pCSEC57DOutputRec.getSzCdCnperStatus());
                                                            
                                                            ccon18so.setSzCdCntrctRegion(pCSEC57DOutputRec.getSzCdCntrctRegion());
                                                            ccon18so.setCIndCntrctBudgLimit(pCSEC57DOutputRec.getCIndCntrctBudgLimit());
                                                            break;
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                                            
                                                            //  Call DAM
                                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            break;
                                                    }
                                                    
                                                    
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                                    
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    
                                                    break;
                                            }
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCRES04DInputRec = new CRES04DI();
                                            
                                            pCRES04DOutputRec = new CRES04DO();
                                            pCRES04DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                                            pCRES04DInputRec.setUlIdResource(ccon18so.getUlIdResource());
                                            rc = cres04dQUERYdam(sqlca, pCRES04DInputRec, pCRES04DOutputRec);
                                            
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    ccon18so.setSzNmResource(pCRES04DOutputRec.getSzNmResource());
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    break;
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                            
                                            //  Call DAM
                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                            break;
                                            
                                        default :
                                            
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                    
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                        break;
                    default :// Event Retrieve
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
        }
        
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            // for CSES26D
            pCSES26DInputRec = new CSES26DI();
            
            pCSES26DOutputRec = new CSES26DO();
            pCSES26DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
            pCSES26DInputRec.setUlIdStage(ccon18si.getUlIdStage());
            rc = cses26dQUERYdam(sqlca, pCSES26DInputRec, pCSES26DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccon18so.setDtDtSituationOpened(pCSES26DOutputRec.getDtDtSituationOpened());
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        /*
        ** Call CLSS24D if CdUnitProgram is APS and bScrIndFrstTmComp == TRUE
        */
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            // for CINT21D
            pCINT21DInputRec = new CINT21DI();
            
            pCINT21DOutputRec = new CINT21DO();
            pCINT21DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
            //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
            // SQL error returned from the DAM.
            pCINT21DInputRec.setUlIdStage(ccon18si.getUlIdStage());
            
            //  Call DAM
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    dtDtStageClose5 = pCINT21DOutputRec.getDtDtStageClose();
                    if (((DateHelper.NULL_DATE != dtDtStageClose5.day) && (DateHelper.NULL_DATE != dtDtStageClose5.month) && (DateHelper.NULL_DATE != dtDtStageClose5.year)) && ((MAX_DATEDAY1 != dtDtStageClose5.day) && (MAX_DATEMONTH1 != dtDtStageClose5.month) && (MAX_DATEYEAR1 != dtDtStageClose5.year))) {
                        
                        ccon18so.setBIndStageClose(1);
                        ccon18so.setDtDtStageClose(dtDtStageClose5);
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCINT21DInputRec = new CINT21DI();
            
            pCINT21DOutputRec = new CINT21DO();
            pCINT21DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
            pCINT21DInputRec.setUlIdStage(ccon18si.getUlIdStage());
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    //  When we find out what the stage is, we need to determine which
                    // Event Type to pass to the event retrieval dam
                    // 
                    // BEGIN CCMN87D : Event Retrieval
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN87DInputRec = new CCMN87DI();
                    
                    pCCMN87DOutputRec = new CCMN87DO();
                    pCCMN87DInputRec.setArchInputStruct(ccon18si.getArchInputStruct());
                    pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
                    //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                    // SQL error returned from the DAM.
                    pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                    
                    pCCMN87DInputRec.setUlIdStage(ccon18si.getUlIdStage());
                    if (0 == INVESTIGATION1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE1);
                    }
                    else if (0 == FAMILY_PRES1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(FPR_CCL_TYPE1);
                    }
                    else if (0 == SUBCARE1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE1);
                    }
                    else if (0 == FAMILY_SUBCARE1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE1);
                    }
                    else if (0 == FAM_REUNIFICATION1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE1);
                    }
                    else if (0 == ADOPTION1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE1);
                    }
                    else if (0 == POST_ADOPTION1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE1);
                    }
                    else if (0 == AGING_OUT1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE1);
                    }
                    else if (0 == SERVICE_DELIVERY1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(FPR_CCL_TYPE1);
                    }
                    // SIR 19811
                    else if (0 == PAL1.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(PAL_CCL_TYPE);
                    }
                    rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING1, EVENT_STATUS_PENDING1.length()) != 0)) {
                                ccon18so.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                            }
                            else {
                                ccon18so.setUlIdEvent(0);
                            }
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            ccon18so.setUlIdEvent(0);
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                        case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                            rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                            
                            RetVal = Csub50s.FND_FAIL;
                            
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                    
                    // 
                    // END CCMN87D: Event Retrieval
                    // 
                    
                    RetVal = SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon18si.getArchInputStruct() , ccon18so.getArchOutputStruct());
        
        if (RetVal == SUCCESS) {
            
            //  Call DAM
            rc = SUCCESS;
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            // 01/22/2003 DWW: Added for error handling
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccon18so;
    }

}
