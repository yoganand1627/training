package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN10SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN16DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN43DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN43DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH8DO;
/**************************************************************************
**
** Module File:   ccmn10s.src
**
** Service Name:  ccmn10s
**
** Description:
** This service is called from the MDL SAVE CLICK callback of ccmn21w.win.
**
** If the checks on the window side (ccmn21w.win) pass,
** then this service (ccmn10s.src) is called.
**
** If the Mode in which ccmn21w.win was called is NEW_USING,
** (that is, szSysCdWinMode == WINDOW_MODE_NEW_USING)
** that means that the New PB was pressed on the On-Call List window (20w),
** and all four dams: ccmn16d (query), ccmn20d (add), ccmn43d (add),
** and ccmn22d (add) will need to be called from this service.
**
** If the Mode in which ccmn21w.win was called is MODIFY,
** (that is, szSysCdWinMode == WINDOW_MODE_MODIFY)
** that means that the Detail PB was pressed on the On-Call List window (20w),
** and only two dams will need to be called from this service:
** ccmn43d (add) and ccmn22d (AUD).
**
** The ccmn43d dam (add) will be used for each add, update, or delete
** of an employee (ccmn22d).
** The ccmn43d dam (add) will send a To-Do (Alert) notifying each
** employee that they have been added/changed/deleted from the shift
** or block in question.
**
** This service will determine which Dams that it needs to call based
** on the following:
**
** if (szSysCdWinMode == WINDOW_MODE_NEW_USING)
** {
**      the CCMN16D Dam is called
**      then over-lap checking is done
**      if there is no over-lap then
**          the ADD section of the CCMN20D Dam is called
**              then the ADD section of the CCMN43D Dam is called.
**                 then the ADD section of the CCMN22D Dam is called.
** }
** else ** szSysCdWinMode == WINDOW_MODE_MODIFY **
** if (szCdScrDataAction == REQ_FUNC_CD_ADD)
**     first the ADD section of the CCMN43D Dam is called, then
**     the CCMN22D Dam is called to ADD the employee to the shift/block;
** else
** if (szCdScrDataAction == REQ_FUNC_CD_UPDATE)
**     first the ADD section of the CCMN43D Dam is called, then
**     the CCMN22D Dam is called to UPDATE the employee to the shift/block;
** else
** if (szCdScrDataAction == REQ_FUNC_CD_DELETE)
**     first the ADD section of the CCMN43D Dam is called, then
**     the CCMN22D Dam is called to DELETE the employee to the shift/block;
**
**
** This service calls four dams:
**
** CCMN16D Dam:
**  input:  County and Program
** output:  full row of the ON CALL table:
**          every shift and block that exists
**          for the County and Program specified.
**
** CCMN20D Dam (on_call AUD: only using ADD section)
**
** Add------->input:   7 variables:  County, Program, Type,
**                     Start Date, Start Time, End Date, End Time
**           output:  return code of the Add (to the database).
**
** CCMN43D Dam (to-do alert AUD: only using ADD section)
**
** Add------->input:   x variables:
**           output:  return code of the Add (to the database).
**
** CCMN22D Dam (emp_on_call_link AUD):
**
** Add------->input:   8 variables:  IdPerson, Contact Order,
**                     OnCallDesig(nation), Phone1, Ext1, Phone2, Ext2,
**                     IdOnCall
**           output:  return code of the Add (to the database).
**
** Update---->input:  10 variables:  IdPerson, Contact Order,
**                    OnCallDesig(nation), Phone1, Ext1, Phone2, Ext2,
**                    IdOnCall, IdEmpOnCallLink, tsLastUpdate
**           output:  return code of the Update (to the database).
**
** Delete---->input:   2 variables:  IdEmpOnCallLink, tsLastUpdate
**           output:  return code of the Delete (from the database).
**
**
** To ADD an on-call shift or block:
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
** To ADD a to-do (alert):
** 1. Call ccmn43D to ADD a To-Do (Alert) for each IdPerson sent from
**    the ccmn21w window. The to-do will contain the information that
**    they have been added/updated/deleted from the on-call shift/block
**    (also listing the details of the shift/block).
**
** 2. Call ccmn22D to add/update/delete all employees assigned to
**    the selected shift/block.
**
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/30/95
**
** Programmer:    Mary F. Sladewski
**
** Archive Information: $Revision:   1.4  $
**                      $Date:   29 Dec 1998 09:34:42  $
**                      $Modtime:   23 Dec 1998 08:53:48  $
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
**  27Jul95   sladewmf  SIR 955: Changed 'On Call' to 'On-Call' in all four
**                      COPYSZ(pCCMN43DInputRec->szTxtTodoDesc,...) lines.
**  14Oct96   durang    Sir 10902 -On call shift overlap error;Modified
**                      several ARC_UTLCompareDateAndTime calls to
**                      include timestamp variables.  This was done to
**                      prevent unwanted shift overlap error messages.
**  10/26/98  Hadjimh   SIR #13420 This SIR was enhancement to On_Call and
**                      On_Call_Detail windows functionality.  The CallCCMNH8D
**                      and the .h files were added. There has also been some
**                      code changes in various places.
**
**  08/05/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
**  11/17/03  RIOSJA    SIR 22375 - Added call to PROCESS_TUX_RC_ERROR_TRANSACT
**                      if MSG_CMN_ON_CALL_TOO_MANY occurs during Overlap
**                      Check DAM call. Handle the error immediately and return
**                      from the service.
***************************************************************************/

/********** service include files *****************************************/

/*
** Extern for version control table.
*/






public class Ccmn10s {
    public static Object CLEAR(char x) {
        return }

    public static final int INITIAL_PAGE1 = 1;
    public static final String BLOCK = "BL";
    public static final String SHIFT = "SH";
    public static final char FILLED = 'Y';
    public static final String REGION_STATE_WIDE = "98";
    public static final String ALL = "ALL";
    public static final String ALLCOUNTIES = "255";
    public static final int TEMP_CODE_LEN = 5;
    static int transactionflag2 = - 1;
    CCMN10SO CCMN10S(CCMN10SI ccmn10si) {
        CCMN10SO ccmn10so = new CCMN10SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        transactionflag2 = - 1;
        boolean bTransactionStarted = false;
        transactionflag2 = tpgetlev();
        if (transactionflag2 == - 1) {
            userlog("ERROR: tpgetlev failed in CCMN10S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            //  If no rows were found, return FND_SUCCESS
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else /* pInputMsg->ArchInputStruct.bDataAcsInd == FALSE */
        if (transactionflag2 == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CCMN10S\n");
        }
        else /* pInputMsg->szSysCdWinMode == WINDOW_MODE_MODIFY */
        if (transactionflag2 == 0) {
            userlog("TRANSACTION IS STARTED in CCMN10S \n");
            bTransactionStarted = true;
        }
        rc = ARC_PRFServiceStartTime_TUX(ccmn10si.getArchInputStruct());
        // This is the case where transaction has not been started.
        
        if (ccmn10si.getSzSysCdWinMode() == WINDOW_MODE_NEW_USING) {
            ccmn10si.getArchInputStruct().setBDataAcsInd(true);
            rc = Ccmn06s.CallCCMN16D(ccmn10si, ccmn10so, pServiceStatus);
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_CMN_ON_CALL_TOO_MANY:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            
            //  Retrieve CPS INV DETAIL information if the input ID EVENT isn't NULL
            if (ccmn10si.getArchInputStruct().getBDataAcsInd() == true) {
                
                //  Call CMSC16D
                rc = Ccmn07s.CallCCMN20D(ccmn10si, ccmn10so, pServiceStatus);
                switch (rc) {
                        
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                }
                
                // ERR #1625: There is no point in calling the remaining DAMs if no data
                // was found.
                if (rc == WtcHelperConstants.ARC_SUCCESS) {
                    
                    rc = Ccmn07s.CallCCMNH8D(ccmn10si, ccmn10so, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
                    }
                }
            }
            else {
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_OVERLAP_ADD;
                rc = Messages.MSG_CMN_OVERLAP_ADD;
            }
        }
        else {
            rc = Ccmn07s.CallCCMN22D(ccmn10si, ccmn10so, pServiceStatus);
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
        }
        
        /* load translation map with service name and version */
        
        /* stop performance timer for service */
        ARC_PRFServiceStopTime_TUX(ccmn10si.getArchInputStruct() , ccmn10so.getArchOutputStruct());
        /*
        ** Retrieve event status if input ID EVENT != NULL
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag2);
        }
        else if (bTransactionStarted) {
            
            
            //  SIR 2766 - If DAM CSYS15D returns MSG_INV_NOT_BEGUN, none of the
            // other DAMs in the service should be called.
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CCMN10S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CCMN10S \n");
        }
        return ccmn10so;
    }

    static int CallCCMN16D(CCMN10SI pInputMsg224, CCMN10SO * pOutputMsg205, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        /* local variables */
        CCMN16DI pCCMN16DInputRec = null;
        CCMN16DO pCCMN16DOutputRec = null;
        int rc = 0;/* Return code */
        int rc_time1 = 0;/* Return code for CompareDateAndTime */
        int rc_time2 = 0;/* Return code for CompareDateAndTime */
        int rc_time3 = 0;/* Return code for CompareDateAndTime */
        int rc_time4 = 0;/* Return code for CompareDateAndTime */
        int i128 = 0;
        
        String temp1_start_time = new String();
        String temp1_end_time = new String();
        String temp2_start_time = new String();
        String temp2_end_time = new String();
        int CountyCounter = 0;/* SIR #13420 */
        int usCountyRow = 0;/* Local counter for each row in listbox */
        
        /* SIR #13420 */
        for (usCountyRow = 0;usCountyRow < pInputMsg224.getROWCCMN20DI().getCdCountyCounter();usCountyRow++) {
            if (rc == Messages.MSG_CMN_ON_CALL_TOO_MANY) {
                break;
            }
            rc_time1 = 0;
            
            // 2: new start date/time, old end date/time
            rc_time2 = 0;
            // 7: old start date/time, new start date/time
            rc_time3 = 0;
            rc_time4 = 0;
            rc = 0;
            i128 = 0;
            CLEAR(temp1_start_time);
            CLEAR(temp1_end_time);
            CLEAR(temp2_start_time);
            CLEAR(temp2_end_time);
            
            // allocate memory for Input and Output Structures
            pCCMN16DInputRec = new CCMN16DI();
            
            pCCMN16DOutputRec = new CCMN16DO();
            pCCMN16DInputRec.setArchInputStruct(pInputMsg224.getArchInputStruct());
            pCCMN16DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE1);
            pCCMN16DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN16DO._CCMN16DO__ROWCCMN16DO_SIZE);
            pCCMN16DInputRec.getROWCCMN16DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(0, pInputMsg224.getROWCCMN20DI().getSzCdOnCallCounty_ARRAY().getSzCdOnCallCounty(usCountyRow));
            pCCMN16DInputRec.getROWCCMN16DI().setSzCdOnCallProgram(pInputMsg224.getROWCCMN20DI().getSzCdOnCallProgram());
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
            
            // retrieve date and time from the server
            rc = ccmn16dQUERYdam(sqlca, pCCMN16DInputRec, pCCMN16DOutputRec);
            if (rc != WtcHelperConstants.SQL_SUCCESS) {
                
                switch (rc) {
                    case NO_DATA_FOUND:
                        
                        //  When creating a new contract, dtCnverEnd should
                        // be curr date plus 100 years
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                }
            }
            else {
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                if (pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() != CCMN16DO._CCMN16DO__ROWCCMN16DO_SIZE) {
                    // 
                    // We now have all of the shifts/blocks for the county/program pair
                    // (in the pCCMN16DOutputRec->ROWCCMN16DO array) of the proposed
                    // shift/block to be added.
                    // First, if the ulRowQty != _CCMN16DO__ROWCCMN16DO_SIZE:
                    // we need to check for over-laps.
                    // else
                    // (that is, if ulRowQty == _CCMN16DO__ROWCCMN16DO_SIZE)
                    // the maximum number of shifts/blocks for the county/program pair
                    // already exist; return the MSG_ON_CALL_TOO_MANY message to the user.
                    // To check for overlaps:
                    // We need to check if there exists an OnCall shift/block which contains
                    // any part of the proposed OnCall shift/block's time; and if so, do NOT
                    // add the proposed OnCall shift/block as it would create an
                    // Overlap condition.
                    // The new shift/block (S/B) to be added is either/or:
                    // Case 1:
                    // Completely contained prior to first start date/time already scheduled.
                    // If (new S/B's end date/time) > (First start date/time)
                    // Set no_overlap = false
                    // Case 2:
                    // Completely contained after the last start date/time already scheduled.
                    // If (new S/B's start date/time) < (Last end date/time)
                    // Set no_overlap = false
                    // no_overlap will only be set to false if both Case 1 and Case 2's
                    // comparisons indicate that no_overlap should be set to false:
                    // If (new S/B's end date/time) > (First start date/time)
                    // AND If (new S/B's start date/time) < (Last end date/time)
                    // Set no_overlap = false
                    // Case 3:
                    // It's start and/or end date/time overlaps with the existing schedule.
                    // So we need to compare the new S/B with each current shift or block
                    // that is already scheduled.
                    // There are four combinations of comparisons:
                    // 1. block-block: the new item is a block and the old item is a block.
                    // 2. block-shift: the new item is a block and the old item is a shift.
                    // 3. shift-block: the new item is a shift and the old item is a block.
                    // 4. shift-shift: the new item is a shift and the old item is a shift.
                    // 
                    
                    // 
                    // Case 1:
                    // Completely contained prior to first start date/time already scheduled.
                    // If (new S/B's end date/time) > (First start date/time)
                    // Set no_overlap = false
                    // no_overlap will only be set to false if both Case 1 and Case 2's
                    // comparisons indicate that no_overlap should be set to false:
                    // If (new S/B's end date/time) > (First start date/time)
                    // AND If (new S/B's start date/time) < (Last end date/time)
                    // Set no_overlap = false
                    // new S/B's end date: pInputMsg->ROWCCMN20DI[0].dtDtOnCallEnd
                    // new S/B's end time: pInputMsg->ROWCCMN20DI[0].tmOnCallEnd
                    // First start date:   pCCMN16DOutputRec->ROWCCMN16DO[0].dtDtOnCallStart
                    // First start time:   pCCMN16DOutputRec->ROWCCMN16DO[0].tmOnCallStart
                    // 
                    rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(0).getTmOnCallStart());
                    
                    // 6: new end date/time, old end date/time
                    rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty() - 1).getTmOnCallEnd());
                    if ((rc_time1 > 0) && (rc_time2 < 0)) {
                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                    }
                    if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == false) {
                        pInputMsg224.getArchInputStruct().setBDataAcsInd(true);
                        
                        for (i128 = 0;((i128 < pCCMN16DOutputRec.getArchOutputStruct().getUlRowQty()) && (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true));++i128) {
                            if ((pInputMsg224.getROWCCMN20DI().getSzCdOnCallType().equals(BLOCK)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getSzCdOnCallType().equals(BLOCK))) {
                                // 1: old start date/time, new start date/time
                                rc_time1 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                
                                // 10: new end date/time, old end date/time
                                rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 11: old start date/time, new start date/time
                                    rc_time3 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                    
                                    // 4: old start date/time, new end date/time
                                    rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 5: new start date/time, old start date/time
                                    rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                    
                                    // 14: block start date/time, shift end date/time
                                    rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                    if ((rc_time1 > 0) && (rc_time2 <= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 15: shift start date/time, block end date/time
                                    rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                    
                                    // 8: old end date/time, new end date/time
                                    rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    if ((rc_time3 > 0) && (rc_time4 <= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 9: new start date/time, old start date/time
                                    rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                    
                                    // 18: block end date/time, shift end date/time
                                    rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                    if ((rc_time1 <= 0) && (rc_time2 >= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 19: shift start date/time, block start date/time
                                    rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                    
                                    // 12: old end date/time, new end date/time
                                    rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    if ((rc_time3 <= 0) && (rc_time4 >= 0)) {
                                        
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
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
                            else if ((pInputMsg224.getROWCCMN20DI().getSzCdOnCallType().equals(BLOCK)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getSzCdOnCallType().equals(SHIFT))) {
                                // 13: shift start date/time, block start date/time
                                rc_time1 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                
                                // 22: block end date/time, shift end date/time
                                rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                    
                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 23: block start date/time, shift start date/time
                                    rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    
                                    // 16: block end date/time, shift end date/time
                                    rc_time4 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                    if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 17: block start date/time, shift start date/time
                                    rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                    
                                    // Sir 10902 -replaced the NULL timestamp
                                    // 26: new_start_date <= old_end_date
                                    rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                    if ((rc_time1 <= 0) && (rc_time2 >= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
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
                            else if ((pInputMsg224.getROWCCMN20DI().getSzCdOnCallType().equals(SHIFT)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getSzCdOnCallType().equals(BLOCK))) {
                                // Sir 10902 -replaced the NULL timestamp
                                // 27: old start date <= new end date
                                rc_time3 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                
                                // 20: block start date/time, shift end date/time
                                rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 21: shift start date/time, block end date/time
                                    rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                    
                                    // Sir 10902 -replaced the NULL timestamp
                                    // 30: old start date <= new end date
                                    // Sir 10902 -replaced the NULL timestamp
                                    rc_time2 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // Sir 10902 -replaced the NULL timestamp
                                    // 31: new start date <= old end date
                                    rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                    
                                    // 24: block end date/time, shift end date/time
                                    rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    if ((rc_time3 <= 0) && (rc_time4 >= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
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
                            else if ((pInputMsg224.getROWCCMN20DI().getSzCdOnCallType().equals(SHIFT)) && (pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getSzCdOnCallType().equals(SHIFT))) {
                                // 25: old_start_date <= new_start_date
                                rc_time1 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                // 34: new_end_time < new_start_time
                                rc_time2 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                
                                //  SIR 21809 - added if statement so that the records retention
                                // clock will not be set after the admin review closing date
                                
                                if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                }
                                
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    //   if { [temp1_start_time <= new_start_time < temp1_end_time]
                                    // or [temp2_start_time <  new_end_time <= temp2_end_time]
                                    // then OVERLAP EXISTS;
                                    // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                    
                                    // if { [temp1_start_time <= new_start_time < temp1_end_time]
                                    // 35: temp1_start_time <= new_start_time
                                    rc_time3 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    
                                    // Sir 10902 -replaced the NULL timestamp
                                    // 28: new end date <= old end date
                                    rc_time4 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                    //  Perform edits for an Investigation Stage
                                    if ((rc_time3 <= 0) && (rc_time4 <= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                
                                //  Perform edits for Code CIU
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 29: new start date <= old start date
                                    // Sir 10902 -replaced the NULL timestamp
                                    rc_time1 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                    
                                    // 38: new_end_time <= temp2_end_time
                                    rc_time2 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    //  Check the Overall Disposition in the
                                    // CPS INVST DETAIL table
                                    if ((rc_time1 <= 0) && (rc_time2 <= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                
                                //  Check Risk Factors
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                    // 39: new_end_time >= new_start_time
                                    rc_time3 = ARC_UTLCompareDateAndTime(pInputMsg224.getROWCCMN20DI().getDtDtOnCallStart() , pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                    
                                    // Sir 10902 -replaced the NULL timestamp
                                    // 32: old end date <= new end date
                                    rc_time4 = ARC_UTLCompareDateAndTime(pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getDtDtOnCallEnd() , pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , pInputMsg224.getROWCCMN20DI().getDtDtOnCallEnd() , pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                    
                                    //  All edits for Code Type CIU are passed so set
                                    // variables accordingly and calculate stage
                                    // retention date
                                    if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                                        pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                    }
                                }
                                
                                //  Set Calculated Retention date to maximum date
                                if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == false) {
                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(true);
                                    
                                    // 33: old_end_time < old_start_time
                                    rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                    
                                    if (rc_time1 < 0) {
                                        
                                        // 41: old start time < new end time
                                        rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                        
                                        //  All edits for Code Type CIU are passed so set
                                        // variables accordingly and calculate stage
                                        // retention date
                                        if (rc_time2 < 0) {
                                            pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                        }
                                        
                                        //  Set Calculated Retention date to maximum date
                                        if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                            temp1_start_time = "12:00 AM";
                                            temp1_end_time = pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd();
                                            temp2_start_time = pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart();
                                            temp2_end_time = "11:59 PM";
                                            // 42: new start time < old end time
                                            rc_time3 = ARC_UTLCompareDateAndTime(0, temp1_start_time, 0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                            
                                            // 36: new_start_time < temp1_end_time
                                            rc_time4 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , 0, temp1_end_time);
                                            
                                            if ((rc_time3 <= 0) && (rc_time4 < 0)) {
                                                pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                        }
                                        
                                        //  All edits for Code Type CIU are passed so set
                                        // variables accordingly and calculate stage
                                        // retention date
                                        if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                            // or [temp2_start_time <  new_end_time <= temp2_end_time]
                                            // 37: temp2_start_time < new_end_time
                                            rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                            
                                            // 45: old start time <= new end time
                                            rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , 0, temp2_end_time);
                                            
                                            //  Set Calculated Retention date to maximum date
                                            if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                                                pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                        }
                                    }
                                    else // old end time >= old start time
                                    {
                                        
                                        // 46: new start time <= old end time
                                        rc_time3 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                        
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
                                            rc_time1 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                            
                                            // 49: new start time < old end time
                                            rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                            
                                            
                                            
                                            
                                            //  Perform edits for Code CIR
                                            if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                                pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                            
                                            //  Check the Overall Disposition in the
                                            // CPS INVST DETAIL table
                                            if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                                // 50: old start time < new end time
                                                rc_time3 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                                
                                                // 43: old end time <= new end time
                                                rc_time4 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                                
                                                //  Check Risk Factors
                                                if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                                }
                                            }
                                            
                                            //  All edits for Code Type CIR are passed so set
                                            // variables accordingly and calculate stage
                                            // retention date
                                            if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                                // 44: new start time <= old start time
                                                rc_time1 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                                
                                                // 53: new start time <= old end time
                                                rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                                
                                                // 54: old start time <= new end time
                                                rc_time3 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                                
                                                // 47: old end time <= new end time
                                                rc_time4 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                                
                                                //  Set Calculated Retention date to maximum date
                                                if ((rc_time1 <= 0) && (rc_time2 <= 0) && (rc_time3 <= 0) && (rc_time4 <= 0)) {
                                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                                }
                                            }
                                            
                                            if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                                // 48: old start time <= new start time
                                                rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                                
                                                // 57: old_start_time < temp1_end_time
                                                rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                                
                                                
                                                
                                                
                                                //  Perform edits for CIO - Investigation
                                                // period closed with other reasons
                                                if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                                }
                                            }
                                            //  Check the Overall Disposition in the
                                            // CPS INVST DETAIL table
                                            if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                                rc_time3 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                                
                                                // 51: new end time <= old end time
                                                rc_time4 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                                
                                                //  Check Risk Factors
                                                if ((rc_time3 < 0) && (rc_time4 <= 0)) {
                                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                                }
                                            }
                                            
                                            if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                                // 52: old start time <= new start time
                                                rc_time1 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart());
                                                
                                                // 59: old_end_time <= temp2_end_time
                                                rc_time2 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallStart() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                                rc_time3 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd());
                                                
                                                // 55: new end time <= old end time
                                                rc_time4 = ARC_UTLCompareDateAndTime(0, pInputMsg224.getROWCCMN20DI().getTmOnCallEnd() , 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                                
                                                if ((rc_time1 <= 0) && (rc_time2 <= 0) && (rc_time3 <= 0) && (rc_time4 <= 0)) {
                                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                                }
                                            }
                                        }
                                        else {
                                            temp1_start_time = "12:00 AM";
                                            temp1_end_time = pInputMsg224.getROWCCMN20DI().getTmOnCallEnd();
                                            temp2_start_time = pInputMsg224.getROWCCMN20DI().getTmOnCallStart();
                                            temp2_end_time = "11:59 PM";
                                            //   if { [temp1_start_time <= old_start_time < temp1_end_time]
                                            // or [temp2_start_time <  old_end_time <= temp2_end_time]
                                            // then OVERLAP EXISTS;
                                            // set pInputMsg->ArchInputStruct.bDataAcsInd = FALSE;
                                            // if { [temp1_start_time <= old_start_time < temp1_end_time]
                                            // 56: temp1_start_time <= old_start_time
                                            rc_time1 = ARC_UTLCompareDateAndTime(0, temp1_start_time, 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart());
                                            rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallStart() , 0, temp1_end_time);
                                            
                                            
                                            
                                            //  Perform edits for ACP - Investigation
                                            // Stage for a community
                                            if ((rc_time1 <= 0) && (rc_time2 < 0)) {
                                                pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                            }
                                            //  Check to see if Admin Review exits for
                                            // this stage
                                            if (pInputMsg224.getArchInputStruct().getBDataAcsInd() == true) {
                                                // or [temp2_start_time < old_end_time <= temp2_end_time]
                                                // 58: temp2_start_time < old_end_time
                                                rc_time1 = ARC_UTLCompareDateAndTime(0, temp2_start_time, 0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd());
                                                rc_time2 = ARC_UTLCompareDateAndTime(0, pCCMN16DOutputRec.getROWCCMN16DO_ARRAY().getROWCCMN16DO(i128).getTmOnCallEnd() , 0, temp2_end_time);
                                                
                                                //  All edits for Code Type ACP are
                                                // passed so set variables and
                                                // calculate stage retention date
                                                if ((rc_time1 < 0) && (rc_time2 <= 0)) {
                                                    pInputMsg224.getArchInputStruct().setBDataAcsInd(false);
                                                }
                                            }
                                        }
                                    }
                                }
                                
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
        }
        return rc;
    }

    static int CallCCMN20D(CCMN10SI pInputMsg225, CCMN10SO pOutputMsg206, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;
        int i129 = 0;
        /* local variables */
        String start_date_string = new String();
        String end_date_string = new String();
        int ord = 0;
        String ord_array = new String();
        String ord_phone = new String();
        
        CCMN20DI pCCMN20DInputRec = null;
        CCMN20DO pCCMN20DOutputRec = null;
        
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        
        CCMN22DI pCCMN22DInputRec = null;
        CCMN22DO pCCMN22DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN20DInputRec = new CCMN20DI();
        
        pCCMN20DOutputRec = new CCMN20DO();
        
        pCCMN43DInputRec = new CCMN43DI();
        
        pCCMN43DOutputRec = new CCMN43DO();
        
        pCCMN22DInputRec = new CCMN22DI();
        
        pCCMN22DOutputRec = new CCMN22DO();
        pCCMN20DInputRec.setArchInputStruct(pInputMsg225.getArchInputStruct());
        pCCMN20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdOnCallMultOrAll(pInputMsg225.getROWCCMN20DI().getSzCdOnCallMultOrAll());
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdRegion(pInputMsg225.getROWCCMN20DI().getSzCdRegion());
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdOnCallProgram(pInputMsg225.getROWCCMN20DI().getSzCdOnCallProgram());
        pCCMN20DInputRec.getROWCCMN20DI().setSzCdOnCallType(pInputMsg225.getROWCCMN20DI().getSzCdOnCallType());
        pCCMN20DInputRec.getROWCCMN20DI().setDtDtOnCallStart(pInputMsg225.getROWCCMN20DI().getDtDtOnCallStart());
        pCCMN20DInputRec.getROWCCMN20DI().setTmOnCallStart(pInputMsg225.getROWCCMN20DI().getTmOnCallStart());
        pCCMN20DInputRec.getROWCCMN20DI().setDtDtOnCallEnd(pInputMsg225.getROWCCMN20DI().getDtDtOnCallEnd());
        pCCMN20DInputRec.getROWCCMN20DI().setTmOnCallEnd(pInputMsg225.getROWCCMN20DI().getTmOnCallEnd());
        pCCMN20DInputRec.getROWCCMN20DI().setBIndOnCallFilled(pInputMsg225.getROWCCMN20DI().getBIndOnCallFilled());
        rc = ccmn20dAUDdam(sqlca, pCCMN20DInputRec, pCCMN20DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            
            //  Analyze return code
            switch (rc) {
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        else /* rc == 0 */
        {
            
            
            //  Start Performance Timer
            rc = WtcHelperConstants.ARC_SUCCESS;
            pCCMN22DInputRec.getROWCCMN22DI().setUlIdOnCall(pCCMN20DOutputRec.getROWCCMN20DO().getUlIdOnCall());
            
            pOutputMsg206.getROWCCMN20DO().setUlIdOnCall(pCCMN20DOutputRec.getROWCCMN20DO().getUlIdOnCall());
            pOutputMsg206.getROWCCMN20DO().setTsLastUpdate(pCCMN20DOutputRec.getROWCCMN20DO().getTsLastUpdate());
            
            pCCMN22DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg225.getArchInputStruct().getUlPageSizeNbr());
            pCCMN22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            pCCMN43DInputRec.setSzCdTodoType("A");
            pCCMN43DInputRec.setUlIdTodoPersCreator(0);
            ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCreated() , 0);
            ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCompleted() , 0);
            ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoDue() , 0);
            pCCMN43DInputRec.getDtDtTaskDue().month = DateHelper.NULL_DATE;
            pCCMN43DInputRec.getDtDtTaskDue().day = DateHelper.NULL_DATE;
            
            pCCMN43DInputRec.getDtDtTaskDue().year = DateHelper.NULL_DATE;
            // COPYSZ(pCCMN43DInputRec->szTxtTodoDesc,"On-Call Addition.");
            
            for (i129 = 0;i129 < pCCMN22DInputRec.getArchInputStruct().getUlPageSizeNbr();++i129) {
                
                pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getUlIdPerson());
                
                pCCMN43DInputRec.setSzTxtTodoDesc("On-Call Addition.");
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pCCMN43DInputRec.setTxtTodoLongDesc("You have been added to the following On-Call");
                if (pInputMsg225.getROWCCMN20DI().getSzCdOnCallType().equals(BLOCK)) {
                    pCCMN43DInputRec.getTxtTodoLongDesc() += " Block:";
                }
                else {
                    pCCMN43DInputRec.getTxtTodoLongDesc() += " Shift:";
                }
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   Region: " + pInputMsg225.getROWCCMN20DI().getSzCdRegion() + "   County: " + pInputMsg225.getROWCCMN20DI().getSzCdOnCallMultOrAll() + "   Program: " + pInputMsg225.getROWCCMN20DI().getSzCdOnCallProgram() + "   Start Date: ";
                start_date_string = pInputMsg225.getROWCCMN20DI().getDtDtOnCallStart().month + "/" + pInputMsg225.getROWCCMN20DI().getDtDtOnCallStart().day + "/" + pInputMsg225.getROWCCMN20DI().getDtDtOnCallStart().year;
                pCCMN43DInputRec.getTxtTodoLongDesc() += start_date_string;
                pCCMN43DInputRec.getSzTxtTodoDesc() += start_date_string + "  ";
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   Start Time: " + pInputMsg225.getROWCCMN20DI().getTmOnCallStart();
                pCCMN43DInputRec.getSzTxtTodoDesc() += pInputMsg225.getROWCCMN20DI().getTmOnCallStart() + " THRU ";
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   End Date: ";
                end_date_string = pInputMsg225.getROWCCMN20DI().getDtDtOnCallEnd().month + "/" + pInputMsg225.getROWCCMN20DI().getDtDtOnCallEnd().day + "/" + pInputMsg225.getROWCCMN20DI().getDtDtOnCallEnd().year;
                pCCMN43DInputRec.getTxtTodoLongDesc() += end_date_string;
                
                //## BEGIN TUX/XML: Declare XML variables 
                pCCMN43DInputRec.getSzTxtTodoDesc() += end_date_string + "  ";
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   End Time: " + pInputMsg225.getROWCCMN20DI().getTmOnCallEnd();
                pCCMN43DInputRec.getSzTxtTodoDesc() += pInputMsg225.getROWCCMN20DI().getTmOnCallEnd();
                
                
                //  ord is initialized to be 48
                // (which is the ascii representation of '0')
                // usNbrEmpOnCallCntctOrd can only be in the range 1..9
                // by adding the usNbrEmpOnCallCntctOrd to ord,
                // we should get the ascii representation of 1..9;
                // that is 49..57, inclusive.
                ord = 48;
                ord += pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getUsNbrEmpOnCallCntctOrd();
                ord_array = CStringUtils.setCharAt(ord_array, 0, ord);
                pCCMN43DInputRec.getTxtTodoLongDesc() += "   Contact Order: " + ord_array + "   On-Call Designation: " + pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzCdEmpOnCallDesig() + "   On-Call Phone: (";
                ord_phone = CStringUtils.setCharAt(ord_phone, 0, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[0]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 1, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[1]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 2, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[2]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 3, ')');
                ord_phone = CStringUtils.setCharAt(ord_phone, 4, ' ');
                ord_phone = CStringUtils.setCharAt(ord_phone, 5, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[3]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 6, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[4]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 7, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[5]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 8, '-');
                ord_phone = CStringUtils.setCharAt(ord_phone, 9, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[6]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 10, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[7]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 11, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[8]);
                ord_phone = CStringUtils.setCharAt(ord_phone, 12, pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1()[9]);
                ord_phone[13] = "";
                pCCMN43DInputRec.getTxtTodoLongDesc() += ord_phone + "   Ext: " + pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getLNbrEmpOnCallExt1();
                pCCMN22DInputRec.getROWCCMN22DI().setUlIdPerson(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getUlIdPerson());
                pCCMN22DInputRec.getROWCCMN22DI().setSzCdEmpOnCallDesig(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzCdEmpOnCallDesig());
                pCCMN22DInputRec.getROWCCMN22DI().setSzNbrEmpOnCallPhone1(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone1());
                pCCMN22DInputRec.getROWCCMN22DI().setLNbrEmpOnCallExt1(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getLNbrEmpOnCallExt1());
                pCCMN22DInputRec.getROWCCMN22DI().setSzNbrEmpOnCallPhone2(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getSzNbrEmpOnCallPhone2());
                pCCMN22DInputRec.getROWCCMN22DI().setLNbrEmpOnCallExt2(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getLNbrEmpOnCallExt2());
                pCCMN22DInputRec.getROWCCMN22DI().setUsNbrEmpOnCallCntctOrd(pInputMsg225.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i129).getUsNbrEmpOnCallCntctOrd());
                
                
                
                //  Initialize Service Status Fields
                
                
                
                //  Perform Main Processing
                
                //  Set CCFC21SO WCD DtSystemDate to current date
                rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
                
                if (rc != WtcHelperConstants.SQL_SUCCESS) {
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    }
                }
                else {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                rc = ccmn22dAUDdam(sqlca, pCCMN22DInputRec, pCCMN22DOutputRec);
                
                if (rc != WtcHelperConstants.SQL_SUCCESS) {
                    
                    
                    
                    //  Analyze return code
                    switch (rc) {
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    }
                }
                else {
                    
                    
                    //  Call CMSC36D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
            }
        }
        return rc;
    }

    static int CallCCMN22D(CCMN10SI pInputMsg226, CCMN10SO pOutputMsg207, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;/* Return code */
        int i130 = 0;
        /* local variables */
        String start_date_string = new String();
        String end_date_string = new String();
        int ord = 0;
        String ord_array = new String();
        String ord_phone = new String();
        
        CCMN22DI pCCMN22DInputRec = null;
        CCMN22DO pCCMN22DOutputRec = null;
        
        CCMN43DI pCCMN43DInputRec = null;
        CCMN43DO pCCMN43DOutputRec = null;
        
        CCMN20DI pCCMN20DInputRec = null;
        CCMN20DO pCCMN20DOutputRec = null;
        
        /* allocate memory for Input and Output Structures */
        pCCMN22DInputRec = new CCMN22DI();
        
        pCCMN22DOutputRec = new CCMN22DO();
        
        pCCMN43DInputRec = new CCMN43DI();
        
        pCCMN43DOutputRec = new CCMN43DO();
        
        pCCMN20DInputRec = new CCMN20DI();
        
        pCCMN20DOutputRec = new CCMN20DO();
        pCCMN22DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg226.getArchInputStruct().getUlPageSizeNbr());
        pCCMN43DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        pCCMN43DInputRec.setSzCdTodoType("A");
        //##              return (FND_SUCCESS);
        pCCMN43DInputRec.setUlIdTodoPersCreator(0);
        ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCreated() , 0);
        ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoCompleted() , 0);
        ARC_UTLGetDateAndTime(pCCMN43DInputRec.getDtDtTodoDue() , 0);
        //##              return (FND_SUCCESS);
        pCCMN43DInputRec.getDtDtTaskDue().month = DateHelper.NULL_DATE;
        pCCMN43DInputRec.getDtDtTaskDue().day = DateHelper.NULL_DATE;
        pCCMN43DInputRec.getDtDtTaskDue().year = DateHelper.NULL_DATE;
        
        for (i130 = 0;i130 < pCCMN22DInputRec.getArchInputStruct().getUlPageSizeNbr();++i130) {
            
            if (pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_ADD) {
                pCCMN43DInputRec.setSzTxtTodoDesc("On-Call Addition.");
                //##              return (FND_SUCCESS);
                pCCMN43DInputRec.setTxtTodoLongDesc("You have been added to the following On-Call");
                //##              return (FND_SUCCESS);
                pCCMN22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else if (pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_UPDATE) {
                pCCMN43DInputRec.setSzTxtTodoDesc("On-Call Modification.");
                pCCMN43DInputRec.setTxtTodoLongDesc("You have been modified in the following On-Call");
                pCCMN22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            }
            else if (pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzCdScrDataAction() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                //##              return (FND_SUCCESS);
                pCCMN43DInputRec.setSzTxtTodoDesc("On-Call Deletion.");
                //##              return (FND_SUCCESS);
                pCCMN43DInputRec.setTxtTodoLongDesc("You have been deleted from the following On-Call");
                pCCMN22DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            }
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            pCCMN43DInputRec.setUlIdTodoPersAssigned(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getUlIdPerson());
            if (pInputMsg226.getROWCCMN20DI().getSzCdOnCallType().equals(BLOCK)) {
                pCCMN43DInputRec.getTxtTodoLongDesc() += " Block:";
            }
            else {
                pCCMN43DInputRec.getTxtTodoLongDesc() += " Shift:";
            }
            pCCMN43DInputRec.getTxtTodoLongDesc() += "   Region: " + pInputMsg226.getROWCCMN20DI().getSzCdRegion() + "   County: " + pInputMsg226.getROWCCMN20DI().getSzCdOnCallMultOrAll() + "   Program: " + pInputMsg226.getROWCCMN20DI().getSzCdOnCallProgram() + "   Start Date: ";
            start_date_string = pInputMsg226.getROWCCMN20DI().getDtDtOnCallStart().month + "/" + pInputMsg226.getROWCCMN20DI().getDtDtOnCallStart().day + "/" + pInputMsg226.getROWCCMN20DI().getDtDtOnCallStart().year;
            pCCMN43DInputRec.getTxtTodoLongDesc() += start_date_string;
            pCCMN43DInputRec.getSzTxtTodoDesc() += start_date_string + "  ";
            pCCMN43DInputRec.getTxtTodoLongDesc() += "   Start Time: " + pInputMsg226.getROWCCMN20DI().getTmOnCallStart();
            pCCMN43DInputRec.getSzTxtTodoDesc() += pInputMsg226.getROWCCMN20DI().getTmOnCallStart() + " THRU ";
            pCCMN43DInputRec.getTxtTodoLongDesc() += "   End Date: ";
            end_date_string = pInputMsg226.getROWCCMN20DI().getDtDtOnCallEnd().month + "/" + pInputMsg226.getROWCCMN20DI().getDtDtOnCallEnd().day + "/" + pInputMsg226.getROWCCMN20DI().getDtDtOnCallEnd().year;
            pCCMN43DInputRec.getTxtTodoLongDesc() += end_date_string;
            pCCMN43DInputRec.getSzTxtTodoDesc() += end_date_string + "  ";
            pCCMN43DInputRec.getTxtTodoLongDesc() += "   End Time: " + pInputMsg226.getROWCCMN20DI().getTmOnCallEnd();
            pCCMN43DInputRec.getSzTxtTodoDesc() += pInputMsg226.getROWCCMN20DI().getTmOnCallEnd();
            
            
            //  ord is initialized to be 48
            // (which is the ascii representation of '0')
            // usNbrEmpOnCallCntctOrd can only be in the range 1..9
            // by adding the usNbrEmpOnCallCntctOrd to ord,
            // we should get the ascii representation of 1..9;
            // that is 49..57, inclusive.
            ord = 48;
            ord += pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getUsNbrEmpOnCallCntctOrd();
            ord_array = CStringUtils.setCharAt(ord_array, 0, ord);
            pCCMN43DInputRec.getTxtTodoLongDesc() += "   Contact Order: " + ord_array + "   On-Call Designation: " + pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzCdEmpOnCallDesig() + "   On-Call Phone: (";
            ord_phone = CStringUtils.setCharAt(ord_phone, 0, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[0]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 1, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[1]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 2, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[2]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 3, ')');
            ord_phone = CStringUtils.setCharAt(ord_phone, 4, ' ');
            ord_phone = CStringUtils.setCharAt(ord_phone, 5, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[3]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 6, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[4]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 7, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[5]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 8, '-');
            ord_phone = CStringUtils.setCharAt(ord_phone, 9, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[6]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 10, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[7]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 11, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[8]);
            ord_phone = CStringUtils.setCharAt(ord_phone, 12, pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1()[9]);
            ord_phone[13] = "";
            pCCMN43DInputRec.getTxtTodoLongDesc() += ord_phone + "   Ext: " + pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getLNbrEmpOnCallExt1();
            pCCMN22DInputRec.getROWCCMN22DI().setUlIdOnCall(pInputMsg226.getROWCCMN20DI().getUlIdOnCall());
            pCCMN22DInputRec.getROWCCMN22DI().setUlIdPerson(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getUlIdPerson());
            
            pCCMN22DInputRec.getROWCCMN22DI().setSzCdEmpOnCallDesig(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzCdEmpOnCallDesig());
            pCCMN22DInputRec.getROWCCMN22DI().setUsNbrEmpOnCallCntctOrd(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getUsNbrEmpOnCallCntctOrd());
            pCCMN22DInputRec.getROWCCMN22DI().setSzNbrEmpOnCallPhone1(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone1());
            // 
            // Function Prototypes
            // 
            pCCMN22DInputRec.getROWCCMN22DI().setLNbrEmpOnCallExt1(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getLNbrEmpOnCallExt1());
            pCCMN22DInputRec.getROWCCMN22DI().setSzNbrEmpOnCallPhone2(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getSzNbrEmpOnCallPhone2());
            pCCMN22DInputRec.getROWCCMN22DI().setLNbrEmpOnCallExt2(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getLNbrEmpOnCallExt2());
            
            pCCMN22DInputRec.getROWCCMN22DI().setUlIdEmpOnCallLink(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getUlIdEmpOnCallLink());
            pCCMN22DInputRec.getROWCCMN22DI().setTsLastUpdate(pInputMsg226.getROWCCMN22DI_ARRAY().getROWCCMN22DI(i130).getTsLastUpdate());
            
            //  Call DAM
            rc = ccmn43dAUDdam(sqlca, pCCMN43DInputRec, pCCMN43DOutputRec);
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
            rc = ccmn22dAUDdam(sqlca, pCCMN22DInputRec, pCCMN22DOutputRec);
            // if no rows found for person_forward, it means there is no name for person_forward
            // therefore we want to insert the name
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
        }
        pCCMN20DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_LIST);
        pCCMN20DInputRec.getROWCCMN20DI().setBIndOnCallFilled(FILLED);
        
        pCCMN20DInputRec.getROWCCMN20DI().setUlIdOnCall(pInputMsg226.getROWCCMN20DI().getUlIdOnCall());
        pCCMN20DInputRec.getROWCCMN20DI().setTsLastUpdate(pInputMsg226.getROWCCMN20DI().getTsLastUpdate());
        
        /*
        ** Call Retrieve DAM
        */
        rc = ccmn20dAUDdam(sqlca, pCCMN20DInputRec, pCCMN20DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            
            switch (rc) {
                case NO_DATA_FOUND:
                    //  Call Retrieve DAM
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        else /* rc == 0 */
        {
            rc = WtcHelperConstants.ARC_SUCCESS;
            
            pOutputMsg207.getROWCCMN20DO().setTsLastUpdate(pCCMN20DOutputRec.getROWCCMN20DO().getTsLastUpdate());
        }
        
        return rc;
    }

    static int CallCCMNH8D(CCMN10SI pInputMsg227, CCMN10SO pOutputMsg208, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;
        int i131 = 0;
        /* local variables */
        CCMNH8DI pCCMNH8DInputRec = null;
        CCMNH8DO pCCMNH8DOutputRec = null;
        int usCountyRow = 0;
        
        /* allocate memory for Input and Output Structures */
        pCCMNH8DInputRec = new CCMNH8DI();
        
        pCCMNH8DOutputRec = new CCMNH8DO();
        pCCMNH8DInputRec.setArchInputStruct(pInputMsg227.getArchInputStruct());
        pCCMNH8DInputRec.getROWCCMNH8DI().setSzCdRegion(pInputMsg227.getROWCCMN20DI().getSzCdRegion());
        pCCMNH8DInputRec.getROWCCMNH8DI().setCdCountyCounter(pInputMsg227.getROWCCMN20DI().getCdCountyCounter());
        pCCMNH8DInputRec.getROWCCMNH8DI().setUlIdOnCall(pOutputMsg208.getROWCCMN20DO().getUlIdOnCall());
        pCCMNH8DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
        /*
        ** SIR 675 - Check for factors with an "Y" answer and if found set
        ** the boolean return flag appropriately, then break out of loop.
        */
        if (pCCMNH8DInputRec.getROWCCMNH8DI().getSzCdRegion().equals(REGION_STATE_WIDE)) {
            pCCMNH8DInputRec.getROWCCMNH8DI().setCdCountyCounter(1);
            pCCMNH8DInputRec.getROWCCMNH8DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(0, ALLCOUNTIES);
        }
        else {
            for (usCountyRow = 0;usCountyRow < pInputMsg227.getROWCCMN20DI().getCdCountyCounter();usCountyRow++) {
                pCCMNH8DInputRec.getROWCCMNH8DI().getSzCdOnCallCounty_ARRAY().setSzCdOnCallCounty(usCountyRow, pInputMsg227.getROWCCMN20DI().getSzCdOnCallCounty_ARRAY().getSzCdOnCallCounty(usCountyRow));
            }
        }
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = ccmnh8dAUDdam(sqlca, pCCMNH8DInputRec, pCCMNH8DOutputRec);
        if (rc != WtcHelperConstants.SQL_SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
        }
        return rc;
    }

}
