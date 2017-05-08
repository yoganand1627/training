package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS21DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN91DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN91DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS18DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC7DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECA9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECA9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC97DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC97DO;
/**************************************************************************
**
** Module File:   CSYS07S.src
**
** Service Name:  Save
**
** Description:   Save/Save And Submit Service for Contact Detail.
**                (CSYS10W)
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/6/95
**
** Programmer:    R. Michael Smith
**
** Function List
** -------------
** CallCSYS04D()       -- CONTACT Search/List DAM.
** CallCSYS04D1()      -- CONTACT Search/List DAM for Face to Face contacts
** CallCSYS07D()       -- CONTACT AUD DAM.
** CallCSYS11D()       -- CONTACT/EVENT retrieval join DAM.
** CallCINV43D()       -- TODO AUD DAM.
** CallCCMN62D()       -- EVENT Status UPDATE DAM ( ignores Timestamp ).
** CallCCMN60D()       -- Retrieves the Employees Supervisor.
** CallCCMN91D()       -- AUD for APPROVAL_EVENT_LINK.
** CallCSYS17D()       -- DELETE for TODO (ignores Timestamp).
** CallPostEvent()     -- EVENT AUD.
** CreateNEWContacts() -- Creates NEW EVENT, CONTACT shell, and TODOs.
** FindNEWContacts()   -- Looks for NEW EVENTs, CONTACT shells, and TODOs.
**
** File History:
**
** Date         User      Description
** ----         ----      -----------
** 05/22/95     laskeyrm  Removed ARC_ERR_FATAL_RETURN from code. Replaced with
**                        ARC_ERR_INTERNAL_ERROR.
**
** 06/06/95     laskeyrm  -Cleaned up code: Indentation, unused variables,
**                         Replaced parameter list withTUX_STATUSPARMS.
**                        -Made wholesale changes to error handling. This
**                         includes swapping PROCESS_TUX_RC_ERROR and
**                         PROCESS_TUX_SQL_ERROR.
**                        -Added check for failed malloc().
**                        -Added function headers and in-line comments.
**                        -Removed memcpy() on FND_INT3DATEs and replaced with
**                         =. Put constants on left side of equality
**                         comparisons.
**
** 06/12/95     laskeyrm  -Added logic to return TOO_MANY_CONTACTS_IN_MONTHLY
**                         to the client when more than 99 FPR Regular
**                         Contacts are included within a Monthly Summary
**                         Period.
**                        -Moved some more #defs to servdeli.h
**
** 06/20/95     laskeyrm  -Nuked and re-coded the top level service function:
**                         CSYS07S(). Most of the CallDam() functions stayed
**                         in place, encompassing the above changes.
**                         Significant design changes were made in the
**                         handling of special Contacts for which System
**                         Generated To-Dos may exist. The functions
**                         CHECKTODOS() and SETTODOS() were gutted and
**                         changed to FindNEWContacts()and CreateNEWContacts().
**                         A call to CSYS11D() was added to retrieve the
**                         timestamps for any shell Contacts and NEW Events.
**                         **This may present a race conditions if multiple
**                         workers are trying to complete a special Contact
**                         for the same Stage at the same time.** The other
**                         significant change deals with Invalidation of
**                         Approval packages. InvalidateAprvl() is now
**                         correctly called for both PENDing Contacts and
**                         PENDing Stage Conclusion Events.
**
** 06/20/95     laskeyrm  -Added patch to deal with SIR #1067/ User Gen'd
**                         To-Dos. See code/SIR #1067. CSYS10W.WIN changes
**                         were also made for this SIR. Note: ulPageSizeNbr
**                         is being used to indicate User Generated To-Do
**                         functionality. This is misleading.
**
** 09/12/95     bruckmk   -SIR 1316: Create ToDo and Contact Shell for first
**                         Face to Face Contact that is created for a stage.
**                         Edited areas have comments referring to SIR 1316.
**                         An extra call was added to the DAM CSYS04D using
**                         a newly created function (CallCSYS04D1).  If no
**                         rows are retrieved, meaning no face to face
**                         contacts exist for that stage, a call is made to
**                         the create contacts function.
**
** 10/02/95     bruckmk   -SIR 1482: Create ToDo and Contact Shell for first
**                         Face to Face Contact only if the Stage
**                         Classification is APS Community.  Added Retrieve
**                         Stage Classification Column in Retrieve service;
**                         added "szCdStageClassification" to Retrieve Output
**                         Message, Save Input Message and Window WCD; added
**                         if statement to check for classification code
**                         before creating shell.
**
** 10/02/95     bruckmk   -SIR 1318: Contact handles insert of NULL DATE
**                         improperly.  If the date is NULL, it is inserting
**                         00/00/0000 (NULL) instead of -1/-1/-1 (NULL_DATE).
**
** 10/04/95     vishnur   -SIR 1547 - Monthly status Todo description is
**                         modified to reflect 'this' month and on 20Th.
**
** 10/13/95 bruckmk    SIR 1722: For the initial Face to Face contact,
**      the Monthly Status ToDo should be created with a
**      due date base on the Contact Occurred Date rather
**      than the system date.
**      Added the sFaceToFaceExists flag to the CCMN43D
**      function call and added a check for the flag
**      within the CCMN43D function.
**
** 10/18/95 bruckmk    SIR 1834:  Three Month ToDo increment was only
**      being incremented by 2.  Changed the #define to 3
**      instead of 2.
**
** 10/19/95 bruckmk    SIR 1858: Replaced Record Group
**       "WCD_ROWCCMN01UIG00.ROWCCMN01UIG01" with
**      "ROWCSVC02SIG03" since the PostEvent Structure
**      could only handle 30 people at a time. This window
**      requires up to 50 people being added to Event
**      Person Link at a time, so a new Record Group had
**      to be added to the Save Service Input Message.
**       Also DAM CCMN68D was added to the save service to
**      handle adding people to Event Person Link instead
**      of the PostEvent Function.
**
** 10/24/95   sooleyag    SIR #1949 - Added code to ensure that only one
**      new monthly status is created at a time.
**
** 11/16/95  Helmkest  SIR 2041: Code added for release 2 contacts
**
** 01/12/96  guarricr  SIR 2602: CheckStageEventStatus should not be appicable
**      for Closed Stage Contacts. Added logic to check Contact Type before
**      running CCMN06U.
**
** 01/31/96  DYARGR    Sir 2986 - We don't want to create the monthly
**           status contact todo when AOC when the first face to face is
**           done, but after the Legal Action for Guardianship is done.
**
** 02/12/96  HELMKEST  SIR 2138: Code added to allow for the save and submit
**           of F/A Home contacts.  Some of these contact types will have
**           a summary period in order to "batch" the approval.
**
** 02/27/96  ELLIOTSL SIR #5057: Logic that calls CSYS04D should NULL out
**           the search criteria only in the DAM input message, not the
**           service input message.  The CreateNEWContacts function has
**           been changed to do this.
**
** 03/13/96  DENTONRA SIR #3787: Added FAHome types to input struct of
**           CSYS04D.PC
**
** 04/11/96  BRUCKMK    SIR 5185:If the ReqFuncCd is DELETE, we first need
**                                              to call CSVC32D to delete all rows from the
**                                              Event_person_link table before trying to delete
**                                              from the Event table.  To do this, CSVC32D DAM was
**                                              added to this service.
**
** 07/15/96  DYARGR     SIR 21812 - Double allocation of pointers for
**                      CallPostEvent.
** 08/15/96  OMARAJJ    SIR# 10609 - changed the following condition for
**                      FacetoFacE contacts from an independent IF statement
**                      to an else if condition so that only one ToDo is
**                      created.  Previously,if on the first contact the user
**                      selected type Monthly Status and Face to Face type
**                      the system created two identical ToDos.
**
** 05/13/97  GONZALCE  SIR 13618 - MHMR Enhancement:  Request for Review
**
**
**
** 07/17/97  PAULS     SIR 13720 - Changed The macro assignment for the
**                     Macro "TODO_THREE_MONTH_REVIEW". Changed this
**                     from "Supervisor Case review Todo due" to  "Three
**                     month review Todo due ". This was causing a confusion
**                     because the first Three month todo created by Stage
**                     Progression had the right description.The 3 Month
**                     todos created  after that had the wrong description.
**
**
** 12/03/97  PAULS     SIR 14235 - Added 8 dams to change the Investigation
**                     Start date   and Intake Closed date to the earliest
**                     24HR Contact date. This is done only for APS INV stages.
**                     during an ADD or an UPDATE.
**
** 03/25/98  ZOLLMF    SIR 14444 - Changed DAMs to call in ID_STAGE instead of
**                     calling ID_CASE and CD_STAGE.  The DAMS were overwriting
**                     incorrectly after a case had been merged.
** 08/19/98  PAULS     SIR 14789 - Added a dam cseca9d.pc to send an Alert to
**                     a Pal Worker when a Sub Stgae is closed. This alert is
**                     sent only  if a Pal Stage Exists and if the PC has
**                     taken 3 or more core training courses.
** 03/02/1999 PAULS     SIR 14963 - Added a Contact Type of Initial face to
**                       face  for AFC Investigations. Added a dam clsc97d
**                       to ensure that this contact was made with a Victim.The
**                       date and time of this contact should also prefill onto
**                       the Facility Investigation Window and in the Abuse
**                       Neglect Report.The TCM edit was also removed. Search on
**                       Sir # for comments.
**
**  09/30/2002  KRD     To-Do Arch Enh - Rewrote service to call the
**                      TodoCommonFunction().  Changes included:
**                      (a) Replacing references to CallCCMN43D with
**                          references to CallTodoCommonFunction().
**                      (b) Removing function CallCCMN43D().
**                      (c) Creating function CallTodoCommonFunction().
**                      (d) Creating macros for the To-Do codes.
**                      (e) Commenting out macros for the to-do descriptions.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver mode" allowing supervisors to ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  05/30/03   Srini    SIR# 17882 Defined a new variable ADMIN_REVIEW and
**                      added the strcmp for ADMIN_REVIEW to check against
**                      szCdStage.
**
**  06/09/03   Srini    SIR# 18131 Pass the username to the dam to be logged
**                      as part of audit log.
**
**  07/23/03  JEH       SIR 18978  Use INDICATOR_NO instead of FALSE to
**                      compare pInputMsg->bIndReview
**
**  07/28/03  JEH       SIR 18889/19044 Initialize InvalidateAprvl structure
**                      correctly to handle Approver mode bypass
**
**  07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**                      before the InvalidateAprvl call.
**  2/10/04   gerryc    SIR 14291 - three month review to dos and contacts
**                      are now created again upon saving old ones.  They
**                      are due on the 20th day of the third month from the
**                      date the contact occurred, not the system date.
**  09/13/05  malpans	SIR 23918 - the APS "three-month-review" To-Do is appearing
**						in duplicate on the worker's and supervisor's To-do list and
**						duplicate contact shell is genertaed everytime user clicks
**						save. Modified to check if an empty contact shell is
**						present, do not create a new empty contact shell or To-Do on
**						save.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/



/*SIR 23918*/



public class Csys07s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String TODO_TYPE = "T";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int INITIAL_PAGE = 1;
    /* SIR 1547 - The todo was appearing on 15th. Changed to 20th. */
    public static final int TODO_DAY_DATE = 20;
    public static final int MONTHS_IN_YEAR = 12;
    public static final int TEMP_SIZE_10 = 10;
    
    /**************************************************************************
    ** SIR 1834:  Three Month ToDo increment was only being incremented by 2.
    ** Changed the #define to 3 instead of 2.
    **************************************************************************/
    public static final int TODO_THREE_MONTH_INC = 3;
    public static final int MAX_REG_SUBMITTED_CONTACTS = 99;
    public static final String FACE_TO_FACE = "FTF";
    public static final String APS_COMMUNITY = "APS";
    public static final String NULL_STRING = "";
    public static final String TXT_EVENT_DESC_MONTHLY_STATUS = "Monthly Status";
    //SIR#17882
    public static final String ADMIN_REVIEW = "ARI";
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String AGING_OUT = "AOC";
    
    /* SIR 13618 */
    public static final String REQUEST_FOR_REVIEW = "EREV";
    
    /* SIR 14235 */
    public static final String INV_OPEN_EVENT = "Investigation Stage Opened";
    public static final String INTAKE = "INT";
    public static final String INT_CLOSED_EVENT = "Intake Stage Closed";
    
    /* SIR 14789 */
    public static final String CPS_PROG = "CPS";
    public static final String SVC_CD_CONTACT_TYPE_SUB_CLOS_SUM = "GSCS";
    public static final String PRIMARY_CHILD = "PC";
    public static final String PAL = "PAL";
    public static final String TODO_INFO_41_CODE = "SUB041";
    
    /*
    ** To-Do Arch Enh BEGIN - To-Do codes necessary for calling the
    ** TodoCommonFunction
    */
    public static final String TODO_SUB_MONTHLY_SUMM = "SVC001";
    public static final String TODO_FSU_MONTHLY_SUMM = "SVC002";
    public static final String TODO_FRE_MONTHLY_SUMM = "SVC003";
    public static final String TODO_FPR_MONTHLY_SUMM = "SVC004";
    public static final String TODO_ADO_MONTHLY_SUMM = "SVC005";
    public static final String TODO_PAD_MONTHLY_SUMM = "SVC006";
    public static final String TODO_INV_MONTHLY_STAT = "SVC007";
    public static final String TODO_AOC_MONTHLY_STAT = "SVC008";
    public static final String TODO_SVC_MONTHLY_STAT = "SVC009";
    public static final String TODO_INV_THREE_MONTH = "APS001";
    public static final String TODO_AOC_THREE_MONTH = "SVC011";
    public static final String TODO_SVC_THREE_MONTH = "SVC012";
    
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    /**************************************************************************
    **
    ** Function Name:  CCMN47S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    static CSYS07SI pInputMsg = null;
    CSYS07SO CSYS07S(CSYS07SI csys07si) {
        CSYS07SO csys07so = new CSYS07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/* SIR#1710 */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common function   */
        
        /* SIR 21130 */
        
        
        CCMN06UO pCCMN06UOutputRec = null;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        CSYS21DO pCSYS21DOutputRec = null;/*SIR 23918 */
        
        
        int sFaceToFaceExists = 1;
        int ulInvalidateIdEvent = 0;
        char tmp_cReqFuncCd = (char) (0);
        int diff = 0;/* SIR 14235 */
        int ulIdPalStage2 = 0;
        int counter = 0;
        int ulContactShellCount1 = 0;
        rc = ARC_PRFServiceStartTime_TUX(csys07si.getArchInputStruct());
        
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
        ** SIR 23918 - Allocate memory for dams before calling the dams.
        ** Also, add a memset after allocating memory.
        ********************************************************************/
        
        pCSYS21DOutputRec = new CSYS21DO();
        
        if (SVC_TYPE_CHAR_CLOSED != csys07si.getSzCdContactType()[0]) {
            // 
            // SIR#1710
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(csys07si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(csys07si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(csys07si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(csys07si.getROWCCMN01UIG00().getSzCdTask());
            
            
            //  Call CINT21D
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
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
        }
        
        if (SUCCESS == RetVal) {
            
            if ((WtcHelperConstants.REQ_FUNC_CD_DELETE == csys07si.getArchInputStruct().getCReqFuncCd()) && (0 == csys07si.getSzCdContactType().compareTo(REQUEST_FOR_REVIEW))) {
                rc = CallCSYS19D(csys07si, csys07so, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;
                        
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
            }
            
            if ((0 == csys07si.getROWCCMN01UIG00().getUlIdEvent()) && ((0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_FPR_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_SUB_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_ADO_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_MONTH_STAT)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_PAL_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_THREE_MONTH)))) {
                
                //  Call CCMN87D
                rc = FindNEWContacts(csys07si, csys07so, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        //  Call CSES24D
                        rc = Csys08s.CallCSYS11D(csys07si, csys07so, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    case NO_DATA_FOUND:
                        csys07si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
            }
            
            if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == csys07si.getArchInputStruct().getCReqFuncCd() || ServiceConstants.REQ_FUNC_CD_DELETE == csys07si.getArchInputStruct().getCReqFuncCd()) {
                
                if ((false == csys07si.getArchInputStruct().getUlSysNbrReserved1()) && (0 == csys07si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(SVC_CD_EVENT_STATUS_PENDING))) {
                    
                    //  Set the invalidation event to the Contact Event
                    // passed into the client. Demote it's status to COMPlete.
                    // Event status' for non PENDing Events are set in the
                    // Client.
                    ulInvalidateIdEvent = csys07si.getROWCCMN01UIG00().getUlIdEvent();
                    csys07si.getROWCCMN01UIG00().setSzCdEventStatus(SVC_CD_EVENT_STATUS_COMPLETE);
                }
            }
            
            //  Instead, if there was a PENDing CONCLusion Event found in the
            // retrieval service, we should invalidate this Approval Package.
            // Mode passed in is irrelevent here.
            // First we update the status of the Conclusion Event to COMPlete.
            // ( CallCCMN62D() actually sets the status and calls the DAM. )
            // IMPACT BEGIN - Don't demote events when in "Approver mode"
            // Original code:
            // else if ( pInputMsg->ulIdEvent )
            else if (false == csys07si.getArchInputStruct().getUlSysNbrReserved1() && csys07si.getUlIdEvent().value != 0) {
                
                //  Call CLSS24D
                rc = Ccmn05u.CallCCMN62D(csys07si, csys07so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  Set the Invalidation Event to the Conclusion Event.
                ulInvalidateIdEvent = csys07si.getUlIdEvent().value;
            }
            if (ulInvalidateIdEvent != 0) {
                pInvdInput = new CCMN05UI();
                
                pInvdOutput = new CCMN05UO();
                pInvdInput.setArchInputStruct(csys07si.getArchInputStruct());
                pInvdInput.setUlIdEvent(ulInvalidateIdEvent);
                
                rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (WtcHelperConstants.REQ_FUNC_CD_DELETE == csys07si.getArchInputStruct().getCReqFuncCd()) {
                //mdm 2/14/2003 - rc is used to indicate service failure
                //the rc returned from the previous statement is not an
                //error but the # of minutes different between the 2 datetimes
                rc = CallCSYS17D(csys07si, csys07so, pServiceStatus);
                
                if ((WtcHelperConstants.SQL_SUCCESS != rc) && (NO_DATA_FOUND != rc)) {
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                //Srini D 01/29/03  Added so that it returns success instead of failure
                //set rc value to success
                rc = Ccmn19s.CallCCMN91D(csys07si, csys07so, pServiceStatus);
                
                if ((WtcHelperConstants.SQL_SUCCESS != rc) && (NO_DATA_FOUND != rc)) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            if (0 == csys07si.getSzCdContactMethod().compareTo(FACE_TO_FACE)) {
                
                if ((0 == csys07si.getSzCdStageClassification().compareTo(APS_COMMUNITY)) && (0 != AGING_OUT.compareTo(csys07si.getSzCdStage())) && (0 != ADMIN_REVIEW.compareTo(csys07si.getSzCdStage()))) {
                    
                    //Srini D 01/29/03  Added so that it returns success instead of failure
                    //set rc value to success
                    rc = CallCSYS04D1(csys07si, csys07so, pServiceStatus);
                    switch (rc) {
                            
                            //SIR:17091 Srini: Added the error handling to take care of full table scans.
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                        case NO_DATA_FOUND:
                            sFaceToFaceExists = 0;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
                else if (0 == AGING_OUT.compareTo(csys07si.getSzCdStage())) {
                    sFaceToFaceExists = 1;
                }
            }
            if (WtcHelperConstants.REQ_FUNC_CD_DELETE == csys07si.getArchInputStruct().getCReqFuncCd()) {
                rc = CallCSVC32D(csys07si, csys07so, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            csys07si.getUlIdEvent().value = csys07si.getROWCCMN01UIG00().getUlIdEvent();
            rc = Ccmn25s.CallPostEvent(csys07si.getArchInputStruct() , csys07si.getROWCCMN01UIG00() , csys07si.getUlIdEvent() , pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    pServiceStatus.severity = FND_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
            rc = Ccmn01u.CallCCMN68D(csys07si, csys07so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            if (csys07si.getArchInputStruct().getUlPageSizeNbr() != 0) {
                tmp_cReqFuncCd = csys07si.getArchInputStruct().getCReqFuncCd();
                
                if (csys07si.getArchInputStruct().getCReqFuncCd() != WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                    csys07si.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
            }
            
            if (!(0 != (int) tmp_cReqFuncCd && WtcHelperConstants.REQ_FUNC_CD_DELETE == csys07si.getArchInputStruct().getCReqFuncCd())) {
                rc = CallCSYS07D(csys07si, csys07so, pServiceStatus);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        pServiceStatus.severity = FND_WARNING;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
            }
            
            if (tmp_cReqFuncCd != 0) {
                csys07si.getArchInputStruct().setCReqFuncCd(tmp_cReqFuncCd);
            }
            
            if (WtcHelperConstants.REQ_FUNC_CD_DELETE != csys07si.getArchInputStruct().getCReqFuncCd()) {
                
                if (0 == csys07si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(SVC_CD_EVENT_STATUS_COMPLETE)) {
                    
                    //  Call DAM
                    rc = Cinv12s.CallCINV43D(csys07si, csys07so, pServiceStatus);
                    
                    if ((WtcHelperConstants.SQL_SUCCESS != rc) && (NO_DATA_FOUND != rc)) {
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                if ((0 == csys07si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(SVC_CD_EVENT_STATUS_COMPLETE)) && ((0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_FPR_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_SUB_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_ADO_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_MONTH_STAT)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_PAL_MNTH)) || (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_THREE_MONTH))) && (SVC_FUTURE_TODOS_CREATED != csys07si.getArchInputStruct().getUsPageNbr())) {
                    
                    rc = CallCSYS21D(csys07si, csys07so, pCSYS21DOutputRec, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            ulContactShellCount1 = pCSYS21DOutputRec.getUlContactShellCount();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    if (ulContactShellCount1 != 1 && ulContactShellCount1 == 0) {
                        rc = CreateNEWContacts(csys07si, csys07so, false, false, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                //  SIR# 10609 - changed the following condition for FacetoFace
                // contacts from an independent IF statement to an else if
                // condition so that only one ToDo is created.  Previously,
                // if on the first contact the user selected type Monthly
                // Status and Face to Face type the system created two identical
                // ToDos.
                
                // 
                // Begin SIR 1316: Create ToDo and Contact Shell for first Face to Face
                // Contact that is created for a stage.
                // 
                
                else if (!sFaceToFaceExists) {
                    rc = CreateNEWContacts(csys07si, csys07so, sFaceToFaceExists, true, pServiceStatus);
                }
                
                if (0 == csys07si.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(SVC_CD_EVENT_STATUS_COMPLETE) && (CompareType(csys07si, SVC_CD_CONTACT_TYPE_FPR_MNTH) != 0 || CompareType(csys07si, SVC_CD_CONTACT_TYPE_SUB_MNTH) != 0 || CompareType(csys07si, SVC_CD_CONTACT_TYPE_ADO_MNTH) != 0 || CompareType(csys07si, SVC_CD_CONTACT_TYPE_PAL_MNTH) != 0 || CompareType(csys07si, SVC_CD_CONTACT_PERS_HOME_STUDY_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_QUARTER_VISIT_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_REGULAR_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_CORRECT_ACT_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_DEVELOP_PLAN_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_CLOSING_SUM_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_MONTH_ASSESS_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_REEVALUATION_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_SERIOUS_INC_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_VARIANCE_SUM) != 0 || CompareType(csys07si, SVC_CD_CONTACT_VIOLATION_SUM) != 0)) {
                    rc = Cinv59s.CallCSYS04D(csys07si, csys07so, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                        case TOO_MANY_CONTACTS_IN_MONTHLY:
                            pServiceStatus.severity = FND_ERROR;
                            pServiceStatus.explan_code = rc;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                        case NO_DATA_FOUND:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
            }
            if ((0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_REQUEST_REVIEW)) && csys07si.getBIndReview() == Cint14s.INDICATOR_NO) {
                rc = Cinv59s.CallCLSC16D(csys07si, csys07so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;
                        
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                rc = CallCINVC1D(csys07si, csys07so, pServiceStatus);
                
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
            }
            
            if ((WtcHelperConstants.REQ_FUNC_CD_DELETE == csys07si.getArchInputStruct().getCReqFuncCd()) && (0 == csys07si.getSzCdContactType().compareTo(REQUEST_FOR_REVIEW))) {
                
                if (csys07so.getNbrContact() == 1) {
                    rc = CallCINVB9D1(csys07si, csys07so, pServiceStatus);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                        case NO_DATA_FOUND:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                    
                    //  Call DAM
                    rc = CallCINVC2D(csys07si, csys07so, pServiceStatus);
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                        case NO_DATA_FOUND:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
            }
            
            if ((0 == csys07si.getSzCdStageClassification().compareTo(CAPS_PROG_APS)) && (0 == csys07si.getSzCdStage().compareTo(SVC_CD_STAGE_INV)) && (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_HOURC24))) {
                if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == csys07si.getArchInputStruct().getCReqFuncCd() || ServiceConstants.REQ_FUNC_CD_ADD == csys07si.getArchInputStruct().getCReqFuncCd()) {
                    rc = CallCSYS20D(csys07si, csys07so, pServiceStatus);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                        case NO_DATA_FOUND:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
            }
            
            if ((0 == csys07si.getSzCdStageClassification().compareTo(CPS_PROG)) && (0 == csys07si.getSzCdStage().compareTo(SVC_CD_STAGE_SUB)) && (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_SUB_CLOS_SUM))) {
                rc = CallCSECA9D(csys07si, csys07so, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                    case NO_DATA_FOUND:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                }
                
                if (0 < csys07so.getUlIdPalStage()) {
                    rc = CallCMSC14D(csys07si, csys07so, pServiceStatus);
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    if (true == csys07so.getBIndSendPalFollowup()) {
                        
                        //  Call DAM
                        rc = CallCINV51D(csys07si, csys07so, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        if (0 < csys07so.getUlIdPalWorker()) {
                            
                            rc = SendToDoToPalWrkr(csys07si, csys07so, pServiceStatus);
                        }
                    }
                }
            }
            if ((0 == csys07si.getSzCdStageClassification().compareTo(SVC_CD_PROGRAM_AFC)) && (0 == csys07si.getSzCdStage().compareTo(SVC_CD_STAGE_INV)) && (0 == csys07si.getSzCdContactType().compareTo(SVC_CD_CON_AFC_IFF_E)) && (csys07si.getBIndVictimSelected() == false)) {
                if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == csys07si.getArchInputStruct().getCReqFuncCd() || ServiceConstants.REQ_FUNC_CD_ADD == csys07si.getArchInputStruct().getCReqFuncCd()) {
                    rc = CallCLSC97D(csys07si, csys07so, pServiceStatus, counter);
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                            
                        case Messages.MSG_VICTIM_NOT_SELECTED:
                            pServiceStatus.severity = FND_ERROR;
                            pServiceStatus.explan_code = rc;
                            break;
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                }
            }
        }
        csys07so.setUlIdEvent(csys07si.getUlIdEvent().value);
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(csys07si.getArchInputStruct() , csys07so.getArchOutputStruct());
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
        return csys07so;
    }

    static int CallCSYS07D(CSYS07SI pInputMsg877, CSYS07SO * pOutputMsg818, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CSYS07DI pCSYS07DInputRec = null;
        CSYS07DO pCSYS07DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS07DInputRec = new CSYS07DI();
        
        pCSYS07DOutputRec = new CSYS07DO();
        pCSYS07DInputRec.setUlIdEvent(pInputMsg877.getUlIdEvent().value);
        pCSYS07DInputRec.setUlIdStage(pInputMsg877.getROWCCMN01UIG00().getUlIdStage());
        pCSYS07DInputRec.setUlIdPerson(pInputMsg877.getUlIdPerson());
        if (pInputMsg877.getDtDtMonthlySummBegin().month == 0 || pInputMsg877.getDtDtMonthlySummBegin().day == 0 || pInputMsg877.getDtDtMonthlySummBegin().year == 0) {
            pCSYS07DInputRec.getDtDtMonthlySummBegin().month = DateHelper.NULL_DATE;
            pCSYS07DInputRec.getDtDtMonthlySummBegin().day = DateHelper.NULL_DATE;
            pCSYS07DInputRec.getDtDtMonthlySummBegin().year = DateHelper.NULL_DATE;
        }
        else {
            pCSYS07DInputRec.setDtDtMonthlySummBegin(pInputMsg877.getDtDtMonthlySummBegin());
        }
        if (pInputMsg877.getDtDtMonthlySummEnd().month == 0 || pInputMsg877.getDtDtMonthlySummEnd().day == 0 || pInputMsg877.getDtDtMonthlySummEnd().year == 0) {
            pCSYS07DInputRec.getDtDtMonthlySummEnd().month = DateHelper.NULL_DATE;
            pCSYS07DInputRec.getDtDtMonthlySummEnd().day = DateHelper.NULL_DATE;
            pCSYS07DInputRec.getDtDtMonthlySummEnd().year = DateHelper.NULL_DATE;
        }
        else {
            pCSYS07DInputRec.setDtDtMonthlySummEnd(pInputMsg877.getDtDtMonthlySummEnd());
        }
        pCSYS07DInputRec.setBIndContactAttempted(pInputMsg877.getBIndContactAttempted());
        pCSYS07DInputRec.setDtDTContactOccurred(pInputMsg877.getDtDTContactOccurred());
        pCSYS07DInputRec.setSzCdContactLocation(pInputMsg877.getSzCdContactLocation());
        pCSYS07DInputRec.setSzCdContactMethod(pInputMsg877.getSzCdContactMethod());
        pCSYS07DInputRec.setSzCdContactOthers(pInputMsg877.getSzCdContactOthers());
        pCSYS07DInputRec.setSzCdContactPurpose(pInputMsg877.getSzCdContactPurpose());
        pCSYS07DInputRec.setSzCdContactType(pInputMsg877.getSzCdContactType());
        pCSYS07DInputRec.setTmScrTmCntct(pInputMsg877.getTmScrTmCntct());
        pCSYS07DInputRec.setTsSysTsLastUpdate2(pInputMsg877.getTsSysTsLastUpdate2());
        pCSYS07DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg877.getArchInputStruct().getCReqFuncCd());
        rc = csys07dAUDdam(sqlca, pCSYS07DInputRec, pCSYS07DOutputRec);
        
        /*
        ** Analyze error code
        */
        if (NO_DATA_FOUND == rc) {
            return Messages.MSG_CMN_TMSTAMP_MISMATCH;
        }
        else {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV43D(CSYS07SI pInputMsg878, CSYS07SO * pOutputMsg819, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV43DInputRec = new CINV43DI();
        
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setUlIdEvent(pInputMsg878.getROWCCMN01UIG00().getUlIdEvent());
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
            case NO_DATA_FOUND:
                rc = 0;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCCMN62D(CSYS07SI pInputMsg879, CSYS07SO * pOutputMsg820, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        
        //## BEGIN TUX/XML: Declare XML variables
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN62DInputRec.setUlIdEvent(pInputMsg879.getUlIdEvent().value);
        pCCMN62DInputRec.setSzCdEventStatus(SVC_CD_EVENT_STATUS_COMPLETE);
        
        /*
        ** Call CSEC33D
        */
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        return rc;
    }

    static int CallCSYS04D(CSYS07SI pInputMsg880, CSYS07SO pOutputMsg821, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i454 = 0;
        int j = 0;
        int iInitial_Row = 0;/* Initial row counter for each pass */
        CSYS04DI pCSYS04DInputRec = null;
        CSYS04DO pCSYS04DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS04DInputRec = new CSYS04DI();
        
        pCSYS04DOutputRec = new CSYS04DO();
        
        
        /*
        ** If the todo indicator for the cSysIndSubEnd is false
        **  process todo.
        */
        if (0 == pInputMsg880.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_FPR_MNTH)) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CONTACT_TYPE_FPR_REG);
        }
        
        /*
        ** If CFAD40SI CFAD40SIGOO dtDtAdptSubEnd
        ** not Null, set ToDoFlag[FAD042] ToDoFlag[FAD038]and to true.
        **
        */
        
        if (0 == pInputMsg880.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_SUB_MNTH)) {
            
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CONTACT_TYPE_SUB_REG);
        }
        if (0 == pInputMsg880.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_ADO_MNTH)) {
            
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CONTACT_TYPE_ADO_REG);
        }
        
        
        
        /*
        ** If IdEvent from input msg is not NULL, process CINV43D.  Otherwise
        **  it will not be called.  This DAM completes a ToDo.  A ToDo will never
        **  exist without an IdEvent.
        **
        ** SIR #3933 - "Or event status is PROC," was added to the following if
        ** statement.  To-do's with the event status of PROC should be completed.
        ** This ensures that manually created to-do's are deleted.
        */
        if (0 == pInputMsg880.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_PAL_MNTH_J)) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CONTACT_TYPE_PAL_REG);
        }
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_CORRECT_ACT_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_CORR_ACTION_I);
        }
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_DEVELOP_PLAN_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_DEVELOP_PLAN_I);
        }
        
        /*****************************************************************
        ** END CINV43D ToDo Complete AUD
        ******************************************************************/
        
        
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_CLOSING_SUM_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_FAD_CLOS_SUMM_I);
        }
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_CLOSING_SUM_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_FAD_CLOS_SUMM_I);
        }
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_MONTH_ASSESS_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_MONTH_ASSES_I);
        }
        
        /*
        ** SIR #4213 - Also populate the IndAdptSubProcess Element.  If this is a
        ** new Adoption Subsidy, then set it to 'N', else pass it through.
        */
        
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_REEVALUATION_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_REEVALUATION_I);
        }
        
        /*
        ** If ArchOutputStruct.ulSysNbrValidationMsg = 0 set severity, explan,
        ** and retval to success. else set them to fail.
        */
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_SERIOUS_INC_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_SERIOUS_INC_I);
            // RIOSJA, SIR 22970
        }
        
        /*
        **  If the inputmsg IdEvent is not 0 do not call this dam.
        **  If it is called with the IdEvent from the inputmsg,
        **  It will post another event link with the same IdEvent and
        **  a different id_adpt_sub.  This is not necessary.
        */
        
        /*
        ** SIR #3710 - 3/13/96 - PURCELA - Also need to call this DAM in the
        ** case of a DUMMY EVENT because there will not have been a previous
        ** Adoption Subsidy linked with event.
        */
        
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_VARIANCE_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_VARIANCE_I);
        }
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_VIOLATION_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_VIOLATION_I);
        }
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_PERS_HOME_STUDY_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_PERS_HOME_STUDY_I);
        }
        
        /*****************************************************************
        ** END CAUD97 ADT SUB AUD
        ******************************************************************/
        
        
        
        /*
        ** Call CAUD97D if RetVal is FND_SUCCESS and CFAD40SI
        ** CdMedUpdType is not NULL and CFAD40SI CdMedTransUpdTypE
        ** is not NULL and CFAD40SI CFAD40SIG00 DtAdptSubEnd month
        ** is not current month and CFAD40SI CFAD40SIG00 DtAdptSubEnd
        ** day is not greater than 15
        **
        ** dtDtEventOccurred is used as the current Date because it was set
        **  as this in the save detail function in casv01w and sent through
        **  the input message to the save service.
        */
        
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_QUARTER_VISIT_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_QUARTER_VISIT_I);
        }
        
        
        /* SIR# 4220 - When the Adoption Subsidy Trans Type is
        ** DEN, denial, and the Adoption Subsidy End Month is the
        ** current month and the current day is the 15th or after
        ** the Medicaid Update table should not be updated.
        */
        
        if (CompareType(pInputMsg880, SVC_CD_CONTACT_REGULAR_SUM) != 0) {
            pCSYS04DInputRec.setSzCdContactType(SVC_CD_CON_TYPE_REGULAR_I);
        }
        pCSYS04DInputRec.setSzCdEventStatus(SVC_CD_EVENT_STATUS_COMPLETE);
        pCSYS04DInputRec.setUlIdStage(pInputMsg880.getROWCCMN01UIG00().getUlIdStage());
        pCSYS04DInputRec.setDtScrSearchDateFrom(pInputMsg880.getDtDtMonthlySummBegin());
        pCSYS04DInputRec.setDtScrSearchDateTo(pInputMsg880.getDtDtMonthlySummEnd());
        pOutputMsg821.getArchOutputStruct().setBMoreDataInd(1);
        pOutputMsg821.getArchOutputStruct().setUlRowQty(0);
        j = INITIAL_PAGE;
        
        /*
        ** Loop until all data is retrieved or end of array
        */
        while (pOutputMsg821.getArchOutputStruct().getBMoreDataInd() != 0 && pOutputMsg821.getArchOutputStruct().getUlRowQty() < CSYS07SO._CSYS07SO__EVENTIDSTRUCT_SIZE) {
            pCSYS04DInputRec.getArchInputStruct().setUsPageNbr(j);
            pCSYS04DInputRec.getArchInputStruct().setUlPageSizeNbr(CSYS04DO._CSYS04DO__ROWCSYS04DO_SIZE);
            pCSYS04DInputRec.getArchInputStruct().setSzUserId(pInputMsg880.getArchInputStruct().getSzUserId());
            rc = csys04dQUERYdam(sqlca, pCSYS04DInputRec, pCSYS04DOutputRec);
            if (0 != rc) {
                
                //  Analyze return code
                switch (rc) {
                        
                    case NO_DATA_FOUND:
                        pOutputMsg821.getArchOutputStruct().setBMoreDataInd(0);
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            else {
                //  Populate Output Message
                iInitial_Row = (j - 1) * _CSYS04DO__ROWCSYS04DO_SIZE;
                for (i454 = iInitial_Row;i454 < (iInitial_Row + pCSYS04DOutputRec.getArchOutputStruct().getUlRowQty());++i454) {
                    if (i454 < CSYS07SO._CSYS07SO__EVENTIDSTRUCT_SIZE) {
                        pOutputMsg821.getEventIdStruct_ARRAY().getEventIdStruct(i454).setUlIdEvent(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(i454 - iInitial_Row).getUlIdEvent());
                    }
                }
                pOutputMsg821.getArchOutputStruct().setUlRowQty(i454);
                pOutputMsg821.getArchOutputStruct().setBMoreDataInd(pCSYS04DOutputRec.getArchOutputStruct().getBMoreDataInd());
            }
            j++;
        }
        
        /* END SIR#20301 */
        
        /*
        ** If the input msg idevent = not 0 input it into the Dam
        ** as MedUpdRecord.  Else use the one retrieved from
        ** post event.  It is held in ulPostEventIdEvent.
        **  This was added on 2/7
        */
        if (pOutputMsg821.getArchOutputStruct().getUlRowQty() > MAX_REG_SUBMITTED_CONTACTS) {
            
            
            //  Call CLSS48D
            rc = TOO_MANY_CONTACTS_IN_MONTHLY;
        }
        return rc;
    }

    static int CallCSYS04D1(CSYS07SI pInputMsg881, CSYS07SO * pOutputMsg822, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSYS04DI pCSYS04DInputRec = null;
        CSYS04DO pCSYS04DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS04DInputRec = new CSYS04DI();
        
        pCSYS04DOutputRec = new CSYS04DO();
        pCSYS04DInputRec.setSzCdContactType(SVC_CD_CONTACT_TYPE_MONTH_STAT);
        pCSYS04DInputRec.setSzCdEventStatus(SVC_CD_EVENT_STATUS_NEW);
        pCSYS04DInputRec.setSzCdContactLocation(NULL_STRING);
        pCSYS04DInputRec.setSzCdContactOthers(NULL_STRING);
        pCSYS04DInputRec.setSzCdContactPurpose(NULL_STRING);
        pCSYS04DInputRec.setUlIdStage(pInputMsg881.getROWCCMN01UIG00().getUlIdStage());
        pCSYS04DInputRec.getDtScrSearchDateFrom().day = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getDtScrSearchDateFrom().month = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getDtScrSearchDateFrom().year = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getDtScrSearchDateTo().day = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getDtScrSearchDateTo().month = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getDtScrSearchDateTo().year = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCSYS04DInputRec.getArchInputStruct().setUlPageSizeNbr(CSYS04DO._CSYS04DO__ROWCSYS04DO_SIZE);
        pCSYS04DInputRec.getArchInputStruct().setSzUserId(pInputMsg881.getArchInputStruct().getSzUserId());
        rc = csys04dQUERYdam(sqlca, pCSYS04DInputRec, pCSYS04DOutputRec);
        
        /*
        ** SIR 21973 - Delete the Unrelated person from the system if s/he is
        ** not attached to any other stage by calling the DELETE_INTAKE_PERSON
        ** complex delete procedure
        */
        if (0 != rc) {
            switch (rc) {
                case NO_DATA_FOUND:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        return rc;
    }

    static int FindNEWContacts(CSYS07SI pInputMsg882, CSYS07SO pOutputMsg823, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CSYS04DI pCSYS04DInputRec = null;
        CSYS04DO pCSYS04DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS04DInputRec = new CSYS04DI();
        
        pCSYS04DOutputRec = new CSYS04DO();
        pCSYS04DInputRec.setSzCdContactType(pInputMsg882.getSzCdContactType());
        pCSYS04DInputRec.setSzCdEventStatus(SVC_CD_EVENT_STATUS_NEW);
        pCSYS04DInputRec.setUlIdStage(pInputMsg882.getROWCCMN01UIG00().getUlIdStage());
        pCSYS04DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCSYS04DInputRec.getArchInputStruct().setUlPageSizeNbr(CSYS04DO._CSYS04DO__ROWCSYS04DO_SIZE);
        rc = csys04dQUERYdam(sqlca, pCSYS04DInputRec, pCSYS04DOutputRec);
        
        /* Sir 13720 */
        if (0 != rc) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        pOutputMsg823.getArchOutputStruct().setUlRowQty(pCSYS04DOutputRec.getArchOutputStruct().getUlRowQty());
        pOutputMsg823.getArchOutputStruct().setBMoreDataInd(pCSYS04DOutputRec.getArchOutputStruct().getBMoreDataInd());
        pInputMsg882.getROWCCMN01UIG00().setUlIdEvent(pCSYS04DOutputRec.getROWCSYS04DO_ARRAY().getROWCSYS04DO(0).getUlIdEvent());
        pInputMsg882.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        return rc;
    }

    static int CreateNEWContacts(CSYS07SI pInputMsg883, CSYS07SO * pOutputMsg824, int sFaceToFaceExists, char cMonthlyStatusType, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        CSYS07SI pTempInputMsg = null;
        CSYS07SO pTempOutputMsg = null;
        FndInt3date dtEmptyDate = null;
        Pint ulIdPersonSupervisor = new Pint();
        ulIdPersonSupervisor.value = 0;
        char bSupervisorToDo = 1;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pTempInputMsg = new CSYS07SI();
        
        pTempOutputMsg = new CSYS07SO();
        
        dtEmptyDate.day = DateHelper.NULL_DATE;
        dtEmptyDate.year = DateHelper.NULL_DATE;
        dtEmptyDate.month = DateHelper.NULL_DATE;
        pTempInputMsg = pInputMsg883;
        pTempInputMsg.setSzCdContactLocation(NULL_STRING);
        pTempInputMsg.setSzCdContactMethod(NULL_STRING);
        pTempInputMsg.setSzCdContactOthers(NULL_STRING);
        pTempInputMsg.setSzCdContactPurpose(NULL_STRING);
        pTempInputMsg.setTmScrTmCntct(NULL_STRING);
        
        pTempInputMsg.getDtDtMonthlySummBegin().day = DateHelper.NULL_DATE;
        pTempInputMsg.getDtDtMonthlySummBegin().month = DateHelper.NULL_DATE;
        pTempInputMsg.getDtDtMonthlySummBegin().year = DateHelper.NULL_DATE;
        pTempInputMsg.getDtDtMonthlySummEnd().day = DateHelper.NULL_DATE;
        pTempInputMsg.getDtDtMonthlySummEnd().month = DateHelper.NULL_DATE;
        pTempInputMsg.getDtDtMonthlySummEnd().year = DateHelper.NULL_DATE;
        pTempInputMsg.setBIndContactAttempted(0);
        pTempInputMsg.setTsSysTsLastUpdate2(null);
        
        /*
        ** Check for allocation errors.
        */
        if (cMonthlyStatusType != 0) {
            pTempInputMsg.setSzCdContactType(SVC_CD_CONTACT_TYPE_MONTH_STAT);
            pTempInputMsg.getROWCCMN01UIG00().setSzTxtEventDescr(TXT_EVENT_DESC_MONTHLY_STATUS);
        }
        pTempInputMsg.getROWCCMN01UIG00().setUlIdEvent(0);
        pTempInputMsg.getUlIdEvent().value = 0;
        pTempInputMsg.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pTempInputMsg.setDtDtMonthlySummBegin(dtEmptyDate);
        pTempInputMsg.getROWCCMN01UIG00().setSzCdEventStatus(SVC_CD_EVENT_STATUS_NEW);
        
        pTempInputMsg.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(0);
        rc = Ccmn25s.CallPostEvent(pTempInputMsg.getArchInputStruct() , pTempInputMsg.getROWCCMN01UIG00() , pTempInputMsg.getUlIdEvent() , pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Call CSES14D
        */
        rc = CallTodoCommonFunction(pTempInputMsg, pTempOutputMsg, sFaceToFaceExists, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (0 == pInputMsg883.getSzCdContactType().compareTo(SVC_CD_CONTACT_THREE_MONTH)) {
            
            //  Set rc to ARC_SUCCESS
            rc = Csub12s.CallCCMN60D(pTempInputMsg, pTempOutputMsg, pServiceStatus, ulIdPersonSupervisor);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    if (ulIdPersonSupervisor.value != 0) {
                        pTempInputMsg.setUlIdPerson(ulIdPersonSupervisor.value);
                        rc = CallTodoCommonFunction(pTempInputMsg, pTempOutputMsg, sFaceToFaceExists, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    //  End of CCMNA1D - Unit Smp
                    
                    break;
                    
                case NO_DATA_FOUND:
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
                    break;
            }
        }
        pTempInputMsg.setUlIdPerson(0);
        pTempInputMsg.setDtDTContactOccurred(dtEmptyDate);
        rc = CallCSYS07D(pTempInputMsg, pTempOutputMsg, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        return rc;
    }

    static int CallCSYS21D(CSYS07SI pInputMsg884, CSYS07SO * pOutputMsg825, CSYS21DO pCSYS21DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSYS21DI pCSYS21DInputRec = new CSYS21DI();
        pCSYS21DInputRec.setArchInputStruct(pInputMsg884.getArchInputStruct());
        pCSYS21DInputRec.setUlIdStage(pInputMsg884.getROWCCMN01UIG00().getUlIdStage());
        
        pCSYS21DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCSYS21DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = csys21dQUERYdam(sqlca, pCSYS21DInputRec, pCSYS21DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CSES68D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = SUCCESS;
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCCMN60D(CSYS07SI pInputMsg885, CSYS07SO * pOutputMsg826, Arcxmlerrors.TUX_DECL_STATUSPARMS, Pint ulIdPersonSupervisor) {
        int rc = 0;
        CCMN60DI pCCMN60DInputRec = null;
        CCMN60DO pCCMN60DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN60DInputRec = new CCMN60DI();
        
        pCCMN60DOutputRec = new CCMN60DO();
        pCCMN60DInputRec.setUlIdPerson(pInputMsg885.getUlIdPerson());
        rc = ccmn60dQUERYdam(sqlca, pCCMN60DInputRec, pCCMN60DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  SQL Not Found Case for Dam CSES68D (APG)
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdPersonSupervisor.value = pCCMN60DOutputRec.getUlIdPerson();
                break;
                
                //  Success Case for Dam CSES68D (ASR)
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallPostEvent(CSYS21DI.ArchInputStruct ArchInputStruct10, ROWCCMN01UIG00 ROWCCMN01UIG009, Pint ulIdEvent39, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.SQL_SUCCESS;
        CCMN01UI pInputMsg886 = null;
        CCMN01UO pOutputMsg827 = null;
        pInputMsg886 = new CCMN01UI();
        pOutputMsg827 = new CCMN01UO();
        if ((ArchInputStruct10 == null) || (ROWCCMN01UIG009 == null) || (ulIdEvent39 == null)) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        pInputMsg886.setArchInputStruct(ArchInputStruct10);
        pInputMsg886.setROWCCMN01UIG00(ROWCCMN01UIG009);
        pOutputMsg827.setUlIdEvent(ulIdEvent39.value);
        rc = Ccmn01u.PostEvent(pInputMsg886, pOutputMsg827, pServiceStatus);
        if (ulIdEvent39.value == null) {
            ulIdEvent39.value = pOutputMsg827.getUlIdEvent();
        }
        return rc;
    }

    static int CallCSYS11D(CSYS07SI pInputMsg887, CSYS07SO * pOutputMsg828, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CSYS11DI pCSYS11DInputRec = null;
        CSYS11DO pCSYS11DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS11DInputRec = new CSYS11DI();
        
        pCSYS11DOutputRec = new CSYS11DO();
        pCSYS11DInputRec.setUlIdEvent(pInputMsg887.getROWCCMN01UIG00().getUlIdEvent());
        pCSYS11DInputRec.setUlIdStage(pInputMsg887.getROWCCMN01UIG00().getUlIdStage());
        
        /*
        ** Retrieve stage information
        */
        rc = csys11dQUERYdam(sqlca, pCSYS11DInputRec, pCSYS11DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg887.setTsSysTsLastUpdate2(pCSYS11DOutputRec.getTsSysTsLastUpdate2());
                pInputMsg887.getROWCCMN01UIG00().setTsLastUpdate(pCSYS11DOutputRec.getTsSysTsLastUpdate3());
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                
                break;
        }
        return rc;
    }

    
    static int CallCSYS17D(CSYS07SI pInputMsg888, CSYS07SO * pOutputMsg829, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CSYS17DI pCSYS17DInputRec = null;
        CSYS17DO pCSYS17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS17DInputRec = new CSYS17DI();
        
        pCSYS17DOutputRec = new CSYS17DO();
        pCSYS17DInputRec.setArchInputStruct(pInputMsg888.getArchInputStruct());
        pCSYS17DInputRec.setUlIdEvent(pInputMsg888.getROWCCMN01UIG00().getUlIdEvent());
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = csys17dAUDdam(sqlca, pCSYS17DInputRec, pCSYS17DOutputRec);
        
        if ((WtcHelperConstants.SQL_SUCCESS != rc) && (NO_DATA_FOUND != rc)) {
            
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN91D(CSYS07SI pInputMsg889, CSYS07SO * pOutputMsg830, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMN91DI pCCMN91DInputRec = null;
        CCMN91DO pCCMN91DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN91DInputRec = new CCMN91DI();
        
        pCCMN91DOutputRec = new CCMN91DO();
        pCCMN91DInputRec.setArchInputStruct(pInputMsg889.getArchInputStruct());
        pCCMN91DInputRec.setUlIdEvent(pInputMsg889.getROWCCMN01UIG00().getUlIdEvent());
        rc = ccmn91dAUDdam(sqlca, pCCMN91DInputRec, pCCMN91DOutputRec);
        
        /*
        ** Set Calculated Retention date to maximum date
        */
        if ((WtcHelperConstants.SQL_SUCCESS != rc) && (NO_DATA_FOUND != rc)) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN68D(CSYS07SI pInputMsg890, CSYS07SO * pOutputMsg831, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i455 = 0;
        
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
        
        pCCMN68DInputRec.setUlIdEvent(pInputMsg890.getUlIdEvent().value);
        
        for (i455 = 0;i455 < pInputMsg890.getUlRowQty();++i455) {
            pCCMN68DInputRec.setUlIdPerson(pInputMsg890.getROWCSVC02SIG03_ARRAY().getROWCSVC02SIG03(i455).getUlIdPerson());
            pCCMN68DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg890.getROWCSVC02SIG03_ARRAY().getROWCSVC02SIG03(i455).getSzCdScrDataAction());
            
            pCCMN68DInputRec.setTsLastUpdate(pInputMsg890.getROWCSVC02SIG03_ARRAY().getROWCSVC02SIG03(i455).getTsLastUpdate());
            rc = ccmn68dAUDdam(sqlca, pCCMN68DInputRec, pCCMN68DOutputRec);
            if (rc != 0) {
                
                //  Analyze error code
                switch (rc) {
                        
                    case NO_DATA_FOUND:
                        rc = 0;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                }
            }
            
        }
        return rc;
    }

    static int CompareType(CSYS07SI pInputMsg891, String TypeCategory) {
        String szFound = null;
        String temp = new String();
        
        if (0 != pInputMsg891.getSzCdContactType().compareTo(NULL_STRING)) {
            temp = pInputMsg891.getSzCdContactType();
            szFound = temp.charAt(1);
            
            if (0 == szFound.substring(0, CSYS18DO.CD_CONTACT_TYPE_LEN).compareTo(TypeCategory.substring(0, CSYS18DO.CD_CONTACT_TYPE_LEN))) {
                return true;
            }
        }
        return false;
    }

    static int CallCSVC32D(CSYS07SI pInputMsg892, CSYS07SO * pOutputMsg832, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSVC32DI pCSVC32DInputRec = null;
        CSVC32DO pCSVC32DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC32DInputRec = new CSVC32DI();
        pCSVC32DOutputRec = new CSVC32DO();
        pCSVC32DInputRec.setArchInputStruct(pInputMsg892.getArchInputStruct());
        pCSVC32DInputRec.setUlIdEvent(pInputMsg892.getROWCCMN01UIG00().getUlIdEvent());
        pCSVC32DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        rc = csvc32dAUDdam(sqlca, pCSVC32DInputRec, pCSVC32DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSC16D(CSYS07SI pInputMsg893, CSYS07SO * pOutputMsg833, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CLSC16DI pCLSC16DInputRec = null;
        CLSC16DO pCLSC16DOutputRec = null;
        int i456 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        
        pCLSC16DInputRec = new CLSC16DI();
        pCLSC16DOutputRec = new CLSC16DO();
        pCLSC16DInputRec.setArchInputStruct(pInputMsg893.getArchInputStruct());
        pCLSC16DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSC16DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC16DO._CLSC16DO__ROWCLSC16DO_SIZE);
        pCLSC16DInputRec.setUlIdAllegationStage(pInputMsg893.getROWCCMN01UIG00().getUlIdStage());
        rc = clsc16dQUERYdam(sqlca, pCLSC16DInputRec, pCLSC16DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  SIR 13618 CINVB9D inserts the original facility investigation
                // information into the facil_alleg_prior_review table.
                for (i456 = 0;i456 < pCLSC16DOutputRec.getArchOutputStruct().getUlRowQty();i456++) {
                    rc = CallCINVB9D(pInputMsg893, pCLSC16DOutputRec, pServiceStatus, i456);
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVB9D(CSYS07SI pInputMsg894, CLSC16DO pCLSC16DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS, int i457) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVB9DI pCINVB9DInputRec = null;
        CINVB9DO pCINVB9DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB9DInputRec = new CINVB9DI();
        pCINVB9DOutputRec = new CINVB9DO();
        pCINVB9DInputRec.setArchInputStruct(pInputMsg894.getArchInputStruct());
        pCINVB9DInputRec.setUlIdAllegation(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getUlIdAllegation());
        pCINVB9DInputRec.setUlIdReviewStage(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getUlIdAllegationStage());
        pCINVB9DInputRec.setUlIdReviewVictim(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getUlIdVictim());
        pCINVB9DInputRec.setUlIdReviewAllegedPerp(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getUlIdAllegedPerpetrator());
        pCINVB9DInputRec.setCdReviewAllegDisp(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getCdAllegDisposition());
        pCINVB9DInputRec.setCdReviewAllegType(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getSzCdAllegType());
        pCINVB9DInputRec.setCdReviewAllegDispSupr(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getSzCdFacilAllegDispSupr());
        pCINVB9DInputRec.setCdReviewAllegClss(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getSzFacilAllegInvClass());
        pCINVB9DInputRec.setCdReviewAllegClssSupr(pCLSC16DOutputRec.getROWCLSC16DO_ARRAY().getROWCLSC16DO(i457).getSzCdFacilAllegClssSupr());
        pCINVB9DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        rc = cinvb9dAUDdam(sqlca, pCINVB9DInputRec, pCINVB9DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call CINT21D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVC1D(CSYS07SI pInputMsg895, CSYS07SO * pOutputMsg834, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVC1DI pCINVC1DInputRec = null;
        CINVC1DO pCINVC1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC1DInputRec = new CINVC1DI();
        pCINVC1DOutputRec = new CINVC1DO();
        pCINVC1DInputRec.setArchInputStruct(pInputMsg895.getArchInputStruct());
        pCINVC1DInputRec.setUlIdStage(pInputMsg895.getROWCCMN01UIG00().getUlIdStage());
        
        /*
        ** Call CSEC58D
        */
        rc = cinvc1dQUERYdam(sqlca, pCINVC1DInputRec, pCINVC1DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVB9D1(CSYS07SI pInputMsg896, CSYS07SO * pOutputMsg835, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVB9DI pCINVB9DInputRec = null;
        CINVB9DO pCINVB9DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB9DInputRec = new CINVB9DI();
        pCINVB9DOutputRec = new CINVB9DO();
        pCINVB9DInputRec.setArchInputStruct(pInputMsg896.getArchInputStruct());
        pCINVB9DInputRec.setUlIdReviewStage(pInputMsg896.getROWCCMN01UIG00().getUlIdStage());
        pCINVB9DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        /********** Start performance timer for Data Access Module ****************/
        rc = cinvb9dAUDdam(sqlca, pCINVB9DInputRec, pCINVB9DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                // 
                // Call DAM
                // 
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSYS19D(CSYS07SI pInputMsg897, CSYS07SO pOutputMsg836, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSYS19DI pCSYS19DInputRec = null;
        CSYS19DO pCSYS19DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS19DInputRec = new CSYS19DI();
        
        pCSYS19DOutputRec = new CSYS19DO();
        pOutputMsg836.getArchOutputStruct().setUlRowQty(0);
        pCSYS19DInputRec.setArchInputStruct(pInputMsg897.getArchInputStruct());
        pCSYS19DInputRec.setUlIdStage(pInputMsg897.getROWCCMN01UIG00().getUlIdStage());
        rc = csys19dQUERYdam(sqlca, pCSYS19DInputRec, pCSYS19DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg836.setNbrContact(pCSYS19DOutputRec.getNbrContact());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        /**************************************************************
        **  END CCMN01U Post Event
        ***************************************************************/
        
        
        /*
        ** Determine ToDo's needed
        **
        ** If Retval is FND_SUCCESS
        */
        
        
        return rc;
    }

    static int CallCINVC2D(CSYS07SI pInputMsg898, CSYS07SO * pOutputMsg837, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVC2DI pCINVC2DInputRec = null;
        CINVC2DO pCINVC2DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC2DInputRec = new CINVC2DI();
        pCINVC2DOutputRec = new CINVC2DO();
        pCINVC2DInputRec.setArchInputStruct(pInputMsg898.getArchInputStruct());
        pCINVC2DInputRec.setUlIdStage(pInputMsg898.getROWCCMN01UIG00().getUlIdStage());
        pCINVC2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = cinvc2dAUDdam(sqlca, pCINVC2DInputRec, pCINVC2DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV44D(CSYS07SI pInputMsg899, CSYS07SO pOutputMsg838, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINV44DI pCINV44DInputRec = null;
        CINV44DO pCINV44DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV44DInputRec = new CINV44DI();
        
        pCINV44DOutputRec = new CINV44DO();
        pCINV44DInputRec.setArchInputStruct(pInputMsg899.getArchInputStruct());
        
        //## BEGIN TUX/XML: Declare XML variables
        pCINV44DInputRec.setUlIdStage(pInputMsg899.getROWCCMN01UIG00().getUlIdStage());
        
        
        /*
        ** CCMN45D retrieves event information
        */
        
        /*
        ** Start Performance Timer
        */
        rc = cinv44dQUERYdam(sqlca, pCINV44DInputRec, pCINV44DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                
                //  Initialize Service Status Fields
                
                
                
                //  Perform Main Processing
                
                
                //  Set CSUB14SO WCD DtSystemDate to current date
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        pOutputMsg838.setDtDtInvStart(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstBegun());
        return rc;
    }

    static int CallCINVC3D(CSYS07SI pInputMsg900, CSYS07SO pOutputMsg839, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVC3DI pCINVC3DInputRec = null;
        CINVC3DO pCINVC3DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC3DInputRec = new CINVC3DI();
        pCINVC3DOutputRec = new CINVC3DO();
        
        pCINVC3DInputRec.setArchInputStruct(pInputMsg900.getArchInputStruct());
        pCINVC3DInputRec.setIdApsStage(pInputMsg900.getROWCCMN01UIG00().getUlIdStage());
        pCINVC3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINVC3DInputRec.setDtDtApsInvstBegun(pOutputMsg839.getDtDTContactOccurred());
        rc = cinvc3dAUDdam(sqlca, pCINVC3DInputRec, pCINVC3DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                // Populate Input Structure for DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;// break for success of cinv51d (VP)
            case NO_DATA_FOUND:
                break;// break for success of CCMN44
                //  END SIR 13532
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVC4D(CSYS07SI pInputMsg901, CSYS07SO pOutputMsg840, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVC4DI pCINVC4DInputRec = null;
        CINVC4DO pCINVC4DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC4DInputRec = new CINVC4DI();
        
        pCINVC4DOutputRec = new CINVC4DO();
        pCINVC4DInputRec.setArchInputStruct(pInputMsg901.getArchInputStruct());
        pCINVC4DInputRec.setUlIdStage(pInputMsg901.getROWCCMN01UIG00().getUlIdStage());
        pCINVC4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINVC4DInputRec.setDtDtStageStart(pOutputMsg840.getDtDTContactOccurred());
        rc = cinvc4dAUDdam(sqlca, pCINVC4DInputRec, pCINVC4DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVC5D(CSYS07SI pInputMsg902, CSYS07SO pOutputMsg841, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVC5DI pCINVC5DInputRec = null;
        CINVC5DO pCINVC5DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC5DInputRec = new CINVC5DI();
        pCINVC5DOutputRec = new CINVC5DO();
        pCINVC5DInputRec.setArchInputStruct(pInputMsg902.getArchInputStruct());
        pCINVC5DInputRec.setUlIdStage(pInputMsg902.getROWCCMN01UIG00().getUlIdStage());
        pCINVC5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINVC5DInputRec.setDtDtStageClose(pOutputMsg841.getDtDTContactOccurred());
        
        /*
        ** Call CSES26D
        */
        rc = cinvc5dAUDdam(sqlca, pCINVC5DInputRec, pCINVC5DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                //  Populate Output Message
                // pCINVB1DOutputRec will be returned to the service, so there
                // is no need to copy the DAM output to the service output.
                // Same goes for the DAM output architecture header.
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallACINVC6D(CSYS07SI pInputMsg903, CSYS07SO pOutputMsg842, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVC6DI pCINVC6DInputRec = null;
        CINVC6DO pCINVC6DOutputRec = null;
        
        
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC6DInputRec = new CINVC6DI();
        pCINVC6DOutputRec = new CINVC6DO();
        pCINVC6DInputRec.setArchInputStruct(pInputMsg903.getArchInputStruct());
        pCINVC6DInputRec.setIdEventStage(pInputMsg903.getROWCCMN01UIG00().getUlIdStage());
        pCINVC6DInputRec.setTxt_Event_Descr(INV_OPEN_EVENT);
        pCINVC6DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINVC6DInputRec.setDtDtEventOccurred(pOutputMsg842.getDtDTContactOccurred());
        rc = cinvc6dAUDdam(sqlca, pCINVC6DInputRec, pCINVC6DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVC9D(CSYS07SI pInputMsg904, CSYS07SO pOutputMsg843, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINVC9DI pCINVC9DInputRec = null;
        CINVC9DO pCINVC9DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC9DInputRec = new CINVC9DI();
        
        pCINVC9DOutputRec = new CINVC9DO();
        pCINVC9DInputRec.setArchInputStruct(pInputMsg904.getArchInputStruct());
        pCINVC9DInputRec.setIdEventStage(pInputMsg904.getROWCCMN01UIG00().getUlIdStage());
        pCINVC9DInputRec.setSzTxtEventDescr(INT_CLOSED_EVENT);
        pCINVC9DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCINVC9DInputRec.setDtDtEventOccurred(pOutputMsg843.getDtDTContactOccurred());
        rc = cinvc9dAUDdam(sqlca, pCINVC9DInputRec, pCINVC9DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CSEC57D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVC7D(CSYS07SI pInputMsg905, CSYS07SO * pOutputMsg844, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINVC7DI pCINVC7DInputRec = null;
        CINVC7DO pCINVC7DOutputRec = null;
        
        
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC7DInputRec = new CINVC7DI();
        pCINVC7DOutputRec = new CINVC7DO();
        pCINVC7DInputRec.setArchInputStruct(pInputMsg905.getArchInputStruct());
        pCINVC7DInputRec.setUlIdCase(pInputMsg905.getUlIdCase());
        pCINVC7DInputRec.setSzCdStage(INTAKE);
        /*
        ** Retrieve the Risk Assessment Finding and Recomended Action (if
        ** any) form the RISK ASSESSMENT table using the ID STAGE passed
        ** as input to the service
        */
        rc = cinvc7dAUDdam(sqlca, pCINVC7DInputRec, pCINVC7DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //SIR 18138: Added the userid to be passed to the dam.
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                break;
                
            case NO_DATA_FOUND:
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSYS20D(CSYS07SI pInputMsg906, CSYS07SO pOutputMsg845, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int rc1 = 0;
        int diff = 0;
        int days = 0;
        
        CSYS20DI pCSYS20DInputRec = null;
        CSYS20DO pCSYS20DOutputRec = null;
        
        
        /* Allocate memory for Input and Output Structures */
        pCSYS20DInputRec = new CSYS20DI();
        
        pCSYS20DOutputRec = new CSYS20DO();
        pCSYS20DInputRec.setArchInputStruct(pInputMsg906.getArchInputStruct());
        pCSYS20DInputRec.setUlIdStage(pInputMsg906.getROWCCMN01UIG00().getUlIdStage());
        pCSYS20DInputRec.setContactType(pInputMsg906.getSzCdContactType());
        
        /*
        ** Call CMSC50D
        */
        rc = csys20dQUERYdam(sqlca, pCSYS20DInputRec, pCSYS20DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  Place the "et al" at the end of the case name if there is enough room
                // to do so. The case name must be 19 characters or less (including the
                // comma) for there to be enough room.
                if (DateHelper.NULL_DATE != pCSYS20DOutputRec.getDtDTContactOccurred().year) {
                    pOutputMsg845.setDtDTContactOccurred(pCSYS20DOutputRec.getDtDTContactOccurred());
                    
                    
                    // Call DAM to retrieve the Investigation Start Date
                    rc1 = Cinv19s.CallCINV44D(pInputMsg906, pOutputMsg845, pServiceStatus);
                    switch (rc1) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                    }
                    
                    
                    //  Compare the Investigation Start Date With The Date
                    // returned from the Dam.If the date returned from
                    // this dam("Earliest 24H Contact date" )
                    // is earlier than the Inv. Start Date, then
                    // reset the Inv Start Dt to the 24H Contact DT.
                    
                    diff = ARC_UTLCompareDateAndTime((FndInt3date) & pOutputMsg845.getDtDtInvStart() , 0, (FndInt3date) & pOutputMsg845.getDtDTContactOccurred() , 0);
                    days = (diff / Arcutls.ARC_UTL_MINUTES_IN_DAY);
                    
                    //  Place the "et al" at the end of the case name if there is enough room
                    // to do so. The case name must be 19 characters or less (including the
                    // comma) for there to be enough room.
                    if (days > 0) {
                        
                        rc = CallCINVC3D(pInputMsg906, pOutputMsg845, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                        }
                        rc = CallCINVC4D(pInputMsg906, pOutputMsg845, pServiceStatus);
                        
                        // Analyze error code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                        }
                        rc = CallCINVC5D(pInputMsg906, pOutputMsg845, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                        }
                        
                        //  Call CLSC64D
                        rc = CallACINVC6D(pInputMsg906, pOutputMsg845, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                        }
                        rc = CallCINVC9D(pInputMsg906, pOutputMsg845, pServiceStatus);
                        
                        //  Analyze error code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                        }
                        rc = CallCINVC7D(pInputMsg906, pOutputMsg845, pServiceStatus);
                        
                        //  Analyze error code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                        }
                    }
                }
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSECA9D(CSYS07SI pInputMsg907, CSYS07SO pOutputMsg846, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSECA9DI pCSECA9DInputRec = null;
        CSECA9DO pCSECA9DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECA9DInputRec = new CSECA9DI();
        
        
        pCSECA9DOutputRec = new CSECA9DO();
        pCSECA9DInputRec.setArchInputStruct(pInputMsg907.getArchInputStruct());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCSECA9DInputRec.setUlIdStage(pInputMsg907.getROWCCMN01UIG00().getUlIdStage());
        pCSECA9DInputRec.setUlIdCase(pInputMsg907.getUlIdCase());
        pCSECA9DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
        pCSECA9DInputRec.setSzCdStage(PAL);
        
        /* Get all the open stages in the case */
        rc = cseca9dQUERYdam(sqlca, pCSECA9DInputRec, pCSECA9DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg846.setUlIdPalStage(pCSECA9DOutputRec.getUlIdStage());
                pOutputMsg846.setUlIdPlcmtChild(pCSECA9DOutputRec.getUlIdPerson());
                
                //  Call DAM to retrieve all Service Authorization events for a
                // particular IdEvent
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                //  for the Service Auth event, search the SVC_AUTH_EVENT_LINK
                // table to get the corresponding Service Auth Id.
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                
                // 
                // Service Macro Definitions
                // 
                
                // 
                // Function Prototypes
                // 
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCMSC14D(CSYS07SI pInputMsg908, CSYS07SO pOutputMsg847, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CMSC14DI pCMSC14DInputRec = null;
        CMSC14DO pCMSC14DOutputRec = null;
        
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCMSC14DInputRec = new CMSC14DI();
        
        pCMSC14DOutputRec = new CMSC14DO();
        
        pCMSC14DInputRec.setArchInputStruct(pInputMsg908.getArchInputStruct());
        pCMSC14DInputRec.setUlIdStage(pOutputMsg847.getUlIdPalStage());
        pCMSC14DInputRec.setUlIdPerson(pOutputMsg847.getUlIdPlcmtChild());
        rc = cmsc14dQUERYdam(sqlca, pCMSC14DInputRec, pCMSC14DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg847.setBIndSendPalFollowup(pCMSC14DOutputRec.getUlSysNbrValidationMsg());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        /* end CSES08D */
        
        /*********************************************************************
        *  Prepare output message to be returned and return
        **********************************************************************/
        
        return rc;
    }

    static int CallCINV51D(CSYS07SI pInputMsg909, CSYS07SO pOutputMsg848, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV51DI pCINV51DInputRec = null;
        CINV51DO pCINV51DOutputRec = null;
        
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINV51DInputRec = new CINV51DI();
        
        pCINV51DOutputRec = new CINV51DO();
        pCINV51DInputRec.setArchInputStruct(pInputMsg909.getArchInputStruct());
        pCINV51DInputRec.setUlIdStage(pOutputMsg848.getUlIdPalStage());
        pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg848.setUlIdPalWorker(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        return rc;
    }

    static int SendToDoToPalWrkr(CSYS07SI pInputMsg910, CSYS07SO pOutputMsg849, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        CSUB40UI pTodoCommonInput = null;
        CSUB40UO pTodoCommonOutput = null;
        int rc = 0;
        FndInt3date CurrentDate = null;
        
        /*
        ** Call CCMN44D
        */
        rc = ARC_UTLGetDateAndTime(CurrentDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        pTodoCommonInput = new CSUB40UI();
        
        pTodoCommonOutput = new CSUB40UO();
        
        pTodoCommonInput.setArchInputStruct(pInputMsg910.getArchInputStruct());
        
        //## BEGIN TUX/XML: Declare XML variables 
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(0);
        pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(CurrentDate);
        pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_41_CODE);
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pOutputMsg849.getUlIdPalWorker());
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pOutputMsg849.getUlIdPalStage());
        
        /*
        ** Call CINV51D
        */
        rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSC97D(CSYS07SI pInputMsg911, CSYS07SO pOutputMsg850, Arcxmlerrors.TUX_DECL_STATUSPARMS, int counter) {
        int rc = 0;/* Return code */
        int i458 = 0;
        /*
        ** Declare local variables
        */
        CLSC97DI pCLSC97DInputRec = null;
        CLSC97DO pCLSC97DOutputRec = null;
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC97DInputRec = new CLSC97DI();
        
        pCLSC97DOutputRec = new CLSC97DO();
        pCLSC97DInputRec.setArchInputStruct(pInputMsg911.getArchInputStruct());
        
        
        
        for (i458 = 0;i458 < pInputMsg911.getUlRowSelected();i458++) {
            pCLSC97DInputRec.setUlIdAllegationStage(pInputMsg911.getROWCCMN01UIG00().getUlIdStage());
            pCLSC97DInputRec.setUlIdPerson(pInputMsg911.getROWCLSC97DIG00_ARRAY().getROWCLSC97DIG00(i458).getUlIdPerson());
            rc = clsc97dQUERYdam(sqlca, pCLSC97DInputRec, pCLSC97DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    pOutputMsg850.getBIndVictimRole()[i458] = pCLSC97DOutputRec.getBIndVictimRole();
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    pOutputMsg850.getBIndVictimRole()[i458] = pCLSC97DOutputRec.getBIndVictimRole();
                    
                    
                    //  Call CINV43D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        pOutputMsg850.setBIndSendEdit(true);
        for (i458 = 0;i458 < pInputMsg911.getUlRowSelected();i458++) {
            if (pOutputMsg850.getBIndVictimRole()[i458] == true) {
                pOutputMsg850.setBIndSendEdit(false);
                rc = WtcHelperConstants.ARC_SUCCESS;
            }
        }
        
        counter = i458;
        if (pOutputMsg850.getBIndSendEdit() == true) {
            rc = Messages.MSG_VICTIM_NOT_SELECTED;
        }
        return rc;
    }

    
    static int CallTodoCommonFunction(CSYS07SI pInputMsg912, CSYS07SO * pOutputMsg851, int sFaceToFaceExists, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int sc = 0;
        CSUB40UI pTodoCommonInput = null;
        CSUB40UO pTodoCommonOutput = null;
        FndInt3date dtEmptyDate = null;
        FndInt3date dtTempDate = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pTodoCommonInput = new CSUB40UI();
        
        pTodoCommonOutput = new CSUB40UO();
        
        dtEmptyDate.day = DateHelper.NULL_DATE;
        dtEmptyDate.year = DateHelper.NULL_DATE;
        dtEmptyDate.month = DateHelper.NULL_DATE;
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        /* 01/22/2003 DWW: Added for error handling */
        if (!sFaceToFaceExists) {
            dtTempDate = pInputMsg912.getDtDTContactOccurred();
        }
        else {
            rc = ARC_UTLGetDateAndTime(dtTempDate, 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Set the date to the middle of the target month.
        */
        dtTempDate.day = TODO_DAY_DATE;
        /* 02/10/2003 Srini: Added to take care of FND_FAIL case. */
        if (0 == SVC_CD_TASK_CONTACT_SUB.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_SUB_MONTHLY_SUMM);
        }
        
        else if (0 == SVC_CD_TASK_CONTACT_FSC.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_FSU_MONTHLY_SUMM);
        }
        
        else if (0 == SVC_CD_TASK_CONTACT_FMR.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_FRE_MONTHLY_SUMM);
        }
        
        else if (0 == SVC_CD_TASK_CONTACT_FPR.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_FPR_MONTHLY_SUMM);
        }
        
        else if (0 == SVC_CD_TASK_CONTACT_ADO.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_ADO_MONTHLY_SUMM);
        }
        
        else if (0 == SVC_CD_TASK_CONTACT_PAD.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_PAD_MONTHLY_SUMM);
        }
        
        else if (0 == SVC_CD_TASK_CONTACT_APS_INV.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            //## END TUX/XML: Turn the XML buffer into an input message struct 
            
            
            
            if (0 == pInputMsg912.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_MONTH_STAT)) {
                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INV_MONTHLY_STAT);
            }
            else {
                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INV_THREE_MONTH);
            }
        }
        
        else if (0 == SVC_CD_TASK_CONTACT_AOC.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            
            //  SIR 2427: Only call ccmn19d.pc, if the stage is not I&R or
            // SPC.
            if (0 == pInputMsg912.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_MONTH_STAT)) {
                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_AOC_MONTHLY_STAT);
            }
        }
        //else
        //{
        
        //    COPYSZ(pTodoCommonInput->CSUB40UIG00.szSysCdTodoCf,
        //           TODO_AOC_THREE_MONTH);
        //} /* end else (three month) */
        
        else if (0 == Csub12s.SVC_CD_TASK_CONTACT_APS.compareTo(pInputMsg912.getROWCCMN01UIG00().getSzCdTask())) {
            
            // 
            // SIR 2657:  Added DAM CINT07D to Retrieve CD_INCMG_STATUS
            // from the Incoming Detail table.  If the STATUS is MFD 
            // (Marked for Deletion), it is OK not to find a primary 
            // worker and to ignore this SQL not found error.
            // 
            if (0 == pInputMsg912.getSzCdContactType().compareTo(SVC_CD_CONTACT_TYPE_MONTH_STAT)) {
                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_SVC_MONTHLY_STAT);
            }
            else if (0 != "GUA".compareTo(pInputMsg912.getSzCdStageType())) {
                pTodoCommonInput.getCSUB40UIG00().setSzSysCdTodoCf(TODO_SVC_THREE_MONTH);
            }
        }
        
        else {
            
            //  Call CINV51D
            rc = Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
            return rc;
        }
        pTodoCommonInput.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(dtTempDate);
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfStage(pInputMsg912.getROWCCMN01UIG00().getUlIdStage());
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfEvent(pInputMsg912.getUlIdEvent().value);
        
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(0);
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pInputMsg912.getUlIdPerson());
        pTodoCommonInput.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pInputMsg912.getUlIdPerson());
        rc = Csub40u.TodoCommonFunction(pTodoCommonInput, pTodoCommonOutput, pServiceStatus);
        switch (rc) {
                // 
                // (END): Retrieve DAM: ccmn44d     
                // Get NmPersonFull given IdPerson
                // 
                
                
                //  CASE SQL_NOT_FOUND for CINV51D (VP)
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                //  Do nothing, the output message just returns success or
                // failure.
                break;
        }
        return rc;
    }

}
