package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC33SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC33SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC99DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC99DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES91DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES91DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB8DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
**
** Module File:    ccfc33s.src
**
** Service Name:   CCFC33S
**
** Description:   This service will retrieve all the keys necessary to
**                produce a printout of the selected output in the Case
**                File.  It makes dynamic DAM calls because the keys can
**                be retrieved using either Case ID, Stage ID, or Situation
**                ID.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/25/1996
**
** Programmer:    Brenda Wallace
**
** Archive Information: $Revision:   1.7  $
**                      $Date:   23 Sep 1999 09:54:34  $
**                      $Modtime:   23 Sep 1999 09:23:02  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  4/25/96   wallacbe  SIR 20445 - Specify to select all events except NEW
**                      ones on output C130 - Svc Plan Eval
**  5/1/96    wallacbe  SIR 20426 - Removed from History of Inv. (C110)
**                      strcpy(pCDYN19DInputRec->szCdStage, "FPR");
**                      so that keys are returned for all stages for this rpt.
**  5/2/96    wallacbe  SIR #20864 - Changed type to ARI from ARV and added
**                      ARF event type on C490 - Admin Review Findings key
**                      retrieval. SIR #20865 - Added 6150 Task to A050 -
**                      Client Assessment Report key retrieval.
**  5/15/96   wallacbe  Corrected incorrect task code in Risk Assessment
**                      key retrieval.  Changed 9240 (non-existent) to 7185
**                      (FPR Risk Assessment)  (C090)
**  5/21/96   wallacbe  SIR 20623 Changed F060, A060, A110 to retrieve stage
**                      as the key
**  09/04/96  BRUCKMK   SIR 21920: The ulSysNbrUlongKey variable serves as an
**                      indicator whether any "R/O - No Risk" rows were found
**                      in the Risk Factors table for the given ID_STAGE.  If
**                      ulSysNbrUlongKey is greater than zero, then the Risk
**                      Assessment for this stage is of type "R/O - No Risk"
**                      and the Short Form needs to be produced (CINV84S).
**                      The DAM CSES91D was created and added to ccfc33s.src
**                      to retrieve the necessary Row Count. The "if"
**                      condition will switch based on this row count for
**                      each id_stage.
**  10/29/96  durang    Sir 22252 - Added APS_NOTIF_NARR_VIEW
**  05/15/97  GONZALCE  SIR 13618 - MHMR Enhacement:  Request for Review.
**                      Add CINVB8D to retrieve a count on Request for
**                      Review Contacts.
**  05/01/98  KOMARA    MHMR3 Item8.5 - MHMR Enhancement:
**                      Add new referral form
**  08/11/99  SHARMAS   Added DAM CLSC99D to this service.  As of Sept. 1999
**                      all Risk Assessments will be done on Intranet. This
**                      dam is added to check the indicator for Intranet Risk
**                      Assessment.
**  06/18/2001 hafelela IRA Narrative Enhancement (IRA2001) - The IRA
**                      narrative will now be accessible from the Case
**                      File Print window, so code has been added to enable
**                      the narrative to generate and/or print with the
**                      report (through the current Risk Assessment item
**                      on the Case File Print window).
**  10/15/2001 corleysl The Services and Referrals Checklist report will
**                      be accessible from the Case File Print window.
**                      The new item will appear before the Investigation
**                      Conclusion Report in the listbox.  It can be
**                      generated or printed.  This will require changes
**                      within the retrieval service for Case File Print.
** 07/26/05    ANANDV   SIR 23690 - added A220 condition & task code in
**                      (6155,2085,5025) for Case File Print option -
**                      Care Form.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/



/*
** Extern for version control table.
*/






public class Ccfc33s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String RULED_OUT = "R/O";
    
    /* SIR 13618 */
    public static final int REVIEW_CONTACT = 1;
    //## END TUX/XML: Declare XML variables
    
    
    //## BEGIN TUX/XML: Turn the XML buffer into an input message struct
    /* Allocate the Input message that will be used within the service */
    static CCFC33SI pInputMsg = null;
    static CCFC33SO pOutputMsg = null;
    CCFC33SO CCFC33S(CCFC33SI ccfc33si) {
        boolean goto_END = false;
        CCFC33SO ccfc33so = new CCFC33SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i54 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  long            rc = 0;
        boolean bFound = false;
        
        /* Stage retrieve */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /* Case file stage dynamic retrieve */
        CDYN19DI pCDYN19DInputRec = null;
        
        /* Case file event dynamic retrieve */
        CDYN20DI pCDYN20DInputRec = null;
        
        /* Case file person dynamic retrieve */
        CDYN21DI pCDYN21DInputRec = null;
        
        CLSC99DI pCLSC99DInputRec = null;
        CLSC99DO pCLSC99DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccfc33si.getArchInputStruct());
        rc = Cinv17s.CallCINVB8D(ccfc33si, ccfc33so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                break;
                
            case NO_DATA_FOUND:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                break;
        }
        
        
        
        /*
        ** Delete the stage record if the call is an I&R or non-case
        ** related special request.  The stage record may be referenced
        ** by a record call event if the intake has previously submitted
        ** of assigned.  
        **
        ** This is a possible point of referential error.  It is unclear
        ** at the time of unit test if there can/will be ToDo's existing
        ** as well.  If so, deletion of the stage, referenced by a ToDo
        ** will get an error.
        */
        
        /*
        ** SIR #1000 08/01/95 MED 
        ** The logic to clean up events and stages for I&Rs and Non-case
        ** related special requests must be circumvented if the call has
        ** been submitted and we are in approval mode.  The results of 
        ** deleting the event would very, very bad.
        */
        if ((ccfc33si.getArchInputStruct().getCReqFuncCd() == 'T') && (ccfc33si.getUlIdSituation() == 0)) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCINT21DInputRec = new CINT21DI();
            
            pCINT21DOutputRec = new CINT21DO();
            pCINT21DInputRec.setArchInputStruct(ccfc33si.getArchInputStruct());
            pCINT21DInputRec.setUlIdStage(ccfc33si.getUlIdStage());
            
            
            //  Initialize rc for loop
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    ccfc33so.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                    ccfc33si.setUlIdSituation(pCINT21DOutputRec.getUlIdSituation());
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        
        
        /**************/
        /* Set code found indicator to FALSE. */
        bFound = false;
        
        
        if (ccfc33si.getArchInputStruct().getCReqFuncCd() == 'S') {
            ccfc33so.getROWCCFC33SOG01().getUlIdStage_ARRAY().setUlIdStage(0, ccfc33si.getUlIdStage());
        }
        
        /************************************************************************/
        /* Else, situation or case is specified.  Call DAM to retrieve all
        ** stages for input case or situation.
        */
        else {
            
            //  Allocate memory for DAM Input Structure
            pCDYN19DInputRec = new CDYN19DI();
            pCDYN19DInputRec.setArchInputStruct(ccfc33si.getArchInputStruct());
            
            
            
            //  Attempt to delete the call from the temporary workload.
            // This is necessary to account for the case when the user
            // opens a call and immediately SaveandCloses it.
            if (ccfc33si.getArchInputStruct().getCReqFuncCd() == 'C') {
                pCDYN19DInputRec.setUlIdCase(ccfc33si.getUlIdCase());
            }
            else {
                pCDYN19DInputRec.setUlIdSituation(ccfc33si.getUlIdSituation());
            }
            pCDYN19DInputRec.getArchInputStruct().setUsPageNbr(1);
            pCDYN19DInputRec.getArchInputStruct().setUlPageSizeNbr(CDYN19DO._CDYN19DO__ROWCDYN19DO_SIZE);
            
            if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A040")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C040")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C050")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F040")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L040"))) {
                pCDYN19DInputRec.setSzCdStage("INT");
                bFound = true;
            }
            // SARE2001 SLC BEGIN
            // added C095 to the INV stage so that the case file print will work with Situation and Case selections
            else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C095")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A080")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C060")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C070")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C100")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F070")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F170")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F060")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A060")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L050")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F050"))) {
                pCDYN19DInputRec.setSzCdStage("INV");
                bFound = true;
            }
            // SARE2001 SLC BEGIN
            else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A100")) {
                pCDYN19DInputRec.setSzCdStage("SVC");
                bFound = true;
            }
            
            else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C110")) {
                // SIR #20426 - Removed strcpy(pCDYN19DInputRec->szCdStage, "FPR");
                // so that keys are returned for all stages
                bFound = true;
            }
            
            else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C470")) {
                pCDYN19DInputRec.setSzCdStage("PAL");
                bFound = true;
            }
            
            else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C400")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C410")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C420")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C430"))) {
                pCDYN19DInputRec.setSzCdStage("FAD");
                bFound = true;
            }
            
            else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C280")) {
                pCDYN19DInputRec.setSzCdStage("SUB");
                bFound = true;
            }
            
            else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A140")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C500")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C350")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F090")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L070"))) {
                bFound = true;
            }
            
            if (bFound) {
                
                
                //  Call CRES26D
                rc = CallCDYN19D(ccfc33si, ccfc33so, pCDYN19DInputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                goto END;
            }
        }
        
        
        
        /*
        ** Allocate memory for DAM Input Structure
        */
        pCDYN20DInputRec = new CDYN20DI();
        pCDYN20DInputRec.setArchInputStruct(ccfc33si.getArchInputStruct());
        
        if (ccfc33si.getArchInputStruct().getCReqFuncCd() == 'C') {
            pCDYN20DInputRec.setUlIdCase(ccfc33si.getUlIdCase());
        }
        else if (ccfc33si.getArchInputStruct().getCReqFuncCd() == 'T') {
            pCDYN20DInputRec.setUlIdSituation(ccfc33si.getUlIdSituation());
        }
        else {
            pCDYN20DInputRec.setUlIdStage(ccfc33si.getUlIdStage());
        }
        pCDYN20DInputRec.getArchInputStruct().setUsPageNbr(1);
        
        pCDYN20DInputRec.getArchInputStruct().setUlPageSizeNbr(CDYN20DO._CDYN20DO__ROWCDYN20DO_SIZE);
        if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A050")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "5020");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(1, "2080");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(2, "6150");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A090")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "2090");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(1, "6070");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(2, "5030");
            bFound = true;
        }
        
        /*SIR 23690 - added Care Form CASE FILE PRINT */
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A220")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "6155");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(1, "2085");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(2, "5025");
            bFound = true;
            
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C080")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "2300");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C090")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "2290");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(1, "3250");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(2, "8750");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(3, "7185");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(4, "2295");
            // IRA2001 END
            bFound = true;
        }
        
        /* SARE2001 SLC BEGIN */
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C095")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "2326");
            bFound = true;
        }
        /* SARE2001 SLC END */
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C120")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "7060");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(1, "5590");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(2, "4140");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C130")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "7085");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(1, "7090");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(2, "7095");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(3, "4160");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(4, "4170");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(5, "4180");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(6, "5610");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(7, "5620");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(8, "5630");
            pCDYN20DInputRec.getSzCdEventStatus_ARRAY().setSzCdEventStatus(0, "COMP");
            pCDYN20DInputRec.getSzCdEventStatus_ARRAY().setSzCdEventStatus(1, "APRV");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C140")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "7080");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(1, "4150");
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(2, "5600");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A070")) {
            pCDYN20DInputRec.getSzCdTask_ARRAY().setSzCdTask(0, "2120");
            pCDYN20DInputRec.setSzSysTxtTablename("GUAR_DOC_NARR");
            bFound = true;
        }
        
        /********************************************************************
        ** This document (Facility Notification to LE does
        ** not currently exist make sure that the following
        ** code is correct when the document is complete.
        ** Fill in the name of the document blob table
        ** Sir 22252 durang - commented out code
        ** ******************************************************************
        **
        **  else if (strcmp(pInputMsg->szSysCdCaseFilePrntRpt, "F050") == 0)
        **  {
        **    COPYSZ(pCDYN20DInputRec->szCdTask[0], "2450");
        **    COPYSZ(pCDYN20DInputRec->szSysTxtTablename, "APS_NOTIF_NARR_VIEW");
        **    bFound = TRUE;
        **  }
        */
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C450")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "APP");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A110")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "CCL");
            bFound = true;
        }
        
        
        else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A130")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C490")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F080")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L060"))) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "ARI");
            
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(1, "ARF");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C150")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "REM");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C270")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "PLA");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C160")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "CSP");
            pCDYN20DInputRec.getSzCdStage_ARRAY().setSzCdStage(0, "SUB");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C170")) 
        
        
        
        
        
        
        
        {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "CSP");
            pCDYN20DInputRec.getSzCdStage_ARRAY().setSzCdStage(0, "ADO");
            pCDYN20DInputRec.getSzCdStage_ARRAY().setSzCdStage(1, "PAD");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C250")) 
        {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "VIS");
            pCDYN20DInputRec.setSzSysTxtTablename("VISIT_PLAN_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C180")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "COM");
            pCDYN20DInputRec.setSzSysTxtTablename("COMMON_APPL_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C190")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "FCD");
            pCDYN20DInputRec.setSzSysTxtTablename("ELIG_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C200")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "CBS");
            pCDYN20DInputRec.setSzSysTxtTablename("CHILDBKGRND_SUMM_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C220")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "FCA");
            pCDYN20DInputRec.setSzSysTxtTablename("FSTR_CARE_AST_APP_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C230")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "FCR");
            pCDYN20DInputRec.setSzSysTxtTablename("FSTR_CARE_AST_RVW_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C240")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "PPT");
            pCDYN20DInputRec.setSzSysTxtTablename("PPT_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C260")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "VIP");
            pCDYN20DInputRec.setSzSysTxtTablename("VISIT_PLN_SPAN_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C300")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "CRA");
            
            pCDYN20DInputRec.setSzSysTxtTablename("CORR_ACT_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C310")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "DVP");
            pCDYN20DInputRec.setSzSysTxtTablename("DVLP_PLN_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C460")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "CCL");
            pCDYN20DInputRec.setSzSysTxtTablename("FAD_CLOS_SUM_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C320")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "QAS");
            pCDYN20DInputRec.setSzSysTxtTablename("QUART_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C330")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "RVF");
            pCDYN20DInputRec.setSzSysTxtTablename("REVERIF_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C340")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "MAS");
            pCDYN20DInputRec.setSzSysTxtTablename("MONTH_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C360")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "REF");
            pCDYN20DInputRec.setSzSysTxtTablename("REFRL_DOC_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C370")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "VRN");
            pCDYN20DInputRec.setSzSysTxtTablename("VARNCE_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C380")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "SRI");
            pCDYN20DInputRec.setSzSysTxtTablename("SER_INC_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C390")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "VLT");
            pCDYN20DInputRec.setSzSysTxtTablename("VIOLTN_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C290")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "HSG");
            pCDYN20DInputRec.setSzSysTxtTablename("HSEGH_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C440")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "ADS");
            pCDYN20DInputRec.setSzSysTxtTablename("SUB_ELIG_NARR_VIEW");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C210")) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "MDH");
            pCDYN20DInputRec.setSzSysTxtTablename("MED_DVL_HIST_NARR");
            bFound = true;
        }
        
        else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A120")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C480"))) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "AUT");
            bFound = true;
        }
        
        else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C520")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L090")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A160")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F110"))) {
            pCDYN20DInputRec.getSzCdEventType_ARRAY().setSzCdEventType(0, "MED");
            bFound = true;
        }
        
        if (bFound) {
            rc = CallCDYN20D(ccfc33si, ccfc33so, pCDYN20DInputRec, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            goto END;
        }
        
        /*
        ** Allocate memory for DAM Input Structure
        */
        pCDYN21DInputRec = new CDYN21DI();
        pCDYN21DInputRec.setArchInputStruct(ccfc33si.getArchInputStruct());
        if (ccfc33si.getArchInputStruct().getCReqFuncCd() == 'C') {
            
            pCDYN21DInputRec.setUlIdCase(ccfc33si.getUlIdCase());
        }
        else if (ccfc33si.getArchInputStruct().getCReqFuncCd() == 'T') {
            pCDYN21DInputRec.setUlIdSituation(ccfc33si.getUlIdSituation());
        }
        else {
            pCDYN21DInputRec.setUlIdStage(ccfc33si.getUlIdStage());
        }
        
        pCDYN21DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCDYN21DInputRec.getArchInputStruct().setUlPageSizeNbr(CDYN21DO._CDYN21DO__ROWCDYN21DO_SIZE);
        
        if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A170")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A180")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F120")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F130"))) {
            pCDYN21DInputRec.getSzCdStagePersRole_ARRAY().setSzCdStagePersRole(0, "VC");
            pCDYN21DInputRec.getSzCdStagePersRole_ARRAY().setSzCdStagePersRole(1, "DV");
            pCDYN21DInputRec.getSzCdStagePersRole_ARRAY().setSzCdStagePersRole(2, "VP");
            pCDYN21DInputRec.getSzCdStagePersRole_ARRAY().setSzCdStagePersRole(3, "DB");
            pCDYN21DInputRec.getSzCdStagePersRole_ARRAY().setSzCdStagePersRole(4, "CL");
            bFound = true;
        }
        
        else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A150")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A190")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A200")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C510")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C580")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C590")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F100")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F140")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F150")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L080")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L130")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L140"))) {
            pCDYN21DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(0, "COL");
            pCDYN21DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(1, "PRN");
            bFound = true;
        }
        
        else if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C530")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C540")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C550")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L100")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L110")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L120"))) {
            pCDYN21DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(0, "PRN");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C560")) {
            pCDYN21DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(0, "PRN");
            pCDYN21DInputRec.setSzSysTxtTablename("INIT_CHLD_DTH_NARR");
            bFound = true;
        }
        
        else if (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C570")) {
            pCDYN21DInputRec.getSzCdStagePersType_ARRAY().setSzCdStagePersType(0, "PRN");
            pCDYN21DInputRec.setSzSysTxtTablename("CHLD_DTH_COMM_NARR");
            bFound = true;
        }
        if (bFound) {
            rc = CallCDYN21D(ccfc33si, ccfc33so, pCDYN21DInputRec, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            goto END;
        }
        if ((ccfc33si.getSzSysCdCaseFilePrntRpt().equals("A210")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("C600")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("F160")) || (ccfc33si.getSzSysCdCaseFilePrntRpt().equals("L150"))) {
            
            
            //  Initialize rc for loop
            rc = CallCDYN22D(ccfc33si, ccfc33so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            goto_END = true;
            //  If ADD, copy the new ID_ALLEGATION that was created in CINV71D -
            // FAC ALLEG DTL AUD from the DAM output message into the service
            // input message. It will be passed to CINV09DI - SAVE INJ LIST/DTL.
        }
        
        if (!(goto_END)) {
            
            if (ccfc33so.getROWCCFC33SOG01().getUlIdStage_ARRAY().getUlIdStage(i54) == 0) {
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_ERR_BAD_FUNC_CD;
            }
            
            // 
            // Prepare output message to be returned and return
            // 
            
            
            ARC_PRFServiceStopTime_TUX(ccfc33si.getArchInputStruct() , ccfc33so.getArchOutputStruct());
        }
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                //Do not commit as it will be committed in the called service.
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Call CAUD54D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccfc33so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = CCFC33S_XLT_OUT;
        pOutputMsgTransMap.map_version = WtcHelperConstants.MAP_VERSION;
        
        
        
        ARC_PRFServiceStopTime_TUX(pInputMsg.getArchInputStruct() , pOutputMsg.getArchOutputStruct());
        
        return SUCCESS;
    }

    static int CallCDYN19D(CCFC33SI * pInputMsg48, CCFC33SO pOutputMsg51, CDYN19DI pCDYN19DInputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        CDYN19DO pCDYN19DOutputRec = null;
        int i55 = 0;
        int rc = 0;
        
        
        /*
        ** Allocate memory for DAM Output Structure
        */
        pCDYN19DOutputRec = new CDYN19DO();
        rc = cdyn19dQUERYdam(sqlca, pCDYN19DInputRec, pCDYN19DOutputRec);
        
        
        /*
        ** Analyze return code for CCMN06U
        */
        switch (rc) {
                
                // SIR 997: added a case statement
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCDYN19DOutputRec.getArchOutputStruct().getBMoreDataInd() == true) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CFC_VIEW_TOO_LARGE;
                    rc = Messages.MSG_CFC_VIEW_TOO_LARGE;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                //  Populate Output Message
                
                for (i55 = 0;i55 < pCDYN19DOutputRec.getArchOutputStruct().getUlRowQty();i55++) {
                    pOutputMsg51.getROWCCFC33SOG01().getUlIdStage_ARRAY().setUlIdStage(i55, pCDYN19DOutputRec.getROWCDYN19DO_ARRAY().getROWCDYN19DO(i55).getUlIdStage());
                }
                break;
                //  If successful, no errors are returned
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCDYN20D(CCFC33SI pInputMsg49, CCFC33SO pOutputMsg52, CDYN20DI pCDYN20DInputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** SIR 21920:
        ** Added CSES91D for Risk Assessment Short Form Enhancement
        ** Added CLSC99D for Risk Assessment Intranet Indicator
        */
        
        CLSC99DI pCLSC99DInputRec = null;
        CLSC99DO pCLSC99DOutputRec = null;
        CSES91DI pCSES91DInputRec = null;
        CSES91DO pCSES91DOutputRec = null;
        CDYN20DO pCDYN20DOutputRec = null;
        int i56 = 0;
        int rc = 0;
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES91DInputRec = new CSES91DI();
        
        pCSES91DOutputRec = new CSES91DO();
        /*
        ** SIR 12693, 11/25/96 - All memory for the DAM output records will be
        **      allocated and initialized at the beginning of the service and
        **      freed at the end of the service. This prevents the freeing of
        **      unallocated memory resulting in server kills.
        */
        pCLSC99DInputRec = new CLSC99DI();
        
        pCLSC99DOutputRec = new CLSC99DO();
        /*
        ** Allocate memory for DAM Output Structure
        */
        pCDYN20DOutputRec = new CDYN20DO();
        
        /*
        ** Call DAM
        */
        rc = cdyn20dQUERYdam(sqlca, pCDYN20DInputRec, pCDYN20DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCDYN20DOutputRec.getArchOutputStruct().getBMoreDataInd() == true) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CFC_VIEW_TOO_LARGE;
                    rc = Messages.MSG_CFC_VIEW_TOO_LARGE;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                //  Populate Output Message
                
                for (i56 = 0;i56 < pCDYN20DOutputRec.getArchOutputStruct().getUlRowQty();i56++) {
                    pOutputMsg52.getROWCCFC33SOG01().getUlIdStage_ARRAY().setUlIdStage(i56, pCDYN20DOutputRec.getROWCDYN20DO_ARRAY().getROWCDYN20DO(i56).getUlIdStage());
                    pOutputMsg52.getROWCCFC33SOG02().getUlIdEvent_ARRAY().setUlIdEvent(i56, pCDYN20DOutputRec.getROWCDYN20DO_ARRAY().getROWCDYN20DO(i56).getUlIdEvent());
                    pCSES91DInputRec.setArchInputStruct(pInputMsg49.getArchInputStruct());
                    pCSES91DInputRec.setSzCdRiskFactorCateg(RULED_OUT);
                    pCSES91DInputRec.setUlIdEvent(pCDYN20DOutputRec.getROWCDYN20DO_ARRAY().getROWCDYN20DO(i56).getUlIdEvent());
                    
                    //  Call DAM
                    rc = cses91dQUERYdam(sqlca, pCSES91DInputRec, pCSES91DOutputRec);
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            
                            if (pCSES91DOutputRec.getUlSysNbrUlongKey() == 0) {
                                pOutputMsg52.getROWCCFC33SOG02().getUlSysNbrUlongKey_ARRAY().setUlSysNbrUlongKey(i56, 0);
                            }
                            else {
                                pOutputMsg52.getROWCCFC33SOG02().getUlSysNbrUlongKey_ARRAY().setUlSysNbrUlongKey(i56, pCSES91DOutputRec.getUlSysNbrUlongKey());
                            }
                            pCLSC99DInputRec.setArchInputStruct(pInputMsg49.getArchInputStruct());
                            pCLSC99DInputRec.setUlIdEvent(pCDYN20DOutputRec.getROWCDYN20DO_ARRAY().getROWCDYN20DO(i56).getUlIdEvent());
                            
                            if (pInputMsg49.getSzSysCdCaseFilePrntRpt().equals("C090")) {
                                //  nothing to do
                                rc = clsc99dQUERYdam(sqlca, pCLSC99DInputRec, pCLSC99DOutputRec);
                            }
                            switch (rc) {
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pOutputMsg52.setCIndRiskAssmtIntranet(pCLSC99DOutputRec.getCIndRiskAssmtIntranet());
                                    
                                    break;
                                    
                                default :
                                    
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    
                                    break;
                            }
                            
                            break;
                            
                        default :
                            //   PROCESS_TUX_SQL_ERROR_TRANSACT is called only when there is an unexpected
                            // SQL error returned from the DAM.
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        return rc;
    }

    static int CallCDYN21D(CCFC33SI * pInputMsg50, CCFC33SO pOutputMsg53, CDYN21DI pCDYN21DInputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        CDYN21DO pCDYN21DOutputRec = null;
        int i57 = 0;
        int rc = 0;/* Return code */
        
        
        /*
        ** Allocate memory for DAM Output Structure
        */
        pCDYN21DOutputRec = new CDYN21DO();
        rc = cdyn21dQUERYdam(sqlca, pCDYN21DInputRec, pCDYN21DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                // 01/22/2003 DWW: Added for error handling
                if (pCDYN21DOutputRec.getArchOutputStruct().getBMoreDataInd() == true) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CFC_VIEW_TOO_LARGE;
                    //  SSN is unique
                    rc = Messages.MSG_CFC_VIEW_TOO_LARGE;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                //  Populate Output Message
                
                for (i57 = 0;i57 < pCDYN21DOutputRec.getArchOutputStruct().getUlRowQty();i57++) {
                    pOutputMsg53.getROWCCFC33SOG03().getUlIdPerson_ARRAY().setUlIdPerson(i57, pCDYN21DOutputRec.getROWCDYN21DO_ARRAY().getROWCDYN21DO(i57).getUlIdPerson());
                }
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCDYN22D(CCFC33SI pInputMsg51, CCFC33SO pOutputMsg54, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        CDYN22DI pCDYN22DInputRec = null;
        CDYN22DO pCDYN22DOutputRec = null;
        int i58 = 0;
        int rc = 0;/* Return code */
        
        
        /*
        ** Allocate memory for DAM Input Structure
        */
        pCDYN22DInputRec = new CDYN22DI();
        
        
        /*
        ** Allocate memory for DAM Output Structure
        */
        pCDYN22DOutputRec = new CDYN22DO();
        pCDYN22DInputRec.setArchInputStruct(pInputMsg51.getArchInputStruct());
        
        /* Return if InvalidateAprvl() failed. */
        if (pInputMsg51.getArchInputStruct().getCReqFuncCd() == 'C') {
            pCDYN22DInputRec.setUlIdCase(pInputMsg51.getUlIdCase());
        }
        else if (pInputMsg51.getArchInputStruct().getCReqFuncCd() == 'T') {
            pCDYN22DInputRec.setUlIdSituation(pInputMsg51.getUlIdSituation());
        }
        else {
            pCDYN22DInputRec.setUlIdStage(pInputMsg51.getUlIdStage());
            
        }
        pCDYN22DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCDYN22DInputRec.getArchInputStruct().setUlPageSizeNbr(CDYN22DO._CDYN22DO__ROWCDYN22DO_SIZE);
        
        /*
        ** Set rc to RetVal so TUX_CHECK_APPL_STATUS will work
        */
        rc = cdyn22dQUERYdam(sqlca, pCDYN22DInputRec, pCDYN22DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  IMPACT BEGIN - Don't demote events when in "Approver mode"
                if (pCDYN22DOutputRec.getArchOutputStruct().getBMoreDataInd() == true) {
                    pServiceStatus.severity = FND_SEVERITY_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CFC_VIEW_TOO_LARGE;
                    rc = Messages.MSG_CFC_VIEW_TOO_LARGE;
                }
                
                else {
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                //  Populate Output Message
                
                for (i58 = 0;i58 < pCDYN22DOutputRec.getArchOutputStruct().getUlRowQty();i58++) {
                    pOutputMsg54.getROWCCFC33SOG04().getUlIdCrimHist_ARRAY().setUlIdCrimHist(i58, pCDYN22DOutputRec.getROWCDYN22DO_ARRAY().getROWCDYN22DO(i58).getUlIdCrimHist());
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set rc to RetVal so TUX_CHECK_APPL_STATUS will work
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINVB8D(CCFC33SI pInputMsg52, CCFC33SO pOutputMsg55, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINVB8DI pCINVB8DInputRec = null;
        CINVB8DO pCINVB8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB8DInputRec = new CINVB8DI();
        
        pCINVB8DOutputRec = new CINVB8DO();
        pCINVB8DInputRec.setUlIdStage(pInputMsg52.getUlIdStage());
        rc = cinvb8dQUERYdam(sqlca, pCINVB8DInputRec, pCINVB8DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (pCINVB8DOutputRec.getDtDTContactOccurred().year != DateHelper.NULL_DATE) {
                    pOutputMsg55.setUlNbrReviewContact(REVIEW_CONTACT);
                    
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        
        return rc;
    }

}
