package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC21DO;
/**************************************************************************
**
** Module File:   CSVC15S.SRC
**
** Service Name:  CSVC15S - RETRIEVE LIST
**
** Description:   Retrieves information for the List Boxes.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/15/94
**
** Programmer:    Wendy Purtle
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  10/06/95  BRUCKMK   SIR 1672: Error in opening Event with Status NEW,
**                      because service assumes that if ID_EVENT != 0, rows
**                      must already exist in the Service Delivery Detail
**                      Table.  Must pass Event Status to Services and check
**                      for condition of event status = NEW.
**
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
**
**  06/23/05  dunawakl  SIR 23664 : Added variables for new service delivery closure fields
**  09/08/05  yeehp     SIR 23771 : Added variable for service delivery closure fields
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csvc15s {
    CSVC15SO CSVC15S(CSVC15SI csvc15si) {
        CSVC15SO csvc15so = new CSVC15SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        rc = ARC_PRFServiceStartTime_TUX(csvc15si.getArchInputStruct());
        
        rc = Ccmn80s.CallCINT40D(csvc15si, csvc15so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case Messages.MSG_NO_ROWS_RETURNED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
                // 
                // END Retrieval for CCMN31D EMPLOYEE SKILLS
                // 
                
                
                // 
                // CONTINUE Retrieval for CRES04D GET MAX PERIOD TERM
                // 
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (csvc15si.getUlIdEvent() != 0) {
            
            
            //  Call CSUB40U
            rc = Ccmn01u.CallCCMN45D(csvc15si, csvc15so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                case Messages.MSG_NO_ROWS_RETURNED:
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            if (0 == csvc15si.getSzCdStage().compareTo(SVC_CD_STAGE_APS_SVC) && csvc15so.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(SVC_CD_EVENT_STATUS_NEW) != 0) {
                rc = CallCSVC21D(csvc15si, csvc15so, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case Messages.MSG_NO_ROWS_RETURNED:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        if ((0 == csvc15si.getSzCdStage().compareTo(SVC_CD_STAGE_APS_SVC)) && (0 >= csvc15so.getDtDtSvcDelvDecision().year)) {
            
            rc = ARC_UTLGetDateAndTime(csvc15so.getDtDtSvcDelvDecision() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(csvc15si.getArchInputStruct() , csvc15so.getArchOutputStruct());
        
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
                
                //  Call CFAD01U
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csvc15so;
    }

    
    static int CallCCMN45D(CSVC15SI pInputMsg848, CSVC15SO pOutputMsg793, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i440 = 0;
        
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
        pCCMN45DInputRec.setUlIdEvent(pInputMsg848.getUlIdEvent());
        
        
        /*
        ** Call DAM
        */
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg793.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg793.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg793.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg793.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                pOutputMsg793.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                pOutputMsg793.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pOutputMsg793.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pOutputMsg793.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg793.getROWCCMN01UIG00().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
        }
        
        return rc;
    }

    
    static int CallCINT40D(CSVC15SI pInputMsg849, CSVC15SO pOutputMsg794, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINT40DI pCINT40DInputRec = null;
        CINT40DO pCINT40DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT40DInputRec = new CINT40DI();
        
        pCINT40DOutputRec = new CINT40DO();
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCINT40DInputRec.setUlIdStage(pInputMsg849.getUlIdStage());
        pCINT40DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg849.getArchInputStruct().getUsPageNbr());
        pCINT40DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg849.getArchInputStruct().getUlPageSizeNbr());
        /* Successful update */
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg794.getROWCINV19SOG02().setUlIdStage(pCINT40DOutputRec.getUlIdStage());
                pOutputMsg794.getROWCINV19SOG02().setTmSysTmStageClose(pCINT40DOutputRec.getTmSysTmStageClose());
                pOutputMsg794.getROWCINV19SOG02().setTmSysTmStageStart(pCINT40DOutputRec.getTmSysTmStageStart());
                pOutputMsg794.getROWCINV19SOG02().setUlIdUnit(pCINT40DOutputRec.getUlIdUnit());
                pOutputMsg794.getROWCINV19SOG02().setBIndStageClose(pCINT40DOutputRec.getBIndStageClose());
                pOutputMsg794.getROWCINV19SOG02().setSzNmStage(pCINT40DOutputRec.getSzNmStage());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStage(pCINT40DOutputRec.getSzCdStage());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageClassification(pCINT40DOutputRec.getSzCdStageClassification());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageCnty(pCINT40DOutputRec.getSzCdStageCnty());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageCurrPriority(pCINT40DOutputRec.getSzCdStageCurrPriority());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageInitialPriority(pCINT40DOutputRec.getSzCdStageInitialPriority());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageProgram(pCINT40DOutputRec.getSzCdStageProgram());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageReasonClosed(pCINT40DOutputRec.getSzCdStageReasonClosed());
                pOutputMsg794.getROWCINV19SOG02().setDtDtStageClose(pCINT40DOutputRec.getDtDtStageClose());
                pOutputMsg794.getROWCINV19SOG02().setDtDtStageStart(pCINT40DOutputRec.getDtDtStageStart());
                pOutputMsg794.getROWCINV19SOG02().setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                pOutputMsg794.getROWCINV19SOG02().setUlIdSituation(pCINT40DOutputRec.getUlIdSituation());
                pOutputMsg794.getROWCINV19SOG02().setSzCdClientAdvised(pCINT40DOutputRec.getSzCdClientAdvised());
                pOutputMsg794.getROWCINV19SOG02().setBIndEcs(pCINT40DOutputRec.getBIndEcs());
                pOutputMsg794.getROWCINV19SOG02().setBIndEcsVer(pCINT40DOutputRec.getBIndEcsVer());
                pOutputMsg794.getROWCINV19SOG02().setSzTxtStageClosureCmnts(pCINT40DOutputRec.getSzTxtStageClosureCmnts());
                pOutputMsg794.getROWCINV19SOG02().setSzTxtStagePriorityCmnts(pCINT40DOutputRec.getSzTxtStagePriorityCmnts());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageRegion(pCINT40DOutputRec.getSzCdStageRegion());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageRsnPriorityChgd(pCINT40DOutputRec.getSzCdStageRsnPriorityChgd());
                pOutputMsg794.getROWCINV19SOG02().setSzCdStageType(pCINT40DOutputRec.getSzCdStageType());
                pOutputMsg794.getROWCINV19SOG02().setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
                pOutputMsg794.getArchOutputStruct().setUlRowQty(pCINT40DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg794.getArchOutputStruct().setBMoreDataInd(pCINT40DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSVC21D(CSVC15SI pInputMsg850, CSVC15SO pOutputMsg795, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSVC21DI pCSVC21DInputRec = null;
        CSVC21DO pCSVC21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSVC21DInputRec = new CSVC21DI();
        
        pCSVC21DOutputRec = new CSVC21DO();
        
        pCSVC21DInputRec.setUlIdStage(pInputMsg850.getUlIdStage());
        
        pCSVC21DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg850.getArchInputStruct().getUsPageNbr());
        pCSVC21DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg850.getArchInputStruct().getUlPageSizeNbr());
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = csvc21dQUERYdam(sqlca, pCSVC21DInputRec, pCSVC21DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg795.setDtDtSvcDelvDecision(pCSVC21DOutputRec.getDtDtSvcDelvDecision());
                pOutputMsg795.setTsLastUpdate(pCSVC21DOutputRec.getTsLastUpdate());
                pOutputMsg795.getArchOutputStruct().setUlRowQty(pCSVC21DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg795.getArchOutputStruct().setBMoreDataInd(pCSVC21DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                break;
                
                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                // SQL error returned from the DAM.
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
