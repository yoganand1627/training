package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND9DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC38DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC50DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC50DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
/**************************************************************************
** 
** Module File:   ccfc39s.src
**
** Service Name:  CCFC39S
**
** Description:   This service will retrieve all past merges for a given case,
**                as well as case specific information for the given case.
**                If the necessary security requirements have not already
**                been met, the service will also check if the logged in user
**                is either assigned to the given case as a primary worker
**                or is in the unit hiearchy of a primary worker for the
**                case.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/12/96 
** 
** Programmer:    aliam
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   08 Jul 1996 15:42:26  $
**                      $Modtime:   08 Jul 1996 15:23:46  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   __Mar96  aliam     Initial check-in.
**   22Apr96  sladewmf  SIR #20244: The cmsc38d dam returns one row for every
**                      stage merged; the service (this file) needs to loop 
**                      thru that list to return only one row for each unique
**                      ulIdCaseMergeFrom-ulIdCaseMergeTo-cIndCaseMergeInv
**                      triplet, for display in the ListBox of the window.
**   22Apr96  sladewmf  SIR #20439: Added a new dam, cmsc50d, which is 
**                      exactly like cmsc38d, except for the two lines
**                      that begin with: START WITH ID_CASE_MERGE_FROM = ...
**                      cmsc38d.pc has: START WITH ID_CASE_MERGE_FROM = ...
**                      cmsc50d.pc has: START WITH ID_CASE_MERGE_TO = ...
**                      This is needed so that rows in the case_merge table
**                      can be retrieved based upon the MERGE_FROM case,
**                      in addition to rows based upon the MERGE_TO case.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc39s {
    public static final int FND_FAILURE = 1;
    CCFC39SO CCFC39S(CCFC39SI ccfc39si) {
        CCFC39SO ccfc39so = new CCFC39SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CCFC39S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i60 = 0;
        int j = 0;/* Loop counter */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        ** 
        ** SIR #20244: Added three new variables: j and copy_record and rc_time
        ** SIR #20439: Added a new dam: cmsc50d: InputRec and OutputRec
        */
        //##  long            rc = 0;
        int copy_record = 1;
        int rc_time = 0;
        
        CCMN04UI pCCMN04UInputRec = null;
        CCMN04UO pCCMN04UOutputRec = null;
        CCMND9DI pCCMND9DInputRec = null;
        CCMND9DO pCCMND9DOutputRec = null;
        CMSC38DI pCMSC38DInputRec = null;
        CMSC38DO pCMSC38DOutputRec = null;
        CLSC64DI pCLSC64DInputRec = null;
        CLSC64DO pCLSC64DOutputRec = null;
        CMSC50DI pCMSC50DInputRec = null;
        CMSC50DO pCMSC50DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc39si.getArchInputStruct());
        
        
        /*
        ** Call CCMN45D
        */
        rc = ARC_UTLGetDateAndTime(ccfc39so.getDtDtTodaysDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (WtcHelperConstants.REQ_FUNC_CD_SEARCH == ccfc39si.getArchInputStruct().getCReqFuncCd()) {
            // 
            // Call  - CCMND9D
            // Description - case SMP Retrieval Dam
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMND9DInputRec = new CCMND9DI();
            
            pCCMND9DOutputRec = new CCMND9DO();
            pCCMND9DInputRec.setArchInputStruct(ccfc39si.getArchInputStruct());
            pCCMND9DInputRec.setUlIdCase(ccfc39si.getUlIdCase());
            rc = ccmnd9dQUERYdam(sqlca, pCCMND9DInputRec, pCCMND9DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc39so.setSzCdCaseProgram(pCCMND9DOutputRec.getSzCdCaseProgram());
                    if (DateHelper.NULL_DATE != pCCMND9DOutputRec.getDtDtCaseClosed().year) {
                        ccfc39so.setCScrIndToCaseCld(INDICATOR_YES);
                    }
                    else {
                        ccfc39so.setCScrIndToCaseCld(Cint14s.INDICATOR_NO);
                        
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    rc = NO_DATA_FOUND;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    
                    //  Call CSES20D
                    rc = FND_FAILURE;
                    break;
            }
        }
        
        if (SUCCESS == rc) {
            // 
            // Call  - CMSC38D
            // Description - CASE MERGE REC Retrieval Dam (MERGE_TO cases)
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCMSC38DInputRec = new CMSC38DI();
            
            pCMSC38DOutputRec = new CMSC38DO();
            
            
            //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
            pCMSC38DInputRec.setArchInputStruct(ccfc39si.getArchInputStruct());
            pCMSC38DInputRec.getArchInputStruct().setUsPageNbr(ccfc39si.getArchInputStruct().getUsPageNbr());
            pCMSC38DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc39si.getArchInputStruct().getUlPageSizeNbr());
            pCMSC38DInputRec.setUlIdCase(ccfc39si.getUlIdCase());
            rc = cmsc38dQUERYdam(sqlca, pCMSC38DInputRec, pCMSC38DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    ccfc39so.getArchOutputStruct().setUlRowQty(pCMSC38DOutputRec.getArchOutputStruct().getUlRowQty());
                    
                    //  Set fields in CCFC39SO to fields in CMSC38DO
                    // SIR #20244: Added two if statements within the for loop:
                    // if (i > 0)
                    // if (TRUE == copy_record)
                    // Changed the index on pOutputMsg->ROWCCFC39SOG00
                    // from i to j.
                    // Starting with the second row returned from the cmsc38d dam,
                    // (that is why there is an "if (i > 0)"), compare the three values
                    // ulIdCaseMergeFrom-ulIdCaseMergeTo-cIndCaseMergeInv for the 
                    // previous record (i-1) with the current record (i), if all three
                    // values are the same, then check if the dtDtCaseMerge field is
                    // the same for the previous and current records (0 == rc_time).
                    // If this is the case, we do not want to pass this row back to 
                    // the window; decrease the pOutputMsg->...ulRowQty by one, 
                    // and set copy_record = FALSE;
                    // The "if (TRUE == copy_record)" will only allow data to be copied
                    // to the pOutputMsg->ROWCCFC39SOG00 if the three values do not 
                    // match or if the three values match but their dtDtCaseMerge's 
                    // are not equal.
                    for (i60 = 0;i60 < pCMSC38DOutputRec.getArchOutputStruct().getUlRowQty();i60++) {
                        
                        if (i60 > 0) 
                        {
                            
                            if ((pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60 - 1).getUlIdCaseMergeFrom() == pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getUlIdCaseMergeFrom()) && (pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60 - 1).getUlIdCaseMergeTo() == pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getUlIdCaseMergeTo()) && (pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60 - 1).getCIndCaseMergeInv() == pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getCIndCaseMergeInv())) {
                                rc_time = ARC_UTLCompareDateAndTime(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60 - 1).getDtDtCaseMerge() , 0, pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getDtDtCaseMerge() , 0);
                                
                                if (0 == rc_time) {
                                    ccfc39so.getArchOutputStruct().getUlRowQty()--;
                                    copy_record = 0;
                                }
                            }
                        }
                        if (copy_record) {
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setCIndCaseMergePending(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getCIndCaseMergePending());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMerge(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getUlIdCaseMerge());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrNmCaseMrgTo(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getSzScrNmCaseMrgTo());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergeTo(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getUlIdCaseMergeTo());
                            
                            // 
                            // Service Macro Definitions
                            // 
                            
                            // 
                            // Function Prototypes
                            // 
                            
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrNmCaseMrgFrom(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getSzScrNmCaseMrgFrom());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergeFrom(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getUlIdCaseMergeFrom());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setDtDtCaseMerge(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getDtDtCaseMerge());
                            
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrMergeWorker(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getSzScrMergeWorker());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergePersMrg(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getUlIdCaseMergePersMrg());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setDtCaseMergeSplit(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getDtCaseMergeSplit());
                            
                            
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrNmSplitWorker(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getSzScrNmSplitWorker());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergePersSplit(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getUlIdCaseMergePersSplit());
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setCIndCaseMergeInv(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getCIndCaseMergeInv());
                            
                            ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setTsLastUpdate(pCMSC38DOutputRec.getROWCMSC38DO_ARRAY().getROWCMSC38DO(i60).getTsLastUpdate());
                            j++;
                            
                        }
                        else {
                            // re-initialize copy_record variable to TRUE
                            copy_record = 1;
                        }
                    }
                    ccfc39so.getArchOutputStruct().setBMoreDataInd(pCMSC38DOutputRec.getArchOutputStruct().getBMoreDataInd());
                    //  Populate Output Message
                    // pCINVB7DOutputRec will be returned to the service, so there
                    // is no need to copy the DAM output to the service output.
                    // Same goes for the DAM output architecture header.
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = SUCCESS;
                    break;
                    
                default :
                    
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    
                    //  Call CCMN44D
                    rc = FND_FAILURE;
                    break;
            }
        }
        
        if ((SUCCESS == rc) && (false == ccfc39so.getArchOutputStruct().getBMoreDataInd())) {
            
            if (0 == ccfc39so.getArchOutputStruct().getUlRowQty()) {
                // 
                // Call  - CMSC50D
                // Description - CASE MERGE REC Retrieval Dam (MERGE_FROM cases)
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCMSC50DInputRec = new CMSC50DI();
                
                pCMSC50DOutputRec = new CMSC50DO();
                pCMSC50DInputRec.setArchInputStruct(ccfc39si.getArchInputStruct());
                pCMSC50DInputRec.getArchInputStruct().setUsPageNbr(ccfc39si.getArchInputStruct().getUsPageNbr());
                pCMSC50DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc39si.getArchInputStruct().getUlPageSizeNbr());
                pCMSC50DInputRec.setUlIdCase(ccfc39si.getUlIdCase());
                
                
                //  Set rc to ARC_SUCCESS
                rc = cmsc50dQUERYdam(sqlca, pCMSC50DInputRec, pCMSC50DOutputRec);
                //SIR:17091 Srini: Added the error handling to take care of full table scans.
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccfc39so.getArchOutputStruct().setUlRowQty(pCMSC50DOutputRec.getArchOutputStruct().getUlRowQty());
                        
                        //  Set fields in CCFC39SO to fields in CMSC50DO
                        // Starting with the second row returned from the cmsc50d dam,
                        // (that is why there is an "if (i > 0)"), compare the three values
                        // ulIdCaseMergeFrom-ulIdCaseMergeTo-cIndCaseMergeInv for the 
                        // previous record (i-1) with the current record (i), if all three
                        // values are the same, then check if the dtDtCaseMerge field is
                        // the same for the previous and current records (0 == rc_time).
                        // If this is the case, we do not want to pass this row back to 
                        // the window; decrease the pOutputMsg->...ulRowQty by one, 
                        // and set copy_record = FALSE;
                        // The "if (TRUE == copy_record)" will only allow data to be copied
                        // to the pOutputMsg->ROWCCFC39SOG00 if the three values do not 
                        // match or if the three values match but their dtDtCaseMerge's 
                        // are not equal.
                        for (i60 = 0;i60 < pCMSC50DOutputRec.getArchOutputStruct().getUlRowQty();i60++) {
                            
                            if (i60 > 0) {
                                if ((pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60 - 1).getUlIdCaseMergeFrom() == pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getUlIdCaseMergeFrom()) && (pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60 - 1).getUlIdCaseMergeTo() == pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getUlIdCaseMergeTo()) && (pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60 - 1).getCIndCaseMergeInv() == pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getCIndCaseMergeInv())) {
                                    rc_time = ARC_UTLCompareDateAndTime(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60 - 1).getDtDtCaseMerge() , 0, pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getDtDtCaseMerge() , 0);
                                    if (0 == rc_time) {
                                        
                                        //## BEGIN TUX/XML: Declare XML variables 
                                        ccfc39so.getArchOutputStruct().getUlRowQty()--;
                                        copy_record = 0;
                                    }
                                }
                            }
                            if (copy_record) {
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setCIndCaseMergePending(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getCIndCaseMergePending());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMerge(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getUlIdCaseMerge());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrNmCaseMrgTo(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getSzScrNmCaseMrgTo());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergeTo(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getUlIdCaseMergeTo());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrNmCaseMrgFrom(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getSzScrNmCaseMrgFrom());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergeFrom(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getUlIdCaseMergeFrom());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setDtDtCaseMerge(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getDtDtCaseMerge());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrMergeWorker(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getSzScrMergeWorker());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergePersMrg(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getUlIdCaseMergePersMrg());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setDtCaseMergeSplit(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getDtCaseMergeSplit());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setSzScrNmSplitWorker(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getSzScrNmSplitWorker());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setUlIdCaseMergePersSplit(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getUlIdCaseMergePersSplit());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setCIndCaseMergeInv(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getCIndCaseMergeInv());
                                ccfc39so.getROWCCFC39SOG00_ARRAY().getROWCCFC39SOG00(j).setTsLastUpdate(pCMSC50DOutputRec.getROWCMSC50DO_ARRAY().getROWCMSC50DO(i60).getTsLastUpdate());
                                j++;
                            }
                            else {
                                // re-initialize copy_record variable to TRUE
                                copy_record = 1;
                            }
                        }
                        ccfc39so.getArchOutputStruct().setBMoreDataInd(pCMSC50DOutputRec.getArchOutputStruct().getBMoreDataInd());
                        break;
                        
                        //04/09/2003 Srini: Adding the case of MSG_NO_PAL_COORD_EXISTS when 
                        //					MSG_NO_ROWS_RETURNED is returned
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        rc = FND_FAILURE;
                        break;
                }
            }
        }
        if (SUCCESS == rc) {
            
            if ((INDICATOR_YES != ccfc39si.getCSysIndMergeAccess()) && (WtcHelperConstants.REQ_FUNC_CD_SEARCH == ccfc39si.getArchInputStruct().getCReqFuncCd()) && Cint14s.INDICATOR_NO == ccfc39so.getCScrIndToCaseCld()) {
                // 
                // Call  - CLSC64D
                // Description - CASE PRIMARY Retrieval Dam.
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCLSC64DInputRec = new CLSC64DI();
                
                pCLSC64DOutputRec = new CLSC64DO();
                pCLSC64DInputRec.setArchInputStruct(ccfc39si.getArchInputStruct());
                pCLSC64DInputRec.setUlIdCase(ccfc39si.getUlIdCase());
                pCLSC64DInputRec.getArchInputStruct().setUsPageNbr(ccfc39si.getArchInputStruct().getUsPageNbr());
                pCLSC64DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc39si.getArchInputStruct().getUlPageSizeNbr());
                
                
                //  Call clss21d
                rc = clsc64dQUERYdam(sqlca, pCLSC64DInputRec, pCLSC64DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        //  Copy Yes to the IndMergeAccess if one of the idperson
                        // from dam output matches with the service idperson
                        for (i60 = 0;(i60 < pCLSC64DOutputRec.getArchOutputStruct().getUlRowQty() && INDICATOR_YES != ccfc39so.getCSysIndMergeAccess());i60++) {
                            
                            if (ccfc39si.getUlIdPerson() == pCLSC64DOutputRec.getROWCLSC64DO_ARRAY().getROWCLSC64DO(i60).getUlIdPerson()) {
                                ccfc39so.setCSysIndMergeAccess(INDICATOR_YES);
                            }
                        }
                        
                        if (INDICATOR_YES != ccfc39so.getCSysIndMergeAccess()) {
                            for (i60 = 0;((0 != pCLSC64DOutputRec.getROWCLSC64DO_ARRAY().getROWCLSC64DO(i60).getUlIdPerson()) && (INDICATOR_YES != ccfc39so.getCSysIndMergeAccess()));i60++) {
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMN04UInputRec = new CCMN04UI();
                                
                                pCCMN04UOutputRec = new CCMN04UO();
                                pCCMN04UInputRec.setArchInputStruct(ccfc39si.getArchInputStruct());
                                pCCMN04UInputRec.setUlIdUnit(pCLSC64DOutputRec.getROWCLSC64DO_ARRAY().getROWCLSC64DO(i60).getUlIdUnit());
                                pCCMN04UInputRec.getUlIdPerson_ARRAY().setUlIdPerson(0, ccfc39si.getUlIdPerson());
                                rc = Ccmn04u.UnitAccess(pCCMN04UInputRec, pCCMN04UOutputRec, pServiceStatus);
                                //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        if (true == pCCMN04UOutputRec.getBSysIndGeneric()) {
                                            ccfc39so.setCSysIndMergeAccess(INDICATOR_YES);
                                        }
                                        break;
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                                        pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                                        rc = NO_DATA_FOUND;
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        
                                        //  Call CLSS22D
                                        rc = FND_FAILURE;
                                        break;
                                }
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Set rc to ARC_SUCCESS
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        rc = FND_FAILURE;
                        break;
                }
            }
        }
        
        /*
        ** Load Translation Map
        */
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc39si.getArchInputStruct() , ccfc39so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  The Annual Family Income must be less than $63,000 (I5)
            // for the family to be eligible for Emergency Assistance.
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
        return ccfc39so;
    }

}
