package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV36SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV36SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV81DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV95DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND2DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV55DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV64DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV64DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS13DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS13DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES87DO;
/**************************************************************************
** 
** Module File:   CINV36S.src
**
** Service Name:  CINV36S
**
** Description:   A retrieval service to fill the Principal list box
**                on the Risk Assessment window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  3/13/95 
** 
** Programmer:    Terry T. Cavallaro
**
** Updates:       Name              Date    Explanation
**                ----------------- ------- -------------------------------
**
** 01/11/96   BRUCKMK	SIR 2428: Now that risk assessment is being called 
**						by subcare stages which do not have an overall 
**						disposition, we only want to call this DAM (CINV95D) 
**						for Investigation Stages.                                  
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cinv36s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    /* Event Variables */
    public static final String EVENT_STATUS_NEW = "NEW";
    public static final String EVENT_STATUS_PENDING = "PEND";
    public static final String EVENT_STATUS_APPROVED = "APPR";
    public static final String CONCL_EVENT_TYPE = "CCL";
    
    /* Narrative Related variables */
    public static final String RISK_ASSMT_NARR = "RISK_ASSMT_NARR";
    public static final String TXT_NARR_EXISTS = "NARRATIVE";
    public static final String PRINCIPAL = "PRN";
    
    /* Miscellaneous variables */
    public static final int NO_ERRORS = 0;
    public static final int MAX_RETRIEVE = 10;
    public static final int MAX_PAGE_SIZE = 30;
    public static final int FIRST_PAGE = 1;
    
    public static final String NULL_STRING = "";
    
    /*
    ** SIR 21919: Added the following #defines:
    */
    public static final String ALLEGED_PERPETRATOR = "AP";
    public static final String FOSTER_ADOPTIVE_HOME = "FAH";
    public static final String ACTIVE = "A";
    public static final char NO_AP_FAH_FOUND = 'N';
    public static final char AP_FAH_FOUND = 'Y';
    public static final String INVESTIGATION = "INV";
    CINV36SO CINV36S(CINV36SI cinv36si) {
        CINV36SO cinv36so = new CINV36SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i350 = 0;
        rc = ARC_PRFServiceStartTime_TUX(cinv36si.getArchInputStruct());
        
        /* Get system date and copy into output message */
        ARC_UTLGetDateAndTime(cinv36so.getDtWCDDtSystemDate() , 0);
        /*
        ** IMPACT BEGIN
        */
        /*
        ** IMPACT END
        */
        
        rc = CallCINV80D(cinv36si, cinv36so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        
        rc = CallCSES87D(cinv36si, cinv36so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        cinv36si.getArchInputStruct().setUsPageNbr(FIRST_PAGE);
        
        /************************************************************************
        **   End SIR 1316: Create ToDo and Contact Shell for first Face to Face
        **   Contact that is created for a stage.
        ************************************************************************/
        /*
        ** End SIR#10609
        */
        
        
        /*
        ** Return events for save and submit.
        */
        /*
        ** SIR 2041: Conditions added to include release 2 contacts
        */
        /*
        ** SIR 2138: Conditions have been added to this statement for
        ** F/A Home contacts.
        */
        if (cinv36so.getLSysNbrRow_ARRAY().getLSysNbrRow(0) > 0) {
            rc = CallCINV81D(cinv36si, cinv36so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** SIR 13618 - Call 3 dams for MHMR Enhancement - Request for Review
        */
        /*
        ** SIR 18978 - Use INDICATOR_NO instead of FALSE
        */
        
        if (cinv36si.getUlIdEvent() != 0) {
            rc = Ccmn01u.CallCCMN45D(cinv36si, cinv36so, pServiceStatus);
            //   PROCESS_TUX_SQL_ERROR_NOFREE is called only when there is an unexpected
            // SQL error returned from the DAM.
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        cinv36si.getArchInputStruct().setUlPageSizeNbr(MAX_PAGE_SIZE);
        
        if (cinv36si.getUlIdEvent() != 0 && cinv36so.getROWCCMN01UIG00().getSzCdEventStatus().substring(0, 3).compareTo(EVENT_STATUS_NEW.substring(0, 3)) != 0) {
            rc = Ccmn02u.CallCCMND2D(cinv36si, cinv36so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Populate Input Structure for DAM
        */
        
        rc = CallCINV64D(cinv36si, cinv36so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (cinv36si.getUlIdEvent() != 0) {
            
            //  Call DAM: perfroms a full row retrieval from SERVICE_AUTHORIZATION &
            // SVC_AUTH_DETAILbased on idPerson
            
            rc = Cinv27s.CallCSYS13D(cinv36si, cinv36so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        
        
        
        
        /*
        ** SIR 14235 - Added a new dam to get the earliest
        ** date on which a 24 hr contact occurred in an
        ** APS INV stage. Then reset the APS INV BEGUN DT
        ** and the APS INT CLOSE DTto the earliest
        ** 24H contact dt if the investigation dt is
        ** is later than the 24H Contact date .
        */
        if (0 == cinv36si.getSzCdStage().compareTo(INVESTIGATION)) {
            
            rc = Ccmn02u.CallCINV95D(cinv36si, cinv36so, pServiceStatus);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                    // SIR# 22914: added the SQL_NOT_FOUND case.
                case Messages.MSG_INV_NO_OVERALL_DISP:
                    break;// break for CLSS67D
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        
        
        ARC_PRFServiceStopTime_TUX(cinv36si.getArchInputStruct() , cinv36so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            
            //  SIR 14789 - Send an Alert to A PAL Worker when Sub Stage is being
            // Closed.
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
        return cinv36so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = "CINV36SO";
        pOutputMsgTransMap.map_version = "01";
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCINV80D(CINV36SI pInputMsg710, CINV36SO pOutputMsg660, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i351 = 0;
        int start = 0;
        int end = 0;
        
        CINV80DI pCINV80DInputRec = null;
        CINV80DO pCINV80DOutputRec = null;
        
        
        
        /* Allocate memory for Input and Output Structures */
        
        
        pCINV80DInputRec = new CINV80DI();
        
        
        pCINV80DOutputRec = new CINV80DO();
        /*  SIR 14160 */
        pCINV80DInputRec.setArchInputStruct(pInputMsg710.getArchInputStruct());
        pCINV80DInputRec.setUlIdStage(pInputMsg710.getUlIdStage());
        pCINV80DInputRec.setSzCdStagePersType(PRINCIPAL);
        rc = cinv80dQUERYdam(sqlca, pCINV80DInputRec, pCINV80DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                // Populate Output Message
                
                // Service Output message = DAM Output message
                for (i351 = 0;i351 < pCINV80DOutputRec.getArchOutputStruct().getUlRowQty();i351++) {
                    
                    pOutputMsg660.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i351).setUlIdPerson(pCINV80DOutputRec.getROWCINV80DO_ARRAY().getROWCINV80DO(i351).getUlIdPerson());
                }
                pOutputMsg660.getLSysNbrRow_ARRAY().setLSysNbrRow(0, (int) pCINV80DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg660.getArchOutputStruct().setBMoreDataInd(pCINV80DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                
                break;
            case NO_DATA_FOUND:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pOutputMsg660.getLSysNbrRow_ARRAY().setLSysNbrRow(0, 0);
                
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV81D(CINV36SI pInputMsg711, CINV36SO pOutputMsg661, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i352 = 0;
        
        CINV81DI pCINV81DInputRec = null;
        CINV81DO pCINV81DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        
        pCINV81DInputRec = new CINV81DI();
        
        
        pCINV81DOutputRec = new CINV81DO();
        pCINV81DInputRec.setArchInputStruct(pInputMsg711.getArchInputStruct());
        
        
        for (i352 = 0;i352 < (int) pOutputMsg661.getLSysNbrRow_ARRAY().getLSysNbrRow(0);i352++) {
            pCINV81DInputRec.setUlIdPerson(pOutputMsg661.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352).getUlIdPerson());
            
            
            //  Set rc to ARC_SUCCESS
            rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pOutputMsg661.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352).setSzNmPersonFull(pCINV81DOutputRec.getSzNmPersonFull());
                    pOutputMsg661.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i352).setDtDtPersonBirth(pCINV81DOutputRec.getDtDtPersonBirth());
                    
                    // 
                    // (END): Update Region and County on Caps Case
                    // 
                    
                    
                    break;
                case NO_DATA_FOUND:
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCINV95D(CINV36SI pInputMsg712, CINV36SO pOutputMsg662, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CINV95DI pCINV95DInputRec = null;
        CINV95DO pCINV95DOutputRec = null;
        
        /* Allocate memory for Input and Output Structures */
        pCINV95DInputRec = new CINV95DI();
        
        
        pCINV95DOutputRec = new CINV95DO();
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCINV95DInputRec.setArchInputStruct(pInputMsg712.getArchInputStruct());
        pCINV95DInputRec.setUlIdStage(pInputMsg712.getUlIdStage());
        rc = cinv95dQUERYdam(sqlca, pCINV95DInputRec, pCINV95DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg662.setCdCpsOverallDisptn(pCINV95DOutputRec.getCdCpsOverallDisptn());
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                
                
                break;
            case NO_DATA_FOUND:
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                pOutputMsg662.setCdCpsOverallDisptn(NULL_STRING);
                
                
                //  Set explan_data to usRow
                // Note: Use sprintf
                //##                  sprintf(pReturnPB->appl_status.explan_data,
                //##                          "%u",
                //##                          usRow);
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMND2D(CINV36SI pInputMsg713, CINV36SO pOutputMsg663, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        int i353 = 0;
        CCMND2DI pCCMND2DInputRec = null;
        CCMND2DO pCCMND2DOutputRec = null;
        CINV55DI pCINV55DInputRec = null;
        CINV55DO pCINV55DOutputRec = null;
        
        
        
        /* Allocate memory for Input and Output Structures */
        
        pCCMND2DInputRec = new CCMND2DI();
        
        
        pCCMND2DOutputRec = new CCMND2DO();
        
        pCINV55DInputRec = new CINV55DI();
        
        
        pCINV55DOutputRec = new CINV55DO();
        pCCMND2DInputRec.setArchInputStruct(pInputMsg713.getArchInputStruct());
        pCCMND2DInputRec.setUlIdEvent(pInputMsg713.getUlIdEvent());
        rc = ccmnd2dQUERYdam(sqlca, pCCMND2DInputRec, pCCMND2DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                // ID PERSON's were found so
                // Populate Output Message
                for (i353 = 0;i353 < pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty();++i353) {
                    pOutputMsg663.getROWCINV36SOG02_ARRAY().getROWCINV36SOG02(i353).setUlIdPerson(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i353).getUlIdPerson());
                    pOutputMsg663.getROWCINV36SOG02_ARRAY().getROWCINV36SOG02(i353).setSzNmPersonFull(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i353).getSzNmPersonFull());
                    pOutputMsg663.getROWCINV36SOG02_ARRAY().getROWCINV36SOG02(i353).setTsLastUpdate(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i353).getTsLastUpdate());
                    
                    // 
                    // Call DAMs to retrieve data
                    // 
                    
                    //  Either ID UNIT or CD UNIT PROGRAM, CD UNIT REGION, NBR UNIT
                    // was passed in, get the approver's ID PERSON using the appropriate
                    // DAM
                    if (!(pOutputMsg663.getROWCCMN01UIG00().getSzCdEventStatus().compareTo(EVENT_STATUS_APPROVED) != 0)) {
                        pCINV55DInputRec.setUlIdPerson(pOutputMsg663.getROWCINV36SOG02_ARRAY().getROWCINV36SOG02(i353).getUlIdPerson());
                        pCINV55DInputRec.setTsLastUpdate(pCCMND2DOutputRec.getROWCCMND2DO_ARRAY().getROWCCMND2DO(i353).getTsLastUpdate());
                        rc = cinv55dQUERYdam(sqlca, pCINV55DInputRec, pCINV55DOutputRec);
                        
                        //  Analyze return code for CINV51D(VP)
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pOutputMsg663.getROWCINV36SOG02_ARRAY().getROWCINV36SOG02(i353).setSzNmPersonFull(pCINV55DOutputRec.getSzNmPersonFull());
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        }
                    }
                }
                pOutputMsg663.getLSysNbrRow_ARRAY().setLSysNbrRow(1, pCCMND2DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN45D(CINV36SI pInputMsg714, CINV36SO pOutputMsg664, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i354 = 0;
        int rc = 0;
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setUlIdEvent(pInputMsg714.getUlIdEvent());
        pCCMN45DInputRec.setArchInputStruct(pInputMsg714.getArchInputStruct());
        
        
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg664.getROWCCMN01UIG00().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                pOutputMsg664.getROWCCMN01UIG00().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                pOutputMsg664.getROWCCMN01UIG00().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                pOutputMsg664.getROWCCMN01UIG00().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                pOutputMsg664.getROWCCMN01UIG00().getDtDtEventOccurred().day = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().day;
                pOutputMsg664.getROWCCMN01UIG00().getDtDtEventOccurred().month = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().month;
                pOutputMsg664.getROWCCMN01UIG00().getDtDtEventOccurred().year = pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred().year;
                pOutputMsg664// 2090
                .getROWCCMN01UIG00().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                pOutputMsg664.getROWCCMN01UIG00().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                pOutputMsg664.getROWCCMN01UIG00().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                pOutputMsg664.getROWCCMN01UIG00().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                break;
                
                //04/09/03 Srini: Adding the case of SQL_NOT_FOUND to return MSG_NO_ROWS_RETURNED
            case NO_DATA_FOUND:
                Arcxmlerrors// 2030
                .PROCESS_TUX_SQL_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCINV64D(CINV36SI pInputMsg715, CINV36SO pOutputMsg665, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i355 = 0;
        CINV64DI pCINV64DInputRec = null;
        CINV64DO pCINV64DOutputRec = null;
        
        
        /* Allocate memory for Input and Output Structures */
        
        pCINV64DInputRec = new CINV64DI();
        
        pCINV64DOutputRec = new CINV64DO();
        
        pCINV64DInputRec.setArchInputStruct(pInputMsg715.getArchInputStruct());
        /***********************************************************
        ** END CAUD20D
        ************************************************************/
        
        /*
        ** Increment counter outside of current loop because
        ** we are keeping track of ALL contracts
        */
        pCINV64DInputRec.setUlIdEvent(pInputMsg715.getUlIdEvent());
        
        /*
        ** Get the current date and store it in dtCurrentDate
        */
        rc = cinv64dQUERYdam(sqlca, pCINV64DInputRec, pCINV64DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg665.getCINV36SOG04().setCdRiskAssmtPurpose(pCINV64DOutputRec.getCdRiskAssmtPurpose());
                pOutputMsg665.getCINV36SOG04().setSzCdRiskAssmtRiskFind(pCINV64DOutputRec.getSzCdRiskAssmtRiskFind());
                pOutputMsg665.getCINV36SOG04().setSzCdRiskAssmtApAccess(pCINV64DOutputRec.getSzCdRiskAssmtApAccess());
                pOutputMsg665.getCINV36SOG04().setTsLastUpdate(pCINV64DOutputRec.getTsLastUpdate());
                break;
                
            case NO_DATA_FOUND:
                pCINV64DOutputRec.getArchOutputStruct().setUlRowQty(0);
                
                //  Compare today's date with Period Start date
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSYS13D(CINV36SI pInputMsg716, CINV36SO pOutputMsg666, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables
        
        int rc = 0;
        CSYS13DI pCSYS13DInputRec = null;
        CSYS13DO pCSYS13DOutputRec = null;
        
        
        /* Allocate memory for Input and Output Structures */
        
        
        pCSYS13DInputRec = new CSYS13DI();
        
        pCSYS13DOutputRec = new CSYS13DO();
        pCSYS13DInputRec.setArchInputStruct(pInputMsg716.getArchInputStruct());
        pCSYS13DInputRec.setUlIdEvent(pInputMsg716.getUlIdEvent());
        pCSYS13DInputRec.setSzSysTxtTablename(RISK_ASSMT_NARR);
        
        rc = csys13dQUERYdam(sqlca, pCSYS13DInputRec, pCSYS13DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg666.getCINV36SOG05().setSzScrTxtNarrStatus(TXT_NARR_EXISTS);
                
                
                break;
            case NO_DATA_FOUND:
                pOutputMsg666.getCINV36SOG05().setSzScrTxtNarrStatus("");
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSES87D(CINV36SI pInputMsg717, CINV36SO pOutputMsg667, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i356 = 0;
        int rc = 0;/* Return code */
        CSES87DI pCSES87DInputRec = null;
        CSES87DO pCSES87DOutputRec = null;
        
        
        /* Allocate memory for Input and Output Structures */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES87DInputRec = new CSES87DI();
        
        pCSES87DOutputRec = new CSES87DO();
        pCSES87DInputRec.setArchInputStruct(pInputMsg717.getArchInputStruct());
        pCSES87DInputRec.setUlIdStage(pInputMsg717.getUlIdStage());
        pCSES87DInputRec.setSzCdCategoryCategory(FOSTER_ADOPTIVE_HOME);
        pCSES87DInputRec.setCdPersonStatus(ACTIVE);
        
        
        for (i356 = 0;i356 < pOutputMsg667.getLSysNbrRow_ARRAY().getLSysNbrRow(0);i356++) {
            pCSES87DInputRec.setUlIdPerson(pOutputMsg667.getROWCINV36SOG01_ARRAY().getROWCINV36SOG01(i356).getUlIdPerson());
            rc = cses87dQUERYdam(sqlca, pCSES87DInputRec, pCSES87DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    //  Set Event Status to "Complete" if required window fields
                    // filled
                    if (pCSES87DOutputRec.getUlSysNbrUlongKey() == 0) {
                        pOutputMsg667.setBSysIndNoDataFound(NO_AP_FAH_FOUND);
                    }
                    else {
                        pOutputMsg667.setBSysIndNoDataFound(AP_FAH_FOUND);
                        i356 = pOutputMsg667.getLSysNbrRow_ARRAY().getLSysNbrRow(0);
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        return rc;
    }

}
