package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN33SO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN85DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN85DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN82DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN82DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVD2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVD2DO;
/**************************************************************************
** 
** Service Name:  CCMN33S.src
**
** Description:   This service calls three dams:
**                CCMN87D: input:  dynamic: up to 10 variables (2 can repeat
**                                 up to 40 times)
**                         output: Data for Event List window's ListBox 
**
**                CCMN85D: input:  ID_EVENT
**                         output: NM_PERSON_FULL from the PERSON table
**                 or "MULTIPLE" if more than one person
**                 is associated with the ID_EVENT
**
**                CCMN82D: input:  CD_TASK
**                         output: one entire row from the TASK table
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/18/95 
** 
** Programmer:    Gwin S. Pitman
**
** Date     Initials        Description
** ------   ---------       ------------------------------------------------ 
** 3/15/95    GSP           SIR 168 Service should return task Decode for 
**                          populating event list header.
** 07/28/95   DMV           SIR 647 Added Sensative Case Message.
** 11/16/95 YANTISTK        SIR#2074 Commented out code dealing with
**                          bIndTaskApprovalAvail, because it was removed
**                          from the Task Table.
** 06/27/97 CYSKD           SVC AUTH ENH -- If no events are returned by
**                          CCMN87D the Output message still needs to be 
**                          returned so that CCMN51W can use info from CINT21D.
** 08/19/99 SOHNJJ          SIR 15049 - This enhancement will retrieve the
**                          IRA indicator from the RISK_ASSESSMENT table and
**                          return it to the window CCMN51W. 
** 2/01/03  Srini D         Added bIndFilteredSensitiveEvents to the CCMN33SO
**                          struct to indicate the service has filtered the  
**							Sensitive events.( As per Matt's request)	
**
**  04/30/03   Srini		SIR 17091: Added the error handling to take care of full 
**							table scans for ccmn87dQUERYdam.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn33s {
    public static final char IS_SENSITIVE = 'Y';
    CCMN33SO CCMN33S(CCMN33SI ccmn33si) {
        CCMN33SO ccmn33so = new CCMN33SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int row = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccmn33si.getArchInputStruct());
        rc = Ccmn02u.CallCINT21D(ccmn33si, ccmn33so, pServiceStatus);
        switch (rc) {
            case SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccmn02u.CallCCMN87D(ccmn33si, ccmn33so, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case SUCCESS:
                break;
            case Messages.MSG_CMN_NO_EVENT_FOUND:
                
                // 
                // Load translation map with service name and version 
                // 
                
                //  Stop performance timer for service 
                ARC_PRFServiceStopTime_TUX(ccmn33si.getArchInputStruct() , ccmn33so.getArchOutputStruct());
                rc = SUCCESS;
                break;
                
                // case MSG_CMN_NO_EVENT_FOUND:
                // return (0);
                // break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** For every row returned from the previous dam, find people associated
        ** with it.  If there is a CD_TASK associated with the event, call dam 
        ** to return task information from Task Table
        */
        for (row = 0;(row < ccmn33so.getArchOutputStruct().getUlRowQty());row++) {
            rc = CallCCMN85D(ccmn33si, ccmn33so, pServiceStatus, row);
            
            //## BEGIN TUX/XML: Declare XML variables 
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            if (ccmn33so.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).getSzCdTask()[0] != null) {
                rc = CallCCMN82D(ccmn33si, ccmn33so, pServiceStatus, row);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                if (ccmn33so.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).getSzCdTask().equals("2290")) {
                    rc = CallCINVD2D(ccmn33si, ccmn33so, pServiceStatus, row);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        /**************************************************************************
        **  Load translation map with service name and version 
        ***************************************************************************/
        
        
        /********** Stop performance timer for service ****************************/
        ARC_PRFServiceStopTime_TUX(ccmn33si.getArchInputStruct() , ccmn33so.getArchOutputStruct());
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
        return ccmn33so;
    }

    
    static int CallCINT21D(CCMN33SI pInputMsg289, CCMN33SO pOutputMsg272, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /********** local variables ***********************************************/
        
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /**************************************************************************
        ** Allocate memory for Input and Output Structures
        ***************************************************************************/
        pCINT21DInputRec = new CINT21DI();
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setUlIdStage(pInputMsg289.getUlIdStage());
        /*
        ** Do nothing, the output message just returns success or
        ** failure.
        */
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        
        if (rc != SUCCESS) {
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  Call DAM
                    rc = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg272.setDtDtStageClose(pCINT21DOutputRec.getDtDtStageClose());
            pOutputMsg272.setSzCdStageReasonClosed(pCINT21DOutputRec.getSzCdStageReasonClosed());
        }
        return rc;
    }

    static int CallCCMN87D(CCMN33SI pInputMsg290, CCMN33SO pOutputMsg273, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i155 = 0;
        int d = 0;/* Loop counter */
        /********** local variables ***********************************************/
        
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        
        /**************************************************************************
        ** Allocate memory for Input and Output Structures
        ***************************************************************************/
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg290.getArchInputStruct().getCReqFuncCd());
        pCCMN87DInputRec.setUlIdCase(pInputMsg290.getUlIdCase());
        pCCMN87DInputRec.setUlIdSituation(pInputMsg290.getUlIdSituation());
        pCCMN87DInputRec.setUlIdStage(pInputMsg290.getUlIdStage());
        pCCMN87DInputRec.setUlIdPerson(pInputMsg290.getUlIdPerson());
        pCCMN87DInputRec.setUlIdEventPerson(pInputMsg290.getUlIdEventPerson());
        pCCMN87DInputRec.setSzCdTask(pInputMsg290.getSzCdTask());
        
        for (i155 = 0;pInputMsg290.getROWCCMN33SI_ARRAY().getROWCCMN33SI(i155).getSzCdEventType()[0] != null;i155++) {
            pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(i155).setSzCdEventType(pInputMsg290.getROWCCMN33SI_ARRAY().getROWCCMN33SI(i155).getSzCdEventType());
        }
        for (i155 = 0;pInputMsg290.getROWCCMN33SI_ARRAY().getROWCCMN33SI(i155).getSzCdStage()[0] != null;i155++) {
            pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(i155).setSzCdStage(pInputMsg290.getROWCCMN33SI_ARRAY().getROWCCMN33SI(i155).getSzCdStage());
        }
        pCCMN87DInputRec.setDtScrDtStartDt(pInputMsg290.getDtScrDtStartDt());
        pCCMN87DInputRec.setDtScrDtEventEnd(pInputMsg290.getDtScrDtEventEnd());
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg290.getArchInputStruct().getUsPageNbr());
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg290.getArchInputStruct().getUlPageSizeNbr());
        /*
        ** SQL_NOT_FOUND is a valid return code
        */
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        /*
        ** IMPACT END
        */
        
        
        /* SIR 3200 - Reset the value of ulRowQty to 1 because only one row
        ** will be returned to the client  BSM
        **
        ** IMPACT BEGIN - this code was moved up above
        **  pOutputMsg->ArchOutputStruct.ulRowQty = ONE_ROW;
        ** IMPACT END
        */
        
        /*
        ** SIR 2851
        ** Revised check of Unit Program to be against entire string "APS"
        */
        if (rc != SUCCESS) {
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CMN_NO_EVENT_FOUND;
                    rc = Messages.MSG_CMN_NO_EVENT_FOUND;
                    
                    break;
                case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    
                    //  Call DAM
                    rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    
                    // 
                    // End Call to Check for Unit Approval Dam - CSES45D
                    // 
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg273.setBIndFilteredSensitiveEvents(false);
            i155 = 0;
            for (d = 0;d < pCCMN87DOutputRec.getArchOutputStruct().getUlRowQty();++d) {
                if (IS_SENSITIVE == pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getBIndCaseSensitive() &&!(pInputMsg290.getBIndCaseSensitive() != 0)) {
                    pOutputMsg273.setBIndFilteredSensitiveEvents(true);
                }
                
                else {
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setDtDtEventOccurred(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getDtDtEventOccurred());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getSzCdEventStatus());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setSzCdEventType(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getSzCdEventType());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setSzScrCaseWorker(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getSzScrCaseWorker());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setSzTxtEventDescr(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getSzTxtEventDescr());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setSzNmStage(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getSzNmStage());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setUlIdCase(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getUlIdCase());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getUlIdEvent());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setUlIdStage(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getUlIdStage());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setSzCdStage(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getSzCdStage());
                    pOutputMsg273.getROWCCMN33SO_ARRAY().getROWCCMN33SO(i155).setSzCdTask(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(d).getSzCdTask());
                    i155++;
                }
            }
            pOutputMsg273.getArchOutputStruct().setUlRowQty(i155);
            pOutputMsg273.getArchOutputStruct().setBMoreDataInd(pCCMN87DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCCMN85D(CCMN33SI * pInputMsg291, CCMN33SO pOutputMsg274, Arcxmlerrors.TUX_DECL_STATUSPARMS, int row) {
        int rc = 0;/* Return code */
        int i156 = 0;
        /********** local variables ***********************************************/
        CCMN85DI pCCMN85DInputRec = null;
        CCMN85DO pCCMN85DOutputRec = null;
        
        
        /**************************************************************************
        ** Allocate memory for Input and Output Structures
        ***************************************************************************/
        pCCMN85DInputRec = new CCMN85DI();
        pCCMN85DOutputRec = new CCMN85DO();
        pCCMN85DInputRec.setUlIdEvent(pOutputMsg274.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).getUlIdEvent());
        pCCMN85DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN85DInputRec.getArchInputStruct().setUlPageSizeNbr(3);
        /*
        ** Copies rows from the INCOMING_PHONE table to the
        ** PERSON_PHONE table
        */
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        /*
        ** Copies rows from the INCOMING_PERSON_ID table to the
        ** PERSON_ID table
        */
        rc = ccmn85dQUERYdam(sqlca, pCCMN85DInputRec, pCCMN85DOutputRec);
        if (rc != SUCCESS) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    //  Copies rows from the INCOMING_PERSON_RACE table to the
                    // PERSON_RACE table
                    rc = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg274.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).setSzScrPersonNameEvent(pCCMN85DOutputRec.getSzScrPersonNameEvent());
            
            
        }
        return rc;
    }

    static int CallCCMN82D(CCMN33SI * pInputMsg292, CCMN33SO pOutputMsg275, Arcxmlerrors.TUX_DECL_STATUSPARMS, int row) {
        int rc = 0;/* Return code */
        /********** local variables ***********************************************/
        
        CCMN82DI pCCMN82DInputRec = null;
        CCMN82DO pCCMN82DOutputRec = null;
        
        /**************************************************************************
        ** Allocate memory for Input and Output Structures
        ***************************************************************************/
        pCCMN82DInputRec = new CCMN82DI();
        pCCMN82DOutputRec = new CCMN82DO();
        pCCMN82DInputRec.setSzCdTask(pOutputMsg275.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).getSzCdTask());
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = ccmn82dQUERYdam(sqlca, pCCMN82DInputRec, pCCMN82DOutputRec);
        
        if (rc != SUCCESS) {
            
            // populate Input Structure for DAM
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg275.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).setSzCdTaskTopWindow(pCCMN82DOutputRec.getSzCdTaskTopWindow());
            pOutputMsg275.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).setSzCdTaskEventStatus(pCCMN82DOutputRec.getSzCdEventStatus());
            pOutputMsg275.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).setBIndTaskEventNavig(pCCMN82DOutputRec.getBIndTaskEventNavig());
            pOutputMsg275.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).setBIndTaskMultInstance(pCCMN82DOutputRec.getBIndTaskMultInstance());
            pOutputMsg275.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).setCIndTaskNewUsing(pCCMN82DOutputRec.getCIndTaskNewUsing());
            
            if (pOutputMsg275.getSzTxtTaskDecode()[0] == null) {
                pOutputMsg275.setSzTxtTaskDecode(pCCMN82DOutputRec.getSzTxtTaskDecode());
            }
        }
        return rc;
    }

    static int CallCINVD2D(CCMN33SI pInputMsg293, CCMN33SO pOutputMsg276, Arcxmlerrors.TUX_DECL_STATUSPARMS, int row) {
        int rc = 0;/* Return code */
        /********** local variables ***********************************************/
        
        CINVD2DI pCINVD2DInputRec = null;
        CINVD2DO pCINVD2DOutputRec = null;
        
        /**************************************************************************
        ** Allocate memory for Input and Output Structures
        ***************************************************************************/
        pCINVD2DInputRec = new CINVD2DI();
        pCINVD2DOutputRec = new CINVD2DO();
        
        pCINVD2DInputRec.setUlIdStage(pInputMsg293.getUlIdStage());
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = cinvd2dQUERYdam(sqlca, pCINVD2DInputRec, pCINVD2DOutputRec);
        
        if (rc != SUCCESS) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else if ((pOutputMsg276.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).getSzCdTask().equals("2290")) && (pCINVD2DOutputRec.getCIndRiskAssmtIntranet().equals("Y"))) {
            pOutputMsg276.getROWCCMN33SO_ARRAY().getROWCCMN33SO(row).setBIndTaskEventNavig('0');
        }
        return rc;
    }

}
