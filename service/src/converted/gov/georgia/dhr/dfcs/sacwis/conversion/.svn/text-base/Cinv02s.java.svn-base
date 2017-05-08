package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
/**************************************************************************
** 
** Module File:   cinv02s.src
**
** Service Name:  cinv02s
**
** Description:   Retrieves information for the Inv Action Window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/05/95
** Date Updated:  5/24/95
** 
** Programmer:    MKB
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                        added the lines.
**
**  04/30/03   Srini	SIR 17091: Added the error handling to take care of full 
**						table scans for ccmn87dQUERYdam.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv02s {
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String EVENT_STATUS_PROGRESS = "PROC";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    
    /* Code for Investigation Conclusion Event Type */
    public static final String CONCLUSION_EVENT_TYPE = "CCL";
    
    /* Other service macros */
    public static final int NUMLISTBOXROWS = 7;
    CINV02SO CINV02S(CINV02SI cinv02si) {
        CINV02SO cinv02so = new CINV02SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cinv02si.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = Ccmn02u.CallCCMN87D(cinv02si, cinv02so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Analyze error code
        */
        if (cinv02si.getUlIdEvent() != 0) {
            rc = Ccmn01u.CallCCMN45D(cinv02si, cinv02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = CallCINV04D(cinv02si, cinv02so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv02si.getArchInputStruct() , cinv02so.getArchOutputStruct());
        
        /*
        ** Analyze error code
        */
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
        return cinv02so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV02SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    
    static int CallCCMN87D(CINV02SI pInputMsg507, CINV02SO pOutputMsg465, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        int rc = 0;
        
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
        pCCMN87DInputRec.setArchInputStruct(pInputMsg507.getArchInputStruct());
        pCCMN87DInputRec.setUlIdStage(pInputMsg507.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CONCLUSION_EVENT_TYPE);
        
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            
            //  Analyze return code
            switch (rc) {
                case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                    
                    
                    // 
                    // End Call to Stage Retrieval Dam - CLSS24D
                    // 
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        else if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
            pOutputMsg465.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
        }
        else {
            pOutputMsg465.setUlIdEvent(0);
        }
        return rc;
    }

    static int CallCINV04D(CINV02SI pInputMsg508, CINV02SO pOutputMsg466, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter */
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINV04DI pCINV04DInputRec = null;
        CINV04DO pCINV04DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV04DInputRec = new CINV04DI();
        pCINV04DOutputRec = new CINV04DO();
        pCINV04DInputRec.setArchInputStruct(pInputMsg508.getArchInputStruct());
        pCINV04DInputRec.setUlIdEvent(pInputMsg508.getUlIdEvent());
        pCINV04DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg508.getArchInputStruct().getUsPageNbr());
        pCINV04DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg508.getArchInputStruct().getUlPageSizeNbr());
        
        /* call DAM */
        rc = cinv04dQUERYdam(sqlca, pCINV04DInputRec, pCINV04DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg466.getArchOutputStruct().setUlRowQty(0);
                    
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            pOutputMsg466.getArchOutputStruct().setUlRowQty(NUMLISTBOXROWS);
            
            for (usRowCtr = 0;usRowCtr < NUMLISTBOXROWS;usRowCtr++) {
                pOutputMsg466.getROWCINV02SOG00_ARRAY().getROWCINV02SOG00(usRowCtr).setSzCdInvstActionAns(pCINV04DOutputRec.getROWCINV04DO_ARRAY().getROWCINV04DO(usRowCtr).getSzCdInvstActionAns());
                
                pOutputMsg466.getROWCINV02SOG00_ARRAY().getROWCINV02SOG00(usRowCtr).setSzCdInvstActionQuest(pCINV04DOutputRec.getROWCINV04DO_ARRAY().getROWCINV04DO(usRowCtr).getSzCdInvstActionQuest());
                pOutputMsg466.getROWCINV02SOG00_ARRAY().getROWCINV02SOG00(usRowCtr).setSzTxtInvstActionCmnts(pCINV04DOutputRec.getROWCINV04DO_ARRAY().getROWCINV04DO(usRowCtr).getSzTxtInvstActionCmnts());
                pOutputMsg466.getROWCINV02SOG00_ARRAY().getROWCINV02SOG00(usRowCtr).setUlIdInvstActionQuest(pCINV04DOutputRec.getROWCINV04DO_ARRAY().getROWCINV04DO(usRowCtr).getUlIdInvstActionQuest());
                pOutputMsg466.getROWCINV02SOG00_ARRAY().getROWCINV02SOG00(usRowCtr).setTsLastUpdate(pCINV04DOutputRec.getROWCINV04DO_ARRAY().getROWCINV04DO(usRowCtr).getTsLastUpdate());
            }
        }
        return rc;
    }

    static int CallCCMN45D(CINV02SI pInputMsg509, CINV02SO pOutputMsg467, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int usRowCtr = 0;/* Row Counter */
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input Structure
        */
        pCCMN45DInputRec = new CCMN45DI();
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg509.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg509.getUlIdEvent());
        
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            pOutputMsg467.setROWCCMN45DO(pCCMN45DOutputRec.getROWCCMN45DO());
        }
        return rc;
    }

}
