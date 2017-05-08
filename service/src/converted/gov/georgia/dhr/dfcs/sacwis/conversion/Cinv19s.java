package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC84DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC84DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS85DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS85DO;
/**************************************************************************
**
** Module File:   CINV19S.src
**
** Service Name:  CINV19S - APS INV DTL SMP
**
** Description:   Retrieves information for the APS Investigation Conclusion
**                window
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/22/95
**
** Programmer:    CRG
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   21 Mar 1997 12:38:40  $
**                      $Modtime:   21 Mar 1997 11:37:48  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/10/95  ODONNERJ  SIR 1969: Add Guardianship Document to CINV16W.WIN
**                      and add CSYS13D DAM to Service to retrieve
**                      Boolean Indicate Blob Exists
**  01/11/96    KRD     SIR 2629 - Added code to call the UnitAccess() common
**                      function to determine if any of the IdPersons passed
**                      into the service is the unit approver for the unit
**                      to which the stage is assigned.  Other minor changes
**                      to match the Release 1.x service shell.
**  01/11/96  GUARRICR  SIR 2618: Moved Event ID retrieved from Investigation
**                      Detail into input message so that Documents can be
**                      retrieved later into the service.
**  03/07/96  DENTONRA  SIR 3692 - Added error processing to include a msg
**                      no rows returned.  If stage = "SVC" then a "graceful"
**                      exit will be processed in the window, showing the
**                      user a message box, telling them that no data exists
**                      for this situation.  If stage is NOT SVC then the
**                      standard "non-graceful" Data Error message box will
**                      show in the window.  This processing occurs during
**                      the call to cinv44d.pc.
**  05/17/96  ODONNERJ  SIR# 2149/20031 - Changed the retrieval of bBLOBExists
**                      to retrieve for both Documents - Notif to LE and
**                      Guradianship Doc.  Replaced CSYS13D with CSYS06D.
**                      This dam also retrieves the tsBLOBLastUpdate for each.
**
**  03/17/97  GONZALCE  SIR 12090 - added CLSC84D to retrieve the
**                      ulIdPriorStage given a current stage.  Also added
**                      ulIdPriorStage to the service output message and
**                      populated it using clsc84d.
**
** 06/20/05   Nallavs  SIR 23663 - Added 11 new fields of stage closure checklist and LEP/Sensory
**                     Impairment Expandable section fiels from the
**                     Face to Face Narrative onto the Investigation Conclusion.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv19s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final String GUARD_DOCUMENT_TABLE = "GUAR_DOC_NARR";
    public static final String SERVICE = "SVC";
    /* SIR 2149/20031 - Define for StdBLOBStruct - we now have two documents!! */
    public static final int GUARDIANSHIP_DOCUMENT_INDEX = 0;
    public static final int APS_INVEST_NOTIF_LE_INDEX = 1;
    public static final String APS_NOTIF_LE_NARR = "APS_NOTIF_NARR_VIEW";
    
    /*
    ** SIR 12090
    */
    public static final String ADMIN_REVIEW = "ARI";
    CINV19SO CINV19S(CINV19SI cinv19si) {
        CINV19SO cinv19so = new CINV19SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int uCount = 0;/* loop variable */
        CCMN04UI pInput = null;
        CCMN04UO pOutput = null;
        rc = ARC_PRFServiceStartTime_TUX(cinv19si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(cinv19so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (cinv19si.getUlIdEvent() != 0) {
            rc = Ccmn01u.CallCCMN45D(cinv19si, cinv19so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = Cinv27s.CallCINV44D(cinv19si, cinv19so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        rc = CallCLSS85D(cinv19si, cinv19so, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        rc = Ccmn80s.CallCINT40D(cinv19si, cinv19so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCSYS06D(cinv19si, cinv19so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        /* 01/22/2003 DWW: Added for error handling */
        if (0 != cinv19so.getROWCINV19SOG02().getSzCdStage().compareTo(ADMIN_REVIEW)) {
            rc = Cinv14s.CallCLSC84D(cinv19si, cinv19so, pServiceStatus);
            
            switch (rc) 
            {
                case SUCCESS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        
        pInput = new CCMN04UI();
        
        pOutput = new CCMN04UO();
        pInput.setUlIdUnit(cinv19so.getROWCINV19SOG02().getUlIdUnit());
        
        
        while ((uCount < CINV19SI._CINV19SI__ULIDPERSON_SIZE) && (cinv19si.getUlIdPerson_ARRAY().getUlIdPerson(uCount) != 0)) {
            pInput.getUlIdPerson_ARRAY().setUlIdPerson(uCount, cinv19si.getUlIdPerson_ARRAY().getUlIdPerson(uCount));
            uCount++;
        }
        rc = Ccmn04u.UnitAccess(pInput, pOutput, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                cinv19so.setBSysIndSupervisor(pOutput.getBSysIndGeneric());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cinv19si.getArchInputStruct() , cinv19so.getArchOutputStruct());
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
        
        return cinv19so;
    }

    static int CallCCMN45D(CINV19SI pInputMsg640, CINV19SO pOutputMsg593, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
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
        pCCMN45DInputRec.setArchInputStruct(pInputMsg640.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(pInputMsg640.getUlIdEvent());
        
        
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg593.getROWCCMN45DO().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg593.getROWCCMN45DO().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                pOutputMsg593.getROWCCMN45DO().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pOutputMsg593.getROWCCMN45DO().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pOutputMsg593.getROWCCMN45DO().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg593.getROWCCMN45DO().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                pOutputMsg593.getROWCCMN45DO().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg593.getROWCCMN45DO().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg593.getROWCCMN45DO().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT40D(CINV19SI pInputMsg641, CINV19SO pOutputMsg594, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
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
        pCINT40DInputRec.setArchInputStruct(pInputMsg641.getArchInputStruct());
        pCINT40DInputRec.setUlIdStage(pInputMsg641.getUlIdStage());
        rc = cint40dQUERYdam(sqlca, pCINT40DInputRec, pCINT40DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg594.getROWCINV19SOG02().setUlIdStage(pCINT40DOutputRec.getUlIdStage());
                pOutputMsg594.getROWCINV19SOG02().setTmSysTmStageClose(pCINT40DOutputRec.getTmSysTmStageClose());
                pOutputMsg594.getROWCINV19SOG02().setTmSysTmStageStart(pCINT40DOutputRec.getTmSysTmStageStart());
                pOutputMsg594.getROWCINV19SOG02().setUlIdUnit(pCINT40DOutputRec.getUlIdUnit());
                pOutputMsg594.getROWCINV19SOG02().setBIndStageClose(pCINT40DOutputRec.getBIndStageClose());
                pOutputMsg594.getROWCINV19SOG02().setSzNmStage(pCINT40DOutputRec.getSzNmStage());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStage(pCINT40DOutputRec.getSzCdStage());
                
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageClassification(pCINT40DOutputRec.getSzCdStageClassification());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageCnty(pCINT40DOutputRec.getSzCdStageCnty());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageCurrPriority(pCINT40DOutputRec.getSzCdStageCurrPriority());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageInitialPriority(pCINT40DOutputRec.getSzCdStageInitialPriority());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageProgram(pCINT40DOutputRec.getSzCdStageProgram());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageReasonClosed(pCINT40DOutputRec.getSzCdStageReasonClosed());
                pOutputMsg594.getROWCINV19SOG02().setDtDtStageClose(pCINT40DOutputRec.getDtDtStageClose());
                pOutputMsg594.getROWCINV19SOG02().setDtDtStageStart(pCINT40DOutputRec.getDtDtStageStart());
                pOutputMsg594.getROWCINV19SOG02().setUlIdCase(pCINT40DOutputRec.getUlIdCase());
                pOutputMsg594.getROWCINV19SOG02().setUlIdSituation(pCINT40DOutputRec.getUlIdSituation());
                pOutputMsg594.getROWCINV19SOG02().setSzTxtStageClosureCmnts(pCINT40DOutputRec.getSzTxtStageClosureCmnts());
                pOutputMsg594.getROWCINV19SOG02().setSzTxtStagePriorityCmnts(pCINT40DOutputRec.getSzTxtStagePriorityCmnts());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageRegion(pCINT40DOutputRec.getSzCdStageRegion());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageRsnPriorityChgd(pCINT40DOutputRec.getSzCdStageRsnPriorityChgd());
                pOutputMsg594.getROWCINV19SOG02().setSzCdStageType(pCINT40DOutputRec.getSzCdStageType());
                pOutputMsg594.getROWCINV19SOG02().setTsLastUpdate(pCINT40DOutputRec.getTsLastUpdate());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINV44D(CINV19SI pInputMsg642, CINV19SO pOutputMsg595, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINV44DI pCINV44DInputRec = null;
        CINV44DO pCINV44DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV44DInputRec = new CINV44DI();
        
        pCINV44DOutputRec = new CINV44DO();
        pCINV44DInputRec.setArchInputStruct(pInputMsg642.getArchInputStruct());
        pCINV44DInputRec.setUlIdStage(pInputMsg642.getUlIdStage());
        
        /*
        ** Call DAM
        */
        rc = cinv44dQUERYdam(sqlca, pCINV44DInputRec, pCINV44DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg595.getROWCINV19SOG01().setUlIdEvent(pCINV44DOutputRec.getROWCINV44DO().getUlIdEvent());
                pOutputMsg595.getROWCINV19SOG01().setUlIdStage(pCINV44DOutputRec.getROWCINV44DO().getUlIdStage());
                pOutputMsg595.getROWCINV19SOG01().setSzCdApsInvstFinalPrty(pCINV44DOutputRec.getROWCINV44DO().getSzCdApsInvstFinalPrty());
                pOutputMsg595.getROWCINV19SOG01().setSzcdApsInvstOvrallDisp(pCINV44DOutputRec.getROWCINV44DO().getSzcdApsInvstOvrallDisp());
                pOutputMsg595.getROWCINV19SOG01().setDtDtApsInvstBegun(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstBegun());
                pOutputMsg595.getROWCINV19SOG01().setDtDtApsInvstCltAssmt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCltAssmt());
                pOutputMsg595.getROWCINV19SOG01().setDtDtApsInvstCmplt(pCINV44DOutputRec.getROWCINV44DO().getDtDtApsInvstCmplt());
                
                //  Increment counter by 1
                pOutputMsg595.getROWCINV19SOG01().setTsLastUpdate(pCINV44DOutputRec.getROWCINV44DO().getTsLastUpdate());
                pOutputMsg595.getROWCINV19SOG01().setSzCdClosureType(pCINV44DOutputRec.getROWCINV44DO().getSzCdClosureType());
                
                //  Increment counter by 1
                pOutputMsg595.getROWCINV19SOG01().setBIndExtDoc(pCINV44DOutputRec.getROWCINV44DO().getBIndExtDoc());
                pOutputMsg595.getROWCINV19SOG01().setBIndLegalAction(pCINV44DOutputRec.getROWCINV44DO().getBIndLegalAction());
                
                pOutputMsg595.getROWCINV19SOG01().setBIndFamViolence(pCINV44DOutputRec.getROWCINV44DO().getBIndFamViolence());
                pOutputMsg595.getROWCINV19SOG01().setBIndECS(pCINV44DOutputRec.getROWCINV44DO().getBIndECS());
                pOutputMsg595.getROWCINV19SOG01().setBIndClient(pCINV44DOutputRec.getROWCINV44DO().getBIndClient());
                pOutputMsg595.getROWCINV19SOG01().setSzTxtClientOther(pCINV44DOutputRec.getROWCINV44DO().getSzTxtClientOther());
                pOutputMsg595.getROWCINV19SOG01().setSzCdInterpreter(pCINV44DOutputRec.getROWCINV44DO().getSzCdInterpreter());
                pOutputMsg595.getROWCINV19SOG01().setSzTxtMethodComm(pCINV44DOutputRec.getROWCINV44DO().getSzTxtMethodComm());
                pOutputMsg595.getROWCINV19SOG01().setSzTxtTrnsNameRlt(pCINV44DOutputRec.getROWCINV44DO().getSzTxtTrnsNameRlt());
                pOutputMsg595.getROWCINV19SOG01().setSzTxtAltComm(pCINV44DOutputRec.getROWCINV44DO().getSzTxtAltComm());
                
                if (!(pInputMsg642.getUlIdEvent() != 0)) {
                    
                    //  Increment counter by 1
                    pInputMsg642.setUlIdEvent(pCINV44DOutputRec.getROWCINV44DO().getUlIdEvent());
                }
                // Possible not to be part of an event
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                if (0 == pInputMsg642.getSzCdStage().compareTo(SERVICE)) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_INV_NO_EXISTS;
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                    break;
                }
                
                else {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
                }
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCSYS06D(CINV19SI pInputMsg643, CINV19SO pOutputMsg596, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSYS06DI pCSYS06DInputRec = null;
        CSYS06DO pCSYS06DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS06DInputRec = new CSYS06DI();
        pCSYS06DOutputRec = new CSYS06DO();
        pCSYS06DInputRec.setArchInputStruct(pInputMsg643.getArchInputStruct());
        pCSYS06DInputRec.setUlIdEvent(pInputMsg643.getUlIdEvent());
        pCSYS06DInputRec.setSzSysTxtTablename(GUARD_DOCUMENT_TABLE);
        rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg596.getBIndBLOBExistsInDatabase()[GUARDIANSHIP_DOCUMENT_INDEX] = true;
                
                pOutputMsg596.getTsBLOBLastUpdate_ARRAY().setTsBLOBLastUpdate(GUARDIANSHIP_DOCUMENT_INDEX, pCSYS06DOutputRec.getTsLastUpdate());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg596.getBIndBLOBExistsInDatabase()[GUARDIANSHIP_DOCUMENT_INDEX] = false;
                pOutputMsg596.getTsBLOBLastUpdate_ARRAY().setTsBLOBLastUpdate(GUARDIANSHIP_DOCUMENT_INDEX, null);
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        pCSYS06DInputRec.setUlIdEvent(pInputMsg643.getUlIdStage());
        pCSYS06DInputRec.setSzSysTxtTablename(APS_NOTIF_LE_NARR);
        rc = csys06dQUERYdam(sqlca, pCSYS06DInputRec, pCSYS06DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg596.getBIndBLOBExistsInDatabase()[APS_INVEST_NOTIF_LE_INDEX] = true;
                pOutputMsg596.getTsBLOBLastUpdate_ARRAY().setTsBLOBLastUpdate(APS_INVEST_NOTIF_LE_INDEX, pCSYS06DOutputRec.getTsLastUpdate());
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg596.getBIndBLOBExistsInDatabase()[APS_INVEST_NOTIF_LE_INDEX] = false;
                pOutputMsg596.getTsBLOBLastUpdate_ARRAY().setTsBLOBLastUpdate(APS_INVEST_NOTIF_LE_INDEX, null);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    
    static int CallCLSC84D(CINV19SI pInputMsg644, CINV19SO pOutputMsg597, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CLSC84DI pCLSC84DInputRec = null;
        CLSC84DO pCLSC84DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSC84DInputRec = new CLSC84DI();
        
        pCLSC84DOutputRec = new CLSC84DO();
        pCLSC84DInputRec.setUlIdStage(pInputMsg644.getUlIdStage());
        pCLSC84DInputRec.setArchInputStruct(pInputMsg644.getArchInputStruct());
        rc = clsc84dQUERYdam(sqlca, pCLSC84DInputRec, pCLSC84DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg597.getROWCINV19SOG02().setUlIdPriorStage(pCLSC84DOutputRec.getUlIdPriorStage());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCLSS85D(CINV19SI pInputMsg645, CINV19SO pOutputMsg598, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i325 = 0;
        
        /*
        ** Declare local variables
        */
        CLSS85DI pCLSS85DInputRec = null;
        CLSS85DO pCLSS85DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS85DInputRec = new CLSS85DI();
        
        pCLSS85DOutputRec = new CLSS85DO();
        pCLSS85DInputRec.setUlIdStage(pInputMsg645.getUlIdStage());
        
        pCLSS85DInputRec.setArchInputStruct(pInputMsg645.getArchInputStruct());
        
        rc = clss85dQUERYdam(sqlca, pCLSS85DInputRec, pCLSS85DOutputRec);
        
        // 01/17/03  Srini D Commenting the writing of info to file.   				    
        //       fprintf(fp, "CheckStageEventStatus: rc = %d\n",rc);
        //       fflush(fp);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i325 = 0;i325 < pCLSS85DOutputRec.getArchOutputStruct().getUlRowQty();++i325) {
                    // SIR 22686 if group home is false, save 63A-D else save 63A-C
                    if (0 != pCLSS85DOutputRec.getROWCLSS85DO_ARRAY().getROWCLSS85DO(i325).getSzCdStagePersRole().compareTo("VP") && 0 != pCLSS85DOutputRec.getROWCLSS85DO_ARRAY().getROWCLSS85DO(i325).getSzCdStagePersRole().compareTo("CL")) {
                        pOutputMsg598.getROWCINV19SOG01().setBIndPerp('Y');
                        
                        // WE PROBABLY DONT NEED THIS CASE
                        
                        break;
                    }
                    
                    else {
                        pOutputMsg598.getROWCINV19SOG01().setBIndPerp('N');
                    }
                };
                pOutputMsg598.getArchOutputStruct().setUlRowQty(pCLSS85DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg598.getArchOutputStruct().setBMoreDataInd(pCLSS85DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
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

}
