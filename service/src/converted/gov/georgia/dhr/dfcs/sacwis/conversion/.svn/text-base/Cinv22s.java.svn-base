package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25DO;
/**************************************************************************
** 
** Module File:   CINV22S.src
**
** Service Name:  CINV22S
**
** Description:   An AUD service to add, update, or delete External
**                Documentation records.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  2/21/95 
** 
** Programmer:    Terry T. Cavallaro
**
** Change History:
** Date      User      Description
** --------  --------  ------------------------------------------
** 11/21/95  HELMKEST  Added CheckStageEventStatus common function to the 
**                     service.               
** 01/22/96  GUARRICR  SIR 2800: Changed logic so that CheckStageEventStatus
**                     is only called when a Stage ID is passed in. This is
**                     so saves can occur when the window is accessed from
**                     Case Summary.
**
**  08/13/96  VANDERM   SIR 21968 - Database needs to be restored for all
**                      AUD services which return errors.  Thus the error
**                      handling for all AUD dams was changed from 
**                      FND_SEVERITY_WARNING to FND_SEVERITY_ERROR.
**
**  05/04/98  SOHNJJ    SIR #14298 - MHMR Enhancement Item 3: Allow the user
**                      to sort the items listed on the Facility Abuse/
**                      Neglect document and the External Documentation
**                      report.  Added the column, CD_EXT_DOC_SORT to the
**                      EXT_DOCUMENTATION table to store the user's sort
**                      order.
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






public class Cinv22s {
    CINV22SO CINV22S(CINV22SI cinv22si) {
        CINV22SO cinv22so = new CINV22SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /* Declare local variables */
        
        /* SIR 1710: Variables used in CheckStageEventStatus common function */
        int RetVal = SUCCESS;
        
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv22si.getArchInputStruct());
        
        if (cinv22si.getUlIdStage() != 0) {
            // 
            // SIR 1710:  
            // (BEGIN): Common Function: ccmn06u   Check Stage/Event common function
            // 
            
            //  Allocate memory for Common Function Input and Output Structures
            pCCMN06UInputRec = new CCMN06UI();
            
            pCCMN06UOutputRec = new CCMN06UO();
            
            pCCMN06UInputRec.setArchInputStruct(cinv22si.getArchInputStruct());
            pCCMN06UInputRec.getArchInputStruct().setCReqFuncCd(cinv22si.getArchInputStruct().getCReqFuncCd());
            pCCMN06UInputRec.setUlIdStage(cinv22si.getUlIdStage());
            pCCMN06UInputRec.setSzCdTask(cinv22si.getSzCdTask());
            
            //  Call CSEC33D
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
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
                    
                case Messages.MSG_SYS_EVENT_STS_MSMTCH:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_EVENT_STS_MSMTCH;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
                case Messages.MSG_SYS_MULT_INST:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_SYS_MULT_INST;
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  Set RetVal to FND_FAIL
                    RetVal = Csub50s.FND_FAIL;
                    
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            
            // Set rc to ARC_SUCCESS
            rc = CallCINV25D(cinv22si, cinv22so, pServiceStatus);
            
            switch (rc) {
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                case Messages.MSG_CMN_UPDATE_FAILED:
                    
                    
                    
                    // 
                    // End Call to EVENT STATUS AUD Dam - CAUD64D
                    // 
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    
            }
        }
        
        /* Load translation map with service name and version */
        
        /* Stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(cinv22si.getArchInputStruct() , cinv22so.getArchOutputStruct());
        
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
        return cinv22so;
    }

    static int CallCINV25D(CINV22SI pInputMsg671, CINV22SO * pOutputMsg621, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i336 = 0;
        int rc = WtcHelperConstants.SQL_SUCCESS;/* Return code */
        CINV25DI pCINV25DInputRec = null;
        CINV25DO pCINV25DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV25DInputRec = new CINV25DI();
        
        pCINV25DOutputRec = new CINV25DO();
        pCINV25DInputRec.setArchInputStruct(pInputMsg671.getArchInputStruct());
        
        
        /************ Populate document additions/updates ************/
        
        for (i336 = 0;i336 < pInputMsg671.getUsSysNbrNumberOfRows();i336++) {
            pCINV25DInputRec.getROWCINV25DI().setUlIdCase(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getUlIdCase());
            pCINV25DInputRec.getROWCINV25DI().setUlIdExtSitInfo(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getUlIdExtSitInfo());
            pCINV25DInputRec.getROWCINV25DI().setSzCdExtDocType(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getSzCdExtDocType());
            
            pCINV25DInputRec.getROWCINV25DI().getDtDtExtDocObtained().day = pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getDtDtExtDocObtained().day;
            
            //## BEGIN TUX/XML: Declare XML variables
            pCINV25DInputRec.getROWCINV25DI().getDtDtExtDocObtained().month = pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getDtDtExtDocObtained().month;
            pCINV25DInputRec.getROWCINV25DI().getDtDtExtDocObtained().year = pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getDtDtExtDocObtained().year;
            pCINV25DInputRec.getROWCINV25DI().setSzTxtExtDocLocation(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getSzTxtExtDocLocation());
            pCINV25DInputRec.getROWCINV25DI().setSzTxtExtDocDetails(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getSzTxtExtDocDetails());
            pCINV25DInputRec.getROWCINV25DI().setTsLastUpdate(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getTsLastUpdate());
            pCINV25DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getSzCdScrDataAction());
            pCINV25DInputRec.getROWCINV25DI().setSzCdExtDocSort(pInputMsg671.getROWCINV22SIG_ARRAY().getROWCINV22SIG(i336).getSzCdExtDocSort());
            rc = cinv25dAUDdam(sqlca, pCINV25DInputRec, pCINV25DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Call DAM
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    //  nothing to return in the Output Message
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

}
