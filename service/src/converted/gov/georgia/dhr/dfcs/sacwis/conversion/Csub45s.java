package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB45SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
/***************************************************************************
** Module File:   csub45s.src
**
** Service Name:  csub45s
**
** Description:   This is the retrieval service for the Legal Status window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  20Sep95
** 
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   22 Feb 2001 14:58:28  $
**                      $Modtime:   22 Feb 2001 10:31:58  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**    5Oct95  sladewmf  Initial check-in.
**  12/12/95  WILSONET  SIR#2177 Service design altered to accommodate 
**                      more than Subcare stage and handle new window code.
**                                                                         
**  12/16/96  ZABIHIN   SIR 21130 - needed to retrieve the id_event & status
**                      of the stage closure event so that the save
**                      service will invalidate the pendig approval for the 
**                      closure event if legal status is changed after the 
**                      stage has been submitted for approval.
**                      added ccmn87d to retrieve the id_event
**                      and status of the closure event.
**                      Look at the comments in csub40w, and csub46s   
**  10/15/97	klm 	SIR# 14192 - Add the TMC Dismissal Date to the info
**			being retrieved and saved for Legal Status.
**  02/22/01    HadjimH SIR# 14413. Retrieved the field CD_COURT_NBR
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
**  04/30/03   Srini	SIR 17091: Added the error handling to take care of full 
**						table scans for ccmn87dQUERYdam.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/
/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub45s {
    public static final String PRIMARY_CHILD = "PC";
    public static final String STATUS_NEW = "NEW";
    public static final String SUB_CARE = "SUB";
    public static final String ADOPTION = "ADO";
    
    /* SIR 21130
    ** we need to have the id_event for the stage closure and 
    ** the id_event for legal status event
    */
    public static final int LEGAL_STATUS = 0;
    public static final int STAGE_CLOSURE = 1;
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String CLOSURE_EVENT_TYPE = "CCL";
    CSUB45SO CSUB45S(CSUB45SI csub45si) {
        CSUB45SO csub45so = new CSUB45SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        /*
        ** SQL_NOT_FOUND is a valid return from the DAM
        */
        rc = ARC_UTLCheckServiceBatchBlock("CSUB45S", pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i431 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        int RetVal = SUCCESS;
        CSES11DI pCSES11DInputRec = null;/* Legal Status simple retrieve */
        
        CSES11DO pCSES11DOutputRec = null;
        CINV51DI pCINV51DInputRec = null;/* Get IdPerson given IdStage & Role */
        
        CINV51DO pCINV51DOutputRec = null;
        CCMN45DI pCCMN45DInputRec = null;/* Event simple retrieve */
        
        CCMN45DO pCCMN45DOutputRec = null;
        CCMN44DI pCCMN44DInputRec = null;/* Get NmPersonFull given IdPerson */
        
        CCMN44DO pCCMN44DOutputRec = null;
        
        rc = ARC_PRFServiceStartTime_TUX(csub45si.getArchInputStruct());
        
        /* 
        ** Call DAM query Incoming Detail for existing information
        */
        rc = ARC_UTLGetDateAndTime(csub45so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        rc = Ccmn02u.CallCCMN87D(csub45si, csub45so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        
        
        /****************************************************/
        /* If case file code needs criminal history, call cdyn22d and exit */
        if (0 == csub45si.getUlIdEvent() && (!(csub45si.getSzCdStage().compareTo(SUB_CARE) != 0) ||!(csub45si.getSzCdStage().compareTo(ADOPTION) != 0))) {
            
            // 
            // (BEGIN): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCINV51DInputRec = new CINV51DI();
            
            pCINV51DOutputRec = new CINV51DO();
            pCINV51DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
            pCINV51DInputRec.setUlIdStage(csub45si.getUlIdStage());
            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub45so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    
                    csub45so.getROWCSUB45SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                    // 
                    // (BEGIN): Retrieve DAM: ccmn44d   Get NmPersonFull given IdPerson
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN44DInputRec = new CCMN44DI();
                    
                    pCCMN44DOutputRec = new CCMN44DO();
                    pCCMN44DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                    pCCMN44DInputRec.setUlIdPerson(csub45so.getROWCSUB45SOG01().getUlIdPerson());
                    
                    rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            csub45so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        else if (0 != csub45si.getUlIdEvent() /* IdEvent != 0 */
        ) {
            // 
            // (BEGIN): Retrieve DAM: ccmn45d      Event simple retrieve
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCCMN45DInputRec = new CCMN45DI();
            
            pCCMN45DOutputRec = new CCMN45DO();
            
            pCCMN45DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
            pCCMN45DInputRec.setUlIdEvent(csub45si.getUlIdEvent());
            
            //  Query to retrieve case
            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
            
            //  Analyze return code from both CRES04D and CRES54D
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub45so.getROWCSUB45SOG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                    csub45so.getROWCSUB45SOG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                    
                    csub45so.getROWCSUB45SOG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                    csub45so.getROWCSUB45SOG00().getSzCdEventStatus_ARRAY().setSzCdEventStatus(LEGAL_STATUS, pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                    csub45so.getROWCSUB45SOG00().getUlIdEvent_ARRAY().setUlIdEvent(LEGAL_STATUS, pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                    csub45so.getROWCSUB45SOG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                    csub45so.getROWCSUB45SOG00().setUlIdEventPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                    
                    csub45so.getROWCSUB45SOG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                    csub45so.getROWCSUB45SOG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                    
                    RetVal = SUCCESS;
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
            
            //  Check the stage record because it is possible to get to this point
            // cleanly with out have to check the case code
            if ((0 == csub45so.getROWCSUB45SOG00().getSzCdEventStatus_ARRAY().getSzCdEventStatus(LEGAL_STATUS).compareTo(STATUS_NEW)) && (RetVal == SUCCESS)) {
                
                if ((0 == SUB_CARE.compareTo(csub45si.getSzCdStage())) || (0 == ADOPTION.compareTo(csub45si.getSzCdStage()))) {
                    
                    // 
                    // (BEGIN): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCINV51DInputRec = new CINV51DI();
                    
                    pCINV51DOutputRec = new CINV51DO();
                    pCINV51DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                    
                    pCINV51DInputRec.setUlIdStage(csub45si.getUlIdStage());
                    pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                    
                    //  Update OR Insert into the CAPS_CASE table.
                    rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            csub45so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                            csub45so.getROWCSUB45SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                            
                            // 
                            // (BEGIN): Retrieve DAM: ccmn44d   Get NmPersonFull given IdPerson
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCCMN44DInputRec = new CCMN44DI();
                            
                            pCCMN44DOutputRec = new CCMN44DO();
                            pCCMN44DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                            
                            pCCMN44DInputRec.setUlIdPerson(csub45so.getROWCSUB45SOG01().getUlIdPerson());
                            
                            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                            
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    csub45so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
            }
            // 
            // (END): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
            // 
            
            
            
            //  Element cSysIndDamCalled is used because it was a 
            // pre-existing element used in the original design.
            // cSysIndDamCalled is used as the element for WindowMode
            else if ((csub45si.getCSysIndDamCalled() == WINDOW_MODE_NEW_USING) && (RetVal == SUCCESS)) {
                
                if ((0 == SUB_CARE.compareTo(csub45si.getSzCdStage())) || (0 == ADOPTION.compareTo(csub45si.getSzCdStage()))) {
                    
                    // 
                    // (BEGIN): Retrieve DAM: cses11d      Legal Status simple retrieve
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES11DInputRec = new CSES11DI();
                    
                    pCSES11DOutputRec = new CSES11DO();
                    
                    pCSES11DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                    pCSES11DInputRec.setUlIdLegalStatEvent(csub45si.getUlIdEvent());
                    //  Place the intake on the workload of the worker. This will 
                    // update STAGE, STAGE PERSON LINK, and other tables involved
                    // with placing an intake on a workload.
                    rc = cses11dQUERYdam(sqlca, pCSES11DInputRec, pCSES11DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            csub45so.getROWCSUB45SOG01().setUlIdLegalStatEvent(pCSES11DOutputRec.getUlIdLegalStatEvent());
                            csub45so.getROWCSUB45SOG01().setUlIdPerson(pCSES11DOutputRec.getUlIdPerson());
                            csub45so.getROWCSUB45SOG01().setDtDtLegalStatStatusDt(pCSES11DOutputRec.getDtDtLegalStatStatusDt());
                            
                            csub45so.getROWCSUB45SOG01().setTsLastUpdate(pCSES11DOutputRec.getTsLastUpdate());
                            csub45so.getROWCSUB45SOG01().setSzCdLegalStatCnty(pCSES11DOutputRec.getSzCdLegalStatCnty());
                            csub45so.getROWCSUB45SOG01().setSzCdLegalStatStatus(pCSES11DOutputRec.getSzCdLegalStatStatus());
                            csub45so.getROWCSUB45SOG01().setSzTxtLegalStatCauseNbr(pCSES11DOutputRec.getSzTxtLegalStatCauseNbr());
                            
                            csub45so.getROWCSUB45SOG01().setSzTxtLegalStatCourtNbr(pCSES11DOutputRec.getSzTxtLegalStatCourtNbr());
                            csub45so.getROWCSUB45SOG01().setSzCdCourtNbr(pCSES11DOutputRec.getSzCdCourtNbr());
                            csub45so.getROWCSUB45SOG01().setDtDtLegalStatTMCDismiss(pCSES11DOutputRec.getDtDtLegalStatTMCDismiss());
                            
                            // 
                            // (BEGIN): Retrieve DAM: cinv51d      Get IdPerson given IdStage & Role
                            // 
                            //  Allocate memory for DAM Input and Output Structures
                            pCINV51DInputRec = new CINV51DI();
                            
                            pCINV51DOutputRec = new CINV51DO();
                            pCINV51DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                            
                            pCINV51DInputRec.setUlIdStage(csub45si.getUlIdStage());
                            pCINV51DInputRec.setSzCdStagePersRole(PRIMARY_CHILD);
                            rc = cinv51dQUERYdam(sqlca, pCINV51DInputRec, pCINV51DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    csub45so.setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                    csub45so.getROWCSUB45SOG01().setUlIdPerson(pCINV51DOutputRec.getUlIdTodoPersAssigned());
                                    
                                    // 
                                    // (BEGIN): Retrieve DAM: ccmn44d   Get NmPersonFull given IdPerson
                                    // 
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCCMN44DInputRec = new CCMN44DI();
                                    
                                    pCCMN44DOutputRec = new CCMN44DO();
                                    
                                    pCCMN44DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                                    pCCMN44DInputRec.setUlIdPerson(csub45so.getROWCSUB45SOG01().getUlIdPerson());
                                    
                                    // Call DAM
                                    rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            csub45so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                    break;
                                    
                                default :
                                    
                                    
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                else // CdStage is != SUB or ADO
                {
                    
                    // 
                    // (BEGIN): Retrieve DAM: cses11d      Legal Status simple retrieve
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES11DInputRec = new CSES11DI();
                    
                    pCSES11DOutputRec = new CSES11DO();
                    pCSES11DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                    pCSES11DInputRec.setUlIdLegalStatEvent(csub45si.getUlIdEvent());
                    rc = cses11dQUERYdam(sqlca, pCSES11DInputRec, pCSES11DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            csub45so.getROWCSUB45SOG01().setUlIdLegalStatEvent(pCSES11DOutputRec.getUlIdLegalStatEvent());
                            csub45so.setUlIdPerson(pCSES11DOutputRec.getUlIdPerson());
                            csub45so.getROWCSUB45SOG01().setUlIdPerson(pCSES11DOutputRec.getUlIdPerson());
                            csub45so.getROWCSUB45SOG01().setDtDtLegalStatStatusDt(pCSES11DOutputRec.getDtDtLegalStatStatusDt());
                            
                            csub45so.getROWCSUB45SOG01().setTsLastUpdate(pCSES11DOutputRec.getTsLastUpdate());
                            csub45so.getROWCSUB45SOG01().setSzCdLegalStatCnty(pCSES11DOutputRec.getSzCdLegalStatCnty());
                            csub45so.getROWCSUB45SOG01().setSzCdLegalStatStatus(pCSES11DOutputRec.getSzCdLegalStatStatus());
                            csub45so.getROWCSUB45SOG01().setSzTxtLegalStatCauseNbr(pCSES11DOutputRec.getSzTxtLegalStatCauseNbr());
                            
                            csub45so.getROWCSUB45SOG01().setSzTxtLegalStatCourtNbr(pCSES11DOutputRec.getSzTxtLegalStatCourtNbr());
                            csub45so.getROWCSUB45SOG01().setSzCdCourtNbr(pCSES11DOutputRec.getSzCdCourtNbr());
                            csub45so.getROWCSUB45SOG01().setDtDtLegalStatTMCDismiss(pCSES11DOutputRec.getDtDtLegalStatTMCDismiss());
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
            }
            else // Mode is Modify or Inquire
            {
                
                // 
                // (BEGIN): Retrieve DAM: cses11d      Legal Status simple retrieve
                // 
                //  Allocate memory for DAM Input and Output Structures
                pCSES11DInputRec = new CSES11DI();
                
                pCSES11DOutputRec = new CSES11DO();
                
                pCSES11DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                pCSES11DInputRec.setUlIdLegalStatEvent(csub45si.getUlIdEvent());
                rc = cses11dQUERYdam(sqlca, pCSES11DInputRec, pCSES11DOutputRec);
                
                // Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        csub45so.getROWCSUB45SOG01().setUlIdLegalStatEvent(pCSES11DOutputRec.getUlIdLegalStatEvent());
                        csub45so.setUlIdPerson(pCSES11DOutputRec.getUlIdPerson());
                        csub45so.getROWCSUB45SOG01().setUlIdPerson(pCSES11DOutputRec.getUlIdPerson());
                        
                        csub45so.getROWCSUB45SOG01().setDtDtLegalStatStatusDt(pCSES11DOutputRec.getDtDtLegalStatStatusDt());
                        csub45so.getROWCSUB45SOG01().setTsLastUpdate(pCSES11DOutputRec.getTsLastUpdate());
                        csub45so.getROWCSUB45SOG01().setSzCdLegalStatCnty(pCSES11DOutputRec.getSzCdLegalStatCnty());
                        csub45so.getROWCSUB45SOG01().setSzCdLegalStatStatus(pCSES11DOutputRec.getSzCdLegalStatStatus());
                        
                        csub45so.getROWCSUB45SOG01().setSzTxtLegalStatCauseNbr(pCSES11DOutputRec.getSzTxtLegalStatCauseNbr());
                        csub45so.getROWCSUB45SOG01().setSzTxtLegalStatCourtNbr(pCSES11DOutputRec.getSzTxtLegalStatCourtNbr());
                        csub45so.getROWCSUB45SOG01().setSzCdCourtNbr(pCSES11DOutputRec.getSzCdCourtNbr());
                        csub45so.getROWCSUB45SOG01().setDtDtLegalStatTMCDismiss(pCSES11DOutputRec.getDtDtLegalStatTMCDismiss());
                        
                        // 
                        // (BEGIN): Retrieve DAM: ccmn44d   Get NmPersonFull given IdPerson
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCCMN44DInputRec = new CCMN44DI();
                        
                        pCCMN44DOutputRec = new CCMN44DO();
                        
                        pCCMN44DInputRec.setArchInputStruct(csub45si.getArchInputStruct());
                        pCCMN44DInputRec.setUlIdPerson(csub45so.getROWCSUB45SOG01().getUlIdPerson());
                        
                        //  Call DAM
                        rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub45so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub45si.getArchInputStruct() , csub45so.getArchOutputStruct());
        
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
        return csub45so;
    }

    static int CallCCMN87D(CSUB45SI pInputMsg841, CSUB45SO pOutputMsg786, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg841.getArchInputStruct());
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.setUlIdStage(pInputMsg841.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CLOSURE_EVENT_TYPE);
        
        
        /*
        ** Start Performance Timer
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg786.getROWCSUB45SOG00().getSzCdEventStatus_ARRAY().setSzCdEventStatus(STAGE_CLOSURE, pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus());
                pOutputMsg786.getROWCSUB45SOG00().getUlIdEvent_ARRAY().setUlIdEvent(STAGE_CLOSURE, pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                
                
                //  Initialize Service Status Fields
                
                
                //  Perform Main Processing
                
                //  Set CFAD32SO WCD DtSystemDate to current date
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg786.getROWCSUB45SOG00().getSzCdEventStatus_ARRAY().setSzCdEventStatus(STAGE_CLOSURE, EVENT_STATUS_NEW);
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

}
