package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS14DO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Cinv05s;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT77DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN89DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN89DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN90DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN90DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT07DO;
/***********************************************************************
** 
** Module File:   CCMN13S.src
**
** Service Name:  CCMN13S
**
** Description:   This service will retrieve the user's supervisor if the 
**                ReqFuncCd is REQ_FUNC_CD_APPROVAL, or it will get the 
**                NM STAGE, NM TASK, TASK DUE DT, PRIMARY WORKER of STAGE
**                if the ReqFuncCd is REQ_FUNC_CD_ASSIGN, or it will get the
**                information related to the ID TODO specified.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/14/94 
** 
** Programmer:    Limin Zhang 
**
**  02/21/95  FOGARTIS  SIR#60 - Task Due Date population no longer based
**                      upon Nbr Days Due on Task Table. Task Due date is
**                      pulled from the Todo Table itself.
**  03/01/95  FOGARTIS  SIR#59 - Reworked Service Error Handling. Handling
**                      of previously deleted to-do added.
**  03/29/95  FOGARTIS  SIR#419 - Modified handling of Case related non
**                      task related todo creation. Dam 82 execution made
**                      to occur under Assign scenerio (from task list)
**                      only if task is related. Dam 82 loads task decode.
**  05/24/95  RUSSELRM  Final Unit test clean up. 
**
**  12/28/95  BRUCKMK   SIR 2217: Added DAM CINT21D to retrieve szCdStage, 
**                      since I&R & SPC intakes do not have a stage name, 
**                      which kills ccmn19d.   
**
**  12/29/95  BRUCKMK   SIR 2427: When trying to add another approver to an 
**                      I&R intake or SPC intake, an internal error occurs, 
**                      because these intakes do not have a stage name or
**                      a row in the stage person link table.  Therefore, 
**                      CINT21D is called prior to calling ccmn19d, in 
**                      order to check the CdStage prior to calling ccmn19d.
**                                                                          
**  01/18/96  BRUCKMK   SIR 2657:  Added DAM CINT07D to Retrieve 
**                      CD_INCMG_STATUS from the Incoming Detail table if the
**                      CD_STAGE is INT (Intake).  
**                      If the STATUS is MFD (Marked for Deletion), it is OK 
**                      not to find a primary worker and to ignore this SQL 
**                      not found error in the DAM CCMN19D.  
**  7/26/96    zabihin  sir 21891 : version control code was missing, I 
**                      added the lines.
**
**  02/18/97  odonnerj  SIR# 10717 - Added Switch and case 
**                      MSG_NO_TASK_AVAIL_SAVE_INT_NOW  after call to 
**                      cint21d. In certain cases, (Alt F4) an Intake may
**                      have no data on the stage table, but worker can open 
**                      the Intake through the task list and try to click
**                      on the Todo Pushbutton. When this happens, we need 
**                      the Intake re-opened so that it can be saved properly.
** 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn13s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String I_AND_R = "I&R";
    public static final String SPC_REQ = "SPC";
    public static final String INTAKE = "INT";
    public static final String MARKED_FOR_DELETION = "MFD";
    public static final String NULL_STRING = "";
    CCMN13SO CCMN13S(CCMN13SI ccmn13si) {
        CCMN13SO ccmn13so = new CCMN13SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables 
        */
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        String szCdStage1 = new String();
        String cdIncmgStatus1 = new String();
        rc = ARC_PRFServiceStartTime_TUX(ccmn13si.getArchInputStruct());
        
        /*
        ** Victim
        **
        ** Get # of times the victim was named as a victim and
        ** the number of times the perp was named as a victim
        ** in other allegations within this stage, other than
        ** the allegation being deleted. Counts will be stored
        ** in ulIdVictim and ulIdAllegedPerpetrator, respectively,
        ** (they have the right data type) then reset before
        ** exiting the service.
        */
        rc = ARC_UTLGetDateAndTime(ccmn13so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        ccmn13so.getTaskStruct().getDtDtTaskDue().month = DateHelper.NULL_DATE;
        ccmn13so.getTaskStruct().getDtDtTaskDue().day = DateHelper.NULL_DATE;
        ccmn13so.getTaskStruct().getDtDtTaskDue().year = DateHelper.NULL_DATE;
        cdIncmgStatus1 = NULL_STRING;
        
        /*
        ** Analyze return code
        */
        switch (ccmn13si.getArchInputStruct().getCReqFuncCd()) {
                
            case WINDOW_MODE_NEW_APPRV:
            case WINDOW_MODE_NEXT_APPRV:
                
                //  Perp
                // Same as above for perp - # of times victim was named
                // as a perp and # of times perp was named as a perp
                // in other allegations in the stage.
                rc = CallCCMN89D(ccmn13si, ccmn13so, pServiceStatus);
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                // Update victim's and perp's role in STAGE_PERSON_LINK.
                rc = Ccmn19s.CallCCMN82D(ccmn13si, ccmn13so, pServiceStatus);
                
                //## BEGIN TUX/XML: Declare XML variables
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                //  11/14/2002 DWW - added next two lines to make service
                // return an error code if this case is reached
                rc = Cinv29s.CallCINT21D(ccmn13si, ccmn13so, szCdStage1, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                if ((0 != szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(I_AND_R.substring(0, CSYS14DO.CD_STAGE_LEN))) && (0 != szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(SPC_REQ.substring(0, CSYS14DO.CD_STAGE_LEN)))) {
                    
                    if (0 == szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(INTAKE.substring(0, CSYS14DO.CD_STAGE_LEN))) {
                        //  ERR#1797 Determine if duplicates exist before saving row
                        // to the Allegation List.
                        rc = Cinv05s.CallCINT07D(ccmn13si, ccmn13so, cdIncmgStatus1, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    // replaced this line:
                    // bOKDuplicates = FALSE;
                    // with the following two lines so that the service functions more
                    // like a normal service, in that it returns when there is an error
                    rc = CallCCMN19D(ccmn13si, ccmn13so, cdIncmgStatus1, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
                
            case WINDOW_MODE_ASSIGN:
                
                if (ccmn13si.getTodoCaseInfStruct().getSzCdTask()[0] != null) {
                    rc = Ccmn19s.CallCCMN82D(ccmn13si, ccmn13so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                rc = Cinv29s.CallCINT21D(ccmn13si, ccmn13so, szCdStage1, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                if ((0 != szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(I_AND_R.substring(0, CSYS14DO.CD_STAGE_LEN))) && (0 != szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(SPC_REQ.substring(0, CSYS14DO.CD_STAGE_LEN)))) {
                    if (0 == szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(INTAKE.substring(0, CSYS14DO.CD_STAGE_LEN))) {
                        rc = Cinv05s.CallCINT07D(ccmn13si, ccmn13so, cdIncmgStatus1, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    
                    // Update intermediate roles.
                    rc = CallCCMN19D(ccmn13si, ccmn13so, cdIncmgStatus1, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
                
            default :
                
                // Allegation Detail AUD
                rc = CallCCMN90D(ccmn13si, ccmn13so, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                    case Messages.MSG_CMN_TODO_DELETED:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                if (ccmn13so.getTaskStruct().getSzCdTask()[0] != null) {
                    ccmn13si.getTodoCaseInfStruct().setSzCdTask(ccmn13so.getTaskStruct().getSzCdTask());
                    
                    rc = Ccmn19s.CallCCMN82D(ccmn13si, ccmn13so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                if (ccmn13so.getStageStruct().getUlIdStage() != 0) {
                    ccmn13si.getTodoCaseInfStruct().setUlIdStage(ccmn13so.getStageStruct().getUlIdStage());
                    // Demote the event status
                    rc = Cinv29s.CallCINT21D(ccmn13si, ccmn13so, szCdStage1, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    if ((0 != szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(I_AND_R.substring(0, CSYS14DO.CD_STAGE_LEN))) && (0 != szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(SPC_REQ.substring(0, CSYS14DO.CD_STAGE_LEN)))) {
                        if (0 == szCdStage1.substring(0, CSYS14DO.CD_STAGE_LEN).compareTo(INTAKE.substring(0, CSYS14DO.CD_STAGE_LEN))) {
                            rc = Cinv05s.CallCINT07D(ccmn13si, ccmn13so, cdIncmgStatus1, pServiceStatus);
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        rc = CallCCMN19D(ccmn13si, ccmn13so, cdIncmgStatus1, pServiceStatus);
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                
                
                //  Get the NM PERSON for the Created and Assigned.
                
                //  Allocate memory for 44 DAM input and output
                pCCMN44DInputRec = new CCMN44DI();
                pCCMN44DOutputRec = new CCMN44DO();
                pCCMN44DInputRec.setUlIdPerson(ccmn13so.getCreatedStruct().getUlIdTodoPersCreator());
                if (pCCMN44DInputRec.getUlIdPerson() != 0) {
                    
                    //  Call the Invalidate function
                    rc = Ccmn03u.CallCCMN44D(pCCMN44DInputRec, pCCMN44DOutputRec, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            ccmn13so.getCreatedStruct().setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                else {
                    ccmn13so.getCreatedStruct().setSzNmPersonFull("System");
                }
                pCCMN44DInputRec.setUlIdPerson(ccmn13so.getAssignedStruct().getUlIdTodoPersAssigned());
                rc = Ccmn03u.CallCCMN44D(pCCMN44DInputRec, pCCMN44DOutputRec, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        ccmn13so.getAssignedStruct().setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn13si.getArchInputStruct() , ccmn13so.getArchOutputStruct());
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
        return ccmn13so;
    }

    static int CallCCMN19D(CCMN13SI pInputMsg230, CCMN13SO pOutputMsg211, String cdIncmgStatus2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i134 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN19DI pCCMN19DInputRec = null;
        CCMN19DO pCCMN19DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN19DInputRec = new CCMN19DI();
        pCCMN19DOutputRec = new CCMN19DO();
        
        /*************************************************************
        ** SIR# 21833 - END.
        *************************************************************/
        
        
        pCCMN19DInputRec.setUlIdStage(pInputMsg230.getTodoCaseInfStruct().getUlIdStage());
        pCCMN19DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
        rc = ccmn19dQUERYdam(sqlca, pCCMN19DInputRec, pCCMN19DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg211.getStageStruct().setSzNmStage(pCCMN19DOutputRec.getSzNmStage());
                
                // Return the return code to the calling routine
                pOutputMsg211.getStageStruct().setUlIdTodoPersWorker(pCCMN19DOutputRec.getUlIdTodoPersWorker());
                pOutputMsg211.getStageStruct().setSzNmPersonFull(pCCMN19DOutputRec.getSzNmPersonFull());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                //  Return the total number of rows found matching the input row's
                // "who did what to whom" triad (including the input row)
                // ERR#1797 If the only duplicate we found is the same row we
                // passed in, return zero duplicates, else return the number found.
                if (0 == cdIncmgStatus2.substring(0, CINT77DI.CD_INCMG_STATUS_LEN).compareTo(MARKED_FOR_DELETION.substring(0, CINT77DI.CD_INCMG_STATUS_LEN))) {
                    pOutputMsg211.getStageStruct().setSzNmStage(pCCMN19DOutputRec.getSzNmStage());
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                }
                //  SIR# 10717 - Send back MSG_NO_TASK_AVAIL_SAVE_INT_NOW
                else {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_NO_TASK_AVAIL_SAVE_INT_NOW;
                    rc = WtcHelperConstants.SQL_SUCCESS;
                    break;
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        
        return rc;
    }

    static int CallCCMN44D(CCMN44DI pCCMN44DInputRec, CCMN44DO pCCMN44DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i135 = 0;
        
        /*
        ** Call CSEC26D
        */
        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                // 
                // End Call to Staff Unit Simple Dam - CCMN39D
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN82D(CCMN13SI pInputMsg231, CCMN13SO pOutputMsg212, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i136 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN82DI pCCMN82DInputRec = null;
        CCMN82DO pCCMN82DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN82DInputRec = new CCMN82DI();
        pCCMN82DOutputRec = new CCMN82DO();
        pCCMN82DInputRec.setSzCdTask(pInputMsg231.getTodoCaseInfStruct().getSzCdTask());
        rc = ccmn82dQUERYdam(sqlca, pCCMN82DInputRec, pCCMN82DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg212.getTaskStruct().setSzTxtTaskDecode(pCCMN82DOutputRec.getSzTxtTaskDecode());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  If no rows are found, the person forward ID
                // isn't in the current stage. If the for loop
                // finishes without ever finding a row in SPLink,
                // then leave the old IdPrimaryPerson ID alone
                // in the output message.
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN89D(CCMN13SI pInputMsg232, CCMN13SO pOutputMsg213, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i137 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN89DI pCCMN89DInputRec = null;
        CCMN89DO pCCMN89DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN89DInputRec = new CCMN89DI();
        pCCMN89DOutputRec = new CCMN89DO();
        pCCMN89DInputRec.setSzCdUnitProgram(pInputMsg232.getTodoCaseInfStruct().getSzCdUnitProgram());
        pCCMN89DInputRec.setSzCdUnitRegion(pInputMsg232.getTodoCaseInfStruct().getSzCdUnitRegion());
        pCCMN89DInputRec.setSzNbrUnit(pInputMsg232.getTodoCaseInfStruct().getSzNbrUnit());
        rc = ccmn89dQUERYdam(sqlca, pCCMN89DInputRec, pCCMN89DOutputRec);
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg213.getAssignedStruct().setSzNmPersonFull(pCCMN89DOutputRec.getSzNmPersonFull());
                pOutputMsg213.getAssignedStruct().setUlIdTodoPersAssigned(pCCMN89DOutputRec.getUlIdPerson());
                
                
                //  Call CINV51D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN90D(CCMN13SI pInputMsg233, CCMN13SO pOutputMsg214, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* return code */
        int i138 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN90DI pCCMN90DInputRec = null;
        CCMN90DO pCCMN90DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN90DInputRec = new CCMN90DI();
        pCCMN90DOutputRec = new CCMN90DO();
        pCCMN90DInputRec.setLdIdTodo(pInputMsg233.getTodoCaseInfStruct().getLdIdTodo());
        rc = ccmn90dQUERYdam(sqlca, pCCMN90DInputRec, pCCMN90DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg214.getTodoInfoStruct().setSzCdTodoType(pCCMN90DOutputRec.getSzCdTodoType());
                pOutputMsg214.getTodoInfoStruct().setDtDtTodoDue(pCCMN90DOutputRec.getDtDtTodoDue());
                pOutputMsg214.getTodoInfoStruct().setUlIdCase(pCCMN90DOutputRec.getUlIdCase());
                pOutputMsg214.getTodoInfoStruct().setUlIdEvent(pCCMN90DOutputRec.getUlIdEvent());
                pOutputMsg214.getTodoInfoStruct().setLdIdTodo(pCCMN90DOutputRec.getLdIdTodo());
                pOutputMsg214.getTodoInfoStruct().setSzTxtTodoDesc(pCCMN90DOutputRec.getSzTxtTodoDesc());
                pOutputMsg214.getTodoInfoStruct().setTxtTodoLongDesc(pCCMN90DOutputRec.getTxtTodoLongDesc());
                pOutputMsg214.getTodoInfoStruct().setDtDtTodoCompleted(pCCMN90DOutputRec.getDtDtTodoCompleted());
                pOutputMsg214.getTaskStruct().setSzCdTask(pCCMN90DOutputRec.getSzCdTodoTask());
                pOutputMsg214.getTaskStruct().setDtDtTaskDue(pCCMN90DOutputRec.getDtDtTaskDue());
                pOutputMsg214.getStageStruct().setUlIdStage(pCCMN90DOutputRec.getUlIdStage());
                pOutputMsg214.getCreatedStruct().setUlIdTodoPersCreator(pCCMN90DOutputRec.getUlIdTodoPersCreator());
                pOutputMsg214.getCreatedStruct().setDtDtTodoCreated(pCCMN90DOutputRec.getDtDtTodoCreated());
                pOutputMsg214.getAssignedStruct().setUlIdTodoPersAssigned(pCCMN90DOutputRec.getUlIdTodoPersAssigned());
                pOutputMsg214.setTsLastUpdate(pCCMN90DOutputRec.getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TODO_DELETED;
                
                //  Call CLSS25D
                rc = Messages.MSG_CMN_TODO_DELETED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINT21D(CCMN13SI pInputMsg234, CCMN13SO * pOutputMsg215, String szCdStage2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setUlIdStage(pInputMsg234.getTodoCaseInfStruct().getUlIdStage());
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                szCdStage2 = pCINT21DOutputRec.getSzCdStage();
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_TASK_AVAIL_SAVE_INT_NOW;
                
                // call DAM
                rc = WtcHelperConstants.SQL_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT07D(CCMN13SI pInputMsg235, CCMN13SO * pOutputMsg216, String cdIncmgStatus3, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT07DI pCINT07DInputRec = null;
        CINT07DO pCINT07DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT07DInputRec = new CINT07DI();
        
        pCINT07DOutputRec = new CINT07DO();
        pCINT07DInputRec.setUlIdStage(pInputMsg235.getTodoCaseInfStruct().getUlIdStage());
        pCINT07DInputRec.setArchInputStruct(pInputMsg235.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = cint07dQUERYdam(sqlca, pCINT07DInputRec, pCINT07DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                cdIncmgStatus3 = pCINT07DOutputRec.getCdIncmgStatus();
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
