package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS07SI;
/**************************************************************************
** 
** Module File:   CCMN01U.src
**
** Service Name:  PostEvent 
**
** Description:   This common function is called to update the event
**                table and the Event Person link table.
**                Rows can be added, updated or deleted from the event
**                table, while the Event Person Link table, you can
**                only add and delete.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:   
** 
** Programmer:   Gwin Pitman 
**
** DAMS:         CCMN46D
**               CCMN68D
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   17 Jul 1999 14:42:54  $
**                      $Modtime:   28 Apr 1999 13:56:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User            SIR   Description
**  --------  --------        ---   ----------------------------------------
**  09/28/95    KRD                 Superficial changes to match the Release
**                                  1.x service shell.
**
**  10/03/95  Terry Cavallaro 1646  Modified the output message to return the
**                                  time stamp from the event table.
**  01/21/96  GUARRICR        2843  Changed logic to not retrieve timestamp of
**                                  event record if event was deleted.
**  04/28/99  SNIDERDL	      MIGFCP32 - changed
**                                  _ROWCCMN01UIG00__ROWCCMN01UIG01_SIZ to
**                                  _ROWCCMN01UIG00__ROWCCMN01UIG01_SIZE
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
public class Ccmn01u {
    static int PostEvent(CCMN01UI pInputMsg59, CCMN01UO pOutputMsg61, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        pServiceStatus.severity = SUCCESS;
        pServiceStatus.explan_code = SUCCESS;
        
        rc = Ccmn02u.CallCCMN46D(pInputMsg59, pOutputMsg61, pServiceStatus);
        
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = Ccmn02u.CallCCMN68D(pInputMsg59, pOutputMsg61, pServiceStatus);
                
                switch (rc) 
                {
                    case WtcHelperConstants.ARC_SUCCESS:
                        if (WtcHelperConstants.REQ_FUNC_CD_DELETE != pInputMsg59.getArchInputStruct().getCReqFuncCd()) {
                            
                            
                            //  Call CSES68D
                            rc = Ccmn03u.CallCCMN45D(pInputMsg59, pOutputMsg61, pServiceStatus);
                            
                            switch (rc) {
                                    
                                    // case SQL_NOT_FOUND:
                                    // pServiceStatus->severity = FND_SEVERITY_ERROR;
                                    // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                                    // RetVal = FND_SUCCESS;
                                    // rc = MSG_CMN_TMSTAMP_MISMATCH;
                                    // break;
                                    
                                case WtcHelperConstants.ARC_SUCCESS:
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                            }
                        }
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        
                        break;
                        
                    case Messages.MSG_CMN_UPDATE_FAILED:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                }
                
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                break;
                
            case Messages.MSG_CMN_UPDATE_FAILED:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN45D(CCMN01UI pInputMsg60, CCMN01UO pOutputMsg62, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for CCMN45DI and CCMN45DO
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        
        if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg60.getArchInputStruct().getCReqFuncCd()) {
            //  Unlike typical DAM calls, a Common Function
            // handles its own SQL errors.  So, after returning,
            // we should call PROCESS_TUX_RC_ERROR_TRANSACT rather than
            // PROCESS_TUX_SQL_ERROR_TRANSACT
            pCCMN45DInputRec.setUlIdEvent(pOutputMsg62.getUlIdEvent());
        }
        else if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == pInputMsg60.getArchInputStruct().getCReqFuncCd()) {
            
            pCCMN45DInputRec.setUlIdEvent(pInputMsg60.getROWCCMN01UIG00().getUlIdEvent());
        }
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pOutputMsg62.setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                
                break;
        }
        
        return rc;
    }

    static int CallCCMN46D(CCMN01UI pInputMsg61, CCMN01UO pOutputMsg63, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CCMN46DI pCCMN46DInputRec = null;
        CCMN46DO pCCMN46DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN46DInputRec = new CCMN46DI();
        
        pCCMN46DOutputRec = new CCMN46DO();
        pCCMN46DInputRec.setSzCdEventType(pInputMsg61.getROWCCMN01UIG00().getSzCdEventType());
        pCCMN46DInputRec.setDtDtEventOccurred(pInputMsg61.getROWCCMN01UIG00().getDtDtEventOccurred());
        
        pCCMN46DInputRec.setUlIdEvent(pInputMsg61.getROWCCMN01UIG00().getUlIdEvent());
        pCCMN46DInputRec.setUlIdStage(pInputMsg61.getROWCCMN01UIG00().getUlIdStage());
        pCCMN46DInputRec.setUlIdPerson(pInputMsg61.getROWCCMN01UIG00().getUlIdPerson());
        pCCMN46DInputRec.setSzCdTask(pInputMsg61.getROWCCMN01UIG00().getSzCdTask());
        pCCMN46DInputRec.setSzTxtEventDescr(pInputMsg61.getROWCCMN01UIG00().getSzTxtEventDescr());
        pCCMN46DInputRec.setSzCdEventStatus(pInputMsg61.getROWCCMN01UIG00().getSzCdEventStatus());
        pCCMN46DInputRec.setTsLastUpdate(pInputMsg61.getROWCCMN01UIG00().getTsLastUpdate());
        pCCMN46DInputRec.setArchInputStruct(pInputMsg61.getArchInputStruct());
        rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
        
        
        /*
        ** Analyze return code
        ** LUT switch
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pInputMsg61.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
                    pOutputMsg63.setUlIdEvent(pCCMN46DOutputRec.getUlIdEvent());
                    pInputMsg61.getROWCCMN01UIG00().setUlIdEvent(pCCMN46DOutputRec.getUlIdEvent());
                }
                //  GOLDBEDA 11/28/95 - Pass back the IdEvent even if the required
                // action is modify. This is for the sake of consistancy. The calling
                // window can ALWAYS assume that it will get the IdEvent back.
                else if (pInputMsg61.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
                    pOutputMsg63.setUlIdEvent(pInputMsg61.getROWCCMN01UIG00().getUlIdEvent());
                }
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();// loop variable
        }
        return rc;
    }

    static int CallCCMN68D(CCMN01UI pInputMsg62, CCMN01UO * pOutputMsg64, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i68 = 0;
        CCMN68DI pCCMN68DInputRec = null;
        CCMN68DO pCCMN68DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN68DInputRec = new CCMN68DI();
        
        pCCMN68DOutputRec = new CCMN68DO();
        pCCMN68DInputRec.setArchInputStruct(pInputMsg62.getArchInputStruct());
        
        /*
        ** FOUNDATION Migration 3.2 - David Snider 4/28/99
        ** changed SIZ to SIZE with new ccmn01ui.h copybook
        */
        for (i68 = 0;i68 < CSYS07SI._ROWCCMN01UIG00__ROWCCMN01UIG01_SIZE;i68++) {
            if (pInputMsg62.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i68).getUlIdPerson() != 0) {
                
                // 
                // Function Prototypes
                // 
                pCCMN68DInputRec.setUlIdEvent(pInputMsg62.getROWCCMN01UIG00().getUlIdEvent());
                pCCMN68DInputRec.setUlIdPerson(pInputMsg62.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i68).getUlIdPerson());
                pCCMN68DInputRec.setSzCdScrDataAction(pInputMsg62.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i68).getSzCdScrDataAction());
                
                pCCMN68DInputRec.setTsLastUpdate(pInputMsg62.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i68).getTsLastUpdate());
                pCCMN68DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg62.getROWCCMN01UIG00().getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(i68).getSzCdScrDataAction());
                rc = ccmn68dAUDdam(sqlca, pCCMN68DInputRec, pCCMN68DOutputRec);
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        //  This case (SQL_NOT_FOUND) would occur
                        // if (0 == pCCMN36DOutputRec->ArchOutputStruct.ulRowQty)
                        // This could happen if there had only been one employee
                        // in the IdUnit searched on (the "IN" approver of that unit),
                        // and someone else (on CAPS) had re-assigned that employee
                        // to a different unit between the time the ccmng5d dam was 
                        // executed and the time this dam (36d) was executed.
                        // This is highly unlikely; however, if this occurred 
                        // we would NOT want to continue processing on this 
                        // employee (within the current execution of this service), 
                        // therefore, set "rc = SQL_NOT_FOUND;".
                        // 
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        //  PROCESS_TUX_SQL_ERROR_TRANSACT is not necssary because the common
                        // function has already taken care of this call
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_WARNING;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        i68 = CSYS07SI._ROWCCMN01UIG00__ROWCCMN01UIG01_SIZE;
                        
                        break;
                    case WtcHelperConstants.SQL_DUPLICATE_KEY:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                        rc = Messages.MSG_CMN_UPDATE_FAILED;
                        i68 = CSYS07SI._ROWCCMN01UIG00__ROWCCMN01UIG01_SIZE;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                }
            }
            
            else {
                i68 = CSYS07SI._ROWCCMN01UIG00__ROWCCMN01UIG01_SIZE;
            }
        }
        return rc;
    }

}
