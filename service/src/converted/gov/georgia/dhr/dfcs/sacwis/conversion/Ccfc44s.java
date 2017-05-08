package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES65DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES65DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:   CCFC44S.src
**
** Service Name:  CCFC44S
**
** Description:   This service performs the steps necessary to save the 
**                information on the Admin Review & Appeal window as well 
**                as update the Admin Review event status and send any 
**                necessary ToDos. If the Admin Review stage is being 
**                closed, the service manually closes the stage rather 
**                than calling the CloseOpenStage common function.
**
**                The service first calls the CheckStageEventStatus common 
**                function (CCMN06U) to ensre that the Admin Review event 
**                and stage have not been modified since the window was 
**                opened.  If the check is successful, the current row 
**                from the ADMIN_REVIEW table is retrieved (CSES65D), the 
**                new data from the window is saved (CAUDA3D) and the 
**                Postevent common function (CCMN01U) is called to update 
**                the event status. 
**
**                If the Admin Review stage is being closed (i.e., the status
**                of the review is set to "Approved"), additional 
**                processing is necessary since the service manually closes 
**                the stage rather than calling the CloseOpenStage common 
**                function.  (SIR 3615 : Changed to call CCMN02U CloseOPenStage
**                common function)
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/16/95
** 
** Programmer:    ODONNERJ 
**
** Archive Information: $Revision:   1.5  $
**                      $Date:   12 May 1997 10:25:14  $
**                      $Modtime:   09 May 1997 08:54:28  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  3/7/96   ODONNERJ  SIR 3615: 1) The following code needs to be deleted from 
**                      the function: CAll to DAM CCMND4D to close the stage, call 
**                      to DAM CCMNG2D to find the primary worker for the 
**                      Admin Review stage being closed, call to DAM CCMND3D 
**                      to change the worker's role to historical primary, 
**                      second call to DAM CCMND3D to delete all other workers
**                      from the stage, call to DAM CSEC02D to retrieve Case 
**                      record data,  call to CMSC44D to find out the number 
**                      of open stages for the case, calls to CMSC18D and 
**                      CMSC30D to close the case and the situation, call to 
**                      CINV43D to complete to-do's.
**                      2) Replace all of the above with a call to CCMN02U.SRC 
**                      populating its input parameters as follows:                
**                          CD_STAGE = will be either ARI or ARF
**                          CD_STAGE_PROGRAM = will either be APS or CPS
**                          CD_STAGE_REASON_CLOSED= same as the one you are 
**                                                  using now
**                          ID_STAGE = of the Admin Review stage
**                          ID_PERSON= of the person closing the Admin review
**                      3) After coming back from the CloseStageCase function 
**                      AND if thefunction returns with no erros, call the 
**                      logic to transfer the Allegations; otherwise you must 
**                      provide error handling. You must be able to handle the 
**                      error message that must be displayed in the client 
**                      side if the Admin Review stage was already closed when 
**                      the user was trying to close it.
**  3/18/96  ODONNERJ   SIR#4037:Use the EventType from InputMsg as the 
**                      CdStage for the call to CCMN02U.
** 04/15/96  ODONNERJ   SIR# 3853: Moved Save ToDo call to the proper place, 
**                      not the place where detail designed had it. Also 
**                      changed the input population to the todo service call
**                      to work properly.
**
**  04/28/96 ODONNERJ   SIR# 20636: This dam will check always check for HP
**                      It has been previously hard-coded into the DAM. We
**                      need to pass into the DAM 'PR' so that this will work
**                      for those few cases where we are doing an Admin Review on
**                      FAD open stages. We used to copy in 
**                      PRIMARY_ROLE_STAGE_CLOSED.
**  
**  05/14/96 NEGRETCI   SIR# 21112 Replace the CCFC44SIG00.ulIdPersonRequestor 
**                      with ulIdPerson in the CloseStageCase function. 
**                      A closed Admin Review Stage Event was populating 
**                      the stage name, not the caseworker name.
**  05/21/96 ODONNERJ   SIR# 21322 - New codes add to the CARVWRES table
**          cause problems for the Todo's.  When the code is
**          Findings_Reversed '060' map it to '020' PRS_Postion
**          Modified.
**  05/31/96  ODONNERJ  SIR# 21526 - Adding two new Dams.  The first will retrieve
**                      a full row from stage_person_link for the INV stage
**                      for the id_person of the Requestor of the Admin Review
**                      (Dam CINV39D).  Next, CINV39D will be called a second 
**                      time for the ARI row for the same person.  Finally,
**                      CINVA6D will be called to update the ARI row in Stage
**                      Person Link with the new role from CINV39D(First Call)
**                      and the DtLastUpdate for the ARI row from the Second
**                      Call to CINV39D.  This functionality only occurs upon
**                      Approval of the Admin Review.
**  06/06/96  ODONNERJ  SIR# 21585 - If ARF then do not execute the code 
**                      from SIR# 21526.
**  06/26/96  ODONNERJ  SIR# 21705 - Only continue processing after SIR 21526
**                      if RetVal is FND_SUCCESS.
**  04/14/97  DURANG    SIR# 13618 - MHMR Enhancement. Added Review
**                      requested by and Requester name to CAUDA3D input
**                      message. This dam saves the data from the  
**                      Admin Review & Appeal window.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**	07/21/03   Srini    SIR 18975 - Added the error handling by setting the rc value
**						to FND_FAIL so that it returns the error.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc44s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    /**************************************************************************
    ** Constants
    ***************************************************************************/
    
    
    public static final String AR_STATUS_APPROVED = "040";
    public static final String RESULT_POSITION_MODIFIED = "020";
    public static final String TODO_TEXT_CFC014_START = "ARV Decision in ";
    public static final String TODO_TEXT_CFC014_END = " is due ";
    public static final String FORWARD_SLASH = "/";
    public static final String PERIOD = ".";
    public static final String TODO_TEXT_CFC015_START = "ARV Review for ";
    public static final String TODO_TEXT_CFC015_MIDDLE = " for ";
    public static final String TODO_TEXT_CFC015_END = " near.";
    public static final String TODO_TEXT_CFC013_START = "Findings for ";
    public static final String TODO_TEXT_CFC013_MIDDLE = " in ";
    public static final String TODO_TEXT_CFC013_END = " case reversed.";
    public static final String ROLE_PRINCIPAL = "PR";
    public static final int INITIAL_PAGE = 1;
    public static final String STAGE_CD_INV = "INV";
    public static final String TODO_CFC013 = "CFC013";
    public static final String TODO_CFC014 = "CFC014";
    public static final String TODO_CFC015 = "CFC015";
    
    /*
    ** SIR 21322 - Add #define for FINDINGS_REVERSED to enable Todo
    */
    public static final String FINDINGS_REVERSED = "060";
    
    /*
    ** SIR 21585 - Add ARF
    */
    public static final String ADMIN_REVIEW_FAD = "ARF";
    CCFC44SO CCFC44S(CCFC44SI ccfc44si) {
        CCFC44SO ccfc44so = new CCFC44SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        
        
        /*
        ** Declare local variables 
        */
        /* Initiliaze the date and chnge local variables that will be passed to the
        ** ARC_UTLAddToDate function.
        */
        FndInt3date dtSubtract = new FndInt3date( - 7, 0, 0);
        
        /*
        ** Used to sprintf date todo due from so it can be concatenated 
        ** to Todo message
        */
        String Date_Todo_Due_From_String = new String();
        
        //##  short rc = FND_SUCCESS;
        
        CCMN19DI pCCMN19DInputRec = null;
        CCMN19DO pCCMN19DOutputRec = null;
        
        CCMN60DI pCCMN60DInputRec = null;
        CCMN60DO pCCMN60DOutputRec = null;
        
        CCMNG2DI pCCMNG2DInputRec = null;
        CCMNG2DO pCCMNG2DOutputRec = null;
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        CSEC02DI pCSEC02DInputRec = null;
        CSEC02DO pCSEC02DOutputRec = null;
        
        CSES65DI pCSES65DInputRec = null;
        CSES65DO pCSES65DOutputRec = null;
        
        CLSC04DI pCLSC04DInputRec = null;
        CLSC04DO pCLSC04DOutputRec = null;
        
        CAUDA3DI pCAUDA3DInputRec = null;
        CAUDA3DO pCAUDA3DOutputRec = null;
        
        CMSC43DI pCMSC43DInputRec = null;
        CMSC43DO pCMSC43DOutputRec = null;
        
        /* SIR# 21526 - Add Two new dams to update stage_person_link */
        CINV39DI pCINV39DInputRec1 = null;
        CINV39DO pCINV39DOutputRec1 = null;
        
        CINV39DI pCINV39DInputRec2 = null;
        CINV39DO pCINV39DOutputRec2 = null;
        CINVA6DI pCINVA6DInputRec = null;/* than individual DAMs, since one    */
        CINVA6DO pCINVA6DOutputRec = null;
        
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): Services which update functional tables and
        **                             call CheckStageEventStatus
        **************************************************************************/
        int RetVal = SUCCESS;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        
        CCMN06UO pCCMN06UOutputRec = null;
        CSUB40UI pCSUB40UInputRec1 = null;/* ToDo common function 1*/
        /**************************************************************************
        ** OPTIONAL CODE NOTE (END): Services which update functional tables and
        **                           call CheckStageEventStatus
        **************************************************************************/
        
        CSUB40UO pCSUB40UOutputRec1 = null;
        CSUB40UI pCSUB40UInputRec2 = null;/* ToDo common function 2*/
        
        CSUB40UO pCSUB40UOutputRec2 = null;
        CSUB40UI pCSUB40UInputRec3 = null;/* ToDo common function 3*/
        
        CSUB40UO pCSUB40UOutputRec3 = null;
        CSUB40UI pCSUB40UInputRec4 = null;/* ToDo common function 4*/
        
        CSUB40UO pCSUB40UOutputRec4 = null;
        CSUB40UI pCSUB40UInputRec5 = null;/* ToDo common function 5*/
        
        CSUB40UO pCSUB40UOutputRec5 = null;
        CCMN01UI pCCMN01UInputRec = null;/* pointer to DAM input record  */
        
        CCMN01UO pCCMN01UOutputRec = null;
        CCMN02UI pCCMN02UInputRec = null;/* CloseStageCase common function */
        
        CCMN02UO pCCMN02UOutputRec = null;
        
        int uCount = 0;
        int ulRowQty1 = 0;
        int usPageNbr1 = 0;
        
        
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): Generic List AUD
        **************************************************************************/
        int usRow = 0;
        int usInputRow = 0;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc44si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** Execute "The Gate" (** Perform Check Stage Event Status Processing **)
        */
        
        /**************************************************************************
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
        pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(ccfc44si.getArchInputStruct().getCReqFuncCd());
        pCCMN06UInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
        pCCMN06UInputRec.setSzCdTask(ccfc44si.getROWCCMN01UIG00().getSzCdTask());
        
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        /*
        ** Analyze error code
        */
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
        
        if (SUCCESS == RetVal) {
            // 
            // (END): Common Function: ccmn06u   Check Stage/Event common function
            // 
            
            //  Call CSES65D - Admin Review by Event
            
            // 
            // CSES65D (BEGIN): Generic Retrieve  DAM 7
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSES65DInputRec = new CSES65DI();
            
            pCSES65DOutputRec = new CSES65DO();
            pCSES65DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
            pCSES65DInputRec.setUlIdEvent(ccfc44si.getCCFC44SIG00().getUlIdEvent());
            rc = cses65dQUERYdam(sqlca, pCSES65DInputRec, pCSES65DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Call CAUDA3D - Admin Review AUD
                    
                    // 
                    // CAUDA3D (BEGIN): Generic AUD 9
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUDA3DInputRec = new CAUDA3DI();
                    
                    pCAUDA3DOutputRec = new CAUDA3DO();
                    pCAUDA3DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                    pCAUDA3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    
                    pCAUDA3DInputRec.setSzCdAdminRvReqBy(ccfc44si.getCCFC44SIG00().getSzCdAdminRvReqBy());
                    pCAUDA3DInputRec.setSzScrNmReviewReqBy(ccfc44si.getCCFC44SIG00().getSzScrNmReviewReqBy());
                    pCAUDA3DInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                    pCAUDA3DInputRec.setUlIdPerson(ccfc44si.getCCFC44SIG00().getUlIdPersonRequestor());
                    pCAUDA3DInputRec.setUlIdEvent(ccfc44si.getCCFC44SIG00().getUlIdEvent());
                    pCAUDA3DInputRec.setUlIdStageRelated(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                    pCAUDA3DInputRec.setCIndAdminRvEmgcyRel(ccfc44si.getCCFC44SIG00().getCIndAdminRvEmgcyRel());
                    pCAUDA3DInputRec.setTsLastUpdate(ccfc44si.getCCFC44SIG00().getTsLastUpdate());
                    pCAUDA3DInputRec.setSzCdAdminRvAppealResult(ccfc44si.getCCFC44SIG00().getSzCdAdminRvAppealResult());
                    pCAUDA3DInputRec.setSzCdAdminRvAppealType(ccfc44si.getCCFC44SIG00().getSzCdAdminRvAppealType());
                    
                    pCAUDA3DInputRec.setSzCdAdminRvAuth(ccfc44si.getCCFC44SIG00().getSzCdAdminRvAuth());
                    pCAUDA3DInputRec.setSzCdAdminRvStatus(ccfc44si.getCCFC44SIG00().getSzCdAdminRvStatus());
                    pCAUDA3DInputRec.setDtDtAdminRvAppealNotif(ccfc44si.getCCFC44SIG00().getDtDtAdminRvAppealNotif());
                    pCAUDA3DInputRec.setDtDtAdminRvAppealReview(ccfc44si.getCCFC44SIG00().getDtDtAdminRvAppealReview());
                    pCAUDA3DInputRec.setDtDtAdminRvDue(ccfc44si.getCCFC44SIG00().getDtDtAdminRvDue());
                    pCAUDA3DInputRec.setDtDtAdminRvEmgcyRel(ccfc44si.getCCFC44SIG00().getDtDtAdminRvEmgcyRel());
                    pCAUDA3DInputRec.setDtDtAdminRvHearing(ccfc44si.getCCFC44SIG00().getDtDtAdminRvHearing());
                    pCAUDA3DInputRec.setDtDtAdminRvReqAppeal(ccfc44si.getCCFC44SIG00().getDtDtAdminRvReqAppeal());
                    rc = cauda3dAUDdam(sqlca, pCAUDA3DInputRec, pCAUDA3DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Post Event Processing p. 5a
                            
                            // 
                            // (BEGIN): Common Function: ccmn01u   Post Event common function
                            // 
                            //  Allocate memory for Common Function Input and Output Structures
                            pCCMN01UInputRec = new CCMN01UI();
                            
                            pCCMN01UOutputRec = new CCMN01UO();
                            pCCMN01UInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                            pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                            pCCMN01UInputRec.setROWCCMN01UIG00(ccfc44si.getROWCCMN01UIG00());
                            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                            
                            //  Analyze return code
                            switch (rc) {
                                    // SIR 16114
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to FND_SUCCESS
                                    RetVal = SUCCESS;
                                    if (0 == ccfc44si.getCCFC44SIG00().getSzCdAdminRvStatus().compareTo(AR_STATUS_APPROVED)) {
                                        //  Call CINT21D - STAGE RTRV
                                        
                                        // 
                                        // CINT21D (BEGIN): Generic Retrieve  DAM 4
                                        // 
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCINT21DInputRec = new CINT21DI();
                                        
                                        pCINT21DOutputRec = new CINT21DO();
                                        pCINT21DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                        pCINT21DInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                                        
                                        //  Call CLSS67D -List of Contract rows for an id resource
                                        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
                                        
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                if ((0 == pCINT21DOutputRec.getSzCdStageProgram().compareTo(CAPS_PROG_APS)) && (0 == pCINT21DOutputRec.getSzCdStageReasonClosed().compareTo(0))) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_NO_APS_CONCL;
                                                    
                                                    
                                                    //  Set RetVal to FND_FAIL
                                                    RetVal = Csub50s.FND_FAIL;
                                                    rc = Csub50s.FND_FAIL;
                                                    
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                }
                                                // End SIR 18975
                                                
                                                
                                                // Start Sir 13618
                                                else if ((0 == pCINT21DOutputRec.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) && (0 == pCINT21DOutputRec.getSzCdStageReasonClosed().compareTo(0))) {
                                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                    pServiceStatus.explan_code = Messages.MSG_NO_AFC_CONCL;
                                                    
                                                    
                                                    //  Set RetVal to FND_FAIL
                                                    RetVal = Csub50s.FND_FAIL;
                                                    rc = Csub50s.FND_FAIL;
                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                }
                                                // End SIR 17631
                                                
                                                else {
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    //  Set RetVal to FND_SUCCESS
                                                    RetVal = SUCCESS;
                                                    
                                                    //  SIR 3615: Removed original Close Stage code from service
                                                    // and replaced it with a call to CloseStageCase function to
                                                    // simplify maintenance.
                                                    
                                                    // 
                                                    // (BEGIN): CloseStageCase CCMN02U
                                                    // 
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCCMN02UInputRec = new CCMN02UI();
                                                    
                                                    
                                                    pCCMN02UOutputRec = new CCMN02UO();
                                                    pCCMN02UInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageReasonClosed(ccfc44si.getCCFC44SIG00().getSzCdAdminRvAppealResult());
                                                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStageProgram(pCINT21DOutputRec.getSzCdStageProgram());
                                                    pCCMN02UInputRec.getCCMN02UIG00().setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                                    pCCMN02UInputRec.getCCMN02UIG00().setUlIdPerson(ccfc44si.getUlIdPerson());
                                                    pCCMN02UInputRec.getCCMN02UIG00().setSzCdStage(ccfc44si.getROWCCMN01UIG00().getSzCdEventType());
                                                    
                                                    //  Call CSES80D - Retrieve Contract Period
                                                    rc = Ccmn02u.CloseStageCase(pCCMN02UInputRec, pCCMN02UOutputRec, pServiceStatus);
                                                    
                                                    
                                                    
                                                    //  Analyze return code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            break;
                                                        case Arcxmlerrors.ARC_ERR_NO_PROC_RC:
                                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                            pServiceStatus.explan_code = Messages.MSG_CMN_STAGE_CLOSED;
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                    
                                                    // Populate DAM Input Structure
                                                    // SIR#3582: If a ChildPlacingAgency (CPA) exists validate its contract
                                                    if ((SUCCESS == RetVal) && (0 == STAGE_CD_INV.compareTo(pCINT21DOutputRec.getSzCdStage()))) {
                                                        
                                                        //  Call CMSC43D - ALIGN TO ADMIN ALGTN
                                                        // if CINT21DO CdStage is STAGE_CD_INV and RetVal is FND_SUCCESS
                                                        
                                                        // 
                                                        // CMSC43D - ALIGN TO ADMIN ALGTN (BEGIN): Generic AUD 15
                                                        // 
                                                        //  Allocate memory for DAM Input and Output Structures
                                                        pCMSC43DInputRec = new CMSC43DI();
                                                        
                                                        pCMSC43DOutputRec = new CMSC43DO();
                                                        pCMSC43DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                        
                                                        pCMSC43DInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                                                        pCMSC43DInputRec.setUlIdPerson(ccfc44si.getCCFC44SIG00().getUlIdPersonRequestor());
                                                        pCMSC43DInputRec.setUlIdAdminAllegARStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                                        pCMSC43DInputRec.setCIndAdminAllegPrior(FND_NO);
                                                        
                                                        
                                                        //  Call architecture function to retreive the current date.
                                                        rc = cmsc43dAUDdam(sqlca, pCMSC43DInputRec, pCMSC43DOutputRec);
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                //  Set RetVal = FND_SUCCESS
                                                                RetVal = SUCCESS;
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                
                                                                //  Set RetVal = FND_SUCCESS
                                                                RetVal = SUCCESS;
                                                                break;
                                                                
                                                            default :
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                
                                                                //  set RetVal = FND_SUCCESS
                                                                RetVal = SUCCESS;
                                                                break;
                                                        }
                                                    }
                                                }
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                //  Set RetVal = FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                break;
                                        }
                                        if ((0 != ccfc44si.getROWCCMN01UIG00().getSzCdEventType().compareTo(ADMIN_REVIEW_FAD)) && (RetVal == SUCCESS)) {
                                            
                                            // 
                                            // SIR# 21526 - CINV39D - FIRST CALL
                                            // 
                                            // 
                                            // SIR# 21526 - Adding two new Dams.  The first will retrieve
                                            // a full row from stage_person_link for the INV stage
                                            // for the id_person of the Requestor of the Admin Review
                                            // (Dam CINV39D).  Next, CINV39D will be called a second 
                                            // time for the ARI row for the same person.  Finally,
                                            // CINVA6D will be called to update the ARI row in Stage
                                            // Person Link with the new role from CINV39D(First Call)
                                            // and the DtLastUpdate for the ARI row from the Second
                                            // Call to CINV39D.  This functionality only occurs upon
                                            // Approval of the Admin Review.
                                            // 
                                            
                                            // 
                                            // 1st Call to CINV39D - INV info from stage person link
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCINV39DInputRec1 = new CINV39DI();
                                            
                                            pCINV39DOutputRec1 = new CINV39DO();
                                            pCINV39DInputRec1.setArchInputStruct(ccfc44si.getArchInputStruct());
                                            pCINV39DInputRec1.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                                            pCINV39DInputRec1.setUlIdPerson(ccfc44si.getCCFC44SIG00().getUlIdPersonRequestor());
                                            rc = cinv39dQUERYdam(sqlca, pCINV39DInputRec1, pCINV39DOutputRec1);
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    //  Set RetVal = FND_SUCCESS
                                                    RetVal = SUCCESS;
                                                    
                                                    // 
                                                    // 2nd Call to CINV39D - ARI info from stage_person_link
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCINV39DInputRec2 = new CINV39DI();
                                                    
                                                    pCINV39DOutputRec2 = new CINV39DO();
                                                    pCINV39DInputRec2.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                    pCINV39DInputRec2.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                                    pCINV39DInputRec2.setUlIdPerson(ccfc44si.getCCFC44SIG00().getUlIdPersonRequestor());
                                                    rc = cinv39dQUERYdam(sqlca, pCINV39DInputRec2, pCINV39DOutputRec2);
                                                    
                                                    //  Analyze error code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //  Set RetVal = FND_SUCCESS
                                                            RetVal = SUCCESS;
                                                            
                                                            // 
                                                            // Call to CINVA6D - update ARI Role in stage_person_link
                                                            // 
                                                            
                                                            //  Allocate memory for DAM Input and Output Structures
                                                            pCINVA6DInputRec = new CINVA6DI();
                                                            
                                                            pCINVA6DOutputRec = new CINVA6DO();
                                                            pCINVA6DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                            pCINVA6DInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                                            pCINVA6DInputRec.setUlIdPerson(ccfc44si.getCCFC44SIG00().getUlIdPersonRequestor());
                                                            pCINVA6DInputRec.setSzCdStagePersRole(pCINV39DOutputRec1.getSzCdStagePersRole());
                                                            pCINVA6DInputRec.setTsLastUpdate(pCINV39DOutputRec2.getTsLastUpdate());
                                                            rc = cinva6dAUDdam(sqlca, pCINVA6DInputRec, pCINVA6DOutputRec);
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    
                                                                    //  Set RetVal = FND_SUCCESS
                                                                    RetVal = SUCCESS;
                                                                    break;
                                                                    
                                                                    
                                                                default :
                                                                    
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    
                                                                    //  set RetVal = FND_SUCCESS
                                                                    RetVal = SUCCESS;
                                                                    break;
                                                            }
                                                            
                                                            break;
                                                            
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            //  set RetVal = FND_SUCCESS
                                                            RetVal = SUCCESS;
                                                            
                                                            break;
                                                    }
                                                    break;
                                                    
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    
                                                    //  set RetVal = FND_SUCCESS
                                                    RetVal = SUCCESS;
                                                    
                                                    break;
                                            }
                                        }
                                    }
                                    if (0 == FINDINGS_REVERSED.compareTo(ccfc44si.getCCFC44SIG00().getSzCdAdminRvAppealResult())) {
                                        ccfc44si.getCCFC44SIG00().setSzCdAdminRvAppealResult(RESULT_POSITION_MODIFIED);
                                    }
                                    
                                    // Populate Output Message
                                    
                                    //  Set fields in CCON31SO to fields in CSEC72DO
                                    // SIR#3582: Do Not write Id Contract
                                    // if Selected PlcmtType is TYC or JPC
                                    // SIR 14938:  Added PACE to this scenario
                                    if ((SUCCESS == RetVal) && (((0 == ccfc44si.getCCFC44SIG00().getSzCdAdminRvAppealResult().compareTo(RESULT_POSITION_MODIFIED)) && (0 == ccfc44si.getCCFC44SIG00().getSzCdAdminRvStatus().compareTo(AR_STATUS_APPROVED))) || (ccfc44si.getCCFC44SIG00().getSzCdAdminRvAppealResult()[0] == null && (ccfc44si.getCCFC44SIG00().getDtDtAdminRvDue().month != DateHelper.NULL_DATE && ccfc44si.getCCFC44SIG00().getDtDtAdminRvDue().day != DateHelper.NULL_DATE && ccfc44si.getCCFC44SIG00().getDtDtAdminRvDue().year != DateHelper.NULL_DATE) && (0 != ARC_UTLCompareDateAndTime((FndInt3date) & ccfc44si.getCCFC44SIG00().getDtDtAdminRvDue() , 0, (FndInt3date) & pCSES65DOutputRec.getDtDtAdminRvDue() , 0))))) {
                                        //  Send ToDo processing
                                        
                                        //  Call CSEC02D - STAGE CASE RTRV
                                        // 
                                        // CSEC02D - STAGE CASE RTRV (BEGIN): Generic Retrieve  DAM 6
                                        // 
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCSEC02DInputRec = new CSEC02DI();
                                        
                                        pCSEC02DOutputRec = new CSEC02DO();
                                        pCSEC02DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                        pCSEC02DInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                        
                                        //  Call CSES81D - Contract Version retrieve
                                        rc = csec02dQUERYdam(sqlca, pCSEC02DInputRec, pCSEC02DOutputRec);
                                        
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  set RetVal = FND_SUCCESS
                                                
                                                RetVal = SUCCESS;
                                                // 
                                                // (END): Retrieve DAM: csec26d   Contract county & period retrieve
                                                // 
                                                
                                                if (null == ccfc44si.getCCFC44SIG00().getSzCdAdminRvAppealResult()[0]) {
                                                    //  Call CCMNG2D - PRIMARY STAFF SMP
                                                    // 
                                                    // CCMNG2D - PRIMARY STAFF SMP (BEGIN): Generic Retrieve  DAM 3
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCCMNG2DInputRec = new CCMNG2DI();
                                                    
                                                    pCCMNG2DOutputRec = new CCMNG2DO();
                                                    pCCMNG2DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                    pCCMNG2DInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                                    rc = ccmng2dQUERYdam(sqlca, pCCMNG2DInputRec, pCCMNG2DOutputRec);
                                                    
                                                    switch (rc) {
                                                            
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //  set RetVal = FND_SUCCESS
                                                            RetVal = SUCCESS;
                                                            
                                                            
                                                            // 
                                                            // BEGIN Todo Common Function Call 1
                                                            // 
                                                            
                                                            
                                                            //  ToDo Common Function
                                                            // ( Send ToDo CFC014 )
                                                            //  Allocate Memory for ToDo Common Function input and output Stuctures
                                                            pCSUB40UInputRec1 = new CSUB40UI();
                                                            
                                                            pCSUB40UOutputRec1 = new CSUB40UO();
                                                            
                                                            pCSUB40UInputRec1.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CFC014);
                                                            pCSUB40UInputRec1.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCCMNG2DOutputRec.getUlIdPerson());
                                                            pCSUB40UInputRec1.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(ccfc44si.getCCFC44SIG00().getDtDtAdminRvDue());
                                                            pCSUB40UInputRec1.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccfc44si.getCCFC44SIG00().getUlIdEvent());
                                                            pCSUB40UInputRec1.getCSUB40UIG00().setUlSysIdTodoCfStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                                            pCSUB40UInputRec1.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC014_START);
                                                            pCSUB40UInputRec1.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += pCSEC02DOutputRec.getSzNmCase() + TODO_TEXT_CFC014_END;
                                                            Date_Todo_Due_From_String = pCSUB40UInputRec1.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().month + "/" + pCSUB40UInputRec1.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day + "/" + pCSUB40UInputRec1.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().year;
                                                            pCSUB40UInputRec1.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += Date_Todo_Due_From_String;
                                                            rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec1, pCSUB40UOutputRec1, pServiceStatus);
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    
                                                                    //  Set RetVal to FND_SUCCESS
                                                                    RetVal = SUCCESS;
                                                                    
                                                                    // 
                                                                    // BEGIN Todo Common Function Call 2
                                                                    // 
                                                                    
                                                                    
                                                                    //  ToDo Common Function ( Send ToDo CFC015 )
                                                                    
                                                                    //  Allocate Memory for ToDo Common Function input and output Stuctures
                                                                    pCSUB40UInputRec2 = new CSUB40UI();
                                                                    
                                                                    pCSUB40UOutputRec2 = new CSUB40UO();
                                                                    pCSUB40UInputRec2.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CFC015);
                                                                    pCSUB40UInputRec2.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCCMNG2DOutputRec.getUlIdPerson());
                                                                    pCSUB40UInputRec2.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(ccfc44si.getCCFC44SIG00().getDtDtAdminRvDue());
                                                                    
                                                                    rc = ARC_UTLAddToDate((FndInt3date) & pCSUB40UInputRec2.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , (FndInt3date) & dtSubtract);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                    pCSUB40UInputRec2.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccfc44si.getCCFC44SIG00().getUlIdEvent());
                                                                    pCSUB40UInputRec2.getCSUB40UIG00().setUlSysIdTodoCfStage(ccfc44si.getCCFC44SIG00().getUlIdStage());
                                                                    pCSUB40UInputRec2.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC015_START);
                                                                    
                                                                    pCSUB40UInputRec2.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += pCSEC02DOutputRec.getSzNmCase() + TODO_TEXT_CFC015_MIDDLE + pCSEC02DOutputRec.getSzNmStage() + TODO_TEXT_CFC015_END;
                                                                    rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec2, pCSUB40UOutputRec2, pServiceStatus);
                                                                    switch (rc) {
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                                            pServiceStatus.explan_code = SUCCESS;
                                                                            
                                                                            //  Set RetVal to FND_SUCCESS
                                                                            RetVal = SUCCESS;
                                                                            
                                                                            break;
                                                                            
                                                                            
                                                                        default :
                                                                            //  Set RetVal to FND_FAIL
                                                                            RetVal = Csub50s.FND_FAIL;
                                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                            break;
                                                                            //   Insert any manipulation required on the DAM output record
                                                                            // before sending the data to ARC_FRMProduceFormData in the
                                                                            // calling function.  In most cases, this loop will be removed
                                                                            // because there is no processing to be done.
                                                                            // 
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
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            
                                                            //  set RetVal = FND_FAIL
                                                            
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                }
                                                
                                                // 
                                                // CCMNG2D (END): Generic Retrieve  DAM 3
                                                // 
                                                
                                                
                                                
                                                else {
                                                    //  Call CCMN19D - STAGE PERSON LINK
                                                    
                                                    // 
                                                    // CCMN19D - STAGE PERSON LINK (BEGIN): Generic Retrieve  DAM 1
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCCMN19DInputRec = new CCMN19DI();
                                                    
                                                    pCCMN19DOutputRec = new CCMN19DO();
                                                    
                                                    pCCMN19DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                    
                                                    pCCMN19DInputRec.setSzCdStagePersRole(ROLE_PRINCIPAL);
                                                    pCCMN19DInputRec.setUlIdStage(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                                                    rc = ccmn19dQUERYdam(sqlca, pCCMN19DInputRec, pCCMN19DOutputRec);
                                                    
                                                    //  Analyze error code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //  set RetVal = FND_SUCCESS
                                                            
                                                            RetVal = SUCCESS;
                                                            
                                                            
                                                            //  Call CCMN60D - GET SUPERVISOR
                                                            // 
                                                            // CCMN60D (BEGIN): Generic Retrieve  DAM 2
                                                            // 
                                                            
                                                            //  Allocate memory for DAM Input and Output Structures
                                                            pCCMN60DInputRec = new CCMN60DI();
                                                            
                                                            pCCMN60DOutputRec = new CCMN60DO();
                                                            pCCMN60DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                            pCCMN60DInputRec.setUlIdPerson(pCCMN19DOutputRec.getUlIdTodoPersWorker());
                                                            //  Call CLSS68D:
                                                            // SELECT * FROM CONTRACT_COUNTY C WHERE C.ID_CONTRACT =
                                                            // AND C.NBR_CNCNTY_PERIOD  =        AND C.NBR_CNCNTY_VERSION =
                                                            rc = ccmn60dQUERYdam(sqlca, pCCMN60DInputRec, pCCMN60DOutputRec);
                                                            switch (rc) {
                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                                    
                                                                    //  Set RetVal to FND_SUCCESS
                                                                    RetVal = SUCCESS;
                                                                    
                                                                    //  Call Todo Common Function ( send ToDo to the historical worker )
                                                                    // 
                                                                    // BEGIN Todo Common Function Call  3
                                                                    // 
                                                                    
                                                                    //  Allocate Memory for ToDo Common Function input and output Stuctures
                                                                    pCSUB40UInputRec3 = new CSUB40UI();
                                                                    
                                                                    pCSUB40UOutputRec3 = new CSUB40UO();
                                                                    pCSUB40UInputRec3.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CFC013);
                                                                    rc = ARC_UTLGetDateAndTime(pCSUB40UInputRec3.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                    pCSUB40UInputRec3.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pCCMN19DOutputRec.getUlIdTodoPersWorker());
                                                                    pCSUB40UInputRec3.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccfc44si.getCCFC44SIG00().getUlIdEvent());
                                                                    pCSUB40UInputRec3.getCSUB40UIG00().setUlSysIdTodoCfStage(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                                                                    pCSUB40UInputRec3.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC013_START);
                                                                    pCSUB40UInputRec3.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += pCSEC02DOutputRec.getSzNmStage() + TODO_TEXT_CFC013_MIDDLE + pCSEC02DOutputRec.getSzNmCase() + TODO_TEXT_CFC013_END;
                                                                    rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec3, pCSUB40UOutputRec3, pServiceStatus);
                                                                    
                                                                    switch (rc) {
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                                            pServiceStatus.explan_code = SUCCESS;
                                                                            
                                                                            //  Set RetVal to FND_SUCCESS
                                                                            RetVal = SUCCESS;
                                                                            
                                                                            // 
                                                                            // BEGIN Todo Common Function Call  4
                                                                            // 
                                                                            
                                                                            
                                                                            //  ToDo Common Function 
                                                                            // ( send ToDo to the historical primary worker's supervisor )
                                                                            
                                                                            //  Allocate Memory for ToDo Common Function input and output Stuctures
                                                                            pCSUB40UInputRec4 = new CSUB40UI();
                                                                            
                                                                            pCSUB40UOutputRec4 = new CSUB40UO();
                                                                            pCSUB40UInputRec4.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CFC013);
                                                                            rc = ARC_UTLGetDateAndTime(pCSUB40UInputRec4.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                                                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                            pCSUB40UInputRec4.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(pCCMN60DOutputRec.getUlIdPerson());
                                                                            pCSUB40UInputRec4.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccfc44si.getCCFC44SIG00().getUlIdEvent());
                                                                            pCSUB40UInputRec4.getCSUB40UIG00().setUlSysIdTodoCfStage(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                                                                            pCSUB40UInputRec4.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC013_START);
                                                                            pCSUB40UInputRec4.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += pCSEC02DOutputRec.getSzNmStage() + TODO_TEXT_CFC013_MIDDLE + pCSEC02DOutputRec.getSzNmCase() + TODO_TEXT_CFC013_END;
                                                                            
                                                                            
                                                                            //  Call CINT20D
                                                                            rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec4, pCSUB40UOutputRec4, pServiceStatus);
                                                                            switch (rc) {
                                                                                case WtcHelperConstants.SQL_SUCCESS:
                                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                                    
                                                                                    //  Set RetVal to FND_SUCCESS
                                                                                    RetVal = SUCCESS;
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
                                                                    break;
                                                                case NO_DATA_FOUND:
                                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                                    pServiceStatus.explan_code = SUCCESS;
                                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                                    
                                                                    //  Set RetVal to FND_SUCCESS
                                                                    RetVal = SUCCESS;
                                                                    break;
                                                                    // 
                                                                    // End Todo Common Function Call  4
                                                                    // 
                                                                    
                                                                    
                                                                default :
                                                                    
                                                                    //  Set RetVal = FND_FAIL
                                                                    
                                                                    RetVal = Csub50s.FND_FAIL;
                                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                    
                                                                    break;
                                                            }
                                                            break;
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            rc = WtcHelperConstants.ARC_SUCCESS;
                                                            
                                                            //  set RetVal = FND_SUCCESS
                                                            RetVal = SUCCESS;
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            //  set RetVal = FND_FAIL
                                                            RetVal = Csub50s.FND_FAIL;
                                                            break;
                                                    }
                                                    
                                                    // SIR#3582: Find JPC or TYC Contract if that is selected PlcmtType
                                                    // SIR 14938:  Add PACE to this scenario
                                                    if (RetVal == SUCCESS) {
                                                        //  Call CLSC04D - DISTINCT WORKERS
                                                        // 
                                                        // CLSC04D (BEGIN): Generic List  DAM 1
                                                        // 
                                                        
                                                        //  Allocate memory for DAM Input and Output Structures
                                                        pCLSC04DInputRec = new CLSC04DI();
                                                        
                                                        pCLSC04DOutputRec = new CLSC04DO();
                                                        pCLSC04DInputRec.setArchInputStruct(ccfc44si.getArchInputStruct());
                                                        pCLSC04DInputRec.setSzCdStagePersRole(ROLE_PRINCIPAL);
                                                        pCLSC04DInputRec.setUlIdCase(pCSEC02DOutputRec.getUlIdCase());
                                                        pCLSC04DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
                                                        
                                                        
                                                        //  Call CRES13D
                                                        rc = clsc04dQUERYdam(sqlca, pCLSC04DInputRec, pCLSC04DOutputRec);
                                                        
                                                        //  Analyze error code
                                                        switch (rc) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                
                                                                //  Set RetVal = FND_SUCCESS
                                                                RetVal = SUCCESS;
                                                                
                                                                //  Set uCount = zero
                                                                uCount = 0;
                                                                ccfc44so.getArchOutputStruct().setUlRowQty(pCLSC04DOutputRec.getArchOutputStruct().getUlRowQty());
                                                                
                                                                //  Call ToDo Common Function
                                                                // While uCount < ulRowQty and RetVal is FND_SUCCESS
                                                                while ((uCount < ulRowQty1) && (RetVal == SUCCESS)) {
                                                                    
                                                                    // 
                                                                    // BEGIN Todo Common Function Call 5
                                                                    // 
                                                                    
                                                                    
                                                                    //  Allocate Memory for ToDo Common Function input and output Stuctures
                                                                    pCSUB40UInputRec5 = new CSUB40UI();
                                                                    
                                                                    pCSUB40UOutputRec5 = new CSUB40UO();
                                                                    pCSUB40UInputRec5.getCSUB40UIG00().setSzSysCdTodoCf(TODO_CFC014);
                                                                    rc = ARC_UTLGetDateAndTime(pCSUB40UInputRec5.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                                                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                                    pCSUB40UInputRec5.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCLSC04DOutputRec.getROWCLSC04DO_ARRAY().getROWCLSC04DO(uCount).getUlIdPerson());
                                                                    pCSUB40UInputRec5.getCSUB40UIG00().setUlSysIdTodoCfEvent(ccfc44si.getCCFC44SIG00().getUlIdEvent());
                                                                    pCSUB40UInputRec5.getCSUB40UIG00().setUlSysIdTodoCfStage(ccfc44si.getCCFC44SIG00().getUlIdStageRelated());
                                                                    pCSUB40UInputRec5.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC013_START);
                                                                    pCSUB40UInputRec5.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += pCSEC02DOutputRec.getSzNmStage() + TODO_TEXT_CFC013_MIDDLE + pCSEC02DOutputRec.getSzNmCase() + TODO_TEXT_CFC013_END;
                                                                    rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec5, pCSUB40UOutputRec5, pServiceStatus);
                                                                    
                                                                    //  Analyze error code
                                                                    switch (rc) {
                                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                                            pServiceStatus.explan_code = SUCCESS;
                                                                            
                                                                            //  Set RetVal to FND_SUCCESS
                                                                            RetVal = SUCCESS;
                                                                            break;
                                                                            
                                                                        default :
                                                                            //  Set RetVal to FND_FAIL
                                                                            RetVal = Csub50s.FND_FAIL;
                                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                            
                                                                            break;
                                                                    }
                                                                    uCount++;
                                                                }
                                                                
                                                                //  Set explan_data to usRow
                                                                // Note: Use sprintf
                                                                //##          sprintf(pReturnPB->appl_status.explan_data,
                                                                //##                  "%u",
                                                                //##                  usRow);
                                                                
                                                                break;
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                //  Call CSES41D
                                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                                
                                                                //  Set RetVal to FND_SUCCESS
                                                                RetVal = SUCCESS;
                                                                
                                                                
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
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                
                                                                //  Set RetVal to FND_FAIL
                                                                RetVal = Csub50s.FND_FAIL;
                                                                
                                                                break;
                                                                usPageNbr1++;
                                                        }
                                                    }
                                                }
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                //  Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                
                                                
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
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                            
                            //  RetVal = FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            
                            
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            //  RetVal = FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            
                            break;
                    }
                    
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    //  Set RetVal = FND_FAIL;
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
        ARC_PRFServiceStopTime_TUX(ccfc44si.getArchInputStruct() , ccfc44so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            // If PlcmtType is JPC, use JPC_VID, otherwise use TYC_VID
            // SIR 14938:  If PlcmtType is PACE, use PACE_VID
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
        return ccfc44so;
    }

}
