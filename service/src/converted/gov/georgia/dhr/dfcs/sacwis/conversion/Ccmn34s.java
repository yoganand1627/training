package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN54DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN56DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN59DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC01DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNI3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNI3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB8DO;
/**************************************************************************
**
** Module File:   CCMN34S.SRC
**
** Service Name:  CCMN34S
**
** Description:   Retrieves data from Approval Related tables to support
**                the population of the Approval Status window and WCD.
**                The service will be given either an ID_TODO, ID_EVENT or
**                ID_APPROVAL. Depending on what is received certain DAMs
**                will be executed.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/05/95
**
** Programmer:    Ian Fogarty
**
**  02/24/95  FOGARTIS  SIR#73 - Standardized Service Error Handling
**  03/12/95  FOGARTIS  SIR#66 SIR#274 - Retreival of Stage Name added
**  04/03/95  FOGARTIS  SIR#72 - Stage progression logic added. DAM 59
**                      enhanced to retrieve additional stage program and
**                      reason closed information. Related Events are
**                      checked against array of closure tasks and then
**                      Stage Progression Mode is discerned.
**  06/30/95  PITMANGS  SIR#703 - Change mode from Modify to Browse if
**                      any Approvers returned from DAM 56 have rejected
**                      or invalidated the approval.
**
** 10/08/95   LASKEYRM  Removed "2450" from line 144. SIR #1675
**
** 02/19/96   ZIMMERNE  SIR #3256 - Added cd_tasks to the Array of Task codes
**                      list for approval closures 5560, 4110, 3270, and 8770
**                      (FRE, FSU, SUB, and ADO).
**
** 02/23/96   DYARGR    SIR 3323 - Add cd_task for AOC closure (5090)
**
** 05/06/96   ODONNERJ  SIR# 20436 - Add cd_task for RCL Conclusion
**
**  03/11/97  GONZALCE  SIR# 11437 - Added 2 dams (cinv51d and csec02d) to
**                      retrieve the name and id_person of a primary worker
**                      given a specific id_stage.
**
** 06/23/97   CYSKD     SVC AUTH ENH -- Modified code in CallCCMN59D and
**                      CallCINV51D to provide for seeking the historical
**                      primary worker's ID in case approval event is for
**                      a Service Auth. in a closed stage.
**
** 04/18/99   SOHNJJ	SIR #15169 -- This enhancement allows SWI supervisors
**			to save or save and assign intakes in approval mode
**			without invalidating the to-do.  The supervisor
**			will be able to approve the to-do at any time after
**			the save and assign.  However, if the worker goes
**			back into the intake, the approval to-do will be
**			invalidated.
**
** 07/17/2005 CASDORJM - SIR 23334 - Added APPROVAL REJECTION ccmni3d
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn34s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char SP_NOT_APPL = 'N';
    public static final char SP_MANUAL = 'W';
    public static final char SP_AUTOMATIC = 'P';
    public static final char SP_CASECLOSE = 'C';
    
    public static final int APRV_MODIFY = 1;
    public static final int APRV_BROWSE = 2;
    
    public static final String APRV_REJECT = "REJT";
    public static final String APRV_INVALID = "INVD";
    
    public static final String PRIMARY_WORKER = "PR";
    public static final String HIST_PRIM_WORKER = "HP";
    public static final char CLOSE_STAGE_YES = 'Y';
    int i;
    CCMN34SO CCMN34S(CCMN34SI ccmn34si) {
        CCMN34SO ccmn34so = new CCMN34SO();
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
        int iCount1 = 0;
        int iCount2 = 0;
        int scenerio = 0;
        FndInt3date dtDate = null;
        FndInt3date dtDtStageClose2 = null;
        String szTime = new String();
        String IndStageClose = new String();
        boolean bSprog = false;/*
        ** Indicates that stage progression
        ** applies because a conclusion Task
        ** was found. SIR#72
        */
        
        /*
        ** Set up Array of Task codes that signify conclusion of stage that
        ** may result in stage progression or case closure upon approval SIR#72
        **
        ** SIR #1675 Removed "2450" from the array. --rml
        **
        ** SIR #3256 - Added Task codes for the following approval closures:
        ** FRE (5560), FSU (4110), SUB (3270), ADO (8770).
        **
        ** SIR 3323 - Added task codes for AOC
        **
        ** SIR# 20436 - Added task codes for RCL Investigation Conclusion
        */
        
        String szCloseTasks = "";
        rc = ARC_PRFServiceStartTime_TUX(ccmn34si.getArchInputStruct());
        
        if (ccmn34si.getLdIdTodo() > 0) {
            scenerio = APRV_MODIFY;
        }
        else /* Entry from functional window or event list window */
        {
            scenerio = APRV_BROWSE;
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (APRV_MODIFY == scenerio) {
            
            // Populate Input Structure for DAM
            rc = CallCCMN54D(ccmn34si, ccmn34so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* if it's a brand new Safety Eval, we don't have to do these! */
        if (APRV_BROWSE == scenerio) {
            rc = Ccmn05u.CallCCMN55D(ccmn34si, ccmn34so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        /*
        ** Default is not what we expect so an error will not be returned
        ** here.
        */
        rc = Ccmn19s.CallCCMN56D(ccmn34si, ccmn34so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** SIR#703 - cycle through all rows returned from CCMN56D.  If an
        ** approver's status is equal to APRV_REJECT or APRV_INVALID, the
        ** mode is changed from Modify to Browse
        */
        for (iCount1 = 0;((APRV_MODIFY == scenerio) && (ccmn34so.getROWCCMN56DO_ARRAY().getROWCCMN56DO(iCount1).getSzCdApproversStatus()[0] != null) && (iCount1 < CCMN34SO._CCMN34SO__ROWCCMN56DO_SIZE));iCount1++) {
            
            // Check what the event code is, if the code is NEW, then the 
            // event was created by a TO-DO and nothing exists in the safety
            // eval tables, so don't bother calling these services
            if ((0 == ccmn34so.getROWCCMN56DO_ARRAY().getROWCCMN56DO(iCount1).getSzCdApproversStatus().compareTo(APRV_REJECT)) || (0 == ccmn34so.getROWCCMN56DO_ARRAY().getROWCCMN56DO(iCount1).getSzCdApproversStatus().compareTo(APRV_INVALID))) {
                scenerio = APRV_BROWSE;
            }
        }
        if (APRV_MODIFY == scenerio) {
            
            //  Populate Input Structure for DAM
            rc = Ccmn05u.CallCCMN57D(ccmn34si, ccmn34so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if ((APRV_MODIFY == scenerio) && (ccmn34so.getUlRowQty2() == 1)) {
            rc = Ccmn13s.CallCCMN82D(ccmn34si, ccmn34so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        /*
        ** Default is not what we expect so an error will not be returned
        ** here.
        */
        rc = CallCCMN58D(ccmn34si, ccmn34so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (APRV_MODIFY == scenerio) {
            rc = CallCCMN59D(ccmn34si, ccmn34so, dtDtStageClose2, IndStageClose, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (APRV_MODIFY == scenerio) {
            rc = CallCINV51D(ccmn34si, ccmn34so, dtDtStageClose2, IndStageClose, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (APRV_MODIFY == scenerio) {
            rc = CallCSEC01D(ccmn34si, ccmn34so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        if (APRV_MODIFY == scenerio) {
            rc = Ccmn01u.CallCCMN45D(ccmn34si, ccmn34so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = CallCCMNI3D(ccmn34si, ccmn34so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        ccmn34so.getAprvlStageProg().setCWCDCdStageProgressMode(SP_NOT_APPL);
        
        /*
        ** Determine whether or not Stage Progression applies based upon related
        ** events cd_tasks and declared local conclusion tasks array
        */
        for (iCount1 = 0;iCount1 < ccmn34so.getUlRowQty2() && (!bSprog);iCount1++) {
            for (iCount2 = 0;(!szCloseTasks[iCount2].equals("END")) && (!bSprog);iCount2++) {
                //## END TUX/XML: Turn the XML buffer into an input message struct
                
                
                
                if (szCloseTasks[iCount2].equals(ccmn34so.getROWCCMN57DO_ARRAY().getROWCCMN57DO(iCount1).getSzCdTask())) {
                    bSprog = true;
                }
            }
        }
        if (bSprog) {
            rc = Ccmn02u.CallCCMNB8D(ccmn34si, ccmn34so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = ARC_UTLGetDateAndTime(dtDate, szTime);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        ccmn34so.setDtWCDDtSystemDate(dtDate);
        ccmn34so.setTmWCDTmSystemTime(szTime);
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn34si.getArchInputStruct() , ccmn34so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            // 
            // (END): Common Function: ccmn06u   Check Stage/Event common function
            // 
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
        return ccmn34so;
    }

    static int CallCCMN45D(CCMN34SI * pInputMsg294, CCMN34SO pOutputMsg277, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setUlIdEvent(pOutputMsg277.getUlIdApproval());
        
        /*
        ** Call DAM
        */
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        if (rc != 0) {
            
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg277.getROWCCMN45DO().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
            pOutputMsg277.getROWCCMN45DO().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
            pOutputMsg277.getROWCCMN45DO().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
            pOutputMsg277.getROWCCMN45DO().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
            
            pOutputMsg277.getROWCCMN45DO().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
            pOutputMsg277.getROWCCMN45DO().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
            pOutputMsg277.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
            pOutputMsg277.getROWCCMN45DO().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
            pOutputMsg277.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMN54D(CCMN34SI pInputMsg295, CCMN34SO pOutputMsg278, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN54DI pCCMN54DInputRec = null;
        CCMN54DO pCCMN54DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN54DInputRec = new CCMN54DI();
        
        pCCMN54DOutputRec = new CCMN54DO();
        pCCMN54DInputRec.setLdIdTodo(pInputMsg295.getLdIdTodo());
        
        
        /*
        ** Call CSES45D
        */
        rc = ccmn54dQUERYdam(sqlca, pCCMN54DInputRec, pCCMN54DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg278.setUlIdApproval(pCCMN54DOutputRec.getUlIdApproval());
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMN55D(CCMN34SI pInputMsg296, CCMN34SO pOutputMsg279, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN55DI pCCMN55DInputRec = null;
        CCMN55DO pCCMN55DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN55DInputRec = new CCMN55DI();
        
        pCCMN55DOutputRec = new CCMN55DO();
        pCCMN55DInputRec.setUlIdEvent(pInputMsg296.getUlIdEvent());
        rc = ccmn55dQUERYdam(sqlca, pCCMN55DInputRec, pCCMN55DOutputRec);
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg279.setUlIdApproval(pInputMsg296.getUlIdEvent());
                    
                    
                    //  Call CSEC03D.  This DAM will retrieve all rows from the contract
                    // table, the resource Id and resource name from the CAPS resource
                    // table, the name from the Person table, and the Id
                    // resource address from the resource address table
                    // related to the contract Id passed.
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            pOutputMsg279.setUlIdApproval(pCCMN55DOutputRec.getUlIdApproval());
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        
        return rc;
    }

    static int CallCCMN56D(CCMN34SI pInputMsg297, CCMN34SO pOutputMsg280, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i157 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN56DI pCCMN56DInputRec = null;
        CCMN56DO pCCMN56DOutputRec = null;
        
        pCCMN56DInputRec = new CCMN56DI();
        
        pCCMN56DOutputRec = new CCMN56DO();
        pCCMN56DInputRec.setUlIdApproval(pOutputMsg280.getUlIdApproval());
        pCCMN56DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg297.getArchInputStruct().getUsPageNbr());
        pCCMN56DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg297.getArchInputStruct().getUlPageSizeNbr());
        
        
        /*
        ** Call CLSC49D
        */
        rc = ccmn56dQUERYdam(sqlca, pCCMN56DInputRec, pCCMN56DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
            
        }
        
        else {
            
            //  Populate Output Message
            for (i157 = 0;i157 < pCCMN56DOutputRec.getArchOutputStruct().getUlRowQty();++i157) {
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setDtDtApproversDetermination(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getDtDtApproversDetermination());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setTmScrTmApprovalTime(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getTmScrTmApprovalTime());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setUlIdPerson(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getUlIdPerson());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setSzNmPersonFull(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getSzNmPersonFull());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setSzCdApproversStatus(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getSzCdApproversStatus());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setSzTxtApproversComments(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getSzTxtApproversComments());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setLdIdTodo(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getLdIdTodo());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setUlIdApprovers(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getUlIdApprovers());
                pOutputMsg280.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).setTsLastUpdate(pCCMN56DOutputRec.getROWCCMN56DO_ARRAY().getROWCCMN56DO(i157).getTsLastUpdate());
            }
            pOutputMsg280.getArchOutputStruct().setUlRowQty(pCCMN56DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg280.getArchOutputStruct().setBMoreDataInd(pCCMN56DOutputRec.getArchOutputStruct().getBMoreDataInd());
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMN57D(CCMN34SI pInputMsg298, CCMN34SO pOutputMsg281, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i158 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN57DI pCCMN57DInputRec = null;
        CCMN57DO pCCMN57DOutputRec = null;
        
        pCCMN57DInputRec = new CCMN57DI();
        
        pCCMN57DOutputRec = new CCMN57DO();
        pCCMN57DInputRec.setUlIdApproval(pOutputMsg281.getUlIdApproval());
        pCCMN57DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg298.getArchInputStruct().getUsPageNbr());
        pCCMN57DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN34SO._CCMN34SO__ROWCCMN57DO_SIZE);
        rc = ccmn57dQUERYdam(sqlca, pCCMN57DInputRec, pCCMN57DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            for (i158 = 0;i158 < pCCMN57DOutputRec.getArchOutputStruct().getUlRowQty();++i158) {
                pOutputMsg281.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i158).setUlIdEvent(pCCMN57DOutputRec.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i158).getUlIdEvent());
                pOutputMsg281.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i158).setSzCdTask(pCCMN57DOutputRec.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i158).getSzCdTask());
            };
            pOutputMsg281.setUlRowQty2(pCCMN57DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg281.setBMoreDataInd2(pCCMN57DOutputRec.getArchOutputStruct().getBMoreDataInd());
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMN58D(CCMN34SI * pInputMsg299, CCMN34SO pOutputMsg282, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /*
        ** Declare local variables
        */
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN58DI pCCMN58DInputRec = null;
        CCMN58DO pCCMN58DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN58DInputRec = new CCMN58DI();
        
        pCCMN58DOutputRec = new CCMN58DO();
        pCCMN58DInputRec.setUlIdApproval(pOutputMsg282.getUlIdApproval());
        rc = ccmn58dQUERYdam(sqlca, pCCMN58DInputRec, pCCMN58DOutputRec);
        
        if (rc != 0) {
            //SIR:17091 Srini: Added the error handling to take care of full table scans.
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg282.setSzTxtApprovalTopic(pCCMN58DOutputRec.getSzTxtApprovalTopic());
            
            
            //  Call CLSS60D
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMN59D(CCMN34SI * pInputMsg300, CCMN34SO pOutputMsg283, FndInt3date dtDtStageClose3, String IndStageClose, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN59DI pCCMN59DInputRec = null;
        CCMN59DO pCCMN59DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN59DInputRec = new CCMN59DI();
        
        pCCMN59DOutputRec = new CCMN59DO();
        pCCMN59DInputRec.setUlIdApproval(pOutputMsg283.getUlIdApproval());
        rc = ccmn59dQUERYdam(sqlca, pCCMN59DInputRec, pCCMN59DOutputRec);
        /*
        ** SIR #21883 - For (i=0; i <= (ulRowQtyEvent -1); i++) Loop
        ** is being deleted here.
        */
        if (rc != 0) {
            
            
            //  Analyze return code
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg283.setUlIdStage(pCCMN59DOutputRec.getUlIdStage());
            pOutputMsg283.setUlIdCase(pCCMN59DOutputRec.getUlIdCase());
            pOutputMsg283.setSzCdStage(pCCMN59DOutputRec.getSzCdStage());
            pOutputMsg283.setSzNmStage(pCCMN59DOutputRec.getSzNmStage());
            pOutputMsg283.getAprvlStageProg().setSzCdStageProgram(pCCMN59DOutputRec.getSzCdStageProgram());
            pOutputMsg283.getAprvlStageProg().setSzCdStageReasonClosed(pCCMN59DOutputRec.getSzCdStageReasonClosed());
            
            if (CLOSE_STAGE_YES == pCCMN59DOutputRec.getBIndStageClose()) {
                dtDtStageClose3 = pCCMN59DOutputRec.getDtDtStageClose();
                IndStageClose = CStringUtils.setCharAt(IndStageClose, 0, pCCMN59DOutputRec.getBIndStageClose());
            }
            
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCINV51D(CCMN34SI * pInputMsg301, CCMN34SO pOutputMsg284, FndInt3date dtDtStageClose4, String IndStageClose, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINV51DI pCINV51DInputRec = null;/* pointer to DAM input record  */
        CINV51DO pCINV51DOutputRec = null;/* pointer to DAM output record  */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV51DInputRec = new CINV51DI();
        
        pCINV51DOutputRec = new CINV51DO();
        pCINV51DInputRec.setUlIdStage(pOutputMsg284.getUlIdStage());
        
        if (CLOSE_STAGE_YES == IndStageClose.charAt(0)) {
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if (0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("3020") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("9020") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("3520") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("5040") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("2100") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("2310") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("8530") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("7100") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("5640") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("6075") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("4190") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("3290") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("3310") || 0 == pOutputMsg284.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask().compareTo("3510")) {
                if (DateHelper.NULL_DATE != dtDtStageClose4.year) {
                    pCINV51DInputRec.setSzCdStagePersRole(HIST_PRIM_WORKER);
                }
                else {
                    pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_WORKER);
                }
            }
        }
        else {
            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_WORKER);
        }
        if ((CLOSE_STAGE_YES == IndStageClose.charAt(0)) && (pOutputMsg284.getSzCdStage().equals("INT")) && (DateHelper.NULL_DATE != dtDtStageClose4.year)) {
            pCINV51DInputRec.setSzCdStagePersRole(HIST_PRIM_WORKER);
        }
        
        /* retrieve date and time from the client */
        rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
        if (rc != 0) {
            
            switch (rc) {
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg284.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
            
            //  Call CAUD15D.  The Contract Version AUD DAM receives IdContract, 
            // NbrCnperPeriod, NbrCnverVersion, IdCntrctWkr, DtCnverCreate, 
            // DtCnverEffective, DtCnverEnd, IndCnverVerLock, NbrCnverNoShowPct 
            // and TxtCnverComment. It performs a full row AUD on the Contract 
            // Version table.
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCSEC01D(CCMN34SI * pInputMsg302, CCMN34SO pOutputMsg285, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CSEC01DI pCSEC01DInputRec = null;
        CSEC01DO pCSEC01DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC01DInputRec = new CSEC01DI();
        
        pCSEC01DOutputRec = new CSEC01DO();
        pCSEC01DInputRec.setUlIdPerson(pOutputMsg285.getUlIdPerson());
        
        /*
        ** Call DAM if a Race is added or deleted
        */
        rc = csec01dQUERYdam(sqlca, pCSEC01DInputRec, pCSEC01DOutputRec);
        if (rc != 0) {
            
            //  Stop DAM Performance Timer
            //##                ARC_PRFDataAccessStopTime();
            
            
            
            //  Analyze return code
            switch (rc) {// SIR#15787: Added if statement
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg285.setSzNmPersonFull(pCSEC01DOutputRec.getSzNmNameLast());
            pOutputMsg285.getSzNmPersonFull() += ",";
            strncat(pOutputMsg285.getSzNmPersonFull() , pCSEC01DOutputRec.getSzNmNameFirst() , 8);
            pOutputMsg285.getSzNmPersonFull() += " ";
            
            strncat(pOutputMsg285.getSzNmPersonFull() , pCSEC01DOutputRec.getSzNmNameMiddle() , 1);
            pOutputMsg285.getSzNmPersonFull() += "\0";
            //  Do nothing, the output message just returns success or
            // failure
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMNI3D(CCMN34SI pInputMsg303, CCMN34SO pOutputMsg286, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMNI3DI pCCMNI3DInputRec = null;
        CCMNI3DO pCCMNI3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNI3DInputRec = new CCMNI3DI();
        
        pCCMNI3DOutputRec = new CCMNI3DO();
        pCCMNI3DInputRec.setUlIdCase(pOutputMsg286.getUlIdCase());
        pCCMNI3DInputRec.setUlIdStage(pOutputMsg286.getUlIdStage());
        
        if (pCCMNI3DInputRec.getUlIdCase() == 0) {
            pCCMNI3DInputRec.setUlIdCase(pInputMsg303.getUlIdCase());
        }
        /*
        ** Set todo status to complete, if any exist.
        */
        if (pCCMNI3DInputRec.getUlIdStage() == 0) {
            pCCMNI3DInputRec.setUlIdStage(pInputMsg303.getUlIdStage());
        }
        pCCMNI3DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg303.getArchInputStruct().getUsPageNbr());
        pCCMNI3DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg303.getArchInputStruct().getUlPageSizeNbr());
        rc = ccmni3dQUERYdam(sqlca, pCCMNI3DInputRec, pCCMNI3DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            for (i = 0;i < pCCMNI3DOutputRec.getArchOutputStruct().getUlRowQty();++i) {
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setSzNMRejector(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getSzNMRejector());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setSzTxtApproversComments(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getSzTxtApproversComments());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setUlIdApprovalRejection(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getUlIdApprovalRejection());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setUlIdRejector(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getUlIdRejector());
                
                // 
                // Service Macro Definitions
                // 
                
                // 
                // Function Prototypes
                // 
                
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setDtDtRejection(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getDtDtRejection());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndApsEffort(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndApsEffort());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndCareEntered(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndCareEntered());
                
                //## BEGIN TUX/XML: Declare XML variables 
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndEvidence(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndEvidence());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndMissingEvidRptr(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndMissingEvidRptr());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndMissingEvidAp(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndMissingEvidAp());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndMissingEvidMp(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndMissingEvidMp());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndMissingEvidCl(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndMissingEvidCl());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndMissingEvidPhoto(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndMissingEvidPhoto());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndMissingEvidDe(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndMissingEvidDe());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndMissingEvidOther(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndMissingEvidOther());
                pOutputMsg286.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).setBIndDiscretionaryReason(pCCMNI3DOutputRec.getROWCCMNI3DO_ARRAY().getROWCCMNI3DO(i).getBIndDiscretionaryReason());
            }
            pOutputMsg286.setUlRowQty3(pCCMNI3DOutputRec.getArchOutputStruct().getUlRowQty());
            
            //  Call CheckStageEventStatus
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    
    static int CallCCMN82D(CCMN34SI * pInputMsg304, CCMN34SO pOutputMsg287, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
        pCCMN82DInputRec.setSzCdTask(pOutputMsg287.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask());
        rc = ccmn82dQUERYdam(sqlca, pCCMN82DInputRec, pCCMN82DOutputRec);
        
        if (rc != 0) {
            
            switch (rc) {
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg287.setSzCdTaskTopWindow(pCCMN82DOutputRec.getSzCdTaskTopWindow());
            
            
            //  Call CLSS67D
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMNB8D(CCMN34SI pInputMsg305, CCMN34SO pOutputMsg288, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i159 = 0;
        
        /*
        ** Declare local variables
        */
        CCMNB8DI pCCMNB8DInputRec = null;
        CCMNB8DO pCCMNB8DOutputRec = null;
        
        /*
        ** Allocate memory for DAM I/O structures
        */
        pCCMNB8DInputRec = new CCMNB8DI();
        
        pCCMNB8DOutputRec = new CCMNB8DO();
        pCCMNB8DInputRec.setSzCdStage(pOutputMsg288.getSzCdStage());
        pCCMNB8DInputRec.setSzCdStageProgram(pOutputMsg288.getAprvlStageProg().getSzCdStageProgram());
        pCCMNB8DInputRec.setSzCdStageReasonClosed(pOutputMsg288.getAprvlStageProg().getSzCdStageReasonClosed());
        pCCMNB8DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg305.getArchInputStruct().getUsPageNbr());
        pCCMNB8DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB8DO._CCMNB8DO__ROWCCMNB8DO_SIZE);
        rc = ccmnb8dQUERYdam(sqlca, pCCMNB8DInputRec, pCCMNB8DOutputRec);
        if (rc != 0) {
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            if (pCCMNB8DOutputRec.getArchOutputStruct().getUlRowQty() == 1) {
                
                pOutputMsg288.getAprvlStageProg().setSzCdStageOpen(pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getSzCdStageProgOpen());
                if (pCCMNB8DOutputRec.getROWCCMNB8DO_ARRAY().getROWCCMNB8DO(0).getBIndStageProgClose() == '1') {
                    pOutputMsg288.getAprvlStageProg().setCWCDCdStageProgressMode(SP_AUTOMATIC);
                }
                else {
                    pOutputMsg288.getAprvlStageProg().setCWCDCdStageProgressMode(SP_CASECLOSE);
                }
            }
            else {
                pOutputMsg288.getAprvlStageProg().setCWCDCdStageProgressMode(SP_MANUAL);
            }
            
            
            // Call DAM to obtain CD EVENT STATUS
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

}
