package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
/**************************************************************************
** 
** Module File:   cinv11s.src
**
** Service Name:  cinv11s
**
** Description:   Retrieves information for the Emergency Assistance window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/9/95 
** 
** Programmer:    SPR
**
** Updated:       5/22/95 by MKB
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  07/26/96   zabihin  sir 21891 : version control code was missing, I 
**                       added the lines.
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






public class Cinv11s {
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String EVENT_STATUS_PROGRESS = "PROC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    public static final int NUMLISTBOXROWS = 3;
    public static final String EVENT_TYPE = "CCL";
    CINV11SO CINV11S(CINV11SI cinv11si) {
        CINV11SO cinv11so = new CINV11SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        /*
        ** Call CAUDB7D
        */
        rc = ARC_PRFServiceStartTime_TUX(cinv11si.getArchInputStruct());
        rc = Ccmn02u.CallCCMN87D(cinv11si, cinv11so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (cinv11si.getUlIdEvent() != 0) 
        {
            
            //  Declare FOUNDATION variables
            
            //  Declare local variables
            
            
            // Nbr Period and Nbr Version
            
            
            // Id Stage
            
            
            
            
            
            //  Start Performance Timer
            rc = Ccmn01u.CallCCMN45D(cinv11si, cinv11so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            
            
            //  Initialize Service Status Fields
            
            
            
            //  Perform Main Processing
            
            
            //  Set CCON22SO WCD DtSystemDate to current date
            rc = Cinv15s.CallCINV15D(cinv11si, cinv11so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Ccmn02u.CallCINV95D(cinv11si, cinv11so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv11si.getArchInputStruct() , cinv11so.getArchOutputStruct());
        
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
        
        return cinv11so;
    }

    
    static int CallCCMN87D(CINV11SI pInputMsg576, CINV11SO pOutputMsg528, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setArchInputStruct(pInputMsg576.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg576.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(EVENT_TYPE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        
        /*
        ** Perform data validation
        */
        
        /*
        ** SIR 2255 - Only perform client assessment check
        ** if current stage is Investigation
        */
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            
            
            //  Analyze return code
            switch (rc) {
                case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        else if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
            pOutputMsg528.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
        }
        else {
            pOutputMsg528.setUlIdEvent(0);
        }
        return rc;
    }

    static int CallCINV15D(CINV11SI pInputMsg577, CINV11SO pOutputMsg529, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        int usRowCtr = 0;
        CINV15DI pCINV15DInputRec = null;
        CINV15DO pCINV15DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV15DInputRec = new CINV15DI();
        pCINV15DOutputRec = new CINV15DO();
        pCINV15DInputRec.setArchInputStruct(pInputMsg577.getArchInputStruct());
        pCINV15DInputRec.setUlIdEvent(pInputMsg577.getUlIdEvent());
        pCINV15DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg577.getArchInputStruct().getUsPageNbr());
        
        pCINV15DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg577.getArchInputStruct().getUlPageSizeNbr());
        rc = cinv15dQUERYdam(sqlca, pCINV15DInputRec, pCINV15DOutputRec);
        
        /*
        ** Set explan_data to usRow
        ** Note: Use sprintf
        */
        //##                              sprintf(pReturnPB->appl_status.explan_data,
        //##                                      "%u",
        //##                                      usVersionRow);
        
        
        /* Equipment */
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    pOutputMsg529.getArchOutputStruct().setUlRowQty(0);
                    
                    
                    //  Call CSUB40U
                    rc = 0;
                    
                    
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
            pOutputMsg529.getArchOutputStruct().setUlRowQty(NUMLISTBOXROWS);
            
            for (usRowCtr = 0;usRowCtr < NUMLISTBOXROWS;usRowCtr++) {
                pOutputMsg529.getROWCINV11SOG00_ARRAY().getROWCINV11SOG00(usRowCtr).setSzCdEaQuestion(pCINV15DOutputRec.getROWCINV15DO_ARRAY().getROWCINV15DO(usRowCtr).getSzCdEaQuestion());
                
                //## BEGIN TUX/XML: Declare XML variables
                pOutputMsg529.getROWCINV11SOG00_ARRAY().getROWCINV11SOG00(usRowCtr).setUlIdEmergencyAssist(pCINV15DOutputRec.getROWCINV15DO_ARRAY().getROWCINV15DO(usRowCtr).getUlIdEmergencyAssist());
                pOutputMsg529.getROWCINV11SOG00_ARRAY().getROWCINV11SOG00(usRowCtr).setBIndEaResponse(pCINV15DOutputRec.getROWCINV15DO_ARRAY().getROWCINV15DO(usRowCtr).getBIndEaResponse());
                pOutputMsg529.getROWCINV11SOG00_ARRAY().getROWCINV11SOG00(usRowCtr).setTsLastUpdate(pCINV15DOutputRec.getROWCINV15DO_ARRAY().getROWCINV15DO(usRowCtr).getTsLastUpdate());
            }
        }
        return rc;
    }

    
    static int CallCCMN45D(CINV11SI pInputMsg578, CINV11SO pOutputMsg530, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter */
        int rc = 0;/* Return code */
        
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
        pCCMN45DInputRec.setArchInputStruct(pInputMsg578.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg578.getUlIdEvent());
        
        /*
        ** Call TodoCommonFunction
        */
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg530.setROWCCMN45DO(pCCMN45DOutputRec.getROWCCMN45DO());
        }
        return rc;
    }

    static int CallCINV95D(CINV11SI pInputMsg579, CINV11SO pOutputMsg531, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV95DInputRec = new CINV95DI();
        pCINV95DOutputRec = new CINV95DO();
        pCINV95DInputRec.setArchInputStruct(pInputMsg579.getArchInputStruct());
        pCINV95DInputRec.setUlIdStage(pInputMsg579.getUlIdStage());
        
        /*
        ** Call CCMN44D
        */
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        /* when the window is call from TASK LIST */
        
        /* Call DAM 82 to get TASK decode if task related */
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg531.getROWCINV11SOG01().setUlIdEvent(pCINV95DOutputRec.getUlIdEvent());
            pOutputMsg531.getROWCINV11SOG01().setSzCdCpsInvstDtlFamIncm(pCINV95DOutputRec.getSzCdCpsInvstDtlFamIncm());
            pOutputMsg531.getROWCINV11SOG01().setCdCpsOverallDisptn(pCINV95DOutputRec.getCdCpsOverallDisptn());
            pOutputMsg531.getROWCINV11SOG01().setDtDtCPSInvstDtlAssigned(pCINV95DOutputRec.getDtDtCPSInvstDtlAssigned());
            pOutputMsg531.getROWCINV11SOG01().setDtDtCPSInvstDtlBegun(pCINV95DOutputRec.getDtDtCPSInvstDtlBegun());
            pOutputMsg531.getROWCINV11SOG01().setDtDtCpsInvstDtlComplt(pCINV95DOutputRec.getDtDtCpsInvstDtlComplt());
            pOutputMsg531.getROWCINV11SOG01().setDtDtCPSInvstDtlIntake(pCINV95DOutputRec.getDtDtCPSInvstDtlIntake());
            pOutputMsg531.getROWCINV11SOG01().setUlIdStage(pCINV95DOutputRec.getUlIdStage());
            pOutputMsg531.getROWCINV11SOG01().setBIndCpsInvstEaConcl(pCINV95DOutputRec.getBIndCpsInvstEaConcl());
            pOutputMsg531.getROWCINV11SOG01().setBIndCpsInvstSafetyPln(pCINV95DOutputRec.getBIndCpsInvstSafetyPln());
            pOutputMsg531.getROWCINV11SOG01().setCIndCpsInvstDtlRaNa(pCINV95DOutputRec.getCIndCpsInvstDtlRaNa());
            pOutputMsg531.getROWCINV11SOG01().setCIndCpsInvstAbbrv(pCINV95DOutputRec.getCIndCpsInvstAbbrv());
            pOutputMsg531.getROWCINV11SOG01().setTsLastUpdate(pCINV95DOutputRec.getTsLastUpdate());
        }
        
        return rc;
    }

}
