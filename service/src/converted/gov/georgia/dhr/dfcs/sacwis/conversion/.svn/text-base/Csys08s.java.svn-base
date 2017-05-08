package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS14DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS04DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS04DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV17DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVB8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVB8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINVC8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINVC8DO;
/**************************************************************************
**
** Module File:   CSYS08S.src
**
** Service Name:  Retrieval
**
** Description:   Retrieval service for Contact Detail window.
**                ( CSYS10W )
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  1/6/95
**
** Programmer:    Matthew Fish, Andersen Consulting
**                R. Michael Smith, Andersen Consulting
**
** Function List
** -------------
** CallCSYS04D() -- Calls CONTACT table dynamic Search/List DAM.
** CallCSYS08D() -- Calls EVENT_PERSON_LINK retrieval DAM.
** CallCSYS11D() -- Calls CONTACT/EVENT joint retrieval DAM.
** CallCSYS13D() -- Calls dynamic NARRATIVE table retrieval DAM.(DoesBlobXist).
** CallCSYS14D() -- Calls STAGE_PERSON_LINK retrieval DAM.( Gets Primary
**                  Caseworker ).
** CallCCMN45D() -- Calls EVENT retrieval DAM.
** CallCINT21D() -- Calls STAGE retrieval DAM.
** CallCINV34D() -- Calls STAGE_PERSON_LINK retrieval DAM. ( Input = Type ).
** CallCCMN87D() -- Calls EVENT search DAM. ( Input = Type ).
**
**
** Date         User      Description
** ----         ----      -----------
** 06/06/95     laskeyrm  -Cleaned up code: Indentation, unused variables, etc,
**                         Replaced parameter list withTUX_STATUSPARMS.
**                        -Modified error handling significantly.
**                        -Added check for failed malloc().
**                        -Added function headers and in-line comments. Put
**                         constants on left side of equality comparisons.
**                        -Added logic to handle the 'Contacted By' ID_PERSON.
**                         This ID is now being placed in the EVENT_PERSON_LINK
**                         table. [CallCSYS08D()]
**                        -Removed Principal/Collateral ListBox sorting code.
**                         [CallCINV34D()]
**
** 06/13/95     laskeyrm  -Added population of ulIdStage in Input record
**                        for csys11dQUERYdam() in CallCSYS11D(). Don't
**                        know why this was left out ...
**                        -Moved constants to servdeli.h.
**
** 06/15/95     laskeyrm  Added a call to DAM ccmn87d to attempt to find
**                        a Stage Conclusion Event that is Pending Approval.
**                        The client acted as if this was being done -- it
**                        wasn't. Did some more error handling clean up.
**
** 07/31/95 maxhamkj  SIR 903: If window entered in new mode, then
**                        retrieve current time along with current date
**     Added second time element so that service can
**     return both the time of Contact record creation
**     and the current time, to be stored in the WCD.
**
** 09/12/95  bruckmk   SIR 1324: Changed cIndContactOccurred to
**                         cSysIndContactOccurred.
**
** 10/02/95  bruckmk   SIR 1482: Create ToDo and Contact Shell for first
**        Face to Face Contact only if the Stage
**        Classification is APS Community.  Added Retrieve
**        Stage Classification Column in Retrieve service;
**        added "szCdStageClassification" to Retrieve Output
**        Message, Save Input Message and Window WCD; added
**        if statement to check for classification code
**        before creating shell.
**
** 10/18/95  bruckmk   SIR 1829: Need to pop up Pending Event Message for New
**         Contacts and Med/Mental Assessments for a stage that
**        has been submitted for closure.  The closure event for
**        Service Delivery has a type of SVC_CD_EVENT_TYPE_CLOSE
**        as opposed to SVC_CD_EVENT_TYPE_CONCL for
**        Investigation.  For Med/Mental: Also added DAM CINT21D
**        for stage retrieval to get CD_STAGE.  Added temporary
**        szCdStage variable to store the retrieved stage
**        information throughout the service.
**
** 02/18/97  odonnerj  SIR# 10717 - Added Switch and case
**        MSG_NO_TASK_AVAIL_SAVE_INT_NOW  after call to cint21d. In certain
**        cases, (Alt F4) an Intake may have no data on the stage table, but
**        worker can open the Intake through the task list and try to click
**        on the Contacts/Summaries Task. When this happens, we need the
**        Intake re-opened so that it can be saved properly.
**
**  05/08/97  GONZALCE  SIR 13618/MHMR Enhancement:  Request for Review
**                      Added CINV17D to the service to retrieve the
**                      indFacilSuperintNofif from the Facility_invst_dtl
**                      table and pass it in the pOutputMsg. Also added
**                      CINVB8D  to determine if a Request for Review contact
**                      was recorded.
**  07/01/97  PHILLILH  SIR 14101 - Only call CINV17D and CINVB9D when the
**                      Stage Program is AFC and the Stage is INV to
**                      prevent a Data Access error when other stages use
**                      the contact window.  These two DAMs retrieve AFC
**                      INV specific information from Facility Tables.
**
**
** 12/03/97  PAULS     SIR 14235 - Added 1 dam to this service to retrieve the
**                     Start date. This is then passed to the Contact Detail
**                     Window . The Intake Start Date is used on the COntact
**                     Detail Window to check if the Contact date is earlier
**                     than this Intake Start Date.
**
** 04/30/03  Srini     SIR 17091: Added the error handling to take care of full
**					   table scans for ccmn87dQUERYdam.
**
** 06/09/03  Srini     SIR 18128: Populated the dams csys04d and csys13d with the
**					   szUserId so that it gets logged in the audit log.
** 07/22/04  DOUGLACS  SIR 22860 - removed if statement, so that dtIntStart would
**                     be populated for all programs.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csys08s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int INITIAL_PAGE = 1;
    public static final String NULL_STRING = "";
    public static final String NARRATIVE_TXT_DESCR = "NARRATIVE";
    public static final int SYSTEM_TIME = 1;
    public static final int CONTACT_REC_CREATED = 0;
    public static final String INVEST = "INV";
    public static final String SERVICE_DELIVERY = "SVC";
    public static final String FAMILY_PLAN = "FPR";
    public static final String INVESTIGATION = "INV";
    public static final String AFC_STAGE = "AFC";
    /* SIR 13618 */
    public static final int REVIEW_CONTACT = 1;
    
    /* SIR 14235 */
    
    public static final String INTAKE = "INT";
    public static final String APS_STAGE = "APS";
    //## END TUX/XML: Declare XML variables 
    
    
    //## BEGIN TUX/XML: Turn the XML buffer into an input message struct 
    /* Allocate the Input message that will be used within the service */
    static CSYS08SI pInputMsg = null;
    static CSYS08SO pOutputMsg = null;
    CSYS08SO CSYS08S(CSYS08SI csys08si) {
        CSYS08SO csys08so = new CSYS08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        FndInt3date dtTempDTStageStart = null;
        rc = ARC_PRFServiceStartTime_TUX(csys08si.getArchInputStruct());
        rc = Ccmn13s.CallCINT21D(csys08si, csys08so, pServiceStatus, dtTempDTStageStart);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = CallCSYS04D(csys08si, csys08so, pServiceStatus, dtTempDTStageStart);
        if (rc != WtcHelperConstants.SQL_SUCCESS && rc != NO_DATA_FOUND) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        
        /* Retrieve user info  */
        rc = Cinv01s.CallCINV34D(csys08si, csys08so, pServiceStatus);
        
        /*
        ** Populate DAM Input Structure
        */
        if (rc != WtcHelperConstants.SQL_SUCCESS && rc != NO_DATA_FOUND) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Call CDYN19D if case file code matches those that need intake stages
        */
        
        if (0 != csys08si.getUlIdEvent()) {
            
            // Retrieve all current temporary assignments and assign security
            // profile
            rc = Ccmn01u.CallCCMN45D(csys08si, csys08so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            rc = Csys07s.CallCSYS11D(csys08si, csys08so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    
                    
                    // 
                    //  If the report Code was found in the above set, the DAM input struct
                    // is fully populated.  Call CDYN19D, which will populate the service
                    // output message, then exit the service.
                    if (0 != csys08so.getROWCCMN45DO().getSzCdEventStatus().substring(0, CSYS08SO.CD_EVENT_STATUS_LEN).compareTo(SVC_CD_EVENT_STATUS_NEW.substring(0, CSYS08SO.CD_EVENT_STATUS_LEN))) {
                        pServiceStatus.severity = FND_WARNING;
                        pServiceStatus.explan_code = NO_DATA_FOUND;
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
            if (0 != csys08so.getROWCCMN45DO().getSzCdEventStatus().substring(0, CSYS08SO.CD_EVENT_STATUS_LEN).compareTo(SVC_CD_EVENT_STATUS_NEW.substring(0, CSYS08SO.CD_EVENT_STATUS_LEN))) {
                rc = CallCSYS08D(csys08si, csys08so, pServiceStatus);
                
                //  Populate DAM Input Structure
                if (rc != WtcHelperConstants.SQL_SUCCESS && rc != NO_DATA_FOUND) {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            // Retrieve all current temporary assignments and assign security
            // profile
            rc = Cinv27s.CallCSYS13D(csys08si, csys08so, pServiceStatus);
            
            //  Call CDYN20D if case file code matches those that needing events
            
            if (rc != WtcHelperConstants.SQL_SUCCESS && rc != NO_DATA_FOUND) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        /************************************************/
        /*
        ** If the report Code was found in the above set, the DAM input struct
        ** is fully populated.  Call CDYN20D, which will populate the service
        ** output message, then exit the service.
        */
        if ((0 == csys08si.getUlIdEvent()) || (0 == csys08so.getROWCCMN45DO().getSzCdEventStatus().substring(0, CSYS08SO.CD_EVENT_STATUS_LEN).compareTo(SVC_CD_EVENT_STATUS_NEW.substring(0, CSYS08SO.CD_EVENT_STATUS_LEN)))) {
            rc = CallCSYS14D(csys08si, csys08so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    rc = 0;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
        }
        
        /*
        ** Call DAM
        */
        rc = Ccmn02u.CallCCMN87D(csys08si, csys08so, pServiceStatus);
        if (rc != WtcHelperConstants.SQL_SUCCESS && rc != NO_DATA_FOUND) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Populate DAM Input Structure
        */
        if ((0 == csys08so.getSzCdStageProgram().compareTo(AFC_STAGE)) && (0 == csys08so.getSzCdStage().compareTo(INVESTIGATION))) {
            
            rc = Cinv17s.CallCINV17D(csys08si, csys08so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
            rc = Ccfc33s.CallCINVB8D(csys08si, csys08so, pServiceStatus);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    
                    
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
            }
        }
        rc = CallCINVC8D(csys08si, csys08so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        rc = ARC_UTLGetDateAndTime(csys08so.getDtWCDDtSystemDate() , csys08so.getTmScrTmCntct_ARRAY().getTmScrTmCntct(SYSTEM_TIME));
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(csys08si.getArchInputStruct() , csys08so.getArchOutputStruct());
        
        /*
        ** Call CDYN21D if case file code matches those that needing it.
        */
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            // 
            //  If the report Code was found in the above set, the DAM input struct
            // is fully populated.  Call CDYN21D, which will populate the service
            // output message, then exit the service.
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csys08so;
    }

    static int CallCSYS08D(CSYS08SI pInputMsg913, CSYS08SO pOutputMsg852, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i459 = 0;
        int j = 0;
        CSYS08DI pCSYS08DInputRec = null;
        CSYS08DO pCSYS08DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS08DInputRec = new CSYS08DI();
        
        pCSYS08DOutputRec = new CSYS08DO();
        pCSYS08DInputRec.setUlIdEvent(pInputMsg913.getUlIdEvent());
        pCSYS08DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg913.getArchInputStruct().getUsPageNbr());
        pCSYS08DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg913.getArchInputStruct().getUlPageSizeNbr());
        rc = csys08dQUERYdam(sqlca, pCSYS08DInputRec, pCSYS08DOutputRec);
        if ((WtcHelperConstants.SQL_SUCCESS != rc) && (NO_DATA_FOUND != rc)) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        /* Loop for each person returned */
        for (i459 = 0;i459 < pCSYS08DOutputRec.getArchOutputStruct().getUlRowQty();i459++) {
            
            if (pCSYS08DOutputRec.getROWCSYS08DO_ARRAY().getROWCSYS08DO(i459).getUlIdPerson() == pOutputMsg852.getUlIdPerson()) {
                pOutputMsg852.setTsSysTsLastUpdate3(pCSYS08DOutputRec.getROWCSYS08DO_ARRAY().getROWCSYS08DO(i459).getTsLastUpdate());
            }
            
            //  Loop to find person in list of people to set indicator.
            j = 0;
            while ((j < pOutputMsg852.getArchOutputStruct().getUlRowQty()) && (pOutputMsg852.getROWCSYS08SO_ARRAY().getROWCSYS08SO(j).getUlIdPerson() != pCSYS08DOutputRec.getROWCSYS08DO_ARRAY().getROWCSYS08DO(i459).getUlIdPerson())) {
                j++;
            }
            
            if (pOutputMsg852.getROWCSYS08SO_ARRAY().getROWCSYS08SO(j).getUlIdPerson() == pCSYS08DOutputRec.getROWCSYS08DO_ARRAY().getROWCSYS08DO(i459).getUlIdPerson()) {
                pOutputMsg852.getROWCSYS08SO_ARRAY().getROWCSYS08SO(j).setCSysIndContactOccurred(1);
                pOutputMsg852.getROWCSYS08SO_ARRAY().getROWCSYS08SO(j).setTsLastUpdate(pCSYS08DOutputRec.getROWCSYS08DO_ARRAY().getROWCSYS08DO(i459).getTsLastUpdate());
            }
        }
        return rc;
    }

    
    static int CallCSYS11D(CSYS08SI pInputMsg914, CSYS08SO pOutputMsg853, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSYS11DI pCSYS11DInputRec = null;
        CSYS11DO pCSYS11DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS11DInputRec = new CSYS11DI();
        
        pCSYS11DOutputRec = new CSYS11DO();
        pCSYS11DInputRec.setUlIdEvent(pInputMsg914.getUlIdEvent());
        pCSYS11DInputRec.setUlIdStage(pInputMsg914.getUlIdStage());
        
        /*sir# 22665 */
        rc = csys11dQUERYdam(sqlca, pCSYS11DInputRec, pCSYS11DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg853.setUlIdPerson(pCSYS11DOutputRec.getUlIdPerson());
                pOutputMsg853.setSzNmPersonFull(pCSYS11DOutputRec.getSzNmPersonFull());
                pOutputMsg853.setSzCdContactLocation(pCSYS11DOutputRec.getSzCdContactLocation());
                pOutputMsg853.setSzCdContactMethod(pCSYS11DOutputRec.getSzCdContactMethod());
                pOutputMsg853.setSzCdContactOthers(pCSYS11DOutputRec.getSzCdContactOthers());
                pOutputMsg853.setSzCdContactPurpose(pCSYS11DOutputRec.getSzCdContactPurpose());
                pOutputMsg853.setSzCdContactType(pCSYS11DOutputRec.getSzCdContactType());
                pOutputMsg853.setTsSysTsLastUpdate2(pCSYS11DOutputRec.getTsSysTsLastUpdate2());
                pOutputMsg853.setDtDTContactOccurred(pCSYS11DOutputRec.getDtDTContactOccurred());
                pOutputMsg853.setDtDtMonthlySummBegin(pCSYS11DOutputRec.getDtDtMonthlySummBegin());
                pOutputMsg853.setDtDtMonthlySummEnd(pCSYS11DOutputRec.getDtDtMonthlySummEnd());
                pOutputMsg853.getTmScrTmCntct_ARRAY().setTmScrTmCntct(CONTACT_REC_CREATED, pCSYS11DOutputRec.getTmScrTmCntct());
                pOutputMsg853.setBIndContactAttempted(pCSYS11DOutputRec.getBIndContactAttempted());
                
                
                break;
            case NO_DATA_FOUND:
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                
                
                
                break;
        }
        return rc;
        
    }

    
    static int CallCSYS13D(CSYS08SI pInputMsg915, CSYS08SO pOutputMsg854, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CSYS13DI pCSYS13DInputRec = null;
        CSYS13DO pCSYS13DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS13DInputRec = new CSYS13DI();
        
        pCSYS13DOutputRec = new CSYS13DO();
        pCSYS13DInputRec.setUlIdEvent(pInputMsg915.getUlIdEvent());
        pCSYS13DInputRec.setSzSysTxtTablename(pInputMsg915.getSzSysTxtTablename());
        pCSYS13DInputRec.getArchInputStruct().setSzUserId(pInputMsg915.getArchInputStruct().getSzUserId());
        rc = csys13dQUERYdam(sqlca, pCSYS13DInputRec, pCSYS13DOutputRec);
        
        if (0 != rc) {
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg854.setSzScrTxtNarrStatus(NULL_STRING);
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        
        else {
            pOutputMsg854.setSzScrTxtNarrStatus(NARRATIVE_TXT_DESCR);
            
            pOutputMsg854.setTsLastUpdate(pCSYS13DOutputRec.getTsLastUpdate());
        }
        return rc;
    }

    static int CallCSYS14D(CSYS08SI pInputMsg916, CSYS08SO pOutputMsg855, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code   */
        CSYS14DI pCSYS14DInputRec = null;
        CSYS14DO pCSYS14DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS14DInputRec = new CSYS14DI();
        
        pCSYS14DOutputRec = new CSYS14DO();
        pCSYS14DInputRec.setUlIdStage(pInputMsg916.getUlIdStage());
        rc = csys14dQUERYdam(sqlca, pCSYS14DInputRec, pCSYS14DOutputRec);
        
        if (0 != rc) {
            
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  End Retrieve Total Payment Information
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        else {
            pOutputMsg855.setUlIdPerson(pCSYS14DOutputRec.getUlIdPerson());
            pOutputMsg855.setSzNmPersonFull(pCSYS14DOutputRec.getSzNmPersonFull());
            
            pOutputMsg855.setBIndContactAttempted(Cint14s.INDICATOR_NO);
            
            rc = ARC_UTLGetDateAndTime(pOutputMsg855.getDtDTContactOccurred() , 0);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            pOutputMsg855.setDtDtMonthlySummEnd(pOutputMsg855.getDtDTContactOccurred());
            pOutputMsg855.getDtDtMonthlySummBegin().day = DateHelper.NULL_DATE;
            pOutputMsg855.getDtDtMonthlySummBegin().month = DateHelper.NULL_DATE;
            
            //## BEGIN TUX/XML: Declare XML variables
            pOutputMsg855.getDtDtMonthlySummBegin().year = DateHelper.NULL_DATE;
        }
        return rc;
    }

    
    static int CallCINT21D(CSYS08SI pInputMsg917, CSYS08SO pOutputMsg856, Arcxmlerrors.TUX_DECL_STATUSPARMS, FndInt3date dtTempDTStageStart) {
        int rc = 0;/* Return code */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT21DInputRec = new CINT21DI();
        
        pCINT21DOutputRec = new CINT21DO();
        pCINT21DInputRec.setUlIdStage(pInputMsg917.getUlIdStage());
        rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg856.setSzCdStage(pCINT21DOutputRec.getSzCdStage());
                pOutputMsg856.setSzCdStageProgram(pCINT21DOutputRec.getSzCdStageProgram());
                pOutputMsg856.setSzCdStageClassification(pCINT21DOutputRec.getSzCdStageClassification());
                pOutputMsg856.setDtDtStageClose(pCINT21DOutputRec.getDtDtStageClose());
                dtTempDTStageStart = pCINT21DOutputRec.getDtDtStageStart();
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_TASK_AVAIL_SAVE_INT_NOW;
                
                //  Call CSES15D
                rc = WtcHelperConstants.SQL_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCCMN45D(CSYS08SI pInputMsg918, CSYS08SO pOutputMsg857, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setUlIdEvent(pInputMsg918.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        /**************************************************************************
        ** (END): Common Function: ccmn06u  ** Check Stage/Event common function
        **************************************************************************/
        
        if (0 == rc) {
            pOutputMsg857.setROWCCMN45DO(pCCMN45DOutputRec.getROWCCMN45DO());
        }
        else {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV34D(CSYS08SI pInputMsg919, CSYS08SO pOutputMsg858, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i460 = 0;
        CINV34DI pCINV34DInputRec = null;
        CINV34DO pCINV34DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV34DInputRec = new CINV34DI();
        pCINV34DOutputRec = new CINV34DO();
        pCINV34DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg919.getArchInputStruct().getUsPageNbr());
        pCINV34DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg919.getArchInputStruct().getUlPageSizeNbr());
        pCINV34DInputRec.setUlIdStage(pInputMsg919.getUlIdStage());
        pCINV34DInputRec.setSzCdStagePersType(SVC_CD_TYPE_STAFF);
        rc = cinv34dQUERYdam(sqlca, pCINV34DInputRec, pCINV34DOutputRec);
        
        if (0 == rc) {
            pOutputMsg858.setArchOutputStruct(pCINV34DOutputRec.getArchOutputStruct());
            for (i460 = 0;i460 < pOutputMsg858.getArchOutputStruct().getUlRowQty();i460++) 
            {
                if (0 != pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i460).getUlIdPerson()) {
                    pOutputMsg858.getROWCSYS08SO_ARRAY().getROWCSYS08SO(i460).setSzNmPersonFull(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i460).getSzNmPersonFull());
                    pOutputMsg858.getROWCSYS08SO_ARRAY().getROWCSYS08SO(i460).setSzCdStagePersRole(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i460).getSzCdStagePersRole());
                    pOutputMsg858.getROWCSYS08SO_ARRAY().getROWCSYS08SO(i460).setSzCdStagePersRelInt(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i460).getSzCdStagePersRelInt());
                    pOutputMsg858.getROWCSYS08SO_ARRAY().getROWCSYS08SO(i460).setSzCdStagePersType(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i460).getSzCdStagePersType());
                    pOutputMsg858.getROWCSYS08SO_ARRAY().getROWCSYS08SO(i460).setUlIdPerson(pCINV34DOutputRec.getROWCINV34DO_ARRAY().getROWCINV34DO(i460).getUlIdPerson());
                }
                
            }
        }
        
        else if (NO_DATA_FOUND != rc) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    
    static int CallCSYS04D(CSYS08SI pInputMsg920, CSYS08SO pOutputMsg859, Arcxmlerrors.TUX_DECL_STATUSPARMS, FndInt3date dtTempDTStageStart) {
        int rc = 0;
        CSYS04DI pCSYS04DInputRec = null;
        CSYS04DO pCSYS04DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSYS04DInputRec = new CSYS04DI();
        
        pCSYS04DOutputRec = new CSYS04DO();
        pCSYS04DInputRec.setSzCdContactLocation(NULL_STRING);
        pCSYS04DInputRec.setSzCdContactMethod(NULL_STRING);
        pCSYS04DInputRec.setSzCdContactOthers(NULL_STRING);
        pCSYS04DInputRec.setSzCdContactPurpose(NULL_STRING);
        pCSYS04DInputRec.setSzCdContactType(SVC_CD_CONTACT_TYPE_ASTR);
        pCSYS04DInputRec.setUlIdStage(pInputMsg920.getUlIdStage());
        pCSYS04DInputRec.setDtScrSearchDateFrom(dtTempDTStageStart);
        pCSYS04DInputRec.getDtScrSearchDateTo().day = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getDtScrSearchDateTo().month = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getDtScrSearchDateTo().year = DateHelper.NULL_DATE;
        pCSYS04DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCSYS04DInputRec.getArchInputStruct().setUlPageSizeNbr(CSYS04DO._CSYS04DO__ROWCSYS04DO_SIZE);
        pCSYS04DInputRec.getArchInputStruct().setSzUserId(pInputMsg920.getArchInputStruct().getSzUserId());
        rc = csys04dQUERYdam(sqlca, pCSYS04DInputRec, pCSYS04DOutputRec);
        
        /*****************************************************************
        ** END CAUD99D MEDICAID UPDATE TABLE
        ******************************************************************/
        /* END SIR# 4220 */
        
        /*
        ** If RetVal is FND_SUCCESS and at least one element in ToDoFlags
        ** is TRUE perform following.
        */
        if (0 != rc) {
            
            
            //  Analyze return code
            switch (rc) {
                case NO_DATA_FOUND:
                    pOutputMsg859.setBScrIndStructNarrExists(false);
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        else if (pCSYS04DOutputRec.getArchOutputStruct().getUlRowQty() > 0) {
            pOutputMsg859.setBScrIndStructNarrExists(true);
        }
        return rc;
    }

    
    static int CallCCMN87D(CSYS08SI pInputMsg921, CSYS08SO pOutputMsg860, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setUlIdStage(pInputMsg921.getUlIdStage());
        if (!(pOutputMsg860.getSzCdStage().compareTo(INVEST) != 0)) {
            pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SVC_CD_EVENT_TYPE_CONCL);
        }
        else {
            pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(SVC_CD_EVENT_TYPE_CLOSE);
        }
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(INITIAL_PAGE);
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Start Performance Timer
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , SVC_CD_EVENT_STATUS_PENDING, SVC_CD_EVENT_STATUS_PENDING.length()) != 0)) {
                    pOutputMsg860.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                }
                else {
                    
                    pOutputMsg860.setUlIdEvent(0);
                }
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg860.setUlIdEvent(0);
                
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINV17D(CSYS08SI pInputMsg922, CSYS08SO pOutputMsg861, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINV17DI pCINV17DInputRec = null;
        CINV17DO pCINV17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV17DInputRec = new CINV17DI();
        
        pCINV17DOutputRec = new CINV17DO();
        pCINV17DInputRec.setUlIdStage(pInputMsg922.getUlIdStage());
        
        /********************************************************************
        ** SIR 5079:
        ** Get the DT_INCOMING_CALL for the Intake Begun Date by using DAM 
        ** CCMNB5D to retrieve the ID STAGE of the Prior Stage from the 
        ** Investigation Stage.  Then use the retrieved Intake Stage ID as 
        ** the Input to DAM CSEC54D, which retrieves the DT_INCOMING_CALL
        ** from the INCOMING_DETAIL table.
        ********************************************************************/
        rc = cinv17dQUERYdam(sqlca, pCINV17DInputRec, pCINV17DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg861.setCIndFacilSuperintNotif(pCINV17DOutputRec.getCIndFacilSuperintNotif());
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
                
        }
        return rc;
    }

    
    static int CallCINVB8D(CSYS08SI pInputMsg923, CSYS08SO pOutputMsg862, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CINVB8DI pCINVB8DInputRec = null;
        CINVB8DO pCINVB8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVB8DInputRec = new CINVB8DI();
        
        pCINVB8DOutputRec = new CINVB8DO();
        
        pCINVB8DInputRec.setUlIdStage(pInputMsg923.getUlIdStage());
        
        rc = cinvb8dQUERYdam(sqlca, pCINVB8DInputRec, pCINVB8DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pCINVB8DOutputRec.getDtDTContactOccurred().year != DateHelper.NULL_DATE) {
                    pOutputMsg862.setUlNbrReviewContact(REVIEW_CONTACT);
                }
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        
        
        return rc;
    }

    static int CallCINVC8D(CSYS08SI pInputMsg924, CSYS08SO pOutputMsg863, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINVC8DI pCINVC8DInputRec = null;
        CINVC8DO pCINVC8DOutputRec = null;
        
        
        
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINVC8DInputRec = new CINVC8DI();
        pCINVC8DOutputRec = new CINVC8DO();
        pCINVC8DInputRec.setArchInputStruct(pInputMsg924.getArchInputStruct());
        pCINVC8DInputRec.setUlIdStage(pInputMsg924.getUlIdStage());
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = cinvc8dQUERYdam(sqlca, pCINVC8DInputRec, pCINVC8DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                if (pCINVC8DOutputRec.getDtDtStageStart().year != DateHelper.NULL_DATE) {
                    pOutputMsg863.setDtDtIntStart(pCINVC8DOutputRec.getDtDtStageStart());
                }
                
                break;
            case NO_DATA_FOUND:
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
