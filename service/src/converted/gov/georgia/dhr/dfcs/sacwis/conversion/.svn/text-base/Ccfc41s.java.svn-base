package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC41SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC41SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUD94DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUD94DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC38DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC38DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   ccfc41s.src
**
** Service Name:  CCFC41S
**
** Description:   This service will save case merges and case splits to
**                the database with the pending flag. The actual DB
**                updates will be done in a batch process.
**                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/12/96
** 
** Programmer:    aliam
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:40:22  $
**                      $Modtime:   29 Mar 1996 23:59:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
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






public class Ccfc41s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int CONNECT_BY_LOOP = - 1436;
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int FND_FAILURE = 1;
    
    public static final char MERGE = 'M';
    public static final char VOID_MERGE = 'V';
    public static final char VOID_SPLIT = 'Z';
    public static final char SPLIT = 'S';
    CCFC41SO CCFC41S(CCFC41SI ccfc41si) {
        CCFC41SO ccfc41so = new CCFC41SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        //set rc value to FND_FAIL
        rc = ARC_UTLCheckServiceBatchBlock("CCFC41S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        CAUD94DI pCAUD94DInputRec = null;
        CAUD94DO pCAUD94DOutputRec = null;
        CMSC38DI pCMSC38DInputRec = null;
        CMSC38DO pCMSC38DOutputRec = null;
        int RetVal = SUCCESS;/* Return Code for DAM calls */
        
        
        //##  short rc = FND_SUCCESS;     /* Return Code for DAM dam calls */
        
        int usRow = 0;
        rc = ARC_PRFServiceStartTime_TUX(ccfc41si.getArchInputStruct());
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        /*
        ** Reserve the memory of the Dams that will be called more than once here.
        ** Allocate memory for them all at once, if any of them fail try and free
        ** all the memory and then return out of the service.  The memory will be
        ** freed on the bottom of the service if everything went well.
        */
        
        pCAUD94DInputRec = new CAUD94DI();
        
        pCAUD94DOutputRec = new CAUD94DO();
        
        /*
        **  Perform Main Processing
        */
        
        /*
        ** While more rows are left to process and rc is success,
        ** continue loop.
        */
        while ((usRow < ccfc41si.getArchInputStruct().getUlPageSizeNbr()) && (RetVal == WtcHelperConstants.SQL_SUCCESS)) {
            pCAUD94DInputRec.setArchInputStruct(ccfc41si.getArchInputStruct());
            if (MERGE == ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getSzCdScrDataAction() || SPLIT == ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getSzCdScrDataAction()) {
                pCAUD94DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_ADD);
            }
            else {
                
                pCAUD94DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
            }
            
            // 
            // Call - CAUD94D
            // Description - Case Merge List AUD Dam
            // 
            
            //  Initialize rc for loop
            RetVal = WtcHelperConstants.SQL_SUCCESS;
            
            //## BEGIN TUX/XML: Declare XML variables 
            pCAUD94DInputRec.setDtDtCaseMerge(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getDtDtCaseMerge());
            pCAUD94DInputRec.setDtCaseMergeSplit(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getDtCaseMergeSplit());
            pCAUD94DInputRec.setUlIdCaseMerge(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getUlIdCaseMerge());
            pCAUD94DInputRec.setUlIdCaseMergeFrom(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getUlIdCaseMergeFrom());
            pCAUD94DInputRec.setUlIdCaseMergePersMrg(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getUlIdCaseMergePersMrg());
            pCAUD94DInputRec.setUlIdCaseMergePersSplit(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getUlIdCaseMergePersSplit());
            pCAUD94DInputRec.setUlIdCaseMergeTo(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getUlIdCaseMergeTo());
            pCAUD94DInputRec.setCIndCaseMergeInv(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getCIndCaseMergeInv());
            if (MERGE == ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getSzCdScrDataAction() || VOID_MERGE == ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getSzCdScrDataAction()) {
                pCAUD94DInputRec.setCIndCaseMergePending(MERGE);
            }
            else {
                pCAUD94DInputRec.setCIndCaseMergePending(SPLIT);
            }
            pCAUD94DInputRec.setTsLastUpdate(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getTsLastUpdate());
            
            //  Call CAUD94D
            RetVal = caud94dAUDdam(sqlca, pCAUD94DInputRec, pCAUD94DOutputRec);
            
            // Analyze return code
            switch (RetVal) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // 
                    // If the row passed has an action indicator of update
                    // and a Lock Modification indicator of yes
                    // numerous actions will take place.
                    // First, The service information will be retrieved for
                    // the modified row.  Second, if the version is not
                    // version number one, the services information will be
                    // retrieved for the previous version.  If all of the
                    // current version service line item amounts are greater
                    // than the previous version's line item amounts used,
                    // the current version's line item amounts used will be
                    // updated with the previous version's amount used values,
                    // (This comparison is only done for versions other than
                    // the first version) the current contract worker's name,
                    // and the new row action indicator will be set to No.
                    // In the case of the first version, only the workers
                    // name and new row action indicator (set to No) will
                    // be updated.
                    // In addition, any service rows that did not exist in
                    // the previous version will be updated with the
                    // current contract worker's name, and the new row action
                    // indicator will be set to No.
                    // This allows the finance work to be updated to the most
                    // recent locked version.  Setting all of the locked
                    // version service rows to No assures that new versions
                    // will contain at least as many service line items
                    // as the previous version in the same order with the
                    // same service line item number.
                    // 
                    
                    if (MERGE == ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getSzCdScrDataAction()) {
                        // 
                        // Call  - CMSC38D
                        // Description - CASE MERGE REC Retrieval Dam 
                        // 
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCMSC38DInputRec = new CMSC38DI();
                        
                        pCMSC38DOutputRec = new CMSC38DO();
                        pCMSC38DInputRec.setArchInputStruct(ccfc41si.getArchInputStruct());
                        pCMSC38DInputRec.getArchInputStruct().setUsPageNbr(1);
                        pCMSC38DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                        pCMSC38DInputRec.setUlIdCase(ccfc41si.getROWCCFC41SIG00_ARRAY().getROWCCFC41SIG00(usRow).getUlIdCaseMergeTo());
                        
                        //  Call CMSC38D
                        RetVal = cmsc38dQUERYdam(sqlca, pCMSC38DInputRec, pCMSC38DOutputRec);
                        
                        
                        // Analyze return code
                        switch (RetVal) {
                                
                                
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                break;
                            case CONNECT_BY_LOOP:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.MSG_CFC_CONNECT_BY_LOOP;
                                
                                //  Set explan_data to usRow
                                //##                      sprintf(pReturnPB->appl_status.explan_data, "%u", usRow);
                                
                                RetVal = FND_FAILURE;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = FND_FAILURE;
                                break;
                        }
                        break;
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    //  Set explan_data to usRow
                    //##            sprintf(pReturnPB->appl_status.explan_data, "%u", usRow);
                    
                    RetVal = FND_FAILURE;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                    
                    //  Set explan_data to usRow
                    //##            sprintf(pReturnPB->appl_status.explan_data, "%u", usRow);
                    
                    RetVal = FND_FAILURE;
                    break;
                    
                default :
                    
                    RetVal = FND_FAILURE;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
            usRow++;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc41si.getArchInputStruct() , ccfc41so.getArchOutputStruct());
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
                
                
                //  Call CCMN19D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccfc41so;
    }

    
}
