package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV00SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV00SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV00DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV00DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVA2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVA2DO;
/**************************************************************************
** 
** Module File:   cinv00s.src
**
** Service Name:  Retrieve Safety Eval
**
** Description:   This service calls 2 DAMS to retrieve the information 
**                for the Safety Evaluation window.  The first service 
**                gets information from the Safety Evaluation Table to 
**                be used for entry fields.  The second DAM is a list that
**                will retieve the Safety Eval Factor information for the 
**                safety factor list box.
**                The service also retrieves a full row from the event table,
**                and also the status of the Conclusion event for this stage.
**                IT also calls a DAM to determine if the ID Event passed in
**                corresponds to the most recent Safety Evaluation and sets
**                a flag accordingly.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/04/95 
** 
** Programmer:    Diane M. Verso
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:22:34  $
**                      $Modtime:   05 Aug 1996 16:49:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/20/96  OMARAJJ   SIR#21251 - Replace COPYSZ with MEMCPY for timestamp
**                      variables.
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                      added the lines.
**
** DAMs Called    CINV00D
**                CINV01D
**                CCMN45D
**                CCMN87D
**                CINVA2D
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






public class Cinv00s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String CONCL_EVENT_TYPE = "CCL";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String EVENT_STATUS_NEW = "NEW";
    CINV00SO CINV00S(CINV00SI cinv00si) {
        CINV00SO cinv00so = new CINV00SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code             */
        
        rc = ARC_PRFServiceStartTime_TUX(cinv00si.getArchInputStruct());
        
        rc = Ccmn02u.CallCCMN87D(cinv00si, cinv00so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (WINDOW_MODE_NEW != cinv00si.getArchInputStruct().getCReqFuncCd()) {
            
            
            //  Call CSYS06D
            rc = Ccmn01u.CallCCMN45D(cinv00si, cinv00so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            if (0 != strncmp(cinv00so.getROWCCMN45DO().getSzCdEventStatus() , EVENT_STATUS_NEW, EVENT_STATUS_NEW.length())) {
                
                
                //  Set rc to ARC_SUCCESS
                rc = CallCINV00D(cinv00si, cinv00so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                //  Set rc to ARC_SUCCESS
                rc = CallCINV01D(cinv00si, cinv00so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                rc = CallCINVA2D(cinv00si, cinv00so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv00si.getArchInputStruct() , cinv00so.getArchOutputStruct());
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
        return cinv00so;
    }

    static int CallCINV00D(CINV00SI pInputMsg495, CINV00SO pOutputMsg453, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CINV00DI pCINV00DInputRec = null;
        CINV00DO pCINV00DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV00DInputRec = new CINV00DI();
        pCINV00DOutputRec = new CINV00DO();
        pCINV00DInputRec.setUlIdEvent(pInputMsg495.getUlIdEvent());
        pCINV00DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg495.getArchInputStruct().getUsPageNbr());
        
        pCINV00DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg495.getArchInputStruct().getUlPageSizeNbr());
        rc = cinv00dQUERYdam(sqlca, pCINV00DInputRec, pCINV00DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg453.setTsLastUpdate(pCINV00DOutputRec.getTsLastUpdate());
                pOutputMsg453.setCCdSftyEvalLegalAct(pCINV00DOutputRec.getCCdSftyEvalLegalAct());
                pOutputMsg453.setTxtSafetyEvalCmntsAr(pCINV00DOutputRec.getTxtSafetyEvalCmntsAr());
                pOutputMsg453.setTxtSafetyEvalCmntsCnc(pCINV00DOutputRec.getTxtSafetyEvalCmntsCnc());
                pOutputMsg453.setTxtSafetyEvalCmntsSoc(pCINV00DOutputRec.getTxtSafetyEvalCmntsSoc());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV01D(CINV00SI pInputMsg496, CINV00SO pOutputMsg454, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i279 = 0;
        /*
        ** Declare local variables
        */
        CINV01DI pCINV01DInputRec = null;
        CINV01DO pCINV01DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV01DInputRec = new CINV01DI();
        
        pCINV01DOutputRec = new CINV01DO();
        pCINV01DInputRec.setUlIdEvent(pInputMsg496.getUlIdEvent());
        pCINV01DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg496.getArchInputStruct().getUsPageNbr());
        pCINV01DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg496.getArchInputStruct().getUlPageSizeNbr());
        rc = cinv01dQUERYdam(sqlca, pCINV01DInputRec, pCINV01DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                //SIR 23664
                
                //SIR 23771
            case NO_DATA_FOUND:
                rc = 0;
                
                break;
                //END SIR 23771
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Populate Output Message
                for (i279 = 0;i279 < pCINV01DOutputRec.getArchOutputStruct().getUlRowQty();i279++) {
                    pOutputMsg454.getROWCINV00SOG_ARRAY().getROWCINV00SOG(i279).setSzCdSafetyFactor(pCINV01DOutputRec.getROWCINV01DO_ARRAY().getROWCINV01DO(i279).getSzCdSafetyFactor());
                    
                    
                    // 
                    // Function Prototypes
                    // 
                    pOutputMsg454.getROWCINV00SOG_ARRAY().getROWCINV00SOG(i279).setTsLastUpdate(pCINV01DOutputRec.getROWCINV01DO_ARRAY().getROWCINV01DO(i279).getTsLastUpdate());
                    pOutputMsg454.getROWCINV00SOG_ARRAY().getROWCINV00SOG(i279).setCCdSafetyEvalType(pCINV01DOutputRec.getROWCINV01DO_ARRAY().getROWCINV01DO(i279).getCCdSafetyEvalType());
                    pOutputMsg454.getROWCINV00SOG_ARRAY().getROWCINV00SOG(i279).setUlIdSafetyEvalFactor(pCINV01DOutputRec.getROWCINV01DO_ARRAY().getROWCINV01DO(i279).getUlIdSafetyEvalFactor());
                }
                pOutputMsg454.getArchOutputStruct().setUlRowQty(pCINV01DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg454.getArchOutputStruct().setBMoreDataInd(pCINV01DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN45D(CINV00SI pInputMsg497, CINV00SO pOutputMsg455, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMN45DInputRec.setUlIdEvent(pInputMsg497.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Stop performance timer for Data Access Module
        */
        ARC_PRFDataAccessStopTime("CCMN45D");
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg455.getROWCCMN45DO().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg455.getROWCCMN45DO().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                pOutputMsg455.getROWCCMN45DO().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                pOutputMsg455.getROWCCMN45DO().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg455.getROWCCMN45DO().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg455.getROWCCMN45DO().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pOutputMsg455.getROWCCMN45DO().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pOutputMsg455.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg455.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    
    static int CallCCMN87D(CINV00SI pInputMsg498, CINV00SO pOutputMsg456, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMN87DInputRec.setUlIdStage(pInputMsg498.getUlIdStage());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CONCL_EVENT_TYPE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
                    pOutputMsg456.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                }
                else {
                    pOutputMsg456.setUlIdEvent(0);
                }
                
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                // 
                // End Call to Primary Staff Simple Dam - CCMNG2D
                // 
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINVA2D(CINV00SI pInputMsg499, CINV00SO pOutputMsg457, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CINVA2DI pCINVA2DInputRec = null;
        CINVA2DO pCINVA2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVA2DInputRec = new CINVA2DI();
        
        pCINVA2DOutputRec = new CINVA2DO();
        
        pCINVA2DInputRec.setUlIdEvent(pInputMsg499.getUlIdEvent());
        pCINVA2DInputRec.setUlIdStage(pInputMsg499.getUlIdStage());
        pCINVA2DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINVA2DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        /*
        ** Do nothing, the output message just returns success or
        ** failure.
        */
        rc = cinva2dQUERYdam(sqlca, pCINVA2DInputRec, pCINVA2DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg457.setBSysIndMostRecent(true);
                break;
            case NO_DATA_FOUND:
                pOutputMsg457.setBSysIndMostRecent(false);
                rc = WtcHelperConstants.SQL_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
