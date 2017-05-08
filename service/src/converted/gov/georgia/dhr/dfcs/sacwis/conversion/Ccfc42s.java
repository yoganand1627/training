package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC42SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC42SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDA5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDA5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV39DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV39DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES63DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES63DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCFC42S.src
**
** Service Name:  CCFC42S.src
**
** Description:   The service performs the steps necessary to create an Admin
**                Review Stage.  If the stage being reviewed is an investigation
**                stage, the service will be passed an ID_PERSON for the
**                requestor of the review which is used with the ID_STAGE to
**                retrieve an entire row from the STAGE_PERSON_LINK table.
**                (CINV39D).  If the person's role in the reviewed stage is
**                not that of a confirmed perpetrator, the service will return
**                an error message and the Admin Review stage is not created.
**                Otherwise, the ADMIN_REVIEW table is checked(CSEC62D) to 
**                ensure that ther is no currently an Admin Review stage 
**                open for the requestor and for the stage to be reviewed.
**                If an Admin review stage is open, then the service will return
**                an error message and the Admin Review stage is not created.
**                Once these initial checks have been made, the service calls
**                the CloseOpenStage common function(CCMN03U) to open the 
**                Admin Review Stage. Next, the service copies all of the 
**                allegations relating to the requestor and the reviewed
**                stage from the ALLEGATION table to the ADMIN_ALLEGATION
**                table(CMSC43D) for historical purposes, sets the name of
**                the Admin Review Stage to that of the requestor(CCMND8D),
**                retrieves the ID_EVENT for the Admin Review event created
**                by CloseOpenStage(CSES63D), and creates an EVENT_PERSON_LINK
**                record for the requestor and the Admin Review Event(CCMN68D).
**                If the stage being reviewed is an APS investigation, then
**                the CD_STAGE_REASON_CLOSED for the stage to be reviewed is
**                cleared (CAUDA5D).  Finally, the service retreives the 
**                ID_PERSON for the historical primary worker of the stage 
**                to be reviewed(CCMN19D) and the worker's supervisor(CCMN60D).
**                If the worker is still an active employee, the ToDo common
**                function(CSUB40U) is called to send a ToDo to both the 
**                worker and the supervisor.
**
**                If the stage being reviewed is a F/A home stage, the 
**                ADMIN_REVIEW table is checked(CSEC64D) to ensure that 
**                there is not currently an Admin Review stage open for 
**                the stage being reviewed.  If an Admin Review stage is
**                open, then the service will return an error message and 
**                the Admin Review Stage is not open. Otherwise, the 
**                CloseOpenStage common function is called(CCMN03U) to 
**                create the Admin Review Stage.  The ID_PERSON of the 
**                primary worker(or historical primary worker) for the 
**                F/A Home Stage(CCMN19D) and the worker's supervisor
**                (CCMN60D are then retreived.If the worker is still an 
**                active employee, the ToDo common function(CSUB40U) is 
**                called to send a ToDo to both the woker and the supervisor.
**  
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1-12-96
** 
** Programmer:    Jeff Hughes 
**
** Archive Information: $Revision:   1.4  $
**                      $Date:   22 Jul 1997 09:45:38  $
**                      $Modtime:   21 Jul 1997 14:39:32  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   3/16/96  ODONNERJ  SIR# 3961 - Changed #define for PERPs to those
**                      noted in e-mail and conversation with Kay Love,
**                      CJ Horton, and Janis Brown. Changed IF loop to 
**                      remove old PERPs.
**   4/08/96 ODONNERJ   SIR# 20266 - Added space before "requested in the 
**                      Create To-do #define
**
**   4/23/96 ODONNERJ   SIR# 20540 - Moved the population of the stage name 
**                      for the call to Stage Progression to inside the 
**                      IF/ELSE to differentiate between ARI/ARF.
**
**   4/24/96 ODONNERJ   SIR# 20540 - Removed the calls to CCMND8D and CCMN68D
**                      They duplicate functionality in Stage Progression.
**                      This required their removal in Foundation and 
**                      regeneration of ccfc01v.mak and ccfc42s.pc.
** 
**   5/1/96  NEGRETCI   SIR# 20775 - Modify Input to CSUB40U so that 
**                      To-Do creates ARI stage to-do with
**                      the selected person's name as the name of the stage.  
**                      and To-Do creates ARF stage to-do with
**                      the selected INV Stage name as the name of the stage
**
**  5/14/96  NEGRETCI   SIR# 21092 - Add 'CL' as a person role for whom 
**                      an Admin Review Stage can be created.  This was 
**                      to by APS Program (L.Clark & C.J.Horton)
**
**  4/14/97  DURANG     SIR# 13618 - MHMR Enhancement. Added AFC 
**                      condition prior to calling CAUD5D.  This will
**                      clear the closure reason on the stage table
**                      if the stage being reviewed is AFC/APS. Added
**                      conditions prior to calling CSUB40U. This sends 
**                      a Todo to the worker and supervisor. 
**  7/15/97  PHILLILH   SIR# 14136 - ENH - Relax edit for AFC Admin Reviews.  
**                      Facility Admin Reviews can be done on persons 
**                      with roles other than DP, CL, VP, or SP.  Therefore,
**                      user will now be able to select a any PRN on the 
**                      Person List.  
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc42s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final int REQUESTER = 0;
    public static final int USER = 1;
    /*SIR# 21092 - Add 'CL' as a person role for whom an ARI can be started*/
    public static final String STG_ROLE_CLIENT = "CL";
    public static final String STG_ROLE_DESIG_VIC_PERP = "DB";
    public static final String STG_ROLE_DESIG_PERP = "DP";
    /*SIR# 3961 - Remove VP and Add SP */
    public static final String STG_ROLE_SUSTAIN_PERP = "SP";
    /*#define STG_ROLE_ALLEG_VIC_PERP     "VP"*/
    public static final String AR_STATUS_APPROVED = "040";
    public static final String STAGE_CD_AR_INV = "ARI";
    public static final String STAGE_CD_AR_FAD = "ARF";
    public static final String TODO_TEXT_CFC012_START = "ARV in Case ";
    /* SIR# 20266 Add space in front of requested by */
    public static final String TODO_TXT_CFC012_END = " requested by ";
    public static final String CCFC012 = "CFC012";
    public static final int MIN_PAGE_FOR_CCMNB8 = 1;
    /* SIR# 13618 Admin Review                       */
    public static final String TODO_TEXT_CFC028_START = "ARV in ";
    public static final String TODO_TXT_CFC028_END = " Case requested re ";
    public static final String CCFC028 = "CFC028";
    CCFC42SO CCFC42S(CCFC42SI ccfc42si) {
        CCFC42SO ccfc42so = new CCFC42SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  short rc = FND_SUCCESS;
        int RetVal = SUCCESS;
        
        CAUDA5DI pCAUDA5DInputRec = null;
        CAUDA5DO pCAUDA5DOutputRec = null;
        
        CCMN19DI pCCMN19DInputRec = null;
        CCMN19DO pCCMN19DOutputRec = null;
        
        CCMN60DI pCCMN60DInputRec = null;
        CCMN60DO pCCMN60DOutputRec = null;
        
        CINV39DI pCINV39DInputRec = null;
        CINV39DO pCINV39DOutputRec = null;
        
        CMSC43DI pCMSC43DInputRec = null;
        CMSC43DO pCMSC43DOutputRec = null;
        
        CSEC62DI pCSEC62DInputRec = null;
        CSEC62DO pCSEC62DOutputRec = null;
        
        CSEC64DI pCSEC64DInputRec = null;
        CSEC64DO pCSEC64DOutputRec = null;
        
        CSES63DI pCSES63DInputRec = null;
        CSES63DO pCSES63DOutputRec = null;
        
        CCMN03UI pCCMN03UInputRec = null;
        CCMN03UO pCCMN03UOutputRec = null;
        
        CSUB40UI pCSUB40UInputRec = null;
        CSUB40UO pCSUB40UOutputRec = null;
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): Generic List AUD
        **************************************************************************/
        int usRow = 0;
        int usInputRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccfc42si.getArchInputStruct());
        if (ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER) > 0) {
            // 
            // Retrieve STAGE PERSON information  using CINV39D 
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCINV39DInputRec = new CINV39DI();
            
            pCINV39DOutputRec = new CINV39DO();
            pCINV39DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
            pCINV39DInputRec.setUlIdStage(ccfc42si.getUlIdStage());
            pCINV39DInputRec.setUlIdPerson(ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER));
            
            //  Call CSES01D, Contract Version retrieve for an idContract
            rc = cinv39dQUERYdam(sqlca, pCINV39DInputRec, pCINV39DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    if (!(pCINV39DOutputRec.getSzCdStagePersRole().compareTo(STG_ROLE_CLIENT) != 0) ||!(pCINV39DOutputRec.getSzCdStagePersRole().compareTo(STG_ROLE_DESIG_VIC_PERP) != 0) ||!(pCINV39DOutputRec.getSzCdStagePersRole().compareTo(STG_ROLE_DESIG_PERP) != 0) ||!(pCINV39DOutputRec.getSzCdStagePersRole().compareTo(STG_ROLE_SUSTAIN_PERP) != 0) || 0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = SUCCESS;
                    }
                    else // not confirmed Perp Processing
                    {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CFC_NOT_CONF_PERP;
                        
                        
                        //  Set RetVal to FND_SUCCESS
                        RetVal = Csub50s.FND_FAIL;
                        
                        //  Call CAUD15D. Performs a full row
                        // update/insert to the Contract Version table.
                        rc = Csub50s.FND_FAIL;
                    }
                    
                    if (RetVal == SUCCESS) {
                        // 
                        // NEXT RETREIVAL DAM CSEC62D for ADMIN REVIEW SEC BEGIN
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCSEC62DInputRec = new CSEC62DI();
                        
                        pCSEC62DOutputRec = new CSEC62DO();
                        pCSEC62DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                        pCSEC62DInputRec.setUlIdStage(ccfc42si.getUlIdStage());
                        pCSEC62DInputRec.setUlIdPerson(ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER));
                        pCSEC62DInputRec.setSzCdAdminRvStatus(AR_STATUS_APPROVED);
                        
                        rc = csec62dQUERYdam(sqlca, pCSEC62DInputRec, pCSEC62DOutputRec);
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_AR_CURR_OPEN;
                                
                                //  Set RetVal to FND_FAIL
                                RetVal = Csub50s.FND_FAIL;
                                
                                //  Call CAUD17D.  The Contract Service AUD performs a full row
                                // insert to the Contract Service table.
                                rc = Csub50s.FND_FAIL;
                                
                                // 
                                // (END): CAUD57D -- PAL PUBLIC ASSIST AUD
                                // 
                                
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                // Retrieve DAM from Contract_County
                                rc = WtcHelperConstants.ARC_SUCCESS;
                                
                                //  Set RetVal to FND_SUCCESS
                                RetVal = SUCCESS;
                                // SIR#3813 - Added break statement.
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                break;
                        }
                    }
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    rc = Csub50s.FND_FAIL;
                    
                    // 
                    // OPTIONAL CODE NOTE (END): CAUD56D -- PAL FOLLOWUP AUD
                    // 
                    
                    break;
                    
            }
        }
        
        
        /*Begin else  which call CSEC 64D to check for Admin Review*/
        else {
            // 
            // Retrieve DAM CSEC 64D 
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC64DInputRec = new CSEC64DI();
            
            pCSEC64DOutputRec = new CSEC64DO();
            pCSEC64DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
            pCSEC64DInputRec.setUlIdStage(ccfc42si.getUlIdStage());
            pCSEC64DInputRec.setSzCdAdminRvStatus(AR_STATUS_APPROVED);
            
            rc = csec64dQUERYdam(sqlca, pCSEC64DInputRec, pCSEC64DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_ADMIN_REV_EXISTS;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    rc = Csub50s.FND_FAIL;
                    
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        
        //SIR 18926
        if (RetVal == SUCCESS) {
            
            // 
            // Common Function CCMN03U to Review investigation processing
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN03UInputRec = new CCMN03UI();
            
            pCCMN03UOutputRec = new CCMN03UO();
            pCCMN03UInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
            pCCMN03UInputRec.getArchInputStruct().setUsPageNbr(MIN_PAGE_FOR_CCMNB8);
            pCCMN03UInputRec.setUlIdStage(ccfc42si.getUlIdStage());
            pCCMN03UInputRec.setSzCdStage(ccfc42si.getSzCdStage());
            pCCMN03UInputRec.setSzCdStageProgram(ccfc42si.getSzCdStageProgram());
            pCCMN03UInputRec.setUlIdPerson(ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(USER));
            pCCMN03UInputRec.setUlScrIdPrimChild(ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER));
            pCCMN03UInputRec.setCSysIndSStgOpenOnly(FND_YES);
            
            if (ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER) > 0) {
                pCCMN03UInputRec.setSzCdStageOpen(STAGE_CD_AR_INV);
                pCCMN03UInputRec.setSzCdStageReasonClosed(STAGE_CD_AR_INV);
                pCCMN03UInputRec.setSzNmPersonFull(ccfc42si.getSzNmPersonFull());
            }
            
            // review F/A Home processing
            else {
                pCCMN03UInputRec.setSzCdStageOpen(STAGE_CD_AR_FAD);
                pCCMN03UInputRec.setSzCdStageReasonClosed(STAGE_CD_AR_FAD);
                pCCMN03UInputRec.setSzNmPersonFull(ccfc42si.getSzNmStage());
                
            }
            rc = Ccmn03u.CloseOpenStage(pCCMN03UInputRec, pCCMN03UOutputRec, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    
                    
                    // 
                    // CSES63D Retreival begin for Admin Review, All in Case 
                    // Success for CCMN03U
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES63DInputRec = new CSES63DI();
                    
                    pCSES63DOutputRec = new CSES63DO();
                    pCSES63DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                    pCSES63DInputRec.setUlIdStage(pCCMN03UOutputRec.getUlIdStage());
                    
                    //  Declare FOUNDATION variables
                    
                    //  Declare local variables
                    
                    
                    //  Start performance timer for service
                    rc = cses63dQUERYdam(sqlca, pCSES63DInputRec, pCSES63DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            //  Set RetVal to FND_SUCCESS
                            RetVal = SUCCESS;
                            if (ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER) > 0) {
                                
                                // 
                                // Call of CMSC43D which performs Post Create Review 
                                // Investigation Processing
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCMSC43DInputRec = new CMSC43DI();
                                
                                pCMSC43DOutputRec = new CMSC43DO();
                                pCMSC43DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                                pCMSC43DInputRec.setUlIdAdminAllegARStage(pCCMN03UOutputRec.getUlIdStage());
                                pCMSC43DInputRec.setUlIdPerson(ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER));
                                pCMSC43DInputRec.setUlIdStage(ccfc42si.getUlIdStage());
                                pCMSC43DInputRec.setCIndAdminAllegPrior(FND_YES);
                                rc = cmsc43dAUDdam(sqlca, pCMSC43DInputRec, pCMSC43DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        
                                        //  Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        if (!(ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_APS) != 0) || 0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                                            
                                            // 
                                            // CALL FOR CAUDA5D which will perform review APS 
                                            // investigation Processing all part 
                                            // of CASE Success in CMSC43D
                                            // 
                                            
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCAUDA5DInputRec = new CAUDA5DI();
                                            
                                            pCAUDA5DOutputRec = new CAUDA5DO();
                                            pCAUDA5DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                                            pCAUDA5DInputRec.setUlIdStage(ccfc42si.getUlIdStage());
                                            pCAUDA5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                                            rc = cauda5dAUDdam(sqlca, pCAUDA5DInputRec, pCAUDA5DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    //  Set RetVal to FND_SUCCESS
                                                    RetVal = SUCCESS;
                                                    
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    //  Set RetVal to FND_FAIL
                                                    RetVal = Csub50s.FND_FAIL;
                                                    
                                                    //  Call CheckStageEventStatus
                                                    rc = Csub50s.FND_FAIL;
                                                    
                                                    break;
                                            }
                                        }
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        
                                        
                                        // 
                                        // Call DAMs to retrieve data
                                        // 
                                        rc = Csub50s.FND_FAIL;
                                        
                                        break;
                                }
                                
                            }
                            if (RetVal == SUCCESS) {
                                // 
                                // CALL CCMN19D TO STAGE_PERSON_LINK
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMN19DInputRec = new CCMN19DI();
                                
                                pCCMN19DOutputRec = new CCMN19DO();
                                pCCMN19DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                                pCCMN19DInputRec.setSzCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
                                pCCMN19DInputRec.setUlIdStage(ccfc42si.getUlIdStage());
                                rc = ccmn19dQUERYdam(sqlca, pCCMN19DInputRec, pCCMN19DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        
                                        // 
                                        // BEGIN DAM CCMN60D TO GET SUPERVISOR ALL PART OF
                                        // CASE SUCCESS IN CCMN19D CALL
                                        // 
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCCMN60DInputRec = new CCMN60DI();
                                        
                                        pCCMN60DOutputRec = new CCMN60DO();
                                        pCCMN60DInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                                        pCCMN60DInputRec.setUlIdPerson(pCCMN19DOutputRec.getUlIdTodoPersWorker());
                                        rc = ccmn60dQUERYdam(sqlca, pCCMN60DInputRec, pCCMN60DOutputRec);
                                        
                                        
                                        
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                
                                                // 
                                                // BEGIN ToDo COMMON FUNCTION CSUB40U WHICH WILL
                                                // SEND THE ToDo TO THE WORKER
                                                // 
                                                
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCSUB40UInputRec = new CSUB40UI();
                                                
                                                pCSUB40UOutputRec = new CSUB40UO();
                                                pCSUB40UInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                                                
                                                // Analyze error code
                                                if (0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                                                    pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(CCFC028);
                                                }
                                                else {
                                                    pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(CCFC012);
                                                }
                                                // End Sir 13618
                                                
                                                ARC_UTLGetDateAndTime(pCSUB40UInputRec.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                                                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCCMN19DOutputRec.getUlIdTodoPersWorker());
                                                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(pCSES63DOutputRec.getUlIdEvent());
                                                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(pCSES63DOutputRec.getUlIdStage());
                                                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(USER));
                                                //## END TUX/XML: Turn the XML buffer into an input message struct 
                                                
                                                
                                                
                                                if (0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                                                    pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC028_START);
                                                }
                                                else {
                                                    pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC012_START);
                                                }
                                                pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += ccfc42si.getSzNmCase();
                                                if // Stage is Investigation or Admin Review
                                                (0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                                                    pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += TODO_TXT_CFC028_END;
                                                }
                                                else {
                                                    pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += TODO_TXT_CFC012_END;
                                                }
                                                
                                                //  Retrieve Overall Disposition based on Program.
                                                
                                                // APS
                                                if (ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER) > 0) {
                                                    pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += ccfc42si.getSzNmPersonFull();
                                                }
                                                else {
                                                    pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += ccfc42si.getSzNmStage();
                                                    
                                                }
                                                rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                                                
                                                
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        
                                                        //  Set RetVal to FND_SUCCESS
                                                        RetVal = SUCCESS;
                                                        
                                                        break;
                                                        
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        
                                                        //  Set RetVal to FND_FAIL
                                                        RetVal = Csub50s.FND_FAIL;
                                                        rc = Csub50s.FND_FAIL;
                                                        
                                                        break;
                                                }
                                                
                                                // CPS
                                                if (RetVal == SUCCESS) {
                                                    // 
                                                    // Begin Process of SENDING ToDo to the Supervisor
                                                    // WIHT CSUB40UI AGAIN
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCSUB40UInputRec = new CSUB40UI();
                                                    
                                                    pCSUB40UOutputRec = new CSUB40UO();
                                                    pCSUB40UInputRec.setArchInputStruct(ccfc42si.getArchInputStruct());
                                                    
                                                    // APS FACILITY
                                                    if (0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                                                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(CCFC028);
                                                    }
                                                    else {
                                                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(CCFC012);
                                                    }
                                                    
                                                    ARC_UTLGetDateAndTime(pCSUB40UInputRec.getCSUB40UIG00().getDtSysDtTodoCfDueFrom() , 0);
                                                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersAssgn(pCCMN60DOutputRec.getUlIdPerson());
                                                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(pCSES63DOutputRec.getUlIdEvent());
                                                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(pCSES63DOutputRec.getUlIdStage());
                                                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersWkr(ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(USER));
                                                    
                                                    // LICENSING
                                                    if (0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                                                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC028_START);
                                                    }
                                                    else {
                                                        pCSUB40UInputRec.getCSUB40UIG00().setSzSysTxtTodoCfDesc(TODO_TEXT_CFC012_START);
                                                    }
                                                    pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += ccfc42si.getSzNmCase();
                                                    
                                                    // Using on the ID EVENT from the overall disposition
                                                    // determine the status of the event.  If the status
                                                    // is pending (PEND), return the ID EVENT to the client
                                                    // Else, return null
                                                    if (0 == ccfc42si.getSzCdStageProgram().compareTo(CAPS_PROG_AFC)) {
                                                        pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += TODO_TXT_CFC028_END;
                                                    }
                                                    else {
                                                        pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += TODO_TXT_CFC012_END;
                                                    }
                                                    
                                                    if (ccfc42si.getUlIdPerson_ARRAY().getUlIdPerson(REQUESTER) > 0) {
                                                        pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += ccfc42si.getSzNmPersonFull();
                                                    }
                                                    else {
                                                        pCSUB40UInputRec.getCSUB40UIG00().getSzSysTxtTodoCfDesc() += ccfc42si.getSzNmStage();
                                                    }
                                                    rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                                                    
                                                    // Analyze return code
                                                    switch (rc) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            
                                                            //  Set RetVal to FND_SUCCESS
                                                            RetVal = SUCCESS;
                                                            
                                                            break;
                                                            
                                                        default :
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            //  Set RetVal to FND_FAIL
                                                            RetVal = Csub50s.FND_FAIL;
                                                            rc = Csub50s.FND_FAIL;
                                                            
                                                            break;
                                                    }
                                                }
                                                
                                                break;
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                
                                                //  Call DAM
                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                
                                                //  Set RetVal to FND_SUCCESS
                                                RetVal = SUCCESS;
                                                
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                //  Set RetVal to FND_FAIL
                                                RetVal = Csub50s.FND_FAIL;
                                                rc = Csub50s.FND_FAIL;
                                                
                                                break;
                                        }
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        //  Set RetVal to FND_FAIL
                                        RetVal = Csub50s.FND_FAIL;
                                        rc = Csub50s.FND_FAIL;
                                        
                                        
                                        break;
                                }
                            }
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            //  Set RetVal to FND_FAIL
                            RetVal = Csub50s.FND_FAIL;
                            
                            //  Call DAM
                            rc = Csub50s.FND_FAIL;
                            
                            break;
                    }
                    
                    break;
                    
                default :
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    rc = Csub50s.FND_FAIL;
                    
                    
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc42si.getArchInputStruct() , ccfc42so.getArchOutputStruct());
        
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
        
        return ccfc42so;
    }

    //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
    
    
    
}
