package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV55SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn05u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV43DO;
/**************************************************************************
**
** Module File:    CINV55S.src
**
** Service Name:   Services and Referrals Save
**
** Description:   This service calls DAMS CAUDE3D.pc and CAUDE4D.pc.
**                This service will save or update all columns on the
**                CPS_CHKLST table.  It will also insert or delete one
**                or more rows from the CPS_CHKLST_ITEM table, depending
**                on what was changed in the Services and Referrals
**                Checklist window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V4.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/05/2001
**
** Programmer:    Jenn Casdorph
**
** Archive Information: $Revision:   1.4  $
**                      $Date:   01 Feb 2002 10:18:06  $
**                      $Modtime:   01 Feb 2002 08:22:10  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/05/01  hafelela  Initial Shell
**
**  10/07/01  casdorjm  Initial Coding of Design
**
**  11/02/2001  KRD     Made some changes so that saving the window for the
**                      first time will work correctly.
**
**  11/08/2001  KRD     Added code to call the CheckStageEventStatus() and
**                      InvalidateAprvl() common functions (CCMN06U and
**                      CCMN05U, respectively).  Made changes to
**                      CallCCMN45D() and CallPOSTEVENT() to more
**                      effeciently support the new common functions.
**                      Renamed macros COMPLETE and
**                      SERVICES_AND_REFERRALS_CHECKLIST to
**                      EVENT_STATUS_COMPLETE and CD_TASK_SARC.
**
**  12/27/2001  KRD     SIR 15978 - Prior to this SIR, the SAR event and the
**                      Checklist information were both inserted/updated based
**                      upon a single function code flag.  However, it is
**                      possible for the SAR event to exist before the
**                      Checklist window is entered, so the first time the
**                      window is saved a "Save Failed" message is generated
**                      due to an incorrect function code.  Modified
**                      CallPOSTEVENT() and CallCCMN06U() to use a different
**                      instead of sharing the Checklist's flag.
**
**  02/01/2002  CWC     SIR 15978 - Added call to CCMN43D to update the ToDo
**                      table when the Services and Referrals Checklist is completed
**                      when navigating through the ToDo window.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  05/05/2003  KRD     IMPACT - Code changes applied to support
**                      "Approver Mode" providing supervisors the ability to
**                      modify data without invalidating the pending
**                      approval.
**
**  06/28/04  RIOSJA    SIR 16114 - Services and Referrals Checklist will
**                      now be available for all family stages (FPR, FRE
**                      and FSU). Three new task codes were added--one for
**                      each stage. The task codes will now be passed into
**                      this service.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv55s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String EVENT_STATUS_COMPLETE = "COMP";
    
    public static final String CHECKLIST = "CHK";
    
    /* Event Description */
    public static final String SERVICES_AND_REFERRALS_EVENT = "Services and Referrals Checklist";
    CINV55SO CINV55S(CINV55SI cinv55si) {
        CINV55SO cinv55so = new CINV55SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int RetVal = SUCCESS;/* Return value for service  */
        int i385 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        
        CINV55SI CINV55SInputRec = null;
        CINV55SO CINV55SOutputRec = null;
        
        CCMN45DO CCMN45DOutRec = null;
        CCMN05UI CCMN05UInRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv55si.getArchInputStruct());
        rc = CallCCMN06U(cinv55si, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                RetVal = SUCCESS;
                break;
                
            default :
                RetVal = Csub50s.FND_FAIL;
                break;
        }
        if ((SUCCESS == RetVal) && (0 != cinv55si.getROWCINV55SIG01().getUlIdEvent())) {
            
            
            //  Call CAUD35D
            rc = Ccmn01u.CallCCMN45D(cinv55si, CCMN45DOutRec, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if ((SUCCESS == RetVal) && (0 == strncmp(CCMN45DOutRec.getROWCCMN45DO().getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length())) && (false == cinv55si.getArchInputStruct().getUlSysNbrReserved1())) {
            CCMN05UInRec.setUlIdEvent(cinv55si.getROWCINV55SIG01().getUlIdEvent());
            rc = Cinv16s.CallCCMN05U(cinv55si, CCMN05UInRec, pServiceStatus);
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if (SUCCESS == RetVal) {
            rc = CallPOSTEVENT(cinv55si, CCMN45DOutRec, pServiceStatus);
            
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        
        /**************************************************************************
        ** Analyze error code
        ***************************************************************************/
        if (SUCCESS == RetVal) {
            
            
            //  Call CAUD36D
            rc = CallCAUDE3D(cinv55si, cinv55so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    RetVal = SUCCESS;
                    break;
                default :
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        /* Task Decodes populated in output message per SIR 168 */
        if (SUCCESS == RetVal) {
            rc = CallCAUDE4D(cinv55si, cinv55so, pServiceStatus);
            
            //  Analyze error code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        if ((0 != cinv55si.getROWCINV55SIG01().getUlIdEvent()) && ((0 == strncmp(CCMN45DOutRec.getROWCCMN45DO().getSzCdEventStatus() , EVENT_STATUS_COMPLETE, EVENT_STATUS_COMPLETE.length())) || (0 == strncmp(CCMN45DOutRec.getROWCCMN45DO().getSzCdEventStatus() , EVENT_STATUS_NEW, EVENT_STATUS_NEW.length())))) {
            rc = Cinv12s.CallCINV43D(cinv55si, cinv55so, pServiceStatus);
        }
        
        /*
        ** Load Translation Map with service name and version
        */
        
        /*
        ** Stop Performance Timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv55si.getArchInputStruct() , cinv55so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        
        /*
        ** Analyze error code
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Call CCMN01U
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cinv55so;
    }

    static int CallPOSTEVENT(CINV55SI pInputMsg765, CCMN45DO pCCMN45DOutRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMN01UI pCCMN01UInputRec = null;
        CCMN01UO pCCMN01UOutputRec = null;
        
        /*
        ** Allocate memory for Common Function Input and Output Structures
        */
        pCCMN01UInputRec = new CCMN01UI();
        
        pCCMN01UOutputRec = new CCMN01UO();
        pCCMN01UInputRec.setArchInputStruct(pInputMsg765.getArchInputStruct());
        
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdTask(pInputMsg765.getROWCINV55SIG01().getSzCdTask());
        if (false == pInputMsg765.getArchInputStruct().getUlSysNbrReserved1()) {
            
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_COMPLETE);
        }
        else {
            pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventStatus(EVENT_STATUS_PENDING);
        }
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzCdEventType(CHECKLIST);
        rc = ARC_UTLGetDateAndTime(pCCMN01UInputRec.getROWCCMN01UIG00().getDtDtEventOccurred() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdEvent(pInputMsg765.getROWCINV55SIG01().getUlIdEvent());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdStage(pInputMsg765.getROWCINV55SIG01().getUlIdStage());
        pCCMN01UInputRec.getROWCCMN01UIG00().setUlIdPerson(pInputMsg765.getUlIdPerson());
        pCCMN01UInputRec.getROWCCMN01UIG00().setSzTxtEventDescr(SERVICES_AND_REFERRALS_EVENT);
        pCCMN01UInputRec.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutRec.getROWCCMN45DO().getTsLastUpdate());
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        
        /*
        ** Start performance timer for service 
        */
        rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                pInputMsg765.getROWCINV55SIG01().setUlIdEvent(pCCMN01UOutputRec.getUlIdEvent());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN45D(CINV55SI pInputMsg766, CCMN45DO pOutputMsg713, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        
        /* Allocate memory for Input and Output Structures */
        
        
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg766.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg766.getROWCINV55SIG01().getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg713 = pCCMN45DOutputRec;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                //  The timestamps are now in the InputMsg.
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCAUDE3D(CINV55SI pInputMsg767, CINV55SO pOutputMsg714, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CAUDE3DI pCAUDE3DInputRec = null;
        CAUDE3DO pCAUDE3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDE3DInputRec = new CAUDE3DI();
        
        pCAUDE3DOutputRec = new CAUDE3DO();
        pCAUDE3DInputRec.setArchInputStruct(pInputMsg767.getArchInputStruct());
        pCAUDE3DInputRec.setUlIdEvent(pInputMsg767.getROWCINV55SIG01().getUlIdEvent());
        pCAUDE3DInputRec.setUlIdCase(pInputMsg767.getROWCINV55SIG01().getUlIdCase());
        pCAUDE3DInputRec.setUlIdCpsChecklist(pInputMsg767.getROWCINV55SIG01().getUlIdCpsChecklist());
        pCAUDE3DInputRec.setUlIdStage(pInputMsg767.getROWCINV55SIG01().getUlIdStage());
        pCAUDE3DInputRec.setDtDtFirstReferral(pInputMsg767.getROWCINV55SIG01().getDtDtFirstReferral());
        pCAUDE3DInputRec.setTsLastUpdate(pInputMsg767.getROWCINV55SIG01().getTsLastUpdate());
        pCAUDE3DInputRec.setCIndSvcRefChklstNoRef(pInputMsg767.getROWCINV55SIG01().getCIndSvcRefChklstNoRef());
        pCAUDE3DInputRec.setSzCdFamilyResponse(pInputMsg767.getROWCINV55SIG01().getSzCdFamilyResponse());
        pCAUDE3DInputRec.setSzTxtChklstComments(pInputMsg767.getROWCINV55SIG01().getSzTxtChklstComments());
        pCAUDE3DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg767.getROWCINV55SIG01().getSzCdScrDataAction());
        
        /*
        ** Call DAM
        */
        rc = caude3dAUDdam(sqlca, pCAUDE3DInputRec, pCAUDE3DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg714.setUlIdCpsChecklist(pCAUDE3DOutputRec.getUlIdCpsChecklist());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                
                
                //  Start Performance Timer
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCAUDE4D(CINV55SI pInputMsg768, CINV55SO pOutputMsg715, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i386 = 0;
        
        /*
        ** Declare local variables
        */
        CAUDE4DI pCAUDE4DInputRec = null;
        CAUDE4DO pCAUDE4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDE4DInputRec = new CAUDE4DI();
        
        pCAUDE4DOutputRec = new CAUDE4DO();
        pCAUDE4DInputRec.setArchInputStruct(pInputMsg768.getArchInputStruct());
        pCAUDE4DInputRec.setUlIdEvent(pInputMsg768.getROWCINV55SIG01().getUlIdEvent());
        
        pCAUDE4DInputRec.setUlIdCase(pInputMsg768.getROWCINV55SIG01().getUlIdCase());
        pCAUDE4DInputRec.setUlIdStage(pInputMsg768.getROWCINV55SIG01().getUlIdStage());
        pCAUDE4DInputRec.setUlIdCpsChecklist(pOutputMsg715.getUlIdCpsChecklist());
        
        for (i386 = 0;((i386 < pInputMsg768.getArchInputStruct().getUlPageSizeNbr()) && (rc == 0));i386++) {
            pCAUDE4DInputRec.setUlIdChklstItem(pInputMsg768.getROWCINV55SIG00_ARRAY().getROWCINV55SIG00(i386).getUlIdChklstItem());
            pCAUDE4DInputRec.setSzCdSvcReferred(pInputMsg768.getROWCINV55SIG00_ARRAY().getROWCINV55SIG00(i386).getSzCdSvcReferred());
            pCAUDE4DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg768.getROWCINV55SIG00_ARRAY().getROWCINV55SIG00(i386).getSzCdScrDataAction());
            pCAUDE4DInputRec.setTsLastUpdate(pInputMsg768.getROWCINV55SIG00_ARRAY().getROWCINV55SIG00(i386).getTsLastUpdate());
            if (pCAUDE4DInputRec.getArchInputStruct().getCReqFuncCd() != null) {
                
                //  Call CheckStageEventStatus
                rc = caude4dAUDdam(sqlca, pCAUDE4DInputRec, pCAUDE4DOutputRec);
            }
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    
                    //  Call CSES73D
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCCMN06U(CINV55SI pInputMsg769, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CCMN06UI pCCMN06UInputRec = null;
        CCMN06UO pCCMN06UOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN06UInputRec = new CCMN06UI();
        
        pCCMN06UOutputRec = new CCMN06UO();
        pCCMN06UInputRec.setArchInputStruct(pInputMsg769.getArchInputStruct());
        pCCMN06UInputRec.setUlIdStage(pInputMsg769.getROWCINV55SIG01().getUlIdStage());
        ;
        pCCMN06UInputRec.setSzCdTask(pInputMsg769.getROWCINV55SIG01().getSzCdTask());
        
        /*
        ** Call CSES82D
        */
        rc = Ccmn06u.CheckStageEventStatus(pCCMN06UInputRec, pCCMN06UOutputRec, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                break;
                
            case Messages.MSG_SYS_STAGE_CLOSED:
            case Messages.MSG_SYS_EVENT_STS_MSMTCH:
            case Messages.MSG_SYS_MULT_INST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = rc;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN05U(CINV55SI pInputMsg770, CCMN05UI pCCMN05UInRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /*
        ** Declare local variables 
        */
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN05UI pInvdInput = null;
        CCMN05UO pInvdOutput = null;
        
        /*
        ** Reserve memory for Invalidate Function structures
        */
        pInvdInput = new CCMN05UI();
        
        pInvdOutput = new CCMN05UO();
        
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pInvdInput.setArchInputStruct(pInputMsg770.getArchInputStruct());
        pInvdInput.setUlIdEvent(pCCMN05UInRec.getUlIdEvent());
        rc = Ccmn05u.InvalidateAprvl(pInvdInput, pInvdOutput, pServiceStatus);
        return rc;
    }

    static int CallCINV43D(CINV55SI pInputMsg771, CINV55SO * pOutputMsg716, Arcxmlerrors.TUX_DECL_STATUSPARMS) {/* if service code is a foster code */
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CINV43DI pCINV43DInputRec = null;
        CINV43DO pCINV43DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV43DInputRec = new CINV43DI();
        pCINV43DOutputRec = new CINV43DO();
        pCINV43DInputRec.setArchInputStruct(pInputMsg771.getArchInputStruct());
        pCINV43DInputRec.setUlIdEvent(pInputMsg771.getROWCINV55SIG01().getUlIdEvent());
        
        rc = cinv43dAUDdam(sqlca, pCINV43DInputRec, pCINV43DOutputRec);
        if (rc != 0) {// if service code is a adoptive code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    rc = 0;
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

}
