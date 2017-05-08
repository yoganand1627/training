package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN16DO;
/**************************************************************************
** 
** Module File:   ccmn06s.src
**
** Service Name:  ccmn06s
**
** Description:   This service calls one dam:
**
** CCMN16D Dam: 
**                input:  dynamic: two variables required:
**                        County and Program
**                        up to 5 other variables:
**                        Start Date, Start Time, End Date, End Time, Type
**               output:  Data for On Call List window's ListBox:
**                        (full row of the ON CALL table)
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/30/95 
** 
** Programmer:    Mary F. Sladewski
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   29 Dec 1998 09:34:38  $
**                      $Modtime:   23 Dec 1998 09:00:12  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10Apr95   sladewmf  Initial check-in.
**  01May95   sladewmf  Made changes recommended by bennetta
**                      (code/technical review).
**  05May95   sladewmf  Made changes to match new error handling outlined
**                      in the May05 08:23 1995 version of svcshell.src
**  06Jun95   sladewmf  Added 'case MSG_NO_ROWS_RETURNED:' to the switch
**                      following 'rc=CallCCMN16D' in the main function. 
**  06Jan96   bruckmk   SIR 1993: Get System Date and Time for return to 
**                      Client, since the Date should not be retrieved on 
**                      the client side.
**  7/26/96    zabihin  SIR 21891 , version control code was missing, I 
**                      added the lines.
**  09/09/96    KRD     SIR 22250 - PROCESS_TUX_SQL_ERROR should only be called
**                      when there is an unexpected SQL return code from a
**                      DAM.  The error handling for CallCCMN16D() has been
**                      corrected.
**  10/26/98  Hadjimh   SIR #13420 This SIR was enhancement to On_Call and 
**			On_Call_Detail windows functionality. There has been
**			changes to the code due to adding a table called
**			On_Call_County which is a many side of the On_Call
**			table.
***************************************************************************/

/********** service include files *****************************************/



/*
** Extern for version control table.
*/






public class Ccmn06s {
    
    public static final String REGION_STATE_WIDE = "98";
    public static final String ALLCOUNTIES = "255";
    public static final int TEMP_CODE_LEN = 5;
    CCMN06SO CCMN06S(CCMN06SI ccmn06si) {
        CCMN06SO ccmn06so = new CCMN06SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(ccmn06si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccmn06so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        /********************************************************
        ** SIR 2551: The Outcome Matrix Event, Three-Month Review
        ** and Monthly Status Contact Events should not be passed
        ** back to the window if they are either NEW or IN_PROGRESS,
        ** since they would then be passed on to the ToDo window,
        ** which would update their status to Pending. Only COMPLETE
        ** and APPROVED events should be passed to the ToDo Window
        ** to be updated to PENDING.
        *********************************************************/
        /* SIR 23530 - ignore any Client Assessment events - they no longer apply */
        if (ccmn06si.getArchInputStruct().getCReqFuncCd() != WtcHelperConstants.REQ_FUNC_CD_ADD) {
            
            //  Call DAM
            rc = Ccmn07s.CallCCMN16D(ccmn06si, ccmn06so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                case Messages.MSG_NO_ROWS_RETURNED:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
        }
        
        /* load translation map with service name and version */
        
        /* stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(ccmn06si.getArchInputStruct() , ccmn06so.getArchOutputStruct());
        /*
        ** SIR 13939 - mhmr rapid closure.  Skip the edit warning
        ** for incomplete events if the status is Rapid Closure.
        */
        /*
        **SIR 23681 - added logic to the if statement to check for the client died and care in proc case
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            
            
            //  SIR 1751 - The ID EVENTs that are placed into the
            // output message are either returned to the calling
            // window and submitted for approval or are set to
            // approved in CallCCMN62D().  However, CONtact events
            // with a status of "NEW" should not be set to approved,
            // they continue with the case and are moved to the next
            // stage of service by Stage Progression.  So we must
            // ensure that those ID EVENTS are not placed into the
            // output message with an if-statement that essentially
            // says:
            // if (not contact) or (contact and not new)
            // SIR 2551: The Outcome Matrix Event, Three-Month Review
            // and Monthly Status Contact Events should not be
            // passed back to the window if they are either NEW or
            // IN_PROGRESS, since they would then be passed
            // on to the ToDo window, which would update their status
            // to Pending. Only COMPLETE and APPROVED Outcome Matrices
            // and Contacts should be passed to the ToDo Window to be
            // updated to PENDING.
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
        return ccmn06so;
    }

    static int CallCCMN16D(CCMN06SI pInputMsg215, CCMN06SO pOutputMsg196, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i120 = 0;
        /* local variables */
        CCMN16DI pCCMN16DInputRec = null;
        CCMN16DO pCCMN16DOutputRec = null;
        int usCountyRow = 0;/* Local counter for each row in listbox */
        int usCntyRow = 0;/* Local counter  */
        
        
        /* allocate memory for Input and Output Structures */
        pCCMN16DInputRec = new CCMN16DI();
        
        pCCMN16DOutputRec = new CCMN16DO();
        
        
        pCCMN16DInputRec.setArchInputStruct(pInputMsg215.getArchInputStruct());
        pCCMN16DInputRec.getROWCCMN16DI().setSzCdRegion(pInputMsg215.getROWCCMN16DI().getSzCdRegion());
        if (0 == pCCMN16DInputRec.getROWCCMN16DI().getSzCdRegion().compareTo(REGION_STATE_WIDE)) {
            pCCMN16DInputRec.getROWCCMN16DI().setCdCountyCounter(1);
            pCCMN16DInputRec.getROWCCMN16DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(0, ALLCOUNTIES);
        }
        else {
            for (usCountyRow = 0;usCountyRow < pInputMsg215.getROWCCMN16DI().getCdCountyCounter();usCountyRow++) {
                pCCMN16DInputRec.getROWCCMN16DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(usCountyRow, pInputMsg215.getROWCCMN16DI().getSzCdOnCallCounty_ARRAY().getSzCdOnCallCounty(usCountyRow));
            }
            pCCMN16DInputRec.getROWCCMN16DI().setCdCountyCounter(pInputMsg215.getROWCCMN16DI().getCdCountyCounter());
        }
        pCCMN16DInputRec.getROWCCMN16DI().setSzCdOnCallProgram(pInputMsg215.getROWCCMN16DI().getSzCdOnCallProgram());
        pCCMN16DInputRec.getROWCCMN16DI().setSzCdOnCallType(pInputMsg215.getROWCCMN16DI().getSzCdOnCallType());
        pCCMN16DInputRec.getROWCCMN16DI().setDtDtOnCallStart(pInputMsg215.getROWCCMN16DI().getDtDtOnCallStart());
        pCCMN16DInputRec.getROWCCMN16DI().setTmOnCallStart(pInputMsg215.getROWCCMN16DI().getTmOnCallStart());
        pCCMN16DInputRec.getROWCCMN16DI().setDtDtOnCallEnd(pInputMsg215.getROWCCMN16DI().getDtDtOnCallEnd());
        pCCMN16DInputRec.getROWCCMN16DI().setTmOnCallEnd(pInputMsg215.getROWCCMN16DI().getTmOnCallEnd());
        rc = ccmn16dQUERYdam(sqlca, pCCMN16DInputRec, pCCMN16DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i120 = 0;i120 < pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty();++i120) {
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setSzCdRegion(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getSzCdRegion());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setSzCdOnCallProgram(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getSzCdOnCallProgram());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setSzCdOnCallType(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getSzCdOnCallType());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setDtDtOnCallStart(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getDtDtOnCallStart());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setTmOnCallStart(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getTmOnCallStart());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setDtDtOnCallEnd(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getDtDtOnCallEnd());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setTmOnCallEnd(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getTmOnCallEnd());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setUlIdOnCall(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getUlIdOnCall());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setBIndOnCallFilled(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getBIndOnCallFilled());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setTsLastUpdate(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getTsLastUpdate());
                    pOutputMsg196.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).setUlCountOfCounty(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i120).getUlCountOfCounty());
                }
                pOutputMsg196.getArchOutputStruct().setUlRowQty(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg196.getArchOutputStruct().setBMoreDataInd(pCCMN16DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                
                //  Call CAUD01D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
