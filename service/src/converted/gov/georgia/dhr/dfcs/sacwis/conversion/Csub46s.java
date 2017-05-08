package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB46SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB46SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD05DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD05DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC54DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES28DO;
/***************************************************************************
**
** Module File:   CSUB46S.src
**
** Service Name:  CSUB46S
**
** Description:   This is the save service for the Legal Status window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  20Sep95
**
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.13.1.2.1.3  $
**                      $Date:   22 Feb 2001 14:58:30  $
**                      $Modtime:   22 Feb 2001 10:31:44  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   5Oct95   sladewmf  Initial check-in.
**  29Nov95   walkerbd  Changed a COPYSZ line and an if statement:
**                      search for 29Nov95 to see changes.
**  12/14/95  WILSONET  SIR#2177 Service design altered to meet
**                      standards and handle new window code.
**  03/17/96  OMARAJJ   SIR#3845 - Added DAM CAUDB8 to update the person
**                      table when the legal status of the ID PERSON is one
**                      of several types.  So that they are recognized as
**                      being in conservatorship.  A 'C' is copied to the
**                      person table at CD_PERS_GUARD_CNSRV.
**
**  07/26/96  zabihin   sir 21891 : version control code was missing, I
**                      added the lines.
**  12/16/96  ZABIHIN   SIR 21130 - the retrieve service retrieves
**                      IdEvent and status of the stage closure event
**                      this service will invalidate the pendig approval for
**                      the closure event if legal status is changed after the
**                      stage has been submitted for approval.
**                      added ccmn62 to update the event table regardless of
**                      what the time stamp is.
**                      Look at the comments in csub40w, and csub45s
**  10/15/97    klm     SIR# 14192 - Add the TMC Dismissal Date to the info
**              that is saved to the database.
**          Add CSUB80D.PC DAM to query for any legal statuses
**          with Status Effective date and same Person ID as the
**          Legal Status being created.  If any are found, then
**          the Legal Status will not be created/modified.  This
**          is an effort to prevent duplicate LS's being created.
**  11/20/97  klm   SIR# 14234 - Correct the conditional for checking
**          the number of duplicate LS dates for add from
**          CSUB80D.
**  12/8/97  klm        SIR# 14234 - Add DAM CINT21D to service to retrieve
**                      dtStageClose so that the window mode is not changed
**                      to Modify if a Stage is closed.  Set the Stage Close
**                      Indicator to TRUE if dtStageClose is not NULL or not
**                      MAX_DATE
**  12/18/97  klm SIR# 14396 - Correct the conditional for checking
**      the number of duplicate LS dates for update from
**      CSUB80D.
**   01/12/1999 PERIL Sir # 14553  - Added code to check if
**                           duplicate legal status date existed.
**                           search for comments under Sir # 14553.
**
**  09/20/2000 SMITHAL SIR # 15072 - Added legal status change indicator to
**                                   info that is saved to the database.
**
**  10/17/2000  PERIL Sir # 15352 - Added code to check two conditions:
**                          1)A person cannot have two consecutive terminating
**                          legal statuses.Terminating legal statuses being :
**                          a)Adoption Conssumated. b)Child Emancipated
**                          c)Prs Resp terminated d)CVS Not Obtained.
**                          2)Child's first legal status cannot be a terminating event.
**                          see comments under sir# 15352.
**  10/17/2000 PERIL Sir #  15353 - Added code and an existing dam CCMN44D.PC
**                          to check for one condition:
**                          1)Legal conservatorship Of a Person 18 Years Old And
**                          Older Is Prohibited.See Comments under sir # 15353.
**  02/22/01    HadjimH SIR# 14413. Added the code for the field CD_COURT_NBR
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  03/20/03   Srini    Replaced TRUE with INDICATOR_YES for the check
**          pInputMsg->IndDateModified == TRUE
**  04/16/03   douglacs Changed error handling for MSG_CMN_TMSTAMP_MISMATCH
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver mode" allowing supervisors to ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**            to PROCESS_TUX_RC_ERROR_NOFREE after the
**            ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**            input and output objects before they are allocated
**
**  07/17/03  douglacs  SIR 18934 -Changed error handling for MSG_NO_LS_AFTER_STG_CLOSE
**
**  07/30/03   Srini    SIR#19044 Initialize the input structure pointers
**            before the InvalidateAprvl call.
**  08/08/03  douglacs  SIR 19357 - In approval mode, the event description
**                      wasn't being updated with legal status changes.
**  10/03/04  douglacs  SIR 16221  - Consecutive Terminating Legal Status edit
**                      isn't working correctly
**  10/14/04  gerryc    SIR 14053 - when legal status changes to adoption
**                      consummated, find the resource id of the placement,
**                      check to see if it's an F/A home, and then increase
**                      the open slots by 1.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/* SIR 21130 */
/* SIR 1130 */




/*
** Extern for version control table.
*/






public class Csub46s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int FND_FAILURE = 1;
    public static final String TODO_INFO_CODE = "SUB026";
    
    /* SIR#3845 */
    public static final String CONSERV_STATUS = "C";
    public static final String CARE_CUST_CNTL = "010";
    public static final String TMC = "020";
    public static final String PMC_RTS_NOT_TERM = "030";
    public static final String PMC_RTS_TERM = "040";
    public static final String PMC_RTS_TERM_BIO = "050";
    public static final String PMC_RTS_TERM_LEG = "060";
    public static final String PMC_RTS_TERM_MOTHER = "070";
    public static final String OTHER_LEGAL = "080";
    public static final String POSS_CONSERVATOR = "130";
    
    /* SIR# 15352 */
    public static final String ADOPT_CONSUMM = "090";
    public static final String CHILD_EMAN = "100";
    public static final String PRS_RESP_TERM = "120";
    public static final String CVS_NOT_OBT = "150";
    
    /* END SIR#3845 */
    
    /* SIR 21130 define section*/
    public static final char UPDATE = 'U';
    public static final String EVENT_PEND = "PEND";
    public static final int STAGE_CLOSURE = 1;
    public static final int MAX_DATEDAY = 31;
    public static final int MAX_DATEMONTH = 12;
    public static final int MAX_DATEYEAR = 4712;
    CSUB46SO CSUB46S(CSUB46SI csub46si) {
        CSUB46SO csub46so = new CSUB46SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CSUB46S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        int RetVal = SUCCESS;
        int i432 = 0;
        int ulIdEvent30 = 0;
        /*SIR 21130*/
        
        /* SIR 21130 - indicator for the status of closure event, if PEND it
        ** will be set to FALSE
        */
        Pint bIndEvent = new Pint();
        bIndEvent.value = 1;
        
        /*
        ** SIR# 14234
        */
        int lStaRC = 0;
        FndInt3date dtDtStageClose6 = null;
        int lRC12 = 0;
        FndInt3date dtDtPersonBirth1 = null;
        CCMN05UI pCCMN05UInputRec = null;/* Invalidate Approval   */
        
        
        
        /* added ccmn05u - invalidate approval */
        CCMN05UO pCCMN05UOutputRec = null;
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;
        
        CCMN01UO pCCMN01UOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;/* ToDo common function: from ToDoInfo */
        
        CSUB40UO pCSUB40UOutputRec = null;
        CAUD05DI pCAUD05DInputRec = null;/* Legal Status Generic AUD dam        */
        
        CAUD05DO pCAUD05DOutputRec = null;
        
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        CAUD07DI pCAUD07DInputRec = null;/* Stored Procedure: Complex Delete    */
        CAUD07DO pCAUD07DOutputRec = null;/* on EVENT, EVENT_PERSON_LINK, & TODO */
        CAUDB8DI pCAUDB8DInputRec = null;/* SIR#3845 */
        CAUDB8DO pCAUDB8DOutputRec = null;/* SIR#3845 */
        CSUB80DI pCSUB80DInputRec = null;/* SIR# 14192 */
        CSUB80DO pCSUB80DOutputRec = null;/* SIR# 14192 */
        CMSC54DI pCMSC54DInputRec = null;/* SIR# 15352 */
        CMSC54DO pCMSC54DOutputRec = null;/* SIR# 15352 */
        CCMN44DI pCCMN44DInputRec = null;/* SIR # 15353 */
        CCMN44DO pCCMN44DOutputRec = null;/*SIR # 15353 */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        rc = ARC_PRFServiceStartTime_TUX(csub46si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields
        */
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** SIR# 14234 - CSUB80D checks for duplicate legal statuses
        */
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSUB80DInputRec = new CSUB80DI();
        
        pCSUB80DOutputRec = new CSUB80DO();
        pCSUB80DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
        pCSUB80DInputRec.setUlIdPerson(csub46si.getROWCSUB46SIG00().getUlIdPerson());
        pCSUB80DInputRec.setDtDtLegalStatStatusDt(csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt());
        
        /* Call Post Event */
        rc = csub80dQUERYdam(sqlca, pCSUB80DInputRec, pCSUB80DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (((0 != pCSUB80DOutputRec.getUsSysNbrNumberOfRows()) && (WtcHelperConstants.REQ_FUNC_CD_ADD == csub46si.getArchInputStruct().getCReqFuncCd())) || ((0 < pCSUB80DOutputRec.getUsSysNbrNumberOfRows()) && (INDICATOR_YES == csub46si.getIndDateModified()) && (ServiceConstants.REQ_FUNC_CD_UPDATE == csub46si.getArchInputStruct().getCReqFuncCd()))) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUP_LEG_STAT_DATE;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE;
                }
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                }
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();// SIR#2556
                
                //  Set RetVal to FND_FAILURE
                RetVal = FND_FAILURE;
                break;
        }
        if (RetVal == FND_FAILURE) {
            
            //  Call PostEvent
            // 
            rc = RetVal;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** if deleting a legal status, subtract one from open slots.  if
        ** adding the legal status, add one to open slots. (this code logic
        ** looks backwards, but it isn't)
        */
        if (WtcHelperConstants.REQ_FUNC_CD_DELETE != csub46si.getArchInputStruct().getCReqFuncCd()) {
            //  Allocate memory for DAM Input Structure
            pCCMN44DInputRec = new CCMN44DI();
            
            pCCMN44DOutputRec = new CCMN44DO();
            pCCMN44DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
            
            pCCMN44DInputRec.setUlIdPerson(csub46si.getROWCSUB46SIG00().getUlIdPerson());
            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    dtDtPersonBirth1 = pCCMN44DOutputRec.getDtDtPersonBirth();
                    if ((DateHelper.NULL_DATE != dtDtPersonBirth1.day) && (DateHelper.NULL_DATE != dtDtPersonBirth1.month) && (DateHelper.NULL_DATE != dtDtPersonBirth1.year)) {
                        dtDtPersonBirth1.year += 18;
                        lRC12 = ARC_UTLCompareDateAndTime((FndInt3date) & csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt() , (char) 0, (FndInt3date) & dtDtPersonBirth1, (char) 0);
                        if (lRC12 > 0) {
                            RetVal = FND_FAILURE;
                            pServiceStatus.explan_code = Messages.MSG_LEG_CSRVT_OF_PER_PROH;
                        }
                        else {
                            RetVal = SUCCESS;
                        }
                    }
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            
            //  Analyze error code
            if (RetVal == FND_FAILURE) {
                rc = RetVal;
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        if (WtcHelperConstants.REQ_FUNC_CD_DELETE != csub46si.getArchInputStruct().getCReqFuncCd()) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC54DInputRec = new CMSC54DI();
            
            pCMSC54DOutputRec = new CMSC54DO();
            pCMSC54DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
            if ((0 == csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(ADOPT_CONSUMM)) || (0 == csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(CHILD_EMAN)) || (0 == csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(PRS_RESP_TERM)) || (0 == csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(CVS_NOT_OBT))) {
                pCMSC54DInputRec.setUlIdPerson(csub46si.getROWCSUB46SIG00().getUlIdPerson());
                pCMSC54DInputRec.setDtDtLegalStatStatusDt(csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt());
                pCMSC54DInputRec.setUlIdLegalStatEvent(csub46si.getROWCSUB46SIG00().getUlIdLegalStatEvent());
                pCMSC54DInputRec.getArchInputStruct().setUsPageNbr(1);
                pCMSC54DInputRec.getArchInputStruct().setUlPageSizeNbr(2);
                rc = cmsc54dQUERYdam(sqlca, pCMSC54DInputRec, pCMSC54DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        for (i432 = 0;i432 < pCMSC54DOutputRec.getArchOutputStruct().getUlRowQty();i432++) {
                            if ((0 == pCMSC54DOutputRec.getSzCdLegalStatStatus_ARRAY().getSzCdLegalStatStatus(i432).compareTo(ADOPT_CONSUMM)) || (0 == pCMSC54DOutputRec.getSzCdLegalStatStatus_ARRAY().getSzCdLegalStatStatus(i432).compareTo(CHILD_EMAN)) || (0 == pCMSC54DOutputRec.getSzCdLegalStatStatus_ARRAY().getSzCdLegalStatStatus(i432).compareTo(PRS_RESP_TERM)) || (0 == pCMSC54DOutputRec.getSzCdLegalStatStatus_ARRAY().getSzCdLegalStatStatus(i432).compareTo(CVS_NOT_OBT))) {
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DUP_TERM_LEG_STAT;
                                
                                
                                //  Set RetVal to FND_FAILURE
                                RetVal = FND_FAILURE;
                            }
                            else {
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CHD_FRST_TERM_LEG_STAT;
                        
                        
                        //  Set RetVal to FND_FAILURE
                        RetVal = FND_FAILURE;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        //  Set RetVal to FND_FAILURE
                        RetVal = FND_FAILURE;
                        break;
                }
                if (RetVal == FND_FAILURE) {
                    rc = RetVal;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            // for CINT21D
            pCINT21DInputRec = new CINT21DI();
            
            pCINT21DOutputRec = new CINT21DO();
            pCINT21DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
            pCINT21DInputRec.setUlIdStage(csub46si.getUlIdStage());
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    dtDtStageClose6 = pCINT21DOutputRec.getDtDtStageClose();
                    if (((DateHelper.NULL_DATE != dtDtStageClose6.day) && (DateHelper.NULL_DATE != dtDtStageClose6.month) && (DateHelper.NULL_DATE != dtDtStageClose6.year)) && ((MAX_DATEDAY != dtDtStageClose6.day) && (MAX_DATEMONTH != dtDtStageClose6.month) && (MAX_DATEYEAR != dtDtStageClose6.year))) {
                        //  Compare:  Eff Date must be before or the same as
                        // the Stage Closure Date
                        lStaRC = ARC_UTLCompareDateAndTime((FndInt3date) & csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt() , (char) 0, (FndInt3date) & dtDtStageClose6, (char) 0);
                        if (lStaRC > 0) {
                            RetVal = FND_FAILURE;
                            pServiceStatus.explan_code = Messages.MSG_NO_LS_AFTER_STG_CLOSE;
                            
                            
                            //  Call CSES34D
                            rc = Messages.MSG_NO_LS_AFTER_STG_CLOSE;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        else {
                            RetVal = SUCCESS;
                        }
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
                    //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    
                    
                    // Exit the service function
            }
        }
        if (SUCCESS == RetVal) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            pCCMN06UInputRec.setArchInputStruct(csub46si.getArchInputStruct());
            if (0 != csub46si.getROWCCMN01UIG00().getUlIdEvent()) {
                pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            else {
                pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            pCCMN06UInputRec.setUlIdStage(csub46si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(csub46si.getROWCCMN01UIG00().getSzCdTask());
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
                    pServiceStatus.explan_code = Messages.MSG_SYS_STAGE_CLOSED;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE;
                    break;
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE;
                    break;
                case Messages.MSG_SYS_MULT_INST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAILURE
                    RetVal = FND_FAILURE;
                    break;
            }
        }
        if ((SUCCESS == RetVal) && ((WtcHelperConstants.REQ_FUNC_CD_ADD == csub46si.getArchInputStruct().getCReqFuncCd()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == csub46si.getArchInputStruct().getCReqFuncCd()))) {
            //  Look for the Contacted By Person record in the
            // EVENT_PERSON_LINK table. If it is found ( it should be )
            // save the timestamp in tsLastUpdate3 for later ( save service )
            // update or deletion.
            // Modification made 06/01/95 -- RML.
            if (false == csub46si.getArchInputStruct().getUlSysNbrReserved1()) {
                
                //  Find the match and set the indicator -- This person was a
                // Contactee.
                if (!(csub46si.getSzCdEventStatus_ARRAY().getSzCdEventStatus(STAGE_CLOSURE).compareTo(EVENT_PEND) != 0)) {
                    pCCMN05UInputRec = new CCMN05UI();
                    
                    pCCMN05UOutputRec = new CCMN05UO();
                    pCCMN05UInputRec.setArchInputStruct(csub46si.getArchInputStruct());
                    //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                    // SQL error returned from the DAM.
                    pCCMN05UInputRec.setUlIdEvent(csub46si.getROWCSUB46SIG00().getUlIdEvent());
                    rc = Ccmn05u.InvalidateAprvl(pCCMN05UInputRec, pCCMN05UOutputRec, pServiceStatus);
                    
                    if (WtcHelperConstants.ARC_SUCCESS != rc) {
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    rc = Ccmn35s.CallCCMN62D(csub46si, csub46so, bIndEvent, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    bIndEvent.value = 0;
                }
            }
            
            if (true) {
                // 
                // (BEGIN): Common Function: ccmn01u   Post Event common function
                // 
                //  Allocate memory for Common Function Input and Output Structures
                pCCMN01UInputRec = new CCMN01UI();
                
                pCCMN01UOutputRec = new CCMN01UO();
                pCCMN01UInputRec.setArchInputStruct(csub46si.getArchInputStruct());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub46si.getROWCCMN01UIG00().getUlIdEvent());
                pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub46si.getROWCCMN01UIG00().getTsLastUpdate());
                pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(csub46si.getROWCCMN01UIG00().getDtDtEventOccurred());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub46si.getROWCCMN01UIG00().getUlIdStage());
                pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub46si.getROWCCMN01UIG00().getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub46si.getROWCCMN01UIG00().getSzCdTask());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub46si.getROWCCMN01UIG00().getSzCdEventStatus());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub46si.getROWCCMN01UIG00().getSzCdEventType());
                pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub46si.getROWCCMN01UIG00().getSzTxtEventDescr());
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub46si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getUlIdPerson());
                pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(csub46si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getSzCdScrDataAction());
                
                if (0 == csub46si.getROWCCMN01UIG00().getUlIdEvent()) {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                }
                else {
                    pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                }
                rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        ulIdEvent30 = pCCMN01UOutputRec.getUlIdEvent();
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        pServiceStatus.explan_code = rc;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            if (rc == WtcHelperConstants.SQL_SUCCESS) {
                
                if (0 != csub46si.getROWCCMN01UIG00().getUlIdEvent()) {
                    
                    // 
                    // (BEGIN): Update DAM: cinv43d    ToDo Complete AUD dam: update only
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCINV43DInputRec = new CINV43DI();
                    
                    pCINV43DOutputRec = new CINV43DO();
                    pCINV43DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
                    pCINV43DInputRec.setUlIdEvent(csub46si.getROWCCMN01UIG00().getUlIdEvent());
                    
                    // Call DAM
                    rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
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
                }
                // 
                // (END): Update DAM: cinv43d      ToDo Complete AUD dam: update only
                // 
                else {
                    csub46si.getROWCCMN01UIG00().setUlIdEvent(ulIdEvent30);
                }
                // 
                // (BEGIN): Add/Update AUD DAM: caud05d      Legal Status Generic AUD dam
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCAUD05DInputRec = new CAUD05DI();
                
                pCAUD05DOutputRec = new CAUD05DO();
                pCAUD05DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
                if (0 == csub46si.getROWCSUB46SIG00().getUlIdLegalStatEvent()) {
                    pCAUD05DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                    pCAUD05DInputRec.setUlIdLegalStatEvent(csub46si.getROWCCMN01UIG00().getUlIdEvent());
                }
                else // (0 != pInputMsg->ROWCSUB46SIG00.ulIdLegalStatEvent)
                {
                    pCAUD05DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCAUD05DInputRec.setUlIdLegalStatEvent(csub46si.getROWCSUB46SIG00().getUlIdLegalStatEvent());
                    pCAUD05DInputRec.setTsLastUpdate(csub46si.getROWCSUB46SIG00().getTsLastUpdate());
                }
                pCAUD05DInputRec.setUlIdPerson(csub46si.getROWCSUB46SIG00().getUlIdPerson());
                pCAUD05DInputRec.setSzCdLegalStatCnty(csub46si.getROWCSUB46SIG00().getSzCdLegalStatCnty());
                pCAUD05DInputRec.setSzCdLegalStatStatus(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus());
                pCAUD05DInputRec.setDtDtLegalStatStatusDt(csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt());
                pCAUD05DInputRec.setSzTxtLegalStatCauseNbr(csub46si.getROWCSUB46SIG00().getSzTxtLegalStatCauseNbr());
                pCAUD05DInputRec.setSzTxtLegalStatCourtNbr(csub46si.getROWCSUB46SIG00().getSzTxtLegalStatCourtNbr());
                pCAUD05DInputRec.setSzCdCourtNbr(csub46si.getROWCSUB46SIG00().getSzCdCourtNbr());
                pCAUD05DInputRec.setCIndCsupSend(csub46si.getCIndCsupSend());
                pCAUD05DInputRec.setDtDtLegalStatTMCDismiss(csub46si.getROWCSUB46SIG00().getDtDtLegalStatTMCDismiss());
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                
                //  Start performance timer for service. All performance functions always
                // return success so there is no need to check status.
                rc = caud05dAUDdam(sqlca, pCAUD05DInputRec, pCAUD05DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        if (0 != csub46si.getUlSysIdTodoCfPersCrea()) {
                            // 
                            // (BEGIN): Common Function: csub40u  ToDo common function: from ToDoInfo
                            // 
                            //  Allocate memory for Common Function Input and Output Structures
                            pCSUB40UInputRec = new CSUB40UI();
                            
                            pCSUB40UOutputRec = new CSUB40UO();
                            pCSUB40UInputRec.setArchInputStruct(csub46si.getArchInputStruct());
                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_CODE);
                            
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(csub46si.getUlIdStage());
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(csub46si.getROWCCMN01UIG00().getUlIdEvent());
                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub46si.getROWCSUB46SIG00().getDtDtLegalStatStatusDt());
                            
                            
                            // 
                            // Service Macro Definitions
                            // 
                            
                            // 
                            // Function Prototypes
                            // 
                            
                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub46si.getUlSysIdTodoCfPersCrea());
                            rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        // 
                        // (END): Common Function: csub40u  ToDo common function: from ToDoInfo
                        // 
                        
                        // SIR#3845 - Include the DAM CAUDB8 to update the Person table
                        // for persons with certain legal status (see #defines for this SIR)
                        // to have conservatorship.  Or if they do not have the appropriate
                        // legal status, the person table column for conservatorship is set to
                        // NULL.
                        
                        //  Update the Person Table for Conservatorship status
                        
                        // 
                        // Call the Conservator Update AUD Dam - CAUDB8D
                        // Description - This DAM updates the person guardianship and conservatorship
                        // status on the Person Table.
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUDB8DInputRec = new CAUDB8DI();
                        
                        pCAUDB8DOutputRec = new CAUDB8DO();
                        pCAUDB8DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
                        if (!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(CARE_CUST_CNTL) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(TMC) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(PMC_RTS_NOT_TERM) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(PMC_RTS_TERM) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(PMC_RTS_TERM_BIO) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(PMC_RTS_TERM_LEG) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(PMC_RTS_TERM_MOTHER) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(OTHER_LEGAL) != 0) ||!(csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(POSS_CONSERVATOR) != 0)) {
                            
                            pCAUDB8DInputRec.setSzCdPersGuardCnsrv(CONSERV_STATUS);
                            pCAUDB8DInputRec.setUlIdPerson(csub46si.getROWCSUB46SIG00().getUlIdPerson());
                        }
                        
                        
                        else {
                            pCAUDB8DInputRec.setSzCdPersGuardCnsrv(null);
                            
                            pCAUDB8DInputRec.setUlIdPerson(csub46si.getROWCSUB46SIG00().getUlIdPerson());
                        }
                        pCAUDB8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                        rc = caudb8dAUDdam(sqlca, pCAUDB8DInputRec, pCAUDB8DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_DATABASE_SAVE_FAIL;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        
                        
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        // 
                        // SIR 1847: Added DAM CLSC59D to retrieve the ID_STAGE of the 
                        // Investigation Stage for the Case.  This Investigation ID_STAGE
                        // should be passed to the DAM which retrieves Overall Disposition
                        // based on program.
                        // 
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        pServiceStatus.explan_code = rc;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                if (WtcHelperConstants.REQ_FUNC_CD_ADD == csub46si.getArchInputStruct().getCReqFuncCd() && 0 == csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(ADOPT_CONSUMM)) {
                    rc = updateOpenSlots(csub46si, csub46so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        /**************************************************************************
        ** (END): Add/Update AUD DAM: caud05d     ** Legal Status Generic AUD dam
        **************************************************************************/
        
        
        /**************************************************************************
        ** (END): Common Function: ccmn01u  ** Post Event common function
        **************************************************************************/
        
        else if (SUCCESS == RetVal) {
            // 
            // (BEGIN): Delete DAM: caud05d      Legal Status Generic AUD dam
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCAUD05DInputRec = new CAUD05DI();
            
            pCAUD05DOutputRec = new CAUD05DO();
            
            // ochumd Sir22779 added ccmni0d.pc to retrieve NmResource
            pCAUD05DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
            pCAUD05DInputRec.getArchInputStruct().setCReqFuncCd(csub46si.getArchInputStruct().getCReqFuncCd());
            pCAUD05DInputRec.setUlIdLegalStatEvent(csub46si.getROWCSUB46SIG00().getUlIdLegalStatEvent());
            
            //  SIR 3207: Added the following two DAMS to retrieve Stage or Case Name.
            pCAUD05DInputRec.setTsLastUpdate(csub46si.getROWCSUB46SIG00().getTsLastUpdate());
            
            // 
            // SIR 1847: Added DAM CLSC59D to retrieve the ID_STAGE of the 
            // Investigation Stage for the Case.  This Investigation ID_STAGE
            // should be passed to the DAM which retrieves Overall Disposition
            // based on program.
            // 
            rc = caud05dAUDdam(sqlca, pCAUD05DInputRec, pCAUD05DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // 
                    // (BEGIN): Delete DAM: caud07d      Stored Procedure: Complex Delete
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD07DInputRec = new CAUD07DI();
                    
                    pCAUD07DOutputRec = new CAUD07DO();
                    pCAUD07DInputRec.setArchInputStruct(csub46si.getArchInputStruct());
                    pCAUD07DInputRec.setUlIdEvent(csub46si.getROWCCMN01UIG00().getUlIdEvent());
                    
                    pCAUD07DInputRec.setTsLastUpdate(csub46si.getROWCCMN01UIG00().getTsLastUpdate());
                    rc = caud07dAUDdam(sqlca, pCAUD07DInputRec, pCAUD07DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            
            if (WtcHelperConstants.REQ_FUNC_CD_DELETE == csub46si.getArchInputStruct().getCReqFuncCd() && 0 == csub46si.getROWCSUB46SIG00().getSzCdLegalStatStatus().compareTo(ADOPT_CONSUMM)) {
                rc = updateOpenSlots(csub46si, csub46so, pServiceStatus);
                
                //  MHMR Phase III Item 4 (RIOSJA) - Added the following DAM and function
                // to do the following tasks: 1) retrieve all victims (past and present)
                // for the case to be used as potential case names, 2) append "et al" to
                // the victims' names when necessary, and 3) write the names to the window
                // to be viewed by the user.
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub46si.getArchInputStruct() , csub46so.getArchOutputStruct());
        
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
        return csub46so;
    }

    static int CallCCMN62D(CSUB46SI pInputMsg842, CSUB46SO * pOutputMsg787, Pint pbIndEvent, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        /*
        ** Declare local variables
        */
        /* The ARC_SUCCESS initializtion has been added to the following line
        ** so that the logic relevant exiting out of the loop in this function
        ** will work correctly.
        */
        CCMN62DI pCCMN62DInputRec = null;
        CCMN62DO pCCMN62DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setArchInputStruct(pInputMsg842.getArchInputStruct());
        if (pbIndEvent.value) {
            pCCMN62DInputRec.setUlIdEvent(pInputMsg842.getROWCSUB46SIG00().getUlIdEvent());
            pCCMN62DInputRec.setSzCdEventStatus("COMP");
        }
        
        else {
            pCCMN62DInputRec.setUlIdEvent(pInputMsg842.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN62DInputRec.setSzCdEventStatus(pInputMsg842.getROWCCMN01UIG00().getSzCdEventStatus());
        }
        pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd(UPDATE);
        rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
        
        /*
        ** Set service status fields appropriately
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int updateOpenSlots(CSUB46SI pInputMsg843, CSUB46SO * pOutputMsg788, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        String PRIV_AGENCY_ADPT_HOME1 = "71";
        String FPS_FA_HOME1 = "70";
        CMSC16DI pCMSC16DInputRec = null;/* Update NBR_RSRC_OPEN_SLOTS */
        
        CMSC16DO pCMSC16DOutputRec = null;
        CSES28DI pCSES28DInputRec = null;/* retrieve placement and */
        CSES28DO pCSES28DOutputRec = null;/* resource info */
        
        
        /* First take the person id and get the most recent placement
        ** and the facility type */
        pCSES28DInputRec = new CSES28DI();
        
        pCSES28DOutputRec = new CSES28DO();
        pCSES28DInputRec.setArchInputStruct(pInputMsg843.getArchInputStruct());
        pCSES28DInputRec.setUlIdPerson(pInputMsg843.getROWCSUB46SIG00().getUlIdPerson());
        rc = cses28dQUERYdam(sqlca, pCSES28DInputRec, pCSES28DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CMSC20D to select list of sums of Qty and fee paid
                rc = WtcHelperConstants.ARC_SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                if (FPS_FA_HOME1.equals(pCSES28DOutputRec.getSzCdRsrcFacilType()) || PRIV_AGENCY_ADPT_HOME1.equals(pCSES28DOutputRec.getSzCdRsrcFacilType())) {
                    //  Allocate memory for DAM Input and Output Structures
                    pCMSC16DInputRec = new CMSC16DI();
                    
                    pCMSC16DOutputRec = new CMSC16DO();
                    pCMSC16DInputRec.setArchInputStruct(pInputMsg843.getArchInputStruct());
                    pCMSC16DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCMSC16DInputRec.setUlIdResource(pCSES28DOutputRec.getUlIdRsrcFacil());
                    
                    if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg843.getArchInputStruct().getCReqFuncCd()) {
                        pCMSC16DInputRec.setSNbrRsrcOpenSlots(1);
                        
                    }
                    else if (WtcHelperConstants.REQ_FUNC_CD_DELETE == pInputMsg843.getArchInputStruct().getCReqFuncCd()) {
                        pCMSC16DInputRec.setSNbrRsrcOpenSlots( - 1);
                    }
                    rc = cmsc16dAUDdam(sqlca, pCMSC16DInputRec, pCMSC16DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            
                            break;
                    }
                }
            case NO_DATA_FOUND:
                
                
                //  Call CLSS39D to retrieve a full row by ID_INVOICE
                rc = WtcHelperConstants.ARC_SUCCESS;
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

}
