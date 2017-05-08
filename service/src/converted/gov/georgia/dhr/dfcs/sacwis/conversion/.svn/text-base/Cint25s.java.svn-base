package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT07DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT07DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallDcsnAUD;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DetermListAUD;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT47DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT47DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
/**************************************************************************
** 
** Module File:   cint25s.src
**
** Service Name:  CINT25S
**                            
** Description:   This service retrieves the information for the Call
**                Entry and Call Decision windows.  It will retrieve
**                information from the INCOMING_DETAIL, STAGE, AND
**                INCMG_DETERM_FACTORS tables.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  12/6/94 
** 
** Programmer:    Mark Dunnagan, Andersen Consulting
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   30 Oct 1996 08:41:38  $
**                      $Modtime:   29 Oct 1996 16:56:10  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/27/95  ELLIOTSL  A assignment has been added so that the IND WORKER
**                      SAFETY will be copied from CINT07D's output to
**                      the service output message. 
**
**  08/10/95  DUNNAGME  A call was added to query the event table and send
**                      the status back to the client.
**                      SIR 1128 - Not directly stated in the SIR, but
**                      inclusion will avoid erroneous Notifications
**                      being created if the invalidate approval
**                      functionality is called more than once.
**
**  10/14/95  ELLIOTSL  ERR #1768: Condition added for no data found for
**                      CINT07D.  If the stage is not found then the
**                      client will display an error message.
**
**   26Mar96  sladewmf  SIR 4246: In the CallCINT07D function,
**                      copy ulIdResource from the Dam Output Message.
**
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
**  10/29/96    KRD     SIR 2928 - The Person List retrieval service
**                      (cint26s) retrieves from the PERSON_HISTORY table
**                      using the DtIncomingCallDisposed value retrieved in
**                      this service by DAM CINT07D.  Due to date conversions
**                      between a timestamp and "normal" date, the seconds
**                      were being lost and thereby set to zero.  Since
**                      Intake retrievals require the "precise-ness" of
**                      hours, minutes and seconds, CINT07D has been modified
**                      to return a timestamp version of the Call Disposed
**                      date.  Required a change to CallCINT07D().  Other
**                      changes have been made to the service for
**                      readability/maintainability purposes.
**
**  07/20/05   ochumd   Sir 23720 - A check box and a comments box were added to the
**                      Special Handling Section on the Intake Actions page to track
**                      Methamphetamine cases. As a result,two new columns were added
**                      to the Incoming_detail and caps_case tables. Those new fields 
**                      were populated here for Retrieval.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint25s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String BUSINESS_PHONE_TYPE = "BS";
    public static final char REQ_FUNC_NEW_USING = 'U';
    public static final int INITIAL_PAGE = 1;
    CINT25SO CINT25S(CINT25SI cint25si) {
        CINT25SO cint25so = new CINT25SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code  */
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): System Date
        **************************************************************************/
        /*
        ** Set CCFC43SO WCD DtSystemDate to current date
        */
        rc = ARC_PRFServiceStartTime_TUX(cint25si.ArchInputStruct);
        rc = CallCINT07D(cint25si, cint25so, pServiceStatus);
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        
        if (!(rc != 0) && 0 != cint25so.CallEntrySvcStruct.getUlIdEvent()) {
            rc = Ccmn01u.CallCCMN45D(cint25si, cint25so, pServiceStatus);
        }
        if (!(rc != 0)) {
            
            
            //  Call CCMN45D
            rc = Ccmn02u.CallCINT21D(cint25si, cint25so, pServiceStatus);
        }
        if (!(rc != 0)) {
            
            rc = CallCINT15D(cint25si, cint25so, pServiceStatus);
        }
        
        if (!(rc != 0) && REQ_FUNC_NEW_USING == cint25si.ArchInputStruct.getCReqFuncCd()) {
            
            rc = CallCINT47D(cint25si, cint25so, pServiceStatus);
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint25si.ArchInputStruct, cint25so.ArchOutputStruct);
        
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
                
                
                //  Call CSES65D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint25so;
    }

    static int CallCINT07D(CINT25SI pInputMsg469, CINT25SO pOutputMsg429, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* Declare local variables*/
        CINT07DI pCINT07DInputRec = null;
        CINT07DO pCINT07DOutputRec = null;
        int tempInd = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT07DInputRec = new CINT07DI();
        
        
        pCINT07DOutputRec = new CINT07DO();
        pCINT07DInputRec.setArchInputStruct(pInputMsg469.ArchInputStruct);
        pCINT07DInputRec.setUlIdStage(pInputMsg469.ulIdStage);
        rc = cint07dQUERYdam(sqlca, pCINT07DInputRec, pCINT07DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg429.CallEntrySvcStruct.setUlIdPerson(pCINT07DOutputRec.getUlIdPerson());
                pOutputMsg429.CallEntrySvcStruct.setUlIdStage(pCINT07DOutputRec.getUlIdStage());
                pOutputMsg429.CallEntrySvcStruct.setUlIdEvent(pCINT07DOutputRec.getUlIdEvent());
                pOutputMsg429.CallEntrySvcStruct.setUlIdResource(pCINT07DOutputRec.getUlIdResource());
                pOutputMsg429.CallDcsnAUD.setSzCdIncmgAllegType(pCINT07DOutputRec.getSzCdIncmgAllegType());
                pOutputMsg429.CallEntrySvcStruct.setCdIncomingProgramType(pCINT07DOutputRec.getCdIncomingProgramType());
                pOutputMsg429.CallEntrySvcStruct.setDtIncomingCallDisposed(pCINT07DOutputRec.getDtIncomingCallDisposed());
                pOutputMsg429.CallEntrySvcStruct.setTmSysTmCallDisp(pCINT07DOutputRec.getTmSysTmCallDisp());
                pOutputMsg429.CallEntrySvcStruct.setTsIncmgCallDisp(pCINT07DOutputRec.getTsIncmgCallDisp());
                pOutputMsg429.CallEntrySvcStruct.setSzNbrIncmgCallerExt(pCINT07DOutputRec.getSzNbrIncmgCallerExt());
                pOutputMsg429.CallEntrySvcStruct.setSzNmJurisdiction(pCINT07DOutputRec.getSzNmJurisdiction());
                pOutputMsg429.CallEntrySvcStruct.setDtDtIncomingCall(pCINT07DOutputRec.getDtDtIncomingCall());
                
                pOutputMsg429.CallEntrySvcStruct.setTmTmIncmgCall(pCINT07DOutputRec.getTmTmIncmgCall());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncomingCallType(pCINT07DOutputRec.getSzCdIncomingCallType());
                pOutputMsg429.CallEntrySvcStruct.setNmIncomingCallerFirst(pCINT07DOutputRec.getNmIncomingCallerFirst());
                pOutputMsg429.CallEntrySvcStruct.setNmIncomingCallerMiddle(pCINT07DOutputRec.getNmIncomingCallerMiddle());
                pOutputMsg429.CallEntrySvcStruct.setNmIncomingCallerLast(pCINT07DOutputRec.getNmIncomingCallerLast());
                pOutputMsg429.CallEntrySvcStruct.setCdIncomingCallerSuffix(pCINT07DOutputRec.getCdIncomingCallerSuffix());
                pOutputMsg429.CallEntrySvcStruct.setSzNbrIncomingCallerPhone(pCINT07DOutputRec.getSzNbrIncomingCallerPhone());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncmgPhoneType(pCINT07DOutputRec.getSzCdIncmgPhoneType());
                pOutputMsg429.CallEntrySvcStruct.setSzAddrIncmgStreetLn1(pCINT07DOutputRec.getSzAddrIncmgStreetLn1());
                pOutputMsg429.CallEntrySvcStruct.setSzAddrIncmgStreetLn2(pCINT07DOutputRec.getSzAddrIncmgStreetLn2());
                pOutputMsg429.CallEntrySvcStruct.setSzAddrIncomingCallerCity(pCINT07DOutputRec.getSzAddrIncomingCallerCity());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncomingCallerCounty(pCINT07DOutputRec.getSzCdIncomingCallerCounty());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncomingCallerState(pCINT07DOutputRec.getSzCdIncomingCallerState());
                pOutputMsg429.CallEntrySvcStruct.setSzAddrIncmgZip(pCINT07DOutputRec.getSzAddrIncmgZip());
                pOutputMsg429.CallEntrySvcStruct.setSzNmIncmgRegardingFirst(pCINT07DOutputRec.getSzNmIncmgRegardingFirst());
                pOutputMsg429.CallEntrySvcStruct.setSzNmIncmgRegardingLast(pCINT07DOutputRec.getSzNmIncmgRegardingLast());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncomingDisposition(pCINT07DOutputRec.getSzCdIncomingDisposition());
                
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncmgCallerInt(pCINT07DOutputRec.getSzCdIncmgCallerInt());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncmgSex(pCINT07DOutputRec.getSzCdIncmgSex());
                pOutputMsg429.CallEntrySvcStruct.setCdIncmgStatus(pCINT07DOutputRec.getCdIncmgStatus());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncmgAddrType(pCINT07DOutputRec.getSzCdIncmgAddrType());
                pOutputMsg429.CallDcsnAUD.setSzCdIncmgSpecHandling(pCINT07DOutputRec.getSzCdIncmgSpecHandling());
                pOutputMsg429.CallDcsnAUD.setTxtIncmgWorkerSafety(pCINT07DOutputRec.getTxtIncmgWorkerSafety());
                pOutputMsg429.CallDcsnAUD.setTxtIncomgSensitive(pCINT07DOutputRec.getTxtIncomgSensitive());
                pOutputMsg429.CallDcsnAUD.setBIndIncmgSensitive(pCINT07DOutputRec.getBIndIncmgSensitive());
                pOutputMsg429.CallDcsnAUD.setTxtIncomgSuspMeth(pCINT07DOutputRec.getTxtIncomgSuspMeth());
                
                pOutputMsg429.CallDcsnAUD.setBIndIncmgSuspMeth(pCINT07DOutputRec.getBIndIncmgSuspMeth());
                pOutputMsg429.CallDcsnAUD.setBIndIncmgWorkerSafety(pCINT07DOutputRec.getBIndIncmgWorkerSafety());
                pOutputMsg429.CallDcsnAUD.setBIndIncmgNoFactor(pCINT07DOutputRec.getBIndIncmgNoFactor());
                pOutputMsg429.CallEntrySvcStruct.setSzAddrIncWkrCity(pCINT07DOutputRec.getSzAddrIncWkrCity());
                pOutputMsg429.CallEntrySvcStruct.setLNbrIncWkrPhone(pCINT07DOutputRec.getLNbrIncWkrPhone());
                pOutputMsg429.CallEntrySvcStruct.setLNbrIncWkrExt(pCINT07DOutputRec.getLNbrIncWkrExt());
                pOutputMsg429.CallEntrySvcStruct.setSzNmIncWkrName(pCINT07DOutputRec.getSzNmIncWkrName());
                pOutputMsg429.CallEntrySvcStruct.setSzCdIncmgRegion(pCINT07DOutputRec.getSzCdIncmgRegion());
                pOutputMsg429.CallEntrySvcStruct.setSzNbrIncmgUnit(pCINT07DOutputRec.getSzNbrIncmgUnit());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT15D(CINT25SI pInputMsg470, CINT25SO pOutputMsg430, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i261 = 0;
        CINT15DI pCINT15DInputRec = null;
        CINT15DO pCINT15DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT15DInputRec = new CINT15DI();
        
        
        pCINT15DOutputRec = new CINT15DO();
        pCINT15DInputRec.setArchInputStruct(pInputMsg470.ArchInputStruct);
        pCINT15DInputRec.setUlIdStage(pInputMsg470.ulIdStage);
        pCINT15DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCINT15DInputRec.getArchInputStruct().setUlPageSizeNbr(CINT25SO._DETERMLISTAUD__CDINCMGDETERM_SIZE);
        rc = cint15dQUERYdam(sqlca, pCINT15DInputRec, pCINT15DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Copy the factors and descriptors to the service
                // output message.
                for (i261 = 0;i261 < pCINT15DOutputRec.getArchOutputStruct().getUlRowQty();i261++) {
                    pOutputMsg430.DetermListAUD.getCdIncmgDeterm_ARRAY().setCdIncmgDeterm(i261, pCINT15DOutputRec.getROWCINT15DO_ARRAY().getROWCINT15DO(i261).getCdIncmgDeterm());
                    pOutputMsg430.DetermListAUD.getSzCdIncmgDetermType_ARRAY().setSzCdIncmgDetermType(i261, pCINT15DOutputRec.getROWCINT15DO_ARRAY().getROWCINT15DO(i261).getSzCdIncmgDetermType());
                }
                pOutputMsg430.ArchOutputStruct.setUlRowQty(pCINT15DOutputRec.getArchOutputStruct().getUlRowQty());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                break;
            case NO_DATA_FOUND:
                
                //  Call Retrieve DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                break;
        }
        return rc;
    }

    
    static int CallCINT21D(CINT25SI pInputMsg471, CINT25SO pOutputMsg431, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* Declare local variables*/
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        
        pCINT21DOutputRec = new CINT21DO();
        
        /*************************************************************
        ** END CAUD08D
        **************************************************************/
        /* end SIR #15787 */
        
        
        
        /*****************************END ADD CODE *****************************/
        
        
        /************************************************************************
        ** (END): Contract creation process if the contract does not already
        **          exist. SIR 20360
        ************************************************************************/
        
        if (pCINT21DInputRec == null) {
            
            
            //  Start Performance Timer
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCINT21DInputRec.setArchInputStruct(pInputMsg471.ArchInputStruct);
        pCINT21DInputRec.setUlIdStage(pInputMsg471.ulIdStage);
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing to return Event and Level of Care information
        */
        
        /*
        ** Set CSUB16SO WCD DtSystemDate to current date
        */
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg431.CallDcsnAUD.setSzCdStageCurrPriority(pCINT21DOutputRec.getSzCdStageCurrPriority());
                pOutputMsg431.CallDcsnAUD.setSzCdStageInitialPriority(pCINT21DOutputRec.getSzCdStageInitialPriority());
                pOutputMsg431.CallDcsnAUD.setSzCdStageReasonClosed(pCINT21DOutputRec.getSzCdStageReasonClosed());
                pOutputMsg431.CallDcsnAUD.setSzCdStageRsnPriorityChgd(pCINT21DOutputRec.getSzCdStageRsnPriorityChgd());
                pOutputMsg431.CallDcsnAUD.setSzCdStageClassification(pCINT21DOutputRec.getSzCdStageClassification());
                pOutputMsg431.CallDcsnAUD.setSzNmStage(pCINT21DOutputRec.getSzNmStage());
                pOutputMsg431.CallDcsnAUD.setSzTxtStagePriorityCmnts(pCINT21DOutputRec.getSzTxtStagePriorityCmnts());
                pOutputMsg431.CallEntrySvcStruct.setUlIdCase(pCINT21DOutputRec.getUlIdCase());
                pOutputMsg431.CallEntrySvcStruct.setUlIdUnit(pCINT21DOutputRec.getUlIdUnit());
                pOutputMsg431.CallEntrySvcStruct.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT47D(CINT25SI pInputMsg472, CINT25SO pOutputMsg432, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return Code */
        /* Declare local variables*/
        CINT47DI pCINT47DInputRec = null;
        CINT47DO pCINT47DOutputRec = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT47DInputRec = new CINT47DI();
        
        
        pCINT47DOutputRec = new CINT47DO();
        pCINT47DInputRec.setArchInputStruct(pInputMsg472.ArchInputStruct);
        pCINT47DInputRec.setUlIdPerson(pInputMsg472.ulIdPerson);
        pCINT47DInputRec.setBIndPersonPhoneInvalid(FND_NO);
        pCINT47DInputRec.setBIndPersonPhonePrimary(FND_YES);
        pCINT47DInputRec.setSzCdPhoneType(BUSINESS_PHONE_TYPE);
        rc = cint47dQUERYdam(sqlca, pCINT47DInputRec, pCINT47DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                pOutputMsg432.CINTS025G01.setLNbrPhone(pCINT47DOutputRec.getLNbrPhone());
                
                pOutputMsg432.CINTS025G01.setLNbrPhoneExtension(pCINT47DOutputRec.getLNbrPhoneExtension());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        return rc;
    }

    static int CallCCMN45D(CINT25SI pInputMsg473, CINT25SO pOutputMsg433, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* Declare local variables*/
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** KRD - For various reasons (namely an unexplained GPF) instead of
        **       using a pCCMN45DOutputRec, we will use pOutputMsg since they
        **       have the same structure type
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(pInputMsg473.ArchInputStruct);
        pCCMN45DInputRec.setUlIdEvent(pOutputMsg433.CallEntrySvcStruct.getUlIdEvent());
        
        /*
        ** Call DAM
        */
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg433.szCdEventStatus = pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus();
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case Arcutls.ARC_UTL_GENERAL_FAILURE:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
