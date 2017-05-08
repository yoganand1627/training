package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN07SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN16DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH8DO;
/*************************************************************************
** 
** Module File:   ccmn07s.src
**
** Service Name:  ccmn07s
**
** Description: 
**
** This service is called from the On-Call List window.
** It's purpose is to add, modify, or delete an on-call shift or block.
** Also, when it deletes an on-call shift or block, it needs to check if
** there are employees assigned to that block and if there are, each 
** employee needs to be sent a To-Do (Alert) notifying the employee that
** the shift or block in question has been deleted and they are no longer
** assigned to it.  After the To-Do's have been sent, the employees are
** then deleted from the EMP ON CALL LINK table.
**
** This service calls five dams:
**
** CCMN16D Dam: 
**  input:  County and Program
** output:  full row of the ON CALL table:
**          every shift and block that exists
**          for the County and Program specified.
**
** CCMN20D Dam (on_call AUD):
**                
** Add------->input:   7 variables:  County, Program, Type,
**                     Start Date, Start Time, End Date, End Time
**           output:  return code of the Add (to the database).
**
** Update---->input:   9 variables:  County, Program, Type,
**                     Start Date, Start Time, End Date, End Time,
**                     IdOnCall, tsLastUpdate
**           output:  return code of the Update (to the database).
**
** Delete---->input:   2 variables:  IdOnCall, tsLastUpdate
**           output:  return code of the Delete (from the database).
**
** If the call to CCMN20D was for a Delete, 
** then the following logic must be processed:
**
** If the 'Filled' column for the IdOnCall to be deleted is 'Y', then:
** CCMN21D Dam: 
**           input:  IdOnCall           
**          output:  full row of the EMP ON CALL LINK table:
**                   every employee (and their details) that exists
**                   for the IdOnCall specified.
**                   (for the purpose of sending those IdPerson's 
**                    a to-do with the information that they have 
**                    been deleted from the on-call shift/block).
**
** CCMN43D Dam (to-do alert AUD: only using ADD section)
**                
** Add------->input:   x variables:  
**           output:  return code of the Add (to the database).
**
** CCMN22D Dam (emp_on_call_link AUD: only using LIST section,
**              which will actually perform a delete of all
**              IdEmpOnCallLink's with the IdOnCall passed to the dam).
** Delete---->input:   1 variable:  IdOnCall
**           output:  return code of the Delete (from the database).
**  
**                
** To ADD:
** It receives the 7 variables required to create an On-Call Shift or Block.
** Before the proposed shift/block may be added, the following check must 
** be made (these steps are done in the CallCCMN16D Function):
** 1. Call CCMN16D to retrieve all shifts/blocks for the county/program pair.
** 2. Check the proposed shift/block to be added against those retrieved 
**    in step 1, looking for overlaps.
**    As soon as an overlap is found, break out of the for loop and 
**    return a message to the user stating that the proposed shift/block
**    cannot be added as it would create an overlap with the existing schedule.
** 3. If an overlap is not found, then call ccmn20D to ADD the proposed
**    shift/block.
** 
** To MODIFY:
** It receives the 7 variables required to modify an On-Call Shift or Block,
** and the IdOnCall of the Shift or Block in question (to be modified).
** Before the proposed shift/block may be modified, the following check must 
** be made:
** 1. Call CCMN16D to retrieve all shifts/blocks for the county/program pair.
** 2. Check the proposed shift/block against those retrieved in step 1,
**    looking for overlaps.
**    NOTE that an extra compare of IdOnCall of the to be modified block with
**    IdOnCall of the existing blocks must be made, and if the IdOnCall's 
**    are the same, then break out and go to the next compare (consider that
**    the 'old' version of the modified block is already deleted).
**    As soon as an overlap is found, break out of the for loop and return
**    a message to the user stating that the proposed shift/block cannot 
**    be modified as it would create an overlap with the existing schedule.
** 3. If an overlap is not found, 
**    then call ccmn20D to MODIFY the proposed shift/block.
**
** To DELETE:
** 1. Call ccmn20D to DELETE the selected shift/block.
**
** 2. If the 'Filled' column for the IdOnCall to be deleted is 'Y'
**    and the End Date of the selected shift/block >= the Current Date, then:
**    Call ccmn21D to retrieve all of the IdPerson's associated with the
**    to-be-deleted shift/block.
**
** 3. Call ccmn43D to ADD a To-Do (Alert) for each IdPerson retrieved from 
**    the call to ccmn21D. The to-do will contain the information that 
**    they have been deleted from the on-call shift/block (also listing
**    the details of the shift/block).
**
** 4. Call ccmn22D to DELETE all employees assigned to the selected 
**    shift/block.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/30/95 
** 
** Programmer:    Mary F. Sladewski
**
** Archive Information: $Revision:   1.8  $
**                      $Date:   11 Mar 1999 11:33:50  $
**                      $Modtime:   11 Mar 1999 11:27:08  $
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
**  09Jun95   sladewmf  Added 'case MSG_CMN_ON_CALL_TOO_MANY:' to the switch
**                      following 'rc=CallCCMN16D' in the main function.
**                      Added 'case MSG_CMN_TMSTAMP_MISMATCH:' to the switch
**                      following 'rc=CallCCMN20D' in the main function.
**  23Jun95   sladewmf  Added population of old_schedule in three places
**                      within the CallCCMN16D function.
**  27Jul95   sladewmf  SIR 955: Changed 'On Call' to 'On-Call' in both 
**                      COPYSZ(pCCMN43DInputRec->szTxtTodoDesc,...) lines.
**  21Dec95   bruckmk   SIR 2227: Have to check if 
**                      new end date/time <= old start date/time or 
**                      new start date/time >= old end date/time.  
**                      If either of the above conditions are met, skip 
**                      the comparison logic that follows this comparison, 
**                      since these conditions verify that the new record
**                      cannot possibly overlap the record that it is 
**                      currently being checked against.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                      added the lines.
**
**  10/26/96   durang   Sir 22273 : Commented out some code to allow   
**                      proper On Call List deletion.  This will prevent
**                      data access errors.
**  10/26/98  Hadjimh   SIR #13420. This SIR was enhancement to On_Call and 
**			On_Call_Detail windows functionality. The CallCCMNH8D  
**			and the .h files were added. There has also been some 
**			code changes in various places.
**  03/10/98  Hadjimh   SIR #15150. Modify and ADD condition was not working 
**			properly.		
**		
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
***************************************************************************/

/********** service include files *****************************************/








/*
** Extern for version control table.
*/






public class Ccmn07s {
    
    /********** global variables **********************************************/
    String old_schedule = new String();
    
    /********** constants *****************************************************/
    public static final char FILLED = 'Y';
    public static final char NOT_FILLED = 'N';
    public static final String SHIFT = "SH";
    public static final String BLOCK = "BL";
    
    public static final int INITIAL_PAGE = 1;
    public static final int TO_DO_REQUIRED = 99;
    public static final String REGION_STATE_WIDE = "98";
    public static final String ALL = "ALL";
    public static final String ALLCOUNTIES = "255";
    public static final int TEMP_CODE_LEN = 5;
    static int transactionflag = - 1;
    CCMN07SO CCMN07S(CCMN07SI ccmn07si) {
        CCMN07SO ccmn07so = new CCMN07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CCMN07S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else /* pInputMsg->ArchInputStruct.bDataAcsInd == FALSE */
        if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCMN07S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CCMN07S \n");
            bTransactionStarted = true;
        }
        rc = ARC_PRFServiceStartTime_TUX(ccmn07si.getArchInputStruct());
        ccmn07si.getArchInputStruct().setBDataAcsInd(true);
        if (ccmn07si.getArchInputStruct().getCReqFuncCd() != WtcHelperConstants.REQ_FUNC_CD_DELETE) {
            
            
            //  Call CCMNC5D
            rc = Ccmn06s.CallCCMN16D(ccmn07si, ccmn07so, pServiceStatus);
            
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_CMN_ON_CALL_TOO_MANY:
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
        }
        
        
        
        
        if (ccmn07si.getArchInputStruct().getBDataAcsInd() == true) {
            rc = Ccmn10s.CallCCMN20D(ccmn07si, ccmn07so, pServiceStatus);
            
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            if (rc == WtcHelperConstants.ARC_SUCCESS) {
                rc = Ccmn10s.CallCCMNH8D(ccmn07si, ccmn07so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
            }
            if ((ccmn07si.getArchInputStruct().getCReqFuncCd() != WtcHelperConstants.REQ_FUNC_CD_ADD) && (ccmn07si.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getBIndOnCallFilled() == FILLED)) {
                
                // Set the CCMN01UI ReqFuncCd to REQ_FUNC_CD_ADD if a NULL value
                // ulIdEvent is passed in
                
                if (ccmn07si.getArchInputStruct().getUsPageNbr() == TO_DO_REQUIRED) {
                    
                    
                    //  Call CSES57D
                    rc = Ccmn09s.CallCCMN21D(ccmn07si, ccmn07so, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                }
                
                // Set DAM Input Time Stamp if 
                // the service input message IdEvent is not equal to NULL
                if (ccmn07si.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                    rc = Ccmn10s.CallCCMN22D(ccmn07si, ccmn07so, pServiceStatus);
                    switch (rc) {
                            
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                }
            }
        }
        else {
            
            //   If the CCMN01 ReqFuncCd is NEW, meaning that no IdEvent 
            // exists for the record being saved, populate the CCMN01 Input
            // Msg with the Primary Child's IdPerson for the Event-Person Link
            if (ccmn07si.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_OVERLAP_UPDATE;
                rc = Messages.MSG_CMN_OVERLAP_UPDATE;
            }
            if (ccmn07si.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_OVERLAP_ADD;
                
                
                //  Call CCMN00D
                rc = Messages.MSG_CMN_OVERLAP_ADD;
            }
        }
        
        /* load translation map with service name and version */
        
        /* stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(ccmn07si.getArchInputStruct() , ccmn07so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            
            
            // SIR# 3669 - Added this IF condition to the call to CINV43D, TODO
            // update DAM, because the dam would cause the save service to fail if
            // no event had been previously created. (ie if no TODO was created before
            // the first attempt at saving. The dam requires an ID EVENT.
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCMN07S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCMN07S \n");
        }
        return ccmn07so;
    }

    static int CallCCMN16D(CCMN07SI pInputMsg217, CCMN07SO * pOutputMsg198, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* local variables */
        CCMN16DI pCCMN16DInputRec = null;
        CCMN16DO pCCMN16DOutputRec = null;
        int rc = 0;
        int rc_time1 = 0;/* Return code for CompareDateAndTime */
        int rc_time2 = 0;/* Return code for CompareDateAndTime */
        int rc_time3 = 0;/* Return code for CompareDateAndTime */
        int rc_time4 = 0;/* Return code for CompareDateAndTime */
        int rc_time5 = 0;/* Return code for CompareDateAndTime */
        int rc_time6 = 0;/* Return code for CompareDateAndTime */
        int i122 = 0;
        boolean skip_first = false;
        boolean skip_last = false;
        boolean skip_matching = false;
        boolean skip_this_one = false;
        
        String temp1_start_time = new String();
        String temp1_end_time = new String();
        String temp2_start_time = new String();
        String temp2_end_time = new String();
        String start_date_string = new String();
        String end_date_string = new String();
        int usCountyRow = 0;/* Local counter for each row in listbox */
        /* SIR #13420 */
        for (usCountyRow = 0;usCountyRow < pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getCdCountyCounter();usCountyRow++) {
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            // 01/22/2003 DWW: Added for error handling
            if (rc == Messages.MSG_CMN_ON_CALL_TOO_MANY) {
                break;
            }
            rc_time1 = 0;
            rc_time2 = 0;
            // 3: new start date/time, old start date/time
            rc_time3 = 0;
            rc_time4 = 0;
            // 
            // BEGIN SIR 2227:
            // Have to check if new end date/time <= old start date/time or
            // new start date/time >= old end date/time.  
            // If either of the above conditions are met, skip the comparison
            // logic that follows.
            // 
            // 19: shift start date/time, block start date/time
            rc_time5 = 0;
            
            // 20: block start date/time, shift end date/time
            rc_time6 = 0;
            rc = 0;
            i122 = 0;
            skip_first = false;
            skip_last = false;
            skip_matching = false;
            skip_this_one = false;
            Ccmn10s.CLEAR(temp1_start_time);
            Ccmn10s.CLEAR(temp1_end_time);
            Ccmn10s.CLEAR(temp2_start_time);
            Ccmn10s.CLEAR(temp2_end_time);
            Ccmn10s.CLEAR(start_date_string);
            Ccmn10s.CLEAR(end_date_string);
            
            Ccmn10s.CLEAR(old_schedule);
            
            // allocate memory for Input and Output Structures
            pCCMN16DInputRec = new CCMN16DI();
            
            pCCMN16DOutputRec = new CCMN16DO();
            pCCMN16DInputRec.setArchInputStruct(pInputMsg217.getArchInputStruct());
            pCCMN16DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCCMN16DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN16DO._CCMN16DO__ROWCCMN16DO_SIZE);
            pCCMN16DInputRec.getROWCCMN16DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallCounty_ARRAY().getSzCdOnCallCounty(usCountyRow));
            pCCMN16DInputRec.getROWCCMN16DI().setSzCdOnCallProgram(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallProgram());
            pCCMN16DInputRec.getROWCCMN16DI().setCdCountyCounter(1);
            pCCMN16DInputRec.getROWCCMN16DI().setSzCdOnCallType(null);
            pCCMN16DInputRec.getROWCCMN16DI().getDtDtOnCallStart().day = DateHelper.NULL_DATE;
            pCCMN16DInputRec.getROWCCMN16DI().getDtDtOnCallStart().month = DateHelper.NULL_DATE;
            pCCMN16DInputRec.getROWCCMN16DI().getDtDtOnCallStart().year = DateHelper.NULL_DATE;
            pCCMN16DInputRec.getROWCCMN16DI().setTmOnCallStart(null);
            pCCMN16DInputRec.getROWCCMN16DI().getDtDtOnCallEnd().day = DateHelper.NULL_DATE;
            pCCMN16DInputRec.getROWCCMN16DI().getDtDtOnCallEnd().month = DateHelper.NULL_DATE;
            pCCMN16DInputRec.getROWCCMN16DI().getDtDtOnCallEnd().year = DateHelper.NULL_DATE;
            pCCMN16DInputRec.getROWCCMN16DI().setTmOnCallEnd(null);
            
            //  Call architecture function to retreive the current date.
            rc = ccmn16dQUERYdam(sqlca, pCCMN16DInputRec, pCCMN16DOutputRec);
            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                
                switch (rc) {
                    case NO_DATA_FOUND:
                        
                        //  Add 100 years to todays date
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
            else {
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                if ((pInputMsg217.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) || ((pInputMsg217.getArchInputStruct().getCReqFuncCd() == ServiceConstants.REQ_FUNC_CD_ADD) && (pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() != CCMN16DO._CCMN16DO__ROWCCMN16DO_SIZE))) {
                    if ((pInputMsg217.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) && (pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() == 1) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getUlIdOnCall() == pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getUlIdOnCall())) {
                        pInputMsg217.getArchInputStruct().setBDataAcsInd(true);
                        
                        if (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getSzCdOnCallType().equals(BLOCK)) {
                            old_schedule = " Block ";
                        }
                        else {
                            old_schedule = " Shift ";
                        }
                        old_schedule += "has been modified; the old schedule was: " + "  Start Date: ";
                        start_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart().year);
                        old_schedule += start_date_string + "  Start Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getTmOnCallStart() + "  End Date: ";
                        end_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallEnd().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallEnd().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallEnd().year);
                        old_schedule += end_date_string + "  End Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getTmOnCallEnd();
                    }
                    else // if (UPDATE and RowQty > 1) or ADD
                    {
                        if (pInputMsg217.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
                            
                            if (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getUlIdOnCall() == pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getUlIdOnCall()) {
                                skip_first = true;
                            }
                            if (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getUlIdOnCall() == pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getUlIdOnCall()) {
                                skip_last = true;
                            }
                        }
                        
                        if (!skip_first) {
                            rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getTmOnCallStart());
                        }
                        else // skip_first == TRUE
                        if (pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() > 1) {
                            rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(1).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(1).getTmOnCallStart());
                        }
                        if (!skip_last) {
                            rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getTmOnCallEnd());
                        }
                        else // skip_last == TRUE
                        if (pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() > 1) {
                            
                            // 2: new start date/time, old end date/time
                            rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 2).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 2).getTmOnCallEnd());
                        }
                        if ((rc_time1 > 0) && (rc_time2 < 0)) {
                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                        }
                        else // no_overlap is TRUE
                        {
                            if (skip_first) {
                                if (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getSzCdOnCallType().equals(BLOCK)) {
                                    old_schedule = " Block ";
                                }
                                else {
                                    old_schedule = " Shift ";
                                }
                                old_schedule += "has been modified; the old schedule was: " + "  Start Date: ";
                                start_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart().year);
                                old_schedule += start_date_string + "  Start Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getTmOnCallStart() + "  End Date: ";
                                end_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallEnd().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallEnd().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallEnd().year);
                                old_schedule += end_date_string + "  End Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getTmOnCallEnd();
                            }
                            //  Make sure the county to be added has not been contracted
                            // during the life of the window
                            if (skip_last) {
                                //  Set the explan_code to MSG_CMN_TMSTMP_MISMATCH if 
                                // CLSC11DO.G00's Id Contract is not null.  This means
                                // that the County has been contracted during the life
                                // of the window.  Terminate service and roll back changes.
                                if (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getSzCdOnCallType().equals(BLOCK)) {
                                    old_schedule = " Block ";
                                }
                                else {
                                    old_schedule = " Shift ";
                                }
                                old_schedule += "has been modified; the old schedule was: " + "  Start Date: ";
                                start_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallStart().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallStart().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallStart().year);
                                old_schedule += start_date_string + "  Start Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getTmOnCallStart() + "  End Date: ";
                                end_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallEnd().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallEnd().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallEnd().year);
                                old_schedule += end_date_string + "  End Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getTmOnCallEnd();
                            }
                        }
                    }
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    //  Following deviates from the general procedure as this service is called by another service and
                    //  it can also be called directly.
                    //  TUX_CHECK_APPL_STATUS
                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == false) {
                        pInputMsg217.getArchInputStruct().setBDataAcsInd(true);
                        
                        for (i122 = 0;((i122 < pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty()) && (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true));++i122) {
                            //Commit only if we began the transaction in this service
                            if ((!skip_matching) && (pInputMsg217.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_UPDATE)) {
                                if (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getUlIdOnCall() == pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getUlIdOnCall()) {
                                    skip_matching = true;
                                    //  If we get to this 'else' statement, 
                                    // it means that skip_this_one was TRUE and we just skipped
                                    // comparing the proposed shift/block with the current 
                                    // shift/block (and we are in MODIFY mode); need to set
                                    // skip_this_one back to FALSE so that we compare the 
                                    // proposed shift/block which each of the remaining 
                                    // shifts/blocks for the county/program pair.
                                    // 23Mar95: at this point, copy the 'old' data for the
                                    // to-be-modified shift/block 
                                    // (to be put into the 43D ToDo LongDesc Text).
                                    skip_this_one = true;
                                }
                            }
                            
                            if (!skip_this_one) {
                                
                                if ((pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallType().equals(BLOCK)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getSzCdOnCallType().equals(BLOCK))) {
                                    // 1: old start date/time, new start date/time
                                    rc_time1 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                    
                                    // 6: new end date/time, old end date/time
                                    rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                    if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                    
                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                        // 7: old start date/time, new start date/time
                                        rc_time3 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                        
                                        // 4: old start date/time, new end date/time
                                        rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                        
                                        if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                    }
                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                        // 5: new start date/time, old start date/time
                                        rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                        
                                        // 10: new end date/time, old end date/time
                                        rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                        
                                        if ((rc_time1 > 0) && (rc_time2 <= 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                    }
                                    
                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                        // 11: old start date/time, new start date/time
                                        rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                        
                                        // 8: old end date/time, new end date/time
                                        rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                        
                                        if ((rc_time3 > 0) && (rc_time4 <= 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                    }
                                    
                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                        // 9: new start date/time, old start date/time
                                        rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                        
                                        // 14: block start date/time, shift end date/time
                                        rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                        
                                        if ((rc_time1 <= 0) && (rc_time2 >= 0)) {
                                            
                                            
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                    }
                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                        // 15: shift start date/time, block end date/time
                                        rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                        
                                        // 12: old end date/time, new end date/time
                                        rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                        
                                        if ((rc_time3 <= 0) && (rc_time4 >= 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                    }
                                }
                                
                                // 
                                // Case 3:
                                // Second (of four) comparison combinations:
                                // 2. block-shift: the new item is a block and the old item is a shift.
                                // else if [ (new block) and (old shift) ]
                                // if {[shift_start date/time <= block_start date/time <  shift_end date/time]
                                // or [shift_start date/time <  block_end date/time   <= shift_end date/time] 
                                // or [(block_start date/time <= shift_start date/time) 
                                // AND (block_end date/time  >= shift_end date/time)]        }
                                // then OVERLAP EXISTS: Set no overlap = false
                                // 
                                else if ((pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallType().equals(BLOCK)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getSzCdOnCallType().equals(SHIFT))) {
                                    // 13: shift start date/time, block start date/time
                                    rc_time1 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                    
                                    // 18: block end date/time, shift end date/time
                                    rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                    
                                    if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                    
                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                        // 19: shift start date/time, block start date/time
                                        rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                        
                                        // 16: block end date/time, shift end date/time
                                        rc_time4 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                        
                                        if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                    }
                                    
                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                        // 17: block start date/time, shift start date/time
                                        rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                        
                                        // 22: block end date/time, shift end date/time
                                        rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                        if ((rc_time1 <= 0) && (rc_time2 >= 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                    }
                                }
                                
                                // 
                                // Case 3:
                                // Third (of four) comparison combinations:
                                // 3. shift-block: the new item is a shift and the old item is a block.
                                // else if [ (new shift) and (old block) ]
                                // if {[shift_start date/time <= block_start date/time <  shift_end date/time]
                                // or [shift_start date/time <  block_end date/time   <= shift_end date/time] 
                                // or [(block_start date/time <= shift_start date/time) 
                                // AND (block_end date/time  >= shift_end date/time)]        }
                                // then OVERLAP EXISTS: Set no overlap = false
                                // 
                                else if ((pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallType().equals(SHIFT)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getSzCdOnCallType().equals(BLOCK))) {
                                    // 
                                    // BEGIN SIR 2227:
                                    // Have to check if new end date/time <= old start date/time or
                                    // new start date/time >= old end date/time.  
                                    // If either of the above conditions are met, skip the comparison
                                    // logic that follows.
                                    // 
                                    // 19: shift start date/time, block start date/time
                                    rc_time5 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                    
                                    // 20: block start date/time, shift end date/time
                                    rc_time6 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                    if (rc_time5 >= 0 || rc_time6 <= 0) {
                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(true);
                                    }
                                    else {
                                        // 23: block start date/time, shift start date/time
                                        rc_time3 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                        
                                        // 20: block start date/time, shift end date/time
                                        rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                        if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                        if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                            // 21: shift start date/time, block end date/time
                                            rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                            
                                            // 26: new_start_date <= old_end_date
                                            rc_time2 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                            
                                            if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                                                pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                        }
                                        
                                        if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                            // 27: old start date <= new end date
                                            rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                            
                                            // 24: block end date/time, shift end date/time
                                            rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                            
                                            if ((rc_time3 <= 0) && (rc_time4 >= 0)) {
                                                pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                        }
                                    }
                                }
                                
                                
                                
                                // 
                                // Case 3:
                                // Fourth (of four) comparison combinations:
                                // 4. shift-shift: the new item is a shift and the old item is a shift.
                                // else if [ (new shift) and (old shift) ]
                                // if { [old_start_date <= new_start_date <= old_end_date]
                                // or [old_start_date <= new_end_date <= old_end_date]
                                // or [new_start_date <= old_start_date <= new_end_date]
                                // or [new_start_date <= old_end_date <= new_end_date] }
                                // {  if one of the above comparisons is true, 
                                // this means that the dates overlap, now check the times 
                                // if (old_end_time < old_start_time)
                                // {
                                // temp1_start_time = 0;        we need 2 blocks 
                                // temp1_end_time   = old_end_time;
                                // temp2_start_time = old_start_time;
                                // temp2_end_time   = 24;
                                // if { [temp1_start_time <= new_start_time < temp1_end_time]
                                // or [new_start_time  <= temp1_start_time < new_end_time]
                                // or [temp2_start_time <= new_start_time < temp2_end_time]
                                // or [new_start_time  <= temp2_start_time < new_end_time] }
                                // then OVERLAP EXISTS; 
                                // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                // }
                                // if [new_end_time < new_start_time]
                                // {
                                // temp1_start_time = 0       we need 2 blocks 
                                // temp1_end_time   = old_end_time
                                // temp2_start_time = old_start_time
                                // temp2_end_time   = 24
                                // if { [temp1_start_time <= old_start_time < temp1_end_time]
                                // or [old_start_time  <= temp1_start_time < old_end_time]
                                // or [temp2_start_time <= old_start_time < temp2_end_time]
                                // or [old_start_time  <= temp2_start_time < old_end_time] }
                                // then OVERLAP EXISTS; 
                                // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                // }
                                // 
                                else if ((pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallType().equals(SHIFT)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getSzCdOnCallType().equals(SHIFT))) {
                                    rc_time5 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                    rc_time6 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                    if (rc_time5 >= 0 || rc_time6 <= 0) {
                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(true);
                                    }
                                    else {
                                        
                                        
                                        // 25: old_start_date <= new_start_date
                                        rc_time1 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , 0);
                                        
                                        // 30: old start date <= new end date
                                        rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , 0);
                                        
                                        if ((rc_time1 <= 0) && (rc_time2 <= 0)) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                        //## END TUX/XML: Turn the XML buffer into an input message struct 
                                        
                                        
                                        
                                        if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                            // 31: new start date <= old end date
                                            rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , 0);
                                            
                                            // 28: new end date <= old end date
                                            rc_time4 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , 0);
                                            //## END TUX/XML: Turn the XML buffer into an input message struct 
                                            
                                            
                                            
                                            if ((rc_time3 <= 0) && (rc_time4 <= 0)) {
                                                pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                                                
                                            }
                                        }
                                        if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                            // 29: new start date <= old start date
                                            rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , 0);
                                            // 34: new_end_time < new_start_time
                                            rc_time2 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , 0);
                                            if ((rc_time1 <= 0) && (rc_time2 <= 0)) {
                                                pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                        }
                                        if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                            //   if { [temp1_start_time <= new_start_time < temp1_end_time]
                                            // or [temp2_start_time <  new_end_time <= temp2_end_time]
                                            // then OVERLAP EXISTS; 
                                            // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                            
                                            // if { [temp1_start_time <= new_start_time < temp1_end_time]
                                            // 35: temp1_start_time <= new_start_time
                                            rc_time3 = ARC_UTLCompareDateAndTime(pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , 0);
                                            
                                            // 32: old end date <= new end date
                                            rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd() , 0);
                                            if ((rc_time3 <= 0) && (rc_time4 <= 0)) {
                                                
                                                pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                        }
                                        if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == false) {
                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(true);
                                            // 33: old_end_time < old_start_time
                                            rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                            if (rc_time1 < 0) {
                                                
                                                // 38: new_end_time <= temp2_end_time
                                                rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                                if (rc_time2 < 0) {
                                                    pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                }
                                                if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                    temp1_start_time = "12:00 AM";
                                                    temp1_end_time = pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd();
                                                    temp2_start_time = pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart();
                                                    temp2_end_time = "11:59 PM";
                                                    // 39: new_end_time >= new_start_time
                                                    rc_time3 = ARC_UTLCompareDateAndTime(0, temp1_start_time, 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                                    
                                                    // 36: new_start_time < temp1_end_time
                                                    rc_time4 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , 0, temp1_end_time);
                                                    if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                    }
                                                }
                                                
                                                if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                    // or [temp2_start_time <  new_end_time <= temp2_end_time]
                                                    // 37: temp2_start_time < new_end_time
                                                    rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                                    
                                                    // 41: old start time < new end time
                                                    rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , 0, temp2_end_time);
                                                    
                                                    if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                    }
                                                }
                                            }
                                            else // old end time >= old start time
                                            {
                                                // 42: new start time < old end time
                                                rc_time3 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                                
                                                if (rc_time3 >= 0) {
                                                    // 
                                                    // If we get to this point, it means that 
                                                    // old end time >=  old start time 
                                                    // and     new end time >= new start time
                                                    // Need to compare the following:
                                                    // If (new start time <= old start time <  new end time)
                                                    // or (new start time <  old end time   <= new end time)
                                                    // or [ (new start time <= old start time <= new end time)
                                                    // && (new start time <= old end time   <= new end time) ]
                                                    // then OVERLAP EXISTS; 
                                                    // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                                    // else
                                                    // If (old start time <= new start time <  old end time)
                                                    // or (old start time <  new end time   <= old end time)
                                                    // or [ (old start time <= new start time <= old end time)
                                                    // && (old start time <= new end time   <= old end time) ]
                                                    // then OVERLAP EXISTS; 
                                                    // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                                    // 40: new start time <= old start time
                                                    rc_time1 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                                    
                                                    // 45: old start time <= new end time
                                                    rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                                    if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                    }
                                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                        
                                                        // 46: new start time <= old end time
                                                        rc_time3 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                                        
                                                        // 43: old end time <= new end time
                                                        rc_time4 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                                        
                                                        if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                        }
                                                    }
                                                    
                                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                        // 44: new start time <= old start time
                                                        rc_time1 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                                        
                                                        // 49: new start time < old end time
                                                        rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                                        // 50: old start time < new end time
                                                        rc_time3 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                                        
                                                        // 47: old end time <= new end time
                                                        rc_time4 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                                        
                                                        if ((rc_time1 <= 0) && (rc_time2 <= 0) && (rc_time3 <= 0) && (rc_time4 <= 0)) {
                                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                        }
                                                    }
                                                    
                                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                        // 48: old start time <= new start time
                                                        rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                                        
                                                        // 53: new start time <= old end time
                                                        rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                                        
                                                        if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                        }
                                                    }
                                                    
                                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                        
                                                        // 54: old start time <= new end time
                                                        rc_time3 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                                        
                                                        // 51: new end time <= old end time
                                                        rc_time4 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                                        
                                                        if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                        }
                                                    }
                                                    
                                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                        // 52: old start time <= new start time
                                                        rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
                                                        
                                                        // 57: old_start_time < temp1_end_time
                                                        rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                                        // 3: new start date/time, old start date/time
                                                        rc_time3 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
                                                        
                                                        // 55: new end time <= old end time
                                                        rc_time4 = ARC_UTLCompareDateAndTime(0, pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                                        if ((rc_time1 <= 0) && (rc_time2 <= 0) && (rc_time3 <= 0) && (rc_time4 <= 0)) {
                                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                        }
                                                    }
                                                }
                                                else {
                                                    temp1_start_time = "12:00 AM";
                                                    temp1_end_time = pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd();
                                                    temp2_start_time = pInputMsg217.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart();
                                                    temp2_end_time = "11:59 PM";
                                                    //   if { [temp1_start_time <= old_start_time < temp1_end_time]
                                                    // or [temp2_start_time <  old_end_time <= temp2_end_time]
                                                    // then OVERLAP EXISTS; 
                                                    // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                                    // if { [temp1_start_time <= old_start_time < temp1_end_time]
                                                    // 56: temp1_start_time <= old_start_time
                                                    rc_time1 = ARC_UTLCompareDateAndTime(0, temp1_start_time, 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart());
                                                    
                                                    // 59: old_end_time <= temp2_end_time
                                                    rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() , 0, temp1_end_time);
                                                    
                                                    if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                                        pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                    }
                                                    
                                                    if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == true) {
                                                        // or [temp2_start_time < old_end_time <= temp2_end_time]
                                                        // 58: temp2_start_time < old_end_time
                                                        rc_time1 = ARC_UTLCompareDateAndTime(0, temp2_start_time, 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd());
                                                        
                                                        
                                                        // 
                                                        // Case 2:
                                                        // Completely contained after the last start date/time already scheduled.
                                                        // If (new S/B's start date/time) < (Last end date/time)
                                                        // Set no_overlap = false
                                                        // no_overlap will only be set to false if both Case 1 and Case 2's
                                                        // comparisons indicate that no_overlap should be set to false:
                                                        // If (new S/B's end date/time) > (First start date/time)
                                                        // AND If (new S/B's start date/time) < (Last end date/time)
                                                        // Set no_overlap = false
                                                        // new S/B's start date: pInputMsg->ROWCCMN20DI.dtDtOnCallStart
                                                        // new S/B's start time: pInputMsg->ROWCCMN20DI.tmOnCallStart
                                                        // Last end date: pCCMN16DOutputRec->ROWCCMN16DO[pCCMN16DOutputRec->
                                                        // ArchOutputStruct.ulRowQty - 1].dtDtOnCallEnd
                                                        // Last end time: pCCMN16DOutputRec->ROWCCMN16DO[pCCMN16DOutputRec->
                                                        // ArchOutputStruct.ulRowQty - 1].tmOnCallEnd
                                                        // 
                                                        rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd() , 0, temp2_end_time);
                                                        // SIR 23663 Added 11 new elements staring from  szCdClosureType
                                                        
                                                        
                                                        if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                                                            pInputMsg217.getArchInputStruct().setBDataAcsInd(false);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else {
                                skip_this_one = false;
                                
                                if (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getSzCdOnCallType().equals(BLOCK)) {
                                    old_schedule = " Block ";
                                }
                                else {
                                    old_schedule = " Shift ";
                                }
                                old_schedule += "has been modified; the old schedule was: " + "  Start Date: ";
                                start_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallStart().year);
                                old_schedule += start_date_string + "  Start Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallStart() + "  End Date: ";
                                end_date_string = (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd().month) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd().day) + "/" + (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getDtDtOnCallEnd().year);
                                old_schedule += end_date_string + "  End Time: " + pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i122).getTmOnCallEnd();
                            }
                        }
                    }
                }
                else // ...ulRowQty == _CCMN16DO__ROWCCMN16DO_SIZE
                {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_ON_CALL_TOO_MANY;
                    rc = Messages.MSG_CMN_ON_CALL_TOO_MANY;
                }
            }
            if (pInputMsg217.getArchInputStruct().getBDataAcsInd() == false) {
                break;
            }
        }
        return rc;
    }

    static int CallCCMN20D(CCMN07SI pInputMsg218, CCMN07SO pOutputMsg199, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = SUCCESS;
        int i123 = 0;
        /* local variables */
        CCMN20DI pCCMN20DInputRec = null;
        CCMN20DO pCCMN20DOutputRec = null;
        String szTempCode = new String();
        String szTempDeCode = new String();
        Arrays.fill(szTempCode, 0, TEMP_CODE_LEN, 0);
        szTempCode = REGION_STATE_WIDE;
        Arrays.fill(szTempDeCode, 0, TEMP_CODE_LEN, 0);
        szTempDeCode = ALLCOUNTIES;
        
        /* allocate memory for Input and Output Structures */
        pCCMN20DInputRec = new CCMN20DI();
        
        pCCMN20DOutputRec = new CCMN20DO();
        pCCMN20DInputRec.setArchInputStruct(pInputMsg218.getArchInputStruct());
        
        if (pInputMsg218.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
            pCCMN20DInputRec.getROWCCMN20DI().setBIndOnCallFilled(NOT_FILLED);
        }
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdOnCallMultOrAll(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallMultOrAll());
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdRegion(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdRegion());
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdOnCallProgram(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallProgram());
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdOnCallType(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallType());
        pCCMN20DInputRec.getROWCCMN20DI().setDtDtOnCallStart(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart());
        pCCMN20DInputRec.getROWCCMN20DI().setTmOnCallStart(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart());
        pCCMN20DInputRec.getROWCCMN20DI().setDtDtOnCallEnd(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd());
        pCCMN20DInputRec.getROWCCMN20DI().setTmOnCallEnd(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd());
        
        for (i123 = 0;i123 < pCCMN20DInputRec.getArchInputStruct().getUlPageSizeNbr();++i123) {
            
            if (pInputMsg218.getArchInputStruct().getCReqFuncCd() != WtcHelperConstants.REQ_FUNC_CD_ADD) {
                pCCMN20DInputRec.getROWCCMN20DI().setUlIdOnCall(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(i123).getUlIdOnCall());
                pCCMN20DInputRec.getROWCCMN20DI().setTsLastUpdate(pInputMsg218.getROWCCMN20DI_ARRAY().getROWCCMN20DI(i123).getTsLastUpdate());
            }
            
            //  Call DAM
            rc = ccmn20dAUDdam(sqlca, pCCMN20DInputRec, pCCMN20DOutputRec);
            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                
                
                
                //  Analyze return code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
            else {
                rc = WtcHelperConstants.ARC_SUCCESS;
                if (pInputMsg218.getArchInputStruct().getCReqFuncCd() != WtcHelperConstants.REQ_FUNC_CD_DELETE) 
                {
                    pOutputMsg199.getROWCCMN20DO().setTsLastUpdate(pCCMN20DOutputRec.getROWCCMN20DO().getTsLastUpdate());
                }
                //## END TUX/XML: Turn the XML buffer into an input message struct 
                
                
                
                if (pInputMsg218.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
                    pOutputMsg199.getROWCCMN20DO().setUlIdOnCall(pCCMN20DOutputRec.getROWCCMN20DO().getUlIdOnCall());
                }
            }
        }
        return rc;
    }

    static int CallCCMN21D(CCMN07SI pInputMsg219, CCMN07SO * pOutputMsg200, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i124 = 0;
        /* local variables */
        String start_date_string = new String();
        String end_date_string = new String();
        int ord = 0;
        int[] ord_array = new int[2];
        String ord_phone = new String();
        
        CCMN21DI pCCMN21DInputRec = null;
        CCMN21DO pCCMN21DOutputRec = null;
        
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN21DInputRec = new CCMN21DI();
        
        pCCMN21DOutputRec = new CCMN21DO();
        
        pCCMN43DInputRec = new CCMN43DI();
        
        pCCMN43DOutputRec = new CCMN43DO();
        pCCMN21DInputRec.setArchInputStruct(pInputMsg219.getArchInputStruct());
        pCCMN21DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN21DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN21DO._CCMN21DO__ROWCCMN21DO_SIZE);
        pCCMN21DInputRec.getROWCCMN21DI().setUlIdOnCall(pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getUlIdOnCall());
        rc = ccmn21dQUERYdam(sqlca, pCCMN21DInputRec, pCCMN21DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            //  Analyze return code
            switch (rc) {
                    
                    //  SQL Not Found Case for Dam CSES68D (ASR)
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        else {
            
            //  Call DAM
            rc = WtcHelperConstants.ARC_SUCCESS;
            
            for (i124 = 0;i124 < pCCMN21DOutputRec.getArchOutputStruct().getUlRowQty();++i124) {
                pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
                pCCMN43DInputRec.setSzCdTodoType("A");
                pCCMN43DInputRec.setUlIdTodoPersCreator(0);
                ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCreated() , 0);
                ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCompleted() , 0);
                ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoDue() , 0);
                pCCMN43DInputRec.getDtDtTaskDue().month = DateHelper.NULL_DATE;
                pCCMN43DInputRec.getDtDtTaskDue().day = DateHelper.NULL_DATE;
                pCCMN43DInputRec.getDtDtTaskDue().year = DateHelper.NULL_DATE;
                pCCMN43DInputRec.setUlIdTodoPersAssigned(pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i124).getUlIdPerson());
                
                if (pInputMsg219.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                    pCCMN43DInputRec.setSzTxtTodoDesc("On-Call Deletion.");
                }
                else // cReqFuncCd == REQ_FUNC_CD_UPDATE
                {
                    pCCMN43DInputRec.setSzTxtTodoDesc("On-Call Modification.");
                }
                pCCMN43DInputRec.setTxtTodoLongDesc("The following On-Call");
                
                if (pInputMsg219.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                    if (pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallType().equals(BLOCK)) {
                        pCCMN43DInputRec.getTxtTodoLongDesc() += " Block ";
                    }
                    else {
                        pCCMN43DInputRec.getTxtTodoLongDesc() += " Shift ";
                    }
                    pCCMN43DInputRec.getTxtTodoLongDesc() += "has been deleted; you are no longer scheduled for this duty.";
                }
                else // cReqFuncCd == REQ_FUNC_CD_UPDATE
                {
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pCCMN43DInputRec.getTxtTodoLongDesc() += old_schedule + "  The new schedule is:";
                }
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   Region: " + pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdRegion() + "   County: " + pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallMultOrAll() + "   Program: " + pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallProgram() + "   Start Date: ";
                start_date_string = (pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart().month) + "/" + (pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart().day) + "/" + (pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallStart().year);
                pCCMN43DInputRec.getTxtTodoLongDesc() += start_date_string;
                pCCMN43DInputRec.getSzTxtTodoDesc() += start_date_string + "  ";
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   Start Time: " + pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart();
                pCCMN43DInputRec.getSzTxtTodoDesc() += pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallStart() + " THRU ";
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   End Date: ";
                end_date_string = (pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd().month) + "/" + (pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd().day) + "/" + (pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getDtDtOnCallEnd().year);
                pCCMN43DInputRec.getTxtTodoLongDesc() += end_date_string;
                pCCMN43DInputRec.getSzTxtTodoDesc() += end_date_string + "  ";
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   End Time: " + pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd();
                pCCMN43DInputRec.getSzTxtTodoDesc() += pInputMsg219.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getTmOnCallEnd();
                
                if (pInputMsg219.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                    //  ord is initialized to be 48
                    // (which is the ascii representation of '0')
                    // usNbrEmpOnCallCntctOrd can only be in the range 1..9
                    // by adding the usNbrEmpOnCallCntctOrd to ord, 
                    // we should get the ascii representation of 1..9; 
                    // that is 49..57, inclusive.
                    ord = 48;
                    ord += pCCMN21DOutputRec.getROWCCMN21DO_ARRAY().getROWCCMN21DO(i124).getUsNbrEmpOnCallCntctOrd();
                    ord_array = new int[];
                    ord_array[0] = ord;
                }
                rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                
                if (rc != WtcHelperConstants.SQL_SUCCESS) {
                    
                    //  Analyze error code
                    switch (rc) {
                            
                            //  Success Case for Dam CSES68D (AOC)
                        case NO_DATA_FOUND:
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    }
                }
            }
        }
        
        return rc;
    }

    static int CallCCMN22D(CCMN07SI pInputMsg220, CCMN07SO * pOutputMsg201, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        int i125 = 0;
        /* local variables */
        CCMN22DI pCCMN22DInputRec = null;
        CCMN22DO pCCMN22DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN22DInputRec = new CCMN22DI();
        
        pCCMN22DOutputRec = new CCMN22DO();
        pCCMN22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_LIST);
        
        //## BEGIN TUX/XML: Declare XML variables
        pCCMN22DInputRec.getROWCCMN22DI().setUlIdOnCall(pInputMsg220.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getUlIdOnCall());
        rc = ccmn22dAUDdam(sqlca, pCCMN22DInputRec, pCCMN22DOutputRec);
        
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        else {
            rc = WtcHelperConstants.ARC_SUCCESS;
        }
        return rc;
    }

    static int CallCCMNH8D(CCMN07SI pInputMsg221, CCMN07SO pOutputMsg202, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        int i126 = 0;
        /* local variables */
        CCMNH8DI pCCMNH8DInputRec = null;
        CCMNH8DO pCCMNH8DOutputRec = null;
        int usCountyRow = 0;
        String szTempCode = new String();
        String szTempDeCode = new String();
        Arrays.fill(szTempCode, 0, TEMP_CODE_LEN, 0);
        szTempCode = REGION_STATE_WIDE;
        Arrays.fill(szTempDeCode, 0, TEMP_CODE_LEN, 0);
        szTempDeCode = ALLCOUNTIES;
        
        /* allocate memory for Input and Output Structures */
        pCCMNH8DInputRec = new CCMNH8DI();
        
        pCCMNH8DOutputRec = new CCMNH8DO();
        pCCMNH8DInputRec.setArchInputStruct(pInputMsg221.getArchInputStruct());
        if (pInputMsg221.getArchInputStruct().getCReqFuncCd() != WtcHelperConstants.REQ_FUNC_CD_DELETE) {
            pCCMNH8DInputRec.getROWCCMNH8DI().setSzCdRegion(pInputMsg221.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdRegion());
            pCCMNH8DInputRec.getROWCCMNH8DI().setCdCountyCounter(pInputMsg221.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getCdCountyCounter());
            
            if (pInputMsg221.getArchInputStruct().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
                pCCMNH8DInputRec.getROWCCMNH8DI().setUlIdOnCall(pOutputMsg202.getROWCCMN20DO().getUlIdOnCall());
            }
            else {
                pCCMNH8DInputRec.getROWCCMNH8DI().setUlIdOnCall(pInputMsg221.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getUlIdOnCall());
            }
            if (pCCMNH8DInputRec.getROWCCMNH8DI().getSzCdRegion().equals(szTempCode)) {
                
                pCCMNH8DInputRec.getROWCCMNH8DI().setCdCountyCounter(1);
                pCCMNH8DInputRec.getROWCCMNH8DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(0, ALLCOUNTIES);
            }
            else {
                for (usCountyRow = 0;usCountyRow < pInputMsg221.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getCdCountyCounter();usCountyRow++) {
                    pCCMNH8DInputRec.getROWCCMNH8DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(usCountyRow, pInputMsg221.getROWCCMN20DI_ARRAY().getROWCCMN20DI(0).getSzCdOnCallCounty_ARRAY().getSzCdOnCallCounty(usCountyRow));
                }
            }
            rc = ccmnh8dAUDdam(sqlca, pCCMNH8DInputRec, pCCMNH8DOutputRec);
            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        else /* func is delete */
        {
            // pInputMsg->ArchInputStruct.cReqFuncCd = REQ_FUNC_CD_DELETE
            for (i126 = 0;i126 < pInputMsg221.getArchInputStruct().getUlPageSizeNbr();++i126) {
                pCCMNH8DInputRec.getROWCCMNH8DI().setUlIdOnCall(pInputMsg221.getROWCCMN20DI_ARRAY().getROWCCMN20DI(i126).getUlIdOnCall());
                
                
                //  Call CRES04D
                rc = ccmnh8dAUDdam(sqlca, pCCMNH8DInputRec, pCCMNH8DOutputRec);
                
                //  Analyze error code
                if (rc != WtcHelperConstants.SQL_SUCCESS) {
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
        }
        return rc;
    }

}
