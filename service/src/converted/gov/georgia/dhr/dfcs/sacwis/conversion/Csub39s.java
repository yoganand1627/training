package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB40UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD03DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD03DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD07DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS07DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/***************************************************************************
** 
** Module File:   CSUB39S.src
**
** Service Name:  CSUB39S
**
** Description:   This is the save service for 
**                the Legal Action/Outcome window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12Oct95
** 
** Programmer:    Mary Sladewski
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:17:20  $
**                      $Modtime:   30 Mar 1996 00:27:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   18Oct95  sladewmf  Initial check-in
**   29Nov95  walkerbd  Changes documented in code. Search on 29Nov95.
**  12/14/95  WILSONET  SIR#2171, 2175, 2178, 2185 - (Search on SIR#2171)
**                      The Save Service was modified to correspond to 
**                      the new window code and to meet standards
**
**  01/20/96  MCRAEBS   SIR 2789 - ToDo due date should be set to one year 
**                      from working date if the Legal Action Subtype is 
**                      Income Tax or Annual Accounting Reports.
**  01/20/96  DYARGR    SIR 2968 - Create a todo for Monthly status for
**                      AOC stages only
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub39s {
    public static final int FND_FAILURE = 1;
    public static final String TODO_INFO_12_CODE = "SUB012";
    public static final String TODO_INFO_13_CODE = "SUB013";
    public static final String TODO_INFO_23_CODE = "SUB023";
    public static final String TODO_INFO_25_CODE = "SUB025";
    public static final String TODO_HEARING = "CCHE";
    public static final String TODO_23_SUBTYPE = "020";
    public static final String TODO_25_1_SUBTYPE = "050";
    public static final String TODO_25_2_SUBTYPE = "060";
    public static final String TODO_GUARDIAN = "CAGA";
    public static final String TODO_12_SUBTYPE = "060";
    public static final String TODO_13_SUBTYPE = "070";
    
    
    /* Added COMP in order to determine whether ToDo should be updated */
    public static final String STATUS_COMPLETE = "COMP";
    public static final String AGING_OUT = "AOC";
    public static final String CONTACT_TODO = "AOC003";
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String CONTACT_TYPE = "CON";
    public static final String CONTACT_CD_TASK = "5010";
    public static final String MONTHLY_CONTACT = "Monthly Status Contact";
    public static final int NULL_DATE = - 1;
    public static final String MONTHLY_CONTACT_TYPE = "CMST";
    CSUB39SO CSUB39S(CSUB39SI csub39si) {
        CSUB39SO csub39so = new CSUB39SO();
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
        int lrc = SUCCESS;
        int RetVal = SUCCESS;
        FndInt3date CurrentDate = null;
        FndInt3date WorkingDate = null;
        
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        CCMN01UI pCCMN01UInputRec = null;/* Post Event common function */
        CCMN01UO pCCMN01UOutputRec = null;
        CSUB40UI pCSUB40UInputRec = null;/* ToDo common function: from ToDoInfo */
        
        CSUB40UO pCSUB40UOutputRec = null;
        CAUD03DI pCAUD03DInputRec = null;/* Legal Action Generic AUD dam        */
        
        CAUD03DO pCAUD03DOutputRec = null;
        
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        CAUD07DI pCAUD07DInputRec = null;/* Stored Procedure: Complex Delete    */
        CAUD07DO pCAUD07DOutputRec = null;/* on EVENT, EVENT_PERSON_LINK, & TODO */
        CSES06DI pCSES06DInputRec = null;/* Legal Action simple retrieve        */
        
        
        CSES06DO pCSES06DOutputRec = null;
        
        /* 
        ** SIR 2986
        */
        CCMN46DI pCCMN46DInputRec = null;
        CCMN46DO pCCMN46DOutputRec = null;
        
        CSYS07DI pCSYS07DInputRec = null;
        CSYS07DO pCSYS07DOutputRec = null;
        
        
        /*
        ** Call CSES68D
        */
        rc = ARC_PRFServiceStartTime_TUX(csub39si.getArchInputStruct());
        
        /*
        ** Initialize Service Status Fields 
        */
        
        /*
        **  Perform Main Processing
        */
        
        /**************************************************************************
        ** (BEGIN): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(csub39si.getArchInputStruct());
        if (0 != csub39si.getROWCCMN01UIG00().getUlIdEvent()) {
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        }
        else {
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        }
        pCCMN06UInputRec.setUlIdStage(csub39si.getROWCCMN01UIG00().getUlIdStage());
        
        pCCMN06UInputRec.setSzCdTask(csub39si.getROWCCMN01UIG00().getSzCdTask());
        
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
        if ((SUCCESS == RetVal) && ((WtcHelperConstants.REQ_FUNC_CD_ADD == csub39si.getArchInputStruct().getCReqFuncCd()) || (ServiceConstants.REQ_FUNC_CD_UPDATE == csub39si.getArchInputStruct().getCReqFuncCd()))) {
            // 
            // (BEGIN): Common Function: ccmn01u   Post Event common function
            // 
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN01UInputRec = new CCMN01UI();
            
            pCCMN01UOutputRec = new CCMN01UO();
            pCCMN01UInputRec.setArchInputStruct(csub39si.getArchInputStruct());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(csub39si.getROWCCMN01UIG00().getUlIdEvent());
            pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(csub39si.getROWCCMN01UIG00().getTsLastUpdate());
            pCCMN01UInputRec.getROWCCMN01UIG00().setDtDtEventOccurred(csub39si.getROWCCMN01UIG00().getDtDtEventOccurred());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(csub39si.getROWCCMN01UIG00().getUlIdStage());
            pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(csub39si.getROWCCMN01UIG00().getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(csub39si.getROWCCMN01UIG00().getSzCdTask());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(csub39si.getROWCCMN01UIG00().getSzCdEventStatus());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(csub39si.getROWCCMN01UIG00().getSzCdEventType());
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(csub39si.getROWCCMN01UIG00().getSzTxtEventDescr());
            pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setUlIdPerson(csub39si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getUlIdPerson());
            pCCMN01UInputRec.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).setSzCdScrDataAction(csub39si.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0).getSzCdScrDataAction());
            
            
            if (0 == csub39si.getROWCCMN01UIG00().getUlIdEvent()) {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else {
                pCCMN01UInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            
            //  Set rc to MSG_DETAIL_DELETED
            rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub39so.setUlIdLegalActEvent(pCCMN01UOutputRec.getUlIdEvent());
                    csub39si.getROWCCMN01UIG00().setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                    csub39so.setTsLastUpdate(pCCMN01UOutputRec.getTsLastUpdate());
                    
                    
                    if (0 == STATUS_COMPLETE.compareTo(csub39si.getROWCCMN01UIG00().getSzCdEventStatus())) {
                        // 
                        // (BEGIN): Update DAM: cinv43d      ToDo Complete AUD dam: update only
                        // 
                        //  Allocate memory for DAM Input and Output Structures
                        pCINV43DInputRec = new CINV43DI();
                        
                        pCINV43DOutputRec = new CINV43DO();
                        pCINV43DInputRec.setArchInputStruct(csub39si.getArchInputStruct());
                        pCINV43DInputRec.setUlIdEvent(csub39si.getROWCCMN01UIG00().getUlIdEvent());
                        
                        
                        //  Call CSES41D
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
                                
                                
                                //  Call CSES75D
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
                    
                    // 
                    // (BEGIN): Add/Update AUD DAM: caud03d      Legal Action Generic AUD dam
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCAUD03DInputRec = new CAUD03DI();
                    
                    pCAUD03DOutputRec = new CAUD03DO();
                    pCAUD03DInputRec.setArchInputStruct(csub39si.getArchInputStruct());
                    pCAUD03DInputRec.getArchInputStruct().setCReqFuncCd(csub39si.getArchInputStruct().getCReqFuncCd());
                    if (0 == csub39si.getROWCSUB39SIG00().getUlIdLegalActEvent()) {
                        pCAUD03DInputRec.setUlIdLegalActEvent(csub39si.getROWCCMN01UIG00().getUlIdEvent());
                    }
                    else // (0 != pInputMsg->ROWCSUB39SIG00.ulIdLegalActEvent)
                    {
                        pCAUD03DInputRec.setUlIdLegalActEvent(csub39si.getROWCSUB39SIG00().getUlIdLegalActEvent());
                        
                        pCAUD03DInputRec.setTsLastUpdate(csub39si.getROWCSUB39SIG00().getTsLastUpdate());
                    }
                    pCAUD03DInputRec.setUlIdPerson(csub39si.getROWCSUB39SIG00().getUlIdPerson());
                    pCAUD03DInputRec.setSzCdLegalActAction(csub39si.getROWCSUB39SIG00().getSzCdLegalActAction());
                    pCAUD03DInputRec.setSzCdLegalActActnSubtype(csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype());
                    pCAUD03DInputRec.setSzCdLegalActOutcome(csub39si.getROWCSUB39SIG00().getSzCdLegalActOutcome());
                    pCAUD03DInputRec.setDtDtLegalActDateFiled(csub39si.getROWCSUB39SIG00().getDtDtLegalActDateFiled());
                    pCAUD03DInputRec.setDtDtLegalActOutcomeDt(csub39si.getROWCSUB39SIG00().getDtDtLegalActOutcomeDt());
                    pCAUD03DInputRec.setCIndLegalActDocsNCase(csub39si.getROWCSUB39SIG00().getCIndLegalActDocsNCase());
                    pCAUD03DInputRec.setSzTxtLegalActComment(csub39si.getROWCSUB39SIG00().getSzTxtLegalActComment());
                    
                    
                    //  Call CSES68D
                    rc = caud03dAUDdam(sqlca, pCAUD03DInputRec, pCAUD03DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            if (INDICATOR_YES == csub39si.getBSysIndGeneric()) {
                                // 
                                // (BEGIN): Retrieve DAM: cses06d      Legal Action simple retrieve
                                // 
                                //  Allocate memory for DAM Input and Output Structures
                                pCSES06DInputRec = new CSES06DI();
                                
                                pCSES06DOutputRec = new CSES06DO();
                                pCSES06DInputRec.setArchInputStruct(csub39si.getArchInputStruct());
                                pCSES06DInputRec.setUlIdLegalActEvent(pCAUD03DInputRec.getUlIdLegalActEvent());
                                
                                rc = cses06dQUERYdam(sqlca, pCSES06DInputRec, pCSES06DOutputRec);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        //  Set RetVal to FND_SUCCESS
                                        RetVal = SUCCESS;
                                        
                                        csub39so.setTsSysTsLastUpdate2(pCSES06DOutputRec.getTsLastUpdate());
                                        break;
                                        
                                    default :
                                        
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                            }
                            
                            //  Update the Cd Stage Type on the Stage table.
                            // SIR2850 : Correct Brackets. Should be (SERV_DELIVERY && APS)
                            // OR (SERV_DELIVERY &&  CONTRACTED).
                            // SIR 18955, RIOSJA - While testing the fix for SIR 18955, I
                            // discovered that a condition was missing from this if statement.
                            // The stage type should be changed to GUA only if the Closure
                            // Date is null. I added that condition.
                            // SIR 23803 - Added new guardianship type DAD, this will
                            // be used in the place of APS
                            if ((0 < csub39si.getUlSysIdTodoCfPersCrea()) && (RetVal == SUCCESS)) {
                                // 
                                // (BEGIN): Common Function: csub40u  ToDo common function: from ToDoInfo
                                // 
                                //  Allocate memory for Common Function Input and Output Structures
                                pCSUB40UInputRec = new CSUB40UI();
                                
                                pCSUB40UOutputRec = new CSUB40UO();
                                pCSUB40UInputRec.setArchInputStruct(csub39si.getArchInputStruct());
                                if (0 != AGING_OUT.compareTo(csub39si.getSzCdStage())) {
                                    if (0 == TODO_HEARING.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActAction())) {
                                        // SIR 23694 - Check the stage type. If stage type is REG set stage type as GUA
                                        // or else if C-REG change stage type to C-GUA.
                                        if (0 == TODO_23_SUBTYPE.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype())) {
                                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_23_CODE);
                                        }
                                        else if ((0 == TODO_25_1_SUBTYPE.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype())) || (0 == TODO_25_2_SUBTYPE.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype()))) {
                                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_25_CODE);
                                        }
                                    }
                                    else if (0 == TODO_GUARDIAN.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActAction())) {
                                        
                                        // 
                                        // (END): CAUD36D
                                        // 
                                        
                                        if (0 == TODO_12_SUBTYPE.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype())) {
                                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_12_CODE);
                                        }
                                        else if (0 == TODO_13_SUBTYPE.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype())) {
                                            pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(TODO_INFO_13_CODE);
                                        }
                                    }
                                    
                                    // 
                                    // (END): CINV51D
                                    // 
                                    
                                    if ((0 == TODO_GUARDIAN.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActAction())) && (0 == TODO_13_SUBTYPE.compareTo(csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype()))) {
                                        
                                        //  Set rc to MSG_DETAIL_DELETED
                                        rc = ARC_UTLGetDateAndTime(CurrentDate, 0);
                                        
                                        // Set the Month of the Working Date to 2
                                        WorkingDate.month = 2;
                                        
                                        // Set the Day of the Working Date to 15
                                        WorkingDate.day = 15;
                                        
                                        // Set the Year of the Working Date to the Year of the Current Date
                                        WorkingDate.year = CurrentDate.year;
                                        
                                        // Compare the Working Date with the Current Date
                                        lrc = ARC_UTLCompareDateAndTime((FndInt3date) & CurrentDate, (char) 0, (FndInt3date) & WorkingDate, (char) 0);
                                        if (lrc < 0 && 0 != csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype().compareTo(TODO_12_SUBTYPE) && 0 != csub39si.getROWCSUB39SIG00().getSzCdLegalActActnSubtype().compareTo(TODO_13_SUBTYPE)) {
                                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(WorkingDate);
                                        }
                                        else {
                                            WorkingDate.year++;
                                            pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(WorkingDate);
                                        }
                                    }
                                    else {
                                        pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub39si.getROWCSUB39SIG00().getDtDtLegalActOutcomeDt());
                                    }
                                    pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(csub39si.getROWCCMN01UIG00().getUlIdEvent());
                                }
                                
                                //  SIR 2986
                                // Everything added in the else to create the contact for AOC
                                else {
                                    pCSUB40UInputRec.getCSUB40UIG00().setSzSysCdTodoCf(CONTACT_TODO);
                                    pCSUB40UInputRec.getCSUB40UIG00().setDtSysDtTodoCfDueFrom(csub39si.getROWCSUB39SIG00().getDtDtLegalActDateFiled());
                                    pCSUB40UInputRec.getCSUB40UIG00().getDtSysDtTodoCfDueFrom().day = 20;
                                    
                                    //  Create the new event
                                    // 
                                    // BEGIN CCMN46D: Create Event
                                    // 
                                    //  Allocate memory for Input and Output Structures
                                    pCCMN46DInputRec = new CCMN46DI();
                                    
                                    pCCMN46DOutputRec = new CCMN46DO();
                                    pCCMN46DInputRec.setArchInputStruct(csub39si.getArchInputStruct());
                                    pCCMN46DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                    pCCMN46DInputRec.setDtDtEventOccurred(csub39si.getROWCSUB39SIG00().getDtDtLegalActDateFiled());
                                    pCCMN46DInputRec.setUlIdStage(csub39si.getUlIdStage());
                                    pCCMN46DInputRec.setUlIdPerson(csub39si.getUlSysIdTodoCfPersCrea());
                                    pCCMN46DInputRec.setSzTxtEventDescr(MONTHLY_CONTACT);
                                    pCCMN46DInputRec.setSzCdEventStatus(EVENT_STATUS_NEW);
                                    pCCMN46DInputRec.setSzCdTask(CONTACT_CD_TASK);
                                    pCCMN46DInputRec.setSzCdEventType(CONTACT_TYPE);
                                    
                                    
                                    //  Call CSES68D
                                    rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfEvent(pCCMN46DOutputRec.getUlIdEvent());
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    }
                                }
                                
                                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfStage(csub39si.getUlIdStage());
                                
                                pCSUB40UInputRec.getCSUB40UIG00().setUlSysIdTodoCfPersCrea(csub39si.getUlSysIdTodoCfPersCrea());
                                
                                rc = Csub40u.TodoCommonFunction(pCSUB40UInputRec, pCSUB40UOutputRec, pServiceStatus);
                                
                                //  Analyze return code
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        if (0 == AGING_OUT.compareTo(csub39si.getSzCdStage())) {
                                            // 
                                            // CSYS07D Begin : Create contact shell record
                                            // 
                                            //  Allocate memory for Input and Output Structures
                                            pCSYS07DInputRec = new CSYS07DI();
                                            
                                            pCSYS07DOutputRec = new CSYS07DO();
                                            pCSYS07DInputRec.setArchInputStruct(csub39si.getArchInputStruct());
                                            pCSYS07DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                            pCSYS07DInputRec.setUlIdEvent(pCSUB40UOutputRec.getUlIdEvent());
                                            pCSYS07DInputRec.setUlIdStage(pCSUB40UOutputRec.getUlIdStage());
                                            pCSYS07DInputRec.setUlIdPerson(pCSUB40UOutputRec.getUlIdTodoPersAssigned());
                                            pCSYS07DInputRec.setSzCdContactType(MONTHLY_CONTACT_TYPE);
                                            pCSYS07DInputRec.getDtDtMonthlySummBegin().day = NULL_DATE;
                                            pCSYS07DInputRec.getDtDtMonthlySummBegin().month = NULL_DATE;
                                            pCSYS07DInputRec.getDtDtMonthlySummBegin().year = NULL_DATE;
                                            pCSYS07DInputRec.getDtDtMonthlySummEnd().day = NULL_DATE;
                                            
                                            pCSYS07DInputRec.getDtDtMonthlySummEnd().month = NULL_DATE;
                                            
                                            pCSYS07DInputRec.getDtDtMonthlySummEnd().year = NULL_DATE;
                                            
                                            pCSYS07DInputRec.getDtDTContactOccurred().day = NULL_DATE;
                                            pCSYS07DInputRec.getDtDTContactOccurred().month = NULL_DATE;
                                            pCSYS07DInputRec.getDtDTContactOccurred().year = NULL_DATE;
                                            
                                            //  Set rc to MSG_DETAIL_DELETED
                                            rc = csys07dAUDdam(sqlca, pCSYS07DInputRec, pCSYS07DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    
                                                    // Set rc to ARC_SUCCESS
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                default :
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            }
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
                            }
                            // SIR 23096 End
                            
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
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
        }
        /**************************************************************************
        ** (END): Common Function: ccmn01u  ** Post Event common function
        **************************************************************************/
        else if (SUCCESS == RetVal) {
            // 
            // (BEGIN): Delete DAM: caud03d      Legal Action Generic AUD dam
            // 
            //  Allocate memory for DAM Input and Output Structures
            pCAUD03DInputRec = new CAUD03DI();
            
            pCAUD03DOutputRec = new CAUD03DO();
            pCAUD03DInputRec.setArchInputStruct(csub39si.getArchInputStruct());
            pCAUD03DInputRec.getArchInputStruct().setCReqFuncCd(csub39si.getArchInputStruct().getCReqFuncCd());
            
            pCAUD03DInputRec.setUlIdLegalActEvent(csub39si.getROWCSUB39SIG00().getUlIdLegalActEvent());
            pCAUD03DInputRec.setTsLastUpdate(csub39si.getROWCSUB39SIG00().getTsLastUpdate());
            
            
            //  Call CSES75D
            rc = caud03dAUDdam(sqlca, pCAUD03DInputRec, pCAUD03DOutputRec);
            
            
            //  Analyze error code
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
                    pCAUD07DInputRec.setArchInputStruct(csub39si.getArchInputStruct());
                    pCAUD07DInputRec.setUlIdEvent(csub39si.getROWCCMN01UIG00().getUlIdEvent());
                    pCAUD07DInputRec.setTsLastUpdate(csub39si.getROWCCMN01UIG00().getTsLastUpdate());
                    
                    
                    //  Call CSEC70D
                    rc = caud07dAUDdam(sqlca, pCAUD07DInputRec, pCAUD07DOutputRec);
                    
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
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
        }
        
        /*
        ** Load Translation Map
        */
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub39si.getArchInputStruct() , csub39so.getArchOutputStruct());
        
        /*
        ** Set pCCMN01UInputRec ReqFuncCode
        */
        if (RetVal == SUCCESS) {
            
            
            //  Call CSES68D
            rc = SUCCESS;
        }
        
        
        /*
        ** Set the Id Event and Time stamp
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  If an event was passed into the service,
            // check for todo's .... if any are found,  complete them
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
        return csub39so;
    }

}
