package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN46DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN57DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN62DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN62DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN88DO;
/**************************************************************************
**
** Module File:   CCMN05U.SRC
**
** Service Name:  CCMN05U - INVALIDATE APPROVAL COMMON FUNCTION
**
** Description:   This library / common function will the approval related
**                to a given ID EVENT. Functional Events are uniquely
**                identified by this input. This function will find the
**                the ID APPROVAL (ID EVENT of the approval event) from
**                the Approval Event List Table. This key information will
**                allow the function to complete the following: Update
**                the Approval Event, Get any other functional events
**                related to the same Approval and demote them, set any
**                pending related approvers to invalid status.
**
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  08 March 1995
**
** Programmer:    Ian Fogarty / Andersen Consulting
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:42:48  $
**                      $Modtime:   02 Feb 1996 13:03:38  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/16/95  ELLIOTSL  Changed ARC_ERR_FATAL_RETURN to ARC_ERR_NO_PROC_RC
**
**  05/16/95  ELLIOTSL  Added logic based on the service shell to check
**                      for NULL pointers returned from mallocs.
**
**  05/16/95  ELLIOTSL  Both prototype and body of each CallCCMN??D function
**                      has been changed to use the new TUX_DECL_STATUSPARMS
**                      macro.
**
**  05/18/95  ELLIOTSL  Logic has been changed for CallCCMN62D so that it
**                      will exit immediately upon an unexpected DAM
**                      error.
**  09/28/95    KRD     Superficial changes to match the Release 1.x
**                      service shell.
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  05/23/2003  KRD     SIR 17534 - The Common Function needs to fail
**                      gracefully if an approval event is not found.
**                      Required changes to the main service function and
**                      CallCCMN55D().
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
public class Ccmn05u {
    static int InvalidateAprvl(CCMN05UI pInputMsg208, CCMN05UO pOutputMsg189, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        pServiceStatus.severity = FND_SEVERITY_OK;
        pServiceStatus.explan_code = SUCCESS;
        if (false == pInputMsg208.getArchInputStruct().getUlSysNbrReserved1()) {
            rc = Ccmn34s.CallCCMN55D(pInputMsg208, pOutputMsg189, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    return SUCCESS;
                    
                    break;
                    //  IMPACT END
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                    
                    break;
            }
            rc = Ccmn01u.CallCCMN45D(pInputMsg208, pOutputMsg189, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            rc = Ccmn01u.CallCCMN46D(pInputMsg208, pOutputMsg189, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            rc = Ccmn34s.CallCCMN57D(pInputMsg208, pOutputMsg189, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            
            //  Call DAM
            rc = Ccmn19s.CallCCMN62D(pInputMsg208, pOutputMsg189, pServiceStatus);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            rc = Ccmn35s.CallCCMN88D(pInputMsg208, pOutputMsg189, pServiceStatus);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN45D(CCMN05UI pInputMsg209, CCMN05UO * pOutputMsg190, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
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
        pCCMN45DInputRec.setUlIdEvent(pInputMsg209.getUlIdApproval());
        pCCMN45DInputRec.setArchInputStruct(pInputMsg209.getArchInputStruct());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg209.getROWCCMN45DO().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pInputMsg209.getROWCCMN45DO().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                pInputMsg209.getROWCCMN45DO().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pInputMsg209.getROWCCMN45DO().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pInputMsg209.getROWCCMN45DO().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pInputMsg209.getROWCCMN45DO().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pInputMsg209.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pInputMsg209.getROWCCMN45DO().getDtDtEventOccurred().month = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().month;
                pInputMsg209.getROWCCMN45DO().getDtDtEventOccurred().day = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().day;
                pInputMsg209.getROWCCMN45DO().getDtDtEventOccurred().year = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().year;
                pInputMsg209.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMN46D(CCMN05UI pInputMsg210, CCMN05UO * pOutputMsg191, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        /*
        ** SIR 1664
        */
        pCCMN46DInputRec.setUlIdEvent(pInputMsg210.getROWCCMN45DO().getUlIdEvent());
        pCCMN46DInputRec.setUlIdPerson(pInputMsg210.getROWCCMN45DO().getUlIdPerson());
        pCCMN46DInputRec.setUlIdStage(pInputMsg210.getROWCCMN45DO().getUlIdStage());
        
        /*
        ** MHMR Phase III Issue 1 (RIOSJA)
        */
        pCCMN46DInputRec.setDtDtEventOccurred(pInputMsg210.getROWCCMN45DO().getDtDtEventOccurred());
        pCCMN46DInputRec.setTsLastUpdate(pInputMsg210.getROWCCMN45DO().getTsLastUpdate());
        pCCMN46DInputRec.setSzCdEventStatus("COMP");
        
        pCCMN46DInputRec.setSzCdTask(pInputMsg210.getROWCCMN45DO().getSzCdTask());
        pCCMN46DInputRec.setSzCdEventType(pInputMsg210.getROWCCMN45DO().getSzCdEventType());
        pCCMN46DInputRec.setSzTxtEventDescr(pInputMsg210.getROWCCMN45DO().getSzTxtEventDescr());
        pCCMN46DInputRec.setArchInputStruct(pInputMsg210.getArchInputStruct());
        pCCMN46DInputRec.getArchInputStruct().setCReqFuncCd('U');
        
        rc = ccmn46dAUDdam(sqlca, pCCMN46DInputRec, pCCMN46DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

    static int CallCCMN55D(CCMN05UI pInputMsg211, CCMN05UO * pOutputMsg192, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN55DI pCCMN55DInputRec = null;
        CCMN55DO pCCMN55DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN55DInputRec = new CCMN55DI();
        
        pCCMN55DOutputRec = new CCMN55DO();
        pCCMN55DInputRec.setUlIdEvent(pInputMsg211.getUlIdEvent());
        pCCMN55DInputRec.setArchInputStruct(pInputMsg211.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = ccmn55dQUERYdam(sqlca, pCCMN55DInputRec, pCCMN55DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pInputMsg211.setUlIdApproval(pCCMN55DOutputRec.getUlIdApproval());
                
                //  IMPACT BEGIN - ensure that the return code is set correctly when
                // no allegations are found.
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        
        return rc;
        
    }

    static int CallCCMN57D(CCMN05UI pInputMsg212, CCMN05UO pOutputMsg193, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i119 = 0;
        /*
        ** Declare local variables
        */
        CCMN57DI pCCMN57DInputRec = null;
        CCMN57DO pCCMN57DOutputRec = null;
        
        pCCMN57DInputRec = new CCMN57DI();
        
        pCCMN57DOutputRec = new CCMN57DO();
        pCCMN57DInputRec.setUlIdApproval(pInputMsg212.getUlIdApproval());
        pCCMN57DInputRec.setArchInputStruct(pInputMsg212.getArchInputStruct());
        pCCMN57DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN57DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN05UI._CCMN05UI__ROWCCMN57DO_SIZE);
        
        rc = ccmn57dQUERYdam(sqlca, pCCMN57DInputRec, pCCMN57DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Update Input Message
                for (i119 = 0;i119 < pCCMN57DOutputRec.getArchOutputStruct().getUlRowQty();++i119) {
                    
                    //  Exit service
                    pInputMsg212.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i119).setUlIdEvent(pCCMN57DOutputRec.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i119).getUlIdEvent());
                    pInputMsg212.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i119).setSzCdTask(pCCMN57DOutputRec.getROWCCMN57DO_ARRAY().getROWCCMN57DO(i119).getSzCdTask());
                };
                pOutputMsg193.getArchOutputStruct().setUlRowQty(pCCMN57DOutputRec.getArchOutputStruct().getUlRowQty());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
                
                
                
                
                break;
        }
        return rc;
    }

    static int CallCCMN62D(CCMN05UI pInputMsg213, CCMN05UO pOutputMsg194, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        /*
        ** Declare local variables
        */
        /* The ARC_SUCCESS initializtion has been added to the following line
        ** so that the logic relevant exiting out of the loop in this function
        ** will work correctly.
        */
        int iCount = 0;
        CCMN62DI pCCMN62DInputRec = null;/* SIR #21130 */
        CCMN62DO pCCMN62DOutputRec = null;/* SIR #21130 */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN62DInputRec = new CCMN62DI();
        
        pCCMN62DOutputRec = new CCMN62DO();
        pCCMN62DInputRec.setArchInputStruct(pInputMsg213.getArchInputStruct());
        
        /*
        ** "rc" has been added to the following line.  See comment in change
        ** history for details.
        */
        for (iCount = 0;(rc == WtcHelperConstants.ARC_SUCCESS) && (iCount < pOutputMsg194.getArchOutputStruct().getUlRowQty());iCount++) {
            
            //  SIR #21680 - Retrieve the School District decode from the
            // database in order to pass through Demographics to the Resource
            // Address Window where it will be displayed in the listbox.
            
            if (pInputMsg213.getROWCCMN57DO_ARRAY().getROWCCMN57DO(iCount).getUlIdEvent() != pInputMsg213.getUlIdEvent()) {
                pCCMN62DInputRec.setUlIdEvent(pInputMsg213.getROWCCMN57DO_ARRAY().getROWCCMN57DO(iCount).getUlIdEvent());
                pCCMN62DInputRec.setSzCdEventStatus("COMP");
                pCCMN62DInputRec.getArchInputStruct().setCReqFuncCd('U');
                
                //  Initialize Service Status Fields
                
                //  Perform Main Processing
                
                //  Set pOutputMsg WCD DtSystemDate to current date
                rc = ccmn62dAUDdam(sqlca, pCCMN62DInputRec, pCCMN62DOutputRec);
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        // 
                        // SIR 21130 - added CCMN87D to retrieve the id_event of the Stage closure
                        // event if there is one.
                        // (BEGIN): Retrieve DAM: CCMN87D     
                        // 
                        
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        //##                        sprintf(pReturnPB->appl_status.explan_data,
                        //##                                "%u",
                        //##                                pInputMsg->ROWCCON06SIG00[usInputRow].ulNbrCnperPeriod);      
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                        break;
                }
            }
        }
        return rc;
    }

    static int CallCCMN88D(CCMN05UI pInputMsg214, CCMN05UO * pOutputMsg195, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN88DI pCCMN88DInputRec = null;
        CCMN88DO pCCMN88DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN88DInputRec = new CCMN88DI();
        
        pCCMN88DOutputRec = new CCMN88DO();
        pCCMN88DInputRec.setUlIdApproval(pInputMsg214.getUlIdApproval());
        pCCMN88DInputRec.setArchInputStruct(pInputMsg214.getArchInputStruct());
        pCCMN88DInputRec.getArchInputStruct().setCReqFuncCd('U');
        rc = ccmn88dAUDdam(sqlca, pCCMN88DInputRec, pCCMN88DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                //  Do nothing, the output message just returns success or
                // failure
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                break;
        }
        return rc;
    }

}
