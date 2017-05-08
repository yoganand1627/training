package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC68DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC68DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC59DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC59DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC66DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC66DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC94DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC94DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS30DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS30DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC54DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS86DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS86DO;
/**************************************************************************
**
** Module File:   ccfc40s.src
**
** Service Name:  CCFC40S
**
** Description:   This Service will verify that the ID case passed to it
**                is an existing case that has not previouly been
**                a Merge From case. The service will also verify
**                that the ID case passed is not pending another merge.
**                If the security requirement have not been met, the
**                service will also verify that the logged in user is
**                authorized to perform the merge. Finally, a series of
**                edit checks will be run to see if cases are eligible
**                to be merged.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/15/96
**
** Programmer:    aliam
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   09 Apr 1999 12:07:02  $
**                      $Modtime:   24 Sep 1998 10:05:02  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   __Mar96  aliam     Initial check-in.
**   16Apr96  sladewmf  SIR 20460: Changed the if within the while which
**                      loops thru MergeFromPersonInfo to compare the
**                      pMergeInfo->ROWFROMPERSONINFO[f].ulIdPerson with the
**                      pMergeInfo->ROWTOPERSONINFO[e].ulIdPerson;
**                      previously, the index was [f] for both ulIdPerson's.
**  04/19/96  YANTISTK  SIR 20503 - Changed SQL_NOT_FOUND case for clsc59d
**                      to display a message stating that the FROM case has
**                      been invalidated by a previous merge. Also changed
**                      the SQL_NOT_FOUND case in clsc66d to return FND_SUCCESS
**                      because the errors will be caught during the edit
**                      checks.
**  04/19/96  YANTISTK  SIR 20545 - Changed if statement for AOC stages so
**                      that an open APS case w/out an AOC stage cannot be
**                      merged with an APS case with an AOC stage.
**  04/19/96  YANTISTK  SIR 20549 - Changed #define for licensing stages from
**                      LIC to CCL and RCL.
**  04/29/96  YANTISTK  SIR 20670 - Changed code to only display CRSR message
**                      if all of the stages in the to case are CRSR.
**
**  01/16/2003  KRD     IMPACT - The way that CAPS deals with messages
**                      MSG_CFC_MERGE_PEND and MSG_CFC_POST_ADOPT_STG works
**                      fine in the client-server world (pop-ups that then
**                      call this service again), but doesn't really work in
**                      the web world.  So, instead we're going to display
**                      the messages on the Error List.  Look for IMPACT
**                      within the code for the changes.
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**
**  01/30/03   DWW      Since this server almost never uses rc, I am
**                      just setting rc to RetVal, so that the server
**                      will actually return correct error codes
**
**  02/02/2003 DWW      Changed from RetVal = FND_SUCCESS; to
**                      RetVal = MSG_CFC_FROM_ID_INV;
**                      on line 3374 so that the
**                      service would throw an exception in this case
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**                      to PROCESS_TUX_RC_ERROR_NOFREE after the
**                      ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**                      input and output objects before they are allocated
**  04/29/04  readymp  SIR 16903 - Added MSG_CFC_FROM_ID_INV to the error
**                     list instead of exiting the service.
**  07/08/04  Hadjimh   SIR#23007. User should not be able to merge case A to Case B,
**					    then Split, then merge Case B to Case A.  This creates a
**						Circular Merge, but message does not display.
**
**  09/13/04  Hadjimh   SIR# 14994.message "The CRSR must be the Merge From case.
**						(text_message_name: MSG_CFC_CMS_CRSR)" occurs in ccfc40s.src
**						and it's based on the condition that if two cases are to be
**						merged and if one of them is not CRSR case, then the service
**						is throwing the above message and the merge does not occur.
**						users should be able to merge CRSR cases to other cases
**						other cases can be merged into the CRSR cases. There
**						should not be any error and/or warning message.
**  03/28/05  Hadjimh   sir# 14411. Intake received date is incorrect after a case merge
**                      of two open INV stages. When merging open INV stages with open
**                      INV stages, the merge to case must have the earliest intake date.
**                      If the worker has entered the merge with the case to case being
**                      the newer case, the case ids must be switched prior to the merge.
**                      A message should tell the worker the cases have been switched
**                      to allow the case to case be the case with the earliest intake date.
**                      CSEC54D DAM has been added to ccfc01v.dep.
**
**	05/16/05  Malpans	SIR# 23267 - Changes made to pervent the merge of Open INT stages.
**
**  06/28/05  Hadjimh   SIR# 22665 Merged cases have blanked out dispositions on the
**                      allegation list/detail page but the investigation conclusion page
**                      has an overall disposition. Recommended Solution: 1)  If two
**                      cases are being merged and one of the cases has been saved and
**                      submitted for stage closure stop the merge. this pertains to all
**                      case merges.   If the event type is Conclusion and the status is
**                      PEND then the user should get a message telling them the merge
**                      will not occure because of a pending closure.  The message should
**                      say "The merge to (or from) case has been saved and submitted for
**                      closure. Please wait for approval of pending event or invalidate
**                      the approval and resubmit for case merge."
**                      2)  If two cases are pending a merge and one of the cases is saved
**                      and submitted, stop the save and submit by displaying an edit on
**                      the conclusion page.  The message should indicate that the user
**                      should cancel the merge or wait for the merge to process before
**                      saving and submitting. This pertains to CPS INV Conclusion Save
**                      and Submit only.
** 06/30/05  Nallavs    SIR# 23715 - Coded for Messaging on the Error list should prevent
**                      having a C-REG or C-GUA stage as the merge from or merge to
**                      case id is in case merge.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc40s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int FND_FAILURE = 1;
    public static final int PAGE_NUM_ONE = 1;
    
    public static final char SPLIT = 'S';
    public static final char MERGE = 'M';
    
    public static final String TODO_LE_NOTIF_TASK = "1047";
    public static final int SIZEOF_CRSR = 2;
    
    public static final String CODE_STAGE_CRSR = "C-";
    public static final String CODE_STAGE_PAL = "PAL";
    public static final String CODE_STAGE_FAD = "FAD";
    public static final String CODE_STAGE_SPC = "SPC";
    public static final String INFO_AND_REFER = "I&R";
    public static final String CODE_STAGE_AOC = "AOC";
    public static final String CODE_STAGE_SUB = "SUB";
    
    public static final String STAGE_PROGRAM_APS = "APS";
    public static final String STAGE_PROGRAM_CPS = "CPS";
    public static final String STAGE_PROGRAM_CCL = "CCL";
    public static final String STAGE_PROGRAM_RCL = "RCL";
    public static final String STAGE_PROGRAM_AFC = "AFC";
    
    public static final String INTAKE = "INT";
    public static final String POST_ADOPT = "PAD";
    public static final String ADOPT = "ADO";
    public static final String INVESTIGATION = "INV";
    public static final String VICTIM = "VC";
    public static final String VICTIM_PERP = "VP";
    public static final String CLIENT = "CL";
    
    /*
    ** Declare FOUNDATION variables 
    */
    public static final String PRIMARY_CHILD = "PC";
    public // SIR 22665
    static final String EVENT_STATUS_PEND = "PEND";
    //## END TUX/XML: Declare XML variables 
    
    
    //## BEGIN TUX/XML: Turn the XML buffer into an input message struct 
    /* Allocate the Input message that will be used within the service */
    static CCFC40SI pInputMsg = null;
    CCFC40SO CCFC40S(CCFC40SI ccfc40si) {
        CCFC40SO ccfc40so = new CCFC40SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code   */
        rc = ARC_UTLCheckServiceBatchBlock("CCFC40S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int /* MergeTo Person  Local Struct loop counter */
        e = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int i61 = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        int o = 0;
        int p = 0;
        int q = 0;
        int r = 0;
        int s = 0;
        int t = 0;
        int u = 0;
        int v = 0;
        int usRow = 0;
        int ErrorCount = 0;
        int RetVal = SUCCESS;/* Return Code for DAM calls */
        
        //##  long  rc = FND_SUCCESS,         /* Return Code for DAM dam calls */
        
        int CaseToStageRowQty = 0;
        int CaseFromStageRowQty = 0;
        int CaseToPersonRowQty = 0;
        int CaseFromPersonRowQty = 0;
        Pchar bSwitchCases = new Pchar();/* SIR# 14411 */
        bSwitchCases.value = 0;
        int ulTempIdCase = 0;/* SIR# 14411 */
        
        
        String MergeFromProgram = new String();
        
        FndInt3date dtDtCurrentDate = null;
        
        char bSPCStage = 0;
        boolean bCRSR = false;
        char bFAD = 0;
        char bOpenIntDlg = 0;
        char bMTOpenInt = 0;
        char bMFOpenInt = 0;
        char bDupStage = 0;
        char bSvcAuth = 0;
        char bMergeFromInv = 0;
        char bMTCRSRTemp = 1;
        boolean bMTCRSRTemp1 = false;
        char bAPSCases = 0;
        char bMTAOC = 0;
        char bMFAOC = 0;
        boolean bAPSVictim = false;
        boolean bCPSPrincipal = false;
        char bMergePend = 0;
        
        /*SIR# 22665.  */
        Pchar bCasePending = new Pchar();
        bCasePending.value = 0;
        
        Ccfc40sl pMergeInfo = null;
        CLSC67DI pCLSC67DInputRec = null;
        CLSC67DO pCLSC67DOutputRec = null;
        CLSC68DI pCLSC68DInputRec = null;
        CLSC68DO pCLSC68DOutputRec = null;
        CLSC64DI pCLSC64DInputRec = null;
        CLSC64DO pCLSC64DOutputRec = null;
        CLSC59DI pCLSC59DInputRec = null;
        CLSC59DO pCLSC59DOutputRec = null;
        CLSC60DI pCLSC60DInputRec = null;
        CLSC60DO pCLSC60DOutputRec = null;
        CLSC66DI pCLSC66DInputRec = null;
        CLSC66DO pCLSC66DOutputRec = null;
        CCMN04UI pCCMN04UInputRec = null;
        CCMN04UO pCCMN04UOutputRec = null;
        CCMND9DI pCCMND9DInputRec = null;
        CCMND9DO pCCMND9DOutputRec = null;
        CINT58DI pCINT58DInputRec = null;
        CINT58DO pCINT58DOutputRec = null;
        CLSC94DI pCLSC94DInputRec = null;
        CLSC94DO pCLSC94DOutputRec = null;
        CLSS30DI pCLSS30DInputRec = null;
        CLSS30DO pCLSS30DOutputRec = null;
        
        /*
        ** Call DAM
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc40si.getArchInputStruct());
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        /* Get date and time */
        ARC_UTLGetDateAndTime(dtDtCurrentDate, 0);
        
        
        rc = Cinv14s.CallCheckCasePending(ccfc40si, ccfc40so, bCasePending, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (bCasePending.value) {
            ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CASE_APRV_PENDING);
            ErrorCount++;
        }
        
        if (rc == SUCCESS) {
            rc = CallCompareIntakeDate(ccfc40si, ccfc40so, bSwitchCases, pServiceStatus);
            if (bSwitchCases.value) {
                ulTempIdCase = ccfc40si.getUlIdCaseMergeTo();
                ccfc40si.setUlIdCaseMergeTo(ccfc40si.getUlIdCaseMergeFrom());
                ccfc40si.setUlIdCaseMergeFrom(ulTempIdCase);
                ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_MERGE_BY_INTAKE_DATE);
                ErrorCount++;
            }
            
            
            //SIR#23007. Circular Case Merge is not allowed
            RetVal = CheckForReverseMerge(ccfc40si, pServiceStatus);
            if (RetVal == Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED) {
                ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED);
                ErrorCount++;
            }
        }
        /*SIR#23715 - Called Clss30d to check for stage program type in C-REG and C-GUA and
        to display message in Error list.*/
        /**************************************************************************
        **
        ** Function Name:  CallCLSS30D
        **
        ** Description:    Call DAM CLSS30D to retrieve stage program type
        **                 for give id case
        ***************************************************************************/
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS30DInputRec = new CLSS30DI();
        
        pCLSS30DOutputRec = new CLSS30DO();
        
        /*setting checkedCRSR to TRUE if CRSR stage program type is present
        in MergeCaseFromId else setting checkedCRSR to FALSE*/
        boolean checkedCRSR = false;
        pCLSS30DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeFrom());
        pCLSS30DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
        
        
        
        /*
        ** Start performance timer for service
        */
        rc = clss30dQUERYdam(sqlca, pCLSS30DInputRec, pCLSS30DOutputRec);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i61 = 0;i61 < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty();++i61) {
                    if (0 == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i61).getSzCdStageType().compareTo("C-REG") || 0 == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i61).getSzCdStageType().compareTo("C-GUA")) {
                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CRSR_STAGE);
                        ErrorCount++;
                        checkedCRSR = true;
                        break;
                        
                    }
                };
                ccfc40so.getArchOutputStruct().setUlRowQty(pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty());
                ccfc40so.getArchOutputStruct().setBMoreDataInd(pCLSS30DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                rc = FND_FAILURE;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        if (!checkedCRSR) {
            pCLSS30DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeTo());
            pCLSS30DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
            rc = clss30dQUERYdam(sqlca, pCLSS30DInputRec, pCLSS30DOutputRec);
            
            switch (rc) {
                    
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    //  Populate Output Message
                    for (i61 = 0;i61 < pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty();++i61) {
                        
                        if (0 == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i61).getSzCdStageType().compareTo("C-REG") || 0 == pCLSS30DOutputRec.getROWCLSS30DO_ARRAY().getROWCLSS30DO(i61).getSzCdStageType().compareTo("C-GUA")) {
                            ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CRSR_STAGE);
                            ErrorCount++;
                            break;
                        }
                    };
                    ccfc40so.getArchOutputStruct().setUlRowQty(pCLSS30DOutputRec.getArchOutputStruct().getUlRowQty());
                    ccfc40so.getArchOutputStruct().setBMoreDataInd(pCLSS30DOutputRec.getArchOutputStruct().getBMoreDataInd());
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    
                    //  Call CheckStageEventStatus
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                    break;
                    
                default :
                    // Call DAM to retrieve count of how many RFR exists
                    
                    
                    rc = FND_FAILURE;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        /*
        ** Get Merge From case info from CAPS_CASE table.
        */
        /**************************************************************************
        ** Call - CCMND9D
        **
        ** Description - The Case SMP Dam
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMND9DInputRec = new CCMND9DI();
        
        pCCMND9DOutputRec = new CCMND9DO();
        pCCMND9DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
        pCCMND9DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeFrom());
        
        /*
        ** Call CCMND9D
        */
        RetVal = ccmnd9dQUERYdam(sqlca, pCCMND9DInputRec, pCCMND9DOutputRec);
        
        switch (RetVal) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                MergeFromProgram = pCCMND9DOutputRec.getSzCdCaseProgram();
                ccfc40so.setSzScrNmCaseMrgFrom(pCCMND9DOutputRec.getSzNmCase());
                
                
                if (DateHelper.NULL_DATE != pCCMND9DOutputRec.getDtDtCaseClosed().year) {
                    ccfc40so.setCScrIndFromCaseCld(INDICATOR_YES);
                }
                else {
                    ccfc40so.setCScrIndFromCaseCld(Cint14s.INDICATOR_NO);
                }
                
                //  This dam will verify that the From case ID has not been invalidated
                // by being the Merge From ID in a separate merge. If it has been
                // invalidated, the service will return. If it is pending a merge as a
                // merge From case, an Edit will be posted as part of the error list
                // edits.
                // 
                // Call - CLSC67D
                // Description - The Case MRG FROM Retrieval Dam
                // Gets a row from CASE_MERGE table by passing in
                // ID_CASE_MERGE_FROM
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSC67DInputRec = new CLSC67DI();
                
                pCLSC67DOutputRec = new CLSC67DO();
                pCLSC67DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                pCLSC67DInputRec.setUlIdCaseMergeFrom(ccfc40si.getUlIdCaseMergeFrom());
                pCLSC67DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                pCLSC67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC67DO._CLSC67DO__ROWCLSC67DO_SIZE);
                
                //  Call CLSC67D
                RetVal = clsc67dQUERYdam(sqlca, pCLSC67DInputRec, pCLSC67DOutputRec);
                
                switch (RetVal) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  While more rows are left to process and rc is success,
                        // continue loop to check if any of the Merge From case is Pending
                        // to be merged, and if any of the Merge From case is to be
                        // Invalidated. If so than set the respective flags.
                        while (usRow < pCLSC67DOutputRec.getArchOutputStruct().getUlRowQty() && (!(bMergeFromInv != 0) ||!(bMergePend != 0))) {
                            if (INDICATOR_YES == pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getCIndCaseMergeInv()) {
                                if (DateHelper.NULL_DATE == pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getDtCaseMergeSplit().year) {
                                    bMergeFromInv = 1;
                                }
                            }
                            
                            if ((MERGE == pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getCIndCaseMergePending()) || (SPLIT == pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getCIndCaseMergePending())) {
                                bMergePend = 1;
                            }
                            usRow++;
                        }
                        break;
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        RetVal = SUCCESS;
                        break;
                        
                    default :
                        //  Default is not what we expect so an error will not be returned
                        // here.
                        RetVal = FND_FAILURE;
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                
                if (SUCCESS == RetVal) {
                    
                    if (INDICATOR_YES != ccfc40si.getCSysIndMergeAccess() && Cint14s.INDICATOR_NO == ccfc40so.getCScrIndFromCaseCld()) {
                        // 
                        // Call - CLSC64D
                        // Description - The Case Primary Retrieval Dam
                        // Gets ID_STAGE, ID_UNIT, ID_PERSON from
                        // STAGE and STAGE_PERSON_LINK table by passing in
                        // ID_CASE_MERGE_FROM.
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCLSC64DInputRec = new CLSC64DI();
                        
                        pCLSC64DOutputRec = new CLSC64DO();
                        pCLSC64DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                        pCLSC64DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeFrom());
                        pCLSC64DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                        pCLSC64DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC64DO._CLSC64DO__ROWCLSC64DO_SIZE);
                        
                        //  Call CLSC64D
                        RetVal = clsc64dQUERYdam(sqlca, pCLSC64DInputRec, pCLSC64DOutputRec);
                        
                        switch (RetVal) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                //  loop thru OutputRec to check if MergeAccess is allowed or not.
                                // Once the MergeAccess Indicator is set to Yes the loop will
                                // exit, otherwise it will go thru all the rows returned.
                                for (i61 = 0;((i61 < pCLSC64DOutputRec.getArchOutputStruct().getUlRowQty()) && (INDICATOR_YES != ccfc40so.getCSysIndMergeAccess()));i61++) {
                                    if (ccfc40si.getUlIdPerson() == pCLSC64DOutputRec.getROWCLSC64DO_ARRAY().getROWCLSC64DO(i61).getUlIdPerson()) {
                                        ccfc40so.setCSysIndMergeAccess(INDICATOR_YES);
                                    }
                                    else {
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCCMN04UInputRec = new CCMN04UI();
                                        
                                        pCCMN04UOutputRec = new CCMN04UO();
                                        pCCMN04UInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                        pCCMN04UInputRec.setUlIdUnit(pCLSC64DOutputRec.getROWCLSC64DO_ARRAY().getROWCLSC64DO(i61).getUlIdUnit());
                                        pCCMN04UInputRec.getUlIdPerson_ARRAY().setUlIdPerson(0, ccfc40si.getUlIdPerson());
                                        
                                        //  Call UnitAccess
                                        RetVal = Ccmn04u.UnitAccess(pCCMN04UInputRec, pCCMN04UOutputRec, pServiceStatus);
                                        
                                        switch (RetVal) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                if (true == pCCMN04UOutputRec.getBSysIndGeneric()) {
                                                    ccfc40so.setCSysIndMergeAccess(INDICATOR_YES);
                                                }
                                                break;
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                                                RetVal = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                RetVal = FND_FAILURE;
                                                break;
                                        }
                                    }
                                }
                                if (INDICATOR_YES != ccfc40so.getCSysIndMergeAccess()) {
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_CFC_NO_MERGE_ACCESS;
                                    RetVal = Messages.MSG_CFC_NO_MERGE_ACCESS;
                                    
                                }
                                break;
                                
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CFC_NO_MERGE_ACCESS;
                                
                                RetVal = Messages.MSG_CFC_NO_MERGE_ACCESS;
                                rc = RetVal;
                                break;
                                
                            default :
                                //  Default is not what we expect so an error will not be returned
                                // here.
                                RetVal = FND_FAILURE;
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    if (SUCCESS == RetVal) {
                        if (INDICATOR_YES != ccfc40si.getCSysIndMergePend()) {
                            // 
                            // Call - CLSC68D
                            // Description - The Case MRG TO Retrieval Dam
                            // Gets a row from the CASE_MERGE table by passing in
                            // ID_CASE_MERGE_FROM
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCLSC68DInputRec = new CLSC68DI();
                            
                            pCLSC68DOutputRec = new CLSC68DO();
                            pCLSC68DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                            pCLSC68DInputRec.setUlIdCaseMergeTo(ccfc40si.getUlIdCaseMergeFrom());
                            pCLSC68DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                            pCLSC68DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC68DO._CLSC68DO__ROWCLSC68DO_SIZE);
                            
                            //  Call CLSC68D
                            RetVal = clsc68dQUERYdam(sqlca, pCLSC68DInputRec, pCLSC68DOutputRec);
                            
                            //  Analyze return code
                            switch (RetVal) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  While more rows are left to process and rc is success,
                                    // continue loop to check if any Merge To case is Pending a
                                    // merge. If so than set the flag and exit service.
                                    while (usRow < pCLSC68DOutputRec.getArchOutputStruct().getUlRowQty() &&!(bMergePend != 0)) {
                                        
                                        if ((MERGE == pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(usRow).getCIndCaseMergePending()) || (SPLIT == pCLSC68DOutputRec.getROWCLSC68DO_ARRAY().getROWCLSC68DO(usRow).getCIndCaseMergePending())) {
                                            bMergePend = 1;
                                        }
                                        usRow++;
                                    }
                                    
                                    //  Analyze error code
                                    if (bMergePend) {
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        RetVal = WtcHelperConstants.ARC_SUCCESS;
                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_MERGE_PEND);
                                        ErrorCount++;
                                    }
                                    break;
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Set RetVal to ARC_SUCCESS
                                    RetVal = WtcHelperConstants.ARC_SUCCESS;
                                    break;
                                    
                                default :
                                    //  Default is not what we expect so an error will not be returned
                                    // here.
                                    RetVal = FND_FAILURE;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        
                        if (SUCCESS == RetVal) {
                            //  RUN EDIT SEQUENCE 
                            
                            //  Allocate memory for the Local Struct to hold Merge To and Merge
                            // From copybook.
                            pMergeInfo = new Ccfc40sl();
                            
                            //  Retrieve all stage rows for TO case from STAGE table.
                            // 
                            // Call the Stage LSC Retrieval Dam - CLSC59D
                            // Description - Merge To case
                            // 
                            
                            //  Allocate memory for DAM Input and Output Structures
                            pCLSC59DInputRec = new CLSC59DI();
                            
                            pCLSC59DOutputRec = new CLSC59DO();
                            pCLSC59DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                            pCLSC59DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeTo());
                            pCLSC59DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                            pCLSC59DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC59DO._CLSC59DO__ROWCLSC59DO_SIZE);
                            
                            //  Call CLSC59D
                            RetVal = clsc59dQUERYdam(sqlca, pCLSC59DInputRec, pCLSC59DOutputRec);
                            
                            //  Analyze error code
                            switch (RetVal) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    if (INDICATOR_YES != ccfc40si.getCSysIndPostAdopt()) 
                                    
                                    
                                    {
                                        //  loop thru rows returned of Merge To case.
                                        for (i61 = 0;i61 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();i61++) 
                                        {
                                            if (!(POST_ADOPT.compareTo(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStage()) != 0)) {
                                                ccfc40si.setCSysIndPostAdopt(INDICATOR_YES);
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                RetVal = WtcHelperConstants.ARC_SUCCESS;
                                                ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_POST_ADOPT_STG);
                                                ErrorCount++;
                                            }
                                        }
                                    }
                                    
                                    //  Store the number of rows returned from the dam in a local
                                    // variable.
                                    CaseToStageRowQty = pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();
                                    
                                    //  loop thru output Rec and populate the Local Merge To
                                    // stage struct
                                    for (i61 = 0;i61 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();i61++) {
                                        pMergeInfo.ROWTOSTAGEINFO[i61].ulIdStage = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getUlIdStage();
                                        pMergeInfo.ROWTOSTAGEINFO[i61].szCdStageType = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStageType();
                                        pMergeInfo.ROWTOSTAGEINFO[i61].dtDtStageClose = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getDtDtStageClose();
                                        pMergeInfo.ROWTOSTAGEINFO[i61].szCdStageProgram = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStageProgram();
                                        pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStage();
                                        pMergeInfo.ROWTOSTAGEINFO[i61].szCdStageReasonClosed = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStageReasonClosed();
                                    }
                                    break;
                                    
                                case NO_DATA_FOUND:
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                    RetVal = Messages.MSG_NO_ROWS_RETURNED;
                                    
                                    //  pInputMsg->ROWCCMN01UIG00.ulIdEvent has the Contact Shell
                                    // ID EVENT ( NEW ).
                                    // The Requested Function Code has been set to UPDATE.
                                    
                                    //  Now we need to get the timestamps for the NEW Event and
                                    // the Contact Shell.
                                    rc = RetVal;
                                    break;
                                    
                                default :
                                    //  Default is not what we expect so an error will not be returned
                                    // here.
                                    RetVal = FND_FAILURE;
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                            
                            if (SUCCESS == RetVal) {
                                //  Retrieve all stage rows for FROM case from STAGE table.
                                // 
                                // Call the Stage LSC Retrieval Dam - CLSC59D
                                // Description - Merge From case
                                // 
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCLSC59DInputRec = new CLSC59DI();
                                
                                pCLSC59DOutputRec = new CLSC59DO();
                                pCLSC59DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                pCLSC59DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeFrom());
                                pCLSC59DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                                pCLSC59DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC59DO._CLSC59DO__ROWCLSC59DO_SIZE);
                                
                                //  Call CLSC59D
                                RetVal = clsc59dQUERYdam(sqlca, pCLSC59DInputRec, pCLSC59DOutputRec);
                                switch (RetVal) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        if (INDICATOR_YES != ccfc40si.getCSysIndPostAdopt()) {
                                            //  loop thru OutputRec of Merge From case.
                                            for (i61 = 0;i61 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();i61++) {
                                                
                                                if (!(POST_ADOPT.compareTo(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStage()) != 0)) {
                                                    ccfc40si.setCSysIndPostAdopt(INDICATOR_YES);
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    RetVal = WtcHelperConstants.ARC_SUCCESS;
                                                    ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_POST_ADOPT_STG);
                                                    ErrorCount++;
                                                }
                                            }
                                        }
                                        CaseFromStageRowQty = pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();
                                        
                                        //  loop thru output Rec and populate the Local Merge From
                                        // stage struct
                                        for (i61 = 0;i61 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();i61++) {
                                            pMergeInfo.ROWFROMSTAGEINFO[i61].ulIdStage = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getUlIdStage();
                                            pMergeInfo.ROWFROMSTAGEINFO[i61].szCdStageType = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStageType();
                                            pMergeInfo.ROWFROMSTAGEINFO[i61].dtDtStageClose = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getDtDtStageClose();
                                            pMergeInfo.ROWFROMSTAGEINFO[i61].szCdStageProgram = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStageProgram();
                                            pMergeInfo.ROWFROMSTAGEINFO[i61].szCdStage = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStage();
                                            pMergeInfo.ROWFROMSTAGEINFO[i61].szCdStageReasonClosed = pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i61).getSzCdStageReasonClosed();
                                        }
                                        //  Do nothing, the output message just returns success or
                                        // failure.
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_CFC_CASE_INVALID;
                                        RetVal = Messages.MSG_CFC_CASE_INVALID;// SIR 20503
                                        rc = RetVal;
                                        //  Do nothing, the output message just returns success or
                                        // failure.
                                        break;
                                        
                                    default :
                                        //  Default is not what we expect so an error will not be returned
                                        // here.
                                        RetVal = FND_FAILURE;
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        break;
                                }
                                
                                if (SUCCESS == RetVal) {
                                    //  Person info for the Merge To case. Note that this dam will hit
                                    // the person Merge table as well as the stage person link table.
                                    // 
                                    // Call the Case PRN LSC Retrieval Dam - CLSC66D
                                    // Description - Merge To Case PRN
                                    // 
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCLSC66DInputRec = new CLSC66DI();
                                    
                                    pCLSC66DOutputRec = new CLSC66DO();
                                    pCLSC66DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                    pCLSC66DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeTo());
                                    
                                    pCLSC66DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                                    pCLSC66DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC66DO._CLSC66DO__ROWCLSC66DO_SIZE);
                                    
                                    //  Call CLSC66D
                                    RetVal = clsc66dQUERYdam(sqlca, pCLSC66DInputRec, pCLSC66DOutputRec);
                                    switch (RetVal) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            CaseToPersonRowQty = pCLSC66DOutputRec.getArchOutputStruct().getUlRowQty();
                                            
                                            //  loop thru Output rows of Merge To case PRN's
                                            for (i61 = 0;i61 < pCLSC66DOutputRec.getArchOutputStruct().getUlRowQty();i61++) {
                                                pMergeInfo.ROWTOPERSONINFO[i61].ulIdStage = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getUlIdStage();
                                                pMergeInfo.ROWTOPERSONINFO[i61].ulIdPerson = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getUlIdPerson();
                                                pMergeInfo.ROWTOPERSONINFO[i61].szCdStagePersType = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getSzCdStagePersType();
                                                pMergeInfo.ROWTOPERSONINFO[i61].szCdStagePersRole = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getSzCdStagePersRole();
                                            }
                                            break;
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                            RetVal = Messages.MSG_NO_ROWS_RETURNED;
                                            rc = RetVal;
                                            break;
                                            
                                        default :
                                            //  Default is not what we expect so an error will not be returned
                                            // here.
                                            RetVal = FND_FAILURE;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            break;
                                    }
                                    
                                    if (SUCCESS == RetVal) {
                                        //  Person info for the Merge From case. Note that this dam will hit
                                        // the person Merge table as well as the stage person link table.
                                        // 
                                        // Call the Case PRN LSC Retrieval Dam - CLSC66D
                                        // Description - Merge From Case PRN
                                        // 
                                        
                                        //  Allocate memory for DAM Input and Output Structures
                                        pCLSC66DInputRec = new CLSC66DI();
                                        
                                        pCLSC66DOutputRec = new CLSC66DO();
                                        
                                        pCLSC66DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                        pCLSC66DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeFrom());
                                        pCLSC66DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                                        pCLSC66DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC66DO._CLSC66DO__ROWCLSC66DO_SIZE);
                                        
                                        //  Call CLSC66D
                                        RetVal = clsc66dQUERYdam(sqlca, pCLSC66DInputRec, pCLSC66DOutputRec);
                                        switch (RetVal) {
                                            case WtcHelperConstants.SQL_SUCCESS:
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                CaseFromPersonRowQty = pCLSC66DOutputRec.getArchOutputStruct().getUlRowQty();
                                                
                                                //  loop thru output rows of Merge From case PRN's
                                                for (i61 = 0;i61 < pCLSC66DOutputRec.getArchOutputStruct().getUlRowQty();i61++) {
                                                    pMergeInfo.ROWFROMPERSONINFO[i61].ulIdStage = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getUlIdStage();
                                                    pMergeInfo.ROWFROMPERSONINFO[i61].ulIdPerson = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getUlIdPerson();
                                                    pMergeInfo.ROWFROMPERSONINFO[i61].szCdStagePersType = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getSzCdStagePersType();
                                                    pMergeInfo.ROWFROMPERSONINFO[i61].szCdStagePersRole = pCLSC66DOutputRec.getROWCLSC66DO_ARRAY().getROWCLSC66DO(i61).getSzCdStagePersRole();
                                                }
                                                //  Do nothing, the output message just returns success or
                                                // failure.
                                                break;
                                                
                                            case NO_DATA_FOUND:
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = SUCCESS;
                                                RetVal = SUCCESS;// SIR 20503
                                                break;
                                                
                                            default :
                                                //  Default is not what we expect so an error will not be
                                                // returned here.
                                                RetVal = FND_FAILURE;
                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                
                                                break;
                                        }
                                        
                                        if (SUCCESS == RetVal) {
                                            
                                            if (bMergePend) {
                                                ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_ALREADY_PEND);
                                                ErrorCount++;
                                            }
                                            
                                            if (MergeFromProgram.compareTo(ccfc40si.getSzCdCaseProgram()) != 0) {
                                                ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_PROGRAM);
                                                ErrorCount++;
                                            }
                                            
                                            if (!(STAGE_PROGRAM_APS.compareTo(ccfc40si.getSzCdCaseProgram()) != 0) ||!(STAGE_PROGRAM_AFC.compareTo(ccfc40si.getSzCdCaseProgram()) != 0)) {
                                                
                                                if (INDICATOR_YES != ccfc40so.getCScrIndFromCaseCld() &&!(STAGE_PROGRAM_APS.compareTo(ccfc40si.getSzCdCaseProgram()) != 0)) {
                                                    bAPSCases = 1;
                                                }
                                                
                                                //  loop thru MergeToPersonInfo Local Struct and
                                                // MergeFromPersonInfo Local Struct. If a same Person is found
                                                // in both the MergeTo and MergeFrom case which has a Stage
                                                // Person Role of Person Role Victim or Person Role Client or
                                                // Person Role Both than set the APSVictim flag to TRUE.
                                                while ((!bAPSVictim) && (e < CaseToPersonRowQty)) {
                                                    
                                                    if (!(VICTIM.compareTo(pMergeInfo.ROWTOPERSONINFO[e].szCdStagePersRole) != 0) ||!(VICTIM_PERP.compareTo(pMergeInfo.ROWTOPERSONINFO[e].szCdStagePersRole) != 0) ||!(CLIENT.compareTo(pMergeInfo.ROWTOPERSONINFO[e].szCdStagePersRole) != 0)) {
                                                        f// MergeFrom Person Local Struct loop counter
                                                         = 0;
                                                        while ((!bAPSVictim) && (f < CaseFromPersonRowQty)) {
                                                            if ((!(VICTIM.compareTo(pMergeInfo.ROWFROMPERSONINFO[f].szCdStagePersRole) != 0) ||!(VICTIM_PERP.compareTo(pMergeInfo.ROWFROMPERSONINFO[f].szCdStagePersRole) != 0) ||!(CLIENT.compareTo(pMergeInfo.ROWFROMPERSONINFO[f].szCdStagePersRole) != 0)) && pMergeInfo.ROWFROMPERSONINFO[f].ulIdPerson == pMergeInfo.ROWTOPERSONINFO[e].ulIdPerson) {
                                                                bAPSVictim = true;
                                                            }
                                                            f++;
                                                        }
                                                    }
                                                    e++;
                                                }
                                            }
                                            
                                            if (!(STAGE_PROGRAM_CPS.compareTo(ccfc40si.getSzCdCaseProgram()) != 0) ||!(STAGE_PROGRAM_CCL.compareTo(ccfc40si.getSzCdCaseProgram()) != 0) ||!(STAGE_PROGRAM_RCL.compareTo(ccfc40si.getSzCdCaseProgram()) != 0)) {
                                                //  loop thru MergeToPersonInfo
                                                while ((!bCPSPrincipal) && (g < CaseToPersonRowQty)) {
                                                    h// MergeFrom Person Local Struct loop counter
                                                     = 0;
                                                    while ((!bCPSPrincipal) && (h < CaseFromPersonRowQty)) {
                                                        
                                                        if (pMergeInfo.ROWFROMPERSONINFO[h].ulIdPerson == pMergeInfo.ROWTOPERSONINFO[g].ulIdPerson) {
                                                            bCPSPrincipal = true;
                                                        }
                                                        h++;
                                                    }
                                                    g++;
                                                }
                                            }
                                            
                                            //  loop thru all stages in MergeToCaseInfo and check if it is
                                            // Case Related Special Request or
                                            // Info & Referral or Special Stage or
                                            // FAD stage or
                                            // Age Out Child Stage or
                                            // Open Intake Stage.
                                            // Check for Duplicate Open stages for
                                            // Subcare stage and
                                            // Post Adopt Stage and
                                            // Adopt Stage and
                                            // Prep Adult stage.
                                            for (i61 = 0;i61 < CaseToStageRowQty || bMTCRSRTemp != 0 && bSPCStage != 0 && bOpenIntDlg != 0 && bFAD != 0 && bMTAOC != 0 && bMTOpenInt != 0 && bDupStage != 0;i61++) {
                                                
                                                if (bMTCRSRTemp != 0) {
                                                    if (!(CODE_STAGE_CRSR.substring(0, SIZEOF_CRSR).compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStageType.substring(0, SIZEOF_CRSR)) != 0)) {
                                                        bMTCRSRTemp1// SIR 20670
                                                         = true;
                                                        
                                                    }
                                                    if (!bMTCRSRTemp1) {
                                                        bMTCRSRTemp// SIR 20670 initialize to TRUE
                                                         = 0;
                                                    }
                                                }
                                                
                                                if (!(bSPCStage != 0)) {
                                                    
                                                    if (!(INFO_AND_REFER.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStageType) != 0) ||!(CODE_STAGE_SPC.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStageType) != 0)) {
                                                        bSPCStage = 1;
                                                    }
                                                }
                                                if (!(bFAD != 0)) {
                                                    
                                                    if (!(CODE_STAGE_FAD.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0)) {
                                                        bFAD = 1;
                                                    }
                                                }
                                                
                                                if (true == bAPSCases &&!(bMTAOC != 0)) {
                                                    
                                                    if (!(CODE_STAGE_AOC.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWTOSTAGEINFO[i61].dtDtStageClose.year) {
                                                        bMTAOC = 1;
                                                    }
                                                }
                                                
                                                if (!(bMTOpenInt != 0)) {
                                                    
                                                    if (!(INTAKE.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWTOSTAGEINFO[i61].dtDtStageClose.year) {
                                                        bMTOpenInt = 1;
                                                        
                                                        if (null == pMergeInfo.ROWTOSTAGEINFO[i61].szCdStageReasonClosed[0]) {
                                                            bOpenIntDlg = 1;
                                                        }
                                                    }
                                                }
                                                
                                                if (!(bDupStage != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWTOSTAGEINFO[i61].dtDtStageClose.year) {
                                                    if (!(CODE_STAGE_SUB.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0)) {
                                                        j// MergeFrom Stage Local Struct loop counter
                                                         = 0;
                                                        while (!(bDupStage != 0) && j < CaseFromStageRowQty) {
                                                            if (!(CODE_STAGE_SUB.compareTo(pMergeInfo.ROWFROMSTAGEINFO[j].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWFROMSTAGEINFO[j].dtDtStageClose.year) {
                                                                k// MergeTo Person  Local Struct loop counter
                                                                 = 0;
                                                                while (k < CaseToPersonRowQty) {
                                                                    
                                                                    if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWTOPERSONINFO[k].szCdStagePersRole) != 0) && pMergeInfo.ROWTOPERSONINFO[k].ulIdStage == pMergeInfo.ROWTOSTAGEINFO[i61].ulIdStage) {
                                                                        l// MergeFrom Person Local Struct loop counter
                                                                         = 0;
                                                                        while (l < CaseFromPersonRowQty) {
                                                                            
                                                                            if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWFROMPERSONINFO[l].szCdStagePersRole) != 0) && pMergeInfo.ROWFROMPERSONINFO[l].ulIdStage == pMergeInfo.ROWFROMSTAGEINFO[j].ulIdStage) {
                                                                                
                                                                                if (pMergeInfo.ROWTOPERSONINFO[k].ulIdPerson == pMergeInfo.ROWFROMPERSONINFO[l].ulIdPerson) {
                                                                                    bDupStage = 1;
                                                                                }
                                                                            }
                                                                            l++;
                                                                        }
                                                                    }
                                                                    k++;
                                                                }
                                                            }
                                                            j++;
                                                        }
                                                        
                                                    }
                                                    if (!(POST_ADOPT.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0) &&!(bDupStage != 0)) {
                                                        m// MergeFrom Stage Local Struct loop counter
                                                         = 0;
                                                        while (!(bDupStage != 0) && m < CaseFromStageRowQty) {
                                                            
                                                            if (!(POST_ADOPT.compareTo(pMergeInfo.ROWFROMSTAGEINFO[m].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWFROMSTAGEINFO[m].dtDtStageClose.year) 
                                                            
                                                            
                                                            {
                                                                n// MergeTo Person  Local Struct loop counter
                                                                 = 0;
                                                                while (n < CaseToPersonRowQty) 
                                                                {
                                                                    if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWTOPERSONINFO[n].szCdStagePersRole) != 0) && pMergeInfo.ROWTOPERSONINFO[n].ulIdStage == pMergeInfo.ROWTOSTAGEINFO[i61].ulIdStage) {
                                                                        o// MergeFrom Person Local Struct loop counter
                                                                         = 0;
                                                                        while (o < CaseFromPersonRowQty) {
                                                                            
                                                                            if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWFROMPERSONINFO[o].szCdStagePersRole) != 0) && pMergeInfo.ROWFROMPERSONINFO[o].ulIdStage == pMergeInfo.ROWFROMSTAGEINFO[m].ulIdStage) {
                                                                                
                                                                                if (pMergeInfo.ROWTOPERSONINFO[n].ulIdPerson == pMergeInfo.ROWFROMPERSONINFO[o].ulIdPerson) {
                                                                                    bDupStage = 1;
                                                                                }
                                                                            }
                                                                            o++;
                                                                        }
                                                                    }
                                                                    
                                                                    //## BEGIN TUX/XML: Declare XML variables
                                                                    n++;
                                                                }
                                                            }
                                                            m++;
                                                        }
                                                    }
                                                    
                                                    if (!(ADOPT.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0) &&!(bDupStage != 0)) {
                                                        p// MergeFrom Stage Local Struct loop counter
                                                         = 0;
                                                        while (!(bDupStage != 0) && p < CaseFromStageRowQty) {
                                                            if (!(ADOPT.compareTo(pMergeInfo.ROWFROMSTAGEINFO[p].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWFROMSTAGEINFO[p].dtDtStageClose.year) {
                                                                q// MergeTo Person  Local Struct loop counter
                                                                 = 0;
                                                                while (q < CaseToPersonRowQty) {
                                                                    
                                                                    if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWTOPERSONINFO[q].szCdStagePersRole) != 0) && pMergeInfo.ROWTOPERSONINFO[q].ulIdStage == pMergeInfo.ROWTOSTAGEINFO[i61].ulIdStage) {
                                                                        r// MergeFrom Person Local Struct loop counter
                                                                         = 0;
                                                                        while (r < CaseFromPersonRowQty) {
                                                                            
                                                                            if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWFROMPERSONINFO[r].szCdStagePersRole) != 0) && pMergeInfo.ROWFROMPERSONINFO[r].ulIdStage == pMergeInfo.ROWFROMSTAGEINFO[p].ulIdStage) {
                                                                                
                                                                                if (pMergeInfo.ROWTOPERSONINFO[q].ulIdPerson == pMergeInfo.ROWFROMPERSONINFO[r].ulIdPerson) {
                                                                                    bDupStage = 1;
                                                                                }
                                                                            }
                                                                            r++;
                                                                        }
                                                                    }
                                                                    q++;
                                                                }
                                                            }
                                                            p++;
                                                        }
                                                    }
                                                    
                                                    if (!(CODE_STAGE_PAL.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0) &&!(bDupStage != 0)) {
                                                        s// MergeFrom Stage Local Struct loop counter
                                                         = 0;
                                                        while (!(bDupStage != 0) && s < CaseFromStageRowQty) {
                                                            
                                                            if (!(CODE_STAGE_PAL.compareTo(pMergeInfo.ROWFROMSTAGEINFO[s].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWFROMSTAGEINFO[s].dtDtStageClose.year) {
                                                                t// MergeTo Person  Local Struct loop counter
                                                                 = 0;
                                                                while (t < CaseToPersonRowQty) {
                                                                    if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWTOPERSONINFO[t].szCdStagePersRole) != 0) && pMergeInfo.ROWTOPERSONINFO[t].ulIdStage == pMergeInfo.ROWTOSTAGEINFO[i61].ulIdStage) {
                                                                        u// MergeFrom Person Local Struct loop counter
                                                                         = 0;
                                                                        while (u < CaseFromPersonRowQty) {
                                                                            if (!(PRIMARY_CHILD.compareTo(pMergeInfo.ROWFROMPERSONINFO[u].szCdStagePersRole) != 0) && pMergeInfo.ROWFROMPERSONINFO[u].ulIdStage == pMergeInfo.ROWFROMSTAGEINFO[s].ulIdStage) {
                                                                                if (pMergeInfo.ROWTOPERSONINFO[t].ulIdPerson == pMergeInfo.ROWFROMPERSONINFO[u].ulIdPerson) {
                                                                                    bDupStage = 1;
                                                                                }
                                                                            }
                                                                            u++;
                                                                        }
                                                                    }
                                                                    t++;
                                                                }
                                                            }
                                                            s++;
                                                        }
                                                    }
                                                }
                                            }
                                            
                                            //  Loop thru all the MergeFrom stages and check if any of the stage
                                            // is Case Related Sprecial Request or
                                            // Info & Referral or Special stage Type or
                                            // FAD stage or
                                            // Open Aging Out Child stage or
                                            // Open Intake Stage and if LE Notification is completed on it.
                                            // 
                                            for (v = 0;v < CaseFromStageRowQty || bMTCRSRTemp != 0 && bSPCStage != 0 && bOpenIntDlg != 0 && bFAD != 0 && bMFAOC != 0 && bMFOpenInt != 0;v++) {
                                                
                                                //  if no address rows found and the resource
                                                // is of type hotline, then continue normal processing
                                                
                                                if (true == bMTCRSRTemp &&!bCRSR) {
                                                    if (!(CODE_STAGE_CRSR.substring(0, SIZEOF_CRSR).compareTo(pMergeInfo.ROWFROMSTAGEINFO[v].szCdStageType.substring(0, SIZEOF_CRSR)) != 0)) {
                                                        bCRSR = true;
                                                    }
                                                }
                                                
                                                if (!(bSPCStage != 0)) {
                                                    if (!(INFO_AND_REFER.compareTo(pMergeInfo.ROWFROMSTAGEINFO[v].szCdStageType) != 0) ||!(CODE_STAGE_SPC.compareTo(pMergeInfo.ROWFROMSTAGEINFO[v].szCdStageType) != 0)) {
                                                        bSPCStage = 1;
                                                    }
                                                }
                                                if (!(bFAD != 0)) {
                                                    
                                                    // analyze error code
                                                    if (!(CODE_STAGE_FAD.compareTo(pMergeInfo.ROWFROMSTAGEINFO[v].szCdStage) != 0)) {
                                                        bFAD = 1;
                                                    }
                                                    
                                                }
                                                if (true == bAPSCases &&!(bMFAOC != 0)) {
                                                    if (!(CODE_STAGE_AOC.compareTo(pMergeInfo.ROWFROMSTAGEINFO[v].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWFROMSTAGEINFO[v].dtDtStageClose.year) {
                                                        bMFAOC = 1;
                                                    }
                                                }
                                                if (!(bMFOpenInt != 0)) {
                                                    if (!(INTAKE.compareTo(pMergeInfo.ROWFROMSTAGEINFO[v].szCdStage) != 0) && DateHelper.NULL_DATE == pMergeInfo.ROWFROMSTAGEINFO[v].dtDtStageClose.year) {
                                                        bMFOpenInt = 1;
                                                        
                                                        //  See if LE Notification is completed on this intake.
                                                        
                                                        // 
                                                        // Call - CINT58D
                                                        // Description - RTRV TODO by STAGE
                                                        // Outputs: Service return code.
                                                        // 
                                                        
                                                        //  Allocate memory for DAM Input and Output Structures
                                                        pCINT58DInputRec = new CINT58DI();
                                                        
                                                        pCINT58DOutputRec = new CINT58DO();
                                                        pCINT58DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                                        pCINT58DInputRec.setUlIdStage(pMergeInfo.ROWFROMSTAGEINFO[v].ulIdStage);
                                                        pCINT58DInputRec.setSzCdTodoTask(TODO_LE_NOTIF_TASK);
                                                        
                                                        //  Call CINT58D
                                                        RetVal = cint58dQUERYdam(sqlca, pCINT58DInputRec, pCINT58DOutputRec);
                                                        
                                                        //  Analyze error code
                                                        switch (RetVal) {
                                                            case WtcHelperConstants.SQL_SUCCESS:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                if (DateHelper.NULL_DATE == pCINT58DOutputRec.getDtDtTodoCompleted().year) {
                                                                    ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_LE_NOT);
                                                                    ErrorCount++;
                                                                }
                                                                
                                                                break;
                                                                
                                                            case NO_DATA_FOUND:
                                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                                pServiceStatus.explan_code = SUCCESS;
                                                                
                                                                //  Set RetVal to ARC_SUCCESS
                                                                RetVal = WtcHelperConstants.ARC_SUCCESS;
                                                                
                                                                
                                                                // End Retrieve Total Information
                                                                
                                                                
                                                                break;
                                                                
                                                            default :
                                                                //  Default is not what we expect so an error will not be
                                                                // returned here.
                                                                RetVal = FND_FAILURE;
                                                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                
                                                                break;
                                                        }
                                                        
                                                        if (null == pMergeInfo.ROWFROMSTAGEINFO[v].szCdStageReasonClosed[0]) {
                                                            bOpenIntDlg = 1;
                                                        }
                                                    }
                                                }
                                            }
                                            if (!(STAGE_PROGRAM_CPS.compareTo(ccfc40si.getSzCdCaseProgram()) != 0)) {
                                                for (i61 = 0;i61 < CaseToStageRowQty;i61++) {
                                                    
                                                    if (!(INVESTIGATION.compareTo(pMergeInfo.ROWTOSTAGEINFO[i61].szCdStage) != 0)) {
                                                        for (j = 0;j < CaseFromStageRowQty;j++) {
                                                            if ((!(INVESTIGATION.compareTo(pMergeInfo.ROWFROMSTAGEINFO[j].szCdStage) != 0) ||!(INTAKE.compareTo(pMergeInfo.ROWFROMSTAGEINFO[j].szCdStage) != 0)) && DateHelper.NULL_DATE == pMergeInfo.ROWFROMSTAGEINFO[j].dtDtStageClose.year &&!(STAGE_PROGRAM_CPS.compareTo(pMergeInfo.ROWFROMSTAGEINFO[j].szCdStageProgram) != 0) && Cint14s.INDICATOR_NO == ccfc40so.getCScrIndFromCaseCld() && Cint14s.INDICATOR_NO == ccfc40si.getCScrIndToCaseCld()) {
                                                                // 
                                                                // Call DAM CLSC94D to retrieve Status of the Investigation 
                                                                // Conclusion Event for the Merged From Case.
                                                                // Allocate memory for DAM Input and Output Structures     
                                                                // /
                                                                pCLSC94DInputRec = new CLSC94DI();
                                                                
                                                                pCLSC94DOutputRec = new CLSC94DO();
                                                                pCLSC94DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                                                pCLSC94DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeFrom());
                                                                
                                                                //  Call CLSC94D
                                                                RetVal = clsc94dQUERYdam(sqlca, pCLSC94DInputRec, pCLSC94DOutputRec);
                                                                
                                                                //  Analyze error code
                                                                switch (RetVal) {
                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        ccfc40so.setSzCdCaseFromCCLStatus(pCLSC94DOutputRec.getSzCdEventStatus());
                                                                        
                                                                        break;
                                                                        
                                                                    case NO_DATA_FOUND:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        
                                                                        //  Set RetVal to ARC_SUCCESS
                                                                        RetVal = WtcHelperConstants.ARC_SUCCESS;
                                                                        
                                                                        
                                                                        // End Retrieve Client's Payment History
                                                                        
                                                                        
                                                                        break;
                                                                        
                                                                    default :
                                                                        //  Default is not what we expect so an error will not be
                                                                        // returned here.
                                                                        RetVal = FND_FAILURE;
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                        
                                                                        break;
                                                                }
                                                                
                                                                // 
                                                                // End Call TO Retrieval Dam - CLSC94D
                                                                // 
                                                                
                                                                
                                                                // 
                                                                // Call DAM CLSC94D to retrieve Status of the Investigation
                                                                // Conclusion Event for the Merged To Case.                
                                                                // Allocate memory for DAM Input and Output Structures     
                                                                // /
                                                                pCLSC94DInputRec = new CLSC94DI();
                                                                
                                                                pCLSC94DOutputRec = new CLSC94DO();
                                                                pCLSC94DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                                                pCLSC94DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeTo());
                                                                
                                                                //  Call CLSC94D
                                                                RetVal = clsc94dQUERYdam(sqlca, pCLSC94DInputRec, pCLSC94DOutputRec);
                                                                
                                                                //  Analyze error code
                                                                
                                                                switch (RetVal) {
                                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        ccfc40so.setSzCdCaseToCCLStatus(pCLSC94DOutputRec.getSzCdEventStatus());
                                                                        
                                                                        break;
                                                                    case NO_DATA_FOUND:
                                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                                        pServiceStatus.explan_code = SUCCESS;
                                                                        
                                                                        //  Set RetVal to ARC_SUCCESS
                                                                        RetVal = WtcHelperConstants.ARC_SUCCESS;
                                                                        break;
                                                                        
                                                                    default :
                                                                        //  Default is not what we expect so an error will not be
                                                                        // returned here.
                                                                        RetVal = FND_FAILURE;
                                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                                        break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            
                                            if (SUCCESS == RetVal) {
                                                
                                                if (Cint14s.INDICATOR_NO == ccfc40so.getCScrIndFromCaseCld()) {
                                                    // 
                                                    // Call - CLSC60D
                                                    // Description - The SVC AUTH TERM DATE Retrieval Dam
                                                    // 
                                                    
                                                    //  Allocate memory for DAM Input and Output Structures
                                                    pCLSC60DInputRec = new CLSC60DI();
                                                    
                                                    pCLSC60DOutputRec = new CLSC60DO();
                                                    pCLSC60DInputRec.setArchInputStruct(ccfc40si.getArchInputStruct());
                                                    pCLSC60DInputRec.setUlIdCase(ccfc40si.getUlIdCaseMergeFrom());
                                                    pCLSC60DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
                                                    
                                                    pCLSC60DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC60DO._CLSC60DO__ROWCLSC60DO_SIZE);
                                                    
                                                    //  Call CLSC60D
                                                    RetVal = clsc60dQUERYdam(sqlca, pCLSC60DInputRec, pCLSC60DOutputRec);
                                                    
                                                    //  Analyze error code
                                                    
                                                    switch (RetVal) {
                                                        case WtcHelperConstants.SQL_SUCCESS:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            bSvcAuth = 1;
                                                            
                                                            //  End Retrieve Total Payment Information
                                                            
                                                            break;
                                                            
                                                        case NO_DATA_FOUND:
                                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                                            pServiceStatus.explan_code = SUCCESS;
                                                            
                                                            //  Set RetVal to ARC_SUCCESS
                                                            RetVal = WtcHelperConstants.ARC_SUCCESS;
                                                            break;
                                                            
                                                        default :
                                                            //  Default is not what we expect so an error will not be
                                                            // returned here.
                                                            RetVal = FND_FAILURE;
                                                            
                                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                            break;
                                                    }
                                                }
                                                
                                                if (SUCCESS == RetVal) {
                                                    if (bSPCStage) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_NO_MRG);
                                                        ErrorCount++;
                                                        
                                                    }
                                                    if (bFAD) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_FAD);
                                                        ErrorCount++;
                                                    }
                                                    
                                                    //  Analyze error code
                                                    if ((true == bMTAOC && false == bMFAOC) || (false == bMTAOC && true == bMFAOC)) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_APS);
                                                        ErrorCount++;
                                                    }
                                                    
                                                    if (bOpenIntDlg) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_INT_OPN);
                                                        ErrorCount++;
                                                    }
                                                    
                                                    if (true == bMTOpenInt || true == bMFOpenInt) {
                                                        
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_OPEN_INT);
                                                        ErrorCount++;
                                                    }
                                                    
                                                    //SIR #22595
                                                    if (bSvcAuth) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_SA);
                                                        ErrorCount++;
                                                    }
                                                    
                                                    if ((!(STAGE_PROGRAM_CPS.compareTo(ccfc40si.getSzCdCaseProgram()) != 0) ||!(STAGE_PROGRAM_CCL.compareTo(ccfc40si.getSzCdCaseProgram()) != 0) ||!(STAGE_PROGRAM_RCL.compareTo(ccfc40si.getSzCdCaseProgram()) != 0)) &&!bCPSPrincipal) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_PRN);
                                                        ErrorCount++;
                                                    }
                                                    if ((!(STAGE_PROGRAM_APS.compareTo(ccfc40si.getSzCdCaseProgram()) != 0) ||!(STAGE_PROGRAM_AFC.compareTo(ccfc40si.getSzCdCaseProgram()) != 0)) &&!bAPSVictim) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_APS_PRN);
                                                        ErrorCount++;
                                                    }
                                                    if (bDupStage) {
                                                        ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_DUP_STG);
                                                        ErrorCount++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                if (true == bMergeFromInv && false == bMergePend) {
                    ccfc40so.getROWCCFC40SOG00_ARRAY().getROWCCFC40SOG00(ErrorCount).setSzCdUerrorMsgNbr(Messages.MSG_CFC_FROM_ID_INV);
                    ErrorCount++;
                }
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CFC_FROM_ID_INV;
                
                // DWW 02/02/2003 Changed from
                // RetVal = FND_SUCCESS;
                // so that the service would throw an exception in this case
                RetVal = Messages.MSG_CFC_FROM_ID_INV;
                break;
                
            default :
                //  Default is not what we expect so an error will not be returned
                // here.
                RetVal = FND_FAILURE;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        ccfc40so.getArchOutputStruct().setUlRowQty(ErrorCount);
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc40si.getArchInputStruct() , ccfc40so.getArchOutputStruct());
        rc = RetVal;
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
            //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            
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
        return ccfc40so;
    }

    static int CheckForReverseMerge(CCFC40SI pInputMsg53, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        
        CLSC67DI pCLSC67DInputRec = null;
        CLSC67DO pCLSC67DOutputRec = null;
        int rc = 0;
        int RetVal = 0;/* Return code */
        int usRow = 0;
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC67DInputRec = new CLSC67DI();
        
        pCLSC67DOutputRec = new CLSC67DO();
        pCLSC67DInputRec.setArchInputStruct(pInputMsg53.getArchInputStruct());
        pCLSC67DInputRec.setUlIdCaseMergeFrom(pInputMsg53.getUlIdCaseMergeTo());
        pCLSC67DInputRec.getArchInputStruct().setUsPageNbr(PAGE_NUM_ONE);
        pCLSC67DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC67DO._CLSC67DO__ROWCLSC67DO_SIZE);
        
        /*
        ** Call CLSC67D
        */
        RetVal = clsc67dQUERYdam(sqlca, pCLSC67DInputRec, pCLSC67DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (RetVal) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  If a row is found it has been previously merged
                while (usRow < pCLSC67DOutputRec.getArchOutputStruct().getUlRowQty()) {
                    if (0 != pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getDtCaseMergeSplit().year && 0 != pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getDtCaseMergeSplit().month && 0 != pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getDtCaseMergeSplit().day) {
                        
                        if ((pInputMsg53.getUlIdCaseMergeFrom() == pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getUlIdCaseMergeTo()) && (pInputMsg53.getUlIdCaseMergeTo() == pCLSC67DOutputRec.getROWCLSC67DO_ARRAY().getROWCLSC67DO(usRow).getUlIdCaseMergeFrom())) {
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED;
                            RetVal = Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED;
                            
                            break;
                        }
                    }
                    usRow++;
                }
                if (RetVal != Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED) {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                }
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                RetVal = SUCCESS;
                
                break;
                
            default :
                RetVal = FND_FAILURE;
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return RetVal;
    }

    static int CallCompareIntakeDate(CCFC40SI pInputMsg54, CCFC40SO * pOutputMsg56, String pbSwitchCases, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i62 = 0;
        int iCaseTo = 0;
        int iCaseFrom = 0;
        int lRC2 = 0;
        /* CaseTo is forward case and CaseFrom is the case that is going to be closed
        ** therefore, intake date on CaseTo(forward_case) should be prior to
        ** CaseFrom (closed_case)
        */
        /*
        ** Declare local variables
        */
        
        boolean bCaseToInvOpen = false;
        boolean bCaseFromInvOpen = false;
        
        CLSC59DI pCaseMergeToInput = null;
        CLSC59DO pCaseMergeToOutput = null;
        
        CLSC59DI pCaseMergeFromInput = null;
        CLSC59DO pCaseMergeFromOutput = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCaseMergeToInput = new CLSC59DI();
        pCaseMergeToOutput = new CLSC59DO();
        pCaseMergeFromInput = new CLSC59DI();
        pCaseMergeFromOutput = new CLSC59DO();
        if ((pCaseMergeToInput == null) || (pCaseMergeToOutput == null) || (pCaseMergeFromInput == null) || (pCaseMergeFromOutput == null)) {
            
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        /*
        ** Extern for version control table.
        */
        
        /**************************************************************************
        ** Service Macro Definitions
        ***************************************************************************/
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        
        pCaseMergeToInput.setUlIdCase(pInputMsg54.getUlIdCaseMergeTo());
        rc = Cinv16s.CallCLSC59D(pCaseMergeToInput, pCaseMergeToOutput, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        pCaseMergeFromInput.setUlIdCase(pInputMsg54.getUlIdCaseMergeFrom());
        rc = Cinv16s.CallCLSC59D(pCaseMergeFromInput, pCaseMergeFromOutput, pServiceStatus);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        iCaseTo = - 1;
        iCaseFrom = - 1;
        
        for (i62 = 0;i62 < pCaseMergeToOutput.getArchOutputStruct().getUlRowQty();i62++) {
            //  SIR 22462 - Call csec25d if the placement type is foster adoptive, otherwise
            // call csecc2d
            if (DateHelper.NULL_DATE != pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().year && DateHelper.NULL_DATE != pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().month && DateHelper.NULL_DATE != pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().day &&!(INTAKE.compareTo(pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getSzCdStage()) != 0)) {
                iCaseTo = i62;
            }
            if (DateHelper.NULL_DATE == pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().year && DateHelper.NULL_DATE == pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().month && DateHelper.NULL_DATE == pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().day &&!(INVESTIGATION.compareTo(pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getSzCdStage()) != 0)) {
                bCaseToInvOpen = true;
            }
            if (bCaseToInvOpen && iCaseTo >= 0) {
                break;// Break for success of cinv51d (CL)
            }
        }
        
        
        /* There must always be a from-case for case-merge. if there is no row back from this DAM, we let the
        ** validation proccess to throw the right error message for the user.
        */
        for (i62 = 0;i62 < pCaseMergeFromOutput.getArchOutputStruct().getUlRowQty();i62++) {
            
            //  Populate DAM Input Structure
            if (DateHelper.NULL_DATE != pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().year && DateHelper.NULL_DATE != pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().month && DateHelper.NULL_DATE != pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().day &&!(INTAKE.compareTo(pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getSzCdStage()) != 0)) {
                iCaseFrom = i62;
            }
            if (DateHelper.NULL_DATE == pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().year && DateHelper.NULL_DATE == pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().month && DateHelper.NULL_DATE == pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getDtDtStageClose().day &&!(INVESTIGATION.compareTo(pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i62).getSzCdStage()) != 0)) {
                bCaseFromInvOpen = true;
            }
            if (bCaseFromInvOpen && iCaseFrom >= 0) {
                break;
            }
        }
        
        /*
        ** Populate DAM Input Structure
        */
        if (bCaseFromInvOpen && bCaseToInvOpen && pCaseMergeFromOutput.getArchOutputStruct().getUlRowQty() > 0) {
            rc = Ccmn03u.CallCSEC54D(pCaseMergeFromInput, pCaseMergeFromOutput, iCaseFrom, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            
            
            //  Start performance timer for service
            rc = Ccmn03u.CallCSEC54D(pCaseMergeToInput, pCaseMergeToOutput, iCaseTo, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            lRC2 = ARC_UTLCompareDateAndTime(pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(iCaseTo).getDtDtStageStart() , pCaseMergeToOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(iCaseTo).getTmScrTmGeneric2() , pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(iCaseFrom).getDtDtStageStart() , pCaseMergeFromOutput.getROWCLSC59DO_ARRAY().getROWCLSC59DO(iCaseFrom).getTmScrTmGeneric2());
            // 
            // (END): Retrieve DAM: csecc2d      Facility_loc simple retrieve
            // 
            
            
            if (lRC2 > 0) {
                pbSwitchCases = CStringUtils.setCharAt(pbSwitchCases, 0, true);
            }
        }
        
        return rc;
    }

    static int CallCLSC59D(CLSC59DI pInputMsg55, CLSC59DO pOutputMsg57, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        int i63 = 0;
        
        CLSC59DI pCLSC59DInputRec = null;
        CLSC59DO pCLSC59DOutputRec = null;
        
        FndInt3date dtDtIntake = null;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC59DInputRec = new CLSC59DI();
        
        pCLSC59DOutputRec = new CLSC59DO();
        pCLSC59DInputRec.setArchInputStruct(pInputMsg55.getArchInputStruct());
        pCLSC59DInputRec.getArchInputStruct().setUsPageNbr(Csys08s.INITIAL_PAGE);
        pCLSC59DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC59DO._CLSC59DO__ROWCLSC59DO_SIZE);
        pCLSC59DInputRec.setUlIdCase(pInputMsg55.getUlIdCase());
        
        /* Set rc to ARC_SUCCESS */
        rc = clsc59dQUERYdam(sqlca, pCLSC59DInputRec, pCLSC59DOutputRec);
        
        switch (rc) {
                // person may not yet have a designated ethnicity
            case WtcHelperConstants.SQL_SUCCESS:
                
                for (i63 = 0;i63 < pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty();i63++) {
                    pOutputMsg57.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).setUlIdCase(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).getUlIdCase());
                    pOutputMsg57.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).setUlIdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).getUlIdStage());
                    pOutputMsg57.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).setDtDtStageClose(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).getDtDtStageClose());
                    pOutputMsg57.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).setSzCdStage(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).getSzCdStage());
                    pOutputMsg57.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).setBIndStageClose(pCLSC59DOutputRec.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i63).getBIndStageClose());
                }
                pOutputMsg57.getArchOutputStruct().setUlRowQty(pCLSC59DOutputRec.getArchOutputStruct().getUlRowQty());
                
                // 
                // End Call to Situation Reopen Dam - CMSC17D
                // 
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
                pOutputMsg57.getArchOutputStruct().setUlRowQty(0);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCSEC54D(CLSC59DI pInputMsg56, CLSC59DO pOutputMsg58, int i64, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CSEC54DI pCSEC54DInputRec = null;
        CSEC54DO pCSEC54DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC54DInputRec = new CSEC54DI();
        pCSEC54DOutputRec = new CSEC54DO();
        pCSEC54DInputRec.setArchInputStruct(pInputMsg56.getArchInputStruct());
        pCSEC54DInputRec.setUlIdStage(pOutputMsg58.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i64).getUlIdStage());
        rc = csec54dQUERYdam(sqlca, pCSEC54DInputRec, pCSEC54DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg58.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i64).setDtDtStageStart(pCSEC54DOutputRec.getDtDtIncomingCall());
                pOutputMsg58.getROWCLSC59DO_ARRAY().getROWCLSC59DO(i64).setTmScrTmGeneric2(pCSEC54DOutputRec.getTmTmIncmgCall());
                break;
                
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCheckCasePending(CCFC40SI pInputMsg57, CCFC40SO * pOutputMsg59, String pbCasePending, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        Pchar bLocalCasePending = new Pchar();
        
        CLSS86DI idCaseToInput = null;
        CLSS86DO idCaseToOutput = null;
        
        CLSS86DI idCaseFromInput = null;
        CLSS86DO idCaseFromOutput = null;
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        idCaseToInput = new CLSS86DI();
        idCaseToOutput = new CLSS86DO();
        idCaseFromInput = new CLSS86DI();
        idCaseFromOutput = new CLSS86DO();
        if ((idCaseFromInput == null) || (idCaseFromOutput == null) || (idCaseToInput == null) || (idCaseToOutput == null)) {
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        bLocalCasePending.value = pbCasePending.charAt(0);
        idCaseToInput.setUlIdCase(pInputMsg57.getUlIdCaseMergeTo());
        idCaseToInput.setSzCdEventStatus(EVENT_STATUS_PEND);
        idCaseToInput.setSzCdEventType(STAGE_PROGRAM_CCL);
        rc = CallCLSS86D(idCaseToInput, bLocalCasePending, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        if (!bLocalCasePending.value) {
            idCaseFromInput.setUlIdCase(pInputMsg57.getUlIdCaseMergeFrom());
            idCaseFromInput.setSzCdEventStatus(EVENT_STATUS_PEND);
            idCaseFromInput.setSzCdEventType(STAGE_PROGRAM_CCL);
            rc = CallCLSS86D(idCaseFromInput, bLocalCasePending, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pbCasePending = CStringUtils.setCharAt(pbCasePending, 0, bLocalCasePending.value);
        return rc;
    }

    static int CallCLSS86D(CLSS86DI pbCLSS86DInputRec, String pbCasePending, Arcxmlerrors.TUX_DECL_STATUSPARMS) 
    {
        int rc = 0;/* Return code */
        
        /*
        ** Declare local variables
        */
        CLSS86DI pCLSS86DInputRec = null;
        CLSS86DO pCLSS86DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCLSS86DInputRec = new CLSS86DI();
        pCLSS86DOutputRec = new CLSS86DO();
        pCLSS86DInputRec.setArchInputStruct(pInputMsg.getArchInputStruct());
        pCLSS86DInputRec.setUlIdCase(pbCLSS86DInputRec.getUlIdCase());
        pCLSS86DInputRec.setSzCdEventStatus(pbCLSS86DInputRec.getSzCdEventStatus());
        pCLSS86DInputRec.setSzCdEventType(pbCLSS86DInputRec.getSzCdEventType());
        rc = clss86dQUERYdam(sqlca, pCLSS86DInputRec, pCLSS86DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pbCasePending = CStringUtils.setCharAt(pbCasePending, 0, true);
                
                break;
                
            case NO_DATA_FOUND:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                pbCasePending = CStringUtils.setCharAt(pbCasePending, 0, false);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                break;
        }
        return rc;
    }

}
