package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV51SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV51SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV65DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV65DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI;
/**************************************************************************
** 
** Module File:   CINV51S.src
**
** Service Name:  CINV51S
**
** Description:   A retrieval service which obtains risk factors for
**                either a Principal or an Incident type from
**                the RISK FACTORS table.  The service also returns
**                the current time stamp for the ID EVENT on the Event table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/14/95 
** 
** Programmer:    Terry T. Cavallaro
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
**
**  05/19/99   LEIHMA   SIR #FND32  Updated data element for the foundation
**                      upgrade from 2.4 to 3.2
***************************************************************************/


/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv51s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int NO_ERRORS = 0;
    public static final char GET_DATA = 'Y';
    public static final char DONT_GET_DATA = 'N';
    public static final String EVENT_STATUS_NEW = "NEW";
    CINV51SO CINV51S(CINV51SI cinv51si) {
        CINV51SO cinv51so = new CINV51SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i378 = 0;
        int counter = 0;/* SIR#2109 */
        
        //set rc value to FND_FAIL
        rc = ARC_PRFServiceStartTime_TUX(cinv51si.getArchInputStruct());
        
        if (cinv51si.getUlIdEvent() != 0) {
            rc = Ccmn01u.CallCCMN45D(cinv51si, cinv51so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        switch (cinv51si.getBSysIndWinDataChg()) {
            case GET_DATA:
                
                if (cinv51si.getUlIdEvent() != 0 && cinv51so.getROWCCMN01UIG00().getSzCdEventStatus().substring(0, 3).compareTo(EVENT_STATUS_NEW.substring(0, 3)) != 0) {
                    rc = CallCINV65D(cinv51si, cinv51so, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
            case DONT_GET_DATA:
                break;
        }
        cinv51si.getArchInputStruct().setUlPageSizeNbr(30);
        
        if (cinv51si.getUlIdEvent() != 0 && cinv51so.getROWCCMN01UIG00().getSzCdEventStatus().substring(0, 3).compareTo(EVENT_STATUS_NEW.substring(0, 3)) != 0) {
            
            
            //  Call CSEC64D
            rc = CallCCMND2D(cinv51si, cinv51so, pServiceStatus, counter);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cinv51si.getArchInputStruct() , cinv51so.getArchOutputStruct());
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            
            //  Initialize Service Status Fields
            
            
            
            //  Perform Main Processing
            
            
            // 
            // BEGIN: CSEC27D
            // 
            //  SIR 11813  durang - Only validate the Service Authorization if the
            // cIndRsrcTransport is FALSE -ADD or NO_SELECTION
            
            //  SIR 3193 - Only validate the Service Authorization if the Invoice
            // Type is not Adoption Subsidy   BSM
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //set the rc to FND_FAIL
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv51so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        /* unsigned short *,    SIR 13532 */
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = "CINV51SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        
        return SUCCESS;
    }

    static int CallCCMN45D(CINV51SI pInputMsg758, CINV51SO pOutputMsg706, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i379 = 0;
        int rc = 0;/* Return code */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        
        /***** Populate Input Structure for DAM *****/
        
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setUlIdEvent(pInputMsg758.getUlIdEvent());
        pCCMN45DInputRec.setArchInputStruct(pInputMsg758.getArchInputStruct());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) {
            case SUCCESS:
                pOutputMsg706.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg706.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                pOutputMsg706.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg706.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg706.getROWCCMN01UIG00().getDtDtEventOccurred().day = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().day;
                pOutputMsg706.getROWCCMN01UIG00().getDtDtEventOccurred().month = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().month;
                pOutputMsg706.getROWCCMN01UIG00().getDtDtEventOccurred().year = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().year;
                
                pOutputMsg706.getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pOutputMsg706.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pOutputMsg706.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg706.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                break;
            case NO_DATA_FOUND:
                //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
                // SQL error returned from the DAM.
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV65D(CINV51SI pInputMsg759, CINV51SO pOutputMsg707, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i380 = 0;
        int j = 0;
        int rc = SUCCESS;
        
        CINV65DI pCINV65DInputRec = null;
        CINV65DO pCINV65DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        
        pCINV65DInputRec = new CINV65DI();
        
        pCINV65DOutputRec = new CINV65DO();
        pCINV65DInputRec.setArchInputStruct(pInputMsg759.getArchInputStruct());
        pOutputMsg707.getArchOutputStruct().setUlRowQty(0);
        pCINV65DInputRec.setUlIdPerson(pInputMsg759.getUlIdPerson());
        pCINV65DInputRec.setUlIdEvent(pInputMsg759.getUlIdEvent());
        
        rc = cinv65dQUERYdam(sqlca, pCINV65DInputRec, pCINV65DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Service Output message = DAM Output message
                for (i380 = 0;i380 < pCINV65DOutputRec.getArchOutputStruct().getUlRowQty();i380++) {
                    pOutputMsg707.getROWCINV51SOG01_ARRAY().getROWCINV51SOG01(i380).setTsLastUpdate(pCINV65DOutputRec.getROWCINV65DO_ARRAY().getROWCINV65DO(i380).getTsLastUpdate());
                    pOutputMsg707.getROWCINV51SOG01_ARRAY().getROWCINV51SOG01(i380).setUlIdRiskFactor(pCINV65DOutputRec.getROWCINV65DO_ARRAY().getROWCINV65DO(i380).getUlIdRiskFactor());
                    pOutputMsg707.getROWCINV51SOG01_ARRAY().getROWCINV51SOG01(i380).setSzCdRiskFactor(pCINV65DOutputRec.getROWCINV65DO_ARRAY().getROWCINV65DO(i380).getSzCdRiskFactor());
                    pOutputMsg707.getROWCINV51SOG01_ARRAY().getROWCINV51SOG01(i380).setSzCdRiskFactorResponse(pCINV65DOutputRec.getROWCINV65DO_ARRAY().getROWCINV65DO(i380).getSzCdRiskFactorResponse());
                    pOutputMsg707.getROWCINV51SOG01_ARRAY().getROWCINV51SOG01(i380).setSzCdRiskFactorCateg(pCINV65DOutputRec.getROWCINV65DO_ARRAY().getROWCINV65DO(i380).getSzCdRiskFactorCateg());
                    pOutputMsg707.getROWCINV51SOG01_ARRAY().getROWCINV51SOG01(i380).setTxtRiskFactorComment(pCINV65DOutputRec.getROWCINV65DO_ARRAY().getROWCINV65DO(i380).getTxtRiskFactorComment());
                }
                pOutputMsg707.getArchOutputStruct().setUlRowQty(pCINV65DOutputRec.getArchOutputStruct().getUlRowQty());
                
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        pOutputMsg707.getArchOutputStruct().setBMoreDataInd(pCINV65DOutputRec.getArchOutputStruct().getBMoreDataInd());
        return rc;
    }

    
    
    static int CallCCMND2D(CINV51SI pInputMsg760, CINV51SO pOutputMsg708, Arcxmlerrors.TUX_DECL_STATUSPARMS, int counter) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        int i381 = 0;
        CCMND2DI pCCMND2DInputRec = null;
        CCMND2DO pCCMND2DOutputRec = null;
        
        
        
        /* Allocate memory for Input and Output Structures */
        
        pCCMND2DInputRec = new CCMND2DI();
        
        
        pCCMND2DOutputRec = new CCMND2DO();
        pCCMND2DInputRec.setArchInputStruct(pInputMsg760.getArchInputStruct());
        pCCMND2DInputRec.setUlIdEvent(pInputMsg760.getUlIdEvent());
        rc = ccmnd2dQUERYdam(sqlca, pCCMND2DInputRec, pCCMND2DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                // Initialize all fields in the Event Person Link
                // storage array
                //  Foundation 3.2 Migration Change - Leihma - 5/19/1999
                // Changed variable
                // From:    _ROWCCMN01UIG00__ROWCCMN01UIG01_SIZ 
                // To:      _ROWCCMN01UIG00__ROWCCMN01UIG01_SIZE
                for (i381 = 0;i381 < CSYS07SI._ROWCCMN01UIG00__ROWCCMN01UIG01_SIZE;i381++) {
                    pOutputMsg708.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i381).setUlIdPerson(0);
                }
                
                // ID PERSON's were found so
                // Populate Output Message
                for (i381 = 0;i381 < pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty();i381++) {
                    pOutputMsg708.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i381).setUlIdPerson(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i381).getUlIdPerson());
                    pOutputMsg708.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i381).setTsLastUpdate(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i381).getTsLastUpdate());
                }
                
                
                counter = i381;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
