package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN86SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN86SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDB5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDB5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDF0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDF0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDF1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDF1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH3DO;
/**************************************************************************
** 
** Module File:   CCMN86S.src
**
** Service Name:  CCMN86S
**
** Description:   Saves New Name to NM_CASE of CAPS CASE table and
**                to NM STAGE all stages of the STAGE table (except subcare)
**                if current stage is not Subcare. If the current
**                stage is Subcare, save the new name only
**                to the Subcare stage.
**                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  March 2, 1995 
** 
** Programmer:    Matthew Fish
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  6/28/95     RMR     Final unit test clean up. 
**
**  10/15/95    RMR     SIR 1816 - Must post an event for each stage whose
**                      name is updated.
**
**  10/23/95    KRD     SIR 1816 - Should only post the event for the stage
**                      whose ID STAGE is passed into the service.  As a
**                      result the code to post the event has been moved from
**                      CallCCMNE1D() to the main service function.
**
**  10/30/95  ELLIOTSL  ERR #1991: If there is a ToDo then the user navigated 
**                      from staff todo list (CCMN30W) or case todo list 
**                      (CCMN31W).  The todo needs to be marked as completed.  
**                      If there is no todo then no action will be taken. 
** 
**  01/17/96  FELLERDL  SIR 2680 If the current stage IS Subcare, do NOT 
**                      change the case name.  Code was moved to else 
**                      statement only.  Also, code added to create Stage 
**                      name change on the events list for non-SUBcare stages.
**
**  01/18/96  GUARRICR  SIR#2426  Added CheckStageEventStatus common 
**                      function.
**
**  01/26/96  MATTESJM  SIR#2078 Added code to update the Caps_Resource 
**                      table and set Nm_Resource to the New Name which is
**                      changed via "Change Case Name" Task on the FAD task
**                      list.  The corresponding Resource Name must be 
**                      updated in addition to the Name of the Stage and Case.
**
**  04/17/96  OVERENTR  SIR #20478 - Added the adoption stage, PAL stage, and
**                      the post adopt stage to the list of child specific
**                      stages (which only included sub care before this sir)
**                      that only update the stage name as opposed to the 
**                      case name and all corresponding stage names excluding
**                      those that are child specific.  
**  8/9/96    MAXHAMKJ  PERF SIR 10379: Removed extraneous malloc 
**                      of PostIn/Out structures to prevent
**                      server getting killed and service timeout.
**
** 12/9/96    VANDERM   SIR 12862 - Moved free statements for input and
**                      output records for dam caudb5d inside of the if
**                      statement from which the memory is allocated.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
**  06/13/03   Srini    SIR#17827 - Made the service transaction aware.
**
**	06/30/03  Srini		SIR 18602 - Modified to fix error handling for 
**						transaction aware code
**
**  07/10/03  Srini     SIR 18602 - More changes. Changed all PROCESS_TUX_RC_ERROR calls to
**						PROCESS_TUX_RC_ERROR_TRANSACT and PROCESS_TUX_SQL_ERROR calls to 
**						PROCESS_TUX_SQL_ERROR_TRANSACT calls.
**
**  03/29/04   Ochumd   SIR 22646 - IMPACT: To satisfy the requirments set out
**                      in the sir, two new dams have been added to this service.
**                      (CAUDF0D and CAUDF1D) CAUDF0D is designed to search through
**                      the stage_person_link table for a stage name indicator given
**                      a stage id.  If one is found/or not, set it to null and call 
**                      CAUDF1D to set a new indicator for the person id selected.
**
**
**  06/25/04   ochumd   Sir# 22852 The situation:  A New Person is 
**                      added to the Person List for an INV, FPR, FSU,  or FRE stage.
**			When you attempt to chosse this new person as the new Case Name, 
**			when you click Save, you get an error message "SQL did not return any rows.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn86s {
    
    /**************************************************************************
    ** Global variables
    ***************************************************************************/
    public static final String SUBCARE_STAGE = "SUB";
    public static final String ADOPTION_STAGE = "ADO";
    public static final String PAL_STAGE = "PAL";
    public static final String POST_ADOPT_STAGE = "PAD";
    
    /*
    ** SIR#2078 CdStage needed to update Caps_Resource
    */
    public static final String CD_STAGE_FAD = "FAD";
    
    /*
    ** SIR 1816 - macros needed for the event to be posted
    */
    public static final String COMPLETE = "COMP";
    public static final String CASE_GENERAL = "CAS";
    public static final String TXT_NAME_CHANGE = "Case name change: ";
    public static final String TXT_TO = " to ";
    
    /*
    ** SIR 2426 - Define Null String for use in comparison
    */
    public static final String NULL_STRING = "";
    
    /**************************************************************************
    ** Service Function
    ***************************************************************************/
    
    /**************************************************************************
    **
    ** Function Name:  CINV29S
    **
    ** Description:    Main Service Function
    **
    ***************************************************************************/
    static CCMN86SI pInputMsg = null;
    static CCMN86SO pOutputMsg = null;
    static int transactionflag = - 1;
    CCMN86SO CCMN86S(CCMN86SI ccmn86si) {
        CCMN86SO ccmn86so = new CCMN86SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        // Need to check if the transaction is already in progress as this service is called
        // from another service.
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        /* 01/22/2003 DWW: Added for error handling */
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCMN86S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            
        }
        
        /*
        ** SIR 2680 DLF  If the current stage IS Subcare, 
        ** do NOT change the case name.  Code was moved
        ** to else statement only.
        */
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCMN86S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCMN86S\n");
            bTransactionStarted = true;
        }
        int RetVal = SUCCESS;/* SIR#2426 */
        CCMN06UI pCCMN06UInputRec = null;/* Check Stage/Event common Function */
        
        CCMN06UO pCCMN06UOutputRec = null;
        CINV81DI pCINV81DInputRec = null;/* SIR#2078 */
        CINV81DO pCINV81DOutputRec = null;/* SIR#2078 */
        CAUDB5DI pCAUDB5DInputRec = null;/* SIR#2078 */
        CAUDB5DO pCAUDB5DOutputRec = null;/* SIR#2078 */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        
        /*
        ** SIR 1816 - declare input/output structures for the PostEvent
        ** common function
        */
        CCMN01UI pPostEventIn = null;
        CCMN01UO pPostEventOut = null;
        
        rc = ARC_PRFServiceStartTime_TUX(ccmn86si.getArchInputStruct());
        //Modified to check for the transaction and commit only if it is started locally.
        //  TUX_CHECK_APPL_STATUS
        if (ccmn86si.getUlIdStage() != 0) {
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            
            pCCMN06UInputRec.setArchInputStruct(ccmn86si.getArchInputStruct());
            
            //  SIR 1209 - prototype for call to DAM CINT58D
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCCMN06UInputRec.setUlIdStage(ccmn86si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(ccmn86si.getSzCdTask());
            rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
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
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        //Commit only if we began the transaction in this service
        if (SUCCESS == RetVal) {
            if ((ccmn86si.getSzCdStage().equals(SUBCARE_STAGE)) || (ccmn86si.getSzCdStage().equals(PAL_STAGE)) || (ccmn86si.getSzCdStage().equals(ADOPTION_STAGE)) || (ccmn86si.getSzCdStage().equals(POST_ADOPT_STAGE))) {
                rc = CallCCMND8D(ccmn86si, ccmn86so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                rc = CallCAUDF0D(ccmn86si, ccmn86so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                if (0 != ccmn86si.getUlIdNmPerson()) {
                    rc = CallCAUDF1D(ccmn86si, ccmn86so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
            else {
                
                // Call INCOMING ADDRESS query DAM.
                rc = CallCCMN14D(ccmn86si, ccmn86so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                
                //  Start the code needed to post the event of the change to
                // case name
                
                //  allocate memory for Post Event Input and Output Structures
                pPostEventIn = new CCMN01UI();
                
                pPostEventOut = new CCMN01UO();
                pPostEventIn.setArchInputStruct(ccmn86si.getArchInputStruct());
                pPostEventIn.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                rc = ARC_UTLGetDateAndTime(pPostEventIn.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pPostEventIn.getROWCCMN01UIG00().setSzCdEventStatus(COMPLETE);
                pPostEventIn.getROWCCMN01UIG00().setSzCdEventType(CASE_GENERAL);
                pPostEventIn.getROWCCMN01UIG00().setUlIdPerson(ccmn86si.getUlIdPerson());
                pPostEventIn.getROWCCMN01UIG00().setUlIdStage(ccmn86si.getUlIdStage());
                pPostEventIn.getROWCCMN01UIG00().setSzTxtEventDescr("Case name change: ");
                strncat(pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr() , ccmn86si.getSzNmCase_ARRAY().getSzNmCase(1) , sizeof () - pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr().length());
                strncat(pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr() , TXT_TO, sizeof () - pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr().length());
                strncat(pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr() , ccmn86si.getSzNmCase_ARRAY().getSzNmCase(0) , sizeof () - pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr().length());
                rc = Ccmn01u.PostEvent(pPostEventIn, pPostEventOut, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                rc = CallCCMNE1D(ccmn86si, ccmn86so, pServiceStatus);
                
                // 
                // Function Prototypes
                // 
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                
                pPostEventIn.setArchInputStruct(ccmn86si.getArchInputStruct());
                pPostEventIn.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                rc = ARC_UTLGetDateAndTime(pPostEventIn.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                pPostEventIn.getROWCCMN01UIG00().setSzCdEventStatus(COMPLETE);
                
                
                pPostEventIn.getROWCCMN01UIG00().setSzCdEventType(CASE_GENERAL);
                pPostEventIn.getROWCCMN01UIG00().setUlIdPerson(ccmn86si.getUlIdPerson());
                pPostEventIn.getROWCCMN01UIG00().setUlIdStage(ccmn86si.getUlIdStage());
                
                pPostEventIn.getROWCCMN01UIG00().setSzTxtEventDescr("Stage name change: ");
                strncat(pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr() , ccmn86si.getSzNmCase_ARRAY().getSzNmCase(1) , sizeof () - pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr().length());
                strncat(pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr() , TXT_TO, sizeof () - pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr().length());
                strncat(pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr() , ccmn86si.getSzNmCase_ARRAY().getSzNmCase(0) , sizeof () - pPostEventIn.getROWCCMN01UIG00().getSzTxtEventDescr().length());
                rc = Ccmn01u.PostEvent(pPostEventIn, pPostEventOut, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                if (ccmn86si.getLdIdTodo() != 0) {
                    rc = Cint21s.CallCMNH3D(ccmn86si, ccmn86so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                if (0 == CD_STAGE_FAD.compareTo(ccmn86si.getSzCdStage())) {
                    //  Special change name processing for FAD cases
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCINV81DInputRec = new CINV81DI();
                    
                    pCINV81DOutputRec = new CINV81DO();
                    
                    pCINV81DInputRec.setArchInputStruct(ccmn86si.getArchInputStruct());
                    pCINV81DInputRec.setUlIdPerson(ccmn86si.getUlIdPerson());
                    rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;
                    }
                    
                    if (WtcHelperConstants.SQL_SUCCESS == rc) {
                        //  Update the New Name on the Caps_resource table
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCAUDB5DInputRec = new CAUDB5DI();
                        
                        pCAUDB5DOutputRec = new CAUDB5DO();
                        
                        pCAUDB5DInputRec.setArchInputStruct(ccmn86si.getArchInputStruct());
                        pCAUDB5DInputRec.getArchInputStruct().setCReqFuncCd(ccmn86si.getArchInputStruct().getCReqFuncCd());
                        pCAUDB5DInputRec.setSzNmResource(ccmn86si.getSzNmCase_ARRAY().getSzNmCase(0));
                        pCAUDB5DInputRec.setSzNmRsrcLastUpdate(pCINV81DOutputRec.getSzNmPersonFull());
                        pCAUDB5DInputRec.setUlIdRsrcFaHomeStage(ccmn86si.getUlIdStage());
                        rc = caudb5dAUDdam(sqlca, pCAUDB5DInputRec, pCAUDB5DOutputRec);
                        
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                    }
                }
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn86si.getArchInputStruct() , ccmn86so.getArchOutputStruct());
        
        
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCMN86S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            //SIR 18602
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCMN86S\n");
        }
        return ccmn86so;
    }

    static int CallCCMN14D(CCMN86SI pInputMsg365, CCMN86SO * pOutputMsg335, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN14DI pCCMN14DInputRec = null;
        CCMN14DO pCCMN14DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN14DInputRec = new CCMN14DI();
        pCCMN14DOutputRec = new CCMN14DO();
        pCCMN14DInputRec.setUlIdCase(pInputMsg365.getUlIdCase());
        pCCMN14DInputRec.setSzNmCase(pInputMsg365.getSzNmCase_ARRAY().getSzNmCase(0));
        pCCMN14DInputRec.setArchInputStruct(pInputMsg365.getArchInputStruct());
        rc = ccmn14dAUDdam(sqlca, pCCMN14DInputRec, pCCMN14DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                break;
        }
        return rc;
    }

    static int CallCCMNE1D(CCMN86SI pInputMsg366, CCMN86SO * pOutputMsg336, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        char subcare_stage = '\u0000';/* Checks status of CD_STAGE */
        int rc = WtcHelperConstants.ARC_SUCCESS;
        int i179 = 0;
        
        /*
        ** Declare local variables
        */
        CCMNE1DI pCCMNE1DInputRec = null;
        CCMNE1DO pCCMNE1DOutputRec = null;
        
        CCMND8DI pCCMND8DInputRec = null;
        CCMND8DO pCCMND8DOutputRec = null;
        CAUDF0DI pCAUDF0DInputRec = null;
        CAUDF0DO pCAUDF0DOutputRec = null;
        CAUDF1DI pCAUDF1DInputRec = null;
        CAUDF1DO pCAUDF1DOutputRec = null;
        
        String CURRENT_CD_STAGE = new String();
        
        // 01/17/03  Srini D Commenting the writing of info to file.   
        //   FILE *fp1;
        //   fp1 = fopen("12862a.txt","w");  /* sir 12862 */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE1DInputRec = new CCMNE1DI();
        pCCMNE1DOutputRec = new CCMNE1DO();
        
        pCCMND8DInputRec = new CCMND8DI();
        pCCMND8DOutputRec = new CCMND8DO();
        pCCMNE1DInputRec.setUlIdCase(pInputMsg366.getUlIdCase());
        pCCMNE1DInputRec.setArchInputStruct(pInputMsg366.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = ccmne1dQUERYdam(sqlca, pCCMNE1DInputRec, pCCMNE1DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                for (i179 = 0;(i179 < pCCMNE1DOutputRec.getArchOutputStruct().getUlRowQty());i179++) {
                    subcare_stage = 0;
                    if ((pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(SUBCARE_STAGE)) || (pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(PAL_STAGE)) || (pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(ADOPTION_STAGE)) || (pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(POST_ADOPT_STAGE))) {
                        subcare_stage = 1;
                    }
                    if (!subcare_stage) {
                        pCCMND8DInputRec.setUlIdStage(pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getUlIdStage());
                        pCCMND8DInputRec.setSzNmCase(pInputMsg366.getSzNmCase_ARRAY().getSzNmCase(0));
                        pCCMND8DInputRec.setArchInputStruct(pInputMsg366.getArchInputStruct());
                        
                        //  Call DAM
                        rc = ccmnd8dAUDdam(sqlca, pCCMND8DInputRec, pCCMND8DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                                break;
                        }
                    }
                }
                // 
                // (END): Retrieve DAM: ccmn44d     
                // Get NmPersonFull given IdPerson
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        /* ochu   */
        for (i179 = 0;(i179 < pCCMNE1DOutputRec.getArchOutputStruct().getUlRowQty());i179++) {
            
            subcare_stage = 0;
            
            //  Analyze error code
            if ((pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(SUBCARE_STAGE)) || (pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(PAL_STAGE)) || (pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(ADOPTION_STAGE)) || (pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getSzCdStage().equals(POST_ADOPT_STAGE))) {
                subcare_stage = 1;
                
            }
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if (!subcare_stage) {
                // Allocate memory for Input and Output Structures.
                pCAUDF0DInputRec = new CAUDF0DI();
                pCAUDF0DOutputRec = new CAUDF0DO();
                if (pCAUDF0DInputRec == (CAUDF0DI) 0 || pCAUDF0DOutputRec == (CAUDF0DO) 0) {
                    rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                pCAUDF0DInputRec.setUlIdStage(pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getUlIdStage());
                rc = caudf0dAUDdam(sqlca, pCAUDF0DInputRec, pCAUDF0DOutputRec);
                switch (rc) {
                    case SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                        break;
                }
                if (0 != pInputMsg366.getUlIdNmPerson()) {
                    //  if the facility type is a non-PRS home and the placement type
                    // is prs f/a home, return an error
                    // otherwise continue
                    
                    // 
                    // (END): CRES04D - full row retrieve (to get the Facility Type)
                    // 
                    
                    
                    
                    // Allocate memory for Input and Output Structures.
                    pCAUDF1DInputRec = new CAUDF1DI();
                    pCAUDF1DOutputRec = new CAUDF1DO();
                    if (pCAUDF1DInputRec == (CAUDF1DI) 0 || pCAUDF1DOutputRec == (CAUDF1DO) 0) {
                        rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                    pCAUDF1DInputRec.setUlIdStage(pCCMNE1DOutputRec.getROWCCMNE1DO_ARRAY().getROWCCMNE1DO(i179).getUlIdStage());
                    pCAUDF1DInputRec.setUlIdPerson(pInputMsg366.getUlIdNmPerson());
                    rc = caudf1dAUDdam(sqlca, pCAUDF1DInputRec, pCAUDF1DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            rc = SUCCESS;
                            break;// break for success of CINV51D (VC)
                            // /*
                            // CASE SQL_NOT_FOUND for CINV51D (VC)
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                            break;// break for success of CCMN44
                    }
                    //  If the placement type is Contracted and the
                    // szCdRsrcLinkType is Child Placing Agency (CPA)
                    // call CRES04 to do a full row retrieval from the
                    // CAPS_RESOURCE table to obtain the Agency Name.
                    // 3/12/96: The Placing Agency needs to be
                    // returned for JUV_PROB and TYC.
                    // SIR 14938:  Added PACE to the above scenario.
                    
                }
            }
        }
        return rc;
    }

    static int CallCCMND8D(CCMN86SI pInputMsg367, CCMN86SO * pOutputMsg337, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i180 = 0;
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMND8DI pCCMND8DInputRec = null;
        CCMND8DO pCCMND8DOutputRec = null;
        CCMN01UI pInput = null;
        CCMN01UO pOutput = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND8DInputRec = new CCMND8DI();
        pCCMND8DOutputRec = new CCMND8DO();
        
        /* allocate memory for Post Event Input and Output Structures */
        pInput = new CCMN01UI();
        
        pOutput = new CCMN01UO();
        pInput.setArchInputStruct(pInputMsg367.getArchInputStruct());
        pInput.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pInput.getROWCCMN01UIG00().setSzCdEventStatus(COMPLETE);
        
        pInput.getROWCCMN01UIG00().setSzCdEventType(CASE_GENERAL);
        ARC_UTLGetDateAndTime(pInput.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pInput.getROWCCMN01UIG00().setUlIdStage(pInputMsg367.getUlIdStage());
        pInput.getROWCCMN01UIG00().setUlIdPerson(pInputMsg367.getUlIdPerson());
        pInput.getROWCCMN01UIG00().setSzTxtEventDescr("Stage name change: ");
        pInput.getROWCCMN01UIG00().getSzTxtEventDescr() += pInputMsg367.getSzNmCase_ARRAY().getSzNmCase(1) + " to " + pInputMsg367.getSzNmCase_ARRAY().getSzNmCase(0);
        rc = Ccmn01u.PostEvent(pInput, pOutput, pServiceStatus);
        
        //## BEGIN TUX/XML: Declare XML variables 
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        pCCMND8DInputRec.setUlIdStage(pInputMsg367.getUlIdStage());
        pCCMND8DInputRec.setSzNmCase(pInputMsg367.getSzNmCase_ARRAY().getSzNmCase(0));
        pCCMND8DInputRec.setArchInputStruct(pInputMsg367.getArchInputStruct());
        rc = ccmnd8dAUDdam(sqlca, pCCMND8DInputRec, pCCMND8DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        
        return rc;
    }

    static int CallCMNH3D(CCMN86SI pInputMsg368, CCMN86SO * pOutputMsg338, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMNH3DI pCCMNH3DI = null;
        CCMNH3DO pCCMNH3DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCCMNH3DI = new CCMNH3DI();
        pCCMNH3DO = new CCMNH3DO();
        
        if (pCCMNH3DI == (CCMNH3DI) 0 || pCCMNH3DO == (CCMNH3DO) 0) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCCMNH3DI.setLdIdTodo(pInputMsg368.getLdIdTodo());
        
        /* get the Educations from educational_history table for person_forward */
        rc = ccmnh3dAUDdam(sqlca, pCCMNH3DI, pCCMNH3DO);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                
                
                break;
        }
        
        return rc;
    }

    static int CallCAUDF0D(CCMN86SI pInputMsg369, CCMN86SO * pOutputMsg339, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CAUDF0DI pCAUDF0DI = null;
        CAUDF0DO pCAUDF0DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCAUDF0DI = new CAUDF0DI();
        pCAUDF0DO = new CAUDF0DO();
        
        /*
        ** SIR 3970
        ** ulIdSendPalFollowUp should be validated against TRUE
        ** not INDICATOR_YES
        */
        
        if (pCAUDF0DI == (CAUDF0DI) 0 || pCAUDF0DO == (CAUDF0DO) 0) /*
        ** IMPACT END
        */
        {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCAUDF0DI.setUlIdStage(pInputMsg369.getUlIdStage());
        rc = caudf0dAUDdam(sqlca, pCAUDF0DI, pCAUDF0DO);
        switch (rc) {
            case SUCCESS:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        
        /* 14113 */
        
        if (pCAUDF0DO != null) {
            
        }
        return rc;
    }

    static int CallCAUDF1D(CCMN86SI pInputMsg370, CCMN86SO * pOutputMsg340, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CAUDF1DI pCAUDF1DI = null;
        CAUDF1DO pCAUDF1DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCAUDF1DI = new CAUDF1DI();
        pCAUDF1DO = new CAUDF1DO();
        
        if (pCAUDF1DI == (CAUDF1DI) 0 || pCAUDF1DO == (CAUDF1DO) 0) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        pCAUDF1DI.setUlIdStage(pInputMsg370.getUlIdStage());
        pCAUDF1DI.setUlIdPerson(pInputMsg370.getUlIdNmPerson());
        rc = caudf1dAUDdam(sqlca, /* DAM name should be in lower case */
        pCAUDF1DI, pCAUDF1DO);
        switch (rc) {
            case SUCCESS:
                break;
                
            default :
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                break;
        }
        
        
        if (pCAUDF1DO != null) {
            
        }
        return rc;
    }

}
