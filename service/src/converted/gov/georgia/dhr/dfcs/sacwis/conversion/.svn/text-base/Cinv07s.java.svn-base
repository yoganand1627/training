package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV07SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV07SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV70DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV70DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV69DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV69DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV08DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV08DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC54DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC54DO;
/**************************************************************************
** 
** Module File:   CINV07S.src
**
** Service Name:  CINV07S
**
** Description:   Retrieves Facility Allegation Detail Information
**                Uses DAMS CINV70D, CINV69D and CINV08D
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  27 MAR 95 
** 
** Programmer:    WHW
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   23 Feb 1998 09:13:20  $
**                      $Modtime:   23 Feb 1998 08:46:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/03/95    KRD     SIR 1470 - Ensure that the current system date is
**                      retrieved and passed back to the window.  
**  10/06/95    KRD     SIR 1610 - Modified CallCINV69D() to return
**                      szNmPersonFull to the window rather than
**                      szNmNameFirst, szNmNameMiddle, and szNmNameLast.
** 03/06/96  BRUCKMK SIR 5079:
**       Get the DT_INCOMING_CALL for the Intake Begun Date by 
**      using DAM CCMNB5D to retrieve the ID STAGE of the 
**      Prior Stage from the Investigation Stage.  Then use 
**      the retrieved Intake Stage ID as the Input to DAM 
**      CSEC54D, which retrieves the DT_INCOMING_CALL
**       from the INCOMING_DETAIL table.
**
**  04/30/03   Srini		SIR 17091: Added the error handling to take care of full 
**							table scans for ccmn87dQUERYdam.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv07s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String CONCL_EVENT_TYPE = "CCL";
    CINV07SO CINV07S(CINV07SI cinv07si) {
        CINV07SO cinv07so = new CINV07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        Pint ulIdStage2 = new Pint();
        ulIdStage2.value = 0;
        /****************************************************************
        ** SIR 1972:
        ** Get the DT_INCOMING_CALL for the Intake Begun Date by using
        ** DAM CLSC69D for a full row retrieval from the INCOMING_DETAIL
        ** table.
        ****************************************************************/
        rc = ARC_PRFServiceStartTime_TUX(cinv07si.getArchInputStruct());
        if (cinv07si.getUlIdAllegation() != 0) {
            //  END SIR 1972 
            
            
            
            //  Sir#15712 - Retrieve principal information
            rc = Cinv08s.CallCINV70D(cinv07si, cinv07so, pServiceStatus);
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    
                    
                    break;
                case Messages.MSG_NO_ROWS_RETURNED:
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //  End SIR 15712
            
            //  Sir#15956 - Retrieve information for principals
            // with unknown Gender or approximate DOB
            rc = CallCINV08D(cinv07si, cinv07so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        /*
        ** End SIR 15956
        */
        
        
        /*
        ** Sir#23536 - Sanjay
        */
        rc = Cinv46s.CallCINV69D(cinv07si, cinv07so, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                
                
                
                break;
                //  Begin effective date  vs. closure date processing
            case Messages.MSG_NO_ROWS_RETURNED:
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        rc = ARC_UTLGetDateAndTime(cinv07so.getCINV07SOG00().getDtDtTodaysDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Ccmn02u.CallCCMN87D(cinv07si, cinv07so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Start Performance Timer
        */
        rc = CallCCMNB5D(cinv07si, cinv07so, ulIdStage2, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        rc = Ccfc40s.CallCSEC54D(cinv07si, cinv07so, ulIdStage2, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cinv07si.getArchInputStruct() , cinv07so.getArchOutputStruct());
        
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
        
        return cinv07so;
    }

    static int CallCINV70D(CINV07SI pInputMsg545, CINV07SO pOutputMsg503, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CINV70DI pCINV70DInputRec = null;
        CINV70DO pCINV70DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV70DInputRec = new CINV70DI();
        
        pCINV70DOutputRec = new CINV70DO();
        
        pCINV70DInputRec.setArchInputStruct(pInputMsg545.getArchInputStruct());
        
        pCINV70DInputRec.setUlIdAllegation(pInputMsg545.getUlIdAllegation());
        
        /*
        ** SIR 2427: Added DAM CINT21D to retrieve szCdStage, since I&R and 
        ** SPC intakes do not have a stage name, 
        ** which kills ccmn19d.
        */
        
        rc = cinv70dQUERYdam(sqlca, pCINV70DInputRec, pCINV70DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                pOutputMsg503.getCINV07SOG00().setDtDtFacilAllegIncident(pCINV70DOutputRec.getDtDtFacilAllegIncident());
                pOutputMsg503.getCINV07SOG00().setTmTmIncmgCall(pCINV70DOutputRec.getTmTmIncmgCall());
                pOutputMsg503.getCINV07SOG00().setSzCdFacilAllegNeglType(pCINV70DOutputRec.getSzCdFacilAllegNeglType());
                pOutputMsg503.getCINV07SOG00().setUlIdAllegedPerpetrator(pCINV70DOutputRec.getUlIdAllegedPerpetrator());
                pOutputMsg503.getCINV07SOG00().setUlIdVictim(pCINV70DOutputRec.getUlIdVictim());
                pOutputMsg503.getCINV07SOG00().setSzCdAllegType(pCINV70DOutputRec.getSzCdAllegType());
                pOutputMsg503.getCINV07SOG00().setSzCdAllegIncidentStage(pCINV70DOutputRec.getSzCdAllegIncidentStage());
                pOutputMsg503.getCINV07SOG00().setSzCdFacilAllegDispSupr(pCINV70DOutputRec.getSzCdFacilAllegDispSupr());
                pOutputMsg503.getCINV07SOG00().setCdAllegDisposition(pCINV70DOutputRec.getCdAllegDisposition());
                
                pOutputMsg503.getCINV07SOG00().setSzCdFacilAllegEventLoc(pCINV70DOutputRec.getSzCdFacilAllegEventLoc());
                pOutputMsg503.getCINV07SOG00().setSzCdFacilAllegInjSer(pCINV70DOutputRec.getSzCdFacilAllegInjSer());
                pOutputMsg503.getCINV07SOG00().setSzNbrFacilAllegMHMR(pCINV70DOutputRec.getSzNbrFacilAllegMHMR());
                
                pOutputMsg503.getCINV07SOG00().setBIndFacilAllegAbOffGr(pCINV70DOutputRec.getBIndFacilAllegAbOffGr());
                pOutputMsg503.getCINV07SOG00().setBIndFacilAllegSupvd(pCINV70DOutputRec.getBIndFacilAllegSupvd());
                pOutputMsg503.getCINV07SOG00().setSzCdFacilAllegSrc(pCINV70DOutputRec.getSzCdFacilAllegSrc());
                pOutputMsg503.getCINV07SOG00().setSzCdFacilAllegSrcSupr(pCINV70DOutputRec.getSzCdFacilAllegSrcSupr());
                
                pOutputMsg503.getCINV07SOG00().setDtDtFacilAllegInvstgtr(pCINV70DOutputRec.getDtDtFacilAllegInvstgtr());
                pOutputMsg503.getCINV07SOG00().setDtDtFacilAllegSuprReply(pCINV70DOutputRec.getDtDtFacilAllegSuprReply());
                pOutputMsg503.getCINV07SOG00().setSzFacilAllegInvClass(pCINV70DOutputRec.getSzFacilAllegInvClass());
                
                pOutputMsg503.getCINV07SOG00().setSzCdFacilAllegClssSupr(pCINV70DOutputRec.getSzCdFacilAllegClssSupr());
                pOutputMsg503.getCINV07SOG00().setSzTxtFacilAllegCmnts(pCINV70DOutputRec.getSzTxtFacilAllegCmnts());
                pOutputMsg503.getCINV07SOG00().setTsLastUpdate(pCINV70DOutputRec.getTsLastUpdate());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return WtcHelperConstants.ARC_SUCCESS;
    }

    static int CallCINV69D(CINV07SI pInputMsg546, CINV07SO pOutputMsg504, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i299 = 0;
        
        /*
        ** Declare local variables
        */
        CINV69DI pCINV69DInputRec = null;
        CINV69DO pCINV69DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV69DInputRec = new CINV69DI();
        
        pCINV69DOutputRec = new CINV69DO();
        pCINV69DInputRec.setUlIdStage(pInputMsg546.getUlIdStage());
        pCINV69DInputRec.setArchInputStruct(pInputMsg546.getArchInputStruct());
        
        
        /*
        ** Call CLSS37D.  The Contract County Retrieve receives IdContract,
        ** NbrCnsvcPeriod, NbrCnsvcVersion, NbrCnsvcLineItem and will
        ** return n full rows.
        */
        rc = cinv69dQUERYdam(sqlca, pCINV69DInputRec, pCINV69DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i299 = 0;i299 < pCINV69DOutputRec.getArchOutputStruct().getUlRowQty();++i299) {
                    pOutputMsg504.getCINV07SOG02_ARRAY().getCINV07SOG02(i299).setUlIdPerson(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i299).getUlIdPerson());
                    pOutputMsg504.getCINV07SOG02_ARRAY().getCINV07SOG02(i299).setSzNmPersonFull(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i299).getSzNmPersonFull());
                    pOutputMsg504.getCINV07SOG02_ARRAY().getCINV07SOG02(i299).setSzCdPersonMaritalStatus(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i299).getSzCdPersonMaritalStatus());
                    pOutputMsg504.getCINV07SOG02_ARRAY().getCINV07SOG02(i299).setDtDtPersonBirth(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i299).getDtDtPersonBirth());
                    pOutputMsg504.getCINV07SOG02_ARRAY().getCINV07SOG02(i299).setSzCdStagePersRole(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i299).getSzCdStagePersRole());
                    pOutputMsg504.getCINV07SOG02_ARRAY().getCINV07SOG02(i299).setTsLastUpdate(pCINV69DOutputRec.getROWCINV69DO_ARRAY().getROWCINV69DO(i299).getTsLastUpdate());
                };
                pOutputMsg504.getArchOutputStruct().setUlRowQty(pCINV69DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg504.getArchOutputStruct().setBMoreDataInd(pCINV69DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV08D(CINV07SI pInputMsg547, CINV07SO pOutputMsg505, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i300 = 0;
        
        /*
        ** Declare local variables
        */
        CINV08DI pCINV08DInputRec = null;
        CINV08DO pCINV08DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINV08DInputRec = new CINV08DI();
        
        pCINV08DOutputRec = new CINV08DO();
        
        if (pCINV08DInputRec == null) {
            
            //  Run-time versioning
            
            //  Check buffer size
            
            //  Process error message and return to client
            
            //  Initialize output message and length
            
            //  Initialize service status fields
            
            //  Retrieve stage closed date
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        pCINV08DInputRec.setArchInputStruct(pInputMsg547.getArchInputStruct());
        
        pCINV08DInputRec.setUlIdAllegation(pInputMsg547.getUlIdAllegation());
        
        
        /*
        ** Search for structured narrative if it exists
        */
        rc = cinv08dQUERYdam(sqlca, pCINV08DInputRec, pCINV08DOutputRec);
        
        
        /*
        ** Stop DAM Performance Timer
        */
        //##                ARC_PRFDataAccessStopTime();
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i300 = 0;i300 < pCINV08DOutputRec.getArchOutputStruct().getUlRowQty();++i300) {
                    
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setSzCdFacilInjuryBody(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getSzCdFacilInjuryBody());
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setSzCdFacilInjuryCause(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getSzCdFacilInjuryCause());
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setDtFacilInjuryDtrmntn(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getDtFacilInjuryDtrmntn());
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setSzCdFacilInjurySide(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getSzCdFacilInjurySide());
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setSzCdFacilInjuryType(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getSzCdFacilInjuryType());
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setSzTxtFacilInjuryCmnts(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getSzTxtFacilInjuryCmnts());
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setUlIdFacilityInjury(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getUlIdFacilityInjury());
                    pOutputMsg505.getCINV07SOG01_ARRAY().getCINV07SOG01(i300).setTsLastUpdate(pCINV08DOutputRec.getROWCINV08DO_ARRAY().getROWCINV08DO(i300).getTsLastUpdate());
                }
                pOutputMsg505.getArchOutputStruct().setUlRowQty(pCINV08DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg505.getArchOutputStruct().setBMoreDataInd(pCINV08DOutputRec.getArchOutputStruct().getBMoreDataInd());
                break;
            case NO_DATA_FOUND:
                
                
                //  Populate Principal/Collaterals Contacted
                // Not Found is now ignored. re: Mr. Dunnagqan 07/11/95.
                // 
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
        
    }

    static int CallCCMN87D(CINV07SI pInputMsg548, CINV07SO pOutputMsg506, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN87DInputRec = new CCMN87DI();
        pCCMN87DOutputRec = new CCMN87DO();
        pCCMN87DInputRec.setUlIdStage(pInputMsg548.getUlIdStage());
        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(CONCL_EVENT_TYPE);
        pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
        
        pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Call DAM
        */
        rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
        
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg506.getCINV07SOG00().setSzCdEventStatus(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus());
                
                break;
            case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                
                
                // 
                // End Call to Stage Retrieval Dam - CSES24D
                // 
                
                
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNB5D(CINV07SI pInputMsg549, CINV07SO * pOutputMsg507, Pint ulIdStage3, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMNB5DI pCCMNB5DInputRec = null;
        CCMNB5DO pCCMNB5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNB5DInputRec = new CCMNB5DI();
        
        pCCMNB5DOutputRec = new CCMNB5DO();
        pCCMNB5DInputRec.setUlIdStage(pInputMsg549.getUlIdStage());
        rc = Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Call CSES01D.  The Contract Period Rtrv DAM receives IdContract 
        ** and NbrCnperPeriod for the current period and returns all columns
        ** for the latest contract version record in the Contract Version table.
        */
        rc = ccmnb5dQUERYdam(sqlca, pCCMNB5DInputRec, pCCMNB5DOutputRec);
        
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        else {
            ulIdStage3.value = pCCMNB5DOutputRec.getUlIdPriorStage();
        }
        return rc;
    }

    static int CallCSEC54D(CINV07SI pInputMsg550, CINV07SO pOutputMsg508, Pint ulIdStage4, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
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
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        
        pCSEC54DInputRec.setUlIdStage(ulIdStage4.value);
        pCSEC54DInputRec.setArchInputStruct(pInputMsg550.getArchInputStruct());
        
        /*
        ** Call DAM
        */
        rc = csec54dQUERYdam(sqlca, pCSEC54DInputRec, pCSEC54DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                pOutputMsg508.setDtDtIncomingCall(pCSEC54DOutputRec.getDtDtIncomingCall());
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

}
