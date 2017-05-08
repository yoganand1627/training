package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT99SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT99SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT40DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT40DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT73DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT73DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
/**************************************************************************
** 
** Module File:   cint99s.src
**
** Service Name:  cint99s
**
** Description:   Predisplay service for CINT15W Priority/Closure window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09 Feb 1995
** 
** Programmer:    Robert M. Laskey / Andersen Consulting
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   21 Aug 1998 14:26:44  $
**                      $Modtime:   19 Aug 1998 16:18:50  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/09/95  laskeyrm  File Created.          
**  04/15/95  laskeyrm  Code review modifications -- code beautification
**                      and malloc() return value checking added.
**  04/18/95  laskeyrm  Changed ARC_ERR_FATAL_RETURN to
**                      ARC_ERR_INTERNAL_ERROR.
**  10/23/95    KRD     SIR 1664 - Added call to DAM CINT73D to check if a
**                      Notification to Reporter has previously been done.
**                      Other general modifications to match the Release 1.x
**                      service shell.  
**  11/29/95  maxhamkj  SIR 1993:  Before svc exit, 
**                      call GetDateAndTime and populate output 
**                      message accordingly
**  07/26/96  zabihin   sir 21891 : version control code was missing, I
**                      added the lines.
**  08/11/98  RIOSJA    MHMR Phase III Issue 1 - Call CINV34D DAM to
**                      determine if there are multiple reporters for the
**                      case. If there is only one reporter for the case,
**                      pass the reporter's person id and full name back to
**                      the calling window. If there are multiple reporters,
**                      do not pass any reporter information back to the
**                      calling window.
**  4/25/03   douglacs	Added string constant FORM_LETTER_DESCRIP so that
**                      event description would be formatted correctly.
**  10/06/03  CASDORJM  JMC - Added logic to trim the event description
**                      for "Notification to Reporter:" so blank reporter
**                      names would not mess up the SQL.
**  03/31/04  OCHUMD    Sir 22422 - Added code to strncat the reporter's name suffix
**                      to the TxtEventDescr.  Also added code to seperate 
**                      name and suffix by one space.  Moreover, added a flag to determine
**                      when to break from cint73d loop so that the memory can be freed.
**
**
** Function List  Description
** -------------  ----------------
** CINT99S        Retrieve service.
** CallCINT40D    Calls STAGE table retrieve DAM.
** CallCINV34D    Calls the DAM to determine if there are multiple reporters
**                for the case.
** CallCINT73D    Determines whether or not a Notification to Reporter has
**                been completed for each reporter in the case.
** Populate99SO   Populates service output message.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint99s {
    
    public static final String EVENT_COMPLETE = "COMP";
    public static final String NOTIF_REPORTER_TASK_CODE = "1047";
    /*
    ** MHMR Phase III Issue 1 (RIOSJA)
    */
    public static final String STAFF_PERSON = "STF";
    public static final int PAGE_SIZE_NBR = 50;
    //douglacs 4/25/03 - added for correct formatting of event description
    public static final String FORM_LETTER_DESCRIP = "Form Letter Sent to Reporter: ";
    CINT99SO CINT99S(CINT99SI cint99si) {
        CINT99SO cint99so = new CINT99SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        CINV34DO pCINV34DOutputRec = new CINV34DO();
        rc = Ccmn80s.CallCINT40D(cint99si, cint99so, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                //  Declare FOUNDATION variables
                
                //  Declare local variables
                
                //  Start performance timer for service. All performance functions always
                // return success so there is no need to check status.
                rc = Cinv20s.CallCINV34D(cint99si, cint99so, pCINV34DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  SIR 21891 - added check for Run-time Versioning
                
                //  Check buffer size
                
                //  Process error message and return to client
                
                //  Initialize output message and length
                
                //  Initialize service status fields
                
                // 
                // Call DAMs to retrieve data
                // 
                rc = CallCINT73D(cint99si, cint99so, pCINV34DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
            default :
                
                //## BEGIN TUX/XML: Declare XML variables 
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        rc = ARC_UTLGetDateAndTime(cint99so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint99si.getArchInputStruct() , cint99so.getArchOutputStruct());
        
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
        return cint99so;
    }

    static int CallCINT40D(CINT99SI pInputMsg492, CINT99SO pOutputMsg450, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINT40DI pRetrvDamInput = null;
        CINT40DO pRetrvDamOutput = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pRetrvDamInput = new CINT40DI();
        
        pRetrvDamOutput = new CINT40DO();
        pRetrvDamInput.setUlIdStage(pInputMsg492.getUlIdStage());
        pRetrvDamInput.setArchInputStruct(pInputMsg492.getArchInputStruct());
        rc = cint40dQUERYdam(sqlca, pRetrvDamInput, pRetrvDamOutput);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                Populate99SO(pOutputMsg450, pRetrvDamOutput);
                
                
                //  Initialize rc for loop
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                
                //  Call CAUD86D
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int Populate99SO(CINT99SO pDst, CINT40DO pSrc) {
        pDst.getStageRow().setUlIdStage(pSrc.getUlIdStage());
        pDst.getStageRow().setUlIdSituation(pSrc.getUlIdSituation());
        pDst.getStageRow().setUlIdCase(pSrc.getUlIdCase());
        pDst.getStageRow().setBIndStageClose(pSrc.getBIndStageClose());
        pDst.getStageRow().setUlIdUnit(pSrc.getUlIdUnit());
        pDst.getStageRow().setSzCdStage(pSrc.getSzCdStage());
        pDst.getStageRow().setSzCdStageClassification(pSrc.getSzCdStageClassification());
        pDst.getStageRow().setSzCdStageCnty(pSrc.getSzCdStageCnty());
        pDst.getStageRow().setSzCdStageProgram(pSrc.getSzCdStageProgram());
        pDst.getStageRow().setSzCdStageReasonClosed(pSrc.getSzCdStageReasonClosed());
        pDst.getStageRow().setSzCdStageRegion(pSrc.getSzCdStageRegion());
        
        pDst.getStageRow().setSzCdStageRsnPriorityChgd(pSrc.getSzCdStageRsnPriorityChgd());
        pDst.getStageRow().setSzCdStageType(pSrc.getSzCdStageType());
        pDst.getStageRow().setSzCdStageCurrPriority(pSrc.getSzCdStageCurrPriority());
        pDst.getStageRow().setSzCdStageInitialPriority(pSrc.getSzCdStageInitialPriority());
        pDst.getStageRow().setSzTxtStagePriorityCmnts(pSrc.getSzTxtStagePriorityCmnts());
        pDst.getStageRow().setSzTxtStageClosureCmnts(pSrc.getSzTxtStageClosureCmnts());
        pDst.getStageRow().setSzNmStage(pSrc.getSzNmStage());
        
        //## BEGIN TUX/XML: Declare XML variables
        pDst.getStageRow().setDtDtStageClose(pSrc.getDtDtStageClose());
        pDst.getStageRow().setDtDtStageStart(pSrc.getDtDtStageStart());
        pDst.getStageRow().setTsLastUpdate(pSrc.getTsLastUpdate());
        pDst.getStageRow().setTmSysTmStageClose(pSrc.getTmSysTmStageClose());
        pDst.getStageRow().setTmSysTmStageStart(pSrc.getTmSysTmStageStart());
        pDst.setArchOutputStruct(pSrc.getArchOutputStruct());
        return 0;
    }

    static int CallCINT73D(CINT99SI pInputMsg493, CINT99SO pOutputMsg451, CINV34DO pCINV34DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT73DI pCINT73DInputRec = null;
        CINT73DO pCINT73DOutputRec = null;
        int i277 = 0;
        /* 
        ** ochumd 03/31/04 - Added to facilitate correct exit from loop.
        */
        char error_exit = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT73DInputRec = new CINT73DI();
        
        pCINT73DOutputRec = new CINT73DO();
        pCINT73DInputRec.setArchInputStruct(pInputMsg493.getArchInputStruct());
        pOutputMsg451.setBSysIndGeneric(true);
        
        /*
        ** MHMR Phase III Issue 1 (RIOSJA) - Determine whether or not a
        ** Notification to Reporter has been generated for each reporter
        ** found in CallCINV34D. This is done be searching for a completed
        ** notification event using the appropriate event description as
        ** the search criteria.
        */
        for (i277 = 0;i277 < pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();i277++) {
            
            if (error_exit) {
                break;
            }
            if ('Y' == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i277).getBIndStagePersReporter()) {
                pCINT73DInputRec.setUlIdStage(pInputMsg493.getUlIdStage());
                pCINT73DInputRec.setSzCdEventStatus(pInputMsg493.getSzCdEventStatus());
                pCINT73DInputRec.setSzCdEventType(pInputMsg493.getSzCdEventType());
                pCINT73DInputRec.setSzTxtEventDescr(FORM_LETTER_DESCRIP);
                strncat(pCINT73DInputRec.getSzTxtEventDescr() , pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i277).getSzNmPersonFull() , Ccmn85s.NM_PERSON_FULL_LEN);
                strncat(pCINT73DInputRec.getSzTxtEventDescr() , " ", 1);
                //   ochumd - Sir 22422 When the report's name has a suffix, the suffix was not being
                // strncat to the TxtEventDescr. Also a space exist between the full name 
                // and the suffix.  Hence the code below.
                strncat(pCINT73DInputRec.getSzTxtEventDescr() , pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i277).getSzCdPersonSuffix() , CINV58DO.SZCDPERSONSUFFIX_LEN);
                pCINT73DInputRec.setSzTxtEventDescr(trim(pCINT73DInputRec.getSzTxtEventDescr()));
                rc = cint73dQUERYdam(sqlca, pCINT73DInputRec, pCINT73DOutputRec);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        
                        pOutputMsg451.setBSysIndGeneric(true);
                        
                        
                        
                        //  Start Performance Timer
                        
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                    case NO_DATA_FOUND:
                        pOutputMsg451.setBSysIndGeneric(false);
                        
                        
                        
                        //  Initialize Service Status Fields
                        
                        
                        
                        //  Perform Main Processing
                        
                        //  Set CSUB29SO WCD DtSystemDate to current date
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        
                        //  If even one reporter is found for whom a Notification
                        // to Reporter has not been generated, the indicator in
                        // the output message must remain FALSE. Since this is the
                        // case, there is no reason to continue the for loop for
                        // the other reporters.
                        error_exit = 1;
                        return rc;
                        
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        break;
                }
            }
        }
        return rc;
    }

    static int CallCINV34D(CINT99SI pInputMsg494, CINT99SO pOutputMsg452, CINV34DO pCINV34DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* 
        ** Declare local variables
        */
        int iNumOfReporters = 0;
        int i278 = 0;
        /*
        ** MHMR Phase III Issue 1 (RIOSJA) - The output structure for this
        ** DAM is declared globally in the main program. Only the input
        ** structure will be declared here.
        */
        CINV34DI pCINV34DInputRec = new CINV34DI();
        pCINV34DInputRec.setArchInputStruct(pInputMsg494.getArchInputStruct());
        pCINV34DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCINV34DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NBR);
        pCINV34DInputRec.setUlIdStage(pInputMsg494.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(STAFF_PERSON);
        
        /*
        ** Call DAM
        */
        rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  A list of all persons in the case was retrieved. Search
                // through the list to determine if there are multiple
                // reporters.
                for (i278 = 0;i278 < pCINV34DOutputRec.getArchOutputStruct().getUlRowQty();i278++) {
                    
                    if ('Y' == pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i278).getBIndStagePersReporter()) {
                        iNumOfReporters++;
                        
                        if (iNumOfReporters == 1) {
                            pOutputMsg452.setUlIdPerson(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i278).getUlIdPerson());
                            pOutputMsg452.setSzNmPersonFull(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i278).getSzNmPersonFull());
                            pOutputMsg452.getSzNmPersonFull() += " " + pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i278).getSzCdPersonSuffix();
                            pOutputMsg452.setSzNmPersonFull(trim(pOutputMsg452.getSzNmPersonFull()));
                        }
                        //  If this reporter is the second or subsequent reporter
                        // found, clear the variables in the service output
                        // message that would contain the reporter's person id
                        // and full name. If these fields are empty upon
                        // returning to the window, the window logic will
                        // function accordingly for multiple reporters.
                        else {
                            pOutputMsg452.setUlIdPerson(0);
                            pOutputMsg452.setSzNmPersonFull(null);
                        }
                    }
                }
                pOutputMsg452.getArchOutputStruct().setUlRowQty(iNumOfReporters);
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        return rc;
    }

}
